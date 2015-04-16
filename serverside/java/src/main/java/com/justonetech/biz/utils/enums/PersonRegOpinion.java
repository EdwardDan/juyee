package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 注册人员窗口受理状态
 * User: Chen Junping
 * Date: 12-6-12
 */
public enum PersonRegOpinion {
    OPINION_NOTACCEPT(0, "未受理"),
    OPINION_PASS(1, "已通过"),
    OPINION_NOTPASS(2, "未通过");

    private int code;
    private String name;

    PersonRegOpinion(int code, String name) {
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
        for (PersonRegOpinion aType : values()) {
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
        PersonRegOpinion[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
