package com.justonetech.proj.approval.vo;

import java.util.Date;

public class ConstructionPermitApplication {

	private  long  constructionPermitId;
//	设计单位
	private String designCompany;//设计单位
	private String designTenderMethod;//招标方式
	private Double designBidPrice;//中标价
	private String designQualificationLevel;//资质等级
	private String designLevelCertificateCode;//证书编号
	private String designProjectLeader;//项目负责人
	private String designLeaderCertificateCode;//证书编号
	
//	监理单位
	private String supervisionCompany;//设计单位
	private String supervisionTenderMethod;//招标方式
	private Double supervisionBidPrice;//中标价
	private String supervisionQualificationLevel;//资质等级
	private String supervisionLevelCertificateCode;//证书编号
	private String supervisionProjectLeader;//项目负责人
	private String supervisionLeaderCertificateCode;//证书编号
	
	
//	施工单位
	private String constructionCompany;//设计单位
	private String constructionTenderMethod;//招标方式
	private Double constructionBidPrice;//中标价
	private String constructionQualificationLevel;//资质等级
	private String constructionLevelCertificateCode;//证书编号
	private String constructionProjectLeader;//项目负责人
	private String constructionLeaderCertificateCode;//证书编号
	
//	建设依据
	private String feasibilityApprovalOrganAndNumber;//工可批准或核准机关和文号
	private Date feasibilityReplyDate;//批复或核准日期
	private String initialDesignApprovalOrganAndNumber;//初步设计批准机关和文号
	private Double investmentEstimation;//投资估算
	private Date initialDesignReplyDate;//批复日期
	private String replyProject;//批复工程
	private Double totalBudget;//总概算
	private String constructionDrawingApprovalOrganAndNumber;//施工图审批批准机关和文号
	private String investmentSource;//投资来源
	
//新增项	
	private String projManager;//项目经理
	private String projDirector;//项目总监
	public long getConstructionPermitId() {
		return constructionPermitId;
	}
	public void setConstructionPermitId(long constructionPermitId) {
		this.constructionPermitId = constructionPermitId;
	}
	public String getDesignCompany() {
		return designCompany;
	}
	public void setDesignCompany(String designCompany) {
		this.designCompany = designCompany;
	}
	public String getDesignTenderMethod() {
		return designTenderMethod;
	}
	public void setDesignTenderMethod(String designTenderMethod) {
		this.designTenderMethod = designTenderMethod;
	}
	public Double getDesignBidPrice() {
		return designBidPrice;
	}
	public void setDesignBidPrice(Double designBidPrice) {
		this.designBidPrice = designBidPrice;
	}
	public String getDesignQualificationLevel() {
		return designQualificationLevel;
	}
	public void setDesignQualificationLevel(String designQualificationLevel) {
		this.designQualificationLevel = designQualificationLevel;
	}
	public String getDesignLevelCertificateCode() {
		return designLevelCertificateCode;
	}
	public void setDesignLevelCertificateCode(String designLevelCertificateCode) {
		this.designLevelCertificateCode = designLevelCertificateCode;
	}
	public String getDesignProjectLeader() {
		return designProjectLeader;
	}
	public void setDesignProjectLeader(String designProjectLeader) {
		this.designProjectLeader = designProjectLeader;
	}
	public String getDesignLeaderCertificateCode() {
		return designLeaderCertificateCode;
	}
	public void setDesignLeaderCertificateCode(String designLeaderCertificateCode) {
		this.designLeaderCertificateCode = designLeaderCertificateCode;
	}
	public String getSupervisionCompany() {
		return supervisionCompany;
	}
	public void setSupervisionCompany(String supervisionCompany) {
		this.supervisionCompany = supervisionCompany;
	}
	public String getSupervisionTenderMethod() {
		return supervisionTenderMethod;
	}
	public void setSupervisionTenderMethod(String supervisionTenderMethod) {
		this.supervisionTenderMethod = supervisionTenderMethod;
	}
	public Double getSupervisionBidPrice() {
		return supervisionBidPrice;
	}
	public void setSupervisionBidPrice(Double supervisionBidPrice) {
		this.supervisionBidPrice = supervisionBidPrice;
	}
	public String getSupervisionQualificationLevel() {
		return supervisionQualificationLevel;
	}
	public void setSupervisionQualificationLevel(String supervisionQualificationLevel) {
		this.supervisionQualificationLevel = supervisionQualificationLevel;
	}
	public String getSupervisionLevelCertificateCode() {
		return supervisionLevelCertificateCode;
	}
	public void setSupervisionLevelCertificateCode(String supervisionLevelCertificateCode) {
		this.supervisionLevelCertificateCode = supervisionLevelCertificateCode;
	}
	public String getSupervisionProjectLeader() {
		return supervisionProjectLeader;
	}
	public void setSupervisionProjectLeader(String supervisionProjectLeader) {
		this.supervisionProjectLeader = supervisionProjectLeader;
	}
	public String getSupervisionLeaderCertificateCode() {
		return supervisionLeaderCertificateCode;
	}
	public void setSupervisionLeaderCertificateCode(String supervisionLeaderCertificateCode) {
		this.supervisionLeaderCertificateCode = supervisionLeaderCertificateCode;
	}
	public String getConstructionCompany() {
		return constructionCompany;
	}
	public void setConstructionCompany(String constructionCompany) {
		this.constructionCompany = constructionCompany;
	}
	public String getConstructionTenderMethod() {
		return constructionTenderMethod;
	}
	public void setConstructionTenderMethod(String constructionTenderMethod) {
		this.constructionTenderMethod = constructionTenderMethod;
	}
	public Double getConstructionBidPrice() {
		return constructionBidPrice;
	}
	public void setConstructionBidPrice(Double constructionBidPrice) {
		this.constructionBidPrice = constructionBidPrice;
	}
	public String getConstructionQualificationLevel() {
		return constructionQualificationLevel;
	}
	public void setConstructionQualificationLevel(String constructionQualificationLevel) {
		this.constructionQualificationLevel = constructionQualificationLevel;
	}
	public String getConstructionLevelCertificateCode() {
		return constructionLevelCertificateCode;
	}
	public void setConstructionLevelCertificateCode(String constructionLevelCertificateCode) {
		this.constructionLevelCertificateCode = constructionLevelCertificateCode;
	}
	public String getConstructionProjectLeader() {
		return constructionProjectLeader;
	}
	public void setConstructionProjectLeader(String constructionProjectLeader) {
		this.constructionProjectLeader = constructionProjectLeader;
	}
	public String getConstructionLeaderCertificateCode() {
		return constructionLeaderCertificateCode;
	}
	public void setConstructionLeaderCertificateCode(String constructionLeaderCertificateCode) {
		this.constructionLeaderCertificateCode = constructionLeaderCertificateCode;
	}
	public String getFeasibilityApprovalOrganAndNumber() {
		return feasibilityApprovalOrganAndNumber;
	}
	public void setFeasibilityApprovalOrganAndNumber(String feasibilityApprovalOrganAndNumber) {
		this.feasibilityApprovalOrganAndNumber = feasibilityApprovalOrganAndNumber;
	}
	public Date getFeasibilityReplyDate() {
		return feasibilityReplyDate;
	}
	public void setFeasibilityReplyDate(Date feasibilityReplyDate) {
		this.feasibilityReplyDate = feasibilityReplyDate;
	}
	public String getInitialDesignApprovalOrganAndNumber() {
		return initialDesignApprovalOrganAndNumber;
	}
	public void setInitialDesignApprovalOrganAndNumber(String initialDesignApprovalOrganAndNumber) {
		this.initialDesignApprovalOrganAndNumber = initialDesignApprovalOrganAndNumber;
	}
	public Double getInvestmentEstimation() {
		return investmentEstimation;
	}
	public void setInvestmentEstimation(Double investmentEstimation) {
		this.investmentEstimation = investmentEstimation;
	}
	public Date getInitialDesignReplyDate() {
		return initialDesignReplyDate;
	}
	public void setInitialDesignReplyDate(Date initialDesignReplyDate) {
		this.initialDesignReplyDate = initialDesignReplyDate;
	}
	public String getReplyProject() {
		return replyProject;
	}
	public void setReplyProject(String replyProject) {
		this.replyProject = replyProject;
	}
	public Double getTotalBudget() {
		return totalBudget;
	}
	public void setTotalBudget(Double totalBudget) {
		this.totalBudget = totalBudget;
	}
	public String getConstructionDrawingApprovalOrganAndNumber() {
		return constructionDrawingApprovalOrganAndNumber;
	}
	public void setConstructionDrawingApprovalOrganAndNumber(String constructionDrawingApprovalOrganAndNumber) {
		this.constructionDrawingApprovalOrganAndNumber = constructionDrawingApprovalOrganAndNumber;
	}
	public String getInvestmentSource() {
		return investmentSource;
	}
	public void setInvestmentSource(String investmentSource) {
		this.investmentSource = investmentSource;
	}
	public String getProjManager() {
		return projManager;
	}
	public void setProjManager(String projManager) {
		this.projManager = projManager;
	}
	public String getProjDirector() {
		return projDirector;
	}
	public void setProjDirector(String projDirector) {
		this.projDirector = projDirector;
	}

}
