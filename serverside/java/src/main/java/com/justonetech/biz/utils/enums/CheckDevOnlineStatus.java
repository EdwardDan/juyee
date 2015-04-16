package com.justonetech.biz.utils.enums;

import com.justonetech.core.utils.JspHelper;

/**
 * 考勤设备联机状态
 * User: Chen Junping
 * Date: 12-8-27
 */
public enum CheckDevOnlineStatus {
    STATUS_ONLINE(1L, "联机"),
    STATUS_OFFLINE(2L, "离线");

    private Long code;
    private String name;

    private CheckDevOnlineStatus(Long code, String name) {
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
        for (CheckDevOnlineStatus aType : values()) {
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
        CheckDevOnlineStatus[] statuses = values();

        String[] names = new String[statuses.length];
        String[] values = new String[statuses.length];
        for (int i = 0; i < (statuses.length); i++) {
            names[i] = statuses[i].getName();
            values[i] = String.valueOf(statuses[i].getCode());
        }
        return JspHelper.getOptionString(names, values, selectValue);
    }
}
