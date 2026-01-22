package com.mystk.market.data.repository;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import com.mystk.market.data.domain.AllDataArchiveSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static com.mystk.market.data.constants.TsConstants.ALL_DATA_ARCHIVE_SUMMARY_FILE_NAME;

/**
 * Repository for all-data archive summary.
 */
public class AllDataArchiveSummaryRepository {

    private static final Logger log = LoggerFactory.getLogger(AllDataArchiveSummaryRepository.class);

    private final File summaryFile;

    public AllDataArchiveSummaryRepository(File baseDir) {
        this.summaryFile = new File(baseDir, ALL_DATA_ARCHIVE_SUMMARY_FILE_NAME);
    }

    /**
     * Reads summary from file.
     *
     * @return summary
     */
    public AllDataArchiveSummary read() {
        if (!summaryFile.exists()) {
            return new AllDataArchiveSummary();
        }
        String json = FileUtil.readUtf8String(summaryFile);
        return JSONUtil.toBean(json, AllDataArchiveSummary.class);
    }

    /**
     * Writes summary to file.
     *
     * @param summary summary info
     */
    public void write(AllDataArchiveSummary summary) {
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(summary), summaryFile);
        log.info("Saved archive summary to {}", summaryFile.getAbsolutePath());
    }
}
