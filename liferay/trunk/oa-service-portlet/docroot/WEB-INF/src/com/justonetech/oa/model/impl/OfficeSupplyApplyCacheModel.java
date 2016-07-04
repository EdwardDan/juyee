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

import com.justonetech.oa.model.OfficeSupplyApply;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OfficeSupplyApply in entity cache.
 *
 * @author justonetech
 * @see OfficeSupplyApply
 * @generated
 */
public class OfficeSupplyApplyCacheModel implements CacheModel<OfficeSupplyApply>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{officeSupplyApplyId=");
		sb.append(officeSupplyApplyId);
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
		sb.append(", applicantId=");
		sb.append(applicantId);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", introductions=");
		sb.append(introductions);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OfficeSupplyApply toEntityModel() {
		OfficeSupplyApplyImpl officeSupplyApplyImpl = new OfficeSupplyApplyImpl();

		officeSupplyApplyImpl.setOfficeSupplyApplyId(officeSupplyApplyId);
		officeSupplyApplyImpl.setUserId(userId);

		if (userName == null) {
			officeSupplyApplyImpl.setUserName(StringPool.BLANK);
		}
		else {
			officeSupplyApplyImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			officeSupplyApplyImpl.setCreateTime(null);
		}
		else {
			officeSupplyApplyImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			officeSupplyApplyImpl.setModifiedTime(null);
		}
		else {
			officeSupplyApplyImpl.setModifiedTime(new Date(modifiedTime));
		}

		officeSupplyApplyImpl.setDeptId(deptId);

		if (deptName == null) {
			officeSupplyApplyImpl.setDeptName(StringPool.BLANK);
		}
		else {
			officeSupplyApplyImpl.setDeptName(deptName);
		}

		officeSupplyApplyImpl.setApplicantId(applicantId);

		if (applicantName == null) {
			officeSupplyApplyImpl.setApplicantName(StringPool.BLANK);
		}
		else {
			officeSupplyApplyImpl.setApplicantName(applicantName);
		}

		if (introductions == null) {
			officeSupplyApplyImpl.setIntroductions(StringPool.BLANK);
		}
		else {
			officeSupplyApplyImpl.setIntroductions(introductions);
		}

		officeSupplyApplyImpl.resetOriginalValues();

		return officeSupplyApplyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeSupplyApplyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		deptId = objectInput.readLong();
		deptName = objectInput.readUTF();
		applicantId = objectInput.readLong();
		applicantName = objectInput.readUTF();
		introductions = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(officeSupplyApplyId);
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

		objectOutput.writeLong(applicantId);

		if (applicantName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (introductions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(introductions);
		}
	}

	public long officeSupplyApplyId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public long deptId;
	public String deptName;
	public long applicantId;
	public String applicantName;
	public String introductions;
}