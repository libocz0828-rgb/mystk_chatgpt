package com.mystk.market.data.service;

import cn.hutool.json.TypeReference;
import com.mystk.market.data.core.TuShareDataPicker;
import com.mystk.market.data.repository.SimpleFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Abstract service for global data without stock/date dimension.
 *
 * @param <T> dto type
 */
public abstract class AbstractGlobalDataService<T> {

    private static final Logger log = LoggerFactory.getLogger(AbstractGlobalDataService.class);

    private final TuShareDataPicker<T> picker;
    private final SimpleFileRepository<T> repository;

    protected AbstractGlobalDataService(TuShareDataPicker<T> picker, SimpleFileRepository<T> repository) {
        this.picker = picker;
        this.repository = repository;
    }

    /**
     * Returns json type reference.
     *
     * @return type reference
     */
    protected abstract TypeReference<List<T>> getTypeReference();

    /**
     * Picks all data with custom params.
     *
     * @param params param map
     * @return list of data
     */
    public List<T> pickAll(Map<String, Object> params) {
        List<T> list = picker.pickByParam(params);
        log.info("Picked {} records", list.size());
        return list;
    }

    /**
     * Reads all data from repository.
     *
     * @return list of data
     */
    public List<T> readAll() {
        return repository.readAll(getTypeReference());
    }

    /**
     * Saves all data to repository.
     *
     * @param list data list
     */
    public void saveAll(List<T> list) {
        repository.writeAll(list);
    }
}
