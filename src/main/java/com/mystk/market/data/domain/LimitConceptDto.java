package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * Limit concept list data.
 *
 * <p>Represents top concept boards and their performance on a trade date.</p>
 */
public class LimitConceptDto {

    private String conceptCode;
    private String conceptName;
    private String tradeDateString;
    private BigDecimal limitUpCount;
    private BigDecimal limitUpRatio;

    public String getConceptCode() {
        return conceptCode;
    }

    public void setConceptCode(String conceptCode) {
        this.conceptCode = conceptCode;
    }

    public String getConceptName() {
        return conceptName;
    }

    public void setConceptName(String conceptName) {
        this.conceptName = conceptName;
    }

    public String getTradeDateString() {
        return tradeDateString;
    }

    public void setTradeDateString(String tradeDateString) {
        this.tradeDateString = tradeDateString;
    }

    public BigDecimal getLimitUpCount() {
        return limitUpCount;
    }

    public void setLimitUpCount(BigDecimal limitUpCount) {
        this.limitUpCount = limitUpCount;
    }

    public BigDecimal getLimitUpRatio() {
        return limitUpRatio;
    }

    public void setLimitUpRatio(BigDecimal limitUpRatio) {
        this.limitUpRatio = limitUpRatio;
    }
}
