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
import com.justonetech.cp.complete.service.CompleteProjectProfileLocalServiceUtil;

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
public class CompleteProjectProfileClp extends BaseModelImpl<CompleteProjectProfile>
	implements CompleteProjectProfile {
	public CompleteProjectProfileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CompleteProjectProfile.class;
	}

	@Override
	public String getModelClassName() {
		return CompleteProjectProfile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _completeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCompleteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _completeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("completeId", getCompleteId());
		attributes.put("bjbh", getBjbh());
		attributes.put("xmlx", getXmlx());
		attributes.put("jsgcsx", getJsgcsx());
		attributes.put("gcmc", getGcmc());
		attributes.put("lxjb", getLxjb());
		attributes.put("jsdwmc", getJsdwmc());
		attributes.put("jsdwdz", getJsdwdz());
		attributes.put("jsdd", getJsdd());
		attributes.put("szqx", getSzqx());
		attributes.put("fddbr", getFddbr());
		attributes.put("lxr", getLxr());
		attributes.put("lxdh", getLxdh());
		attributes.put("bz", getBz());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long completeId = (Long)attributes.get("completeId");

		if (completeId != null) {
			setCompleteId(completeId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		Long xmlx = (Long)attributes.get("xmlx");

		if (xmlx != null) {
			setXmlx(xmlx);
		}

		Long jsgcsx = (Long)attributes.get("jsgcsx");

		if (jsgcsx != null) {
			setJsgcsx(jsgcsx);
		}

		String gcmc = (String)attributes.get("gcmc");

		if (gcmc != null) {
			setGcmc(gcmc);
		}

		String lxjb = (String)attributes.get("lxjb");

		if (lxjb != null) {
			setLxjb(lxjb);
		}

		String jsdwmc = (String)attributes.get("jsdwmc");

		if (jsdwmc != null) {
			setJsdwmc(jsdwmc);
		}

		String jsdwdz = (String)attributes.get("jsdwdz");

		if (jsdwdz != null) {
			setJsdwdz(jsdwdz);
		}

		String jsdd = (String)attributes.get("jsdd");

		if (jsdd != null) {
			setJsdd(jsdd);
		}

		String szqx = (String)attributes.get("szqx");

		if (szqx != null) {
			setSzqx(szqx);
		}

		String fddbr = (String)attributes.get("fddbr");

		if (fddbr != null) {
			setFddbr(fddbr);
		}

		String lxr = (String)attributes.get("lxr");

		if (lxr != null) {
			setLxr(lxr);
		}

		String lxdh = (String)attributes.get("lxdh");

		if (lxdh != null) {
			setLxdh(lxdh);
		}

		String bz = (String)attributes.get("bz");

		if (bz != null) {
			setBz(bz);
		}
	}

	@Override
	public long getCompleteId() {
		return _completeId;
	}

	@Override
	public void setCompleteId(long completeId) {
		_completeId = completeId;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleteId", long.class);

				method.invoke(_completeProjectProfileRemoteModel, completeId);
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

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_completeProjectProfileRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXmlx() {
		return _xmlx;
	}

	@Override
	public void setXmlx(long xmlx) {
		_xmlx = xmlx;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXmlx", long.class);

				method.invoke(_completeProjectProfileRemoteModel, xmlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJsgcsx() {
		return _jsgcsx;
	}

	@Override
	public void setJsgcsx(long jsgcsx) {
		_jsgcsx = jsgcsx;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgcsx", long.class);

				method.invoke(_completeProjectProfileRemoteModel, jsgcsx);
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

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGcmc", String.class);

				method.invoke(_completeProjectProfileRemoteModel, gcmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxjb() {
		return _lxjb;
	}

	@Override
	public void setLxjb(String lxjb) {
		_lxjb = lxjb;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLxjb", String.class);

				method.invoke(_completeProjectProfileRemoteModel, lxjb);
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

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwmc", String.class);

				method.invoke(_completeProjectProfileRemoteModel, jsdwmc);
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

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwdz", String.class);

				method.invoke(_completeProjectProfileRemoteModel, jsdwdz);
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

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdd", String.class);

				method.invoke(_completeProjectProfileRemoteModel, jsdd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSzqx() {
		return _szqx;
	}

	@Override
	public void setSzqx(String szqx) {
		_szqx = szqx;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSzqx", String.class);

				method.invoke(_completeProjectProfileRemoteModel, szqx);
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

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFddbr", String.class);

				method.invoke(_completeProjectProfileRemoteModel, fddbr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxr() {
		return _lxr;
	}

	@Override
	public void setLxr(String lxr) {
		_lxr = lxr;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLxr", String.class);

				method.invoke(_completeProjectProfileRemoteModel, lxr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxdh() {
		return _lxdh;
	}

	@Override
	public void setLxdh(String lxdh) {
		_lxdh = lxdh;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLxdh", String.class);

				method.invoke(_completeProjectProfileRemoteModel, lxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBz() {
		return _bz;
	}

	@Override
	public void setBz(String bz) {
		_bz = bz;

		if (_completeProjectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _completeProjectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setBz", String.class);

				method.invoke(_completeProjectProfileRemoteModel, bz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCompleteProjectProfileRemoteModel() {
		return _completeProjectProfileRemoteModel;
	}

	public void setCompleteProjectProfileRemoteModel(
		BaseModel<?> completeProjectProfileRemoteModel) {
		_completeProjectProfileRemoteModel = completeProjectProfileRemoteModel;
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

		Class<?> remoteModelClass = _completeProjectProfileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_completeProjectProfileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompleteProjectProfileLocalServiceUtil.addCompleteProjectProfile(this);
		}
		else {
			CompleteProjectProfileLocalServiceUtil.updateCompleteProjectProfile(this);
		}
	}

	@Override
	public CompleteProjectProfile toEscapedModel() {
		return (CompleteProjectProfile)ProxyUtil.newProxyInstance(CompleteProjectProfile.class.getClassLoader(),
			new Class[] { CompleteProjectProfile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CompleteProjectProfileClp clone = new CompleteProjectProfileClp();

		clone.setCompleteId(getCompleteId());
		clone.setBjbh(getBjbh());
		clone.setXmlx(getXmlx());
		clone.setJsgcsx(getJsgcsx());
		clone.setGcmc(getGcmc());
		clone.setLxjb(getLxjb());
		clone.setJsdwmc(getJsdwmc());
		clone.setJsdwdz(getJsdwdz());
		clone.setJsdd(getJsdd());
		clone.setSzqx(getSzqx());
		clone.setFddbr(getFddbr());
		clone.setLxr(getLxr());
		clone.setLxdh(getLxdh());
		clone.setBz(getBz());

		return clone;
	}

	@Override
	public int compareTo(CompleteProjectProfile completeProjectProfile) {
		long primaryKey = completeProjectProfile.getPrimaryKey();

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

		if (!(obj instanceof CompleteProjectProfileClp)) {
			return false;
		}

		CompleteProjectProfileClp completeProjectProfile = (CompleteProjectProfileClp)obj;

		long primaryKey = completeProjectProfile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{completeId=");
		sb.append(getCompleteId());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", xmlx=");
		sb.append(getXmlx());
		sb.append(", jsgcsx=");
		sb.append(getJsgcsx());
		sb.append(", gcmc=");
		sb.append(getGcmc());
		sb.append(", lxjb=");
		sb.append(getLxjb());
		sb.append(", jsdwmc=");
		sb.append(getJsdwmc());
		sb.append(", jsdwdz=");
		sb.append(getJsdwdz());
		sb.append(", jsdd=");
		sb.append(getJsdd());
		sb.append(", szqx=");
		sb.append(getSzqx());
		sb.append(", fddbr=");
		sb.append(getFddbr());
		sb.append(", lxr=");
		sb.append(getLxr());
		sb.append(", lxdh=");
		sb.append(getLxdh());
		sb.append(", bz=");
		sb.append(getBz());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.complete.model.CompleteProjectProfile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>completeId</column-name><column-value><![CDATA[");
		sb.append(getCompleteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmlx</column-name><column-value><![CDATA[");
		sb.append(getXmlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgcsx</column-name><column-value><![CDATA[");
		sb.append(getJsgcsx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gcmc</column-name><column-value><![CDATA[");
		sb.append(getGcmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxjb</column-name><column-value><![CDATA[");
		sb.append(getLxjb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwmc</column-name><column-value><![CDATA[");
		sb.append(getJsdwmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwdz</column-name><column-value><![CDATA[");
		sb.append(getJsdwdz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdd</column-name><column-value><![CDATA[");
		sb.append(getJsdd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>szqx</column-name><column-value><![CDATA[");
		sb.append(getSzqx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fddbr</column-name><column-value><![CDATA[");
		sb.append(getFddbr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxr</column-name><column-value><![CDATA[");
		sb.append(getLxr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxdh</column-name><column-value><![CDATA[");
		sb.append(getLxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bz</column-name><column-value><![CDATA[");
		sb.append(getBz());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _completeId;
	private String _bjbh;
	private long _xmlx;
	private long _jsgcsx;
	private String _gcmc;
	private String _lxjb;
	private String _jsdwmc;
	private String _jsdwdz;
	private String _jsdd;
	private String _szqx;
	private String _fddbr;
	private String _lxr;
	private String _lxdh;
	private String _bz;
	private BaseModel<?> _completeProjectProfileRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.complete.service.ClpSerializer.class;
}