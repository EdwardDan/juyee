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

import com.justonetech.sys.service.ClpSerializer;
import com.justonetech.sys.service.SMSLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author justonetech
 */
public class SMSClp extends BaseModelImpl<SMS> implements SMS {
	public SMSClp() {
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
	public long getPrimaryKey() {
		return _smsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSmsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _smsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("smsId", getSmsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

	@Override
	public long getSmsId() {
		return _smsId;
	}

	@Override
	public void setSmsId(long smsId) {
		_smsId = smsId;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setSmsId", long.class);

				method.invoke(_smsRemoteModel, smsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_smsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_smsRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		_createTime = createTime;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_smsRemoteModel, createTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(Date modifiedTime) {
		_modifiedTime = modifiedTime;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_smsRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_smsRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSenderId() {
		return _senderId;
	}

	@Override
	public void setSenderId(long senderId) {
		_senderId = senderId;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderId", long.class);

				method.invoke(_smsRemoteModel, senderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSenderName() {
		return _senderName;
	}

	@Override
	public void setSenderName(String senderName) {
		_senderName = senderName;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderName", String.class);

				method.invoke(_smsRemoteModel, senderName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceiver() {
		return _receiver;
	}

	@Override
	public void setReceiver(String receiver) {
		_receiver = receiver;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiver", String.class);

				method.invoke(_smsRemoteModel, receiver);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSendTime() {
		return _sendTime;
	}

	@Override
	public void setSendTime(Date sendTime) {
		_sendTime = sendTime;

		if (_smsRemoteModel != null) {
			try {
				Class<?> clazz = _smsRemoteModel.getClass();

				Method method = clazz.getMethod("setSendTime", Date.class);

				method.invoke(_smsRemoteModel, sendTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSMSRemoteModel() {
		return _smsRemoteModel;
	}

	public void setSMSRemoteModel(BaseModel<?> smsRemoteModel) {
		_smsRemoteModel = smsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _smsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_smsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SMSLocalServiceUtil.addSMS(this);
		}
		else {
			SMSLocalServiceUtil.updateSMS(this);
		}
	}

	@Override
	public SMS toEscapedModel() {
		return (SMS)ProxyUtil.newProxyInstance(SMS.class.getClassLoader(),
			new Class[] { SMS.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SMSClp clone = new SMSClp();

		clone.setSmsId(getSmsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setContent(getContent());
		clone.setSenderId(getSenderId());
		clone.setSenderName(getSenderName());
		clone.setReceiver(getReceiver());
		clone.setSendTime(getSendTime());

		return clone;
	}

	@Override
	public int compareTo(SMS sms) {
		int value = 0;

		value = DateUtil.compareTo(getCreateTime(), sms.getCreateTime());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SMSClp)) {
			return false;
		}

		SMSClp sms = (SMSClp)obj;

		long primaryKey = sms.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{smsId=");
		sb.append(getSmsId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", senderId=");
		sb.append(getSenderId());
		sb.append(", senderName=");
		sb.append(getSenderName());
		sb.append(", receiver=");
		sb.append(getReceiver());
		sb.append(", sendTime=");
		sb.append(getSendTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.sys.model.SMS");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>smsId</column-name><column-value><![CDATA[");
		sb.append(getSmsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderId</column-name><column-value><![CDATA[");
		sb.append(getSenderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderName</column-name><column-value><![CDATA[");
		sb.append(getSenderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiver</column-name><column-value><![CDATA[");
		sb.append(getReceiver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendTime</column-name><column-value><![CDATA[");
		sb.append(getSendTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _smsId;
	private long _groupId;
	private long _companyId;
	private Date _createTime;
	private Date _modifiedTime;
	private String _content;
	private long _senderId;
	private String _senderName;
	private String _receiver;
	private Date _sendTime;
	private BaseModel<?> _smsRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.sys.service.ClpSerializer.class;
}