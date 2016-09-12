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

package com.justonetech.cp.complete.model.impl;

import com.justonetech.cp.complete.model.Complete;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Complete in entity cache.
 *
 * @author fanqi
 * @see Complete
 * @generated
 */
public class CompleteCacheModel implements CacheModel<Complete>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{completeId=");
		sb.append(completeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", zzjgdm=");
		sb.append(zzjgdm);
		sb.append(", bjbh=");
		sb.append(bjbh);
		sb.append(", sqbz=");
		sb.append(sqbz);
		sb.append(", sqzt=");
		sb.append(sqzt);
		sb.append(", babh=");
		sb.append(babh);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Complete toEntityModel() {
		CompleteImpl completeImpl = new CompleteImpl();

		completeImpl.setCompleteId(completeId);
		completeImpl.setGroupId(groupId);
		completeImpl.setCompanyId(companyId);
		completeImpl.setUserId(userId);

		if (userName == null) {
			completeImpl.setUserName(StringPool.BLANK);
		}
		else {
			completeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			completeImpl.setCreateDate(null);
		}
		else {
			completeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			completeImpl.setModifiedDate(null);
		}
		else {
			completeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (zzjgdm == null) {
			completeImpl.setZzjgdm(StringPool.BLANK);
		}
		else {
			completeImpl.setZzjgdm(zzjgdm);
		}

		if (bjbh == null) {
			completeImpl.setBjbh(StringPool.BLANK);
		}
		else {
			completeImpl.setBjbh(bjbh);
		}

		completeImpl.setSqbz(sqbz);
		completeImpl.setSqzt(sqzt);

		if (babh == null) {
			completeImpl.setBabh(StringPool.BLANK);
		}
		else {
			completeImpl.setBabh(babh);
		}

		completeImpl.resetOriginalValues();

		return completeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		completeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		zzjgdm = objectInput.readUTF();
		bjbh = objectInput.readUTF();
		sqbz = objectInput.readInt();
		sqzt = objectInput.readInt();
		babh = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(completeId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (zzjgdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zzjgdm);
		}

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		objectOutput.writeInt(sqbz);
		objectOutput.writeInt(sqzt);

		if (babh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(babh);
		}
	}

	public long completeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String zzjgdm;
	public String bjbh;
	public int sqbz;
	public int sqzt;
	public String babh;
}