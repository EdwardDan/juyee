package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:巡查问题选择条件下拉框
 * User: Shaxj
 * Date: 14-8-11
 * Time: 下午1:42
 */
public class AndroidPollingDictOption implements Serializable {
    // id
    private Long id;
    //  法规名称
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
        return "AndroidPollingDictOption{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
