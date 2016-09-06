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

import com.justonetech.cp.permit.model.ParticipationUnit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ParticipationUnit in entity cache.
 *
 * @author fanqi
 * @see ParticipationUnit
 * @generated
 */
public class ParticipationUnitCacheModel implements CacheModel<ParticipationUnit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{unitId=");
		sb.append(unitId);
		sb.append(", permitId=");
		sb.append(permitId);
		sb.append(", dwlx=");
		sb.append(dwlx);
		sb.append(", dwmc=");
		sb.append(dwmc);
		sb.append(", xmfzr=");
		sb.append(xmfzr);
		sb.append(", dhhm=");
		sb.append(dhhm);
		sb.append(", zjlx=");
		sb.append(zjlx);
		sb.append(", zjh=");
		sb.append(zjh);
		sb.append(", sfyssj=");
		sb.append(sfyssj);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ParticipationUnit toEntityModel() {
		ParticipationUnitImpl participationUnitImpl = new ParticipationUnitImpl();

		participationUnitImpl.setUnitId(unitId);
		participationUnitImpl.setPermitId(permitId);

		if (dwlx == null) {
			participationUnitImpl.setDwlx(StringPool.BLANK);
		}
		else {
			participationUnitImpl.setDwlx(dwlx);
		}

		if (dwmc == null) {
			participationUnitImpl.setDwmc(StringPool.BLANK);
		}
		else {
			participationUnitImpl.setDwmc(dwmc);
		}

		if (xmfzr == null) {
			participationUnitImpl.setXmfzr(StringPool.BLANK);
		}
		else {
			participationUnitImpl.setXmfzr(xmfzr);
		}

		if (dhhm == null) {
			participationUnitImpl.setDhhm(StringPool.BLANK);
		}
		else {
			participationUnitImpl.setDhhm(dhhm);
		}

		if (zjlx == null) {
			participationUnitImpl.setZjlx(StringPool.BLANK);
		}
		else {
			participationUnitImpl.setZjlx(zjlx);
		}

		if (zjh == null) {
			participationUnitImpl.setZjh(StringPool.BLANK);
		}
		else {
			participationUnitImpl.setZjh(zjh);
		}

		participationUnitImpl.setSfyssj(sfyssj);

		participationUnitImpl.resetOriginalValues();

		return participationUnitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		unitId = objectInput.readLong();
		permitId = objectInput.readLong();
		dwlx = objectInput.readUTF();
		dwmc = objectInput.readUTF();
		xmfzr = objectInput.readUTF();
		dhhm = objectInput.readUTF();
		zjlx = objectInput.readUTF();
		zjh = objectInput.readUTF();
		sfyssj = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(unitId);
		objectOutput.writeLong(permitId);

		if (dwlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dwlx);
		}

		if (dwmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dwmc);
		}

		if (xmfzr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfzr);
		}

		if (dhhm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dhhm);
		}

		if (zjlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlx);
		}

		if (zjh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjh);
		}

		objectOutput.writeBoolean(sfyssj);
	}

	public long unitId;
	public long permitId;
	public String dwlx;
	public String dwmc;
	public String xmfzr;
	public String dhhm;
	public String zjlx;
	public String zjh;
	public boolean sfyssj;
}