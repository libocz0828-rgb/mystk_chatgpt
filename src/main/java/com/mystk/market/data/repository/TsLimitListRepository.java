package com.mystk.market.data.repository;

import com.mystk.market.data.domain.LimitListDto;

import java.io.File;

/**
 * Repository for limit list data.
 */
public class TsLimitListRepository extends StockHistoryFileRepository<LimitListDto> {

    public TsLimitListRepository(File baseDir) {
        super("limit_list_d", baseDir);
    }
}
