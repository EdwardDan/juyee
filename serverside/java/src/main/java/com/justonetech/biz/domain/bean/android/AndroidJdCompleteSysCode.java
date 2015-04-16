package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;
import java.util.List;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-6
 * Time: 上午9:45
 */
public class AndroidJdCompleteSysCode implements Serializable {
    // primary key
    private java.lang.Long id;
    // 检查条件名称
    private String name;
    // 监督类型
    private String type;
    // 检查条目
    private List<AndroidJdRecordCompleteCheckItem> jdRecordCompleteCheckItem;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AndroidJdRecordCompleteCheckItem> getJdRecordCompleteCheckItem() {
        return jdRecordCompleteCheckItem;
    }

    public void setJdRecordCompleteCheckItem(List<AndroidJdRecordCompleteCheckItem> jdRecordCompleteCheckItem) {
        this.jdRecordCompleteCheckItem = jdRecordCompleteCheckItem;
    }

    @Override
    public String toString() {
        return "AndroidJdCompleteSysCode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", jdRecordCompleteCheckItem=" + jdRecordCompleteCheckItem +
                '}';
    }
}
