package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-5
 * Time: 下午5:13
 */
public class AndroidJdTask implements Serializable {

    // 行号
    private Integer rn;
    private Long  id;
    // 监督类型
    private String type;
    // 监督任务书编号
    private String jdTaskCode;
    // 项目名称
    private String projectName;
    // 报建编号
    private String bjbh;
    /*监督日期*/
    private String jdDatetime;
    //
    private List<AndroidJdPersonInfo> jdPersons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBjbh() {
        return bjbh;
    }

    public void setBjbh(String bjbh) {
        this.bjbh = bjbh;
    }

    public String getJdDatetime() {
        return jdDatetime;
    }

    public void setJdDatetime(String jdDatetime) {
        this.jdDatetime = jdDatetime;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<AndroidJdPersonInfo> getJdPersons() {
        return jdPersons;
    }

    public void setJdPersons(List<AndroidJdPersonInfo> jdPersons) {
        this.jdPersons = jdPersons;
    }

    @Override
    public String toString() {
        return "AndroidJdTask{" +
                "rn=" + rn +
                ", type='" + type + '\'' +
                ", jdTaskCode='" + jdTaskCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", bjbh='" + bjbh + '\'' +
                ", jdDatetime='" + jdDatetime + '\'' +
                ", jdPersons=" + jdPersons +
                '}';
    }
}
