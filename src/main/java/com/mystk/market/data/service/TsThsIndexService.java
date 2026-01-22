package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.ThsIndexDto;
import com.mystk.market.data.repository.TsThsIndexRepository;

import java.util.List;

/**
 * Service for TongHuaShun index data.
 */
public class TsThsIndexService extends AbstractGlobalDataService<ThsIndexDto> {

    public TsThsIndexService(TuShareDataPicker<ThsIndexDto> picker,
                             TsThsIndexRepository repository) {
        super(picker, repository);
    }

    @Override
    protected TypeReference<List<ThsIndexDto>> getTypeReference() {
        return new TypeReference<List<ThsIndexDto>>() {
        };
    }
}
