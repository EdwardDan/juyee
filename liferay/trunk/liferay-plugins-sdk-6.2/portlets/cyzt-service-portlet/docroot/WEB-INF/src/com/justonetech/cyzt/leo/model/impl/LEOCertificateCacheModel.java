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

import com.justonetech.cyzt.leo.model.LEOCertificate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LEOCertificate in entity cache.
 *
 * @author fanqi
 * @see LEOCertificate
 * @generated
 */
public class LEOCertificateCacheModel implements CacheModel<LEOCertificate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{certificateId=");
		sb.append(certificateId);
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
		sb.append(", xm=");
		sb.append(xm);
		sb.append(", zjbh=");
		sb.append(zjbh);
		sb.append(", zylx=");
		sb.append(zylx);
		sb.append(", yxq=");
		sb.append(yxq);
		sb.append(", fzrq=");
		sb.append(fzrq);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LEOCertificate toEntityModel() {
		LEOCertificateImpl leoCertificateImpl = new LEOCertificateImpl();

		leoCertificateImpl.setCertificateId(certificateId);
		leoCertificateImpl.setGroupId(groupId);
		leoCertificateImpl.setCompanyId(companyId);
		leoCertificateImpl.setUserId(userId);

		if (userName == null) {
			leoCertificateImpl.setUserName(StringPool.BLANK);
		}
		else {
			leoCertificateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			leoCertificateImpl.setCreateDate(null);
		}
		else {
			leoCertificateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			leoCertificateImpl.setModifiedDate(null);
		}
		else {
			leoCertificateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (xm == null) {
			leoCertificateImpl.setXm(StringPool.BLANK);
		}
		else {
			leoCertificateImpl.setXm(xm);
		}

		if (zjbh == null) {
			leoCertificateImpl.setZjbh(StringPool.BLANK);
		}
		else {
			leoCertificateImpl.setZjbh(zjbh);
		}

		if (zylx == null) {
			leoCertificateImpl.setZylx(StringPool.BLANK);
		}
		else {
			leoCertificateImpl.setZylx(zylx);
		}

		if (yxq == Long.MIN_VALUE) {
			leoCertificateImpl.setYxq(null);
		}
		else {
			leoCertificateImpl.setYxq(new Date(yxq));
		}

		if (fzrq == Long.MIN_VALUE) {
			leoCertificateImpl.setFzrq(null);
		}
		else {
			leoCertificateImpl.setFzrq(new Date(fzrq));
		}

		leoCertificateImpl.resetOriginalValues();

		return leoCertificateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		certificateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		xm = objectInput.readUTF();
		zjbh = objectInput.readUTF();
		zylx = objectInput.readUTF();
		yxq = objectInput.readLong();
		fzrq = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(certificateId);
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

		if (xm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xm);
		}

		if (zjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjbh);
		}

		if (zylx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zylx);
		}

		objectOutput.writeLong(yxq);
		objectOutput.writeLong(fzrq);
	}

	public long certificateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String xm;
	public String zjbh;
	public String zylx;
	public long yxq;
	public long fzrq;
}