package com.mystk.market.data.repository;

import com.mystk.market.data.domain.CyqPerfDto;

import java.io.File;

/**
 * Repository for chip performance data.
 */
public class TsCyqPerfRepository extends StockHistoryFileRepository<CyqPerfDto> {

    public TsCyqPerfRepository(File baseDir) {
        super("cyq_perf", baseDir);
    }
}
