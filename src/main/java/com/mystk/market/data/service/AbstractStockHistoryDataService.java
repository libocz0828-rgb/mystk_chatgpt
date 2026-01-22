package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.AbstractStockHistoryDto;
import com.mystk.market.data.domain.AllDataArchiveSummary;
import com.mystk.market.data.domain.SummaryInfo;
import com.mystk.market.data.exception.TsDataException;
import com.mystk.market.data.repository.AllDataArchiveSummaryRepository;
import com.mystk.market.data.repository.StockHistoryFileRepository;
import com.mystk.market.data.repository.StockSummaryRepository;
import com.mystk.market.data.util.TsDateUtils;
import com.mystk.market.data.util.TsStockCodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Abstract service for stock history data processing.
 *
 * <p>Provides unified operations for pick, read, save and archive across data types.</p>
 *
 * @param <T> dto type
 */
public abstract class AbstractStockHistoryDataService<T extends AbstractStockHistoryDto> {

    private static final Logger log = LoggerFactory.getLogger(AbstractStockHistoryDataService.class);

    private final TuShareDataPicker<T> picker;
    private final StockHistoryFileRepository<T> repository;
    private final StockSummaryRepository summaryRepository;
    private final AllDataArchiveSummaryRepository archiveSummaryRepository;
    private final TradeCalendarService tradeCalendarService;
    private final StockBasicInfoProvider stockBasicInfoProvider;

    protected AbstractStockHistoryDataService(TuShareDataPicker<T> picker,
                                              StockHistoryFileRepository<T> repository,
                                              StockSummaryRepository summaryRepository,
                                              AllDataArchiveSummaryRepository archiveSummaryRepository,
                                              TradeCalendarService tradeCalendarService,
                                              StockBasicInfoProvider stockBasicInfoProvider) {
        this.picker = picker;
        this.repository = repository;
        this.summaryRepository = summaryRepository;
        this.archiveSummaryRepository = archiveSummaryRepository;
        this.tradeCalendarService = tradeCalendarService;
        this.stockBasicInfoProvider = stockBasicInfoProvider;
    }

    /**
     * Returns data type name.
     *
     * @return data type
     */
    public abstract String getDataType();

    /**
     * Returns json type reference for list deserialization.
     *
     * @return type reference
     */
    protected abstract TypeReference<List<T>> getTypeReference();

    /**
     * Picks all trade date data for a single stock.
     *
     * @param stockCode 6-digit stock code
     * @return list of data
     */
    public List<T> pickOneStockAllTradeDate(String stockCode) {
        String normalized = TsStockCodeUtils.normalizeStockCode(stockCode);
        Date listingDate = stockBasicInfoProvider.getListingDate(normalized);
        Date startDate = TsDateUtils.parseDate("19900101");
        if (listingDate != null && listingDate.after(startDate)) {
            startDate = listingDate;
        }
        Date endDate = new Date();
        List<DateRange> ranges = DateRange.splitByYears(startDate, endDate, 20);
        List<T> result = new ArrayList<>();
        for (DateRange range : ranges) {
            List<T> part = picker.pickByStockCode(normalized,
                TsDateUtils.formatDate(range.getStartDate()),
                TsDateUtils.formatDate(range.getEndDate()));
            result.addAll(part);
        }
        log.info("Picked {} records for stock {}", result.size(), normalized);
        return result;
    }

    /**
     * Picks all stock data for one trade date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @return map of stock code to dto
     */
    public Map<String, T> pickAllStockOneTradeDate(String tradeDateString) {
        List<T> list = picker.pickByTradeDate(tradeDateString);
        return list.stream().collect(Collectors.toMap(AbstractStockHistoryDto::getStockCode, item -> item, (a, b) -> b));
    }

    /**
     * Reads all trade date data for one stock.
     *
     * @param stockCode 6-digit stock code
     * @return list of data
     */
    public List<T> readOneStockAllTradeDate(String stockCode) {
        String normalized = TsStockCodeUtils.normalizeStockCode(stockCode);
        return repository.readByStockCode(normalized, getTypeReference());
    }

    /**
     * Reads all stock data for one trade date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @return map of stock code to dto
     */
    public Map<String, T> readAllStockOneTradeDate(String tradeDateString) {
        return repository.readMapByTradeDate(tradeDateString, getTypeReference());
    }

    /**
     * Saves all trade date data for one stock and updates summary.
     *
     * @param stockCode 6-digit stock code
     * @param list data list
     */
    public void saveOneStockAllTradeDate(String stockCode, List<T> list) {
        String normalized = TsStockCodeUtils.normalizeStockCode(stockCode);
        List<T> sorted = sortAndIndex(list);
        repository.writeByStockCode(normalized, sorted);
        updateSummaryInfo(normalized, sorted);
    }

    /**
     * Saves all stock data for one trade date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @param list data list
     */
    public void saveAllStockOneTradeDate(String tradeDateString, List<T> list) {
        List<T> sorted = sortAndIndex(list);
        repository.writeByTradeDate(tradeDateString, sorted);
    }

