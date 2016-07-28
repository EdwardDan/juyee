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

package com.justonetech.sys.model.impl;

import com.justonetech.sys.model.SMS;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SMS in entity cache.
 *
 * @author justonetech
 * @see SMS
 * @generated
 */
public class SMSCacheModel implements CacheModel<SMS>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{smsId=");
		sb.append(smsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", modifiedTime=");
		sb.append(modifiedTime);
		sb.append(", content=");
		sb.append(content);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", senderName=");
		sb.append(senderName);
		sb.append(", receiver=");
		sb.append(receiver);
		sb.append(", sendTime=");
		sb.append(sendTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SMS toEntityModel() {
		SMSImpl smsImpl = new SMSImpl();

		smsImpl.setSmsId(smsId);
		smsImpl.setGroupId(groupId);
		smsImpl.setCompanyId(companyId);

		if (createTime == Long.MIN_VALUE) {
			smsImpl.setCreateTime(null);
		}
		else {
			smsImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			smsImpl.setModifiedTime(null);
		}
		else {
			smsImpl.setModifiedTime(new Date(modifiedTime));
		}

		if (content == null) {
			smsImpl.setContent(StringPool.BLANK);
		}
		else {
			smsImpl.setContent(content);
		}

		smsImpl.setSenderId(senderId);

		if (senderName == null) {
			smsImpl.setSenderName(StringPool.BLANK);
		}
		else {
			smsImpl.setSenderName(senderName);
		}

		if (receiver == null) {
			smsImpl.setReceiver(StringPool.BLANK);
		}
		else {
			smsImpl.setReceiver(receiver);
		}

		if (sendTime == Long.MIN_VALUE) {
			smsImpl.setSendTime(null);
		}
		else {
			smsImpl.setSendTime(new Date(sendTime));
		}

		smsImpl.resetOriginalValues();

		return smsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		smsId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		content = objectInput.readUTF();
		senderId = objectInput.readLong();
		senderName = objectInput.readUTF();
		receiver = objectInput.readUTF();
		sendTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(smsId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createTime);
		objectOutput.writeLong(modifiedTime);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(senderId);

		if (senderName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(senderName);
		}

		if (receiver == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receiver);
		}

		objectOutput.writeLong(sendTime);
	}

	public long smsId;
	public long groupId;
	public long companyId;
	public long createTime;
	public long modifiedTime;
	public String content;
	public long senderId;
	public String senderName;
	public String receiver;
	public long sendTime;
}