package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-13
 * Time: 下午4:38
 */
public class AndroidCommonMsg implements Serializable {

    Long id;

    String msg;
    // 打印用，
    String type;
    // 安全首次质量竣工
    String typeCode;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AndroidCommonMsg{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", type='" + type + '\'' +
                ", typeCode='" + typeCode + '\'' +
                '}';
    }
}
