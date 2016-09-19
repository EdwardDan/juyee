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
 * This class is a wrapper for {@link LEOCertificate}.
 * </p>
 *
 * @author fanqi
 * @see LEOCertificate
 * @generated
 */
public class LEOCertificateWrapper implements LEOCertificate,
	ModelWrapper<LEOCertificate> {
	public LEOCertificateWrapper(LEOCertificate leoCertificate) {
		_leoCertificate = leoCertificate;
	}

	@Override
	public Class<?> getModelClass() {
		return LEOCertificate.class;
	}

	@Override
	public String getModelClassName() {
		return LEOCertificate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("certificateId", getCertificateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("xm", getXm());
		attributes.put("zjbh", getZjbh());
		attributes.put("zylx", getZylx());
		attributes.put("yxq", getYxq());
		attributes.put("fzrq", getFzrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long certificateId = (Long)attributes.get("certificateId");

		if (certificateId != null) {
			setCertificateId(certificateId);
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

		String xm = (String)attributes.get("xm");

		if (xm != null) {
			setXm(xm);
		}

		String zjbh = (String)attributes.get("zjbh");

		if (zjbh != null) {
			setZjbh(zjbh);
		}

		String zylx = (String)attributes.get("zylx");

		if (zylx != null) {
			setZylx(zylx);
		}

		Date yxq = (Date)attributes.get("yxq");

		if (yxq != null) {
			setYxq(yxq);
		}

		Date fzrq = (Date)attributes.get("fzrq");

		if (fzrq != null) {
			setFzrq(fzrq);
		}
	}

	/**
	* Returns the primary key of this l e o certificate.
	*
	* @return the primary key of this l e o certificate
	*/
	@Override
	public long getPrimaryKey() {
		return _leoCertificate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l e o certificate.
	*
	* @param primaryKey the primary key of this l e o certificate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_leoCertificate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the certificate ID of this l e o certificate.
	*
	* @return the certificate ID of this l e o certificate
	*/
	@Override
	public long getCertificateId() {
		return _leoCertificate.getCertificateId();
	}

	/**
	* Sets the certificate ID of this l e o certificate.
	*
	* @param certificateId the certificate ID of this l e o certificate
	*/
	@Override
	public void setCertificateId(long certificateId) {
		_leoCertificate.setCertificateId(certificateId);
	}

	/**
	* Returns the group ID of this l e o certificate.
	*
	* @return the group ID of this l e o certificate
	*/
	@Override
	public long getGroupId() {
		return _leoCertificate.getGroupId();
	}

	/**
	* Sets the group ID of this l e o certificate.
	*
	* @param groupId the group ID of this l e o certificate
	*/
	@Override
	public void setGroupId(long groupId) {
		_leoCertificate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this l e o certificate.
	*
	* @return the company ID of this l e o certificate
	*/
	@Override
	public long getCompanyId() {
		return _leoCertificate.getCompanyId();
	}

	/**
	* Sets the company ID of this l e o certificate.
	*
	* @param companyId the company ID of this l e o certificate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_leoCertificate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this l e o certificate.
	*
	* @return the user ID of this l e o certificate
	*/
	@Override
	public long getUserId() {
		return _leoCertificate.getUserId();
	}

	/**
	* Sets the user ID of this l e o certificate.
	*
	* @param userId the user ID of this l e o certificate
	*/
	@Override
	public void setUserId(long userId) {
		_leoCertificate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this l e o certificate.
	*
	* @return the user uuid of this l e o certificate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificate.getUserUuid();
	}

	/**
	* Sets the user uuid of this l e o certificate.
	*
	* @param userUuid the user uuid of this l e o certificate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_leoCertificate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this l e o certificate.
	*
	* @return the user name of this l e o certificate
	*/
	@Override
	public java.lang.String getUserName() {
		return _leoCertificate.getUserName();
	}

	/**
	* Sets the user name of this l e o certificate.
	*
	* @param userName the user name of this l e o certificate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_leoCertificate.setUserName(userName);
	}

	/**
	* Returns the create date of this l e o certificate.
	*
	* @return the create date of this l e o certificate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _leoCertificate.getCreateDate();
	}

	/**
	* Sets the create date of this l e o certificate.
	*
	* @param createDate the create date of this l e o certificate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_leoCertificate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this l e o certificate.
	*
	* @return the modified date of this l e o certificate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _leoCertificate.getModifiedDate();
	}

	/**
	* Sets the modified date of this l e o certificate.
	*
	* @param modifiedDate the modified date of this l e o certificate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_leoCertificate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the xm of this l e o certificate.
	*
	* @return the xm of this l e o certificate
	*/
	@Override
	public java.lang.String getXm() {
		return _leoCertificate.getXm();
	}

	/**
	* Sets the xm of this l e o certificate.
	*
	* @param xm the xm of this l e o certificate
	*/
	@Override
	public void setXm(java.lang.String xm) {
		_leoCertificate.setXm(xm);
	}

	/**
	* Returns the zjbh of this l e o certificate.
	*
	* @return the zjbh of this l e o certificate
	*/
	@Override
	public java.lang.String getZjbh() {
		return _leoCertificate.getZjbh();
	}

	/**
	* Sets the zjbh of this l e o certificate.
	*
	* @param zjbh the zjbh of this l e o certificate
	*/
	@Override
	public void setZjbh(java.lang.String zjbh) {
		_leoCertificate.setZjbh(zjbh);
	}

	/**
	* Returns the zylx of this l e o certificate.
	*
	* @return the zylx of this l e o certificate
	*/
	@Override
	public java.lang.String getZylx() {
		return _leoCertificate.getZylx();
	}

	/**
	* Sets the zylx of this l e o certificate.
	*
	* @param zylx the zylx of this l e o certificate
	*/
	@Override
	public void setZylx(java.lang.String zylx) {
		_leoCertificate.setZylx(zylx);
	}

	/**
	* Returns the yxq of this l e o certificate.
	*
	* @return the yxq of this l e o certificate
	*/
	@Override
	public java.util.Date getYxq() {
		return _leoCertificate.getYxq();
	}

	/**
	* Sets the yxq of this l e o certificate.
	*
	* @param yxq the yxq of this l e o certificate
	*/
	@Override
	public void setYxq(java.util.Date yxq) {
		_leoCertificate.setYxq(yxq);
	}

	/**
	* Returns the fzrq of this l e o certificate.
	*
	* @return the fzrq of this l e o certificate
	*/
	@Override
	public java.util.Date getFzrq() {
		return _leoCertificate.getFzrq();
	}

	/**
	* Sets the fzrq of this l e o certificate.
	*
	* @param fzrq the fzrq of this l e o certificate
	*/
	@Override
	public void setFzrq(java.util.Date fzrq) {
		_leoCertificate.setFzrq(fzrq);
	}

	@Override
	public boolean isNew() {
		return _leoCertificate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_leoCertificate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _leoCertificate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_leoCertificate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _leoCertificate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _leoCertificate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_leoCertificate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _leoCertificate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_leoCertificate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_leoCertificate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_leoCertificate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LEOCertificateWrapper((LEOCertificate)_leoCertificate.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate) {
		return _leoCertificate.compareTo(leoCertificate);
	}

	@Override
	public int hashCode() {
		return _leoCertificate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cyzt.leo.model.LEOCertificate> toCacheModel() {
		return _leoCertificate.toCacheModel();
	}

	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate toEscapedModel() {
		return new LEOCertificateWrapper(_leoCertificate.toEscapedModel());
	}

	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate toUnescapedModel() {
		return new LEOCertificateWrapper(_leoCertificate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _leoCertificate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _leoCertificate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_leoCertificate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LEOCertificateWrapper)) {
			return false;
		}

		LEOCertificateWrapper leoCertificateWrapper = (LEOCertificateWrapper)obj;

		if (Validator.equals(_leoCertificate,
					leoCertificateWrapper._leoCertificate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LEOCertificate getWrappedLEOCertificate() {
		return _leoCertificate;
	}

	@Override
	public LEOCertificate getWrappedModel() {
		return _leoCertificate;
	}

	@Override
	public void resetOriginalValues() {
		_leoCertificate.resetOriginalValues();
	}

	private LEOCertificate _leoCertificate;
}