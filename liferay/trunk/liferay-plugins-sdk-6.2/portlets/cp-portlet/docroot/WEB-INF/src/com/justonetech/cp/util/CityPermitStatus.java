package com.justonetech.cp.util;

/**
 * 施工许可管理状态
 */
public enum CityPermitStatus {
	STATUS_WZ(0, "未知", "yellow", "wz"),
    STATUS_EDIT(1, "填写", "red", "tx"),
    STATUS_SB(2, "已上报", "blue", "submit"),
    STATUS_YS_PASS(3, "预审通过(请到行政服务中心受理)", "blue", "jgzx_ys_pass"),
    STATUS_YS_BACK(4, "预审退回", "blue", "jgzx_ys_back"),
    STATUS_SJ_PASS(5, "收件通过", "green", "slzx_pass"),
    STATUS_SJ_BACK(6, "收件退回", "red", "slzx_back"),
    STATUS_CS_PASS(7, "初审通过", "green", "cs_pass"),
    STATUS_FH_PASS(8, "复核通过", "green", "fh_pass"),
    STATUS_SH_PASS(9, "审核通过", "green", "sh_pass"),
    STATUS_SH_BACK(10, "审核退回", "red", "sh_back"),
    STATUS_FGLD_PASS(11, "分管领导审核通过", "green", "fgldsh_pass"),
    STATUS_FGLD_BACK(12, "分管领导审核退回", "red", "fgldsh_back"),
    STATUS_ZXLD_PASS(13, "中心领导审核通过", "green", "fgldsh_pass"),
    STATUS_ZXLD_BACK(14, "中心领导审核退回", "red", "zxldsh_back"),
    STATUS_JSC_XK(15, "建设处许可", "green", "jscsh_xk"),
    STATUS_JSC_BXK(16, "建设处不许可", "red", "jscsh_bxk"),
    STATUS_JSC_BACK(17, "建设处审核退回", "red", "jscsh_back"),
    STATUS_SPC_XK(18, "审批处许可", "green", "spcsh_xk"),
    STATUS_SPC_BXK(19, "审批处不许可", "red", "spcsh_bxk"),
    STATUS_SPC_BACK(20, "审批处审核退回", "red", "spcsh_back"),
    STATUS_WLD_PASS(21, "委领导许可", "green", "wldsh_pass"),
    STATUS_WLD_BACK(22, "委领导不许可", "red", "wldsh_back"),
	STATUS_BZ_BACK(23, "补正退回", "red", "bz_back"),
	STATUS_NB_BACK(24, "内部退回", "red", "nb_back");

	private int code;
	private String name;
	private String color;
	private String stepCode;

	private CityPermitStatus(int code, String name, String color,
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
		for (CityPermitStatus aType : values()) {
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
		for (CityPermitStatus aType : values()) {
			if (aType.getCode() == code)
				return aType.getStepCode();
		}
		return null;
	}

	public static String getColorNameByCode(int code) {
		for (CityPermitStatus aType : values()) {
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
	// SgPermitStatus[] statuses = values();
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
