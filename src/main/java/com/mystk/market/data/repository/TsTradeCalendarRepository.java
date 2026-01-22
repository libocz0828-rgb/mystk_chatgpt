package com.mystk.market.data.repository;

import java.io.File;

/**
 * Repository for trade calendar data.
 */
public class TsTradeCalendarRepository extends TradeCalendarRepository {

    public TsTradeCalendarRepository(File baseDir) {
        super(baseDir);
    }
}
