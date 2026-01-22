package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.MoneyflowThsDto;
import com.mystk.market.data.repository.AllDataArchiveSummaryRepository;
import com.mystk.market.data.repository.StockSummaryRepository;
import com.mystk.market.data.repository.TsMoneyflowThsRepository;

import java.util.List;

/**
 * Service for TongHuaShun stock money flow data.
 */
public class TsMoneyflowThsService extends AbstractStockHistoryDataService<MoneyflowThsDto> {

    public TsMoneyflowThsService(TuShareDataPicker<MoneyflowThsDto> picker,
                                 TsMoneyflowThsRepository repository,
                                 StockSummaryRepository summaryRepository,
                                 AllDataArchiveSummaryRepository archiveSummaryRepository,
                                 TradeCalendarService tradeCalendarService,
                                 StockBasicInfoProvider stockBasicInfoProvider) {
        super(picker, repository, summaryRepository, archiveSummaryRepository, tradeCalendarService, stockBasicInfoProvider);
    }

    @Override
    public String getDataType() {
        return "moneyflow_ths";
    }

    @Override
    protected TypeReference<List<MoneyflowThsDto>> getTypeReference() {
        return new TypeReference<List<MoneyflowThsDto>>() {
        };
    }
}
