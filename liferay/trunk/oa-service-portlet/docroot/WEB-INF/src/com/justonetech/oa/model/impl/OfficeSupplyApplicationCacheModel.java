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

import com.justonetech.oa.model.OfficeSupplyApplication;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OfficeSupplyApplication in entity cache.
 *
 * @author justonetech
 * @see OfficeSupplyApplication
 * @generated
 */
public class OfficeSupplyApplicationCacheModel implements CacheModel<OfficeSupplyApplication>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{officeSupplyApplicationId=");
		sb.append(officeSupplyApplicationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
		sb.append(", introductions=");
		sb.append(introductions);
		sb.append(", perposeClerk=");
		sb.append(perposeClerk);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OfficeSupplyApplication toEntityModel() {
		OfficeSupplyApplicationImpl officeSupplyApplicationImpl = new OfficeSupplyApplicationImpl();

		officeSupplyApplicationImpl.setOfficeSupplyApplicationId(officeSupplyApplicationId);
		officeSupplyApplicationImpl.setGroupId(groupId);
		officeSupplyApplicationImpl.setCompanyId(companyId);
		officeSupplyApplicationImpl.setUserId(userId);

		if (userName == null) {
			officeSupplyApplicationImpl.setUserName(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			officeSupplyApplicationImpl.setCreateTime(null);
		}
		else {
			officeSupplyApplicationImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			officeSupplyApplicationImpl.setModifiedTime(null);
		}
		else {
			officeSupplyApplicationImpl.setModifiedTime(new Date(modifiedTime));
		}

		officeSupplyApplicationImpl.setDeptId(deptId);

		if (deptName == null) {
			officeSupplyApplicationImpl.setDeptName(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationImpl.setDeptName(deptName);
		}

		if (introductions == null) {
			officeSupplyApplicationImpl.setIntroductions(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationImpl.setIntroductions(introductions);
		}

		if (perposeClerk == null) {
			officeSupplyApplicationImpl.setPerposeClerk(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationImpl.setPerposeClerk(perposeClerk);
		}

		if (title == null) {
			officeSupplyApplicationImpl.setTitle(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationImpl.setTitle(title);
		}

		if (content == null) {
			officeSupplyApplicationImpl.setContent(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationImpl.setContent(content);
		}

		officeSupplyApplicationImpl.setStatus(status);
		officeSupplyApplicationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			officeSupplyApplicationImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			officeSupplyApplicationImpl.setStatusDate(null);
		}
		else {
			officeSupplyApplicationImpl.setStatusDate(new Date(statusDate));
		}

		officeSupplyApplicationImpl.resetOriginalValues();

		return officeSupplyApplicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeSupplyApplicationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		deptId = objectInput.readLong();
		deptName = objectInput.readUTF();
		introductions = objectInput.readUTF();
		perposeClerk = objectInput.readUTF();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(officeSupplyApplicationId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
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

		if (introductions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(introductions);
		}

		if (perposeClerk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(perposeClerk);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long officeSupplyApplicationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public long deptId;
	public String deptName;
	public String introductions;
	public String perposeClerk;
	public String title;
	public String content;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}