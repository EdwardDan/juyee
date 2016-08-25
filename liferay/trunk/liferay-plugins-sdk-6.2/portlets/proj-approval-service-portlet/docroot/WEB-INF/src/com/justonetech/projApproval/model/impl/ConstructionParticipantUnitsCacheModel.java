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

import com.justonetech.projApproval.model.ConstructionParticipantUnits;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ConstructionParticipantUnits in entity cache.
 *
 * @author justonetech
 * @see ConstructionParticipantUnits
 * @generated
 */
public class ConstructionParticipantUnitsCacheModel implements CacheModel<ConstructionParticipantUnits>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{constructionParticipantUnitsId=");
		sb.append(constructionParticipantUnitsId);
		sb.append(", sortNo=");
		sb.append(sortNo);
		sb.append(", contractInfoSubmitNum=");
		sb.append(contractInfoSubmitNum);
		sb.append(", unitType=");
		sb.append(unitType);
		sb.append(", unitName=");
		sb.append(unitName);
		sb.append(", projectLeader=");
		sb.append(projectLeader);
		sb.append(", telephoneNum=");
		sb.append(telephoneNum);
		sb.append(", constructionPermitId=");
		sb.append(constructionPermitId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConstructionParticipantUnits toEntityModel() {
		ConstructionParticipantUnitsImpl constructionParticipantUnitsImpl = new ConstructionParticipantUnitsImpl();

		constructionParticipantUnitsImpl.setConstructionParticipantUnitsId(constructionParticipantUnitsId);
		constructionParticipantUnitsImpl.setSortNo(sortNo);

		if (contractInfoSubmitNum == null) {
			constructionParticipantUnitsImpl.setContractInfoSubmitNum(StringPool.BLANK);
		}
		else {
			constructionParticipantUnitsImpl.setContractInfoSubmitNum(contractInfoSubmitNum);
		}

		constructionParticipantUnitsImpl.setUnitType(unitType);

		if (unitName == null) {
			constructionParticipantUnitsImpl.setUnitName(StringPool.BLANK);
		}
		else {
			constructionParticipantUnitsImpl.setUnitName(unitName);
		}

		if (projectLeader == null) {
			constructionParticipantUnitsImpl.setProjectLeader(StringPool.BLANK);
		}
		else {
			constructionParticipantUnitsImpl.setProjectLeader(projectLeader);
		}

		if (telephoneNum == null) {
			constructionParticipantUnitsImpl.setTelephoneNum(StringPool.BLANK);
		}
		else {
			constructionParticipantUnitsImpl.setTelephoneNum(telephoneNum);
		}

		constructionParticipantUnitsImpl.setConstructionPermitId(constructionPermitId);

		constructionParticipantUnitsImpl.resetOriginalValues();

		return constructionParticipantUnitsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		constructionParticipantUnitsId = objectInput.readLong();
		sortNo = objectInput.readInt();
		contractInfoSubmitNum = objectInput.readUTF();
		unitType = objectInput.readLong();
		unitName = objectInput.readUTF();
		projectLeader = objectInput.readUTF();
		telephoneNum = objectInput.readUTF();
		constructionPermitId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(constructionParticipantUnitsId);
		objectOutput.writeInt(sortNo);

		if (contractInfoSubmitNum == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractInfoSubmitNum);
		}

		objectOutput.writeLong(unitType);

		if (unitName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unitName);
		}

		if (projectLeader == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectLeader);
		}

		if (telephoneNum == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telephoneNum);
		}

		objectOutput.writeLong(constructionPermitId);
	}

	public long constructionParticipantUnitsId;
	public int sortNo;
	public String contractInfoSubmitNum;
	public long unitType;
	public String unitName;
	public String projectLeader;
	public String telephoneNum;
	public long constructionPermitId;
}