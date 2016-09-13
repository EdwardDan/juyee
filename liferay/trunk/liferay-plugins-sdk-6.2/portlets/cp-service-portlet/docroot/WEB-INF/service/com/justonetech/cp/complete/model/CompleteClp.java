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

package com.justonetech.cp.complete.model;

import com.justonetech.cp.complete.service.ClpSerializer;
import com.justonetech.cp.complete.service.CompleteLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
 * @author fanqi
 */
public class CompleteClp extends BaseModelImpl<Complete> implements Complete {
	public CompleteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Complete.class;
	}

	@Override
	public String getModelClassName() {
		return Complete.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _completeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCompleteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _completeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("completeId", getCompleteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("bjbh", getBjbh());
		attributes.put("sqbz", getSqbz());
		attributes.put("status", getStatus());
		attributes.put("babh", getBabh());
		attributes.put("wssqbh", getWssqbh());
		attributes.put("sbrq", getSbrq());
		attributes.put("shyj", getShyj());
		attributes.put("shr", getShr());
		attributes.put("shrq", getShrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long completeId = (Long)attributes.get("completeId");

		if (completeId != null) {
			setCompleteId(completeId);
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

		String zzjgdm = (String)attributes.get("zzjgdm");

		if (zzjgdm != null) {
			setZzjgdm(zzjgdm);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		Integer sqbz = (Integer)attributes.get("sqbz");

		if (sqbz != null) {
			setSqbz(sqbz);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String babh = (String)attributes.get("babh");

		if (babh != null) {
			setBabh(babh);
		}

		String wssqbh = (String)attributes.get("wssqbh");

		if (wssqbh != null) {
			setWssqbh(wssqbh);
		}

		Date sbrq = (Date)attributes.get("sbrq");

		if (sbrq != null) {
			setSbrq(sbrq);
		}

		String shyj = (String)attributes.get("shyj");

		if (shyj != null) {
			setShyj(shyj);
		}

		String shr = (String)attributes.get("shr");

		if (shr != null) {
			setShr(shr);
		}

		Date shrq = (Date)attributes.get("shrq");

		if (shrq != null) {
			setShrq(shrq);
		}
	}

	@Override
	public long getCompleteId() {
		return _completeId;
	}

	@Override
	public void setCompleteId(long completeId) {
		_completeId = completeId;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleteId", long.class);

				method.invoke(_completeRemoteModel, completeId);
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

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_completeRemoteModel, groupId);
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

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_completeRemoteModel, companyId);
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

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_completeRemoteModel, userId);
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

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_completeRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_completeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_completeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZzjgdm() {
		return _zzjgdm;
	}

	@Override
	public void setZzjgdm(String zzjgdm) {
		_zzjgdm = zzjgdm;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setZzjgdm", String.class);

				method.invoke(_completeRemoteModel, zzjgdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjbh() {
		return _bjbh;
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_completeRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSqbz() {
		return _sqbz;
	}

	@Override
	public void setSqbz(int sqbz) {
		_sqbz = sqbz;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setSqbz", int.class);

				method.invoke(_completeRemoteModel, sqbz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_completeRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBabh() {
		return _babh;
	}

	@Override
	public void setBabh(String babh) {
		_babh = babh;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setBabh", String.class);

				method.invoke(_completeRemoteModel, babh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWssqbh() {
		return _wssqbh;
	}

	@Override
	public void setWssqbh(String wssqbh) {
		_wssqbh = wssqbh;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setWssqbh", String.class);

				method.invoke(_completeRemoteModel, wssqbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSbrq() {
		return _sbrq;
	}

	@Override
	public void setSbrq(Date sbrq) {
		_sbrq = sbrq;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setSbrq", Date.class);

				method.invoke(_completeRemoteModel, sbrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShyj() {
		return _shyj;
	}

	@Override
	public void setShyj(String shyj) {
		_shyj = shyj;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setShyj", String.class);

				method.invoke(_completeRemoteModel, shyj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShr() {
		return _shr;
	}

	@Override
	public void setShr(String shr) {
		_shr = shr;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setShr", String.class);

				method.invoke(_completeRemoteModel, shr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getShrq() {
		return _shrq;
	}

	@Override
	public void setShrq(Date shrq) {
		_shrq = shrq;

		if (_completeRemoteModel != null) {
			try {
				Class<?> clazz = _completeRemoteModel.getClass();

				Method method = clazz.getMethod("setShrq", Date.class);

				method.invoke(_completeRemoteModel, shrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCompleteRemoteModel() {
		return _completeRemoteModel;
	}

	public void setCompleteRemoteModel(BaseModel<?> completeRemoteModel) {
		_completeRemoteModel = completeRemoteModel;
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

		Class<?> remoteModelClass = _completeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_completeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompleteLocalServiceUtil.addComplete(this);
		}
		else {
			CompleteLocalServiceUtil.updateComplete(this);
		}
	}

	@Override
	public Complete toEscapedModel() {
		return (Complete)ProxyUtil.newProxyInstance(Complete.class.getClassLoader(),
			new Class[] { Complete.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CompleteClp clone = new CompleteClp();

		clone.setCompleteId(getCompleteId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setZzjgdm(getZzjgdm());
		clone.setBjbh(getBjbh());
		clone.setSqbz(getSqbz());
		clone.setStatus(getStatus());
		clone.setBabh(getBabh());
		clone.setWssqbh(getWssqbh());
		clone.setSbrq(getSbrq());
		clone.setShyj(getShyj());
		clone.setShr(getShr());
		clone.setShrq(getShrq());

		return clone;
	}

	@Override
	public int compareTo(Complete complete) {
		long primaryKey = complete.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompleteClp)) {
			return false;
		}

		CompleteClp complete = (CompleteClp)obj;

		long primaryKey = complete.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{completeId=");
		sb.append(getCompleteId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", zzjgdm=");
		sb.append(getZzjgdm());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", sqbz=");
		sb.append(getSqbz());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", babh=");
		sb.append(getBabh());
		sb.append(", wssqbh=");
		sb.append(getWssqbh());
		sb.append(", sbrq=");
		sb.append(getSbrq());
		sb.append(", shyj=");
		sb.append(getShyj());
		sb.append(", shr=");
		sb.append(getShr());
		sb.append(", shrq=");
		sb.append(getShrq());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.complete.model.Complete");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>completeId</column-name><column-value><![CDATA[");
		sb.append(getCompleteId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zzjgdm</column-name><column-value><![CDATA[");
		sb.append(getZzjgdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqbz</column-name><column-value><![CDATA[");
		sb.append(getSqbz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>babh</column-name><column-value><![CDATA[");
		sb.append(getBabh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wssqbh</column-name><column-value><![CDATA[");
		sb.append(getWssqbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sbrq</column-name><column-value><![CDATA[");
		sb.append(getSbrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shyj</column-name><column-value><![CDATA[");
		sb.append(getShyj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shr</column-name><column-value><![CDATA[");
		sb.append(getShr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shrq</column-name><column-value><![CDATA[");
		sb.append(getShrq());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _completeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _zzjgdm;
	private String _bjbh;
	private int _sqbz;
	private int _status;
	private String _babh;
	private String _wssqbh;
	private Date _sbrq;
	private String _shyj;
	private String _shr;
	private Date _shrq;
	private BaseModel<?> _completeRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.complete.service.ClpSerializer.class;
}