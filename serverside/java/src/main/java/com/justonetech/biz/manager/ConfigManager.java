package com.justonetech.biz.manager;

/**
 * 系统配置
 * User: Chen Junping
 * Date: 12-3-21
 */
public class ConfigManager {
    private String projectArea;  //报建项目的区县
    private String projectAreaCode; //报建项目的区县代码
    private String jdDeptName; //监督单位名称
    private String siteName;     //网站标题
    private String filePath;     //附件存储路径
    private Boolean sendSms;     //短信开关
    private Boolean syncDatabase;     //数据库及危险源数据同步开关
    private Boolean syncCheckData;     //考勤数据同步开关
    private String syncCheckArea;     //考勤区域编码
    private Boolean certSwitch;     //证书验证开关
    private String certPath;     //证书存储路径
    private String defaultSkinPath;  //系统缺省皮肤
    private String hkVideoIp;     //海康视频登录--IP
    private String hkVideoUser;     //海康视频登录--用户名
    private String hkVideoPass;     //海康视频登录--密码
    private String syncLogPath;     //数据同步日志路径

    public String getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(String projectArea) {
        this.projectArea = projectArea;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getJdDeptName() {
        return jdDeptName;
    }

    public void setJdDeptName(String jdDeptName) {
        this.jdDeptName = jdDeptName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Boolean getSendSms() {
        return sendSms;
    }

    public void setSendSms(Boolean sendSms) {
        this.sendSms = sendSms;
    }

    public Boolean getSyncDatabase() {
        return syncDatabase;
    }

    public void setSyncDatabase(Boolean syncDatabase) {
        this.syncDatabase = syncDatabase;
    }

    public void setProjectAreaCode(String projectAreaCode) {
        this.projectAreaCode = projectAreaCode;
    }

    public String getProjectAreaCode() {
        return projectAreaCode;
    }

    public Boolean getSyncCheckData() {
        return syncCheckData;
    }

    public void setSyncCheckData(Boolean syncCheckData) {
        this.syncCheckData = syncCheckData;
    }

    public String getSyncCheckArea() {
        return syncCheckArea;
    }

    public void setSyncCheckArea(String syncCheckArea) {
        this.syncCheckArea = syncCheckArea;
    }

    public Boolean getCertSwitch() {
        return certSwitch;
    }

    public void setCertSwitch(Boolean certSwitch) {
        this.certSwitch = certSwitch;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getDefaultSkinPath() {
        return defaultSkinPath;
    }

    public void setDefaultSkinPath(String defaultSkinPath) {
        this.defaultSkinPath = defaultSkinPath;
    }

    public String getHkVideoIp() {
        return hkVideoIp;
    }

    public void setHkVideoIp(String hkVideoIp) {
        this.hkVideoIp = hkVideoIp;
    }

    public String getHkVideoUser() {
        return hkVideoUser;
    }

    public void setHkVideoUser(String hkVideoUser) {
        this.hkVideoUser = hkVideoUser;
    }

    public String getHkVideoPass() {
        return hkVideoPass;
    }

    public void setHkVideoPass(String hkVideoPass) {
        this.hkVideoPass = hkVideoPass;
    }

    public String getSyncLogPath() {
        return syncLogPath;
    }

    public void setSyncLogPath(String syncLogPath) {
        this.syncLogPath = syncLogPath;
    }
}
