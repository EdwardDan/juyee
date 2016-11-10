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
		StringBundler sb = new StringBundler(171);

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
		sb.append(", gcnr=");
		sb.append(gcnr);
		sb.append(", sgxkzsbz=");
		sb.append(sgxkzsbz);
		sb.append(", gls=");
		sb.append(gls);
		sb.append(", jzmj=");
		sb.append(jzmj);
		sb.append(", qlsl=");
		sb.append(qlsl);
		sb.append(", qlkd=");
		sb.append(qlkd);
		sb.append(", guijiaosl=");
		sb.append(guijiaosl);
		sb.append(", sdsl=");
		sb.append(sdsl);
		sb.append(", gaojiasl=");
		sb.append(gaojiasl);
		sb.append(", zgj=");
		sb.append(zgj);
		sb.append(", zsqxks=");
		sb.append(zsqxks);
		sb.append(", zsqxjs=");
		sb.append(zsqxjs);
		sb.append(", cnsx=");
		sb.append(cnsx);
		sb.append(", tzly=");
		sb.append(tzly);
		sb.append(", gkpzhhzjghwh=");
		sb.append(gkpzhhzjghwh);
		sb.append(", pfhhzrq=");
		sb.append(pfhhzrq);
		sb.append(", cbsjpzjghwh=");
		sb.append(cbsjpzjghwh);
		sb.append(", pfrq=");
		sb.append(pfrq);
		sb.append(", pfgq=");
		sb.append(pfgq);
		sb.append(", pzjghwh=");
		sb.append(pzjghwh);
		sb.append(", xmdw=");
		sb.append(xmdw);
		sb.append(", xmfzr=");
		sb.append(xmfzr);
		sb.append(", xmfzrlxdh=");
		sb.append(xmfzrlxdh);
		sb.append(", zysjdw=");
		sb.append(zysjdw);
		sb.append(", sj_zbfs=");
		sb.append(sj_zbfs);
		sb.append(", sj_zbj=");
		sb.append(sj_zbj);
		sb.append(", sj_zzdj=");
		sb.append(sj_zzdj);
		sb.append(", sj_zzdjzsbh=");
		sb.append(sj_zzdjzsbh);
		sb.append(", sj_xmfzr=");
		sb.append(sj_xmfzr);
		sb.append(", sj_xmfzrzsbh=");
		sb.append(sj_xmfzrzsbh);
		sb.append(", zyjldw=");
		sb.append(zyjldw);
		sb.append(", jl_zbfs=");
		sb.append(jl_zbfs);
		sb.append(", jl_zbj=");
		sb.append(jl_zbj);
		sb.append(", jl_zzdj=");
		sb.append(jl_zzdj);
		sb.append(", jl_zzdjzsbh=");
		sb.append(jl_zzdjzsbh);
		sb.append(", jl_zj=");
		sb.append(jl_zj);
		sb.append(", jl_zjzsbh=");
		sb.append(jl_zjzsbh);
		sb.append(", zysgdw=");
		sb.append(zysgdw);
		sb.append(", sg_zbfs=");
		sb.append(sg_zbfs);
		sb.append(", sg_zbj=");
		sb.append(sg_zbj);
		sb.append(", sg_zzdj=");
		sb.append(sg_zzdj);
		sb.append(", sg_zzdjzsbh=");
		sb.append(sg_zzdjzsbh);
		sb.append(", sg_xmjl=");
		sb.append(sg_xmjl);
		sb.append(", sg_xmjlzsbh=");
		sb.append(sg_xmjlzsbh);
		sb.append(", jszjjhlsqk=");
		sb.append(jszjjhlsqk);
		sb.append(", dcqwcqk=");
		sb.append(dcqwcqk);
		sb.append(", sgzbqk=");
		sb.append(sgzbqk);
		sb.append(", sytdxgwj=");
		sb.append(sytdxgwj);
		sb.append(", gczljddjqk=");
		sb.append(gczljddjqk);
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

		if (gcnr == null) {
			projectProfileImpl.setGcnr(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setGcnr(gcnr);
		}

		if (sgxkzsbz == null) {
			projectProfileImpl.setSgxkzsbz(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSgxkzsbz(sgxkzsbz);
		}

		if (gls == null) {
			projectProfileImpl.setGls(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setGls(gls);
		}

		if (jzmj == null) {
			projectProfileImpl.setJzmj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJzmj(jzmj);
		}

		projectProfileImpl.setQlsl(qlsl);

		if (qlkd == null) {
			projectProfileImpl.setQlkd(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setQlkd(qlkd);
		}

		projectProfileImpl.setGuijiaosl(guijiaosl);
		projectProfileImpl.setSdsl(sdsl);
		projectProfileImpl.setGaojiasl(gaojiasl);

		if (zgj == null) {
			projectProfileImpl.setZgj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setZgj(zgj);
		}

		if (zsqxks == Long.MIN_VALUE) {
			projectProfileImpl.setZsqxks(null);
		}
		else {
			projectProfileImpl.setZsqxks(new Date(zsqxks));
		}

		if (zsqxjs == Long.MIN_VALUE) {
			projectProfileImpl.setZsqxjs(null);
		}
		else {
			projectProfileImpl.setZsqxjs(new Date(zsqxjs));
		}

		if (cnsx == null) {
			projectProfileImpl.setCnsx(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setCnsx(cnsx);
		}

		if (tzly == null) {
			projectProfileImpl.setTzly(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setTzly(tzly);
		}

		if (gkpzhhzjghwh == null) {
			projectProfileImpl.setGkpzhhzjghwh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setGkpzhhzjghwh(gkpzhhzjghwh);
		}

		if (pfhhzrq == Long.MIN_VALUE) {
			projectProfileImpl.setPfhhzrq(null);
		}
		else {
			projectProfileImpl.setPfhhzrq(new Date(pfhhzrq));
		}

		if (cbsjpzjghwh == null) {
			projectProfileImpl.setCbsjpzjghwh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setCbsjpzjghwh(cbsjpzjghwh);
		}

		if (pfrq == Long.MIN_VALUE) {
			projectProfileImpl.setPfrq(null);
		}
		else {
			projectProfileImpl.setPfrq(new Date(pfrq));
		}

		projectProfileImpl.setPfgq(pfgq);

		if (pzjghwh == null) {
			projectProfileImpl.setPzjghwh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setPzjghwh(pzjghwh);
		}

		if (xmdw == null) {
			projectProfileImpl.setXmdw(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setXmdw(xmdw);
		}

		if (xmfzr == null) {
			projectProfileImpl.setXmfzr(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setXmfzr(xmfzr);
		}

		if (xmfzrlxdh == null) {
			projectProfileImpl.setXmfzrlxdh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setXmfzrlxdh(xmfzrlxdh);
		}

		if (zysjdw == null) {
			projectProfileImpl.setZysjdw(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setZysjdw(zysjdw);
		}

		if (sj_zbfs == null) {
			projectProfileImpl.setSj_zbfs(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSj_zbfs(sj_zbfs);
		}

		if (sj_zbj == null) {
			projectProfileImpl.setSj_zbj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSj_zbj(sj_zbj);
		}

		if (sj_zzdj == null) {
			projectProfileImpl.setSj_zzdj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSj_zzdj(sj_zzdj);
		}

		if (sj_zzdjzsbh == null) {
			projectProfileImpl.setSj_zzdjzsbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSj_zzdjzsbh(sj_zzdjzsbh);
		}

		if (sj_xmfzr == null) {
			projectProfileImpl.setSj_xmfzr(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSj_xmfzr(sj_xmfzr);
		}

		if (sj_xmfzrzsbh == null) {
			projectProfileImpl.setSj_xmfzrzsbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSj_xmfzrzsbh(sj_xmfzrzsbh);
		}

		if (zyjldw == null) {
			projectProfileImpl.setZyjldw(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setZyjldw(zyjldw);
		}

		if (jl_zbfs == null) {
			projectProfileImpl.setJl_zbfs(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJl_zbfs(jl_zbfs);
		}

		if (jl_zbj == null) {
			projectProfileImpl.setJl_zbj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJl_zbj(jl_zbj);
		}

		if (jl_zzdj == null) {
			projectProfileImpl.setJl_zzdj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJl_zzdj(jl_zzdj);
		}

		if (jl_zzdjzsbh == null) {
			projectProfileImpl.setJl_zzdjzsbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJl_zzdjzsbh(jl_zzdjzsbh);
		}

		if (jl_zj == null) {
			projectProfileImpl.setJl_zj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJl_zj(jl_zj);
		}

		if (jl_zjzsbh == null) {
			projectProfileImpl.setJl_zjzsbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJl_zjzsbh(jl_zjzsbh);
		}

		if (zysgdw == null) {
			projectProfileImpl.setZysgdw(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setZysgdw(zysgdw);
		}

		if (sg_zbfs == null) {
			projectProfileImpl.setSg_zbfs(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSg_zbfs(sg_zbfs);
		}

		if (sg_zbj == null) {
			projectProfileImpl.setSg_zbj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSg_zbj(sg_zbj);
		}

		if (sg_zzdj == null) {
			projectProfileImpl.setSg_zzdj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSg_zzdj(sg_zzdj);
		}

		if (sg_zzdjzsbh == null) {
			projectProfileImpl.setSg_zzdjzsbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSg_zzdjzsbh(sg_zzdjzsbh);
		}

		if (sg_xmjl == null) {
			projectProfileImpl.setSg_xmjl(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSg_xmjl(sg_xmjl);
		}

		if (sg_xmjlzsbh == null) {
			projectProfileImpl.setSg_xmjlzsbh(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSg_xmjlzsbh(sg_xmjlzsbh);
		}

		if (jszjjhlsqk == null) {
			projectProfileImpl.setJszjjhlsqk(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setJszjjhlsqk(jszjjhlsqk);
		}

		if (dcqwcqk == null) {
			projectProfileImpl.setDcqwcqk(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setDcqwcqk(dcqwcqk);
		}

		if (sgzbqk == null) {
			projectProfileImpl.setSgzbqk(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSgzbqk(sgzbqk);
		}

		if (sytdxgwj == null) {
			projectProfileImpl.setSytdxgwj(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setSytdxgwj(sytdxgwj);
		}

		if (gczljddjqk == null) {
			projectProfileImpl.setGczljddjqk(StringPool.BLANK);
		}
		else {
			projectProfileImpl.setGczljddjqk(gczljddjqk);
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
		gcnr = objectInput.readUTF();
		sgxkzsbz = objectInput.readUTF();
		gls = objectInput.readUTF();
		jzmj = objectInput.readUTF();
		qlsl = objectInput.readInt();
		qlkd = objectInput.readUTF();
		guijiaosl = objectInput.readInt();
		sdsl = objectInput.readInt();
		gaojiasl = objectInput.readInt();
		zgj = objectInput.readUTF();
		zsqxks = objectInput.readLong();
		zsqxjs = objectInput.readLong();
		cnsx = objectInput.readUTF();
		tzly = objectInput.readUTF();
		gkpzhhzjghwh = objectInput.readUTF();
		pfhhzrq = objectInput.readLong();
		cbsjpzjghwh = objectInput.readUTF();
		pfrq = objectInput.readLong();
		pfgq = objectInput.readInt();
		pzjghwh = objectInput.readUTF();
		xmdw = objectInput.readUTF();
		xmfzr = objectInput.readUTF();
		xmfzrlxdh = objectInput.readUTF();
		zysjdw = objectInput.readUTF();
		sj_zbfs = objectInput.readUTF();
		sj_zbj = objectInput.readUTF();
		sj_zzdj = objectInput.readUTF();
		sj_zzdjzsbh = objectInput.readUTF();
		sj_xmfzr = objectInput.readUTF();
		sj_xmfzrzsbh = objectInput.readUTF();
		zyjldw = objectInput.readUTF();
		jl_zbfs = objectInput.readUTF();
		jl_zbj = objectInput.readUTF();
		jl_zzdj = objectInput.readUTF();
		jl_zzdjzsbh = objectInput.readUTF();
		jl_zj = objectInput.readUTF();
		jl_zjzsbh = objectInput.readUTF();
		zysgdw = objectInput.readUTF();
		sg_zbfs = objectInput.readUTF();
		sg_zbj = objectInput.readUTF();
		sg_zzdj = objectInput.readUTF();
		sg_zzdjzsbh = objectInput.readUTF();
		sg_xmjl = objectInput.readUTF();
		sg_xmjlzsbh = objectInput.readUTF();
		jszjjhlsqk = objectInput.readUTF();
		dcqwcqk = objectInput.readUTF();
		sgzbqk = objectInput.readUTF();
		sytdxgwj = objectInput.readUTF();
		gczljddjqk = objectInput.readUTF();
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

		if (gcnr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gcnr);
		}

		if (sgxkzsbz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgxkzsbz);
		}

		if (gls == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gls);
		}

		if (jzmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jzmj);
		}

		objectOutput.writeInt(qlsl);

		if (qlkd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qlkd);
		}

		objectOutput.writeInt(guijiaosl);
		objectOutput.writeInt(sdsl);
		objectOutput.writeInt(gaojiasl);

		if (zgj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zgj);
		}

		objectOutput.writeLong(zsqxks);
		objectOutput.writeLong(zsqxjs);

		if (cnsx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cnsx);
		}

		if (tzly == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tzly);
		}

		if (gkpzhhzjghwh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gkpzhhzjghwh);
		}

		objectOutput.writeLong(pfhhzrq);

		if (cbsjpzjghwh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cbsjpzjghwh);
		}

		objectOutput.writeLong(pfrq);
		objectOutput.writeInt(pfgq);

		if (pzjghwh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pzjghwh);
		}

		if (xmdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmdw);
		}

		if (xmfzr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfzr);
		}

		if (xmfzrlxdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfzrlxdh);
		}

		if (zysjdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zysjdw);
		}

		if (sj_zbfs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sj_zbfs);
		}

		if (sj_zbj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sj_zbj);
		}

		if (sj_zzdj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sj_zzdj);
		}

		if (sj_zzdjzsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sj_zzdjzsbh);
		}

		if (sj_xmfzr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sj_xmfzr);
		}

		if (sj_xmfzrzsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sj_xmfzrzsbh);
		}

		if (zyjldw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zyjldw);
		}

		if (jl_zbfs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jl_zbfs);
		}

		if (jl_zbj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jl_zbj);
		}

		if (jl_zzdj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jl_zzdj);
		}

		if (jl_zzdjzsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jl_zzdjzsbh);
		}

		if (jl_zj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jl_zj);
		}

		if (jl_zjzsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jl_zjzsbh);
		}

		if (zysgdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zysgdw);
		}

		if (sg_zbfs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sg_zbfs);
		}

		if (sg_zbj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sg_zbj);
		}

		if (sg_zzdj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sg_zzdj);
		}

		if (sg_zzdjzsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sg_zzdjzsbh);
		}

		if (sg_xmjl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sg_xmjl);
		}

		if (sg_xmjlzsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sg_xmjlzsbh);
		}

		if (jszjjhlsqk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jszjjhlsqk);
		}

		if (dcqwcqk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dcqwcqk);
		}

		if (sgzbqk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgzbqk);
		}

		if (sytdxgwj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sytdxgwj);
		}

		if (gczljddjqk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gczljddjqk);
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
	public String gcnr;
	public String sgxkzsbz;
	public String gls;
	public String jzmj;
	public int qlsl;
	public String qlkd;
	public int guijiaosl;
	public int sdsl;
	public int gaojiasl;
	public String zgj;
	public long zsqxks;
	public long zsqxjs;
	public String cnsx;
	public String tzly;
	public String gkpzhhzjghwh;
	public long pfhhzrq;
	public String cbsjpzjghwh;
	public long pfrq;
	public int pfgq;
	public String pzjghwh;
	public String xmdw;
	public String xmfzr;
	public String xmfzrlxdh;
	public String zysjdw;
	public String sj_zbfs;
	public String sj_zbj;
	public String sj_zzdj;
	public String sj_zzdjzsbh;
	public String sj_xmfzr;
	public String sj_xmfzrzsbh;
	public String zyjldw;
	public String jl_zbfs;
	public String jl_zbj;
	public String jl_zzdj;
	public String jl_zzdjzsbh;
	public String jl_zj;
	public String jl_zjzsbh;
	public String zysgdw;
	public String sg_zbfs;
	public String sg_zbj;
	public String sg_zzdj;
	public String sg_zzdjzsbh;
	public String sg_xmjl;
	public String sg_xmjlzsbh;
	public String jszjjhlsqk;
	public String dcqwcqk;
	public String sgzbqk;
	public String sytdxgwj;
	public String gczljddjqk;
}