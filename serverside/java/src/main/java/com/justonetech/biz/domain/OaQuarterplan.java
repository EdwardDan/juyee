package com.justonetech.biz.domain;

import com.justonetech.biz.daoservice.OaQuarterplanService;
import com.justonetech.biz.domain.base.BaseOaQuarterplan;
import org.springframework.beans.factory.annotation.Autowired;


public class OaQuarterplan extends BaseOaQuarterplan {
    private static final long serialVersionUID = 1L;

    @Autowired
    private OaQuarterplanService oaQuarterplanService;

    /*[CONSTRUCTOR MARKER BEGIN]*/
    public OaQuarterplan() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public OaQuarterplan(Long id) {
        super(id);
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
        String reportTime="";
        if (null == this.getPeriod()) {
            reportTime ="";
        }else if(5==this.getPeriod()){
            reportTime = "上半年度";
        }else if(6==this.getPeriod()){
            reportTime="下半年度";
        }else {
            reportTime ="第"+this.getPeriod()+"季度";
        }
        return this.getYear()+"年"+reportTime;
    }

}