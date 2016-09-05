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
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;

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
public class ProjectProfileClp extends BaseModelImpl<ProjectProfile>
	implements ProjectProfile {
	public ProjectProfileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectProfile.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectProfile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _permitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPermitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _permitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("permitId", getPermitId());
		attributes.put("bjbh", getBjbh());
		attributes.put("jsdwmc", getJsdwmc());
		attributes.put("jsdwxz", getJsdwxz());
		attributes.put("jsdwdz", getJsdwdz());
		attributes.put("gcmc", getGcmc());
		attributes.put("jsdd", getJsdd());
		attributes.put("jsgcgm", getJsgcgm());
		attributes.put("fwjzmj", getFwjzmj());
		attributes.put("htjg", getHtjg());
		attributes.put("htgq", getHtgq());
		attributes.put("fddbr", getFddbr());
		attributes.put("jsdwlxdh", getJsdwlxdh());
		attributes.put("jsdwlxr", getJsdwlxr());
		attributes.put("jsdwsjh", getJsdwsjh());
		attributes.put("jsydpzwjhfdccqzbh", getJsydpzwjhfdccqzbh());
		attributes.put("jsgcghxkzbh", getJsgcghxkzbh());
		attributes.put("xckgqk", getXckgqk());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String jsdwmc = (String)attributes.get("jsdwmc");

		if (jsdwmc != null) {
			setJsdwmc(jsdwmc);
		}

		String jsdwxz = (String)attributes.get("jsdwxz");

		if (jsdwxz != null) {
			setJsdwxz(jsdwxz);
		}

		String jsdwdz = (String)attributes.get("jsdwdz");

		if (jsdwdz != null) {
			setJsdwdz(jsdwdz);
		}

		String gcmc = (String)attributes.get("gcmc");

		if (gcmc != null) {
			setGcmc(gcmc);
		}

		String jsdd = (String)attributes.get("jsdd");

		if (jsdd != null) {
			setJsdd(jsdd);
		}

		String jsgcgm = (String)attributes.get("jsgcgm");

		if (jsgcgm != null) {
			setJsgcgm(jsgcgm);
		}

		String fwjzmj = (String)attributes.get("fwjzmj");

		if (fwjzmj != null) {
			setFwjzmj(fwjzmj);
		}

		String htjg = (String)attributes.get("htjg");

		if (htjg != null) {
			setHtjg(htjg);
		}

		Integer htgq = (Integer)attributes.get("htgq");

		if (htgq != null) {
			setHtgq(htgq);
		}

		String fddbr = (String)attributes.get("fddbr");

		if (fddbr != null) {
			setFddbr(fddbr);
		}

		String jsdwlxdh = (String)attributes.get("jsdwlxdh");

		if (jsdwlxdh != null) {
			setJsdwlxdh(jsdwlxdh);
		}

		String jsdwlxr = (String)attributes.get("jsdwlxr");

		if (jsdwlxr != null) {
			setJsdwlxr(jsdwlxr);
		}

		String jsdwsjh = (String)attributes.get("jsdwsjh");

		if (jsdwsjh != null) {
			setJsdwsjh(jsdwsjh);
		}

		String jsydpzwjhfdccqzbh = (String)attributes.get("jsydpzwjhfdccqzbh");

		if (jsydpzwjhfdccqzbh != null) {
			setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
		}

		String jsgcghxkzbh = (String)attributes.get("jsgcghxkzbh");

		if (jsgcghxkzbh != null) {
			setJsgcghxkzbh(jsgcghxkzbh);
		}

		String xckgqk = (String)attributes.get("xckgqk");

		if (xckgqk != null) {
			setXckgqk(xckgqk);
		}
	}

	@Override
	public long getPermitId() {
		return _permitId;
	}

	@Override
	public void setPermitId(long permitId) {
		_permitId = permitId;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitId", long.class);

				method.invoke(_projectProfileRemoteModel, permitId);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_projectProfileRemoteModel, bjbh);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwmc", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwxz() {
		return _jsdwxz;
	}

	@Override
	public void setJsdwxz(String jsdwxz) {
		_jsdwxz = jsdwxz;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwxz", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwxz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwdz() {
		return _jsdwdz;
	}

	@Override
	public void setJsdwdz(String jsdwdz) {
		_jsdwdz = jsdwdz;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwdz", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwdz);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGcmc", String.class);

				method.invoke(_projectProfileRemoteModel, gcmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdd() {
		return _jsdd;
	}

	@Override
	public void setJsdd(String jsdd) {
		_jsdd = jsdd;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdd", String.class);

				method.invoke(_projectProfileRemoteModel, jsdd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsgcgm() {
		return _jsgcgm;
	}

	@Override
	public void setJsgcgm(String jsgcgm) {
		_jsgcgm = jsgcgm;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgcgm", String.class);

				method.invoke(_projectProfileRemoteModel, jsgcgm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFwjzmj() {
		return _fwjzmj;
	}

	@Override
	public void setFwjzmj(String fwjzmj) {
		_fwjzmj = fwjzmj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFwjzmj", String.class);

				method.invoke(_projectProfileRemoteModel, fwjzmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtjg() {
		return _htjg;
	}

	@Override
	public void setHtjg(String htjg) {
		_htjg = htjg;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setHtjg", String.class);

				method.invoke(_projectProfileRemoteModel, htjg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHtgq() {
		return _htgq;
	}

	@Override
	public void setHtgq(int htgq) {
		_htgq = htgq;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setHtgq", int.class);

				method.invoke(_projectProfileRemoteModel, htgq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFddbr() {
		return _fddbr;
	}

	@Override
	public void setFddbr(String fddbr) {
		_fddbr = fddbr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFddbr", String.class);

				method.invoke(_projectProfileRemoteModel, fddbr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwlxdh() {
		return _jsdwlxdh;
	}

	@Override
	public void setJsdwlxdh(String jsdwlxdh) {
		_jsdwlxdh = jsdwlxdh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwlxdh", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwlxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwlxr() {
		return _jsdwlxr;
	}

	@Override
	public void setJsdwlxr(String jsdwlxr) {
		_jsdwlxr = jsdwlxr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwlxr", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwlxr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwsjh() {
		return _jsdwsjh;
	}

	@Override
	public void setJsdwsjh(String jsdwsjh) {
		_jsdwsjh = jsdwsjh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwsjh", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwsjh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsydpzwjhfdccqzbh() {
		return _jsydpzwjhfdccqzbh;
	}

	@Override
	public void setJsydpzwjhfdccqzbh(String jsydpzwjhfdccqzbh) {
		_jsydpzwjhfdccqzbh = jsydpzwjhfdccqzbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsydpzwjhfdccqzbh",
						String.class);

				method.invoke(_projectProfileRemoteModel, jsydpzwjhfdccqzbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsgcghxkzbh() {
		return _jsgcghxkzbh;
	}

	@Override
	public void setJsgcghxkzbh(String jsgcghxkzbh) {
		_jsgcghxkzbh = jsgcghxkzbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgcghxkzbh", String.class);

				method.invoke(_projectProfileRemoteModel, jsgcghxkzbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXckgqk() {
		return _xckgqk;
	}

	@Override
	public void setXckgqk(String xckgqk) {
		_xckgqk = xckgqk;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXckgqk", String.class);

				method.invoke(_projectProfileRemoteModel, xckgqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProjectProfileRemoteModel() {
		return _projectProfileRemoteModel;
	}

	public void setProjectProfileRemoteModel(
		BaseModel<?> projectProfileRemoteModel) {
		_projectProfileRemoteModel = projectProfileRemoteModel;
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

		Class<?> remoteModelClass = _projectProfileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_projectProfileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProjectProfileLocalServiceUtil.addProjectProfile(this);
		}
		else {
			ProjectProfileLocalServiceUtil.updateProjectProfile(this);
		}
	}

	@Override
	public ProjectProfile toEscapedModel() {
		return (ProjectProfile)ProxyUtil.newProxyInstance(ProjectProfile.class.getClassLoader(),
			new Class[] { ProjectProfile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProjectProfileClp clone = new ProjectProfileClp();

		clone.setPermitId(getPermitId());
		clone.setBjbh(getBjbh());
		clone.setJsdwmc(getJsdwmc());
		clone.setJsdwxz(getJsdwxz());
		clone.setJsdwdz(getJsdwdz());
		clone.setGcmc(getGcmc());
		clone.setJsdd(getJsdd());
		clone.setJsgcgm(getJsgcgm());
		clone.setFwjzmj(getFwjzmj());
		clone.setHtjg(getHtjg());
		clone.setHtgq(getHtgq());
		clone.setFddbr(getFddbr());
		clone.setJsdwlxdh(getJsdwlxdh());
		clone.setJsdwlxr(getJsdwlxr());
		clone.setJsdwsjh(getJsdwsjh());
		clone.setJsydpzwjhfdccqzbh(getJsydpzwjhfdccqzbh());
		clone.setJsgcghxkzbh(getJsgcghxkzbh());
		clone.setXckgqk(getXckgqk());

		return clone;
	}

	@Override
	public int compareTo(ProjectProfile projectProfile) {
		long primaryKey = projectProfile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectProfileClp)) {
			return false;
		}

		ProjectProfileClp projectProfile = (ProjectProfileClp)obj;

		long primaryKey = projectProfile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{permitId=");
		sb.append(getPermitId());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", jsdwmc=");
		sb.append(getJsdwmc());
		sb.append(", jsdwxz=");
		sb.append(getJsdwxz());
		sb.append(", jsdwdz=");
		sb.append(getJsdwdz());
		sb.append(", gcmc=");
		sb.append(getGcmc());
		sb.append(", jsdd=");
		sb.append(getJsdd());
		sb.append(", jsgcgm=");
		sb.append(getJsgcgm());
		sb.append(", fwjzmj=");
		sb.append(getFwjzmj());
		sb.append(", htjg=");
		sb.append(getHtjg());
		sb.append(", htgq=");
		sb.append(getHtgq());
		sb.append(", fddbr=");
		sb.append(getFddbr());
		sb.append(", jsdwlxdh=");
		sb.append(getJsdwlxdh());
		sb.append(", jsdwlxr=");
		sb.append(getJsdwlxr());
		sb.append(", jsdwsjh=");
		sb.append(getJsdwsjh());
		sb.append(", jsydpzwjhfdccqzbh=");
		sb.append(getJsydpzwjhfdccqzbh());
		sb.append(", jsgcghxkzbh=");
		sb.append(getJsgcghxkzbh());
		sb.append(", xckgqk=");
		sb.append(getXckgqk());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.permit.model.ProjectProfile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>permitId</column-name><column-value><![CDATA[");
		sb.append(getPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwmc</column-name><column-value><![CDATA[");
		sb.append(getJsdwmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwxz</column-name><column-value><![CDATA[");
		sb.append(getJsdwxz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwdz</column-name><column-value><![CDATA[");
		sb.append(getJsdwdz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gcmc</column-name><column-value><![CDATA[");
		sb.append(getGcmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdd</column-name><column-value><![CDATA[");
		sb.append(getJsdd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgcgm</column-name><column-value><![CDATA[");
		sb.append(getJsgcgm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fwjzmj</column-name><column-value><![CDATA[");
		sb.append(getFwjzmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htjg</column-name><column-value><![CDATA[");
		sb.append(getHtjg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htgq</column-name><column-value><![CDATA[");
		sb.append(getHtgq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fddbr</column-name><column-value><![CDATA[");
		sb.append(getFddbr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwlxdh</column-name><column-value><![CDATA[");
		sb.append(getJsdwlxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwlxr</column-name><column-value><![CDATA[");
		sb.append(getJsdwlxr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwsjh</column-name><column-value><![CDATA[");
		sb.append(getJsdwsjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsydpzwjhfdccqzbh</column-name><column-value><![CDATA[");
		sb.append(getJsydpzwjhfdccqzbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgcghxkzbh</column-name><column-value><![CDATA[");
		sb.append(getJsgcghxkzbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xckgqk</column-name><column-value><![CDATA[");
		sb.append(getXckgqk());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _permitId;
	private String _bjbh;
	private String _jsdwmc;
	private String _jsdwxz;
	private String _jsdwdz;
	private String _gcmc;
	private String _jsdd;
	private String _jsgcgm;
	private String _fwjzmj;
	private String _htjg;
	private int _htgq;
	private String _fddbr;
	private String _jsdwlxdh;
	private String _jsdwlxr;
	private String _jsdwsjh;
	private String _jsydpzwjhfdccqzbh;
	private String _jsgcghxkzbh;
	private String _xckgqk;
	private BaseModel<?> _projectProfileRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}