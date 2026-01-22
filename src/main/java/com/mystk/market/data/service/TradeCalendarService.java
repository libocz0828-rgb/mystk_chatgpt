package com.mystk.market.data.service;

import com.mystk.market.data.domain.TradeCalendarDto;
import com.mystk.market.data.exception.TsDataException;
import com.mystk.market.data.repository.TradeCalendarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Trade calendar service for common trade date operations.
 */
public class TradeCalendarService {

    private static final Logger log = LoggerFactory.getLogger(TradeCalendarService.class);

    private final TradeCalendarRepository repository;

    public TradeCalendarService(TradeCalendarRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns true if the date is a trade date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @return true when open
     */
    public boolean isTradeDate(String tradeDateString) {
        return repository.readAll().stream()
            .anyMatch(item -> item.getTradeDateString().equals(tradeDateString) && item.isOpen());
    }

    /**
     * Returns the previous trade date from the given date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @return previous trade date
     */
    public String getPreviousTradeDate(String tradeDateString) {
        List<TradeCalendarDto> list = repository.readAll().stream()
            .filter(TradeCalendarDto::isOpen)
            .sorted(Comparator.comparing(TradeCalendarDto::getTradeDateString))
            .collect(Collectors.toList());
        Optional<TradeCalendarDto> previous = Optional.empty();
        for (TradeCalendarDto item : list) {
            if (item.getTradeDateString().equals(tradeDateString)) {
                if (previous.isPresent()) {
                    return previous.get().getTradeDateString();
                }
                throw new TsDataException("No previous trade date found for: " + tradeDateString);
            }
            previous = Optional.of(item);
        }
        throw new TsDataException("Trade date not found in calendar: " + tradeDateString);
    }

    /**
     * Returns recent N trade dates up to the given base date.
     *
     * @param tradeDateString base trade date
     * @param recentlyN number of dates
     * @return recent trade date list
     */
    public List<String> getRecentTradeDates(String tradeDateString, int recentlyN) {
        List<String> tradeDates = repository.readAll().stream()
            .filter(TradeCalendarDto::isOpen)
            .sorted(Comparator.comparing(TradeCalendarDto::getTradeDateString))
            .map(TradeCalendarDto::getTradeDateString)
            .collect(Collectors.toList());
        int index = tradeDates.indexOf(tradeDateString);
        if (index < 0) {
            throw new TsDataException("Trade date not found in calendar: " + tradeDateString);
        }
        int startIndex = Math.max(0, index - recentlyN + 1);
        List<String> result = tradeDates.subList(startIndex, index + 1);
        log.info("Resolved recent {} trade dates to {}", recentlyN, result);
        return result;
    }
}
