package com.justonetech.biz.utils.webService.workSiteWebservice.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * description:工地信息
 * User: Chenjp
 * Date: 12-11-15 下午3:52
 */
public class WorkSiteData {

    /*工地编号*/
    private String workCode;

    /*工地名称*/
    private String workName;

    /*工地地址*/
    private String address;

    /*状态代码*/
    private String statusCode;

    /*状态描述*/
    private String statusDesc;

    /*监管单位代码*/
    private String jgDeptCode;

    /*监管单位名称*/
    private String jgDeptName;

    /*施工总包单位代码*/
    private String sgDeptCode;

    /*施工总包单位名称*/
    private String sgDeptName;

    /*监理单位代码*/
    private String jlDeptCode;

    /*监理单位名称*/
    private String jlDeptName;

    /*经度*/
    private Double longitude;

    /*纬度*/
    private Double latitude;

    private ProjectInfoData projectInfoData;   //项目信息
    List<ProjectDeptData> projectDeptDatas;     //参建单位
    List<ProjectDwgcData> projectDwgcDatas;     //单位工程

    public WorkSiteData() {
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getJgDeptCode() {
        return jgDeptCode;
    }

    public void setJgDeptCode(String jgDeptCode) {
        this.jgDeptCode = jgDeptCode;
    }

    public String getJgDeptName() {
        return jgDeptName;
    }

    public void setJgDeptName(String jgDeptName) {
        this.jgDeptName = jgDeptName;
    }

    public String getSgDeptCode() {
        return sgDeptCode;
    }

    public void setSgDeptCode(String sgDeptCode) {
        this.sgDeptCode = sgDeptCode;
    }

    public String getSgDeptName() {
        return sgDeptName;
    }

    public void setSgDeptName(String sgDeptName) {
        this.sgDeptName = sgDeptName;
    }

    public String getJlDeptCode() {
        return jlDeptCode;
    }

    public void setJlDeptCode(String jlDeptCode) {
        this.jlDeptCode = jlDeptCode;
    }

    public String getJlDeptName() {
        return jlDeptName;
    }

    public void setJlDeptName(String jlDeptName) {
        this.jlDeptName = jlDeptName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public ProjectInfoData getProjectInfoData() {
        return projectInfoData;
    }

    public void setProjectInfoData(ProjectInfoData projectInfoData) {
        this.projectInfoData = projectInfoData;
    }

    public List<ProjectDeptData> getProjectDeptDatas() {
        if(projectDeptDatas == null){
            projectDeptDatas = new ArrayList<ProjectDeptData>();
        }
        return projectDeptDatas;
    }

    public void setProjectDeptDatas(List<ProjectDeptData> projectDeptDatas) {
        this.projectDeptDatas = projectDeptDatas;
    }

    public List<ProjectDwgcData> getProjectDwgcDatas() {
        if(projectDwgcDatas == null){
            projectDwgcDatas = new ArrayList<ProjectDwgcData>();
        }
        return projectDwgcDatas;
    }

    public void setProjectDwgcDatas(List<ProjectDwgcData> projectDwgcDatas) {
        this.projectDwgcDatas = projectDwgcDatas;
    }
}
