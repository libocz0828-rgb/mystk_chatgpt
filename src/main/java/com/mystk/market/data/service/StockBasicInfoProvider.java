package com.mystk.market.data.service;

import java.util.Date;

/**
 * Provides stock basic info for data picking.
 */
public interface StockBasicInfoProvider {

    /**
     * Returns listing date for a stock.
     *
     * @param stockCode 6-digit stock code
     * @return listing date
     */
    Date getListingDate(String stockCode);
}
