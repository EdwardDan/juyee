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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DeptWorkItem}.
 * </p>
 *
 * @author justonetech
 * @see DeptWorkItem
 * @generated
 */
public class DeptWorkItemWrapper implements DeptWorkItem,
	ModelWrapper<DeptWorkItem> {
	public DeptWorkItemWrapper(DeptWorkItem deptWorkItem) {
		_deptWorkItem = deptWorkItem;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deptWorkItemId", getDeptWorkItemId());
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

	/**
	* Returns the primary key of this dept work item.
	*
	* @return the primary key of this dept work item
	*/
	@Override
	public long getPrimaryKey() {
		return _deptWorkItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dept work item.
	*
	* @param primaryKey the primary key of this dept work item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_deptWorkItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dept work item ID of this dept work item.
	*
	* @return the dept work item ID of this dept work item
	*/
	@Override
	public long getDeptWorkItemId() {
		return _deptWorkItem.getDeptWorkItemId();
	}

	/**
	* Sets the dept work item ID of this dept work item.
	*
	* @param deptWorkItemId the dept work item ID of this dept work item
	*/
	@Override
	public void setDeptWorkItemId(long deptWorkItemId) {
		_deptWorkItem.setDeptWorkItemId(deptWorkItemId);
	}

	/**
	* Returns the dept work ID of this dept work item.
	*
	* @return the dept work ID of this dept work item
	*/
	@Override
	public long getDeptWorkId() {
		return _deptWorkItem.getDeptWorkId();
	}

	/**
	* Sets the dept work ID of this dept work item.
	*
	* @param deptWorkId the dept work ID of this dept work item
	*/
	@Override
	public void setDeptWorkId(long deptWorkId) {
		_deptWorkItem.setDeptWorkId(deptWorkId);
	}

	/**
	* Returns the sort no of this dept work item.
	*
	* @return the sort no of this dept work item
	*/
	@Override
	public int getSortNo() {
		return _deptWorkItem.getSortNo();
	}

	/**
	* Sets the sort no of this dept work item.
	*
	* @param sortNo the sort no of this dept work item
	*/
	@Override
	public void setSortNo(int sortNo) {
		_deptWorkItem.setSortNo(sortNo);
	}

	/**
	* Returns the duty person of this dept work item.
	*
	* @return the duty person of this dept work item
	*/
	@Override
	public java.lang.String getDutyPerson() {
		return _deptWorkItem.getDutyPerson();
	}

	/**
	* Sets the duty person of this dept work item.
	*
	* @param dutyPerson the duty person of this dept work item
	*/
	@Override
	public void setDutyPerson(java.lang.String dutyPerson) {
		_deptWorkItem.setDutyPerson(dutyPerson);
	}

	/**
	* Returns the main work of this dept work item.
	*
	* @return the main work of this dept work item
	*/
	@Override
	public boolean getMainWork() {
		return _deptWorkItem.getMainWork();
	}

	/**
	* Returns <code>true</code> if this dept work item is main work.
	*
	* @return <code>true</code> if this dept work item is main work; <code>false</code> otherwise
	*/
	@Override
	public boolean isMainWork() {
		return _deptWorkItem.isMainWork();
	}

	/**
	* Sets whether this dept work item is main work.
	*
	* @param mainWork the main work of this dept work item
	*/
	@Override
	public void setMainWork(boolean mainWork) {
		_deptWorkItem.setMainWork(mainWork);
	}

	/**
	* Returns the schedule of this dept work item.
	*
	* @return the schedule of this dept work item
	*/
	@Override
	public java.lang.String getSchedule() {
		return _deptWorkItem.getSchedule();
	}

	/**
	* Sets the schedule of this dept work item.
	*
	* @param schedule the schedule of this dept work item
	*/
	@Override
	public void setSchedule(java.lang.String schedule) {
		_deptWorkItem.setSchedule(schedule);
	}

	/**
	* Returns the content of this dept work item.
	*
	* @return the content of this dept work item
	*/
	@Override
	public java.lang.String getContent() {
		return _deptWorkItem.getContent();
	}

	/**
	* Sets the content of this dept work item.
	*
	* @param content the content of this dept work item
	*/
	@Override
	public void setContent(java.lang.String content) {
		_deptWorkItem.setContent(content);
	}

	/**
	* Returns the agent person of this dept work item.
	*
	* @return the agent person of this dept work item
	*/
	@Override
	public java.lang.String getAgentPerson() {
		return _deptWorkItem.getAgentPerson();
	}

	/**
	* Sets the agent person of this dept work item.
	*
	* @param agentPerson the agent person of this dept work item
	*/
	@Override
	public void setAgentPerson(java.lang.String agentPerson) {
		_deptWorkItem.setAgentPerson(agentPerson);
	}

	@Override
	public boolean isNew() {
		return _deptWorkItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_deptWorkItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _deptWorkItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_deptWorkItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _deptWorkItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _deptWorkItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_deptWorkItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _deptWorkItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_deptWorkItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_deptWorkItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_deptWorkItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DeptWorkItemWrapper((DeptWorkItem)_deptWorkItem.clone());
	}

	@Override
	public int compareTo(com.justonetech.oa.model.DeptWorkItem deptWorkItem) {
		return _deptWorkItem.compareTo(deptWorkItem);
	}

	@Override
	public int hashCode() {
		return _deptWorkItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.DeptWorkItem> toCacheModel() {
		return _deptWorkItem.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.DeptWorkItem toEscapedModel() {
		return new DeptWorkItemWrapper(_deptWorkItem.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.DeptWorkItem toUnescapedModel() {
		return new DeptWorkItemWrapper(_deptWorkItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _deptWorkItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _deptWorkItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_deptWorkItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeptWorkItemWrapper)) {
			return false;
		}

		DeptWorkItemWrapper deptWorkItemWrapper = (DeptWorkItemWrapper)obj;

		if (Validator.equals(_deptWorkItem, deptWorkItemWrapper._deptWorkItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DeptWorkItem getWrappedDeptWorkItem() {
		return _deptWorkItem;
	}

	@Override
	public DeptWorkItem getWrappedModel() {
		return _deptWorkItem;
	}

	@Override
	public void resetOriginalValues() {
		_deptWorkItem.resetOriginalValues();
	}

	private DeptWorkItem _deptWorkItem;
}