package com.justonetech.biz.utils.webService.workSiteWebservice.bean;

/**
 * description:参建单位信息
 * User: Chenjp
 * Date: 12-11-15 下午4:08
 */
public class ProjectDeptData {

    /*企业类别(施工、监理等)*/
    private String categoryCode;

    /*企业编码*/
    private String code;

    /*机构代码证*/
    private String orgCode;

    /*企业名称*/
    private String name;

    /*国家和地区*/
    private String country;

    /*企业地区属性*/
    private String areaProperty;

    /*注册地*/
    private String regAddress;

    /*项目负责人*/
    private String manager;

    /*项目负责人手机*/
    private String managerMobile;

    public ProjectDeptData() {
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerMobile() {
        return managerMobile;
    }

    public void setManagerMobile(String managerMobile) {
        this.managerMobile = managerMobile;
    }

    public String getAreaProperty() {
        return areaProperty;
    }

    public void setAreaProperty(String areaProperty) {
        this.areaProperty = areaProperty;
    }
}
