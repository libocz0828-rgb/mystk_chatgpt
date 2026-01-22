package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.MoneyflowConceptThsDto;
import com.mystk.market.data.repository.TsMoneyflowConceptRepository;

import java.util.List;

/**
 * Service for TongHuaShun concept money flow data.
 */
public class TsMoneyflowConceptService extends AbstractGlobalDataService<MoneyflowConceptThsDto> {

    public TsMoneyflowConceptService(TuShareDataPicker<MoneyflowConceptThsDto> picker,
                                     TsMoneyflowConceptRepository repository) {
        super(picker, repository);
    }

    @Override
    protected TypeReference<List<MoneyflowConceptThsDto>> getTypeReference() {
        return new TypeReference<List<MoneyflowConceptThsDto>>() {
        };
    }
}
