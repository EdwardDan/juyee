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
import com.justonetech.oa.service.LeaderWorkLocalServiceUtil;
import com.justonetech.oa.service.persistence.LeaderWorkPK;

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
 * @author justonetech
 */
public class LeaderWorkClp extends BaseModelImpl<LeaderWork>
	implements LeaderWork {
	public LeaderWorkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LeaderWork.class;
	}

	@Override
	public String getModelClassName() {
		return LeaderWork.class.getName();
	}

	@Override
	public LeaderWorkPK getPrimaryKey() {
		return new LeaderWorkPK(_userId, _workDate, _amOrPm);
	}

	@Override
	public void setPrimaryKey(LeaderWorkPK primaryKey) {
		setUserId(primaryKey.userId);
		setWorkDate(primaryKey.workDate);
		setAmOrPm(primaryKey.amOrPm);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new LeaderWorkPK(_userId, _workDate, _amOrPm);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((LeaderWorkPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("workDate", getWorkDate());
		attributes.put("amOrPm", getAmOrPm());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long workDate = (Long)attributes.get("workDate");

		if (workDate != null) {
			setWorkDate(workDate);
		}

		Long amOrPm = (Long)attributes.get("amOrPm");

		if (amOrPm != null) {
			setAmOrPm(amOrPm);
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

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_leaderWorkRemoteModel != null) {
			try {
				Class<?> clazz = _leaderWorkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leaderWorkRemoteModel, userId);
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
	public long getWorkDate() {
		return _workDate;
	}

	@Override
	public void setWorkDate(long workDate) {
		_workDate = workDate;

		if (_leaderWorkRemoteModel != null) {
			try {
				Class<?> clazz = _leaderWorkRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkDate", long.class);

				method.invoke(_leaderWorkRemoteModel, workDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAmOrPm() {
		return _amOrPm;
	}

	@Override
	public void setAmOrPm(long amOrPm) {
		_amOrPm = amOrPm;

		if (_leaderWorkRemoteModel != null) {
			try {
				Class<?> clazz = _leaderWorkRemoteModel.getClass();

				Method method = clazz.getMethod("setAmOrPm", long.class);

				method.invoke(_leaderWorkRemoteModel, amOrPm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_leaderWorkRemoteModel != null) {
			try {
				Class<?> clazz = _leaderWorkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_leaderWorkRemoteModel, userName);
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

		if (_leaderWorkRemoteModel != null) {
			try {
				Class<?> clazz = _leaderWorkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_leaderWorkRemoteModel, createTime);
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

		if (_leaderWorkRemoteModel != null) {
			try {
				Class<?> clazz = _leaderWorkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_leaderWorkRemoteModel, modifiedTime);
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

		if (_leaderWorkRemoteModel != null) {
			try {
				Class<?> clazz = _leaderWorkRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_leaderWorkRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLeaderWorkRemoteModel() {
		return _leaderWorkRemoteModel;
	}

	public void setLeaderWorkRemoteModel(BaseModel<?> leaderWorkRemoteModel) {
		_leaderWorkRemoteModel = leaderWorkRemoteModel;
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

		Class<?> remoteModelClass = _leaderWorkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leaderWorkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LeaderWorkLocalServiceUtil.addLeaderWork(this);
		}
		else {
			LeaderWorkLocalServiceUtil.updateLeaderWork(this);
		}
	}

	@Override
	public LeaderWork toEscapedModel() {
		return (LeaderWork)ProxyUtil.newProxyInstance(LeaderWork.class.getClassLoader(),
			new Class[] { LeaderWork.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LeaderWorkClp clone = new LeaderWorkClp();

		clone.setUserId(getUserId());
		clone.setWorkDate(getWorkDate());
		clone.setAmOrPm(getAmOrPm());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(LeaderWork leaderWork) {
		LeaderWorkPK primaryKey = leaderWork.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaderWorkClp)) {
			return false;
		}

		LeaderWorkClp leaderWork = (LeaderWorkClp)obj;

		LeaderWorkPK primaryKey = leaderWork.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", workDate=");
		sb.append(getWorkDate());
		sb.append(", amOrPm=");
		sb.append(getAmOrPm());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.LeaderWork");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workDate</column-name><column-value><![CDATA[");
		sb.append(getWorkDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amOrPm</column-name><column-value><![CDATA[");
		sb.append(getAmOrPm());
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
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _workDate;
	private long _amOrPm;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private String _content;
	private BaseModel<?> _leaderWorkRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}