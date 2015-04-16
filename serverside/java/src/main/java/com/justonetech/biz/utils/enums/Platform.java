package com.justonetech.biz.utils.enums;

/**
 * 所属平台——OA、业务管理
 * User: Chen Junping
 * Date: 12-6-12
 */
public enum Platform {
    PLATFORM_OA("oa", "OA管理"),
    PLATFORM_BIZ("biz", "业务管理");

    private String code;
    private String name;

    Platform(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
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
        for (Platform aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }
}
