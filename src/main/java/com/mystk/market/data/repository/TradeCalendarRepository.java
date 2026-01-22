package com.mystk.market.data.repository;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.TypeReference;
import com.mystk.market.data.domain.TradeCalendarDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for trade calendar data.
 */
public class TradeCalendarRepository {

    private static final Logger log = LoggerFactory.getLogger(TradeCalendarRepository.class);

    private final File calendarFile;

    public TradeCalendarRepository(File baseDir) {
        this.calendarFile = new File(baseDir, "tradeCalendar.json");
    }

    /**
     * Reads all trade calendar entries.
     *
     * @return trade calendar list
     */
    public List<TradeCalendarDto> readAll() {
        if (!calendarFile.exists()) {
            return new ArrayList<>();
        }
        String json = FileUtil.readUtf8String(calendarFile);
        return JSONUtil.toBean(json, new TypeReference<List<TradeCalendarDto>>() {
        }, false);
    }

    /**
     * Writes all trade calendar entries.
     *
     * @param list trade calendar list
     */
    public void writeAll(List<TradeCalendarDto> list) {
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(list), calendarFile);
        log.info("Saved {} trade calendar records to {}", list.size(), calendarFile.getAbsolutePath());
    }
}
