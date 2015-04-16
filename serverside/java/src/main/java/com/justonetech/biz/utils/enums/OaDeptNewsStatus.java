package com.justonetech.biz.utils.enums;

import com.justonetech.biz.domain.OaDeptNews;
import com.justonetech.core.utils.JspHelper;

/**
 * description:
 * User: user
 * Date: 14-4-28 下午5:33
 */
public enum OaDeptNewsStatus {
    STATUS_EDIT(1, "填写", "red"),
    STATUS_SUBMIT(2, "已提交", "blue"),
    STATUS_BACK(3, "退回修改", "red"),
    STATUS_PASS(4, "审核通过", "green");

    private int code;
    private String name;
    private String color;

    private OaDeptNewsStatus(int code, String name, String color) {
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
        for (OaDeptNewsStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (OaDeptNewsStatus aType : values()) {
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
        OaDeptNewsStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }

}
