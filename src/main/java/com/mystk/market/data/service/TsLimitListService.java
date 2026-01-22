package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.LimitListDto;
import com.mystk.market.data.repository.AllDataArchiveSummaryRepository;
import com.mystk.market.data.repository.StockSummaryRepository;
import com.mystk.market.data.repository.TsLimitListRepository;

import java.util.List;

/**
 * Service for limit list data.
 */
public class TsLimitListService extends AbstractStockHistoryDataService<LimitListDto> {

    public TsLimitListService(TuShareDataPicker<LimitListDto> picker,
                              TsLimitListRepository repository,
                              StockSummaryRepository summaryRepository,
                              AllDataArchiveSummaryRepository archiveSummaryRepository,
                              TradeCalendarService tradeCalendarService,
                              StockBasicInfoProvider stockBasicInfoProvider) {
        super(picker, repository, summaryRepository, archiveSummaryRepository, tradeCalendarService, stockBasicInfoProvider);
    }

    @Override
    public String getDataType() {
        return "limit_list_d";
    }

    @Override
    protected TypeReference<List<LimitListDto>> getTypeReference() {
        return new TypeReference<List<LimitListDto>>() {
        };
    }
}
