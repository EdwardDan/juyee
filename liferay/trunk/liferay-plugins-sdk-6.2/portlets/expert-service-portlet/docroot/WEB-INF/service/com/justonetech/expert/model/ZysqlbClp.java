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
import com.justonetech.expert.service.ZysqlbLocalServiceUtil;

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
public class ZysqlbClp extends BaseModelImpl<Zysqlb> implements Zysqlb {
	public ZysqlbClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Zysqlb.class;
	}

	@Override
	public String getModelClassName() {
		return Zysqlb.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _zysqlbId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setZysqlbId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _zysqlbId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("zysqlbId", getZysqlbId());
		attributes.put("sx", getSx());
		attributes.put("zy", getZy());
		attributes.put("zt", getZt());
		attributes.put("shyj", getShyj());
		attributes.put("shr", getShr());
		attributes.put("shrq", getShrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long zysqlbId = (Long)attributes.get("zysqlbId");

		if (zysqlbId != null) {
			setZysqlbId(zysqlbId);
		}

		String sx = (String)attributes.get("sx");

		if (sx != null) {
			setSx(sx);
		}

		String zy = (String)attributes.get("zy");

		if (zy != null) {
			setZy(zy);
		}

		String zt = (String)attributes.get("zt");

		if (zt != null) {
			setZt(zt);
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
	public long getZysqlbId() {
		return _zysqlbId;
	}

	@Override
	public void setZysqlbId(long zysqlbId) {
		_zysqlbId = zysqlbId;

		if (_zysqlbRemoteModel != null) {
			try {
				Class<?> clazz = _zysqlbRemoteModel.getClass();

				Method method = clazz.getMethod("setZysqlbId", long.class);

				method.invoke(_zysqlbRemoteModel, zysqlbId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSx() {
		return _sx;
	}

	@Override
	public void setSx(String sx) {
		_sx = sx;

		if (_zysqlbRemoteModel != null) {
			try {
				Class<?> clazz = _zysqlbRemoteModel.getClass();

				Method method = clazz.getMethod("setSx", String.class);

				method.invoke(_zysqlbRemoteModel, sx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZy() {
		return _zy;
	}

	@Override
	public void setZy(String zy) {
		_zy = zy;

		if (_zysqlbRemoteModel != null) {
			try {
				Class<?> clazz = _zysqlbRemoteModel.getClass();

				Method method = clazz.getMethod("setZy", String.class);

				method.invoke(_zysqlbRemoteModel, zy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZt() {
		return _zt;
	}

	@Override
	public void setZt(String zt) {
		_zt = zt;

		if (_zysqlbRemoteModel != null) {
			try {
				Class<?> clazz = _zysqlbRemoteModel.getClass();

				Method method = clazz.getMethod("setZt", String.class);

				method.invoke(_zysqlbRemoteModel, zt);
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

		if (_zysqlbRemoteModel != null) {
			try {
				Class<?> clazz = _zysqlbRemoteModel.getClass();

				Method method = clazz.getMethod("setShyj", String.class);

				method.invoke(_zysqlbRemoteModel, shyj);
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

		if (_zysqlbRemoteModel != null) {
			try {
				Class<?> clazz = _zysqlbRemoteModel.getClass();

				Method method = clazz.getMethod("setShr", String.class);

				method.invoke(_zysqlbRemoteModel, shr);
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

		if (_zysqlbRemoteModel != null) {
			try {
				Class<?> clazz = _zysqlbRemoteModel.getClass();

				Method method = clazz.getMethod("setShrq", Date.class);

				method.invoke(_zysqlbRemoteModel, shrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getZysqlbRemoteModel() {
		return _zysqlbRemoteModel;
	}

	public void setZysqlbRemoteModel(BaseModel<?> zysqlbRemoteModel) {
		_zysqlbRemoteModel = zysqlbRemoteModel;
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

		Class<?> remoteModelClass = _zysqlbRemoteModel.getClass();

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

		Object returnValue = method.invoke(_zysqlbRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ZysqlbLocalServiceUtil.addZysqlb(this);
		}
		else {
			ZysqlbLocalServiceUtil.updateZysqlb(this);
		}
	}

	@Override
	public Zysqlb toEscapedModel() {
		return (Zysqlb)ProxyUtil.newProxyInstance(Zysqlb.class.getClassLoader(),
			new Class[] { Zysqlb.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ZysqlbClp clone = new ZysqlbClp();

		clone.setZysqlbId(getZysqlbId());
		clone.setSx(getSx());
		clone.setZy(getZy());
		clone.setZt(getZt());
		clone.setShyj(getShyj());
		clone.setShr(getShr());
		clone.setShrq(getShrq());

		return clone;
	}

	@Override
	public int compareTo(Zysqlb zysqlb) {
		int value = 0;

		if (getZysqlbId() < zysqlb.getZysqlbId()) {
			value = -1;
		}
		else if (getZysqlbId() > zysqlb.getZysqlbId()) {
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

		if (!(obj instanceof ZysqlbClp)) {
			return false;
		}

		ZysqlbClp zysqlb = (ZysqlbClp)obj;

		long primaryKey = zysqlb.getPrimaryKey();

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

		sb.append("{zysqlbId=");
		sb.append(getZysqlbId());
		sb.append(", sx=");
		sb.append(getSx());
		sb.append(", zy=");
		sb.append(getZy());
		sb.append(", zt=");
		sb.append(getZt());
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
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.expert.model.Zysqlb");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>zysqlbId</column-name><column-value><![CDATA[");
		sb.append(getZysqlbId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sx</column-name><column-value><![CDATA[");
		sb.append(getSx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zy</column-name><column-value><![CDATA[");
		sb.append(getZy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zt</column-name><column-value><![CDATA[");
		sb.append(getZt());
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

	private long _zysqlbId;
	private String _sx;
	private String _zy;
	private String _zt;
	private String _shyj;
	private String _shr;
	private Date _shrq;
	private BaseModel<?> _zysqlbRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.expert.service.ClpSerializer.class;
}