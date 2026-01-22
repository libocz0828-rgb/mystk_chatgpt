package com.mystk.market.data.util;

import com.mystk.market.data.constants.TsConstants;
import com.mystk.market.data.exception.TsDataException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date utility methods for TuShare data processing.
 */
public final class TsDateUtils {

    private TsDateUtils() {
    }

    /**
     * Parses a date string with yyyyMMdd format.
     *
     * @param dateString date string
     * @return date
     */
    public static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat(TsConstants.DATE_FORMAT).parse(dateString);
        } catch (ParseException e) {
            throw new TsDataException("Failed to parse date string: " + dateString, e);
        }
    }

    /**
     * Formats a date to yyyyMMdd.
     *
     * @param date date
     * @return date string
     */
    public static String formatDate(Date date) {
        return new SimpleDateFormat(TsConstants.DATE_FORMAT).format(date);
    }

    /**
     * Formats a date time string with yyyyMMddHHmmss.
     *
     * @param date date
     * @return date time string
     */
    public static String formatDateTime(Date date) {
        return new SimpleDateFormat(TsConstants.DATE_TIME_FORMAT).format(date);
    }
}
