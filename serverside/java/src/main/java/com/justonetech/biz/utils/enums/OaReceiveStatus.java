package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;
//收文步骤  存在OaReceiveStep表中
public enum OaReceiveStatus {
    OA_RECEIVE_SWDJ("swdj", "收文登记", "red"),
    OA_RECEIVE_BGSNB("bgsnb", "办公室拟办", "blue"),
    OA_RECEIVE_LDPS("ldps", "领导批示", "purple"),
    OA_RECEIVE_BMLDYJ("bmldyj", "部门领导意见", "red"),
    OA_RECEIVE_BLJG("bljg", "办理结果", "green"),
    OA_RECEIVE_CB("cb", "催办", "red"),
    OA_RECEIVE_SWWC("swwc", "收文完成", "green");


    private String code;
    private String name;
    private String color;

    private OaReceiveStatus(String code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
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
    public static String getNameByCode(String code) {
        for (OaReceiveStatus aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }

    public static String getColorNameByCode(String code) {//获取状态名颜色
        for (OaReceiveStatus aType : values()) {
            if (aType.getCode().equals(code))
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
        OaReceiveStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
