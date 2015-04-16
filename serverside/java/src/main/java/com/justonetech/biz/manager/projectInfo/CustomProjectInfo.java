package com.justonetech.biz.manager.projectInfo;

/**
 * description: 项目信息
 * User: Chenjp
 * Date: 14-6-5 上午9:25
 * 注意：此类属性已被多处引用，如果要修改属性，必须同步修改涉及的jsp和controller
 */
public class CustomProjectInfo {
    private String bjbh;   //报建编号
    private String bjDate;   //报监日期
    private String projectName;   //工程名称
    private String buildAddress;   //建设地点
    private String belongArea;   //所属区县
    private String lxFileCode;   //立项文号
    private Double totalInvestment;   //工程造价
    private String totalInvestmentDesc;   //工程造价 -- 加万元
    private Double totalArea;   //建筑面积
    private String totalAreaDesc;   //建筑面积 -- 加㎡
    private String structureForm;   //结构形式
    private int dtsl;   //单体数量
    private String projectType;   //项目分类 -- 装饰装修、普通商品房、市政
    private String projectProperty;   //项目性质 -- 生产性项目、非生产性项目
    private String buildProperty;   //建设性质 -- 新建、改建、其他
    private String buildScale;   //建设规模
    private String approvalDept;   //批准机关
    private String approvalDate;   //施工许可证发放日期

    private String jsdwmc;   //建设单位名称
    private String jsdwFr;   //建设单位法人
    private String jsdwLxr;   //建设单位联系人
    private String jsdwTel;   //建设单位联系电话
    private String jsdwZipcode;   //建设单位邮编
    private String jsdwAddress;   //建设单位地址

    private String jdTaskCode;   //监督任务书编号
    private String sgdwmc;     //施工单位名称
    private String sgdwLxr;   //施工单位联系人
    private String sgdwTel;   //施工单位电话

    private String sgzbdwmc;     //施工总包单位名称
    private String sgzbdwLxr;   //施工总包单位联系人
    private String sgzbdwTel;   //施工总包单位电话

    private String jldwmc;     //监理单位名称
    private String jldwLxr;   //监理单位联系人
    private String jldwTel;   //监理单位电话

    private String kcdwmc;     //勘察单位名称
    private String kcdwLxr;   //勘察单位联系人
    private String kcdwTel;   //勘察单位电话

    private String sjdwmc;     //设计单位名称
    private String sjdwLxr;   //设计单位联系人
    private String sjdwTel;   //设计单位电话


