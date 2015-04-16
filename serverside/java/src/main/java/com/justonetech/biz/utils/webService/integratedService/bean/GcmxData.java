package com.justonetech.biz.utils.webService.integratedService.bean;

/**
 * User: Chen Junping
 * Date: 12-4-28
 */
public class GcmxData {
    private String id;            //编号
    private String DwGcBh;       //单位工程编号
    private String JdRwsBh;      //监督任务书编号
    private String DwGcMc;       //单位工程名称
    private String GcLx;         //工程类型
    private Double JzMj;         //建筑面积
    private Double GzZj;         //工程造价
    private String ChangeTime;  //变化时间
    private String Jbr;          //经办人
    private String JbrDm;        //经办人代码
    private String bjbh;         //报建编号
    private String dwgch;        //单位工程号
    private int ts;              //台数
    private String jglx;         //监管类型

    public GcmxData() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDwGcBh() {
        return DwGcBh;
    }

    public void setDwGcBh(String dwGcBh) {
        DwGcBh = dwGcBh;
    }

    public String getJdRwsBh() {
        return JdRwsBh;
    }

    public void setJdRwsBh(String jdRwsBh) {
        JdRwsBh = jdRwsBh;
    }

    public String getDwGcMc() {
        return DwGcMc;
    }

    public void setDwGcMc(String dwGcMc) {
        DwGcMc = dwGcMc;
    }

    public String getGcLx() {
        return GcLx;
    }

    public void setGcLx(String gcLx) {
        GcLx = gcLx;
    }

    public Double getJzMj() {
        return JzMj;
    }

    public void setJzMj(Double jzMj) {
        JzMj = jzMj;
    }

    public Double getGzZj() {
        return GzZj;
    }

    public void setGzZj(Double gzZj) {
        GzZj = gzZj;
    }

    public String getChangeTime() {
        return ChangeTime;
    }

    public void setChangeTime(String changeTime) {
        ChangeTime = changeTime;
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

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public String getDwgch() {
        return dwgch;
    }

    public void setDwgch(String dwgch) {
        this.dwgch = dwgch;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getJglx() {
        return jglx;
    }

    public void setJglx(String jglx) {
        this.jglx = jglx;
    }
}
