package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.CyqPerfDto;
import com.mystk.market.data.repository.AllDataArchiveSummaryRepository;
import com.mystk.market.data.repository.StockSummaryRepository;
import com.mystk.market.data.repository.TsCyqPerfRepository;

import java.util.List;

/**
 * Service for chip performance data.
 */
public class TsCyqPerfService extends AbstractStockHistoryDataService<CyqPerfDto> {

    public TsCyqPerfService(TuShareDataPicker<CyqPerfDto> picker,
                            TsCyqPerfRepository repository,
                            StockSummaryRepository summaryRepository,
                            AllDataArchiveSummaryRepository archiveSummaryRepository,
                            TradeCalendarService tradeCalendarService,
                            StockBasicInfoProvider stockBasicInfoProvider) {
        super(picker, repository, summaryRepository, archiveSummaryRepository, tradeCalendarService, stockBasicInfoProvider);
    }

    @Override
    public String getDataType() {
        return "cyq_perf";
    }

    @Override
    protected TypeReference<List<CyqPerfDto>> getTypeReference() {
        return new TypeReference<List<CyqPerfDto>>() {
        };
    }
}
