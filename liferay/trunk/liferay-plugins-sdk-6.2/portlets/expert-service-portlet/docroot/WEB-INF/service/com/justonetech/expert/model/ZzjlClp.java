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
import com.justonetech.expert.service.ZzjlLocalServiceUtil;

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
public class ZzjlClp extends BaseModelImpl<Zzjl> implements Zzjl {
	public ZzjlClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Zzjl.class;
	}

	@Override
	public String getModelClassName() {
		return Zzjl.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _zzjlId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setZzjlId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _zzjlId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("zzjlId", getZzjlId());
		attributes.put("expertId", getExpertId());
		attributes.put("gzdw", getGzdw());
		attributes.put("qzny", getQzny());
		attributes.put("cszyzygz", getCszyzygz());
		attributes.put("zw", getZw());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long zzjlId = (Long)attributes.get("zzjlId");

		if (zzjlId != null) {
			setZzjlId(zzjlId);
		}

		Long expertId = (Long)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String gzdw = (String)attributes.get("gzdw");

		if (gzdw != null) {
			setGzdw(gzdw);
		}

		String qzny = (String)attributes.get("qzny");

		if (qzny != null) {
			setQzny(qzny);
		}

		String cszyzygz = (String)attributes.get("cszyzygz");

		if (cszyzygz != null) {
			setCszyzygz(cszyzygz);
		}

		String zw = (String)attributes.get("zw");

		if (zw != null) {
			setZw(zw);
		}
	}

	@Override
	public long getZzjlId() {
		return _zzjlId;
	}

	@Override
	public void setZzjlId(long zzjlId) {
		_zzjlId = zzjlId;

		if (_zzjlRemoteModel != null) {
			try {
				Class<?> clazz = _zzjlRemoteModel.getClass();

				Method method = clazz.getMethod("setZzjlId", long.class);

				method.invoke(_zzjlRemoteModel, zzjlId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getExpertId() {
		return _expertId;
	}

	@Override
	public void setExpertId(long expertId) {
		_expertId = expertId;

		if (_zzjlRemoteModel != null) {
			try {
				Class<?> clazz = _zzjlRemoteModel.getClass();

				Method method = clazz.getMethod("setExpertId", long.class);

				method.invoke(_zzjlRemoteModel, expertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGzdw() {
		return _gzdw;
	}

	@Override
	public void setGzdw(String gzdw) {
		_gzdw = gzdw;

		if (_zzjlRemoteModel != null) {
			try {
				Class<?> clazz = _zzjlRemoteModel.getClass();

				Method method = clazz.getMethod("setGzdw", String.class);

				method.invoke(_zzjlRemoteModel, gzdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQzny() {
		return _qzny;
	}

	@Override
	public void setQzny(String qzny) {
		_qzny = qzny;

		if (_zzjlRemoteModel != null) {
			try {
				Class<?> clazz = _zzjlRemoteModel.getClass();

				Method method = clazz.getMethod("setQzny", String.class);

				method.invoke(_zzjlRemoteModel, qzny);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCszyzygz() {
		return _cszyzygz;
	}

	@Override
	public void setCszyzygz(String cszyzygz) {
		_cszyzygz = cszyzygz;

		if (_zzjlRemoteModel != null) {
			try {
				Class<?> clazz = _zzjlRemoteModel.getClass();

				Method method = clazz.getMethod("setCszyzygz", String.class);

				method.invoke(_zzjlRemoteModel, cszyzygz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZw() {
		return _zw;
	}

	@Override
	public void setZw(String zw) {
		_zw = zw;

		if (_zzjlRemoteModel != null) {
			try {
				Class<?> clazz = _zzjlRemoteModel.getClass();

				Method method = clazz.getMethod("setZw", String.class);

				method.invoke(_zzjlRemoteModel, zw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getZzjlRemoteModel() {
		return _zzjlRemoteModel;
	}

	public void setZzjlRemoteModel(BaseModel<?> zzjlRemoteModel) {
		_zzjlRemoteModel = zzjlRemoteModel;
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

		Class<?> remoteModelClass = _zzjlRemoteModel.getClass();

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

		Object returnValue = method.invoke(_zzjlRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ZzjlLocalServiceUtil.addZzjl(this);
		}
		else {
			ZzjlLocalServiceUtil.updateZzjl(this);
		}
	}

	@Override
	public Zzjl toEscapedModel() {
		return (Zzjl)ProxyUtil.newProxyInstance(Zzjl.class.getClassLoader(),
			new Class[] { Zzjl.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ZzjlClp clone = new ZzjlClp();

		clone.setZzjlId(getZzjlId());
		clone.setExpertId(getExpertId());
		clone.setGzdw(getGzdw());
		clone.setQzny(getQzny());
		clone.setCszyzygz(getCszyzygz());
		clone.setZw(getZw());

		return clone;
	}

	@Override
	public int compareTo(Zzjl zzjl) {
		int value = 0;

		if (getZzjlId() < zzjl.getZzjlId()) {
			value = -1;
		}
		else if (getZzjlId() > zzjl.getZzjlId()) {
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

		if (!(obj instanceof ZzjlClp)) {
			return false;
		}

		ZzjlClp zzjl = (ZzjlClp)obj;

		long primaryKey = zzjl.getPrimaryKey();

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

		sb.append("{zzjlId=");
		sb.append(getZzjlId());
		sb.append(", expertId=");
		sb.append(getExpertId());
		sb.append(", gzdw=");
		sb.append(getGzdw());
		sb.append(", qzny=");
		sb.append(getQzny());
		sb.append(", cszyzygz=");
		sb.append(getCszyzygz());
		sb.append(", zw=");
		sb.append(getZw());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.expert.model.Zzjl");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>zzjlId</column-name><column-value><![CDATA[");
		sb.append(getZzjlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expertId</column-name><column-value><![CDATA[");
		sb.append(getExpertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gzdw</column-name><column-value><![CDATA[");
		sb.append(getGzdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qzny</column-name><column-value><![CDATA[");
		sb.append(getQzny());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cszyzygz</column-name><column-value><![CDATA[");
		sb.append(getCszyzygz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zw</column-name><column-value><![CDATA[");
		sb.append(getZw());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _zzjlId;
	private long _expertId;
	private String _gzdw;
	private String _qzny;
	private String _cszyzygz;
	private String _zw;
	private BaseModel<?> _zzjlRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.expert.service.ClpSerializer.class;
}