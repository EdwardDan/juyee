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

package com.justonetech.projApproval.model.impl;

import com.justonetech.projApproval.model.ConstructionUnitProject;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ConstructionUnitProject in entity cache.
 *
 * @author justonetech
 * @see ConstructionUnitProject
 * @generated
 */
public class ConstructionUnitProjectCacheModel implements CacheModel<ConstructionUnitProject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{constructionUnitProjectId=");
		sb.append(constructionUnitProjectId);
		sb.append(", sortNo=");
		sb.append(sortNo);
		sb.append(", unitProjectNum=");
		sb.append(unitProjectNum);
		sb.append(", unitProjectName=");
		sb.append(unitProjectName);
		sb.append(", constructionContent=");
		sb.append(constructionContent);
		sb.append(", constructionPermitId=");
		sb.append(constructionPermitId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConstructionUnitProject toEntityModel() {
		ConstructionUnitProjectImpl constructionUnitProjectImpl = new ConstructionUnitProjectImpl();

		constructionUnitProjectImpl.setConstructionUnitProjectId(constructionUnitProjectId);
		constructionUnitProjectImpl.setSortNo(sortNo);

		if (unitProjectNum == null) {
			constructionUnitProjectImpl.setUnitProjectNum(StringPool.BLANK);
		}
		else {
			constructionUnitProjectImpl.setUnitProjectNum(unitProjectNum);
		}

		if (unitProjectName == null) {
			constructionUnitProjectImpl.setUnitProjectName(StringPool.BLANK);
		}
		else {
			constructionUnitProjectImpl.setUnitProjectName(unitProjectName);
		}

		if (constructionContent == null) {
			constructionUnitProjectImpl.setConstructionContent(StringPool.BLANK);
		}
		else {
			constructionUnitProjectImpl.setConstructionContent(constructionContent);
		}

		constructionUnitProjectImpl.setConstructionPermitId(constructionPermitId);

		constructionUnitProjectImpl.resetOriginalValues();

		return constructionUnitProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		constructionUnitProjectId = objectInput.readLong();
		sortNo = objectInput.readInt();
		unitProjectNum = objectInput.readUTF();
		unitProjectName = objectInput.readUTF();
		constructionContent = objectInput.readUTF();
		constructionPermitId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(constructionUnitProjectId);
		objectOutput.writeInt(sortNo);

		if (unitProjectNum == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unitProjectNum);
		}

		if (unitProjectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unitProjectName);
		}

		if (constructionContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(constructionContent);
		}

		objectOutput.writeLong(constructionPermitId);
	}

	public long constructionUnitProjectId;
	public int sortNo;
	public String unitProjectNum;
	public String unitProjectName;
	public String constructionContent;
	public long constructionPermitId;
}