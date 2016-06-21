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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.justonetech.proj.service.http.ProjectServiceSoap}.
 *
 * @author fanqi
 * @see com.justonetech.proj.service.http.ProjectServiceSoap
 * @generated
 */
public class ProjectSoap implements Serializable {
	public static ProjectSoap toSoapModel(Project model) {
		ProjectSoap soapModel = new ProjectSoap();

		soapModel.setProjectId(model.getProjectId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setProjNum(model.getProjNum());
		soapModel.setSortNo(model.getSortNo());
		soapModel.setProjStatus(model.getProjStatus());
		soapModel.setIndustryCategory(model.getIndustryCategory());
		soapModel.setManageAttr(model.getManageAttr());
		soapModel.setIsMajor(model.getIsMajor());
		soapModel.setProjSource(model.getProjSource());
		soapModel.setBelongCounty(model.getBelongCounty());
		soapModel.setProjAttr(model.getProjAttr());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setProjName(model.getProjName());
		soapModel.setLocation(model.getLocation());
		soapModel.setInvolveCounty(model.getInvolveCounty());
		soapModel.setGhhx(model.getGhhx());
		soapModel.setRoadLevel(model.getRoadLevel());
		soapModel.setRoadTechLevel(model.getRoadTechLevel());
		soapModel.setStartNode(model.getStartNode());
		soapModel.setEndNode(model.getEndNode());
		soapModel.setPlanStartDate(model.getPlanStartDate());
		soapModel.setPlanEndDate(model.getPlanEndDate());
		soapModel.setIntroduction(model.getIntroduction());
		soapModel.setPlanTotle(model.getPlanTotle());
		soapModel.setGkpfTotle(model.getGkpfTotle());
		soapModel.setGkpfPre(model.getGkpfPre());
		soapModel.setGkpfJafy(model.getGkpfJafy());
		soapModel.setCsTotle(model.getCsTotle());
		soapModel.setCsPre(model.getCsPre());
		soapModel.setCsJafy(model.getCsJafy());

		return soapModel;
	}

	public static ProjectSoap[] toSoapModels(Project[] models) {
		ProjectSoap[] soapModels = new ProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[][] toSoapModels(Project[][] models) {
		ProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[] toSoapModels(List<Project> models) {
		List<ProjectSoap> soapModels = new ArrayList<ProjectSoap>(models.size());

		for (Project model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectSoap[soapModels.size()]);
	}

	public ProjectSoap() {
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long pk) {
		setProjectId(pk);
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public String getProjNum() {
		return _projNum;
	}

	public void setProjNum(String projNum) {
		_projNum = projNum;
	}

	public int getSortNo() {
		return _sortNo;
	}

	public void setSortNo(int sortNo) {
		_sortNo = sortNo;
	}

	public long getProjStatus() {
		return _projStatus;
	}

	public void setProjStatus(long projStatus) {
		_projStatus = projStatus;
	}

	public long getIndustryCategory() {
		return _industryCategory;
	}

	public void setIndustryCategory(long industryCategory) {
		_industryCategory = industryCategory;
	}

	public long getManageAttr() {
		return _manageAttr;
	}

	public void setManageAttr(long manageAttr) {
		_manageAttr = manageAttr;
	}

	public boolean getIsMajor() {
		return _isMajor;
	}

	public boolean isIsMajor() {
		return _isMajor;
	}

	public void setIsMajor(boolean isMajor) {
		_isMajor = isMajor;
	}

	public long getProjSource() {
		return _projSource;
	}

	public void setProjSource(long projSource) {
		_projSource = projSource;
	}

	public long getBelongCounty() {
		return _belongCounty;
	}

	public void setBelongCounty(long belongCounty) {
		_belongCounty = belongCounty;
	}

	public long getProjAttr() {
		return _projAttr;
	}

	public void setProjAttr(long projAttr) {
		_projAttr = projAttr;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getProjName() {
		return _projName;
	}

	public void setProjName(String projName) {
		_projName = projName;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getInvolveCounty() {
		return _involveCounty;
	}

	public void setInvolveCounty(String involveCounty) {
		_involveCounty = involveCounty;
	}

	public double getGhhx() {
		return _ghhx;
	}

	public void setGhhx(double ghhx) {
		_ghhx = ghhx;
	}

	public long getRoadLevel() {
		return _roadLevel;
	}

	public void setRoadLevel(long roadLevel) {
		_roadLevel = roadLevel;
	}

	public long getRoadTechLevel() {
		return _roadTechLevel;
	}

	public void setRoadTechLevel(long roadTechLevel) {
		_roadTechLevel = roadTechLevel;
	}

	public Date getStartNode() {
		return _startNode;
	}

	public void setStartNode(Date startNode) {
		_startNode = startNode;
	}

	public Date getEndNode() {
		return _endNode;
	}

	public void setEndNode(Date endNode) {
		_endNode = endNode;
	}

	public Date getPlanStartDate() {
		return _planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		_planStartDate = planStartDate;
	}

	public Date getPlanEndDate() {
		return _planEndDate;
	}

	public void setPlanEndDate(Date planEndDate) {
		_planEndDate = planEndDate;
	}

	public String getIntroduction() {
		return _introduction;
	}

	public void setIntroduction(String introduction) {
		_introduction = introduction;
	}

	public double getPlanTotle() {
		return _planTotle;
	}

	public void setPlanTotle(double planTotle) {
		_planTotle = planTotle;
	}

	public double getGkpfTotle() {
		return _gkpfTotle;
	}

	public void setGkpfTotle(double gkpfTotle) {
		_gkpfTotle = gkpfTotle;
	}

	public double getGkpfPre() {
		return _gkpfPre;
	}

	public void setGkpfPre(double gkpfPre) {
		_gkpfPre = gkpfPre;
	}

	public double getGkpfJafy() {
		return _gkpfJafy;
	}

	public void setGkpfJafy(double gkpfJafy) {
		_gkpfJafy = gkpfJafy;
	}

	public double getCsTotle() {
		return _csTotle;
	}

	public void setCsTotle(double csTotle) {
		_csTotle = csTotle;
	}

	public double getCsPre() {
		return _csPre;
	}

	public void setCsPre(double csPre) {
		_csPre = csPre;
	}

	public double getCsJafy() {
		return _csJafy;
	}

	public void setCsJafy(double csJafy) {
		_csJafy = csJafy;
	}

	private long _projectId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
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
}