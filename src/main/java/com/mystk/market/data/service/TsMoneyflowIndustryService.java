package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.MoneyflowIndustryThsDto;
import com.mystk.market.data.repository.TsMoneyflowIndustryRepository;

import java.util.List;

/**
 * Service for TongHuaShun industry money flow data.
 */
public class TsMoneyflowIndustryService extends AbstractGlobalDataService<MoneyflowIndustryThsDto> {

    public TsMoneyflowIndustryService(TuShareDataPicker<MoneyflowIndustryThsDto> picker,
                                      TsMoneyflowIndustryRepository repository) {
        super(picker, repository);
    }

    @Override
    protected TypeReference<List<MoneyflowIndustryThsDto>> getTypeReference() {
        return new TypeReference<List<MoneyflowIndustryThsDto>>() {
        };
    }
}
