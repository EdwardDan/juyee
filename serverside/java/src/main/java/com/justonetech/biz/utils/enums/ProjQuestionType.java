package com.justonetech.biz.utils.enums;

/**
 * 问题清单
 * Created by gq on 2016/1/4.
 */
public enum ProjQuestionType {
    QUESTION_TYPE("question", "问题清单"),
    DUTY_TYPE("duty", "责任清单");

    private String code;
    private String name;

    ProjQuestionType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(String code) {
        for (ProjQuestionType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }
}
