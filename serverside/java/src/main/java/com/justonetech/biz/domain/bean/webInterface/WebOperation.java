package com.justonetech.biz.domain.bean.webInterface;

/**
 * description: 项目审批--工程基本信息
 * User: Chenjp
 * Date: 14-8-19 下午1:10
 */
public class WebOperation {
    private String step; //受理环节名称
    private String name;  //操作状态
    private String time;  //受理时间
    private String results;  //受理结果
    private String bdh;  //标段号

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getBdh() {
        return bdh;
    }

    public void setBdh(String bdh) {
        this.bdh = bdh;
    }
}
