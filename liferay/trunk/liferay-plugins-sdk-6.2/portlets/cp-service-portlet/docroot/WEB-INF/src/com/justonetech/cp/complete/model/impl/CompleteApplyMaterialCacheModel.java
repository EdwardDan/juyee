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

package com.justonetech.cp.complete.model.impl;

import com.justonetech.cp.complete.model.CompleteApplyMaterial;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CompleteApplyMaterial in entity cache.
 *
 * @author fanqi
 * @see CompleteApplyMaterial
 * @generated
 */
public class CompleteApplyMaterialCacheModel implements CacheModel<CompleteApplyMaterial>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{materialId=");
		sb.append(materialId);
		sb.append(", completeId=");
		sb.append(completeId);
		sb.append(", xh=");
		sb.append(xh);
		sb.append(", clmc=");
		sb.append(clmc);
		sb.append(", fileEntryIds=");
		sb.append(fileEntryIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompleteApplyMaterial toEntityModel() {
		CompleteApplyMaterialImpl completeApplyMaterialImpl = new CompleteApplyMaterialImpl();

		completeApplyMaterialImpl.setMaterialId(materialId);
		completeApplyMaterialImpl.setCompleteId(completeId);

		if (xh == null) {
			completeApplyMaterialImpl.setXh(StringPool.BLANK);
		}
		else {
			completeApplyMaterialImpl.setXh(xh);
		}

		if (clmc == null) {
			completeApplyMaterialImpl.setClmc(StringPool.BLANK);
		}
		else {
			completeApplyMaterialImpl.setClmc(clmc);
		}

		if (fileEntryIds == null) {
			completeApplyMaterialImpl.setFileEntryIds(StringPool.BLANK);
		}
		else {
			completeApplyMaterialImpl.setFileEntryIds(fileEntryIds);
		}

		completeApplyMaterialImpl.resetOriginalValues();

		return completeApplyMaterialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		materialId = objectInput.readLong();
		completeId = objectInput.readLong();
		xh = objectInput.readUTF();
		clmc = objectInput.readUTF();
		fileEntryIds = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(materialId);
		objectOutput.writeLong(completeId);

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

		if (fileEntryIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryIds);
		}
	}

	public long materialId;
	public long completeId;
	public String xh;
	public String clmc;
	public String fileEntryIds;
}