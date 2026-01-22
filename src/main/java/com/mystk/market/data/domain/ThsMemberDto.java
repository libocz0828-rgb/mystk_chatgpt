package com.mystk.market.data.domain;

import java.util.Date;

/**
 * TongHuaShun concept member data.
 *
 * <p>Maintains concept membership list with in/out dates.</p>
 */
public class ThsMemberDto {

    private String conceptCode;
    private String stockCode;
    private Date inDate;
    private Date outDate;

    public String getConceptCode() {
        return conceptCode;
    }

    public void setConceptCode(String conceptCode) {
        this.conceptCode = conceptCode;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }
}
