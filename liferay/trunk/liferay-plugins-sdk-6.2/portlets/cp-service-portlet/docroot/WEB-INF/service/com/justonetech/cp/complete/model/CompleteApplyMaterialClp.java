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

package com.justonetech.cp.complete.model;

import com.justonetech.cp.complete.service.ClpSerializer;
import com.justonetech.cp.complete.service.CompleteApplyMaterialLocalServiceUtil;

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
public class CompleteApplyMaterialClp extends BaseModelImpl<CompleteApplyMaterial>
	implements CompleteApplyMaterial {
	public CompleteApplyMaterialClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CompleteApplyMaterial.class;
	}

	@Override
	public String getModelClassName() {
		return CompleteApplyMaterial.class.getName();
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
		attributes.put("completeId", getCompleteId());
		attributes.put("xh", getXh());
		attributes.put("clmc", getClmc());
		attributes.put("fileEntryIds", getFileEntryIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long materialId = (Long)attributes.get("materialId");

		if (materialId != null) {
			setMaterialId(materialId);
		}

		Long completeId = (Long)attributes.get("completeId");

		if (completeId != null) {
			setCompleteId(completeId);
		}

		String xh = (String)attributes.get("xh");

		if (xh != null) {
			setXh(xh);
		}

		String clmc = (String)attributes.get("clmc");

		if (clmc != null) {
			setClmc(clmc);
		}

		String fileEntryIds = (String)attributes.get("fileEntryIds");

		if (fileEntryIds != null) {
			setFileEntryIds(fileEntryIds);
		}
	}

	@Override
	public long getMaterialId() {
		return _materialId;
	}

	@Override
	public void setMaterialId(long materialId) {
		_materialId = materialId;

		if (_completeApplyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _completeApplyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setMaterialId", long.class);

				method.invoke(_completeApplyMaterialRemoteModel, materialId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompleteId() {
		return _completeId;
	}

	@Override
	public void setCompleteId(long completeId) {
		_completeId = completeId;

		if (_completeApplyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _completeApplyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleteId", long.class);

				method.invoke(_completeApplyMaterialRemoteModel, completeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXh() {
		return _xh;
	}

	@Override
	public void setXh(String xh) {
		_xh = xh;

		if (_completeApplyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _completeApplyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setXh", String.class);

				method.invoke(_completeApplyMaterialRemoteModel, xh);
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

		if (_completeApplyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _completeApplyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setClmc", String.class);

				method.invoke(_completeApplyMaterialRemoteModel, clmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileEntryIds() {
		return _fileEntryIds;
	}

	@Override
	public void setFileEntryIds(String fileEntryIds) {
		_fileEntryIds = fileEntryIds;

		if (_completeApplyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _completeApplyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryIds", String.class);

				method.invoke(_completeApplyMaterialRemoteModel, fileEntryIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCompleteApplyMaterialRemoteModel() {
		return _completeApplyMaterialRemoteModel;
	}

	public void setCompleteApplyMaterialRemoteModel(
		BaseModel<?> completeApplyMaterialRemoteModel) {
		_completeApplyMaterialRemoteModel = completeApplyMaterialRemoteModel;
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

		Class<?> remoteModelClass = _completeApplyMaterialRemoteModel.getClass();

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

		Object returnValue = method.invoke(_completeApplyMaterialRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompleteApplyMaterialLocalServiceUtil.addCompleteApplyMaterial(this);
		}
		else {
			CompleteApplyMaterialLocalServiceUtil.updateCompleteApplyMaterial(this);
		}
	}

	@Override
	public CompleteApplyMaterial toEscapedModel() {
		return (CompleteApplyMaterial)ProxyUtil.newProxyInstance(CompleteApplyMaterial.class.getClassLoader(),
			new Class[] { CompleteApplyMaterial.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CompleteApplyMaterialClp clone = new CompleteApplyMaterialClp();

		clone.setMaterialId(getMaterialId());
		clone.setCompleteId(getCompleteId());
		clone.setXh(getXh());
		clone.setClmc(getClmc());
		clone.setFileEntryIds(getFileEntryIds());

		return clone;
	}

	@Override
	public int compareTo(CompleteApplyMaterial completeApplyMaterial) {
		int value = 0;

		if (getMaterialId() < completeApplyMaterial.getMaterialId()) {
			value = -1;
		}
		else if (getMaterialId() > completeApplyMaterial.getMaterialId()) {
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

		if (!(obj instanceof CompleteApplyMaterialClp)) {
			return false;
		}

		CompleteApplyMaterialClp completeApplyMaterial = (CompleteApplyMaterialClp)obj;

		long primaryKey = completeApplyMaterial.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{materialId=");
		sb.append(getMaterialId());
		sb.append(", completeId=");
		sb.append(getCompleteId());
		sb.append(", xh=");
		sb.append(getXh());
		sb.append(", clmc=");
		sb.append(getClmc());
		sb.append(", fileEntryIds=");
		sb.append(getFileEntryIds());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.complete.model.CompleteApplyMaterial");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>materialId</column-name><column-value><![CDATA[");
		sb.append(getMaterialId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completeId</column-name><column-value><![CDATA[");
		sb.append(getCompleteId());
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
			"<column><column-name>fileEntryIds</column-name><column-value><![CDATA[");
		sb.append(getFileEntryIds());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _materialId;
	private long _completeId;
	private String _xh;
	private String _clmc;
	private String _fileEntryIds;
	private BaseModel<?> _completeApplyMaterialRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.complete.service.ClpSerializer.class;
}