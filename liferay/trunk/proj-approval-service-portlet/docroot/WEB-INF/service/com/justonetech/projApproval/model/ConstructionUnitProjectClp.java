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

package com.justonetech.projApproval.model;

import com.justonetech.projApproval.service.ClpSerializer;
import com.justonetech.projApproval.service.ConstructionUnitProjectLocalServiceUtil;

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
 * @author justonetech
 */
public class ConstructionUnitProjectClp extends BaseModelImpl<ConstructionUnitProject>
	implements ConstructionUnitProject {
	public ConstructionUnitProjectClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ConstructionUnitProject.class;
	}

	@Override
	public String getModelClassName() {
		return ConstructionUnitProject.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _constructionUnitProjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConstructionUnitProjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _constructionUnitProjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("constructionUnitProjectId",
			getConstructionUnitProjectId());
		attributes.put("sortNo", getSortNo());
		attributes.put("unitProjectNum", getUnitProjectNum());
		attributes.put("unitProjectName", getUnitProjectName());
		attributes.put("constructionContent", getConstructionContent());
		attributes.put("constructionPermitId", getConstructionPermitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long constructionUnitProjectId = (Long)attributes.get(
				"constructionUnitProjectId");

		if (constructionUnitProjectId != null) {
			setConstructionUnitProjectId(constructionUnitProjectId);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String unitProjectNum = (String)attributes.get("unitProjectNum");

		if (unitProjectNum != null) {
			setUnitProjectNum(unitProjectNum);
		}

		String unitProjectName = (String)attributes.get("unitProjectName");

		if (unitProjectName != null) {
			setUnitProjectName(unitProjectName);
		}

		String constructionContent = (String)attributes.get(
				"constructionContent");

		if (constructionContent != null) {
			setConstructionContent(constructionContent);
		}

		Long constructionPermitId = (Long)attributes.get("constructionPermitId");

		if (constructionPermitId != null) {
			setConstructionPermitId(constructionPermitId);
		}
	}

	@Override
	public long getConstructionUnitProjectId() {
		return _constructionUnitProjectId;
	}

	@Override
	public void setConstructionUnitProjectId(long constructionUnitProjectId) {
		_constructionUnitProjectId = constructionUnitProjectId;

		if (_constructionUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _constructionUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionUnitProjectId",
						long.class);

				method.invoke(_constructionUnitProjectRemoteModel,
					constructionUnitProjectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSortNo() {
		return _sortNo;
	}

	@Override
	public void setSortNo(int sortNo) {
		_sortNo = sortNo;

		if (_constructionUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _constructionUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setSortNo", int.class);

				method.invoke(_constructionUnitProjectRemoteModel, sortNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnitProjectNum() {
		return _unitProjectNum;
	}

	@Override
	public void setUnitProjectNum(String unitProjectNum) {
		_unitProjectNum = unitProjectNum;

		if (_constructionUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _constructionUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitProjectNum",
						String.class);

				method.invoke(_constructionUnitProjectRemoteModel,
					unitProjectNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnitProjectName() {
		return _unitProjectName;
	}

	@Override
	public void setUnitProjectName(String unitProjectName) {
		_unitProjectName = unitProjectName;

		if (_constructionUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _constructionUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitProjectName",
						String.class);

				method.invoke(_constructionUnitProjectRemoteModel,
					unitProjectName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConstructionContent() {
		return _constructionContent;
	}

	@Override
	public void setConstructionContent(String constructionContent) {
		_constructionContent = constructionContent;

		if (_constructionUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _constructionUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionContent",
						String.class);

				method.invoke(_constructionUnitProjectRemoteModel,
					constructionContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConstructionPermitId() {
		return _constructionPermitId;
	}

	@Override
	public void setConstructionPermitId(long constructionPermitId) {
		_constructionPermitId = constructionPermitId;

		if (_constructionUnitProjectRemoteModel != null) {
			try {
				Class<?> clazz = _constructionUnitProjectRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionPermitId",
						long.class);

				method.invoke(_constructionUnitProjectRemoteModel,
					constructionPermitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getConstructionUnitProjectRemoteModel() {
		return _constructionUnitProjectRemoteModel;
	}

	public void setConstructionUnitProjectRemoteModel(
		BaseModel<?> constructionUnitProjectRemoteModel) {
		_constructionUnitProjectRemoteModel = constructionUnitProjectRemoteModel;
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

		Class<?> remoteModelClass = _constructionUnitProjectRemoteModel.getClass();

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

		Object returnValue = method.invoke(_constructionUnitProjectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConstructionUnitProjectLocalServiceUtil.addConstructionUnitProject(this);
		}
		else {
			ConstructionUnitProjectLocalServiceUtil.updateConstructionUnitProject(this);
		}
	}

	@Override
	public ConstructionUnitProject toEscapedModel() {
		return (ConstructionUnitProject)ProxyUtil.newProxyInstance(ConstructionUnitProject.class.getClassLoader(),
			new Class[] { ConstructionUnitProject.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConstructionUnitProjectClp clone = new ConstructionUnitProjectClp();

		clone.setConstructionUnitProjectId(getConstructionUnitProjectId());
		clone.setSortNo(getSortNo());
		clone.setUnitProjectNum(getUnitProjectNum());
		clone.setUnitProjectName(getUnitProjectName());
		clone.setConstructionContent(getConstructionContent());
		clone.setConstructionPermitId(getConstructionPermitId());

		return clone;
	}

	@Override
	public int compareTo(ConstructionUnitProject constructionUnitProject) {
		long primaryKey = constructionUnitProject.getPrimaryKey();

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

		if (!(obj instanceof ConstructionUnitProjectClp)) {
			return false;
		}

		ConstructionUnitProjectClp constructionUnitProject = (ConstructionUnitProjectClp)obj;

		long primaryKey = constructionUnitProject.getPrimaryKey();

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

		sb.append("{constructionUnitProjectId=");
		sb.append(getConstructionUnitProjectId());
		sb.append(", sortNo=");
		sb.append(getSortNo());
		sb.append(", unitProjectNum=");
		sb.append(getUnitProjectNum());
		sb.append(", unitProjectName=");
		sb.append(getUnitProjectName());
		sb.append(", constructionContent=");
		sb.append(getConstructionContent());
		sb.append(", constructionPermitId=");
		sb.append(getConstructionPermitId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.projApproval.model.ConstructionUnitProject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>constructionUnitProjectId</column-name><column-value><![CDATA[");
		sb.append(getConstructionUnitProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortNo</column-name><column-value><![CDATA[");
		sb.append(getSortNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitProjectNum</column-name><column-value><![CDATA[");
		sb.append(getUnitProjectNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitProjectName</column-name><column-value><![CDATA[");
		sb.append(getUnitProjectName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>constructionContent</column-name><column-value><![CDATA[");
		sb.append(getConstructionContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>constructionPermitId</column-name><column-value><![CDATA[");
		sb.append(getConstructionPermitId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _constructionUnitProjectId;
	private int _sortNo;
	private String _unitProjectNum;
	private String _unitProjectName;
	private String _constructionContent;
	private long _constructionPermitId;
	private BaseModel<?> _constructionUnitProjectRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.projApproval.service.ClpSerializer.class;
}