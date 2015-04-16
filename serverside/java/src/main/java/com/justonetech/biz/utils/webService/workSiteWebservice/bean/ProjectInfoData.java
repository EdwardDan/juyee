package com.justonetech.biz.utils.webService.workSiteWebservice.bean;

/**
 * description:项目信息
 * User: Chenjp
 * Date: 12-11-15 下午4:02
 */
public class ProjectInfoData {

    /*报建编号*/
    private String buildCode;

    /*报建日期*/
    private java.util.Date buildDatetime;   //java.sql.Timestamp

    /*项目名称*/
    private String buildName;

    /*建设单位*/
    private String buildDept;

    /*建设单位性质*/
    private String buildDeptProperty;

    /*建设单位地址*/
    private String buildDeptAddress;

    /*建设单位电话*/
    private String buildDeptPhone;

    /*建设单位法人*/
    private String buildDeptLegal;

    /*建设单位联系人*/
    private String buildDeptLinkman;

    /*建设单位邮编*/
    private String buildDeptZipcode;

    /*建设单位注册资金*/
    private Double buildDeptRegCapital;

    /*建设地点*/
    private String buildAddress;

    /*建设性质*/
    private String buildProperty;

    /*建设规模*/
    private String buildScope;

    /*总面积*/
    private Double buildArea;

    /*开工日期*/
    private java.util.Date buildStartDate;   //java.sql.Date

    /*总投资*/
    private Double totalInvest;

    /*项目分类*/
    private String projectType;

    /*所在区县名称:静安、浦东*/
    private String belongArea;

    /*项目概况*/
    private String proDesc;

    /*项目进度*/
    private String proSchedule;

    /*项目关注度*/
    private String proAttention;

    /*设计单位名称*/
    private String designDept;

    /*勘察单位名称*/
    private String kcDept;

    public ProjectInfoData() {
    }

    public String getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode;
    }

    public java.util.Date getBuildDatetime() {
        return buildDatetime;
    }

    public void setBuildDatetime(java.util.Date buildDatetime) {
        this.buildDatetime = buildDatetime;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildDept() {
        return buildDept;
    }

    public void setBuildDept(String buildDept) {
        this.buildDept = buildDept;
    }

    public String getBuildDeptProperty() {
        return buildDeptProperty;
    }

    public void setBuildDeptProperty(String buildDeptProperty) {
        this.buildDeptProperty = buildDeptProperty;
    }

    public String getBuildDeptAddress() {
        return buildDeptAddress;
    }

    public void setBuildDeptAddress(String buildDeptAddress) {
        this.buildDeptAddress = buildDeptAddress;
    }

    public String getBuildDeptPhone() {
        return buildDeptPhone;
    }

    public void setBuildDeptPhone(String buildDeptPhone) {
        this.buildDeptPhone = buildDeptPhone;
    }

    public String getBuildDeptLegal() {
        return buildDeptLegal;
    }

    public void setBuildDeptLegal(String buildDeptLegal) {
        this.buildDeptLegal = buildDeptLegal;
    }

    public String getBuildDeptLinkman() {
        return buildDeptLinkman;
    }

    public void setBuildDeptLinkman(String buildDeptLinkman) {
        this.buildDeptLinkman = buildDeptLinkman;
    }

    public String getBuildDeptZipcode() {
        return buildDeptZipcode;
    }

    public void setBuildDeptZipcode(String buildDeptZipcode) {
        this.buildDeptZipcode = buildDeptZipcode;
    }

    public Double getBuildDeptRegCapital() {
        return buildDeptRegCapital;
    }

    public void setBuildDeptRegCapital(Double buildDeptRegCapital) {
        this.buildDeptRegCapital = buildDeptRegCapital;
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    public String getBuildProperty() {
        return buildProperty;
    }

    public void setBuildProperty(String buildProperty) {
        this.buildProperty = buildProperty;
    }

    public String getBuildScope() {
        return buildScope;
    }

    public void setBuildScope(String buildScope) {
        this.buildScope = buildScope;
    }

    public Double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Double buildArea) {
        this.buildArea = buildArea;
    }

    public java.util.Date getBuildStartDate() {
        return buildStartDate;
    }

    public void setBuildStartDate(java.util.Date buildStartDate) {
        this.buildStartDate = buildStartDate;
    }

    public Double getTotalInvest() {
        return totalInvest;
    }

    public void setTotalInvest(Double totalInvest) {
        this.totalInvest = totalInvest;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getBelongArea() {
        return belongArea;
    }

    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProSchedule() {
        return proSchedule;
    }

    public void setProSchedule(String proSchedule) {
        this.proSchedule = proSchedule;
    }

    public String getProAttention() {
        return proAttention;
    }

    public void setProAttention(String proAttention) {
        this.proAttention = proAttention;
    }

    public String getDesignDept() {
        return designDept;
    }

    public void setDesignDept(String designDept) {
        this.designDept = designDept;
    }

    public String getKcDept() {
        return kcDept;
    }

    public void setKcDept(String kcDept) {
        this.kcDept = kcDept;
    }
}
