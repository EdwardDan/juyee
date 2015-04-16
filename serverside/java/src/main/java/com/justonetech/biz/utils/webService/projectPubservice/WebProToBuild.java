package com.justonetech.biz.utils.webService.projectPubservice;


import java.util.Date;
import java.util.List;


public class WebProToBuild {
    private String projectName;

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

    public String getLxFile() {
        return lxFile;
    }

    public void setLxFile(String lxFile) {
        this.lxFile = lxFile;
    }

    public String getLxLevel() {
        return lxLevel;
    }

    public void setLxLevel(String lxLevel) {
        this.lxLevel = lxLevel;
    }

    public String getApprovalUnit() {
        return approvalUnit;
    }

    public void setApprovalUnit(String approvalUnit) {
        this.approvalUnit = approvalUnit;
    }

    public String getLxFileCode() {
        return lxFileCode;
    }

    public void setLxFileCode(String lxFileCode) {
        this.lxFileCode = lxFileCode;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public Date getBjDate() {
        return bjDate;
    }

    public void setBjDate(Date bjDate) {
        this.bjDate = bjDate;
    }

    public List<WebshareProContract> getWebshareProContract() {
        return WebshareProContract;
    }

    public void setWebshareProContract(List<WebshareProContract> webshareProContract) {
        WebshareProContract = webshareProContract;
    }

    private String buildUnitName;
    private String buildAddress;
    private Double totalInvestment;

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    private Double totalArea;
    private String lxFile;
    private String lxLevel;
    private String approvalUnit;
    private String lxFileCode;
    private Date approvalDate;
    private String bjbh;
    private Date bjDate;
    private List<WebshareProContract> WebshareProContract;


}
