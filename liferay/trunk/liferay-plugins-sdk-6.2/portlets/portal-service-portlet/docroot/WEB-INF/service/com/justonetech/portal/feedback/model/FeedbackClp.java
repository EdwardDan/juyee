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

package com.justonetech.portal.feedback.model;

import com.justonetech.portal.feedback.service.ClpSerializer;
import com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil;

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
public class FeedbackClp extends BaseModelImpl<Feedback> implements Feedback {
	public FeedbackClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("zt", getZt());
		attributes.put("lxId", getLxId());
		attributes.put("fkrId", getFkrId());
		attributes.put("fkrq", getFkrq());
		attributes.put("fknr", getFknr());
		attributes.put("hfrId", getHfrId());
		attributes.put("hfrq", getHfrq());
		attributes.put("hfjg", getHfjg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String zt = (String)attributes.get("zt");

		if (zt != null) {
			setZt(zt);
		}

		Long lxId = (Long)attributes.get("lxId");

		if (lxId != null) {
			setLxId(lxId);
		}

		Long fkrId = (Long)attributes.get("fkrId");

		if (fkrId != null) {
			setFkrId(fkrId);
		}

		Date fkrq = (Date)attributes.get("fkrq");

		if (fkrq != null) {
			setFkrq(fkrq);
		}

		String fknr = (String)attributes.get("fknr");

		if (fknr != null) {
			setFknr(fknr);
		}

		Long hfrId = (Long)attributes.get("hfrId");

		if (hfrId != null) {
			setHfrId(hfrId);
		}

		Date hfrq = (Date)attributes.get("hfrq");

		if (hfrq != null) {
			setHfrq(hfrq);
		}

		String hfjg = (String)attributes.get("hfjg");

		if (hfjg != null) {
			setHfjg(hfjg);
		}
	}

	@Override
	public long getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFeedbackId", long.class);

				method.invoke(_feedbackRemoteModel, feedbackId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_feedbackRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_feedbackRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZt() {
		return _zt;
	}

	@Override
	public void setZt(String zt) {
		_zt = zt;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setZt", String.class);

				method.invoke(_feedbackRemoteModel, zt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLxId() {
		return _lxId;
	}

	@Override
	public void setLxId(long lxId) {
		_lxId = lxId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setLxId", long.class);

				method.invoke(_feedbackRemoteModel, lxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFkrId() {
		return _fkrId;
	}

	@Override
	public void setFkrId(long fkrId) {
		_fkrId = fkrId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFkrId", long.class);

				method.invoke(_feedbackRemoteModel, fkrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getFkrq() {
		return _fkrq;
	}

	@Override
	public void setFkrq(Date fkrq) {
		_fkrq = fkrq;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFkrq", Date.class);

				method.invoke(_feedbackRemoteModel, fkrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFknr() {
		return _fknr;
	}

	@Override
	public void setFknr(String fknr) {
		_fknr = fknr;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFknr", String.class);

				method.invoke(_feedbackRemoteModel, fknr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHfrId() {
		return _hfrId;
	}

	@Override
	public void setHfrId(long hfrId) {
		_hfrId = hfrId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setHfrId", long.class);

				method.invoke(_feedbackRemoteModel, hfrId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getHfrq() {
		return _hfrq;
	}

	@Override
	public void setHfrq(Date hfrq) {
		_hfrq = hfrq;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setHfrq", Date.class);

				method.invoke(_feedbackRemoteModel, hfrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHfjg() {
		return _hfjg;
	}

	@Override
	public void setHfjg(String hfjg) {
		_hfjg = hfjg;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setHfjg", String.class);

				method.invoke(_feedbackRemoteModel, hfjg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFeedbackRemoteModel() {
		return _feedbackRemoteModel;
	}

	public void setFeedbackRemoteModel(BaseModel<?> feedbackRemoteModel) {
		_feedbackRemoteModel = feedbackRemoteModel;
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

		Class<?> remoteModelClass = _feedbackRemoteModel.getClass();

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

		Object returnValue = method.invoke(_feedbackRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FeedbackLocalServiceUtil.addFeedback(this);
		}
		else {
			FeedbackLocalServiceUtil.updateFeedback(this);
		}
	}

	@Override
	public Feedback toEscapedModel() {
		return (Feedback)ProxyUtil.newProxyInstance(Feedback.class.getClassLoader(),
			new Class[] { Feedback.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FeedbackClp clone = new FeedbackClp();

		clone.setFeedbackId(getFeedbackId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setZt(getZt());
		clone.setLxId(getLxId());
		clone.setFkrId(getFkrId());
		clone.setFkrq(getFkrq());
		clone.setFknr(getFknr());
		clone.setHfrId(getHfrId());
		clone.setHfrq(getHfrq());
		clone.setHfjg(getHfjg());

		return clone;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int value = 0;

		value = DateUtil.compareTo(getFkrq(), feedback.getFkrq());

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

		if (!(obj instanceof FeedbackClp)) {
			return false;
		}

		FeedbackClp feedback = (FeedbackClp)obj;

		long primaryKey = feedback.getPrimaryKey();

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

		sb.append("{feedbackId=");
		sb.append(getFeedbackId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", zt=");
		sb.append(getZt());
		sb.append(", lxId=");
		sb.append(getLxId());
		sb.append(", fkrId=");
		sb.append(getFkrId());
		sb.append(", fkrq=");
		sb.append(getFkrq());
		sb.append(", fknr=");
		sb.append(getFknr());
		sb.append(", hfrId=");
		sb.append(getHfrId());
		sb.append(", hfrq=");
		sb.append(getHfrq());
		sb.append(", hfjg=");
		sb.append(getHfjg());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.portal.feedback.model.Feedback");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zt</column-name><column-value><![CDATA[");
		sb.append(getZt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxId</column-name><column-value><![CDATA[");
		sb.append(getLxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fkrId</column-name><column-value><![CDATA[");
		sb.append(getFkrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fkrq</column-name><column-value><![CDATA[");
		sb.append(getFkrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fknr</column-name><column-value><![CDATA[");
		sb.append(getFknr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hfrId</column-name><column-value><![CDATA[");
		sb.append(getHfrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hfrq</column-name><column-value><![CDATA[");
		sb.append(getHfrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hfjg</column-name><column-value><![CDATA[");
		sb.append(getHfjg());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _feedbackId;
	private long _groupId;
	private long _companyId;
	private String _zt;
	private long _lxId;
	private long _fkrId;
	private Date _fkrq;
	private String _fknr;
	private long _hfrId;
	private Date _hfrq;
	private String _hfjg;
	private BaseModel<?> _feedbackRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.portal.feedback.service.ClpSerializer.class;
}