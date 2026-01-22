package com.mystk.market.data.domain;

import java.util.Date;

/**
 * Stock basic info.
 *
 * <p>Represents A-share listing information, code, name and listing date.</p>
 */
public class StockBasicInfoDto {

    /**
     * 6-digit stock code.
     */
    private String stockCode;

    /**
     * Stock name.
     */
    private String stockName;

    /**
     * Industry name.
     */
    private String industry;

    /**
     * Listing date.
     */
    private Date listingDate;

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

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Date getLatestUpdateDateTime() {
        return latestUpdateDateTime;
    }

    public void setLatestUpdateDateTime(Date latestUpdateDateTime) {
        this.latestUpdateDateTime = latestUpdateDateTime;
    }
}
