package com.mystk.market.data.repository;

import com.mystk.market.data.domain.ThsMemberDto;

import java.io.File;

/**
 * Repository for TongHuaShun concept members.
 */
public class TsThsMemberRepository extends SimpleFileRepository<ThsMemberDto> {

    public TsThsMemberRepository(File baseDir) {
        super(baseDir, "ths_member.json");
    }
}
