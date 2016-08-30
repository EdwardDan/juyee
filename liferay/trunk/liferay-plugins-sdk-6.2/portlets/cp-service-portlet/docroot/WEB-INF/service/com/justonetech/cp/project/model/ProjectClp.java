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

package com.justonetech.cp.project.model;

import com.justonetech.cp.project.service.ClpSerializer;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class ProjectClp extends BaseModelImpl<Project> implements Project {
	public ProjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _projectId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("bjrq", getBjrq());
		attributes.put("bjWebid", getBjWebid());
		attributes.put("xmmc", getXmmc());
		attributes.put("bjwcbj", getBjwcbj());
		attributes.put("jsdwmc", getJsdwmc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String projectId = (String)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String zzjgdm = (String)attributes.get("zzjgdm");

		if (zzjgdm != null) {
			setZzjgdm(zzjgdm);
		}

		Date bjrq = (Date)attributes.get("bjrq");

		if (bjrq != null) {
			setBjrq(bjrq);
		}

		String bjWebid = (String)attributes.get("bjWebid");

		if (bjWebid != null) {
			setBjWebid(bjWebid);
		}

		String xmmc = (String)attributes.get("xmmc");

		if (xmmc != null) {
			setXmmc(xmmc);
		}

		String bjwcbj = (String)attributes.get("bjwcbj");

		if (bjwcbj != null) {
			setBjwcbj(bjwcbj);
		}

		String jsdwmc = (String)attributes.get("jsdwmc");

		if (jsdwmc != null) {
			setJsdwmc(jsdwmc);
		}
	}

	@Override
	public String getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(String projectId) {
		_projectId = projectId;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", String.class);

				method.invoke(_projectRemoteModel, projectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZzjgdm() {
		return _zzjgdm;
	}

	@Override
	public void setZzjgdm(String zzjgdm) {
		_zzjgdm = zzjgdm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZzjgdm", String.class);

				method.invoke(_projectRemoteModel, zzjgdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBjrq() {
		return _bjrq;
	}

	@Override
	public void setBjrq(Date bjrq) {
		_bjrq = bjrq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjrq", Date.class);

				method.invoke(_projectRemoteModel, bjrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjWebid() {
		return _bjWebid;
	}

	@Override
	public void setBjWebid(String bjWebid) {
		_bjWebid = bjWebid;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjWebid", String.class);

				method.invoke(_projectRemoteModel, bjWebid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmmc() {
		return _xmmc;
	}

	@Override
	public void setXmmc(String xmmc) {
		_xmmc = xmmc;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setXmmc", String.class);

				method.invoke(_projectRemoteModel, xmmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjwcbj() {
		return _bjwcbj;
	}

	@Override
	public void setBjwcbj(String bjwcbj) {
		_bjwcbj = bjwcbj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjwcbj", String.class);

				method.invoke(_projectRemoteModel, bjwcbj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwmc() {
		return _jsdwmc;
	}

	@Override
	public void setJsdwmc(String jsdwmc) {
		_jsdwmc = jsdwmc;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwmc", String.class);

				method.invoke(_projectRemoteModel, jsdwmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProjectRemoteModel() {
		return _projectRemoteModel;
	}

	public void setProjectRemoteModel(BaseModel<?> projectRemoteModel) {
		_projectRemoteModel = projectRemoteModel;
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

		Class<?> remoteModelClass = _projectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_projectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProjectLocalServiceUtil.addProject(this);
		}
		else {
			ProjectLocalServiceUtil.updateProject(this);
		}
	}

	@Override
	public Project toEscapedModel() {
		return (Project)ProxyUtil.newProxyInstance(Project.class.getClassLoader(),
			new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProjectClp clone = new ProjectClp();

		clone.setProjectId(getProjectId());
		clone.setZzjgdm(getZzjgdm());
		clone.setBjrq(getBjrq());
		clone.setBjWebid(getBjWebid());
		clone.setXmmc(getXmmc());
		clone.setBjwcbj(getBjwcbj());
		clone.setJsdwmc(getJsdwmc());

		return clone;
	}

	@Override
	public int compareTo(Project project) {
		int value = 0;

		value = DateUtil.compareTo(getBjrq(), project.getBjrq());

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

		if (!(obj instanceof ProjectClp)) {
			return false;
		}

		ProjectClp project = (ProjectClp)obj;

		String primaryKey = project.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{projectId=");
		sb.append(getProjectId());
		sb.append(", zzjgdm=");
		sb.append(getZzjgdm());
		sb.append(", bjrq=");
		sb.append(getBjrq());
		sb.append(", bjWebid=");
		sb.append(getBjWebid());
		sb.append(", xmmc=");
		sb.append(getXmmc());
		sb.append(", bjwcbj=");
		sb.append(getBjwcbj());
		sb.append(", jsdwmc=");
		sb.append(getJsdwmc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.project.model.Project");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zzjgdm</column-name><column-value><![CDATA[");
		sb.append(getZzjgdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjrq</column-name><column-value><![CDATA[");
		sb.append(getBjrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjWebid</column-name><column-value><![CDATA[");
		sb.append(getBjWebid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmmc</column-name><column-value><![CDATA[");
		sb.append(getXmmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjwcbj</column-name><column-value><![CDATA[");
		sb.append(getBjwcbj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwmc</column-name><column-value><![CDATA[");
		sb.append(getJsdwmc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _projectId;
	private String _zzjgdm;
	private Date _bjrq;
	private String _bjWebid;
	private String _xmmc;
	private String _bjwcbj;
	private String _jsdwmc;
	private BaseModel<?> _projectRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.project.service.ClpSerializer.class;
}