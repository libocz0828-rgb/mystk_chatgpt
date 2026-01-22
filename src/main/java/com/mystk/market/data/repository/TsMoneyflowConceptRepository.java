package com.mystk.market.data.repository;

import com.mystk.market.data.domain.MoneyflowConceptThsDto;

import java.io.File;

/**
 * Repository for TongHuaShun concept money flow.
 */
public class TsMoneyflowConceptRepository extends SimpleFileRepository<MoneyflowConceptThsDto> {

    public TsMoneyflowConceptRepository(File baseDir) {
        super(baseDir, "moneyflow_cnt_ths.json");
    }
}
