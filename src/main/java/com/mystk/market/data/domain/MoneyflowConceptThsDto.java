package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * TongHuaShun concept money flow data.
 *
 * <p>Represents daily money flow for a concept board.</p>
 */
public class MoneyflowConceptThsDto {

    private String conceptCode;
    private String tradeDateString;
    private BigDecimal netInflow;
    private BigDecimal inflowRatio;

    public String getConceptCode() {
        return conceptCode;
    }

    public void setConceptCode(String conceptCode) {
        this.conceptCode = conceptCode;
    }

    public String getTradeDateString() {
        return tradeDateString;
    }

    public void setTradeDateString(String tradeDateString) {
        this.tradeDateString = tradeDateString;
    }

    public BigDecimal getNetInflow() {
        return netInflow;
    }

    public void setNetInflow(BigDecimal netInflow) {
        this.netInflow = netInflow;
    }

    public BigDecimal getInflowRatio() {
        return inflowRatio;
    }

    public void setInflowRatio(BigDecimal inflowRatio) {
        this.inflowRatio = inflowRatio;
    }
}
