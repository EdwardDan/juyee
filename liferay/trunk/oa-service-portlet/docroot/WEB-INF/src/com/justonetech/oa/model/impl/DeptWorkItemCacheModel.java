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

package com.justonetech.oa.model.impl;

import com.justonetech.oa.model.DeptWorkItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DeptWorkItem in entity cache.
 *
 * @author justonetech
 * @see DeptWorkItem
 * @generated
 */
public class DeptWorkItemCacheModel implements CacheModel<DeptWorkItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{deptWorkItemId=");
		sb.append(deptWorkItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", deptWorkId=");
		sb.append(deptWorkId);
		sb.append(", sortNo=");
		sb.append(sortNo);
		sb.append(", dutyPerson=");
		sb.append(dutyPerson);
		sb.append(", mainWork=");
		sb.append(mainWork);
		sb.append(", schedule=");
		sb.append(schedule);
		sb.append(", content=");
		sb.append(content);
		sb.append(", agentPerson=");
		sb.append(agentPerson);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DeptWorkItem toEntityModel() {
		DeptWorkItemImpl deptWorkItemImpl = new DeptWorkItemImpl();

		deptWorkItemImpl.setDeptWorkItemId(deptWorkItemId);
		deptWorkItemImpl.setGroupId(groupId);
		deptWorkItemImpl.setCompanyId(companyId);
		deptWorkItemImpl.setDeptWorkId(deptWorkId);
		deptWorkItemImpl.setSortNo(sortNo);

		if (dutyPerson == null) {
			deptWorkItemImpl.setDutyPerson(StringPool.BLANK);
		}
		else {
			deptWorkItemImpl.setDutyPerson(dutyPerson);
		}

		deptWorkItemImpl.setMainWork(mainWork);

		if (schedule == null) {
			deptWorkItemImpl.setSchedule(StringPool.BLANK);
		}
		else {
			deptWorkItemImpl.setSchedule(schedule);
		}

		if (content == null) {
			deptWorkItemImpl.setContent(StringPool.BLANK);
		}
		else {
			deptWorkItemImpl.setContent(content);
		}

		if (agentPerson == null) {
			deptWorkItemImpl.setAgentPerson(StringPool.BLANK);
		}
		else {
			deptWorkItemImpl.setAgentPerson(agentPerson);
		}

		deptWorkItemImpl.resetOriginalValues();

		return deptWorkItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		deptWorkItemId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		deptWorkId = objectInput.readLong();
		sortNo = objectInput.readInt();
		dutyPerson = objectInput.readUTF();
		mainWork = objectInput.readBoolean();
		schedule = objectInput.readUTF();
		content = objectInput.readUTF();
		agentPerson = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(deptWorkItemId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(deptWorkId);
		objectOutput.writeInt(sortNo);

		if (dutyPerson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dutyPerson);
		}

		objectOutput.writeBoolean(mainWork);

		if (schedule == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(schedule);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (agentPerson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(agentPerson);
		}
	}

	public long deptWorkItemId;
	public long groupId;
	public long companyId;
	public long deptWorkId;
	public int sortNo;
	public String dutyPerson;
	public boolean mainWork;
	public String schedule;
	public String content;
	public String agentPerson;
}