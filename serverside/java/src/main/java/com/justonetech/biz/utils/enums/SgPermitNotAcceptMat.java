package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

import java.util.List;

/**
 * Created by gq on 2015/12/8.
 * 不予受理决定书材料
 */
public enum SgPermitNotAcceptMat {
    NOT_ACCEPT_1(1, "该事项不属于本行政机关职权范围；"),
    NOT_ACCEPT_2(2, "申请人隐瞒有关情况、提供虚假材料；"),
    NOT_ACCEPT_3(3, "不具备法定的申请主体资格；"),
    NOT_ACCEPT_4(4, "申请材料仍不齐全/不符合法定形式；"),
    NOT_ACCEPT_5(5, "（法律、法规、规章规定的其他不予受理的情形）。");

    private int code;
    private String name;

    private SgPermitNotAcceptMat(int code, String name) {
        this.code = code;
        this.name = name;
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

    /**
     * 获取下拉框
     *
     * @param selectValue .
     * @return .
     */
    public static String getOptions(String selectValue) {
        SgPermitNotAcceptMat[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
