package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * Daily limit list info.
 *
 * <p>Includes limit up/down data and open board information.</p>
 */
public class LimitListDto extends AbstractStockHistoryDto {

    private BigDecimal limitUpAmount;
    private BigDecimal limitDownAmount;
    private BigDecimal openBoardAmount;

    public BigDecimal getLimitUpAmount() {
        return limitUpAmount;
    }

    public void setLimitUpAmount(BigDecimal limitUpAmount) {
        this.limitUpAmount = limitUpAmount;
    }

    public BigDecimal getLimitDownAmount() {
        return limitDownAmount;
    }

    public void setLimitDownAmount(BigDecimal limitDownAmount) {
        this.limitDownAmount = limitDownAmount;
    }

    public BigDecimal getOpenBoardAmount() {
        return openBoardAmount;
    }

    public void setOpenBoardAmount(BigDecimal openBoardAmount) {
        this.openBoardAmount = openBoardAmount;
    }
}
