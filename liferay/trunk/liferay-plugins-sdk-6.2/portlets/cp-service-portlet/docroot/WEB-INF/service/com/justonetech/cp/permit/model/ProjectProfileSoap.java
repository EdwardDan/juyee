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

package com.justonetech.cp.permit.model;

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
public class ProjectProfileSoap implements Serializable {
	public static ProjectProfileSoap toSoapModel(ProjectProfile model) {
		ProjectProfileSoap soapModel = new ProjectProfileSoap();

		soapModel.setPermitId(model.getPermitId());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setJsdwmc(model.getJsdwmc());
		soapModel.setJsdwxz(model.getJsdwxz());
		soapModel.setJsdwdz(model.getJsdwdz());
		soapModel.setGcmc(model.getGcmc());
		soapModel.setJsdd(model.getJsdd());
		soapModel.setJsgcgm(model.getJsgcgm());
		soapModel.setFwjzmj(model.getFwjzmj());
		soapModel.setHtjg(model.getHtjg());
		soapModel.setHtgq(model.getHtgq());
		soapModel.setFddbr(model.getFddbr());
		soapModel.setJsdwlxdh(model.getJsdwlxdh());
		soapModel.setJsdwlxr(model.getJsdwlxr());
		soapModel.setJsdwsjh(model.getJsdwsjh());
		soapModel.setJsgcghxkzbh(model.getJsgcghxkzbh());
		soapModel.setXckgqk(model.getXckgqk());
		soapModel.setXmlx(model.getXmlx());
		soapModel.setLxjb(model.getLxjb());
		soapModel.setXmxz(model.getXmxz());
		soapModel.setSsqx(model.getSsqx());
		soapModel.setYwbm(model.getYwbm());
		soapModel.setJsddssqx(model.getJsddssqx());
		soapModel.setJsgclb(model.getJsgclb());
		soapModel.setJsgcsx(model.getJsgcsx());
		soapModel.setGyzjbz(model.getGyzjbz());
		soapModel.setZbjg(model.getZbjg());
		soapModel.setXmtzgs(model.getXmtzgs());
		soapModel.setJhkg(model.getJhkg());
		soapModel.setJhjg(model.getJhjg());
		soapModel.setSfzftzl(model.getSfzftzl());
		soapModel.setYzzpl1(model.getYzzpl1());
		soapModel.setYzzpl2(model.getYzzpl2());
		soapModel.setYzzpl3(model.getYzzpl3());
		soapModel.setYzzpl4(model.getYzzpl4());
		soapModel.setBimsj(model.getBimsj());
		soapModel.setBimsg(model.getBimsg());
		soapModel.setBimyw(model.getBimyw());
		soapModel.setTjsj(model.getTjsj());
		soapModel.setGcnr(model.getGcnr());
		soapModel.setSgxkzsbz(model.getSgxkzsbz());
		soapModel.setGls(model.getGls());
		soapModel.setJzmj(model.getJzmj());
		soapModel.setQlsl(model.getQlsl());
		soapModel.setQlkd(model.getQlkd());
		soapModel.setGuijiaosl(model.getGuijiaosl());
		soapModel.setSdsl(model.getSdsl());
		soapModel.setGaojiasl(model.getGaojiasl());
		soapModel.setZgj(model.getZgj());
		soapModel.setZsqxks(model.getZsqxks());
		soapModel.setZsqxjs(model.getZsqxjs());
		soapModel.setCnsx(model.getCnsx());
		soapModel.setTzly(model.getTzly());
		soapModel.setGkpzhhzjghwh(model.getGkpzhhzjghwh());
		soapModel.setPfhhzrq(model.getPfhhzrq());
		soapModel.setCbsjpzjghwh(model.getCbsjpzjghwh());
		soapModel.setPfrq(model.getPfrq());
		soapModel.setPfgq(model.getPfgq());
		soapModel.setPzjghwh(model.getPzjghwh());
		soapModel.setXmdw(model.getXmdw());
		soapModel.setXmfzr(model.getXmfzr());
		soapModel.setXmfzrlxdh(model.getXmfzrlxdh());
		soapModel.setZysjdw(model.getZysjdw());
		soapModel.setSj_zbfs(model.getSj_zbfs());
		soapModel.setSj_zbj(model.getSj_zbj());
		soapModel.setSj_zzdj(model.getSj_zzdj());
		soapModel.setSj_zzdjzsbh(model.getSj_zzdjzsbh());
		soapModel.setSj_xmfzr(model.getSj_xmfzr());
		soapModel.setSj_xmfzrzsbh(model.getSj_xmfzrzsbh());
		soapModel.setZyjldw(model.getZyjldw());
		soapModel.setJl_zbfs(model.getJl_zbfs());
		soapModel.setJl_zbj(model.getJl_zbj());
		soapModel.setJl_zzdj(model.getJl_zzdj());
		soapModel.setJl_zzdjzsbh(model.getJl_zzdjzsbh());
		soapModel.setJl_zj(model.getJl_zj());
		soapModel.setJl_zjzsbh(model.getJl_zjzsbh());
		soapModel.setZysgdw(model.getZysgdw());
		soapModel.setSg_zbfs(model.getSg_zbfs());
		soapModel.setSg_zbj(model.getSg_zbj());
		soapModel.setSg_zzdj(model.getSg_zzdj());
		soapModel.setSg_zzdjzsbh(model.getSg_zzdjzsbh());
		soapModel.setSg_xmjl(model.getSg_xmjl());
		soapModel.setSg_xmjlzsbh(model.getSg_xmjlzsbh());
		soapModel.setJszjjhlsqk(model.getJszjjhlsqk());
		soapModel.setDcqwcqk(model.getDcqwcqk());
		soapModel.setSgzbqk(model.getSgzbqk());
		soapModel.setSytdxgwj(model.getSytdxgwj());
		soapModel.setGczljddjqk(model.getGczljddjqk());

		return soapModel;
	}

