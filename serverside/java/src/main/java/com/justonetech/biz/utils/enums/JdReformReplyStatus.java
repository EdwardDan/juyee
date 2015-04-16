package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * description: 整改回复单
 * User: shaxiaojie
 * Date: 14-01-21 下午17:36
 */
public enum JdReformReplyStatus {

    STATUS_EDIT(1, "填写", "blue"),
    STATUS_SUBMIT(2, "提交", "blue"),
    STATUS_FIRST_PASS(3, "预审通过", "green"),
    STATUS_FIRST_BACK(4, "预审退回", "red"),
    STATUS_BACK(5, "复核通过", "green");

    private int code;
    private String name;
    private String color;

    private JdReformReplyStatus(int code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
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
        for (JdReformReplyStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (JdReformReplyStatus aType : values()) {
            if (aType.getCode() == code)
                return "<font color='" + aType.getColor() + "'>" + aType.getName() + "</font>";
        }
        return null;
    }

    /**
     * 获取下拉框
     *
     * @param selectValue .
     * @return .
     */
    public static String getOptions(String selectValue) {
        JdReformReplyStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
