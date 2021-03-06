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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the DeptWorkItem service. Represents a row in the &quot;oa_DeptWorkItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.oa.model.impl.DeptWorkItemModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.oa.model.impl.DeptWorkItemImpl}.
 * </p>
 *
 * @author justonetech
 * @see DeptWorkItem
 * @see com.justonetech.oa.model.impl.DeptWorkItemImpl
 * @see com.justonetech.oa.model.impl.DeptWorkItemModelImpl
 * @generated
 */
public interface DeptWorkItemModel extends BaseModel<DeptWorkItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a dept work item model instance should use the {@link DeptWorkItem} interface instead.
	 */

	/**
	 * Returns the primary key of this dept work item.
	 *
	 * @return the primary key of this dept work item
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this dept work item.
	 *
	 * @param primaryKey the primary key of this dept work item
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the dept work item ID of this dept work item.
	 *
	 * @return the dept work item ID of this dept work item
	 */
	public long getDeptWorkItemId();

	/**
	 * Sets the dept work item ID of this dept work item.
	 *
	 * @param deptWorkItemId the dept work item ID of this dept work item
	 */
	public void setDeptWorkItemId(long deptWorkItemId);

	/**
	 * Returns the group ID of this dept work item.
	 *
	 * @return the group ID of this dept work item
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this dept work item.
	 *
	 * @param groupId the group ID of this dept work item
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this dept work item.
	 *
	 * @return the company ID of this dept work item
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this dept work item.
	 *
	 * @param companyId the company ID of this dept work item
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the dept work ID of this dept work item.
	 *
	 * @return the dept work ID of this dept work item
	 */
	public long getDeptWorkId();

	/**
	 * Sets the dept work ID of this dept work item.
	 *
	 * @param deptWorkId the dept work ID of this dept work item
	 */
	public void setDeptWorkId(long deptWorkId);

	/**
	 * Returns the sort no of this dept work item.
	 *
	 * @return the sort no of this dept work item
	 */
	public int getSortNo();

	/**
	 * Sets the sort no of this dept work item.
	 *
	 * @param sortNo the sort no of this dept work item
	 */
	public void setSortNo(int sortNo);

	/**
	 * Returns the duty person of this dept work item.
	 *
	 * @return the duty person of this dept work item
	 */
	@AutoEscape
	public String getDutyPerson();

	/**
	 * Sets the duty person of this dept work item.
	 *
	 * @param dutyPerson the duty person of this dept work item
	 */
	public void setDutyPerson(String dutyPerson);

	/**
	 * Returns the main work of this dept work item.
	 *
	 * @return the main work of this dept work item
	 */
	public boolean getMainWork();

	/**
	 * Returns <code>true</code> if this dept work item is main work.
	 *
	 * @return <code>true</code> if this dept work item is main work; <code>false</code> otherwise
	 */
	public boolean isMainWork();

	/**
	 * Sets whether this dept work item is main work.
	 *
	 * @param mainWork the main work of this dept work item
	 */
	public void setMainWork(boolean mainWork);

	/**
	 * Returns the schedule of this dept work item.
	 *
	 * @return the schedule of this dept work item
	 */
	@AutoEscape
	public String getSchedule();

	/**
	 * Sets the schedule of this dept work item.
	 *
	 * @param schedule the schedule of this dept work item
	 */
	public void setSchedule(String schedule);

	/**
	 * Returns the content of this dept work item.
	 *
	 * @return the content of this dept work item
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this dept work item.
	 *
	 * @param content the content of this dept work item
	 */
	public void setContent(String content);

	/**
	 * Returns the agent person of this dept work item.
	 *
	 * @return the agent person of this dept work item
	 */
	@AutoEscape
	public String getAgentPerson();

	/**
	 * Sets the agent person of this dept work item.
	 *
	 * @param agentPerson the agent person of this dept work item
	 */
	public void setAgentPerson(String agentPerson);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.justonetech.oa.model.DeptWorkItem deptWorkItem);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.oa.model.DeptWorkItem> toCacheModel();

	@Override
	public com.justonetech.oa.model.DeptWorkItem toEscapedModel();

	@Override
	public com.justonetech.oa.model.DeptWorkItem toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}