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

import java.util.Date;

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
		StringBundler sb = new StringBundler(75);

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
		sb.append(", xmlx=");
		sb.append(xmlx);
		sb.append(", lxjb=");
		sb.append(lxjb);
		sb.append(", xmxz=");
		sb.append(xmxz);
		sb.append(", ssqx=");
		sb.append(ssqx);
		sb.append(", ywbm=");
		sb.append(ywbm);
		sb.append(", jsddssqx=");
		sb.append(jsddssqx);
		sb.append(", jsgclb=");
		sb.append(jsgclb);
		sb.append(", jsgcsx=");
		sb.append(jsgcsx);
		sb.append(", gyzjbz=");
		sb.append(gyzjbz);
		sb.append(", zbjg=");
		sb.append(zbjg);
		sb.append(", xmtzgs=");
		sb.append(xmtzgs);
		sb.append(", jhkg=");
		sb.append(jhkg);
		sb.append(", jhjg=");
		sb.append(jhjg);
		sb.append(", sfzftzl=");
		sb.append(sfzftzl);
		sb.append(", yzzpl1=");
		sb.append(yzzpl1);
		sb.append(", yzzpl2=");
		sb.append(yzzpl2);
		sb.append(", yzzpl3=");
		sb.append(yzzpl3);
		sb.append(", yzzpl4=");
		sb.append(yzzpl4);
		sb.append(", tjsj=");
		sb.append(tjsj);
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

		projectProfileImpl.setXmlx(xmlx);

		if (lxjb == null) {
			projectProfileImpl.setLxjb(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setLxjb(lxjb);
		}

		projectProfileImpl.setXmxz(xmxz);

		if (ssqx == null) {
			projectProfileImpl.setSsqx(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSsqx(ssqx);
		}

		if (ywbm == null) {
			projectProfileImpl.setYwbm(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setYwbm(ywbm);
		}

		projectProfileImpl.setJsddssqx(jsddssqx);

		if (jsgclb == null) {
			projectProfileImpl.setJsgclb(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJsgclb(jsgclb);
		}

		projectProfileImpl.setJsgcsx(jsgcsx);

		if (gyzjbz == null) {
			projectProfileImpl.setGyzjbz(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setGyzjbz(gyzjbz);
		}

		if (zbjg == null) {
			projectProfileImpl.setZbjg(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setZbjg(zbjg);
		}

		if (xmtzgs == null) {
			projectProfileImpl.setXmtzgs(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setXmtzgs(xmtzgs);
		}

		if (jhkg == Long.MIN_VALUE) {
			projectProfileImpl.setJhkg(null);
		}
		else {
			projectProfileImpl.setJhkg(new Date(jhkg));
		}

		if (jhjg == Long.MIN_VALUE) {
			projectProfileImpl.setJhjg(null);
		}
		else {
			projectProfileImpl.setJhjg(new Date(jhjg));
		}

		projectProfileImpl.setSfzftzl(sfzftzl);

		if (yzzpl1 == null) {
			projectProfileImpl.setYzzpl1(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setYzzpl1(yzzpl1);
		}

		if (yzzpl2 == null) {
			projectProfileImpl.setYzzpl2(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setYzzpl2(yzzpl2);
		}

		if (yzzpl3 == null) {
			projectProfileImpl.setYzzpl3(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setYzzpl3(yzzpl3);
		}

		if (yzzpl4 == null) {
			projectProfileImpl.setYzzpl4(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setYzzpl4(yzzpl4);
		}

		if (tjsj == Long.MIN_VALUE) {
			projectProfileImpl.setTjsj(null);
		}
		else {
			projectProfileImpl.setTjsj(new Date(tjsj));
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
		xmlx = objectInput.readLong();
		lxjb = objectInput.readUTF();
		xmxz = objectInput.readLong();
		ssqx = objectInput.readUTF();
		ywbm = objectInput.readUTF();
		jsddssqx = objectInput.readLong();
		jsgclb = objectInput.readUTF();
		jsgcsx = objectInput.readLong();
		gyzjbz = objectInput.readUTF();
		zbjg = objectInput.readUTF();
		xmtzgs = objectInput.readUTF();
		jhkg = objectInput.readLong();
		jhjg = objectInput.readLong();
		sfzftzl = objectInput.readBoolean();
		yzzpl1 = objectInput.readUTF();
		yzzpl2 = objectInput.readUTF();
		yzzpl3 = objectInput.readUTF();
		yzzpl4 = objectInput.readUTF();
		tjsj = objectInput.readLong();
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

		objectOutput.writeLong(xmlx);

		if (lxjb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxjb);
		}

		objectOutput.writeLong(xmxz);

		if (ssqx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ssqx);
		}

		if (ywbm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywbm);
		}

		objectOutput.writeLong(jsddssqx);

		if (jsgclb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsgclb);
		}

		objectOutput.writeLong(jsgcsx);

		if (gyzjbz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gyzjbz);
		}

		if (zbjg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zbjg);
		}

		if (xmtzgs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmtzgs);
		}

		objectOutput.writeLong(jhkg);
		objectOutput.writeLong(jhjg);
		objectOutput.writeBoolean(sfzftzl);

		if (yzzpl1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yzzpl1);
		}

		if (yzzpl2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yzzpl2);
		}

		if (yzzpl3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yzzpl3);
		}

		if (yzzpl4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yzzpl4);
		}

		objectOutput.writeLong(tjsj);
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
	public long xmlx;
	public String lxjb;
	public long xmxz;
	public String ssqx;
	public String ywbm;
	public long jsddssqx;
	public String jsgclb;
	public long jsgcsx;
	public String gyzjbz;
	public String zbjg;
	public String xmtzgs;
	public long jhkg;
	public long jhjg;
	public boolean sfzftzl;
	public String yzzpl1;
	public String yzzpl2;
	public String yzzpl3;
	public String yzzpl4;
	public long tjsj;
}