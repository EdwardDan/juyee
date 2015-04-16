package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaMonthplanSum;
import com.justonetech.biz.utils.enums.OaMonthplanStatus;
import com.justonetech.biz.utils.enums.OaMonthplanSumStatus;
import com.justonetech.core.utils.StringHelper;

import java.util.HashSet;
import java.util.Set;


public class OaMonthplanSum extends BaseOaMonthplanSum {
    private static final long serialVersionUID = 1L;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaMonthplanSum() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaMonthplanSum(Long id) {
        super(id);
    }

    /*[CONSTRUCTOR MARKER END]*/
    //获取状态的名称
    public String getStatusName() {
        return OaMonthplanSumStatus.getColorNameByCode(this.getStatus());
    }

    //报告时间
    public String getReportTime() {
        return this.getYear() + "年" + this.getPeriod() + "月";
    }

    //获取审核通过的部门
    public String getReportDepts() {
        Set<String> report = new HashSet<String>();
        String reportDept = "";
        Set<OaMonthplanSumItem> oaMonthplanSumItems = this.getOaMonthplanSumItems();
        for (OaMonthplanSumItem oaMonthplanSumItem : oaMonthplanSumItems) {
            OaMonthplanItem monthplanItem = oaMonthplanSumItem.getMonthplanItem();
            OaMonthplan monthplan = monthplanItem.getMonthplan();
            if ((monthplan.getStatus() == OaMonthplanStatus.STATUS_PASS.getCode()) && !monthplanItem.getIsSumDelete()) {
                String dept = monthplan.getReportDept();
                if (!report.contains(dept)) {
                    reportDept += "," + dept;
                    report.add(dept);
                }
            }
        }
        if (!StringHelper.isEmpty(reportDept)) {
            reportDept = reportDept.substring(1);
        }
        return reportDept;
    }

}