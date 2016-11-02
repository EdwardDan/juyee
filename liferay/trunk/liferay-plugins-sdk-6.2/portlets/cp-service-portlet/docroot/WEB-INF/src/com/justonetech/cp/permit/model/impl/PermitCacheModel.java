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

import com.justonetech.cp.permit.model.Permit;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Permit in entity cache.
 *
 * @author fanqi
 * @see Permit
 * @generated
 */
public class PermitCacheModel implements CacheModel<Permit>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

		sb.append("{permitId=");
		sb.append(permitId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", zzjgdm=");
		sb.append(zzjgdm);
		sb.append(", bjbh=");
		sb.append(bjbh);
		sb.append(", htxxbsbh=");
		sb.append(htxxbsbh);
		sb.append(", sqbz=");
		sb.append(sqbz);
		sb.append(", status=");
		sb.append(status);
		sb.append(", bdh=");
		sb.append(bdh);
		sb.append(", ywbh=");
		sb.append(ywbh);
		sb.append(", sgxkzbh=");
		sb.append(sgxkzbh);
		sb.append(", slbh=");
		sb.append(slbh);
		sb.append(", hjgsz=");
		sb.append(hjgsz);
		sb.append(", hjgsh=");
		sb.append(hjgsh);
		sb.append(", sqr=");
		sb.append(sqr);
		sb.append(", sqsx=");
		sb.append(sqsx);
		sb.append(", sqh=");
		sb.append(sqh);
		sb.append(", cltjr=");
		sb.append(cltjr);
		sb.append(", cltjrlxdh=");
		sb.append(cltjrlxdh);
		sb.append(", cltjrlxdz=");
		sb.append(cltjrlxdz);
		sb.append(", sjr=");
		sb.append(sjr);
		sb.append(", sjrlxdh=");
		sb.append(sjrlxdh);
		sb.append(", slyj=");
		sb.append(slyj);
		sb.append(", slsj=");
		sb.append(slsj);
		sb.append(", nsgnr=");
		sb.append(nsgnr);
		sb.append(", sgxkzFileEntryId=");
		sb.append(sgxkzFileEntryId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Permit toEntityModel() {
		PermitImpl permitImpl = new PermitImpl();

		permitImpl.setPermitId(permitId);
		permitImpl.setGroupId(groupId);
		permitImpl.setCompanyId(companyId);
		permitImpl.setUserId(userId);

		if (userName == null) {
			permitImpl.setUserName(StringPool.BLANK);
		}
		else {
			permitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			permitImpl.setCreateDate(null);
		}
		else {
			permitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			permitImpl.setModifiedDate(null);
		}
		else {
			permitImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (zzjgdm == null) {
			permitImpl.setZzjgdm(StringPool.BLANK);
		}
		else {
			permitImpl.setZzjgdm(zzjgdm);
		}

		if (bjbh == null) {
			permitImpl.setBjbh(StringPool.BLANK);
		}
		else {
			permitImpl.setBjbh(bjbh);
		}

		if (htxxbsbh == null) {
			permitImpl.setHtxxbsbh(StringPool.BLANK);
		}
		else {
			permitImpl.setHtxxbsbh(htxxbsbh);
		}

		permitImpl.setSqbz(sqbz);
		permitImpl.setStatus(status);

		if (bdh == null) {
			permitImpl.setBdh(StringPool.BLANK);
		}
		else {
			permitImpl.setBdh(bdh);
		}

		if (ywbh == null) {
			permitImpl.setYwbh(StringPool.BLANK);
		}
		else {
			permitImpl.setYwbh(ywbh);
		}

		if (sgxkzbh == null) {
			permitImpl.setSgxkzbh(StringPool.BLANK);
		}
		else {
			permitImpl.setSgxkzbh(sgxkzbh);
		}

		if (slbh == null) {
			permitImpl.setSlbh(StringPool.BLANK);
		}
		else {
			permitImpl.setSlbh(slbh);
		}

		permitImpl.setHjgsz(hjgsz);
		permitImpl.setHjgsh(hjgsh);

		if (sqr == null) {
			permitImpl.setSqr(StringPool.BLANK);
		}
		else {
			permitImpl.setSqr(sqr);
		}

		if (sqsx == null) {
			permitImpl.setSqsx(StringPool.BLANK);
		}
		else {
			permitImpl.setSqsx(sqsx);
		}

		if (sqh == null) {
			permitImpl.setSqh(StringPool.BLANK);
		}
		else {
			permitImpl.setSqh(sqh);
		}

		if (cltjr == null) {
			permitImpl.setCltjr(StringPool.BLANK);
		}
		else {
			permitImpl.setCltjr(cltjr);
		}

		if (cltjrlxdh == null) {
			permitImpl.setCltjrlxdh(StringPool.BLANK);
		}
		else {
			permitImpl.setCltjrlxdh(cltjrlxdh);
		}

		if (cltjrlxdz == null) {
			permitImpl.setCltjrlxdz(StringPool.BLANK);
		}
		else {
			permitImpl.setCltjrlxdz(cltjrlxdz);
		}

		if (sjr == null) {
			permitImpl.setSjr(StringPool.BLANK);
		}
		else {
			permitImpl.setSjr(sjr);
		}

		if (sjrlxdh == null) {
			permitImpl.setSjrlxdh(StringPool.BLANK);
		}
		else {
			permitImpl.setSjrlxdh(sjrlxdh);
		}

		if (slyj == null) {
			permitImpl.setSlyj(StringPool.BLANK);
		}
		else {
			permitImpl.setSlyj(slyj);
		}

		if (slsj == null) {
			permitImpl.setSlsj(StringPool.BLANK);
		}
		else {
			permitImpl.setSlsj(slsj);
		}

		if (nsgnr == null) {
			permitImpl.setNsgnr(StringPool.BLANK);
		}
		else {
			permitImpl.setNsgnr(nsgnr);
		}

		permitImpl.setSgxkzFileEntryId(sgxkzFileEntryId);

		if (title == null) {
			permitImpl.setTitle(StringPool.BLANK);
		}
		else {
			permitImpl.setTitle(title);
		}

		if (content == null) {
			permitImpl.setContent(StringPool.BLANK);
		}
		else {
			permitImpl.setContent(content);
		}

		permitImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			permitImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			permitImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			permitImpl.setStatusDate(null);
		}
		else {
			permitImpl.setStatusDate(new Date(statusDate));
		}

		permitImpl.resetOriginalValues();

		return permitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		permitId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		zzjgdm = objectInput.readUTF();
		bjbh = objectInput.readUTF();
		htxxbsbh = objectInput.readUTF();
		sqbz = objectInput.readInt();
		status = objectInput.readInt();
		bdh = objectInput.readUTF();
		ywbh = objectInput.readUTF();
		sgxkzbh = objectInput.readUTF();
		slbh = objectInput.readUTF();
		hjgsz = objectInput.readInt();
		hjgsh = objectInput.readInt();
		sqr = objectInput.readUTF();
		sqsx = objectInput.readUTF();
		sqh = objectInput.readUTF();
		cltjr = objectInput.readUTF();
		cltjrlxdh = objectInput.readUTF();
		cltjrlxdz = objectInput.readUTF();
		sjr = objectInput.readUTF();
		sjrlxdh = objectInput.readUTF();
		slyj = objectInput.readUTF();
		slsj = objectInput.readUTF();
		nsgnr = objectInput.readUTF();
		sgxkzFileEntryId = objectInput.readLong();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(permitId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (zzjgdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zzjgdm);
		}

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		if (htxxbsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htxxbsbh);
		}

		objectOutput.writeInt(sqbz);
		objectOutput.writeInt(status);

		if (bdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bdh);
		}

		if (ywbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywbh);
		}

		if (sgxkzbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgxkzbh);
		}

		if (slbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(slbh);
		}

		objectOutput.writeInt(hjgsz);
		objectOutput.writeInt(hjgsh);

		if (sqr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sqr);
		}

		if (sqsx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sqsx);
		}

		if (sqh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sqh);
		}

		if (cltjr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cltjr);
		}

		if (cltjrlxdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cltjrlxdh);
		}

		if (cltjrlxdz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cltjrlxdz);
		}

		if (sjr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjr);
		}

		if (sjrlxdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjrlxdh);
		}

		if (slyj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(slyj);
		}

		if (slsj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(slsj);
		}

		if (nsgnr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nsgnr);
		}

		objectOutput.writeLong(sgxkzFileEntryId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public long permitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String zzjgdm;
	public String bjbh;
	public String htxxbsbh;
	public int sqbz;
	public int status;
	public String bdh;
	public String ywbh;
	public String sgxkzbh;
	public String slbh;
	public int hjgsz;
	public int hjgsh;
	public String sqr;
	public String sqsx;
	public String sqh;
	public String cltjr;
	public String cltjrlxdh;
	public String cltjrlxdz;
	public String sjr;
	public String sjrlxdh;
	public String slyj;
	public String slsj;
	public String nsgnr;
	public long sgxkzFileEntryId;
	public String title;
	public String content;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}