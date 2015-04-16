package com.justonetech.biz.utils.webService.workSiteWebservice.bean;

/**
 * description:单位工程信息
 * User: Chenjp
 * Date: 12-11-15 下午4:15
 */
public class ProjectDwgcData {

    /*单位工程编号*/
    private String code;

    /*单位工程名称*/
    private String name;

    /*工程类型*/
    private String category;

    /*建筑面积*/
    private Double buildArea;

    /*工程造价*/
    private Double buildCost;

    /*层数*/
    private Integer upLevel;

    /*地下层数*/
    private Integer downLevel;

    /*在监状态描述*/
    private String statusDesc;

    public ProjectDwgcData() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Double buildArea) {
        this.buildArea = buildArea;
    }

    public Double getBuildCost() {
        return buildCost;
    }

    public void setBuildCost(Double buildCost) {
        this.buildCost = buildCost;
    }

    public Integer getUpLevel() {
        return upLevel;
    }

    public void setUpLevel(Integer upLevel) {
        this.upLevel = upLevel;
    }

    public Integer getDownLevel() {
        return downLevel;
    }

    public void setDownLevel(Integer downLevel) {
        this.downLevel = downLevel;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
