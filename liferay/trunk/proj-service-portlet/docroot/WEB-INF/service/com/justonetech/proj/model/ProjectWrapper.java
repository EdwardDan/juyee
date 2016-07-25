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

package com.justonetech.proj.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author fanqi
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
	public ProjectWrapper(Project project) {
		_project = project;
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("constructionCode", getConstructionCode());
		attributes.put("projNum", getProjNum());
		attributes.put("sortNo", getSortNo());
		attributes.put("projStatus", getProjStatus());
		attributes.put("industryCategory", getIndustryCategory());
		attributes.put("manageAttribute", getManageAttribute());
		attributes.put("isMajor", getIsMajor());
		attributes.put("projSource", getProjSource());
		attributes.put("belongCounty", getBelongCounty());
		attributes.put("projAttr", getProjAttr());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("projName", getProjName());
		attributes.put("location", getLocation());
		attributes.put("involveCounty", getInvolveCounty());
		attributes.put("planRedLine", getPlanRedLine());
		attributes.put("roadLevel", getRoadLevel());
		attributes.put("roadTechLevel", getRoadTechLevel());
		attributes.put("startNode", getStartNode());
		attributes.put("endNode", getEndNode());
		attributes.put("planStartDate", getPlanStartDate());
		attributes.put("planEndDate", getPlanEndDate());
		attributes.put("introduction", getIntroduction());
		attributes.put("planTotalInvestment", getPlanTotalInvestment());
		attributes.put("feasibilityTotalInvestment",
			getFeasibilityTotalInvestment());
		attributes.put("feasibilityPreCost", getFeasibilityPreCost());
		attributes.put("feasibilityJiananCost", getFeasibilityJiananCost());
		attributes.put("firstFoundedTotalInvestment",
			getFirstFoundedTotalInvestment());
		attributes.put("firstFoundedPreCost", getFirstFoundedPreCost());
		attributes.put("firstFoundedJiananCost", getFirstFoundedJiananCost());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String constructionCode = (String)attributes.get("constructionCode");

		if (constructionCode != null) {
			setConstructionCode(constructionCode);
		}

		String projNum = (String)attributes.get("projNum");

		if (projNum != null) {
			setProjNum(projNum);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		Long projStatus = (Long)attributes.get("projStatus");

		if (projStatus != null) {
			setProjStatus(projStatus);
		}

		Long industryCategory = (Long)attributes.get("industryCategory");

		if (industryCategory != null) {
			setIndustryCategory(industryCategory);
		}

		Long manageAttribute = (Long)attributes.get("manageAttribute");

		if (manageAttribute != null) {
			setManageAttribute(manageAttribute);
		}

		Boolean isMajor = (Boolean)attributes.get("isMajor");

		if (isMajor != null) {
			setIsMajor(isMajor);
		}

		Long projSource = (Long)attributes.get("projSource");

		if (projSource != null) {
			setProjSource(projSource);
		}

		Long belongCounty = (Long)attributes.get("belongCounty");

		if (belongCounty != null) {
			setBelongCounty(belongCounty);
		}

		Long projAttr = (Long)attributes.get("projAttr");

		if (projAttr != null) {
			setProjAttr(projAttr);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String projName = (String)attributes.get("projName");

		if (projName != null) {
			setProjName(projName);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String involveCounty = (String)attributes.get("involveCounty");

		if (involveCounty != null) {
			setInvolveCounty(involveCounty);
		}

		Double planRedLine = (Double)attributes.get("planRedLine");

		if (planRedLine != null) {
			setPlanRedLine(planRedLine);
		}

		Long roadLevel = (Long)attributes.get("roadLevel");

		if (roadLevel != null) {
			setRoadLevel(roadLevel);
		}

		Long roadTechLevel = (Long)attributes.get("roadTechLevel");

		if (roadTechLevel != null) {
			setRoadTechLevel(roadTechLevel);
		}

		Date startNode = (Date)attributes.get("startNode");

		if (startNode != null) {
			setStartNode(startNode);
		}

		Date endNode = (Date)attributes.get("endNode");

		if (endNode != null) {
			setEndNode(endNode);
		}

		Date planStartDate = (Date)attributes.get("planStartDate");

		if (planStartDate != null) {
			setPlanStartDate(planStartDate);
		}

		Date planEndDate = (Date)attributes.get("planEndDate");

		if (planEndDate != null) {
			setPlanEndDate(planEndDate);
		}

		String introduction = (String)attributes.get("introduction");

		if (introduction != null) {
			setIntroduction(introduction);
		}

		Double planTotalInvestment = (Double)attributes.get(
				"planTotalInvestment");

		if (planTotalInvestment != null) {
			setPlanTotalInvestment(planTotalInvestment);
		}

		Double feasibilityTotalInvestment = (Double)attributes.get(
				"feasibilityTotalInvestment");

		if (feasibilityTotalInvestment != null) {
			setFeasibilityTotalInvestment(feasibilityTotalInvestment);
		}

		Double feasibilityPreCost = (Double)attributes.get("feasibilityPreCost");

		if (feasibilityPreCost != null) {
			setFeasibilityPreCost(feasibilityPreCost);
		}

		Double feasibilityJiananCost = (Double)attributes.get(
				"feasibilityJiananCost");

		if (feasibilityJiananCost != null) {
			setFeasibilityJiananCost(feasibilityJiananCost);
		}

		Double firstFoundedTotalInvestment = (Double)attributes.get(
				"firstFoundedTotalInvestment");

		if (firstFoundedTotalInvestment != null) {
			setFirstFoundedTotalInvestment(firstFoundedTotalInvestment);
		}

		Double firstFoundedPreCost = (Double)attributes.get(
				"firstFoundedPreCost");

		if (firstFoundedPreCost != null) {
			setFirstFoundedPreCost(firstFoundedPreCost);
		}

		Double firstFoundedJiananCost = (Double)attributes.get(
				"firstFoundedJiananCost");

		if (firstFoundedJiananCost != null) {
			setFirstFoundedJiananCost(firstFoundedJiananCost);
		}
	}

	/**
	* Returns the primary key of this project.
	*
	* @return the primary key of this project
	*/
	@Override
	public long getPrimaryKey() {
		return _project.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project.
	*
	* @param primaryKey the primary key of this project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_project.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project ID of this project.
	*
	* @return the project ID of this project
	*/
	@Override
	public long getProjectId() {
		return _project.getProjectId();
	}

	/**
	* Sets the project ID of this project.
	*
	* @param projectId the project ID of this project
	*/
	@Override
	public void setProjectId(long projectId) {
		_project.setProjectId(projectId);
	}

	/**
	* Returns the group ID of this project.
	*
	* @return the group ID of this project
	*/
	@Override
	public long getGroupId() {
		return _project.getGroupId();
	}

	/**
	* Sets the group ID of this project.
	*
	* @param groupId the group ID of this project
	*/
	@Override
	public void setGroupId(long groupId) {
		_project.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this project.
	*
	* @return the company ID of this project
	*/
	@Override
	public long getCompanyId() {
		return _project.getCompanyId();
	}

	/**
	* Sets the company ID of this project.
	*
	* @param companyId the company ID of this project
	*/
	@Override
	public void setCompanyId(long companyId) {
		_project.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this project.
	*
	* @return the user ID of this project
	*/
	@Override
	public long getUserId() {
		return _project.getUserId();
	}

	/**
	* Sets the user ID of this project.
	*
	* @param userId the user ID of this project
	*/
	@Override
	public void setUserId(long userId) {
		_project.setUserId(userId);
	}

	/**
	* Returns the user uuid of this project.
	*
	* @return the user uuid of this project
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _project.getUserUuid();
	}

	/**
	* Sets the user uuid of this project.
	*
	* @param userUuid the user uuid of this project
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_project.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this project.
	*
	* @return the user name of this project
	*/
	@Override
	public java.lang.String getUserName() {
		return _project.getUserName();
	}

	/**
	* Sets the user name of this project.
	*
	* @param userName the user name of this project
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_project.setUserName(userName);
	}

	/**
	* Returns the create time of this project.
	*
	* @return the create time of this project
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _project.getCreateTime();
	}

	/**
	* Sets the create time of this project.
	*
	* @param createTime the create time of this project
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_project.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this project.
	*
	* @return the modified time of this project
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _project.getModifiedTime();
	}

	/**
	* Sets the modified time of this project.
	*
	* @param modifiedTime the modified time of this project
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_project.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the construction code of this project.
	*
	* @return the construction code of this project
	*/
	@Override
	public java.lang.String getConstructionCode() {
		return _project.getConstructionCode();
	}

	/**
	* Sets the construction code of this project.
	*
	* @param constructionCode the construction code of this project
	*/
	@Override
	public void setConstructionCode(java.lang.String constructionCode) {
		_project.setConstructionCode(constructionCode);
	}

	/**
	* Returns the proj num of this project.
	*
	* @return the proj num of this project
	*/
	@Override
	public java.lang.String getProjNum() {
		return _project.getProjNum();
	}

	/**
	* Sets the proj num of this project.
	*
	* @param projNum the proj num of this project
	*/
	@Override
	public void setProjNum(java.lang.String projNum) {
		_project.setProjNum(projNum);
	}

	/**
	* Returns the sort no of this project.
	*
	* @return the sort no of this project
	*/
	@Override
	public int getSortNo() {
		return _project.getSortNo();
	}

	/**
	* Sets the sort no of this project.
	*
	* @param sortNo the sort no of this project
	*/
	@Override
	public void setSortNo(int sortNo) {
		_project.setSortNo(sortNo);
	}

	/**
	* Returns the proj status of this project.
	*
	* @return the proj status of this project
	*/
	@Override
	public long getProjStatus() {
		return _project.getProjStatus();
	}

	/**
	* Sets the proj status of this project.
	*
	* @param projStatus the proj status of this project
	*/
	@Override
	public void setProjStatus(long projStatus) {
		_project.setProjStatus(projStatus);
	}

	/**
	* Returns the industry category of this project.
	*
	* @return the industry category of this project
	*/
	@Override
	public long getIndustryCategory() {
		return _project.getIndustryCategory();
	}

	/**
	* Sets the industry category of this project.
	*
	* @param industryCategory the industry category of this project
	*/
	@Override
	public void setIndustryCategory(long industryCategory) {
		_project.setIndustryCategory(industryCategory);
	}

	/**
	* Returns the manage attribute of this project.
	*
	* @return the manage attribute of this project
	*/
	@Override
	public long getManageAttribute() {
		return _project.getManageAttribute();
	}

	/**
	* Sets the manage attribute of this project.
	*
	* @param manageAttribute the manage attribute of this project
	*/
	@Override
	public void setManageAttribute(long manageAttribute) {
		_project.setManageAttribute(manageAttribute);
	}

	/**
	* Returns the is major of this project.
	*
	* @return the is major of this project
	*/
	@Override
	public boolean getIsMajor() {
		return _project.getIsMajor();
	}

	/**
	* Returns <code>true</code> if this project is is major.
	*
	* @return <code>true</code> if this project is is major; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsMajor() {
		return _project.isIsMajor();
	}

	/**
	* Sets whether this project is is major.
	*
	* @param isMajor the is major of this project
	*/
	@Override
	public void setIsMajor(boolean isMajor) {
		_project.setIsMajor(isMajor);
	}

	/**
	* Returns the proj source of this project.
	*
	* @return the proj source of this project
	*/
	@Override
	public long getProjSource() {
		return _project.getProjSource();
	}

	/**
	* Sets the proj source of this project.
	*
	* @param projSource the proj source of this project
	*/
	@Override
	public void setProjSource(long projSource) {
		_project.setProjSource(projSource);
	}

	/**
	* Returns the belong county of this project.
	*
	* @return the belong county of this project
	*/
	@Override
	public long getBelongCounty() {
		return _project.getBelongCounty();
	}

	/**
	* Sets the belong county of this project.
	*
	* @param belongCounty the belong county of this project
	*/
	@Override
	public void setBelongCounty(long belongCounty) {
		_project.setBelongCounty(belongCounty);
	}

	/**
	* Returns the proj attr of this project.
	*
	* @return the proj attr of this project
	*/
	@Override
	public long getProjAttr() {
		return _project.getProjAttr();
	}

	/**
	* Sets the proj attr of this project.
	*
	* @param projAttr the proj attr of this project
	*/
	@Override
	public void setProjAttr(long projAttr) {
		_project.setProjAttr(projAttr);
	}

	/**
	* Returns the start date of this project.
	*
	* @return the start date of this project
	*/
	@Override
	public java.util.Date getStartDate() {
		return _project.getStartDate();
	}

	/**
	* Sets the start date of this project.
	*
	* @param startDate the start date of this project
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_project.setStartDate(startDate);
	}

	/**
	* Returns the end date of this project.
	*
	* @return the end date of this project
	*/
	@Override
	public java.util.Date getEndDate() {
		return _project.getEndDate();
	}

	/**
	* Sets the end date of this project.
	*
	* @param endDate the end date of this project
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_project.setEndDate(endDate);
	}

	/**
	* Returns the proj name of this project.
	*
	* @return the proj name of this project
	*/
	@Override
	public java.lang.String getProjName() {
		return _project.getProjName();
	}

	/**
	* Sets the proj name of this project.
	*
	* @param projName the proj name of this project
	*/
	@Override
	public void setProjName(java.lang.String projName) {
		_project.setProjName(projName);
	}

	/**
	* Returns the location of this project.
	*
	* @return the location of this project
	*/
	@Override
	public java.lang.String getLocation() {
		return _project.getLocation();
	}

	/**
	* Sets the location of this project.
	*
	* @param location the location of this project
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_project.setLocation(location);
	}

	/**
	* Returns the involve county of this project.
	*
	* @return the involve county of this project
	*/
	@Override
	public java.lang.String getInvolveCounty() {
		return _project.getInvolveCounty();
	}

	/**
	* Sets the involve county of this project.
	*
	* @param involveCounty the involve county of this project
	*/
	@Override
	public void setInvolveCounty(java.lang.String involveCounty) {
		_project.setInvolveCounty(involveCounty);
	}

	/**
	* Returns the plan red line of this project.
	*
	* @return the plan red line of this project
	*/
	@Override
	public double getPlanRedLine() {
		return _project.getPlanRedLine();
	}

	/**
	* Sets the plan red line of this project.
	*
	* @param planRedLine the plan red line of this project
	*/
	@Override
	public void setPlanRedLine(double planRedLine) {
		_project.setPlanRedLine(planRedLine);
	}

	/**
	* Returns the road level of this project.
	*
	* @return the road level of this project
	*/
	@Override
	public long getRoadLevel() {
		return _project.getRoadLevel();
	}

	/**
	* Sets the road level of this project.
	*
	* @param roadLevel the road level of this project
	*/
	@Override
	public void setRoadLevel(long roadLevel) {
		_project.setRoadLevel(roadLevel);
	}

	/**
	* Returns the road tech level of this project.
	*
	* @return the road tech level of this project
	*/
	@Override
	public long getRoadTechLevel() {
		return _project.getRoadTechLevel();
	}

	/**
	* Sets the road tech level of this project.
	*
	* @param roadTechLevel the road tech level of this project
	*/
	@Override
	public void setRoadTechLevel(long roadTechLevel) {
		_project.setRoadTechLevel(roadTechLevel);
	}

	/**
	* Returns the start node of this project.
	*
	* @return the start node of this project
	*/
	@Override
	public java.util.Date getStartNode() {
		return _project.getStartNode();
	}

	/**
	* Sets the start node of this project.
	*
	* @param startNode the start node of this project
	*/
	@Override
	public void setStartNode(java.util.Date startNode) {
		_project.setStartNode(startNode);
	}

	/**
	* Returns the end node of this project.
	*
	* @return the end node of this project
	*/
	@Override
	public java.util.Date getEndNode() {
		return _project.getEndNode();
	}

	/**
	* Sets the end node of this project.
	*
	* @param endNode the end node of this project
	*/
	@Override
	public void setEndNode(java.util.Date endNode) {
		_project.setEndNode(endNode);
	}

	/**
	* Returns the plan start date of this project.
	*
	* @return the plan start date of this project
	*/
	@Override
	public java.util.Date getPlanStartDate() {
		return _project.getPlanStartDate();
	}

	/**
	* Sets the plan start date of this project.
	*
	* @param planStartDate the plan start date of this project
	*/
	@Override
	public void setPlanStartDate(java.util.Date planStartDate) {
		_project.setPlanStartDate(planStartDate);
	}

	/**
	* Returns the plan end date of this project.
	*
	* @return the plan end date of this project
	*/
	@Override
	public java.util.Date getPlanEndDate() {
		return _project.getPlanEndDate();
	}

	/**
	* Sets the plan end date of this project.
	*
	* @param planEndDate the plan end date of this project
	*/
	@Override
	public void setPlanEndDate(java.util.Date planEndDate) {
		_project.setPlanEndDate(planEndDate);
	}

	/**
	* Returns the introduction of this project.
	*
	* @return the introduction of this project
	*/
	@Override
	public java.lang.String getIntroduction() {
		return _project.getIntroduction();
	}

	/**
	* Sets the introduction of this project.
	*
	* @param introduction the introduction of this project
	*/
	@Override
	public void setIntroduction(java.lang.String introduction) {
		_project.setIntroduction(introduction);
	}

	/**
	* Returns the plan total investment of this project.
	*
	* @return the plan total investment of this project
	*/
	@Override
	public double getPlanTotalInvestment() {
		return _project.getPlanTotalInvestment();
	}

	/**
	* Sets the plan total investment of this project.
	*
	* @param planTotalInvestment the plan total investment of this project
	*/
	@Override
	public void setPlanTotalInvestment(double planTotalInvestment) {
		_project.setPlanTotalInvestment(planTotalInvestment);
	}

	/**
	* Returns the feasibility total investment of this project.
	*
	* @return the feasibility total investment of this project
	*/
	@Override
	public double getFeasibilityTotalInvestment() {
		return _project.getFeasibilityTotalInvestment();
	}

	/**
	* Sets the feasibility total investment of this project.
	*
	* @param feasibilityTotalInvestment the feasibility total investment of this project
	*/
	@Override
	public void setFeasibilityTotalInvestment(double feasibilityTotalInvestment) {
		_project.setFeasibilityTotalInvestment(feasibilityTotalInvestment);
	}

	/**
	* Returns the feasibility pre cost of this project.
	*
	* @return the feasibility pre cost of this project
	*/
	@Override
	public double getFeasibilityPreCost() {
		return _project.getFeasibilityPreCost();
	}

	/**
	* Sets the feasibility pre cost of this project.
	*
	* @param feasibilityPreCost the feasibility pre cost of this project
	*/
	@Override
	public void setFeasibilityPreCost(double feasibilityPreCost) {
		_project.setFeasibilityPreCost(feasibilityPreCost);
	}

	/**
	* Returns the feasibility jianan cost of this project.
	*
	* @return the feasibility jianan cost of this project
	*/
	@Override
	public double getFeasibilityJiananCost() {
		return _project.getFeasibilityJiananCost();
	}

	/**
	* Sets the feasibility jianan cost of this project.
	*
	* @param feasibilityJiananCost the feasibility jianan cost of this project
	*/
	@Override
	public void setFeasibilityJiananCost(double feasibilityJiananCost) {
		_project.setFeasibilityJiananCost(feasibilityJiananCost);
	}

	/**
	* Returns the first founded total investment of this project.
	*
	* @return the first founded total investment of this project
	*/
	@Override
	public double getFirstFoundedTotalInvestment() {
		return _project.getFirstFoundedTotalInvestment();
	}

	/**
	* Sets the first founded total investment of this project.
	*
	* @param firstFoundedTotalInvestment the first founded total investment of this project
	*/
	@Override
	public void setFirstFoundedTotalInvestment(
		double firstFoundedTotalInvestment) {
		_project.setFirstFoundedTotalInvestment(firstFoundedTotalInvestment);
	}

	/**
	* Returns the first founded pre cost of this project.
	*
	* @return the first founded pre cost of this project
	*/
	@Override
	public double getFirstFoundedPreCost() {
		return _project.getFirstFoundedPreCost();
	}

	/**
	* Sets the first founded pre cost of this project.
	*
	* @param firstFoundedPreCost the first founded pre cost of this project
	*/
	@Override
	public void setFirstFoundedPreCost(double firstFoundedPreCost) {
		_project.setFirstFoundedPreCost(firstFoundedPreCost);
	}

	/**
	* Returns the first founded jianan cost of this project.
	*
	* @return the first founded jianan cost of this project
	*/
	@Override
	public double getFirstFoundedJiananCost() {
		return _project.getFirstFoundedJiananCost();
	}

	/**
	* Sets the first founded jianan cost of this project.
	*
	* @param firstFoundedJiananCost the first founded jianan cost of this project
	*/
	@Override
	public void setFirstFoundedJiananCost(double firstFoundedJiananCost) {
		_project.setFirstFoundedJiananCost(firstFoundedJiananCost);
	}

	@Override
	public boolean isNew() {
		return _project.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectWrapper((Project)_project.clone());
	}

	@Override
	public int compareTo(com.justonetech.proj.model.Project project) {
		return _project.compareTo(project);
	}

	@Override
	public int hashCode() {
		return _project.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.proj.model.Project> toCacheModel() {
		return _project.toCacheModel();
	}

	@Override
	public com.justonetech.proj.model.Project toEscapedModel() {
		return new ProjectWrapper(_project.toEscapedModel());
	}

	@Override
	public com.justonetech.proj.model.Project toUnescapedModel() {
		return new ProjectWrapper(_project.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectWrapper)) {
			return false;
		}

		ProjectWrapper projectWrapper = (ProjectWrapper)obj;

		if (Validator.equals(_project, projectWrapper._project)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project getWrappedProject() {
		return _project;
	}

	@Override
	public Project getWrappedModel() {
		return _project;
	}

	@Override
	public void resetOriginalValues() {
		_project.resetOriginalValues();
	}

	private Project _project;
}