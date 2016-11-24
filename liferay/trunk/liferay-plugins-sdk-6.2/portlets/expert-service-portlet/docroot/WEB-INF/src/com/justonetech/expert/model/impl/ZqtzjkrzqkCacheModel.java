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

package com.justonetech.expert.model.impl;

import com.justonetech.expert.model.Zqtzjkrzqk;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Zqtzjkrzqk in entity cache.
 *
 * @author fanqi
 * @see Zqtzjkrzqk
 * @generated
 */
public class ZqtzjkrzqkCacheModel implements CacheModel<Zqtzjkrzqk>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{zqtzjkrzqkId=");
		sb.append(zqtzjkrzqkId);
		sb.append(", expertId=");
		sb.append(expertId);
		sb.append(", zjkxtlsdw=");
		sb.append(zjkxtlsdw);
		sb.append(", sqzy=");
		sb.append(sqzy);
		sb.append(", pzrq=");
		sb.append(pzrq);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Zqtzjkrzqk toEntityModel() {
		ZqtzjkrzqkImpl zqtzjkrzqkImpl = new ZqtzjkrzqkImpl();

		zqtzjkrzqkImpl.setZqtzjkrzqkId(zqtzjkrzqkId);
		zqtzjkrzqkImpl.setExpertId(expertId);

		if (zjkxtlsdw == null) {
			zqtzjkrzqkImpl.setZjkxtlsdw(StringPool.BLANK);
		}
		else {
			zqtzjkrzqkImpl.setZjkxtlsdw(zjkxtlsdw);
		}

		if (sqzy == null) {
			zqtzjkrzqkImpl.setSqzy(StringPool.BLANK);
		}
		else {
			zqtzjkrzqkImpl.setSqzy(sqzy);
		}

		if (pzrq == Long.MIN_VALUE) {
			zqtzjkrzqkImpl.setPzrq(null);
		}
		else {
			zqtzjkrzqkImpl.setPzrq(new Date(pzrq));
		}

		zqtzjkrzqkImpl.resetOriginalValues();

		return zqtzjkrzqkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		zqtzjkrzqkId = objectInput.readLong();
		expertId = objectInput.readLong();
		zjkxtlsdw = objectInput.readUTF();
		sqzy = objectInput.readUTF();
		pzrq = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(zqtzjkrzqkId);
		objectOutput.writeLong(expertId);

		if (zjkxtlsdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjkxtlsdw);
		}

		if (sqzy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sqzy);
		}

		objectOutput.writeLong(pzrq);
	}

	public long zqtzjkrzqkId;
	public long expertId;
	public String zjkxtlsdw;
	public String sqzy;
	public long pzrq;
}