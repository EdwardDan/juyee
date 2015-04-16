package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 月度总结和计划汇总状态
 * User: guoqiong
 * Date: 14-4-29
 */
public enum OaMonthplanSumStatus {
    STATUS_EDIT(1, "办公室主任填写", "red"),
    STATUS_SUBMIT(2, "提交", "blue"),
    STATUS_BACK_LEADER(3, "领导退回修改", "red"),
    STATUS_PASS(4, "领导审核通过", "green");

    private int code;
    private String name;
    private String color;

    OaMonthplanSumStatus(int code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(int code) {
        for (OaMonthplanSumStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (OaMonthplanSumStatus aType : values()) {
            if (aType.getCode() == code)
                return "<font color=" + aType.getColor() + ">" + aType.getName() + "</font>";
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
        OaMonthplanSumStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }

}
