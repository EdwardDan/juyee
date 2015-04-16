package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 手持终端版本类型
 * User: Chen Junping
 * Date: 12-8-27
 */
public enum PadVersionType {
    TYPE_NORMAL(1L, "普通版"),
    TYPE_LEADER(2L, "领导版");

    private Long code;
    private String name;

    private PadVersionType(Long code, String name) {
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
        for (PadVersionType aType : values()) {
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
        PadVersionType[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
