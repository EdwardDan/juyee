package com.justonetech.biz.domain;

import com.justonetech.biz.domain.base.BaseOaQuarterplanSum;
import com.justonetech.biz.utils.enums.OaQuarterplanSumStatus;
import com.justonetech.core.utils.StringHelper;

import java.util.HashSet;
import java.util.Set;


public class OaQuarterplanSum extends BaseOaQuarterplanSum {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public OaQuarterplanSum () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public OaQuarterplanSum (Long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/


    //获取状态的名称
    public String getStatusName() {
        return OaQuarterplanSumStatus.getColorNameByCode(this.getStatus());
    }

    //提交类型
    public String getReportType() {
        if (null == this.getPeriod()) {
            return "年度总结计划";
        } else {
            return "季度总结计划";
        }
    }

    //报告时间
    public String getReportTime() {
        if (null == this.getPeriod()) {
            return this.getYear() + "年";
        }else if(5==this.getPeriod()){
            return this.getYear()+"年"+"上半年度";
        }else if(6==this.getPeriod()){
            return this.getPeriod()+"年"+"下半年度";
        }else {
            return this.getYear() + "年第" + this.getPeriod() + "季度";
        }
    }

    //统计已经审核通过的部门
    public String getReportDepts() {
        Set<String> report = new HashSet<String>();
        String reportDept = "";
        Set<OaQuarterplanSumItem> oaQuarterplanSumItems = this.getOaQuarterplanSumItems();
        if (oaQuarterplanSumItems != null && oaQuarterplanSumItems.size() > 0) {
            for (OaQuarterplanSumItem oaQuarterplanSumItem : oaQuarterplanSumItems) {
                String dept = oaQuarterplanSumItem.getReportDept();
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