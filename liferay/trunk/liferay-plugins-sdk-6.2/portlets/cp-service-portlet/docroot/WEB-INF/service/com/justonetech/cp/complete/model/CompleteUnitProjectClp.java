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
import com.justonetech.cp.complete.service.CompleteUnitProjectLocalServiceUtil;

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
public class CompleteUnitProjectClp extends BaseModelImpl<CompleteUnitProject>
	implements CompleteUnitProject {
	public CompleteUnitProjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CompleteUnitProject.class;
	}

	@Override
	public String getModelClassName() {
		return CompleteUnitProject.class.getName();
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
		attributes.put("completeId", getCompleteId());
		attributes.put("permitUnitProjectId", getPermitUnitProjectId());
		attributes.put("bjbh", getBjbh());
		attributes.put("sgxkzbh", getSgxkzbh());
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

		Long completeId = (Long)attributes.get("completeId");

		if (completeId != null) {
			setCompleteId(completeId);
		}

		Long permitUnitProjectId = (Long)attributes.get("permitUnitProjectId");

		if (permitUnitProjectId != null) {
			setPermitUnitProjectId(permitUnitProjectId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String sgxkzbh = (String)attributes.get("sgxkzbh");

		if (sgxkzbh != null) {
			setSgxkzbh(sgxkzbh);
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

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", long.class);

				method.invoke(_completeUnitProjectRemoteModel, projectId);
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

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleteId", long.class);

				method.invoke(_completeUnitProjectRemoteModel, completeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPermitUnitProjectId() {
		return _permitUnitProjectId;
	}

	@Override
	public void setPermitUnitProjectId(long permitUnitProjectId) {
		_permitUnitProjectId = permitUnitProjectId;

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitUnitProjectId",
						long.class);

				method.invoke(_completeUnitProjectRemoteModel,
					permitUnitProjectId);
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

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_completeUnitProjectRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgxkzbh() {
		return _sgxkzbh;
	}

	@Override
	public void setSgxkzbh(String sgxkzbh) {
		_sgxkzbh = sgxkzbh;

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSgxkzbh", String.class);

				method.invoke(_completeUnitProjectRemoteModel, sgxkzbh);
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

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setGcbh", String.class);

				method.invoke(_completeUnitProjectRemoteModel, gcbh);
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

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setGcmc", String.class);

				method.invoke(_completeUnitProjectRemoteModel, gcmc);
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

		if (_completeUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _completeUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsnr", String.class);

				method.invoke(_completeUnitProjectRemoteModel, jsnr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCompleteUnitProjectRemoteModel() {
		return _completeUnitProjectRemoteModel;
	}

	public void setCompleteUnitProjectRemoteModel(
		BaseModel<?> completeUnitProjectRemoteModel) {
		_completeUnitProjectRemoteModel = completeUnitProjectRemoteModel;
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

		Class<?> remoteModelClass = _completeUnitProjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_completeUnitProjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompleteUnitProjectLocalServiceUtil.addCompleteUnitProject(this);
		}
		else {
			CompleteUnitProjectLocalServiceUtil.updateCompleteUnitProject(this);
		}
	}

	@Override
	public CompleteUnitProject toEscapedModel() {
		return (CompleteUnitProject)ProxyUtil.newProxyInstance(CompleteUnitProject.class.getClassLoader(),
			new Class[] { CompleteUnitProject.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CompleteUnitProjectClp clone = new CompleteUnitProjectClp();

		clone.setProjectId(getProjectId());
		clone.setCompleteId(getCompleteId());
		clone.setPermitUnitProjectId(getPermitUnitProjectId());
		clone.setBjbh(getBjbh());
		clone.setSgxkzbh(getSgxkzbh());
		clone.setGcbh(getGcbh());
		clone.setGcmc(getGcmc());
		clone.setJsnr(getJsnr());

		return clone;
	}

	@Override
	public int compareTo(CompleteUnitProject completeUnitProject) {
		int value = 0;

		value = getGcbh().compareTo(completeUnitProject.getGcbh());

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

		if (!(obj instanceof CompleteUnitProjectClp)) {
			return false;
		}

		CompleteUnitProjectClp completeUnitProject = (CompleteUnitProjectClp)obj;

		long primaryKey = completeUnitProject.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{projectId=");
		sb.append(getProjectId());
		sb.append(", completeId=");
		sb.append(getCompleteId());
		sb.append(", permitUnitProjectId=");
		sb.append(getPermitUnitProjectId());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", sgxkzbh=");
		sb.append(getSgxkzbh());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.complete.model.CompleteUnitProject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completeId</column-name><column-value><![CDATA[");
		sb.append(getCompleteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permitUnitProjectId</column-name><column-value><![CDATA[");
		sb.append(getPermitUnitProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgxkzbh</column-name><column-value><![CDATA[");
		sb.append(getSgxkzbh());
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
	private long _completeId;
	private long _permitUnitProjectId;
	private String _bjbh;
	private String _sgxkzbh;
	private String _gcbh;
	private String _gcmc;
	private String _jsnr;
	private BaseModel<?> _completeUnitProjectRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.complete.service.ClpSerializer.class;
}