package com.justonetech.eca.model;

public class CECreditAssessment {
	private String enterpriseName;//企业名称
	private String enterpriseCode;//企业组织机构代码
	private String ultoReportId;//上月报告Id
	private String ultoScore;//上月评分
	private String ultoScoreBaseDate;//上月评分基准日
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getEnterpriseCode() {
		return enterpriseCode;
	}
	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}
	public String getUltoReportId() {
		return ultoReportId;
	}
	public void setUltoReportId(String ultoReportId) {
		this.ultoReportId = ultoReportId;
	}
	public String getUltoScore() {
		return ultoScore;
	}
	public void setUltoScore(String ultoScore) {
		this.ultoScore = ultoScore;
	}
	public String getUltoScoreBaseDate() {
		return ultoScoreBaseDate;
	}
	public void setUltoScoreBaseDate(String ultoScoreBaseDate) {
		this.ultoScoreBaseDate = ultoScoreBaseDate;
	}
	
}
