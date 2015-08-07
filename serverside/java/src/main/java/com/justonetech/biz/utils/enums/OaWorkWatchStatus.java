package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 外出会议状态
 */
public enum OaWorkWatchStatus {
    STATUS_EDIT(1, "未提交", "blue"),
    STATUS_ZR_SH(2, "主任审核", "green"),
    STATUS_BACK(3, "退回修改", "red"),
    STATUS_INFO(4, "上报工作情况", "black"),
    STATUS_B_CHECK(5, "办公室核实", "blue"),
    STATUS_CHECK_BACK(6, "核实不通过", "red"),
    STATUS_CHECK_PASS(7, "核实通过", "green");

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
