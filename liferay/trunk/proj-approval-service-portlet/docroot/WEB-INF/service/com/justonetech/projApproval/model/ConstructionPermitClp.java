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

import com.justonetech.projApproval.service.ClpSerializer;
import com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author justonetech
 */
public class ConstructionPermitClp extends BaseModelImpl<ConstructionPermit>
	implements ConstructionPermit {
	public ConstructionPermitClp() {
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
	public long getPrimaryKey() {
		return _constructionPermitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConstructionPermitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _constructionPermitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("companySiteCounty", getCompanySiteCounty());
		attributes.put("engineerCategory", getEngineerCategory());
		attributes.put("engineerAttribute", getEngineerAttribute());
		attributes.put("engineerScale", getEngineerScale());
		attributes.put("nationalFundsProportion", getNationalFundsProportion());
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
		attributes.put("constructionPermitCode", getConstructionPermitCode());

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

		String companySiteCounty = (String)attributes.get("companySiteCounty");

		if (companySiteCounty != null) {
			setCompanySiteCounty(companySiteCounty);
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

		String nationalFundsProportion = (String)attributes.get(
				"nationalFundsProportion");

		if (nationalFundsProportion != null) {
			setNationalFundsProportion(nationalFundsProportion);
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

		String constructionPermitCode = (String)attributes.get(
				"constructionPermitCode");

		if (constructionPermitCode != null) {
			setConstructionPermitCode(constructionPermitCode);
		}
	}

	@Override
	public long getConstructionPermitId() {
		return _constructionPermitId;
	}

	@Override
	public void setConstructionPermitId(long constructionPermitId) {
		_constructionPermitId = constructionPermitId;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionPermitId",
						long.class);

				method.invoke(_constructionPermitRemoteModel,
					constructionPermitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_constructionPermitRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_constructionPermitRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		_createTime = createTime;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_constructionPermitRemoteModel, createTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(Date modifiedTime) {
		_modifiedTime = modifiedTime;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_constructionPermitRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjType() {
		return _projType;
	}

	@Override
	public void setProjType(long projType) {
		_projType = projType;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setProjType", long.class);

				method.invoke(_constructionPermitRemoteModel, projType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjProperty() {
		return _projProperty;
	}

	@Override
	public void setProjProperty(long projProperty) {
		_projProperty = projProperty;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setProjProperty", long.class);

				method.invoke(_constructionPermitRemoteModel, projProperty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCounty() {
		return _county;
	}

	@Override
	public void setCounty(long county) {
		_county = county;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCounty", long.class);

				method.invoke(_constructionPermitRemoteModel, county);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConstructionCode() {
		return _constructionCode;
	}

	@Override
	public void setConstructionCode(String constructionCode) {
		_constructionCode = constructionCode;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionCode",
						String.class);

				method.invoke(_constructionPermitRemoteModel, constructionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBidingCode() {
		return _bidingCode;
	}

	@Override
	public void setBidingCode(String bidingCode) {
		_bidingCode = bidingCode;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setBidingCode", String.class);

				method.invoke(_constructionPermitRemoteModel, bidingCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusinessCode() {
		return _businessCode;
	}

	@Override
	public void setBusinessCode(String businessCode) {
		_businessCode = businessCode;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessCode", String.class);

				method.invoke(_constructionPermitRemoteModel, businessCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjName() {
		return _projName;
	}

	@Override
	public void setProjName(String projName) {
		_projName = projName;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setProjName", String.class);

				method.invoke(_constructionPermitRemoteModel, projName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompany() {
		return _company;
	}

	@Override
	public void setCompany(String company) {
		_company = company;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_constructionPermitRemoteModel, company);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyProperty() {
		return _companyProperty;
	}

	@Override
	public void setCompanyProperty(String companyProperty) {
		_companyProperty = companyProperty;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyProperty",
						String.class);

				method.invoke(_constructionPermitRemoteModel, companyProperty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyAddress() {
		return _companyAddress;
	}

	@Override
	public void setCompanyAddress(String companyAddress) {
		_companyAddress = companyAddress;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyAddress",
						String.class);

				method.invoke(_constructionPermitRemoteModel, companyAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLegalPerson() {
		return _legalPerson;
	}

	@Override
	public void setLegalPerson(String legalPerson) {
		_legalPerson = legalPerson;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setLegalPerson", String.class);

				method.invoke(_constructionPermitRemoteModel, legalPerson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyTel() {
		return _companyTel;
	}

	@Override
	public void setCompanyTel(String companyTel) {
		_companyTel = companyTel;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyTel", String.class);

				method.invoke(_constructionPermitRemoteModel, companyTel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyContacts() {
		return _companyContacts;
	}

	@Override
	public void setCompanyContacts(String companyContacts) {
		_companyContacts = companyContacts;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyContacts",
						String.class);

				method.invoke(_constructionPermitRemoteModel, companyContacts);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyContactPhone() {
		return _companyContactPhone;
	}

	@Override
	public void setCompanyContactPhone(String companyContactPhone) {
		_companyContactPhone = companyContactPhone;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyContactPhone",
						String.class);

				method.invoke(_constructionPermitRemoteModel,
					companyContactPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanySite() {
		return _companySite;
	}

	@Override
	public void setCompanySite(String companySite) {
		_companySite = companySite;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanySite", String.class);

				method.invoke(_constructionPermitRemoteModel, companySite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanySiteCounty() {
		return _companySiteCounty;
	}

	@Override
	public void setCompanySiteCounty(String companySiteCounty) {
		_companySiteCounty = companySiteCounty;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanySiteCounty",
						String.class);

				method.invoke(_constructionPermitRemoteModel, companySiteCounty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEngineerCategory() {
		return _engineerCategory;
	}

	@Override
	public void setEngineerCategory(String engineerCategory) {
		_engineerCategory = engineerCategory;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setEngineerCategory",
						String.class);

				method.invoke(_constructionPermitRemoteModel, engineerCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEngineerAttribute() {
		return _engineerAttribute;
	}

	@Override
	public void setEngineerAttribute(long engineerAttribute) {
		_engineerAttribute = engineerAttribute;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setEngineerAttribute",
						long.class);

				method.invoke(_constructionPermitRemoteModel, engineerAttribute);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEngineerScale() {
		return _engineerScale;
	}

	@Override
	public void setEngineerScale(String engineerScale) {
		_engineerScale = engineerScale;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setEngineerScale", String.class);

				method.invoke(_constructionPermitRemoteModel, engineerScale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNationalFundsProportion() {
		return _nationalFundsProportion;
	}

	@Override
	public void setNationalFundsProportion(String nationalFundsProportion) {
		_nationalFundsProportion = nationalFundsProportion;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setNationalFundsProportion",
						String.class);

				method.invoke(_constructionPermitRemoteModel,
					nationalFundsProportion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getContractPrice() {
		return _contractPrice;
	}

	@Override
	public void setContractPrice(double contractPrice) {
		_contractPrice = contractPrice;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setContractPrice", double.class);

				method.invoke(_constructionPermitRemoteModel, contractPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getContractSchedule() {
		return _contractSchedule;
	}

	@Override
	public void setContractSchedule(double contractSchedule) {
		_contractSchedule = contractSchedule;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setContractSchedule",
						double.class);

				method.invoke(_constructionPermitRemoteModel, contractSchedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getBidPrice() {
		return _bidPrice;
	}

	@Override
	public void setBidPrice(double bidPrice) {
		_bidPrice = bidPrice;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setBidPrice", double.class);

				method.invoke(_constructionPermitRemoteModel, bidPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getInvestBudget() {
		return _investBudget;
	}

	@Override
	public void setInvestBudget(double investBudget) {
		_investBudget = investBudget;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setInvestBudget", double.class);

				method.invoke(_constructionPermitRemoteModel, investBudget);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPlanStartDate() {
		return _planStartDate;
	}

	@Override
	public void setPlanStartDate(Date planStartDate) {
		_planStartDate = planStartDate;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setPlanStartDate", Date.class);

				method.invoke(_constructionPermitRemoteModel, planStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPlanEndDate() {
		return _planEndDate;
	}

	@Override
	public void setPlanEndDate(Date planEndDate) {
		_planEndDate = planEndDate;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setPlanEndDate", Date.class);

				method.invoke(_constructionPermitRemoteModel, planEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkSituation() {
		return _workSituation;
	}

	@Override
	public void setWorkSituation(String workSituation) {
		_workSituation = workSituation;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkSituation", String.class);

				method.invoke(_constructionPermitRemoteModel, workSituation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOtherInfo() {
		return _otherInfo;
	}

	@Override
	public void setOtherInfo(String otherInfo) {
		_otherInfo = otherInfo;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setOtherInfo", String.class);

				method.invoke(_constructionPermitRemoteModel, otherInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplyMaterial() {
		return _applyMaterial;
	}

	@Override
	public void setApplyMaterial(String applyMaterial) {
		_applyMaterial = applyMaterial;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setApplyMaterial", String.class);

				method.invoke(_constructionPermitRemoteModel, applyMaterial);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceiptNum() {
		return _receiptNum;
	}

	@Override
	public void setReceiptNum(String receiptNum) {
		_receiptNum = receiptNum;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiptNum", String.class);

				method.invoke(_constructionPermitRemoteModel, receiptNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCertificationDate() {
		return _certificationDate;
	}

	@Override
	public void setCertificationDate(Date certificationDate) {
		_certificationDate = certificationDate;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificationDate",
						Date.class);

				method.invoke(_constructionPermitRemoteModel, certificationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConstructionPermitCode() {
		return _constructionPermitCode;
	}

	@Override
	public void setConstructionPermitCode(String constructionPermitCode) {
		_constructionPermitCode = constructionPermitCode;

		if (_constructionPermitRemoteModel != null) {
			try {
				Class<?> clazz = _constructionPermitRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionPermitCode",
						String.class);

				method.invoke(_constructionPermitRemoteModel,
					constructionPermitCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getConstructionPermitRemoteModel() {
		return _constructionPermitRemoteModel;
	}

	public void setConstructionPermitRemoteModel(
		BaseModel<?> constructionPermitRemoteModel) {
		_constructionPermitRemoteModel = constructionPermitRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _constructionPermitRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_constructionPermitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConstructionPermitLocalServiceUtil.addConstructionPermit(this);
		}
		else {
			ConstructionPermitLocalServiceUtil.updateConstructionPermit(this);
		}
	}

	@Override
	public ConstructionPermit toEscapedModel() {
		return (ConstructionPermit)ProxyUtil.newProxyInstance(ConstructionPermit.class.getClassLoader(),
			new Class[] { ConstructionPermit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConstructionPermitClp clone = new ConstructionPermitClp();

		clone.setConstructionPermitId(getConstructionPermitId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setProjType(getProjType());
		clone.setProjProperty(getProjProperty());
		clone.setCounty(getCounty());
		clone.setConstructionCode(getConstructionCode());
		clone.setBidingCode(getBidingCode());
		clone.setBusinessCode(getBusinessCode());
		clone.setProjName(getProjName());
		clone.setCompany(getCompany());
		clone.setCompanyProperty(getCompanyProperty());
		clone.setCompanyAddress(getCompanyAddress());
		clone.setLegalPerson(getLegalPerson());
		clone.setCompanyTel(getCompanyTel());
		clone.setCompanyContacts(getCompanyContacts());
		clone.setCompanyContactPhone(getCompanyContactPhone());
		clone.setCompanySite(getCompanySite());
		clone.setCompanySiteCounty(getCompanySiteCounty());
		clone.setEngineerCategory(getEngineerCategory());
		clone.setEngineerAttribute(getEngineerAttribute());
		clone.setEngineerScale(getEngineerScale());
		clone.setNationalFundsProportion(getNationalFundsProportion());
		clone.setContractPrice(getContractPrice());
		clone.setContractSchedule(getContractSchedule());
		clone.setBidPrice(getBidPrice());
		clone.setInvestBudget(getInvestBudget());
		clone.setPlanStartDate(getPlanStartDate());
		clone.setPlanEndDate(getPlanEndDate());
		clone.setWorkSituation(getWorkSituation());
		clone.setOtherInfo(getOtherInfo());
		clone.setApplyMaterial(getApplyMaterial());
		clone.setReceiptNum(getReceiptNum());
		clone.setCertificationDate(getCertificationDate());
		clone.setConstructionPermitCode(getConstructionPermitCode());

		return clone;
	}

	@Override
	public int compareTo(ConstructionPermit constructionPermit) {
		long primaryKey = constructionPermit.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConstructionPermitClp)) {
			return false;
		}

		ConstructionPermitClp constructionPermit = (ConstructionPermitClp)obj;

		long primaryKey = constructionPermit.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{constructionPermitId=");
		sb.append(getConstructionPermitId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", projType=");
		sb.append(getProjType());
		sb.append(", projProperty=");
		sb.append(getProjProperty());
		sb.append(", county=");
		sb.append(getCounty());
		sb.append(", constructionCode=");
		sb.append(getConstructionCode());
		sb.append(", bidingCode=");
		sb.append(getBidingCode());
		sb.append(", businessCode=");
		sb.append(getBusinessCode());
		sb.append(", projName=");
		sb.append(getProjName());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", companyProperty=");
		sb.append(getCompanyProperty());
		sb.append(", companyAddress=");
		sb.append(getCompanyAddress());
		sb.append(", legalPerson=");
		sb.append(getLegalPerson());
		sb.append(", companyTel=");
		sb.append(getCompanyTel());
		sb.append(", companyContacts=");
		sb.append(getCompanyContacts());
		sb.append(", companyContactPhone=");
		sb.append(getCompanyContactPhone());
		sb.append(", companySite=");
		sb.append(getCompanySite());
		sb.append(", companySiteCounty=");
		sb.append(getCompanySiteCounty());
		sb.append(", engineerCategory=");
		sb.append(getEngineerCategory());
		sb.append(", engineerAttribute=");
		sb.append(getEngineerAttribute());
		sb.append(", engineerScale=");
		sb.append(getEngineerScale());
		sb.append(", nationalFundsProportion=");
		sb.append(getNationalFundsProportion());
		sb.append(", contractPrice=");
		sb.append(getContractPrice());
		sb.append(", contractSchedule=");
		sb.append(getContractSchedule());
		sb.append(", bidPrice=");
		sb.append(getBidPrice());
		sb.append(", investBudget=");
		sb.append(getInvestBudget());
		sb.append(", planStartDate=");
		sb.append(getPlanStartDate());
		sb.append(", planEndDate=");
		sb.append(getPlanEndDate());
		sb.append(", workSituation=");
		sb.append(getWorkSituation());
		sb.append(", otherInfo=");
		sb.append(getOtherInfo());
		sb.append(", applyMaterial=");
		sb.append(getApplyMaterial());
		sb.append(", receiptNum=");
		sb.append(getReceiptNum());
		sb.append(", certificationDate=");
		sb.append(getCertificationDate());
		sb.append(", constructionPermitCode=");
		sb.append(getConstructionPermitCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.projApproval.model.ConstructionPermit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>constructionPermitId</column-name><column-value><![CDATA[");
		sb.append(getConstructionPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projType</column-name><column-value><![CDATA[");
		sb.append(getProjType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projProperty</column-name><column-value><![CDATA[");
		sb.append(getProjProperty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>county</column-name><column-value><![CDATA[");
		sb.append(getCounty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>constructionCode</column-name><column-value><![CDATA[");
		sb.append(getConstructionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bidingCode</column-name><column-value><![CDATA[");
		sb.append(getBidingCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessCode</column-name><column-value><![CDATA[");
		sb.append(getBusinessCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projName</column-name><column-value><![CDATA[");
		sb.append(getProjName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyProperty</column-name><column-value><![CDATA[");
		sb.append(getCompanyProperty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyAddress</column-name><column-value><![CDATA[");
		sb.append(getCompanyAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>legalPerson</column-name><column-value><![CDATA[");
		sb.append(getLegalPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyTel</column-name><column-value><![CDATA[");
		sb.append(getCompanyTel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyContacts</column-name><column-value><![CDATA[");
		sb.append(getCompanyContacts());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyContactPhone</column-name><column-value><![CDATA[");
		sb.append(getCompanyContactPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companySite</column-name><column-value><![CDATA[");
		sb.append(getCompanySite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companySiteCounty</column-name><column-value><![CDATA[");
		sb.append(getCompanySiteCounty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>engineerCategory</column-name><column-value><![CDATA[");
		sb.append(getEngineerCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>engineerAttribute</column-name><column-value><![CDATA[");
		sb.append(getEngineerAttribute());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>engineerScale</column-name><column-value><![CDATA[");
		sb.append(getEngineerScale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalFundsProportion</column-name><column-value><![CDATA[");
		sb.append(getNationalFundsProportion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractPrice</column-name><column-value><![CDATA[");
		sb.append(getContractPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractSchedule</column-name><column-value><![CDATA[");
		sb.append(getContractSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bidPrice</column-name><column-value><![CDATA[");
		sb.append(getBidPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>investBudget</column-name><column-value><![CDATA[");
		sb.append(getInvestBudget());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>planStartDate</column-name><column-value><![CDATA[");
		sb.append(getPlanStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>planEndDate</column-name><column-value><![CDATA[");
		sb.append(getPlanEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workSituation</column-name><column-value><![CDATA[");
		sb.append(getWorkSituation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otherInfo</column-name><column-value><![CDATA[");
		sb.append(getOtherInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applyMaterial</column-name><column-value><![CDATA[");
		sb.append(getApplyMaterial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiptNum</column-name><column-value><![CDATA[");
		sb.append(getReceiptNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificationDate</column-name><column-value><![CDATA[");
		sb.append(getCertificationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>constructionPermitCode</column-name><column-value><![CDATA[");
		sb.append(getConstructionPermitCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _constructionPermitId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _projType;
	private long _projProperty;
	private long _county;
	private String _constructionCode;
	private String _bidingCode;
	private String _businessCode;
	private String _projName;
	private String _company;
	private String _companyProperty;
	private String _companyAddress;
	private String _legalPerson;
	private String _companyTel;
	private String _companyContacts;
	private String _companyContactPhone;
	private String _companySite;
	private String _companySiteCounty;
	private String _engineerCategory;
	private long _engineerAttribute;
	private String _engineerScale;
	private String _nationalFundsProportion;
	private double _contractPrice;
	private double _contractSchedule;
	private double _bidPrice;
	private double _investBudget;
	private Date _planStartDate;
	private Date _planEndDate;
	private String _workSituation;
	private String _otherInfo;
	private String _applyMaterial;
	private String _receiptNum;
	private Date _certificationDate;
	private String _constructionPermitCode;
	private BaseModel<?> _constructionPermitRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.projApproval.service.ClpSerializer.class;
}