    public CustomProjectInfo() {
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public String getBjDate() {
        return bjDate;
    }

    public void setBjDate(String bjDate) {
        this.bjDate = bjDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBuildAddress() {
        return buildAddress;
    }

    public void setBuildAddress(String buildAddress) {
        this.buildAddress = buildAddress;
    }

    public String getBelongArea() {
        return belongArea;
    }

    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }

    public String getLxFileCode() {
        return lxFileCode;
    }

    public void setLxFileCode(String lxFileCode) {
        this.lxFileCode = lxFileCode;
    }

    public Double getTotalInvestment() {
        return totalInvestment;
    }

    public void setTotalInvestment(Double totalInvestment) {
        this.totalInvestment = totalInvestment;
    }

    public String getTotalInvestmentDesc() {
        return totalInvestmentDesc;
    }

    public void setTotalInvestmentDesc(String totalInvestmentDesc) {
        this.totalInvestmentDesc = totalInvestmentDesc;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public String getTotalAreaDesc() {
        return totalAreaDesc;
    }

    public void setTotalAreaDesc(String totalAreaDesc) {
        this.totalAreaDesc = totalAreaDesc;
    }

    public String getStructureForm() {
        return structureForm;
    }

    public void setStructureForm(String structureForm) {
        this.structureForm = structureForm;
    }

    public int getDtsl() {
        return dtsl;
    }

    public void setDtsl(int dtsl) {
        this.dtsl = dtsl;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getBuildProperty() {
        return buildProperty;
    }

    public void setBuildProperty(String buildProperty) {
        this.buildProperty = buildProperty;
    }

    public String getProjectProperty() {
        return projectProperty;
    }

    public void setProjectProperty(String projectProperty) {
        this.projectProperty = projectProperty;
    }

    public String getBuildScale() {
        return buildScale;
    }

    public void setBuildScale(String buildScale) {
        this.buildScale = buildScale;
    }

    public String getApprovalDept() {
        return approvalDept;
    }

    public void setApprovalDept(String approvalDept) {
        this.approvalDept = approvalDept;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getJsdwmc() {
        return jsdwmc;
    }

    public void setJsdwmc(String jsdwmc) {
        this.jsdwmc = jsdwmc;
    }

    public String getJsdwFr() {
        return jsdwFr;
    }

    public void setJsdwFr(String jsdwFr) {
        this.jsdwFr = jsdwFr;
    }

    public String getJsdwLxr() {
        return jsdwLxr;
    }

    public void setJsdwLxr(String jsdwLxr) {
        this.jsdwLxr = jsdwLxr;
    }

    public String getJsdwTel() {
        return jsdwTel;
    }

    public void setJsdwTel(String jsdwTel) {
        this.jsdwTel = jsdwTel;
    }

    public String getJsdwZipcode() {
        return jsdwZipcode;
    }

    public void setJsdwZipcode(String jsdwZipcode) {
        this.jsdwZipcode = jsdwZipcode;
    }

    public String getJsdwAddress() {
        return jsdwAddress;
    }

    public void setJsdwAddress(String jsdwAddress) {
        this.jsdwAddress = jsdwAddress;
    }

    public String getJdTaskCode() {
        return jdTaskCode;
    }

    public void setJdTaskCode(String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
    }

    public String getSgzbdwmc() {
        return sgzbdwmc;
    }

    public void setSgzbdwmc(String sgzbdwmc) {
        this.sgzbdwmc = sgzbdwmc;
    }

    public String getSgzbdwLxr() {
        return sgzbdwLxr;
    }

    public void setSgzbdwLxr(String sgzbdwLxr) {
        this.sgzbdwLxr = sgzbdwLxr;
    }

    public String getSgzbdwTel() {
        return sgzbdwTel;
    }

    public void setSgzbdwTel(String sgzbdwTel) {
        this.sgzbdwTel = sgzbdwTel;
    }

    public String getSgdwmc() {
        return sgdwmc;
    }

    public void setSgdwmc(String sgdwmc) {
        this.sgdwmc = sgdwmc;
    }

    public String getSgdwLxr() {
        return sgdwLxr;
    }

    public void setSgdwLxr(String sgdwLxr) {
        this.sgdwLxr = sgdwLxr;
    }

    public String getSgdwTel() {
        return sgdwTel;
    }

    public void setSgdwTel(String sgdwTel) {
        this.sgdwTel = sgdwTel;
    }

    public String getJldwmc() {
        return jldwmc;
    }

    public void setJldwmc(String jldwmc) {
        this.jldwmc = jldwmc;
    }

    public String getJldwLxr() {
        return jldwLxr;
    }

    public void setJldwLxr(String jldwLxr) {
        this.jldwLxr = jldwLxr;
    }

    public String getJldwTel() {
        return jldwTel;
    }

    public void setJldwTel(String jldwTel) {
        this.jldwTel = jldwTel;
    }

    public String getKcdwmc() {
        return kcdwmc;
    }

    public void setKcdwmc(String kcdwmc) {
        this.kcdwmc = kcdwmc;
    }

    public String getKcdwLxr() {
        return kcdwLxr;
    }

    public void setKcdwLxr(String kcdwLxr) {
        this.kcdwLxr = kcdwLxr;
    }

    public String getKcdwTel() {
        return kcdwTel;
    }

    public void setKcdwTel(String kcdwTel) {
        this.kcdwTel = kcdwTel;
    }

    public String getSjdwmc() {
        return sjdwmc;
    }

    public void setSjdwmc(String sjdwmc) {
        this.sjdwmc = sjdwmc;
    }

    public String getSjdwLxr() {
        return sjdwLxr;
    }

    public void setSjdwLxr(String sjdwLxr) {
        this.sjdwLxr = sjdwLxr;
    }

    public String getSjdwTel() {
        return sjdwTel;
    }

    public void setSjdwTel(String sjdwTel) {
        this.sjdwTel = sjdwTel;
    }
}
