package com.mystk.market.data.repository;

import com.mystk.market.data.domain.CyqChipsDto;

import java.io.File;

/**
 * Repository for chip distribution data.
 */
public class TsCyqChipsRepository extends StockHistoryFileRepository<CyqChipsDto> {

    public TsCyqChipsRepository(File baseDir) {
        super("cyq_chips", baseDir);
    }
}
