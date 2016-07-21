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

package com.justonetech.proj.model.impl;

import com.justonetech.proj.model.Project;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author fanqi
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{projectId=");
		sb.append(projectId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", modifiedTime=");
		sb.append(modifiedTime);
		sb.append(", constructionCode=");
		sb.append(constructionCode);
		sb.append(", projNum=");
		sb.append(projNum);
		sb.append(", sortNo=");
		sb.append(sortNo);
		sb.append(", projStatus=");
		sb.append(projStatus);
		sb.append(", industryCategory=");
		sb.append(industryCategory);
		sb.append(", manageAttribute=");
		sb.append(manageAttribute);
		sb.append(", isMajor=");
		sb.append(isMajor);
		sb.append(", projSource=");
		sb.append(projSource);
		sb.append(", belongCounty=");
		sb.append(belongCounty);
		sb.append(", projAttr=");
		sb.append(projAttr);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", projName=");
		sb.append(projName);
		sb.append(", location=");
		sb.append(location);
		sb.append(", involveCounty=");
		sb.append(involveCounty);
		sb.append(", planRedLine=");
		sb.append(planRedLine);
		sb.append(", roadLevel=");
		sb.append(roadLevel);
		sb.append(", roadTechLevel=");
		sb.append(roadTechLevel);
		sb.append(", startNode=");
		sb.append(startNode);
		sb.append(", endNode=");
		sb.append(endNode);
		sb.append(", planStartDate=");
		sb.append(planStartDate);
		sb.append(", planEndDate=");
		sb.append(planEndDate);
		sb.append(", introduction=");
		sb.append(introduction);
		sb.append(", planTotleInvestment=");
		sb.append(planTotleInvestment);
		sb.append(", feasibilityTotleInvestment=");
		sb.append(feasibilityTotleInvestment);
		sb.append(", feasibilityPreCost=");
		sb.append(feasibilityPreCost);
		sb.append(", feasibilityJiananCost=");
		sb.append(feasibilityJiananCost);
		sb.append(", firstFoundedTotleInvestment=");
		sb.append(firstFoundedTotleInvestment);
		sb.append(", firstFoundedPreCost=");
		sb.append(firstFoundedPreCost);
		sb.append(", firstFoundedJiananCost=");
		sb.append(firstFoundedJiananCost);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		projectImpl.setProjectId(projectId);
		projectImpl.setGroupId(groupId);
		projectImpl.setCompanyId(companyId);
		projectImpl.setUserId(userId);

		if (userName == null) {
			projectImpl.setUserName(StringPool.BLANK);
		}
		else {
			projectImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			projectImpl.setCreateTime(null);
		}
		else {
			projectImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			projectImpl.setModifiedTime(null);
		}
		else {
			projectImpl.setModifiedTime(new Date(modifiedTime));
		}

		if (constructionCode == null) {
			projectImpl.setConstructionCode(StringPool.BLANK);
		}
		else {
			projectImpl.setConstructionCode(constructionCode);
		}

		if (projNum == null) {
			projectImpl.setProjNum(StringPool.BLANK);
		}
		else {
			projectImpl.setProjNum(projNum);
		}

		projectImpl.setSortNo(sortNo);
		projectImpl.setProjStatus(projStatus);
		projectImpl.setIndustryCategory(industryCategory);
		projectImpl.setManageAttribute(manageAttribute);
		projectImpl.setIsMajor(isMajor);
		projectImpl.setProjSource(projSource);
		projectImpl.setBelongCounty(belongCounty);
		projectImpl.setProjAttr(projAttr);

		if (startDate == Long.MIN_VALUE) {
			projectImpl.setStartDate(null);
		}
		else {
			projectImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectImpl.setEndDate(null);
		}
		else {
			projectImpl.setEndDate(new Date(endDate));
		}

		if (projName == null) {
			projectImpl.setProjName(StringPool.BLANK);
		}
		else {
			projectImpl.setProjName(projName);
		}

		if (location == null) {
			projectImpl.setLocation(StringPool.BLANK);
		}
		else {
			projectImpl.setLocation(location);
		}

		if (involveCounty == null) {
			projectImpl.setInvolveCounty(StringPool.BLANK);
		}
		else {
			projectImpl.setInvolveCounty(involveCounty);
		}

		projectImpl.setPlanRedLine(planRedLine);
		projectImpl.setRoadLevel(roadLevel);
		projectImpl.setRoadTechLevel(roadTechLevel);

		if (startNode == Long.MIN_VALUE) {
			projectImpl.setStartNode(null);
		}
		else {
			projectImpl.setStartNode(new Date(startNode));
		}

		if (endNode == Long.MIN_VALUE) {
			projectImpl.setEndNode(null);
		}
		else {
			projectImpl.setEndNode(new Date(endNode));
		}

		if (planStartDate == Long.MIN_VALUE) {
			projectImpl.setPlanStartDate(null);
		}
		else {
			projectImpl.setPlanStartDate(new Date(planStartDate));
		}

		if (planEndDate == Long.MIN_VALUE) {
			projectImpl.setPlanEndDate(null);
		}
		else {
			projectImpl.setPlanEndDate(new Date(planEndDate));
		}

		if (introduction == null) {
			projectImpl.setIntroduction(StringPool.BLANK);
		}
		else {
			projectImpl.setIntroduction(introduction);
		}

		projectImpl.setPlanTotleInvestment(planTotleInvestment);
		projectImpl.setFeasibilityTotleInvestment(feasibilityTotleInvestment);
		projectImpl.setFeasibilityPreCost(feasibilityPreCost);
		projectImpl.setFeasibilityJiananCost(feasibilityJiananCost);
		projectImpl.setFirstFoundedTotleInvestment(firstFoundedTotleInvestment);
		projectImpl.setFirstFoundedPreCost(firstFoundedPreCost);
		projectImpl.setFirstFoundedJiananCost(firstFoundedJiananCost);

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		constructionCode = objectInput.readUTF();
		projNum = objectInput.readUTF();
		sortNo = objectInput.readInt();
		projStatus = objectInput.readLong();
		industryCategory = objectInput.readLong();
		manageAttribute = objectInput.readLong();
		isMajor = objectInput.readBoolean();
		projSource = objectInput.readLong();
		belongCounty = objectInput.readLong();
		projAttr = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		projName = objectInput.readUTF();
		location = objectInput.readUTF();
		involveCounty = objectInput.readUTF();
		planRedLine = objectInput.readDouble();
		roadLevel = objectInput.readLong();
		roadTechLevel = objectInput.readLong();
		startNode = objectInput.readLong();
		endNode = objectInput.readLong();
		planStartDate = objectInput.readLong();
		planEndDate = objectInput.readLong();
		introduction = objectInput.readUTF();
		planTotleInvestment = objectInput.readDouble();
		feasibilityTotleInvestment = objectInput.readDouble();
		feasibilityPreCost = objectInput.readDouble();
		feasibilityJiananCost = objectInput.readDouble();
		firstFoundedTotleInvestment = objectInput.readDouble();
		firstFoundedPreCost = objectInput.readDouble();
		firstFoundedJiananCost = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createTime);
		objectOutput.writeLong(modifiedTime);

		if (constructionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(constructionCode);
		}

		if (projNum == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projNum);
		}

		objectOutput.writeInt(sortNo);
		objectOutput.writeLong(projStatus);
		objectOutput.writeLong(industryCategory);
		objectOutput.writeLong(manageAttribute);
		objectOutput.writeBoolean(isMajor);
		objectOutput.writeLong(projSource);
		objectOutput.writeLong(belongCounty);
		objectOutput.writeLong(projAttr);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (projName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projName);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (involveCounty == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(involveCounty);
		}

		objectOutput.writeDouble(planRedLine);
		objectOutput.writeLong(roadLevel);
		objectOutput.writeLong(roadTechLevel);
		objectOutput.writeLong(startNode);
		objectOutput.writeLong(endNode);
		objectOutput.writeLong(planStartDate);
		objectOutput.writeLong(planEndDate);

		if (introduction == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(introduction);
		}

		objectOutput.writeDouble(planTotleInvestment);
		objectOutput.writeDouble(feasibilityTotleInvestment);
		objectOutput.writeDouble(feasibilityPreCost);
		objectOutput.writeDouble(feasibilityJiananCost);
		objectOutput.writeDouble(firstFoundedTotleInvestment);
		objectOutput.writeDouble(firstFoundedPreCost);
		objectOutput.writeDouble(firstFoundedJiananCost);
	}

	public long projectId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public String constructionCode;
	public String projNum;
	public int sortNo;
	public long projStatus;
	public long industryCategory;
	public long manageAttribute;
	public boolean isMajor;
	public long projSource;
	public long belongCounty;
	public long projAttr;
	public long startDate;
	public long endDate;
	public String projName;
	public String location;
	public String involveCounty;
	public double planRedLine;
	public long roadLevel;
	public long roadTechLevel;
	public long startNode;
	public long endNode;
	public long planStartDate;
	public long planEndDate;
	public String introduction;
	public double planTotleInvestment;
	public double feasibilityTotleInvestment;
	public double feasibilityPreCost;
	public double feasibilityJiananCost;
	public double firstFoundedTotleInvestment;
	public double firstFoundedPreCost;
	public double firstFoundedJiananCost;
}