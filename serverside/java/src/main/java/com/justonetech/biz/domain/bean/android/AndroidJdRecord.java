package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note: 监督预约责任主体
 * User: Shaxj
 * Date: 14-8-14
 * Time: 上午11:20
 */
public class AndroidJdRecord implements Serializable {

    /*建设单位*/
    private String jsDept;
    /*勘察单位*/
    private String kcDept;
    /*设计单位*/
    private String sjDept;
    /*施工单位*/
    private String sgDept;
    /*监理单位*/
    private String jlDept;
    /*检测单位*/
    private String jcDept;

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

    @Override
    public String toString() {
        return "AndroidJdRecord{" +
                "jsDept='" + jsDept + '\'' +
                ", kcDept='" + kcDept + '\'' +
                ", sjDept='" + sjDept + '\'' +
                ", sgDept='" + sgDept + '\'' +
                ", jlDept='" + jlDept + '\'' +
                ", jcDept='" + jcDept + '\'' +
                '}';
    }
}
