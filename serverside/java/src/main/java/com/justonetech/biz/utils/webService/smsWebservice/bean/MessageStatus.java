package com.justonetech.biz.utils.webService.smsWebservice.bean;

/**
 * @author Ma Ji
 * @version 1.0
 * @since <pre>2010-7-1</pre>
 */
public class MessageStatus {

    private String bizId;

    private MobileStatus[] mobileStatuses;

    public MessageStatus() {
    }

    public MessageStatus(String bizId, MobileStatus[] mobileStatuses) {
        this.bizId = bizId;
        this.mobileStatuses = mobileStatuses;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public MobileStatus[] getMobileStatuses() {
        return mobileStatuses;
    }

    public void setMobileStatuses(MobileStatus[] mobileStatuses) {
        this.mobileStatuses = mobileStatuses;
    }
}
