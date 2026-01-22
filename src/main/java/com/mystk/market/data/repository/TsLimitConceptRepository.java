package com.mystk.market.data.repository;

import com.mystk.market.data.domain.LimitConceptDto;

import java.io.File;

/**
 * Repository for limit concept list data.
 */
public class TsLimitConceptRepository extends SimpleFileRepository<LimitConceptDto> {

    public TsLimitConceptRepository(File baseDir) {
        super(baseDir, "limit_cpt_list.json");
    }
}
