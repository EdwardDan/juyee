package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 外出会议状态
 */
public enum OaMeetingStatus {
    STATUS_EDIT(1, "填写", "red"),
    STATUS_SUBMIT(2, "提交", "blue"),
    STATUS_BRANCH_PASS(3, "分管领导审核通过", "purple"),
    STATUS_BRANCH_BACK(4, "分管领导审核退回", "red"),
    STATUS_MAIN_PASS(5, "主任审核通过", "green"),
    STATUS_MAIN_BACK(6, "主任审核退回", "red");

    private int code;
    private String name;
    private String color;

    private OaMeetingStatus(int code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
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
        for (OaMeetingStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (OaMeetingStatus aType : values()) {
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
        OaMeetingStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
