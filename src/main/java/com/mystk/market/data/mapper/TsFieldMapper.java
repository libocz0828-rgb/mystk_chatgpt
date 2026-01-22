package com.mystk.market.data.mapper;

import java.util.Map;

/**
 * Mapper for TuShare field names to DTO fields.
 *
 * @param <T> dto type
 */
public interface TsFieldMapper<T> {

    /**
     * Maps a TuShare record to DTO.
     *
     * @param record field name map
     * @return dto
     */
    T mapFromTushare(Map<String, String> record);
}
