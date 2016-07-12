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

package com.justonetech.sys.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SMS}.
 * </p>
 *
 * @author justonetech
 * @see SMS
 * @generated
 */
public class SMSWrapper implements SMS, ModelWrapper<SMS> {
	public SMSWrapper(SMS sms) {
		_sms = sms;
	}

	@Override
	public Class<?> getModelClass() {
		return SMS.class;
	}

	@Override
	public String getModelClassName() {
		return SMS.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smsId", getSmsId());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("content", getContent());
		attributes.put("senderId", getSenderId());
		attributes.put("senderName", getSenderName());
		attributes.put("receiver", getReceiver());
		attributes.put("sendTime", getSendTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long smsId = (Long)attributes.get("smsId");

		if (smsId != null) {
			setSmsId(smsId);
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

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}

		String senderName = (String)attributes.get("senderName");

		if (senderName != null) {
			setSenderName(senderName);
		}

		String receiver = (String)attributes.get("receiver");

		if (receiver != null) {
			setReceiver(receiver);
		}

		Date sendTime = (Date)attributes.get("sendTime");

		if (sendTime != null) {
			setSendTime(sendTime);
		}
	}

	/**
	* Returns the primary key of this s m s.
	*
	* @return the primary key of this s m s
	*/
	@Override
	public long getPrimaryKey() {
		return _sms.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s m s.
	*
	* @param primaryKey the primary key of this s m s
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sms.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sms ID of this s m s.
	*
	* @return the sms ID of this s m s
	*/
	@Override
	public long getSmsId() {
		return _sms.getSmsId();
	}

	/**
	* Sets the sms ID of this s m s.
	*
	* @param smsId the sms ID of this s m s
	*/
	@Override
	public void setSmsId(long smsId) {
		_sms.setSmsId(smsId);
	}

	/**
	* Returns the create time of this s m s.
	*
	* @return the create time of this s m s
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _sms.getCreateTime();
	}

	/**
	* Sets the create time of this s m s.
	*
	* @param createTime the create time of this s m s
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_sms.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this s m s.
	*
	* @return the modified time of this s m s
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _sms.getModifiedTime();
	}

	/**
	* Sets the modified time of this s m s.
	*
	* @param modifiedTime the modified time of this s m s
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_sms.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the content of this s m s.
	*
	* @return the content of this s m s
	*/
	@Override
	public java.lang.String getContent() {
		return _sms.getContent();
	}

	/**
	* Sets the content of this s m s.
	*
	* @param content the content of this s m s
	*/
	@Override
	public void setContent(java.lang.String content) {
		_sms.setContent(content);
	}

	/**
	* Returns the sender ID of this s m s.
	*
	* @return the sender ID of this s m s
	*/
	@Override
	public long getSenderId() {
		return _sms.getSenderId();
	}

	/**
	* Sets the sender ID of this s m s.
	*
	* @param senderId the sender ID of this s m s
	*/
	@Override
	public void setSenderId(long senderId) {
		_sms.setSenderId(senderId);
	}

	/**
	* Returns the sender name of this s m s.
	*
	* @return the sender name of this s m s
	*/
	@Override
	public java.lang.String getSenderName() {
		return _sms.getSenderName();
	}

	/**
	* Sets the sender name of this s m s.
	*
	* @param senderName the sender name of this s m s
	*/
	@Override
	public void setSenderName(java.lang.String senderName) {
		_sms.setSenderName(senderName);
	}

	/**
	* Returns the receiver of this s m s.
	*
	* @return the receiver of this s m s
	*/
	@Override
	public java.lang.String getReceiver() {
		return _sms.getReceiver();
	}

	/**
	* Sets the receiver of this s m s.
	*
	* @param receiver the receiver of this s m s
	*/
	@Override
	public void setReceiver(java.lang.String receiver) {
		_sms.setReceiver(receiver);
	}

	/**
	* Returns the send time of this s m s.
	*
	* @return the send time of this s m s
	*/
	@Override
	public java.util.Date getSendTime() {
		return _sms.getSendTime();
	}

	/**
	* Sets the send time of this s m s.
	*
	* @param sendTime the send time of this s m s
	*/
	@Override
	public void setSendTime(java.util.Date sendTime) {
		_sms.setSendTime(sendTime);
	}

	@Override
	public boolean isNew() {
		return _sms.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sms.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sms.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sms.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sms.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sms.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sms.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sms.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sms.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sms.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sms.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SMSWrapper((SMS)_sms.clone());
	}

	@Override
	public int compareTo(com.justonetech.sys.model.SMS sms) {
		return _sms.compareTo(sms);
	}

	@Override
	public int hashCode() {
		return _sms.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.sys.model.SMS> toCacheModel() {
		return _sms.toCacheModel();
	}

	@Override
	public com.justonetech.sys.model.SMS toEscapedModel() {
		return new SMSWrapper(_sms.toEscapedModel());
	}

	@Override
	public com.justonetech.sys.model.SMS toUnescapedModel() {
		return new SMSWrapper(_sms.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sms.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sms.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sms.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SMSWrapper)) {
			return false;
		}

		SMSWrapper smsWrapper = (SMSWrapper)obj;

		if (Validator.equals(_sms, smsWrapper._sms)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SMS getWrappedSMS() {
		return _sms;
	}

	@Override
	public SMS getWrappedModel() {
		return _sms;
	}

	@Override
	public void resetOriginalValues() {
		_sms.resetOriginalValues();
	}

	private SMS _sms;
}