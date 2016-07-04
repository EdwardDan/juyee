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
 * This class is a wrapper for {@link OfficeSupplyRequisition}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisition
 * @generated
 */
public class OfficeSupplyRequisitionWrapper implements OfficeSupplyRequisition,
	ModelWrapper<OfficeSupplyRequisition> {
	public OfficeSupplyRequisitionWrapper(
		OfficeSupplyRequisition officeSupplyRequisition) {
		_officeSupplyRequisition = officeSupplyRequisition;
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyRequisition.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyRequisition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyRequisitionId",
			getOfficeSupplyRequisitionId());
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
		Long officeSupplyRequisitionId = (Long)attributes.get(
				"officeSupplyRequisitionId");

		if (officeSupplyRequisitionId != null) {
			setOfficeSupplyRequisitionId(officeSupplyRequisitionId);
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
	* Returns the primary key of this office supply requisition.
	*
	* @return the primary key of this office supply requisition
	*/
	@Override
	public long getPrimaryKey() {
		return _officeSupplyRequisition.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office supply requisition.
	*
	* @param primaryKey the primary key of this office supply requisition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_officeSupplyRequisition.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office supply requisition ID of this office supply requisition.
	*
	* @return the office supply requisition ID of this office supply requisition
	*/
	@Override
	public long getOfficeSupplyRequisitionId() {
		return _officeSupplyRequisition.getOfficeSupplyRequisitionId();
	}

	/**
	* Sets the office supply requisition ID of this office supply requisition.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID of this office supply requisition
	*/
	@Override
	public void setOfficeSupplyRequisitionId(long officeSupplyRequisitionId) {
		_officeSupplyRequisition.setOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

	/**
	* Returns the user ID of this office supply requisition.
	*
	* @return the user ID of this office supply requisition
	*/
	@Override
	public long getUserId() {
		return _officeSupplyRequisition.getUserId();
	}

	/**
	* Sets the user ID of this office supply requisition.
	*
	* @param userId the user ID of this office supply requisition
	*/
	@Override
	public void setUserId(long userId) {
		_officeSupplyRequisition.setUserId(userId);
	}

	/**
	* Returns the user uuid of this office supply requisition.
	*
	* @return the user uuid of this office supply requisition
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisition.getUserUuid();
	}

	/**
	* Sets the user uuid of this office supply requisition.
	*
	* @param userUuid the user uuid of this office supply requisition
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_officeSupplyRequisition.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this office supply requisition.
	*
	* @return the user name of this office supply requisition
	*/
	@Override
	public java.lang.String getUserName() {
		return _officeSupplyRequisition.getUserName();
	}

	/**
	* Sets the user name of this office supply requisition.
	*
	* @param userName the user name of this office supply requisition
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_officeSupplyRequisition.setUserName(userName);
	}

	/**
	* Returns the create time of this office supply requisition.
	*
	* @return the create time of this office supply requisition
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _officeSupplyRequisition.getCreateTime();
	}

	/**
	* Sets the create time of this office supply requisition.
	*
	* @param createTime the create time of this office supply requisition
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_officeSupplyRequisition.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this office supply requisition.
	*
	* @return the modified time of this office supply requisition
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _officeSupplyRequisition.getModifiedTime();
	}

	/**
	* Sets the modified time of this office supply requisition.
	*
	* @param modifiedTime the modified time of this office supply requisition
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_officeSupplyRequisition.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the dept ID of this office supply requisition.
	*
	* @return the dept ID of this office supply requisition
	*/
	@Override
	public long getDeptId() {
		return _officeSupplyRequisition.getDeptId();
	}

	/**
	* Sets the dept ID of this office supply requisition.
	*
	* @param deptId the dept ID of this office supply requisition
	*/
	@Override
	public void setDeptId(long deptId) {
		_officeSupplyRequisition.setDeptId(deptId);
	}

	/**
	* Returns the dept name of this office supply requisition.
	*
	* @return the dept name of this office supply requisition
	*/
	@Override
	public java.lang.String getDeptName() {
		return _officeSupplyRequisition.getDeptName();
	}

	/**
	* Sets the dept name of this office supply requisition.
	*
	* @param deptName the dept name of this office supply requisition
	*/
	@Override
	public void setDeptName(java.lang.String deptName) {
		_officeSupplyRequisition.setDeptName(deptName);
	}

	/**
	* Returns the applicant ID of this office supply requisition.
	*
	* @return the applicant ID of this office supply requisition
	*/
	@Override
	public long getApplicantId() {
		return _officeSupplyRequisition.getApplicantId();
	}

	/**
	* Sets the applicant ID of this office supply requisition.
	*
	* @param applicantId the applicant ID of this office supply requisition
	*/
	@Override
	public void setApplicantId(long applicantId) {
		_officeSupplyRequisition.setApplicantId(applicantId);
	}

	/**
	* Returns the applicant name of this office supply requisition.
	*
	* @return the applicant name of this office supply requisition
	*/
	@Override
	public java.lang.String getApplicantName() {
		return _officeSupplyRequisition.getApplicantName();
	}

	/**
	* Sets the applicant name of this office supply requisition.
	*
	* @param applicantName the applicant name of this office supply requisition
	*/
	@Override
	public void setApplicantName(java.lang.String applicantName) {
		_officeSupplyRequisition.setApplicantName(applicantName);
	}

	/**
	* Returns the introductions of this office supply requisition.
	*
	* @return the introductions of this office supply requisition
	*/
	@Override
	public java.lang.String getIntroductions() {
		return _officeSupplyRequisition.getIntroductions();
	}

	/**
	* Sets the introductions of this office supply requisition.
	*
	* @param introductions the introductions of this office supply requisition
	*/
	@Override
	public void setIntroductions(java.lang.String introductions) {
		_officeSupplyRequisition.setIntroductions(introductions);
	}

	@Override
	public boolean isNew() {
		return _officeSupplyRequisition.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_officeSupplyRequisition.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _officeSupplyRequisition.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_officeSupplyRequisition.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _officeSupplyRequisition.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _officeSupplyRequisition.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_officeSupplyRequisition.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _officeSupplyRequisition.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_officeSupplyRequisition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_officeSupplyRequisition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_officeSupplyRequisition.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeSupplyRequisitionWrapper((OfficeSupplyRequisition)_officeSupplyRequisition.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.OfficeSupplyRequisition officeSupplyRequisition) {
		return _officeSupplyRequisition.compareTo(officeSupplyRequisition);
	}

	@Override
	public int hashCode() {
		return _officeSupplyRequisition.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.OfficeSupplyRequisition> toCacheModel() {
		return _officeSupplyRequisition.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition toEscapedModel() {
		return new OfficeSupplyRequisitionWrapper(_officeSupplyRequisition.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition toUnescapedModel() {
		return new OfficeSupplyRequisitionWrapper(_officeSupplyRequisition.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _officeSupplyRequisition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _officeSupplyRequisition.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_officeSupplyRequisition.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyRequisitionWrapper)) {
			return false;
		}

		OfficeSupplyRequisitionWrapper officeSupplyRequisitionWrapper = (OfficeSupplyRequisitionWrapper)obj;

		if (Validator.equals(_officeSupplyRequisition,
					officeSupplyRequisitionWrapper._officeSupplyRequisition)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OfficeSupplyRequisition getWrappedOfficeSupplyRequisition() {
		return _officeSupplyRequisition;
	}

	@Override
	public OfficeSupplyRequisition getWrappedModel() {
		return _officeSupplyRequisition;
	}

	@Override
	public void resetOriginalValues() {
		_officeSupplyRequisition.resetOriginalValues();
	}

	private OfficeSupplyRequisition _officeSupplyRequisition;
}