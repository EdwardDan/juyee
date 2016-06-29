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

import com.justonetech.oa.model.DeptWork;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DeptWork in entity cache.
 *
 * @author justonetech
 * @see DeptWork
 * @generated
 */
public class DeptWorkCacheModel implements CacheModel<DeptWork>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{deptWorkId=");
		sb.append(deptWorkId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", modifiedTime=");
		sb.append(modifiedTime);
		sb.append(", deptId=");
		sb.append(deptId);
		sb.append(", deptName=");
		sb.append(deptName);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DeptWork toEntityModel() {
		DeptWorkImpl deptWorkImpl = new DeptWorkImpl();

		deptWorkImpl.setDeptWorkId(deptWorkId);
		deptWorkImpl.setUserId(userId);

		if (userName == null) {
			deptWorkImpl.setUserName(StringPool.BLANK);
		}
		else {
			deptWorkImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			deptWorkImpl.setCreateTime(null);
		}
		else {
			deptWorkImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			deptWorkImpl.setModifiedTime(null);
		}
		else {
			deptWorkImpl.setModifiedTime(new Date(modifiedTime));
		}

		deptWorkImpl.setDeptId(deptId);

		if (deptName == null) {
			deptWorkImpl.setDeptName(StringPool.BLANK);
		}
		else {
			deptWorkImpl.setDeptName(deptName);
		}

		if (startDate == Long.MIN_VALUE) {
			deptWorkImpl.setStartDate(null);
		}
		else {
			deptWorkImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			deptWorkImpl.setEndDate(null);
		}
		else {
			deptWorkImpl.setEndDate(new Date(endDate));
		}

		if (status == null) {
			deptWorkImpl.setStatus(StringPool.BLANK);
		}
		else {
			deptWorkImpl.setStatus(status);
		}

		deptWorkImpl.resetOriginalValues();

		return deptWorkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		deptWorkId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		deptId = objectInput.readLong();
		deptName = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(deptWorkId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createTime);
		objectOutput.writeLong(modifiedTime);
		objectOutput.writeLong(deptId);

		if (deptName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deptName);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long deptWorkId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public long deptId;
	public String deptName;
	public long startDate;
	public long endDate;
	public String status;
}