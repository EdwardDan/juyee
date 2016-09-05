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

package com.justonetech.cp.permit.model.impl;

import com.justonetech.cp.permit.model.Permit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Permit in entity cache.
 *
 * @author fanqi
 * @see Permit
 * @generated
 */
public class PermitCacheModel implements CacheModel<Permit>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{permitId=");
		sb.append(permitId);
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
		sb.append(", htxxbsbh=");
		sb.append(htxxbsbh);
		sb.append(", sqbz=");
		sb.append(sqbz);
		sb.append(", sqzt=");
		sb.append(sqzt);
		sb.append(", bdh=");
		sb.append(bdh);
		sb.append(", ywbh=");
		sb.append(ywbh);
		sb.append(", sgxkzbh=");
		sb.append(sgxkzbh);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Permit toEntityModel() {
		PermitImpl permitImpl = new PermitImpl();

		permitImpl.setPermitId(permitId);
		permitImpl.setGroupId(groupId);
		permitImpl.setCompanyId(companyId);
		permitImpl.setUserId(userId);

		if (userName == null) {
			permitImpl.setUserName(StringPool.BLANK);
		}
		else {
			permitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			permitImpl.setCreateDate(null);
		}
		else {
			permitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			permitImpl.setModifiedDate(null);
		}
		else {
			permitImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (zzjgdm == null) {
			permitImpl.setZzjgdm(StringPool.BLANK);
		}
		else {
			permitImpl.setZzjgdm(zzjgdm);
		}

		if (bjbh == null) {
			permitImpl.setBjbh(StringPool.BLANK);
		}
		else {
			permitImpl.setBjbh(bjbh);
		}

		if (htxxbsbh == null) {
			permitImpl.setHtxxbsbh(StringPool.BLANK);
		}
		else {
			permitImpl.setHtxxbsbh(htxxbsbh);
		}

		permitImpl.setSqbz(sqbz);

		if (sqzt == null) {
			permitImpl.setSqzt(StringPool.BLANK);
		}
		else {
			permitImpl.setSqzt(sqzt);
		}

		if (bdh == null) {
			permitImpl.setBdh(StringPool.BLANK);
		}
		else {
			permitImpl.setBdh(bdh);
		}

		if (ywbh == null) {
			permitImpl.setYwbh(StringPool.BLANK);
		}
		else {
			permitImpl.setYwbh(ywbh);
		}

		if (sgxkzbh == null) {
			permitImpl.setSgxkzbh(StringPool.BLANK);
		}
		else {
			permitImpl.setSgxkzbh(sgxkzbh);
		}

		permitImpl.resetOriginalValues();

		return permitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		permitId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		zzjgdm = objectInput.readUTF();
		bjbh = objectInput.readUTF();
		htxxbsbh = objectInput.readUTF();
		sqbz = objectInput.readInt();
		sqzt = objectInput.readUTF();
		bdh = objectInput.readUTF();
		ywbh = objectInput.readUTF();
		sgxkzbh = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(permitId);
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

		if (htxxbsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htxxbsbh);
		}

		objectOutput.writeInt(sqbz);

		if (sqzt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sqzt);
		}

		if (bdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bdh);
		}

		if (ywbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywbh);
		}

		if (sgxkzbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgxkzbh);
		}
	}

	public long permitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String zzjgdm;
	public String bjbh;
	public String htxxbsbh;
	public int sqbz;
	public String sqzt;
	public String bdh;
	public String ywbh;
	public String sgxkzbh;
}