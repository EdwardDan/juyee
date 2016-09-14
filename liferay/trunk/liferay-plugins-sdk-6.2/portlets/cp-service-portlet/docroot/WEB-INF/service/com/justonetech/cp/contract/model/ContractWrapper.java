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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contract}.
 * </p>
 *
 * @author fanqi
 * @see Contract
 * @generated
 */
public class ContractWrapper implements Contract, ModelWrapper<Contract> {
	public ContractWrapper(Contract contract) {
		_contract = contract;
	}

	@Override
	public Class<?> getModelClass() {
		return Contract.class;
	}

	@Override
	public String getModelClassName() {
		return Contract.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contractId", getContractId());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("htlb", getHtlb());
		attributes.put("id", getId());
		attributes.put("htid", getHtid());
		attributes.put("htbh", getHtbh());
		attributes.put("zbhtbh", getZbhtbh());
		attributes.put("fbhtbh", getFbhtbh());
		attributes.put("lwfbhtbh", getLwfbhtbh());
		attributes.put("htlx", getHtlx());
		attributes.put("htzt", getHtzt());
		attributes.put("zfbgx", getZfbgx());
		attributes.put("sfsl", getSfsl());
		attributes.put("zxbz", getZxbz());
		attributes.put("state", getState());
		attributes.put("bssj", getBssj());
		attributes.put("slsj", getSlsj());
		attributes.put("bjbh", getBjbh());
		attributes.put("szdq", getSzdq());
		attributes.put("xmmc", getXmmc());
		attributes.put("jsdw", getJsdw());
		attributes.put("jsdd", getJsdd());
		attributes.put("lxpw", getLxpw());
		attributes.put("pzwh", getPzwh());
		attributes.put("dwxz", getDwxz());
		attributes.put("zjlygc", getZjlygc());
		attributes.put("ztz", getZtz());
		attributes.put("zmj", getZmj());
		attributes.put("xmfl", getXmfl());
		attributes.put("jsgm", getJsgm());
		attributes.put("bdh", getBdh());
		attributes.put("fbfs", getFbfs());
		attributes.put("cbfs", getCbfs());
		attributes.put("zycbht", getZycbht());
		attributes.put("zygclb", getZygclb());
		attributes.put("htmc", getHtmc());
		attributes.put("fbdw", getFbdw());
		attributes.put("cbdw", getCbdw());
		attributes.put("sjdw", getSjdw());
		attributes.put("xmfzr", getXmfzr());
		attributes.put("xmfzrzjlx", getXmfzrzjlx());
		attributes.put("xmfzrzjh", getXmfzrzjh());
		attributes.put("sjfzr", getSjfzr());
		attributes.put("sjfzrzjlx", getSjfzrzjlx());
		attributes.put("sjfzrzjh", getSjfzrzjh());
		attributes.put("kcdw", getKcdw());
		attributes.put("kcfzr", getKcfzr());
		attributes.put("kcfzrzjlx", getKcfzrzjlx());
		attributes.put("kcfzrzjh", getKcfzrzjh());
		attributes.put("sgdw", getSgdw());
		attributes.put("sgfzr", getSgfzr());
		attributes.put("sgfzrzjlx", getSgfzrzjlx());
		attributes.put("sgfzrzjh", getSgfzrzjh());
		attributes.put("xmlb", getXmlb());
		attributes.put("gclb", getGclb());
		attributes.put("gcgm", getGcgm());
		attributes.put("sjxmlb", getSjxmlb());
		attributes.put("sjgclb", getSjgclb());
		attributes.put("sjgcgm", getSjgcgm());
		attributes.put("sgxmlb", getSgxmlb());
		attributes.put("sggclb", getSggclb());
		attributes.put("sggcgm", getSggcgm());
		attributes.put("kgrq", getKgrq());
		attributes.put("jgrq", getJgrq());
		attributes.put("jsfs", getJsfs());
		attributes.put("htj", getHtj());
		attributes.put("sjf", getSjf());
		attributes.put("kcf", getKcf());
		attributes.put("jazj", getJazj());
		attributes.put("zlje", getZlje());
		attributes.put("zgj", getZgj());
		attributes.put("wmcsf", getWmcsf());
		attributes.put("htqdrq", getHtqdrq());
		attributes.put("htqzrq", getHtqzrq());
		attributes.put("cbnr", getCbnr());
		attributes.put("htsfwbmc", getHtsfwbmc());
		attributes.put("bz", getBz());
		attributes.put("sfzx", getSfzx());
		attributes.put("zxsj", getZxsj());
		attributes.put("zxsm", getZxsm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String contractId = (String)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		String zzjgdm = (String)attributes.get("zzjgdm");

		if (zzjgdm != null) {
			setZzjgdm(zzjgdm);
		}

		String htlb = (String)attributes.get("htlb");

		if (htlb != null) {
			setHtlb(htlb);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String htid = (String)attributes.get("htid");

		if (htid != null) {
			setHtid(htid);
		}

		String htbh = (String)attributes.get("htbh");

		if (htbh != null) {
			setHtbh(htbh);
		}

		String zbhtbh = (String)attributes.get("zbhtbh");

		if (zbhtbh != null) {
			setZbhtbh(zbhtbh);
		}

		String fbhtbh = (String)attributes.get("fbhtbh");

		if (fbhtbh != null) {
			setFbhtbh(fbhtbh);
		}

		String lwfbhtbh = (String)attributes.get("lwfbhtbh");

		if (lwfbhtbh != null) {
			setLwfbhtbh(lwfbhtbh);
		}

		String htlx = (String)attributes.get("htlx");

		if (htlx != null) {
			setHtlx(htlx);
		}

		String htzt = (String)attributes.get("htzt");

		if (htzt != null) {
			setHtzt(htzt);
		}

		String zfbgx = (String)attributes.get("zfbgx");

		if (zfbgx != null) {
			setZfbgx(zfbgx);
		}

		String sfsl = (String)attributes.get("sfsl");

		if (sfsl != null) {
			setSfsl(sfsl);
		}

		String zxbz = (String)attributes.get("zxbz");

		if (zxbz != null) {
			setZxbz(zxbz);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Date bssj = (Date)attributes.get("bssj");

		if (bssj != null) {
			setBssj(bssj);
		}

		Date slsj = (Date)attributes.get("slsj");

		if (slsj != null) {
			setSlsj(slsj);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String szdq = (String)attributes.get("szdq");

		if (szdq != null) {
			setSzdq(szdq);
		}

		String xmmc = (String)attributes.get("xmmc");

		if (xmmc != null) {
			setXmmc(xmmc);
		}

		String jsdw = (String)attributes.get("jsdw");

		if (jsdw != null) {
			setJsdw(jsdw);
		}

		String jsdd = (String)attributes.get("jsdd");

		if (jsdd != null) {
			setJsdd(jsdd);
		}

		String lxpw = (String)attributes.get("lxpw");

		if (lxpw != null) {
			setLxpw(lxpw);
		}

		String pzwh = (String)attributes.get("pzwh");

		if (pzwh != null) {
			setPzwh(pzwh);
		}

		String dwxz = (String)attributes.get("dwxz");

		if (dwxz != null) {
			setDwxz(dwxz);
		}

		String zjlygc = (String)attributes.get("zjlygc");

		if (zjlygc != null) {
			setZjlygc(zjlygc);
		}

		String ztz = (String)attributes.get("ztz");

		if (ztz != null) {
			setZtz(ztz);
		}

		String zmj = (String)attributes.get("zmj");

		if (zmj != null) {
			setZmj(zmj);
		}

		String xmfl = (String)attributes.get("xmfl");

		if (xmfl != null) {
			setXmfl(xmfl);
		}

		String jsgm = (String)attributes.get("jsgm");

		if (jsgm != null) {
			setJsgm(jsgm);
		}

		String bdh = (String)attributes.get("bdh");

		if (bdh != null) {
			setBdh(bdh);
		}

		String fbfs = (String)attributes.get("fbfs");

		if (fbfs != null) {
			setFbfs(fbfs);
		}

		String cbfs = (String)attributes.get("cbfs");

		if (cbfs != null) {
			setCbfs(cbfs);
		}

		String zycbht = (String)attributes.get("zycbht");

		if (zycbht != null) {
			setZycbht(zycbht);
		}

		String zygclb = (String)attributes.get("zygclb");

		if (zygclb != null) {
			setZygclb(zygclb);
		}

		String htmc = (String)attributes.get("htmc");

		if (htmc != null) {
			setHtmc(htmc);
		}

		String fbdw = (String)attributes.get("fbdw");

		if (fbdw != null) {
			setFbdw(fbdw);
		}

		String cbdw = (String)attributes.get("cbdw");

		if (cbdw != null) {
			setCbdw(cbdw);
		}

		String sjdw = (String)attributes.get("sjdw");

		if (sjdw != null) {
			setSjdw(sjdw);
		}

		String xmfzr = (String)attributes.get("xmfzr");

		if (xmfzr != null) {
			setXmfzr(xmfzr);
		}

		String xmfzrzjlx = (String)attributes.get("xmfzrzjlx");

		if (xmfzrzjlx != null) {
			setXmfzrzjlx(xmfzrzjlx);
		}

		String xmfzrzjh = (String)attributes.get("xmfzrzjh");

		if (xmfzrzjh != null) {
			setXmfzrzjh(xmfzrzjh);
		}

		String sjfzr = (String)attributes.get("sjfzr");

		if (sjfzr != null) {
			setSjfzr(sjfzr);
		}

		String sjfzrzjlx = (String)attributes.get("sjfzrzjlx");

		if (sjfzrzjlx != null) {
			setSjfzrzjlx(sjfzrzjlx);
		}

		String sjfzrzjh = (String)attributes.get("sjfzrzjh");

		if (sjfzrzjh != null) {
			setSjfzrzjh(sjfzrzjh);
		}

		String kcdw = (String)attributes.get("kcdw");

		if (kcdw != null) {
			setKcdw(kcdw);
		}

		String kcfzr = (String)attributes.get("kcfzr");

		if (kcfzr != null) {
			setKcfzr(kcfzr);
		}

		String kcfzrzjlx = (String)attributes.get("kcfzrzjlx");

		if (kcfzrzjlx != null) {
			setKcfzrzjlx(kcfzrzjlx);
		}

		String kcfzrzjh = (String)attributes.get("kcfzrzjh");

		if (kcfzrzjh != null) {
			setKcfzrzjh(kcfzrzjh);
		}

		String sgdw = (String)attributes.get("sgdw");

		if (sgdw != null) {
			setSgdw(sgdw);
		}

		String sgfzr = (String)attributes.get("sgfzr");

		if (sgfzr != null) {
			setSgfzr(sgfzr);
		}

		String sgfzrzjlx = (String)attributes.get("sgfzrzjlx");

		if (sgfzrzjlx != null) {
			setSgfzrzjlx(sgfzrzjlx);
		}

		String sgfzrzjh = (String)attributes.get("sgfzrzjh");

		if (sgfzrzjh != null) {
			setSgfzrzjh(sgfzrzjh);
		}

		String xmlb = (String)attributes.get("xmlb");

		if (xmlb != null) {
			setXmlb(xmlb);
		}

		String gclb = (String)attributes.get("gclb");

		if (gclb != null) {
			setGclb(gclb);
		}

		String gcgm = (String)attributes.get("gcgm");

		if (gcgm != null) {
			setGcgm(gcgm);
		}

		String sjxmlb = (String)attributes.get("sjxmlb");

		if (sjxmlb != null) {
			setSjxmlb(sjxmlb);
		}

		String sjgclb = (String)attributes.get("sjgclb");

		if (sjgclb != null) {
			setSjgclb(sjgclb);
		}

		String sjgcgm = (String)attributes.get("sjgcgm");

		if (sjgcgm != null) {
			setSjgcgm(sjgcgm);
		}

		String sgxmlb = (String)attributes.get("sgxmlb");

		if (sgxmlb != null) {
			setSgxmlb(sgxmlb);
		}

		String sggclb = (String)attributes.get("sggclb");

		if (sggclb != null) {
			setSggclb(sggclb);
		}

		String sggcgm = (String)attributes.get("sggcgm");

		if (sggcgm != null) {
			setSggcgm(sggcgm);
		}

		Date kgrq = (Date)attributes.get("kgrq");

		if (kgrq != null) {
			setKgrq(kgrq);
		}

		Date jgrq = (Date)attributes.get("jgrq");

		if (jgrq != null) {
			setJgrq(jgrq);
		}

		String jsfs = (String)attributes.get("jsfs");

		if (jsfs != null) {
			setJsfs(jsfs);
		}

		String htj = (String)attributes.get("htj");

		if (htj != null) {
			setHtj(htj);
		}

		String sjf = (String)attributes.get("sjf");

		if (sjf != null) {
			setSjf(sjf);
		}

		String kcf = (String)attributes.get("kcf");

		if (kcf != null) {
			setKcf(kcf);
		}

		String jazj = (String)attributes.get("jazj");

		if (jazj != null) {
			setJazj(jazj);
		}

		String zlje = (String)attributes.get("zlje");

		if (zlje != null) {
			setZlje(zlje);
		}

		String zgj = (String)attributes.get("zgj");

		if (zgj != null) {
			setZgj(zgj);
		}

		String wmcsf = (String)attributes.get("wmcsf");

		if (wmcsf != null) {
			setWmcsf(wmcsf);
		}

		Date htqdrq = (Date)attributes.get("htqdrq");

		if (htqdrq != null) {
			setHtqdrq(htqdrq);
		}

		String htqzrq = (String)attributes.get("htqzrq");

		if (htqzrq != null) {
			setHtqzrq(htqzrq);
		}

		String cbnr = (String)attributes.get("cbnr");

		if (cbnr != null) {
			setCbnr(cbnr);
		}

		String htsfwbmc = (String)attributes.get("htsfwbmc");

		if (htsfwbmc != null) {
			setHtsfwbmc(htsfwbmc);
		}

		String bz = (String)attributes.get("bz");

		if (bz != null) {
			setBz(bz);
		}

		String sfzx = (String)attributes.get("sfzx");

		if (sfzx != null) {
			setSfzx(sfzx);
		}

		Date zxsj = (Date)attributes.get("zxsj");

		if (zxsj != null) {
			setZxsj(zxsj);
		}

		String zxsm = (String)attributes.get("zxsm");

		if (zxsm != null) {
			setZxsm(zxsm);
		}
	}

	/**
	* Returns the primary key of this contract.
	*
	* @return the primary key of this contract
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _contract.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contract.
	*
	* @param primaryKey the primary key of this contract
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_contract.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contract ID of this contract.
	*
	* @return the contract ID of this contract
	*/
	@Override
	public java.lang.String getContractId() {
		return _contract.getContractId();
	}

	/**
	* Sets the contract ID of this contract.
	*
	* @param contractId the contract ID of this contract
	*/
	@Override
	public void setContractId(java.lang.String contractId) {
		_contract.setContractId(contractId);
	}

	/**
	* Returns the zzjgdm of this contract.
	*
	* @return the zzjgdm of this contract
	*/
	@Override
	public java.lang.String getZzjgdm() {
		return _contract.getZzjgdm();
	}

	/**
	* Sets the zzjgdm of this contract.
	*
	* @param zzjgdm the zzjgdm of this contract
	*/
	@Override
	public void setZzjgdm(java.lang.String zzjgdm) {
		_contract.setZzjgdm(zzjgdm);
	}

	/**
	* Returns the htlb of this contract.
	*
	* @return the htlb of this contract
	*/
	@Override
	public java.lang.String getHtlb() {
		return _contract.getHtlb();
	}

	/**
	* Sets the htlb of this contract.
	*
	* @param htlb the htlb of this contract
	*/
	@Override
	public void setHtlb(java.lang.String htlb) {
		_contract.setHtlb(htlb);
	}

	/**
	* Returns the ID of this contract.
	*
	* @return the ID of this contract
	*/
	@Override
	public java.lang.String getId() {
		return _contract.getId();
	}

	/**
	* Sets the ID of this contract.
	*
	* @param id the ID of this contract
	*/
	@Override
	public void setId(java.lang.String id) {
		_contract.setId(id);
	}

	/**
	* Returns the htid of this contract.
	*
	* @return the htid of this contract
	*/
	@Override
	public java.lang.String getHtid() {
		return _contract.getHtid();
	}

	/**
	* Sets the htid of this contract.
	*
	* @param htid the htid of this contract
	*/
	@Override
	public void setHtid(java.lang.String htid) {
		_contract.setHtid(htid);
	}

	/**
	* Returns the htbh of this contract.
	*
	* @return the htbh of this contract
	*/
	@Override
	public java.lang.String getHtbh() {
		return _contract.getHtbh();
	}

	/**
	* Sets the htbh of this contract.
	*
	* @param htbh the htbh of this contract
	*/
	@Override
	public void setHtbh(java.lang.String htbh) {
		_contract.setHtbh(htbh);
	}

	/**
	* Returns the zbhtbh of this contract.
	*
	* @return the zbhtbh of this contract
	*/
	@Override
	public java.lang.String getZbhtbh() {
		return _contract.getZbhtbh();
	}

	/**
	* Sets the zbhtbh of this contract.
	*
	* @param zbhtbh the zbhtbh of this contract
	*/
	@Override
	public void setZbhtbh(java.lang.String zbhtbh) {
		_contract.setZbhtbh(zbhtbh);
	}

	/**
	* Returns the fbhtbh of this contract.
	*
	* @return the fbhtbh of this contract
	*/
	@Override
	public java.lang.String getFbhtbh() {
		return _contract.getFbhtbh();
	}

	/**
	* Sets the fbhtbh of this contract.
	*
	* @param fbhtbh the fbhtbh of this contract
	*/
	@Override
	public void setFbhtbh(java.lang.String fbhtbh) {
		_contract.setFbhtbh(fbhtbh);
	}

	/**
	* Returns the lwfbhtbh of this contract.
	*
	* @return the lwfbhtbh of this contract
	*/
	@Override
	public java.lang.String getLwfbhtbh() {
		return _contract.getLwfbhtbh();
	}

	/**
	* Sets the lwfbhtbh of this contract.
	*
	* @param lwfbhtbh the lwfbhtbh of this contract
	*/
	@Override
	public void setLwfbhtbh(java.lang.String lwfbhtbh) {
		_contract.setLwfbhtbh(lwfbhtbh);
	}

	/**
	* Returns the htlx of this contract.
	*
	* @return the htlx of this contract
	*/
	@Override
	public java.lang.String getHtlx() {
		return _contract.getHtlx();
	}

	/**
	* Sets the htlx of this contract.
	*
	* @param htlx the htlx of this contract
	*/
	@Override
	public void setHtlx(java.lang.String htlx) {
		_contract.setHtlx(htlx);
	}

	/**
	* Returns the htzt of this contract.
	*
	* @return the htzt of this contract
	*/
	@Override
	public java.lang.String getHtzt() {
		return _contract.getHtzt();
	}

	/**
	* Sets the htzt of this contract.
	*
	* @param htzt the htzt of this contract
	*/
	@Override
	public void setHtzt(java.lang.String htzt) {
		_contract.setHtzt(htzt);
	}

	/**
	* Returns the zfbgx of this contract.
	*
	* @return the zfbgx of this contract
	*/
	@Override
	public java.lang.String getZfbgx() {
		return _contract.getZfbgx();
	}

	/**
	* Sets the zfbgx of this contract.
	*
	* @param zfbgx the zfbgx of this contract
	*/
	@Override
	public void setZfbgx(java.lang.String zfbgx) {
		_contract.setZfbgx(zfbgx);
	}

	/**
	* Returns the sfsl of this contract.
	*
	* @return the sfsl of this contract
	*/
	@Override
	public java.lang.String getSfsl() {
		return _contract.getSfsl();
	}

	/**
	* Sets the sfsl of this contract.
	*
	* @param sfsl the sfsl of this contract
	*/
	@Override
	public void setSfsl(java.lang.String sfsl) {
		_contract.setSfsl(sfsl);
	}

	/**
	* Returns the zxbz of this contract.
	*
	* @return the zxbz of this contract
	*/
	@Override
	public java.lang.String getZxbz() {
		return _contract.getZxbz();
	}

	/**
	* Sets the zxbz of this contract.
	*
	* @param zxbz the zxbz of this contract
	*/
	@Override
	public void setZxbz(java.lang.String zxbz) {
		_contract.setZxbz(zxbz);
	}

	/**
	* Returns the state of this contract.
	*
	* @return the state of this contract
	*/
	@Override
	public java.lang.String getState() {
		return _contract.getState();
	}

	/**
	* Sets the state of this contract.
	*
	* @param state the state of this contract
	*/
	@Override
	public void setState(java.lang.String state) {
		_contract.setState(state);
	}

	/**
	* Returns the bssj of this contract.
	*
	* @return the bssj of this contract
	*/
	@Override
	public java.util.Date getBssj() {
		return _contract.getBssj();
	}

	/**
	* Sets the bssj of this contract.
	*
	* @param bssj the bssj of this contract
	*/
	@Override
	public void setBssj(java.util.Date bssj) {
		_contract.setBssj(bssj);
	}

	/**
	* Returns the slsj of this contract.
	*
	* @return the slsj of this contract
	*/
	@Override
	public java.util.Date getSlsj() {
		return _contract.getSlsj();
	}

	/**
	* Sets the slsj of this contract.
	*
	* @param slsj the slsj of this contract
	*/
	@Override
	public void setSlsj(java.util.Date slsj) {
		_contract.setSlsj(slsj);
	}

	/**
	* Returns the bjbh of this contract.
	*
	* @return the bjbh of this contract
	*/
	@Override
	public java.lang.String getBjbh() {
		return _contract.getBjbh();
	}

	/**
	* Sets the bjbh of this contract.
	*
	* @param bjbh the bjbh of this contract
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_contract.setBjbh(bjbh);
	}

	/**
	* Returns the szdq of this contract.
	*
	* @return the szdq of this contract
	*/
	@Override
	public java.lang.String getSzdq() {
		return _contract.getSzdq();
	}

	/**
	* Sets the szdq of this contract.
	*
	* @param szdq the szdq of this contract
	*/
	@Override
	public void setSzdq(java.lang.String szdq) {
		_contract.setSzdq(szdq);
	}

	/**
	* Returns the xmmc of this contract.
	*
	* @return the xmmc of this contract
	*/
	@Override
	public java.lang.String getXmmc() {
		return _contract.getXmmc();
	}

	/**
	* Sets the xmmc of this contract.
	*
	* @param xmmc the xmmc of this contract
	*/
	@Override
	public void setXmmc(java.lang.String xmmc) {
		_contract.setXmmc(xmmc);
	}

	/**
	* Returns the jsdw of this contract.
	*
	* @return the jsdw of this contract
	*/
	@Override
	public java.lang.String getJsdw() {
		return _contract.getJsdw();
	}

	/**
	* Sets the jsdw of this contract.
	*
	* @param jsdw the jsdw of this contract
	*/
	@Override
	public void setJsdw(java.lang.String jsdw) {
		_contract.setJsdw(jsdw);
	}

	/**
	* Returns the jsdd of this contract.
	*
	* @return the jsdd of this contract
	*/
	@Override
	public java.lang.String getJsdd() {
		return _contract.getJsdd();
	}

	/**
	* Sets the jsdd of this contract.
	*
	* @param jsdd the jsdd of this contract
	*/
	@Override
	public void setJsdd(java.lang.String jsdd) {
		_contract.setJsdd(jsdd);
	}

	/**
	* Returns the lxpw of this contract.
	*
	* @return the lxpw of this contract
	*/
	@Override
	public java.lang.String getLxpw() {
		return _contract.getLxpw();
	}

	/**
	* Sets the lxpw of this contract.
	*
	* @param lxpw the lxpw of this contract
	*/
	@Override
	public void setLxpw(java.lang.String lxpw) {
		_contract.setLxpw(lxpw);
	}

	/**
	* Returns the pzwh of this contract.
	*
	* @return the pzwh of this contract
	*/
	@Override
	public java.lang.String getPzwh() {
		return _contract.getPzwh();
	}

	/**
	* Sets the pzwh of this contract.
	*
	* @param pzwh the pzwh of this contract
	*/
	@Override
	public void setPzwh(java.lang.String pzwh) {
		_contract.setPzwh(pzwh);
	}

	/**
	* Returns the dwxz of this contract.
	*
	* @return the dwxz of this contract
	*/
	@Override
	public java.lang.String getDwxz() {
		return _contract.getDwxz();
	}

	/**
	* Sets the dwxz of this contract.
	*
	* @param dwxz the dwxz of this contract
	*/
	@Override
	public void setDwxz(java.lang.String dwxz) {
		_contract.setDwxz(dwxz);
	}

	/**
	* Returns the zjlygc of this contract.
	*
	* @return the zjlygc of this contract
	*/
	@Override
	public java.lang.String getZjlygc() {
		return _contract.getZjlygc();
	}

	/**
	* Sets the zjlygc of this contract.
	*
	* @param zjlygc the zjlygc of this contract
	*/
	@Override
	public void setZjlygc(java.lang.String zjlygc) {
		_contract.setZjlygc(zjlygc);
	}

	/**
	* Returns the ztz of this contract.
	*
	* @return the ztz of this contract
	*/
	@Override
	public java.lang.String getZtz() {
		return _contract.getZtz();
	}

	/**
	* Sets the ztz of this contract.
	*
	* @param ztz the ztz of this contract
	*/
	@Override
	public void setZtz(java.lang.String ztz) {
		_contract.setZtz(ztz);
	}

	/**
	* Returns the zmj of this contract.
	*
	* @return the zmj of this contract
	*/
	@Override
	public java.lang.String getZmj() {
		return _contract.getZmj();
	}

	/**
	* Sets the zmj of this contract.
	*
	* @param zmj the zmj of this contract
	*/
	@Override
	public void setZmj(java.lang.String zmj) {
		_contract.setZmj(zmj);
	}

	/**
	* Returns the xmfl of this contract.
	*
	* @return the xmfl of this contract
	*/
	@Override
	public java.lang.String getXmfl() {
		return _contract.getXmfl();
	}

	/**
	* Sets the xmfl of this contract.
	*
	* @param xmfl the xmfl of this contract
	*/
	@Override
	public void setXmfl(java.lang.String xmfl) {
		_contract.setXmfl(xmfl);
	}

	/**
	* Returns the jsgm of this contract.
	*
	* @return the jsgm of this contract
	*/
	@Override
	public java.lang.String getJsgm() {
		return _contract.getJsgm();
	}

	/**
	* Sets the jsgm of this contract.
	*
	* @param jsgm the jsgm of this contract
	*/
	@Override
	public void setJsgm(java.lang.String jsgm) {
		_contract.setJsgm(jsgm);
	}

	/**
	* Returns the bdh of this contract.
	*
	* @return the bdh of this contract
	*/
	@Override
	public java.lang.String getBdh() {
		return _contract.getBdh();
	}

	/**
	* Sets the bdh of this contract.
	*
	* @param bdh the bdh of this contract
	*/
	@Override
	public void setBdh(java.lang.String bdh) {
		_contract.setBdh(bdh);
	}

	/**
	* Returns the fbfs of this contract.
	*
	* @return the fbfs of this contract
	*/
	@Override
	public java.lang.String getFbfs() {
		return _contract.getFbfs();
	}

	/**
	* Sets the fbfs of this contract.
	*
	* @param fbfs the fbfs of this contract
	*/
	@Override
	public void setFbfs(java.lang.String fbfs) {
		_contract.setFbfs(fbfs);
	}

	/**
	* Returns the cbfs of this contract.
	*
	* @return the cbfs of this contract
	*/
	@Override
	public java.lang.String getCbfs() {
		return _contract.getCbfs();
	}

	/**
	* Sets the cbfs of this contract.
	*
	* @param cbfs the cbfs of this contract
	*/
	@Override
	public void setCbfs(java.lang.String cbfs) {
		_contract.setCbfs(cbfs);
	}

	/**
	* Returns the zycbht of this contract.
	*
	* @return the zycbht of this contract
	*/
	@Override
	public java.lang.String getZycbht() {
		return _contract.getZycbht();
	}

	/**
	* Sets the zycbht of this contract.
	*
	* @param zycbht the zycbht of this contract
	*/
	@Override
	public void setZycbht(java.lang.String zycbht) {
		_contract.setZycbht(zycbht);
	}

	/**
	* Returns the zygclb of this contract.
	*
	* @return the zygclb of this contract
	*/
	@Override
	public java.lang.String getZygclb() {
		return _contract.getZygclb();
	}

	/**
	* Sets the zygclb of this contract.
	*
	* @param zygclb the zygclb of this contract
	*/
	@Override
	public void setZygclb(java.lang.String zygclb) {
		_contract.setZygclb(zygclb);
	}

	/**
	* Returns the htmc of this contract.
	*
	* @return the htmc of this contract
	*/
	@Override
	public java.lang.String getHtmc() {
		return _contract.getHtmc();
	}

	/**
	* Sets the htmc of this contract.
	*
	* @param htmc the htmc of this contract
	*/
	@Override
	public void setHtmc(java.lang.String htmc) {
		_contract.setHtmc(htmc);
	}

	/**
	* Returns the fbdw of this contract.
	*
	* @return the fbdw of this contract
	*/
	@Override
	public java.lang.String getFbdw() {
		return _contract.getFbdw();
	}

	/**
	* Sets the fbdw of this contract.
	*
	* @param fbdw the fbdw of this contract
	*/
	@Override
	public void setFbdw(java.lang.String fbdw) {
		_contract.setFbdw(fbdw);
	}

	/**
	* Returns the cbdw of this contract.
	*
	* @return the cbdw of this contract
	*/
	@Override
	public java.lang.String getCbdw() {
		return _contract.getCbdw();
	}

	/**
	* Sets the cbdw of this contract.
	*
	* @param cbdw the cbdw of this contract
	*/
	@Override
	public void setCbdw(java.lang.String cbdw) {
		_contract.setCbdw(cbdw);
	}

	/**
	* Returns the sjdw of this contract.
	*
	* @return the sjdw of this contract
	*/
	@Override
	public java.lang.String getSjdw() {
		return _contract.getSjdw();
	}

	/**
	* Sets the sjdw of this contract.
	*
	* @param sjdw the sjdw of this contract
	*/
	@Override
	public void setSjdw(java.lang.String sjdw) {
		_contract.setSjdw(sjdw);
	}

	/**
	* Returns the xmfzr of this contract.
	*
	* @return the xmfzr of this contract
	*/
	@Override
	public java.lang.String getXmfzr() {
		return _contract.getXmfzr();
	}

	/**
	* Sets the xmfzr of this contract.
	*
	* @param xmfzr the xmfzr of this contract
	*/
	@Override
	public void setXmfzr(java.lang.String xmfzr) {
		_contract.setXmfzr(xmfzr);
	}

	/**
	* Returns the xmfzrzjlx of this contract.
	*
	* @return the xmfzrzjlx of this contract
	*/
	@Override
	public java.lang.String getXmfzrzjlx() {
		return _contract.getXmfzrzjlx();
	}

	/**
	* Sets the xmfzrzjlx of this contract.
	*
	* @param xmfzrzjlx the xmfzrzjlx of this contract
	*/
	@Override
	public void setXmfzrzjlx(java.lang.String xmfzrzjlx) {
		_contract.setXmfzrzjlx(xmfzrzjlx);
	}

	/**
	* Returns the xmfzrzjh of this contract.
	*
	* @return the xmfzrzjh of this contract
	*/
	@Override
	public java.lang.String getXmfzrzjh() {
		return _contract.getXmfzrzjh();
	}

	/**
	* Sets the xmfzrzjh of this contract.
	*
	* @param xmfzrzjh the xmfzrzjh of this contract
	*/
	@Override
	public void setXmfzrzjh(java.lang.String xmfzrzjh) {
		_contract.setXmfzrzjh(xmfzrzjh);
	}

	/**
	* Returns the sjfzr of this contract.
	*
	* @return the sjfzr of this contract
	*/
	@Override
	public java.lang.String getSjfzr() {
		return _contract.getSjfzr();
	}

	/**
	* Sets the sjfzr of this contract.
	*
	* @param sjfzr the sjfzr of this contract
	*/
	@Override
	public void setSjfzr(java.lang.String sjfzr) {
		_contract.setSjfzr(sjfzr);
	}

	/**
	* Returns the sjfzrzjlx of this contract.
	*
	* @return the sjfzrzjlx of this contract
	*/
	@Override
	public java.lang.String getSjfzrzjlx() {
		return _contract.getSjfzrzjlx();
	}

	/**
	* Sets the sjfzrzjlx of this contract.
	*
	* @param sjfzrzjlx the sjfzrzjlx of this contract
	*/
	@Override
	public void setSjfzrzjlx(java.lang.String sjfzrzjlx) {
		_contract.setSjfzrzjlx(sjfzrzjlx);
	}

	/**
	* Returns the sjfzrzjh of this contract.
	*
	* @return the sjfzrzjh of this contract
	*/
	@Override
	public java.lang.String getSjfzrzjh() {
		return _contract.getSjfzrzjh();
	}

	/**
	* Sets the sjfzrzjh of this contract.
	*
	* @param sjfzrzjh the sjfzrzjh of this contract
	*/
	@Override
	public void setSjfzrzjh(java.lang.String sjfzrzjh) {
		_contract.setSjfzrzjh(sjfzrzjh);
	}

	/**
	* Returns the kcdw of this contract.
	*
	* @return the kcdw of this contract
	*/
	@Override
	public java.lang.String getKcdw() {
		return _contract.getKcdw();
	}

	/**
	* Sets the kcdw of this contract.
	*
	* @param kcdw the kcdw of this contract
	*/
	@Override
	public void setKcdw(java.lang.String kcdw) {
		_contract.setKcdw(kcdw);
	}

	/**
	* Returns the kcfzr of this contract.
	*
	* @return the kcfzr of this contract
	*/
	@Override
	public java.lang.String getKcfzr() {
		return _contract.getKcfzr();
	}

	/**
	* Sets the kcfzr of this contract.
	*
	* @param kcfzr the kcfzr of this contract
	*/
	@Override
	public void setKcfzr(java.lang.String kcfzr) {
		_contract.setKcfzr(kcfzr);
	}

	/**
	* Returns the kcfzrzjlx of this contract.
	*
	* @return the kcfzrzjlx of this contract
	*/
	@Override
	public java.lang.String getKcfzrzjlx() {
		return _contract.getKcfzrzjlx();
	}

	/**
	* Sets the kcfzrzjlx of this contract.
	*
	* @param kcfzrzjlx the kcfzrzjlx of this contract
	*/
	@Override
	public void setKcfzrzjlx(java.lang.String kcfzrzjlx) {
		_contract.setKcfzrzjlx(kcfzrzjlx);
	}

	/**
	* Returns the kcfzrzjh of this contract.
	*
	* @return the kcfzrzjh of this contract
	*/
	@Override
	public java.lang.String getKcfzrzjh() {
		return _contract.getKcfzrzjh();
	}

	/**
	* Sets the kcfzrzjh of this contract.
	*
	* @param kcfzrzjh the kcfzrzjh of this contract
	*/
	@Override
	public void setKcfzrzjh(java.lang.String kcfzrzjh) {
		_contract.setKcfzrzjh(kcfzrzjh);
	}

	/**
	* Returns the sgdw of this contract.
	*
	* @return the sgdw of this contract
	*/
	@Override
	public java.lang.String getSgdw() {
		return _contract.getSgdw();
	}

	/**
	* Sets the sgdw of this contract.
	*
	* @param sgdw the sgdw of this contract
	*/
	@Override
	public void setSgdw(java.lang.String sgdw) {
		_contract.setSgdw(sgdw);
	}

	/**
	* Returns the sgfzr of this contract.
	*
	* @return the sgfzr of this contract
	*/
	@Override
	public java.lang.String getSgfzr() {
		return _contract.getSgfzr();
	}

	/**
	* Sets the sgfzr of this contract.
	*
	* @param sgfzr the sgfzr of this contract
	*/
	@Override
	public void setSgfzr(java.lang.String sgfzr) {
		_contract.setSgfzr(sgfzr);
	}

	/**
	* Returns the sgfzrzjlx of this contract.
	*
	* @return the sgfzrzjlx of this contract
	*/
	@Override
	public java.lang.String getSgfzrzjlx() {
		return _contract.getSgfzrzjlx();
	}

	/**
	* Sets the sgfzrzjlx of this contract.
	*
	* @param sgfzrzjlx the sgfzrzjlx of this contract
	*/
	@Override
	public void setSgfzrzjlx(java.lang.String sgfzrzjlx) {
		_contract.setSgfzrzjlx(sgfzrzjlx);
	}

	/**
	* Returns the sgfzrzjh of this contract.
	*
	* @return the sgfzrzjh of this contract
	*/
	@Override
	public java.lang.String getSgfzrzjh() {
		return _contract.getSgfzrzjh();
	}

	/**
	* Sets the sgfzrzjh of this contract.
	*
	* @param sgfzrzjh the sgfzrzjh of this contract
	*/
	@Override
	public void setSgfzrzjh(java.lang.String sgfzrzjh) {
		_contract.setSgfzrzjh(sgfzrzjh);
	}

	/**
	* Returns the xmlb of this contract.
	*
	* @return the xmlb of this contract
	*/
	@Override
	public java.lang.String getXmlb() {
		return _contract.getXmlb();
	}

	/**
	* Sets the xmlb of this contract.
	*
	* @param xmlb the xmlb of this contract
	*/
	@Override
	public void setXmlb(java.lang.String xmlb) {
		_contract.setXmlb(xmlb);
	}

	/**
	* Returns the gclb of this contract.
	*
	* @return the gclb of this contract
	*/
	@Override
	public java.lang.String getGclb() {
		return _contract.getGclb();
	}

	/**
	* Sets the gclb of this contract.
	*
	* @param gclb the gclb of this contract
	*/
	@Override
	public void setGclb(java.lang.String gclb) {
		_contract.setGclb(gclb);
	}

	/**
	* Returns the gcgm of this contract.
	*
	* @return the gcgm of this contract
	*/
	@Override
	public java.lang.String getGcgm() {
		return _contract.getGcgm();
	}

	/**
	* Sets the gcgm of this contract.
	*
	* @param gcgm the gcgm of this contract
	*/
	@Override
	public void setGcgm(java.lang.String gcgm) {
		_contract.setGcgm(gcgm);
	}

	/**
	* Returns the sjxmlb of this contract.
	*
	* @return the sjxmlb of this contract
	*/
	@Override
	public java.lang.String getSjxmlb() {
		return _contract.getSjxmlb();
	}

	/**
	* Sets the sjxmlb of this contract.
	*
	* @param sjxmlb the sjxmlb of this contract
	*/
	@Override
	public void setSjxmlb(java.lang.String sjxmlb) {
		_contract.setSjxmlb(sjxmlb);
	}

	/**
	* Returns the sjgclb of this contract.
	*
	* @return the sjgclb of this contract
	*/
	@Override
	public java.lang.String getSjgclb() {
		return _contract.getSjgclb();
	}

	/**
	* Sets the sjgclb of this contract.
	*
	* @param sjgclb the sjgclb of this contract
	*/
	@Override
	public void setSjgclb(java.lang.String sjgclb) {
		_contract.setSjgclb(sjgclb);
	}

	/**
	* Returns the sjgcgm of this contract.
	*
	* @return the sjgcgm of this contract
	*/
	@Override
	public java.lang.String getSjgcgm() {
		return _contract.getSjgcgm();
	}

	/**
	* Sets the sjgcgm of this contract.
	*
	* @param sjgcgm the sjgcgm of this contract
	*/
	@Override
	public void setSjgcgm(java.lang.String sjgcgm) {
		_contract.setSjgcgm(sjgcgm);
	}

	/**
	* Returns the sgxmlb of this contract.
	*
	* @return the sgxmlb of this contract
	*/
	@Override
	public java.lang.String getSgxmlb() {
		return _contract.getSgxmlb();
	}

	/**
	* Sets the sgxmlb of this contract.
	*
	* @param sgxmlb the sgxmlb of this contract
	*/
	@Override
	public void setSgxmlb(java.lang.String sgxmlb) {
		_contract.setSgxmlb(sgxmlb);
	}

	/**
	* Returns the sggclb of this contract.
	*
	* @return the sggclb of this contract
	*/
	@Override
	public java.lang.String getSggclb() {
		return _contract.getSggclb();
	}

	/**
	* Sets the sggclb of this contract.
	*
	* @param sggclb the sggclb of this contract
	*/
	@Override
	public void setSggclb(java.lang.String sggclb) {
		_contract.setSggclb(sggclb);
	}

	/**
	* Returns the sggcgm of this contract.
	*
	* @return the sggcgm of this contract
	*/
	@Override
	public java.lang.String getSggcgm() {
		return _contract.getSggcgm();
	}

	/**
	* Sets the sggcgm of this contract.
	*
	* @param sggcgm the sggcgm of this contract
	*/
	@Override
	public void setSggcgm(java.lang.String sggcgm) {
		_contract.setSggcgm(sggcgm);
	}

	/**
	* Returns the kgrq of this contract.
	*
	* @return the kgrq of this contract
	*/
	@Override
	public java.util.Date getKgrq() {
		return _contract.getKgrq();
	}

	/**
	* Sets the kgrq of this contract.
	*
	* @param kgrq the kgrq of this contract
	*/
	@Override
	public void setKgrq(java.util.Date kgrq) {
		_contract.setKgrq(kgrq);
	}

	/**
	* Returns the jgrq of this contract.
	*
	* @return the jgrq of this contract
	*/
	@Override
	public java.util.Date getJgrq() {
		return _contract.getJgrq();
	}

	/**
	* Sets the jgrq of this contract.
	*
	* @param jgrq the jgrq of this contract
	*/
	@Override
	public void setJgrq(java.util.Date jgrq) {
		_contract.setJgrq(jgrq);
	}

	/**
	* Returns the jsfs of this contract.
	*
	* @return the jsfs of this contract
	*/
	@Override
	public java.lang.String getJsfs() {
		return _contract.getJsfs();
	}

	/**
	* Sets the jsfs of this contract.
	*
	* @param jsfs the jsfs of this contract
	*/
	@Override
	public void setJsfs(java.lang.String jsfs) {
		_contract.setJsfs(jsfs);
	}

	/**
	* Returns the htj of this contract.
	*
	* @return the htj of this contract
	*/
	@Override
	public java.lang.String getHtj() {
		return _contract.getHtj();
	}

	/**
	* Sets the htj of this contract.
	*
	* @param htj the htj of this contract
	*/
	@Override
	public void setHtj(java.lang.String htj) {
		_contract.setHtj(htj);
	}

	/**
	* Returns the sjf of this contract.
	*
	* @return the sjf of this contract
	*/
	@Override
	public java.lang.String getSjf() {
		return _contract.getSjf();
	}

	/**
	* Sets the sjf of this contract.
	*
	* @param sjf the sjf of this contract
	*/
	@Override
	public void setSjf(java.lang.String sjf) {
		_contract.setSjf(sjf);
	}

	/**
	* Returns the kcf of this contract.
	*
	* @return the kcf of this contract
	*/
	@Override
	public java.lang.String getKcf() {
		return _contract.getKcf();
	}

	/**
	* Sets the kcf of this contract.
	*
	* @param kcf the kcf of this contract
	*/
	@Override
	public void setKcf(java.lang.String kcf) {
		_contract.setKcf(kcf);
	}

	/**
	* Returns the jazj of this contract.
	*
	* @return the jazj of this contract
	*/
	@Override
	public java.lang.String getJazj() {
		return _contract.getJazj();
	}

	/**
	* Sets the jazj of this contract.
	*
	* @param jazj the jazj of this contract
	*/
	@Override
	public void setJazj(java.lang.String jazj) {
		_contract.setJazj(jazj);
	}

	/**
	* Returns the zlje of this contract.
	*
	* @return the zlje of this contract
	*/
	@Override
	public java.lang.String getZlje() {
		return _contract.getZlje();
	}

	/**
	* Sets the zlje of this contract.
	*
	* @param zlje the zlje of this contract
	*/
	@Override
	public void setZlje(java.lang.String zlje) {
		_contract.setZlje(zlje);
	}

	/**
	* Returns the zgj of this contract.
	*
	* @return the zgj of this contract
	*/
	@Override
	public java.lang.String getZgj() {
		return _contract.getZgj();
	}

	/**
	* Sets the zgj of this contract.
	*
	* @param zgj the zgj of this contract
	*/
	@Override
	public void setZgj(java.lang.String zgj) {
		_contract.setZgj(zgj);
	}

	/**
	* Returns the wmcsf of this contract.
	*
	* @return the wmcsf of this contract
	*/
	@Override
	public java.lang.String getWmcsf() {
		return _contract.getWmcsf();
	}

	/**
	* Sets the wmcsf of this contract.
	*
	* @param wmcsf the wmcsf of this contract
	*/
	@Override
	public void setWmcsf(java.lang.String wmcsf) {
		_contract.setWmcsf(wmcsf);
	}

	/**
	* Returns the htqdrq of this contract.
	*
	* @return the htqdrq of this contract
	*/
	@Override
	public java.util.Date getHtqdrq() {
		return _contract.getHtqdrq();
	}

	/**
	* Sets the htqdrq of this contract.
	*
	* @param htqdrq the htqdrq of this contract
	*/
	@Override
	public void setHtqdrq(java.util.Date htqdrq) {
		_contract.setHtqdrq(htqdrq);
	}

	/**
	* Returns the htqzrq of this contract.
	*
	* @return the htqzrq of this contract
	*/
	@Override
	public java.lang.String getHtqzrq() {
		return _contract.getHtqzrq();
	}

	/**
	* Sets the htqzrq of this contract.
	*
	* @param htqzrq the htqzrq of this contract
	*/
	@Override
	public void setHtqzrq(java.lang.String htqzrq) {
		_contract.setHtqzrq(htqzrq);
	}

	/**
	* Returns the cbnr of this contract.
	*
	* @return the cbnr of this contract
	*/
	@Override
	public java.lang.String getCbnr() {
		return _contract.getCbnr();
	}

	/**
	* Sets the cbnr of this contract.
	*
	* @param cbnr the cbnr of this contract
	*/
	@Override
	public void setCbnr(java.lang.String cbnr) {
		_contract.setCbnr(cbnr);
	}

	/**
	* Returns the htsfwbmc of this contract.
	*
	* @return the htsfwbmc of this contract
	*/
	@Override
	public java.lang.String getHtsfwbmc() {
		return _contract.getHtsfwbmc();
	}

	/**
	* Sets the htsfwbmc of this contract.
	*
	* @param htsfwbmc the htsfwbmc of this contract
	*/
	@Override
	public void setHtsfwbmc(java.lang.String htsfwbmc) {
		_contract.setHtsfwbmc(htsfwbmc);
	}

	/**
	* Returns the bz of this contract.
	*
	* @return the bz of this contract
	*/
	@Override
	public java.lang.String getBz() {
		return _contract.getBz();
	}

	/**
	* Sets the bz of this contract.
	*
	* @param bz the bz of this contract
	*/
	@Override
	public void setBz(java.lang.String bz) {
		_contract.setBz(bz);
	}

	/**
	* Returns the sfzx of this contract.
	*
	* @return the sfzx of this contract
	*/
	@Override
	public java.lang.String getSfzx() {
		return _contract.getSfzx();
	}

	/**
	* Sets the sfzx of this contract.
	*
	* @param sfzx the sfzx of this contract
	*/
	@Override
	public void setSfzx(java.lang.String sfzx) {
		_contract.setSfzx(sfzx);
	}

	/**
	* Returns the zxsj of this contract.
	*
	* @return the zxsj of this contract
	*/
	@Override
	public java.util.Date getZxsj() {
		return _contract.getZxsj();
	}

	/**
	* Sets the zxsj of this contract.
	*
	* @param zxsj the zxsj of this contract
	*/
	@Override
	public void setZxsj(java.util.Date zxsj) {
		_contract.setZxsj(zxsj);
	}

	/**
	* Returns the zxsm of this contract.
	*
	* @return the zxsm of this contract
	*/
	@Override
	public java.lang.String getZxsm() {
		return _contract.getZxsm();
	}

	/**
	* Sets the zxsm of this contract.
	*
	* @param zxsm the zxsm of this contract
	*/
	@Override
	public void setZxsm(java.lang.String zxsm) {
		_contract.setZxsm(zxsm);
	}

	@Override
	public boolean isNew() {
		return _contract.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contract.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contract.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contract.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contract.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contract.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contract.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contract.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contract.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contract.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contract.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContractWrapper((Contract)_contract.clone());
	}

	@Override
	public int compareTo(com.justonetech.cp.contract.model.Contract contract) {
		return _contract.compareTo(contract);
	}

	@Override
	public int hashCode() {
		return _contract.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.contract.model.Contract> toCacheModel() {
		return _contract.toCacheModel();
	}

	@Override
	public com.justonetech.cp.contract.model.Contract toEscapedModel() {
		return new ContractWrapper(_contract.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.contract.model.Contract toUnescapedModel() {
		return new ContractWrapper(_contract.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contract.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contract.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contract.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContractWrapper)) {
			return false;
		}

		ContractWrapper contractWrapper = (ContractWrapper)obj;

		if (Validator.equals(_contract, contractWrapper._contract)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Contract getWrappedContract() {
		return _contract;
	}

	@Override
	public Contract getWrappedModel() {
		return _contract;
	}

	@Override
	public void resetOriginalValues() {
		_contract.resetOriginalValues();
	}

	private Contract _contract;
}