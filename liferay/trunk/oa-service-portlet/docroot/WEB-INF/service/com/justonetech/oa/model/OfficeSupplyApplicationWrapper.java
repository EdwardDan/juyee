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
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("deptId", getDeptId());
		attributes.put("deptName", getDeptName());
		attributes.put("introductions", getIntroductions());
		attributes.put("perposeClerk", getPerposeClerk());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyApplicationId = (Long)attributes.get(
				"officeSupplyApplicationId");

		if (officeSupplyApplicationId != null) {
			setOfficeSupplyApplicationId(officeSupplyApplicationId);
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

		String introductions = (String)attributes.get("introductions");

		if (introductions != null) {
			setIntroductions(introductions);
		}

		String perposeClerk = (String)attributes.get("perposeClerk");

		if (perposeClerk != null) {
			setPerposeClerk(perposeClerk);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
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
	* Returns the group ID of this office supply application.
	*
	* @return the group ID of this office supply application
	*/
	@Override
	public long getGroupId() {
		return _officeSupplyApplication.getGroupId();
	}

	/**
	* Sets the group ID of this office supply application.
	*
	* @param groupId the group ID of this office supply application
	*/
	@Override
	public void setGroupId(long groupId) {
		_officeSupplyApplication.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this office supply application.
	*
	* @return the company ID of this office supply application
	*/
	@Override
	public long getCompanyId() {
		return _officeSupplyApplication.getCompanyId();
	}

	/**
	* Sets the company ID of this office supply application.
	*
	* @param companyId the company ID of this office supply application
	*/
	@Override
	public void setCompanyId(long companyId) {
		_officeSupplyApplication.setCompanyId(companyId);
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

	/**
	* Returns the perpose clerk of this office supply application.
	*
	* @return the perpose clerk of this office supply application
	*/
	@Override
	public java.lang.String getPerposeClerk() {
		return _officeSupplyApplication.getPerposeClerk();
	}

	/**
	* Sets the perpose clerk of this office supply application.
	*
	* @param perposeClerk the perpose clerk of this office supply application
	*/
	@Override
	public void setPerposeClerk(java.lang.String perposeClerk) {
		_officeSupplyApplication.setPerposeClerk(perposeClerk);
	}

	/**
	* Returns the title of this office supply application.
	*
	* @return the title of this office supply application
	*/
	@Override
	public java.lang.String getTitle() {
		return _officeSupplyApplication.getTitle();
	}

	/**
	* Sets the title of this office supply application.
	*
	* @param title the title of this office supply application
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_officeSupplyApplication.setTitle(title);
	}

	/**
	* Returns the content of this office supply application.
	*
	* @return the content of this office supply application
	*/
	@Override
	public java.lang.String getContent() {
		return _officeSupplyApplication.getContent();
	}

	/**
	* Sets the content of this office supply application.
	*
	* @param content the content of this office supply application
	*/
	@Override
	public void setContent(java.lang.String content) {
		_officeSupplyApplication.setContent(content);
	}

	/**
	* Returns the status of this office supply application.
	*
	* @return the status of this office supply application
	*/
	@Override
	public int getStatus() {
		return _officeSupplyApplication.getStatus();
	}

	/**
	* Sets the status of this office supply application.
	*
	* @param status the status of this office supply application
	*/
	@Override
	public void setStatus(int status) {
		_officeSupplyApplication.setStatus(status);
	}

	/**
	* Returns the status by user ID of this office supply application.
	*
	* @return the status by user ID of this office supply application
	*/
	@Override
	public long getStatusByUserId() {
		return _officeSupplyApplication.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this office supply application.
	*
	* @param statusByUserId the status by user ID of this office supply application
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_officeSupplyApplication.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this office supply application.
	*
	* @return the status by user uuid of this office supply application
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplication.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this office supply application.
	*
	* @param statusByUserUuid the status by user uuid of this office supply application
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_officeSupplyApplication.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this office supply application.
	*
	* @return the status by user name of this office supply application
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _officeSupplyApplication.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this office supply application.
	*
	* @param statusByUserName the status by user name of this office supply application
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_officeSupplyApplication.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this office supply application.
	*
	* @return the status date of this office supply application
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _officeSupplyApplication.getStatusDate();
	}

	/**
	* Sets the status date of this office supply application.
	*
	* @param statusDate the status date of this office supply application
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_officeSupplyApplication.setStatusDate(statusDate);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _officeSupplyApplication.getApproved();
	}

	/**
	* Returns <code>true</code> if this office supply application is approved.
	*
	* @return <code>true</code> if this office supply application is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _officeSupplyApplication.isApproved();
	}

	/**
	* Returns <code>true</code> if this office supply application is denied.
	*
	* @return <code>true</code> if this office supply application is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _officeSupplyApplication.isDenied();
	}

	/**
	* Returns <code>true</code> if this office supply application is a draft.
	*
	* @return <code>true</code> if this office supply application is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _officeSupplyApplication.isDraft();
	}

	/**
	* Returns <code>true</code> if this office supply application is expired.
	*
	* @return <code>true</code> if this office supply application is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _officeSupplyApplication.isExpired();
	}

	/**
	* Returns <code>true</code> if this office supply application is inactive.
	*
	* @return <code>true</code> if this office supply application is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _officeSupplyApplication.isInactive();
	}

	/**
	* Returns <code>true</code> if this office supply application is incomplete.
	*
	* @return <code>true</code> if this office supply application is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _officeSupplyApplication.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this office supply application is pending.
	*
	* @return <code>true</code> if this office supply application is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _officeSupplyApplication.isPending();
	}

	/**
	* Returns <code>true</code> if this office supply application is scheduled.
	*
	* @return <code>true</code> if this office supply application is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _officeSupplyApplication.isScheduled();
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