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

package com.justonetech.proj.model.impl;

import com.justonetech.proj.model.Bidding;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Bidding in entity cache.
 *
 * @author fanqi
 * @see Bidding
 * @generated
 */
public class BiddingCacheModel implements CacheModel<Bidding>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{biddingId=");
		sb.append(biddingId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", bidCode=");
		sb.append(bidCode);
		sb.append(", sortNo=");
		sb.append(sortNo);
		sb.append(", bidName=");
		sb.append(bidName);
		sb.append(", bidCategoryCode=");
		sb.append(bidCategoryCode);
		sb.append(", buildMileage=");
		sb.append(buildMileage);
		sb.append(", involveCounty=");
		sb.append(involveCounty);
		sb.append(", projLinkman=");
		sb.append(projLinkman);
		sb.append(", linkTel=");
		sb.append(linkTel);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bidding toEntityModel() {
		BiddingImpl biddingImpl = new BiddingImpl();

		biddingImpl.setBiddingId(biddingId);
		biddingImpl.setUserId(userId);

		if (userName == null) {
			biddingImpl.setUserName(StringPool.BLANK);
		}
		else {
			biddingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			biddingImpl.setCreateDate(null);
		}
		else {
			biddingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			biddingImpl.setModifiedDate(null);
		}
		else {
			biddingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (bidCode == null) {
			biddingImpl.setBidCode(StringPool.BLANK);
		}
		else {
			biddingImpl.setBidCode(bidCode);
		}

		biddingImpl.setSortNo(sortNo);

		if (bidName == null) {
			biddingImpl.setBidName(StringPool.BLANK);
		}
		else {
			biddingImpl.setBidName(bidName);
		}

		if (bidCategoryCode == null) {
			biddingImpl.setBidCategoryCode(StringPool.BLANK);
		}
		else {
			biddingImpl.setBidCategoryCode(bidCategoryCode);
		}

		if (buildMileage == null) {
			biddingImpl.setBuildMileage(StringPool.BLANK);
		}
		else {
			biddingImpl.setBuildMileage(buildMileage);
		}

		if (involveCounty == null) {
			biddingImpl.setInvolveCounty(StringPool.BLANK);
		}
		else {
			biddingImpl.setInvolveCounty(involveCounty);
		}

		if (projLinkman == null) {
			biddingImpl.setProjLinkman(StringPool.BLANK);
		}
		else {
			biddingImpl.setProjLinkman(projLinkman);
		}

		if (linkTel == null) {
			biddingImpl.setLinkTel(StringPool.BLANK);
		}
		else {
			biddingImpl.setLinkTel(linkTel);
		}

		if (startDate == Long.MIN_VALUE) {
			biddingImpl.setStartDate(null);
		}
		else {
			biddingImpl.setStartDate(new Date(startDate));
		}

		biddingImpl.setProjectId(projectId);

		biddingImpl.resetOriginalValues();

		return biddingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		biddingId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		bidCode = objectInput.readUTF();
		sortNo = objectInput.readInt();
		bidName = objectInput.readUTF();
		bidCategoryCode = objectInput.readUTF();
		buildMileage = objectInput.readUTF();
		involveCounty = objectInput.readUTF();
		projLinkman = objectInput.readUTF();
		linkTel = objectInput.readUTF();
		startDate = objectInput.readLong();
		projectId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(biddingId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (bidCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bidCode);
		}

		objectOutput.writeInt(sortNo);

		if (bidName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bidName);
		}

		if (bidCategoryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bidCategoryCode);
		}

		if (buildMileage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(buildMileage);
		}

		if (involveCounty == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(involveCounty);
		}

		if (projLinkman == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projLinkman);
		}

		if (linkTel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkTel);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(projectId);
	}

	public long biddingId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String bidCode;
	public int sortNo;
	public String bidName;
	public String bidCategoryCode;
	public String buildMileage;
	public String involveCounty;
	public String projLinkman;
	public String linkTel;
	public long startDate;
	public long projectId;
}