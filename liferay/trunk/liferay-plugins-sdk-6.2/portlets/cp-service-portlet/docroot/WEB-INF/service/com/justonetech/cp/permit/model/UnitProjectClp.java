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
import com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil;

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
public class UnitProjectClp extends BaseModelImpl<UnitProject>
	implements UnitProject {
	public UnitProjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UnitProject.class;
	}

	@Override
	public String getModelClassName() {
		return UnitProject.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _projectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("permitId", getPermitId());
		attributes.put("bjbh", getBjbh());
		attributes.put("gcbh", getGcbh());
		attributes.put("gcmc", getGcmc());
		attributes.put("jsnr", getJsnr());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String gcbh = (String)attributes.get("gcbh");

		if (gcbh != null) {
			setGcbh(gcbh);
		}

		String gcmc = (String)attributes.get("gcmc");

		if (gcmc != null) {
			setGcmc(gcmc);
		}

		String jsnr = (String)attributes.get("jsnr");

		if (jsnr != null) {
			setJsnr(jsnr);
		}
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;

		if (_unitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _unitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", long.class);

				method.invoke(_unitProjectRemoteModel, projectId);
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

		if (_unitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _unitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitId", long.class);

				method.invoke(_unitProjectRemoteModel, permitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjbh() {
		return _bjbh;
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;

		if (_unitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _unitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_unitProjectRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGcbh() {
		return _gcbh;
	}

	@Override
	public void setGcbh(String gcbh) {
		_gcbh = gcbh;

		if (_unitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _unitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setGcbh", String.class);

				method.invoke(_unitProjectRemoteModel, gcbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGcmc() {
		return _gcmc;
	}

	@Override
	public void setGcmc(String gcmc) {
		_gcmc = gcmc;

		if (_unitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _unitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setGcmc", String.class);

				method.invoke(_unitProjectRemoteModel, gcmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsnr() {
		return _jsnr;
	}

	@Override
	public void setJsnr(String jsnr) {
		_jsnr = jsnr;

		if (_unitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _unitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsnr", String.class);

				method.invoke(_unitProjectRemoteModel, jsnr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUnitProjectRemoteModel() {
		return _unitProjectRemoteModel;
	}

	public void setUnitProjectRemoteModel(BaseModel<?> unitProjectRemoteModel) {
		_unitProjectRemoteModel = unitProjectRemoteModel;
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

		Class<?> remoteModelClass = _unitProjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_unitProjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UnitProjectLocalServiceUtil.addUnitProject(this);
		}
		else {
			UnitProjectLocalServiceUtil.updateUnitProject(this);
		}
	}

	@Override
	public UnitProject toEscapedModel() {
		return (UnitProject)ProxyUtil.newProxyInstance(UnitProject.class.getClassLoader(),
			new Class[] { UnitProject.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UnitProjectClp clone = new UnitProjectClp();

		clone.setProjectId(getProjectId());
		clone.setPermitId(getPermitId());
		clone.setBjbh(getBjbh());
		clone.setGcbh(getGcbh());
		clone.setGcmc(getGcmc());
		clone.setJsnr(getJsnr());

		return clone;
	}

	@Override
	public int compareTo(UnitProject unitProject) {
		int value = 0;

		value = getGcbh().compareTo(unitProject.getGcbh());

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

		if (!(obj instanceof UnitProjectClp)) {
			return false;
		}

		UnitProjectClp unitProject = (UnitProjectClp)obj;

		long primaryKey = unitProject.getPrimaryKey();

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

		sb.append("{projectId=");
		sb.append(getProjectId());
		sb.append(", permitId=");
		sb.append(getPermitId());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", gcbh=");
		sb.append(getGcbh());
		sb.append(", gcmc=");
		sb.append(getGcmc());
		sb.append(", jsnr=");
		sb.append(getJsnr());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.permit.model.UnitProject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permitId</column-name><column-value><![CDATA[");
		sb.append(getPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gcbh</column-name><column-value><![CDATA[");
		sb.append(getGcbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gcmc</column-name><column-value><![CDATA[");
		sb.append(getGcmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsnr</column-name><column-value><![CDATA[");
		sb.append(getJsnr());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _projectId;
	private long _permitId;
	private String _bjbh;
	private String _gcbh;
	private String _gcmc;
	private String _jsnr;
	private BaseModel<?> _unitProjectRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}