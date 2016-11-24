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

package com.justonetech.expert.model;

import com.justonetech.expert.service.ClpSerializer;
import com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
 * @author fanqi
 */
public class ZqtzjkrzqkClp extends BaseModelImpl<Zqtzjkrzqk>
	implements Zqtzjkrzqk {
	public ZqtzjkrzqkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Zqtzjkrzqk.class;
	}

	@Override
	public String getModelClassName() {
		return Zqtzjkrzqk.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _zqtzjkrzqkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setZqtzjkrzqkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _zqtzjkrzqkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("zqtzjkrzqkId", getZqtzjkrzqkId());
		attributes.put("zjkxtlsdw", getZjkxtlsdw());
		attributes.put("sqzy", getSqzy());
		attributes.put("pzrq", getPzrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long zqtzjkrzqkId = (Long)attributes.get("zqtzjkrzqkId");

		if (zqtzjkrzqkId != null) {
			setZqtzjkrzqkId(zqtzjkrzqkId);
		}

		String zjkxtlsdw = (String)attributes.get("zjkxtlsdw");

		if (zjkxtlsdw != null) {
			setZjkxtlsdw(zjkxtlsdw);
		}

		String sqzy = (String)attributes.get("sqzy");

		if (sqzy != null) {
			setSqzy(sqzy);
		}

		Date pzrq = (Date)attributes.get("pzrq");

		if (pzrq != null) {
			setPzrq(pzrq);
		}
	}

	@Override
	public long getZqtzjkrzqkId() {
		return _zqtzjkrzqkId;
	}

	@Override
	public void setZqtzjkrzqkId(long zqtzjkrzqkId) {
		_zqtzjkrzqkId = zqtzjkrzqkId;

		if (_zqtzjkrzqkRemoteModel != null) {
			try {
				Class<?> clazz = _zqtzjkrzqkRemoteModel.getClass();

				Method method = clazz.getMethod("setZqtzjkrzqkId", long.class);

				method.invoke(_zqtzjkrzqkRemoteModel, zqtzjkrzqkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjkxtlsdw() {
		return _zjkxtlsdw;
	}

	@Override
	public void setZjkxtlsdw(String zjkxtlsdw) {
		_zjkxtlsdw = zjkxtlsdw;

		if (_zqtzjkrzqkRemoteModel != null) {
			try {
				Class<?> clazz = _zqtzjkrzqkRemoteModel.getClass();

				Method method = clazz.getMethod("setZjkxtlsdw", String.class);

				method.invoke(_zqtzjkrzqkRemoteModel, zjkxtlsdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSqzy() {
		return _sqzy;
	}

	@Override
	public void setSqzy(String sqzy) {
		_sqzy = sqzy;

		if (_zqtzjkrzqkRemoteModel != null) {
			try {
				Class<?> clazz = _zqtzjkrzqkRemoteModel.getClass();

				Method method = clazz.getMethod("setSqzy", String.class);

				method.invoke(_zqtzjkrzqkRemoteModel, sqzy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPzrq() {
		return _pzrq;
	}

	@Override
	public void setPzrq(Date pzrq) {
		_pzrq = pzrq;

		if (_zqtzjkrzqkRemoteModel != null) {
			try {
				Class<?> clazz = _zqtzjkrzqkRemoteModel.getClass();

				Method method = clazz.getMethod("setPzrq", Date.class);

				method.invoke(_zqtzjkrzqkRemoteModel, pzrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getZqtzjkrzqkRemoteModel() {
		return _zqtzjkrzqkRemoteModel;
	}

	public void setZqtzjkrzqkRemoteModel(BaseModel<?> zqtzjkrzqkRemoteModel) {
		_zqtzjkrzqkRemoteModel = zqtzjkrzqkRemoteModel;
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

		Class<?> remoteModelClass = _zqtzjkrzqkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_zqtzjkrzqkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ZqtzjkrzqkLocalServiceUtil.addZqtzjkrzqk(this);
		}
		else {
			ZqtzjkrzqkLocalServiceUtil.updateZqtzjkrzqk(this);
		}
	}

	@Override
	public Zqtzjkrzqk toEscapedModel() {
		return (Zqtzjkrzqk)ProxyUtil.newProxyInstance(Zqtzjkrzqk.class.getClassLoader(),
			new Class[] { Zqtzjkrzqk.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ZqtzjkrzqkClp clone = new ZqtzjkrzqkClp();

		clone.setZqtzjkrzqkId(getZqtzjkrzqkId());
		clone.setZjkxtlsdw(getZjkxtlsdw());
		clone.setSqzy(getSqzy());
		clone.setPzrq(getPzrq());

		return clone;
	}

	@Override
	public int compareTo(Zqtzjkrzqk zqtzjkrzqk) {
		int value = 0;

		if (getZqtzjkrzqkId() < zqtzjkrzqk.getZqtzjkrzqkId()) {
			value = -1;
		}
		else if (getZqtzjkrzqkId() > zqtzjkrzqk.getZqtzjkrzqkId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ZqtzjkrzqkClp)) {
			return false;
		}

		ZqtzjkrzqkClp zqtzjkrzqk = (ZqtzjkrzqkClp)obj;

		long primaryKey = zqtzjkrzqk.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{zqtzjkrzqkId=");
		sb.append(getZqtzjkrzqkId());
		sb.append(", zjkxtlsdw=");
		sb.append(getZjkxtlsdw());
		sb.append(", sqzy=");
		sb.append(getSqzy());
		sb.append(", pzrq=");
		sb.append(getPzrq());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.expert.model.Zqtzjkrzqk");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>zqtzjkrzqkId</column-name><column-value><![CDATA[");
		sb.append(getZqtzjkrzqkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjkxtlsdw</column-name><column-value><![CDATA[");
		sb.append(getZjkxtlsdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqzy</column-name><column-value><![CDATA[");
		sb.append(getSqzy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pzrq</column-name><column-value><![CDATA[");
		sb.append(getPzrq());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _zqtzjkrzqkId;
	private String _zjkxtlsdw;
	private String _sqzy;
	private Date _pzrq;
	private BaseModel<?> _zqtzjkrzqkRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.expert.service.ClpSerializer.class;
}