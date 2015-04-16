package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 *  （新）质量安全监督记录的状态
 * User: chenjp
 * Date: 2014-01-08
 */
public enum JdRecordStatus {
    EDIT(1, "填写"),
    SUBMIT(2, "已提交");

    private int code;
    private String name;

    JdRecordStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
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
    public static String getNameByCode(int code) {
        for (JdRecordStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
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
        JdRecordStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
