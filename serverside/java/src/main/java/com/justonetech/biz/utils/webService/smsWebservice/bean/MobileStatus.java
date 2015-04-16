package com.justonetech.biz.utils.webService.smsWebservice.bean;

import java.util.Date;

/**
 * @author Ma Ji
 * @version 1.0
 * @since <pre>2010-7-1</pre>
 */
public class MobileStatus {

    //手机号码
    private String mobile;

    //提交时间
    private Date submitDate;

    //信息的提交状态
    private String submitStatus;

    //信息提交状态说明
    private String submitStatusDescription;

    //送达时间
    private Date deliverDate;

    //送达状态
    private String deliverStatus;

    //送达状态说明
    private String deliverStatusDecription;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }

    public String getSubmitStatusDescription() {
        return submitStatusDescription;
    }

    public void setSubmitStatusDescription(String submitStatusDescription) {
        this.submitStatusDescription = submitStatusDescription;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(String deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public String getDeliverStatusDecription() {
        return deliverStatusDecription;
    }

    public void setDeliverStatusDecription(String deliverStatusDecription) {
        this.deliverStatusDecription = deliverStatusDecription;
    }
}
