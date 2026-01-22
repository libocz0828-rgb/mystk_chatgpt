package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.TradeCalendarDto;
import com.mystk.market.data.repository.TsTradeCalendarRepository;

import java.util.List;

/**
 * Service for trade calendar data collection and persistence.
 */
public class TsTradeCalendarService extends AbstractGlobalDataService<TradeCalendarDto> {

    public TsTradeCalendarService(TuShareDataPicker<TradeCalendarDto> picker,
                                  TsTradeCalendarRepository repository) {
        super(picker, repository);
    }

    @Override
    protected TypeReference<List<TradeCalendarDto>> getTypeReference() {
        return new TypeReference<List<TradeCalendarDto>>() {
        };
    }
}
