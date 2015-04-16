package com.justonetech.biz.utils.enums;

/**
 * description: 项目承发包--招标方式
 */
public enum NetCfbBidMethod {
    MTHOD_PUBLIC("public", "公开招标"),
    MTHOD_DIRECT("direct", "直接发包");

    private String code;  //类别编码
    private String name;  //类别名称


    private NetCfbBidMethod(String code, String name) {
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
     * 获取类别名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(String code) {
        for (NetCfbBidMethod aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }
}
