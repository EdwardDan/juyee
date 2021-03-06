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
		StringBundler sb = new StringBundler(35);

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
		sb.append(", status=");
		sb.append(status);
		sb.append(", babh=");
		sb.append(babh);
		sb.append(", wssqbh=");
		sb.append(wssqbh);
		sb.append(", sbrq=");
		sb.append(sbrq);
		sb.append(", shyj=");
		sb.append(shyj);
		sb.append(", shr=");
		sb.append(shr);
		sb.append(", shrq=");
		sb.append(shrq);
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
		completeImpl.setStatus(status);

		if (babh == null) {
			completeImpl.setBabh(StringPool.BLANK);
		}
		else {
			completeImpl.setBabh(babh);
		}

		if (wssqbh == null) {
			completeImpl.setWssqbh(StringPool.BLANK);
		}
		else {
			completeImpl.setWssqbh(wssqbh);
		}

		if (sbrq == Long.MIN_VALUE) {
			completeImpl.setSbrq(null);
		}
		else {
			completeImpl.setSbrq(new Date(sbrq));
		}

		if (shyj == null) {
			completeImpl.setShyj(StringPool.BLANK);
		}
		else {
			completeImpl.setShyj(shyj);
		}

		if (shr == null) {
			completeImpl.setShr(StringPool.BLANK);
		}
		else {
			completeImpl.setShr(shr);
		}

		if (shrq == Long.MIN_VALUE) {
			completeImpl.setShrq(null);
		}
		else {
			completeImpl.setShrq(new Date(shrq));
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
		status = objectInput.readInt();
		babh = objectInput.readUTF();
		wssqbh = objectInput.readUTF();
		sbrq = objectInput.readLong();
		shyj = objectInput.readUTF();
		shr = objectInput.readUTF();
		shrq = objectInput.readLong();
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
		objectOutput.writeInt(status);

		if (babh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(babh);
		}

		if (wssqbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wssqbh);
		}

		objectOutput.writeLong(sbrq);

		if (shyj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shyj);
		}

		if (shr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shr);
		}

		objectOutput.writeLong(shrq);
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
	public int status;
	public String babh;
	public String wssqbh;
	public long sbrq;
	public String shyj;
	public String shr;
	public long shrq;
}