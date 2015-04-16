package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:施工进度
 * User: Shaxj
 * Date: 14-8-6
 * Time: 下午5:48
 */
public class AndroidJdSgjd implements Serializable {
    // id
    private Long id;
    // 名称
    private String name;

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
        return "AndroidJdSgjd{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
