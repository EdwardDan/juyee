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

package com.justonetech.cp.project.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author fanqi
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
	public ProjectWrapper(Project project) {
		_project = project;
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bjbh", getBjbh());
		attributes.put("bjrq", getBjrq());
		attributes.put("jsdw", getJsdw());
		attributes.put("jsdwxz", getJsdwxz());
		attributes.put("jsdwdz", getJsdwdz());
		attributes.put("jsdwdh", getJsdwdh());
		attributes.put("jsdwfr", getJsdwfr());
		attributes.put("jsdwlxr", getJsdwlxr());
		attributes.put("jsdwyb", getJsdwyb());
		attributes.put("jsdwzczj", getJsdwzczj());
		attributes.put("xmmc", getXmmc());
		attributes.put("jsdd", getJsdd());
		attributes.put("lxwj", getLxwj());
		attributes.put("lxwh", getLxwh());
		attributes.put("lxjb", getLxjb());
		attributes.put("pzjg", getPzjg());
		attributes.put("pzrq", getPzrq());
		attributes.put("ztz", getZtz());
		attributes.put("sbtz", getSbtz());
		attributes.put("jsxz", getJsxz());
		attributes.put("jsgm", getJsgm());
		attributes.put("zmj", getZmj());
		attributes.put("kgrq", getKgrq());
		attributes.put("xmxz", getXmxz());
		attributes.put("cjqk", getCjqk());
		attributes.put("smqk", getSmqk());
		attributes.put("bjbz", getBjbz());
		attributes.put("fbzgsc", getFbzgsc());
		attributes.put("cardid", getCardid());
		attributes.put("zjlygc_1", getZjlygc_1());
		attributes.put("zjlygc_2", getZjlygc_2());
		attributes.put("zjlygc_3", getZjlygc_3());
		attributes.put("zjlygc_4", getZjlygc_4());
		attributes.put("zjlygc_5", getZjlygc_5());
		attributes.put("zjlygc_6", getZjlygc_6());
		attributes.put("zjlygc_7", getZjlygc_7());
		attributes.put("zjlygc_8", getZjlygc_8());
		attributes.put("zjlygc_9", getZjlygc_9());
		attributes.put("jgxs", getJgxs());
		attributes.put("xmfl", getXmfl());
		attributes.put("jzmq", getJzmq());
		attributes.put("ywdt", getYwdt());
		attributes.put("dxsck", getDxsck());
		attributes.put("bhjz", getBhjz());
		attributes.put("fjms", getFjms());
		attributes.put("sfsbxm", getSfsbxm());
		attributes.put("hzyj", getHzyj());
		attributes.put("bj_sx", getBj_sx());
		attributes.put("bj_webid", getBj_webid());
		attributes.put("bjwcbj", getBjwcbj());
		attributes.put("bmdm", getBmdm());
		attributes.put("jbr", getJbr());
		attributes.put("shr", getShr());
		attributes.put("shbmdm", getShbmdm());
		attributes.put("wcbjsj", getWcbjsj());
		attributes.put("old_bjbh", getOld_bjbh());
		attributes.put("sffb", getSffb());
		attributes.put("timeflag", getTimeflag());
		attributes.put("jbrdm", getJbrdm());
		attributes.put("shrdm", getShrdm());
		attributes.put("jsbh", getJsbh());
		attributes.put("needSbjl", getNeedSbjl());
		attributes.put("wcSbjl", getWcSbjl());
		attributes.put("sfgyzbkg", getSfgyzbkg());
		attributes.put("jyzxfbxx", getJyzxfbxx());
		attributes.put("sgGkzbfb", getSgGkzbfb());
		attributes.put("sgjlGkzbfb", getSgjlGkzbfb());
		attributes.put("fxglxm", getFxglxm());
		attributes.put("fxglxmJbr", getFxglxmJbr());
		attributes.put("fxglxmJbrdm", getFxglxmJbrdm());
		attributes.put("fxglxmJbrq", getFxglxmJbrq());
		attributes.put("jsdwjgdm", getJsdwjgdm());
		attributes.put("szqy", getSzqy());
		attributes.put("ywxjfwjz", getYwxjfwjz());
		attributes.put("ywgbfwjg", getYwgbfwjg());
		attributes.put("gczh", getGczh());
		attributes.put("zdcyyn", getZdcyyn());
		attributes.put("lxfl", getLxfl());
		attributes.put("ms1", getMs1());
		attributes.put("ms2", getMs2());
		attributes.put("ms3", getMs3());
		attributes.put("zdxmyn", getZdxmyn());
		attributes.put("dxjzsq", getDxjzsq());
		attributes.put("ywjzxzz", getYwjzxzz());
		attributes.put("fgwjhm", getFgwjhm());
		attributes.put("zzbl", getZzbl());
		attributes.put("ChangeTime", getChangeTime());
		attributes.put("PD_SW", getPD_SW());
		attributes.put("bmpfrq", getBmpfrq());
		attributes.put("bmpfwh", getBmpfwh());
		attributes.put("bmpfwj", getBmpfwj());
		attributes.put("CertificateKey", getCertificateKey());
		attributes.put("dsjzmj", getDsjzmj());
		attributes.put("dxjzmj", getDxjzmj());
		attributes.put("gdzctzbh", getGdzctzbh());
		attributes.put("jsxz_2011", getJsxz_2011());
		attributes.put("lhmj", getLhmj());
		attributes.put("lxjb_2011", getLxjb_2011());
		attributes.put("mfmj", getMfmj());
		attributes.put("other_qx", getOther_qx());
		attributes.put("ProjectSlyj", getProjectSlyj());
		attributes.put("qxbz", getQxbz());
		attributes.put("sfcysjkfq", getSfcysjkfq());
		attributes.put("sfmfss", getSfmfss());
		attributes.put("szqx", getSzqx());
		attributes.put("tsgs", getTsgs());
		attributes.put("xmfl_2011", getXmfl_2011());
		attributes.put("xsjpw", getXsjpw());
		attributes.put("xsjpzdw", getXsjpzdw());
		attributes.put("zjlygc_10", getZjlygc_10());
		attributes.put("zjlygc_11", getZjlygc_11());
		attributes.put("zjlygc_xs_1", getZjlygc_xs_1());
		attributes.put("zjlygc_xs_2", getZjlygc_xs_2());
		attributes.put("zjlygc_xs_3", getZjlygc_xs_3());
		attributes.put("zjlygc_xs_4", getZjlygc_xs_4());
		attributes.put("zjlygc_1_2", getZjlygc_1_2());
		attributes.put("zjlygc_1_2_4", getZjlygc_1_2_4());
		attributes.put("ywptlh", getYwptlh());
		attributes.put("gyyqbh", getGyyqbh());
		attributes.put("sfcyxm", getSfcyxm());
		attributes.put("zbxmfzrxm", getZbxmfzrxm());
		attributes.put("zbxmfzrzjh", getZbxmfzrzjh());
		attributes.put("zbxmfzrzjlx", getZbxmfzrzjlx());
		attributes.put("zbxmfzrqrsj", getZbxmfzrqrsj());
		attributes.put("sflsjzbs", getSflsjzbs());
		attributes.put("sjbs", getSjbs());
		attributes.put("yxbs", getYxbs());
		attributes.put("sfyjngz", getSfyjngz());
		attributes.put("sfsszpjz", getSfsszpjz());
		attributes.put("zczxjgdmz", getZczxjgdmz());
		attributes.put("ischeckxmbm", getIscheckxmbm());
		attributes.put("zddtmj", getZddtmj());
		attributes.put("sjjdYn", getSjjdYn());
		attributes.put("sgjdYn", getSgjdYn());
		attributes.put("yxjdYn", getYxjdYn());
		attributes.put("tdhtqdbh", getTdhtqdbh());
		attributes.put("tdhtqdrq", getTdhtqdrq());
		attributes.put("dkbh", getDkbh());
		attributes.put("zpsjzlsbl", getZpsjzlsbl());
		attributes.put("zpsjzmj", getZpsjzmj());
		attributes.put("dwyzzpl", getDwyzzpl());
		attributes.put("zdh", getZdh());
		attributes.put("sfgdcg", getSfgdcg());
		attributes.put("ptlhmj", getPtlhmj());
		attributes.put("bimjszxfy", getBimjszxfy());
		attributes.put("bz", getBz());
		attributes.put("sfzcxm", getSfzcxm());
		attributes.put("zcxmbm", getZcxmbm());
		attributes.put("sfzmqxm", getSfzmqxm());
		attributes.put("printPDFTime", getPrintPDFTime());
		attributes.put("isBgPrint", getIsBgPrint());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		Date bjrq = (Date)attributes.get("bjrq");

		if (bjrq != null) {
			setBjrq(bjrq);
		}

		String jsdw = (String)attributes.get("jsdw");

		if (jsdw != null) {
			setJsdw(jsdw);
		}

		String jsdwxz = (String)attributes.get("jsdwxz");

		if (jsdwxz != null) {
			setJsdwxz(jsdwxz);
		}

		String jsdwdz = (String)attributes.get("jsdwdz");

		if (jsdwdz != null) {
			setJsdwdz(jsdwdz);
		}

		String jsdwdh = (String)attributes.get("jsdwdh");

		if (jsdwdh != null) {
			setJsdwdh(jsdwdh);
		}

		String jsdwfr = (String)attributes.get("jsdwfr");

		if (jsdwfr != null) {
			setJsdwfr(jsdwfr);
		}

		String jsdwlxr = (String)attributes.get("jsdwlxr");

		if (jsdwlxr != null) {
			setJsdwlxr(jsdwlxr);
		}

		String jsdwyb = (String)attributes.get("jsdwyb");

		if (jsdwyb != null) {
			setJsdwyb(jsdwyb);
		}

		String jsdwzczj = (String)attributes.get("jsdwzczj");

		if (jsdwzczj != null) {
			setJsdwzczj(jsdwzczj);
		}

		String xmmc = (String)attributes.get("xmmc");

		if (xmmc != null) {
			setXmmc(xmmc);
		}

		String jsdd = (String)attributes.get("jsdd");

		if (jsdd != null) {
			setJsdd(jsdd);
		}

		String lxwj = (String)attributes.get("lxwj");

		if (lxwj != null) {
			setLxwj(lxwj);
		}

		String lxwh = (String)attributes.get("lxwh");

		if (lxwh != null) {
			setLxwh(lxwh);
		}

		String lxjb = (String)attributes.get("lxjb");

		if (lxjb != null) {
			setLxjb(lxjb);
		}

		String pzjg = (String)attributes.get("pzjg");

		if (pzjg != null) {
			setPzjg(pzjg);
		}

		String pzrq = (String)attributes.get("pzrq");

		if (pzrq != null) {
			setPzrq(pzrq);
		}

		String ztz = (String)attributes.get("ztz");

		if (ztz != null) {
			setZtz(ztz);
		}

		String sbtz = (String)attributes.get("sbtz");

		if (sbtz != null) {
			setSbtz(sbtz);
		}

		String jsxz = (String)attributes.get("jsxz");

		if (jsxz != null) {
			setJsxz(jsxz);
		}

		String jsgm = (String)attributes.get("jsgm");

		if (jsgm != null) {
			setJsgm(jsgm);
		}

		String zmj = (String)attributes.get("zmj");

		if (zmj != null) {
			setZmj(zmj);
		}

		String kgrq = (String)attributes.get("kgrq");

		if (kgrq != null) {
			setKgrq(kgrq);
		}

		String xmxz = (String)attributes.get("xmxz");

		if (xmxz != null) {
			setXmxz(xmxz);
		}

		String cjqk = (String)attributes.get("cjqk");

		if (cjqk != null) {
			setCjqk(cjqk);
		}

		String smqk = (String)attributes.get("smqk");

		if (smqk != null) {
			setSmqk(smqk);
		}

		String bjbz = (String)attributes.get("bjbz");

		if (bjbz != null) {
			setBjbz(bjbz);
		}

		String fbzgsc = (String)attributes.get("fbzgsc");

		if (fbzgsc != null) {
			setFbzgsc(fbzgsc);
		}

		String cardid = (String)attributes.get("cardid");

		if (cardid != null) {
			setCardid(cardid);
		}

		String zjlygc_1 = (String)attributes.get("zjlygc_1");

		if (zjlygc_1 != null) {
			setZjlygc_1(zjlygc_1);
		}

		String zjlygc_2 = (String)attributes.get("zjlygc_2");

		if (zjlygc_2 != null) {
			setZjlygc_2(zjlygc_2);
		}

		String zjlygc_3 = (String)attributes.get("zjlygc_3");

		if (zjlygc_3 != null) {
			setZjlygc_3(zjlygc_3);
		}

		String zjlygc_4 = (String)attributes.get("zjlygc_4");

		if (zjlygc_4 != null) {
			setZjlygc_4(zjlygc_4);
		}

		String zjlygc_5 = (String)attributes.get("zjlygc_5");

		if (zjlygc_5 != null) {
			setZjlygc_5(zjlygc_5);
		}

		String zjlygc_6 = (String)attributes.get("zjlygc_6");

		if (zjlygc_6 != null) {
			setZjlygc_6(zjlygc_6);
		}

		String zjlygc_7 = (String)attributes.get("zjlygc_7");

		if (zjlygc_7 != null) {
			setZjlygc_7(zjlygc_7);
		}

		String zjlygc_8 = (String)attributes.get("zjlygc_8");

		if (zjlygc_8 != null) {
			setZjlygc_8(zjlygc_8);
		}

		String zjlygc_9 = (String)attributes.get("zjlygc_9");

		if (zjlygc_9 != null) {
			setZjlygc_9(zjlygc_9);
		}

		String jgxs = (String)attributes.get("jgxs");

		if (jgxs != null) {
			setJgxs(jgxs);
		}

		String xmfl = (String)attributes.get("xmfl");

		if (xmfl != null) {
			setXmfl(xmfl);
		}

		String jzmq = (String)attributes.get("jzmq");

		if (jzmq != null) {
			setJzmq(jzmq);
		}

		String ywdt = (String)attributes.get("ywdt");

		if (ywdt != null) {
			setYwdt(ywdt);
		}

		String dxsck = (String)attributes.get("dxsck");

		if (dxsck != null) {
			setDxsck(dxsck);
		}

		String bhjz = (String)attributes.get("bhjz");

		if (bhjz != null) {
			setBhjz(bhjz);
		}

		String fjms = (String)attributes.get("fjms");

		if (fjms != null) {
			setFjms(fjms);
		}

		String sfsbxm = (String)attributes.get("sfsbxm");

		if (sfsbxm != null) {
			setSfsbxm(sfsbxm);
		}

		String hzyj = (String)attributes.get("hzyj");

		if (hzyj != null) {
			setHzyj(hzyj);
		}

		String bj_sx = (String)attributes.get("bj_sx");

		if (bj_sx != null) {
			setBj_sx(bj_sx);
		}

		String bj_webid = (String)attributes.get("bj_webid");

		if (bj_webid != null) {
			setBj_webid(bj_webid);
		}

		String bjwcbj = (String)attributes.get("bjwcbj");

		if (bjwcbj != null) {
			setBjwcbj(bjwcbj);
		}

		String bmdm = (String)attributes.get("bmdm");

		if (bmdm != null) {
			setBmdm(bmdm);
		}

		String jbr = (String)attributes.get("jbr");

		if (jbr != null) {
			setJbr(jbr);
		}

		String shr = (String)attributes.get("shr");

		if (shr != null) {
			setShr(shr);
		}

		String shbmdm = (String)attributes.get("shbmdm");

		if (shbmdm != null) {
			setShbmdm(shbmdm);
		}

		String wcbjsj = (String)attributes.get("wcbjsj");

		if (wcbjsj != null) {
			setWcbjsj(wcbjsj);
		}

		String old_bjbh = (String)attributes.get("old_bjbh");

		if (old_bjbh != null) {
			setOld_bjbh(old_bjbh);
		}

		String sffb = (String)attributes.get("sffb");

		if (sffb != null) {
			setSffb(sffb);
		}

		String timeflag = (String)attributes.get("timeflag");

		if (timeflag != null) {
			setTimeflag(timeflag);
		}

		String jbrdm = (String)attributes.get("jbrdm");

		if (jbrdm != null) {
			setJbrdm(jbrdm);
		}

		String shrdm = (String)attributes.get("shrdm");

		if (shrdm != null) {
			setShrdm(shrdm);
		}

		String jsbh = (String)attributes.get("jsbh");

		if (jsbh != null) {
			setJsbh(jsbh);
		}

		String needSbjl = (String)attributes.get("needSbjl");

		if (needSbjl != null) {
			setNeedSbjl(needSbjl);
		}

		String wcSbjl = (String)attributes.get("wcSbjl");

		if (wcSbjl != null) {
			setWcSbjl(wcSbjl);
		}

		String sfgyzbkg = (String)attributes.get("sfgyzbkg");

		if (sfgyzbkg != null) {
			setSfgyzbkg(sfgyzbkg);
		}

		String jyzxfbxx = (String)attributes.get("jyzxfbxx");

		if (jyzxfbxx != null) {
			setJyzxfbxx(jyzxfbxx);
		}

		String sgGkzbfb = (String)attributes.get("sgGkzbfb");

		if (sgGkzbfb != null) {
			setSgGkzbfb(sgGkzbfb);
		}

		String sgjlGkzbfb = (String)attributes.get("sgjlGkzbfb");

		if (sgjlGkzbfb != null) {
			setSgjlGkzbfb(sgjlGkzbfb);
		}

		String fxglxm = (String)attributes.get("fxglxm");

		if (fxglxm != null) {
			setFxglxm(fxglxm);
		}

		String fxglxmJbr = (String)attributes.get("fxglxmJbr");

		if (fxglxmJbr != null) {
			setFxglxmJbr(fxglxmJbr);
		}

		String fxglxmJbrdm = (String)attributes.get("fxglxmJbrdm");

		if (fxglxmJbrdm != null) {
			setFxglxmJbrdm(fxglxmJbrdm);
		}

		String fxglxmJbrq = (String)attributes.get("fxglxmJbrq");

		if (fxglxmJbrq != null) {
			setFxglxmJbrq(fxglxmJbrq);
		}

		String jsdwjgdm = (String)attributes.get("jsdwjgdm");

		if (jsdwjgdm != null) {
			setJsdwjgdm(jsdwjgdm);
		}

		String szqy = (String)attributes.get("szqy");

		if (szqy != null) {
			setSzqy(szqy);
		}

		String ywxjfwjz = (String)attributes.get("ywxjfwjz");

		if (ywxjfwjz != null) {
			setYwxjfwjz(ywxjfwjz);
		}

		String ywgbfwjg = (String)attributes.get("ywgbfwjg");

		if (ywgbfwjg != null) {
			setYwgbfwjg(ywgbfwjg);
		}

		String gczh = (String)attributes.get("gczh");

		if (gczh != null) {
			setGczh(gczh);
		}

		String zdcyyn = (String)attributes.get("zdcyyn");

		if (zdcyyn != null) {
			setZdcyyn(zdcyyn);
		}

		String lxfl = (String)attributes.get("lxfl");

		if (lxfl != null) {
			setLxfl(lxfl);
		}

		String ms1 = (String)attributes.get("ms1");

		if (ms1 != null) {
			setMs1(ms1);
		}

		String ms2 = (String)attributes.get("ms2");

		if (ms2 != null) {
			setMs2(ms2);
		}

		String ms3 = (String)attributes.get("ms3");

		if (ms3 != null) {
			setMs3(ms3);
		}

		String zdxmyn = (String)attributes.get("zdxmyn");

		if (zdxmyn != null) {
			setZdxmyn(zdxmyn);
		}

		String dxjzsq = (String)attributes.get("dxjzsq");

		if (dxjzsq != null) {
			setDxjzsq(dxjzsq);
		}

		String ywjzxzz = (String)attributes.get("ywjzxzz");

		if (ywjzxzz != null) {
			setYwjzxzz(ywjzxzz);
		}

		String fgwjhm = (String)attributes.get("fgwjhm");

		if (fgwjhm != null) {
			setFgwjhm(fgwjhm);
		}

		String zzbl = (String)attributes.get("zzbl");

		if (zzbl != null) {
			setZzbl(zzbl);
		}

		String ChangeTime = (String)attributes.get("ChangeTime");

		if (ChangeTime != null) {
			setChangeTime(ChangeTime);
		}

		String PD_SW = (String)attributes.get("PD_SW");

		if (PD_SW != null) {
			setPD_SW(PD_SW);
		}

		String bmpfrq = (String)attributes.get("bmpfrq");

		if (bmpfrq != null) {
			setBmpfrq(bmpfrq);
		}

		String bmpfwh = (String)attributes.get("bmpfwh");

		if (bmpfwh != null) {
			setBmpfwh(bmpfwh);
		}

		String bmpfwj = (String)attributes.get("bmpfwj");

		if (bmpfwj != null) {
			setBmpfwj(bmpfwj);
		}

		String CertificateKey = (String)attributes.get("CertificateKey");

		if (CertificateKey != null) {
			setCertificateKey(CertificateKey);
		}

		String dsjzmj = (String)attributes.get("dsjzmj");

		if (dsjzmj != null) {
			setDsjzmj(dsjzmj);
		}

		String dxjzmj = (String)attributes.get("dxjzmj");

		if (dxjzmj != null) {
			setDxjzmj(dxjzmj);
		}

		String gdzctzbh = (String)attributes.get("gdzctzbh");

		if (gdzctzbh != null) {
			setGdzctzbh(gdzctzbh);
		}

		String jsxz_2011 = (String)attributes.get("jsxz_2011");

		if (jsxz_2011 != null) {
			setJsxz_2011(jsxz_2011);
		}

		String lhmj = (String)attributes.get("lhmj");

		if (lhmj != null) {
			setLhmj(lhmj);
		}

		String lxjb_2011 = (String)attributes.get("lxjb_2011");

		if (lxjb_2011 != null) {
			setLxjb_2011(lxjb_2011);
		}

		String mfmj = (String)attributes.get("mfmj");

		if (mfmj != null) {
			setMfmj(mfmj);
		}

		String other_qx = (String)attributes.get("other_qx");

		if (other_qx != null) {
			setOther_qx(other_qx);
		}

		String ProjectSlyj = (String)attributes.get("ProjectSlyj");

		if (ProjectSlyj != null) {
			setProjectSlyj(ProjectSlyj);
		}

		String qxbz = (String)attributes.get("qxbz");

		if (qxbz != null) {
			setQxbz(qxbz);
		}

		String sfcysjkfq = (String)attributes.get("sfcysjkfq");

		if (sfcysjkfq != null) {
			setSfcysjkfq(sfcysjkfq);
		}

		String sfmfss = (String)attributes.get("sfmfss");

		if (sfmfss != null) {
			setSfmfss(sfmfss);
		}

		String szqx = (String)attributes.get("szqx");

		if (szqx != null) {
			setSzqx(szqx);
		}

		String tsgs = (String)attributes.get("tsgs");

		if (tsgs != null) {
			setTsgs(tsgs);
		}

		String xmfl_2011 = (String)attributes.get("xmfl_2011");

		if (xmfl_2011 != null) {
			setXmfl_2011(xmfl_2011);
		}

		String xsjpw = (String)attributes.get("xsjpw");

		if (xsjpw != null) {
			setXsjpw(xsjpw);
		}

		String xsjpzdw = (String)attributes.get("xsjpzdw");

		if (xsjpzdw != null) {
			setXsjpzdw(xsjpzdw);
		}

		String zjlygc_10 = (String)attributes.get("zjlygc_10");

		if (zjlygc_10 != null) {
			setZjlygc_10(zjlygc_10);
		}

		String zjlygc_11 = (String)attributes.get("zjlygc_11");

		if (zjlygc_11 != null) {
			setZjlygc_11(zjlygc_11);
		}

		String zjlygc_xs_1 = (String)attributes.get("zjlygc_xs_1");

		if (zjlygc_xs_1 != null) {
			setZjlygc_xs_1(zjlygc_xs_1);
		}

		String zjlygc_xs_2 = (String)attributes.get("zjlygc_xs_2");

		if (zjlygc_xs_2 != null) {
			setZjlygc_xs_2(zjlygc_xs_2);
		}

		String zjlygc_xs_3 = (String)attributes.get("zjlygc_xs_3");

		if (zjlygc_xs_3 != null) {
			setZjlygc_xs_3(zjlygc_xs_3);
		}

		String zjlygc_xs_4 = (String)attributes.get("zjlygc_xs_4");

		if (zjlygc_xs_4 != null) {
			setZjlygc_xs_4(zjlygc_xs_4);
		}

		String zjlygc_1_2 = (String)attributes.get("zjlygc_1_2");

		if (zjlygc_1_2 != null) {
			setZjlygc_1_2(zjlygc_1_2);
		}

		String zjlygc_1_2_4 = (String)attributes.get("zjlygc_1_2_4");

		if (zjlygc_1_2_4 != null) {
			setZjlygc_1_2_4(zjlygc_1_2_4);
		}

		String ywptlh = (String)attributes.get("ywptlh");

		if (ywptlh != null) {
			setYwptlh(ywptlh);
		}

		String gyyqbh = (String)attributes.get("gyyqbh");

		if (gyyqbh != null) {
			setGyyqbh(gyyqbh);
		}

		String sfcyxm = (String)attributes.get("sfcyxm");

		if (sfcyxm != null) {
			setSfcyxm(sfcyxm);
		}

		String zbxmfzrxm = (String)attributes.get("zbxmfzrxm");

		if (zbxmfzrxm != null) {
			setZbxmfzrxm(zbxmfzrxm);
		}

		String zbxmfzrzjh = (String)attributes.get("zbxmfzrzjh");

		if (zbxmfzrzjh != null) {
			setZbxmfzrzjh(zbxmfzrzjh);
		}

		String zbxmfzrzjlx = (String)attributes.get("zbxmfzrzjlx");

		if (zbxmfzrzjlx != null) {
			setZbxmfzrzjlx(zbxmfzrzjlx);
		}

		String zbxmfzrqrsj = (String)attributes.get("zbxmfzrqrsj");

		if (zbxmfzrqrsj != null) {
			setZbxmfzrqrsj(zbxmfzrqrsj);
		}

		String sflsjzbs = (String)attributes.get("sflsjzbs");

		if (sflsjzbs != null) {
			setSflsjzbs(sflsjzbs);
		}

		String sjbs = (String)attributes.get("sjbs");

		if (sjbs != null) {
			setSjbs(sjbs);
		}

		String yxbs = (String)attributes.get("yxbs");

		if (yxbs != null) {
			setYxbs(yxbs);
		}

		String sfyjngz = (String)attributes.get("sfyjngz");

		if (sfyjngz != null) {
			setSfyjngz(sfyjngz);
		}

		String sfsszpjz = (String)attributes.get("sfsszpjz");

		if (sfsszpjz != null) {
			setSfsszpjz(sfsszpjz);
		}

		String zczxjgdmz = (String)attributes.get("zczxjgdmz");

		if (zczxjgdmz != null) {
			setZczxjgdmz(zczxjgdmz);
		}

		String ischeckxmbm = (String)attributes.get("ischeckxmbm");

		if (ischeckxmbm != null) {
			setIscheckxmbm(ischeckxmbm);
		}

		String zddtmj = (String)attributes.get("zddtmj");

		if (zddtmj != null) {
			setZddtmj(zddtmj);
		}

		String sjjdYn = (String)attributes.get("sjjdYn");

		if (sjjdYn != null) {
			setSjjdYn(sjjdYn);
		}

		String sgjdYn = (String)attributes.get("sgjdYn");

		if (sgjdYn != null) {
			setSgjdYn(sgjdYn);
		}

		String yxjdYn = (String)attributes.get("yxjdYn");

		if (yxjdYn != null) {
			setYxjdYn(yxjdYn);
		}

		String tdhtqdbh = (String)attributes.get("tdhtqdbh");

		if (tdhtqdbh != null) {
			setTdhtqdbh(tdhtqdbh);
		}

		String tdhtqdrq = (String)attributes.get("tdhtqdrq");

		if (tdhtqdrq != null) {
			setTdhtqdrq(tdhtqdrq);
		}

		String dkbh = (String)attributes.get("dkbh");

		if (dkbh != null) {
			setDkbh(dkbh);
		}

		String zpsjzlsbl = (String)attributes.get("zpsjzlsbl");

		if (zpsjzlsbl != null) {
			setZpsjzlsbl(zpsjzlsbl);
		}

		String zpsjzmj = (String)attributes.get("zpsjzmj");

		if (zpsjzmj != null) {
			setZpsjzmj(zpsjzmj);
		}

		String dwyzzpl = (String)attributes.get("dwyzzpl");

		if (dwyzzpl != null) {
			setDwyzzpl(dwyzzpl);
		}

		String zdh = (String)attributes.get("zdh");

		if (zdh != null) {
			setZdh(zdh);
		}

		String sfgdcg = (String)attributes.get("sfgdcg");

		if (sfgdcg != null) {
			setSfgdcg(sfgdcg);
		}

		String ptlhmj = (String)attributes.get("ptlhmj");

		if (ptlhmj != null) {
			setPtlhmj(ptlhmj);
		}

		String bimjszxfy = (String)attributes.get("bimjszxfy");

		if (bimjszxfy != null) {
			setBimjszxfy(bimjszxfy);
		}

		String bz = (String)attributes.get("bz");

		if (bz != null) {
			setBz(bz);
		}

		String sfzcxm = (String)attributes.get("sfzcxm");

		if (sfzcxm != null) {
			setSfzcxm(sfzcxm);
		}

		String zcxmbm = (String)attributes.get("zcxmbm");

		if (zcxmbm != null) {
			setZcxmbm(zcxmbm);
		}

		String sfzmqxm = (String)attributes.get("sfzmqxm");

		if (sfzmqxm != null) {
			setSfzmqxm(sfzmqxm);
		}

		String printPDFTime = (String)attributes.get("printPDFTime");

		if (printPDFTime != null) {
			setPrintPDFTime(printPDFTime);
		}

		String isBgPrint = (String)attributes.get("isBgPrint");

		if (isBgPrint != null) {
			setIsBgPrint(isBgPrint);
		}
	}

	/**
	* Returns the primary key of this project.
	*
	* @return the primary key of this project
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _project.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project.
	*
	* @param primaryKey the primary key of this project
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_project.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bjbh of this project.
	*
	* @return the bjbh of this project
	*/
	@Override
	public java.lang.String getBjbh() {
		return _project.getBjbh();
	}

	/**
	* Sets the bjbh of this project.
	*
	* @param bjbh the bjbh of this project
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_project.setBjbh(bjbh);
	}

	/**
	* Returns the bjrq of this project.
	*
	* @return the bjrq of this project
	*/
	@Override
	public java.util.Date getBjrq() {
		return _project.getBjrq();
	}

	/**
	* Sets the bjrq of this project.
	*
	* @param bjrq the bjrq of this project
	*/
	@Override
	public void setBjrq(java.util.Date bjrq) {
		_project.setBjrq(bjrq);
	}

	/**
	* Returns the jsdw of this project.
	*
	* @return the jsdw of this project
	*/
	@Override
	public java.lang.String getJsdw() {
		return _project.getJsdw();
	}

	/**
	* Sets the jsdw of this project.
	*
	* @param jsdw the jsdw of this project
	*/
	@Override
	public void setJsdw(java.lang.String jsdw) {
		_project.setJsdw(jsdw);
	}

	/**
	* Returns the jsdwxz of this project.
	*
	* @return the jsdwxz of this project
	*/
	@Override
	public java.lang.String getJsdwxz() {
		return _project.getJsdwxz();
	}

	/**
	* Sets the jsdwxz of this project.
	*
	* @param jsdwxz the jsdwxz of this project
	*/
	@Override
	public void setJsdwxz(java.lang.String jsdwxz) {
		_project.setJsdwxz(jsdwxz);
	}

	/**
	* Returns the jsdwdz of this project.
	*
	* @return the jsdwdz of this project
	*/
	@Override
	public java.lang.String getJsdwdz() {
		return _project.getJsdwdz();
	}

	/**
	* Sets the jsdwdz of this project.
	*
	* @param jsdwdz the jsdwdz of this project
	*/
	@Override
	public void setJsdwdz(java.lang.String jsdwdz) {
		_project.setJsdwdz(jsdwdz);
	}

	/**
	* Returns the jsdwdh of this project.
	*
	* @return the jsdwdh of this project
	*/
	@Override
	public java.lang.String getJsdwdh() {
		return _project.getJsdwdh();
	}

	/**
	* Sets the jsdwdh of this project.
	*
	* @param jsdwdh the jsdwdh of this project
	*/
	@Override
	public void setJsdwdh(java.lang.String jsdwdh) {
		_project.setJsdwdh(jsdwdh);
	}

	/**
	* Returns the jsdwfr of this project.
	*
	* @return the jsdwfr of this project
	*/
	@Override
	public java.lang.String getJsdwfr() {
		return _project.getJsdwfr();
	}

	/**
	* Sets the jsdwfr of this project.
	*
	* @param jsdwfr the jsdwfr of this project
	*/
	@Override
	public void setJsdwfr(java.lang.String jsdwfr) {
		_project.setJsdwfr(jsdwfr);
	}

	/**
	* Returns the jsdwlxr of this project.
	*
	* @return the jsdwlxr of this project
	*/
	@Override
	public java.lang.String getJsdwlxr() {
		return _project.getJsdwlxr();
	}

	/**
	* Sets the jsdwlxr of this project.
	*
	* @param jsdwlxr the jsdwlxr of this project
	*/
	@Override
	public void setJsdwlxr(java.lang.String jsdwlxr) {
		_project.setJsdwlxr(jsdwlxr);
	}

	/**
	* Returns the jsdwyb of this project.
	*
	* @return the jsdwyb of this project
	*/
	@Override
	public java.lang.String getJsdwyb() {
		return _project.getJsdwyb();
	}

	/**
	* Sets the jsdwyb of this project.
	*
	* @param jsdwyb the jsdwyb of this project
	*/
	@Override
	public void setJsdwyb(java.lang.String jsdwyb) {
		_project.setJsdwyb(jsdwyb);
	}

	/**
	* Returns the jsdwzczj of this project.
	*
	* @return the jsdwzczj of this project
	*/
	@Override
	public java.lang.String getJsdwzczj() {
		return _project.getJsdwzczj();
	}

	/**
	* Sets the jsdwzczj of this project.
	*
	* @param jsdwzczj the jsdwzczj of this project
	*/
	@Override
	public void setJsdwzczj(java.lang.String jsdwzczj) {
		_project.setJsdwzczj(jsdwzczj);
	}

	/**
	* Returns the xmmc of this project.
	*
	* @return the xmmc of this project
	*/
	@Override
	public java.lang.String getXmmc() {
		return _project.getXmmc();
	}

	/**
	* Sets the xmmc of this project.
	*
	* @param xmmc the xmmc of this project
	*/
	@Override
	public void setXmmc(java.lang.String xmmc) {
		_project.setXmmc(xmmc);
	}

	/**
	* Returns the jsdd of this project.
	*
	* @return the jsdd of this project
	*/
	@Override
	public java.lang.String getJsdd() {
		return _project.getJsdd();
	}

	/**
	* Sets the jsdd of this project.
	*
	* @param jsdd the jsdd of this project
	*/
	@Override
	public void setJsdd(java.lang.String jsdd) {
		_project.setJsdd(jsdd);
	}

	/**
	* Returns the lxwj of this project.
	*
	* @return the lxwj of this project
	*/
	@Override
	public java.lang.String getLxwj() {
		return _project.getLxwj();
	}

	/**
	* Sets the lxwj of this project.
	*
	* @param lxwj the lxwj of this project
	*/
	@Override
	public void setLxwj(java.lang.String lxwj) {
		_project.setLxwj(lxwj);
	}

	/**
	* Returns the lxwh of this project.
	*
	* @return the lxwh of this project
	*/
	@Override
	public java.lang.String getLxwh() {
		return _project.getLxwh();
	}

	/**
	* Sets the lxwh of this project.
	*
	* @param lxwh the lxwh of this project
	*/
	@Override
	public void setLxwh(java.lang.String lxwh) {
		_project.setLxwh(lxwh);
	}

	/**
	* Returns the lxjb of this project.
	*
	* @return the lxjb of this project
	*/
	@Override
	public java.lang.String getLxjb() {
		return _project.getLxjb();
	}

	/**
	* Sets the lxjb of this project.
	*
	* @param lxjb the lxjb of this project
	*/
	@Override
	public void setLxjb(java.lang.String lxjb) {
		_project.setLxjb(lxjb);
	}

	/**
	* Returns the pzjg of this project.
	*
	* @return the pzjg of this project
	*/
	@Override
	public java.lang.String getPzjg() {
		return _project.getPzjg();
	}

	/**
	* Sets the pzjg of this project.
	*
	* @param pzjg the pzjg of this project
	*/
	@Override
	public void setPzjg(java.lang.String pzjg) {
		_project.setPzjg(pzjg);
	}

	/**
	* Returns the pzrq of this project.
	*
	* @return the pzrq of this project
	*/
	@Override
	public java.lang.String getPzrq() {
		return _project.getPzrq();
	}

	/**
	* Sets the pzrq of this project.
	*
	* @param pzrq the pzrq of this project
	*/
	@Override
	public void setPzrq(java.lang.String pzrq) {
		_project.setPzrq(pzrq);
	}

	/**
	* Returns the ztz of this project.
	*
	* @return the ztz of this project
	*/
	@Override
	public java.lang.String getZtz() {
		return _project.getZtz();
	}

	/**
	* Sets the ztz of this project.
	*
	* @param ztz the ztz of this project
	*/
	@Override
	public void setZtz(java.lang.String ztz) {
		_project.setZtz(ztz);
	}

	/**
	* Returns the sbtz of this project.
	*
	* @return the sbtz of this project
	*/
	@Override
	public java.lang.String getSbtz() {
		return _project.getSbtz();
	}

	/**
	* Sets the sbtz of this project.
	*
	* @param sbtz the sbtz of this project
	*/
	@Override
	public void setSbtz(java.lang.String sbtz) {
		_project.setSbtz(sbtz);
	}

	/**
	* Returns the jsxz of this project.
	*
	* @return the jsxz of this project
	*/
	@Override
	public java.lang.String getJsxz() {
		return _project.getJsxz();
	}

	/**
	* Sets the jsxz of this project.
	*
	* @param jsxz the jsxz of this project
	*/
	@Override
	public void setJsxz(java.lang.String jsxz) {
		_project.setJsxz(jsxz);
	}

	/**
	* Returns the jsgm of this project.
	*
	* @return the jsgm of this project
	*/
	@Override
	public java.lang.String getJsgm() {
		return _project.getJsgm();
	}

	/**
	* Sets the jsgm of this project.
	*
	* @param jsgm the jsgm of this project
	*/
	@Override
	public void setJsgm(java.lang.String jsgm) {
		_project.setJsgm(jsgm);
	}

	/**
	* Returns the zmj of this project.
	*
	* @return the zmj of this project
	*/
	@Override
	public java.lang.String getZmj() {
		return _project.getZmj();
	}

	/**
	* Sets the zmj of this project.
	*
	* @param zmj the zmj of this project
	*/
	@Override
	public void setZmj(java.lang.String zmj) {
		_project.setZmj(zmj);
	}

	/**
	* Returns the kgrq of this project.
	*
	* @return the kgrq of this project
	*/
	@Override
	public java.lang.String getKgrq() {
		return _project.getKgrq();
	}

	/**
	* Sets the kgrq of this project.
	*
	* @param kgrq the kgrq of this project
	*/
	@Override
	public void setKgrq(java.lang.String kgrq) {
		_project.setKgrq(kgrq);
	}

	/**
	* Returns the xmxz of this project.
	*
	* @return the xmxz of this project
	*/
	@Override
	public java.lang.String getXmxz() {
		return _project.getXmxz();
	}

	/**
	* Sets the xmxz of this project.
	*
	* @param xmxz the xmxz of this project
	*/
	@Override
	public void setXmxz(java.lang.String xmxz) {
		_project.setXmxz(xmxz);
	}

	/**
	* Returns the cjqk of this project.
	*
	* @return the cjqk of this project
	*/
	@Override
	public java.lang.String getCjqk() {
		return _project.getCjqk();
	}

	/**
	* Sets the cjqk of this project.
	*
	* @param cjqk the cjqk of this project
	*/
	@Override
	public void setCjqk(java.lang.String cjqk) {
		_project.setCjqk(cjqk);
	}

	/**
	* Returns the smqk of this project.
	*
	* @return the smqk of this project
	*/
	@Override
	public java.lang.String getSmqk() {
		return _project.getSmqk();
	}

	/**
	* Sets the smqk of this project.
	*
	* @param smqk the smqk of this project
	*/
	@Override
	public void setSmqk(java.lang.String smqk) {
		_project.setSmqk(smqk);
	}

	/**
	* Returns the bjbz of this project.
	*
	* @return the bjbz of this project
	*/
	@Override
	public java.lang.String getBjbz() {
		return _project.getBjbz();
	}

	/**
	* Sets the bjbz of this project.
	*
	* @param bjbz the bjbz of this project
	*/
	@Override
	public void setBjbz(java.lang.String bjbz) {
		_project.setBjbz(bjbz);
	}

	/**
	* Returns the fbzgsc of this project.
	*
	* @return the fbzgsc of this project
	*/
	@Override
	public java.lang.String getFbzgsc() {
		return _project.getFbzgsc();
	}

	/**
	* Sets the fbzgsc of this project.
	*
	* @param fbzgsc the fbzgsc of this project
	*/
	@Override
	public void setFbzgsc(java.lang.String fbzgsc) {
		_project.setFbzgsc(fbzgsc);
	}

	/**
	* Returns the cardid of this project.
	*
	* @return the cardid of this project
	*/
	@Override
	public java.lang.String getCardid() {
		return _project.getCardid();
	}

	/**
	* Sets the cardid of this project.
	*
	* @param cardid the cardid of this project
	*/
	@Override
	public void setCardid(java.lang.String cardid) {
		_project.setCardid(cardid);
	}

	/**
	* Returns the zjlygc_1 of this project.
	*
	* @return the zjlygc_1 of this project
	*/
	@Override
	public java.lang.String getZjlygc_1() {
		return _project.getZjlygc_1();
	}

	/**
	* Sets the zjlygc_1 of this project.
	*
	* @param zjlygc_1 the zjlygc_1 of this project
	*/
	@Override
	public void setZjlygc_1(java.lang.String zjlygc_1) {
		_project.setZjlygc_1(zjlygc_1);
	}

	/**
	* Returns the zjlygc_2 of this project.
	*
	* @return the zjlygc_2 of this project
	*/
	@Override
	public java.lang.String getZjlygc_2() {
		return _project.getZjlygc_2();
	}

	/**
	* Sets the zjlygc_2 of this project.
	*
	* @param zjlygc_2 the zjlygc_2 of this project
	*/
	@Override
	public void setZjlygc_2(java.lang.String zjlygc_2) {
		_project.setZjlygc_2(zjlygc_2);
	}

	/**
	* Returns the zjlygc_3 of this project.
	*
	* @return the zjlygc_3 of this project
	*/
	@Override
	public java.lang.String getZjlygc_3() {
		return _project.getZjlygc_3();
	}

	/**
	* Sets the zjlygc_3 of this project.
	*
	* @param zjlygc_3 the zjlygc_3 of this project
	*/
	@Override
	public void setZjlygc_3(java.lang.String zjlygc_3) {
		_project.setZjlygc_3(zjlygc_3);
	}

	/**
	* Returns the zjlygc_4 of this project.
	*
	* @return the zjlygc_4 of this project
	*/
	@Override
	public java.lang.String getZjlygc_4() {
		return _project.getZjlygc_4();
	}

	/**
	* Sets the zjlygc_4 of this project.
	*
	* @param zjlygc_4 the zjlygc_4 of this project
	*/
	@Override
	public void setZjlygc_4(java.lang.String zjlygc_4) {
		_project.setZjlygc_4(zjlygc_4);
	}

	/**
	* Returns the zjlygc_5 of this project.
	*
	* @return the zjlygc_5 of this project
	*/
	@Override
	public java.lang.String getZjlygc_5() {
		return _project.getZjlygc_5();
	}

	/**
	* Sets the zjlygc_5 of this project.
	*
	* @param zjlygc_5 the zjlygc_5 of this project
	*/
	@Override
	public void setZjlygc_5(java.lang.String zjlygc_5) {
		_project.setZjlygc_5(zjlygc_5);
	}

	/**
	* Returns the zjlygc_6 of this project.
	*
	* @return the zjlygc_6 of this project
	*/
	@Override
	public java.lang.String getZjlygc_6() {
		return _project.getZjlygc_6();
	}

	/**
	* Sets the zjlygc_6 of this project.
	*
	* @param zjlygc_6 the zjlygc_6 of this project
	*/
	@Override
	public void setZjlygc_6(java.lang.String zjlygc_6) {
		_project.setZjlygc_6(zjlygc_6);
	}

	/**
	* Returns the zjlygc_7 of this project.
	*
	* @return the zjlygc_7 of this project
	*/
	@Override
	public java.lang.String getZjlygc_7() {
		return _project.getZjlygc_7();
	}

	/**
	* Sets the zjlygc_7 of this project.
	*
	* @param zjlygc_7 the zjlygc_7 of this project
	*/
	@Override
	public void setZjlygc_7(java.lang.String zjlygc_7) {
		_project.setZjlygc_7(zjlygc_7);
	}

	/**
	* Returns the zjlygc_8 of this project.
	*
	* @return the zjlygc_8 of this project
	*/
	@Override
	public java.lang.String getZjlygc_8() {
		return _project.getZjlygc_8();
	}

	/**
	* Sets the zjlygc_8 of this project.
	*
	* @param zjlygc_8 the zjlygc_8 of this project
	*/
	@Override
	public void setZjlygc_8(java.lang.String zjlygc_8) {
		_project.setZjlygc_8(zjlygc_8);
	}

	/**
	* Returns the zjlygc_9 of this project.
	*
	* @return the zjlygc_9 of this project
	*/
	@Override
	public java.lang.String getZjlygc_9() {
		return _project.getZjlygc_9();
	}

	/**
	* Sets the zjlygc_9 of this project.
	*
	* @param zjlygc_9 the zjlygc_9 of this project
	*/
	@Override
	public void setZjlygc_9(java.lang.String zjlygc_9) {
		_project.setZjlygc_9(zjlygc_9);
	}

	/**
	* Returns the jgxs of this project.
	*
	* @return the jgxs of this project
	*/
	@Override
	public java.lang.String getJgxs() {
		return _project.getJgxs();
	}

	/**
	* Sets the jgxs of this project.
	*
	* @param jgxs the jgxs of this project
	*/
	@Override
	public void setJgxs(java.lang.String jgxs) {
		_project.setJgxs(jgxs);
	}

	/**
	* Returns the xmfl of this project.
	*
	* @return the xmfl of this project
	*/
	@Override
	public java.lang.String getXmfl() {
		return _project.getXmfl();
	}

	/**
	* Sets the xmfl of this project.
	*
	* @param xmfl the xmfl of this project
	*/
	@Override
	public void setXmfl(java.lang.String xmfl) {
		_project.setXmfl(xmfl);
	}

	/**
	* Returns the jzmq of this project.
	*
	* @return the jzmq of this project
	*/
	@Override
	public java.lang.String getJzmq() {
		return _project.getJzmq();
	}

	/**
	* Sets the jzmq of this project.
	*
	* @param jzmq the jzmq of this project
	*/
	@Override
	public void setJzmq(java.lang.String jzmq) {
		_project.setJzmq(jzmq);
	}

	/**
	* Returns the ywdt of this project.
	*
	* @return the ywdt of this project
	*/
	@Override
	public java.lang.String getYwdt() {
		return _project.getYwdt();
	}

	/**
	* Sets the ywdt of this project.
	*
	* @param ywdt the ywdt of this project
	*/
	@Override
	public void setYwdt(java.lang.String ywdt) {
		_project.setYwdt(ywdt);
	}

	/**
	* Returns the dxsck of this project.
	*
	* @return the dxsck of this project
	*/
	@Override
	public java.lang.String getDxsck() {
		return _project.getDxsck();
	}

	/**
	* Sets the dxsck of this project.
	*
	* @param dxsck the dxsck of this project
	*/
	@Override
	public void setDxsck(java.lang.String dxsck) {
		_project.setDxsck(dxsck);
	}

	/**
	* Returns the bhjz of this project.
	*
	* @return the bhjz of this project
	*/
	@Override
	public java.lang.String getBhjz() {
		return _project.getBhjz();
	}

	/**
	* Sets the bhjz of this project.
	*
	* @param bhjz the bhjz of this project
	*/
	@Override
	public void setBhjz(java.lang.String bhjz) {
		_project.setBhjz(bhjz);
	}

	/**
	* Returns the fjms of this project.
	*
	* @return the fjms of this project
	*/
	@Override
	public java.lang.String getFjms() {
		return _project.getFjms();
	}

	/**
	* Sets the fjms of this project.
	*
	* @param fjms the fjms of this project
	*/
	@Override
	public void setFjms(java.lang.String fjms) {
		_project.setFjms(fjms);
	}

	/**
	* Returns the sfsbxm of this project.
	*
	* @return the sfsbxm of this project
	*/
	@Override
	public java.lang.String getSfsbxm() {
		return _project.getSfsbxm();
	}

	/**
	* Sets the sfsbxm of this project.
	*
	* @param sfsbxm the sfsbxm of this project
	*/
	@Override
	public void setSfsbxm(java.lang.String sfsbxm) {
		_project.setSfsbxm(sfsbxm);
	}

	/**
	* Returns the hzyj of this project.
	*
	* @return the hzyj of this project
	*/
	@Override
	public java.lang.String getHzyj() {
		return _project.getHzyj();
	}

	/**
	* Sets the hzyj of this project.
	*
	* @param hzyj the hzyj of this project
	*/
	@Override
	public void setHzyj(java.lang.String hzyj) {
		_project.setHzyj(hzyj);
	}

	/**
	* Returns the bj_sx of this project.
	*
	* @return the bj_sx of this project
	*/
	@Override
	public java.lang.String getBj_sx() {
		return _project.getBj_sx();
	}

	/**
	* Sets the bj_sx of this project.
	*
	* @param bj_sx the bj_sx of this project
	*/
	@Override
	public void setBj_sx(java.lang.String bj_sx) {
		_project.setBj_sx(bj_sx);
	}

	/**
	* Returns the bj_webid of this project.
	*
	* @return the bj_webid of this project
	*/
	@Override
	public java.lang.String getBj_webid() {
		return _project.getBj_webid();
	}

	/**
	* Sets the bj_webid of this project.
	*
	* @param bj_webid the bj_webid of this project
	*/
	@Override
	public void setBj_webid(java.lang.String bj_webid) {
		_project.setBj_webid(bj_webid);
	}

	/**
	* Returns the bjwcbj of this project.
	*
	* @return the bjwcbj of this project
	*/
	@Override
	public java.lang.String getBjwcbj() {
		return _project.getBjwcbj();
	}

	/**
	* Sets the bjwcbj of this project.
	*
	* @param bjwcbj the bjwcbj of this project
	*/
	@Override
	public void setBjwcbj(java.lang.String bjwcbj) {
		_project.setBjwcbj(bjwcbj);
	}

	/**
	* Returns the bmdm of this project.
	*
	* @return the bmdm of this project
	*/
	@Override
	public java.lang.String getBmdm() {
		return _project.getBmdm();
	}

	/**
	* Sets the bmdm of this project.
	*
	* @param bmdm the bmdm of this project
	*/
	@Override
	public void setBmdm(java.lang.String bmdm) {
		_project.setBmdm(bmdm);
	}

	/**
	* Returns the jbr of this project.
	*
	* @return the jbr of this project
	*/
	@Override
	public java.lang.String getJbr() {
		return _project.getJbr();
	}

	/**
	* Sets the jbr of this project.
	*
	* @param jbr the jbr of this project
	*/
	@Override
	public void setJbr(java.lang.String jbr) {
		_project.setJbr(jbr);
	}

	/**
	* Returns the shr of this project.
	*
	* @return the shr of this project
	*/
	@Override
	public java.lang.String getShr() {
		return _project.getShr();
	}

	/**
	* Sets the shr of this project.
	*
	* @param shr the shr of this project
	*/
	@Override
	public void setShr(java.lang.String shr) {
		_project.setShr(shr);
	}

	/**
	* Returns the shbmdm of this project.
	*
	* @return the shbmdm of this project
	*/
	@Override
	public java.lang.String getShbmdm() {
		return _project.getShbmdm();
	}

	/**
	* Sets the shbmdm of this project.
	*
	* @param shbmdm the shbmdm of this project
	*/
	@Override
	public void setShbmdm(java.lang.String shbmdm) {
		_project.setShbmdm(shbmdm);
	}

	/**
	* Returns the wcbjsj of this project.
	*
	* @return the wcbjsj of this project
	*/
	@Override
	public java.lang.String getWcbjsj() {
		return _project.getWcbjsj();
	}

	/**
	* Sets the wcbjsj of this project.
	*
	* @param wcbjsj the wcbjsj of this project
	*/
	@Override
	public void setWcbjsj(java.lang.String wcbjsj) {
		_project.setWcbjsj(wcbjsj);
	}

	/**
	* Returns the old_bjbh of this project.
	*
	* @return the old_bjbh of this project
	*/
	@Override
	public java.lang.String getOld_bjbh() {
		return _project.getOld_bjbh();
	}

	/**
	* Sets the old_bjbh of this project.
	*
	* @param old_bjbh the old_bjbh of this project
	*/
	@Override
	public void setOld_bjbh(java.lang.String old_bjbh) {
		_project.setOld_bjbh(old_bjbh);
	}

	/**
	* Returns the sffb of this project.
	*
	* @return the sffb of this project
	*/
	@Override
	public java.lang.String getSffb() {
		return _project.getSffb();
	}

	/**
	* Sets the sffb of this project.
	*
	* @param sffb the sffb of this project
	*/
	@Override
	public void setSffb(java.lang.String sffb) {
		_project.setSffb(sffb);
	}

	/**
	* Returns the timeflag of this project.
	*
	* @return the timeflag of this project
	*/
	@Override
	public java.lang.String getTimeflag() {
		return _project.getTimeflag();
	}

	/**
	* Sets the timeflag of this project.
	*
	* @param timeflag the timeflag of this project
	*/
	@Override
	public void setTimeflag(java.lang.String timeflag) {
		_project.setTimeflag(timeflag);
	}

	/**
	* Returns the jbrdm of this project.
	*
	* @return the jbrdm of this project
	*/
	@Override
	public java.lang.String getJbrdm() {
		return _project.getJbrdm();
	}

	/**
	* Sets the jbrdm of this project.
	*
	* @param jbrdm the jbrdm of this project
	*/
	@Override
	public void setJbrdm(java.lang.String jbrdm) {
		_project.setJbrdm(jbrdm);
	}

	/**
	* Returns the shrdm of this project.
	*
	* @return the shrdm of this project
	*/
	@Override
	public java.lang.String getShrdm() {
		return _project.getShrdm();
	}

	/**
	* Sets the shrdm of this project.
	*
	* @param shrdm the shrdm of this project
	*/
	@Override
	public void setShrdm(java.lang.String shrdm) {
		_project.setShrdm(shrdm);
	}

	/**
	* Returns the jsbh of this project.
	*
	* @return the jsbh of this project
	*/
	@Override
	public java.lang.String getJsbh() {
		return _project.getJsbh();
	}

	/**
	* Sets the jsbh of this project.
	*
	* @param jsbh the jsbh of this project
	*/
	@Override
	public void setJsbh(java.lang.String jsbh) {
		_project.setJsbh(jsbh);
	}

	/**
	* Returns the need sbjl of this project.
	*
	* @return the need sbjl of this project
	*/
	@Override
	public java.lang.String getNeedSbjl() {
		return _project.getNeedSbjl();
	}

	/**
	* Sets the need sbjl of this project.
	*
	* @param needSbjl the need sbjl of this project
	*/
	@Override
	public void setNeedSbjl(java.lang.String needSbjl) {
		_project.setNeedSbjl(needSbjl);
	}

	/**
	* Returns the wc sbjl of this project.
	*
	* @return the wc sbjl of this project
	*/
	@Override
	public java.lang.String getWcSbjl() {
		return _project.getWcSbjl();
	}

	/**
	* Sets the wc sbjl of this project.
	*
	* @param wcSbjl the wc sbjl of this project
	*/
	@Override
	public void setWcSbjl(java.lang.String wcSbjl) {
		_project.setWcSbjl(wcSbjl);
	}

	/**
	* Returns the sfgyzbkg of this project.
	*
	* @return the sfgyzbkg of this project
	*/
	@Override
	public java.lang.String getSfgyzbkg() {
		return _project.getSfgyzbkg();
	}

	/**
	* Sets the sfgyzbkg of this project.
	*
	* @param sfgyzbkg the sfgyzbkg of this project
	*/
	@Override
	public void setSfgyzbkg(java.lang.String sfgyzbkg) {
		_project.setSfgyzbkg(sfgyzbkg);
	}

	/**
	* Returns the jyzxfbxx of this project.
	*
	* @return the jyzxfbxx of this project
	*/
	@Override
	public java.lang.String getJyzxfbxx() {
		return _project.getJyzxfbxx();
	}

	/**
	* Sets the jyzxfbxx of this project.
	*
	* @param jyzxfbxx the jyzxfbxx of this project
	*/
	@Override
	public void setJyzxfbxx(java.lang.String jyzxfbxx) {
		_project.setJyzxfbxx(jyzxfbxx);
	}

	/**
	* Returns the sg gkzbfb of this project.
	*
	* @return the sg gkzbfb of this project
	*/
	@Override
	public java.lang.String getSgGkzbfb() {
		return _project.getSgGkzbfb();
	}

	/**
	* Sets the sg gkzbfb of this project.
	*
	* @param sgGkzbfb the sg gkzbfb of this project
	*/
	@Override
	public void setSgGkzbfb(java.lang.String sgGkzbfb) {
		_project.setSgGkzbfb(sgGkzbfb);
	}

	/**
	* Returns the sgjl gkzbfb of this project.
	*
	* @return the sgjl gkzbfb of this project
	*/
	@Override
	public java.lang.String getSgjlGkzbfb() {
		return _project.getSgjlGkzbfb();
	}

	/**
	* Sets the sgjl gkzbfb of this project.
	*
	* @param sgjlGkzbfb the sgjl gkzbfb of this project
	*/
	@Override
	public void setSgjlGkzbfb(java.lang.String sgjlGkzbfb) {
		_project.setSgjlGkzbfb(sgjlGkzbfb);
	}

	/**
	* Returns the fxglxm of this project.
	*
	* @return the fxglxm of this project
	*/
	@Override
	public java.lang.String getFxglxm() {
		return _project.getFxglxm();
	}

	/**
	* Sets the fxglxm of this project.
	*
	* @param fxglxm the fxglxm of this project
	*/
	@Override
	public void setFxglxm(java.lang.String fxglxm) {
		_project.setFxglxm(fxglxm);
	}

	/**
	* Returns the fxglxm jbr of this project.
	*
	* @return the fxglxm jbr of this project
	*/
	@Override
	public java.lang.String getFxglxmJbr() {
		return _project.getFxglxmJbr();
	}

	/**
	* Sets the fxglxm jbr of this project.
	*
	* @param fxglxmJbr the fxglxm jbr of this project
	*/
	@Override
	public void setFxglxmJbr(java.lang.String fxglxmJbr) {
		_project.setFxglxmJbr(fxglxmJbr);
	}

	/**
	* Returns the fxglxm jbrdm of this project.
	*
	* @return the fxglxm jbrdm of this project
	*/
	@Override
	public java.lang.String getFxglxmJbrdm() {
		return _project.getFxglxmJbrdm();
	}

	/**
	* Sets the fxglxm jbrdm of this project.
	*
	* @param fxglxmJbrdm the fxglxm jbrdm of this project
	*/
	@Override
	public void setFxglxmJbrdm(java.lang.String fxglxmJbrdm) {
		_project.setFxglxmJbrdm(fxglxmJbrdm);
	}

	/**
	* Returns the fxglxm jbrq of this project.
	*
	* @return the fxglxm jbrq of this project
	*/
	@Override
	public java.lang.String getFxglxmJbrq() {
		return _project.getFxglxmJbrq();
	}

	/**
	* Sets the fxglxm jbrq of this project.
	*
	* @param fxglxmJbrq the fxglxm jbrq of this project
	*/
	@Override
	public void setFxglxmJbrq(java.lang.String fxglxmJbrq) {
		_project.setFxglxmJbrq(fxglxmJbrq);
	}

	/**
	* Returns the jsdwjgdm of this project.
	*
	* @return the jsdwjgdm of this project
	*/
	@Override
	public java.lang.String getJsdwjgdm() {
		return _project.getJsdwjgdm();
	}

	/**
	* Sets the jsdwjgdm of this project.
	*
	* @param jsdwjgdm the jsdwjgdm of this project
	*/
	@Override
	public void setJsdwjgdm(java.lang.String jsdwjgdm) {
		_project.setJsdwjgdm(jsdwjgdm);
	}

	/**
	* Returns the szqy of this project.
	*
	* @return the szqy of this project
	*/
	@Override
	public java.lang.String getSzqy() {
		return _project.getSzqy();
	}

	/**
	* Sets the szqy of this project.
	*
	* @param szqy the szqy of this project
	*/
	@Override
	public void setSzqy(java.lang.String szqy) {
		_project.setSzqy(szqy);
	}

	/**
	* Returns the ywxjfwjz of this project.
	*
	* @return the ywxjfwjz of this project
	*/
	@Override
	public java.lang.String getYwxjfwjz() {
		return _project.getYwxjfwjz();
	}

	/**
	* Sets the ywxjfwjz of this project.
	*
	* @param ywxjfwjz the ywxjfwjz of this project
	*/
	@Override
	public void setYwxjfwjz(java.lang.String ywxjfwjz) {
		_project.setYwxjfwjz(ywxjfwjz);
	}

	/**
	* Returns the ywgbfwjg of this project.
	*
	* @return the ywgbfwjg of this project
	*/
	@Override
	public java.lang.String getYwgbfwjg() {
		return _project.getYwgbfwjg();
	}

	/**
	* Sets the ywgbfwjg of this project.
	*
	* @param ywgbfwjg the ywgbfwjg of this project
	*/
	@Override
	public void setYwgbfwjg(java.lang.String ywgbfwjg) {
		_project.setYwgbfwjg(ywgbfwjg);
	}

	/**
	* Returns the gczh of this project.
	*
	* @return the gczh of this project
	*/
	@Override
	public java.lang.String getGczh() {
		return _project.getGczh();
	}

	/**
	* Sets the gczh of this project.
	*
	* @param gczh the gczh of this project
	*/
	@Override
	public void setGczh(java.lang.String gczh) {
		_project.setGczh(gczh);
	}

	/**
	* Returns the zdcyyn of this project.
	*
	* @return the zdcyyn of this project
	*/
	@Override
	public java.lang.String getZdcyyn() {
		return _project.getZdcyyn();
	}

	/**
	* Sets the zdcyyn of this project.
	*
	* @param zdcyyn the zdcyyn of this project
	*/
	@Override
	public void setZdcyyn(java.lang.String zdcyyn) {
		_project.setZdcyyn(zdcyyn);
	}

	/**
	* Returns the lxfl of this project.
	*
	* @return the lxfl of this project
	*/
	@Override
	public java.lang.String getLxfl() {
		return _project.getLxfl();
	}

	/**
	* Sets the lxfl of this project.
	*
	* @param lxfl the lxfl of this project
	*/
	@Override
	public void setLxfl(java.lang.String lxfl) {
		_project.setLxfl(lxfl);
	}

	/**
	* Returns the ms1 of this project.
	*
	* @return the ms1 of this project
	*/
	@Override
	public java.lang.String getMs1() {
		return _project.getMs1();
	}

	/**
	* Sets the ms1 of this project.
	*
	* @param ms1 the ms1 of this project
	*/
	@Override
	public void setMs1(java.lang.String ms1) {
		_project.setMs1(ms1);
	}

	/**
	* Returns the ms2 of this project.
	*
	* @return the ms2 of this project
	*/
	@Override
	public java.lang.String getMs2() {
		return _project.getMs2();
	}

	/**
	* Sets the ms2 of this project.
	*
	* @param ms2 the ms2 of this project
	*/
	@Override
	public void setMs2(java.lang.String ms2) {
		_project.setMs2(ms2);
	}

	/**
	* Returns the ms3 of this project.
	*
	* @return the ms3 of this project
	*/
	@Override
	public java.lang.String getMs3() {
		return _project.getMs3();
	}

	/**
	* Sets the ms3 of this project.
	*
	* @param ms3 the ms3 of this project
	*/
	@Override
	public void setMs3(java.lang.String ms3) {
		_project.setMs3(ms3);
	}

	/**
	* Returns the zdxmyn of this project.
	*
	* @return the zdxmyn of this project
	*/
	@Override
	public java.lang.String getZdxmyn() {
		return _project.getZdxmyn();
	}

	/**
	* Sets the zdxmyn of this project.
	*
	* @param zdxmyn the zdxmyn of this project
	*/
	@Override
	public void setZdxmyn(java.lang.String zdxmyn) {
		_project.setZdxmyn(zdxmyn);
	}

	/**
	* Returns the dxjzsq of this project.
	*
	* @return the dxjzsq of this project
	*/
	@Override
	public java.lang.String getDxjzsq() {
		return _project.getDxjzsq();
	}

	/**
	* Sets the dxjzsq of this project.
	*
	* @param dxjzsq the dxjzsq of this project
	*/
	@Override
	public void setDxjzsq(java.lang.String dxjzsq) {
		_project.setDxjzsq(dxjzsq);
	}

	/**
	* Returns the ywjzxzz of this project.
	*
	* @return the ywjzxzz of this project
	*/
	@Override
	public java.lang.String getYwjzxzz() {
		return _project.getYwjzxzz();
	}

	/**
	* Sets the ywjzxzz of this project.
	*
	* @param ywjzxzz the ywjzxzz of this project
	*/
	@Override
	public void setYwjzxzz(java.lang.String ywjzxzz) {
		_project.setYwjzxzz(ywjzxzz);
	}

	/**
	* Returns the fgwjhm of this project.
	*
	* @return the fgwjhm of this project
	*/
	@Override
	public java.lang.String getFgwjhm() {
		return _project.getFgwjhm();
	}

	/**
	* Sets the fgwjhm of this project.
	*
	* @param fgwjhm the fgwjhm of this project
	*/
	@Override
	public void setFgwjhm(java.lang.String fgwjhm) {
		_project.setFgwjhm(fgwjhm);
	}

	/**
	* Returns the zzbl of this project.
	*
	* @return the zzbl of this project
	*/
	@Override
	public java.lang.String getZzbl() {
		return _project.getZzbl();
	}

	/**
	* Sets the zzbl of this project.
	*
	* @param zzbl the zzbl of this project
	*/
	@Override
	public void setZzbl(java.lang.String zzbl) {
		_project.setZzbl(zzbl);
	}

	/**
	* Returns the change time of this project.
	*
	* @return the change time of this project
	*/
	@Override
	public java.lang.String getChangeTime() {
		return _project.getChangeTime();
	}

	/**
	* Sets the change time of this project.
	*
	* @param ChangeTime the change time of this project
	*/
	@Override
	public void setChangeTime(java.lang.String ChangeTime) {
		_project.setChangeTime(ChangeTime);
	}

	/**
	* Returns the p d_ s w of this project.
	*
	* @return the p d_ s w of this project
	*/
	@Override
	public java.lang.String getPD_SW() {
		return _project.getPD_SW();
	}

	/**
	* Sets the p d_ s w of this project.
	*
	* @param PD_SW the p d_ s w of this project
	*/
	@Override
	public void setPD_SW(java.lang.String PD_SW) {
		_project.setPD_SW(PD_SW);
	}

	/**
	* Returns the bmpfrq of this project.
	*
	* @return the bmpfrq of this project
	*/
	@Override
	public java.lang.String getBmpfrq() {
		return _project.getBmpfrq();
	}

	/**
	* Sets the bmpfrq of this project.
	*
	* @param bmpfrq the bmpfrq of this project
	*/
	@Override
	public void setBmpfrq(java.lang.String bmpfrq) {
		_project.setBmpfrq(bmpfrq);
	}

	/**
	* Returns the bmpfwh of this project.
	*
	* @return the bmpfwh of this project
	*/
	@Override
	public java.lang.String getBmpfwh() {
		return _project.getBmpfwh();
	}

	/**
	* Sets the bmpfwh of this project.
	*
	* @param bmpfwh the bmpfwh of this project
	*/
	@Override
	public void setBmpfwh(java.lang.String bmpfwh) {
		_project.setBmpfwh(bmpfwh);
	}

	/**
	* Returns the bmpfwj of this project.
	*
	* @return the bmpfwj of this project
	*/
	@Override
	public java.lang.String getBmpfwj() {
		return _project.getBmpfwj();
	}

	/**
	* Sets the bmpfwj of this project.
	*
	* @param bmpfwj the bmpfwj of this project
	*/
	@Override
	public void setBmpfwj(java.lang.String bmpfwj) {
		_project.setBmpfwj(bmpfwj);
	}

	/**
	* Returns the certificate key of this project.
	*
	* @return the certificate key of this project
	*/
	@Override
	public java.lang.String getCertificateKey() {
		return _project.getCertificateKey();
	}

	/**
	* Sets the certificate key of this project.
	*
	* @param CertificateKey the certificate key of this project
	*/
	@Override
	public void setCertificateKey(java.lang.String CertificateKey) {
		_project.setCertificateKey(CertificateKey);
	}

	/**
	* Returns the dsjzmj of this project.
	*
	* @return the dsjzmj of this project
	*/
	@Override
	public java.lang.String getDsjzmj() {
		return _project.getDsjzmj();
	}

	/**
	* Sets the dsjzmj of this project.
	*
	* @param dsjzmj the dsjzmj of this project
	*/
	@Override
	public void setDsjzmj(java.lang.String dsjzmj) {
		_project.setDsjzmj(dsjzmj);
	}

	/**
	* Returns the dxjzmj of this project.
	*
	* @return the dxjzmj of this project
	*/
	@Override
	public java.lang.String getDxjzmj() {
		return _project.getDxjzmj();
	}

	/**
	* Sets the dxjzmj of this project.
	*
	* @param dxjzmj the dxjzmj of this project
	*/
	@Override
	public void setDxjzmj(java.lang.String dxjzmj) {
		_project.setDxjzmj(dxjzmj);
	}

	/**
	* Returns the gdzctzbh of this project.
	*
	* @return the gdzctzbh of this project
	*/
	@Override
	public java.lang.String getGdzctzbh() {
		return _project.getGdzctzbh();
	}

	/**
	* Sets the gdzctzbh of this project.
	*
	* @param gdzctzbh the gdzctzbh of this project
	*/
	@Override
	public void setGdzctzbh(java.lang.String gdzctzbh) {
		_project.setGdzctzbh(gdzctzbh);
	}

	/**
	* Returns the jsxz_2011 of this project.
	*
	* @return the jsxz_2011 of this project
	*/
	@Override
	public java.lang.String getJsxz_2011() {
		return _project.getJsxz_2011();
	}

	/**
	* Sets the jsxz_2011 of this project.
	*
	* @param jsxz_2011 the jsxz_2011 of this project
	*/
	@Override
	public void setJsxz_2011(java.lang.String jsxz_2011) {
		_project.setJsxz_2011(jsxz_2011);
	}

	/**
	* Returns the lhmj of this project.
	*
	* @return the lhmj of this project
	*/
	@Override
	public java.lang.String getLhmj() {
		return _project.getLhmj();
	}

	/**
	* Sets the lhmj of this project.
	*
	* @param lhmj the lhmj of this project
	*/
	@Override
	public void setLhmj(java.lang.String lhmj) {
		_project.setLhmj(lhmj);
	}

	/**
	* Returns the lxjb_2011 of this project.
	*
	* @return the lxjb_2011 of this project
	*/
	@Override
	public java.lang.String getLxjb_2011() {
		return _project.getLxjb_2011();
	}

	/**
	* Sets the lxjb_2011 of this project.
	*
	* @param lxjb_2011 the lxjb_2011 of this project
	*/
	@Override
	public void setLxjb_2011(java.lang.String lxjb_2011) {
		_project.setLxjb_2011(lxjb_2011);
	}

	/**
	* Returns the mfmj of this project.
	*
	* @return the mfmj of this project
	*/
	@Override
	public java.lang.String getMfmj() {
		return _project.getMfmj();
	}

	/**
	* Sets the mfmj of this project.
	*
	* @param mfmj the mfmj of this project
	*/
	@Override
	public void setMfmj(java.lang.String mfmj) {
		_project.setMfmj(mfmj);
	}

	/**
	* Returns the other_qx of this project.
	*
	* @return the other_qx of this project
	*/
	@Override
	public java.lang.String getOther_qx() {
		return _project.getOther_qx();
	}

	/**
	* Sets the other_qx of this project.
	*
	* @param other_qx the other_qx of this project
	*/
	@Override
	public void setOther_qx(java.lang.String other_qx) {
		_project.setOther_qx(other_qx);
	}

	/**
	* Returns the project slyj of this project.
	*
	* @return the project slyj of this project
	*/
	@Override
	public java.lang.String getProjectSlyj() {
		return _project.getProjectSlyj();
	}

	/**
	* Sets the project slyj of this project.
	*
	* @param ProjectSlyj the project slyj of this project
	*/
	@Override
	public void setProjectSlyj(java.lang.String ProjectSlyj) {
		_project.setProjectSlyj(ProjectSlyj);
	}

	/**
	* Returns the qxbz of this project.
	*
	* @return the qxbz of this project
	*/
	@Override
	public java.lang.String getQxbz() {
		return _project.getQxbz();
	}

	/**
	* Sets the qxbz of this project.
	*
	* @param qxbz the qxbz of this project
	*/
	@Override
	public void setQxbz(java.lang.String qxbz) {
		_project.setQxbz(qxbz);
	}

	/**
	* Returns the sfcysjkfq of this project.
	*
	* @return the sfcysjkfq of this project
	*/
	@Override
	public java.lang.String getSfcysjkfq() {
		return _project.getSfcysjkfq();
	}

	/**
	* Sets the sfcysjkfq of this project.
	*
	* @param sfcysjkfq the sfcysjkfq of this project
	*/
	@Override
	public void setSfcysjkfq(java.lang.String sfcysjkfq) {
		_project.setSfcysjkfq(sfcysjkfq);
	}

	/**
	* Returns the sfmfss of this project.
	*
	* @return the sfmfss of this project
	*/
	@Override
	public java.lang.String getSfmfss() {
		return _project.getSfmfss();
	}

	/**
	* Sets the sfmfss of this project.
	*
	* @param sfmfss the sfmfss of this project
	*/
	@Override
	public void setSfmfss(java.lang.String sfmfss) {
		_project.setSfmfss(sfmfss);
	}

	/**
	* Returns the szqx of this project.
	*
	* @return the szqx of this project
	*/
	@Override
	public java.lang.String getSzqx() {
		return _project.getSzqx();
	}

	/**
	* Sets the szqx of this project.
	*
	* @param szqx the szqx of this project
	*/
	@Override
	public void setSzqx(java.lang.String szqx) {
		_project.setSzqx(szqx);
	}

	/**
	* Returns the tsgs of this project.
	*
	* @return the tsgs of this project
	*/
	@Override
	public java.lang.String getTsgs() {
		return _project.getTsgs();
	}

	/**
	* Sets the tsgs of this project.
	*
	* @param tsgs the tsgs of this project
	*/
	@Override
	public void setTsgs(java.lang.String tsgs) {
		_project.setTsgs(tsgs);
	}

	/**
	* Returns the xmfl_2011 of this project.
	*
	* @return the xmfl_2011 of this project
	*/
	@Override
	public java.lang.String getXmfl_2011() {
		return _project.getXmfl_2011();
	}

	/**
	* Sets the xmfl_2011 of this project.
	*
	* @param xmfl_2011 the xmfl_2011 of this project
	*/
	@Override
	public void setXmfl_2011(java.lang.String xmfl_2011) {
		_project.setXmfl_2011(xmfl_2011);
	}

	/**
	* Returns the xsjpw of this project.
	*
	* @return the xsjpw of this project
	*/
	@Override
	public java.lang.String getXsjpw() {
		return _project.getXsjpw();
	}

	/**
	* Sets the xsjpw of this project.
	*
	* @param xsjpw the xsjpw of this project
	*/
	@Override
	public void setXsjpw(java.lang.String xsjpw) {
		_project.setXsjpw(xsjpw);
	}

	/**
	* Returns the xsjpzdw of this project.
	*
	* @return the xsjpzdw of this project
	*/
	@Override
	public java.lang.String getXsjpzdw() {
		return _project.getXsjpzdw();
	}

	/**
	* Sets the xsjpzdw of this project.
	*
	* @param xsjpzdw the xsjpzdw of this project
	*/
	@Override
	public void setXsjpzdw(java.lang.String xsjpzdw) {
		_project.setXsjpzdw(xsjpzdw);
	}

	/**
	* Returns the zjlygc_10 of this project.
	*
	* @return the zjlygc_10 of this project
	*/
	@Override
	public java.lang.String getZjlygc_10() {
		return _project.getZjlygc_10();
	}

	/**
	* Sets the zjlygc_10 of this project.
	*
	* @param zjlygc_10 the zjlygc_10 of this project
	*/
	@Override
	public void setZjlygc_10(java.lang.String zjlygc_10) {
		_project.setZjlygc_10(zjlygc_10);
	}

	/**
	* Returns the zjlygc_11 of this project.
	*
	* @return the zjlygc_11 of this project
	*/
	@Override
	public java.lang.String getZjlygc_11() {
		return _project.getZjlygc_11();
	}

	/**
	* Sets the zjlygc_11 of this project.
	*
	* @param zjlygc_11 the zjlygc_11 of this project
	*/
	@Override
	public void setZjlygc_11(java.lang.String zjlygc_11) {
		_project.setZjlygc_11(zjlygc_11);
	}

	/**
	* Returns the zjlygc_xs_1 of this project.
	*
	* @return the zjlygc_xs_1 of this project
	*/
	@Override
	public java.lang.String getZjlygc_xs_1() {
		return _project.getZjlygc_xs_1();
	}

	/**
	* Sets the zjlygc_xs_1 of this project.
	*
	* @param zjlygc_xs_1 the zjlygc_xs_1 of this project
	*/
	@Override
	public void setZjlygc_xs_1(java.lang.String zjlygc_xs_1) {
		_project.setZjlygc_xs_1(zjlygc_xs_1);
	}

	/**
	* Returns the zjlygc_xs_2 of this project.
	*
	* @return the zjlygc_xs_2 of this project
	*/
	@Override
	public java.lang.String getZjlygc_xs_2() {
		return _project.getZjlygc_xs_2();
	}

	/**
	* Sets the zjlygc_xs_2 of this project.
	*
	* @param zjlygc_xs_2 the zjlygc_xs_2 of this project
	*/
	@Override
	public void setZjlygc_xs_2(java.lang.String zjlygc_xs_2) {
		_project.setZjlygc_xs_2(zjlygc_xs_2);
	}

	/**
	* Returns the zjlygc_xs_3 of this project.
	*
	* @return the zjlygc_xs_3 of this project
	*/
	@Override
	public java.lang.String getZjlygc_xs_3() {
		return _project.getZjlygc_xs_3();
	}

	/**
	* Sets the zjlygc_xs_3 of this project.
	*
	* @param zjlygc_xs_3 the zjlygc_xs_3 of this project
	*/
	@Override
	public void setZjlygc_xs_3(java.lang.String zjlygc_xs_3) {
		_project.setZjlygc_xs_3(zjlygc_xs_3);
	}

	/**
	* Returns the zjlygc_xs_4 of this project.
	*
	* @return the zjlygc_xs_4 of this project
	*/
	@Override
	public java.lang.String getZjlygc_xs_4() {
		return _project.getZjlygc_xs_4();
	}

	/**
	* Sets the zjlygc_xs_4 of this project.
	*
	* @param zjlygc_xs_4 the zjlygc_xs_4 of this project
	*/
	@Override
	public void setZjlygc_xs_4(java.lang.String zjlygc_xs_4) {
		_project.setZjlygc_xs_4(zjlygc_xs_4);
	}

	/**
	* Returns the zjlygc_1_2 of this project.
	*
	* @return the zjlygc_1_2 of this project
	*/
	@Override
	public java.lang.String getZjlygc_1_2() {
		return _project.getZjlygc_1_2();
	}

	/**
	* Sets the zjlygc_1_2 of this project.
	*
	* @param zjlygc_1_2 the zjlygc_1_2 of this project
	*/
	@Override
	public void setZjlygc_1_2(java.lang.String zjlygc_1_2) {
		_project.setZjlygc_1_2(zjlygc_1_2);
	}

	/**
	* Returns the zjlygc_1_2_4 of this project.
	*
	* @return the zjlygc_1_2_4 of this project
	*/
	@Override
	public java.lang.String getZjlygc_1_2_4() {
		return _project.getZjlygc_1_2_4();
	}

	/**
	* Sets the zjlygc_1_2_4 of this project.
	*
	* @param zjlygc_1_2_4 the zjlygc_1_2_4 of this project
	*/
	@Override
	public void setZjlygc_1_2_4(java.lang.String zjlygc_1_2_4) {
		_project.setZjlygc_1_2_4(zjlygc_1_2_4);
	}

	/**
	* Returns the ywptlh of this project.
	*
	* @return the ywptlh of this project
	*/
	@Override
	public java.lang.String getYwptlh() {
		return _project.getYwptlh();
	}

	/**
	* Sets the ywptlh of this project.
	*
	* @param ywptlh the ywptlh of this project
	*/
	@Override
	public void setYwptlh(java.lang.String ywptlh) {
		_project.setYwptlh(ywptlh);
	}

	/**
	* Returns the gyyqbh of this project.
	*
	* @return the gyyqbh of this project
	*/
	@Override
	public java.lang.String getGyyqbh() {
		return _project.getGyyqbh();
	}

	/**
	* Sets the gyyqbh of this project.
	*
	* @param gyyqbh the gyyqbh of this project
	*/
	@Override
	public void setGyyqbh(java.lang.String gyyqbh) {
		_project.setGyyqbh(gyyqbh);
	}

	/**
	* Returns the sfcyxm of this project.
	*
	* @return the sfcyxm of this project
	*/
	@Override
	public java.lang.String getSfcyxm() {
		return _project.getSfcyxm();
	}

	/**
	* Sets the sfcyxm of this project.
	*
	* @param sfcyxm the sfcyxm of this project
	*/
	@Override
	public void setSfcyxm(java.lang.String sfcyxm) {
		_project.setSfcyxm(sfcyxm);
	}

	/**
	* Returns the zbxmfzrxm of this project.
	*
	* @return the zbxmfzrxm of this project
	*/
	@Override
	public java.lang.String getZbxmfzrxm() {
		return _project.getZbxmfzrxm();
	}

	/**
	* Sets the zbxmfzrxm of this project.
	*
	* @param zbxmfzrxm the zbxmfzrxm of this project
	*/
	@Override
	public void setZbxmfzrxm(java.lang.String zbxmfzrxm) {
		_project.setZbxmfzrxm(zbxmfzrxm);
	}

	/**
	* Returns the zbxmfzrzjh of this project.
	*
	* @return the zbxmfzrzjh of this project
	*/
	@Override
	public java.lang.String getZbxmfzrzjh() {
		return _project.getZbxmfzrzjh();
	}

	/**
	* Sets the zbxmfzrzjh of this project.
	*
	* @param zbxmfzrzjh the zbxmfzrzjh of this project
	*/
	@Override
	public void setZbxmfzrzjh(java.lang.String zbxmfzrzjh) {
		_project.setZbxmfzrzjh(zbxmfzrzjh);
	}

	/**
	* Returns the zbxmfzrzjlx of this project.
	*
	* @return the zbxmfzrzjlx of this project
	*/
	@Override
	public java.lang.String getZbxmfzrzjlx() {
		return _project.getZbxmfzrzjlx();
	}

	/**
	* Sets the zbxmfzrzjlx of this project.
	*
	* @param zbxmfzrzjlx the zbxmfzrzjlx of this project
	*/
	@Override
	public void setZbxmfzrzjlx(java.lang.String zbxmfzrzjlx) {
		_project.setZbxmfzrzjlx(zbxmfzrzjlx);
	}

	/**
	* Returns the zbxmfzrqrsj of this project.
	*
	* @return the zbxmfzrqrsj of this project
	*/
	@Override
	public java.lang.String getZbxmfzrqrsj() {
		return _project.getZbxmfzrqrsj();
	}

	/**
	* Sets the zbxmfzrqrsj of this project.
	*
	* @param zbxmfzrqrsj the zbxmfzrqrsj of this project
	*/
	@Override
	public void setZbxmfzrqrsj(java.lang.String zbxmfzrqrsj) {
		_project.setZbxmfzrqrsj(zbxmfzrqrsj);
	}

	/**
	* Returns the sflsjzbs of this project.
	*
	* @return the sflsjzbs of this project
	*/
	@Override
	public java.lang.String getSflsjzbs() {
		return _project.getSflsjzbs();
	}

	/**
	* Sets the sflsjzbs of this project.
	*
	* @param sflsjzbs the sflsjzbs of this project
	*/
	@Override
	public void setSflsjzbs(java.lang.String sflsjzbs) {
		_project.setSflsjzbs(sflsjzbs);
	}

	/**
	* Returns the sjbs of this project.
	*
	* @return the sjbs of this project
	*/
	@Override
	public java.lang.String getSjbs() {
		return _project.getSjbs();
	}

	/**
	* Sets the sjbs of this project.
	*
	* @param sjbs the sjbs of this project
	*/
	@Override
	public void setSjbs(java.lang.String sjbs) {
		_project.setSjbs(sjbs);
	}

	/**
	* Returns the yxbs of this project.
	*
	* @return the yxbs of this project
	*/
	@Override
	public java.lang.String getYxbs() {
		return _project.getYxbs();
	}

	/**
	* Sets the yxbs of this project.
	*
	* @param yxbs the yxbs of this project
	*/
	@Override
	public void setYxbs(java.lang.String yxbs) {
		_project.setYxbs(yxbs);
	}

	/**
	* Returns the sfyjngz of this project.
	*
	* @return the sfyjngz of this project
	*/
	@Override
	public java.lang.String getSfyjngz() {
		return _project.getSfyjngz();
	}

	/**
	* Sets the sfyjngz of this project.
	*
	* @param sfyjngz the sfyjngz of this project
	*/
	@Override
	public void setSfyjngz(java.lang.String sfyjngz) {
		_project.setSfyjngz(sfyjngz);
	}

	/**
	* Returns the sfsszpjz of this project.
	*
	* @return the sfsszpjz of this project
	*/
	@Override
	public java.lang.String getSfsszpjz() {
		return _project.getSfsszpjz();
	}

	/**
	* Sets the sfsszpjz of this project.
	*
	* @param sfsszpjz the sfsszpjz of this project
	*/
	@Override
	public void setSfsszpjz(java.lang.String sfsszpjz) {
		_project.setSfsszpjz(sfsszpjz);
	}

	/**
	* Returns the zczxjgdmz of this project.
	*
	* @return the zczxjgdmz of this project
	*/
	@Override
	public java.lang.String getZczxjgdmz() {
		return _project.getZczxjgdmz();
	}

	/**
	* Sets the zczxjgdmz of this project.
	*
	* @param zczxjgdmz the zczxjgdmz of this project
	*/
	@Override
	public void setZczxjgdmz(java.lang.String zczxjgdmz) {
		_project.setZczxjgdmz(zczxjgdmz);
	}

	/**
	* Returns the ischeckxmbm of this project.
	*
	* @return the ischeckxmbm of this project
	*/
	@Override
	public java.lang.String getIscheckxmbm() {
		return _project.getIscheckxmbm();
	}

	/**
	* Sets the ischeckxmbm of this project.
	*
	* @param ischeckxmbm the ischeckxmbm of this project
	*/
	@Override
	public void setIscheckxmbm(java.lang.String ischeckxmbm) {
		_project.setIscheckxmbm(ischeckxmbm);
	}

	/**
	* Returns the zddtmj of this project.
	*
	* @return the zddtmj of this project
	*/
	@Override
	public java.lang.String getZddtmj() {
		return _project.getZddtmj();
	}

	/**
	* Sets the zddtmj of this project.
	*
	* @param zddtmj the zddtmj of this project
	*/
	@Override
	public void setZddtmj(java.lang.String zddtmj) {
		_project.setZddtmj(zddtmj);
	}

	/**
	* Returns the sjjd yn of this project.
	*
	* @return the sjjd yn of this project
	*/
	@Override
	public java.lang.String getSjjdYn() {
		return _project.getSjjdYn();
	}

	/**
	* Sets the sjjd yn of this project.
	*
	* @param sjjdYn the sjjd yn of this project
	*/
	@Override
	public void setSjjdYn(java.lang.String sjjdYn) {
		_project.setSjjdYn(sjjdYn);
	}

	/**
	* Returns the sgjd yn of this project.
	*
	* @return the sgjd yn of this project
	*/
	@Override
	public java.lang.String getSgjdYn() {
		return _project.getSgjdYn();
	}

	/**
	* Sets the sgjd yn of this project.
	*
	* @param sgjdYn the sgjd yn of this project
	*/
	@Override
	public void setSgjdYn(java.lang.String sgjdYn) {
		_project.setSgjdYn(sgjdYn);
	}

	/**
	* Returns the yxjd yn of this project.
	*
	* @return the yxjd yn of this project
	*/
	@Override
	public java.lang.String getYxjdYn() {
		return _project.getYxjdYn();
	}

	/**
	* Sets the yxjd yn of this project.
	*
	* @param yxjdYn the yxjd yn of this project
	*/
	@Override
	public void setYxjdYn(java.lang.String yxjdYn) {
		_project.setYxjdYn(yxjdYn);
	}

	/**
	* Returns the tdhtqdbh of this project.
	*
	* @return the tdhtqdbh of this project
	*/
	@Override
	public java.lang.String getTdhtqdbh() {
		return _project.getTdhtqdbh();
	}

	/**
	* Sets the tdhtqdbh of this project.
	*
	* @param tdhtqdbh the tdhtqdbh of this project
	*/
	@Override
	public void setTdhtqdbh(java.lang.String tdhtqdbh) {
		_project.setTdhtqdbh(tdhtqdbh);
	}

	/**
	* Returns the tdhtqdrq of this project.
	*
	* @return the tdhtqdrq of this project
	*/
	@Override
	public java.lang.String getTdhtqdrq() {
		return _project.getTdhtqdrq();
	}

	/**
	* Sets the tdhtqdrq of this project.
	*
	* @param tdhtqdrq the tdhtqdrq of this project
	*/
	@Override
	public void setTdhtqdrq(java.lang.String tdhtqdrq) {
		_project.setTdhtqdrq(tdhtqdrq);
	}

	/**
	* Returns the dkbh of this project.
	*
	* @return the dkbh of this project
	*/
	@Override
	public java.lang.String getDkbh() {
		return _project.getDkbh();
	}

	/**
	* Sets the dkbh of this project.
	*
	* @param dkbh the dkbh of this project
	*/
	@Override
	public void setDkbh(java.lang.String dkbh) {
		_project.setDkbh(dkbh);
	}

	/**
	* Returns the zpsjzlsbl of this project.
	*
	* @return the zpsjzlsbl of this project
	*/
	@Override
	public java.lang.String getZpsjzlsbl() {
		return _project.getZpsjzlsbl();
	}

	/**
	* Sets the zpsjzlsbl of this project.
	*
	* @param zpsjzlsbl the zpsjzlsbl of this project
	*/
	@Override
	public void setZpsjzlsbl(java.lang.String zpsjzlsbl) {
		_project.setZpsjzlsbl(zpsjzlsbl);
	}

	/**
	* Returns the zpsjzmj of this project.
	*
	* @return the zpsjzmj of this project
	*/
	@Override
	public java.lang.String getZpsjzmj() {
		return _project.getZpsjzmj();
	}

	/**
	* Sets the zpsjzmj of this project.
	*
	* @param zpsjzmj the zpsjzmj of this project
	*/
	@Override
	public void setZpsjzmj(java.lang.String zpsjzmj) {
		_project.setZpsjzmj(zpsjzmj);
	}

	/**
	* Returns the dwyzzpl of this project.
	*
	* @return the dwyzzpl of this project
	*/
	@Override
	public java.lang.String getDwyzzpl() {
		return _project.getDwyzzpl();
	}

	/**
	* Sets the dwyzzpl of this project.
	*
	* @param dwyzzpl the dwyzzpl of this project
	*/
	@Override
	public void setDwyzzpl(java.lang.String dwyzzpl) {
		_project.setDwyzzpl(dwyzzpl);
	}

	/**
	* Returns the zdh of this project.
	*
	* @return the zdh of this project
	*/
	@Override
	public java.lang.String getZdh() {
		return _project.getZdh();
	}

	/**
	* Sets the zdh of this project.
	*
	* @param zdh the zdh of this project
	*/
	@Override
	public void setZdh(java.lang.String zdh) {
		_project.setZdh(zdh);
	}

	/**
	* Returns the sfgdcg of this project.
	*
	* @return the sfgdcg of this project
	*/
	@Override
	public java.lang.String getSfgdcg() {
		return _project.getSfgdcg();
	}

	/**
	* Sets the sfgdcg of this project.
	*
	* @param sfgdcg the sfgdcg of this project
	*/
	@Override
	public void setSfgdcg(java.lang.String sfgdcg) {
		_project.setSfgdcg(sfgdcg);
	}

	/**
	* Returns the ptlhmj of this project.
	*
	* @return the ptlhmj of this project
	*/
	@Override
	public java.lang.String getPtlhmj() {
		return _project.getPtlhmj();
	}

	/**
	* Sets the ptlhmj of this project.
	*
	* @param ptlhmj the ptlhmj of this project
	*/
	@Override
	public void setPtlhmj(java.lang.String ptlhmj) {
		_project.setPtlhmj(ptlhmj);
	}

	/**
	* Returns the bimjszxfy of this project.
	*
	* @return the bimjszxfy of this project
	*/
	@Override
	public java.lang.String getBimjszxfy() {
		return _project.getBimjszxfy();
	}

	/**
	* Sets the bimjszxfy of this project.
	*
	* @param bimjszxfy the bimjszxfy of this project
	*/
	@Override
	public void setBimjszxfy(java.lang.String bimjszxfy) {
		_project.setBimjszxfy(bimjszxfy);
	}

	/**
	* Returns the bz of this project.
	*
	* @return the bz of this project
	*/
	@Override
	public java.lang.String getBz() {
		return _project.getBz();
	}

	/**
	* Sets the bz of this project.
	*
	* @param bz the bz of this project
	*/
	@Override
	public void setBz(java.lang.String bz) {
		_project.setBz(bz);
	}

	/**
	* Returns the sfzcxm of this project.
	*
	* @return the sfzcxm of this project
	*/
	@Override
	public java.lang.String getSfzcxm() {
		return _project.getSfzcxm();
	}

	/**
	* Sets the sfzcxm of this project.
	*
	* @param sfzcxm the sfzcxm of this project
	*/
	@Override
	public void setSfzcxm(java.lang.String sfzcxm) {
		_project.setSfzcxm(sfzcxm);
	}

	/**
	* Returns the zcxmbm of this project.
	*
	* @return the zcxmbm of this project
	*/
	@Override
	public java.lang.String getZcxmbm() {
		return _project.getZcxmbm();
	}

	/**
	* Sets the zcxmbm of this project.
	*
	* @param zcxmbm the zcxmbm of this project
	*/
	@Override
	public void setZcxmbm(java.lang.String zcxmbm) {
		_project.setZcxmbm(zcxmbm);
	}

	/**
	* Returns the sfzmqxm of this project.
	*
	* @return the sfzmqxm of this project
	*/
	@Override
	public java.lang.String getSfzmqxm() {
		return _project.getSfzmqxm();
	}

	/**
	* Sets the sfzmqxm of this project.
	*
	* @param sfzmqxm the sfzmqxm of this project
	*/
	@Override
	public void setSfzmqxm(java.lang.String sfzmqxm) {
		_project.setSfzmqxm(sfzmqxm);
	}

	/**
	* Returns the print p d f time of this project.
	*
	* @return the print p d f time of this project
	*/
	@Override
	public java.lang.String getPrintPDFTime() {
		return _project.getPrintPDFTime();
	}

	/**
	* Sets the print p d f time of this project.
	*
	* @param printPDFTime the print p d f time of this project
	*/
	@Override
	public void setPrintPDFTime(java.lang.String printPDFTime) {
		_project.setPrintPDFTime(printPDFTime);
	}

	/**
	* Returns the is bg print of this project.
	*
	* @return the is bg print of this project
	*/
	@Override
	public java.lang.String getIsBgPrint() {
		return _project.getIsBgPrint();
	}

	/**
	* Sets the is bg print of this project.
	*
	* @param isBgPrint the is bg print of this project
	*/
	@Override
	public void setIsBgPrint(java.lang.String isBgPrint) {
		_project.setIsBgPrint(isBgPrint);
	}

	@Override
	public boolean isNew() {
		return _project.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectWrapper((Project)_project.clone());
	}

	@Override
	public int compareTo(com.justonetech.cp.project.model.Project project) {
		return _project.compareTo(project);
	}

	@Override
	public int hashCode() {
		return _project.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.project.model.Project> toCacheModel() {
		return _project.toCacheModel();
	}

	@Override
	public com.justonetech.cp.project.model.Project toEscapedModel() {
		return new ProjectWrapper(_project.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.project.model.Project toUnescapedModel() {
		return new ProjectWrapper(_project.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectWrapper)) {
			return false;
		}

		ProjectWrapper projectWrapper = (ProjectWrapper)obj;

		if (Validator.equals(_project, projectWrapper._project)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project getWrappedProject() {
		return _project;
	}

	@Override
	public Project getWrappedModel() {
		return _project;
	}

	@Override
	public void resetOriginalValues() {
		_project.resetOriginalValues();
	}

	private Project _project;
}