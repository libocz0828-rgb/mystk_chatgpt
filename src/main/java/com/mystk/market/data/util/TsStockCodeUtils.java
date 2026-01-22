package com.mystk.market.data.util;

/**
 * Stock code utility methods.
 */
public final class TsStockCodeUtils {

    private TsStockCodeUtils() {
    }

    /**
     * Normalizes a stock code to 6-digit format.
     *
     * @param stockCode stock code
     * @return normalized stock code
     */
    public static String normalizeStockCode(String stockCode) {
        if (stockCode == null) {
            return null;
        }
        String trimmed = stockCode.trim();
        if (trimmed.length() >= 6) {
            return trimmed.substring(trimmed.length() - 6);
        }
        return String.format("%06d", Integer.parseInt(trimmed));
    }
}
