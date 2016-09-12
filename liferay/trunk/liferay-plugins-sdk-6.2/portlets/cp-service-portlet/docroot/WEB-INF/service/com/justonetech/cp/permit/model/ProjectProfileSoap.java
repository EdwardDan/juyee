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
		soapModel.setJsydpzwjhfdccqzbh(model.getJsydpzwjhfdccqzbh());
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
		soapModel.setTjsj(model.getTjsj());

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

	public String getJsydpzwjhfdccqzbh() {
		return _jsydpzwjhfdccqzbh;
	}

	public void setJsydpzwjhfdccqzbh(String jsydpzwjhfdccqzbh) {
		_jsydpzwjhfdccqzbh = jsydpzwjhfdccqzbh;
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

	public Date getTjsj() {
		return _tjsj;
	}

	public void setTjsj(Date tjsj) {
		_tjsj = tjsj;
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
	private String _jsydpzwjhfdccqzbh;
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
	private Date _tjsj;
}