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

package com.justonetech.oa.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LeaderWork}.
 * </p>
 *
 * @author justonetech
 * @see LeaderWork
 * @generated
 */
public class LeaderWorkWrapper implements LeaderWork, ModelWrapper<LeaderWork> {
	public LeaderWorkWrapper(LeaderWork leaderWork) {
		_leaderWork = leaderWork;
	}

	@Override
	public Class<?> getModelClass() {
		return LeaderWork.class;
	}

	@Override
	public String getModelClassName() {
		return LeaderWork.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("workDate", getWorkDate());
		attributes.put("amOrPm", getAmOrPm());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date workDate = (Date)attributes.get("workDate");

		if (workDate != null) {
			setWorkDate(workDate);
		}

		Long amOrPm = (Long)attributes.get("amOrPm");

		if (amOrPm != null) {
			setAmOrPm(amOrPm);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	/**
	* Returns the primary key of this leader work.
	*
	* @return the primary key of this leader work
	*/
	@Override
	public com.justonetech.oa.service.persistence.LeaderWorkPK getPrimaryKey() {
		return _leaderWork.getPrimaryKey();
	}

	/**
	* Sets the primary key of this leader work.
	*
	* @param primaryKey the primary key of this leader work
	*/
	@Override
	public void setPrimaryKey(
		com.justonetech.oa.service.persistence.LeaderWorkPK primaryKey) {
		_leaderWork.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this leader work.
	*
	* @return the user ID of this leader work
	*/
	@Override
	public long getUserId() {
		return _leaderWork.getUserId();
	}

	/**
	* Sets the user ID of this leader work.
	*
	* @param userId the user ID of this leader work
	*/
	@Override
	public void setUserId(long userId) {
		_leaderWork.setUserId(userId);
	}

	/**
	* Returns the user uuid of this leader work.
	*
	* @return the user uuid of this leader work
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaderWork.getUserUuid();
	}

	/**
	* Sets the user uuid of this leader work.
	*
	* @param userUuid the user uuid of this leader work
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leaderWork.setUserUuid(userUuid);
	}

	/**
	* Returns the work date of this leader work.
	*
	* @return the work date of this leader work
	*/
	@Override
	public java.util.Date getWorkDate() {
		return _leaderWork.getWorkDate();
	}

	/**
	* Sets the work date of this leader work.
	*
	* @param workDate the work date of this leader work
	*/
	@Override
	public void setWorkDate(java.util.Date workDate) {
		_leaderWork.setWorkDate(workDate);
	}

	/**
	* Returns the am or pm of this leader work.
	*
	* @return the am or pm of this leader work
	*/
	@Override
	public long getAmOrPm() {
		return _leaderWork.getAmOrPm();
	}

	/**
	* Sets the am or pm of this leader work.
	*
	* @param amOrPm the am or pm of this leader work
	*/
	@Override
	public void setAmOrPm(long amOrPm) {
		_leaderWork.setAmOrPm(amOrPm);
	}

	/**
	* Returns the group ID of this leader work.
	*
	* @return the group ID of this leader work
	*/
	@Override
	public long getGroupId() {
		return _leaderWork.getGroupId();
	}

	/**
	* Sets the group ID of this leader work.
	*
	* @param groupId the group ID of this leader work
	*/
	@Override
	public void setGroupId(long groupId) {
		_leaderWork.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this leader work.
	*
	* @return the company ID of this leader work
	*/
	@Override
	public long getCompanyId() {
		return _leaderWork.getCompanyId();
	}

	/**
	* Sets the company ID of this leader work.
	*
	* @param companyId the company ID of this leader work
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leaderWork.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this leader work.
	*
	* @return the user name of this leader work
	*/
	@Override
	public java.lang.String getUserName() {
		return _leaderWork.getUserName();
	}

	/**
	* Sets the user name of this leader work.
	*
	* @param userName the user name of this leader work
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_leaderWork.setUserName(userName);
	}

	/**
	* Returns the create time of this leader work.
	*
	* @return the create time of this leader work
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _leaderWork.getCreateTime();
	}

	/**
	* Sets the create time of this leader work.
	*
	* @param createTime the create time of this leader work
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_leaderWork.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this leader work.
	*
	* @return the modified time of this leader work
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _leaderWork.getModifiedTime();
	}

	/**
	* Sets the modified time of this leader work.
	*
	* @param modifiedTime the modified time of this leader work
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_leaderWork.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the content of this leader work.
	*
	* @return the content of this leader work
	*/
	@Override
	public java.lang.String getContent() {
		return _leaderWork.getContent();
	}

	/**
	* Sets the content of this leader work.
	*
	* @param content the content of this leader work
	*/
	@Override
	public void setContent(java.lang.String content) {
		_leaderWork.setContent(content);
	}

	@Override
	public boolean isNew() {
		return _leaderWork.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leaderWork.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leaderWork.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leaderWork.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leaderWork.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leaderWork.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leaderWork.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leaderWork.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leaderWork.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leaderWork.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leaderWork.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LeaderWorkWrapper((LeaderWork)_leaderWork.clone());
	}

	@Override
	public int compareTo(com.justonetech.oa.model.LeaderWork leaderWork) {
		return _leaderWork.compareTo(leaderWork);
	}

	@Override
	public int hashCode() {
		return _leaderWork.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.LeaderWork> toCacheModel() {
		return _leaderWork.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.LeaderWork toEscapedModel() {
		return new LeaderWorkWrapper(_leaderWork.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.LeaderWork toUnescapedModel() {
		return new LeaderWorkWrapper(_leaderWork.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leaderWork.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leaderWork.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leaderWork.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaderWorkWrapper)) {
			return false;
		}

		LeaderWorkWrapper leaderWorkWrapper = (LeaderWorkWrapper)obj;

		if (Validator.equals(_leaderWork, leaderWorkWrapper._leaderWork)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LeaderWork getWrappedLeaderWork() {
		return _leaderWork;
	}

	@Override
	public LeaderWork getWrappedModel() {
		return _leaderWork;
	}

	@Override
	public void resetOriginalValues() {
		_leaderWork.resetOriginalValues();
	}

	private LeaderWork _leaderWork;
}