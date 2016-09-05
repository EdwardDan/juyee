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

import com.justonetech.cp.permit.service.ApplyMaterialLocalServiceUtil;
import com.justonetech.cp.permit.service.ClpSerializer;

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
public class ApplyMaterialClp extends BaseModelImpl<ApplyMaterial>
	implements ApplyMaterial {
	public ApplyMaterialClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ApplyMaterial.class;
	}

	@Override
	public String getModelClassName() {
		return ApplyMaterial.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _materialId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMaterialId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _materialId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("materialId", getMaterialId());
		attributes.put("permitId", getPermitId());
		attributes.put("xh", getXh());
		attributes.put("clmc", getClmc());
		attributes.put("yjfs", getYjfs());
		attributes.put("sjfs", getSjfs());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long materialId = (Long)attributes.get("materialId");

		if (materialId != null) {
			setMaterialId(materialId);
		}

		String permitId = (String)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		Integer xh = (Integer)attributes.get("xh");

		if (xh != null) {
			setXh(xh);
		}

		String clmc = (String)attributes.get("clmc");

		if (clmc != null) {
			setClmc(clmc);
		}

		Integer yjfs = (Integer)attributes.get("yjfs");

		if (yjfs != null) {
			setYjfs(yjfs);
		}

		Integer sjfs = (Integer)attributes.get("sjfs");

		if (sjfs != null) {
			setSjfs(sjfs);
		}
	}

	@Override
	public long getMaterialId() {
		return _materialId;
	}

	@Override
	public void setMaterialId(long materialId) {
		_materialId = materialId;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialId", long.class);

				method.invoke(_applyMaterialRemoteModel, materialId);
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

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitId", String.class);

				method.invoke(_applyMaterialRemoteModel, permitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getXh() {
		return _xh;
	}

	@Override
	public void setXh(int xh) {
		_xh = xh;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setXh", int.class);

				method.invoke(_applyMaterialRemoteModel, xh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClmc() {
		return _clmc;
	}

	@Override
	public void setClmc(String clmc) {
		_clmc = clmc;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setClmc", String.class);

				method.invoke(_applyMaterialRemoteModel, clmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYjfs() {
		return _yjfs;
	}

	@Override
	public void setYjfs(int yjfs) {
		_yjfs = yjfs;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setYjfs", int.class);

				method.invoke(_applyMaterialRemoteModel, yjfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSjfs() {
		return _sjfs;
	}

	@Override
	public void setSjfs(int sjfs) {
		_sjfs = sjfs;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setSjfs", int.class);

				method.invoke(_applyMaterialRemoteModel, sjfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getApplyMaterialRemoteModel() {
		return _applyMaterialRemoteModel;
	}

	public void setApplyMaterialRemoteModel(
		BaseModel<?> applyMaterialRemoteModel) {
		_applyMaterialRemoteModel = applyMaterialRemoteModel;
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

		Class<?> remoteModelClass = _applyMaterialRemoteModel.getClass();

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

		Object returnValue = method.invoke(_applyMaterialRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ApplyMaterialLocalServiceUtil.addApplyMaterial(this);
		}
		else {
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(this);
		}
	}

	@Override
	public ApplyMaterial toEscapedModel() {
		return (ApplyMaterial)ProxyUtil.newProxyInstance(ApplyMaterial.class.getClassLoader(),
			new Class[] { ApplyMaterial.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplyMaterialClp clone = new ApplyMaterialClp();

		clone.setMaterialId(getMaterialId());
		clone.setPermitId(getPermitId());
		clone.setXh(getXh());
		clone.setClmc(getClmc());
		clone.setYjfs(getYjfs());
		clone.setSjfs(getSjfs());

		return clone;
	}

	@Override
	public int compareTo(ApplyMaterial applyMaterial) {
		int value = 0;

		if (getXh() < applyMaterial.getXh()) {
			value = -1;
		}
		else if (getXh() > applyMaterial.getXh()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ApplyMaterialClp)) {
			return false;
		}

		ApplyMaterialClp applyMaterial = (ApplyMaterialClp)obj;

		long primaryKey = applyMaterial.getPrimaryKey();

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

		sb.append("{materialId=");
		sb.append(getMaterialId());
		sb.append(", permitId=");
		sb.append(getPermitId());
		sb.append(", xh=");
		sb.append(getXh());
		sb.append(", clmc=");
		sb.append(getClmc());
		sb.append(", yjfs=");
		sb.append(getYjfs());
		sb.append(", sjfs=");
		sb.append(getSjfs());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.permit.model.ApplyMaterial");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>materialId</column-name><column-value><![CDATA[");
		sb.append(getMaterialId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permitId</column-name><column-value><![CDATA[");
		sb.append(getPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xh</column-name><column-value><![CDATA[");
		sb.append(getXh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clmc</column-name><column-value><![CDATA[");
		sb.append(getClmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yjfs</column-name><column-value><![CDATA[");
		sb.append(getYjfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjfs</column-name><column-value><![CDATA[");
		sb.append(getSjfs());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _materialId;
	private String _permitId;
	private int _xh;
	private String _clmc;
	private int _yjfs;
	private int _sjfs;
	private BaseModel<?> _applyMaterialRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}