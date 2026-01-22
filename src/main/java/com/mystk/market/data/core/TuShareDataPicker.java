package com.mystk.market.data.core;

import java.util.List;
import java.util.Map;

/**
 * TuShare data picker interface.
 *
 * <p>Provides data access by stock code, trade date or custom parameters.</p>
 *
 * @param <T> dto type
 */
public interface TuShareDataPicker<T> {

    /**
     * Picks data by stock code and date range.
     *
     * @param stockCode 6-digit stock code
     * @param startDateString start date in yyyyMMdd
     * @param endDateString end date in yyyyMMdd
     * @return list of data
     */
    List<T> pickByStockCode(String stockCode, String startDateString, String endDateString);

    /**
     * Picks data by trade date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @return list of data
     */
    List<T> pickByTradeDate(String tradeDateString);

    /**
     * Picks data by custom params.
     *
     * @param params custom parameters
     * @return list of data
     */
    List<T> pickByParam(Map<String, Object> params);
}
