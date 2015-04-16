package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 物资采购管理--状态
 * User: Chenjp
 * Date: 14-4-16
 */
public enum OaMaterialStatus {
    STATUS_EDIT(1, "填写", "red"),
    STATUS_SUBMIT(2, "办公室主任审核", "blue"),
    STATUS_BACK(3, "办公室主任退回", "red"),
    STATUS_SUBMIT_LEADER(4, "领导审核", "blue"),
    STATUS_BACK_LEADER(5, "领导退回", "red"),
    STATUS_PASS(6, "审核通过", "green");

    private int code;
    private String name;
    private String color;

    private OaMaterialStatus(int code, String name, String color) {
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
        for (OaMaterialStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (OaMaterialStatus aType : values()) {
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
        OaMaterialStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }

}
