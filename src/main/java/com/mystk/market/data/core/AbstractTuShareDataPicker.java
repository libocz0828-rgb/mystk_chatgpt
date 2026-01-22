package com.mystk.market.data.core;

import com.mystk.market.data.exception.TsDataException;

import java.util.List;
import java.util.Map;

/**
 * Abstract TuShare data picker with unsupported defaults.
 *
 * @param <T> dto type
 */
public abstract class AbstractTuShareDataPicker<T> implements TuShareDataPicker<T> {

    @Override
    public List<T> pickByStockCode(String stockCode, String startDateString, String endDateString) {
        throw new TsDataException("Pick by stock code not supported.");
    }

    @Override
    public List<T> pickByTradeDate(String tradeDateString) {
        throw new TsDataException("Pick by trade date not supported.");
    }

    @Override
    public List<T> pickByParam(Map<String, Object> params) {
        throw new TsDataException("Pick by param not supported.");
    }
}