	public static ProjectProfileSoap[] toSoapModels(ProjectProfile[] models) {
		ProjectProfileSoap[] soapModels = new ProjectProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectProfileSoap[][] toSoapModels(ProjectProfile[][] models) {
		ProjectProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectProfileSoap[] toSoapModels(List<ProjectProfile> models) {
		List<ProjectProfileSoap> soapModels = new ArrayList<ProjectProfileSoap>(models.size());

		for (ProjectProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectProfileSoap[soapModels.size()]);
	}

	public ProjectProfileSoap() {
	}

	public long getPrimaryKey() {
		return _permitId;
	}

	public void setPrimaryKey(long pk) {
		setPermitId(pk);
	}

	public long getPermitId() {
		return _permitId;
	}

	public void setPermitId(long permitId) {
		_permitId = permitId;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public String getJsdwmc() {
		return _jsdwmc;
	}

	public void setJsdwmc(String jsdwmc) {
		_jsdwmc = jsdwmc;
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

	public String getGcmc() {
		return _gcmc;
	}

	public void setGcmc(String gcmc) {
		_gcmc = gcmc;
	}

	public String getJsdd() {
		return _jsdd;
	}

	public void setJsdd(String jsdd) {
		_jsdd = jsdd;
	}

	public String getJsgcgm() {
		return _jsgcgm;
	}

	public void setJsgcgm(String jsgcgm) {
		_jsgcgm = jsgcgm;
	}

	public String getFwjzmj() {
		return _fwjzmj;
	}

	public void setFwjzmj(String fwjzmj) {
		_fwjzmj = fwjzmj;
	}

	public String getHtjg() {
		return _htjg;
	}

	public void setHtjg(String htjg) {
		_htjg = htjg;
	}

	public int getHtgq() {
		return _htgq;
	}

	public void setHtgq(int htgq) {
		_htgq = htgq;
	}

	public String getFddbr() {
		return _fddbr;
	}

	public void setFddbr(String fddbr) {
		_fddbr = fddbr;
	}

	public String getJsdwlxdh() {
		return _jsdwlxdh;
	}

	public void setJsdwlxdh(String jsdwlxdh) {
		_jsdwlxdh = jsdwlxdh;
	}

	public String getJsdwlxr() {
		return _jsdwlxr;
	}

	public void setJsdwlxr(String jsdwlxr) {
		_jsdwlxr = jsdwlxr;
	}

	public String getJsdwsjh() {
		return _jsdwsjh;
	}

	public void setJsdwsjh(String jsdwsjh) {
		_jsdwsjh = jsdwsjh;
	}

	public String getJsgcghxkzbh() {
		return _jsgcghxkzbh;
	}

	public void setJsgcghxkzbh(String jsgcghxkzbh) {
		_jsgcghxkzbh = jsgcghxkzbh;
	}

	public String getXckgqk() {
		return _xckgqk;
	}

	public void setXckgqk(String xckgqk) {
		_xckgqk = xckgqk;
	}

	public long getXmlx() {
		return _xmlx;
	}

	public void setXmlx(long xmlx) {
		_xmlx = xmlx;
	}

	public String getLxjb() {
		return _lxjb;
	}

	public void setLxjb(String lxjb) {
		_lxjb = lxjb;
	}

	public long getXmxz() {
		return _xmxz;
	}

	public void setXmxz(long xmxz) {
		_xmxz = xmxz;
	}

	public String getSsqx() {
		return _ssqx;
	}

	public void setSsqx(String ssqx) {
		_ssqx = ssqx;
	}

	public String getYwbm() {
		return _ywbm;
	}

	public void setYwbm(String ywbm) {
		_ywbm = ywbm;
	}

	public long getJsddssqx() {
		return _jsddssqx;
	}

	public void setJsddssqx(long jsddssqx) {
		_jsddssqx = jsddssqx;
	}

	public String getJsgclb() {
		return _jsgclb;
	}

	public void setJsgclb(String jsgclb) {
		_jsgclb = jsgclb;
	}

	public long getJsgcsx() {
		return _jsgcsx;
	}

	public void setJsgcsx(long jsgcsx) {
		_jsgcsx = jsgcsx;
	}

	public String getGyzjbz() {
		return _gyzjbz;
	}

	public void setGyzjbz(String gyzjbz) {
		_gyzjbz = gyzjbz;
	}

	public String getZbjg() {
		return _zbjg;
	}

	public void setZbjg(String zbjg) {
		_zbjg = zbjg;
	}

	public String getXmtzgs() {
		return _xmtzgs;
	}

	public void setXmtzgs(String xmtzgs) {
		_xmtzgs = xmtzgs;
	}

	public Date getJhkg() {
		return _jhkg;
	}

	public void setJhkg(Date jhkg) {
		_jhkg = jhkg;
	}

	public Date getJhjg() {
		return _jhjg;
	}

	public void setJhjg(Date jhjg) {
		_jhjg = jhjg;
	}

	public boolean getSfzftzl() {
		return _sfzftzl;
	}

	public boolean isSfzftzl() {
		return _sfzftzl;
	}

	public void setSfzftzl(boolean sfzftzl) {
		_sfzftzl = sfzftzl;
	}

	public String getYzzpl1() {
		return _yzzpl1;
	}

	public void setYzzpl1(String yzzpl1) {
		_yzzpl1 = yzzpl1;
	}

	public String getYzzpl2() {
		return _yzzpl2;
	}

	public void setYzzpl2(String yzzpl2) {
		_yzzpl2 = yzzpl2;
	}

	public String getYzzpl3() {
		return _yzzpl3;
	}

	public void setYzzpl3(String yzzpl3) {
		_yzzpl3 = yzzpl3;
	}

	public String getYzzpl4() {
		return _yzzpl4;
	}

	public void setYzzpl4(String yzzpl4) {
		_yzzpl4 = yzzpl4;
	}

	public String getBimsj() {
		return _bimsj;
	}

	public void setBimsj(String bimsj) {
		_bimsj = bimsj;
	}

	public String getBimsg() {
		return _bimsg;
	}

	public void setBimsg(String bimsg) {
		_bimsg = bimsg;
	}

	public String getBimyw() {
		return _bimyw;
	}

	public void setBimyw(String bimyw) {
		_bimyw = bimyw;
	}

	public Date getTjsj() {
		return _tjsj;
	}

	public void setTjsj(Date tjsj) {
		_tjsj = tjsj;
	}

	public String getGcnr() {
		return _gcnr;
	}

	public void setGcnr(String gcnr) {
		_gcnr = gcnr;
	}

	public String getSgxkzsbz() {
		return _sgxkzsbz;
	}

	public void setSgxkzsbz(String sgxkzsbz) {
		_sgxkzsbz = sgxkzsbz;
	}

	public String getGls() {
		return _gls;
	}

	public void setGls(String gls) {
		_gls = gls;
	}

	public String getJzmj() {
		return _jzmj;
	}

	public void setJzmj(String jzmj) {
		_jzmj = jzmj;
	}

	public int getQlsl() {
		return _qlsl;
	}

	public void setQlsl(int qlsl) {
		_qlsl = qlsl;
	}

	public String getQlkd() {
		return _qlkd;
	}

	public void setQlkd(String qlkd) {
		_qlkd = qlkd;
	}

	public int getGuijiaosl() {
		return _guijiaosl;
	}

	public void setGuijiaosl(int guijiaosl) {
		_guijiaosl = guijiaosl;
	}

	public int getSdsl() {
		return _sdsl;
	}

	public void setSdsl(int sdsl) {
		_sdsl = sdsl;
	}

	public int getGaojiasl() {
		return _gaojiasl;
	}

	public void setGaojiasl(int gaojiasl) {
		_gaojiasl = gaojiasl;
	}

	public String getZgj() {
		return _zgj;
	}

	public void setZgj(String zgj) {
		_zgj = zgj;
	}

	public Date getZsqxks() {
		return _zsqxks;
	}

	public void setZsqxks(Date zsqxks) {
		_zsqxks = zsqxks;
	}

	public Date getZsqxjs() {
		return _zsqxjs;
	}

	public void setZsqxjs(Date zsqxjs) {
		_zsqxjs = zsqxjs;
	}

	public String getCnsx() {
		return _cnsx;
	}

	public void setCnsx(String cnsx) {
		_cnsx = cnsx;
	}

	public String getTzly() {
		return _tzly;
	}

	public void setTzly(String tzly) {
		_tzly = tzly;
	}

	public String getGkpzhhzjghwh() {
		return _gkpzhhzjghwh;
	}

	public void setGkpzhhzjghwh(String gkpzhhzjghwh) {
		_gkpzhhzjghwh = gkpzhhzjghwh;
	}

	public Date getPfhhzrq() {
		return _pfhhzrq;
	}

	public void setPfhhzrq(Date pfhhzrq) {
		_pfhhzrq = pfhhzrq;
	}

	public String getCbsjpzjghwh() {
		return _cbsjpzjghwh;
	}

	public void setCbsjpzjghwh(String cbsjpzjghwh) {
		_cbsjpzjghwh = cbsjpzjghwh;
	}

	public Date getPfrq() {
		return _pfrq;
	}

	public void setPfrq(Date pfrq) {
		_pfrq = pfrq;
	}

	public int getPfgq() {
		return _pfgq;
	}

	public void setPfgq(int pfgq) {
		_pfgq = pfgq;
	}

	public String getPzjghwh() {
		return _pzjghwh;
	}

	public void setPzjghwh(String pzjghwh) {
		_pzjghwh = pzjghwh;
	}

	public String getXmdw() {
		return _xmdw;
	}

	public void setXmdw(String xmdw) {
		_xmdw = xmdw;
	}

	public String getXmfzr() {
		return _xmfzr;
	}

	public void setXmfzr(String xmfzr) {
		_xmfzr = xmfzr;
	}

	public String getXmfzrlxdh() {
		return _xmfzrlxdh;
	}

	public void setXmfzrlxdh(String xmfzrlxdh) {
		_xmfzrlxdh = xmfzrlxdh;
	}

	public String getZysjdw() {
		return _zysjdw;
	}

	public void setZysjdw(String zysjdw) {
		_zysjdw = zysjdw;
	}

	public String getSj_zbfs() {
		return _sj_zbfs;
	}

	public void setSj_zbfs(String sj_zbfs) {
		_sj_zbfs = sj_zbfs;
	}

	public String getSj_zbj() {
		return _sj_zbj;
	}

	public void setSj_zbj(String sj_zbj) {
		_sj_zbj = sj_zbj;
	}

	public String getSj_zzdj() {
		return _sj_zzdj;
	}

	public void setSj_zzdj(String sj_zzdj) {
		_sj_zzdj = sj_zzdj;
	}

	public String getSj_zzdjzsbh() {
		return _sj_zzdjzsbh;
	}

	public void setSj_zzdjzsbh(String sj_zzdjzsbh) {
		_sj_zzdjzsbh = sj_zzdjzsbh;
	}

	public String getSj_xmfzr() {
		return _sj_xmfzr;
	}

	public void setSj_xmfzr(String sj_xmfzr) {
		_sj_xmfzr = sj_xmfzr;
	}

	public String getSj_xmfzrzsbh() {
		return _sj_xmfzrzsbh;
	}

	public void setSj_xmfzrzsbh(String sj_xmfzrzsbh) {
		_sj_xmfzrzsbh = sj_xmfzrzsbh;
	}

	public String getZyjldw() {
		return _zyjldw;
	}

	public void setZyjldw(String zyjldw) {
		_zyjldw = zyjldw;
	}

	public String getJl_zbfs() {
		return _jl_zbfs;
	}

	public void setJl_zbfs(String jl_zbfs) {
		_jl_zbfs = jl_zbfs;
	}

	public String getJl_zbj() {
		return _jl_zbj;
	}

	public void setJl_zbj(String jl_zbj) {
		_jl_zbj = jl_zbj;
	}

	public String getJl_zzdj() {
		return _jl_zzdj;
	}

	public void setJl_zzdj(String jl_zzdj) {
		_jl_zzdj = jl_zzdj;
	}

	public String getJl_zzdjzsbh() {
		return _jl_zzdjzsbh;
	}

	public void setJl_zzdjzsbh(String jl_zzdjzsbh) {
		_jl_zzdjzsbh = jl_zzdjzsbh;
	}

	public String getJl_zj() {
		return _jl_zj;
	}

	public void setJl_zj(String jl_zj) {
		_jl_zj = jl_zj;
	}

	public String getJl_zjzsbh() {
		return _jl_zjzsbh;
	}

	public void setJl_zjzsbh(String jl_zjzsbh) {
		_jl_zjzsbh = jl_zjzsbh;
	}

	public String getZysgdw() {
		return _zysgdw;
	}

	public void setZysgdw(String zysgdw) {
		_zysgdw = zysgdw;
	}

	public String getSg_zbfs() {
		return _sg_zbfs;
	}

	public void setSg_zbfs(String sg_zbfs) {
		_sg_zbfs = sg_zbfs;
	}

	public String getSg_zbj() {
		return _sg_zbj;
	}

	public void setSg_zbj(String sg_zbj) {
		_sg_zbj = sg_zbj;
	}

	public String getSg_zzdj() {
		return _sg_zzdj;
	}

	public void setSg_zzdj(String sg_zzdj) {
		_sg_zzdj = sg_zzdj;
	}

	public String getSg_zzdjzsbh() {
		return _sg_zzdjzsbh;
	}

	public void setSg_zzdjzsbh(String sg_zzdjzsbh) {
		_sg_zzdjzsbh = sg_zzdjzsbh;
	}

	public String getSg_xmjl() {
		return _sg_xmjl;
	}

	public void setSg_xmjl(String sg_xmjl) {
		_sg_xmjl = sg_xmjl;
	}

	public String getSg_xmjlzsbh() {
		return _sg_xmjlzsbh;
	}

	public void setSg_xmjlzsbh(String sg_xmjlzsbh) {
		_sg_xmjlzsbh = sg_xmjlzsbh;
	}

	public String getJszjjhlsqk() {
		return _jszjjhlsqk;
	}

	public void setJszjjhlsqk(String jszjjhlsqk) {
		_jszjjhlsqk = jszjjhlsqk;
	}

	public String getDcqwcqk() {
		return _dcqwcqk;
	}

	public void setDcqwcqk(String dcqwcqk) {
		_dcqwcqk = dcqwcqk;
	}

	public String getSgzbqk() {
		return _sgzbqk;
	}

	public void setSgzbqk(String sgzbqk) {
		_sgzbqk = sgzbqk;
	}

	public String getSytdxgwj() {
		return _sytdxgwj;
	}

	public void setSytdxgwj(String sytdxgwj) {
		_sytdxgwj = sytdxgwj;
	}

	public String getGczljddjqk() {
		return _gczljddjqk;
	}

	public void setGczljddjqk(String gczljddjqk) {
		_gczljddjqk = gczljddjqk;
	}

	private long _permitId;
	private String _bjbh;
	private String _jsdwmc;
	private String _jsdwxz;
	private String _jsdwdz;
	private String _gcmc;
	private String _jsdd;
	private String _jsgcgm;
	private String _fwjzmj;
	private String _htjg;
	private int _htgq;
	private String _fddbr;
	private String _jsdwlxdh;
	private String _jsdwlxr;
	private String _jsdwsjh;
	private String _jsgcghxkzbh;
	private String _xckgqk;
	private long _xmlx;
	private String _lxjb;
	private long _xmxz;
	private String _ssqx;
	private String _ywbm;
	private long _jsddssqx;
	private String _jsgclb;
	private long _jsgcsx;
	private String _gyzjbz;
	private String _zbjg;
	private String _xmtzgs;
	private Date _jhkg;
	private Date _jhjg;
	private boolean _sfzftzl;
	private String _yzzpl1;
	private String _yzzpl2;
	private String _yzzpl3;
	private String _yzzpl4;
	private String _bimsj;
	private String _bimsg;
	private String _bimyw;
	private Date _tjsj;
	private String _gcnr;
	private String _sgxkzsbz;
	private String _gls;
	private String _jzmj;
	private int _qlsl;
	private String _qlkd;
	private int _guijiaosl;
	private int _sdsl;
	private int _gaojiasl;
	private String _zgj;
	private Date _zsqxks;
	private Date _zsqxjs;
	private String _cnsx;
	private String _tzly;
	private String _gkpzhhzjghwh;
	private Date _pfhhzrq;
	private String _cbsjpzjghwh;
	private Date _pfrq;
	private int _pfgq;
	private String _pzjghwh;
	private String _xmdw;
	private String _xmfzr;
	private String _xmfzrlxdh;
	private String _zysjdw;
	private String _sj_zbfs;
	private String _sj_zbj;
	private String _sj_zzdj;
	private String _sj_zzdjzsbh;
	private String _sj_xmfzr;
	private String _sj_xmfzrzsbh;
	private String _zyjldw;
	private String _jl_zbfs;
	private String _jl_zbj;
	private String _jl_zzdj;
	private String _jl_zzdjzsbh;
	private String _jl_zj;
	private String _jl_zjzsbh;
	private String _zysgdw;
	private String _sg_zbfs;
	private String _sg_zbj;
	private String _sg_zzdj;
	private String _sg_zzdjzsbh;
	private String _sg_xmjl;
	private String _sg_xmjlzsbh;
	private String _jszjjhlsqk;
	private String _dcqwcqk;
	private String _sgzbqk;
	private String _sytdxgwj;
	private String _gczljddjqk;
}