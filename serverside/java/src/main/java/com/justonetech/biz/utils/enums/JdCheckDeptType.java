package com.justonetech.biz.utils.enums;

/**
 * description: (新)监督整改/暂缓施工/停工单--类别定义
 * User: wangfei
 * Date: 14-01-06 下午18:11
 */
public enum JdCheckDeptType {
    TYPE_SGZB(1, "施工总包单位"),
    TYPE_JLDW(2, "监理单位"),
    TYPE_JSDW(3, "建设单位"),
    TYPE_OTHER(4, "其他");

    private int code;  //类别编码
    private String name;  //类别名称


    private JdCheckDeptType(int code, String name) {
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
     * 获取监督类别名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(int code) {
        for (JdCheckDeptType aType : values()) {
            if (aType.getCode()== code)
                return aType.getName();
        }
        return null;
    }

    /**
     * 获取监督类别名称数组
     *
     * @return
     */
    public static String[] getNames(){
        JdCheckDeptType[] jdRecordTypes = values();
        String[] names = new String[jdRecordTypes.length];
        for (int i = 0; i < (jdRecordTypes.length); i++) {
            names[i] = String.valueOf(jdRecordTypes[i].getName());
        }
        return names;
    }
}
