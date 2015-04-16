package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:监督预约
 * User: Shaxj
 * Date: 14-8-15
 * Time: 下午2:35
 */
public class AndroidOrderForm implements Serializable {

    private Long id;
    /*监督任务书编号*/
    private String jdTaskCode;
    /*工程名称*/
    private String projectName;
    /*工程地点*/
    private String buildAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJdTaskCode() {
        return jdTaskCode;
    }

    public void setJdTaskCode(String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
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

    @Override
    public String toString() {
        return "AndroidOrderForm{" +
                "id=" + id +
                ", jdTaskCode='" + jdTaskCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", buildAddress='" + buildAddress + '\'' +
                '}';
    }
}
