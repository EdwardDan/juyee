package com.justonetech.biz.utils.enums;

/**
 * description:   邮件接收类型（TO接收/CC抄送）
 * User: Chenjp
 * Date: 14-3-28 下午4:23
 */
public enum OaMailReceiveType {
    TYPE_TO("to", "收件"),
    TYPE_CC("cc", "抄送");

    private String code;
    private String name;

    OaMailReceiveType(String code, String name) {
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
        for (OaMailReceiveType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }
}
