package com.mystk.market.data.constants;

/**
 * Supported TuShare data types.
 */
public enum TsDataType {

    STOCK_BASIC("stock_basic"),
    DAILY("daily"),
    LIMIT_LIST_D("limit_list_d"),
    LIMIT_CPT_LIST("limit_cpt_list"),
    THS_INDEX("ths_index"),
    THS_MEMBER("ths_member"),
    MONEYFLOW_THS("moneyflow_ths"),
    MONEYFLOW_CNT_THS("moneyflow_cnt_ths"),
    MONEYFLOW_IND_THS("moneyflow_ind_ths"),
    CYQ_PERF("cyq_perf"),
    CYQ_CHIPS("cyq_chips"),
    TRADE_CAL("trade_cal");

    private final String dataType;

    TsDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
