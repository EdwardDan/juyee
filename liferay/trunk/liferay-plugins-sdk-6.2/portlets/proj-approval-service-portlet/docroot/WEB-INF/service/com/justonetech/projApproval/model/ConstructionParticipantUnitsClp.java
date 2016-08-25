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
import com.justonetech.projApproval.service.ConstructionParticipantUnitsLocalServiceUtil;

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
public class ConstructionParticipantUnitsClp extends BaseModelImpl<ConstructionParticipantUnits>
	implements ConstructionParticipantUnits {
	public ConstructionParticipantUnitsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ConstructionParticipantUnits.class;
	}

	@Override
	public String getModelClassName() {
		return ConstructionParticipantUnits.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _constructionParticipantUnitsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setConstructionParticipantUnitsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _constructionParticipantUnitsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("constructionParticipantUnitsId",
			getConstructionParticipantUnitsId());
		attributes.put("sortNo", getSortNo());
		attributes.put("contractInfoSubmitNum", getContractInfoSubmitNum());
		attributes.put("unitType", getUnitType());
		attributes.put("unitName", getUnitName());
		attributes.put("projectLeader", getProjectLeader());
		attributes.put("telephoneNum", getTelephoneNum());
		attributes.put("constructionPermitId", getConstructionPermitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long constructionParticipantUnitsId = (Long)attributes.get(
				"constructionParticipantUnitsId");

		if (constructionParticipantUnitsId != null) {
			setConstructionParticipantUnitsId(constructionParticipantUnitsId);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String contractInfoSubmitNum = (String)attributes.get(
				"contractInfoSubmitNum");

		if (contractInfoSubmitNum != null) {
			setContractInfoSubmitNum(contractInfoSubmitNum);
		}

		Long unitType = (Long)attributes.get("unitType");

		if (unitType != null) {
			setUnitType(unitType);
		}

		String unitName = (String)attributes.get("unitName");

		if (unitName != null) {
			setUnitName(unitName);
		}

		String projectLeader = (String)attributes.get("projectLeader");

		if (projectLeader != null) {
			setProjectLeader(projectLeader);
		}

		String telephoneNum = (String)attributes.get("telephoneNum");

		if (telephoneNum != null) {
			setTelephoneNum(telephoneNum);
		}

		Long constructionPermitId = (Long)attributes.get("constructionPermitId");

		if (constructionPermitId != null) {
			setConstructionPermitId(constructionPermitId);
		}
	}

	@Override
	public long getConstructionParticipantUnitsId() {
		return _constructionParticipantUnitsId;
	}

	@Override
	public void setConstructionParticipantUnitsId(
		long constructionParticipantUnitsId) {
		_constructionParticipantUnitsId = constructionParticipantUnitsId;

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionParticipantUnitsId",
						long.class);

				method.invoke(_constructionParticipantUnitsRemoteModel,
					constructionParticipantUnitsId);
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

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setSortNo", int.class);

				method.invoke(_constructionParticipantUnitsRemoteModel, sortNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContractInfoSubmitNum() {
		return _contractInfoSubmitNum;
	}

	@Override
	public void setContractInfoSubmitNum(String contractInfoSubmitNum) {
		_contractInfoSubmitNum = contractInfoSubmitNum;

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setContractInfoSubmitNum",
						String.class);

				method.invoke(_constructionParticipantUnitsRemoteModel,
					contractInfoSubmitNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUnitType() {
		return _unitType;
	}

	@Override
	public void setUnitType(long unitType) {
		_unitType = unitType;

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitType", long.class);

				method.invoke(_constructionParticipantUnitsRemoteModel, unitType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnitName() {
		return _unitName;
	}

	@Override
	public void setUnitName(String unitName) {
		_unitName = unitName;

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitName", String.class);

				method.invoke(_constructionParticipantUnitsRemoteModel, unitName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectLeader() {
		return _projectLeader;
	}

	@Override
	public void setProjectLeader(String projectLeader) {
		_projectLeader = projectLeader;

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectLeader", String.class);

				method.invoke(_constructionParticipantUnitsRemoteModel,
					projectLeader);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelephoneNum() {
		return _telephoneNum;
	}

	@Override
	public void setTelephoneNum(String telephoneNum) {
		_telephoneNum = telephoneNum;

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setTelephoneNum", String.class);

				method.invoke(_constructionParticipantUnitsRemoteModel,
					telephoneNum);
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

		if (_constructionParticipantUnitsRemoteModel != null) {
			try {
				Class<?> clazz = _constructionParticipantUnitsRemoteModel.getClass();

				Method method = clazz.getMethod("setConstructionPermitId",
						long.class);

				method.invoke(_constructionParticipantUnitsRemoteModel,
					constructionPermitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getConstructionParticipantUnitsRemoteModel() {
		return _constructionParticipantUnitsRemoteModel;
	}

	public void setConstructionParticipantUnitsRemoteModel(
		BaseModel<?> constructionParticipantUnitsRemoteModel) {
		_constructionParticipantUnitsRemoteModel = constructionParticipantUnitsRemoteModel;
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

		Class<?> remoteModelClass = _constructionParticipantUnitsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_constructionParticipantUnitsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ConstructionParticipantUnitsLocalServiceUtil.addConstructionParticipantUnits(this);
		}
		else {
			ConstructionParticipantUnitsLocalServiceUtil.updateConstructionParticipantUnits(this);
		}
	}

	@Override
	public ConstructionParticipantUnits toEscapedModel() {
		return (ConstructionParticipantUnits)ProxyUtil.newProxyInstance(ConstructionParticipantUnits.class.getClassLoader(),
			new Class[] { ConstructionParticipantUnits.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConstructionParticipantUnitsClp clone = new ConstructionParticipantUnitsClp();

		clone.setConstructionParticipantUnitsId(getConstructionParticipantUnitsId());
		clone.setSortNo(getSortNo());
		clone.setContractInfoSubmitNum(getContractInfoSubmitNum());
		clone.setUnitType(getUnitType());
		clone.setUnitName(getUnitName());
		clone.setProjectLeader(getProjectLeader());
		clone.setTelephoneNum(getTelephoneNum());
		clone.setConstructionPermitId(getConstructionPermitId());

		return clone;
	}

	@Override
	public int compareTo(
		ConstructionParticipantUnits constructionParticipantUnits) {
		long primaryKey = constructionParticipantUnits.getPrimaryKey();

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

		if (!(obj instanceof ConstructionParticipantUnitsClp)) {
			return false;
		}

		ConstructionParticipantUnitsClp constructionParticipantUnits = (ConstructionParticipantUnitsClp)obj;

		long primaryKey = constructionParticipantUnits.getPrimaryKey();

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

		sb.append("{constructionParticipantUnitsId=");
		sb.append(getConstructionParticipantUnitsId());
		sb.append(", sortNo=");
		sb.append(getSortNo());
		sb.append(", contractInfoSubmitNum=");
		sb.append(getContractInfoSubmitNum());
		sb.append(", unitType=");
		sb.append(getUnitType());
		sb.append(", unitName=");
		sb.append(getUnitName());
		sb.append(", projectLeader=");
		sb.append(getProjectLeader());
		sb.append(", telephoneNum=");
		sb.append(getTelephoneNum());
		sb.append(", constructionPermitId=");
		sb.append(getConstructionPermitId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"com.justonetech.projApproval.model.ConstructionParticipantUnits");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>constructionParticipantUnitsId</column-name><column-value><![CDATA[");
		sb.append(getConstructionParticipantUnitsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortNo</column-name><column-value><![CDATA[");
		sb.append(getSortNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contractInfoSubmitNum</column-name><column-value><![CDATA[");
		sb.append(getContractInfoSubmitNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitType</column-name><column-value><![CDATA[");
		sb.append(getUnitType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitName</column-name><column-value><![CDATA[");
		sb.append(getUnitName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectLeader</column-name><column-value><![CDATA[");
		sb.append(getProjectLeader());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telephoneNum</column-name><column-value><![CDATA[");
		sb.append(getTelephoneNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>constructionPermitId</column-name><column-value><![CDATA[");
		sb.append(getConstructionPermitId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _constructionParticipantUnitsId;
	private int _sortNo;
	private String _contractInfoSubmitNum;
	private long _unitType;
	private String _unitName;
	private String _projectLeader;
	private String _telephoneNum;
	private long _constructionPermitId;
	private BaseModel<?> _constructionParticipantUnitsRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.projApproval.service.ClpSerializer.class;
}