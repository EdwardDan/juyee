package com.justonetech.cp.util;


/**
 * 区县施工许可状态
 * Created by gq on 2016/3/9.
 */
public enum CountyPermitStatus {
	STATUS_WZ(0, "未知", "yellow", "wz"),
    STATUS_EDIT(1, "填写", "red", "tx"),
    STATUS_SB(2, "已上报", "blue", "submit"),
    STATUS_SJ_PASS(3, "收件通过", "green", "sj_pass"),
    STATUS_SJ_BACK(4, "收件退回", "red", "sj_back"),
    STATUS_SL_PASS(5, "受理通过", "green", "sl_pass"),
    STATUS_SH_PASS(6, "审核通过", "green", "sh_pass"),
    STATUS_SP_PASS(7, "审批通过", "green", "sp_pass"),
    STATUS_SP_BACK(8, "审批退回", "red", "sp_back"),
	STATUS_BZ_BACK(9, "补正退回", "red", "bz_back");

	private int code;
	private String name;
	private String color;
	private String stepCode;

	private CountyPermitStatus(int code, String name, String color,
			String stepCode) {
		this.code = code;
		this.name = name;
		this.color = color;
		this.stepCode = stepCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStepCode() {
		return stepCode;
	}

	public void setStepCode(String stepCode) {
		this.stepCode = stepCode;
	}

	/**
	 * 获取名称
	 *
	 * @param code
	 *            .
	 * @return .
	 */
	public static String getNameByCode(int code) {
		for (CountyPermitStatus aType : values()) {
			if (aType.getCode() == code)
				return aType.getName();
		}
		return null;
	}

	/**
	 * 获取typecode
	 *
	 * @param code
	 *            .
	 * @return .
	 */
	public static String getTypeCode(int code) {
		for (CountyPermitStatus aType : values()) {
			if (aType.getCode() == code)
				return aType.getStepCode();
		}
		return null;
	}

	public static String getColorNameByCode(int code) {
		for (CountyPermitStatus aType : values()) {
			if (aType.getCode() == code)
				return "<font color=" + aType.getColor() + ">"
						+ aType.getName() + "</font>";
		}
		return null;
	}

	// /**
	// * 获取下拉框
	// *
	// * @param selectValue .
	// * @return .
	// */
	// public static String getOptions(String selectValue) {
	// CountyPermitStatus[] statuses = values();
	//
	// String[] names = new String[statuses.length];
	// String[] values = new String[statuses.length];
	// for (int i = 0; i < (statuses.length); i++) {
	// names[i] = statuses[i].getName();
	// values[i] = String.valueOf(statuses[i].getCode());
	// }
	// return JspHelper.getOptionString(names, values, selectValue);
	// }
}
