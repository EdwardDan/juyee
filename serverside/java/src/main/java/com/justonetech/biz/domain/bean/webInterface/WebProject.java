package com.justonetech.biz.domain.bean.webInterface;

/**
 * description: 项目审批--工程基本信息
 * User: Chenjp
 * Date: 14-8-19 下午1:10
 */
public class WebProject {
    private String bjbh;              //报建编号
    private String projectName;      //项目名称
    private String buildUnitName;    //建设单位
    private String buildAddress;     //建设地点
    private Double totalInvestment;  //总投资
    private WebFirstStep bjAction;    //项目报建基本信息
    private WebFirstStep sgt;          //施工图审图基本信息
    private WebFirstStep xmbj;         //项目报监基本信息
    private WebFirstStep sgxk;         //施工许可基本信息

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBuildUnitName() {
        return buildUnitName;
    }

    public void setBuildUnitName(String buildUnitName) {
        this.buildUnitName = buildUnitName;
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public WebFirstStep getBjAction() {
        return bjAction;
    }

    public void setBjAction(WebFirstStep bjAction) {
        this.bjAction = bjAction;
    }

    public WebFirstStep getSgt() {
        return sgt;
    }

    public void setSgt(WebFirstStep sgt) {
        this.sgt = sgt;
    }

    public WebFirstStep getXmbj() {
        return xmbj;
    }

    public void setXmbj(WebFirstStep xmbj) {
        this.xmbj = xmbj;
    }

    public WebFirstStep getSgxk() {
        return sgxk;
    }

    public void setSgxk(WebFirstStep sgxk) {
        this.sgxk = sgxk;
    }
}
