package com.justonetech.biz.manager;

/**
 * 系统配置
 * User: Chen Junping
 * Date: 12-3-21
 */
public class ConfigManager {
    private String jdDeptName; //监督单位名称
    private String siteName;     //网站标题
    private String filePath;     //附件存储路径
    private Boolean sendSms;     //短信开关
    private Boolean kxtSendSms;     //短信开关
    private String defaultSkinPath;  //系统缺省皮肤

    public String getJdDeptName() {
        return jdDeptName;
    }

    public void setJdDeptName(String jdDeptName) {
        this.jdDeptName = jdDeptName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Boolean getSendSms() {
        return sendSms;
    }

    public void setSendSms(Boolean sendSms) {
        this.sendSms = sendSms;
    }

    public Boolean getKxtSendSms() {
        return kxtSendSms;
    }

    public void setKxtSendSms(Boolean kxtSendSms) {
        this.kxtSendSms = kxtSendSms;
    }

    public String getDefaultSkinPath() {
        return defaultSkinPath;
    }

    public void setDefaultSkinPath(String defaultSkinPath) {
        this.defaultSkinPath = defaultSkinPath;
    }
}
