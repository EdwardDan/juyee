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

import com.justonetech.cp.permit.model.ProjectProfile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ProjectProfile in entity cache.
 *
 * @author fanqi
 * @see ProjectProfile
 * @generated
 */
public class ProjectProfileCacheModel implements CacheModel<ProjectProfile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{permitId=");
		sb.append(permitId);
		sb.append(", bjbh=");
		sb.append(bjbh);
		sb.append(", jsdwmc=");
		sb.append(jsdwmc);
		sb.append(", jsdwxz=");
		sb.append(jsdwxz);
		sb.append(", jsdwdz=");
		sb.append(jsdwdz);
		sb.append(", gcmc=");
		sb.append(gcmc);
		sb.append(", jsdd=");
		sb.append(jsdd);
		sb.append(", jsgcgm=");
		sb.append(jsgcgm);
		sb.append(", fwjzmj=");
		sb.append(fwjzmj);
		sb.append(", htjg=");
		sb.append(htjg);
		sb.append(", htgq=");
		sb.append(htgq);
		sb.append(", fddbr=");
		sb.append(fddbr);
		sb.append(", jsdwlxdh=");
		sb.append(jsdwlxdh);
		sb.append(", jsdwlxr=");
		sb.append(jsdwlxr);
		sb.append(", jsdwsjh=");
		sb.append(jsdwsjh);
		sb.append(", jsydpzwjhfdccqzbh=");
		sb.append(jsydpzwjhfdccqzbh);
		sb.append(", jsgcghxkzbh=");
		sb.append(jsgcghxkzbh);
		sb.append(", xckgqk=");
		sb.append(xckgqk);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectProfile toEntityModel() {
		ProjectProfileImpl projectProfileImpl = new ProjectProfileImpl();

		projectProfileImpl.setPermitId(permitId);

		if (bjbh == null) {
			projectProfileImpl.setBjbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setBjbh(bjbh);
		}

		if (jsdwmc == null) {
			projectProfileImpl.setJsdwmc(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsdwmc(jsdwmc);
		}

		if (jsdwxz == null) {
			projectProfileImpl.setJsdwxz(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsdwxz(jsdwxz);
		}

		if (jsdwdz == null) {
			projectProfileImpl.setJsdwdz(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsdwdz(jsdwdz);
		}

		if (gcmc == null) {
			projectProfileImpl.setGcmc(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setGcmc(gcmc);
		}

		if (jsdd == null) {
			projectProfileImpl.setJsdd(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsdd(jsdd);
		}

		if (jsgcgm == null) {
			projectProfileImpl.setJsgcgm(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsgcgm(jsgcgm);
		}

		if (fwjzmj == null) {
			projectProfileImpl.setFwjzmj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setFwjzmj(fwjzmj);
		}

		if (htjg == null) {
			projectProfileImpl.setHtjg(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setHtjg(htjg);
		}

		projectProfileImpl.setHtgq(htgq);

		if (fddbr == null) {
			projectProfileImpl.setFddbr(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setFddbr(fddbr);
		}

		if (jsdwlxdh == null) {
			projectProfileImpl.setJsdwlxdh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsdwlxdh(jsdwlxdh);
		}

		if (jsdwlxr == null) {
			projectProfileImpl.setJsdwlxr(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsdwlxr(jsdwlxr);
		}

		if (jsdwsjh == null) {
			projectProfileImpl.setJsdwsjh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsdwsjh(jsdwsjh);
		}

		if (jsydpzwjhfdccqzbh == null) {
			projectProfileImpl.setJsydpzwjhfdccqzbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
		}

		if (jsgcghxkzbh == null) {
			projectProfileImpl.setJsgcghxkzbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsgcghxkzbh(jsgcghxkzbh);
		}

		if (xckgqk == null) {
			projectProfileImpl.setXckgqk(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setXckgqk(xckgqk);
		}

		projectProfileImpl.resetOriginalValues();

		return projectProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		permitId = objectInput.readLong();
		bjbh = objectInput.readUTF();
		jsdwmc = objectInput.readUTF();
		jsdwxz = objectInput.readUTF();
		jsdwdz = objectInput.readUTF();
		gcmc = objectInput.readUTF();
		jsdd = objectInput.readUTF();
		jsgcgm = objectInput.readUTF();
		fwjzmj = objectInput.readUTF();
		htjg = objectInput.readUTF();
		htgq = objectInput.readInt();
		fddbr = objectInput.readUTF();
		jsdwlxdh = objectInput.readUTF();
		jsdwlxr = objectInput.readUTF();
		jsdwsjh = objectInput.readUTF();
		jsydpzwjhfdccqzbh = objectInput.readUTF();
		jsgcghxkzbh = objectInput.readUTF();
		xckgqk = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(permitId);

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		if (jsdwmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwmc);
		}

		if (jsdwxz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwxz);
		}

		if (jsdwdz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwdz);
		}

		if (gcmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gcmc);
		}

		if (jsdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdd);
		}

		if (jsgcgm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsgcgm);
		}

		if (fwjzmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fwjzmj);
		}

		if (htjg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htjg);
		}

		objectOutput.writeInt(htgq);

		if (fddbr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fddbr);
		}

		if (jsdwlxdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwlxdh);
		}

		if (jsdwlxr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwlxr);
		}

		if (jsdwsjh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwsjh);
		}

		if (jsydpzwjhfdccqzbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsydpzwjhfdccqzbh);
		}

		if (jsgcghxkzbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsgcghxkzbh);
		}

		if (xckgqk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xckgqk);
		}
	}

	public long permitId;
	public String bjbh;
	public String jsdwmc;
	public String jsdwxz;
	public String jsdwdz;
	public String gcmc;
	public String jsdd;
	public String jsgcgm;
	public String fwjzmj;
	public String htjg;
	public int htgq;
	public String fddbr;
	public String jsdwlxdh;
	public String jsdwlxr;
	public String jsdwsjh;
	public String jsydpzwjhfdccqzbh;
	public String jsgcghxkzbh;
	public String xckgqk;
}