package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 施工许可管理状态
 * User: gq
 * Date: 15-11-9
 */
public enum SgPermitStatus {
    STATUS_CH(0, "撤回", "red", "ch"),
    STATUS_EDIT(1, "未提交", "red", "tx"),
    STATUS_SUBMIT(2, "已提交", "blue", "submit"),
    STATUS_JGZX_YS_PASS(3, "预审通过(请到行政服务中心受理)", "blue", "jgzx_ys_pass"),
    STATUS_JGZX_YS_BACK(4, "预审退回", "blue", "jgzx_ys_back"),
    STATUS_SLZX_PASS(5, "收件通过", "green", "slzx_pass"),
    STATUS_SLZX_BACK(6, "收件退回", "red", "slzx_back"),
    STATUS_CS_PASS(7, "初审通过", "green", "cs_pass"),
    STATUS_CS_BACK(8, "初审退回", "red", "cs_back"),
    STATUS_FH_PASS(9, "复核通过", "green", "fh_pass"),
    STATUS_FH_BACK(10, "复核退回", "red", "fh_back"),
    STATUS_SH_PASS(11, "审核通过", "green", "sh_pass"),
    STATUS_SH_BACK(12, "审核退回", "red", "sh_back"),
    STATUS_FGLD_PASS(13, "分管领导审核通过", "green", "fgldsh_pass"),
    STATUS_FGLD_BACK(14, "分管领导审核退回", "red", "fgldsh_back"),
    STATUS_ZXLD_PASS(15, "中心领导审核通过", "green", "fgldsh_pass"),
    STATUS_ZXLD_BACK(16, "中心领导审核退回", "red", "zxldsh_back"),
    STATUS_JSC_XK(17, "建设处许可", "green", "jscsh_xk"),
    STATUS_JSC_BXK(18, "建设处不许可", "red", "jscsh_bxk"),
    STATUS_JSC_BACK(19, "建设处审核退回", "red", "jscsh_back"),
    STATUS_SPC_XK(20, "审批处许可", "green", "spcsh_xk"),
    STATUS_SPC_BXK(21, "审批处不许可", "red", "spcsh_bxk"),
    STATUS_SPC_BACK(22, "审批处审核退回", "red", "spcsh_back"),
    STATUS_WLD_PASS(23, "委领导许可", "green", "wldsh_pass"),
    STATUS_WLD_BACK(24, "委领导不许可", "red", "wldsh_back");

    private int code;
    private String name;
    private String color;
    private String stepCode;

    private SgPermitStatus(int code, String name, String color, String stepCode) {
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
        for (SgPermitStatus aType : values()) {
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
        for (SgPermitStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getStepCode();
        }
        return null;
    }

    public static String getColorNameByCode(int code) {
        for (SgPermitStatus aType : values()) {
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
        SgPermitStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
