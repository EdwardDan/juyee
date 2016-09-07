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
		attributes.put("fileEntryIds", getFileEntryIds());
		attributes.put("shyq", getShyq());
		attributes.put("csyj", getCsyj());
		attributes.put("fhyj", getFhyj());
		attributes.put("shyj", getShyj());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long materialId = (Long)attributes.get("materialId");

		if (materialId != null) {
			setMaterialId(materialId);
		}

		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String xh = (String)attributes.get("xh");

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

		String fileEntryIds = (String)attributes.get("fileEntryIds");

		if (fileEntryIds != null) {
			setFileEntryIds(fileEntryIds);
		}

		String shyq = (String)attributes.get("shyq");

		if (shyq != null) {
			setShyq(shyq);
		}

		String csyj = (String)attributes.get("csyj");

		if (csyj != null) {
			setCsyj(csyj);
		}

		String fhyj = (String)attributes.get("fhyj");

		if (fhyj != null) {
			setFhyj(fhyj);
		}

		String shyj = (String)attributes.get("shyj");

		if (shyj != null) {
			setShyj(shyj);
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
	public long getPermitId() {
		return _permitId;
	}

	@Override
	public void setPermitId(long permitId) {
		_permitId = permitId;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitId", long.class);

				method.invoke(_applyMaterialRemoteModel, permitId);
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

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setXh", String.class);

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

	@Override
	public String getFileEntryIds() {
		return _fileEntryIds;
	}

	@Override
	public void setFileEntryIds(String fileEntryIds) {
		_fileEntryIds = fileEntryIds;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryIds", String.class);

				method.invoke(_applyMaterialRemoteModel, fileEntryIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShyq() {
		return _shyq;
	}

	@Override
	public void setShyq(String shyq) {
		_shyq = shyq;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setShyq", String.class);

				method.invoke(_applyMaterialRemoteModel, shyq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCsyj() {
		return _csyj;
	}

	@Override
	public void setCsyj(String csyj) {
		_csyj = csyj;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setCsyj", String.class);

				method.invoke(_applyMaterialRemoteModel, csyj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFhyj() {
		return _fhyj;
	}

	@Override
	public void setFhyj(String fhyj) {
		_fhyj = fhyj;

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setFhyj", String.class);

				method.invoke(_applyMaterialRemoteModel, fhyj);
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

		if (_applyMaterialRemoteModel != null) {
			try {
				Class<?> clazz = _applyMaterialRemoteModel.getClass();

				Method method = clazz.getMethod("setShyj", String.class);

				method.invoke(_applyMaterialRemoteModel, shyj);
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
		clone.setFileEntryIds(getFileEntryIds());
		clone.setShyq(getShyq());
		clone.setCsyj(getCsyj());
		clone.setFhyj(getFhyj());
		clone.setShyj(getShyj());

		return clone;
	}

	@Override
	public int compareTo(ApplyMaterial applyMaterial) {
		int value = 0;

		if (getMaterialId() < applyMaterial.getMaterialId()) {
			value = -1;
		}
		else if (getMaterialId() > applyMaterial.getMaterialId()) {
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
		StringBundler sb = new StringBundler(23);

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
		sb.append(", fileEntryIds=");
		sb.append(getFileEntryIds());
		sb.append(", shyq=");
		sb.append(getShyq());
		sb.append(", csyj=");
		sb.append(getCsyj());
		sb.append(", fhyj=");
		sb.append(getFhyj());
		sb.append(", shyj=");
		sb.append(getShyj());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

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
		sb.append(
			"<column><column-name>fileEntryIds</column-name><column-value><![CDATA[");
		sb.append(getFileEntryIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shyq</column-name><column-value><![CDATA[");
		sb.append(getShyq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csyj</column-name><column-value><![CDATA[");
		sb.append(getCsyj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fhyj</column-name><column-value><![CDATA[");
		sb.append(getFhyj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shyj</column-name><column-value><![CDATA[");
		sb.append(getShyj());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _materialId;
	private long _permitId;
	private String _xh;
	private String _clmc;
	private int _yjfs;
	private int _sjfs;
	private String _fileEntryIds;
	private String _shyq;
	private String _csyj;
	private String _fhyj;
	private String _shyj;
	private BaseModel<?> _applyMaterialRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}