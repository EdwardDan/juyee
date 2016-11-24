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

import com.justonetech.expert.model.Zysqlb;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Zysqlb in entity cache.
 *
 * @author fanqi
 * @see Zysqlb
 * @generated
 */
public class ZysqlbCacheModel implements CacheModel<Zysqlb>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{zysqlbId=");
		sb.append(zysqlbId);
		sb.append(", sx=");
		sb.append(sx);
		sb.append(", zy=");
		sb.append(zy);
		sb.append(", zt=");
		sb.append(zt);
		sb.append(", shyj=");
		sb.append(shyj);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Zysqlb toEntityModel() {
		ZysqlbImpl zysqlbImpl = new ZysqlbImpl();

		zysqlbImpl.setZysqlbId(zysqlbId);

		if (sx == null) {
			zysqlbImpl.setSx(StringPool.BLANK);
		}
		else {
			zysqlbImpl.setSx(sx);
		}

		if (zy == null) {
			zysqlbImpl.setZy(StringPool.BLANK);
		}
		else {
			zysqlbImpl.setZy(zy);
		}

		if (zt == null) {
			zysqlbImpl.setZt(StringPool.BLANK);
		}
		else {
			zysqlbImpl.setZt(zt);
		}

		if (shyj == null) {
			zysqlbImpl.setShyj(StringPool.BLANK);
		}
		else {
			zysqlbImpl.setShyj(shyj);
		}

		zysqlbImpl.resetOriginalValues();

		return zysqlbImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		zysqlbId = objectInput.readLong();
		sx = objectInput.readUTF();
		zy = objectInput.readUTF();
		zt = objectInput.readUTF();
		shyj = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(zysqlbId);

		if (sx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sx);
		}

		if (zy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zy);
		}

		if (zt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zt);
		}

		if (shyj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shyj);
		}
	}

	public long zysqlbId;
	public String sx;
	public String zy;
	public String zt;
	public String shyj;
}