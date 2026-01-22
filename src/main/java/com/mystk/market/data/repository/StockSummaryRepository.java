package com.mystk.market.data.repository;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.TypeReference;
import com.mystk.market.data.domain.SummaryInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mystk.market.data.constants.TsConstants.STOCK_SUMMARY_FILE_NAME;

/**
 * Repository for per-stock summary info.
 */
public class StockSummaryRepository {

    private static final Logger log = LoggerFactory.getLogger(StockSummaryRepository.class);

    private final File summaryFile;

    public StockSummaryRepository(File dataTypeDir) {
        this.summaryFile = new File(dataTypeDir, STOCK_SUMMARY_FILE_NAME);
    }

    /**
     * Reads all summary entries.
     *
     * @return summary list
     */
    public List<SummaryInfo> readAll() {
        if (!summaryFile.exists()) {
            return new ArrayList<>();
        }
        String json = FileUtil.readUtf8String(summaryFile);
        return JSONUtil.toBean(json, new TypeReference<List<SummaryInfo>>() {
        }, false);
    }

    /**
     * Reads summary by stock code.
     *
     * @param stockCode stock code
     * @return summary info
     */
    public Optional<SummaryInfo> readByStockCode(String stockCode) {
        return readAll().stream()
            .filter(item -> item.getStockCode().equals(stockCode))
            .findFirst();
    }

    /**
     * Writes all summary entries.
     *
     * @param list summary list
     */
    public void writeAll(List<SummaryInfo> list) {
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(list), summaryFile);
        log.info("Saved {} summary records to {}", list.size(), summaryFile.getAbsolutePath());
    }
}
