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
import com.justonetech.oa.service.OfficeSupplyApplyLocalServiceUtil;

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
public class OfficeSupplyApplyClp extends BaseModelImpl<OfficeSupplyApply>
	implements OfficeSupplyApply {
	public OfficeSupplyApplyClp() {
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
	public long getPrimaryKey() {
		return _officeSupplyApplyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSupplyApplyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSupplyApplyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getOfficeSupplyApplyId() {
		return _officeSupplyApplyId;
	}

	@Override
	public void setOfficeSupplyApplyId(long officeSupplyApplyId) {
		_officeSupplyApplyId = officeSupplyApplyId;

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyApplyId",
						long.class);

				method.invoke(_officeSupplyApplyRemoteModel, officeSupplyApplyId);
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

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_officeSupplyApplyRemoteModel, userId);
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

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_officeSupplyApplyRemoteModel, userName);
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

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_officeSupplyApplyRemoteModel, createTime);
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

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_officeSupplyApplyRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDeptId() {
		return _deptId;
	}

	@Override
	public void setDeptId(long deptId) {
		_deptId = deptId;

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setDeptId", long.class);

				method.invoke(_officeSupplyApplyRemoteModel, deptId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeptName() {
		return _deptName;
	}

	@Override
	public void setDeptName(String deptName) {
		_deptName = deptName;

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setDeptName", String.class);

				method.invoke(_officeSupplyApplyRemoteModel, deptName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicantId() {
		return _applicantId;
	}

	@Override
	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantId", long.class);

				method.invoke(_officeSupplyApplyRemoteModel, applicantId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicantName() {
		return _applicantName;
	}

	@Override
	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantName", String.class);

				method.invoke(_officeSupplyApplyRemoteModel, applicantName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIntroductions() {
		return _introductions;
	}

	@Override
	public void setIntroductions(String introductions) {
		_introductions = introductions;

		if (_officeSupplyApplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyRemoteModel.getClass();

				Method method = clazz.getMethod("setIntroductions", String.class);

				method.invoke(_officeSupplyApplyRemoteModel, introductions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOfficeSupplyApplyRemoteModel() {
		return _officeSupplyApplyRemoteModel;
	}

	public void setOfficeSupplyApplyRemoteModel(
		BaseModel<?> officeSupplyApplyRemoteModel) {
		_officeSupplyApplyRemoteModel = officeSupplyApplyRemoteModel;
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

		Class<?> remoteModelClass = _officeSupplyApplyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_officeSupplyApplyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OfficeSupplyApplyLocalServiceUtil.addOfficeSupplyApply(this);
		}
		else {
			OfficeSupplyApplyLocalServiceUtil.updateOfficeSupplyApply(this);
		}
	}

	@Override
	public OfficeSupplyApply toEscapedModel() {
		return (OfficeSupplyApply)ProxyUtil.newProxyInstance(OfficeSupplyApply.class.getClassLoader(),
			new Class[] { OfficeSupplyApply.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfficeSupplyApplyClp clone = new OfficeSupplyApplyClp();

		clone.setOfficeSupplyApplyId(getOfficeSupplyApplyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setDeptId(getDeptId());
		clone.setDeptName(getDeptName());
		clone.setApplicantId(getApplicantId());
		clone.setApplicantName(getApplicantName());
		clone.setIntroductions(getIntroductions());

		return clone;
	}

	@Override
	public int compareTo(OfficeSupplyApply officeSupplyApply) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedTime(),
				officeSupplyApply.getModifiedTime());

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

		if (!(obj instanceof OfficeSupplyApplyClp)) {
			return false;
		}

		OfficeSupplyApplyClp officeSupplyApply = (OfficeSupplyApplyClp)obj;

		long primaryKey = officeSupplyApply.getPrimaryKey();

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

		sb.append("{officeSupplyApplyId=");
		sb.append(getOfficeSupplyApplyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", deptId=");
		sb.append(getDeptId());
		sb.append(", deptName=");
		sb.append(getDeptName());
		sb.append(", applicantId=");
		sb.append(getApplicantId());
		sb.append(", applicantName=");
		sb.append(getApplicantName());
		sb.append(", introductions=");
		sb.append(getIntroductions());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupplyApply");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyApplyId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyApplyId());
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
			"<column><column-name>deptId</column-name><column-value><![CDATA[");
		sb.append(getDeptId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deptName</column-name><column-value><![CDATA[");
		sb.append(getDeptName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantId</column-name><column-value><![CDATA[");
		sb.append(getApplicantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantName</column-name><column-value><![CDATA[");
		sb.append(getApplicantName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>introductions</column-name><column-value><![CDATA[");
		sb.append(getIntroductions());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _officeSupplyApplyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private long _applicantId;
	private String _applicantName;
	private String _introductions;
	private BaseModel<?> _officeSupplyApplyRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}