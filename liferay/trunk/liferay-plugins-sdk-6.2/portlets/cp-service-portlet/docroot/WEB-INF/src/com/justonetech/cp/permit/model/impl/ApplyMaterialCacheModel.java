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

import com.justonetech.cp.permit.model.ApplyMaterial;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ApplyMaterial in entity cache.
 *
 * @author fanqi
 * @see ApplyMaterial
 * @generated
 */
public class ApplyMaterialCacheModel implements CacheModel<ApplyMaterial>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{materialId=");
		sb.append(materialId);
		sb.append(", permitId=");
		sb.append(permitId);
		sb.append(", xh=");
		sb.append(xh);
		sb.append(", clmc=");
		sb.append(clmc);
		sb.append(", yjfs=");
		sb.append(yjfs);
		sb.append(", sjfs=");
		sb.append(sjfs);
		sb.append(", fileEntryIds=");
		sb.append(fileEntryIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplyMaterial toEntityModel() {
		ApplyMaterialImpl applyMaterialImpl = new ApplyMaterialImpl();

		applyMaterialImpl.setMaterialId(materialId);
		applyMaterialImpl.setPermitId(permitId);

		if (xh == null) {
			applyMaterialImpl.setXh(StringPool.BLANK);
		}
		else {
			applyMaterialImpl.setXh(xh);
		}

		if (clmc == null) {
			applyMaterialImpl.setClmc(StringPool.BLANK);
		}
		else {
			applyMaterialImpl.setClmc(clmc);
		}

		applyMaterialImpl.setYjfs(yjfs);
		applyMaterialImpl.setSjfs(sjfs);

		if (fileEntryIds == null) {
			applyMaterialImpl.setFileEntryIds(StringPool.BLANK);
		}
		else {
			applyMaterialImpl.setFileEntryIds(fileEntryIds);
		}

		applyMaterialImpl.resetOriginalValues();

		return applyMaterialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		materialId = objectInput.readLong();
		permitId = objectInput.readLong();
		xh = objectInput.readUTF();
		clmc = objectInput.readUTF();
		yjfs = objectInput.readInt();
		sjfs = objectInput.readInt();
		fileEntryIds = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(materialId);
		objectOutput.writeLong(permitId);

		if (xh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xh);
		}

		if (clmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clmc);
		}

		objectOutput.writeInt(yjfs);
		objectOutput.writeInt(sjfs);

		if (fileEntryIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryIds);
		}
	}

	public long materialId;
	public long permitId;
	public String xh;
	public String clmc;
	public int yjfs;
	public int sjfs;
	public String fileEntryIds;
}