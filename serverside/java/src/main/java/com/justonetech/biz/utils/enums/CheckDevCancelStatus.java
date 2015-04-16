package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 考勤设备注销状态
 * User: Chen Junping
 * Date: 12-8-27
 */
public enum CheckDevCancelStatus {
    TYPE_VALID(1L, "未注销"),
    TYPE_INVALID(2L, "已注销");

    private Long code;
    private String name;

    private CheckDevCancelStatus(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
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
    public static String getNameByCode(Long code) {
        for (CheckDevCancelStatus aType : values()) {
            if (aType.getCode().equals(code))
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
        CheckDevCancelStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
