package com.mystk.market.data.repository;

import com.mystk.market.data.domain.MoneyflowThsDto;

import java.io.File;

/**
 * Repository for TongHuaShun stock money flow data.
 */
public class TsMoneyflowThsRepository extends StockHistoryFileRepository<MoneyflowThsDto> {

    public TsMoneyflowThsRepository(File baseDir) {
        super("moneyflow_ths", baseDir);
    }
}
