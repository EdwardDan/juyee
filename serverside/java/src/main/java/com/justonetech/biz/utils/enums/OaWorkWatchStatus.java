package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 外出会议状态
 */
public enum OaWorkWatchStatus {
    STATUS_EDIT(0, "填写", "red"),
    STATUS_SUBMIT(1, "提交", "blue"),
    STATUS_ZR_PASS(2, "主任审核通过", "green"),
    STATUS_ZR_BACK(3, "主任审核退回", "red"),
    STATUS_INFO(4, "已上报", "purple"),
    STATUS_B_PASS(5, "办公室核实通过", "green"),
    STATUS_B_BACK(6, "办公室核实退回", "red");

    private int code;
    private String name;
    private String color;

    private OaWorkWatchStatus(int code, String name, String color) {
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
        for (OaWorkWatchStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (OaWorkWatchStatus aType : values()) {
            if (aType.getCode() == code)
                return "<font color=\"" + aType.getColor() + "\">" + aType.getName() + "</font>";
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
        OaWorkWatchStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
