package com.mystk.market.data.domain;

import java.math.BigDecimal;

/**
 * Chip distribution data.
 *
 * <p>Provides price distribution ratios for each trade date.</p>
 */
public class CyqChipsDto extends AbstractStockHistoryDto {

    private BigDecimal priceRange;
    private BigDecimal chipRatio;

    public BigDecimal getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(BigDecimal priceRange) {
        this.priceRange = priceRange;
    }

    public BigDecimal getChipRatio() {
        return chipRatio;
    }

    public void setChipRatio(BigDecimal chipRatio) {
        this.chipRatio = chipRatio;
    }
}
