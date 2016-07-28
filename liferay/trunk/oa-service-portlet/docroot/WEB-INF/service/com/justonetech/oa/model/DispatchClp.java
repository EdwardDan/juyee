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

import com.justonetech.oa.service.ClpSerializer;
import com.justonetech.oa.service.DispatchLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author justonetech
 */
public class DispatchClp extends BaseModelImpl<Dispatch> implements Dispatch {
	public DispatchClp() {
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
	public long getPrimaryKey() {
		return _dispatchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDispatchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dispatchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dispatchId", getDispatchId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("recordType", getRecordType());
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

		Long recordType = (Long)attributes.get("recordType");

		if (recordType != null) {
			setRecordType(recordType);
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

	@Override
	public long getDispatchId() {
		return _dispatchId;
	}

	@Override
	public void setDispatchId(long dispatchId) {
		_dispatchId = dispatchId;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setDispatchId", long.class);

				method.invoke(_dispatchRemoteModel, dispatchId);
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

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dispatchRemoteModel, groupId);
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

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dispatchRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dispatchRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_dispatchRemoteModel, userName);
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

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_dispatchRemoteModel, createTime);
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

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_dispatchRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRecordType() {
		return _recordType;
	}

	@Override
	public void setRecordType(long recordType) {
		_recordType = recordType;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setRecordType", long.class);

				method.invoke(_dispatchRemoteModel, recordType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSecurityLevel() {
		return _securityLevel;
	}

	@Override
	public void setSecurityLevel(long securityLevel) {
		_securityLevel = securityLevel;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setSecurityLevel", long.class);

				method.invoke(_dispatchRemoteModel, securityLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganaAbbreviation() {
		return _organaAbbreviation;
	}

	@Override
	public void setOrganaAbbreviation(long organaAbbreviation) {
		_organaAbbreviation = organaAbbreviation;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganaAbbreviation",
						long.class);

				method.invoke(_dispatchRemoteModel, organaAbbreviation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_year = year;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_dispatchRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSerialNo() {
		return _serialNo;
	}

	@Override
	public void setSerialNo(int serialNo) {
		_serialNo = serialNo;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setSerialNo", int.class);

				method.invoke(_dispatchRemoteModel, serialNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_dispatchRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSendOrgan() {
		return _sendOrgan;
	}

	@Override
	public void setSendOrgan(String sendOrgan) {
		_sendOrgan = sendOrgan;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setSendOrgan", String.class);

				method.invoke(_dispatchRemoteModel, sendOrgan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCcOrgan() {
		return _ccOrgan;
	}

	@Override
	public void setCcOrgan(String ccOrgan) {
		_ccOrgan = ccOrgan;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setCcOrgan", String.class);

				method.invoke(_dispatchRemoteModel, ccOrgan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWrittenOrgan() {
		return _writtenOrgan;
	}

	@Override
	public void setWrittenOrgan(String writtenOrgan) {
		_writtenOrgan = writtenOrgan;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setWrittenOrgan", String.class);

				method.invoke(_dispatchRemoteModel, writtenOrgan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getWrittenDate() {
		return _writtenDate;
	}

	@Override
	public void setWrittenDate(Date writtenDate) {
		_writtenDate = writtenDate;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setWrittenDate", Date.class);

				method.invoke(_dispatchRemoteModel, writtenDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUrgencyDegree() {
		return _urgencyDegree;
	}

	@Override
	public void setUrgencyDegree(long urgencyDegree) {
		_urgencyDegree = urgencyDegree;

		if (_dispatchRemoteModel != null) {
			try {
				Class<?> clazz = _dispatchRemoteModel.getClass();

				Method method = clazz.getMethod("setUrgencyDegree", long.class);

				method.invoke(_dispatchRemoteModel, urgencyDegree);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDispatchRemoteModel() {
		return _dispatchRemoteModel;
	}

	public void setDispatchRemoteModel(BaseModel<?> dispatchRemoteModel) {
		_dispatchRemoteModel = dispatchRemoteModel;
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

		Class<?> remoteModelClass = _dispatchRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dispatchRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DispatchLocalServiceUtil.addDispatch(this);
		}
		else {
			DispatchLocalServiceUtil.updateDispatch(this);
		}
	}

	@Override
	public Dispatch toEscapedModel() {
		return (Dispatch)ProxyUtil.newProxyInstance(Dispatch.class.getClassLoader(),
			new Class[] { Dispatch.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DispatchClp clone = new DispatchClp();

		clone.setDispatchId(getDispatchId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setRecordType(getRecordType());
		clone.setSecurityLevel(getSecurityLevel());
		clone.setOrganaAbbreviation(getOrganaAbbreviation());
		clone.setYear(getYear());
		clone.setSerialNo(getSerialNo());
		clone.setTitle(getTitle());
		clone.setSendOrgan(getSendOrgan());
		clone.setCcOrgan(getCcOrgan());
		clone.setWrittenOrgan(getWrittenOrgan());
		clone.setWrittenDate(getWrittenDate());
		clone.setUrgencyDegree(getUrgencyDegree());

		return clone;
	}

	@Override
	public int compareTo(Dispatch dispatch) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedTime(), dispatch.getModifiedTime());

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

		if (!(obj instanceof DispatchClp)) {
			return false;
		}

		DispatchClp dispatch = (DispatchClp)obj;

		long primaryKey = dispatch.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{dispatchId=");
		sb.append(getDispatchId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", recordType=");
		sb.append(getRecordType());
		sb.append(", securityLevel=");
		sb.append(getSecurityLevel());
		sb.append(", organaAbbreviation=");
		sb.append(getOrganaAbbreviation());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", serialNo=");
		sb.append(getSerialNo());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", sendOrgan=");
		sb.append(getSendOrgan());
		sb.append(", ccOrgan=");
		sb.append(getCcOrgan());
		sb.append(", writtenOrgan=");
		sb.append(getWrittenOrgan());
		sb.append(", writtenDate=");
		sb.append(getWrittenDate());
		sb.append(", urgencyDegree=");
		sb.append(getUrgencyDegree());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.Dispatch");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dispatchId</column-name><column-value><![CDATA[");
		sb.append(getDispatchId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>recordType</column-name><column-value><![CDATA[");
		sb.append(getRecordType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityLevel</column-name><column-value><![CDATA[");
		sb.append(getSecurityLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organaAbbreviation</column-name><column-value><![CDATA[");
		sb.append(getOrganaAbbreviation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serialNo</column-name><column-value><![CDATA[");
		sb.append(getSerialNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendOrgan</column-name><column-value><![CDATA[");
		sb.append(getSendOrgan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccOrgan</column-name><column-value><![CDATA[");
		sb.append(getCcOrgan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenOrgan</column-name><column-value><![CDATA[");
		sb.append(getWrittenOrgan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenDate</column-name><column-value><![CDATA[");
		sb.append(getWrittenDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urgencyDegree</column-name><column-value><![CDATA[");
		sb.append(getUrgencyDegree());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dispatchId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _recordType;
	private long _securityLevel;
	private long _organaAbbreviation;
	private int _year;
	private int _serialNo;
	private String _title;
	private String _sendOrgan;
	private String _ccOrgan;
	private String _writtenOrgan;
	private Date _writtenDate;
	private long _urgencyDegree;
	private BaseModel<?> _dispatchRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}