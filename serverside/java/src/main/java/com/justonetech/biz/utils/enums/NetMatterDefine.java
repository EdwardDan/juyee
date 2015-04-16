package com.justonetech.biz.utils.enums;

/**
 * description: 项目审批--审批事项定义
 */
public enum NetMatterDefine {
    MATTER_APPLY("NetApply", "项目报建"),
    MATTER_CFB_PUBLIC("NetCfb_public", "承发包(公开招标)"),
    MATTER_CFB_DIRECT("NetCfb_direct", "承发包(直接发包)"),
    MATTER_CONTRACT("NetContract", "合同备案"),
    MATTER_MONITOR("NetMonitor", "项目报监"),
    MATTER_SGPERMIT("NetSgpermit", "施工许可");

    private String code;  //事项编码
    private String name;  //事项名称


    private NetMatterDefine(String code, String name) {
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
     * 获取事项名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(String code) {
        for (NetMatterDefine aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }
}
