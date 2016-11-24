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
import com.justonetech.expert.service.ExpertLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class ExpertClp extends BaseModelImpl<Expert> implements Expert {
	public ExpertClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Expert.class;
	}

	@Override
	public String getModelClassName() {
		return Expert.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _expertId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExpertId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expertId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expertId", getExpertId());
		attributes.put("xm", getXm());
		attributes.put("xb", getXb());
		attributes.put("sfzh", getSfzh());
		attributes.put("csny", getCsny());
		attributes.put("gzdw", getGzdw());
		attributes.put("dzyx", getDzyx());
		attributes.put("txdz", getTxdz());
		attributes.put("yzbm", getYzbm());
		attributes.put("xrzw", getXrzw());
		attributes.put("zc", getZc());
		attributes.put("zyzg", getZyzg());
		attributes.put("cszy", getCszy());
		attributes.put("zygznx", getZygznx());
		attributes.put("sjhm", getSjhm());
		attributes.put("lxdh", getLxdh());
		attributes.put("cz", getCz());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expertId = (Long)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String xm = (String)attributes.get("xm");

		if (xm != null) {
			setXm(xm);
		}

		String xb = (String)attributes.get("xb");

		if (xb != null) {
			setXb(xb);
		}

		String sfzh = (String)attributes.get("sfzh");

		if (sfzh != null) {
			setSfzh(sfzh);
		}

		Date csny = (Date)attributes.get("csny");

		if (csny != null) {
			setCsny(csny);
		}

		String gzdw = (String)attributes.get("gzdw");

		if (gzdw != null) {
			setGzdw(gzdw);
		}

		String dzyx = (String)attributes.get("dzyx");

		if (dzyx != null) {
			setDzyx(dzyx);
		}

		String txdz = (String)attributes.get("txdz");

		if (txdz != null) {
			setTxdz(txdz);
		}

		String yzbm = (String)attributes.get("yzbm");

		if (yzbm != null) {
			setYzbm(yzbm);
		}

		String xrzw = (String)attributes.get("xrzw");

		if (xrzw != null) {
			setXrzw(xrzw);
		}

		String zc = (String)attributes.get("zc");

		if (zc != null) {
			setZc(zc);
		}

		String zyzg = (String)attributes.get("zyzg");

		if (zyzg != null) {
			setZyzg(zyzg);
		}

		String cszy = (String)attributes.get("cszy");

		if (cszy != null) {
			setCszy(cszy);
		}

		String zygznx = (String)attributes.get("zygznx");

		if (zygznx != null) {
			setZygznx(zygznx);
		}

		String sjhm = (String)attributes.get("sjhm");

		if (sjhm != null) {
			setSjhm(sjhm);
		}

		String lxdh = (String)attributes.get("lxdh");

		if (lxdh != null) {
			setLxdh(lxdh);
		}

		String cz = (String)attributes.get("cz");

		if (cz != null) {
			setCz(cz);
		}
	}

	@Override
	public long getExpertId() {
		return _expertId;
	}

	@Override
	public void setExpertId(long expertId) {
		_expertId = expertId;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setExpertId", long.class);

				method.invoke(_expertRemoteModel, expertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXm() {
		return _xm;
	}

	@Override
	public void setXm(String xm) {
		_xm = xm;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setXm", String.class);

				method.invoke(_expertRemoteModel, xm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXb() {
		return _xb;
	}

	@Override
	public void setXb(String xb) {
		_xb = xb;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setXb", String.class);

				method.invoke(_expertRemoteModel, xb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfzh() {
		return _sfzh;
	}

	@Override
	public void setSfzh(String sfzh) {
		_sfzh = sfzh;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setSfzh", String.class);

				method.invoke(_expertRemoteModel, sfzh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCsny() {
		return _csny;
	}

	@Override
	public void setCsny(Date csny) {
		_csny = csny;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setCsny", Date.class);

				method.invoke(_expertRemoteModel, csny);
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

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setGzdw", String.class);

				method.invoke(_expertRemoteModel, gzdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDzyx() {
		return _dzyx;
	}

	@Override
	public void setDzyx(String dzyx) {
		_dzyx = dzyx;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setDzyx", String.class);

				method.invoke(_expertRemoteModel, dzyx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTxdz() {
		return _txdz;
	}

	@Override
	public void setTxdz(String txdz) {
		_txdz = txdz;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setTxdz", String.class);

				method.invoke(_expertRemoteModel, txdz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYzbm() {
		return _yzbm;
	}

	@Override
	public void setYzbm(String yzbm) {
		_yzbm = yzbm;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setYzbm", String.class);

				method.invoke(_expertRemoteModel, yzbm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXrzw() {
		return _xrzw;
	}

	@Override
	public void setXrzw(String xrzw) {
		_xrzw = xrzw;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setXrzw", String.class);

				method.invoke(_expertRemoteModel, xrzw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZc() {
		return _zc;
	}

	@Override
	public void setZc(String zc) {
		_zc = zc;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setZc", String.class);

				method.invoke(_expertRemoteModel, zc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZyzg() {
		return _zyzg;
	}

	@Override
	public void setZyzg(String zyzg) {
		_zyzg = zyzg;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setZyzg", String.class);

				method.invoke(_expertRemoteModel, zyzg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCszy() {
		return _cszy;
	}

	@Override
	public void setCszy(String cszy) {
		_cszy = cszy;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setCszy", String.class);

				method.invoke(_expertRemoteModel, cszy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZygznx() {
		return _zygznx;
	}

	@Override
	public void setZygznx(String zygznx) {
		_zygznx = zygznx;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setZygznx", String.class);

				method.invoke(_expertRemoteModel, zygznx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjhm() {
		return _sjhm;
	}

	@Override
	public void setSjhm(String sjhm) {
		_sjhm = sjhm;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setSjhm", String.class);

				method.invoke(_expertRemoteModel, sjhm);
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

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setLxdh", String.class);

				method.invoke(_expertRemoteModel, lxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCz() {
		return _cz;
	}

	@Override
	public void setCz(String cz) {
		_cz = cz;

		if (_expertRemoteModel != null) {
			try {
				Class<?> clazz = _expertRemoteModel.getClass();

				Method method = clazz.getMethod("setCz", String.class);

				method.invoke(_expertRemoteModel, cz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getExpertRemoteModel() {
		return _expertRemoteModel;
	}

	public void setExpertRemoteModel(BaseModel<?> expertRemoteModel) {
		_expertRemoteModel = expertRemoteModel;
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

		Class<?> remoteModelClass = _expertRemoteModel.getClass();

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

		Object returnValue = method.invoke(_expertRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExpertLocalServiceUtil.addExpert(this);
		}
		else {
			ExpertLocalServiceUtil.updateExpert(this);
		}
	}

	@Override
	public Expert toEscapedModel() {
		return (Expert)ProxyUtil.newProxyInstance(Expert.class.getClassLoader(),
			new Class[] { Expert.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExpertClp clone = new ExpertClp();

		clone.setExpertId(getExpertId());
		clone.setXm(getXm());
		clone.setXb(getXb());
		clone.setSfzh(getSfzh());
		clone.setCsny(getCsny());
		clone.setGzdw(getGzdw());
		clone.setDzyx(getDzyx());
		clone.setTxdz(getTxdz());
		clone.setYzbm(getYzbm());
		clone.setXrzw(getXrzw());
		clone.setZc(getZc());
		clone.setZyzg(getZyzg());
		clone.setCszy(getCszy());
		clone.setZygznx(getZygznx());
		clone.setSjhm(getSjhm());
		clone.setLxdh(getLxdh());
		clone.setCz(getCz());

		return clone;
	}

	@Override
	public int compareTo(Expert expert) {
		int value = 0;

		if (getExpertId() < expert.getExpertId()) {
			value = -1;
		}
		else if (getExpertId() > expert.getExpertId()) {
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

		if (!(obj instanceof ExpertClp)) {
			return false;
		}

		ExpertClp expert = (ExpertClp)obj;

		long primaryKey = expert.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{expertId=");
		sb.append(getExpertId());
		sb.append(", xm=");
		sb.append(getXm());
		sb.append(", xb=");
		sb.append(getXb());
		sb.append(", sfzh=");
		sb.append(getSfzh());
		sb.append(", csny=");
		sb.append(getCsny());
		sb.append(", gzdw=");
		sb.append(getGzdw());
		sb.append(", dzyx=");
		sb.append(getDzyx());
		sb.append(", txdz=");
		sb.append(getTxdz());
		sb.append(", yzbm=");
		sb.append(getYzbm());
		sb.append(", xrzw=");
		sb.append(getXrzw());
		sb.append(", zc=");
		sb.append(getZc());
		sb.append(", zyzg=");
		sb.append(getZyzg());
		sb.append(", cszy=");
		sb.append(getCszy());
		sb.append(", zygznx=");
		sb.append(getZygznx());
		sb.append(", sjhm=");
		sb.append(getSjhm());
		sb.append(", lxdh=");
		sb.append(getLxdh());
		sb.append(", cz=");
		sb.append(getCz());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.expert.model.Expert");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>expertId</column-name><column-value><![CDATA[");
		sb.append(getExpertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xm</column-name><column-value><![CDATA[");
		sb.append(getXm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xb</column-name><column-value><![CDATA[");
		sb.append(getXb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfzh</column-name><column-value><![CDATA[");
		sb.append(getSfzh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>csny</column-name><column-value><![CDATA[");
		sb.append(getCsny());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gzdw</column-name><column-value><![CDATA[");
		sb.append(getGzdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dzyx</column-name><column-value><![CDATA[");
		sb.append(getDzyx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>txdz</column-name><column-value><![CDATA[");
		sb.append(getTxdz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yzbm</column-name><column-value><![CDATA[");
		sb.append(getYzbm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xrzw</column-name><column-value><![CDATA[");
		sb.append(getXrzw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zc</column-name><column-value><![CDATA[");
		sb.append(getZc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zyzg</column-name><column-value><![CDATA[");
		sb.append(getZyzg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cszy</column-name><column-value><![CDATA[");
		sb.append(getCszy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zygznx</column-name><column-value><![CDATA[");
		sb.append(getZygznx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjhm</column-name><column-value><![CDATA[");
		sb.append(getSjhm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxdh</column-name><column-value><![CDATA[");
		sb.append(getLxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cz</column-name><column-value><![CDATA[");
		sb.append(getCz());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _expertId;
	private String _xm;
	private String _xb;
	private String _sfzh;
	private Date _csny;
	private String _gzdw;
	private String _dzyx;
	private String _txdz;
	private String _yzbm;
	private String _xrzw;
	private String _zc;
	private String _zyzg;
	private String _cszy;
	private String _zygznx;
	private String _sjhm;
	private String _lxdh;
	private String _cz;
	private BaseModel<?> _expertRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.expert.service.ClpSerializer.class;
}