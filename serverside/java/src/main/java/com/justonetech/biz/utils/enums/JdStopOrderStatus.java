package com.justonetech.biz.utils.enums;

/**
 * description: (新)监督指令单状态
 * User: Chenjp
 * Date: 14-01-07 上午09:30
 */
public enum JdStopOrderStatus {
    STATUS_EDIT(1, "填写"),
    STATUS_UNREFORMED(2, "整改中"),
    STATUS_REFORMED(3, "已经整改");

    private int code;
    private String name;

    JdStopOrderStatus(int code, String name) {
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
        for (JdStopOrderStatus aType : values()) {
            if (aType.getCode() == code)
                return aType.getName();
        }
        return null;
    }
}
