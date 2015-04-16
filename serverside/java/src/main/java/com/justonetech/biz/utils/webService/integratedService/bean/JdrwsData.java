package com.justonetech.biz.utils.webService.integratedService.bean;

/**
 * 监督任务书--webservice
 * User: Chen Junping
 * Date: 12-4-28
 */
public class JdrwsData {
    private String JdRwsBh;   //监督任务书编号
    private String JdRwsScRq; //监督任务书生成时间
    private String JdRwsMc;   //监督任务书名称
    private String Zt;         //状态
    private String Bz;         //备注
    private String Bjbh;       //报建编号
    private String DwDm;       //单位代码
    private String Jbr;        //经办人
    private String JbrDm;      //经办人代码
    private String ChangeTime;//变化时间
    private Boolean wtyn;      //
    private String firstTime; //首次监督时间
    private String xmmc;       //项目名称
    private String xmdd;       //项目地点

    public JdrwsData() {
    }

    public String getJdRwsBh() {
        return JdRwsBh;
    }

    public void setJdRwsBh(String jdRwsBh) {
        JdRwsBh = jdRwsBh;
    }

    public String getJdRwsScRq() {
        return JdRwsScRq;
    }

    public void setJdRwsScRq(String jdRwsScRq) {
        JdRwsScRq = jdRwsScRq;
    }

    public String getJdRwsMc() {
        return JdRwsMc;
    }

    public void setJdRwsMc(String jdRwsMc) {
        JdRwsMc = jdRwsMc;
    }

    public String getZt() {
        return Zt;
    }

    public void setZt(String zt) {
        Zt = zt;
    }

    public String getBz() {
        return Bz;
    }

    public void setBz(String bz) {
        Bz = bz;
    }

    public String getBjbh() {
        return Bjbh;
    }

    public void setBjbh(String bjbh) {
        Bjbh = bjbh;
    }

    public String getDwDm() {
        return DwDm;
    }

    public void setDwDm(String dwDm) {
        DwDm = dwDm;
    }

    public String getJbr() {
        return Jbr;
    }

    public void setJbr(String jbr) {
        Jbr = jbr;
    }

    public String getJbrDm() {
        return JbrDm;
    }

    public void setJbrDm(String jbrDm) {
        JbrDm = jbrDm;
    }

    public String getChangeTime() {
        return ChangeTime;
    }

    public void setChangeTime(String changeTime) {
        ChangeTime = changeTime;
    }

    public Boolean getWtyn() {
        return wtyn;
    }

    public void setWtyn(Boolean wtyn) {
        this.wtyn = wtyn;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getXmmc() {
        return xmmc;
    }

    public void setXmmc(String xmmc) {
        this.xmmc = xmmc;
    }

    public String getXmdd() {
        return xmdd;
    }

    public void setXmdd(String xmdd) {
        this.xmdd = xmdd;
    }
}
