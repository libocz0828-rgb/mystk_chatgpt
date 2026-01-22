package com.mystk.market.data.repository;

import com.mystk.market.data.domain.StockKlineDto;

import java.io.File;

/**
 * Repository for daily stock K-line data.
 */
public class TsStockKlineRepository extends StockHistoryFileRepository<StockKlineDto> {

    public TsStockKlineRepository(File baseDir) {
        super("daily", baseDir);
    }
}
