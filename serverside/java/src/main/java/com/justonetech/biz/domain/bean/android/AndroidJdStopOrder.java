package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-12
 * Time: 下午2:52
 */
public class AndroidJdStopOrder implements Serializable {
    // primary key
    private java.lang.Long id;
    /*表单类别(整改/暂缓/停工)*/
    private java.lang.String formCode;
    //  (整改/暂缓/停工)
    private java.lang.String formCodeDesc;
    /*监督类别编码*/
    private java.lang.String jdTypeCode;
    /*监督属性类别编码*/
    private java.lang.String type;
    /*监督id(首次/安全/质量/竣工)*/
    private java.lang.Long recordId;
    /*报建编号*/
    private java.lang.String bjbh;
    /*年份*/
    private java.lang.Integer year;
    /*序号*/
    private java.lang.String orderNo;
    /*责任主体*/
    private java.lang.String dutyDept;
    /*工程名称(冗余)*/
    private java.lang.String projectName;
    /*复查单位*/
    private java.lang.String recheckDept;
    /*复查单位其他*/
    private java.lang.String recheckOther;
    /*整改范围*/
    private java.lang.String reformArea;
    /*整改起始时间*/
    private java.lang.String reformBeginDate;
    /*整改期限*/
    private java.lang.String reformLimit;
    /*签发单位*/
    private java.lang.String signDept;
    /*审批人*/
    private java.lang.String signPerson;
    /*签发日期*/
    private java.lang.String signDate;
    /*备注*/
    private java.lang.String description;
    /*状态*/
    private java.lang.Integer status;
    /*状态中文描述*/
    private java.lang.String statusDesc;
    // 整改问题
    private List<AndroidJdRecordQuestion> questionList;

    public String getFormCodeDesc() {
        return formCodeDesc;
    }

    public void setFormCodeDesc(String formCodeDesc) {
        this.formCodeDesc = formCodeDesc;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormCode() {
        return formCode;
    }

    public void setFormCode(String formCode) {
        this.formCode = formCode;
    }

    public String getJdTypeCode() {
        return jdTypeCode;
    }

    public void setJdTypeCode(String jdTypeCode) {
        this.jdTypeCode = jdTypeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDutyDept() {
        return dutyDept;
    }

    public void setDutyDept(String dutyDept) {
        this.dutyDept = dutyDept;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRecheckDept() {
        return recheckDept;
    }

    public void setRecheckDept(String recheckDept) {
        this.recheckDept = recheckDept;
    }

    public String getRecheckOther() {
        return recheckOther;
    }

    public void setRecheckOther(String recheckOther) {
        this.recheckOther = recheckOther;
    }

    public String getReformArea() {
        return reformArea;
    }

    public void setReformArea(String reformArea) {
        this.reformArea = reformArea;
    }


    public String getSignDept() {
        return signDept;
    }

    public void setSignDept(String signDept) {
        this.signDept = signDept;
    }

    public String getSignPerson() {
        return signPerson;
    }

    public void setSignPerson(String signPerson) {
        this.signPerson = signPerson;
    }

    public String getReformBeginDate() {
        return reformBeginDate;
    }

    public void setReformBeginDate(String reformBeginDate) {
        this.reformBeginDate = reformBeginDate;
    }

    public String getReformLimit() {
        return reformLimit;
    }

    public void setReformLimit(String reformLimit) {
        this.reformLimit = reformLimit;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<AndroidJdRecordQuestion> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<AndroidJdRecordQuestion> questionList) {
        this.questionList = questionList;
    }

    @Override
    public String toString() {
        return "AndroidJdStopOrder{" +
                "id=" + id +
                ", formCode='" + formCode + '\'' +
                ", formCodeDesc='" + formCodeDesc + '\'' +
                ", jdTypeCode='" + jdTypeCode + '\'' +
                ", type='" + type + '\'' +
                ", recordId=" + recordId +
                ", bjbh='" + bjbh + '\'' +
                ", year=" + year +
                ", orderNo='" + orderNo + '\'' +
                ", dutyDept='" + dutyDept + '\'' +
                ", projectName='" + projectName + '\'' +
                ", recheckDept='" + recheckDept + '\'' +
                ", recheckOther='" + recheckOther + '\'' +
                ", reformArea='" + reformArea + '\'' +
                ", reformBeginDate='" + reformBeginDate + '\'' +
                ", reformLimit='" + reformLimit + '\'' +
                ", signDept='" + signDept + '\'' +
                ", signPerson='" + signPerson + '\'' +
                ", signDate='" + signDate + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", statusDesc='" + statusDesc + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
