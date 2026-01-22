package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * TongHuaShun stock money flow data.
 *
 * <p>Provides net inflow and related metrics for a stock on a trade date.</p>
 */
public class MoneyflowThsDto extends AbstractStockHistoryDto {

    private BigDecimal netInflow;
    private BigDecimal hugeInflow;
    private BigDecimal largeInflow;

    public BigDecimal getNetInflow() {
        return netInflow;
    }

    public void setNetInflow(BigDecimal netInflow) {
        this.netInflow = netInflow;
    }

    public BigDecimal getHugeInflow() {
        return hugeInflow;
    }

    public void setHugeInflow(BigDecimal hugeInflow) {
        this.hugeInflow = hugeInflow;
    }

    public BigDecimal getLargeInflow() {
        return largeInflow;
    }

    public void setLargeInflow(BigDecimal largeInflow) {
        this.largeInflow = largeInflow;
    }
}
