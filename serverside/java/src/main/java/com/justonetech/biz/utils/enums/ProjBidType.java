package com.justonetech.biz.utils.enums;

/**
 * 标段类别--分别用户办证推进和形象进度
 */
public enum ProjBidType {
    TYPE_STAGE("certStage", "办证推进"),
    TYPE_NODE("scheduleNode", "形象进度");

    private String code;
    private String name;

    ProjBidType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(String code) {
        for (ProjBidType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }
}
