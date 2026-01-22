package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * TongHuaShun index data.
 *
 * <p>Includes index code, name and performance for each trade date.</p>
 */
public class ThsIndexDto {

    private String indexCode;
    private String indexName;
    private String tradeDateString;
    private BigDecimal closePrice;
    private BigDecimal changeRatio;

    public String getIndexCode() {
        return indexCode;
    }

    public void setIndexCode(String indexCode) {
        this.indexCode = indexCode;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getTradeDateString() {
        return tradeDateString;
    }

    public void setTradeDateString(String tradeDateString) {
        this.tradeDateString = tradeDateString;
    }

    public BigDecimal getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(BigDecimal closePrice) {
        this.closePrice = closePrice;
    }

    public BigDecimal getChangeRatio() {
        return changeRatio;
    }

    public void setChangeRatio(BigDecimal changeRatio) {
        this.changeRatio = changeRatio;
    }
}
