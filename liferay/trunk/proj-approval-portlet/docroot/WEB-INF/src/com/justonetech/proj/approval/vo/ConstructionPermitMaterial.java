package com.justonetech.proj.approval.vo;

public class ConstructionPermitMaterial {
	
	private long id;//id
	private long dictionaryId;//项目类型的系统字典id
	private long type;//材料类型
	private int sortNo;//序号
	private String materialName;//材料名称
	private String auditReq;//审核要求
	private String auditReqGreen;//绿色审核要求
	private int yjNum;//应交份数
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDictionaryId() {
		return dictionaryId;
	}
	public void setDictionaryId(long dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getAuditReq() {
		return auditReq;
	}
	public void setAuditReq(String auditReq) {
		this.auditReq = auditReq;
	}
	public String getAuditReqGreen() {
		return auditReqGreen;
	}
	public void setAuditReqGreen(String auditReqGreen) {
		this.auditReqGreen = auditReqGreen;
	}
	public int getSortNo() {
		return sortNo;
	}
	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}
	public int getYjNum() {
		return yjNum;
	}
	public void setYjNum(int yjNum) {
		this.yjNum = yjNum;
	}

	
	
}
