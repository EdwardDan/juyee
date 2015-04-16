package com.justonetech.biz.utils.enums;

/**
 * description: (新)监督整改/暂缓施工/停工单--类别定义
 * User: Chenjp
 * Date: 14-01-06 下午18:11
 */
public enum JdStopOrderType {
    TYPE_REFORM("reform", "整改指令单", "静安质监（{0}）整字[{1}]号"),
    TYPE_SUSPEND("suspend", "局部暂缓施工指令单", "静安质监（{0}）缓字[{1}]号"),
    TYPE_STOP("stop", "停工指令单", "静安质监（{0}）停字[{1}]号");

    private String code;  //类别编码
    private String name;  //类别名称
    private String serialDesc; //编号中文描述

    private JdStopOrderType(String code, String name, String serialDesc) {
        this.code = code;
        this.name = name;
        this.serialDesc = serialDesc;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSerialDesc() {
        return serialDesc;
    }

    /**
     * 获取监督类别名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(String code) {
        for (JdStopOrderType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }

    /**
     * 获取编码前缀
     *
     * @param code .
     * @return .
     */
    public static String getSerialDescByCode(String code) {
        for (JdStopOrderType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getSerialDesc();
        }
        return null;
    }

    /**
     * 根据code取得首字母大写
     * @param code .
     * @return .
     */
    public static String getFileName(String code){
         return code.substring(0,1).toUpperCase()+code.substring(1);
    }
}
