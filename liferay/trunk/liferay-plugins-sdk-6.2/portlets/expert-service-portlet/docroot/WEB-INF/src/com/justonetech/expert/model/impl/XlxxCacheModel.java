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

import com.justonetech.expert.model.Xlxx;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Xlxx in entity cache.
 *
 * @author fanqi
 * @see Xlxx
 * @generated
 */
public class XlxxCacheModel implements CacheModel<Xlxx>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{xlxxId=");
		sb.append(xlxxId);
		sb.append(", expertId=");
		sb.append(expertId);
		sb.append(", byyx=");
		sb.append(byyx);
		sb.append(", sxzy=");
		sb.append(sxzy);
		sb.append(", xlhxw=");
		sb.append(xlhxw);
		sb.append(", zxsj=");
		sb.append(zxsj);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Xlxx toEntityModel() {
		XlxxImpl xlxxImpl = new XlxxImpl();

		xlxxImpl.setXlxxId(xlxxId);

		if (expertId == null) {
			xlxxImpl.setExpertId(StringPool.BLANK);
		}
		else {
			xlxxImpl.setExpertId(expertId);
		}

		if (byyx == null) {
			xlxxImpl.setByyx(StringPool.BLANK);
		}
		else {
			xlxxImpl.setByyx(byyx);
		}

		if (sxzy == null) {
			xlxxImpl.setSxzy(StringPool.BLANK);
		}
		else {
			xlxxImpl.setSxzy(sxzy);
		}

		if (xlhxw == null) {
			xlxxImpl.setXlhxw(StringPool.BLANK);
		}
		else {
			xlxxImpl.setXlhxw(xlhxw);
		}

		if (zxsj == null) {
			xlxxImpl.setZxsj(StringPool.BLANK);
		}
		else {
			xlxxImpl.setZxsj(zxsj);
		}

		xlxxImpl.resetOriginalValues();

		return xlxxImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		xlxxId = objectInput.readLong();
		expertId = objectInput.readUTF();
		byyx = objectInput.readUTF();
		sxzy = objectInput.readUTF();
		xlhxw = objectInput.readUTF();
		zxsj = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(xlxxId);

		if (expertId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expertId);
		}

		if (byyx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(byyx);
		}

		if (sxzy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sxzy);
		}

		if (xlhxw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xlhxw);
		}

		if (zxsj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zxsj);
		}
	}

	public long xlxxId;
	public String expertId;
	public String byyx;
	public String sxzy;
	public String xlhxw;
	public String zxsj;
}