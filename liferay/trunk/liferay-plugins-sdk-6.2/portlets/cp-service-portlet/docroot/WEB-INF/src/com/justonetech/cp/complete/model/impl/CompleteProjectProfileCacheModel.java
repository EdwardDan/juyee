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

import com.justonetech.cp.complete.model.CompleteProjectProfile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CompleteProjectProfile in entity cache.
 *
 * @author fanqi
 * @see CompleteProjectProfile
 * @generated
 */
public class CompleteProjectProfileCacheModel implements CacheModel<CompleteProjectProfile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{completeId=");
		sb.append(completeId);
		sb.append(", bjbh=");
		sb.append(bjbh);
		sb.append(", gcmc=");
		sb.append(gcmc);
		sb.append(", jsdwmc=");
		sb.append(jsdwmc);
		sb.append(", jsdwdz=");
		sb.append(jsdwdz);
		sb.append(", jsdd=");
		sb.append(jsdd);
		sb.append(", szqx=");
		sb.append(szqx);
		sb.append(", fddbr=");
		sb.append(fddbr);
		sb.append(", lxr=");
		sb.append(lxr);
		sb.append(", lxdh=");
		sb.append(lxdh);
		sb.append(", bz=");
		sb.append(bz);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompleteProjectProfile toEntityModel() {
		CompleteProjectProfileImpl completeProjectProfileImpl = new CompleteProjectProfileImpl();

		completeProjectProfileImpl.setCompleteId(completeId);

		if (bjbh == null) {
			completeProjectProfileImpl.setBjbh(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setBjbh(bjbh);
		}

		if (gcmc == null) {
			completeProjectProfileImpl.setGcmc(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setGcmc(gcmc);
		}

		if (jsdwmc == null) {
			completeProjectProfileImpl.setJsdwmc(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setJsdwmc(jsdwmc);
		}

		if (jsdwdz == null) {
			completeProjectProfileImpl.setJsdwdz(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setJsdwdz(jsdwdz);
		}

		if (jsdd == null) {
			completeProjectProfileImpl.setJsdd(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setJsdd(jsdd);
		}

		if (szqx == null) {
			completeProjectProfileImpl.setSzqx(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setSzqx(szqx);
		}

		if (fddbr == null) {
			completeProjectProfileImpl.setFddbr(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setFddbr(fddbr);
		}

		if (lxr == null) {
			completeProjectProfileImpl.setLxr(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setLxr(lxr);
		}

		if (lxdh == null) {
			completeProjectProfileImpl.setLxdh(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setLxdh(lxdh);
		}

		if (bz == null) {
			completeProjectProfileImpl.setBz(StringPool.BLANK);
		}
		else {
			completeProjectProfileImpl.setBz(bz);
		}

		completeProjectProfileImpl.resetOriginalValues();

		return completeProjectProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		completeId = objectInput.readLong();
		bjbh = objectInput.readUTF();
		gcmc = objectInput.readUTF();
		jsdwmc = objectInput.readUTF();
		jsdwdz = objectInput.readUTF();
		jsdd = objectInput.readUTF();
		szqx = objectInput.readUTF();
		fddbr = objectInput.readUTF();
		lxr = objectInput.readUTF();
		lxdh = objectInput.readUTF();
		bz = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(completeId);

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		if (gcmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gcmc);
		}

		if (jsdwmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwmc);
		}

		if (jsdwdz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwdz);
		}

		if (jsdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdd);
		}

		if (szqx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(szqx);
		}

		if (fddbr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fddbr);
		}

		if (lxr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxr);
		}

		if (lxdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxdh);
		}

		if (bz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bz);
		}
	}

	public long completeId;
	public String bjbh;
	public String gcmc;
	public String jsdwmc;
	public String jsdwdz;
	public String jsdd;
	public String szqx;
	public String fddbr;
	public String lxr;
	public String lxdh;
	public String bz;
}