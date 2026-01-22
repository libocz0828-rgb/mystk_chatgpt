package com.mystk.market.data.constants;

/**
 * TuShare related constants and shared configuration.
 *
 * <p>All date strings use yyyyMMdd to ensure consistent persistence and parsing.</p>
 */
public final class TsConstants {

    /**
     * Standard date format for trade dates.
     */
    public static final String DATE_FORMAT = "yyyyMMdd";

    /**
     * Standard date time format.
     */
    public static final String DATE_TIME_FORMAT = "yyyyMMddHHmmss";

    /**
     * Summary file name for per-stock latest trade info.
     */
    public static final String STOCK_SUMMARY_FILE_NAME = "summary.json";

    /**
     * Summary file name for all-data archive latest trade info.
     */
    public static final String ALL_DATA_ARCHIVE_SUMMARY_FILE_NAME = "allDataArchiveSummary.json";

    private TsConstants() {
    }
}
