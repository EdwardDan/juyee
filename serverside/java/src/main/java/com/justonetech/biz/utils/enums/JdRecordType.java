package com.justonetech.biz.utils.enums;

/**
 * description: (新)监督记录类别--类别编码
 * User: Chenjp
 * Date: 14-01-02 下午17:36
 */
public enum JdRecordType {
    TYPE_FIRST("first", "首次监督", "SC", "JD_RECORD_FIRST"),
    TYPE_SAFE("safe", "过程安全监督", "AQ", "JD_RECORD_SAFE"),
    TYPE_QUALITY("quality", "过程质量监督", "ZL", "JD_RECORD_QUALITY"),
    TYPE_COMPLETE("complete", "竣工验收监督", "JG", "JD_RECORD_COMPLETE");

    private String code;  //类别编码--对应字段：JD_RECORD_QUESTION.JD_TYPE_CODE
    private String name;  //类别名称
    private String prefix; //类别前缀--用于编号自动生成
    private String tableName; //类别前缀--用于编号自动生成

    private JdRecordType(String code, String name, String prefix, String tableName) {
        this.code = code;
        this.name = name;
        this.prefix = prefix;
        this.tableName = tableName;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getTableName() {
        return tableName;
    }

    /**
     * 获取监督类别名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(String code) {
        for (JdRecordType aType : values()) {
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
    public static String getPrefixByCode(String code) {
        for (JdRecordType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getPrefix();
        }
        return null;
    }

    /**
     * 获取数据库名
     *
     * @param code .
     * @return .
     */
    public static String getTableNameByCode(String code) {
        for (JdRecordType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getTableName();
        }
        return null;
    }
}
