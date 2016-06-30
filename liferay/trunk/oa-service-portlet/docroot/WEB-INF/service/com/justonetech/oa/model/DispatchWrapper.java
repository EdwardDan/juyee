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
 * This class is a wrapper for {@link Dispatch}.
 * </p>
 *
 * @author justonetech
 * @see Dispatch
 * @generated
 */
public class DispatchWrapper implements Dispatch, ModelWrapper<Dispatch> {
	public DispatchWrapper(Dispatch dispatch) {
		_dispatch = dispatch;
	}

	@Override
	public Class<?> getModelClass() {
		return Dispatch.class;
	}

	@Override
	public String getModelClassName() {
		return Dispatch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dispatchId", getDispatchId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("rocordType", getRocordType());
		attributes.put("securityLevel", getSecurityLevel());
		attributes.put("organaAbbreviation", getOrganaAbbreviation());
		attributes.put("year", getYear());
		attributes.put("serialNo", getSerialNo());
		attributes.put("title", getTitle());
		attributes.put("sendOrgan", getSendOrgan());
		attributes.put("ccOrgan", getCcOrgan());
		attributes.put("writtenOrgan", getWrittenOrgan());
		attributes.put("writtenDate", getWrittenDate());
		attributes.put("urgencyDegree", getUrgencyDegree());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dispatchId = (Long)attributes.get("dispatchId");

		if (dispatchId != null) {
			setDispatchId(dispatchId);
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

		Long rocordType = (Long)attributes.get("rocordType");

		if (rocordType != null) {
			setRocordType(rocordType);
		}

		Long securityLevel = (Long)attributes.get("securityLevel");

		if (securityLevel != null) {
			setSecurityLevel(securityLevel);
		}

		Long organaAbbreviation = (Long)attributes.get("organaAbbreviation");

		if (organaAbbreviation != null) {
			setOrganaAbbreviation(organaAbbreviation);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer serialNo = (Integer)attributes.get("serialNo");

		if (serialNo != null) {
			setSerialNo(serialNo);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String sendOrgan = (String)attributes.get("sendOrgan");

		if (sendOrgan != null) {
			setSendOrgan(sendOrgan);
		}

		String ccOrgan = (String)attributes.get("ccOrgan");

		if (ccOrgan != null) {
			setCcOrgan(ccOrgan);
		}

		String writtenOrgan = (String)attributes.get("writtenOrgan");

		if (writtenOrgan != null) {
			setWrittenOrgan(writtenOrgan);
		}

		Date writtenDate = (Date)attributes.get("writtenDate");

		if (writtenDate != null) {
			setWrittenDate(writtenDate);
		}

		Long urgencyDegree = (Long)attributes.get("urgencyDegree");

		if (urgencyDegree != null) {
			setUrgencyDegree(urgencyDegree);
		}
	}

	/**
	* Returns the primary key of this dispatch.
	*
	* @return the primary key of this dispatch
	*/
	@Override
	public long getPrimaryKey() {
		return _dispatch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dispatch.
	*
	* @param primaryKey the primary key of this dispatch
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dispatch.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dispatch ID of this dispatch.
	*
	* @return the dispatch ID of this dispatch
	*/
	@Override
	public long getDispatchId() {
		return _dispatch.getDispatchId();
	}

	/**
	* Sets the dispatch ID of this dispatch.
	*
	* @param dispatchId the dispatch ID of this dispatch
	*/
	@Override
	public void setDispatchId(long dispatchId) {
		_dispatch.setDispatchId(dispatchId);
	}

	/**
	* Returns the user ID of this dispatch.
	*
	* @return the user ID of this dispatch
	*/
	@Override
	public long getUserId() {
		return _dispatch.getUserId();
	}

	/**
	* Sets the user ID of this dispatch.
	*
	* @param userId the user ID of this dispatch
	*/
	@Override
	public void setUserId(long userId) {
		_dispatch.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dispatch.
	*
	* @return the user uuid of this dispatch
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatch.getUserUuid();
	}

	/**
	* Sets the user uuid of this dispatch.
	*
	* @param userUuid the user uuid of this dispatch
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dispatch.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this dispatch.
	*
	* @return the user name of this dispatch
	*/
	@Override
	public java.lang.String getUserName() {
		return _dispatch.getUserName();
	}

	/**
	* Sets the user name of this dispatch.
	*
	* @param userName the user name of this dispatch
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dispatch.setUserName(userName);
	}

	/**
	* Returns the create time of this dispatch.
	*
	* @return the create time of this dispatch
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _dispatch.getCreateTime();
	}

	/**
	* Sets the create time of this dispatch.
	*
	* @param createTime the create time of this dispatch
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_dispatch.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this dispatch.
	*
	* @return the modified time of this dispatch
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _dispatch.getModifiedTime();
	}

	/**
	* Sets the modified time of this dispatch.
	*
	* @param modifiedTime the modified time of this dispatch
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_dispatch.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the rocord type of this dispatch.
	*
	* @return the rocord type of this dispatch
	*/
	@Override
	public long getRocordType() {
		return _dispatch.getRocordType();
	}

	/**
	* Sets the rocord type of this dispatch.
	*
	* @param rocordType the rocord type of this dispatch
	*/
	@Override
	public void setRocordType(long rocordType) {
		_dispatch.setRocordType(rocordType);
	}

	/**
	* Returns the security level of this dispatch.
	*
	* @return the security level of this dispatch
	*/
	@Override
	public long getSecurityLevel() {
		return _dispatch.getSecurityLevel();
	}

	/**
	* Sets the security level of this dispatch.
	*
	* @param securityLevel the security level of this dispatch
	*/
	@Override
	public void setSecurityLevel(long securityLevel) {
		_dispatch.setSecurityLevel(securityLevel);
	}

	/**
	* Returns the organa abbreviation of this dispatch.
	*
	* @return the organa abbreviation of this dispatch
	*/
	@Override
	public long getOrganaAbbreviation() {
		return _dispatch.getOrganaAbbreviation();
	}

	/**
	* Sets the organa abbreviation of this dispatch.
	*
	* @param organaAbbreviation the organa abbreviation of this dispatch
	*/
	@Override
	public void setOrganaAbbreviation(long organaAbbreviation) {
		_dispatch.setOrganaAbbreviation(organaAbbreviation);
	}

	/**
	* Returns the year of this dispatch.
	*
	* @return the year of this dispatch
	*/
	@Override
	public int getYear() {
		return _dispatch.getYear();
	}

	/**
	* Sets the year of this dispatch.
	*
	* @param year the year of this dispatch
	*/
	@Override
	public void setYear(int year) {
		_dispatch.setYear(year);
	}

	/**
	* Returns the serial no of this dispatch.
	*
	* @return the serial no of this dispatch
	*/
	@Override
	public int getSerialNo() {
		return _dispatch.getSerialNo();
	}

	/**
	* Sets the serial no of this dispatch.
	*
	* @param serialNo the serial no of this dispatch
	*/
	@Override
	public void setSerialNo(int serialNo) {
		_dispatch.setSerialNo(serialNo);
	}

	/**
	* Returns the title of this dispatch.
	*
	* @return the title of this dispatch
	*/
	@Override
	public java.lang.String getTitle() {
		return _dispatch.getTitle();
	}

	/**
	* Sets the title of this dispatch.
	*
	* @param title the title of this dispatch
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_dispatch.setTitle(title);
	}

	/**
	* Returns the send organ of this dispatch.
	*
	* @return the send organ of this dispatch
	*/
	@Override
	public java.lang.String getSendOrgan() {
		return _dispatch.getSendOrgan();
	}

	/**
	* Sets the send organ of this dispatch.
	*
	* @param sendOrgan the send organ of this dispatch
	*/
	@Override
	public void setSendOrgan(java.lang.String sendOrgan) {
		_dispatch.setSendOrgan(sendOrgan);
	}

	/**
	* Returns the cc organ of this dispatch.
	*
	* @return the cc organ of this dispatch
	*/
	@Override
	public java.lang.String getCcOrgan() {
		return _dispatch.getCcOrgan();
	}

	/**
	* Sets the cc organ of this dispatch.
	*
	* @param ccOrgan the cc organ of this dispatch
	*/
	@Override
	public void setCcOrgan(java.lang.String ccOrgan) {
		_dispatch.setCcOrgan(ccOrgan);
	}

	/**
	* Returns the written organ of this dispatch.
	*
	* @return the written organ of this dispatch
	*/
	@Override
	public java.lang.String getWrittenOrgan() {
		return _dispatch.getWrittenOrgan();
	}

	/**
	* Sets the written organ of this dispatch.
	*
	* @param writtenOrgan the written organ of this dispatch
	*/
	@Override
	public void setWrittenOrgan(java.lang.String writtenOrgan) {
		_dispatch.setWrittenOrgan(writtenOrgan);
	}

	/**
	* Returns the written date of this dispatch.
	*
	* @return the written date of this dispatch
	*/
	@Override
	public java.util.Date getWrittenDate() {
		return _dispatch.getWrittenDate();
	}

	/**
	* Sets the written date of this dispatch.
	*
	* @param writtenDate the written date of this dispatch
	*/
	@Override
	public void setWrittenDate(java.util.Date writtenDate) {
		_dispatch.setWrittenDate(writtenDate);
	}

	/**
	* Returns the urgency degree of this dispatch.
	*
	* @return the urgency degree of this dispatch
	*/
	@Override
	public long getUrgencyDegree() {
		return _dispatch.getUrgencyDegree();
	}

	/**
	* Sets the urgency degree of this dispatch.
	*
	* @param urgencyDegree the urgency degree of this dispatch
	*/
	@Override
	public void setUrgencyDegree(long urgencyDegree) {
		_dispatch.setUrgencyDegree(urgencyDegree);
	}

	@Override
	public boolean isNew() {
		return _dispatch.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dispatch.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dispatch.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dispatch.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dispatch.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dispatch.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dispatch.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dispatch.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dispatch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dispatch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dispatch.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DispatchWrapper((Dispatch)_dispatch.clone());
	}

	@Override
	public int compareTo(com.justonetech.oa.model.Dispatch dispatch) {
		return _dispatch.compareTo(dispatch);
	}

	@Override
	public int hashCode() {
		return _dispatch.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.Dispatch> toCacheModel() {
		return _dispatch.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.Dispatch toEscapedModel() {
		return new DispatchWrapper(_dispatch.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.Dispatch toUnescapedModel() {
		return new DispatchWrapper(_dispatch.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dispatch.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dispatch.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dispatch.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DispatchWrapper)) {
			return false;
		}

		DispatchWrapper dispatchWrapper = (DispatchWrapper)obj;

		if (Validator.equals(_dispatch, dispatchWrapper._dispatch)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Dispatch getWrappedDispatch() {
		return _dispatch;
	}

	@Override
	public Dispatch getWrappedModel() {
		return _dispatch;
	}

	@Override
	public void resetOriginalValues() {
		_dispatch.resetOriginalValues();
	}

	private Dispatch _dispatch;
}