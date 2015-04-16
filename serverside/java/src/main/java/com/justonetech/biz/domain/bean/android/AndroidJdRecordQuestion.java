package com.justonetech.biz.domain.bean.android;

import java.io.Serializable;
import java.util.List;

/**
 * note:
 * User: Shaxj
 * Date: 14-8-5
 * Time: 下午5:34
 */
public class AndroidJdRecordQuestion implements Serializable {

    // id
    private Long id;
    // 问题类别
    private String typeCode;
    // 监督类型
    private String type;
    // 问题dict表中的id
    private Long dictId;
    // 法规
    private String refRule;
    // 法规名字
    private String dictName;
    // 人员ID
    private Long personId;
    // 人员名字
    private String personName;
    // 监督记录id
    private Long recordid;

    public Long getRecordid() {
        return recordid;
    }

    public void setRecordid(Long recordid) {
        this.recordid = recordid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getRefRule() {
        return refRule;
    }

    public void setRefRule(String refRule) {
        this.refRule = refRule;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "AndroidJdRecordQuestion{" +
                "id=" + id +
                ", typeCode='" + typeCode + '\'' +
                ", type='" + type + '\'' +
                ", dictId=" + dictId +
                ", refRule='" + refRule + '\'' +
                ", dictName='" + dictName + '\'' +
                ", personId=" + personId +
                ", personName='" + personName + '\'' +
                ", recordid=" + recordid +
                '}';
    }
}
