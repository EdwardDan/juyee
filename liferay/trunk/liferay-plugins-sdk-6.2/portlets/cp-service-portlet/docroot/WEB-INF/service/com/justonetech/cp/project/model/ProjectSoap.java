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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class ProjectSoap implements Serializable {
	public static ProjectSoap toSoapModel(Project model) {
		ProjectSoap soapModel = new ProjectSoap();

		soapModel.setBjbh(model.getBjbh());
		soapModel.setBjrq(model.getBjrq());
		soapModel.setJsdw(model.getJsdw());
		soapModel.setJsdwxz(model.getJsdwxz());
		soapModel.setJsdwdz(model.getJsdwdz());
		soapModel.setJsdwdh(model.getJsdwdh());
		soapModel.setJsdwfr(model.getJsdwfr());
		soapModel.setJsdwlxr(model.getJsdwlxr());
		soapModel.setJsdwyb(model.getJsdwyb());
		soapModel.setJsdwzczj(model.getJsdwzczj());
		soapModel.setXmmc(model.getXmmc());
		soapModel.setJsdd(model.getJsdd());
		soapModel.setLxwj(model.getLxwj());
		soapModel.setLxwh(model.getLxwh());
		soapModel.setLxjb(model.getLxjb());
		soapModel.setPzjg(model.getPzjg());
		soapModel.setPzrq(model.getPzrq());
		soapModel.setZtz(model.getZtz());
		soapModel.setSbtz(model.getSbtz());
		soapModel.setJsxz(model.getJsxz());
		soapModel.setJsgm(model.getJsgm());
		soapModel.setZmj(model.getZmj());
		soapModel.setKgrq(model.getKgrq());
		soapModel.setXmxz(model.getXmxz());
		soapModel.setCjqk(model.getCjqk());
		soapModel.setSmqk(model.getSmqk());
		soapModel.setBjbz(model.getBjbz());
		soapModel.setFbzgsc(model.getFbzgsc());
		soapModel.setCardid(model.getCardid());
		soapModel.setZjlygc_1(model.getZjlygc_1());
		soapModel.setZjlygc_2(model.getZjlygc_2());
		soapModel.setZjlygc_3(model.getZjlygc_3());
		soapModel.setZjlygc_4(model.getZjlygc_4());
		soapModel.setZjlygc_5(model.getZjlygc_5());
		soapModel.setZjlygc_6(model.getZjlygc_6());
		soapModel.setZjlygc_7(model.getZjlygc_7());
		soapModel.setZjlygc_8(model.getZjlygc_8());
		soapModel.setZjlygc_9(model.getZjlygc_9());
		soapModel.setJgxs(model.getJgxs());
		soapModel.setXmfl(model.getXmfl());
		soapModel.setJzmq(model.getJzmq());
		soapModel.setYwdt(model.getYwdt());
		soapModel.setDxsck(model.getDxsck());
		soapModel.setBhjz(model.getBhjz());
		soapModel.setFjms(model.getFjms());
		soapModel.setSfsbxm(model.getSfsbxm());
		soapModel.setHzyj(model.getHzyj());
		soapModel.setBj_sx(model.getBj_sx());
		soapModel.setBj_webid(model.getBj_webid());
		soapModel.setBjwcbj(model.getBjwcbj());
		soapModel.setBmdm(model.getBmdm());
		soapModel.setJbr(model.getJbr());
		soapModel.setShr(model.getShr());
		soapModel.setShbmdm(model.getShbmdm());
		soapModel.setWcbjsj(model.getWcbjsj());
		soapModel.setOld_bjbh(model.getOld_bjbh());
		soapModel.setSffb(model.getSffb());
		soapModel.setTimeflag(model.getTimeflag());
		soapModel.setJbrdm(model.getJbrdm());
		soapModel.setShrdm(model.getShrdm());
		soapModel.setJsbh(model.getJsbh());
		soapModel.setNeedSbjl(model.getNeedSbjl());
		soapModel.setWcSbjl(model.getWcSbjl());
		soapModel.setSfgyzbkg(model.getSfgyzbkg());
		soapModel.setJyzxfbxx(model.getJyzxfbxx());
		soapModel.setSgGkzbfb(model.getSgGkzbfb());
		soapModel.setSgjlGkzbfb(model.getSgjlGkzbfb());
		soapModel.setFxglxm(model.getFxglxm());
		soapModel.setFxglxmJbr(model.getFxglxmJbr());
		soapModel.setFxglxmJbrdm(model.getFxglxmJbrdm());
		soapModel.setFxglxmJbrq(model.getFxglxmJbrq());
		soapModel.setJsdwjgdm(model.getJsdwjgdm());
		soapModel.setSzqy(model.getSzqy());
		soapModel.setYwxjfwjz(model.getYwxjfwjz());
		soapModel.setYwgbfwjg(model.getYwgbfwjg());
		soapModel.setGczh(model.getGczh());
		soapModel.setZdcyyn(model.getZdcyyn());
		soapModel.setLxfl(model.getLxfl());
		soapModel.setMs1(model.getMs1());
		soapModel.setMs2(model.getMs2());
		soapModel.setMs3(model.getMs3());
		soapModel.setZdxmyn(model.getZdxmyn());
		soapModel.setDxjzsq(model.getDxjzsq());
		soapModel.setYwjzxzz(model.getYwjzxzz());
		soapModel.setFgwjhm(model.getFgwjhm());
		soapModel.setZzbl(model.getZzbl());
		soapModel.setChangeTime(model.getChangeTime());
		soapModel.setPD_SW(model.getPD_SW());
		soapModel.setBmpfrq(model.getBmpfrq());
		soapModel.setBmpfwh(model.getBmpfwh());
		soapModel.setBmpfwj(model.getBmpfwj());
		soapModel.setCertificateKey(model.getCertificateKey());
		soapModel.setDsjzmj(model.getDsjzmj());
		soapModel.setDxjzmj(model.getDxjzmj());
		soapModel.setGdzctzbh(model.getGdzctzbh());
		soapModel.setJsxz_2011(model.getJsxz_2011());
		soapModel.setLhmj(model.getLhmj());
		soapModel.setLxjb_2011(model.getLxjb_2011());
		soapModel.setMfmj(model.getMfmj());
		soapModel.setOther_qx(model.getOther_qx());
		soapModel.setProjectSlyj(model.getProjectSlyj());
		soapModel.setQxbz(model.getQxbz());
		soapModel.setSfcysjkfq(model.getSfcysjkfq());
		soapModel.setSfmfss(model.getSfmfss());
		soapModel.setSzqx(model.getSzqx());
		soapModel.setTsgs(model.getTsgs());
		soapModel.setXmfl_2011(model.getXmfl_2011());
		soapModel.setXsjpw(model.getXsjpw());
		soapModel.setXsjpzdw(model.getXsjpzdw());
		soapModel.setZjlygc_10(model.getZjlygc_10());
		soapModel.setZjlygc_11(model.getZjlygc_11());
		soapModel.setZjlygc_xs_1(model.getZjlygc_xs_1());
		soapModel.setZjlygc_xs_2(model.getZjlygc_xs_2());
		soapModel.setZjlygc_xs_3(model.getZjlygc_xs_3());
		soapModel.setZjlygc_xs_4(model.getZjlygc_xs_4());
		soapModel.setZjlygc_1_2(model.getZjlygc_1_2());
		soapModel.setZjlygc_1_2_4(model.getZjlygc_1_2_4());
		soapModel.setYwptlh(model.getYwptlh());
		soapModel.setGyyqbh(model.getGyyqbh());
		soapModel.setSfcyxm(model.getSfcyxm());
		soapModel.setZbxmfzrxm(model.getZbxmfzrxm());
		soapModel.setZbxmfzrzjh(model.getZbxmfzrzjh());
		soapModel.setZbxmfzrzjlx(model.getZbxmfzrzjlx());
		soapModel.setZbxmfzrqrsj(model.getZbxmfzrqrsj());
		soapModel.setSflsjzbs(model.getSflsjzbs());
		soapModel.setSjbs(model.getSjbs());
		soapModel.setYxbs(model.getYxbs());
		soapModel.setSfyjngz(model.getSfyjngz());
		soapModel.setSfsszpjz(model.getSfsszpjz());
		soapModel.setZczxjgdmz(model.getZczxjgdmz());
		soapModel.setIscheckxmbm(model.getIscheckxmbm());
		soapModel.setZddtmj(model.getZddtmj());
		soapModel.setSjjdYn(model.getSjjdYn());
		soapModel.setSgjdYn(model.getSgjdYn());
		soapModel.setYxjdYn(model.getYxjdYn());
		soapModel.setTdhtqdbh(model.getTdhtqdbh());
		soapModel.setTdhtqdrq(model.getTdhtqdrq());
		soapModel.setDkbh(model.getDkbh());
		soapModel.setZpsjzlsbl(model.getZpsjzlsbl());
		soapModel.setZpsjzmj(model.getZpsjzmj());
		soapModel.setDwyzzpl(model.getDwyzzpl());
		soapModel.setZdh(model.getZdh());
		soapModel.setSfgdcg(model.getSfgdcg());
		soapModel.setPtlhmj(model.getPtlhmj());
		soapModel.setBimjszxfy(model.getBimjszxfy());
		soapModel.setBz(model.getBz());
		soapModel.setSfzcxm(model.getSfzcxm());
		soapModel.setZcxmbm(model.getZcxmbm());
		soapModel.setSfzmqxm(model.getSfzmqxm());
		soapModel.setPrintPDFTime(model.getPrintPDFTime());
		soapModel.setIsBgPrint(model.getIsBgPrint());

		return soapModel;
	}

	public static ProjectSoap[] toSoapModels(Project[] models) {
		ProjectSoap[] soapModels = new ProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[][] toSoapModels(Project[][] models) {
		ProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectSoap[] toSoapModels(List<Project> models) {
		List<ProjectSoap> soapModels = new ArrayList<ProjectSoap>(models.size());

		for (Project model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectSoap[soapModels.size()]);
	}

	public ProjectSoap() {
	}

	public String getPrimaryKey() {
		return _bjbh;
	}

	public void setPrimaryKey(String pk) {
		setBjbh(pk);
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public Date getBjrq() {
		return _bjrq;
	}

	public void setBjrq(Date bjrq) {
		_bjrq = bjrq;
	}

	public String getJsdw() {
		return _jsdw;
	}

	public void setJsdw(String jsdw) {
		_jsdw = jsdw;
	}

	public String getJsdwxz() {
		return _jsdwxz;
	}

	public void setJsdwxz(String jsdwxz) {
		_jsdwxz = jsdwxz;
	}

	public String getJsdwdz() {
		return _jsdwdz;
	}

	public void setJsdwdz(String jsdwdz) {
		_jsdwdz = jsdwdz;
	}

	public String getJsdwdh() {
		return _jsdwdh;
	}

	public void setJsdwdh(String jsdwdh) {
		_jsdwdh = jsdwdh;
	}

	public String getJsdwfr() {
		return _jsdwfr;
	}

	public void setJsdwfr(String jsdwfr) {
		_jsdwfr = jsdwfr;
	}

	public String getJsdwlxr() {
		return _jsdwlxr;
	}

	public void setJsdwlxr(String jsdwlxr) {
		_jsdwlxr = jsdwlxr;
	}

	public String getJsdwyb() {
		return _jsdwyb;
	}

	public void setJsdwyb(String jsdwyb) {
		_jsdwyb = jsdwyb;
	}

	public String getJsdwzczj() {
		return _jsdwzczj;
	}

	public void setJsdwzczj(String jsdwzczj) {
		_jsdwzczj = jsdwzczj;
	}

	public String getXmmc() {
		return _xmmc;
	}

	public void setXmmc(String xmmc) {
		_xmmc = xmmc;
	}

	public String getJsdd() {
		return _jsdd;
	}

	public void setJsdd(String jsdd) {
		_jsdd = jsdd;
	}

	public String getLxwj() {
		return _lxwj;
	}

	public void setLxwj(String lxwj) {
		_lxwj = lxwj;
	}

	public String getLxwh() {
		return _lxwh;
	}

	public void setLxwh(String lxwh) {
		_lxwh = lxwh;
	}

	public String getLxjb() {
		return _lxjb;
	}

	public void setLxjb(String lxjb) {
		_lxjb = lxjb;
	}

	public String getPzjg() {
		return _pzjg;
	}

	public void setPzjg(String pzjg) {
		_pzjg = pzjg;
	}

	public String getPzrq() {
		return _pzrq;
	}

	public void setPzrq(String pzrq) {
		_pzrq = pzrq;
	}

	public String getZtz() {
		return _ztz;
	}

	public void setZtz(String ztz) {
		_ztz = ztz;
	}

	public String getSbtz() {
		return _sbtz;
	}

	public void setSbtz(String sbtz) {
		_sbtz = sbtz;
	}

	public String getJsxz() {
		return _jsxz;
	}

	public void setJsxz(String jsxz) {
		_jsxz = jsxz;
	}

	public String getJsgm() {
		return _jsgm;
	}

	public void setJsgm(String jsgm) {
		_jsgm = jsgm;
	}

	public String getZmj() {
		return _zmj;
	}

	public void setZmj(String zmj) {
		_zmj = zmj;
	}

	public String getKgrq() {
		return _kgrq;
	}

	public void setKgrq(String kgrq) {
		_kgrq = kgrq;
	}

	public String getXmxz() {
		return _xmxz;
	}

	public void setXmxz(String xmxz) {
		_xmxz = xmxz;
	}

	public String getCjqk() {
		return _cjqk;
	}

	public void setCjqk(String cjqk) {
		_cjqk = cjqk;
	}

	public String getSmqk() {
		return _smqk;
	}

	public void setSmqk(String smqk) {
		_smqk = smqk;
	}

	public String getBjbz() {
		return _bjbz;
	}

	public void setBjbz(String bjbz) {
		_bjbz = bjbz;
	}

	public String getFbzgsc() {
		return _fbzgsc;
	}

	public void setFbzgsc(String fbzgsc) {
		_fbzgsc = fbzgsc;
	}

	public String getCardid() {
		return _cardid;
	}

	public void setCardid(String cardid) {
		_cardid = cardid;
	}

	public String getZjlygc_1() {
		return _zjlygc_1;
	}

	public void setZjlygc_1(String zjlygc_1) {
		_zjlygc_1 = zjlygc_1;
	}

	public String getZjlygc_2() {
		return _zjlygc_2;
	}

	public void setZjlygc_2(String zjlygc_2) {
		_zjlygc_2 = zjlygc_2;
	}

	public String getZjlygc_3() {
		return _zjlygc_3;
	}

	public void setZjlygc_3(String zjlygc_3) {
		_zjlygc_3 = zjlygc_3;
	}

	public String getZjlygc_4() {
		return _zjlygc_4;
	}

	public void setZjlygc_4(String zjlygc_4) {
		_zjlygc_4 = zjlygc_4;
	}

	public String getZjlygc_5() {
		return _zjlygc_5;
	}

	public void setZjlygc_5(String zjlygc_5) {
		_zjlygc_5 = zjlygc_5;
	}

	public String getZjlygc_6() {
		return _zjlygc_6;
	}

	public void setZjlygc_6(String zjlygc_6) {
		_zjlygc_6 = zjlygc_6;
	}

	public String getZjlygc_7() {
		return _zjlygc_7;
	}

	public void setZjlygc_7(String zjlygc_7) {
		_zjlygc_7 = zjlygc_7;
	}

	public String getZjlygc_8() {
		return _zjlygc_8;
	}

	public void setZjlygc_8(String zjlygc_8) {
		_zjlygc_8 = zjlygc_8;
	}

	public String getZjlygc_9() {
		return _zjlygc_9;
	}

	public void setZjlygc_9(String zjlygc_9) {
		_zjlygc_9 = zjlygc_9;
	}

	public String getJgxs() {
		return _jgxs;
	}

	public void setJgxs(String jgxs) {
		_jgxs = jgxs;
	}

	public String getXmfl() {
		return _xmfl;
	}

	public void setXmfl(String xmfl) {
		_xmfl = xmfl;
	}

	public String getJzmq() {
		return _jzmq;
	}

	public void setJzmq(String jzmq) {
		_jzmq = jzmq;
	}

	public String getYwdt() {
		return _ywdt;
	}

	public void setYwdt(String ywdt) {
		_ywdt = ywdt;
	}

	public String getDxsck() {
		return _dxsck;
	}

	public void setDxsck(String dxsck) {
		_dxsck = dxsck;
	}

	public String getBhjz() {
		return _bhjz;
	}

	public void setBhjz(String bhjz) {
		_bhjz = bhjz;
	}

	public String getFjms() {
		return _fjms;
	}

	public void setFjms(String fjms) {
		_fjms = fjms;
	}

	public String getSfsbxm() {
		return _sfsbxm;
	}

	public void setSfsbxm(String sfsbxm) {
		_sfsbxm = sfsbxm;
	}

	public String getHzyj() {
		return _hzyj;
	}

	public void setHzyj(String hzyj) {
		_hzyj = hzyj;
	}

	public String getBj_sx() {
		return _bj_sx;
	}

	public void setBj_sx(String bj_sx) {
		_bj_sx = bj_sx;
	}

	public String getBj_webid() {
		return _bj_webid;
	}

	public void setBj_webid(String bj_webid) {
		_bj_webid = bj_webid;
	}

	public String getBjwcbj() {
		return _bjwcbj;
	}

	public void setBjwcbj(String bjwcbj) {
		_bjwcbj = bjwcbj;
	}

	public String getBmdm() {
		return _bmdm;
	}

	public void setBmdm(String bmdm) {
		_bmdm = bmdm;
	}

	public String getJbr() {
		return _jbr;
	}

	public void setJbr(String jbr) {
		_jbr = jbr;
	}

	public String getShr() {
		return _shr;
	}

	public void setShr(String shr) {
		_shr = shr;
	}

	public String getShbmdm() {
		return _shbmdm;
	}

	public void setShbmdm(String shbmdm) {
		_shbmdm = shbmdm;
	}

	public String getWcbjsj() {
		return _wcbjsj;
	}

	public void setWcbjsj(String wcbjsj) {
		_wcbjsj = wcbjsj;
	}

	public String getOld_bjbh() {
		return _old_bjbh;
	}

	public void setOld_bjbh(String old_bjbh) {
		_old_bjbh = old_bjbh;
	}

	public String getSffb() {
		return _sffb;
	}

	public void setSffb(String sffb) {
		_sffb = sffb;
	}

	public String getTimeflag() {
		return _timeflag;
	}

	public void setTimeflag(String timeflag) {
		_timeflag = timeflag;
	}

	public String getJbrdm() {
		return _jbrdm;
	}

	public void setJbrdm(String jbrdm) {
		_jbrdm = jbrdm;
	}

	public String getShrdm() {
		return _shrdm;
	}

	public void setShrdm(String shrdm) {
		_shrdm = shrdm;
	}

	public String getJsbh() {
		return _jsbh;
	}

	public void setJsbh(String jsbh) {
		_jsbh = jsbh;
	}

	public String getNeedSbjl() {
		return _needSbjl;
	}

	public void setNeedSbjl(String needSbjl) {
		_needSbjl = needSbjl;
	}

	public String getWcSbjl() {
		return _wcSbjl;
	}

	public void setWcSbjl(String wcSbjl) {
		_wcSbjl = wcSbjl;
	}

	public String getSfgyzbkg() {
		return _sfgyzbkg;
	}

	public void setSfgyzbkg(String sfgyzbkg) {
		_sfgyzbkg = sfgyzbkg;
	}

	public String getJyzxfbxx() {
		return _jyzxfbxx;
	}

	public void setJyzxfbxx(String jyzxfbxx) {
		_jyzxfbxx = jyzxfbxx;
	}

	public String getSgGkzbfb() {
		return _sgGkzbfb;
	}

	public void setSgGkzbfb(String sgGkzbfb) {
		_sgGkzbfb = sgGkzbfb;
	}

	public String getSgjlGkzbfb() {
		return _sgjlGkzbfb;
	}

	public void setSgjlGkzbfb(String sgjlGkzbfb) {
		_sgjlGkzbfb = sgjlGkzbfb;
	}

	public String getFxglxm() {
		return _fxglxm;
	}

	public void setFxglxm(String fxglxm) {
		_fxglxm = fxglxm;
	}

	public String getFxglxmJbr() {
		return _fxglxmJbr;
	}

	public void setFxglxmJbr(String fxglxmJbr) {
		_fxglxmJbr = fxglxmJbr;
	}

	public String getFxglxmJbrdm() {
		return _fxglxmJbrdm;
	}

	public void setFxglxmJbrdm(String fxglxmJbrdm) {
		_fxglxmJbrdm = fxglxmJbrdm;
	}

	public String getFxglxmJbrq() {
		return _fxglxmJbrq;
	}

	public void setFxglxmJbrq(String fxglxmJbrq) {
		_fxglxmJbrq = fxglxmJbrq;
	}

	public String getJsdwjgdm() {
		return _jsdwjgdm;
	}

	public void setJsdwjgdm(String jsdwjgdm) {
		_jsdwjgdm = jsdwjgdm;
	}

	public String getSzqy() {
		return _szqy;
	}

	public void setSzqy(String szqy) {
		_szqy = szqy;
	}

	public String getYwxjfwjz() {
		return _ywxjfwjz;
	}

	public void setYwxjfwjz(String ywxjfwjz) {
		_ywxjfwjz = ywxjfwjz;
	}

	public String getYwgbfwjg() {
		return _ywgbfwjg;
	}

	public void setYwgbfwjg(String ywgbfwjg) {
		_ywgbfwjg = ywgbfwjg;
	}

	public String getGczh() {
		return _gczh;
	}

	public void setGczh(String gczh) {
		_gczh = gczh;
	}

	public String getZdcyyn() {
		return _zdcyyn;
	}

	public void setZdcyyn(String zdcyyn) {
		_zdcyyn = zdcyyn;
	}

	public String getLxfl() {
		return _lxfl;
	}

	public void setLxfl(String lxfl) {
		_lxfl = lxfl;
	}

	public String getMs1() {
		return _ms1;
	}

	public void setMs1(String ms1) {
		_ms1 = ms1;
	}

	public String getMs2() {
		return _ms2;
	}

	public void setMs2(String ms2) {
		_ms2 = ms2;
	}

	public String getMs3() {
		return _ms3;
	}

	public void setMs3(String ms3) {
		_ms3 = ms3;
	}

	public String getZdxmyn() {
		return _zdxmyn;
	}

	public void setZdxmyn(String zdxmyn) {
		_zdxmyn = zdxmyn;
	}

	public String getDxjzsq() {
		return _dxjzsq;
	}

	public void setDxjzsq(String dxjzsq) {
		_dxjzsq = dxjzsq;
	}

	public String getYwjzxzz() {
		return _ywjzxzz;
	}

	public void setYwjzxzz(String ywjzxzz) {
		_ywjzxzz = ywjzxzz;
	}

	public String getFgwjhm() {
		return _fgwjhm;
	}

	public void setFgwjhm(String fgwjhm) {
		_fgwjhm = fgwjhm;
	}

	public String getZzbl() {
		return _zzbl;
	}

	public void setZzbl(String zzbl) {
		_zzbl = zzbl;
	}

	public String getChangeTime() {
		return _ChangeTime;
	}

	public void setChangeTime(String ChangeTime) {
		_ChangeTime = ChangeTime;
	}

	public String getPD_SW() {
		return _PD_SW;
	}

	public void setPD_SW(String PD_SW) {
		_PD_SW = PD_SW;
	}

	public String getBmpfrq() {
		return _bmpfrq;
	}

	public void setBmpfrq(String bmpfrq) {
		_bmpfrq = bmpfrq;
	}

	public String getBmpfwh() {
		return _bmpfwh;
	}

	public void setBmpfwh(String bmpfwh) {
		_bmpfwh = bmpfwh;
	}

	public String getBmpfwj() {
		return _bmpfwj;
	}

	public void setBmpfwj(String bmpfwj) {
		_bmpfwj = bmpfwj;
	}

	public String getCertificateKey() {
		return _CertificateKey;
	}

	public void setCertificateKey(String CertificateKey) {
		_CertificateKey = CertificateKey;
	}

	public String getDsjzmj() {
		return _dsjzmj;
	}

	public void setDsjzmj(String dsjzmj) {
		_dsjzmj = dsjzmj;
	}

	public String getDxjzmj() {
		return _dxjzmj;
	}

	public void setDxjzmj(String dxjzmj) {
		_dxjzmj = dxjzmj;
	}

	public String getGdzctzbh() {
		return _gdzctzbh;
	}

	public void setGdzctzbh(String gdzctzbh) {
		_gdzctzbh = gdzctzbh;
	}

	public String getJsxz_2011() {
		return _jsxz_2011;
	}

	public void setJsxz_2011(String jsxz_2011) {
		_jsxz_2011 = jsxz_2011;
	}

	public String getLhmj() {
		return _lhmj;
	}

	public void setLhmj(String lhmj) {
		_lhmj = lhmj;
	}

	public String getLxjb_2011() {
		return _lxjb_2011;
	}

	public void setLxjb_2011(String lxjb_2011) {
		_lxjb_2011 = lxjb_2011;
	}

	public String getMfmj() {
		return _mfmj;
	}

	public void setMfmj(String mfmj) {
		_mfmj = mfmj;
	}

	public String getOther_qx() {
		return _other_qx;
	}

	public void setOther_qx(String other_qx) {
		_other_qx = other_qx;
	}

	public String getProjectSlyj() {
		return _ProjectSlyj;
	}

	public void setProjectSlyj(String ProjectSlyj) {
		_ProjectSlyj = ProjectSlyj;
	}

	public String getQxbz() {
		return _qxbz;
	}

	public void setQxbz(String qxbz) {
		_qxbz = qxbz;
	}

	public String getSfcysjkfq() {
		return _sfcysjkfq;
	}

	public void setSfcysjkfq(String sfcysjkfq) {
		_sfcysjkfq = sfcysjkfq;
	}

	public String getSfmfss() {
		return _sfmfss;
	}

	public void setSfmfss(String sfmfss) {
		_sfmfss = sfmfss;
	}

	public String getSzqx() {
		return _szqx;
	}

	public void setSzqx(String szqx) {
		_szqx = szqx;
	}

	public String getTsgs() {
		return _tsgs;
	}

	public void setTsgs(String tsgs) {
		_tsgs = tsgs;
	}

	public String getXmfl_2011() {
		return _xmfl_2011;
	}

	public void setXmfl_2011(String xmfl_2011) {
		_xmfl_2011 = xmfl_2011;
	}

	public String getXsjpw() {
		return _xsjpw;
	}

	public void setXsjpw(String xsjpw) {
		_xsjpw = xsjpw;
	}

	public String getXsjpzdw() {
		return _xsjpzdw;
	}

	public void setXsjpzdw(String xsjpzdw) {
		_xsjpzdw = xsjpzdw;
	}

	public String getZjlygc_10() {
		return _zjlygc_10;
	}

	public void setZjlygc_10(String zjlygc_10) {
		_zjlygc_10 = zjlygc_10;
	}

	public String getZjlygc_11() {
		return _zjlygc_11;
	}

	public void setZjlygc_11(String zjlygc_11) {
		_zjlygc_11 = zjlygc_11;
	}

	public String getZjlygc_xs_1() {
		return _zjlygc_xs_1;
	}

	public void setZjlygc_xs_1(String zjlygc_xs_1) {
		_zjlygc_xs_1 = zjlygc_xs_1;
	}

	public String getZjlygc_xs_2() {
		return _zjlygc_xs_2;
	}

	public void setZjlygc_xs_2(String zjlygc_xs_2) {
		_zjlygc_xs_2 = zjlygc_xs_2;
	}

	public String getZjlygc_xs_3() {
		return _zjlygc_xs_3;
	}

	public void setZjlygc_xs_3(String zjlygc_xs_3) {
		_zjlygc_xs_3 = zjlygc_xs_3;
	}

	public String getZjlygc_xs_4() {
		return _zjlygc_xs_4;
	}

	public void setZjlygc_xs_4(String zjlygc_xs_4) {
		_zjlygc_xs_4 = zjlygc_xs_4;
	}

	public String getZjlygc_1_2() {
		return _zjlygc_1_2;
	}

	public void setZjlygc_1_2(String zjlygc_1_2) {
		_zjlygc_1_2 = zjlygc_1_2;
	}

	public String getZjlygc_1_2_4() {
		return _zjlygc_1_2_4;
	}

	public void setZjlygc_1_2_4(String zjlygc_1_2_4) {
		_zjlygc_1_2_4 = zjlygc_1_2_4;
	}

	public String getYwptlh() {
		return _ywptlh;
	}

	public void setYwptlh(String ywptlh) {
		_ywptlh = ywptlh;
	}

	public String getGyyqbh() {
		return _gyyqbh;
	}

	public void setGyyqbh(String gyyqbh) {
		_gyyqbh = gyyqbh;
	}

	public String getSfcyxm() {
		return _sfcyxm;
	}

	public void setSfcyxm(String sfcyxm) {
		_sfcyxm = sfcyxm;
	}

	public String getZbxmfzrxm() {
		return _zbxmfzrxm;
	}

	public void setZbxmfzrxm(String zbxmfzrxm) {
		_zbxmfzrxm = zbxmfzrxm;
	}

	public String getZbxmfzrzjh() {
		return _zbxmfzrzjh;
	}

	public void setZbxmfzrzjh(String zbxmfzrzjh) {
		_zbxmfzrzjh = zbxmfzrzjh;
	}

	public String getZbxmfzrzjlx() {
		return _zbxmfzrzjlx;
	}

	public void setZbxmfzrzjlx(String zbxmfzrzjlx) {
		_zbxmfzrzjlx = zbxmfzrzjlx;
	}

	public String getZbxmfzrqrsj() {
		return _zbxmfzrqrsj;
	}

	public void setZbxmfzrqrsj(String zbxmfzrqrsj) {
		_zbxmfzrqrsj = zbxmfzrqrsj;
	}

	public String getSflsjzbs() {
		return _sflsjzbs;
	}

	public void setSflsjzbs(String sflsjzbs) {
		_sflsjzbs = sflsjzbs;
	}

	public String getSjbs() {
		return _sjbs;
	}

	public void setSjbs(String sjbs) {
		_sjbs = sjbs;
	}

	public String getYxbs() {
		return _yxbs;
	}

	public void setYxbs(String yxbs) {
		_yxbs = yxbs;
	}

	public String getSfyjngz() {
		return _sfyjngz;
	}

	public void setSfyjngz(String sfyjngz) {
		_sfyjngz = sfyjngz;
	}

	public String getSfsszpjz() {
		return _sfsszpjz;
	}

	public void setSfsszpjz(String sfsszpjz) {
		_sfsszpjz = sfsszpjz;
	}

	public String getZczxjgdmz() {
		return _zczxjgdmz;
	}

	public void setZczxjgdmz(String zczxjgdmz) {
		_zczxjgdmz = zczxjgdmz;
	}

	public String getIscheckxmbm() {
		return _ischeckxmbm;
	}

	public void setIscheckxmbm(String ischeckxmbm) {
		_ischeckxmbm = ischeckxmbm;
	}

	public String getZddtmj() {
		return _zddtmj;
	}

	public void setZddtmj(String zddtmj) {
		_zddtmj = zddtmj;
	}

	public String getSjjdYn() {
		return _sjjdYn;
	}

	public void setSjjdYn(String sjjdYn) {
		_sjjdYn = sjjdYn;
	}

	public String getSgjdYn() {
		return _sgjdYn;
	}

	public void setSgjdYn(String sgjdYn) {
		_sgjdYn = sgjdYn;
	}

	public String getYxjdYn() {
		return _yxjdYn;
	}

	public void setYxjdYn(String yxjdYn) {
		_yxjdYn = yxjdYn;
	}

	public String getTdhtqdbh() {
		return _tdhtqdbh;
	}

	public void setTdhtqdbh(String tdhtqdbh) {
		_tdhtqdbh = tdhtqdbh;
	}

	public String getTdhtqdrq() {
		return _tdhtqdrq;
	}

	public void setTdhtqdrq(String tdhtqdrq) {
		_tdhtqdrq = tdhtqdrq;
	}

	public String getDkbh() {
		return _dkbh;
	}

	public void setDkbh(String dkbh) {
		_dkbh = dkbh;
	}

	public String getZpsjzlsbl() {
		return _zpsjzlsbl;
	}

	public void setZpsjzlsbl(String zpsjzlsbl) {
		_zpsjzlsbl = zpsjzlsbl;
	}

	public String getZpsjzmj() {
		return _zpsjzmj;
	}

	public void setZpsjzmj(String zpsjzmj) {
		_zpsjzmj = zpsjzmj;
	}

	public String getDwyzzpl() {
		return _dwyzzpl;
	}

	public void setDwyzzpl(String dwyzzpl) {
		_dwyzzpl = dwyzzpl;
	}

	public String getZdh() {
		return _zdh;
	}

	public void setZdh(String zdh) {
		_zdh = zdh;
	}

	public String getSfgdcg() {
		return _sfgdcg;
	}

	public void setSfgdcg(String sfgdcg) {
		_sfgdcg = sfgdcg;
	}

	public String getPtlhmj() {
		return _ptlhmj;
	}

	public void setPtlhmj(String ptlhmj) {
		_ptlhmj = ptlhmj;
	}

	public String getBimjszxfy() {
		return _bimjszxfy;
	}

	public void setBimjszxfy(String bimjszxfy) {
		_bimjszxfy = bimjszxfy;
	}

	public String getBz() {
		return _bz;
	}

	public void setBz(String bz) {
		_bz = bz;
	}

	public String getSfzcxm() {
		return _sfzcxm;
	}

	public void setSfzcxm(String sfzcxm) {
		_sfzcxm = sfzcxm;
	}

	public String getZcxmbm() {
		return _zcxmbm;
	}

	public void setZcxmbm(String zcxmbm) {
		_zcxmbm = zcxmbm;
	}

	public String getSfzmqxm() {
		return _sfzmqxm;
	}

	public void setSfzmqxm(String sfzmqxm) {
		_sfzmqxm = sfzmqxm;
	}

	public String getPrintPDFTime() {
		return _printPDFTime;
	}

	public void setPrintPDFTime(String printPDFTime) {
		_printPDFTime = printPDFTime;
	}

	public String getIsBgPrint() {
		return _isBgPrint;
	}

	public void setIsBgPrint(String isBgPrint) {
		_isBgPrint = isBgPrint;
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
}