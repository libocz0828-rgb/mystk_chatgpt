package com.mystk.market.data.repository;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.TypeReference;
import com.mystk.market.data.domain.AbstractStockHistoryDto;
import com.mystk.market.data.exception.TsDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * File-based repository for stock history data.
 *
 * <p>Supports read/write by stock code and by trade date.</p>
 *
 * @param <T> dto type
 */
public class StockHistoryFileRepository<T extends AbstractStockHistoryDto> {

    private static final Logger log = LoggerFactory.getLogger(StockHistoryFileRepository.class);

    private final String dataType;
    private final File baseDir;

    public StockHistoryFileRepository(String dataType, File baseDir) {
        this.dataType = dataType;
        this.baseDir = baseDir;
    }

    /**
     * Reads data list by stock code.
     *
     * @param stockCode 6-digit stock code
     * @param typeReference type reference
     * @return list of data
     */
    public List<T> readByStockCode(String stockCode, TypeReference<List<T>> typeReference) {
        File file = getStockFile(stockCode);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        String json = FileUtil.readUtf8String(file);
        return JSONUtil.toBean(json, typeReference, false);
    }

    /**
     * Writes data list by stock code.
     *
     * @param stockCode 6-digit stock code
     * @param list data list
     */
    public void writeByStockCode(String stockCode, List<T> list) {
        File file = getStockFile(stockCode);
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(list), file);
        log.info("Saved {} records for {} to {}", list.size(), stockCode, file.getAbsolutePath());
    }

    /**
     * Reads data list by trade date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @param typeReference type reference
     * @return list of data
     */
    public List<T> readByTradeDate(String tradeDateString, TypeReference<List<T>> typeReference) {
        File file = getTradeDateFile(tradeDateString);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        String json = FileUtil.readUtf8String(file);
        return JSONUtil.toBean(json, typeReference, false);
    }

    /**
     * Writes data list by trade date.
     *
     * @param tradeDateString trade date in yyyyMMdd
     * @param list data list
     */
    public void writeByTradeDate(String tradeDateString, List<T> list) {
        File file = getTradeDateFile(tradeDateString);
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(list), file);
        log.info("Saved {} records for tradeDate {} to {}", list.size(), tradeDateString, file.getAbsolutePath());
    }

    /**
     * Appends a list of data to existing stock file.
     *
     * @param stockCode stock code
     * @param list data list
     * @param typeReference type reference
     */
    public void appendByStockCode(String stockCode, List<T> list, TypeReference<List<T>> typeReference) {
        List<T> current = readByStockCode(stockCode, typeReference);
        current.addAll(list);
        writeByStockCode(stockCode, current);
    }

    /**
     * Reads all data for a trade date and returns map by stock code.
     *
     * @param tradeDateString trade date
     * @param typeReference type reference
     * @return map of stock code to dto
     */
    public Map<String, T> readMapByTradeDate(String tradeDateString, TypeReference<List<T>> typeReference) {
        List<T> list = readByTradeDate(tradeDateString, typeReference);
        return list.stream().collect(Collectors.toMap(AbstractStockHistoryDto::getStockCode, item -> item, (a, b) -> b));
    }

    /**
     * Returns the base directory for this data type.
     *
     * @return base directory
     */
    public File getBaseDir() {
        return baseDir;
    }

    private File getStockFile(String stockCode) {
        File dir = new File(baseDir, dataType + File.separator + "byStock");
        FileUtil.mkdir(dir);
        return new File(dir, stockCode + ".json");
    }

    private File getTradeDateFile(String tradeDateString) {
        File dir = new File(baseDir, dataType + File.separator + "byDate");
        FileUtil.mkdir(dir);
        return new File(dir, tradeDateString + ".json");
    }

    /**
     * Returns all stock files for this data type.
     *
     * @return list of stock files
     */
    public List<File> listStockFiles() {
        File dir = new File(baseDir, dataType + File.separator + "byStock");
        if (!dir.exists()) {
            return Collections.emptyList();
        }
        File[] files = dir.listFiles();
        if (files == null) {
            throw new TsDataException("Failed to list stock files for " + dataType);
        }
        List<File> list = new ArrayList<>();
        Collections.addAll(list, files);
        return list;
    }
}
