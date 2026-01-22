package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.StockKlineDto;
import com.mystk.market.data.repository.AllDataArchiveSummaryRepository;
import com.mystk.market.data.repository.StockSummaryRepository;
import com.mystk.market.data.repository.TsStockKlineRepository;

import java.util.List;

/**
 * Service for daily stock K-line data.
 */
public class TsStockKlineService extends AbstractStockHistoryDataService<StockKlineDto> {

    public TsStockKlineService(TuShareDataPicker<StockKlineDto> picker,
                               TsStockKlineRepository repository,
                               StockSummaryRepository summaryRepository,
                               AllDataArchiveSummaryRepository archiveSummaryRepository,
                               TradeCalendarService tradeCalendarService,
                               StockBasicInfoProvider stockBasicInfoProvider) {
        super(picker, repository, summaryRepository, archiveSummaryRepository, tradeCalendarService, stockBasicInfoProvider);
    }

    @Override
    public String getDataType() {
        return "daily";
    }

    @Override
    protected TypeReference<List<StockKlineDto>> getTypeReference() {
        return new TypeReference<List<StockKlineDto>>() {
        };
    }
}
