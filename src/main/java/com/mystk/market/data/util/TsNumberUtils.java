package com.mystk.market.data.util;

import java.math.BigDecimal;

/**
 * Number utility methods.
 */
public final class TsNumberUtils {

    private TsNumberUtils() {
    }

    /**
     * Converts string to BigDecimal with zero fallback.
     *
     * @param value value string
     * @return BigDecimal
     */
    public static BigDecimal toBigDecimal(String value) {
        if (value == null || value.trim().isEmpty()) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(value.trim());
    }
}
