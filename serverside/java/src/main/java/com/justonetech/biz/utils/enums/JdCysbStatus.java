package com.justonetech.biz.utils.enums;

/**
 * description:
 * User: HGR
 * Date: 2014/5/15 13:40
 */
public enum JdCysbStatus {
    STATUS_EDIT(1, "填写", "red"),
    STATUS_SUBMIT(2, "已提交", "blue"),
    STATUS_BACK(3, "退回修改", "red"),
    STATUS_PASS(4, "审核通过", "green");

    private int code;
    private String name;
    private String color;

    private JdCysbStatus(int code, String name, String color) {
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
        for (JdCysbStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (JdCysbStatus aType : values()) {
            if (aType.getCode() == code)
                return "<font color=" + aType.getColor() + ">" + aType.getName() + "</font>";
        }
        return null;
    }

}
