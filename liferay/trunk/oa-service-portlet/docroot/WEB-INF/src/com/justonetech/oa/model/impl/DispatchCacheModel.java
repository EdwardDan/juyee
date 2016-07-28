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

import com.justonetech.oa.model.Dispatch;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dispatch in entity cache.
 *
 * @author justonetech
 * @see Dispatch
 * @generated
 */
public class DispatchCacheModel implements CacheModel<Dispatch>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{dispatchId=");
		sb.append(dispatchId);
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
		sb.append(", recordType=");
		sb.append(recordType);
		sb.append(", securityLevel=");
		sb.append(securityLevel);
		sb.append(", organaAbbreviation=");
		sb.append(organaAbbreviation);
		sb.append(", year=");
		sb.append(year);
		sb.append(", serialNo=");
		sb.append(serialNo);
		sb.append(", title=");
		sb.append(title);
		sb.append(", sendOrgan=");
		sb.append(sendOrgan);
		sb.append(", ccOrgan=");
		sb.append(ccOrgan);
		sb.append(", writtenOrgan=");
		sb.append(writtenOrgan);
		sb.append(", writtenDate=");
		sb.append(writtenDate);
		sb.append(", urgencyDegree=");
		sb.append(urgencyDegree);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dispatch toEntityModel() {
		DispatchImpl dispatchImpl = new DispatchImpl();

		dispatchImpl.setDispatchId(dispatchId);
		dispatchImpl.setGroupId(groupId);
		dispatchImpl.setCompanyId(companyId);
		dispatchImpl.setUserId(userId);

		if (userName == null) {
			dispatchImpl.setUserName(StringPool.BLANK);
		}
		else {
			dispatchImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			dispatchImpl.setCreateTime(null);
		}
		else {
			dispatchImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			dispatchImpl.setModifiedTime(null);
		}
		else {
			dispatchImpl.setModifiedTime(new Date(modifiedTime));
		}

		dispatchImpl.setRecordType(recordType);
		dispatchImpl.setSecurityLevel(securityLevel);
		dispatchImpl.setOrganaAbbreviation(organaAbbreviation);
		dispatchImpl.setYear(year);
		dispatchImpl.setSerialNo(serialNo);

		if (title == null) {
			dispatchImpl.setTitle(StringPool.BLANK);
		}
		else {
			dispatchImpl.setTitle(title);
		}

		if (sendOrgan == null) {
			dispatchImpl.setSendOrgan(StringPool.BLANK);
		}
		else {
			dispatchImpl.setSendOrgan(sendOrgan);
		}

		if (ccOrgan == null) {
			dispatchImpl.setCcOrgan(StringPool.BLANK);
		}
		else {
			dispatchImpl.setCcOrgan(ccOrgan);
		}

		if (writtenOrgan == null) {
			dispatchImpl.setWrittenOrgan(StringPool.BLANK);
		}
		else {
			dispatchImpl.setWrittenOrgan(writtenOrgan);
		}

		if (writtenDate == Long.MIN_VALUE) {
			dispatchImpl.setWrittenDate(null);
		}
		else {
			dispatchImpl.setWrittenDate(new Date(writtenDate));
		}

		dispatchImpl.setUrgencyDegree(urgencyDegree);

		dispatchImpl.resetOriginalValues();

		return dispatchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dispatchId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		recordType = objectInput.readLong();
		securityLevel = objectInput.readLong();
		organaAbbreviation = objectInput.readLong();
		year = objectInput.readInt();
		serialNo = objectInput.readInt();
		title = objectInput.readUTF();
		sendOrgan = objectInput.readUTF();
		ccOrgan = objectInput.readUTF();
		writtenOrgan = objectInput.readUTF();
		writtenDate = objectInput.readLong();
		urgencyDegree = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dispatchId);
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
		objectOutput.writeLong(recordType);
		objectOutput.writeLong(securityLevel);
		objectOutput.writeLong(organaAbbreviation);
		objectOutput.writeInt(year);
		objectOutput.writeInt(serialNo);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (sendOrgan == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sendOrgan);
		}

		if (ccOrgan == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccOrgan);
		}

		if (writtenOrgan == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(writtenOrgan);
		}

		objectOutput.writeLong(writtenDate);
		objectOutput.writeLong(urgencyDegree);
	}

	public long dispatchId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public long recordType;
	public long securityLevel;
	public long organaAbbreviation;
	public int year;
	public int serialNo;
	public String title;
	public String sendOrgan;
	public String ccOrgan;
	public String writtenOrgan;
	public long writtenDate;
	public long urgencyDegree;
}