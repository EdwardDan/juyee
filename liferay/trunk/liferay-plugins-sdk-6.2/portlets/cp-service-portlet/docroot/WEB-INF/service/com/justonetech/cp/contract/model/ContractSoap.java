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

package com.justonetech.cp.contract.model;

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
public class ContractSoap implements Serializable {
	public static ContractSoap toSoapModel(Contract model) {
		ContractSoap soapModel = new ContractSoap();

		soapModel.setContractId(model.getContractId());
		soapModel.setZzjgdm(model.getZzjgdm());
		soapModel.setHtlb(model.getHtlb());
		soapModel.setHtbh(model.getHtbh());
		soapModel.setZbhtbh(model.getZbhtbh());
		soapModel.setFbhtbh(model.getFbhtbh());
		soapModel.setHtlx(model.getHtlx());
		soapModel.setHtzt(model.getHtzt());
		soapModel.setZfbgx(model.getZfbgx());
		soapModel.setBsrq(model.getBsrq());
		soapModel.setSlsj(model.getSlsj());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setSzdq(model.getSzdq());
		soapModel.setXmmc(model.getXmmc());
		soapModel.setJsdw(model.getJsdw());
		soapModel.setJsdd(model.getJsdd());
		soapModel.setLxpw(model.getLxpw());
		soapModel.setPzwh(model.getPzwh());
		soapModel.setDwxz(model.getDwxz());
		soapModel.setZjlygc(model.getZjlygc());
		soapModel.setZtz(model.getZtz());
		soapModel.setZjzmj(model.getZjzmj());
		soapModel.setXmfl(model.getXmfl());
		soapModel.setJzgm(model.getJzgm());
		soapModel.setBdh(model.getBdh());
		soapModel.setFbfs(model.getFbfs());
		soapModel.setCbfs(model.getCbfs());
		soapModel.setZycbht(model.getZycbht());
		soapModel.setZygclb(model.getZygclb());
		soapModel.setHtmc(model.getHtmc());
		soapModel.setFbdw(model.getFbdw());
		soapModel.setCbdw(model.getCbdw());
		soapModel.setSjdw(model.getSjdw());
		soapModel.setXmfzr(model.getXmfzr());
		soapModel.setXmfzrzjlx(model.getXmfzrzjlx());
		soapModel.setXmfzrzjh(model.getXmfzrzjh());
		soapModel.setSjfzr(model.getSjfzr());
		soapModel.setSjfzrzjlx(model.getSjfzrzjlx());
		soapModel.setSjfzrzjh(model.getSjfzrzjh());
		soapModel.setKcdwmc(model.getKcdwmc());
		soapModel.setKcfzr(model.getKcfzr());
		soapModel.setKcfzrzjlx(model.getKcfzrzjlx());
		soapModel.setKcfzrzjh(model.getKcfzrzjh());
		soapModel.setSgdwmc(model.getSgdwmc());
		soapModel.setSgfzr(model.getSgfzr());
		soapModel.setSgfzrzjlx(model.getSgfzrzjlx());
		soapModel.setSgfzrzjh(model.getSgfzrzjh());
		soapModel.setXmlb(model.getXmlb());
		soapModel.setGclb(model.getGclb());
		soapModel.setGcgm(model.getGcgm());
		soapModel.setSjxmlb(model.getSjxmlb());
		soapModel.setSjgclb(model.getSjgclb());
		soapModel.setSjgcgm(model.getSjgcgm());
		soapModel.setSgxmlb(model.getSgxmlb());
		soapModel.setSggclb(model.getSggclb());
		soapModel.setSggcgm(model.getSggcgm());
		soapModel.setKgrq(model.getKgrq());
		soapModel.setJgrq(model.getJgrq());
		soapModel.setJsfs(model.getJsfs());
		soapModel.setHtj(model.getHtj());
		soapModel.setSjf(model.getSjf());
		soapModel.setKcf(model.getKcf());
		soapModel.setJazj(model.getJazj());
		soapModel.setZlje(model.getZlje());
		soapModel.setZgj(model.getZgj());
		soapModel.setAqfhwmsgcsf(model.getAqfhwmsgcsf());
		soapModel.setHtqdrq(model.getHtqdrq());
		soapModel.setHtqzrq(model.getHtqzrq());
		soapModel.setCbnr(model.getCbnr());
		soapModel.setCyhtsfwb(model.getCyhtsfwb());
		soapModel.setFzjqtsm(model.getFzjqtsm());
		soapModel.setSfzx(model.getSfzx());
		soapModel.setZxsj(model.getZxsj());
		soapModel.setZxsm(model.getZxsm());

		return soapModel;
	}

