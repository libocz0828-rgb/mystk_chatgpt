package com.mystk.market.data.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Summary for all data archives across data types.
 *
 * <p>Maintains latest archived trade date string for each data type.</p>
 */
public class AllDataArchiveSummary {

    private final Map<String, String> latestArchiveTradeDateMap = new HashMap<>();

    /**
     * Returns an unmodifiable view of the summary map.
     *
     * @return data type to latest trade date map
     */
    public Map<String, String> getLatestArchiveTradeDateMap() {
        return Collections.unmodifiableMap(latestArchiveTradeDateMap);
    }

    /**
     * Updates the latest trade date for a given data type.
     *
     * @param dataType data type name
     * @param tradeDateString latest trade date
     */
    public void updateLatestArchiveTradeDate(String dataType, String tradeDateString) {
        latestArchiveTradeDateMap.put(dataType, tradeDateString);
    }

    /**
     * Returns the latest trade date string for a given data type.
     *
     * @param dataType data type name
     * @return latest trade date string
     */
    public String getLatestArchiveTradeDate(String dataType) {
        return latestArchiveTradeDateMap.get(dataType);
    }
}
