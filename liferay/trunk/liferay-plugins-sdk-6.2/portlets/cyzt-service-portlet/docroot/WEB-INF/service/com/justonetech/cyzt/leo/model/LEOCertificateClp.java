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
import com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil;

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
public class LEOCertificateClp extends BaseModelImpl<LEOCertificate>
	implements LEOCertificate {
	public LEOCertificateClp() {
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
	public String getPrimaryKey() {
		return _certificateId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCertificateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _certificateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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
		attributes.put("zylx", getZylx());
		attributes.put("yxq", getYxq());
		attributes.put("fzrq", getFzrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String certificateId = (String)attributes.get("certificateId");

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

	@Override
	public String getCertificateId() {
		return _certificateId;
	}

	@Override
	public void setCertificateId(String certificateId) {
		_certificateId = certificateId;

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateId", String.class);

				method.invoke(_leoCertificateRemoteModel, certificateId);
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

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_leoCertificateRemoteModel, groupId);
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

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_leoCertificateRemoteModel, companyId);
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

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_leoCertificateRemoteModel, userId);
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

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_leoCertificateRemoteModel, userName);
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

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_leoCertificateRemoteModel, createDate);
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

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_leoCertificateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXm() {
		return _xm;
	}

	@Override
	public void setXm(String xm) {
		_xm = xm;

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setXm", String.class);

				method.invoke(_leoCertificateRemoteModel, xm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZylx() {
		return _zylx;
	}

	@Override
	public void setZylx(String zylx) {
		_zylx = zylx;

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setZylx", String.class);

				method.invoke(_leoCertificateRemoteModel, zylx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getYxq() {
		return _yxq;
	}

	@Override
	public void setYxq(Date yxq) {
		_yxq = yxq;

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setYxq", Date.class);

				method.invoke(_leoCertificateRemoteModel, yxq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFzrq() {
		return _fzrq;
	}

	@Override
	public void setFzrq(Date fzrq) {
		_fzrq = fzrq;

		if (_leoCertificateRemoteModel != null) {
			try {
				Class<?> clazz = _leoCertificateRemoteModel.getClass();

				Method method = clazz.getMethod("setFzrq", Date.class);

				method.invoke(_leoCertificateRemoteModel, fzrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLEOCertificateRemoteModel() {
		return _leoCertificateRemoteModel;
	}

	public void setLEOCertificateRemoteModel(
		BaseModel<?> leoCertificateRemoteModel) {
		_leoCertificateRemoteModel = leoCertificateRemoteModel;
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

		Class<?> remoteModelClass = _leoCertificateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_leoCertificateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LEOCertificateLocalServiceUtil.addLEOCertificate(this);
		}
		else {
			LEOCertificateLocalServiceUtil.updateLEOCertificate(this);
		}
	}

	@Override
	public LEOCertificate toEscapedModel() {
		return (LEOCertificate)ProxyUtil.newProxyInstance(LEOCertificate.class.getClassLoader(),
			new Class[] { LEOCertificate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LEOCertificateClp clone = new LEOCertificateClp();

		clone.setCertificateId(getCertificateId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setXm(getXm());
		clone.setZylx(getZylx());
		clone.setYxq(getYxq());
		clone.setFzrq(getFzrq());

		return clone;
	}

	@Override
	public int compareTo(LEOCertificate leoCertificate) {
		String primaryKey = leoCertificate.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LEOCertificateClp)) {
			return false;
		}

		LEOCertificateClp leoCertificate = (LEOCertificateClp)obj;

		String primaryKey = leoCertificate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{certificateId=");
		sb.append(getCertificateId());
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
		sb.append(", xm=");
		sb.append(getXm());
		sb.append(", zylx=");
		sb.append(getZylx());
		sb.append(", yxq=");
		sb.append(getYxq());
		sb.append(", fzrq=");
		sb.append(getFzrq());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cyzt.leo.model.LEOCertificate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>certificateId</column-name><column-value><![CDATA[");
		sb.append(getCertificateId());
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
			"<column><column-name>xm</column-name><column-value><![CDATA[");
		sb.append(getXm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zylx</column-name><column-value><![CDATA[");
		sb.append(getZylx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yxq</column-name><column-value><![CDATA[");
		sb.append(getYxq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fzrq</column-name><column-value><![CDATA[");
		sb.append(getFzrq());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _certificateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _xm;
	private String _zylx;
	private Date _yxq;
	private Date _fzrq;
	private BaseModel<?> _leoCertificateRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cyzt.leo.service.ClpSerializer.class;
}