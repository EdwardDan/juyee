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

package com.justonetech.projApproval.model.impl;

import com.justonetech.projApproval.model.ConstructionPermit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ConstructionPermit in entity cache.
 *
 * @author justonetech
 * @see ConstructionPermit
 * @generated
 */
public class ConstructionPermitCacheModel implements CacheModel<ConstructionPermit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{constructionPermitId=");
		sb.append(constructionPermitId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", modifiedTime=");
		sb.append(modifiedTime);
		sb.append(", projType=");
		sb.append(projType);
		sb.append(", projProperty=");
		sb.append(projProperty);
		sb.append(", county=");
		sb.append(county);
		sb.append(", constructionCode=");
		sb.append(constructionCode);
		sb.append(", bidingCode=");
		sb.append(bidingCode);
		sb.append(", businessCode=");
		sb.append(businessCode);
		sb.append(", projName=");
		sb.append(projName);
		sb.append(", company=");
		sb.append(company);
		sb.append(", companyProperty=");
		sb.append(companyProperty);
		sb.append(", companyAddress=");
		sb.append(companyAddress);
		sb.append(", legalPerson=");
		sb.append(legalPerson);
		sb.append(", companyTel=");
		sb.append(companyTel);
		sb.append(", companyContacts=");
		sb.append(companyContacts);
		sb.append(", companyContactPhone=");
		sb.append(companyContactPhone);
		sb.append(", companySite=");
		sb.append(companySite);
		sb.append(", companySiteCounty=");
		sb.append(companySiteCounty);
		sb.append(", engineerCategory=");
		sb.append(engineerCategory);
		sb.append(", engineerAttribute=");
		sb.append(engineerAttribute);
		sb.append(", engineerScale=");
		sb.append(engineerScale);
		sb.append(", nationalFundsProportion=");
		sb.append(nationalFundsProportion);
		sb.append(", contractPrice=");
		sb.append(contractPrice);
		sb.append(", contractSchedule=");
		sb.append(contractSchedule);
		sb.append(", bidPrice=");
		sb.append(bidPrice);
		sb.append(", investBudget=");
		sb.append(investBudget);
		sb.append(", planStartDate=");
		sb.append(planStartDate);
		sb.append(", planEndDate=");
		sb.append(planEndDate);
		sb.append(", workSituation=");
		sb.append(workSituation);
		sb.append(", otherInfo=");
		sb.append(otherInfo);
		sb.append(", applyMaterial=");
		sb.append(applyMaterial);
		sb.append(", receiptNum=");
		sb.append(receiptNum);
		sb.append(", certificationDate=");
		sb.append(certificationDate);
		sb.append(", constructionPermitCode=");
		sb.append(constructionPermitCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConstructionPermit toEntityModel() {
		ConstructionPermitImpl constructionPermitImpl = new ConstructionPermitImpl();

		constructionPermitImpl.setConstructionPermitId(constructionPermitId);
		constructionPermitImpl.setUserId(userId);

		if (userName == null) {
			constructionPermitImpl.setUserName(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			constructionPermitImpl.setCreateTime(null);
		}
		else {
			constructionPermitImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			constructionPermitImpl.setModifiedTime(null);
		}
		else {
			constructionPermitImpl.setModifiedTime(new Date(modifiedTime));
		}

		constructionPermitImpl.setProjType(projType);
		constructionPermitImpl.setProjProperty(projProperty);
		constructionPermitImpl.setCounty(county);

		if (constructionCode == null) {
			constructionPermitImpl.setConstructionCode(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setConstructionCode(constructionCode);
		}

		if (bidingCode == null) {
			constructionPermitImpl.setBidingCode(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setBidingCode(bidingCode);
		}

		if (businessCode == null) {
			constructionPermitImpl.setBusinessCode(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setBusinessCode(businessCode);
		}

		if (projName == null) {
			constructionPermitImpl.setProjName(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setProjName(projName);
		}

		if (company == null) {
			constructionPermitImpl.setCompany(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompany(company);
		}

		if (companyProperty == null) {
			constructionPermitImpl.setCompanyProperty(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompanyProperty(companyProperty);
		}

		if (companyAddress == null) {
			constructionPermitImpl.setCompanyAddress(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompanyAddress(companyAddress);
		}

		if (legalPerson == null) {
			constructionPermitImpl.setLegalPerson(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setLegalPerson(legalPerson);
		}

		if (companyTel == null) {
			constructionPermitImpl.setCompanyTel(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompanyTel(companyTel);
		}

		if (companyContacts == null) {
			constructionPermitImpl.setCompanyContacts(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompanyContacts(companyContacts);
		}

		if (companyContactPhone == null) {
			constructionPermitImpl.setCompanyContactPhone(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompanyContactPhone(companyContactPhone);
		}

		if (companySite == null) {
			constructionPermitImpl.setCompanySite(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompanySite(companySite);
		}

		if (companySiteCounty == null) {
			constructionPermitImpl.setCompanySiteCounty(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setCompanySiteCounty(companySiteCounty);
		}

		if (engineerCategory == null) {
			constructionPermitImpl.setEngineerCategory(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setEngineerCategory(engineerCategory);
		}

		constructionPermitImpl.setEngineerAttribute(engineerAttribute);

		if (engineerScale == null) {
			constructionPermitImpl.setEngineerScale(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setEngineerScale(engineerScale);
		}

		if (nationalFundsProportion == null) {
			constructionPermitImpl.setNationalFundsProportion(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setNationalFundsProportion(nationalFundsProportion);
		}

		constructionPermitImpl.setContractPrice(contractPrice);
		constructionPermitImpl.setContractSchedule(contractSchedule);
		constructionPermitImpl.setBidPrice(bidPrice);
		constructionPermitImpl.setInvestBudget(investBudget);

		if (planStartDate == Long.MIN_VALUE) {
			constructionPermitImpl.setPlanStartDate(null);
		}
		else {
			constructionPermitImpl.setPlanStartDate(new Date(planStartDate));
		}

		if (planEndDate == Long.MIN_VALUE) {
			constructionPermitImpl.setPlanEndDate(null);
		}
		else {
			constructionPermitImpl.setPlanEndDate(new Date(planEndDate));
		}

		if (workSituation == null) {
			constructionPermitImpl.setWorkSituation(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setWorkSituation(workSituation);
		}

		if (otherInfo == null) {
			constructionPermitImpl.setOtherInfo(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setOtherInfo(otherInfo);
		}

		if (applyMaterial == null) {
			constructionPermitImpl.setApplyMaterial(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setApplyMaterial(applyMaterial);
		}

		if (receiptNum == null) {
			constructionPermitImpl.setReceiptNum(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setReceiptNum(receiptNum);
		}

		if (certificationDate == Long.MIN_VALUE) {
			constructionPermitImpl.setCertificationDate(null);
		}
		else {
			constructionPermitImpl.setCertificationDate(new Date(
					certificationDate));
		}

		if (constructionPermitCode == null) {
			constructionPermitImpl.setConstructionPermitCode(StringPool.BLANK);
		}
		else {
			constructionPermitImpl.setConstructionPermitCode(constructionPermitCode);
		}

		constructionPermitImpl.resetOriginalValues();

		return constructionPermitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		constructionPermitId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		projType = objectInput.readLong();
		projProperty = objectInput.readLong();
		county = objectInput.readLong();
		constructionCode = objectInput.readUTF();
		bidingCode = objectInput.readUTF();
		businessCode = objectInput.readUTF();
		projName = objectInput.readUTF();
		company = objectInput.readUTF();
		companyProperty = objectInput.readUTF();
		companyAddress = objectInput.readUTF();
		legalPerson = objectInput.readUTF();
		companyTel = objectInput.readUTF();
		companyContacts = objectInput.readUTF();
		companyContactPhone = objectInput.readUTF();
		companySite = objectInput.readUTF();
		companySiteCounty = objectInput.readUTF();
		engineerCategory = objectInput.readUTF();
		engineerAttribute = objectInput.readLong();
		engineerScale = objectInput.readUTF();
		nationalFundsProportion = objectInput.readUTF();
		contractPrice = objectInput.readDouble();
		contractSchedule = objectInput.readDouble();
		bidPrice = objectInput.readDouble();
		investBudget = objectInput.readDouble();
		planStartDate = objectInput.readLong();
		planEndDate = objectInput.readLong();
		workSituation = objectInput.readUTF();
		otherInfo = objectInput.readUTF();
		applyMaterial = objectInput.readUTF();
		receiptNum = objectInput.readUTF();
		certificationDate = objectInput.readLong();
		constructionPermitCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(constructionPermitId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createTime);
		objectOutput.writeLong(modifiedTime);
		objectOutput.writeLong(projType);
		objectOutput.writeLong(projProperty);
		objectOutput.writeLong(county);

		if (constructionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(constructionCode);
		}

		if (bidingCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bidingCode);
		}

		if (businessCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(businessCode);
		}

		if (projName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projName);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (companyProperty == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyProperty);
		}

		if (companyAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyAddress);
		}

		if (legalPerson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(legalPerson);
		}

		if (companyTel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyTel);
		}

		if (companyContacts == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyContacts);
		}

		if (companyContactPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyContactPhone);
		}

		if (companySite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companySite);
		}

		if (companySiteCounty == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companySiteCounty);
		}

		if (engineerCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(engineerCategory);
		}

		objectOutput.writeLong(engineerAttribute);

		if (engineerScale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(engineerScale);
		}

		if (nationalFundsProportion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nationalFundsProportion);
		}

		objectOutput.writeDouble(contractPrice);
		objectOutput.writeDouble(contractSchedule);
		objectOutput.writeDouble(bidPrice);
		objectOutput.writeDouble(investBudget);
		objectOutput.writeLong(planStartDate);
		objectOutput.writeLong(planEndDate);

		if (workSituation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workSituation);
		}

		if (otherInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherInfo);
		}

		if (applyMaterial == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applyMaterial);
		}

		if (receiptNum == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receiptNum);
		}

		objectOutput.writeLong(certificationDate);

		if (constructionPermitCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(constructionPermitCode);
		}
	}

	public long constructionPermitId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public long projType;
	public long projProperty;
	public long county;
	public String constructionCode;
	public String bidingCode;
	public String businessCode;
	public String projName;
	public String company;
	public String companyProperty;
	public String companyAddress;
	public String legalPerson;
	public String companyTel;
	public String companyContacts;
	public String companyContactPhone;
	public String companySite;
	public String companySiteCounty;
	public String engineerCategory;
	public long engineerAttribute;
	public String engineerScale;
	public String nationalFundsProportion;
	public double contractPrice;
	public double contractSchedule;
	public double bidPrice;
	public double investBudget;
	public long planStartDate;
	public long planEndDate;
	public String workSituation;
	public String otherInfo;
	public String applyMaterial;
	public String receiptNum;
	public long certificationDate;
	public String constructionPermitCode;
}