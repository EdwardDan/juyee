package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 注册人员来源
 * User: Chen Junping
 * Date: 12-6-12
 */
public enum PersonRegSource {
    RESOURCE_WEBSITE(1, "网站"),
    RESOURCE_WINDOW(2, "窗口");

    private int code;
    private String name;

    PersonRegSource(int code, String name) {
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
        for (PersonRegSource aType : values()) {
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
        PersonRegSource[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
