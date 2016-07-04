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

import com.justonetech.oa.model.OfficeSupplyRequisition;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OfficeSupplyRequisition in entity cache.
 *
 * @author justonetech
 * @see OfficeSupplyRequisition
 * @generated
 */
public class OfficeSupplyRequisitionCacheModel implements CacheModel<OfficeSupplyRequisition>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{officeSupplyRequisitionId=");
		sb.append(officeSupplyRequisitionId);
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
	public OfficeSupplyRequisition toEntityModel() {
		OfficeSupplyRequisitionImpl officeSupplyRequisitionImpl = new OfficeSupplyRequisitionImpl();

		officeSupplyRequisitionImpl.setOfficeSupplyRequisitionId(officeSupplyRequisitionId);
		officeSupplyRequisitionImpl.setUserId(userId);

		if (userName == null) {
			officeSupplyRequisitionImpl.setUserName(StringPool.BLANK);
		}
		else {
			officeSupplyRequisitionImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			officeSupplyRequisitionImpl.setCreateTime(null);
		}
		else {
			officeSupplyRequisitionImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			officeSupplyRequisitionImpl.setModifiedTime(null);
		}
		else {
			officeSupplyRequisitionImpl.setModifiedTime(new Date(modifiedTime));
		}

		officeSupplyRequisitionImpl.setDeptId(deptId);

		if (deptName == null) {
			officeSupplyRequisitionImpl.setDeptName(StringPool.BLANK);
		}
		else {
			officeSupplyRequisitionImpl.setDeptName(deptName);
		}

		officeSupplyRequisitionImpl.setApplicantId(applicantId);

		if (applicantName == null) {
			officeSupplyRequisitionImpl.setApplicantName(StringPool.BLANK);
		}
		else {
			officeSupplyRequisitionImpl.setApplicantName(applicantName);
		}

		if (introductions == null) {
			officeSupplyRequisitionImpl.setIntroductions(StringPool.BLANK);
		}
		else {
			officeSupplyRequisitionImpl.setIntroductions(introductions);
		}

		officeSupplyRequisitionImpl.resetOriginalValues();

		return officeSupplyRequisitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeSupplyRequisitionId = objectInput.readLong();
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
		objectOutput.writeLong(officeSupplyRequisitionId);
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

	public long officeSupplyRequisitionId;
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