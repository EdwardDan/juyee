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
 * This class is a wrapper for {@link OfficeSupplyApply}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApply
 * @generated
 */
public class OfficeSupplyApplyWrapper implements OfficeSupplyApply,
	ModelWrapper<OfficeSupplyApply> {
	public OfficeSupplyApplyWrapper(OfficeSupplyApply officeSupplyApply) {
		_officeSupplyApply = officeSupplyApply;
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyApply.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyApply.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyApplyId", getOfficeSupplyApplyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("deptId", getDeptId());
		attributes.put("deptName", getDeptName());
		attributes.put("applicantId", getApplicantId());
		attributes.put("applicantName", getApplicantName());
		attributes.put("introductions", getIntroductions());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyApplyId = (Long)attributes.get("officeSupplyApplyId");

		if (officeSupplyApplyId != null) {
			setOfficeSupplyApplyId(officeSupplyApplyId);
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

		Long applicantId = (Long)attributes.get("applicantId");

		if (applicantId != null) {
			setApplicantId(applicantId);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String introductions = (String)attributes.get("introductions");

		if (introductions != null) {
			setIntroductions(introductions);
		}
	}

	/**
	* Returns the primary key of this office supply apply.
	*
	* @return the primary key of this office supply apply
	*/
	@Override
	public long getPrimaryKey() {
		return _officeSupplyApply.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office supply apply.
	*
	* @param primaryKey the primary key of this office supply apply
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_officeSupplyApply.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office supply apply ID of this office supply apply.
	*
	* @return the office supply apply ID of this office supply apply
	*/
	@Override
	public long getOfficeSupplyApplyId() {
		return _officeSupplyApply.getOfficeSupplyApplyId();
	}

	/**
	* Sets the office supply apply ID of this office supply apply.
	*
	* @param officeSupplyApplyId the office supply apply ID of this office supply apply
	*/
	@Override
	public void setOfficeSupplyApplyId(long officeSupplyApplyId) {
		_officeSupplyApply.setOfficeSupplyApplyId(officeSupplyApplyId);
	}

	/**
	* Returns the user ID of this office supply apply.
	*
	* @return the user ID of this office supply apply
	*/
	@Override
	public long getUserId() {
		return _officeSupplyApply.getUserId();
	}

	/**
	* Sets the user ID of this office supply apply.
	*
	* @param userId the user ID of this office supply apply
	*/
	@Override
	public void setUserId(long userId) {
		_officeSupplyApply.setUserId(userId);
	}

	/**
	* Returns the user uuid of this office supply apply.
	*
	* @return the user uuid of this office supply apply
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApply.getUserUuid();
	}

	/**
	* Sets the user uuid of this office supply apply.
	*
	* @param userUuid the user uuid of this office supply apply
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_officeSupplyApply.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this office supply apply.
	*
	* @return the user name of this office supply apply
	*/
	@Override
	public java.lang.String getUserName() {
		return _officeSupplyApply.getUserName();
	}

	/**
	* Sets the user name of this office supply apply.
	*
	* @param userName the user name of this office supply apply
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_officeSupplyApply.setUserName(userName);
	}

	/**
	* Returns the create time of this office supply apply.
	*
	* @return the create time of this office supply apply
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _officeSupplyApply.getCreateTime();
	}

	/**
	* Sets the create time of this office supply apply.
	*
	* @param createTime the create time of this office supply apply
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_officeSupplyApply.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this office supply apply.
	*
	* @return the modified time of this office supply apply
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _officeSupplyApply.getModifiedTime();
	}

	/**
	* Sets the modified time of this office supply apply.
	*
	* @param modifiedTime the modified time of this office supply apply
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_officeSupplyApply.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the dept ID of this office supply apply.
	*
	* @return the dept ID of this office supply apply
	*/
	@Override
	public long getDeptId() {
		return _officeSupplyApply.getDeptId();
	}

	/**
	* Sets the dept ID of this office supply apply.
	*
	* @param deptId the dept ID of this office supply apply
	*/
	@Override
	public void setDeptId(long deptId) {
		_officeSupplyApply.setDeptId(deptId);
	}

	/**
	* Returns the dept name of this office supply apply.
	*
	* @return the dept name of this office supply apply
	*/
	@Override
	public java.lang.String getDeptName() {
		return _officeSupplyApply.getDeptName();
	}

	/**
	* Sets the dept name of this office supply apply.
	*
	* @param deptName the dept name of this office supply apply
	*/
	@Override
	public void setDeptName(java.lang.String deptName) {
		_officeSupplyApply.setDeptName(deptName);
	}

	/**
	* Returns the applicant ID of this office supply apply.
	*
	* @return the applicant ID of this office supply apply
	*/
	@Override
	public long getApplicantId() {
		return _officeSupplyApply.getApplicantId();
	}

	/**
	* Sets the applicant ID of this office supply apply.
	*
	* @param applicantId the applicant ID of this office supply apply
	*/
	@Override
	public void setApplicantId(long applicantId) {
		_officeSupplyApply.setApplicantId(applicantId);
	}

	/**
	* Returns the applicant name of this office supply apply.
	*
	* @return the applicant name of this office supply apply
	*/
	@Override
	public java.lang.String getApplicantName() {
		return _officeSupplyApply.getApplicantName();
	}

	/**
	* Sets the applicant name of this office supply apply.
	*
	* @param applicantName the applicant name of this office supply apply
	*/
	@Override
	public void setApplicantName(java.lang.String applicantName) {
		_officeSupplyApply.setApplicantName(applicantName);
	}

	/**
	* Returns the introductions of this office supply apply.
	*
	* @return the introductions of this office supply apply
	*/
	@Override
	public java.lang.String getIntroductions() {
		return _officeSupplyApply.getIntroductions();
	}

	/**
	* Sets the introductions of this office supply apply.
	*
	* @param introductions the introductions of this office supply apply
	*/
	@Override
	public void setIntroductions(java.lang.String introductions) {
		_officeSupplyApply.setIntroductions(introductions);
	}

	@Override
	public boolean isNew() {
		return _officeSupplyApply.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_officeSupplyApply.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _officeSupplyApply.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_officeSupplyApply.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _officeSupplyApply.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _officeSupplyApply.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_officeSupplyApply.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _officeSupplyApply.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_officeSupplyApply.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_officeSupplyApply.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_officeSupplyApply.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeSupplyApplyWrapper((OfficeSupplyApply)_officeSupplyApply.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.OfficeSupplyApply officeSupplyApply) {
		return _officeSupplyApply.compareTo(officeSupplyApply);
	}

	@Override
	public int hashCode() {
		return _officeSupplyApply.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.OfficeSupplyApply> toCacheModel() {
		return _officeSupplyApply.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApply toEscapedModel() {
		return new OfficeSupplyApplyWrapper(_officeSupplyApply.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApply toUnescapedModel() {
		return new OfficeSupplyApplyWrapper(_officeSupplyApply.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _officeSupplyApply.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _officeSupplyApply.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_officeSupplyApply.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyApplyWrapper)) {
			return false;
		}

		OfficeSupplyApplyWrapper officeSupplyApplyWrapper = (OfficeSupplyApplyWrapper)obj;

		if (Validator.equals(_officeSupplyApply,
					officeSupplyApplyWrapper._officeSupplyApply)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OfficeSupplyApply getWrappedOfficeSupplyApply() {
		return _officeSupplyApply;
	}

	@Override
	public OfficeSupplyApply getWrappedModel() {
		return _officeSupplyApply;
	}

	@Override
	public void resetOriginalValues() {
		_officeSupplyApply.resetOriginalValues();
	}

	private OfficeSupplyApply _officeSupplyApply;
}