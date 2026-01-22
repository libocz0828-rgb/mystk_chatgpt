package com.mystk.market.data.repository;

import com.mystk.market.data.domain.StockBasicInfoDto;

import java.io.File;

/**
 * Repository for stock basic info.
 */
public class TsStockBasicInfoRepository extends SimpleFileRepository<StockBasicInfoDto> {

    public TsStockBasicInfoRepository(File baseDir) {
        super(baseDir, "stock_basic.json");
    }
}
