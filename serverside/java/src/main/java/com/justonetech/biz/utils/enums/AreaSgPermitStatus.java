package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 区县施工许可状态
 * Created by gq on 2016/3/9.
 */
public enum AreaSgPermitStatus {
    STATUS_EDIT(1, "未提交", "red", "tx"),
    STATUS_SUBMIT(2, "已提交", "blue", "submit"),
    STATUS_JGZX_YS_PASS(3, "预审通过", "blue", "ys_pass"),
    STATUS_JGZX_YS_BACK(4, "预审退回", "blue", "ys_back"),
    STATUS_SLZX_PASS(5, "收件通过", "green", "sj_pass"),
    STATUS_SLZX_BACK(6, "收件退回", "red", "sj_back"),
    STATUS_CS_PASS(7, "受理通过", "green", "sl_pass"),
    STATUS_CS_BACK(8, "受理退回", "red", "sl_back"),
    STATUS_FH_PASS(9, "审核通过", "green", "sh_pass"),
    STATUS_FH_BACK(10, "审核退回", "red", "sh_back"),
    STATUS_SH_PASS(11, "审批通过", "green", "sp_pass"),
    STATUS_SH_BACK(12, "审批退回", "red", "sp_back");

    private int code;
    private String name;
    private String color;
    private String stepCode;

    private AreaSgPermitStatus(int code, String name, String color, String stepCode) {
        this.code = code;
        this.name = name;
        this.color = color;
        this.stepCode = stepCode;
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

    public String getStepCode() {
        return stepCode;
    }

    public void setStepCode(String stepCode) {
        this.stepCode = stepCode;
    }

    /**
     * 获取名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(int code) {
        for (AreaSgPermitStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }

    /**
     * 获取typecode
     *
     * @param code .
     * @return .
     */
    public static String getTypeCode(int code) {
        for (AreaSgPermitStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getStepCode();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (AreaSgPermitStatus aType : values()) {
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
        AreaSgPermitStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
