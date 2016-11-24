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
import com.justonetech.expert.service.XlxxLocalServiceUtil;

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
public class XlxxClp extends BaseModelImpl<Xlxx> implements Xlxx {
	public XlxxClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Xlxx.class;
	}

	@Override
	public String getModelClassName() {
		return Xlxx.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _xlxxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setXlxxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _xlxxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("xlxxId", getXlxxId());
		attributes.put("expertId", getExpertId());
		attributes.put("byyx", getByyx());
		attributes.put("sxzy", getSxzy());
		attributes.put("xlhxw", getXlhxw());
		attributes.put("zxsj", getZxsj());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long xlxxId = (Long)attributes.get("xlxxId");

		if (xlxxId != null) {
			setXlxxId(xlxxId);
		}

		String expertId = (String)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String byyx = (String)attributes.get("byyx");

		if (byyx != null) {
			setByyx(byyx);
		}

		String sxzy = (String)attributes.get("sxzy");

		if (sxzy != null) {
			setSxzy(sxzy);
		}

		String xlhxw = (String)attributes.get("xlhxw");

		if (xlhxw != null) {
			setXlhxw(xlhxw);
		}

		String zxsj = (String)attributes.get("zxsj");

		if (zxsj != null) {
			setZxsj(zxsj);
		}
	}

	@Override
	public long getXlxxId() {
		return _xlxxId;
	}

	@Override
	public void setXlxxId(long xlxxId) {
		_xlxxId = xlxxId;

		if (_xlxxRemoteModel != null) {
			try {
				Class<?> clazz = _xlxxRemoteModel.getClass();

				Method method = clazz.getMethod("setXlxxId", long.class);

				method.invoke(_xlxxRemoteModel, xlxxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpertId() {
		return _expertId;
	}

	@Override
	public void setExpertId(String expertId) {
		_expertId = expertId;

		if (_xlxxRemoteModel != null) {
			try {
				Class<?> clazz = _xlxxRemoteModel.getClass();

				Method method = clazz.getMethod("setExpertId", String.class);

				method.invoke(_xlxxRemoteModel, expertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getByyx() {
		return _byyx;
	}

	@Override
	public void setByyx(String byyx) {
		_byyx = byyx;

		if (_xlxxRemoteModel != null) {
			try {
				Class<?> clazz = _xlxxRemoteModel.getClass();

				Method method = clazz.getMethod("setByyx", String.class);

				method.invoke(_xlxxRemoteModel, byyx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSxzy() {
		return _sxzy;
	}

	@Override
	public void setSxzy(String sxzy) {
		_sxzy = sxzy;

		if (_xlxxRemoteModel != null) {
			try {
				Class<?> clazz = _xlxxRemoteModel.getClass();

				Method method = clazz.getMethod("setSxzy", String.class);

				method.invoke(_xlxxRemoteModel, sxzy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXlhxw() {
		return _xlhxw;
	}

	@Override
	public void setXlhxw(String xlhxw) {
		_xlhxw = xlhxw;

		if (_xlxxRemoteModel != null) {
			try {
				Class<?> clazz = _xlxxRemoteModel.getClass();

				Method method = clazz.getMethod("setXlhxw", String.class);

				method.invoke(_xlxxRemoteModel, xlhxw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZxsj() {
		return _zxsj;
	}

	@Override
	public void setZxsj(String zxsj) {
		_zxsj = zxsj;

		if (_xlxxRemoteModel != null) {
			try {
				Class<?> clazz = _xlxxRemoteModel.getClass();

				Method method = clazz.getMethod("setZxsj", String.class);

				method.invoke(_xlxxRemoteModel, zxsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getXlxxRemoteModel() {
		return _xlxxRemoteModel;
	}

	public void setXlxxRemoteModel(BaseModel<?> xlxxRemoteModel) {
		_xlxxRemoteModel = xlxxRemoteModel;
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

		Class<?> remoteModelClass = _xlxxRemoteModel.getClass();

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

		Object returnValue = method.invoke(_xlxxRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			XlxxLocalServiceUtil.addXlxx(this);
		}
		else {
			XlxxLocalServiceUtil.updateXlxx(this);
		}
	}

	@Override
	public Xlxx toEscapedModel() {
		return (Xlxx)ProxyUtil.newProxyInstance(Xlxx.class.getClassLoader(),
			new Class[] { Xlxx.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		XlxxClp clone = new XlxxClp();

		clone.setXlxxId(getXlxxId());
		clone.setExpertId(getExpertId());
		clone.setByyx(getByyx());
		clone.setSxzy(getSxzy());
		clone.setXlhxw(getXlhxw());
		clone.setZxsj(getZxsj());

		return clone;
	}

	@Override
	public int compareTo(Xlxx xlxx) {
		int value = 0;

		if (getXlxxId() < xlxx.getXlxxId()) {
			value = -1;
		}
		else if (getXlxxId() > xlxx.getXlxxId()) {
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

		if (!(obj instanceof XlxxClp)) {
			return false;
		}

		XlxxClp xlxx = (XlxxClp)obj;

		long primaryKey = xlxx.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{xlxxId=");
		sb.append(getXlxxId());
		sb.append(", expertId=");
		sb.append(getExpertId());
		sb.append(", byyx=");
		sb.append(getByyx());
		sb.append(", sxzy=");
		sb.append(getSxzy());
		sb.append(", xlhxw=");
		sb.append(getXlhxw());
		sb.append(", zxsj=");
		sb.append(getZxsj());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.expert.model.Xlxx");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>xlxxId</column-name><column-value><![CDATA[");
		sb.append(getXlxxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expertId</column-name><column-value><![CDATA[");
		sb.append(getExpertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>byyx</column-name><column-value><![CDATA[");
		sb.append(getByyx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sxzy</column-name><column-value><![CDATA[");
		sb.append(getSxzy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xlhxw</column-name><column-value><![CDATA[");
		sb.append(getXlhxw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zxsj</column-name><column-value><![CDATA[");
		sb.append(getZxsj());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _xlxxId;
	private String _expertId;
	private String _byyx;
	private String _sxzy;
	private String _xlhxw;
	private String _zxsj;
	private BaseModel<?> _xlxxRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.expert.service.ClpSerializer.class;
}