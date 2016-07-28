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
 * This class is a wrapper for {@link DeptWork}.
 * </p>
 *
 * @author justonetech
 * @see DeptWork
 * @generated
 */
public class DeptWorkWrapper implements DeptWork, ModelWrapper<DeptWork> {
	public DeptWorkWrapper(DeptWork deptWork) {
		_deptWork = deptWork;
	}

	@Override
	public Class<?> getModelClass() {
		return DeptWork.class;
	}

	@Override
	public String getModelClassName() {
		return DeptWork.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deptWorkId", getDeptWorkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("deptId", getDeptId());
		attributes.put("deptName", getDeptName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long deptWorkId = (Long)attributes.get("deptWorkId");

		if (deptWorkId != null) {
			setDeptWorkId(deptWorkId);
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

		Long deptId = (Long)attributes.get("deptId");

		if (deptId != null) {
			setDeptId(deptId);
		}

		String deptName = (String)attributes.get("deptName");

		if (deptName != null) {
			setDeptName(deptName);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this dept work.
	*
	* @return the primary key of this dept work
	*/
	@Override
	public long getPrimaryKey() {
		return _deptWork.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dept work.
	*
	* @param primaryKey the primary key of this dept work
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_deptWork.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dept work ID of this dept work.
	*
	* @return the dept work ID of this dept work
	*/
	@Override
	public long getDeptWorkId() {
		return _deptWork.getDeptWorkId();
	}

	/**
	* Sets the dept work ID of this dept work.
	*
	* @param deptWorkId the dept work ID of this dept work
	*/
	@Override
	public void setDeptWorkId(long deptWorkId) {
		_deptWork.setDeptWorkId(deptWorkId);
	}

	/**
	* Returns the group ID of this dept work.
	*
	* @return the group ID of this dept work
	*/
	@Override
	public long getGroupId() {
		return _deptWork.getGroupId();
	}

	/**
	* Sets the group ID of this dept work.
	*
	* @param groupId the group ID of this dept work
	*/
	@Override
	public void setGroupId(long groupId) {
		_deptWork.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this dept work.
	*
	* @return the company ID of this dept work
	*/
	@Override
	public long getCompanyId() {
		return _deptWork.getCompanyId();
	}

	/**
	* Sets the company ID of this dept work.
	*
	* @param companyId the company ID of this dept work
	*/
	@Override
	public void setCompanyId(long companyId) {
		_deptWork.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this dept work.
	*
	* @return the user ID of this dept work
	*/
	@Override
	public long getUserId() {
		return _deptWork.getUserId();
	}

	/**
	* Sets the user ID of this dept work.
	*
	* @param userId the user ID of this dept work
	*/
	@Override
	public void setUserId(long userId) {
		_deptWork.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dept work.
	*
	* @return the user uuid of this dept work
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWork.getUserUuid();
	}

	/**
	* Sets the user uuid of this dept work.
	*
	* @param userUuid the user uuid of this dept work
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_deptWork.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this dept work.
	*
	* @return the user name of this dept work
	*/
	@Override
	public java.lang.String getUserName() {
		return _deptWork.getUserName();
	}

	/**
	* Sets the user name of this dept work.
	*
	* @param userName the user name of this dept work
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_deptWork.setUserName(userName);
	}

	/**
	* Returns the create time of this dept work.
	*
	* @return the create time of this dept work
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _deptWork.getCreateTime();
	}

	/**
	* Sets the create time of this dept work.
	*
	* @param createTime the create time of this dept work
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_deptWork.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this dept work.
	*
	* @return the modified time of this dept work
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _deptWork.getModifiedTime();
	}

	/**
	* Sets the modified time of this dept work.
	*
	* @param modifiedTime the modified time of this dept work
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_deptWork.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the dept ID of this dept work.
	*
	* @return the dept ID of this dept work
	*/
	@Override
	public long getDeptId() {
		return _deptWork.getDeptId();
	}

	/**
	* Sets the dept ID of this dept work.
	*
	* @param deptId the dept ID of this dept work
	*/
	@Override
	public void setDeptId(long deptId) {
		_deptWork.setDeptId(deptId);
	}

	/**
	* Returns the dept name of this dept work.
	*
	* @return the dept name of this dept work
	*/
	@Override
	public java.lang.String getDeptName() {
		return _deptWork.getDeptName();
	}

	/**
	* Sets the dept name of this dept work.
	*
	* @param deptName the dept name of this dept work
	*/
	@Override
	public void setDeptName(java.lang.String deptName) {
		_deptWork.setDeptName(deptName);
	}

	/**
	* Returns the start date of this dept work.
	*
	* @return the start date of this dept work
	*/
	@Override
	public java.util.Date getStartDate() {
		return _deptWork.getStartDate();
	}

	/**
	* Sets the start date of this dept work.
	*
	* @param startDate the start date of this dept work
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_deptWork.setStartDate(startDate);
	}

	/**
	* Returns the end date of this dept work.
	*
	* @return the end date of this dept work
	*/
	@Override
	public java.util.Date getEndDate() {
		return _deptWork.getEndDate();
	}

	/**
	* Sets the end date of this dept work.
	*
	* @param endDate the end date of this dept work
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_deptWork.setEndDate(endDate);
	}

	/**
	* Returns the status of this dept work.
	*
	* @return the status of this dept work
	*/
	@Override
	public java.lang.String getStatus() {
		return _deptWork.getStatus();
	}

	/**
	* Sets the status of this dept work.
	*
	* @param status the status of this dept work
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_deptWork.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _deptWork.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_deptWork.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _deptWork.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_deptWork.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _deptWork.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _deptWork.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_deptWork.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _deptWork.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_deptWork.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_deptWork.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_deptWork.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DeptWorkWrapper((DeptWork)_deptWork.clone());
	}

	@Override
	public int compareTo(com.justonetech.oa.model.DeptWork deptWork) {
		return _deptWork.compareTo(deptWork);
	}

	@Override
	public int hashCode() {
		return _deptWork.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.DeptWork> toCacheModel() {
		return _deptWork.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.DeptWork toEscapedModel() {
		return new DeptWorkWrapper(_deptWork.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.DeptWork toUnescapedModel() {
		return new DeptWorkWrapper(_deptWork.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _deptWork.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _deptWork.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_deptWork.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeptWorkWrapper)) {
			return false;
		}

		DeptWorkWrapper deptWorkWrapper = (DeptWorkWrapper)obj;

		if (Validator.equals(_deptWork, deptWorkWrapper._deptWork)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DeptWork getWrappedDeptWork() {
		return _deptWork;
	}

	@Override
	public DeptWork getWrappedModel() {
		return _deptWork;
	}

	@Override
	public void resetOriginalValues() {
		_deptWork.resetOriginalValues();
	}

	private DeptWork _deptWork;
}