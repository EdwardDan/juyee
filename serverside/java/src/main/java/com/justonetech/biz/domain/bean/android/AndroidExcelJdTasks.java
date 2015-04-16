package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-14
 * Time: 上午10:27
 */
public class AndroidExcelJdTasks implements Serializable {
    // primary key
    private java.lang.Long id;
    /*报监日期*/
    private java.lang.String jdDatetime;
    /*报建编号*/
    private java.lang.String bjbh;
    /*监督任务书编号*/
    private java.lang.String jdTaskCode;
    /*项目名称*/
    private java.lang.String projectName;
    /*工程地点*/
    private java.lang.String projectAdd;
    /*建设单位*/
    private java.lang.String jsUnitName;
    /*建设单位地址*/
    private java.lang.String jsUnitAdd;
    /*建设单位联系人*/
    private java.lang.String jsLinkman;
    /*建设单位联系电话*/
    private java.lang.String jsPhone;
    /*地图标注X*/
    private java.lang.Double x;
    /*地图标注Y*/
    private java.lang.Double y;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJdDatetime() {
        return jdDatetime;
    }

    public void setJdDatetime(String jdDatetime) {
        this.jdDatetime = jdDatetime;
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
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

    public String getProjectAdd() {
        return projectAdd;
    }

    public void setProjectAdd(String projectAdd) {
        this.projectAdd = projectAdd;
    }

    public String getJsUnitName() {
        return jsUnitName;
    }

    public void setJsUnitName(String jsUnitName) {
        this.jsUnitName = jsUnitName;
    }

    public String getJsUnitAdd() {
        return jsUnitAdd;
    }

    public void setJsUnitAdd(String jsUnitAdd) {
        this.jsUnitAdd = jsUnitAdd;
    }

    public String getJsLinkman() {
        return jsLinkman;
    }

    public void setJsLinkman(String jsLinkman) {
        this.jsLinkman = jsLinkman;
    }

    public String getJsPhone() {
        return jsPhone;
    }

    public void setJsPhone(String jsPhone) {
        this.jsPhone = jsPhone;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "AndroidExcelJdTasks{" +
                "id=" + id +
                ", jdDatetime='" + jdDatetime + '\'' +
                ", bjbh='" + bjbh + '\'' +
                ", jdTaskCode='" + jdTaskCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectAdd='" + projectAdd + '\'' +
                ", jsUnitName='" + jsUnitName + '\'' +
                ", jsUnitAdd='" + jsUnitAdd + '\'' +
                ", jsLinkman='" + jsLinkman + '\'' +
                ", jsPhone='" + jsPhone + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
