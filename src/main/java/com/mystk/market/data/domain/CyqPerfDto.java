package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * Chip performance data.
 *
 * <p>Includes average cost and win ratio metrics for a trade date.</p>
 */
public class CyqPerfDto extends AbstractStockHistoryDto {

    private BigDecimal averageCost;
    private BigDecimal winRatio;

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    public BigDecimal getWinRatio() {
        return winRatio;
    }

    public void setWinRatio(BigDecimal winRatio) {
        this.winRatio = winRatio;
    }
}
