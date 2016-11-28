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

import com.justonetech.expert.model.Gzjl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Gzjl in entity cache.
 *
 * @author fanqi
 * @see Gzjl
 * @generated
 */
public class GzjlCacheModel implements CacheModel<Gzjl>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{GzjlId=");
		sb.append(GzjlId);
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
	public Gzjl toEntityModel() {
		GzjlImpl gzjlImpl = new GzjlImpl();

		gzjlImpl.setGzjlId(GzjlId);
		gzjlImpl.setExpertId(expertId);

		if (gzdw == null) {
			gzjlImpl.setGzdw(StringPool.BLANK);
		}
		else {
			gzjlImpl.setGzdw(gzdw);
		}

		if (qzny == null) {
			gzjlImpl.setQzny(StringPool.BLANK);
		}
		else {
			gzjlImpl.setQzny(qzny);
		}

		if (cszyzygz == null) {
			gzjlImpl.setCszyzygz(StringPool.BLANK);
		}
		else {
			gzjlImpl.setCszyzygz(cszyzygz);
		}

		if (zw == null) {
			gzjlImpl.setZw(StringPool.BLANK);
		}
		else {
			gzjlImpl.setZw(zw);
		}

		gzjlImpl.resetOriginalValues();

		return gzjlImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		GzjlId = objectInput.readLong();
		expertId = objectInput.readLong();
		gzdw = objectInput.readUTF();
		qzny = objectInput.readUTF();
		cszyzygz = objectInput.readUTF();
		zw = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(GzjlId);
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

	public long GzjlId;
	public long expertId;
	public String gzdw;
	public String qzny;
	public String cszyzygz;
	public String zw;
}