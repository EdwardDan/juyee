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

package com.justonetech.cp.project.model.impl;

import com.justonetech.cp.project.model.Project;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author fanqi
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(303);

		sb.append("{bjbh=");
		sb.append(bjbh);
		sb.append(", bjrq=");
		sb.append(bjrq);
		sb.append(", jsdw=");
		sb.append(jsdw);
		sb.append(", jsdwxz=");
		sb.append(jsdwxz);
		sb.append(", jsdwdz=");
		sb.append(jsdwdz);
		sb.append(", jsdwdh=");
		sb.append(jsdwdh);
		sb.append(", jsdwfr=");
		sb.append(jsdwfr);
		sb.append(", jsdwlxr=");
		sb.append(jsdwlxr);
		sb.append(", jsdwyb=");
		sb.append(jsdwyb);
		sb.append(", jsdwzczj=");
		sb.append(jsdwzczj);
		sb.append(", xmmc=");
		sb.append(xmmc);
		sb.append(", jsdd=");
		sb.append(jsdd);
		sb.append(", lxwj=");
		sb.append(lxwj);
		sb.append(", lxwh=");
		sb.append(lxwh);
		sb.append(", lxjb=");
		sb.append(lxjb);
		sb.append(", pzjg=");
		sb.append(pzjg);
		sb.append(", pzrq=");
		sb.append(pzrq);
		sb.append(", ztz=");
		sb.append(ztz);
		sb.append(", sbtz=");
		sb.append(sbtz);
		sb.append(", jsxz=");
		sb.append(jsxz);
		sb.append(", jsgm=");
		sb.append(jsgm);
		sb.append(", zmj=");
		sb.append(zmj);
		sb.append(", kgrq=");
		sb.append(kgrq);
		sb.append(", xmxz=");
		sb.append(xmxz);
		sb.append(", cjqk=");
		sb.append(cjqk);
		sb.append(", smqk=");
		sb.append(smqk);
		sb.append(", bjbz=");
		sb.append(bjbz);
		sb.append(", fbzgsc=");
		sb.append(fbzgsc);
		sb.append(", cardid=");
		sb.append(cardid);
		sb.append(", zjlygc_1=");
		sb.append(zjlygc_1);
		sb.append(", zjlygc_2=");
		sb.append(zjlygc_2);
		sb.append(", zjlygc_3=");
		sb.append(zjlygc_3);
		sb.append(", zjlygc_4=");
		sb.append(zjlygc_4);
		sb.append(", zjlygc_5=");
		sb.append(zjlygc_5);
		sb.append(", zjlygc_6=");
		sb.append(zjlygc_6);
		sb.append(", zjlygc_7=");
		sb.append(zjlygc_7);
		sb.append(", zjlygc_8=");
		sb.append(zjlygc_8);
		sb.append(", zjlygc_9=");
		sb.append(zjlygc_9);
		sb.append(", jgxs=");
		sb.append(jgxs);
		sb.append(", xmfl=");
		sb.append(xmfl);
		sb.append(", jzmq=");
		sb.append(jzmq);
		sb.append(", ywdt=");
		sb.append(ywdt);
		sb.append(", dxsck=");
		sb.append(dxsck);
		sb.append(", bhjz=");
		sb.append(bhjz);
		sb.append(", fjms=");
		sb.append(fjms);
		sb.append(", sfsbxm=");
		sb.append(sfsbxm);
		sb.append(", hzyj=");
		sb.append(hzyj);
		sb.append(", bj_sx=");
		sb.append(bj_sx);
		sb.append(", bj_webid=");
		sb.append(bj_webid);
		sb.append(", bjwcbj=");
		sb.append(bjwcbj);
		sb.append(", bmdm=");
		sb.append(bmdm);
		sb.append(", jbr=");
		sb.append(jbr);
		sb.append(", shr=");
		sb.append(shr);
		sb.append(", shbmdm=");
		sb.append(shbmdm);
		sb.append(", wcbjsj=");
		sb.append(wcbjsj);
		sb.append(", old_bjbh=");
		sb.append(old_bjbh);
		sb.append(", sffb=");
		sb.append(sffb);
		sb.append(", timeflag=");
		sb.append(timeflag);
		sb.append(", jbrdm=");
		sb.append(jbrdm);
		sb.append(", shrdm=");
		sb.append(shrdm);
		sb.append(", jsbh=");
		sb.append(jsbh);
		sb.append(", needSbjl=");
		sb.append(needSbjl);
		sb.append(", wcSbjl=");
		sb.append(wcSbjl);
		sb.append(", sfgyzbkg=");
		sb.append(sfgyzbkg);
		sb.append(", jyzxfbxx=");
		sb.append(jyzxfbxx);
		sb.append(", sgGkzbfb=");
		sb.append(sgGkzbfb);
		sb.append(", sgjlGkzbfb=");
		sb.append(sgjlGkzbfb);
		sb.append(", fxglxm=");
		sb.append(fxglxm);
		sb.append(", fxglxmJbr=");
		sb.append(fxglxmJbr);
		sb.append(", fxglxmJbrdm=");
		sb.append(fxglxmJbrdm);
		sb.append(", fxglxmJbrq=");
		sb.append(fxglxmJbrq);
		sb.append(", jsdwjgdm=");
		sb.append(jsdwjgdm);
		sb.append(", szqy=");
		sb.append(szqy);
		sb.append(", ywxjfwjz=");
		sb.append(ywxjfwjz);
		sb.append(", ywgbfwjg=");
		sb.append(ywgbfwjg);
		sb.append(", gczh=");
		sb.append(gczh);
		sb.append(", zdcyyn=");
		sb.append(zdcyyn);
		sb.append(", lxfl=");
		sb.append(lxfl);
		sb.append(", ms1=");
		sb.append(ms1);
		sb.append(", ms2=");
		sb.append(ms2);
		sb.append(", ms3=");
		sb.append(ms3);
		sb.append(", zdxmyn=");
		sb.append(zdxmyn);
		sb.append(", dxjzsq=");
		sb.append(dxjzsq);
		sb.append(", ywjzxzz=");
		sb.append(ywjzxzz);
		sb.append(", fgwjhm=");
		sb.append(fgwjhm);
		sb.append(", zzbl=");
		sb.append(zzbl);
		sb.append(", ChangeTime=");
		sb.append(ChangeTime);
		sb.append(", PD_SW=");
		sb.append(PD_SW);
		sb.append(", bmpfrq=");
		sb.append(bmpfrq);
		sb.append(", bmpfwh=");
		sb.append(bmpfwh);
		sb.append(", bmpfwj=");
		sb.append(bmpfwj);
		sb.append(", CertificateKey=");
		sb.append(CertificateKey);
		sb.append(", dsjzmj=");
		sb.append(dsjzmj);
		sb.append(", dxjzmj=");
		sb.append(dxjzmj);
		sb.append(", gdzctzbh=");
		sb.append(gdzctzbh);
		sb.append(", jsxz_2011=");
		sb.append(jsxz_2011);
		sb.append(", lhmj=");
		sb.append(lhmj);
		sb.append(", lxjb_2011=");
		sb.append(lxjb_2011);
		sb.append(", mfmj=");
		sb.append(mfmj);
		sb.append(", other_qx=");
		sb.append(other_qx);
		sb.append(", ProjectSlyj=");
		sb.append(ProjectSlyj);
		sb.append(", qxbz=");
		sb.append(qxbz);
		sb.append(", sfcysjkfq=");
		sb.append(sfcysjkfq);
		sb.append(", sfmfss=");
		sb.append(sfmfss);
		sb.append(", szqx=");
		sb.append(szqx);
		sb.append(", tsgs=");
		sb.append(tsgs);
		sb.append(", xmfl_2011=");
		sb.append(xmfl_2011);
		sb.append(", xsjpw=");
		sb.append(xsjpw);
		sb.append(", xsjpzdw=");
		sb.append(xsjpzdw);
		sb.append(", zjlygc_10=");
		sb.append(zjlygc_10);
		sb.append(", zjlygc_11=");
		sb.append(zjlygc_11);
		sb.append(", zjlygc_xs_1=");
		sb.append(zjlygc_xs_1);
		sb.append(", zjlygc_xs_2=");
		sb.append(zjlygc_xs_2);
		sb.append(", zjlygc_xs_3=");
		sb.append(zjlygc_xs_3);
		sb.append(", zjlygc_xs_4=");
		sb.append(zjlygc_xs_4);
		sb.append(", zjlygc_1_2=");
		sb.append(zjlygc_1_2);
		sb.append(", zjlygc_1_2_4=");
		sb.append(zjlygc_1_2_4);
		sb.append(", ywptlh=");
		sb.append(ywptlh);
		sb.append(", gyyqbh=");
		sb.append(gyyqbh);
		sb.append(", sfcyxm=");
		sb.append(sfcyxm);
		sb.append(", zbxmfzrxm=");
		sb.append(zbxmfzrxm);
		sb.append(", zbxmfzrzjh=");
		sb.append(zbxmfzrzjh);
		sb.append(", zbxmfzrzjlx=");
		sb.append(zbxmfzrzjlx);
		sb.append(", zbxmfzrqrsj=");
		sb.append(zbxmfzrqrsj);
		sb.append(", sflsjzbs=");
		sb.append(sflsjzbs);
		sb.append(", sjbs=");
		sb.append(sjbs);
		sb.append(", yxbs=");
		sb.append(yxbs);
		sb.append(", sfyjngz=");
		sb.append(sfyjngz);
		sb.append(", sfsszpjz=");
		sb.append(sfsszpjz);
		sb.append(", zczxjgdmz=");
		sb.append(zczxjgdmz);
		sb.append(", ischeckxmbm=");
		sb.append(ischeckxmbm);
		sb.append(", zddtmj=");
		sb.append(zddtmj);
		sb.append(", sjjdYn=");
		sb.append(sjjdYn);
		sb.append(", sgjdYn=");
		sb.append(sgjdYn);
		sb.append(", yxjdYn=");
		sb.append(yxjdYn);
		sb.append(", tdhtqdbh=");
		sb.append(tdhtqdbh);
		sb.append(", tdhtqdrq=");
		sb.append(tdhtqdrq);
		sb.append(", dkbh=");
		sb.append(dkbh);
		sb.append(", zpsjzlsbl=");
		sb.append(zpsjzlsbl);
		sb.append(", zpsjzmj=");
		sb.append(zpsjzmj);
		sb.append(", dwyzzpl=");
		sb.append(dwyzzpl);
		sb.append(", zdh=");
		sb.append(zdh);
		sb.append(", sfgdcg=");
		sb.append(sfgdcg);
		sb.append(", ptlhmj=");
		sb.append(ptlhmj);
		sb.append(", bimjszxfy=");
		sb.append(bimjszxfy);
		sb.append(", bz=");
		sb.append(bz);
		sb.append(", sfzcxm=");
		sb.append(sfzcxm);
		sb.append(", zcxmbm=");
		sb.append(zcxmbm);
		sb.append(", sfzmqxm=");
		sb.append(sfzmqxm);
		sb.append(", printPDFTime=");
		sb.append(printPDFTime);
		sb.append(", isBgPrint=");
		sb.append(isBgPrint);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		if (bjbh == null) {
			projectImpl.setBjbh(StringPool.BLANK);
		}
		else {
			projectImpl.setBjbh(bjbh);
		}

		if (bjrq == Long.MIN_VALUE) {
			projectImpl.setBjrq(null);
		}
		else {
			projectImpl.setBjrq(new Date(bjrq));
		}

		if (jsdw == null) {
			projectImpl.setJsdw(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdw(jsdw);
		}

		if (jsdwxz == null) {
			projectImpl.setJsdwxz(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwxz(jsdwxz);
		}

		if (jsdwdz == null) {
			projectImpl.setJsdwdz(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwdz(jsdwdz);
		}

		if (jsdwdh == null) {
			projectImpl.setJsdwdh(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwdh(jsdwdh);
		}

		if (jsdwfr == null) {
			projectImpl.setJsdwfr(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwfr(jsdwfr);
		}

		if (jsdwlxr == null) {
			projectImpl.setJsdwlxr(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwlxr(jsdwlxr);
		}

		if (jsdwyb == null) {
			projectImpl.setJsdwyb(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwyb(jsdwyb);
		}

		if (jsdwzczj == null) {
			projectImpl.setJsdwzczj(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwzczj(jsdwzczj);
		}

		if (xmmc == null) {
			projectImpl.setXmmc(StringPool.BLANK);
		}
		else {
			projectImpl.setXmmc(xmmc);
		}

		if (jsdd == null) {
			projectImpl.setJsdd(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdd(jsdd);
		}

		if (lxwj == null) {
			projectImpl.setLxwj(StringPool.BLANK);
		}
		else {
			projectImpl.setLxwj(lxwj);
		}

		if (lxwh == null) {
			projectImpl.setLxwh(StringPool.BLANK);
		}
		else {
			projectImpl.setLxwh(lxwh);
		}

		if (lxjb == null) {
			projectImpl.setLxjb(StringPool.BLANK);
		}
		else {
			projectImpl.setLxjb(lxjb);
		}

		if (pzjg == null) {
			projectImpl.setPzjg(StringPool.BLANK);
		}
		else {
			projectImpl.setPzjg(pzjg);
		}

		if (pzrq == null) {
			projectImpl.setPzrq(StringPool.BLANK);
		}
		else {
			projectImpl.setPzrq(pzrq);
		}

		if (ztz == null) {
			projectImpl.setZtz(StringPool.BLANK);
		}
		else {
			projectImpl.setZtz(ztz);
		}

		if (sbtz == null) {
			projectImpl.setSbtz(StringPool.BLANK);
		}
		else {
			projectImpl.setSbtz(sbtz);
		}

		if (jsxz == null) {
			projectImpl.setJsxz(StringPool.BLANK);
		}
		else {
			projectImpl.setJsxz(jsxz);
		}

		if (jsgm == null) {
			projectImpl.setJsgm(StringPool.BLANK);
		}
		else {
			projectImpl.setJsgm(jsgm);
		}

		if (zmj == null) {
			projectImpl.setZmj(StringPool.BLANK);
		}
		else {
			projectImpl.setZmj(zmj);
		}

		if (kgrq == null) {
			projectImpl.setKgrq(StringPool.BLANK);
		}
		else {
			projectImpl.setKgrq(kgrq);
		}

		if (xmxz == null) {
			projectImpl.setXmxz(StringPool.BLANK);
		}
		else {
			projectImpl.setXmxz(xmxz);
		}

		if (cjqk == null) {
			projectImpl.setCjqk(StringPool.BLANK);
		}
		else {
			projectImpl.setCjqk(cjqk);
		}

		if (smqk == null) {
			projectImpl.setSmqk(StringPool.BLANK);
		}
		else {
			projectImpl.setSmqk(smqk);
		}

		if (bjbz == null) {
			projectImpl.setBjbz(StringPool.BLANK);
		}
		else {
			projectImpl.setBjbz(bjbz);
		}

		if (fbzgsc == null) {
			projectImpl.setFbzgsc(StringPool.BLANK);
		}
		else {
			projectImpl.setFbzgsc(fbzgsc);
		}

		if (cardid == null) {
			projectImpl.setCardid(StringPool.BLANK);
		}
		else {
			projectImpl.setCardid(cardid);
		}

		if (zjlygc_1 == null) {
			projectImpl.setZjlygc_1(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_1(zjlygc_1);
		}

		if (zjlygc_2 == null) {
			projectImpl.setZjlygc_2(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_2(zjlygc_2);
		}

		if (zjlygc_3 == null) {
			projectImpl.setZjlygc_3(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_3(zjlygc_3);
		}

		if (zjlygc_4 == null) {
			projectImpl.setZjlygc_4(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_4(zjlygc_4);
		}

		if (zjlygc_5 == null) {
			projectImpl.setZjlygc_5(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_5(zjlygc_5);
		}

		if (zjlygc_6 == null) {
			projectImpl.setZjlygc_6(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_6(zjlygc_6);
		}

		if (zjlygc_7 == null) {
			projectImpl.setZjlygc_7(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_7(zjlygc_7);
		}

		if (zjlygc_8 == null) {
			projectImpl.setZjlygc_8(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_8(zjlygc_8);
		}

		if (zjlygc_9 == null) {
			projectImpl.setZjlygc_9(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_9(zjlygc_9);
		}

		if (jgxs == null) {
			projectImpl.setJgxs(StringPool.BLANK);
		}
		else {
			projectImpl.setJgxs(jgxs);
		}

		if (xmfl == null) {
			projectImpl.setXmfl(StringPool.BLANK);
		}
		else {
			projectImpl.setXmfl(xmfl);
		}

		if (jzmq == null) {
			projectImpl.setJzmq(StringPool.BLANK);
		}
		else {
			projectImpl.setJzmq(jzmq);
		}

		if (ywdt == null) {
			projectImpl.setYwdt(StringPool.BLANK);
		}
		else {
			projectImpl.setYwdt(ywdt);
		}

		if (dxsck == null) {
			projectImpl.setDxsck(StringPool.BLANK);
		}
		else {
			projectImpl.setDxsck(dxsck);
		}

		if (bhjz == null) {
			projectImpl.setBhjz(StringPool.BLANK);
		}
		else {
			projectImpl.setBhjz(bhjz);
		}

		if (fjms == null) {
			projectImpl.setFjms(StringPool.BLANK);
		}
		else {
			projectImpl.setFjms(fjms);
		}

		if (sfsbxm == null) {
			projectImpl.setSfsbxm(StringPool.BLANK);
		}
		else {
			projectImpl.setSfsbxm(sfsbxm);
		}

		if (hzyj == null) {
			projectImpl.setHzyj(StringPool.BLANK);
		}
		else {
			projectImpl.setHzyj(hzyj);
		}

		if (bj_sx == null) {
			projectImpl.setBj_sx(StringPool.BLANK);
		}
		else {
			projectImpl.setBj_sx(bj_sx);
		}

		if (bj_webid == null) {
			projectImpl.setBj_webid(StringPool.BLANK);
		}
		else {
			projectImpl.setBj_webid(bj_webid);
		}

		if (bjwcbj == null) {
			projectImpl.setBjwcbj(StringPool.BLANK);
		}
		else {
			projectImpl.setBjwcbj(bjwcbj);
		}

		if (bmdm == null) {
			projectImpl.setBmdm(StringPool.BLANK);
		}
		else {
			projectImpl.setBmdm(bmdm);
		}

		if (jbr == null) {
			projectImpl.setJbr(StringPool.BLANK);
		}
		else {
			projectImpl.setJbr(jbr);
		}

		if (shr == null) {
			projectImpl.setShr(StringPool.BLANK);
		}
		else {
			projectImpl.setShr(shr);
		}

		if (shbmdm == null) {
			projectImpl.setShbmdm(StringPool.BLANK);
		}
		else {
			projectImpl.setShbmdm(shbmdm);
		}

		if (wcbjsj == null) {
			projectImpl.setWcbjsj(StringPool.BLANK);
		}
		else {
			projectImpl.setWcbjsj(wcbjsj);
		}

		if (old_bjbh == null) {
			projectImpl.setOld_bjbh(StringPool.BLANK);
		}
		else {
			projectImpl.setOld_bjbh(old_bjbh);
		}

		if (sffb == null) {
			projectImpl.setSffb(StringPool.BLANK);
		}
		else {
			projectImpl.setSffb(sffb);
		}

		if (timeflag == null) {
			projectImpl.setTimeflag(StringPool.BLANK);
		}
		else {
			projectImpl.setTimeflag(timeflag);
		}

		if (jbrdm == null) {
			projectImpl.setJbrdm(StringPool.BLANK);
		}
		else {
			projectImpl.setJbrdm(jbrdm);
		}

		if (shrdm == null) {
			projectImpl.setShrdm(StringPool.BLANK);
		}
		else {
			projectImpl.setShrdm(shrdm);
		}

		if (jsbh == null) {
			projectImpl.setJsbh(StringPool.BLANK);
		}
		else {
			projectImpl.setJsbh(jsbh);
		}

		if (needSbjl == null) {
			projectImpl.setNeedSbjl(StringPool.BLANK);
		}
		else {
			projectImpl.setNeedSbjl(needSbjl);
		}

		if (wcSbjl == null) {
			projectImpl.setWcSbjl(StringPool.BLANK);
		}
		else {
			projectImpl.setWcSbjl(wcSbjl);
		}

		if (sfgyzbkg == null) {
			projectImpl.setSfgyzbkg(StringPool.BLANK);
		}
		else {
			projectImpl.setSfgyzbkg(sfgyzbkg);
		}

		if (jyzxfbxx == null) {
			projectImpl.setJyzxfbxx(StringPool.BLANK);
		}
		else {
			projectImpl.setJyzxfbxx(jyzxfbxx);
		}

		if (sgGkzbfb == null) {
			projectImpl.setSgGkzbfb(StringPool.BLANK);
		}
		else {
			projectImpl.setSgGkzbfb(sgGkzbfb);
		}

		if (sgjlGkzbfb == null) {
			projectImpl.setSgjlGkzbfb(StringPool.BLANK);
		}
		else {
			projectImpl.setSgjlGkzbfb(sgjlGkzbfb);
		}

		if (fxglxm == null) {
			projectImpl.setFxglxm(StringPool.BLANK);
		}
		else {
			projectImpl.setFxglxm(fxglxm);
		}

		if (fxglxmJbr == null) {
			projectImpl.setFxglxmJbr(StringPool.BLANK);
		}
		else {
			projectImpl.setFxglxmJbr(fxglxmJbr);
		}

		if (fxglxmJbrdm == null) {
			projectImpl.setFxglxmJbrdm(StringPool.BLANK);
		}
		else {
			projectImpl.setFxglxmJbrdm(fxglxmJbrdm);
		}

		if (fxglxmJbrq == null) {
			projectImpl.setFxglxmJbrq(StringPool.BLANK);
		}
		else {
			projectImpl.setFxglxmJbrq(fxglxmJbrq);
		}

		if (jsdwjgdm == null) {
			projectImpl.setJsdwjgdm(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwjgdm(jsdwjgdm);
		}

		if (szqy == null) {
			projectImpl.setSzqy(StringPool.BLANK);
		}
		else {
			projectImpl.setSzqy(szqy);
		}

		if (ywxjfwjz == null) {
			projectImpl.setYwxjfwjz(StringPool.BLANK);
		}
		else {
			projectImpl.setYwxjfwjz(ywxjfwjz);
		}

		if (ywgbfwjg == null) {
			projectImpl.setYwgbfwjg(StringPool.BLANK);
		}
		else {
			projectImpl.setYwgbfwjg(ywgbfwjg);
		}

		if (gczh == null) {
			projectImpl.setGczh(StringPool.BLANK);
		}
		else {
			projectImpl.setGczh(gczh);
		}

		if (zdcyyn == null) {
			projectImpl.setZdcyyn(StringPool.BLANK);
		}
		else {
			projectImpl.setZdcyyn(zdcyyn);
		}

		if (lxfl == null) {
			projectImpl.setLxfl(StringPool.BLANK);
		}
		else {
			projectImpl.setLxfl(lxfl);
		}

		if (ms1 == null) {
			projectImpl.setMs1(StringPool.BLANK);
		}
		else {
			projectImpl.setMs1(ms1);
		}

		if (ms2 == null) {
			projectImpl.setMs2(StringPool.BLANK);
		}
		else {
			projectImpl.setMs2(ms2);
		}

		if (ms3 == null) {
			projectImpl.setMs3(StringPool.BLANK);
		}
		else {
			projectImpl.setMs3(ms3);
		}

		if (zdxmyn == null) {
			projectImpl.setZdxmyn(StringPool.BLANK);
		}
		else {
			projectImpl.setZdxmyn(zdxmyn);
		}

		if (dxjzsq == null) {
			projectImpl.setDxjzsq(StringPool.BLANK);
		}
		else {
			projectImpl.setDxjzsq(dxjzsq);
		}

		if (ywjzxzz == null) {
			projectImpl.setYwjzxzz(StringPool.BLANK);
		}
		else {
			projectImpl.setYwjzxzz(ywjzxzz);
		}

		if (fgwjhm == null) {
			projectImpl.setFgwjhm(StringPool.BLANK);
		}
		else {
			projectImpl.setFgwjhm(fgwjhm);
		}

		if (zzbl == null) {
			projectImpl.setZzbl(StringPool.BLANK);
		}
		else {
			projectImpl.setZzbl(zzbl);
		}

		if (ChangeTime == null) {
			projectImpl.setChangeTime(StringPool.BLANK);
		}
		else {
			projectImpl.setChangeTime(ChangeTime);
		}

		if (PD_SW == null) {
			projectImpl.setPD_SW(StringPool.BLANK);
		}
		else {
			projectImpl.setPD_SW(PD_SW);
		}

		if (bmpfrq == null) {
			projectImpl.setBmpfrq(StringPool.BLANK);
		}
		else {
			projectImpl.setBmpfrq(bmpfrq);
		}

		if (bmpfwh == null) {
			projectImpl.setBmpfwh(StringPool.BLANK);
		}
		else {
			projectImpl.setBmpfwh(bmpfwh);
		}

		if (bmpfwj == null) {
			projectImpl.setBmpfwj(StringPool.BLANK);
		}
		else {
			projectImpl.setBmpfwj(bmpfwj);
		}

		if (CertificateKey == null) {
			projectImpl.setCertificateKey(StringPool.BLANK);
		}
		else {
			projectImpl.setCertificateKey(CertificateKey);
		}

		if (dsjzmj == null) {
			projectImpl.setDsjzmj(StringPool.BLANK);
		}
		else {
			projectImpl.setDsjzmj(dsjzmj);
		}

		if (dxjzmj == null) {
			projectImpl.setDxjzmj(StringPool.BLANK);
		}
		else {
			projectImpl.setDxjzmj(dxjzmj);
		}

		if (gdzctzbh == null) {
			projectImpl.setGdzctzbh(StringPool.BLANK);
		}
		else {
			projectImpl.setGdzctzbh(gdzctzbh);
		}

		if (jsxz_2011 == null) {
			projectImpl.setJsxz_2011(StringPool.BLANK);
		}
		else {
			projectImpl.setJsxz_2011(jsxz_2011);
		}

		if (lhmj == null) {
			projectImpl.setLhmj(StringPool.BLANK);
		}
		else {
			projectImpl.setLhmj(lhmj);
		}

		if (lxjb_2011 == null) {
			projectImpl.setLxjb_2011(StringPool.BLANK);
		}
		else {
			projectImpl.setLxjb_2011(lxjb_2011);
		}

		if (mfmj == null) {
			projectImpl.setMfmj(StringPool.BLANK);
		}
		else {
			projectImpl.setMfmj(mfmj);
		}

		if (other_qx == null) {
			projectImpl.setOther_qx(StringPool.BLANK);
		}
		else {
			projectImpl.setOther_qx(other_qx);
		}

		if (ProjectSlyj == null) {
			projectImpl.setProjectSlyj(StringPool.BLANK);
		}
		else {
			projectImpl.setProjectSlyj(ProjectSlyj);
		}

		if (qxbz == null) {
			projectImpl.setQxbz(StringPool.BLANK);
		}
		else {
			projectImpl.setQxbz(qxbz);
		}

		if (sfcysjkfq == null) {
			projectImpl.setSfcysjkfq(StringPool.BLANK);
		}
		else {
			projectImpl.setSfcysjkfq(sfcysjkfq);
		}

		if (sfmfss == null) {
			projectImpl.setSfmfss(StringPool.BLANK);
		}
		else {
			projectImpl.setSfmfss(sfmfss);
		}

		if (szqx == null) {
			projectImpl.setSzqx(StringPool.BLANK);
		}
		else {
			projectImpl.setSzqx(szqx);
		}

		if (tsgs == null) {
			projectImpl.setTsgs(StringPool.BLANK);
		}
		else {
			projectImpl.setTsgs(tsgs);
		}

		if (xmfl_2011 == null) {
			projectImpl.setXmfl_2011(StringPool.BLANK);
		}
		else {
			projectImpl.setXmfl_2011(xmfl_2011);
		}

		if (xsjpw == null) {
			projectImpl.setXsjpw(StringPool.BLANK);
		}
		else {
			projectImpl.setXsjpw(xsjpw);
		}

		if (xsjpzdw == null) {
			projectImpl.setXsjpzdw(StringPool.BLANK);
		}
		else {
			projectImpl.setXsjpzdw(xsjpzdw);
		}

		if (zjlygc_10 == null) {
			projectImpl.setZjlygc_10(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_10(zjlygc_10);
		}

		if (zjlygc_11 == null) {
			projectImpl.setZjlygc_11(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_11(zjlygc_11);
		}

		if (zjlygc_xs_1 == null) {
			projectImpl.setZjlygc_xs_1(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_xs_1(zjlygc_xs_1);
		}

		if (zjlygc_xs_2 == null) {
			projectImpl.setZjlygc_xs_2(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_xs_2(zjlygc_xs_2);
		}

		if (zjlygc_xs_3 == null) {
			projectImpl.setZjlygc_xs_3(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_xs_3(zjlygc_xs_3);
		}

		if (zjlygc_xs_4 == null) {
			projectImpl.setZjlygc_xs_4(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_xs_4(zjlygc_xs_4);
		}

		if (zjlygc_1_2 == null) {
			projectImpl.setZjlygc_1_2(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_1_2(zjlygc_1_2);
		}

		if (zjlygc_1_2_4 == null) {
			projectImpl.setZjlygc_1_2_4(StringPool.BLANK);
		}
		else {
			projectImpl.setZjlygc_1_2_4(zjlygc_1_2_4);
		}

		if (ywptlh == null) {
			projectImpl.setYwptlh(StringPool.BLANK);
		}
		else {
			projectImpl.setYwptlh(ywptlh);
		}

		if (gyyqbh == null) {
			projectImpl.setGyyqbh(StringPool.BLANK);
		}
		else {
			projectImpl.setGyyqbh(gyyqbh);
		}

		if (sfcyxm == null) {
			projectImpl.setSfcyxm(StringPool.BLANK);
		}
		else {
			projectImpl.setSfcyxm(sfcyxm);
		}

		if (zbxmfzrxm == null) {
			projectImpl.setZbxmfzrxm(StringPool.BLANK);
		}
		else {
			projectImpl.setZbxmfzrxm(zbxmfzrxm);
		}

		if (zbxmfzrzjh == null) {
			projectImpl.setZbxmfzrzjh(StringPool.BLANK);
		}
		else {
			projectImpl.setZbxmfzrzjh(zbxmfzrzjh);
		}

		if (zbxmfzrzjlx == null) {
			projectImpl.setZbxmfzrzjlx(StringPool.BLANK);
		}
		else {
			projectImpl.setZbxmfzrzjlx(zbxmfzrzjlx);
		}

		if (zbxmfzrqrsj == null) {
			projectImpl.setZbxmfzrqrsj(StringPool.BLANK);
		}
		else {
			projectImpl.setZbxmfzrqrsj(zbxmfzrqrsj);
		}

		if (sflsjzbs == null) {
			projectImpl.setSflsjzbs(StringPool.BLANK);
		}
		else {
			projectImpl.setSflsjzbs(sflsjzbs);
		}

		if (sjbs == null) {
			projectImpl.setSjbs(StringPool.BLANK);
		}
		else {
			projectImpl.setSjbs(sjbs);
		}

		if (yxbs == null) {
			projectImpl.setYxbs(StringPool.BLANK);
		}
		else {
			projectImpl.setYxbs(yxbs);
		}

		if (sfyjngz == null) {
			projectImpl.setSfyjngz(StringPool.BLANK);
		}
		else {
			projectImpl.setSfyjngz(sfyjngz);
		}

		if (sfsszpjz == null) {
			projectImpl.setSfsszpjz(StringPool.BLANK);
		}
		else {
			projectImpl.setSfsszpjz(sfsszpjz);
		}

		if (zczxjgdmz == null) {
			projectImpl.setZczxjgdmz(StringPool.BLANK);
		}
		else {
			projectImpl.setZczxjgdmz(zczxjgdmz);
		}

		if (ischeckxmbm == null) {
			projectImpl.setIscheckxmbm(StringPool.BLANK);
		}
		else {
			projectImpl.setIscheckxmbm(ischeckxmbm);
		}

		if (zddtmj == null) {
			projectImpl.setZddtmj(StringPool.BLANK);
		}
		else {
			projectImpl.setZddtmj(zddtmj);
		}

		if (sjjdYn == null) {
			projectImpl.setSjjdYn(StringPool.BLANK);
		}
		else {
			projectImpl.setSjjdYn(sjjdYn);
		}

		if (sgjdYn == null) {
			projectImpl.setSgjdYn(StringPool.BLANK);
		}
		else {
			projectImpl.setSgjdYn(sgjdYn);
		}

		if (yxjdYn == null) {
			projectImpl.setYxjdYn(StringPool.BLANK);
		}
		else {
			projectImpl.setYxjdYn(yxjdYn);
		}

		if (tdhtqdbh == null) {
			projectImpl.setTdhtqdbh(StringPool.BLANK);
		}
		else {
			projectImpl.setTdhtqdbh(tdhtqdbh);
		}

		if (tdhtqdrq == null) {
			projectImpl.setTdhtqdrq(StringPool.BLANK);
		}
		else {
			projectImpl.setTdhtqdrq(tdhtqdrq);
		}

		if (dkbh == null) {
			projectImpl.setDkbh(StringPool.BLANK);
		}
		else {
			projectImpl.setDkbh(dkbh);
		}

		if (zpsjzlsbl == null) {
			projectImpl.setZpsjzlsbl(StringPool.BLANK);
		}
		else {
			projectImpl.setZpsjzlsbl(zpsjzlsbl);
		}

		if (zpsjzmj == null) {
			projectImpl.setZpsjzmj(StringPool.BLANK);
		}
		else {
			projectImpl.setZpsjzmj(zpsjzmj);
		}

		if (dwyzzpl == null) {
			projectImpl.setDwyzzpl(StringPool.BLANK);
		}
		else {
			projectImpl.setDwyzzpl(dwyzzpl);
		}

		if (zdh == null) {
			projectImpl.setZdh(StringPool.BLANK);
		}
		else {
			projectImpl.setZdh(zdh);
		}

		if (sfgdcg == null) {
			projectImpl.setSfgdcg(StringPool.BLANK);
		}
		else {
			projectImpl.setSfgdcg(sfgdcg);
		}

		if (ptlhmj == null) {
			projectImpl.setPtlhmj(StringPool.BLANK);
		}
		else {
			projectImpl.setPtlhmj(ptlhmj);
		}

		if (bimjszxfy == null) {
			projectImpl.setBimjszxfy(StringPool.BLANK);
		}
		else {
			projectImpl.setBimjszxfy(bimjszxfy);
		}

		if (bz == null) {
			projectImpl.setBz(StringPool.BLANK);
		}
		else {
			projectImpl.setBz(bz);
		}

		if (sfzcxm == null) {
			projectImpl.setSfzcxm(StringPool.BLANK);
		}
		else {
			projectImpl.setSfzcxm(sfzcxm);
		}

		if (zcxmbm == null) {
			projectImpl.setZcxmbm(StringPool.BLANK);
		}
		else {
			projectImpl.setZcxmbm(zcxmbm);
		}

		if (sfzmqxm == null) {
			projectImpl.setSfzmqxm(StringPool.BLANK);
		}
		else {
			projectImpl.setSfzmqxm(sfzmqxm);
		}

		if (printPDFTime == null) {
			projectImpl.setPrintPDFTime(StringPool.BLANK);
		}
		else {
			projectImpl.setPrintPDFTime(printPDFTime);
		}

		if (isBgPrint == null) {
			projectImpl.setIsBgPrint(StringPool.BLANK);
		}
		else {
			projectImpl.setIsBgPrint(isBgPrint);
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bjbh = objectInput.readUTF();
		bjrq = objectInput.readLong();
		jsdw = objectInput.readUTF();
		jsdwxz = objectInput.readUTF();
		jsdwdz = objectInput.readUTF();
		jsdwdh = objectInput.readUTF();
		jsdwfr = objectInput.readUTF();
		jsdwlxr = objectInput.readUTF();
		jsdwyb = objectInput.readUTF();
		jsdwzczj = objectInput.readUTF();
		xmmc = objectInput.readUTF();
		jsdd = objectInput.readUTF();
		lxwj = objectInput.readUTF();
		lxwh = objectInput.readUTF();
		lxjb = objectInput.readUTF();
		pzjg = objectInput.readUTF();
		pzrq = objectInput.readUTF();
		ztz = objectInput.readUTF();
		sbtz = objectInput.readUTF();
		jsxz = objectInput.readUTF();
		jsgm = objectInput.readUTF();
		zmj = objectInput.readUTF();
		kgrq = objectInput.readUTF();
		xmxz = objectInput.readUTF();
		cjqk = objectInput.readUTF();
		smqk = objectInput.readUTF();
		bjbz = objectInput.readUTF();
		fbzgsc = objectInput.readUTF();
		cardid = objectInput.readUTF();
		zjlygc_1 = objectInput.readUTF();
		zjlygc_2 = objectInput.readUTF();
		zjlygc_3 = objectInput.readUTF();
		zjlygc_4 = objectInput.readUTF();
		zjlygc_5 = objectInput.readUTF();
		zjlygc_6 = objectInput.readUTF();
		zjlygc_7 = objectInput.readUTF();
		zjlygc_8 = objectInput.readUTF();
		zjlygc_9 = objectInput.readUTF();
		jgxs = objectInput.readUTF();
		xmfl = objectInput.readUTF();
		jzmq = objectInput.readUTF();
		ywdt = objectInput.readUTF();
		dxsck = objectInput.readUTF();
		bhjz = objectInput.readUTF();
		fjms = objectInput.readUTF();
		sfsbxm = objectInput.readUTF();
		hzyj = objectInput.readUTF();
		bj_sx = objectInput.readUTF();
		bj_webid = objectInput.readUTF();
		bjwcbj = objectInput.readUTF();
		bmdm = objectInput.readUTF();
		jbr = objectInput.readUTF();
		shr = objectInput.readUTF();
		shbmdm = objectInput.readUTF();
		wcbjsj = objectInput.readUTF();
		old_bjbh = objectInput.readUTF();
		sffb = objectInput.readUTF();
		timeflag = objectInput.readUTF();
		jbrdm = objectInput.readUTF();
		shrdm = objectInput.readUTF();
		jsbh = objectInput.readUTF();
		needSbjl = objectInput.readUTF();
		wcSbjl = objectInput.readUTF();
		sfgyzbkg = objectInput.readUTF();
		jyzxfbxx = objectInput.readUTF();
		sgGkzbfb = objectInput.readUTF();
		sgjlGkzbfb = objectInput.readUTF();
		fxglxm = objectInput.readUTF();
		fxglxmJbr = objectInput.readUTF();
		fxglxmJbrdm = objectInput.readUTF();
		fxglxmJbrq = objectInput.readUTF();
		jsdwjgdm = objectInput.readUTF();
		szqy = objectInput.readUTF();
		ywxjfwjz = objectInput.readUTF();
		ywgbfwjg = objectInput.readUTF();
		gczh = objectInput.readUTF();
		zdcyyn = objectInput.readUTF();
		lxfl = objectInput.readUTF();
		ms1 = objectInput.readUTF();
		ms2 = objectInput.readUTF();
		ms3 = objectInput.readUTF();
		zdxmyn = objectInput.readUTF();
		dxjzsq = objectInput.readUTF();
		ywjzxzz = objectInput.readUTF();
		fgwjhm = objectInput.readUTF();
		zzbl = objectInput.readUTF();
		ChangeTime = objectInput.readUTF();
		PD_SW = objectInput.readUTF();
		bmpfrq = objectInput.readUTF();
		bmpfwh = objectInput.readUTF();
		bmpfwj = objectInput.readUTF();
		CertificateKey = objectInput.readUTF();
		dsjzmj = objectInput.readUTF();
		dxjzmj = objectInput.readUTF();
		gdzctzbh = objectInput.readUTF();
		jsxz_2011 = objectInput.readUTF();
		lhmj = objectInput.readUTF();
		lxjb_2011 = objectInput.readUTF();
		mfmj = objectInput.readUTF();
		other_qx = objectInput.readUTF();
		ProjectSlyj = objectInput.readUTF();
		qxbz = objectInput.readUTF();
		sfcysjkfq = objectInput.readUTF();
		sfmfss = objectInput.readUTF();
		szqx = objectInput.readUTF();
		tsgs = objectInput.readUTF();
		xmfl_2011 = objectInput.readUTF();
		xsjpw = objectInput.readUTF();
		xsjpzdw = objectInput.readUTF();
		zjlygc_10 = objectInput.readUTF();
		zjlygc_11 = objectInput.readUTF();
		zjlygc_xs_1 = objectInput.readUTF();
		zjlygc_xs_2 = objectInput.readUTF();
		zjlygc_xs_3 = objectInput.readUTF();
		zjlygc_xs_4 = objectInput.readUTF();
		zjlygc_1_2 = objectInput.readUTF();
		zjlygc_1_2_4 = objectInput.readUTF();
		ywptlh = objectInput.readUTF();
		gyyqbh = objectInput.readUTF();
		sfcyxm = objectInput.readUTF();
		zbxmfzrxm = objectInput.readUTF();
		zbxmfzrzjh = objectInput.readUTF();
		zbxmfzrzjlx = objectInput.readUTF();
		zbxmfzrqrsj = objectInput.readUTF();
		sflsjzbs = objectInput.readUTF();
		sjbs = objectInput.readUTF();
		yxbs = objectInput.readUTF();
		sfyjngz = objectInput.readUTF();
		sfsszpjz = objectInput.readUTF();
		zczxjgdmz = objectInput.readUTF();
		ischeckxmbm = objectInput.readUTF();
		zddtmj = objectInput.readUTF();
		sjjdYn = objectInput.readUTF();
		sgjdYn = objectInput.readUTF();
		yxjdYn = objectInput.readUTF();
		tdhtqdbh = objectInput.readUTF();
		tdhtqdrq = objectInput.readUTF();
		dkbh = objectInput.readUTF();
		zpsjzlsbl = objectInput.readUTF();
		zpsjzmj = objectInput.readUTF();
		dwyzzpl = objectInput.readUTF();
		zdh = objectInput.readUTF();
		sfgdcg = objectInput.readUTF();
		ptlhmj = objectInput.readUTF();
		bimjszxfy = objectInput.readUTF();
		bz = objectInput.readUTF();
		sfzcxm = objectInput.readUTF();
		zcxmbm = objectInput.readUTF();
		sfzmqxm = objectInput.readUTF();
		printPDFTime = objectInput.readUTF();
		isBgPrint = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		objectOutput.writeLong(bjrq);

		if (jsdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdw);
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

		if (jsdwdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwdh);
		}

		if (jsdwfr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwfr);
		}

		if (jsdwlxr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwlxr);
		}

		if (jsdwyb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwyb);
		}

		if (jsdwzczj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwzczj);
		}

		if (xmmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmmc);
		}

		if (jsdd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdd);
		}

		if (lxwj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxwj);
		}

		if (lxwh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxwh);
		}

		if (lxjb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxjb);
		}

		if (pzjg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pzjg);
		}

		if (pzrq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pzrq);
		}

		if (ztz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ztz);
		}

		if (sbtz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sbtz);
		}

		if (jsxz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsxz);
		}

		if (jsgm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsgm);
		}

		if (zmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zmj);
		}

		if (kgrq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kgrq);
		}

		if (xmxz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmxz);
		}

		if (cjqk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cjqk);
		}

		if (smqk == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(smqk);
		}

		if (bjbz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbz);
		}

		if (fbzgsc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fbzgsc);
		}

		if (cardid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cardid);
		}

		if (zjlygc_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_1);
		}

		if (zjlygc_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_2);
		}

		if (zjlygc_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_3);
		}

		if (zjlygc_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_4);
		}

		if (zjlygc_5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_5);
		}

		if (zjlygc_6 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_6);
		}

		if (zjlygc_7 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_7);
		}

		if (zjlygc_8 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_8);
		}

		if (zjlygc_9 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_9);
		}

		if (jgxs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jgxs);
		}

		if (xmfl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfl);
		}

		if (jzmq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jzmq);
		}

		if (ywdt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywdt);
		}

		if (dxsck == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dxsck);
		}

		if (bhjz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bhjz);
		}

		if (fjms == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fjms);
		}

		if (sfsbxm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfsbxm);
		}

		if (hzyj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hzyj);
		}

		if (bj_sx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bj_sx);
		}

		if (bj_webid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bj_webid);
		}

		if (bjwcbj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjwcbj);
		}

		if (bmdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bmdm);
		}

		if (jbr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jbr);
		}

		if (shr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shr);
		}

		if (shbmdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shbmdm);
		}

		if (wcbjsj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wcbjsj);
		}

		if (old_bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(old_bjbh);
		}

		if (sffb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sffb);
		}

		if (timeflag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timeflag);
		}

		if (jbrdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jbrdm);
		}

		if (shrdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shrdm);
		}

		if (jsbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsbh);
		}

		if (needSbjl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(needSbjl);
		}

		if (wcSbjl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wcSbjl);
		}

		if (sfgyzbkg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfgyzbkg);
		}

		if (jyzxfbxx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jyzxfbxx);
		}

		if (sgGkzbfb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgGkzbfb);
		}

		if (sgjlGkzbfb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgjlGkzbfb);
		}

		if (fxglxm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fxglxm);
		}

		if (fxglxmJbr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fxglxmJbr);
		}

		if (fxglxmJbrdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fxglxmJbrdm);
		}

		if (fxglxmJbrq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fxglxmJbrq);
		}

		if (jsdwjgdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwjgdm);
		}

		if (szqy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(szqy);
		}

		if (ywxjfwjz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywxjfwjz);
		}

		if (ywgbfwjg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywgbfwjg);
		}

		if (gczh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gczh);
		}

		if (zdcyyn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zdcyyn);
		}

		if (lxfl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxfl);
		}

		if (ms1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ms1);
		}

		if (ms2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ms2);
		}

		if (ms3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ms3);
		}

		if (zdxmyn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zdxmyn);
		}

		if (dxjzsq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dxjzsq);
		}

		if (ywjzxzz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywjzxzz);
		}

		if (fgwjhm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fgwjhm);
		}

		if (zzbl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zzbl);
		}

		if (ChangeTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ChangeTime);
		}

		if (PD_SW == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(PD_SW);
		}

		if (bmpfrq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bmpfrq);
		}

		if (bmpfwh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bmpfwh);
		}

		if (bmpfwj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bmpfwj);
		}

		if (CertificateKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CertificateKey);
		}

		if (dsjzmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dsjzmj);
		}

		if (dxjzmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dxjzmj);
		}

		if (gdzctzbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gdzctzbh);
		}

		if (jsxz_2011 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsxz_2011);
		}

		if (lhmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lhmj);
		}

		if (lxjb_2011 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxjb_2011);
		}

		if (mfmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mfmj);
		}

		if (other_qx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(other_qx);
		}

		if (ProjectSlyj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ProjectSlyj);
		}

		if (qxbz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qxbz);
		}

		if (sfcysjkfq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfcysjkfq);
		}

		if (sfmfss == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfmfss);
		}

		if (szqx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(szqx);
		}

		if (tsgs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tsgs);
		}

		if (xmfl_2011 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmfl_2011);
		}

		if (xsjpw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xsjpw);
		}

		if (xsjpzdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xsjpzdw);
		}

		if (zjlygc_10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_10);
		}

		if (zjlygc_11 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_11);
		}

		if (zjlygc_xs_1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_xs_1);
		}

		if (zjlygc_xs_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_xs_2);
		}

		if (zjlygc_xs_3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_xs_3);
		}

		if (zjlygc_xs_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_xs_4);
		}

		if (zjlygc_1_2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_1_2);
		}

		if (zjlygc_1_2_4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zjlygc_1_2_4);
		}

		if (ywptlh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ywptlh);
		}

		if (gyyqbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gyyqbh);
		}

		if (sfcyxm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfcyxm);
		}

		if (zbxmfzrxm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zbxmfzrxm);
		}

		if (zbxmfzrzjh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zbxmfzrzjh);
		}

		if (zbxmfzrzjlx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zbxmfzrzjlx);
		}

		if (zbxmfzrqrsj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zbxmfzrqrsj);
		}

		if (sflsjzbs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sflsjzbs);
		}

		if (sjbs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjbs);
		}

		if (yxbs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yxbs);
		}

		if (sfyjngz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfyjngz);
		}

		if (sfsszpjz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfsszpjz);
		}

		if (zczxjgdmz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zczxjgdmz);
		}

		if (ischeckxmbm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ischeckxmbm);
		}

		if (zddtmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zddtmj);
		}

		if (sjjdYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjjdYn);
		}

		if (sgjdYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgjdYn);
		}

		if (yxjdYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yxjdYn);
		}

		if (tdhtqdbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tdhtqdbh);
		}

		if (tdhtqdrq == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tdhtqdrq);
		}

		if (dkbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dkbh);
		}

		if (zpsjzlsbl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zpsjzlsbl);
		}

		if (zpsjzmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zpsjzmj);
		}

		if (dwyzzpl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dwyzzpl);
		}

		if (zdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zdh);
		}

		if (sfgdcg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfgdcg);
		}

		if (ptlhmj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ptlhmj);
		}

		if (bimjszxfy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bimjszxfy);
		}

		if (bz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bz);
		}

		if (sfzcxm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfzcxm);
		}

		if (zcxmbm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zcxmbm);
		}

		if (sfzmqxm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfzmqxm);
		}

		if (printPDFTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(printPDFTime);
		}

		if (isBgPrint == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isBgPrint);
		}
	}

	public String bjbh;
	public long bjrq;
	public String jsdw;
	public String jsdwxz;
	public String jsdwdz;
	public String jsdwdh;
	public String jsdwfr;
	public String jsdwlxr;
	public String jsdwyb;
	public String jsdwzczj;
	public String xmmc;
	public String jsdd;
	public String lxwj;
	public String lxwh;
	public String lxjb;
	public String pzjg;
	public String pzrq;
	public String ztz;
	public String sbtz;
	public String jsxz;
	public String jsgm;
	public String zmj;
	public String kgrq;
	public String xmxz;
	public String cjqk;
	public String smqk;
	public String bjbz;
	public String fbzgsc;
	public String cardid;
	public String zjlygc_1;
	public String zjlygc_2;
	public String zjlygc_3;
	public String zjlygc_4;
	public String zjlygc_5;
	public String zjlygc_6;
	public String zjlygc_7;
	public String zjlygc_8;
	public String zjlygc_9;
	public String jgxs;
	public String xmfl;
	public String jzmq;
	public String ywdt;
	public String dxsck;
	public String bhjz;
	public String fjms;
	public String sfsbxm;
	public String hzyj;
	public String bj_sx;
	public String bj_webid;
	public String bjwcbj;
	public String bmdm;
	public String jbr;
	public String shr;
	public String shbmdm;
	public String wcbjsj;
	public String old_bjbh;
	public String sffb;
	public String timeflag;
	public String jbrdm;
	public String shrdm;
	public String jsbh;
	public String needSbjl;
	public String wcSbjl;
	public String sfgyzbkg;
	public String jyzxfbxx;
	public String sgGkzbfb;
	public String sgjlGkzbfb;
	public String fxglxm;
	public String fxglxmJbr;
	public String fxglxmJbrdm;
	public String fxglxmJbrq;
	public String jsdwjgdm;
	public String szqy;
	public String ywxjfwjz;
	public String ywgbfwjg;
	public String gczh;
	public String zdcyyn;
	public String lxfl;
	public String ms1;
	public String ms2;
	public String ms3;
	public String zdxmyn;
	public String dxjzsq;
	public String ywjzxzz;
	public String fgwjhm;
	public String zzbl;
	public String ChangeTime;
	public String PD_SW;
	public String bmpfrq;
	public String bmpfwh;
	public String bmpfwj;
	public String CertificateKey;
	public String dsjzmj;
	public String dxjzmj;
	public String gdzctzbh;
	public String jsxz_2011;
	public String lhmj;
	public String lxjb_2011;
	public String mfmj;
	public String other_qx;
	public String ProjectSlyj;
	public String qxbz;
	public String sfcysjkfq;
	public String sfmfss;
	public String szqx;
	public String tsgs;
	public String xmfl_2011;
	public String xsjpw;
	public String xsjpzdw;
	public String zjlygc_10;
	public String zjlygc_11;
	public String zjlygc_xs_1;
	public String zjlygc_xs_2;
	public String zjlygc_xs_3;
	public String zjlygc_xs_4;
	public String zjlygc_1_2;
	public String zjlygc_1_2_4;
	public String ywptlh;
	public String gyyqbh;
	public String sfcyxm;
	public String zbxmfzrxm;
	public String zbxmfzrzjh;
	public String zbxmfzrzjlx;
	public String zbxmfzrqrsj;
	public String sflsjzbs;
	public String sjbs;
	public String yxbs;
	public String sfyjngz;
	public String sfsszpjz;
	public String zczxjgdmz;
	public String ischeckxmbm;
	public String zddtmj;
	public String sjjdYn;
	public String sgjdYn;
	public String yxjdYn;
	public String tdhtqdbh;
	public String tdhtqdrq;
	public String dkbh;
	public String zpsjzlsbl;
	public String zpsjzmj;
	public String dwyzzpl;
	public String zdh;
	public String sfgdcg;
	public String ptlhmj;
	public String bimjszxfy;
	public String bz;
	public String sfzcxm;
	public String zcxmbm;
	public String sfzmqxm;
	public String printPDFTime;
	public String isBgPrint;
}