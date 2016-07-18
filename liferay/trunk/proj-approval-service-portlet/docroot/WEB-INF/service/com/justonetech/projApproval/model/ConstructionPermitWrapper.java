/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.justonetech.projApproval.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConstructionPermit}.
 * </p>
 *
 * @author justonetech
 * @see ConstructionPermit
 * @generated
 */
public class ConstructionPermitWrapper implements ConstructionPermit,
	ModelWrapper<ConstructionPermit> {
	public ConstructionPermitWrapper(ConstructionPermit constructionPermit) {
		_constructionPermit = constructionPermit;
	}

	@Override
	public Class<?> getModelClass() {
		return ConstructionPermit.class;
	}

	@Override
	public String getModelClassName() {
		return ConstructionPermit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("constructionPermitId", getConstructionPermitId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("projType", getProjType());
		attributes.put("projProperty", getProjProperty());
		attributes.put("county", getCounty());
		attributes.put("constructionCode", getConstructionCode());
		attributes.put("bidingCode", getBidingCode());
		attributes.put("businessCode", getBusinessCode());
		attributes.put("projName", getProjName());
		attributes.put("company", getCompany());
		attributes.put("companyProperty", getCompanyProperty());
		attributes.put("companyAddress", getCompanyAddress());
		attributes.put("legalPerson", getLegalPerson());
		attributes.put("companyTel", getCompanyTel());
		attributes.put("companyContacts", getCompanyContacts());
		attributes.put("companyContactPhone", getCompanyContactPhone());
		attributes.put("companySite", getCompanySite());
		attributes.put("engineerCategory", getEngineerCategory());
		attributes.put("engineerAttribute", getEngineerAttribute());
		attributes.put("engineerScale", getEngineerScale());
		attributes.put("nationalFundsPer", getNationalFundsPer());
		attributes.put("contractPrice", getContractPrice());
		attributes.put("contractSchedule", getContractSchedule());
		attributes.put("bidPrice", getBidPrice());
		attributes.put("investBudget", getInvestBudget());
		attributes.put("planStartDate", getPlanStartDate());
		attributes.put("planEndDate", getPlanEndDate());
		attributes.put("workSituation", getWorkSituation());
		attributes.put("otherInfo", getOtherInfo());
		attributes.put("applyMaterial", getApplyMaterial());
		attributes.put("receiptNum", getReceiptNum());
		attributes.put("certificationDate", getCertificationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long constructionPermitId = (Long)attributes.get("constructionPermitId");

		if (constructionPermitId != null) {
			setConstructionPermitId(constructionPermitId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createTime = (Date)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Date modifiedTime = (Date)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
		}

		Long projType = (Long)attributes.get("projType");

		if (projType != null) {
			setProjType(projType);
		}

		Long projProperty = (Long)attributes.get("projProperty");

		if (projProperty != null) {
			setProjProperty(projProperty);
		}

		Long county = (Long)attributes.get("county");

		if (county != null) {
			setCounty(county);
		}

		String constructionCode = (String)attributes.get("constructionCode");

		if (constructionCode != null) {
			setConstructionCode(constructionCode);
		}

		String bidingCode = (String)attributes.get("bidingCode");

		if (bidingCode != null) {
			setBidingCode(bidingCode);
		}

		String businessCode = (String)attributes.get("businessCode");

		if (businessCode != null) {
			setBusinessCode(businessCode);
		}

		String projName = (String)attributes.get("projName");

		if (projName != null) {
			setProjName(projName);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String companyProperty = (String)attributes.get("companyProperty");

		if (companyProperty != null) {
			setCompanyProperty(companyProperty);
		}

		String companyAddress = (String)attributes.get("companyAddress");

		if (companyAddress != null) {
			setCompanyAddress(companyAddress);
		}

		String legalPerson = (String)attributes.get("legalPerson");

		if (legalPerson != null) {
			setLegalPerson(legalPerson);
		}

		String companyTel = (String)attributes.get("companyTel");

		if (companyTel != null) {
			setCompanyTel(companyTel);
		}

		String companyContacts = (String)attributes.get("companyContacts");

		if (companyContacts != null) {
			setCompanyContacts(companyContacts);
		}

		String companyContactPhone = (String)attributes.get(
				"companyContactPhone");

		if (companyContactPhone != null) {
			setCompanyContactPhone(companyContactPhone);
		}

		String companySite = (String)attributes.get("companySite");

		if (companySite != null) {
			setCompanySite(companySite);
		}

		String engineerCategory = (String)attributes.get("engineerCategory");

		if (engineerCategory != null) {
			setEngineerCategory(engineerCategory);
		}

		Long engineerAttribute = (Long)attributes.get("engineerAttribute");

		if (engineerAttribute != null) {
			setEngineerAttribute(engineerAttribute);
		}

		String engineerScale = (String)attributes.get("engineerScale");

		if (engineerScale != null) {
			setEngineerScale(engineerScale);
		}

		String nationalFundsPer = (String)attributes.get("nationalFundsPer");

		if (nationalFundsPer != null) {
			setNationalFundsPer(nationalFundsPer);
		}

		Double contractPrice = (Double)attributes.get("contractPrice");

		if (contractPrice != null) {
			setContractPrice(contractPrice);
		}

		Double contractSchedule = (Double)attributes.get("contractSchedule");

		if (contractSchedule != null) {
			setContractSchedule(contractSchedule);
		}

		Double bidPrice = (Double)attributes.get("bidPrice");

		if (bidPrice != null) {
			setBidPrice(bidPrice);
		}

		Double investBudget = (Double)attributes.get("investBudget");

		if (investBudget != null) {
			setInvestBudget(investBudget);
		}

		Date planStartDate = (Date)attributes.get("planStartDate");

		if (planStartDate != null) {
			setPlanStartDate(planStartDate);
		}

		Date planEndDate = (Date)attributes.get("planEndDate");

		if (planEndDate != null) {
			setPlanEndDate(planEndDate);
		}

		String workSituation = (String)attributes.get("workSituation");

		if (workSituation != null) {
			setWorkSituation(workSituation);
		}

		String otherInfo = (String)attributes.get("otherInfo");

		if (otherInfo != null) {
			setOtherInfo(otherInfo);
		}

		String applyMaterial = (String)attributes.get("applyMaterial");

		if (applyMaterial != null) {
			setApplyMaterial(applyMaterial);
		}

		String receiptNum = (String)attributes.get("receiptNum");

		if (receiptNum != null) {
			setReceiptNum(receiptNum);
		}

		Date certificationDate = (Date)attributes.get("certificationDate");

		if (certificationDate != null) {
			setCertificationDate(certificationDate);
		}
	}

	/**
	* Returns the primary key of this construction permit.
	*
	* @return the primary key of this construction permit
	*/
	@Override
	public long getPrimaryKey() {
		return _constructionPermit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this construction permit.
	*
	* @param primaryKey the primary key of this construction permit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_constructionPermit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the construction permit ID of this construction permit.
	*
	* @return the construction permit ID of this construction permit
	*/
	@Override
	public long getConstructionPermitId() {
		return _constructionPermit.getConstructionPermitId();
	}

	/**
	* Sets the construction permit ID of this construction permit.
	*
	* @param constructionPermitId the construction permit ID of this construction permit
	*/
	@Override
	public void setConstructionPermitId(long constructionPermitId) {
		_constructionPermit.setConstructionPermitId(constructionPermitId);
	}

	/**
	* Returns the user ID of this construction permit.
	*
	* @return the user ID of this construction permit
	*/
	@Override
	public long getUserId() {
		return _constructionPermit.getUserId();
	}

	/**
	* Sets the user ID of this construction permit.
	*
	* @param userId the user ID of this construction permit
	*/
	@Override
	public void setUserId(long userId) {
		_constructionPermit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this construction permit.
	*
	* @return the user uuid of this construction permit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _constructionPermit.getUserUuid();
	}

	/**
	* Sets the user uuid of this construction permit.
	*
	* @param userUuid the user uuid of this construction permit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_constructionPermit.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this construction permit.
	*
	* @return the user name of this construction permit
	*/
	@Override
	public java.lang.String getUserName() {
		return _constructionPermit.getUserName();
	}

	/**
	* Sets the user name of this construction permit.
	*
	* @param userName the user name of this construction permit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_constructionPermit.setUserName(userName);
	}

	/**
	* Returns the create time of this construction permit.
	*
	* @return the create time of this construction permit
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _constructionPermit.getCreateTime();
	}

	/**
	* Sets the create time of this construction permit.
	*
	* @param createTime the create time of this construction permit
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_constructionPermit.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this construction permit.
	*
	* @return the modified time of this construction permit
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _constructionPermit.getModifiedTime();
	}

	/**
	* Sets the modified time of this construction permit.
	*
	* @param modifiedTime the modified time of this construction permit
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_constructionPermit.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the proj type of this construction permit.
	*
	* @return the proj type of this construction permit
	*/
	@Override
	public long getProjType() {
		return _constructionPermit.getProjType();
	}

	/**
	* Sets the proj type of this construction permit.
	*
	* @param projType the proj type of this construction permit
	*/
	@Override
	public void setProjType(long projType) {
		_constructionPermit.setProjType(projType);
	}

	/**
	* Returns the proj property of this construction permit.
	*
	* @return the proj property of this construction permit
	*/
	@Override
	public long getProjProperty() {
		return _constructionPermit.getProjProperty();
	}

	/**
	* Sets the proj property of this construction permit.
	*
	* @param projProperty the proj property of this construction permit
	*/
	@Override
	public void setProjProperty(long projProperty) {
		_constructionPermit.setProjProperty(projProperty);
	}

	/**
	* Returns the county of this construction permit.
	*
	* @return the county of this construction permit
	*/
	@Override
	public long getCounty() {
		return _constructionPermit.getCounty();
	}

	/**
	* Sets the county of this construction permit.
	*
	* @param county the county of this construction permit
	*/
	@Override
	public void setCounty(long county) {
		_constructionPermit.setCounty(county);
	}

	/**
	* Returns the construction code of this construction permit.
	*
	* @return the construction code of this construction permit
	*/
	@Override
	public java.lang.String getConstructionCode() {
		return _constructionPermit.getConstructionCode();
	}

	/**
	* Sets the construction code of this construction permit.
	*
	* @param constructionCode the construction code of this construction permit
	*/
	@Override
	public void setConstructionCode(java.lang.String constructionCode) {
		_constructionPermit.setConstructionCode(constructionCode);
	}

	/**
	* Returns the biding code of this construction permit.
	*
	* @return the biding code of this construction permit
	*/
	@Override
	public java.lang.String getBidingCode() {
		return _constructionPermit.getBidingCode();
	}

	/**
	* Sets the biding code of this construction permit.
	*
	* @param bidingCode the biding code of this construction permit
	*/
	@Override
	public void setBidingCode(java.lang.String bidingCode) {
		_constructionPermit.setBidingCode(bidingCode);
	}

	/**
	* Returns the business code of this construction permit.
	*
	* @return the business code of this construction permit
	*/
	@Override
	public java.lang.String getBusinessCode() {
		return _constructionPermit.getBusinessCode();
	}

	/**
	* Sets the business code of this construction permit.
	*
	* @param businessCode the business code of this construction permit
	*/
	@Override
	public void setBusinessCode(java.lang.String businessCode) {
		_constructionPermit.setBusinessCode(businessCode);
	}

	/**
	* Returns the proj name of this construction permit.
	*
	* @return the proj name of this construction permit
	*/
	@Override
	public java.lang.String getProjName() {
		return _constructionPermit.getProjName();
	}

	/**
	* Sets the proj name of this construction permit.
	*
	* @param projName the proj name of this construction permit
	*/
	@Override
	public void setProjName(java.lang.String projName) {
		_constructionPermit.setProjName(projName);
	}

	/**
	* Returns the company of this construction permit.
	*
	* @return the company of this construction permit
	*/
	@Override
	public java.lang.String getCompany() {
		return _constructionPermit.getCompany();
	}

	/**
	* Sets the company of this construction permit.
	*
	* @param company the company of this construction permit
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_constructionPermit.setCompany(company);
	}

	/**
	* Returns the company property of this construction permit.
	*
	* @return the company property of this construction permit
	*/
	@Override
	public java.lang.String getCompanyProperty() {
		return _constructionPermit.getCompanyProperty();
	}

	/**
	* Sets the company property of this construction permit.
	*
	* @param companyProperty the company property of this construction permit
	*/
	@Override
	public void setCompanyProperty(java.lang.String companyProperty) {
		_constructionPermit.setCompanyProperty(companyProperty);
	}

	/**
	* Returns the company address of this construction permit.
	*
	* @return the company address of this construction permit
	*/
	@Override
	public java.lang.String getCompanyAddress() {
		return _constructionPermit.getCompanyAddress();
	}

	/**
	* Sets the company address of this construction permit.
	*
	* @param companyAddress the company address of this construction permit
	*/
	@Override
	public void setCompanyAddress(java.lang.String companyAddress) {
		_constructionPermit.setCompanyAddress(companyAddress);
	}

	/**
	* Returns the legal person of this construction permit.
	*
	* @return the legal person of this construction permit
	*/
	@Override
	public java.lang.String getLegalPerson() {
		return _constructionPermit.getLegalPerson();
	}

	/**
	* Sets the legal person of this construction permit.
	*
	* @param legalPerson the legal person of this construction permit
	*/
	@Override
	public void setLegalPerson(java.lang.String legalPerson) {
		_constructionPermit.setLegalPerson(legalPerson);
	}

	/**
	* Returns the company tel of this construction permit.
	*
	* @return the company tel of this construction permit
	*/
	@Override
	public java.lang.String getCompanyTel() {
		return _constructionPermit.getCompanyTel();
	}

	/**
	* Sets the company tel of this construction permit.
	*
	* @param companyTel the company tel of this construction permit
	*/
	@Override
	public void setCompanyTel(java.lang.String companyTel) {
		_constructionPermit.setCompanyTel(companyTel);
	}

	/**
	* Returns the company contacts of this construction permit.
	*
	* @return the company contacts of this construction permit
	*/
	@Override
	public java.lang.String getCompanyContacts() {
		return _constructionPermit.getCompanyContacts();
	}

	/**
	* Sets the company contacts of this construction permit.
	*
	* @param companyContacts the company contacts of this construction permit
	*/
	@Override
	public void setCompanyContacts(java.lang.String companyContacts) {
		_constructionPermit.setCompanyContacts(companyContacts);
	}

	/**
	* Returns the company contact phone of this construction permit.
	*
	* @return the company contact phone of this construction permit
	*/
	@Override
	public java.lang.String getCompanyContactPhone() {
		return _constructionPermit.getCompanyContactPhone();
	}

	/**
	* Sets the company contact phone of this construction permit.
	*
	* @param companyContactPhone the company contact phone of this construction permit
	*/
	@Override
	public void setCompanyContactPhone(java.lang.String companyContactPhone) {
		_constructionPermit.setCompanyContactPhone(companyContactPhone);
	}

	/**
	* Returns the company site of this construction permit.
	*
	* @return the company site of this construction permit
	*/
	@Override
	public java.lang.String getCompanySite() {
		return _constructionPermit.getCompanySite();
	}

	/**
	* Sets the company site of this construction permit.
	*
	* @param companySite the company site of this construction permit
	*/
	@Override
	public void setCompanySite(java.lang.String companySite) {
		_constructionPermit.setCompanySite(companySite);
	}

	/**
	* Returns the engineer category of this construction permit.
	*
	* @return the engineer category of this construction permit
	*/
	@Override
	public java.lang.String getEngineerCategory() {
		return _constructionPermit.getEngineerCategory();
	}

	/**
	* Sets the engineer category of this construction permit.
	*
	* @param engineerCategory the engineer category of this construction permit
	*/
	@Override
	public void setEngineerCategory(java.lang.String engineerCategory) {
		_constructionPermit.setEngineerCategory(engineerCategory);
	}

	/**
	* Returns the engineer attribute of this construction permit.
	*
	* @return the engineer attribute of this construction permit
	*/
	@Override
	public long getEngineerAttribute() {
		return _constructionPermit.getEngineerAttribute();
	}

	/**
	* Sets the engineer attribute of this construction permit.
	*
	* @param engineerAttribute the engineer attribute of this construction permit
	*/
	@Override
	public void setEngineerAttribute(long engineerAttribute) {
		_constructionPermit.setEngineerAttribute(engineerAttribute);
	}

	/**
	* Returns the engineer scale of this construction permit.
	*
	* @return the engineer scale of this construction permit
	*/
	@Override
	public java.lang.String getEngineerScale() {
		return _constructionPermit.getEngineerScale();
	}

	/**
	* Sets the engineer scale of this construction permit.
	*
	* @param engineerScale the engineer scale of this construction permit
	*/
	@Override
	public void setEngineerScale(java.lang.String engineerScale) {
		_constructionPermit.setEngineerScale(engineerScale);
	}

	/**
	* Returns the national funds per of this construction permit.
	*
	* @return the national funds per of this construction permit
	*/
	@Override
	public java.lang.String getNationalFundsPer() {
		return _constructionPermit.getNationalFundsPer();
	}

	/**
	* Sets the national funds per of this construction permit.
	*
	* @param nationalFundsPer the national funds per of this construction permit
	*/
	@Override
	public void setNationalFundsPer(java.lang.String nationalFundsPer) {
		_constructionPermit.setNationalFundsPer(nationalFundsPer);
	}

	/**
	* Returns the contract price of this construction permit.
	*
	* @return the contract price of this construction permit
	*/
	@Override
	public double getContractPrice() {
		return _constructionPermit.getContractPrice();
	}

	/**
	* Sets the contract price of this construction permit.
	*
	* @param contractPrice the contract price of this construction permit
	*/
	@Override
	public void setContractPrice(double contractPrice) {
		_constructionPermit.setContractPrice(contractPrice);
	}

	/**
	* Returns the contract schedule of this construction permit.
	*
	* @return the contract schedule of this construction permit
	*/
	@Override
	public double getContractSchedule() {
		return _constructionPermit.getContractSchedule();
	}

	/**
	* Sets the contract schedule of this construction permit.
	*
	* @param contractSchedule the contract schedule of this construction permit
	*/
	@Override
	public void setContractSchedule(double contractSchedule) {
		_constructionPermit.setContractSchedule(contractSchedule);
	}

	/**
	* Returns the bid price of this construction permit.
	*
	* @return the bid price of this construction permit
	*/
	@Override
	public double getBidPrice() {
		return _constructionPermit.getBidPrice();
	}

	/**
	* Sets the bid price of this construction permit.
	*
	* @param bidPrice the bid price of this construction permit
	*/
	@Override
	public void setBidPrice(double bidPrice) {
		_constructionPermit.setBidPrice(bidPrice);
	}

	/**
	* Returns the invest budget of this construction permit.
	*
	* @return the invest budget of this construction permit
	*/
	@Override
	public double getInvestBudget() {
		return _constructionPermit.getInvestBudget();
	}

	/**
	* Sets the invest budget of this construction permit.
	*
	* @param investBudget the invest budget of this construction permit
	*/
	@Override
	public void setInvestBudget(double investBudget) {
		_constructionPermit.setInvestBudget(investBudget);
	}

	/**
	* Returns the plan start date of this construction permit.
	*
	* @return the plan start date of this construction permit
	*/
	@Override
	public java.util.Date getPlanStartDate() {
		return _constructionPermit.getPlanStartDate();
	}

	/**
	* Sets the plan start date of this construction permit.
	*
	* @param planStartDate the plan start date of this construction permit
	*/
	@Override
	public void setPlanStartDate(java.util.Date planStartDate) {
		_constructionPermit.setPlanStartDate(planStartDate);
	}

	/**
	* Returns the plan end date of this construction permit.
	*
	* @return the plan end date of this construction permit
	*/
	@Override
	public java.util.Date getPlanEndDate() {
		return _constructionPermit.getPlanEndDate();
	}

	/**
	* Sets the plan end date of this construction permit.
	*
	* @param planEndDate the plan end date of this construction permit
	*/
	@Override
	public void setPlanEndDate(java.util.Date planEndDate) {
		_constructionPermit.setPlanEndDate(planEndDate);
	}

	/**
	* Returns the work situation of this construction permit.
	*
	* @return the work situation of this construction permit
	*/
	@Override
	public java.lang.String getWorkSituation() {
		return _constructionPermit.getWorkSituation();
	}

	/**
	* Sets the work situation of this construction permit.
	*
	* @param workSituation the work situation of this construction permit
	*/
	@Override
	public void setWorkSituation(java.lang.String workSituation) {
		_constructionPermit.setWorkSituation(workSituation);
	}

	/**
	* Returns the other info of this construction permit.
	*
	* @return the other info of this construction permit
	*/
	@Override
	public java.lang.String getOtherInfo() {
		return _constructionPermit.getOtherInfo();
	}

	/**
	* Sets the other info of this construction permit.
	*
	* @param otherInfo the other info of this construction permit
	*/
	@Override
	public void setOtherInfo(java.lang.String otherInfo) {
		_constructionPermit.setOtherInfo(otherInfo);
	}

	/**
	* Returns the apply material of this construction permit.
	*
	* @return the apply material of this construction permit
	*/
	@Override
	public java.lang.String getApplyMaterial() {
		return _constructionPermit.getApplyMaterial();
	}

	/**
	* Sets the apply material of this construction permit.
	*
	* @param applyMaterial the apply material of this construction permit
	*/
	@Override
	public void setApplyMaterial(java.lang.String applyMaterial) {
		_constructionPermit.setApplyMaterial(applyMaterial);
	}

	/**
	* Returns the receipt num of this construction permit.
	*
	* @return the receipt num of this construction permit
	*/
	@Override
	public java.lang.String getReceiptNum() {
		return _constructionPermit.getReceiptNum();
	}

	/**
	* Sets the receipt num of this construction permit.
	*
	* @param receiptNum the receipt num of this construction permit
	*/
	@Override
	public void setReceiptNum(java.lang.String receiptNum) {
		_constructionPermit.setReceiptNum(receiptNum);
	}

	/**
	* Returns the certification date of this construction permit.
	*
	* @return the certification date of this construction permit
	*/
	@Override
	public java.util.Date getCertificationDate() {
		return _constructionPermit.getCertificationDate();
	}

	/**
	* Sets the certification date of this construction permit.
	*
	* @param certificationDate the certification date of this construction permit
	*/
	@Override
	public void setCertificationDate(java.util.Date certificationDate) {
		_constructionPermit.setCertificationDate(certificationDate);
	}

	@Override
	public boolean isNew() {
		return _constructionPermit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_constructionPermit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _constructionPermit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_constructionPermit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _constructionPermit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _constructionPermit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_constructionPermit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _constructionPermit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_constructionPermit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_constructionPermit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_constructionPermit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConstructionPermitWrapper((ConstructionPermit)_constructionPermit.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.projApproval.model.ConstructionPermit constructionPermit) {
		return _constructionPermit.compareTo(constructionPermit);
	}

	@Override
	public int hashCode() {
		return _constructionPermit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.projApproval.model.ConstructionPermit> toCacheModel() {
		return _constructionPermit.toCacheModel();
	}

	@Override
	public com.justonetech.projApproval.model.ConstructionPermit toEscapedModel() {
		return new ConstructionPermitWrapper(_constructionPermit.toEscapedModel());
	}

	@Override
	public com.justonetech.projApproval.model.ConstructionPermit toUnescapedModel() {
		return new ConstructionPermitWrapper(_constructionPermit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _constructionPermit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _constructionPermit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_constructionPermit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConstructionPermitWrapper)) {
			return false;
		}

		ConstructionPermitWrapper constructionPermitWrapper = (ConstructionPermitWrapper)obj;

		if (Validator.equals(_constructionPermit,
					constructionPermitWrapper._constructionPermit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConstructionPermit getWrappedConstructionPermit() {
		return _constructionPermit;
	}

	@Override
	public ConstructionPermit getWrappedModel() {
		return _constructionPermit;
	}

	@Override
	public void resetOriginalValues() {
		_constructionPermit.resetOriginalValues();
	}

	private ConstructionPermit _constructionPermit;
}