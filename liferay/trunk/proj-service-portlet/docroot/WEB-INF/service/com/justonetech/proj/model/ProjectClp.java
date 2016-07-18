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

import com.justonetech.proj.service.ClpSerializer;
import com.justonetech.proj.service.ProjectLocalServiceUtil;

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
 * @author fanqi
 */
public class ProjectClp extends BaseModelImpl<Project> implements Project {
	public ProjectClp() {
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
	public long getPrimaryKey() {
		return _projectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		Date createTime = (Date)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Date modifiedTime = (Date)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
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

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", long.class);

				method.invoke(_projectRemoteModel, projectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_projectRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_projectRemoteModel, companyId);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_projectRemoteModel, userId);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_projectRemoteModel, userName);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_projectRemoteModel, createTime);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_projectRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjbh() {
		return _bjbh;
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_projectRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjNum() {
		return _projNum;
	}

	@Override
	public void setProjNum(String projNum) {
		_projNum = projNum;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjNum", String.class);

				method.invoke(_projectRemoteModel, projNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSortNo() {
		return _sortNo;
	}

	@Override
	public void setSortNo(int sortNo) {
		_sortNo = sortNo;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSortNo", int.class);

				method.invoke(_projectRemoteModel, sortNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjStatus() {
		return _projStatus;
	}

	@Override
	public void setProjStatus(long projStatus) {
		_projStatus = projStatus;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjStatus", long.class);

				method.invoke(_projectRemoteModel, projStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndustryCategory() {
		return _industryCategory;
	}

	@Override
	public void setIndustryCategory(long industryCategory) {
		_industryCategory = industryCategory;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setIndustryCategory",
						long.class);

				method.invoke(_projectRemoteModel, industryCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getManageAttr() {
		return _manageAttr;
	}

	@Override
	public void setManageAttr(long manageAttr) {
		_manageAttr = manageAttr;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setManageAttr", long.class);

				method.invoke(_projectRemoteModel, manageAttr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsMajor() {
		return _isMajor;
	}

	@Override
	public boolean isIsMajor() {
		return _isMajor;
	}

	@Override
	public void setIsMajor(boolean isMajor) {
		_isMajor = isMajor;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMajor", boolean.class);

				method.invoke(_projectRemoteModel, isMajor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjSource() {
		return _projSource;
	}

	@Override
	public void setProjSource(long projSource) {
		_projSource = projSource;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjSource", long.class);

				method.invoke(_projectRemoteModel, projSource);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBelongCounty() {
		return _belongCounty;
	}

	@Override
	public void setBelongCounty(long belongCounty) {
		_belongCounty = belongCounty;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBelongCounty", long.class);

				method.invoke(_projectRemoteModel, belongCounty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjAttr() {
		return _projAttr;
	}

	@Override
	public void setProjAttr(long projAttr) {
		_projAttr = projAttr;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjAttr", long.class);

				method.invoke(_projectRemoteModel, projAttr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_projectRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_projectRemoteModel, endDate);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjName", String.class);

				method.invoke(_projectRemoteModel, projName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_projectRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInvolveCounty() {
		return _involveCounty;
	}

	@Override
	public void setInvolveCounty(String involveCounty) {
		_involveCounty = involveCounty;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setInvolveCounty", String.class);

				method.invoke(_projectRemoteModel, involveCounty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getGhhx() {
		return _ghhx;
	}

	@Override
	public void setGhhx(double ghhx) {
		_ghhx = ghhx;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGhhx", double.class);

				method.invoke(_projectRemoteModel, ghhx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRoadLevel() {
		return _roadLevel;
	}

	@Override
	public void setRoadLevel(long roadLevel) {
		_roadLevel = roadLevel;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setRoadLevel", long.class);

				method.invoke(_projectRemoteModel, roadLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRoadTechLevel() {
		return _roadTechLevel;
	}

	@Override
	public void setRoadTechLevel(long roadTechLevel) {
		_roadTechLevel = roadTechLevel;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setRoadTechLevel", long.class);

				method.invoke(_projectRemoteModel, roadTechLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartNode() {
		return _startNode;
	}

	@Override
	public void setStartNode(Date startNode) {
		_startNode = startNode;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setStartNode", Date.class);

				method.invoke(_projectRemoteModel, startNode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndNode() {
		return _endNode;
	}

	@Override
	public void setEndNode(Date endNode) {
		_endNode = endNode;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setEndNode", Date.class);

				method.invoke(_projectRemoteModel, endNode);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPlanStartDate", Date.class);

				method.invoke(_projectRemoteModel, planStartDate);
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

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPlanEndDate", Date.class);

				method.invoke(_projectRemoteModel, planEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIntroduction() {
		return _introduction;
	}

	@Override
	public void setIntroduction(String introduction) {
		_introduction = introduction;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setIntroduction", String.class);

				method.invoke(_projectRemoteModel, introduction);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPlanTotle() {
		return _planTotle;
	}

	@Override
	public void setPlanTotle(double planTotle) {
		_planTotle = planTotle;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPlanTotle", double.class);

				method.invoke(_projectRemoteModel, planTotle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getGkpfTotle() {
		return _gkpfTotle;
	}

	@Override
	public void setGkpfTotle(double gkpfTotle) {
		_gkpfTotle = gkpfTotle;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGkpfTotle", double.class);

				method.invoke(_projectRemoteModel, gkpfTotle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getGkpfPre() {
		return _gkpfPre;
	}

	@Override
	public void setGkpfPre(double gkpfPre) {
		_gkpfPre = gkpfPre;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGkpfPre", double.class);

				method.invoke(_projectRemoteModel, gkpfPre);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getGkpfJafy() {
		return _gkpfJafy;
	}

	@Override
	public void setGkpfJafy(double gkpfJafy) {
		_gkpfJafy = gkpfJafy;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGkpfJafy", double.class);

				method.invoke(_projectRemoteModel, gkpfJafy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCsTotle() {
		return _csTotle;
	}

	@Override
	public void setCsTotle(double csTotle) {
		_csTotle = csTotle;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCsTotle", double.class);

				method.invoke(_projectRemoteModel, csTotle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCsPre() {
		return _csPre;
	}

	@Override
	public void setCsPre(double csPre) {
		_csPre = csPre;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCsPre", double.class);

				method.invoke(_projectRemoteModel, csPre);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCsJafy() {
		return _csJafy;
	}

	@Override
	public void setCsJafy(double csJafy) {
		_csJafy = csJafy;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCsJafy", double.class);

				method.invoke(_projectRemoteModel, csJafy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProjectRemoteModel() {
		return _projectRemoteModel;
	}

	public void setProjectRemoteModel(BaseModel<?> projectRemoteModel) {
		_projectRemoteModel = projectRemoteModel;
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

		Class<?> remoteModelClass = _projectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_projectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProjectLocalServiceUtil.addProject(this);
		}
		else {
			ProjectLocalServiceUtil.updateProject(this);
		}
	}

	@Override
	public Project toEscapedModel() {
		return (Project)ProxyUtil.newProxyInstance(Project.class.getClassLoader(),
			new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProjectClp clone = new ProjectClp();

		clone.setProjectId(getProjectId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setBjbh(getBjbh());
		clone.setProjNum(getProjNum());
		clone.setSortNo(getSortNo());
		clone.setProjStatus(getProjStatus());
		clone.setIndustryCategory(getIndustryCategory());
		clone.setManageAttr(getManageAttr());
		clone.setIsMajor(getIsMajor());
		clone.setProjSource(getProjSource());
		clone.setBelongCounty(getBelongCounty());
		clone.setProjAttr(getProjAttr());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setProjName(getProjName());
		clone.setLocation(getLocation());
		clone.setInvolveCounty(getInvolveCounty());
		clone.setGhhx(getGhhx());
		clone.setRoadLevel(getRoadLevel());
		clone.setRoadTechLevel(getRoadTechLevel());
		clone.setStartNode(getStartNode());
		clone.setEndNode(getEndNode());
		clone.setPlanStartDate(getPlanStartDate());
		clone.setPlanEndDate(getPlanEndDate());
		clone.setIntroduction(getIntroduction());
		clone.setPlanTotle(getPlanTotle());
		clone.setGkpfTotle(getGkpfTotle());
		clone.setGkpfPre(getGkpfPre());
		clone.setGkpfJafy(getGkpfJafy());
		clone.setCsTotle(getCsTotle());
		clone.setCsPre(getCsPre());
		clone.setCsJafy(getCsJafy());

		return clone;
	}

	@Override
	public int compareTo(Project project) {
		int value = 0;

		if (getSortNo() < project.getSortNo()) {
			value = -1;
		}
		else if (getSortNo() > project.getSortNo()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getProjectId() < project.getProjectId()) {
			value = -1;
		}
		else if (getProjectId() > project.getProjectId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectClp)) {
			return false;
		}

		ProjectClp project = (ProjectClp)obj;

		long primaryKey = project.getPrimaryKey();

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

		sb.append("{projectId=");
		sb.append(getProjectId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", projNum=");
		sb.append(getProjNum());
		sb.append(", sortNo=");
		sb.append(getSortNo());
		sb.append(", projStatus=");
		sb.append(getProjStatus());
		sb.append(", industryCategory=");
		sb.append(getIndustryCategory());
		sb.append(", manageAttr=");
		sb.append(getManageAttr());
		sb.append(", isMajor=");
		sb.append(getIsMajor());
		sb.append(", projSource=");
		sb.append(getProjSource());
		sb.append(", belongCounty=");
		sb.append(getBelongCounty());
		sb.append(", projAttr=");
		sb.append(getProjAttr());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", projName=");
		sb.append(getProjName());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", involveCounty=");
		sb.append(getInvolveCounty());
		sb.append(", ghhx=");
		sb.append(getGhhx());
		sb.append(", roadLevel=");
		sb.append(getRoadLevel());
		sb.append(", roadTechLevel=");
		sb.append(getRoadTechLevel());
		sb.append(", startNode=");
		sb.append(getStartNode());
		sb.append(", endNode=");
		sb.append(getEndNode());
		sb.append(", planStartDate=");
		sb.append(getPlanStartDate());
		sb.append(", planEndDate=");
		sb.append(getPlanEndDate());
		sb.append(", introduction=");
		sb.append(getIntroduction());
		sb.append(", planTotle=");
		sb.append(getPlanTotle());
		sb.append(", gkpfTotle=");
		sb.append(getGkpfTotle());
		sb.append(", gkpfPre=");
		sb.append(getGkpfPre());
		sb.append(", gkpfJafy=");
		sb.append(getGkpfJafy());
		sb.append(", csTotle=");
		sb.append(getCsTotle());
		sb.append(", csPre=");
		sb.append(getCsPre());
		sb.append(", csJafy=");
		sb.append(getCsJafy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(115);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.proj.model.Project");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projNum</column-name><column-value><![CDATA[");
		sb.append(getProjNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortNo</column-name><column-value><![CDATA[");
		sb.append(getSortNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projStatus</column-name><column-value><![CDATA[");
		sb.append(getProjStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>industryCategory</column-name><column-value><![CDATA[");
		sb.append(getIndustryCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manageAttr</column-name><column-value><![CDATA[");
		sb.append(getManageAttr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMajor</column-name><column-value><![CDATA[");
		sb.append(getIsMajor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projSource</column-name><column-value><![CDATA[");
		sb.append(getProjSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>belongCounty</column-name><column-value><![CDATA[");
		sb.append(getBelongCounty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projAttr</column-name><column-value><![CDATA[");
		sb.append(getProjAttr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projName</column-name><column-value><![CDATA[");
		sb.append(getProjName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>involveCounty</column-name><column-value><![CDATA[");
		sb.append(getInvolveCounty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghhx</column-name><column-value><![CDATA[");
		sb.append(getGhhx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roadLevel</column-name><column-value><![CDATA[");
		sb.append(getRoadLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roadTechLevel</column-name><column-value><![CDATA[");
		sb.append(getRoadTechLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startNode</column-name><column-value><![CDATA[");
		sb.append(getStartNode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endNode</column-name><column-value><![CDATA[");
		sb.append(getEndNode());
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
			"<column><column-name>introduction</column-name><column-value><![CDATA[");
		sb.append(getIntroduction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>planTotle</column-name><column-value><![CDATA[");
		sb.append(getPlanTotle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gkpfTotle</column-name><column-value><![CDATA[");
		sb.append(getGkpfTotle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gkpfPre</column-name><column-value><![CDATA[");
		sb.append(getGkpfPre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gkpfJafy</column-name><column-value><![CDATA[");
		sb.append(getGkpfJafy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csTotle</column-name><column-value><![CDATA[");
		sb.append(getCsTotle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csPre</column-name><column-value><![CDATA[");
		sb.append(getCsPre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csJafy</column-name><column-value><![CDATA[");
		sb.append(getCsJafy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private String _bjbh;
	private String _projNum;
	private int _sortNo;
	private long _projStatus;
	private long _industryCategory;
	private long _manageAttr;
	private boolean _isMajor;
	private long _projSource;
	private long _belongCounty;
	private long _projAttr;
	private Date _startDate;
	private Date _endDate;
	private String _projName;
	private String _location;
	private String _involveCounty;
	private double _ghhx;
	private long _roadLevel;
	private long _roadTechLevel;
	private Date _startNode;
	private Date _endNode;
	private Date _planStartDate;
	private Date _planEndDate;
	private String _introduction;
	private double _planTotle;
	private double _gkpfTotle;
	private double _gkpfPre;
	private double _gkpfJafy;
	private double _csTotle;
	private double _csPre;
	private double _csJafy;
	private BaseModel<?> _projectRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.proj.service.ClpSerializer.class;
}