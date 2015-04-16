package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-5
 * Time: 下午5:16
 */
public class AndroidJdPersonInfo implements Serializable {
     // 登录名
    private String loginName;

    private Long id;
    // 人员姓名
    private String name;
    // primary key

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AndroidJdPersonInfo{" +
                "loginName='" + loginName + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
