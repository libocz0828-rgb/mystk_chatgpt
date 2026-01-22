package com.mystk.market.data.repository;

import com.mystk.market.data.domain.MoneyflowIndustryThsDto;

import java.io.File;

/**
 * Repository for TongHuaShun industry money flow.
 */
public class TsMoneyflowIndustryRepository extends SimpleFileRepository<MoneyflowIndustryThsDto> {

    public TsMoneyflowIndustryRepository(File baseDir) {
        super(baseDir, "moneyflow_ind_ths.json");
    }
}
