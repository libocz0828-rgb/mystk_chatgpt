package com.mystk.market.data.repository;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple file repository for global data without stock/date dimension.
 *
 * @param <T> dto type
 */
public class SimpleFileRepository<T> {

    private static final Logger log = LoggerFactory.getLogger(SimpleFileRepository.class);

    private final File file;

    public SimpleFileRepository(File baseDir, String fileName) {
        this.file = new File(baseDir, fileName);
    }

    /**
     * Reads all data.
     *
     * @param typeReference type reference
     * @return list of data
     */
    public List<T> readAll(TypeReference<List<T>> typeReference) {
        if (!file.exists()) {
            return new ArrayList<>();
        }
        String json = FileUtil.readUtf8String(file);
        return JSONUtil.toBean(json, typeReference, false);
    }

    /**
     * Writes all data.
     *
     * @param list data list
     */
    public void writeAll(List<T> list) {
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(list), file);
        log.info("Saved {} records to {}", list.size(), file.getAbsolutePath());
    }
}
