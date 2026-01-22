package com.mystk.market.data.domain;

/**
 * Summary information for per-stock persisted data.
 *
 * <p>Contains last trade date and index number to validate incremental updates.</p>
 */
public class SummaryInfo {

    /**
     * 6-digit stock code.
     */
    private String stockCode;

    /**
     * Latest trade date string in yyyyMMdd.
     */
    private String tradeDateString;

    /**
     * Index number for the latest record, starts from 1.
     */
    private long indexNumber;

    /**
     * Latest update date time.
     */
    private String latestUpdateDateTimeString;

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

    public String getLatestUpdateDateTimeString() {
        return latestUpdateDateTimeString;
    }

    public void setLatestUpdateDateTimeString(String latestUpdateDateTimeString) {
        this.latestUpdateDateTimeString = latestUpdateDateTimeString;
    }
}
