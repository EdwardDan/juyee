package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaMonthplan;
import com.justonetech.biz.utils.enums.OaMonthplanStatus;


public class OaMonthplan extends BaseOaMonthplan {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaMonthplan() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaMonthplan(Long id) {
        super(id);
    }

/*[CONSTRUCTOR MARKER END]*/

    //获取状态的名称
    public String getStatusName() {
        return OaMonthplanStatus.getColorNameByCode(this.getStatus());
    }

    //报告时间
    public String getReportTime() {
        return this.getYear() + "年" + this.getPeriod() + "月";
    }
}