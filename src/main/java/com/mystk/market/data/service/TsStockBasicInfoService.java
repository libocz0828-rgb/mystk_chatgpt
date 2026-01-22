package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.domain.StockBasicInfoDto;
import com.mystk.market.data.repository.TsStockBasicInfoRepository;

import java.util.List;

/**
 * Service for stock basic info.
 */
public class TsStockBasicInfoService extends AbstractGlobalDataService<StockBasicInfoDto> implements StockBasicInfoProvider {

    private final TsStockBasicInfoRepository repository;

    public TsStockBasicInfoService(TuShareDataPicker<StockBasicInfoDto> picker,
                                   TsStockBasicInfoRepository repository) {
        super(picker, repository);
        this.repository = repository;
    }

    @Override
    protected TypeReference<List<StockBasicInfoDto>> getTypeReference() {
        return new TypeReference<List<StockBasicInfoDto>>() {
        };
    }

    @Override
    public java.util.Date getListingDate(String stockCode) {
        return repository.readAll(getTypeReference()).stream()
            .filter(item -> item.getStockCode().equals(stockCode))
            .findFirst()
            .map(StockBasicInfoDto::getListingDate)
            .orElse(null);
    }
}
