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

import com.justonetech.cyzt.leo.service.ClpSerializer;
import com.justonetech.cyzt.leo.service.LEOTrainingLocalServiceUtil;

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
public class LEOTrainingClp extends BaseModelImpl<LEOTraining>
	implements LEOTraining {
	public LEOTrainingClp() {
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
	public long getPrimaryKey() {
		return _trainingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTrainingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _trainingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getTrainingId() {
		return _trainingId;
	}

	@Override
	public void setTrainingId(long trainingId) {
		_trainingId = trainingId;

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setTrainingId", long.class);

				method.invoke(_leoTrainingRemoteModel, trainingId);
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

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leoTrainingRemoteModel, groupId);
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

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leoTrainingRemoteModel, companyId);
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

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leoTrainingRemoteModel, userId);
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

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_leoTrainingRemoteModel, userName);
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

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leoTrainingRemoteModel, createDate);
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

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leoTrainingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCertificateId() {
		return _certificateId;
	}

	@Override
	public void setCertificateId(long certificateId) {
		_certificateId = certificateId;

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateId", long.class);

				method.invoke(_leoTrainingRemoteModel, certificateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPxsj() {
		return _pxsj;
	}

	@Override
	public void setPxsj(Date pxsj) {
		_pxsj = pxsj;

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setPxsj", Date.class);

				method.invoke(_leoTrainingRemoteModel, pxsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getXcjysj() {
		return _xcjysj;
	}

	@Override
	public void setXcjysj(Date xcjysj) {
		_xcjysj = xcjysj;

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setXcjysj", Date.class);

				method.invoke(_leoTrainingRemoteModel, xcjysj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPxnr() {
		return _pxnr;
	}

	@Override
	public void setPxnr(String pxnr) {
		_pxnr = pxnr;

		if (_leoTrainingRemoteModel != null) {
			try {
				Class<?> clazz = _leoTrainingRemoteModel.getClass();

				Method method = clazz.getMethod("setPxnr", String.class);

				method.invoke(_leoTrainingRemoteModel, pxnr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLEOTrainingRemoteModel() {
		return _leoTrainingRemoteModel;
	}

	public void setLEOTrainingRemoteModel(BaseModel<?> leoTrainingRemoteModel) {
		_leoTrainingRemoteModel = leoTrainingRemoteModel;
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

		Class<?> remoteModelClass = _leoTrainingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leoTrainingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LEOTrainingLocalServiceUtil.addLEOTraining(this);
		}
		else {
			LEOTrainingLocalServiceUtil.updateLEOTraining(this);
		}
	}

	@Override
	public LEOTraining toEscapedModel() {
		return (LEOTraining)ProxyUtil.newProxyInstance(LEOTraining.class.getClassLoader(),
			new Class[] { LEOTraining.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LEOTrainingClp clone = new LEOTrainingClp();

		clone.setTrainingId(getTrainingId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCertificateId(getCertificateId());
		clone.setPxsj(getPxsj());
		clone.setXcjysj(getXcjysj());
		clone.setPxnr(getPxnr());

		return clone;
	}

	@Override
	public int compareTo(LEOTraining leoTraining) {
		long primaryKey = leoTraining.getPrimaryKey();

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

		if (!(obj instanceof LEOTrainingClp)) {
			return false;
		}

		LEOTrainingClp leoTraining = (LEOTrainingClp)obj;

		long primaryKey = leoTraining.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{trainingId=");
		sb.append(getTrainingId());
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
		sb.append(", certificateId=");
		sb.append(getCertificateId());
		sb.append(", pxsj=");
		sb.append(getPxsj());
		sb.append(", xcjysj=");
		sb.append(getXcjysj());
		sb.append(", pxnr=");
		sb.append(getPxnr());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cyzt.leo.model.LEOTraining");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>trainingId</column-name><column-value><![CDATA[");
		sb.append(getTrainingId());
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
			"<column><column-name>certificateId</column-name><column-value><![CDATA[");
		sb.append(getCertificateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pxsj</column-name><column-value><![CDATA[");
		sb.append(getPxsj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xcjysj</column-name><column-value><![CDATA[");
		sb.append(getXcjysj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pxnr</column-name><column-value><![CDATA[");
		sb.append(getPxnr());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _trainingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _certificateId;
	private Date _pxsj;
	private Date _xcjysj;
	private String _pxnr;
	private BaseModel<?> _leoTrainingRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cyzt.leo.service.ClpSerializer.class;
}