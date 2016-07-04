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

import com.justonetech.oa.model.LeaderWork;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LeaderWork in entity cache.
 *
 * @author justonetech
 * @see LeaderWork
 * @generated
 */
public class LeaderWorkCacheModel implements CacheModel<LeaderWork>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", workDate=");
		sb.append(workDate);
		sb.append(", amOrPm=");
		sb.append(amOrPm);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", modifiedTime=");
		sb.append(modifiedTime);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LeaderWork toEntityModel() {
		LeaderWorkImpl leaderWorkImpl = new LeaderWorkImpl();

		leaderWorkImpl.setUserId(userId);

		if (workDate == Long.MIN_VALUE) {
			leaderWorkImpl.setWorkDate(null);
		}
		else {
			leaderWorkImpl.setWorkDate(new Date(workDate));
		}

		leaderWorkImpl.setAmOrPm(amOrPm);

		if (userName == null) {
			leaderWorkImpl.setUserName(StringPool.BLANK);
		}
		else {
			leaderWorkImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			leaderWorkImpl.setCreateTime(null);
		}
		else {
			leaderWorkImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			leaderWorkImpl.setModifiedTime(null);
		}
		else {
			leaderWorkImpl.setModifiedTime(new Date(modifiedTime));
		}

		if (content == null) {
			leaderWorkImpl.setContent(StringPool.BLANK);
		}
		else {
			leaderWorkImpl.setContent(content);
		}

		leaderWorkImpl.resetOriginalValues();

		return leaderWorkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		workDate = objectInput.readLong();
		amOrPm = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(workDate);
		objectOutput.writeLong(amOrPm);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createTime);
		objectOutput.writeLong(modifiedTime);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long userId;
	public long workDate;
	public long amOrPm;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public String content;
}