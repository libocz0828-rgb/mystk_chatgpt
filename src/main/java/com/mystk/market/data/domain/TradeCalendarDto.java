package com.mystk.market.data.domain;

import java.util.Date;

/**
 * Trade calendar data.
 *
 * <p>Represents whether a date is open for trading.</p>
 */
public class TradeCalendarDto {

    private String exchangeCode;
    private String tradeDateString;
    private boolean open;
    private Date latestUpdateDateTime;

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getTradeDateString() {
        return tradeDateString;
    }

    public void setTradeDateString(String tradeDateString) {
        this.tradeDateString = tradeDateString;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Date getLatestUpdateDateTime() {
        return latestUpdateDateTime;
    }

    public void setLatestUpdateDateTime(Date latestUpdateDateTime) {
        this.latestUpdateDateTime = latestUpdateDateTime;
    }
}
