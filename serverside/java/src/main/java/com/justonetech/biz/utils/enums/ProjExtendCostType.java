package com.justonetech.biz.utils.enums;

/**
 * Created with IntelliJ IDEA.
 * User: gq
 * Date: 15-8-21
 */
public enum ProjExtendCostType {
    EXTEND_TYPE_1("hospitalAccCost","历年累计完成投资"),
    EXTEND_TYPE_2("yearCostPlanCost","年度投资计划"),
    EXTEND_TYPE_3("currentAccCost","当年累计完成投资额"),
    EXTEND_TYPE_4("financeCost","财政资金");

    private String code;
    private String name;

     ProjExtendCostType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取名称
     *
     * @param code .
     * @return .
     */
    public static String getNameByCode(String code) {
        for (ProjExtendCostType aType : values()) {
            if (aType.getCode().equals(code))
                return aType.getName();
        }
        return null;
    }
}
