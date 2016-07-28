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

import com.justonetech.oa.model.VehicleApplication;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VehicleApplication in entity cache.
 *
 * @author justonetech
 * @see VehicleApplication
 * @generated
 */
public class VehicleApplicationCacheModel implements CacheModel<VehicleApplication>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{vehicleApplicationId=");
		sb.append(vehicleApplicationId);
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
		sb.append(", applicantDeptId=");
		sb.append(applicantDeptId);
		sb.append(", applicantDeptName=");
		sb.append(applicantDeptName);
		sb.append(", applicantId=");
		sb.append(applicantId);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", passengerNum=");
		sb.append(passengerNum);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", destination=");
		sb.append(destination);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VehicleApplication toEntityModel() {
		VehicleApplicationImpl vehicleApplicationImpl = new VehicleApplicationImpl();

		vehicleApplicationImpl.setVehicleApplicationId(vehicleApplicationId);
		vehicleApplicationImpl.setGroupId(groupId);
		vehicleApplicationImpl.setCompanyId(companyId);
		vehicleApplicationImpl.setUserId(userId);

		if (userName == null) {
			vehicleApplicationImpl.setUserName(StringPool.BLANK);
		}
		else {
			vehicleApplicationImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			vehicleApplicationImpl.setCreateTime(null);
		}
		else {
			vehicleApplicationImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			vehicleApplicationImpl.setModifiedTime(null);
		}
		else {
			vehicleApplicationImpl.setModifiedTime(new Date(modifiedTime));
		}

		vehicleApplicationImpl.setApplicantDeptId(applicantDeptId);

		if (applicantDeptName == null) {
			vehicleApplicationImpl.setApplicantDeptName(StringPool.BLANK);
		}
		else {
			vehicleApplicationImpl.setApplicantDeptName(applicantDeptName);
		}

		vehicleApplicationImpl.setApplicantId(applicantId);

		if (applicantName == null) {
			vehicleApplicationImpl.setApplicantName(StringPool.BLANK);
		}
		else {
			vehicleApplicationImpl.setApplicantName(applicantName);
		}

		if (startTime == Long.MIN_VALUE) {
			vehicleApplicationImpl.setStartTime(null);
		}
		else {
			vehicleApplicationImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			vehicleApplicationImpl.setEndTime(null);
		}
		else {
			vehicleApplicationImpl.setEndTime(new Date(endTime));
		}

		vehicleApplicationImpl.setPassengerNum(passengerNum);

		if (reason == null) {
			vehicleApplicationImpl.setReason(StringPool.BLANK);
		}
		else {
			vehicleApplicationImpl.setReason(reason);
		}

		if (destination == null) {
			vehicleApplicationImpl.setDestination(StringPool.BLANK);
		}
		else {
			vehicleApplicationImpl.setDestination(destination);
		}

		vehicleApplicationImpl.resetOriginalValues();

		return vehicleApplicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vehicleApplicationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		applicantDeptId = objectInput.readLong();
		applicantDeptName = objectInput.readUTF();
		applicantId = objectInput.readLong();
		applicantName = objectInput.readUTF();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		passengerNum = objectInput.readInt();
		reason = objectInput.readUTF();
		destination = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(vehicleApplicationId);
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
		objectOutput.writeLong(applicantDeptId);

		if (applicantDeptName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantDeptName);
		}

		objectOutput.writeLong(applicantId);

		if (applicantName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
		objectOutput.writeInt(passengerNum);

		if (reason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (destination == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(destination);
		}
	}

	public long vehicleApplicationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public long applicantDeptId;
	public String applicantDeptName;
	public long applicantId;
	public String applicantName;
	public long startTime;
	public long endTime;
	public int passengerNum;
	public String reason;
	public String destination;
}