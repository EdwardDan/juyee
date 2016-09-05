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

import com.justonetech.cp.contract.service.ClpSerializer;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;

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
public class ContractClp extends BaseModelImpl<Contract> implements Contract {
	public ContractClp() {
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
	public String getPrimaryKey() {
		return _contractId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setContractId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contractId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contractId", getContractId());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("htlb", getHtlb());
		attributes.put("htbh", getHtbh());
		attributes.put("zbhtbh", getZbhtbh());
		attributes.put("fbhtbh", getFbhtbh());
		attributes.put("htlx", getHtlx());
		attributes.put("htzt", getHtzt());
		attributes.put("zfbgx", getZfbgx());
		attributes.put("bsrq", getBsrq());
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
		attributes.put("zjzmj", getZjzmj());
		attributes.put("xmfl", getXmfl());
		attributes.put("jzgm", getJzgm());
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
		attributes.put("kcdwmc", getKcdwmc());
		attributes.put("kcfzr", getKcfzr());
		attributes.put("kcfzrzjlx", getKcfzrzjlx());
		attributes.put("kcfzrzjh", getKcfzrzjh());
		attributes.put("sgdwmc", getSgdwmc());
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
		attributes.put("aqfhwmsgcsf", getAqfhwmsgcsf());
		attributes.put("htqdrq", getHtqdrq());
		attributes.put("htqzrq", getHtqzrq());
		attributes.put("cbnr", getCbnr());
		attributes.put("cyhtsfwb", getCyhtsfwb());
		attributes.put("fzjqtsm", getFzjqtsm());
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

		Long zzjgdm = (Long)attributes.get("zzjgdm");

		if (zzjgdm != null) {
			setZzjgdm(zzjgdm);
		}

		String htlb = (String)attributes.get("htlb");

		if (htlb != null) {
			setHtlb(htlb);
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

		Date bsrq = (Date)attributes.get("bsrq");

		if (bsrq != null) {
			setBsrq(bsrq);
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

		String zjzmj = (String)attributes.get("zjzmj");

		if (zjzmj != null) {
			setZjzmj(zjzmj);
		}

		String xmfl = (String)attributes.get("xmfl");

		if (xmfl != null) {
			setXmfl(xmfl);
		}

		String jzgm = (String)attributes.get("jzgm");

		if (jzgm != null) {
			setJzgm(jzgm);
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

		String kcdwmc = (String)attributes.get("kcdwmc");

		if (kcdwmc != null) {
			setKcdwmc(kcdwmc);
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

		String sgdwmc = (String)attributes.get("sgdwmc");

		if (sgdwmc != null) {
			setSgdwmc(sgdwmc);
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

		String aqfhwmsgcsf = (String)attributes.get("aqfhwmsgcsf");

		if (aqfhwmsgcsf != null) {
			setAqfhwmsgcsf(aqfhwmsgcsf);
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

		String cyhtsfwb = (String)attributes.get("cyhtsfwb");

		if (cyhtsfwb != null) {
			setCyhtsfwb(cyhtsfwb);
		}

		String fzjqtsm = (String)attributes.get("fzjqtsm");

		if (fzjqtsm != null) {
			setFzjqtsm(fzjqtsm);
		}

		String sfzx = (String)attributes.get("sfzx");

		if (sfzx != null) {
			setSfzx(sfzx);
		}

		Date zxsj = (Date)attributes.get("zxsj");

		if (zxsj != null) {
			setZxsj(zxsj);
		}

		Date zxsm = (Date)attributes.get("zxsm");

		if (zxsm != null) {
			setZxsm(zxsm);
		}
	}

	@Override
	public String getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(String contractId) {
		_contractId = contractId;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", String.class);

				method.invoke(_contractRemoteModel, contractId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getZzjgdm() {
		return _zzjgdm;
	}

	@Override
	public void setZzjgdm(long zzjgdm) {
		_zzjgdm = zzjgdm;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZzjgdm", long.class);

				method.invoke(_contractRemoteModel, zzjgdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtlb() {
		return _htlb;
	}

	@Override
	public void setHtlb(String htlb) {
		_htlb = htlb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtlb", String.class);

				method.invoke(_contractRemoteModel, htlb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtbh() {
		return _htbh;
	}

	@Override
	public void setHtbh(String htbh) {
		_htbh = htbh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtbh", String.class);

				method.invoke(_contractRemoteModel, htbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZbhtbh() {
		return _zbhtbh;
	}

	@Override
	public void setZbhtbh(String zbhtbh) {
		_zbhtbh = zbhtbh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZbhtbh", String.class);

				method.invoke(_contractRemoteModel, zbhtbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFbhtbh() {
		return _fbhtbh;
	}

	@Override
	public void setFbhtbh(String fbhtbh) {
		_fbhtbh = fbhtbh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setFbhtbh", String.class);

				method.invoke(_contractRemoteModel, fbhtbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtlx() {
		return _htlx;
	}

	@Override
	public void setHtlx(String htlx) {
		_htlx = htlx;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtlx", String.class);

				method.invoke(_contractRemoteModel, htlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtzt() {
		return _htzt;
	}

	@Override
	public void setHtzt(String htzt) {
		_htzt = htzt;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtzt", String.class);

				method.invoke(_contractRemoteModel, htzt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZfbgx() {
		return _zfbgx;
	}

	@Override
	public void setZfbgx(String zfbgx) {
		_zfbgx = zfbgx;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZfbgx", String.class);

				method.invoke(_contractRemoteModel, zfbgx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBsrq() {
		return _bsrq;
	}

	@Override
	public void setBsrq(Date bsrq) {
		_bsrq = bsrq;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setBsrq", Date.class);

				method.invoke(_contractRemoteModel, bsrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSlsj() {
		return _slsj;
	}

	@Override
	public void setSlsj(Date slsj) {
		_slsj = slsj;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSlsj", Date.class);

				method.invoke(_contractRemoteModel, slsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjbh() {
		return _bjbh;
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_contractRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSzdq() {
		return _szdq;
	}

	@Override
	public void setSzdq(String szdq) {
		_szdq = szdq;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSzdq", String.class);

				method.invoke(_contractRemoteModel, szdq);
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

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setXmmc", String.class);

				method.invoke(_contractRemoteModel, xmmc);
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

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdw", String.class);

				method.invoke(_contractRemoteModel, jsdw);
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

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdd", String.class);

				method.invoke(_contractRemoteModel, jsdd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLxpw() {
		return _lxpw;
	}

	@Override
	public void setLxpw(String lxpw) {
		_lxpw = lxpw;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setLxpw", String.class);

				method.invoke(_contractRemoteModel, lxpw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPzwh() {
		return _pzwh;
	}

	@Override
	public void setPzwh(String pzwh) {
		_pzwh = pzwh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setPzwh", String.class);

				method.invoke(_contractRemoteModel, pzwh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDwxz() {
		return _dwxz;
	}

	@Override
	public void setDwxz(String dwxz) {
		_dwxz = dwxz;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setDwxz", String.class);

				method.invoke(_contractRemoteModel, dwxz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjlygc() {
		return _zjlygc;
	}

	@Override
	public void setZjlygc(String zjlygc) {
		_zjlygc = zjlygc;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZjlygc", String.class);

				method.invoke(_contractRemoteModel, zjlygc);
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

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZtz", String.class);

				method.invoke(_contractRemoteModel, ztz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZjzmj() {
		return _zjzmj;
	}

	@Override
	public void setZjzmj(String zjzmj) {
		_zjzmj = zjzmj;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZjzmj", String.class);

				method.invoke(_contractRemoteModel, zjzmj);
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

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfl", String.class);

				method.invoke(_contractRemoteModel, xmfl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJzgm() {
		return _jzgm;
	}

	@Override
	public void setJzgm(String jzgm) {
		_jzgm = jzgm;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setJzgm", String.class);

				method.invoke(_contractRemoteModel, jzgm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBdh() {
		return _bdh;
	}

	@Override
	public void setBdh(String bdh) {
		_bdh = bdh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setBdh", String.class);

				method.invoke(_contractRemoteModel, bdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFbfs() {
		return _fbfs;
	}

	@Override
	public void setFbfs(String fbfs) {
		_fbfs = fbfs;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setFbfs", String.class);

				method.invoke(_contractRemoteModel, fbfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCbfs() {
		return _cbfs;
	}

	@Override
	public void setCbfs(String cbfs) {
		_cbfs = cbfs;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setCbfs", String.class);

				method.invoke(_contractRemoteModel, cbfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZycbht() {
		return _zycbht;
	}

	@Override
	public void setZycbht(String zycbht) {
		_zycbht = zycbht;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZycbht", String.class);

				method.invoke(_contractRemoteModel, zycbht);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZygclb() {
		return _zygclb;
	}

	@Override
	public void setZygclb(String zygclb) {
		_zygclb = zygclb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZygclb", String.class);

				method.invoke(_contractRemoteModel, zygclb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtmc() {
		return _htmc;
	}

	@Override
	public void setHtmc(String htmc) {
		_htmc = htmc;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmc", String.class);

				method.invoke(_contractRemoteModel, htmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFbdw() {
		return _fbdw;
	}

	@Override
	public void setFbdw(String fbdw) {
		_fbdw = fbdw;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setFbdw", String.class);

				method.invoke(_contractRemoteModel, fbdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCbdw() {
		return _cbdw;
	}

	@Override
	public void setCbdw(String cbdw) {
		_cbdw = cbdw;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setCbdw", String.class);

				method.invoke(_contractRemoteModel, cbdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjdw() {
		return _sjdw;
	}

	@Override
	public void setSjdw(String sjdw) {
		_sjdw = sjdw;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjdw", String.class);

				method.invoke(_contractRemoteModel, sjdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmfzr() {
		return _xmfzr;
	}

	@Override
	public void setXmfzr(String xmfzr) {
		_xmfzr = xmfzr;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfzr", String.class);

				method.invoke(_contractRemoteModel, xmfzr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmfzrzjlx() {
		return _xmfzrzjlx;
	}

	@Override
	public void setXmfzrzjlx(String xmfzrzjlx) {
		_xmfzrzjlx = xmfzrzjlx;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfzrzjlx", String.class);

				method.invoke(_contractRemoteModel, xmfzrzjlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmfzrzjh() {
		return _xmfzrzjh;
	}

	@Override
	public void setXmfzrzjh(String xmfzrzjh) {
		_xmfzrzjh = xmfzrzjh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfzrzjh", String.class);

				method.invoke(_contractRemoteModel, xmfzrzjh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjfzr() {
		return _sjfzr;
	}

	@Override
	public void setSjfzr(String sjfzr) {
		_sjfzr = sjfzr;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjfzr", String.class);

				method.invoke(_contractRemoteModel, sjfzr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjfzrzjlx() {
		return _sjfzrzjlx;
	}

	@Override
	public void setSjfzrzjlx(String sjfzrzjlx) {
		_sjfzrzjlx = sjfzrzjlx;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjfzrzjlx", String.class);

				method.invoke(_contractRemoteModel, sjfzrzjlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjfzrzjh() {
		return _sjfzrzjh;
	}

	@Override
	public void setSjfzrzjh(String sjfzrzjh) {
		_sjfzrzjh = sjfzrzjh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjfzrzjh", String.class);

				method.invoke(_contractRemoteModel, sjfzrzjh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKcdwmc() {
		return _kcdwmc;
	}

	@Override
	public void setKcdwmc(String kcdwmc) {
		_kcdwmc = kcdwmc;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setKcdwmc", String.class);

				method.invoke(_contractRemoteModel, kcdwmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKcfzr() {
		return _kcfzr;
	}

	@Override
	public void setKcfzr(String kcfzr) {
		_kcfzr = kcfzr;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setKcfzr", String.class);

				method.invoke(_contractRemoteModel, kcfzr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKcfzrzjlx() {
		return _kcfzrzjlx;
	}

	@Override
	public void setKcfzrzjlx(String kcfzrzjlx) {
		_kcfzrzjlx = kcfzrzjlx;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setKcfzrzjlx", String.class);

				method.invoke(_contractRemoteModel, kcfzrzjlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKcfzrzjh() {
		return _kcfzrzjh;
	}

	@Override
	public void setKcfzrzjh(String kcfzrzjh) {
		_kcfzrzjh = kcfzrzjh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setKcfzrzjh", String.class);

				method.invoke(_contractRemoteModel, kcfzrzjh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgdwmc() {
		return _sgdwmc;
	}

	@Override
	public void setSgdwmc(String sgdwmc) {
		_sgdwmc = sgdwmc;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSgdwmc", String.class);

				method.invoke(_contractRemoteModel, sgdwmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgfzr() {
		return _sgfzr;
	}

	@Override
	public void setSgfzr(String sgfzr) {
		_sgfzr = sgfzr;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSgfzr", String.class);

				method.invoke(_contractRemoteModel, sgfzr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgfzrzjlx() {
		return _sgfzrzjlx;
	}

	@Override
	public void setSgfzrzjlx(String sgfzrzjlx) {
		_sgfzrzjlx = sgfzrzjlx;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSgfzrzjlx", String.class);

				method.invoke(_contractRemoteModel, sgfzrzjlx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgfzrzjh() {
		return _sgfzrzjh;
	}

	@Override
	public void setSgfzrzjh(String sgfzrzjh) {
		_sgfzrzjh = sgfzrzjh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSgfzrzjh", String.class);

				method.invoke(_contractRemoteModel, sgfzrzjh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmlb() {
		return _xmlb;
	}

	@Override
	public void setXmlb(String xmlb) {
		_xmlb = xmlb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setXmlb", String.class);

				method.invoke(_contractRemoteModel, xmlb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGclb() {
		return _gclb;
	}

	@Override
	public void setGclb(String gclb) {
		_gclb = gclb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setGclb", String.class);

				method.invoke(_contractRemoteModel, gclb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGcgm() {
		return _gcgm;
	}

	@Override
	public void setGcgm(String gcgm) {
		_gcgm = gcgm;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setGcgm", String.class);

				method.invoke(_contractRemoteModel, gcgm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjxmlb() {
		return _sjxmlb;
	}

	@Override
	public void setSjxmlb(String sjxmlb) {
		_sjxmlb = sjxmlb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjxmlb", String.class);

				method.invoke(_contractRemoteModel, sjxmlb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjgclb() {
		return _sjgclb;
	}

	@Override
	public void setSjgclb(String sjgclb) {
		_sjgclb = sjgclb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjgclb", String.class);

				method.invoke(_contractRemoteModel, sjgclb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjgcgm() {
		return _sjgcgm;
	}

	@Override
	public void setSjgcgm(String sjgcgm) {
		_sjgcgm = sjgcgm;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjgcgm", String.class);

				method.invoke(_contractRemoteModel, sjgcgm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgxmlb() {
		return _sgxmlb;
	}

	@Override
	public void setSgxmlb(String sgxmlb) {
		_sgxmlb = sgxmlb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSgxmlb", String.class);

				method.invoke(_contractRemoteModel, sgxmlb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSggclb() {
		return _sggclb;
	}

	@Override
	public void setSggclb(String sggclb) {
		_sggclb = sggclb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSggclb", String.class);

				method.invoke(_contractRemoteModel, sggclb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSggcgm() {
		return _sggcgm;
	}

	@Override
	public void setSggcgm(String sggcgm) {
		_sggcgm = sggcgm;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSggcgm", String.class);

				method.invoke(_contractRemoteModel, sggcgm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getKgrq() {
		return _kgrq;
	}

	@Override
	public void setKgrq(Date kgrq) {
		_kgrq = kgrq;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setKgrq", Date.class);

				method.invoke(_contractRemoteModel, kgrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJgrq() {
		return _jgrq;
	}

	@Override
	public void setJgrq(Date jgrq) {
		_jgrq = jgrq;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setJgrq", Date.class);

				method.invoke(_contractRemoteModel, jgrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsfs() {
		return _jsfs;
	}

	@Override
	public void setJsfs(String jsfs) {
		_jsfs = jsfs;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setJsfs", String.class);

				method.invoke(_contractRemoteModel, jsfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtj() {
		return _htj;
	}

	@Override
	public void setHtj(String htj) {
		_htj = htj;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtj", String.class);

				method.invoke(_contractRemoteModel, htj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjf() {
		return _sjf;
	}

	@Override
	public void setSjf(String sjf) {
		_sjf = sjf;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSjf", String.class);

				method.invoke(_contractRemoteModel, sjf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKcf() {
		return _kcf;
	}

	@Override
	public void setKcf(String kcf) {
		_kcf = kcf;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setKcf", String.class);

				method.invoke(_contractRemoteModel, kcf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJazj() {
		return _jazj;
	}

	@Override
	public void setJazj(String jazj) {
		_jazj = jazj;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setJazj", String.class);

				method.invoke(_contractRemoteModel, jazj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZlje() {
		return _zlje;
	}

	@Override
	public void setZlje(String zlje) {
		_zlje = zlje;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZlje", String.class);

				method.invoke(_contractRemoteModel, zlje);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZgj() {
		return _zgj;
	}

	@Override
	public void setZgj(String zgj) {
		_zgj = zgj;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZgj", String.class);

				method.invoke(_contractRemoteModel, zgj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAqfhwmsgcsf() {
		return _aqfhwmsgcsf;
	}

	@Override
	public void setAqfhwmsgcsf(String aqfhwmsgcsf) {
		_aqfhwmsgcsf = aqfhwmsgcsf;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setAqfhwmsgcsf", String.class);

				method.invoke(_contractRemoteModel, aqfhwmsgcsf);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getHtqdrq() {
		return _htqdrq;
	}

	@Override
	public void setHtqdrq(Date htqdrq) {
		_htqdrq = htqdrq;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtqdrq", Date.class);

				method.invoke(_contractRemoteModel, htqdrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtqzrq() {
		return _htqzrq;
	}

	@Override
	public void setHtqzrq(String htqzrq) {
		_htqzrq = htqzrq;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtqzrq", String.class);

				method.invoke(_contractRemoteModel, htqzrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCbnr() {
		return _cbnr;
	}

	@Override
	public void setCbnr(String cbnr) {
		_cbnr = cbnr;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setCbnr", String.class);

				method.invoke(_contractRemoteModel, cbnr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCyhtsfwb() {
		return _cyhtsfwb;
	}

	@Override
	public void setCyhtsfwb(String cyhtsfwb) {
		_cyhtsfwb = cyhtsfwb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setCyhtsfwb", String.class);

				method.invoke(_contractRemoteModel, cyhtsfwb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFzjqtsm() {
		return _fzjqtsm;
	}

	@Override
	public void setFzjqtsm(String fzjqtsm) {
		_fzjqtsm = fzjqtsm;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setFzjqtsm", String.class);

				method.invoke(_contractRemoteModel, fzjqtsm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSfzx() {
		return _sfzx;
	}

	@Override
	public void setSfzx(String sfzx) {
		_sfzx = sfzx;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setSfzx", String.class);

				method.invoke(_contractRemoteModel, sfzx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getZxsj() {
		return _zxsj;
	}

	@Override
	public void setZxsj(Date zxsj) {
		_zxsj = zxsj;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZxsj", Date.class);

				method.invoke(_contractRemoteModel, zxsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getZxsm() {
		return _zxsm;
	}

	@Override
	public void setZxsm(Date zxsm) {
		_zxsm = zxsm;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setZxsm", Date.class);

				method.invoke(_contractRemoteModel, zxsm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContractRemoteModel() {
		return _contractRemoteModel;
	}

	public void setContractRemoteModel(BaseModel<?> contractRemoteModel) {
		_contractRemoteModel = contractRemoteModel;
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

		Class<?> remoteModelClass = _contractRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contractRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContractLocalServiceUtil.addContract(this);
		}
		else {
			ContractLocalServiceUtil.updateContract(this);
		}
	}

	@Override
	public Contract toEscapedModel() {
		return (Contract)ProxyUtil.newProxyInstance(Contract.class.getClassLoader(),
			new Class[] { Contract.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContractClp clone = new ContractClp();

		clone.setContractId(getContractId());
		clone.setZzjgdm(getZzjgdm());
		clone.setHtlb(getHtlb());
		clone.setHtbh(getHtbh());
		clone.setZbhtbh(getZbhtbh());
		clone.setFbhtbh(getFbhtbh());
		clone.setHtlx(getHtlx());
		clone.setHtzt(getHtzt());
		clone.setZfbgx(getZfbgx());
		clone.setBsrq(getBsrq());
		clone.setSlsj(getSlsj());
		clone.setBjbh(getBjbh());
		clone.setSzdq(getSzdq());
		clone.setXmmc(getXmmc());
		clone.setJsdw(getJsdw());
		clone.setJsdd(getJsdd());
		clone.setLxpw(getLxpw());
		clone.setPzwh(getPzwh());
		clone.setDwxz(getDwxz());
		clone.setZjlygc(getZjlygc());
		clone.setZtz(getZtz());
		clone.setZjzmj(getZjzmj());
		clone.setXmfl(getXmfl());
		clone.setJzgm(getJzgm());
		clone.setBdh(getBdh());
		clone.setFbfs(getFbfs());
		clone.setCbfs(getCbfs());
		clone.setZycbht(getZycbht());
		clone.setZygclb(getZygclb());
		clone.setHtmc(getHtmc());
		clone.setFbdw(getFbdw());
		clone.setCbdw(getCbdw());
		clone.setSjdw(getSjdw());
		clone.setXmfzr(getXmfzr());
		clone.setXmfzrzjlx(getXmfzrzjlx());
		clone.setXmfzrzjh(getXmfzrzjh());
		clone.setSjfzr(getSjfzr());
		clone.setSjfzrzjlx(getSjfzrzjlx());
		clone.setSjfzrzjh(getSjfzrzjh());
		clone.setKcdwmc(getKcdwmc());
		clone.setKcfzr(getKcfzr());
		clone.setKcfzrzjlx(getKcfzrzjlx());
		clone.setKcfzrzjh(getKcfzrzjh());
		clone.setSgdwmc(getSgdwmc());
		clone.setSgfzr(getSgfzr());
		clone.setSgfzrzjlx(getSgfzrzjlx());
		clone.setSgfzrzjh(getSgfzrzjh());
		clone.setXmlb(getXmlb());
		clone.setGclb(getGclb());
		clone.setGcgm(getGcgm());
		clone.setSjxmlb(getSjxmlb());
		clone.setSjgclb(getSjgclb());
		clone.setSjgcgm(getSjgcgm());
		clone.setSgxmlb(getSgxmlb());
		clone.setSggclb(getSggclb());
		clone.setSggcgm(getSggcgm());
		clone.setKgrq(getKgrq());
		clone.setJgrq(getJgrq());
		clone.setJsfs(getJsfs());
		clone.setHtj(getHtj());
		clone.setSjf(getSjf());
		clone.setKcf(getKcf());
		clone.setJazj(getJazj());
		clone.setZlje(getZlje());
		clone.setZgj(getZgj());
		clone.setAqfhwmsgcsf(getAqfhwmsgcsf());
		clone.setHtqdrq(getHtqdrq());
		clone.setHtqzrq(getHtqzrq());
		clone.setCbnr(getCbnr());
		clone.setCyhtsfwb(getCyhtsfwb());
		clone.setFzjqtsm(getFzjqtsm());
		clone.setSfzx(getSfzx());
		clone.setZxsj(getZxsj());
		clone.setZxsm(getZxsm());

		return clone;
	}

	@Override
	public int compareTo(Contract contract) {
		int value = 0;

		value = DateUtil.compareTo(getBsrq(), contract.getBsrq());

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

		if (!(obj instanceof ContractClp)) {
			return false;
		}

		ContractClp contract = (ContractClp)obj;

		String primaryKey = contract.getPrimaryKey();

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
		StringBundler sb = new StringBundler(149);

		sb.append("{contractId=");
		sb.append(getContractId());
		sb.append(", zzjgdm=");
		sb.append(getZzjgdm());
		sb.append(", htlb=");
		sb.append(getHtlb());
		sb.append(", htbh=");
		sb.append(getHtbh());
		sb.append(", zbhtbh=");
		sb.append(getZbhtbh());
		sb.append(", fbhtbh=");
		sb.append(getFbhtbh());
		sb.append(", htlx=");
		sb.append(getHtlx());
		sb.append(", htzt=");
		sb.append(getHtzt());
		sb.append(", zfbgx=");
		sb.append(getZfbgx());
		sb.append(", bsrq=");
		sb.append(getBsrq());
		sb.append(", slsj=");
		sb.append(getSlsj());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", szdq=");
		sb.append(getSzdq());
		sb.append(", xmmc=");
		sb.append(getXmmc());
		sb.append(", jsdw=");
		sb.append(getJsdw());
		sb.append(", jsdd=");
		sb.append(getJsdd());
		sb.append(", lxpw=");
		sb.append(getLxpw());
		sb.append(", pzwh=");
		sb.append(getPzwh());
		sb.append(", dwxz=");
		sb.append(getDwxz());
		sb.append(", zjlygc=");
		sb.append(getZjlygc());
		sb.append(", ztz=");
		sb.append(getZtz());
		sb.append(", zjzmj=");
		sb.append(getZjzmj());
		sb.append(", xmfl=");
		sb.append(getXmfl());
		sb.append(", jzgm=");
		sb.append(getJzgm());
		sb.append(", bdh=");
		sb.append(getBdh());
		sb.append(", fbfs=");
		sb.append(getFbfs());
		sb.append(", cbfs=");
		sb.append(getCbfs());
		sb.append(", zycbht=");
		sb.append(getZycbht());
		sb.append(", zygclb=");
		sb.append(getZygclb());
		sb.append(", htmc=");
		sb.append(getHtmc());
		sb.append(", fbdw=");
		sb.append(getFbdw());
		sb.append(", cbdw=");
		sb.append(getCbdw());
		sb.append(", sjdw=");
		sb.append(getSjdw());
		sb.append(", xmfzr=");
		sb.append(getXmfzr());
		sb.append(", xmfzrzjlx=");
		sb.append(getXmfzrzjlx());
		sb.append(", xmfzrzjh=");
		sb.append(getXmfzrzjh());
		sb.append(", sjfzr=");
		sb.append(getSjfzr());
		sb.append(", sjfzrzjlx=");
		sb.append(getSjfzrzjlx());
		sb.append(", sjfzrzjh=");
		sb.append(getSjfzrzjh());
		sb.append(", kcdwmc=");
		sb.append(getKcdwmc());
		sb.append(", kcfzr=");
		sb.append(getKcfzr());
		sb.append(", kcfzrzjlx=");
		sb.append(getKcfzrzjlx());
		sb.append(", kcfzrzjh=");
		sb.append(getKcfzrzjh());
		sb.append(", sgdwmc=");
		sb.append(getSgdwmc());
		sb.append(", sgfzr=");
		sb.append(getSgfzr());
		sb.append(", sgfzrzjlx=");
		sb.append(getSgfzrzjlx());
		sb.append(", sgfzrzjh=");
		sb.append(getSgfzrzjh());
		sb.append(", xmlb=");
		sb.append(getXmlb());
		sb.append(", gclb=");
		sb.append(getGclb());
		sb.append(", gcgm=");
		sb.append(getGcgm());
		sb.append(", sjxmlb=");
		sb.append(getSjxmlb());
		sb.append(", sjgclb=");
		sb.append(getSjgclb());
		sb.append(", sjgcgm=");
		sb.append(getSjgcgm());
		sb.append(", sgxmlb=");
		sb.append(getSgxmlb());
		sb.append(", sggclb=");
		sb.append(getSggclb());
		sb.append(", sggcgm=");
		sb.append(getSggcgm());
		sb.append(", kgrq=");
		sb.append(getKgrq());
		sb.append(", jgrq=");
		sb.append(getJgrq());
		sb.append(", jsfs=");
		sb.append(getJsfs());
		sb.append(", htj=");
		sb.append(getHtj());
		sb.append(", sjf=");
		sb.append(getSjf());
		sb.append(", kcf=");
		sb.append(getKcf());
		sb.append(", jazj=");
		sb.append(getJazj());
		sb.append(", zlje=");
		sb.append(getZlje());
		sb.append(", zgj=");
		sb.append(getZgj());
		sb.append(", aqfhwmsgcsf=");
		sb.append(getAqfhwmsgcsf());
		sb.append(", htqdrq=");
		sb.append(getHtqdrq());
		sb.append(", htqzrq=");
		sb.append(getHtqzrq());
		sb.append(", cbnr=");
		sb.append(getCbnr());
		sb.append(", cyhtsfwb=");
		sb.append(getCyhtsfwb());
		sb.append(", fzjqtsm=");
		sb.append(getFzjqtsm());
		sb.append(", sfzx=");
		sb.append(getSfzx());
		sb.append(", zxsj=");
		sb.append(getZxsj());
		sb.append(", zxsm=");
		sb.append(getZxsm());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(226);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.contract.model.Contract");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zzjgdm</column-name><column-value><![CDATA[");
		sb.append(getZzjgdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htlb</column-name><column-value><![CDATA[");
		sb.append(getHtlb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htbh</column-name><column-value><![CDATA[");
		sb.append(getHtbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zbhtbh</column-name><column-value><![CDATA[");
		sb.append(getZbhtbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fbhtbh</column-name><column-value><![CDATA[");
		sb.append(getFbhtbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htlx</column-name><column-value><![CDATA[");
		sb.append(getHtlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htzt</column-name><column-value><![CDATA[");
		sb.append(getHtzt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zfbgx</column-name><column-value><![CDATA[");
		sb.append(getZfbgx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bsrq</column-name><column-value><![CDATA[");
		sb.append(getBsrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slsj</column-name><column-value><![CDATA[");
		sb.append(getSlsj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>szdq</column-name><column-value><![CDATA[");
		sb.append(getSzdq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmmc</column-name><column-value><![CDATA[");
		sb.append(getXmmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdw</column-name><column-value><![CDATA[");
		sb.append(getJsdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdd</column-name><column-value><![CDATA[");
		sb.append(getJsdd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxpw</column-name><column-value><![CDATA[");
		sb.append(getLxpw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pzwh</column-name><column-value><![CDATA[");
		sb.append(getPzwh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dwxz</column-name><column-value><![CDATA[");
		sb.append(getDwxz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlygc</column-name><column-value><![CDATA[");
		sb.append(getZjlygc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ztz</column-name><column-value><![CDATA[");
		sb.append(getZtz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjzmj</column-name><column-value><![CDATA[");
		sb.append(getZjzmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfl</column-name><column-value><![CDATA[");
		sb.append(getXmfl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jzgm</column-name><column-value><![CDATA[");
		sb.append(getJzgm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bdh</column-name><column-value><![CDATA[");
		sb.append(getBdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fbfs</column-name><column-value><![CDATA[");
		sb.append(getFbfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cbfs</column-name><column-value><![CDATA[");
		sb.append(getCbfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zycbht</column-name><column-value><![CDATA[");
		sb.append(getZycbht());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zygclb</column-name><column-value><![CDATA[");
		sb.append(getZygclb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmc</column-name><column-value><![CDATA[");
		sb.append(getHtmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fbdw</column-name><column-value><![CDATA[");
		sb.append(getFbdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cbdw</column-name><column-value><![CDATA[");
		sb.append(getCbdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjdw</column-name><column-value><![CDATA[");
		sb.append(getSjdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfzr</column-name><column-value><![CDATA[");
		sb.append(getXmfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfzrzjlx</column-name><column-value><![CDATA[");
		sb.append(getXmfzrzjlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfzrzjh</column-name><column-value><![CDATA[");
		sb.append(getXmfzrzjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjfzr</column-name><column-value><![CDATA[");
		sb.append(getSjfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjfzrzjlx</column-name><column-value><![CDATA[");
		sb.append(getSjfzrzjlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjfzrzjh</column-name><column-value><![CDATA[");
		sb.append(getSjfzrzjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kcdwmc</column-name><column-value><![CDATA[");
		sb.append(getKcdwmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kcfzr</column-name><column-value><![CDATA[");
		sb.append(getKcfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kcfzrzjlx</column-name><column-value><![CDATA[");
		sb.append(getKcfzrzjlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kcfzrzjh</column-name><column-value><![CDATA[");
		sb.append(getKcfzrzjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgdwmc</column-name><column-value><![CDATA[");
		sb.append(getSgdwmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgfzr</column-name><column-value><![CDATA[");
		sb.append(getSgfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgfzrzjlx</column-name><column-value><![CDATA[");
		sb.append(getSgfzrzjlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgfzrzjh</column-name><column-value><![CDATA[");
		sb.append(getSgfzrzjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmlb</column-name><column-value><![CDATA[");
		sb.append(getXmlb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gclb</column-name><column-value><![CDATA[");
		sb.append(getGclb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gcgm</column-name><column-value><![CDATA[");
		sb.append(getGcgm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjxmlb</column-name><column-value><![CDATA[");
		sb.append(getSjxmlb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjgclb</column-name><column-value><![CDATA[");
		sb.append(getSjgclb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjgcgm</column-name><column-value><![CDATA[");
		sb.append(getSjgcgm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgxmlb</column-name><column-value><![CDATA[");
		sb.append(getSgxmlb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sggclb</column-name><column-value><![CDATA[");
		sb.append(getSggclb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sggcgm</column-name><column-value><![CDATA[");
		sb.append(getSggcgm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kgrq</column-name><column-value><![CDATA[");
		sb.append(getKgrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jgrq</column-name><column-value><![CDATA[");
		sb.append(getJgrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsfs</column-name><column-value><![CDATA[");
		sb.append(getJsfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htj</column-name><column-value><![CDATA[");
		sb.append(getHtj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjf</column-name><column-value><![CDATA[");
		sb.append(getSjf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kcf</column-name><column-value><![CDATA[");
		sb.append(getKcf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jazj</column-name><column-value><![CDATA[");
		sb.append(getJazj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zlje</column-name><column-value><![CDATA[");
		sb.append(getZlje());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zgj</column-name><column-value><![CDATA[");
		sb.append(getZgj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aqfhwmsgcsf</column-name><column-value><![CDATA[");
		sb.append(getAqfhwmsgcsf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htqdrq</column-name><column-value><![CDATA[");
		sb.append(getHtqdrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htqzrq</column-name><column-value><![CDATA[");
		sb.append(getHtqzrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cbnr</column-name><column-value><![CDATA[");
		sb.append(getCbnr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cyhtsfwb</column-name><column-value><![CDATA[");
		sb.append(getCyhtsfwb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fzjqtsm</column-name><column-value><![CDATA[");
		sb.append(getFzjqtsm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfzx</column-name><column-value><![CDATA[");
		sb.append(getSfzx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zxsj</column-name><column-value><![CDATA[");
		sb.append(getZxsj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zxsm</column-name><column-value><![CDATA[");
		sb.append(getZxsm());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _contractRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.contract.service.ClpSerializer.class;
}