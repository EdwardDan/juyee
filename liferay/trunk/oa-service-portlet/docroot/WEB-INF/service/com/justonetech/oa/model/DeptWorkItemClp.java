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

package com.justonetech.oa.model;

import com.justonetech.oa.service.ClpSerializer;
import com.justonetech.oa.service.DeptWorkItemLocalServiceUtil;

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
public class DeptWorkItemClp extends BaseModelImpl<DeptWorkItem>
	implements DeptWorkItem {
	public DeptWorkItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DeptWorkItem.class;
	}

	@Override
	public String getModelClassName() {
		return DeptWorkItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _deptWorkItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDeptWorkItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deptWorkItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deptWorkItemId", getDeptWorkItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("deptWorkId", getDeptWorkId());
		attributes.put("sortNo", getSortNo());
		attributes.put("dutyPerson", getDutyPerson());
		attributes.put("mainWork", getMainWork());
		attributes.put("schedule", getSchedule());
		attributes.put("content", getContent());
		attributes.put("agentPerson", getAgentPerson());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long deptWorkItemId = (Long)attributes.get("deptWorkItemId");

		if (deptWorkItemId != null) {
			setDeptWorkItemId(deptWorkItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long deptWorkId = (Long)attributes.get("deptWorkId");

		if (deptWorkId != null) {
			setDeptWorkId(deptWorkId);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String dutyPerson = (String)attributes.get("dutyPerson");

		if (dutyPerson != null) {
			setDutyPerson(dutyPerson);
		}

		Boolean mainWork = (Boolean)attributes.get("mainWork");

		if (mainWork != null) {
			setMainWork(mainWork);
		}

		String schedule = (String)attributes.get("schedule");

		if (schedule != null) {
			setSchedule(schedule);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String agentPerson = (String)attributes.get("agentPerson");

		if (agentPerson != null) {
			setAgentPerson(agentPerson);
		}
	}

	@Override
	public long getDeptWorkItemId() {
		return _deptWorkItemId;
	}

	@Override
	public void setDeptWorkItemId(long deptWorkItemId) {
		_deptWorkItemId = deptWorkItemId;

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDeptWorkItemId", long.class);

				method.invoke(_deptWorkItemRemoteModel, deptWorkItemId);
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

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_deptWorkItemRemoteModel, groupId);
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

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_deptWorkItemRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDeptWorkId() {
		return _deptWorkId;
	}

	@Override
	public void setDeptWorkId(long deptWorkId) {
		_deptWorkId = deptWorkId;

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDeptWorkId", long.class);

				method.invoke(_deptWorkItemRemoteModel, deptWorkId);
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

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSortNo", int.class);

				method.invoke(_deptWorkItemRemoteModel, sortNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDutyPerson() {
		return _dutyPerson;
	}

	@Override
	public void setDutyPerson(String dutyPerson) {
		_dutyPerson = dutyPerson;

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDutyPerson", String.class);

				method.invoke(_deptWorkItemRemoteModel, dutyPerson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getMainWork() {
		return _mainWork;
	}

	@Override
	public boolean isMainWork() {
		return _mainWork;
	}

	@Override
	public void setMainWork(boolean mainWork) {
		_mainWork = mainWork;

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setMainWork", boolean.class);

				method.invoke(_deptWorkItemRemoteModel, mainWork);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSchedule() {
		return _schedule;
	}

	@Override
	public void setSchedule(String schedule) {
		_schedule = schedule;

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSchedule", String.class);

				method.invoke(_deptWorkItemRemoteModel, schedule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_deptWorkItemRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgentPerson() {
		return _agentPerson;
	}

	@Override
	public void setAgentPerson(String agentPerson) {
		_agentPerson = agentPerson;

		if (_deptWorkItemRemoteModel != null) {
			try {
				Class<?> clazz = _deptWorkItemRemoteModel.getClass();

				Method method = clazz.getMethod("setAgentPerson", String.class);

				method.invoke(_deptWorkItemRemoteModel, agentPerson);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDeptWorkItemRemoteModel() {
		return _deptWorkItemRemoteModel;
	}

	public void setDeptWorkItemRemoteModel(BaseModel<?> deptWorkItemRemoteModel) {
		_deptWorkItemRemoteModel = deptWorkItemRemoteModel;
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

		Class<?> remoteModelClass = _deptWorkItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_deptWorkItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DeptWorkItemLocalServiceUtil.addDeptWorkItem(this);
		}
		else {
			DeptWorkItemLocalServiceUtil.updateDeptWorkItem(this);
		}
	}

	@Override
	public DeptWorkItem toEscapedModel() {
		return (DeptWorkItem)ProxyUtil.newProxyInstance(DeptWorkItem.class.getClassLoader(),
			new Class[] { DeptWorkItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DeptWorkItemClp clone = new DeptWorkItemClp();

		clone.setDeptWorkItemId(getDeptWorkItemId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setDeptWorkId(getDeptWorkId());
		clone.setSortNo(getSortNo());
		clone.setDutyPerson(getDutyPerson());
		clone.setMainWork(getMainWork());
		clone.setSchedule(getSchedule());
		clone.setContent(getContent());
		clone.setAgentPerson(getAgentPerson());

		return clone;
	}

	@Override
	public int compareTo(DeptWorkItem deptWorkItem) {
		long primaryKey = deptWorkItem.getPrimaryKey();

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

		if (!(obj instanceof DeptWorkItemClp)) {
			return false;
		}

		DeptWorkItemClp deptWorkItem = (DeptWorkItemClp)obj;

		long primaryKey = deptWorkItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{deptWorkItemId=");
		sb.append(getDeptWorkItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", deptWorkId=");
		sb.append(getDeptWorkId());
		sb.append(", sortNo=");
		sb.append(getSortNo());
		sb.append(", dutyPerson=");
		sb.append(getDutyPerson());
		sb.append(", mainWork=");
		sb.append(getMainWork());
		sb.append(", schedule=");
		sb.append(getSchedule());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", agentPerson=");
		sb.append(getAgentPerson());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.DeptWorkItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>deptWorkItemId</column-name><column-value><![CDATA[");
		sb.append(getDeptWorkItemId());
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
			"<column><column-name>deptWorkId</column-name><column-value><![CDATA[");
		sb.append(getDeptWorkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortNo</column-name><column-value><![CDATA[");
		sb.append(getSortNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dutyPerson</column-name><column-value><![CDATA[");
		sb.append(getDutyPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mainWork</column-name><column-value><![CDATA[");
		sb.append(getMainWork());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schedule</column-name><column-value><![CDATA[");
		sb.append(getSchedule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agentPerson</column-name><column-value><![CDATA[");
		sb.append(getAgentPerson());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _deptWorkItemId;
	private long _groupId;
	private long _companyId;
	private long _deptWorkId;
	private int _sortNo;
	private String _dutyPerson;
	private boolean _mainWork;
	private String _schedule;
	private String _content;
	private String _agentPerson;
	private BaseModel<?> _deptWorkItemRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}