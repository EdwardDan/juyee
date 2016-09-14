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

package com.justonetech.cp.contract.model.impl;

import com.justonetech.cp.contract.model.Contract;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Contract in entity cache.
 *
 * @author fanqi
 * @see Contract
 * @generated
 */
public class ContractCacheModel implements CacheModel<Contract>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(159);

		sb.append("{contractId=");
		sb.append(contractId);
		sb.append(", zzjgdm=");
		sb.append(zzjgdm);
		sb.append(", htlb=");
		sb.append(htlb);
		sb.append(", id=");
		sb.append(id);
		sb.append(", htid=");
		sb.append(htid);
		sb.append(", htbh=");
		sb.append(htbh);
		sb.append(", zbhtbh=");
		sb.append(zbhtbh);
		sb.append(", fbhtbh=");
		sb.append(fbhtbh);
		sb.append(", lwfbhtbh=");
		sb.append(lwfbhtbh);
		sb.append(", htlx=");
		sb.append(htlx);
		sb.append(", htzt=");
		sb.append(htzt);
		sb.append(", sfsl=");
		sb.append(sfsl);
		sb.append(", zxbz=");
		sb.append(zxbz);
		sb.append(", state=");
		sb.append(state);
		sb.append(", bssj=");
		sb.append(bssj);
		sb.append(", slsj=");
		sb.append(slsj);
		sb.append(", bjbh=");
		sb.append(bjbh);
		sb.append(", szdq=");
		sb.append(szdq);
		sb.append(", xmmc=");
		sb.append(xmmc);
		sb.append(", jsdw=");
		sb.append(jsdw);
		sb.append(", jsdd=");
		sb.append(jsdd);
		sb.append(", lxpw=");
		sb.append(lxpw);
		sb.append(", pzwh=");
		sb.append(pzwh);
		sb.append(", dwxz=");
		sb.append(dwxz);
		sb.append(", zjlygc=");
		sb.append(zjlygc);
		sb.append(", ztz=");
		sb.append(ztz);
		sb.append(", zmj=");
		sb.append(zmj);
		sb.append(", xmfl=");
		sb.append(xmfl);
		sb.append(", jsgm=");
		sb.append(jsgm);
		sb.append(", bdh=");
		sb.append(bdh);
		sb.append(", fbfs=");
		sb.append(fbfs);
		sb.append(", cbfs=");
		sb.append(cbfs);
		sb.append(", zycbht=");
		sb.append(zycbht);
		sb.append(", zygclb=");
		sb.append(zygclb);
		sb.append(", htmc=");
		sb.append(htmc);
		sb.append(", fbdw=");
		sb.append(fbdw);
		sb.append(", cbdw=");
		sb.append(cbdw);
		sb.append(", sjdw=");
		sb.append(sjdw);
		sb.append(", xmfzr=");
		sb.append(xmfzr);
		sb.append(", xmfzrzjlx=");
		sb.append(xmfzrzjlx);
		sb.append(", xmfzrzjh=");
		sb.append(xmfzrzjh);
		sb.append(", sjfzr=");
		sb.append(sjfzr);
		sb.append(", sjfzrzjlx=");
		sb.append(sjfzrzjlx);
		sb.append(", sjfzrzjh=");
		sb.append(sjfzrzjh);
		sb.append(", kcdw=");
		sb.append(kcdw);
		sb.append(", kcfzr=");
		sb.append(kcfzr);
		sb.append(", kcfzrzjlx=");
		sb.append(kcfzrzjlx);
		sb.append(", kcfzrzjh=");
		sb.append(kcfzrzjh);
		sb.append(", sgdw=");
		sb.append(sgdw);
		sb.append(", sgfzr=");
		sb.append(sgfzr);
		sb.append(", sgfzrzjlx=");
		sb.append(sgfzrzjlx);
		sb.append(", sgfzrzjh=");
		sb.append(sgfzrzjh);
		sb.append(", xmlb=");
		sb.append(xmlb);
		sb.append(", gclb=");
		sb.append(gclb);
		sb.append(", gcgm=");
		sb.append(gcgm);
		sb.append(", sjxmlb=");
		sb.append(sjxmlb);
		sb.append(", sjgclb=");
		sb.append(sjgclb);
		sb.append(", sjgcgm=");
		sb.append(sjgcgm);
		sb.append(", sgxmlb=");
		sb.append(sgxmlb);
		sb.append(", sggclb=");
		sb.append(sggclb);
		sb.append(", sggcgm=");
		sb.append(sggcgm);
		sb.append(", kgrq=");
		sb.append(kgrq);
		sb.append(", jgrq=");
		sb.append(jgrq);
		sb.append(", jsfs=");
		sb.append(jsfs);
		sb.append(", htj=");
		sb.append(htj);
		sb.append(", sjf=");
		sb.append(sjf);
		sb.append(", kcf=");
		sb.append(kcf);
		sb.append(", jazj=");
		sb.append(jazj);
		sb.append(", zlje=");
		sb.append(zlje);
		sb.append(", zgj=");
		sb.append(zgj);
		sb.append(", wmcsf=");
		sb.append(wmcsf);
		sb.append(", htqdrq=");
		sb.append(htqdrq);
		sb.append(", htqzrq=");
		sb.append(htqzrq);
		sb.append(", cbnr=");
		sb.append(cbnr);
		sb.append(", htsfwbmc=");
		sb.append(htsfwbmc);
		sb.append(", bz=");
		sb.append(bz);
		sb.append(", sfzx=");
		sb.append(sfzx);
		sb.append(", zxsj=");
		sb.append(zxsj);
		sb.append(", zxsm=");
		sb.append(zxsm);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contract toEntityModel() {
		ContractImpl contractImpl = new ContractImpl();

		if (contractId == null) {
			contractImpl.setContractId(StringPool.BLANK);
		}
		else {
			contractImpl.setContractId(contractId);
		}

		if (zzjgdm == null) {
			contractImpl.setZzjgdm(StringPool.BLANK);
		}
		else {
			contractImpl.setZzjgdm(zzjgdm);
		}

		if (htlb == null) {
			contractImpl.setHtlb(StringPool.BLANK);
		}
		else {
			contractImpl.setHtlb(htlb);
		}

		if (id == null) {
			contractImpl.setId(StringPool.BLANK);
		}
		else {
			contractImpl.setId(id);
		}

		if (htid == null) {
			contractImpl.setHtid(StringPool.BLANK);
		}
		else {
			contractImpl.setHtid(htid);
		}

		if (htbh == null) {
			contractImpl.setHtbh(StringPool.BLANK);
		}
		else {
			contractImpl.setHtbh(htbh);
		}

		if (zbhtbh == null) {
			contractImpl.setZbhtbh(StringPool.BLANK);
		}
		else {
			contractImpl.setZbhtbh(zbhtbh);
		}

		if (fbhtbh == null) {
			contractImpl.setFbhtbh(StringPool.BLANK);
		}
		else {
			contractImpl.setFbhtbh(fbhtbh);
		}

		if (lwfbhtbh == null) {
			contractImpl.setLwfbhtbh(StringPool.BLANK);
		}
		else {
			contractImpl.setLwfbhtbh(lwfbhtbh);
		}

		if (htlx == null) {
			contractImpl.setHtlx(StringPool.BLANK);
		}
		else {
			contractImpl.setHtlx(htlx);
		}

		if (htzt == null) {
			contractImpl.setHtzt(StringPool.BLANK);
		}
		else {
			contractImpl.setHtzt(htzt);
		}

		if (sfsl == null) {
			contractImpl.setSfsl(StringPool.BLANK);
		}
		else {
			contractImpl.setSfsl(sfsl);
		}

		if (zxbz == null) {
			contractImpl.setZxbz(StringPool.BLANK);
		}
		else {
			contractImpl.setZxbz(zxbz);
		}

		if (state == null) {
			contractImpl.setState(StringPool.BLANK);
		}
		else {
			contractImpl.setState(state);
		}

		if (bssj == Long.MIN_VALUE) {
			contractImpl.setBssj(null);
		}
		else {
			contractImpl.setBssj(new Date(bssj));
		}

		if (slsj == Long.MIN_VALUE) {
			contractImpl.setSlsj(null);
		}
		else {
			contractImpl.setSlsj(new Date(slsj));
		}

		if (bjbh == null) {
			contractImpl.setBjbh(StringPool.BLANK);
		}
		else {
			contractImpl.setBjbh(bjbh);
		}

		if (szdq == null) {
			contractImpl.setSzdq(StringPool.BLANK);
		}
		else {
			contractImpl.setSzdq(szdq);
		}

		if (xmmc == null) {
			contractImpl.setXmmc(StringPool.BLANK);
		}
		else {
			contractImpl.setXmmc(xmmc);
		}

		if (jsdw == null) {
			contractImpl.setJsdw(StringPool.BLANK);
		}
		else {
			contractImpl.setJsdw(jsdw);
		}

		if (jsdd == null) {
			contractImpl.setJsdd(StringPool.BLANK);
		}
		else {
			contractImpl.setJsdd(jsdd);
		}

		if (lxpw == null) {
			contractImpl.setLxpw(StringPool.BLANK);
		}
		else {
			contractImpl.setLxpw(lxpw);
		}

		if (pzwh == null) {
			contractImpl.setPzwh(StringPool.BLANK);
		}
		else {
			contractImpl.setPzwh(pzwh);
		}

		if (dwxz == null) {
			contractImpl.setDwxz(StringPool.BLANK);
		}
		else {
			contractImpl.setDwxz(dwxz);
		}

		if (zjlygc == null) {
			contractImpl.setZjlygc(StringPool.BLANK);
		}
		else {
			contractImpl.setZjlygc(zjlygc);
		}

		if (ztz == null) {
			contractImpl.setZtz(StringPool.BLANK);
		}
		else {
			contractImpl.setZtz(ztz);
		}

		if (zmj == null) {
			contractImpl.setZmj(StringPool.BLANK);
		}
		else {
			contractImpl.setZmj(zmj);
		}

		if (xmfl == null) {
			contractImpl.setXmfl(StringPool.BLANK);
		}
		else {
			contractImpl.setXmfl(xmfl);
		}

		if (jsgm == null) {
			contractImpl.setJsgm(StringPool.BLANK);
		}
		else {
			contractImpl.setJsgm(jsgm);
		}

		if (bdh == null) {
			contractImpl.setBdh(StringPool.BLANK);
		}
		else {
			contractImpl.setBdh(bdh);
		}

		if (fbfs == null) {
			contractImpl.setFbfs(StringPool.BLANK);
		}
		else {
			contractImpl.setFbfs(fbfs);
		}

		if (cbfs == null) {
			contractImpl.setCbfs(StringPool.BLANK);
		}
		else {
			contractImpl.setCbfs(cbfs);
		}

		if (zycbht == null) {
			contractImpl.setZycbht(StringPool.BLANK);
		}
		else {
			contractImpl.setZycbht(zycbht);
		}

		if (zygclb == null) {
			contractImpl.setZygclb(StringPool.BLANK);
		}
		else {
			contractImpl.setZygclb(zygclb);
		}

		if (htmc == null) {
			contractImpl.setHtmc(StringPool.BLANK);
		}
		else {
			contractImpl.setHtmc(htmc);
		}

		if (fbdw == null) {
			contractImpl.setFbdw(StringPool.BLANK);
		}
		else {
			contractImpl.setFbdw(fbdw);
		}

		if (cbdw == null) {
			contractImpl.setCbdw(StringPool.BLANK);
		}
		else {
			contractImpl.setCbdw(cbdw);
		}

		if (sjdw == null) {
			contractImpl.setSjdw(StringPool.BLANK);
		}
		else {
			contractImpl.setSjdw(sjdw);
		}

		if (xmfzr == null) {
			contractImpl.setXmfzr(StringPool.BLANK);
		}
		else {
			contractImpl.setXmfzr(xmfzr);
		}

		if (xmfzrzjlx == null) {
			contractImpl.setXmfzrzjlx(StringPool.BLANK);
		}
		else {
			contractImpl.setXmfzrzjlx(xmfzrzjlx);
		}

		if (xmfzrzjh == null) {
			contractImpl.setXmfzrzjh(StringPool.BLANK);
		}
		else {
			contractImpl.setXmfzrzjh(xmfzrzjh);
		}

		if (sjfzr == null) {
			contractImpl.setSjfzr(StringPool.BLANK);
		}
		else {
			contractImpl.setSjfzr(sjfzr);
		}

		if (sjfzrzjlx == null) {
			contractImpl.setSjfzrzjlx(StringPool.BLANK);
		}
		else {
			contractImpl.setSjfzrzjlx(sjfzrzjlx);
		}

		if (sjfzrzjh == null) {
			contractImpl.setSjfzrzjh(StringPool.BLANK);
		}
		else {
			contractImpl.setSjfzrzjh(sjfzrzjh);
		}

		if (kcdw == null) {
			contractImpl.setKcdw(StringPool.BLANK);
		}
		else {
			contractImpl.setKcdw(kcdw);
		}

		if (kcfzr == null) {
			contractImpl.setKcfzr(StringPool.BLANK);
		}
		else {
			contractImpl.setKcfzr(kcfzr);
		}

		if (kcfzrzjlx == null) {
			contractImpl.setKcfzrzjlx(StringPool.BLANK);
		}
		else {
			contractImpl.setKcfzrzjlx(kcfzrzjlx);
		}

		if (kcfzrzjh == null) {
			contractImpl.setKcfzrzjh(StringPool.BLANK);
		}
		else {
			contractImpl.setKcfzrzjh(kcfzrzjh);
		}

		if (sgdw == null) {
			contractImpl.setSgdw(StringPool.BLANK);
		}
		else {
			contractImpl.setSgdw(sgdw);
		}

		if (sgfzr == null) {
			contractImpl.setSgfzr(StringPool.BLANK);
		}
		else {
			contractImpl.setSgfzr(sgfzr);
		}

		if (sgfzrzjlx == null) {
			contractImpl.setSgfzrzjlx(StringPool.BLANK);
		}
		else {
			contractImpl.setSgfzrzjlx(sgfzrzjlx);
		}

		if (sgfzrzjh == null) {
			contractImpl.setSgfzrzjh(StringPool.BLANK);
		}
		else {
			contractImpl.setSgfzrzjh(sgfzrzjh);
		}

		if (xmlb == null) {
			contractImpl.setXmlb(StringPool.BLANK);
		}
		else {
			contractImpl.setXmlb(xmlb);
		}

		if (gclb == null) {
			contractImpl.setGclb(StringPool.BLANK);
		}
		else {
			contractImpl.setGclb(gclb);
		}

		if (gcgm == null) {
			contractImpl.setGcgm(StringPool.BLANK);
		}
		else {
			contractImpl.setGcgm(gcgm);
		}

		if (sjxmlb == null) {
			contractImpl.setSjxmlb(StringPool.BLANK);
		}
		else {
			contractImpl.setSjxmlb(sjxmlb);
		}

		if (sjgclb == null) {
			contractImpl.setSjgclb(StringPool.BLANK);
		}
		else {
			contractImpl.setSjgclb(sjgclb);
		}

		if (sjgcgm == null) {
			contractImpl.setSjgcgm(StringPool.BLANK);
		}
		else {
			contractImpl.setSjgcgm(sjgcgm);
		}

		if (sgxmlb == null) {
			contractImpl.setSgxmlb(StringPool.BLANK);
		}
		else {
			contractImpl.setSgxmlb(sgxmlb);
		}

		if (sggclb == null) {
			contractImpl.setSggclb(StringPool.BLANK);
		}
		else {
			contractImpl.setSggclb(sggclb);
		}

		if (sggcgm == null) {
			contractImpl.setSggcgm(StringPool.BLANK);
		}
		else {
			contractImpl.setSggcgm(sggcgm);
		}

		if (kgrq == Long.MIN_VALUE) {
			contractImpl.setKgrq(null);
		}
		else {
			contractImpl.setKgrq(new Date(kgrq));
		}

		if (jgrq == Long.MIN_VALUE) {
			contractImpl.setJgrq(null);
		}
		else {
			contractImpl.setJgrq(new Date(jgrq));
		}

		if (jsfs == null) {
			contractImpl.setJsfs(StringPool.BLANK);
		}
		else {
			contractImpl.setJsfs(jsfs);
		}

		if (htj == null) {
			contractImpl.setHtj(StringPool.BLANK);
		}
		else {
			contractImpl.setHtj(htj);
		}

		if (sjf == null) {
			contractImpl.setSjf(StringPool.BLANK);
		}
		else {
			contractImpl.setSjf(sjf);
		}

		if (kcf == null) {
			contractImpl.setKcf(StringPool.BLANK);
		}
		else {
			contractImpl.setKcf(kcf);
		}

		if (jazj == null) {
			contractImpl.setJazj(StringPool.BLANK);
		}
		else {
			contractImpl.setJazj(jazj);
		}

		if (zlje == null) {
			contractImpl.setZlje(StringPool.BLANK);
		}
		else {
			contractImpl.setZlje(zlje);
		}

		if (zgj == null) {
			contractImpl.setZgj(StringPool.BLANK);
		}
		else {
			contractImpl.setZgj(zgj);
		}

		if (wmcsf == null) {
			contractImpl.setWmcsf(StringPool.BLANK);
		}
		else {
			contractImpl.setWmcsf(wmcsf);
		}

		if (htqdrq == Long.MIN_VALUE) {
			contractImpl.setHtqdrq(null);
		}
		else {
			contractImpl.setHtqdrq(new Date(htqdrq));
		}

		if (htqzrq == null) {
			contractImpl.setHtqzrq(StringPool.BLANK);
		}
		else {
			contractImpl.setHtqzrq(htqzrq);
		}

		if (cbnr == null) {
			contractImpl.setCbnr(StringPool.BLANK);
		}
		else {
			contractImpl.setCbnr(cbnr);
		}

		if (htsfwbmc == null) {
			contractImpl.setHtsfwbmc(StringPool.BLANK);
		}
		else {
			contractImpl.setHtsfwbmc(htsfwbmc);
		}

		if (bz == null) {
			contractImpl.setBz(StringPool.BLANK);
		}
		else {
			contractImpl.setBz(bz);
		}

		if (sfzx == null) {
			contractImpl.setSfzx(StringPool.BLANK);
		}
		else {
			contractImpl.setSfzx(sfzx);
		}

		if (zxsj == Long.MIN_VALUE) {
			contractImpl.setZxsj(null);
		}
		else {
			contractImpl.setZxsj(new Date(zxsj));
		}

		if (zxsm == null) {
			contractImpl.setZxsm(StringPool.BLANK);
		}
		else {
			contractImpl.setZxsm(zxsm);
		}

		contractImpl.resetOriginalValues();

		return contractImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contractId = objectInput.readUTF();
		zzjgdm = objectInput.readUTF();
		htlb = objectInput.readUTF();
		id = objectInput.readUTF();
		htid = objectInput.readUTF();
		htbh = objectInput.readUTF();
		zbhtbh = objectInput.readUTF();
		fbhtbh = objectInput.readUTF();
		lwfbhtbh = objectInput.readUTF();
		htlx = objectInput.readUTF();
		htzt = objectInput.readUTF();
		sfsl = objectInput.readUTF();
		zxbz = objectInput.readUTF();
		state = objectInput.readUTF();
		bssj = objectInput.readLong();
		slsj = objectInput.readLong();
		bjbh = objectInput.readUTF();
		szdq = objectInput.readUTF();
		xmmc = objectInput.readUTF();
		jsdw = objectInput.readUTF();
		jsdd = objectInput.readUTF();
		lxpw = objectInput.readUTF();
		pzwh = objectInput.readUTF();
		dwxz = objectInput.readUTF();
		zjlygc = objectInput.readUTF();
		ztz = objectInput.readUTF();
		zmj = objectInput.readUTF();
		xmfl = objectInput.readUTF();
		jsgm = objectInput.readUTF();
		bdh = objectInput.readUTF();
		fbfs = objectInput.readUTF();
		cbfs = objectInput.readUTF();
		zycbht = objectInput.readUTF();
		zygclb = objectInput.readUTF();
		htmc = objectInput.readUTF();
		fbdw = objectInput.readUTF();
		cbdw = objectInput.readUTF();
		sjdw = objectInput.readUTF();
		xmfzr = objectInput.readUTF();
		xmfzrzjlx = objectInput.readUTF();
		xmfzrzjh = objectInput.readUTF();
		sjfzr = objectInput.readUTF();
		sjfzrzjlx = objectInput.readUTF();
		sjfzrzjh = objectInput.readUTF();
		kcdw = objectInput.readUTF();
		kcfzr = objectInput.readUTF();
		kcfzrzjlx = objectInput.readUTF();
		kcfzrzjh = objectInput.readUTF();
		sgdw = objectInput.readUTF();
		sgfzr = objectInput.readUTF();
		sgfzrzjlx = objectInput.readUTF();
		sgfzrzjh = objectInput.readUTF();
		xmlb = objectInput.readUTF();
		gclb = objectInput.readUTF();
		gcgm = objectInput.readUTF();
		sjxmlb = objectInput.readUTF();
		sjgclb = objectInput.readUTF();
		sjgcgm = objectInput.readUTF();
		sgxmlb = objectInput.readUTF();
		sggclb = objectInput.readUTF();
		sggcgm = objectInput.readUTF();
		kgrq = objectInput.readLong();
		jgrq = objectInput.readLong();
		jsfs = objectInput.readUTF();
		htj = objectInput.readUTF();
		sjf = objectInput.readUTF();
		kcf = objectInput.readUTF();
		jazj = objectInput.readUTF();
		zlje = objectInput.readUTF();
		zgj = objectInput.readUTF();
		wmcsf = objectInput.readUTF();
		htqdrq = objectInput.readLong();
		htqzrq = objectInput.readUTF();
		cbnr = objectInput.readUTF();
		htsfwbmc = objectInput.readUTF();
		bz = objectInput.readUTF();
		sfzx = objectInput.readUTF();
		zxsj = objectInput.readLong();
		zxsm = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (contractId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractId);
		}

		if (zzjgdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zzjgdm);
		}

		if (htlb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htlb);
		}

		if (id == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(id);
		}

		if (htid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htid);
		}

		if (htbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htbh);
		}

		if (zbhtbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zbhtbh);
		}

		if (fbhtbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fbhtbh);
		}

		if (lwfbhtbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lwfbhtbh);
		}

		if (htlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htlx);
		}

		if (htzt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htzt);
		}

		if (sfsl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfsl);
		}

		if (zxbz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zxbz);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(bssj);
		objectOutput.writeLong(slsj);

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		if (szdq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(szdq);
		}

		if (xmmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmmc);
		}

		if (jsdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdw);
		}

		if (jsdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdd);
		}

		if (lxpw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxpw);
		}

		if (pzwh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pzwh);
		}

		if (dwxz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dwxz);
		}

		if (zjlygc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc);
		}

		if (ztz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ztz);
		}

		if (zmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zmj);
		}

		if (xmfl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfl);
		}

		if (jsgm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsgm);
		}

		if (bdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bdh);
		}

		if (fbfs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fbfs);
		}

		if (cbfs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cbfs);
		}

		if (zycbht == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zycbht);
		}

		if (zygclb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zygclb);
		}

		if (htmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htmc);
		}

		if (fbdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fbdw);
		}

		if (cbdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cbdw);
		}

		if (sjdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjdw);
		}

		if (xmfzr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfzr);
		}

		if (xmfzrzjlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfzrzjlx);
		}

		if (xmfzrzjh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfzrzjh);
		}

		if (sjfzr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjfzr);
		}

		if (sjfzrzjlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjfzrzjlx);
		}

		if (sjfzrzjh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjfzrzjh);
		}

		if (kcdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kcdw);
		}

		if (kcfzr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kcfzr);
		}

		if (kcfzrzjlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kcfzrzjlx);
		}

		if (kcfzrzjh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kcfzrzjh);
		}

		if (sgdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgdw);
		}

		if (sgfzr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgfzr);
		}

		if (sgfzrzjlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgfzrzjlx);
		}

		if (sgfzrzjh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgfzrzjh);
		}

		if (xmlb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmlb);
		}

		if (gclb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gclb);
		}

		if (gcgm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gcgm);
		}

		if (sjxmlb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjxmlb);
		}

		if (sjgclb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjgclb);
		}

		if (sjgcgm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjgcgm);
		}

		if (sgxmlb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgxmlb);
		}

		if (sggclb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sggclb);
		}

		if (sggcgm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sggcgm);
		}

		objectOutput.writeLong(kgrq);
		objectOutput.writeLong(jgrq);

		if (jsfs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsfs);
		}

		if (htj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htj);
		}

		if (sjf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjf);
		}

		if (kcf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kcf);
		}

		if (jazj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jazj);
		}

		if (zlje == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zlje);
		}

		if (zgj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zgj);
		}

		if (wmcsf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wmcsf);
		}

		objectOutput.writeLong(htqdrq);

		if (htqzrq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htqzrq);
		}

		if (cbnr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cbnr);
		}

		if (htsfwbmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htsfwbmc);
		}

		if (bz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bz);
		}

		if (sfzx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfzx);
		}

		objectOutput.writeLong(zxsj);

		if (zxsm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zxsm);
		}
	}

	public String contractId;
	public String zzjgdm;
	public String htlb;
	public String id;
	public String htid;
	public String htbh;
	public String zbhtbh;
	public String fbhtbh;
	public String lwfbhtbh;
	public String htlx;
	public String htzt;
	public String sfsl;
	public String zxbz;
	public String state;
	public long bssj;
	public long slsj;
	public String bjbh;
	public String szdq;
	public String xmmc;
	public String jsdw;
	public String jsdd;
	public String lxpw;
	public String pzwh;
	public String dwxz;
	public String zjlygc;
	public String ztz;
	public String zmj;
	public String xmfl;
	public String jsgm;
	public String bdh;
	public String fbfs;
	public String cbfs;
	public String zycbht;
	public String zygclb;
	public String htmc;
	public String fbdw;
	public String cbdw;
	public String sjdw;
	public String xmfzr;
	public String xmfzrzjlx;
	public String xmfzrzjh;
	public String sjfzr;
	public String sjfzrzjlx;
	public String sjfzrzjh;
	public String kcdw;
	public String kcfzr;
	public String kcfzrzjlx;
	public String kcfzrzjh;
	public String sgdw;
	public String sgfzr;
	public String sgfzrzjlx;
	public String sgfzrzjh;
	public String xmlb;
	public String gclb;
	public String gcgm;
	public String sjxmlb;
	public String sjgclb;
	public String sjgcgm;
	public String sgxmlb;
	public String sggclb;
	public String sggcgm;
	public long kgrq;
	public long jgrq;
	public String jsfs;
	public String htj;
	public String sjf;
	public String kcf;
	public String jazj;
	public String zlje;
	public String zgj;
	public String wmcsf;
	public long htqdrq;
	public String htqzrq;
	public String cbnr;
	public String htsfwbmc;
	public String bz;
	public String sfzx;
	public long zxsj;
	public String zxsm;
}