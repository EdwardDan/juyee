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

import com.justonetech.oa.model.VehicleRequisition;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VehicleRequisition in entity cache.
 *
 * @author justonetech
 * @see VehicleRequisition
 * @generated
 */
public class VehicleRequisitionCacheModel implements CacheModel<VehicleRequisition>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{vehicleRequisitionId=");
		sb.append(vehicleRequisitionId);
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
	public VehicleRequisition toEntityModel() {
		VehicleRequisitionImpl vehicleRequisitionImpl = new VehicleRequisitionImpl();

		vehicleRequisitionImpl.setVehicleRequisitionId(vehicleRequisitionId);
		vehicleRequisitionImpl.setUserId(userId);

		if (userName == null) {
			vehicleRequisitionImpl.setUserName(StringPool.BLANK);
		}
		else {
			vehicleRequisitionImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			vehicleRequisitionImpl.setCreateTime(null);
		}
		else {
			vehicleRequisitionImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			vehicleRequisitionImpl.setModifiedTime(null);
		}
		else {
			vehicleRequisitionImpl.setModifiedTime(new Date(modifiedTime));
		}

		vehicleRequisitionImpl.setApplicantDeptId(applicantDeptId);

		if (applicantDeptName == null) {
			vehicleRequisitionImpl.setApplicantDeptName(StringPool.BLANK);
		}
		else {
			vehicleRequisitionImpl.setApplicantDeptName(applicantDeptName);
		}

		vehicleRequisitionImpl.setApplicantId(applicantId);

		if (applicantName == null) {
			vehicleRequisitionImpl.setApplicantName(StringPool.BLANK);
		}
		else {
			vehicleRequisitionImpl.setApplicantName(applicantName);
		}

		if (startTime == Long.MIN_VALUE) {
			vehicleRequisitionImpl.setStartTime(null);
		}
		else {
			vehicleRequisitionImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			vehicleRequisitionImpl.setEndTime(null);
		}
		else {
			vehicleRequisitionImpl.setEndTime(new Date(endTime));
		}

		vehicleRequisitionImpl.setPassengerNum(passengerNum);

		if (reason == null) {
			vehicleRequisitionImpl.setReason(StringPool.BLANK);
		}
		else {
			vehicleRequisitionImpl.setReason(reason);
		}

		if (destination == null) {
			vehicleRequisitionImpl.setDestination(StringPool.BLANK);
		}
		else {
			vehicleRequisitionImpl.setDestination(destination);
		}

		vehicleRequisitionImpl.resetOriginalValues();

		return vehicleRequisitionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vehicleRequisitionId = objectInput.readLong();
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
		objectOutput.writeLong(vehicleRequisitionId);
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

	public long vehicleRequisitionId;
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