	public static ContractSoap[] toSoapModels(Contract[] models) {
		ContractSoap[] soapModels = new ContractSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContractSoap[][] toSoapModels(Contract[][] models) {
		ContractSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContractSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContractSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContractSoap[] toSoapModels(List<Contract> models) {
		List<ContractSoap> soapModels = new ArrayList<ContractSoap>(models.size());

		for (Contract model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContractSoap[soapModels.size()]);
	}

	public ContractSoap() {
	}

	public String getPrimaryKey() {
		return _contractId;
	}

	public void setPrimaryKey(String pk) {
		setContractId(pk);
	}

	public String getContractId() {
		return _contractId;
	}

	public void setContractId(String contractId) {
		_contractId = contractId;
	}

	public long getZzjgdm() {
		return _zzjgdm;
	}

	public void setZzjgdm(long zzjgdm) {
		_zzjgdm = zzjgdm;
	}

	public String getHtlb() {
		return _htlb;
	}

	public void setHtlb(String htlb) {
		_htlb = htlb;
	}

	public String getHtbh() {
		return _htbh;
	}

	public void setHtbh(String htbh) {
		_htbh = htbh;
	}

	public String getZbhtbh() {
		return _zbhtbh;
	}

	public void setZbhtbh(String zbhtbh) {
		_zbhtbh = zbhtbh;
	}

	public String getFbhtbh() {
		return _fbhtbh;
	}

	public void setFbhtbh(String fbhtbh) {
		_fbhtbh = fbhtbh;
	}

	public String getHtlx() {
		return _htlx;
	}

	public void setHtlx(String htlx) {
		_htlx = htlx;
	}

	public String getHtzt() {
		return _htzt;
	}

	public void setHtzt(String htzt) {
		_htzt = htzt;
	}

	public String getZfbgx() {
		return _zfbgx;
	}

	public void setZfbgx(String zfbgx) {
		_zfbgx = zfbgx;
	}

	public Date getBsrq() {
		return _bsrq;
	}

	public void setBsrq(Date bsrq) {
		_bsrq = bsrq;
	}

	public Date getSlsj() {
		return _slsj;
	}

	public void setSlsj(Date slsj) {
		_slsj = slsj;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public String getSzdq() {
		return _szdq;
	}

	public void setSzdq(String szdq) {
		_szdq = szdq;
	}

	public String getXmmc() {
		return _xmmc;
	}

	public void setXmmc(String xmmc) {
		_xmmc = xmmc;
	}

	public String getJsdw() {
		return _jsdw;
	}

	public void setJsdw(String jsdw) {
		_jsdw = jsdw;
	}

	public String getJsdd() {
		return _jsdd;
	}

	public void setJsdd(String jsdd) {
		_jsdd = jsdd;
	}

	public String getLxpw() {
		return _lxpw;
	}

	public void setLxpw(String lxpw) {
		_lxpw = lxpw;
	}

	public String getPzwh() {
		return _pzwh;
	}

	public void setPzwh(String pzwh) {
		_pzwh = pzwh;
	}

	public String getDwxz() {
		return _dwxz;
	}

	public void setDwxz(String dwxz) {
		_dwxz = dwxz;
	}

	public String getZjlygc() {
		return _zjlygc;
	}

	public void setZjlygc(String zjlygc) {
		_zjlygc = zjlygc;
	}

	public String getZtz() {
		return _ztz;
	}

	public void setZtz(String ztz) {
		_ztz = ztz;
	}

	public String getZjzmj() {
		return _zjzmj;
	}

	public void setZjzmj(String zjzmj) {
		_zjzmj = zjzmj;
	}

	public String getXmfl() {
		return _xmfl;
	}

	public void setXmfl(String xmfl) {
		_xmfl = xmfl;
	}

	public String getJzgm() {
		return _jzgm;
	}

	public void setJzgm(String jzgm) {
		_jzgm = jzgm;
	}

	public String getBdh() {
		return _bdh;
	}

	public void setBdh(String bdh) {
		_bdh = bdh;
	}

	public String getFbfs() {
		return _fbfs;
	}

	public void setFbfs(String fbfs) {
		_fbfs = fbfs;
	}

	public String getCbfs() {
		return _cbfs;
	}

	public void setCbfs(String cbfs) {
		_cbfs = cbfs;
	}

	public String getZycbht() {
		return _zycbht;
	}

	public void setZycbht(String zycbht) {
		_zycbht = zycbht;
	}

	public String getZygclb() {
		return _zygclb;
	}

	public void setZygclb(String zygclb) {
		_zygclb = zygclb;
	}

	public String getHtmc() {
		return _htmc;
	}

	public void setHtmc(String htmc) {
		_htmc = htmc;
	}

	public String getFbdw() {
		return _fbdw;
	}

	public void setFbdw(String fbdw) {
		_fbdw = fbdw;
	}

	public String getCbdw() {
		return _cbdw;
	}

	public void setCbdw(String cbdw) {
		_cbdw = cbdw;
	}

	public String getSjdw() {
		return _sjdw;
	}

	public void setSjdw(String sjdw) {
		_sjdw = sjdw;
	}

	public String getXmfzr() {
		return _xmfzr;
	}

	public void setXmfzr(String xmfzr) {
		_xmfzr = xmfzr;
	}

	public String getXmfzrzjlx() {
		return _xmfzrzjlx;
	}

	public void setXmfzrzjlx(String xmfzrzjlx) {
		_xmfzrzjlx = xmfzrzjlx;
	}

	public String getXmfzrzjh() {
		return _xmfzrzjh;
	}

	public void setXmfzrzjh(String xmfzrzjh) {
		_xmfzrzjh = xmfzrzjh;
	}

	public String getSjfzr() {
		return _sjfzr;
	}

	public void setSjfzr(String sjfzr) {
		_sjfzr = sjfzr;
	}

	public String getSjfzrzjlx() {
		return _sjfzrzjlx;
	}

	public void setSjfzrzjlx(String sjfzrzjlx) {
		_sjfzrzjlx = sjfzrzjlx;
	}

	public String getSjfzrzjh() {
		return _sjfzrzjh;
	}

	public void setSjfzrzjh(String sjfzrzjh) {
		_sjfzrzjh = sjfzrzjh;
	}

	public String getKcdwmc() {
		return _kcdwmc;
	}

	public void setKcdwmc(String kcdwmc) {
		_kcdwmc = kcdwmc;
	}

	public String getKcfzr() {
		return _kcfzr;
	}

	public void setKcfzr(String kcfzr) {
		_kcfzr = kcfzr;
	}

	public String getKcfzrzjlx() {
		return _kcfzrzjlx;
	}

	public void setKcfzrzjlx(String kcfzrzjlx) {
		_kcfzrzjlx = kcfzrzjlx;
	}

	public String getKcfzrzjh() {
		return _kcfzrzjh;
	}

	public void setKcfzrzjh(String kcfzrzjh) {
		_kcfzrzjh = kcfzrzjh;
	}

	public String getSgdwmc() {
		return _sgdwmc;
	}

	public void setSgdwmc(String sgdwmc) {
		_sgdwmc = sgdwmc;
	}

	public String getSgfzr() {
		return _sgfzr;
	}

	public void setSgfzr(String sgfzr) {
		_sgfzr = sgfzr;
	}

	public String getSgfzrzjlx() {
		return _sgfzrzjlx;
	}

	public void setSgfzrzjlx(String sgfzrzjlx) {
		_sgfzrzjlx = sgfzrzjlx;
	}

	public String getSgfzrzjh() {
		return _sgfzrzjh;
	}

	public void setSgfzrzjh(String sgfzrzjh) {
		_sgfzrzjh = sgfzrzjh;
	}

	public String getXmlb() {
		return _xmlb;
	}

	public void setXmlb(String xmlb) {
		_xmlb = xmlb;
	}

	public String getGclb() {
		return _gclb;
	}

	public void setGclb(String gclb) {
		_gclb = gclb;
	}

	public String getGcgm() {
		return _gcgm;
	}

	public void setGcgm(String gcgm) {
		_gcgm = gcgm;
	}

	public String getSjxmlb() {
		return _sjxmlb;
	}

	public void setSjxmlb(String sjxmlb) {
		_sjxmlb = sjxmlb;
	}

	public String getSjgclb() {
		return _sjgclb;
	}

	public void setSjgclb(String sjgclb) {
		_sjgclb = sjgclb;
	}

	public String getSjgcgm() {
		return _sjgcgm;
	}

	public void setSjgcgm(String sjgcgm) {
		_sjgcgm = sjgcgm;
	}

	public String getSgxmlb() {
		return _sgxmlb;
	}

	public void setSgxmlb(String sgxmlb) {
		_sgxmlb = sgxmlb;
	}

	public String getSggclb() {
		return _sggclb;
	}

	public void setSggclb(String sggclb) {
		_sggclb = sggclb;
	}

	public String getSggcgm() {
		return _sggcgm;
	}

	public void setSggcgm(String sggcgm) {
		_sggcgm = sggcgm;
	}

	public Date getKgrq() {
		return _kgrq;
	}

	public void setKgrq(Date kgrq) {
		_kgrq = kgrq;
	}

	public Date getJgrq() {
		return _jgrq;
	}

	public void setJgrq(Date jgrq) {
		_jgrq = jgrq;
	}

	public String getJsfs() {
		return _jsfs;
	}

	public void setJsfs(String jsfs) {
		_jsfs = jsfs;
	}

	public String getHtj() {
		return _htj;
	}

	public void setHtj(String htj) {
		_htj = htj;
	}

	public String getSjf() {
		return _sjf;
	}

	public void setSjf(String sjf) {
		_sjf = sjf;
	}

	public String getKcf() {
		return _kcf;
	}

	public void setKcf(String kcf) {
		_kcf = kcf;
	}

	public String getJazj() {
		return _jazj;
	}

	public void setJazj(String jazj) {
		_jazj = jazj;
	}

	public String getZlje() {
		return _zlje;
	}

	public void setZlje(String zlje) {
		_zlje = zlje;
	}

	public String getZgj() {
		return _zgj;
	}

	public void setZgj(String zgj) {
		_zgj = zgj;
	}

	public String getAqfhwmsgcsf() {
		return _aqfhwmsgcsf;
	}

	public void setAqfhwmsgcsf(String aqfhwmsgcsf) {
		_aqfhwmsgcsf = aqfhwmsgcsf;
	}

	public Date getHtqdrq() {
		return _htqdrq;
	}

	public void setHtqdrq(Date htqdrq) {
		_htqdrq = htqdrq;
	}

	public String getHtqzrq() {
		return _htqzrq;
	}

	public void setHtqzrq(String htqzrq) {
		_htqzrq = htqzrq;
	}

	public String getCbnr() {
		return _cbnr;
	}

	public void setCbnr(String cbnr) {
		_cbnr = cbnr;
	}

	public String getCyhtsfwb() {
		return _cyhtsfwb;
	}

	public void setCyhtsfwb(String cyhtsfwb) {
		_cyhtsfwb = cyhtsfwb;
	}

	public String getFzjqtsm() {
		return _fzjqtsm;
	}

	public void setFzjqtsm(String fzjqtsm) {
		_fzjqtsm = fzjqtsm;
	}

	public String getSfzx() {
		return _sfzx;
	}

	public void setSfzx(String sfzx) {
		_sfzx = sfzx;
	}

	public Date getZxsj() {
		return _zxsj;
	}

	public void setZxsj(Date zxsj) {
		_zxsj = zxsj;
	}

	public Date getZxsm() {
		return _zxsm;
	}

	public void setZxsm(Date zxsm) {
		_zxsm = zxsm;
	}

	private String _contractId;
	private long _zzjgdm;
	private String _htlb;
	private String _htbh;
	private String _zbhtbh;
	private String _fbhtbh;
	private String _htlx;
	private String _htzt;
	private String _zfbgx;
	private Date _bsrq;
	private Date _slsj;
	private String _bjbh;
	private String _szdq;
	private String _xmmc;
	private String _jsdw;
	private String _jsdd;
	private String _lxpw;
	private String _pzwh;
	private String _dwxz;
	private String _zjlygc;
	private String _ztz;
	private String _zjzmj;
	private String _xmfl;
	private String _jzgm;
	private String _bdh;
	private String _fbfs;
	private String _cbfs;
	private String _zycbht;
	private String _zygclb;
	private String _htmc;
	private String _fbdw;
	private String _cbdw;
	private String _sjdw;
	private String _xmfzr;
	private String _xmfzrzjlx;
	private String _xmfzrzjh;
	private String _sjfzr;
	private String _sjfzrzjlx;
	private String _sjfzrzjh;
	private String _kcdwmc;
	private String _kcfzr;
	private String _kcfzrzjlx;
	private String _kcfzrzjh;
	private String _sgdwmc;
	private String _sgfzr;
	private String _sgfzrzjlx;
	private String _sgfzrzjh;
	private String _xmlb;
	private String _gclb;
	private String _gcgm;
	private String _sjxmlb;
	private String _sjgclb;
	private String _sjgcgm;
	private String _sgxmlb;
	private String _sggclb;
	private String _sggcgm;
	private Date _kgrq;
	private Date _jgrq;
	private String _jsfs;
	private String _htj;
	private String _sjf;
	private String _kcf;
	private String _jazj;
	private String _zlje;
	private String _zgj;
	private String _aqfhwmsgcsf;
	private Date _htqdrq;
	private String _htqzrq;
	private String _cbnr;
	private String _cyhtsfwb;
	private String _fzjqtsm;
	private String _sfzx;
	private Date _zxsj;
	private Date _zxsm;
}