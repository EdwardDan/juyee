package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-6
 * Time: 下午12:12
 */
public class AndroidJdRecordCjdw implements Serializable {
    private String jdTaskCode; //监督任务书编号
    private String flowCode;   //流转编号
    private String bjbh;       //报建编号
    private String projectName;//工程名称
    private String jsDept;      //建设单位
    private String kcDept;      //勘察单位
    private String sjDept;      //设计单位
    private String sgDept;      //施工单位
    private String jlDept;      //监理单位
    private String jcDept;      //检测单位
    private String jdjg;        //监督机构

    public AndroidJdRecordCjdw() {
    }

    public String getJdTaskCode() {
        return jdTaskCode;
    }

    public void setJdTaskCode(String jdTaskCode) {
        this.jdTaskCode = jdTaskCode;
    }

    public String getFlowCode() {
        return flowCode;
    }

    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode;
    }

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

    public String getJsDept() {
        return jsDept;
    }

    public void setJsDept(String jsDept) {
        this.jsDept = jsDept;
    }

    public String getKcDept() {
        return kcDept;
    }

    public void setKcDept(String kcDept) {
        this.kcDept = kcDept;
    }

    public String getSjDept() {
        return sjDept;
    }

    public void setSjDept(String sjDept) {
        this.sjDept = sjDept;
    }

    public String getSgDept() {
        return sgDept;
    }

    public void setSgDept(String sgDept) {
        this.sgDept = sgDept;
    }

    public String getJlDept() {
        return jlDept;
    }

    public void setJlDept(String jlDept) {
        this.jlDept = jlDept;
    }

    public String getJcDept() {
        return jcDept;
    }

    public void setJcDept(String jcDept) {
        this.jcDept = jcDept;
    }

    public String getJdjg() {
        return jdjg;
    }

    public void setJdjg(String jdjg) {
        this.jdjg = jdjg;
    }

    @Override
    public String toString() {
        return "AndroidJdRecordCjdw{" +
                "jdTaskCode='" + jdTaskCode + '\'' +
                ", flowCode='" + flowCode + '\'' +
                ", bjbh='" + bjbh + '\'' +
                ", projectName='" + projectName + '\'' +
                ", jsDept='" + jsDept + '\'' +
                ", kcDept='" + kcDept + '\'' +
                ", sjDept='" + sjDept + '\'' +
                ", sgDept='" + sgDept + '\'' +
                ", jlDept='" + jlDept + '\'' +
                ", jcDept='" + jcDept + '\'' +
                ", jdjg='" + jdjg + '\'' +
                '}';
    }
}
