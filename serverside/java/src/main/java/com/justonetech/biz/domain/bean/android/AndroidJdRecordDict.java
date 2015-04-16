package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-6
 * Time: 下午12:58
 */
public class AndroidJdRecordDict implements Serializable {


    // primary key
    private Integer rn;

    // primary key
    private java.lang.Long id;

    // fields
    /*法规依据*/
    /*法规依据*/
    private java.lang.String refRule;

    /*名称*/
    /*名称*/
    private java.lang.String name;

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefRule() {
        return refRule;
    }

    public void setRefRule(String refRule) {
        this.refRule = refRule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AndroidJdRecordDict{" +
                "rn=" + rn +
                ", id=" + id +
                ", refRule='" + refRule + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
