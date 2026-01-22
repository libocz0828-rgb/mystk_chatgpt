package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * TongHuaShun industry money flow data.
 *
 * <p>Represents daily money flow for an industry.</p>
 */
public class MoneyflowIndustryThsDto {

    private String industryCode;
    private String tradeDateString;
    private BigDecimal netInflow;
    private BigDecimal inflowRatio;

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
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
