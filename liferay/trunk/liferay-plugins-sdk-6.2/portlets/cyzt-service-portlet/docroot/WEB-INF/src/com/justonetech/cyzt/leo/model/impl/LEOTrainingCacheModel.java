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

package com.justonetech.cyzt.leo.model.impl;

import com.justonetech.cyzt.leo.model.LEOTraining;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LEOTraining in entity cache.
 *
 * @author fanqi
 * @see LEOTraining
 * @generated
 */
public class LEOTrainingCacheModel implements CacheModel<LEOTraining>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{trainingId=");
		sb.append(trainingId);
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
		sb.append(", certificateId=");
		sb.append(certificateId);
		sb.append(", pxsj=");
		sb.append(pxsj);
		sb.append(", xcjysj=");
		sb.append(xcjysj);
		sb.append(", pxnr=");
		sb.append(pxnr);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LEOTraining toEntityModel() {
		LEOTrainingImpl leoTrainingImpl = new LEOTrainingImpl();

		leoTrainingImpl.setTrainingId(trainingId);
		leoTrainingImpl.setGroupId(groupId);
		leoTrainingImpl.setCompanyId(companyId);
		leoTrainingImpl.setUserId(userId);

		if (userName == null) {
			leoTrainingImpl.setUserName(StringPool.BLANK);
		}
		else {
			leoTrainingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			leoTrainingImpl.setCreateDate(null);
		}
		else {
			leoTrainingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leoTrainingImpl.setModifiedDate(null);
		}
		else {
			leoTrainingImpl.setModifiedDate(new Date(modifiedDate));
		}

		leoTrainingImpl.setCertificateId(certificateId);

		if (pxsj == Long.MIN_VALUE) {
			leoTrainingImpl.setPxsj(null);
		}
		else {
			leoTrainingImpl.setPxsj(new Date(pxsj));
		}

		if (xcjysj == Long.MIN_VALUE) {
			leoTrainingImpl.setXcjysj(null);
		}
		else {
			leoTrainingImpl.setXcjysj(new Date(xcjysj));
		}

		if (pxnr == null) {
			leoTrainingImpl.setPxnr(StringPool.BLANK);
		}
		else {
			leoTrainingImpl.setPxnr(pxnr);
		}

		leoTrainingImpl.resetOriginalValues();

		return leoTrainingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		trainingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		certificateId = objectInput.readLong();
		pxsj = objectInput.readLong();
		xcjysj = objectInput.readLong();
		pxnr = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(trainingId);
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
		objectOutput.writeLong(certificateId);
		objectOutput.writeLong(pxsj);
		objectOutput.writeLong(xcjysj);

		if (pxnr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pxnr);
		}
	}

	public long trainingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long certificateId;
	public long pxsj;
	public long xcjysj;
	public String pxnr;
}