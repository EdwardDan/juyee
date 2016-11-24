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

import com.justonetech.expert.model.Zzjl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Zzjl in entity cache.
 *
 * @author fanqi
 * @see Zzjl
 * @generated
 */
public class ZzjlCacheModel implements CacheModel<Zzjl>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{zzjlId=");
		sb.append(zzjlId);
		sb.append(", expertId=");
		sb.append(expertId);
		sb.append(", gzdw=");
		sb.append(gzdw);
		sb.append(", qzny=");
		sb.append(qzny);
		sb.append(", cszyzygz=");
		sb.append(cszyzygz);
		sb.append(", zw=");
		sb.append(zw);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Zzjl toEntityModel() {
		ZzjlImpl zzjlImpl = new ZzjlImpl();

		zzjlImpl.setZzjlId(zzjlId);
		zzjlImpl.setExpertId(expertId);

		if (gzdw == null) {
			zzjlImpl.setGzdw(StringPool.BLANK);
		}
		else {
			zzjlImpl.setGzdw(gzdw);
		}

		if (qzny == null) {
			zzjlImpl.setQzny(StringPool.BLANK);
		}
		else {
			zzjlImpl.setQzny(qzny);
		}

		if (cszyzygz == null) {
			zzjlImpl.setCszyzygz(StringPool.BLANK);
		}
		else {
			zzjlImpl.setCszyzygz(cszyzygz);
		}

		if (zw == null) {
			zzjlImpl.setZw(StringPool.BLANK);
		}
		else {
			zzjlImpl.setZw(zw);
		}

		zzjlImpl.resetOriginalValues();

		return zzjlImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		zzjlId = objectInput.readLong();
		expertId = objectInput.readLong();
		gzdw = objectInput.readUTF();
		qzny = objectInput.readUTF();
		cszyzygz = objectInput.readUTF();
		zw = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(zzjlId);
		objectOutput.writeLong(expertId);

		if (gzdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gzdw);
		}

		if (qzny == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qzny);
		}

		if (cszyzygz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cszyzygz);
		}

		if (zw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zw);
		}
	}

	public long zzjlId;
	public long expertId;
	public String gzdw;
	public String qzny;
	public String cszyzygz;
	public String zw;
}