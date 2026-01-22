package com.mystk.market.data.domain;

import java.util.Date;

/**
 * Base DTO for all stock-history data.
 *
 * <p>Index number starts from 1 and records the ordering within the stored file.</p>
 */
public abstract class AbstractStockHistoryDto {

    /**
     * 6-digit stock code.
     */
    private String stockCode;

    /**
     * Trade date string in yyyyMMdd.
     */
    private String tradeDateString;

    /**
     * Index number of this record in file ordering, starting from 1.
     */
    private long indexNumber;

    /**
     * Latest update time.
     */
    private Date latestUpdateDateTime;

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getTradeDateString() {
        return tradeDateString;
    }

    public void setTradeDateString(String tradeDateString) {
        this.tradeDateString = tradeDateString;
    }

    public long getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(long indexNumber) {
        this.indexNumber = indexNumber;
    }

    public Date getLatestUpdateDateTime() {
        return latestUpdateDateTime;
    }

    public void setLatestUpdateDateTime(Date latestUpdateDateTime) {
        this.latestUpdateDateTime = latestUpdateDateTime;
    }
}
