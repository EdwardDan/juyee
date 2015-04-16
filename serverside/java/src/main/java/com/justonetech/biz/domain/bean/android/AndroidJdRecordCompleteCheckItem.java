package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-6
 * Time: 上午9:28
 */
public class AndroidJdRecordCompleteCheckItem implements Serializable {

    // primary key
    private java.lang.Long id;
    /*竣工验收条件*/
    private java.lang.String condition;
    /*符合形式*/
    private java.lang.String selectItems;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(String selectItems) {
        this.selectItems = selectItems;
    }

    @Override
    public String toString() {
        return "AndroidJdRecordCompleteCheckItem{" +
                "id=" + id +
                ", condition='" + condition + '\'' +
                ", selectItems='" + selectItems + '\'' +
                '}';
    }
}
