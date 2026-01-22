package com.mystk.market.data.repository;

import com.mystk.market.data.domain.ThsIndexDto;

import java.io.File;

/**
 * Repository for TongHuaShun index data.
 */
public class TsThsIndexRepository extends SimpleFileRepository<ThsIndexDto> {

    public TsThsIndexRepository(File baseDir) {
        super(baseDir, "ths_index.json");
    }
}
