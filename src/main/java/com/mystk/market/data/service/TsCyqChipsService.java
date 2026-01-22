package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.CyqChipsDto;
import com.mystk.market.data.repository.AllDataArchiveSummaryRepository;
import com.mystk.market.data.repository.StockSummaryRepository;
import com.mystk.market.data.repository.TsCyqChipsRepository;

import java.util.List;

/**
 * Service for chip distribution data.
 */
public class TsCyqChipsService extends AbstractStockHistoryDataService<CyqChipsDto> {

    public TsCyqChipsService(TuShareDataPicker<CyqChipsDto> picker,
                             TsCyqChipsRepository repository,
                             StockSummaryRepository summaryRepository,
                             AllDataArchiveSummaryRepository archiveSummaryRepository,
                             TradeCalendarService tradeCalendarService,
                             StockBasicInfoProvider stockBasicInfoProvider) {
        super(picker, repository, summaryRepository, archiveSummaryRepository, tradeCalendarService, stockBasicInfoProvider);
    }

    @Override
    public String getDataType() {
        return "cyq_chips";
    }

    @Override
    protected TypeReference<List<CyqChipsDto>> getTypeReference() {
        return new TypeReference<List<CyqChipsDto>>() {
        };
    }
}
