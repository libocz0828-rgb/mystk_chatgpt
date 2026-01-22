package com.mystk.market.data.archive;

import com.mystk.market.data.service.AbstractGlobalDataService;
import com.mystk.market.data.service.AbstractStockHistoryDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Daily archive service for after-close data collection.
 */
public class DailyArchiveService {

    private static final Logger log = LoggerFactory.getLogger(DailyArchiveService.class);

    /**
     * Archives daily data across history and global services.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @param historyServices stock history services
     * @param globalServices global data services
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void archiveDailyData(String tradeDateString,
                                 List<AbstractStockHistoryDataService> historyServices,
                                 List<AbstractGlobalDataService<?>> globalServices) {
        List<AbstractStockHistoryDataService> safeHistory =
            historyServices == null ? Collections.emptyList() : historyServices;
        for (AbstractStockHistoryDataService<?> service : safeHistory) {
            Map<String, ?> map = service.pickAllStockOneTradeDate(tradeDateString);
            List dataList = map.values().stream().collect(java.util.stream.Collectors.toList());
            service.saveAllStockOneTradeDate(tradeDateString, dataList);
            service.appendAllStockOneTradeDate(tradeDateString, dataList);
            log.info("Archived history data type {} for trade date {}", service.getDataType(), tradeDateString);
        }

        List<AbstractGlobalDataService<?>> safeGlobal =
            globalServices == null ? Collections.emptyList() : globalServices;
        for (AbstractGlobalDataService<?> service : safeGlobal) {
            service.saveAll(service.pickAll(Collections.singletonMap("trade_date", tradeDateString)));
            log.info("Archived global data for trade date {}", tradeDateString);
        }
    }
}
