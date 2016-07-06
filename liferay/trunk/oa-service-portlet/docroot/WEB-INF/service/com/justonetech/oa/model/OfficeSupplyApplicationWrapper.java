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
 * This class is a wrapper for {@link OfficeSupplyApplication}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplication
 * @generated
 */
public class OfficeSupplyApplicationWrapper implements OfficeSupplyApplication,
	ModelWrapper<OfficeSupplyApplication> {
	public OfficeSupplyApplicationWrapper(
		OfficeSupplyApplication officeSupplyApplication) {
		_officeSupplyApplication = officeSupplyApplication;
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyApplication.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyApplication.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyApplicationId",
			getOfficeSupplyApplicationId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("deptId", getDeptId());
		attributes.put("deptName", getDeptName());
		attributes.put("introductions", getIntroductions());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyApplicationId = (Long)attributes.get(
				"officeSupplyApplicationId");

		if (officeSupplyApplicationId != null) {
			setOfficeSupplyApplicationId(officeSupplyApplicationId);
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

		String introductions = (String)attributes.get("introductions");

		if (introductions != null) {
			setIntroductions(introductions);
		}
	}

	/**
	* Returns the primary key of this office supply application.
	*
	* @return the primary key of this office supply application
	*/
	@Override
	public long getPrimaryKey() {
		return _officeSupplyApplication.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office supply application.
	*
	* @param primaryKey the primary key of this office supply application
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_officeSupplyApplication.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office supply application ID of this office supply application.
	*
	* @return the office supply application ID of this office supply application
	*/
	@Override
	public long getOfficeSupplyApplicationId() {
		return _officeSupplyApplication.getOfficeSupplyApplicationId();
	}

	/**
	* Sets the office supply application ID of this office supply application.
	*
	* @param officeSupplyApplicationId the office supply application ID of this office supply application
	*/
	@Override
	public void setOfficeSupplyApplicationId(long officeSupplyApplicationId) {
		_officeSupplyApplication.setOfficeSupplyApplicationId(officeSupplyApplicationId);
	}

	/**
	* Returns the user ID of this office supply application.
	*
	* @return the user ID of this office supply application
	*/
	@Override
	public long getUserId() {
		return _officeSupplyApplication.getUserId();
	}

	/**
	* Sets the user ID of this office supply application.
	*
	* @param userId the user ID of this office supply application
	*/
	@Override
	public void setUserId(long userId) {
		_officeSupplyApplication.setUserId(userId);
	}

	/**
	* Returns the user uuid of this office supply application.
	*
	* @return the user uuid of this office supply application
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplication.getUserUuid();
	}

	/**
	* Sets the user uuid of this office supply application.
	*
	* @param userUuid the user uuid of this office supply application
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_officeSupplyApplication.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this office supply application.
	*
	* @return the user name of this office supply application
	*/
	@Override
	public java.lang.String getUserName() {
		return _officeSupplyApplication.getUserName();
	}

	/**
	* Sets the user name of this office supply application.
	*
	* @param userName the user name of this office supply application
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_officeSupplyApplication.setUserName(userName);
	}

	/**
	* Returns the create time of this office supply application.
	*
	* @return the create time of this office supply application
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _officeSupplyApplication.getCreateTime();
	}

	/**
	* Sets the create time of this office supply application.
	*
	* @param createTime the create time of this office supply application
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_officeSupplyApplication.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this office supply application.
	*
	* @return the modified time of this office supply application
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _officeSupplyApplication.getModifiedTime();
	}

	/**
	* Sets the modified time of this office supply application.
	*
	* @param modifiedTime the modified time of this office supply application
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_officeSupplyApplication.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the dept ID of this office supply application.
	*
	* @return the dept ID of this office supply application
	*/
	@Override
	public long getDeptId() {
		return _officeSupplyApplication.getDeptId();
	}

	/**
	* Sets the dept ID of this office supply application.
	*
	* @param deptId the dept ID of this office supply application
	*/
	@Override
	public void setDeptId(long deptId) {
		_officeSupplyApplication.setDeptId(deptId);
	}

	/**
	* Returns the dept name of this office supply application.
	*
	* @return the dept name of this office supply application
	*/
	@Override
	public java.lang.String getDeptName() {
		return _officeSupplyApplication.getDeptName();
	}

	/**
	* Sets the dept name of this office supply application.
	*
	* @param deptName the dept name of this office supply application
	*/
	@Override
	public void setDeptName(java.lang.String deptName) {
		_officeSupplyApplication.setDeptName(deptName);
	}

	/**
	* Returns the introductions of this office supply application.
	*
	* @return the introductions of this office supply application
	*/
	@Override
	public java.lang.String getIntroductions() {
		return _officeSupplyApplication.getIntroductions();
	}

	/**
	* Sets the introductions of this office supply application.
	*
	* @param introductions the introductions of this office supply application
	*/
	@Override
	public void setIntroductions(java.lang.String introductions) {
		_officeSupplyApplication.setIntroductions(introductions);
	}

	@Override
	public boolean isNew() {
		return _officeSupplyApplication.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_officeSupplyApplication.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _officeSupplyApplication.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_officeSupplyApplication.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _officeSupplyApplication.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _officeSupplyApplication.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_officeSupplyApplication.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _officeSupplyApplication.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_officeSupplyApplication.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_officeSupplyApplication.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_officeSupplyApplication.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeSupplyApplicationWrapper((OfficeSupplyApplication)_officeSupplyApplication.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.OfficeSupplyApplication officeSupplyApplication) {
		return _officeSupplyApplication.compareTo(officeSupplyApplication);
	}

	@Override
	public int hashCode() {
		return _officeSupplyApplication.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.OfficeSupplyApplication> toCacheModel() {
		return _officeSupplyApplication.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApplication toEscapedModel() {
		return new OfficeSupplyApplicationWrapper(_officeSupplyApplication.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApplication toUnescapedModel() {
		return new OfficeSupplyApplicationWrapper(_officeSupplyApplication.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _officeSupplyApplication.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _officeSupplyApplication.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_officeSupplyApplication.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyApplicationWrapper)) {
			return false;
		}

		OfficeSupplyApplicationWrapper officeSupplyApplicationWrapper = (OfficeSupplyApplicationWrapper)obj;

		if (Validator.equals(_officeSupplyApplication,
					officeSupplyApplicationWrapper._officeSupplyApplication)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OfficeSupplyApplication getWrappedOfficeSupplyApplication() {
		return _officeSupplyApplication;
	}

	@Override
	public OfficeSupplyApplication getWrappedModel() {
		return _officeSupplyApplication;
	}

	@Override
	public void resetOriginalValues() {
		_officeSupplyApplication.resetOriginalValues();
	}

	private OfficeSupplyApplication _officeSupplyApplication;
}