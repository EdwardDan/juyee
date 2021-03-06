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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Project service. Represents a row in the &quot;proj_Project&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.proj.model.impl.ProjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.proj.model.impl.ProjectImpl}.
 * </p>
 *
 * @author fanqi
 * @see Project
 * @see com.justonetech.proj.model.impl.ProjectImpl
 * @see com.justonetech.proj.model.impl.ProjectModelImpl
 * @generated
 */
public interface ProjectModel extends BaseModel<Project> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project model instance should use the {@link Project} interface instead.
	 */

	/**
	 * Returns the primary key of this project.
	 *
	 * @return the primary key of this project
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project.
	 *
	 * @param primaryKey the primary key of this project
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the project ID of this project.
	 *
	 * @return the project ID of this project
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this project.
	 *
	 * @param projectId the project ID of this project
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the group ID of this project.
	 *
	 * @return the group ID of this project
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this project.
	 *
	 * @param groupId the group ID of this project
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this project.
	 *
	 * @return the company ID of this project
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this project.
	 *
	 * @param companyId the company ID of this project
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this project.
	 *
	 * @return the user ID of this project
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this project.
	 *
	 * @param userId the user ID of this project
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this project.
	 *
	 * @return the user uuid of this project
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this project.
	 *
	 * @param userUuid the user uuid of this project
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this project.
	 *
	 * @return the user name of this project
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this project.
	 *
	 * @param userName the user name of this project
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create time of this project.
	 *
	 * @return the create time of this project
	 */
	public Date getCreateTime();

	/**
	 * Sets the create time of this project.
	 *
	 * @param createTime the create time of this project
	 */
	public void setCreateTime(Date createTime);

	/**
	 * Returns the modified time of this project.
	 *
	 * @return the modified time of this project
	 */
	public Date getModifiedTime();

	/**
	 * Sets the modified time of this project.
	 *
	 * @param modifiedTime the modified time of this project
	 */
	public void setModifiedTime(Date modifiedTime);

	/**
	 * Returns the construction code of this project.
	 *
	 * @return the construction code of this project
	 */
	@AutoEscape
	public String getConstructionCode();

	/**
	 * Sets the construction code of this project.
	 *
	 * @param constructionCode the construction code of this project
	 */
	public void setConstructionCode(String constructionCode);

	/**
	 * Returns the proj num of this project.
	 *
	 * @return the proj num of this project
	 */
	@AutoEscape
	public String getProjNum();

	/**
	 * Sets the proj num of this project.
	 *
	 * @param projNum the proj num of this project
	 */
	public void setProjNum(String projNum);

	/**
	 * Returns the sort no of this project.
	 *
	 * @return the sort no of this project
	 */
	public int getSortNo();

	/**
	 * Sets the sort no of this project.
	 *
	 * @param sortNo the sort no of this project
	 */
	public void setSortNo(int sortNo);

	/**
	 * Returns the proj status of this project.
	 *
	 * @return the proj status of this project
	 */
	public long getProjStatus();

	/**
	 * Sets the proj status of this project.
	 *
	 * @param projStatus the proj status of this project
	 */
	public void setProjStatus(long projStatus);

	/**
	 * Returns the industry category of this project.
	 *
	 * @return the industry category of this project
	 */
	public long getIndustryCategory();

	/**
	 * Sets the industry category of this project.
	 *
	 * @param industryCategory the industry category of this project
	 */
	public void setIndustryCategory(long industryCategory);

	/**
	 * Returns the manage attribute of this project.
	 *
	 * @return the manage attribute of this project
	 */
	public long getManageAttribute();

	/**
	 * Sets the manage attribute of this project.
	 *
	 * @param manageAttribute the manage attribute of this project
	 */
	public void setManageAttribute(long manageAttribute);

	/**
	 * Returns the is major of this project.
	 *
	 * @return the is major of this project
	 */
	public boolean getIsMajor();

	/**
	 * Returns <code>true</code> if this project is is major.
	 *
	 * @return <code>true</code> if this project is is major; <code>false</code> otherwise
	 */
	public boolean isIsMajor();

	/**
	 * Sets whether this project is is major.
	 *
	 * @param isMajor the is major of this project
	 */
	public void setIsMajor(boolean isMajor);

	/**
	 * Returns the proj source of this project.
	 *
	 * @return the proj source of this project
	 */
	public long getProjSource();

	/**
	 * Sets the proj source of this project.
	 *
	 * @param projSource the proj source of this project
	 */
	public void setProjSource(long projSource);

	/**
	 * Returns the belong county of this project.
	 *
	 * @return the belong county of this project
	 */
	public long getBelongCounty();

	/**
	 * Sets the belong county of this project.
	 *
	 * @param belongCounty the belong county of this project
	 */
	public void setBelongCounty(long belongCounty);

	/**
	 * Returns the proj attr of this project.
	 *
	 * @return the proj attr of this project
	 */
	public long getProjAttr();

	/**
	 * Sets the proj attr of this project.
	 *
	 * @param projAttr the proj attr of this project
	 */
	public void setProjAttr(long projAttr);

	/**
	 * Returns the start date of this project.
	 *
	 * @return the start date of this project
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this project.
	 *
	 * @param startDate the start date of this project
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this project.
	 *
	 * @return the end date of this project
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this project.
	 *
	 * @param endDate the end date of this project
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the proj name of this project.
	 *
	 * @return the proj name of this project
	 */
	@AutoEscape
	public String getProjName();

	/**
	 * Sets the proj name of this project.
	 *
	 * @param projName the proj name of this project
	 */
	public void setProjName(String projName);

	/**
	 * Returns the location of this project.
	 *
	 * @return the location of this project
	 */
	@AutoEscape
	public String getLocation();

	/**
	 * Sets the location of this project.
	 *
	 * @param location the location of this project
	 */
	public void setLocation(String location);

	/**
	 * Returns the involve county of this project.
	 *
	 * @return the involve county of this project
	 */
	@AutoEscape
	public String getInvolveCounty();

	/**
	 * Sets the involve county of this project.
	 *
	 * @param involveCounty the involve county of this project
	 */
	public void setInvolveCounty(String involveCounty);

	/**
	 * Returns the plan red line of this project.
	 *
	 * @return the plan red line of this project
	 */
	public double getPlanRedLine();

	/**
	 * Sets the plan red line of this project.
	 *
	 * @param planRedLine the plan red line of this project
	 */
	public void setPlanRedLine(double planRedLine);

	/**
	 * Returns the road level of this project.
	 *
	 * @return the road level of this project
	 */
	public long getRoadLevel();

	/**
	 * Sets the road level of this project.
	 *
	 * @param roadLevel the road level of this project
	 */
	public void setRoadLevel(long roadLevel);

	/**
	 * Returns the road tech level of this project.
	 *
	 * @return the road tech level of this project
	 */
	public long getRoadTechLevel();

	/**
	 * Sets the road tech level of this project.
	 *
	 * @param roadTechLevel the road tech level of this project
	 */
	public void setRoadTechLevel(long roadTechLevel);

	/**
	 * Returns the start node of this project.
	 *
	 * @return the start node of this project
	 */
	public Date getStartNode();

	/**
	 * Sets the start node of this project.
	 *
	 * @param startNode the start node of this project
	 */
	public void setStartNode(Date startNode);

	/**
	 * Returns the end node of this project.
	 *
	 * @return the end node of this project
	 */
	public Date getEndNode();

	/**
	 * Sets the end node of this project.
	 *
	 * @param endNode the end node of this project
	 */
	public void setEndNode(Date endNode);

	/**
	 * Returns the plan start date of this project.
	 *
	 * @return the plan start date of this project
	 */
	public Date getPlanStartDate();

	/**
	 * Sets the plan start date of this project.
	 *
	 * @param planStartDate the plan start date of this project
	 */
	public void setPlanStartDate(Date planStartDate);

	/**
	 * Returns the plan end date of this project.
	 *
	 * @return the plan end date of this project
	 */
	public Date getPlanEndDate();

	/**
	 * Sets the plan end date of this project.
	 *
	 * @param planEndDate the plan end date of this project
	 */
	public void setPlanEndDate(Date planEndDate);

	/**
	 * Returns the introduction of this project.
	 *
	 * @return the introduction of this project
	 */
	@AutoEscape
	public String getIntroduction();

	/**
	 * Sets the introduction of this project.
	 *
	 * @param introduction the introduction of this project
	 */
	public void setIntroduction(String introduction);

	/**
	 * Returns the plan total investment of this project.
	 *
	 * @return the plan total investment of this project
	 */
	public double getPlanTotalInvestment();

	/**
	 * Sets the plan total investment of this project.
	 *
	 * @param planTotalInvestment the plan total investment of this project
	 */
	public void setPlanTotalInvestment(double planTotalInvestment);

	/**
	 * Returns the feasibility total investment of this project.
	 *
	 * @return the feasibility total investment of this project
	 */
	public double getFeasibilityTotalInvestment();

	/**
	 * Sets the feasibility total investment of this project.
	 *
	 * @param feasibilityTotalInvestment the feasibility total investment of this project
	 */
	public void setFeasibilityTotalInvestment(double feasibilityTotalInvestment);

	/**
	 * Returns the feasibility pre cost of this project.
	 *
	 * @return the feasibility pre cost of this project
	 */
	public double getFeasibilityPreCost();

	/**
	 * Sets the feasibility pre cost of this project.
	 *
	 * @param feasibilityPreCost the feasibility pre cost of this project
	 */
	public void setFeasibilityPreCost(double feasibilityPreCost);

	/**
	 * Returns the feasibility jianan cost of this project.
	 *
	 * @return the feasibility jianan cost of this project
	 */
	public double getFeasibilityJiananCost();

	/**
	 * Sets the feasibility jianan cost of this project.
	 *
	 * @param feasibilityJiananCost the feasibility jianan cost of this project
	 */
	public void setFeasibilityJiananCost(double feasibilityJiananCost);

	/**
	 * Returns the first founded total investment of this project.
	 *
	 * @return the first founded total investment of this project
	 */
	public double getFirstFoundedTotalInvestment();

	/**
	 * Sets the first founded total investment of this project.
	 *
	 * @param firstFoundedTotalInvestment the first founded total investment of this project
	 */
	public void setFirstFoundedTotalInvestment(
		double firstFoundedTotalInvestment);

	/**
	 * Returns the first founded pre cost of this project.
	 *
	 * @return the first founded pre cost of this project
	 */
	public double getFirstFoundedPreCost();

	/**
	 * Sets the first founded pre cost of this project.
	 *
	 * @param firstFoundedPreCost the first founded pre cost of this project
	 */
	public void setFirstFoundedPreCost(double firstFoundedPreCost);

	/**
	 * Returns the first founded jianan cost of this project.
	 *
	 * @return the first founded jianan cost of this project
	 */
	public double getFirstFoundedJiananCost();

	/**
	 * Sets the first founded jianan cost of this project.
	 *
	 * @param firstFoundedJiananCost the first founded jianan cost of this project
	 */
	public void setFirstFoundedJiananCost(double firstFoundedJiananCost);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.justonetech.proj.model.Project project);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.proj.model.Project> toCacheModel();

	@Override
	public com.justonetech.proj.model.Project toEscapedModel();

	@Override
	public com.justonetech.proj.model.Project toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}