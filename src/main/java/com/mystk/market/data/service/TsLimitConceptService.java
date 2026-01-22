package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.LimitConceptDto;
import com.mystk.market.data.repository.TsLimitConceptRepository;

import java.util.List;

/**
 * Service for limit concept list data.
 */
public class TsLimitConceptService extends AbstractGlobalDataService<LimitConceptDto> {

    public TsLimitConceptService(TuShareDataPicker<LimitConceptDto> picker,
                                 TsLimitConceptRepository repository) {
        super(picker, repository);
    }

    @Override
    protected TypeReference<List<LimitConceptDto>> getTypeReference() {
        return new TypeReference<List<LimitConceptDto>>() {
        };
    }
}
