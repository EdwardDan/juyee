package com.justonetech.expert.util;

public enum ExpertApprovalStatus {

	STATUS_HX(1, "候选", "red", "hx"),
    STATUS_YB(2, "预备", "blue", "yb"),
    STATUS_ZS(3, "正式", "green", "zs");
	
	private int code;
	private String name;
	private String color;
	private String stepCode;

	private ExpertApprovalStatus(int code, String name, String color,
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
		for (ExpertApprovalStatus aType : values()) {
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
		for (ExpertApprovalStatus aType : values()) {
			if (aType.getCode() == code)
				return aType.getStepCode();
		}
		return null;
	}

	public static String getColorNameByCode(int code) {
		for (ExpertApprovalStatus aType : values()) {
			if (aType.getCode() == code)
				return "<font color=" + aType.getColor() + ">"
						+ aType.getName() + "</font>";
		}
		return null;
	}

}
