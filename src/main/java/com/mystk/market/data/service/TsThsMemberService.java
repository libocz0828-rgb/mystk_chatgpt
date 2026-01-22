package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.ThsMemberDto;
import com.mystk.market.data.repository.TsThsMemberRepository;

import java.util.List;

/**
 * Service for TongHuaShun concept member data.
 */
public class TsThsMemberService extends AbstractGlobalDataService<ThsMemberDto> {

    public TsThsMemberService(TuShareDataPicker<ThsMemberDto> picker,
                              TsThsMemberRepository repository) {
        super(picker, repository);
    }

    @Override
    protected TypeReference<List<ThsMemberDto>> getTypeReference() {
        return new TypeReference<List<ThsMemberDto>>() {
        };
    }
}