    /**
     * Fixes all stock data based on summary and base trade date.
     *
     * @param baseTradeDateString base trade date
     * @return fixed stock code list
     */
    public List<String> fixAllStockAllHistory(String baseTradeDateString) {
        List<SummaryInfo> summaries = summaryRepository.readAll();
        List<String> fixed = new ArrayList<>();
        for (SummaryInfo summary : summaries) {
            if (summary.getTradeDateString().compareTo(baseTradeDateString) >= 0) {
                continue;
            }
            List<T> data = pickOneStockAllTradeDate(summary.getStockCode());
            saveOneStockAllTradeDate(summary.getStockCode(), data);
            fixed.add(summary.getStockCode());
        }
        log.info("Fixed {} stocks for base trade date {}", fixed.size(), baseTradeDateString);
        return fixed;
    }

    /**
     * Appends all stock data for one trade date and updates archive summary.
     *
     * @param tradeDateString trade date
     * @param list data list
     */
    public void appendAllStockOneTradeDate(String tradeDateString, List<T> list) {
        AllDataArchiveSummary summary = archiveSummaryRepository.read();
        String latest = summary.getLatestArchiveTradeDate(getDataType());
        String previousTradeDate = tradeCalendarService.getPreviousTradeDate(tradeDateString);
        if (latest != null && !latest.equals(previousTradeDate)) {
            throw new TsDataException("Archive date mismatch. expected previous trade date: "
                + previousTradeDate + ", actual: " + latest);
        }
        Map<String, List<T>> grouped = list.stream().collect(Collectors.groupingBy(AbstractStockHistoryDto::getStockCode));
        grouped.forEach((code, items) -> {
            List<T> sorted = sortAndIndex(items);
            repository.appendByStockCode(code, sorted, getTypeReference());
            updateSummaryInfo(code, repository.readByStockCode(code, getTypeReference()));
        });
        summary.updateLatestArchiveTradeDate(getDataType(), tradeDateString);
        archiveSummaryRepository.write(summary);
        log.info("Appended {} records for trade date {}", list.size(), tradeDateString);
    }

    /**
     * Reads recent N trade dates and aggregates by trade date.
     *
     * @param tradeDateString base trade date
     * @param recentlyN number of dates
     * @return map of trade date to data list
     */
    public Map<String, List<T>> readRecentlyNTradeDate(String tradeDateString, int recentlyN) {
        List<String> recentDates = tradeCalendarService.getRecentTradeDates(tradeDateString, recentlyN);
        return recentDates.stream().collect(Collectors.toMap(date -> date,
            date -> repository.readByTradeDate(date, getTypeReference())));
    }

    /**
     * Reads summary info for a stock.
     *
     * @param stockCode stock code
     * @return summary info
     */
    public Optional<SummaryInfo> readSummaryInfo(String stockCode) {
        return summaryRepository.readByStockCode(stockCode);
    }

    /**
     * Updates summary info for a stock.
     *
     * @param stockCode stock code
     * @param list data list
     */
    public void updateSummaryInfo(String stockCode, List<T> list) {
        if (list.isEmpty()) {
            return;
        }
        T latest = list.get(list.size() - 1);
        SummaryInfo summaryInfo = new SummaryInfo();
        summaryInfo.setStockCode(stockCode);
        summaryInfo.setTradeDateString(latest.getTradeDateString());
        summaryInfo.setIndexNumber(latest.getIndexNumber());
        summaryInfo.setLatestUpdateDateTimeString(TsDateUtils.formatDateTime(new Date()));

        List<SummaryInfo> all = summaryRepository.readAll();
        all = all.stream().filter(item -> !item.getStockCode().equals(stockCode))
            .collect(Collectors.toList());
        all.add(summaryInfo);
        summaryRepository.writeAll(all);
    }

    private List<T> sortAndIndex(List<T> list) {
        List<T> sorted = list.stream()
            .sorted(Comparator.comparing(AbstractStockHistoryDto::getTradeDateString))
            .collect(Collectors.toList());
        long index = 1L;
        for (T item : sorted) {
            item.setIndexNumber(index++);
            item.setLatestUpdateDateTime(new Date());
        }
        return sorted;
    }

    /**
     * Date range holder for segmentation.
     */
    private static class DateRange {
        private final Date startDate;
        private final Date endDate;

        private DateRange(Date startDate, Date endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Date getStartDate() {
            return startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public static List<DateRange> splitByYears(Date startDate, Date endDate, int years) {
            if (startDate.after(endDate)) {
                throw new TsDataException("Start date after end date");
            }
            List<DateRange> ranges = new ArrayList<>();
            java.util.Calendar calendar = java.util.Calendar.getInstance();
            calendar.setTime(startDate);
            while (!calendar.getTime().after(endDate)) {
                Date rangeStart = calendar.getTime();
                calendar.add(java.util.Calendar.YEAR, years);
                calendar.add(java.util.Calendar.DAY_OF_MONTH, -1);
                Date rangeEnd = calendar.getTime();
                if (rangeEnd.after(endDate)) {
                    rangeEnd = endDate;
                }
                ranges.add(new DateRange(rangeStart, rangeEnd));
                calendar.setTime(rangeEnd);
                calendar.add(java.util.Calendar.DAY_OF_MONTH, 1);
            }
            return ranges;
        }
    }
}
