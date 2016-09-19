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

package com.justonetech.cyzt.leo.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LEOTraining}.
 * </p>
 *
 * @author fanqi
 * @see LEOTraining
 * @generated
 */
public class LEOTrainingWrapper implements LEOTraining,
	ModelWrapper<LEOTraining> {
	public LEOTrainingWrapper(LEOTraining leoTraining) {
		_leoTraining = leoTraining;
	}

	@Override
	public Class<?> getModelClass() {
		return LEOTraining.class;
	}

	@Override
	public String getModelClassName() {
		return LEOTraining.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("trainingId", getTrainingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("certificateId", getCertificateId());
		attributes.put("pxsj", getPxsj());
		attributes.put("xcjysj", getXcjysj());
		attributes.put("pxnr", getPxnr());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long trainingId = (Long)attributes.get("trainingId");

		if (trainingId != null) {
			setTrainingId(trainingId);
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

		Long certificateId = (Long)attributes.get("certificateId");

		if (certificateId != null) {
			setCertificateId(certificateId);
		}

		Date pxsj = (Date)attributes.get("pxsj");

		if (pxsj != null) {
			setPxsj(pxsj);
		}

		Date xcjysj = (Date)attributes.get("xcjysj");

		if (xcjysj != null) {
			setXcjysj(xcjysj);
		}

		String pxnr = (String)attributes.get("pxnr");

		if (pxnr != null) {
			setPxnr(pxnr);
		}
	}

	/**
	* Returns the primary key of this l e o training.
	*
	* @return the primary key of this l e o training
	*/
	@Override
	public long getPrimaryKey() {
		return _leoTraining.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l e o training.
	*
	* @param primaryKey the primary key of this l e o training
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leoTraining.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the training ID of this l e o training.
	*
	* @return the training ID of this l e o training
	*/
	@Override
	public long getTrainingId() {
		return _leoTraining.getTrainingId();
	}

	/**
	* Sets the training ID of this l e o training.
	*
	* @param trainingId the training ID of this l e o training
	*/
	@Override
	public void setTrainingId(long trainingId) {
		_leoTraining.setTrainingId(trainingId);
	}

	/**
	* Returns the group ID of this l e o training.
	*
	* @return the group ID of this l e o training
	*/
	@Override
	public long getGroupId() {
		return _leoTraining.getGroupId();
	}

	/**
	* Sets the group ID of this l e o training.
	*
	* @param groupId the group ID of this l e o training
	*/
	@Override
	public void setGroupId(long groupId) {
		_leoTraining.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this l e o training.
	*
	* @return the company ID of this l e o training
	*/
	@Override
	public long getCompanyId() {
		return _leoTraining.getCompanyId();
	}

	/**
	* Sets the company ID of this l e o training.
	*
	* @param companyId the company ID of this l e o training
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leoTraining.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this l e o training.
	*
	* @return the user ID of this l e o training
	*/
	@Override
	public long getUserId() {
		return _leoTraining.getUserId();
	}

	/**
	* Sets the user ID of this l e o training.
	*
	* @param userId the user ID of this l e o training
	*/
	@Override
	public void setUserId(long userId) {
		_leoTraining.setUserId(userId);
	}

	/**
	* Returns the user uuid of this l e o training.
	*
	* @return the user uuid of this l e o training
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTraining.getUserUuid();
	}

	/**
	* Sets the user uuid of this l e o training.
	*
	* @param userUuid the user uuid of this l e o training
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leoTraining.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this l e o training.
	*
	* @return the user name of this l e o training
	*/
	@Override
	public java.lang.String getUserName() {
		return _leoTraining.getUserName();
	}

	/**
	* Sets the user name of this l e o training.
	*
	* @param userName the user name of this l e o training
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_leoTraining.setUserName(userName);
	}

	/**
	* Returns the create date of this l e o training.
	*
	* @return the create date of this l e o training
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leoTraining.getCreateDate();
	}

	/**
	* Sets the create date of this l e o training.
	*
	* @param createDate the create date of this l e o training
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leoTraining.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this l e o training.
	*
	* @return the modified date of this l e o training
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leoTraining.getModifiedDate();
	}

	/**
	* Sets the modified date of this l e o training.
	*
	* @param modifiedDate the modified date of this l e o training
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leoTraining.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the certificate ID of this l e o training.
	*
	* @return the certificate ID of this l e o training
	*/
	@Override
	public long getCertificateId() {
		return _leoTraining.getCertificateId();
	}

	/**
	* Sets the certificate ID of this l e o training.
	*
	* @param certificateId the certificate ID of this l e o training
	*/
	@Override
	public void setCertificateId(long certificateId) {
		_leoTraining.setCertificateId(certificateId);
	}

	/**
	* Returns the pxsj of this l e o training.
	*
	* @return the pxsj of this l e o training
	*/
	@Override
	public java.util.Date getPxsj() {
		return _leoTraining.getPxsj();
	}

	/**
	* Sets the pxsj of this l e o training.
	*
	* @param pxsj the pxsj of this l e o training
	*/
	@Override
	public void setPxsj(java.util.Date pxsj) {
		_leoTraining.setPxsj(pxsj);
	}

	/**
	* Returns the xcjysj of this l e o training.
	*
	* @return the xcjysj of this l e o training
	*/
	@Override
	public java.util.Date getXcjysj() {
		return _leoTraining.getXcjysj();
	}

	/**
	* Sets the xcjysj of this l e o training.
	*
	* @param xcjysj the xcjysj of this l e o training
	*/
	@Override
	public void setXcjysj(java.util.Date xcjysj) {
		_leoTraining.setXcjysj(xcjysj);
	}

	/**
	* Returns the pxnr of this l e o training.
	*
	* @return the pxnr of this l e o training
	*/
	@Override
	public java.lang.String getPxnr() {
		return _leoTraining.getPxnr();
	}

	/**
	* Sets the pxnr of this l e o training.
	*
	* @param pxnr the pxnr of this l e o training
	*/
	@Override
	public void setPxnr(java.lang.String pxnr) {
		_leoTraining.setPxnr(pxnr);
	}

	@Override
	public boolean isNew() {
		return _leoTraining.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leoTraining.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leoTraining.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leoTraining.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leoTraining.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leoTraining.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leoTraining.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leoTraining.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leoTraining.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leoTraining.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leoTraining.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LEOTrainingWrapper((LEOTraining)_leoTraining.clone());
	}

	@Override
	public int compareTo(com.justonetech.cyzt.leo.model.LEOTraining leoTraining) {
		return _leoTraining.compareTo(leoTraining);
	}

	@Override
	public int hashCode() {
		return _leoTraining.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cyzt.leo.model.LEOTraining> toCacheModel() {
		return _leoTraining.toCacheModel();
	}

	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining toEscapedModel() {
		return new LEOTrainingWrapper(_leoTraining.toEscapedModel());
	}

	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining toUnescapedModel() {
		return new LEOTrainingWrapper(_leoTraining.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leoTraining.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leoTraining.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leoTraining.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LEOTrainingWrapper)) {
			return false;
		}

		LEOTrainingWrapper leoTrainingWrapper = (LEOTrainingWrapper)obj;

		if (Validator.equals(_leoTraining, leoTrainingWrapper._leoTraining)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LEOTraining getWrappedLEOTraining() {
		return _leoTraining;
	}

	@Override
	public LEOTraining getWrappedModel() {
		return _leoTraining;
	}

	@Override
	public void resetOriginalValues() {
		_leoTraining.resetOriginalValues();
	}

	private LEOTraining _leoTraining;
}