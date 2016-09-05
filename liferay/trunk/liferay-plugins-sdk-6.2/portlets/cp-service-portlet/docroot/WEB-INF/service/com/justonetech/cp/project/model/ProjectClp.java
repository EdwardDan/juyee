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

import com.justonetech.cp.project.service.ClpSerializer;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanqi
 */
public class ProjectClp extends BaseModelImpl<Project> implements Project {
	public ProjectClp() {
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
	public String getPrimaryKey() {
		return _bjbh;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setBjbh(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bjbh;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

	@Override
	public String getBjbh() {
		return _bjbh;
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_projectRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBjrq() {
		return _bjrq;
	}

	@Override
	public void setBjrq(Date bjrq) {
		_bjrq = bjrq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjrq", Date.class);

				method.invoke(_projectRemoteModel, bjrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdw() {
		return _jsdw;
	}

	@Override
	public void setJsdw(String jsdw) {
		_jsdw = jsdw;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdw", String.class);

				method.invoke(_projectRemoteModel, jsdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwxz() {
		return _jsdwxz;
	}

	@Override
	public void setJsdwxz(String jsdwxz) {
		_jsdwxz = jsdwxz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwxz", String.class);

				method.invoke(_projectRemoteModel, jsdwxz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwdz() {
		return _jsdwdz;
	}

	@Override
	public void setJsdwdz(String jsdwdz) {
		_jsdwdz = jsdwdz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwdz", String.class);

				method.invoke(_projectRemoteModel, jsdwdz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwdh() {
		return _jsdwdh;
	}

	@Override
	public void setJsdwdh(String jsdwdh) {
		_jsdwdh = jsdwdh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwdh", String.class);

				method.invoke(_projectRemoteModel, jsdwdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwfr() {
		return _jsdwfr;
	}

	@Override
	public void setJsdwfr(String jsdwfr) {
		_jsdwfr = jsdwfr;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwfr", String.class);

				method.invoke(_projectRemoteModel, jsdwfr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwlxr() {
		return _jsdwlxr;
	}

	@Override
	public void setJsdwlxr(String jsdwlxr) {
		_jsdwlxr = jsdwlxr;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwlxr", String.class);

				method.invoke(_projectRemoteModel, jsdwlxr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwyb() {
		return _jsdwyb;
	}

	@Override
	public void setJsdwyb(String jsdwyb) {
		_jsdwyb = jsdwyb;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwyb", String.class);

				method.invoke(_projectRemoteModel, jsdwyb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwzczj() {
		return _jsdwzczj;
	}

	@Override
	public void setJsdwzczj(String jsdwzczj) {
		_jsdwzczj = jsdwzczj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwzczj", String.class);

				method.invoke(_projectRemoteModel, jsdwzczj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmmc() {
		return _xmmc;
	}

	@Override
	public void setXmmc(String xmmc) {
		_xmmc = xmmc;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setXmmc", String.class);

				method.invoke(_projectRemoteModel, xmmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdd() {
		return _jsdd;
	}

	@Override
	public void setJsdd(String jsdd) {
		_jsdd = jsdd;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdd", String.class);

				method.invoke(_projectRemoteModel, jsdd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxwj() {
		return _lxwj;
	}

	@Override
	public void setLxwj(String lxwj) {
		_lxwj = lxwj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setLxwj", String.class);

				method.invoke(_projectRemoteModel, lxwj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxwh() {
		return _lxwh;
	}

	@Override
	public void setLxwh(String lxwh) {
		_lxwh = lxwh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setLxwh", String.class);

				method.invoke(_projectRemoteModel, lxwh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxjb() {
		return _lxjb;
	}

	@Override
	public void setLxjb(String lxjb) {
		_lxjb = lxjb;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setLxjb", String.class);

				method.invoke(_projectRemoteModel, lxjb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPzjg() {
		return _pzjg;
	}

	@Override
	public void setPzjg(String pzjg) {
		_pzjg = pzjg;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPzjg", String.class);

				method.invoke(_projectRemoteModel, pzjg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPzrq() {
		return _pzrq;
	}

	@Override
	public void setPzrq(String pzrq) {
		_pzrq = pzrq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPzrq", String.class);

				method.invoke(_projectRemoteModel, pzrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZtz() {
		return _ztz;
	}

	@Override
	public void setZtz(String ztz) {
		_ztz = ztz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZtz", String.class);

				method.invoke(_projectRemoteModel, ztz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSbtz() {
		return _sbtz;
	}

	@Override
	public void setSbtz(String sbtz) {
		_sbtz = sbtz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSbtz", String.class);

				method.invoke(_projectRemoteModel, sbtz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsxz() {
		return _jsxz;
	}

	@Override
	public void setJsxz(String jsxz) {
		_jsxz = jsxz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsxz", String.class);

				method.invoke(_projectRemoteModel, jsxz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsgm() {
		return _jsgm;
	}

	@Override
	public void setJsgm(String jsgm) {
		_jsgm = jsgm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgm", String.class);

				method.invoke(_projectRemoteModel, jsgm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZmj() {
		return _zmj;
	}

	@Override
	public void setZmj(String zmj) {
		_zmj = zmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZmj", String.class);

				method.invoke(_projectRemoteModel, zmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKgrq() {
		return _kgrq;
	}

	@Override
	public void setKgrq(String kgrq) {
		_kgrq = kgrq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setKgrq", String.class);

				method.invoke(_projectRemoteModel, kgrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmxz() {
		return _xmxz;
	}

	@Override
	public void setXmxz(String xmxz) {
		_xmxz = xmxz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setXmxz", String.class);

				method.invoke(_projectRemoteModel, xmxz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCjqk() {
		return _cjqk;
	}

	@Override
	public void setCjqk(String cjqk) {
		_cjqk = cjqk;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCjqk", String.class);

				method.invoke(_projectRemoteModel, cjqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSmqk() {
		return _smqk;
	}

	@Override
	public void setSmqk(String smqk) {
		_smqk = smqk;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSmqk", String.class);

				method.invoke(_projectRemoteModel, smqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjbz() {
		return _bjbz;
	}

	@Override
	public void setBjbz(String bjbz) {
		_bjbz = bjbz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbz", String.class);

				method.invoke(_projectRemoteModel, bjbz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFbzgsc() {
		return _fbzgsc;
	}

	@Override
	public void setFbzgsc(String fbzgsc) {
		_fbzgsc = fbzgsc;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setFbzgsc", String.class);

				method.invoke(_projectRemoteModel, fbzgsc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCardid() {
		return _cardid;
	}

	@Override
	public void setCardid(String cardid) {
		_cardid = cardid;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCardid", String.class);

				method.invoke(_projectRemoteModel, cardid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_1() {
		return _zjlygc_1;
	}

	@Override
	public void setZjlygc_1(String zjlygc_1) {
		_zjlygc_1 = zjlygc_1;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_1", String.class);

				method.invoke(_projectRemoteModel, zjlygc_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_2() {
		return _zjlygc_2;
	}

	@Override
	public void setZjlygc_2(String zjlygc_2) {
		_zjlygc_2 = zjlygc_2;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_2", String.class);

				method.invoke(_projectRemoteModel, zjlygc_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_3() {
		return _zjlygc_3;
	}

	@Override
	public void setZjlygc_3(String zjlygc_3) {
		_zjlygc_3 = zjlygc_3;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_3", String.class);

				method.invoke(_projectRemoteModel, zjlygc_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_4() {
		return _zjlygc_4;
	}

	@Override
	public void setZjlygc_4(String zjlygc_4) {
		_zjlygc_4 = zjlygc_4;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_4", String.class);

				method.invoke(_projectRemoteModel, zjlygc_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_5() {
		return _zjlygc_5;
	}

	@Override
	public void setZjlygc_5(String zjlygc_5) {
		_zjlygc_5 = zjlygc_5;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_5", String.class);

				method.invoke(_projectRemoteModel, zjlygc_5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_6() {
		return _zjlygc_6;
	}

	@Override
	public void setZjlygc_6(String zjlygc_6) {
		_zjlygc_6 = zjlygc_6;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_6", String.class);

				method.invoke(_projectRemoteModel, zjlygc_6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_7() {
		return _zjlygc_7;
	}

	@Override
	public void setZjlygc_7(String zjlygc_7) {
		_zjlygc_7 = zjlygc_7;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_7", String.class);

				method.invoke(_projectRemoteModel, zjlygc_7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_8() {
		return _zjlygc_8;
	}

	@Override
	public void setZjlygc_8(String zjlygc_8) {
		_zjlygc_8 = zjlygc_8;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_8", String.class);

				method.invoke(_projectRemoteModel, zjlygc_8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_9() {
		return _zjlygc_9;
	}

	@Override
	public void setZjlygc_9(String zjlygc_9) {
		_zjlygc_9 = zjlygc_9;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_9", String.class);

				method.invoke(_projectRemoteModel, zjlygc_9);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJgxs() {
		return _jgxs;
	}

	@Override
	public void setJgxs(String jgxs) {
		_jgxs = jgxs;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJgxs", String.class);

				method.invoke(_projectRemoteModel, jgxs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmfl() {
		return _xmfl;
	}

	@Override
	public void setXmfl(String xmfl) {
		_xmfl = xmfl;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfl", String.class);

				method.invoke(_projectRemoteModel, xmfl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJzmq() {
		return _jzmq;
	}

	@Override
	public void setJzmq(String jzmq) {
		_jzmq = jzmq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJzmq", String.class);

				method.invoke(_projectRemoteModel, jzmq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYwdt() {
		return _ywdt;
	}

	@Override
	public void setYwdt(String ywdt) {
		_ywdt = ywdt;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setYwdt", String.class);

				method.invoke(_projectRemoteModel, ywdt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDxsck() {
		return _dxsck;
	}

	@Override
	public void setDxsck(String dxsck) {
		_dxsck = dxsck;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setDxsck", String.class);

				method.invoke(_projectRemoteModel, dxsck);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBhjz() {
		return _bhjz;
	}

	@Override
	public void setBhjz(String bhjz) {
		_bhjz = bhjz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBhjz", String.class);

				method.invoke(_projectRemoteModel, bhjz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFjms() {
		return _fjms;
	}

	@Override
	public void setFjms(String fjms) {
		_fjms = fjms;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setFjms", String.class);

				method.invoke(_projectRemoteModel, fjms);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfsbxm() {
		return _sfsbxm;
	}

	@Override
	public void setSfsbxm(String sfsbxm) {
		_sfsbxm = sfsbxm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfsbxm", String.class);

				method.invoke(_projectRemoteModel, sfsbxm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHzyj() {
		return _hzyj;
	}

	@Override
	public void setHzyj(String hzyj) {
		_hzyj = hzyj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setHzyj", String.class);

				method.invoke(_projectRemoteModel, hzyj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBj_sx() {
		return _bj_sx;
	}

	@Override
	public void setBj_sx(String bj_sx) {
		_bj_sx = bj_sx;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBj_sx", String.class);

				method.invoke(_projectRemoteModel, bj_sx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBj_webid() {
		return _bj_webid;
	}

	@Override
	public void setBj_webid(String bj_webid) {
		_bj_webid = bj_webid;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBj_webid", String.class);

				method.invoke(_projectRemoteModel, bj_webid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjwcbj() {
		return _bjwcbj;
	}

	@Override
	public void setBjwcbj(String bjwcbj) {
		_bjwcbj = bjwcbj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBjwcbj", String.class);

				method.invoke(_projectRemoteModel, bjwcbj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBmdm() {
		return _bmdm;
	}

	@Override
	public void setBmdm(String bmdm) {
		_bmdm = bmdm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBmdm", String.class);

				method.invoke(_projectRemoteModel, bmdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJbr() {
		return _jbr;
	}

	@Override
	public void setJbr(String jbr) {
		_jbr = jbr;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJbr", String.class);

				method.invoke(_projectRemoteModel, jbr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShr() {
		return _shr;
	}

	@Override
	public void setShr(String shr) {
		_shr = shr;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setShr", String.class);

				method.invoke(_projectRemoteModel, shr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShbmdm() {
		return _shbmdm;
	}

	@Override
	public void setShbmdm(String shbmdm) {
		_shbmdm = shbmdm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setShbmdm", String.class);

				method.invoke(_projectRemoteModel, shbmdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWcbjsj() {
		return _wcbjsj;
	}

	@Override
	public void setWcbjsj(String wcbjsj) {
		_wcbjsj = wcbjsj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setWcbjsj", String.class);

				method.invoke(_projectRemoteModel, wcbjsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOld_bjbh() {
		return _old_bjbh;
	}

	@Override
	public void setOld_bjbh(String old_bjbh) {
		_old_bjbh = old_bjbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setOld_bjbh", String.class);

				method.invoke(_projectRemoteModel, old_bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSffb() {
		return _sffb;
	}

	@Override
	public void setSffb(String sffb) {
		_sffb = sffb;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSffb", String.class);

				method.invoke(_projectRemoteModel, sffb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTimeflag() {
		return _timeflag;
	}

	@Override
	public void setTimeflag(String timeflag) {
		_timeflag = timeflag;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setTimeflag", String.class);

				method.invoke(_projectRemoteModel, timeflag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJbrdm() {
		return _jbrdm;
	}

	@Override
	public void setJbrdm(String jbrdm) {
		_jbrdm = jbrdm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJbrdm", String.class);

				method.invoke(_projectRemoteModel, jbrdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShrdm() {
		return _shrdm;
	}

	@Override
	public void setShrdm(String shrdm) {
		_shrdm = shrdm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setShrdm", String.class);

				method.invoke(_projectRemoteModel, shrdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsbh() {
		return _jsbh;
	}

	@Override
	public void setJsbh(String jsbh) {
		_jsbh = jsbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsbh", String.class);

				method.invoke(_projectRemoteModel, jsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNeedSbjl() {
		return _needSbjl;
	}

	@Override
	public void setNeedSbjl(String needSbjl) {
		_needSbjl = needSbjl;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setNeedSbjl", String.class);

				method.invoke(_projectRemoteModel, needSbjl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWcSbjl() {
		return _wcSbjl;
	}

	@Override
	public void setWcSbjl(String wcSbjl) {
		_wcSbjl = wcSbjl;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setWcSbjl", String.class);

				method.invoke(_projectRemoteModel, wcSbjl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfgyzbkg() {
		return _sfgyzbkg;
	}

	@Override
	public void setSfgyzbkg(String sfgyzbkg) {
		_sfgyzbkg = sfgyzbkg;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfgyzbkg", String.class);

				method.invoke(_projectRemoteModel, sfgyzbkg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJyzxfbxx() {
		return _jyzxfbxx;
	}

	@Override
	public void setJyzxfbxx(String jyzxfbxx) {
		_jyzxfbxx = jyzxfbxx;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJyzxfbxx", String.class);

				method.invoke(_projectRemoteModel, jyzxfbxx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgGkzbfb() {
		return _sgGkzbfb;
	}

	@Override
	public void setSgGkzbfb(String sgGkzbfb) {
		_sgGkzbfb = sgGkzbfb;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSgGkzbfb", String.class);

				method.invoke(_projectRemoteModel, sgGkzbfb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgjlGkzbfb() {
		return _sgjlGkzbfb;
	}

	@Override
	public void setSgjlGkzbfb(String sgjlGkzbfb) {
		_sgjlGkzbfb = sgjlGkzbfb;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSgjlGkzbfb", String.class);

				method.invoke(_projectRemoteModel, sgjlGkzbfb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFxglxm() {
		return _fxglxm;
	}

	@Override
	public void setFxglxm(String fxglxm) {
		_fxglxm = fxglxm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setFxglxm", String.class);

				method.invoke(_projectRemoteModel, fxglxm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFxglxmJbr() {
		return _fxglxmJbr;
	}

	@Override
	public void setFxglxmJbr(String fxglxmJbr) {
		_fxglxmJbr = fxglxmJbr;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setFxglxmJbr", String.class);

				method.invoke(_projectRemoteModel, fxglxmJbr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFxglxmJbrdm() {
		return _fxglxmJbrdm;
	}

	@Override
	public void setFxglxmJbrdm(String fxglxmJbrdm) {
		_fxglxmJbrdm = fxglxmJbrdm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setFxglxmJbrdm", String.class);

				method.invoke(_projectRemoteModel, fxglxmJbrdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFxglxmJbrq() {
		return _fxglxmJbrq;
	}

	@Override
	public void setFxglxmJbrq(String fxglxmJbrq) {
		_fxglxmJbrq = fxglxmJbrq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setFxglxmJbrq", String.class);

				method.invoke(_projectRemoteModel, fxglxmJbrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwjgdm() {
		return _jsdwjgdm;
	}

	@Override
	public void setJsdwjgdm(String jsdwjgdm) {
		_jsdwjgdm = jsdwjgdm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwjgdm", String.class);

				method.invoke(_projectRemoteModel, jsdwjgdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSzqy() {
		return _szqy;
	}

	@Override
	public void setSzqy(String szqy) {
		_szqy = szqy;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSzqy", String.class);

				method.invoke(_projectRemoteModel, szqy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYwxjfwjz() {
		return _ywxjfwjz;
	}

	@Override
	public void setYwxjfwjz(String ywxjfwjz) {
		_ywxjfwjz = ywxjfwjz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setYwxjfwjz", String.class);

				method.invoke(_projectRemoteModel, ywxjfwjz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYwgbfwjg() {
		return _ywgbfwjg;
	}

	@Override
	public void setYwgbfwjg(String ywgbfwjg) {
		_ywgbfwjg = ywgbfwjg;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setYwgbfwjg", String.class);

				method.invoke(_projectRemoteModel, ywgbfwjg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGczh() {
		return _gczh;
	}

	@Override
	public void setGczh(String gczh) {
		_gczh = gczh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGczh", String.class);

				method.invoke(_projectRemoteModel, gczh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZdcyyn() {
		return _zdcyyn;
	}

	@Override
	public void setZdcyyn(String zdcyyn) {
		_zdcyyn = zdcyyn;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZdcyyn", String.class);

				method.invoke(_projectRemoteModel, zdcyyn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxfl() {
		return _lxfl;
	}

	@Override
	public void setLxfl(String lxfl) {
		_lxfl = lxfl;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setLxfl", String.class);

				method.invoke(_projectRemoteModel, lxfl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMs1() {
		return _ms1;
	}

	@Override
	public void setMs1(String ms1) {
		_ms1 = ms1;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setMs1", String.class);

				method.invoke(_projectRemoteModel, ms1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMs2() {
		return _ms2;
	}

	@Override
	public void setMs2(String ms2) {
		_ms2 = ms2;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setMs2", String.class);

				method.invoke(_projectRemoteModel, ms2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMs3() {
		return _ms3;
	}

	@Override
	public void setMs3(String ms3) {
		_ms3 = ms3;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setMs3", String.class);

				method.invoke(_projectRemoteModel, ms3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZdxmyn() {
		return _zdxmyn;
	}

	@Override
	public void setZdxmyn(String zdxmyn) {
		_zdxmyn = zdxmyn;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZdxmyn", String.class);

				method.invoke(_projectRemoteModel, zdxmyn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDxjzsq() {
		return _dxjzsq;
	}

	@Override
	public void setDxjzsq(String dxjzsq) {
		_dxjzsq = dxjzsq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setDxjzsq", String.class);

				method.invoke(_projectRemoteModel, dxjzsq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYwjzxzz() {
		return _ywjzxzz;
	}

	@Override
	public void setYwjzxzz(String ywjzxzz) {
		_ywjzxzz = ywjzxzz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setYwjzxzz", String.class);

				method.invoke(_projectRemoteModel, ywjzxzz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFgwjhm() {
		return _fgwjhm;
	}

	@Override
	public void setFgwjhm(String fgwjhm) {
		_fgwjhm = fgwjhm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setFgwjhm", String.class);

				method.invoke(_projectRemoteModel, fgwjhm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZzbl() {
		return _zzbl;
	}

	@Override
	public void setZzbl(String zzbl) {
		_zzbl = zzbl;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZzbl", String.class);

				method.invoke(_projectRemoteModel, zzbl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChangeTime() {
		return _ChangeTime;
	}

	@Override
	public void setChangeTime(String ChangeTime) {
		_ChangeTime = ChangeTime;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setChangeTime", String.class);

				method.invoke(_projectRemoteModel, ChangeTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPD_SW() {
		return _PD_SW;
	}

	@Override
	public void setPD_SW(String PD_SW) {
		_PD_SW = PD_SW;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPD_SW", String.class);

				method.invoke(_projectRemoteModel, PD_SW);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBmpfrq() {
		return _bmpfrq;
	}

	@Override
	public void setBmpfrq(String bmpfrq) {
		_bmpfrq = bmpfrq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBmpfrq", String.class);

				method.invoke(_projectRemoteModel, bmpfrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBmpfwh() {
		return _bmpfwh;
	}

	@Override
	public void setBmpfwh(String bmpfwh) {
		_bmpfwh = bmpfwh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBmpfwh", String.class);

				method.invoke(_projectRemoteModel, bmpfwh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBmpfwj() {
		return _bmpfwj;
	}

	@Override
	public void setBmpfwj(String bmpfwj) {
		_bmpfwj = bmpfwj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBmpfwj", String.class);

				method.invoke(_projectRemoteModel, bmpfwj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCertificateKey() {
		return _CertificateKey;
	}

	@Override
	public void setCertificateKey(String CertificateKey) {
		_CertificateKey = CertificateKey;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateKey",
						String.class);

				method.invoke(_projectRemoteModel, CertificateKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDsjzmj() {
		return _dsjzmj;
	}

	@Override
	public void setDsjzmj(String dsjzmj) {
		_dsjzmj = dsjzmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setDsjzmj", String.class);

				method.invoke(_projectRemoteModel, dsjzmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDxjzmj() {
		return _dxjzmj;
	}

	@Override
	public void setDxjzmj(String dxjzmj) {
		_dxjzmj = dxjzmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setDxjzmj", String.class);

				method.invoke(_projectRemoteModel, dxjzmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGdzctzbh() {
		return _gdzctzbh;
	}

	@Override
	public void setGdzctzbh(String gdzctzbh) {
		_gdzctzbh = gdzctzbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGdzctzbh", String.class);

				method.invoke(_projectRemoteModel, gdzctzbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsxz_2011() {
		return _jsxz_2011;
	}

	@Override
	public void setJsxz_2011(String jsxz_2011) {
		_jsxz_2011 = jsxz_2011;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setJsxz_2011", String.class);

				method.invoke(_projectRemoteModel, jsxz_2011);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLhmj() {
		return _lhmj;
	}

	@Override
	public void setLhmj(String lhmj) {
		_lhmj = lhmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setLhmj", String.class);

				method.invoke(_projectRemoteModel, lhmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxjb_2011() {
		return _lxjb_2011;
	}

	@Override
	public void setLxjb_2011(String lxjb_2011) {
		_lxjb_2011 = lxjb_2011;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setLxjb_2011", String.class);

				method.invoke(_projectRemoteModel, lxjb_2011);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMfmj() {
		return _mfmj;
	}

	@Override
	public void setMfmj(String mfmj) {
		_mfmj = mfmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setMfmj", String.class);

				method.invoke(_projectRemoteModel, mfmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOther_qx() {
		return _other_qx;
	}

	@Override
	public void setOther_qx(String other_qx) {
		_other_qx = other_qx;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setOther_qx", String.class);

				method.invoke(_projectRemoteModel, other_qx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectSlyj() {
		return _ProjectSlyj;
	}

	@Override
	public void setProjectSlyj(String ProjectSlyj) {
		_ProjectSlyj = ProjectSlyj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectSlyj", String.class);

				method.invoke(_projectRemoteModel, ProjectSlyj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQxbz() {
		return _qxbz;
	}

	@Override
	public void setQxbz(String qxbz) {
		_qxbz = qxbz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setQxbz", String.class);

				method.invoke(_projectRemoteModel, qxbz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfcysjkfq() {
		return _sfcysjkfq;
	}

	@Override
	public void setSfcysjkfq(String sfcysjkfq) {
		_sfcysjkfq = sfcysjkfq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfcysjkfq", String.class);

				method.invoke(_projectRemoteModel, sfcysjkfq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfmfss() {
		return _sfmfss;
	}

	@Override
	public void setSfmfss(String sfmfss) {
		_sfmfss = sfmfss;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfmfss", String.class);

				method.invoke(_projectRemoteModel, sfmfss);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSzqx() {
		return _szqx;
	}

	@Override
	public void setSzqx(String szqx) {
		_szqx = szqx;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSzqx", String.class);

				method.invoke(_projectRemoteModel, szqx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTsgs() {
		return _tsgs;
	}

	@Override
	public void setTsgs(String tsgs) {
		_tsgs = tsgs;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setTsgs", String.class);

				method.invoke(_projectRemoteModel, tsgs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmfl_2011() {
		return _xmfl_2011;
	}

	@Override
	public void setXmfl_2011(String xmfl_2011) {
		_xmfl_2011 = xmfl_2011;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfl_2011", String.class);

				method.invoke(_projectRemoteModel, xmfl_2011);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXsjpw() {
		return _xsjpw;
	}

	@Override
	public void setXsjpw(String xsjpw) {
		_xsjpw = xsjpw;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setXsjpw", String.class);

				method.invoke(_projectRemoteModel, xsjpw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXsjpzdw() {
		return _xsjpzdw;
	}

	@Override
	public void setXsjpzdw(String xsjpzdw) {
		_xsjpzdw = xsjpzdw;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setXsjpzdw", String.class);

				method.invoke(_projectRemoteModel, xsjpzdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_10() {
		return _zjlygc_10;
	}

	@Override
	public void setZjlygc_10(String zjlygc_10) {
		_zjlygc_10 = zjlygc_10;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_10", String.class);

				method.invoke(_projectRemoteModel, zjlygc_10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_11() {
		return _zjlygc_11;
	}

	@Override
	public void setZjlygc_11(String zjlygc_11) {
		_zjlygc_11 = zjlygc_11;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_11", String.class);

				method.invoke(_projectRemoteModel, zjlygc_11);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_xs_1() {
		return _zjlygc_xs_1;
	}

	@Override
	public void setZjlygc_xs_1(String zjlygc_xs_1) {
		_zjlygc_xs_1 = zjlygc_xs_1;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_xs_1", String.class);

				method.invoke(_projectRemoteModel, zjlygc_xs_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_xs_2() {
		return _zjlygc_xs_2;
	}

	@Override
	public void setZjlygc_xs_2(String zjlygc_xs_2) {
		_zjlygc_xs_2 = zjlygc_xs_2;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_xs_2", String.class);

				method.invoke(_projectRemoteModel, zjlygc_xs_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_xs_3() {
		return _zjlygc_xs_3;
	}

	@Override
	public void setZjlygc_xs_3(String zjlygc_xs_3) {
		_zjlygc_xs_3 = zjlygc_xs_3;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_xs_3", String.class);

				method.invoke(_projectRemoteModel, zjlygc_xs_3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_xs_4() {
		return _zjlygc_xs_4;
	}

	@Override
	public void setZjlygc_xs_4(String zjlygc_xs_4) {
		_zjlygc_xs_4 = zjlygc_xs_4;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_xs_4", String.class);

				method.invoke(_projectRemoteModel, zjlygc_xs_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_1_2() {
		return _zjlygc_1_2;
	}

	@Override
	public void setZjlygc_1_2(String zjlygc_1_2) {
		_zjlygc_1_2 = zjlygc_1_2;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_1_2", String.class);

				method.invoke(_projectRemoteModel, zjlygc_1_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc_1_2_4() {
		return _zjlygc_1_2_4;
	}

	@Override
	public void setZjlygc_1_2_4(String zjlygc_1_2_4) {
		_zjlygc_1_2_4 = zjlygc_1_2_4;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc_1_2_4", String.class);

				method.invoke(_projectRemoteModel, zjlygc_1_2_4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYwptlh() {
		return _ywptlh;
	}

	@Override
	public void setYwptlh(String ywptlh) {
		_ywptlh = ywptlh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setYwptlh", String.class);

				method.invoke(_projectRemoteModel, ywptlh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGyyqbh() {
		return _gyyqbh;
	}

	@Override
	public void setGyyqbh(String gyyqbh) {
		_gyyqbh = gyyqbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setGyyqbh", String.class);

				method.invoke(_projectRemoteModel, gyyqbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfcyxm() {
		return _sfcyxm;
	}

	@Override
	public void setSfcyxm(String sfcyxm) {
		_sfcyxm = sfcyxm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfcyxm", String.class);

				method.invoke(_projectRemoteModel, sfcyxm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZbxmfzrxm() {
		return _zbxmfzrxm;
	}

	@Override
	public void setZbxmfzrxm(String zbxmfzrxm) {
		_zbxmfzrxm = zbxmfzrxm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZbxmfzrxm", String.class);

				method.invoke(_projectRemoteModel, zbxmfzrxm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZbxmfzrzjh() {
		return _zbxmfzrzjh;
	}

	@Override
	public void setZbxmfzrzjh(String zbxmfzrzjh) {
		_zbxmfzrzjh = zbxmfzrzjh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZbxmfzrzjh", String.class);

				method.invoke(_projectRemoteModel, zbxmfzrzjh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZbxmfzrzjlx() {
		return _zbxmfzrzjlx;
	}

	@Override
	public void setZbxmfzrzjlx(String zbxmfzrzjlx) {
		_zbxmfzrzjlx = zbxmfzrzjlx;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZbxmfzrzjlx", String.class);

				method.invoke(_projectRemoteModel, zbxmfzrzjlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZbxmfzrqrsj() {
		return _zbxmfzrqrsj;
	}

	@Override
	public void setZbxmfzrqrsj(String zbxmfzrqrsj) {
		_zbxmfzrqrsj = zbxmfzrqrsj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZbxmfzrqrsj", String.class);

				method.invoke(_projectRemoteModel, zbxmfzrqrsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSflsjzbs() {
		return _sflsjzbs;
	}

	@Override
	public void setSflsjzbs(String sflsjzbs) {
		_sflsjzbs = sflsjzbs;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSflsjzbs", String.class);

				method.invoke(_projectRemoteModel, sflsjzbs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjbs() {
		return _sjbs;
	}

	@Override
	public void setSjbs(String sjbs) {
		_sjbs = sjbs;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSjbs", String.class);

				method.invoke(_projectRemoteModel, sjbs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYxbs() {
		return _yxbs;
	}

	@Override
	public void setYxbs(String yxbs) {
		_yxbs = yxbs;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setYxbs", String.class);

				method.invoke(_projectRemoteModel, yxbs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfyjngz() {
		return _sfyjngz;
	}

	@Override
	public void setSfyjngz(String sfyjngz) {
		_sfyjngz = sfyjngz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfyjngz", String.class);

				method.invoke(_projectRemoteModel, sfyjngz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfsszpjz() {
		return _sfsszpjz;
	}

	@Override
	public void setSfsszpjz(String sfsszpjz) {
		_sfsszpjz = sfsszpjz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfsszpjz", String.class);

				method.invoke(_projectRemoteModel, sfsszpjz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZczxjgdmz() {
		return _zczxjgdmz;
	}

	@Override
	public void setZczxjgdmz(String zczxjgdmz) {
		_zczxjgdmz = zczxjgdmz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZczxjgdmz", String.class);

				method.invoke(_projectRemoteModel, zczxjgdmz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIscheckxmbm() {
		return _ischeckxmbm;
	}

	@Override
	public void setIscheckxmbm(String ischeckxmbm) {
		_ischeckxmbm = ischeckxmbm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setIscheckxmbm", String.class);

				method.invoke(_projectRemoteModel, ischeckxmbm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZddtmj() {
		return _zddtmj;
	}

	@Override
	public void setZddtmj(String zddtmj) {
		_zddtmj = zddtmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZddtmj", String.class);

				method.invoke(_projectRemoteModel, zddtmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjjdYn() {
		return _sjjdYn;
	}

	@Override
	public void setSjjdYn(String sjjdYn) {
		_sjjdYn = sjjdYn;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSjjdYn", String.class);

				method.invoke(_projectRemoteModel, sjjdYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgjdYn() {
		return _sgjdYn;
	}

	@Override
	public void setSgjdYn(String sgjdYn) {
		_sgjdYn = sgjdYn;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSgjdYn", String.class);

				method.invoke(_projectRemoteModel, sgjdYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYxjdYn() {
		return _yxjdYn;
	}

	@Override
	public void setYxjdYn(String yxjdYn) {
		_yxjdYn = yxjdYn;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setYxjdYn", String.class);

				method.invoke(_projectRemoteModel, yxjdYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTdhtqdbh() {
		return _tdhtqdbh;
	}

	@Override
	public void setTdhtqdbh(String tdhtqdbh) {
		_tdhtqdbh = tdhtqdbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setTdhtqdbh", String.class);

				method.invoke(_projectRemoteModel, tdhtqdbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTdhtqdrq() {
		return _tdhtqdrq;
	}

	@Override
	public void setTdhtqdrq(String tdhtqdrq) {
		_tdhtqdrq = tdhtqdrq;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setTdhtqdrq", String.class);

				method.invoke(_projectRemoteModel, tdhtqdrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDkbh() {
		return _dkbh;
	}

	@Override
	public void setDkbh(String dkbh) {
		_dkbh = dkbh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setDkbh", String.class);

				method.invoke(_projectRemoteModel, dkbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZpsjzlsbl() {
		return _zpsjzlsbl;
	}

	@Override
	public void setZpsjzlsbl(String zpsjzlsbl) {
		_zpsjzlsbl = zpsjzlsbl;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZpsjzlsbl", String.class);

				method.invoke(_projectRemoteModel, zpsjzlsbl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZpsjzmj() {
		return _zpsjzmj;
	}

	@Override
	public void setZpsjzmj(String zpsjzmj) {
		_zpsjzmj = zpsjzmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZpsjzmj", String.class);

				method.invoke(_projectRemoteModel, zpsjzmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDwyzzpl() {
		return _dwyzzpl;
	}

	@Override
	public void setDwyzzpl(String dwyzzpl) {
		_dwyzzpl = dwyzzpl;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setDwyzzpl", String.class);

				method.invoke(_projectRemoteModel, dwyzzpl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZdh() {
		return _zdh;
	}

	@Override
	public void setZdh(String zdh) {
		_zdh = zdh;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZdh", String.class);

				method.invoke(_projectRemoteModel, zdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfgdcg() {
		return _sfgdcg;
	}

	@Override
	public void setSfgdcg(String sfgdcg) {
		_sfgdcg = sfgdcg;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfgdcg", String.class);

				method.invoke(_projectRemoteModel, sfgdcg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPtlhmj() {
		return _ptlhmj;
	}

	@Override
	public void setPtlhmj(String ptlhmj) {
		_ptlhmj = ptlhmj;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPtlhmj", String.class);

				method.invoke(_projectRemoteModel, ptlhmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBimjszxfy() {
		return _bimjszxfy;
	}

	@Override
	public void setBimjszxfy(String bimjszxfy) {
		_bimjszxfy = bimjszxfy;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBimjszxfy", String.class);

				method.invoke(_projectRemoteModel, bimjszxfy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBz() {
		return _bz;
	}

	@Override
	public void setBz(String bz) {
		_bz = bz;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setBz", String.class);

				method.invoke(_projectRemoteModel, bz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfzcxm() {
		return _sfzcxm;
	}

	@Override
	public void setSfzcxm(String sfzcxm) {
		_sfzcxm = sfzcxm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfzcxm", String.class);

				method.invoke(_projectRemoteModel, sfzcxm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZcxmbm() {
		return _zcxmbm;
	}

	@Override
	public void setZcxmbm(String zcxmbm) {
		_zcxmbm = zcxmbm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setZcxmbm", String.class);

				method.invoke(_projectRemoteModel, zcxmbm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfzmqxm() {
		return _sfzmqxm;
	}

	@Override
	public void setSfzmqxm(String sfzmqxm) {
		_sfzmqxm = sfzmqxm;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setSfzmqxm", String.class);

				method.invoke(_projectRemoteModel, sfzmqxm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrintPDFTime() {
		return _printPDFTime;
	}

	@Override
	public void setPrintPDFTime(String printPDFTime) {
		_printPDFTime = printPDFTime;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setPrintPDFTime", String.class);

				method.invoke(_projectRemoteModel, printPDFTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsBgPrint() {
		return _isBgPrint;
	}

	@Override
	public void setIsBgPrint(String isBgPrint) {
		_isBgPrint = isBgPrint;

		if (_projectRemoteModel != null) {
			try {
				Class<?> clazz = _projectRemoteModel.getClass();

				Method method = clazz.getMethod("setIsBgPrint", String.class);

				method.invoke(_projectRemoteModel, isBgPrint);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProjectRemoteModel() {
		return _projectRemoteModel;
	}

	public void setProjectRemoteModel(BaseModel<?> projectRemoteModel) {
		_projectRemoteModel = projectRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _projectRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_projectRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProjectLocalServiceUtil.addProject(this);
		}
		else {
			ProjectLocalServiceUtil.updateProject(this);
		}
	}

	@Override
	public Project toEscapedModel() {
		return (Project)ProxyUtil.newProxyInstance(Project.class.getClassLoader(),
			new Class[] { Project.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProjectClp clone = new ProjectClp();

		clone.setBjbh(getBjbh());
		clone.setBjrq(getBjrq());
		clone.setJsdw(getJsdw());
		clone.setJsdwxz(getJsdwxz());
		clone.setJsdwdz(getJsdwdz());
		clone.setJsdwdh(getJsdwdh());
		clone.setJsdwfr(getJsdwfr());
		clone.setJsdwlxr(getJsdwlxr());
		clone.setJsdwyb(getJsdwyb());
		clone.setJsdwzczj(getJsdwzczj());
		clone.setXmmc(getXmmc());
		clone.setJsdd(getJsdd());
		clone.setLxwj(getLxwj());
		clone.setLxwh(getLxwh());
		clone.setLxjb(getLxjb());
		clone.setPzjg(getPzjg());
		clone.setPzrq(getPzrq());
		clone.setZtz(getZtz());
		clone.setSbtz(getSbtz());
		clone.setJsxz(getJsxz());
		clone.setJsgm(getJsgm());
		clone.setZmj(getZmj());
		clone.setKgrq(getKgrq());
		clone.setXmxz(getXmxz());
		clone.setCjqk(getCjqk());
		clone.setSmqk(getSmqk());
		clone.setBjbz(getBjbz());
		clone.setFbzgsc(getFbzgsc());
		clone.setCardid(getCardid());
		clone.setZjlygc_1(getZjlygc_1());
		clone.setZjlygc_2(getZjlygc_2());
		clone.setZjlygc_3(getZjlygc_3());
		clone.setZjlygc_4(getZjlygc_4());
		clone.setZjlygc_5(getZjlygc_5());
		clone.setZjlygc_6(getZjlygc_6());
		clone.setZjlygc_7(getZjlygc_7());
		clone.setZjlygc_8(getZjlygc_8());
		clone.setZjlygc_9(getZjlygc_9());
		clone.setJgxs(getJgxs());
		clone.setXmfl(getXmfl());
		clone.setJzmq(getJzmq());
		clone.setYwdt(getYwdt());
		clone.setDxsck(getDxsck());
		clone.setBhjz(getBhjz());
		clone.setFjms(getFjms());
		clone.setSfsbxm(getSfsbxm());
		clone.setHzyj(getHzyj());
		clone.setBj_sx(getBj_sx());
		clone.setBj_webid(getBj_webid());
		clone.setBjwcbj(getBjwcbj());
		clone.setBmdm(getBmdm());
		clone.setJbr(getJbr());
		clone.setShr(getShr());
		clone.setShbmdm(getShbmdm());
		clone.setWcbjsj(getWcbjsj());
		clone.setOld_bjbh(getOld_bjbh());
		clone.setSffb(getSffb());
		clone.setTimeflag(getTimeflag());
		clone.setJbrdm(getJbrdm());
		clone.setShrdm(getShrdm());
		clone.setJsbh(getJsbh());
		clone.setNeedSbjl(getNeedSbjl());
		clone.setWcSbjl(getWcSbjl());
		clone.setSfgyzbkg(getSfgyzbkg());
		clone.setJyzxfbxx(getJyzxfbxx());
		clone.setSgGkzbfb(getSgGkzbfb());
		clone.setSgjlGkzbfb(getSgjlGkzbfb());
		clone.setFxglxm(getFxglxm());
		clone.setFxglxmJbr(getFxglxmJbr());
		clone.setFxglxmJbrdm(getFxglxmJbrdm());
		clone.setFxglxmJbrq(getFxglxmJbrq());
		clone.setJsdwjgdm(getJsdwjgdm());
		clone.setSzqy(getSzqy());
		clone.setYwxjfwjz(getYwxjfwjz());
		clone.setYwgbfwjg(getYwgbfwjg());
		clone.setGczh(getGczh());
		clone.setZdcyyn(getZdcyyn());
		clone.setLxfl(getLxfl());
		clone.setMs1(getMs1());
		clone.setMs2(getMs2());
		clone.setMs3(getMs3());
		clone.setZdxmyn(getZdxmyn());
		clone.setDxjzsq(getDxjzsq());
		clone.setYwjzxzz(getYwjzxzz());
		clone.setFgwjhm(getFgwjhm());
		clone.setZzbl(getZzbl());
		clone.setChangeTime(getChangeTime());
		clone.setPD_SW(getPD_SW());
		clone.setBmpfrq(getBmpfrq());
		clone.setBmpfwh(getBmpfwh());
		clone.setBmpfwj(getBmpfwj());
		clone.setCertificateKey(getCertificateKey());
		clone.setDsjzmj(getDsjzmj());
		clone.setDxjzmj(getDxjzmj());
		clone.setGdzctzbh(getGdzctzbh());
		clone.setJsxz_2011(getJsxz_2011());
		clone.setLhmj(getLhmj());
		clone.setLxjb_2011(getLxjb_2011());
		clone.setMfmj(getMfmj());
		clone.setOther_qx(getOther_qx());
		clone.setProjectSlyj(getProjectSlyj());
		clone.setQxbz(getQxbz());
		clone.setSfcysjkfq(getSfcysjkfq());
		clone.setSfmfss(getSfmfss());
		clone.setSzqx(getSzqx());
		clone.setTsgs(getTsgs());
		clone.setXmfl_2011(getXmfl_2011());
		clone.setXsjpw(getXsjpw());
		clone.setXsjpzdw(getXsjpzdw());
		clone.setZjlygc_10(getZjlygc_10());
		clone.setZjlygc_11(getZjlygc_11());
		clone.setZjlygc_xs_1(getZjlygc_xs_1());
		clone.setZjlygc_xs_2(getZjlygc_xs_2());
		clone.setZjlygc_xs_3(getZjlygc_xs_3());
		clone.setZjlygc_xs_4(getZjlygc_xs_4());
		clone.setZjlygc_1_2(getZjlygc_1_2());
		clone.setZjlygc_1_2_4(getZjlygc_1_2_4());
		clone.setYwptlh(getYwptlh());
		clone.setGyyqbh(getGyyqbh());
		clone.setSfcyxm(getSfcyxm());
		clone.setZbxmfzrxm(getZbxmfzrxm());
		clone.setZbxmfzrzjh(getZbxmfzrzjh());
		clone.setZbxmfzrzjlx(getZbxmfzrzjlx());
		clone.setZbxmfzrqrsj(getZbxmfzrqrsj());
		clone.setSflsjzbs(getSflsjzbs());
		clone.setSjbs(getSjbs());
		clone.setYxbs(getYxbs());
		clone.setSfyjngz(getSfyjngz());
		clone.setSfsszpjz(getSfsszpjz());
		clone.setZczxjgdmz(getZczxjgdmz());
		clone.setIscheckxmbm(getIscheckxmbm());
		clone.setZddtmj(getZddtmj());
		clone.setSjjdYn(getSjjdYn());
		clone.setSgjdYn(getSgjdYn());
		clone.setYxjdYn(getYxjdYn());
		clone.setTdhtqdbh(getTdhtqdbh());
		clone.setTdhtqdrq(getTdhtqdrq());
		clone.setDkbh(getDkbh());
		clone.setZpsjzlsbl(getZpsjzlsbl());
		clone.setZpsjzmj(getZpsjzmj());
		clone.setDwyzzpl(getDwyzzpl());
		clone.setZdh(getZdh());
		clone.setSfgdcg(getSfgdcg());
		clone.setPtlhmj(getPtlhmj());
		clone.setBimjszxfy(getBimjszxfy());
		clone.setBz(getBz());
		clone.setSfzcxm(getSfzcxm());
		clone.setZcxmbm(getZcxmbm());
		clone.setSfzmqxm(getSfzmqxm());
		clone.setPrintPDFTime(getPrintPDFTime());
		clone.setIsBgPrint(getIsBgPrint());

		return clone;
	}

	@Override
	public int compareTo(Project project) {
		int value = 0;

		value = DateUtil.compareTo(getBjrq(), project.getBjrq());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectClp)) {
			return false;
		}

		ProjectClp project = (ProjectClp)obj;

		String primaryKey = project.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(303);

		sb.append("{bjbh=");
		sb.append(getBjbh());
		sb.append(", bjrq=");
		sb.append(getBjrq());
		sb.append(", jsdw=");
		sb.append(getJsdw());
		sb.append(", jsdwxz=");
		sb.append(getJsdwxz());
		sb.append(", jsdwdz=");
		sb.append(getJsdwdz());
		sb.append(", jsdwdh=");
		sb.append(getJsdwdh());
		sb.append(", jsdwfr=");
		sb.append(getJsdwfr());
		sb.append(", jsdwlxr=");
		sb.append(getJsdwlxr());
		sb.append(", jsdwyb=");
		sb.append(getJsdwyb());
		sb.append(", jsdwzczj=");
		sb.append(getJsdwzczj());
		sb.append(", xmmc=");
		sb.append(getXmmc());
		sb.append(", jsdd=");
		sb.append(getJsdd());
		sb.append(", lxwj=");
		sb.append(getLxwj());
		sb.append(", lxwh=");
		sb.append(getLxwh());
		sb.append(", lxjb=");
		sb.append(getLxjb());
		sb.append(", pzjg=");
		sb.append(getPzjg());
		sb.append(", pzrq=");
		sb.append(getPzrq());
		sb.append(", ztz=");
		sb.append(getZtz());
		sb.append(", sbtz=");
		sb.append(getSbtz());
		sb.append(", jsxz=");
		sb.append(getJsxz());
		sb.append(", jsgm=");
		sb.append(getJsgm());
		sb.append(", zmj=");
		sb.append(getZmj());
		sb.append(", kgrq=");
		sb.append(getKgrq());
		sb.append(", xmxz=");
		sb.append(getXmxz());
		sb.append(", cjqk=");
		sb.append(getCjqk());
		sb.append(", smqk=");
		sb.append(getSmqk());
		sb.append(", bjbz=");
		sb.append(getBjbz());
		sb.append(", fbzgsc=");
		sb.append(getFbzgsc());
		sb.append(", cardid=");
		sb.append(getCardid());
		sb.append(", zjlygc_1=");
		sb.append(getZjlygc_1());
		sb.append(", zjlygc_2=");
		sb.append(getZjlygc_2());
		sb.append(", zjlygc_3=");
		sb.append(getZjlygc_3());
		sb.append(", zjlygc_4=");
		sb.append(getZjlygc_4());
		sb.append(", zjlygc_5=");
		sb.append(getZjlygc_5());
		sb.append(", zjlygc_6=");
		sb.append(getZjlygc_6());
		sb.append(", zjlygc_7=");
		sb.append(getZjlygc_7());
		sb.append(", zjlygc_8=");
		sb.append(getZjlygc_8());
		sb.append(", zjlygc_9=");
		sb.append(getZjlygc_9());
		sb.append(", jgxs=");
		sb.append(getJgxs());
		sb.append(", xmfl=");
		sb.append(getXmfl());
		sb.append(", jzmq=");
		sb.append(getJzmq());
		sb.append(", ywdt=");
		sb.append(getYwdt());
		sb.append(", dxsck=");
		sb.append(getDxsck());
		sb.append(", bhjz=");
		sb.append(getBhjz());
		sb.append(", fjms=");
		sb.append(getFjms());
		sb.append(", sfsbxm=");
		sb.append(getSfsbxm());
		sb.append(", hzyj=");
		sb.append(getHzyj());
		sb.append(", bj_sx=");
		sb.append(getBj_sx());
		sb.append(", bj_webid=");
		sb.append(getBj_webid());
		sb.append(", bjwcbj=");
		sb.append(getBjwcbj());
		sb.append(", bmdm=");
		sb.append(getBmdm());
		sb.append(", jbr=");
		sb.append(getJbr());
		sb.append(", shr=");
		sb.append(getShr());
		sb.append(", shbmdm=");
		sb.append(getShbmdm());
		sb.append(", wcbjsj=");
		sb.append(getWcbjsj());
		sb.append(", old_bjbh=");
		sb.append(getOld_bjbh());
		sb.append(", sffb=");
		sb.append(getSffb());
		sb.append(", timeflag=");
		sb.append(getTimeflag());
		sb.append(", jbrdm=");
		sb.append(getJbrdm());
		sb.append(", shrdm=");
		sb.append(getShrdm());
		sb.append(", jsbh=");
		sb.append(getJsbh());
		sb.append(", needSbjl=");
		sb.append(getNeedSbjl());
		sb.append(", wcSbjl=");
		sb.append(getWcSbjl());
		sb.append(", sfgyzbkg=");
		sb.append(getSfgyzbkg());
		sb.append(", jyzxfbxx=");
		sb.append(getJyzxfbxx());
		sb.append(", sgGkzbfb=");
		sb.append(getSgGkzbfb());
		sb.append(", sgjlGkzbfb=");
		sb.append(getSgjlGkzbfb());
		sb.append(", fxglxm=");
		sb.append(getFxglxm());
		sb.append(", fxglxmJbr=");
		sb.append(getFxglxmJbr());
		sb.append(", fxglxmJbrdm=");
		sb.append(getFxglxmJbrdm());
		sb.append(", fxglxmJbrq=");
		sb.append(getFxglxmJbrq());
		sb.append(", jsdwjgdm=");
		sb.append(getJsdwjgdm());
		sb.append(", szqy=");
		sb.append(getSzqy());
		sb.append(", ywxjfwjz=");
		sb.append(getYwxjfwjz());
		sb.append(", ywgbfwjg=");
		sb.append(getYwgbfwjg());
		sb.append(", gczh=");
		sb.append(getGczh());
		sb.append(", zdcyyn=");
		sb.append(getZdcyyn());
		sb.append(", lxfl=");
		sb.append(getLxfl());
		sb.append(", ms1=");
		sb.append(getMs1());
		sb.append(", ms2=");
		sb.append(getMs2());
		sb.append(", ms3=");
		sb.append(getMs3());
		sb.append(", zdxmyn=");
		sb.append(getZdxmyn());
		sb.append(", dxjzsq=");
		sb.append(getDxjzsq());
		sb.append(", ywjzxzz=");
		sb.append(getYwjzxzz());
		sb.append(", fgwjhm=");
		sb.append(getFgwjhm());
		sb.append(", zzbl=");
		sb.append(getZzbl());
		sb.append(", ChangeTime=");
		sb.append(getChangeTime());
		sb.append(", PD_SW=");
		sb.append(getPD_SW());
		sb.append(", bmpfrq=");
		sb.append(getBmpfrq());
		sb.append(", bmpfwh=");
		sb.append(getBmpfwh());
		sb.append(", bmpfwj=");
		sb.append(getBmpfwj());
		sb.append(", CertificateKey=");
		sb.append(getCertificateKey());
		sb.append(", dsjzmj=");
		sb.append(getDsjzmj());
		sb.append(", dxjzmj=");
		sb.append(getDxjzmj());
		sb.append(", gdzctzbh=");
		sb.append(getGdzctzbh());
		sb.append(", jsxz_2011=");
		sb.append(getJsxz_2011());
		sb.append(", lhmj=");
		sb.append(getLhmj());
		sb.append(", lxjb_2011=");
		sb.append(getLxjb_2011());
		sb.append(", mfmj=");
		sb.append(getMfmj());
		sb.append(", other_qx=");
		sb.append(getOther_qx());
		sb.append(", ProjectSlyj=");
		sb.append(getProjectSlyj());
		sb.append(", qxbz=");
		sb.append(getQxbz());
		sb.append(", sfcysjkfq=");
		sb.append(getSfcysjkfq());
		sb.append(", sfmfss=");
		sb.append(getSfmfss());
		sb.append(", szqx=");
		sb.append(getSzqx());
		sb.append(", tsgs=");
		sb.append(getTsgs());
		sb.append(", xmfl_2011=");
		sb.append(getXmfl_2011());
		sb.append(", xsjpw=");
		sb.append(getXsjpw());
		sb.append(", xsjpzdw=");
		sb.append(getXsjpzdw());
		sb.append(", zjlygc_10=");
		sb.append(getZjlygc_10());
		sb.append(", zjlygc_11=");
		sb.append(getZjlygc_11());
		sb.append(", zjlygc_xs_1=");
		sb.append(getZjlygc_xs_1());
		sb.append(", zjlygc_xs_2=");
		sb.append(getZjlygc_xs_2());
		sb.append(", zjlygc_xs_3=");
		sb.append(getZjlygc_xs_3());
		sb.append(", zjlygc_xs_4=");
		sb.append(getZjlygc_xs_4());
		sb.append(", zjlygc_1_2=");
		sb.append(getZjlygc_1_2());
		sb.append(", zjlygc_1_2_4=");
		sb.append(getZjlygc_1_2_4());
		sb.append(", ywptlh=");
		sb.append(getYwptlh());
		sb.append(", gyyqbh=");
		sb.append(getGyyqbh());
		sb.append(", sfcyxm=");
		sb.append(getSfcyxm());
		sb.append(", zbxmfzrxm=");
		sb.append(getZbxmfzrxm());
		sb.append(", zbxmfzrzjh=");
		sb.append(getZbxmfzrzjh());
		sb.append(", zbxmfzrzjlx=");
		sb.append(getZbxmfzrzjlx());
		sb.append(", zbxmfzrqrsj=");
		sb.append(getZbxmfzrqrsj());
		sb.append(", sflsjzbs=");
		sb.append(getSflsjzbs());
		sb.append(", sjbs=");
		sb.append(getSjbs());
		sb.append(", yxbs=");
		sb.append(getYxbs());
		sb.append(", sfyjngz=");
		sb.append(getSfyjngz());
		sb.append(", sfsszpjz=");
		sb.append(getSfsszpjz());
		sb.append(", zczxjgdmz=");
		sb.append(getZczxjgdmz());
		sb.append(", ischeckxmbm=");
		sb.append(getIscheckxmbm());
		sb.append(", zddtmj=");
		sb.append(getZddtmj());
		sb.append(", sjjdYn=");
		sb.append(getSjjdYn());
		sb.append(", sgjdYn=");
		sb.append(getSgjdYn());
		sb.append(", yxjdYn=");
		sb.append(getYxjdYn());
		sb.append(", tdhtqdbh=");
		sb.append(getTdhtqdbh());
		sb.append(", tdhtqdrq=");
		sb.append(getTdhtqdrq());
		sb.append(", dkbh=");
		sb.append(getDkbh());
		sb.append(", zpsjzlsbl=");
		sb.append(getZpsjzlsbl());
		sb.append(", zpsjzmj=");
		sb.append(getZpsjzmj());
		sb.append(", dwyzzpl=");
		sb.append(getDwyzzpl());
		sb.append(", zdh=");
		sb.append(getZdh());
		sb.append(", sfgdcg=");
		sb.append(getSfgdcg());
		sb.append(", ptlhmj=");
		sb.append(getPtlhmj());
		sb.append(", bimjszxfy=");
		sb.append(getBimjszxfy());
		sb.append(", bz=");
		sb.append(getBz());
		sb.append(", sfzcxm=");
		sb.append(getSfzcxm());
		sb.append(", zcxmbm=");
		sb.append(getZcxmbm());
		sb.append(", sfzmqxm=");
		sb.append(getSfzmqxm());
		sb.append(", printPDFTime=");
		sb.append(getPrintPDFTime());
		sb.append(", isBgPrint=");
		sb.append(getIsBgPrint());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(457);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.project.model.Project");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjrq</column-name><column-value><![CDATA[");
		sb.append(getBjrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdw</column-name><column-value><![CDATA[");
		sb.append(getJsdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwxz</column-name><column-value><![CDATA[");
		sb.append(getJsdwxz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwdz</column-name><column-value><![CDATA[");
		sb.append(getJsdwdz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwdh</column-name><column-value><![CDATA[");
		sb.append(getJsdwdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwfr</column-name><column-value><![CDATA[");
		sb.append(getJsdwfr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwlxr</column-name><column-value><![CDATA[");
		sb.append(getJsdwlxr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwyb</column-name><column-value><![CDATA[");
		sb.append(getJsdwyb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwzczj</column-name><column-value><![CDATA[");
		sb.append(getJsdwzczj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmmc</column-name><column-value><![CDATA[");
		sb.append(getXmmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdd</column-name><column-value><![CDATA[");
		sb.append(getJsdd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxwj</column-name><column-value><![CDATA[");
		sb.append(getLxwj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxwh</column-name><column-value><![CDATA[");
		sb.append(getLxwh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxjb</column-name><column-value><![CDATA[");
		sb.append(getLxjb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pzjg</column-name><column-value><![CDATA[");
		sb.append(getPzjg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pzrq</column-name><column-value><![CDATA[");
		sb.append(getPzrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ztz</column-name><column-value><![CDATA[");
		sb.append(getZtz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sbtz</column-name><column-value><![CDATA[");
		sb.append(getSbtz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsxz</column-name><column-value><![CDATA[");
		sb.append(getJsxz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgm</column-name><column-value><![CDATA[");
		sb.append(getJsgm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zmj</column-name><column-value><![CDATA[");
		sb.append(getZmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kgrq</column-name><column-value><![CDATA[");
		sb.append(getKgrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmxz</column-name><column-value><![CDATA[");
		sb.append(getXmxz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cjqk</column-name><column-value><![CDATA[");
		sb.append(getCjqk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smqk</column-name><column-value><![CDATA[");
		sb.append(getSmqk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbz</column-name><column-value><![CDATA[");
		sb.append(getBjbz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fbzgsc</column-name><column-value><![CDATA[");
		sb.append(getFbzgsc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardid</column-name><column-value><![CDATA[");
		sb.append(getCardid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_1</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_2</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_3</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_4</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_5</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_6</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_7</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_8</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_9</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_9());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jgxs</column-name><column-value><![CDATA[");
		sb.append(getJgxs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfl</column-name><column-value><![CDATA[");
		sb.append(getXmfl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jzmq</column-name><column-value><![CDATA[");
		sb.append(getJzmq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ywdt</column-name><column-value><![CDATA[");
		sb.append(getYwdt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dxsck</column-name><column-value><![CDATA[");
		sb.append(getDxsck());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bhjz</column-name><column-value><![CDATA[");
		sb.append(getBhjz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fjms</column-name><column-value><![CDATA[");
		sb.append(getFjms());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfsbxm</column-name><column-value><![CDATA[");
		sb.append(getSfsbxm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hzyj</column-name><column-value><![CDATA[");
		sb.append(getHzyj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bj_sx</column-name><column-value><![CDATA[");
		sb.append(getBj_sx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bj_webid</column-name><column-value><![CDATA[");
		sb.append(getBj_webid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjwcbj</column-name><column-value><![CDATA[");
		sb.append(getBjwcbj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bmdm</column-name><column-value><![CDATA[");
		sb.append(getBmdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jbr</column-name><column-value><![CDATA[");
		sb.append(getJbr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shr</column-name><column-value><![CDATA[");
		sb.append(getShr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shbmdm</column-name><column-value><![CDATA[");
		sb.append(getShbmdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wcbjsj</column-name><column-value><![CDATA[");
		sb.append(getWcbjsj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>old_bjbh</column-name><column-value><![CDATA[");
		sb.append(getOld_bjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sffb</column-name><column-value><![CDATA[");
		sb.append(getSffb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeflag</column-name><column-value><![CDATA[");
		sb.append(getTimeflag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jbrdm</column-name><column-value><![CDATA[");
		sb.append(getJbrdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shrdm</column-name><column-value><![CDATA[");
		sb.append(getShrdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsbh</column-name><column-value><![CDATA[");
		sb.append(getJsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>needSbjl</column-name><column-value><![CDATA[");
		sb.append(getNeedSbjl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wcSbjl</column-name><column-value><![CDATA[");
		sb.append(getWcSbjl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfgyzbkg</column-name><column-value><![CDATA[");
		sb.append(getSfgyzbkg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jyzxfbxx</column-name><column-value><![CDATA[");
		sb.append(getJyzxfbxx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgGkzbfb</column-name><column-value><![CDATA[");
		sb.append(getSgGkzbfb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgjlGkzbfb</column-name><column-value><![CDATA[");
		sb.append(getSgjlGkzbfb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fxglxm</column-name><column-value><![CDATA[");
		sb.append(getFxglxm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fxglxmJbr</column-name><column-value><![CDATA[");
		sb.append(getFxglxmJbr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fxglxmJbrdm</column-name><column-value><![CDATA[");
		sb.append(getFxglxmJbrdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fxglxmJbrq</column-name><column-value><![CDATA[");
		sb.append(getFxglxmJbrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwjgdm</column-name><column-value><![CDATA[");
		sb.append(getJsdwjgdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>szqy</column-name><column-value><![CDATA[");
		sb.append(getSzqy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ywxjfwjz</column-name><column-value><![CDATA[");
		sb.append(getYwxjfwjz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ywgbfwjg</column-name><column-value><![CDATA[");
		sb.append(getYwgbfwjg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gczh</column-name><column-value><![CDATA[");
		sb.append(getGczh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zdcyyn</column-name><column-value><![CDATA[");
		sb.append(getZdcyyn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxfl</column-name><column-value><![CDATA[");
		sb.append(getLxfl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ms1</column-name><column-value><![CDATA[");
		sb.append(getMs1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ms2</column-name><column-value><![CDATA[");
		sb.append(getMs2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ms3</column-name><column-value><![CDATA[");
		sb.append(getMs3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zdxmyn</column-name><column-value><![CDATA[");
		sb.append(getZdxmyn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dxjzsq</column-name><column-value><![CDATA[");
		sb.append(getDxjzsq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ywjzxzz</column-name><column-value><![CDATA[");
		sb.append(getYwjzxzz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fgwjhm</column-name><column-value><![CDATA[");
		sb.append(getFgwjhm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zzbl</column-name><column-value><![CDATA[");
		sb.append(getZzbl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ChangeTime</column-name><column-value><![CDATA[");
		sb.append(getChangeTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PD_SW</column-name><column-value><![CDATA[");
		sb.append(getPD_SW());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bmpfrq</column-name><column-value><![CDATA[");
		sb.append(getBmpfrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bmpfwh</column-name><column-value><![CDATA[");
		sb.append(getBmpfwh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bmpfwj</column-name><column-value><![CDATA[");
		sb.append(getBmpfwj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CertificateKey</column-name><column-value><![CDATA[");
		sb.append(getCertificateKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dsjzmj</column-name><column-value><![CDATA[");
		sb.append(getDsjzmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dxjzmj</column-name><column-value><![CDATA[");
		sb.append(getDxjzmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gdzctzbh</column-name><column-value><![CDATA[");
		sb.append(getGdzctzbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsxz_2011</column-name><column-value><![CDATA[");
		sb.append(getJsxz_2011());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lhmj</column-name><column-value><![CDATA[");
		sb.append(getLhmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxjb_2011</column-name><column-value><![CDATA[");
		sb.append(getLxjb_2011());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mfmj</column-name><column-value><![CDATA[");
		sb.append(getMfmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>other_qx</column-name><column-value><![CDATA[");
		sb.append(getOther_qx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ProjectSlyj</column-name><column-value><![CDATA[");
		sb.append(getProjectSlyj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qxbz</column-name><column-value><![CDATA[");
		sb.append(getQxbz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfcysjkfq</column-name><column-value><![CDATA[");
		sb.append(getSfcysjkfq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfmfss</column-name><column-value><![CDATA[");
		sb.append(getSfmfss());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>szqx</column-name><column-value><![CDATA[");
		sb.append(getSzqx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tsgs</column-name><column-value><![CDATA[");
		sb.append(getTsgs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfl_2011</column-name><column-value><![CDATA[");
		sb.append(getXmfl_2011());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xsjpw</column-name><column-value><![CDATA[");
		sb.append(getXsjpw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xsjpzdw</column-name><column-value><![CDATA[");
		sb.append(getXsjpzdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_10</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_10());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_11</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_11());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_xs_1</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_xs_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_xs_2</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_xs_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_xs_3</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_xs_3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_xs_4</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_xs_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_1_2</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_1_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc_1_2_4</column-name><column-value><![CDATA[");
		sb.append(getZjlygc_1_2_4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ywptlh</column-name><column-value><![CDATA[");
		sb.append(getYwptlh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gyyqbh</column-name><column-value><![CDATA[");
		sb.append(getGyyqbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfcyxm</column-name><column-value><![CDATA[");
		sb.append(getSfcyxm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zbxmfzrxm</column-name><column-value><![CDATA[");
		sb.append(getZbxmfzrxm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zbxmfzrzjh</column-name><column-value><![CDATA[");
		sb.append(getZbxmfzrzjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zbxmfzrzjlx</column-name><column-value><![CDATA[");
		sb.append(getZbxmfzrzjlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zbxmfzrqrsj</column-name><column-value><![CDATA[");
		sb.append(getZbxmfzrqrsj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sflsjzbs</column-name><column-value><![CDATA[");
		sb.append(getSflsjzbs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjbs</column-name><column-value><![CDATA[");
		sb.append(getSjbs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yxbs</column-name><column-value><![CDATA[");
		sb.append(getYxbs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfyjngz</column-name><column-value><![CDATA[");
		sb.append(getSfyjngz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfsszpjz</column-name><column-value><![CDATA[");
		sb.append(getSfsszpjz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zczxjgdmz</column-name><column-value><![CDATA[");
		sb.append(getZczxjgdmz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ischeckxmbm</column-name><column-value><![CDATA[");
		sb.append(getIscheckxmbm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zddtmj</column-name><column-value><![CDATA[");
		sb.append(getZddtmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjjdYn</column-name><column-value><![CDATA[");
		sb.append(getSjjdYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgjdYn</column-name><column-value><![CDATA[");
		sb.append(getSgjdYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yxjdYn</column-name><column-value><![CDATA[");
		sb.append(getYxjdYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tdhtqdbh</column-name><column-value><![CDATA[");
		sb.append(getTdhtqdbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tdhtqdrq</column-name><column-value><![CDATA[");
		sb.append(getTdhtqdrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dkbh</column-name><column-value><![CDATA[");
		sb.append(getDkbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zpsjzlsbl</column-name><column-value><![CDATA[");
		sb.append(getZpsjzlsbl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zpsjzmj</column-name><column-value><![CDATA[");
		sb.append(getZpsjzmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dwyzzpl</column-name><column-value><![CDATA[");
		sb.append(getDwyzzpl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zdh</column-name><column-value><![CDATA[");
		sb.append(getZdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfgdcg</column-name><column-value><![CDATA[");
		sb.append(getSfgdcg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ptlhmj</column-name><column-value><![CDATA[");
		sb.append(getPtlhmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bimjszxfy</column-name><column-value><![CDATA[");
		sb.append(getBimjszxfy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bz</column-name><column-value><![CDATA[");
		sb.append(getBz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfzcxm</column-name><column-value><![CDATA[");
		sb.append(getSfzcxm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zcxmbm</column-name><column-value><![CDATA[");
		sb.append(getZcxmbm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfzmqxm</column-name><column-value><![CDATA[");
		sb.append(getSfzmqxm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>printPDFTime</column-name><column-value><![CDATA[");
		sb.append(getPrintPDFTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isBgPrint</column-name><column-value><![CDATA[");
		sb.append(getIsBgPrint());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _bjbh;
	private Date _bjrq;
	private String _jsdw;
	private String _jsdwxz;
	private String _jsdwdz;
	private String _jsdwdh;
	private String _jsdwfr;
	private String _jsdwlxr;
	private String _jsdwyb;
	private String _jsdwzczj;
	private String _xmmc;
	private String _jsdd;
	private String _lxwj;
	private String _lxwh;
	private String _lxjb;
	private String _pzjg;
	private String _pzrq;
	private String _ztz;
	private String _sbtz;
	private String _jsxz;
	private String _jsgm;
	private String _zmj;
	private String _kgrq;
	private String _xmxz;
	private String _cjqk;
	private String _smqk;
	private String _bjbz;
	private String _fbzgsc;
	private String _cardid;
	private String _zjlygc_1;
	private String _zjlygc_2;
	private String _zjlygc_3;
	private String _zjlygc_4;
	private String _zjlygc_5;
	private String _zjlygc_6;
	private String _zjlygc_7;
	private String _zjlygc_8;
	private String _zjlygc_9;
	private String _jgxs;
	private String _xmfl;
	private String _jzmq;
	private String _ywdt;
	private String _dxsck;
	private String _bhjz;
	private String _fjms;
	private String _sfsbxm;
	private String _hzyj;
	private String _bj_sx;
	private String _bj_webid;
	private String _bjwcbj;
	private String _bmdm;
	private String _jbr;
	private String _shr;
	private String _shbmdm;
	private String _wcbjsj;
	private String _old_bjbh;
	private String _sffb;
	private String _timeflag;
	private String _jbrdm;
	private String _shrdm;
	private String _jsbh;
	private String _needSbjl;
	private String _wcSbjl;
	private String _sfgyzbkg;
	private String _jyzxfbxx;
	private String _sgGkzbfb;
	private String _sgjlGkzbfb;
	private String _fxglxm;
	private String _fxglxmJbr;
	private String _fxglxmJbrdm;
	private String _fxglxmJbrq;
	private String _jsdwjgdm;
	private String _szqy;
	private String _ywxjfwjz;
	private String _ywgbfwjg;
	private String _gczh;
	private String _zdcyyn;
	private String _lxfl;
	private String _ms1;
	private String _ms2;
	private String _ms3;
	private String _zdxmyn;
	private String _dxjzsq;
	private String _ywjzxzz;
	private String _fgwjhm;
	private String _zzbl;
	private String _ChangeTime;
	private String _PD_SW;
	private String _bmpfrq;
	private String _bmpfwh;
	private String _bmpfwj;
	private String _CertificateKey;
	private String _dsjzmj;
	private String _dxjzmj;
	private String _gdzctzbh;
	private String _jsxz_2011;
	private String _lhmj;
	private String _lxjb_2011;
	private String _mfmj;
	private String _other_qx;
	private String _ProjectSlyj;
	private String _qxbz;
	private String _sfcysjkfq;
	private String _sfmfss;
	private String _szqx;
	private String _tsgs;
	private String _xmfl_2011;
	private String _xsjpw;
	private String _xsjpzdw;
	private String _zjlygc_10;
	private String _zjlygc_11;
	private String _zjlygc_xs_1;
	private String _zjlygc_xs_2;
	private String _zjlygc_xs_3;
	private String _zjlygc_xs_4;
	private String _zjlygc_1_2;
	private String _zjlygc_1_2_4;
	private String _ywptlh;
	private String _gyyqbh;
	private String _sfcyxm;
	private String _zbxmfzrxm;
	private String _zbxmfzrzjh;
	private String _zbxmfzrzjlx;
	private String _zbxmfzrqrsj;
	private String _sflsjzbs;
	private String _sjbs;
	private String _yxbs;
	private String _sfyjngz;
	private String _sfsszpjz;
	private String _zczxjgdmz;
	private String _ischeckxmbm;
	private String _zddtmj;
	private String _sjjdYn;
	private String _sgjdYn;
	private String _yxjdYn;
	private String _tdhtqdbh;
	private String _tdhtqdrq;
	private String _dkbh;
	private String _zpsjzlsbl;
	private String _zpsjzmj;
	private String _dwyzzpl;
	private String _zdh;
	private String _sfgdcg;
	private String _ptlhmj;
	private String _bimjszxfy;
	private String _bz;
	private String _sfzcxm;
	private String _zcxmbm;
	private String _sfzmqxm;
	private String _printPDFTime;
	private String _isBgPrint;
	private BaseModel<?> _projectRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.project.service.ClpSerializer.class;
}