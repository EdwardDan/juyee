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
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bjbh", getBjbh());
		attributes.put("projNum", getProjNum());
		attributes.put("sortNo", getSortNo());
		attributes.put("projStatus", getProjStatus());
		attributes.put("industryCategory", getIndustryCategory());
		attributes.put("manageAttr", getManageAttr());
		attributes.put("isMajor", getIsMajor());
		attributes.put("projSource", getProjSource());
		attributes.put("belongCounty", getBelongCounty());
		attributes.put("projAttr", getProjAttr());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("projName", getProjName());
		attributes.put("location", getLocation());
		attributes.put("involveCounty", getInvolveCounty());
		attributes.put("ghhx", getGhhx());
		attributes.put("roadLevel", getRoadLevel());
		attributes.put("roadTechLevel", getRoadTechLevel());
		attributes.put("startNode", getStartNode());
		attributes.put("endNode", getEndNode());
		attributes.put("planStartDate", getPlanStartDate());
		attributes.put("planEndDate", getPlanEndDate());
		attributes.put("introduction", getIntroduction());
		attributes.put("planTotle", getPlanTotle());
		attributes.put("gkpfTotle", getGkpfTotle());
		attributes.put("gkpfPre", getGkpfPre());
		attributes.put("gkpfJafy", getGkpfJafy());
		attributes.put("csTotle", getCsTotle());
		attributes.put("csPre", getCsPre());
		attributes.put("csJafy", getCsJafy());

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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
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

		Long manageAttr = (Long)attributes.get("manageAttr");

		if (manageAttr != null) {
			setManageAttr(manageAttr);
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

		Double ghhx = (Double)attributes.get("ghhx");

		if (ghhx != null) {
			setGhhx(ghhx);
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

		Double planTotle = (Double)attributes.get("planTotle");

		if (planTotle != null) {
			setPlanTotle(planTotle);
		}

		Double gkpfTotle = (Double)attributes.get("gkpfTotle");

		if (gkpfTotle != null) {
			setGkpfTotle(gkpfTotle);
		}

		Double gkpfPre = (Double)attributes.get("gkpfPre");

		if (gkpfPre != null) {
			setGkpfPre(gkpfPre);
		}

		Double gkpfJafy = (Double)attributes.get("gkpfJafy");

		if (gkpfJafy != null) {
			setGkpfJafy(gkpfJafy);
		}

		Double csTotle = (Double)attributes.get("csTotle");

		if (csTotle != null) {
			setCsTotle(csTotle);
		}

		Double csPre = (Double)attributes.get("csPre");

		if (csPre != null) {
			setCsPre(csPre);
		}

		Double csJafy = (Double)attributes.get("csJafy");

		if (csJafy != null) {
			setCsJafy(csJafy);
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
	* Returns the create date of this project.
	*
	* @return the create date of this project
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _project.getCreateDate();
	}

	/**
	* Sets the create date of this project.
	*
	* @param createDate the create date of this project
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_project.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this project.
	*
	* @return the modified date of this project
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _project.getModifiedDate();
	}

	/**
	* Sets the modified date of this project.
	*
	* @param modifiedDate the modified date of this project
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_project.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the bjbh of this project.
	*
	* @return the bjbh of this project
	*/
	@Override
	public java.lang.String getBjbh() {
		return _project.getBjbh();
	}

	/**
	* Sets the bjbh of this project.
	*
	* @param bjbh the bjbh of this project
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_project.setBjbh(bjbh);
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
	* Returns the manage attr of this project.
	*
	* @return the manage attr of this project
	*/
	@Override
	public long getManageAttr() {
		return _project.getManageAttr();
	}

	/**
	* Sets the manage attr of this project.
	*
	* @param manageAttr the manage attr of this project
	*/
	@Override
	public void setManageAttr(long manageAttr) {
		_project.setManageAttr(manageAttr);
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
	* Returns the ghhx of this project.
	*
	* @return the ghhx of this project
	*/
	@Override
	public double getGhhx() {
		return _project.getGhhx();
	}

	/**
	* Sets the ghhx of this project.
	*
	* @param ghhx the ghhx of this project
	*/
	@Override
	public void setGhhx(double ghhx) {
		_project.setGhhx(ghhx);
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
	* Returns the plan totle of this project.
	*
	* @return the plan totle of this project
	*/
	@Override
	public double getPlanTotle() {
		return _project.getPlanTotle();
	}

	/**
	* Sets the plan totle of this project.
	*
	* @param planTotle the plan totle of this project
	*/
	@Override
	public void setPlanTotle(double planTotle) {
		_project.setPlanTotle(planTotle);
	}

	/**
	* Returns the gkpf totle of this project.
	*
	* @return the gkpf totle of this project
	*/
	@Override
	public double getGkpfTotle() {
		return _project.getGkpfTotle();
	}

	/**
	* Sets the gkpf totle of this project.
	*
	* @param gkpfTotle the gkpf totle of this project
	*/
	@Override
	public void setGkpfTotle(double gkpfTotle) {
		_project.setGkpfTotle(gkpfTotle);
	}

	/**
	* Returns the gkpf pre of this project.
	*
	* @return the gkpf pre of this project
	*/
	@Override
	public double getGkpfPre() {
		return _project.getGkpfPre();
	}

	/**
	* Sets the gkpf pre of this project.
	*
	* @param gkpfPre the gkpf pre of this project
	*/
	@Override
	public void setGkpfPre(double gkpfPre) {
		_project.setGkpfPre(gkpfPre);
	}

	/**
	* Returns the gkpf jafy of this project.
	*
	* @return the gkpf jafy of this project
	*/
	@Override
	public double getGkpfJafy() {
		return _project.getGkpfJafy();
	}

	/**
	* Sets the gkpf jafy of this project.
	*
	* @param gkpfJafy the gkpf jafy of this project
	*/
	@Override
	public void setGkpfJafy(double gkpfJafy) {
		_project.setGkpfJafy(gkpfJafy);
	}

	/**
	* Returns the cs totle of this project.
	*
	* @return the cs totle of this project
	*/
	@Override
	public double getCsTotle() {
		return _project.getCsTotle();
	}

	/**
	* Sets the cs totle of this project.
	*
	* @param csTotle the cs totle of this project
	*/
	@Override
	public void setCsTotle(double csTotle) {
		_project.setCsTotle(csTotle);
	}

	/**
	* Returns the cs pre of this project.
	*
	* @return the cs pre of this project
	*/
	@Override
	public double getCsPre() {
		return _project.getCsPre();
	}

	/**
	* Sets the cs pre of this project.
	*
	* @param csPre the cs pre of this project
	*/
	@Override
	public void setCsPre(double csPre) {
		_project.setCsPre(csPre);
	}

	/**
	* Returns the cs jafy of this project.
	*
	* @return the cs jafy of this project
	*/
	@Override
	public double getCsJafy() {
		return _project.getCsJafy();
	}

	/**
	* Sets the cs jafy of this project.
	*
	* @param csJafy the cs jafy of this project
	*/
	@Override
	public void setCsJafy(double csJafy) {
		_project.setCsJafy(csJafy);
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