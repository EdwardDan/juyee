package com.justonetech.biz.utils.enums;

/**
 * description:
 * User: HGR
 * Date: 2014/5/20 10:40
 */
public enum JdInformStatus {
    STATUS_EDIT(1, "填写", "red"),
    STATUS_SUBMIT(2, "科长审核", "blue"),
    STATUS_BACK(3, "科长退回", "red"),
    STATUS_SUBMIT_LEADER(4, "分管领导审核", "blue"),
    STATUS_BACK_LEADER(5, "分管领导退回", "red"),
    STATUS_PASS(6, "审核通过", "green");

    private int code;
    private String name;
    private String color;

    private JdInformStatus(int code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }

    /**
     * 获取名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(int code) {
        for (JdInformStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (JdInformStatus aType : values()) {
            if (aType.getCode() == code)
                return "<font color=" + aType.getColor() + ">" + aType.getName() + "</font>";
        }
        return null;
    }

}
