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

package com.justonetech.cp.permit.model;

import com.justonetech.cp.permit.service.ClpSerializer;
import com.justonetech.cp.permit.service.ParticipationUnitLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanqi
 */
public class ParticipationUnitClp extends BaseModelImpl<ParticipationUnit>
	implements ParticipationUnit {
	public ParticipationUnitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ParticipationUnit.class;
	}

	@Override
	public String getModelClassName() {
		return ParticipationUnit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _unitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUnitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _unitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("unitId", getUnitId());
		attributes.put("permitId", getPermitId());
		attributes.put("htxxbsbh", getHtxxbsbh());
		attributes.put("dwlx", getDwlx());
		attributes.put("dwmc", getDwmc());
		attributes.put("xmfzr", getXmfzr());
		attributes.put("dhhm", getDhhm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		String permitId = (String)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String htxxbsbh = (String)attributes.get("htxxbsbh");

		if (htxxbsbh != null) {
			setHtxxbsbh(htxxbsbh);
		}

		String dwlx = (String)attributes.get("dwlx");

		if (dwlx != null) {
			setDwlx(dwlx);
		}

		String dwmc = (String)attributes.get("dwmc");

		if (dwmc != null) {
			setDwmc(dwmc);
		}

		String xmfzr = (String)attributes.get("xmfzr");

		if (xmfzr != null) {
			setXmfzr(xmfzr);
		}

		String dhhm = (String)attributes.get("dhhm");

		if (dhhm != null) {
			setDhhm(dhhm);
		}
	}

	@Override
	public long getUnitId() {
		return _unitId;
	}

	@Override
	public void setUnitId(long unitId) {
		_unitId = unitId;

		if (_participationUnitRemoteModel != null) {
			try {
				Class<?> clazz = _participationUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitId", long.class);

				method.invoke(_participationUnitRemoteModel, unitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPermitId() {
		return _permitId;
	}

	@Override
	public void setPermitId(String permitId) {
		_permitId = permitId;

		if (_participationUnitRemoteModel != null) {
			try {
				Class<?> clazz = _participationUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitId", String.class);

				method.invoke(_participationUnitRemoteModel, permitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtxxbsbh() {
		return _htxxbsbh;
	}

	@Override
	public void setHtxxbsbh(String htxxbsbh) {
		_htxxbsbh = htxxbsbh;

		if (_participationUnitRemoteModel != null) {
			try {
				Class<?> clazz = _participationUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setHtxxbsbh", String.class);

				method.invoke(_participationUnitRemoteModel, htxxbsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDwlx() {
		return _dwlx;
	}

	@Override
	public void setDwlx(String dwlx) {
		_dwlx = dwlx;

		if (_participationUnitRemoteModel != null) {
			try {
				Class<?> clazz = _participationUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setDwlx", String.class);

				method.invoke(_participationUnitRemoteModel, dwlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDwmc() {
		return _dwmc;
	}

	@Override
	public void setDwmc(String dwmc) {
		_dwmc = dwmc;

		if (_participationUnitRemoteModel != null) {
			try {
				Class<?> clazz = _participationUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setDwmc", String.class);

				method.invoke(_participationUnitRemoteModel, dwmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmfzr() {
		return _xmfzr;
	}

	@Override
	public void setXmfzr(String xmfzr) {
		_xmfzr = xmfzr;

		if (_participationUnitRemoteModel != null) {
			try {
				Class<?> clazz = _participationUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfzr", String.class);

				method.invoke(_participationUnitRemoteModel, xmfzr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDhhm() {
		return _dhhm;
	}

	@Override
	public void setDhhm(String dhhm) {
		_dhhm = dhhm;

		if (_participationUnitRemoteModel != null) {
			try {
				Class<?> clazz = _participationUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setDhhm", String.class);

				method.invoke(_participationUnitRemoteModel, dhhm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getParticipationUnitRemoteModel() {
		return _participationUnitRemoteModel;
	}

	public void setParticipationUnitRemoteModel(
		BaseModel<?> participationUnitRemoteModel) {
		_participationUnitRemoteModel = participationUnitRemoteModel;
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

		Class<?> remoteModelClass = _participationUnitRemoteModel.getClass();

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

		Object returnValue = method.invoke(_participationUnitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ParticipationUnitLocalServiceUtil.addParticipationUnit(this);
		}
		else {
			ParticipationUnitLocalServiceUtil.updateParticipationUnit(this);
		}
	}

	@Override
	public ParticipationUnit toEscapedModel() {
		return (ParticipationUnit)ProxyUtil.newProxyInstance(ParticipationUnit.class.getClassLoader(),
			new Class[] { ParticipationUnit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ParticipationUnitClp clone = new ParticipationUnitClp();

		clone.setUnitId(getUnitId());
		clone.setPermitId(getPermitId());
		clone.setHtxxbsbh(getHtxxbsbh());
		clone.setDwlx(getDwlx());
		clone.setDwmc(getDwmc());
		clone.setXmfzr(getXmfzr());
		clone.setDhhm(getDhhm());

		return clone;
	}

	@Override
	public int compareTo(ParticipationUnit participationUnit) {
		long primaryKey = participationUnit.getPrimaryKey();

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

		if (!(obj instanceof ParticipationUnitClp)) {
			return false;
		}

		ParticipationUnitClp participationUnit = (ParticipationUnitClp)obj;

		long primaryKey = participationUnit.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{unitId=");
		sb.append(getUnitId());
		sb.append(", permitId=");
		sb.append(getPermitId());
		sb.append(", htxxbsbh=");
		sb.append(getHtxxbsbh());
		sb.append(", dwlx=");
		sb.append(getDwlx());
		sb.append(", dwmc=");
		sb.append(getDwmc());
		sb.append(", xmfzr=");
		sb.append(getXmfzr());
		sb.append(", dhhm=");
		sb.append(getDhhm());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.permit.model.ParticipationUnit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>unitId</column-name><column-value><![CDATA[");
		sb.append(getUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permitId</column-name><column-value><![CDATA[");
		sb.append(getPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htxxbsbh</column-name><column-value><![CDATA[");
		sb.append(getHtxxbsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dwlx</column-name><column-value><![CDATA[");
		sb.append(getDwlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dwmc</column-name><column-value><![CDATA[");
		sb.append(getDwmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfzr</column-name><column-value><![CDATA[");
		sb.append(getXmfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dhhm</column-name><column-value><![CDATA[");
		sb.append(getDhhm());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _unitId;
	private String _permitId;
	private String _htxxbsbh;
	private String _dwlx;
	private String _dwmc;
	private String _xmfzr;
	private String _dhhm;
	private BaseModel<?> _participationUnitRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}