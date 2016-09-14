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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Contract service. Represents a row in the &quot;cp_Contract&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.cp.contract.model.impl.ContractModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.cp.contract.model.impl.ContractImpl}.
 * </p>
 *
 * @author fanqi
 * @see Contract
 * @see com.justonetech.cp.contract.model.impl.ContractImpl
 * @see com.justonetech.cp.contract.model.impl.ContractModelImpl
 * @generated
 */
public interface ContractModel extends BaseModel<Contract> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contract model instance should use the {@link Contract} interface instead.
	 */

	/**
	 * Returns the primary key of this contract.
	 *
	 * @return the primary key of this contract
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this contract.
	 *
	 * @param primaryKey the primary key of this contract
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the contract ID of this contract.
	 *
	 * @return the contract ID of this contract
	 */
	@AutoEscape
	public String getContractId();

	/**
	 * Sets the contract ID of this contract.
	 *
	 * @param contractId the contract ID of this contract
	 */
	public void setContractId(String contractId);

	/**
	 * Returns the zzjgdm of this contract.
	 *
	 * @return the zzjgdm of this contract
	 */
	@AutoEscape
	public String getZzjgdm();

	/**
	 * Sets the zzjgdm of this contract.
	 *
	 * @param zzjgdm the zzjgdm of this contract
	 */
	public void setZzjgdm(String zzjgdm);

	/**
	 * Returns the htlb of this contract.
	 *
	 * @return the htlb of this contract
	 */
	@AutoEscape
	public String getHtlb();

	/**
	 * Sets the htlb of this contract.
	 *
	 * @param htlb the htlb of this contract
	 */
	public void setHtlb(String htlb);

	/**
	 * Returns the ID of this contract.
	 *
	 * @return the ID of this contract
	 */
	@AutoEscape
	public String getId();

	/**
	 * Sets the ID of this contract.
	 *
	 * @param id the ID of this contract
	 */
	public void setId(String id);

	/**
	 * Returns the htid of this contract.
	 *
	 * @return the htid of this contract
	 */
	@AutoEscape
	public String getHtid();

	/**
	 * Sets the htid of this contract.
	 *
	 * @param htid the htid of this contract
	 */
	public void setHtid(String htid);

	/**
	 * Returns the htbh of this contract.
	 *
	 * @return the htbh of this contract
	 */
	@AutoEscape
	public String getHtbh();

	/**
	 * Sets the htbh of this contract.
	 *
	 * @param htbh the htbh of this contract
	 */
	public void setHtbh(String htbh);

	/**
	 * Returns the zbhtbh of this contract.
	 *
	 * @return the zbhtbh of this contract
	 */
	@AutoEscape
	public String getZbhtbh();

	/**
	 * Sets the zbhtbh of this contract.
	 *
	 * @param zbhtbh the zbhtbh of this contract
	 */
	public void setZbhtbh(String zbhtbh);

	/**
	 * Returns the fbhtbh of this contract.
	 *
	 * @return the fbhtbh of this contract
	 */
	@AutoEscape
	public String getFbhtbh();

	/**
	 * Sets the fbhtbh of this contract.
	 *
	 * @param fbhtbh the fbhtbh of this contract
	 */
	public void setFbhtbh(String fbhtbh);

	/**
	 * Returns the lwfbhtbh of this contract.
	 *
	 * @return the lwfbhtbh of this contract
	 */
	@AutoEscape
	public String getLwfbhtbh();

	/**
	 * Sets the lwfbhtbh of this contract.
	 *
	 * @param lwfbhtbh the lwfbhtbh of this contract
	 */
	public void setLwfbhtbh(String lwfbhtbh);

	/**
	 * Returns the htlx of this contract.
	 *
	 * @return the htlx of this contract
	 */
	@AutoEscape
	public String getHtlx();

	/**
	 * Sets the htlx of this contract.
	 *
	 * @param htlx the htlx of this contract
	 */
	public void setHtlx(String htlx);

	/**
	 * Returns the htzt of this contract.
	 *
	 * @return the htzt of this contract
	 */
	@AutoEscape
	public String getHtzt();

	/**
	 * Sets the htzt of this contract.
	 *
	 * @param htzt the htzt of this contract
	 */
	public void setHtzt(String htzt);

	/**
	 * Returns the sfsl of this contract.
	 *
	 * @return the sfsl of this contract
	 */
	@AutoEscape
	public String getSfsl();

	/**
	 * Sets the sfsl of this contract.
	 *
	 * @param sfsl the sfsl of this contract
	 */
	public void setSfsl(String sfsl);

	/**
	 * Returns the zxbz of this contract.
	 *
	 * @return the zxbz of this contract
	 */
	@AutoEscape
	public String getZxbz();

	/**
	 * Sets the zxbz of this contract.
	 *
	 * @param zxbz the zxbz of this contract
	 */
	public void setZxbz(String zxbz);

	/**
	 * Returns the state of this contract.
	 *
	 * @return the state of this contract
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this contract.
	 *
	 * @param state the state of this contract
	 */
	public void setState(String state);

	/**
	 * Returns the bssj of this contract.
	 *
	 * @return the bssj of this contract
	 */
	public Date getBssj();

	/**
	 * Sets the bssj of this contract.
	 *
	 * @param bssj the bssj of this contract
	 */
	public void setBssj(Date bssj);

	/**
	 * Returns the slsj of this contract.
	 *
	 * @return the slsj of this contract
	 */
	public Date getSlsj();

	/**
	 * Sets the slsj of this contract.
	 *
	 * @param slsj the slsj of this contract
	 */
	public void setSlsj(Date slsj);

	/**
	 * Returns the bjbh of this contract.
	 *
	 * @return the bjbh of this contract
	 */
	@AutoEscape
	public String getBjbh();

	/**
	 * Sets the bjbh of this contract.
	 *
	 * @param bjbh the bjbh of this contract
	 */
	public void setBjbh(String bjbh);

	/**
	 * Returns the szdq of this contract.
	 *
	 * @return the szdq of this contract
	 */
	@AutoEscape
	public String getSzdq();

	/**
	 * Sets the szdq of this contract.
	 *
	 * @param szdq the szdq of this contract
	 */
	public void setSzdq(String szdq);

	/**
	 * Returns the xmmc of this contract.
	 *
	 * @return the xmmc of this contract
	 */
	@AutoEscape
	public String getXmmc();

	/**
	 * Sets the xmmc of this contract.
	 *
	 * @param xmmc the xmmc of this contract
	 */
	public void setXmmc(String xmmc);

	/**
	 * Returns the jsdw of this contract.
	 *
	 * @return the jsdw of this contract
	 */
	@AutoEscape
	public String getJsdw();

	/**
	 * Sets the jsdw of this contract.
	 *
	 * @param jsdw the jsdw of this contract
	 */
	public void setJsdw(String jsdw);

	/**
	 * Returns the jsdd of this contract.
	 *
	 * @return the jsdd of this contract
	 */
	@AutoEscape
	public String getJsdd();

	/**
	 * Sets the jsdd of this contract.
	 *
	 * @param jsdd the jsdd of this contract
	 */
	public void setJsdd(String jsdd);

	/**
	 * Returns the lxpw of this contract.
	 *
	 * @return the lxpw of this contract
	 */
	@AutoEscape
	public String getLxpw();

	/**
	 * Sets the lxpw of this contract.
	 *
	 * @param lxpw the lxpw of this contract
	 */
	public void setLxpw(String lxpw);

	/**
	 * Returns the pzwh of this contract.
	 *
	 * @return the pzwh of this contract
	 */
	@AutoEscape
	public String getPzwh();

	/**
	 * Sets the pzwh of this contract.
	 *
	 * @param pzwh the pzwh of this contract
	 */
	public void setPzwh(String pzwh);

	/**
	 * Returns the dwxz of this contract.
	 *
	 * @return the dwxz of this contract
	 */
	@AutoEscape
	public String getDwxz();

	/**
	 * Sets the dwxz of this contract.
	 *
	 * @param dwxz the dwxz of this contract
	 */
	public void setDwxz(String dwxz);

	/**
	 * Returns the zjlygc of this contract.
	 *
	 * @return the zjlygc of this contract
	 */
	@AutoEscape
	public String getZjlygc();

	/**
	 * Sets the zjlygc of this contract.
	 *
	 * @param zjlygc the zjlygc of this contract
	 */
	public void setZjlygc(String zjlygc);

	/**
	 * Returns the ztz of this contract.
	 *
	 * @return the ztz of this contract
	 */
	@AutoEscape
	public String getZtz();

	/**
	 * Sets the ztz of this contract.
	 *
	 * @param ztz the ztz of this contract
	 */
	public void setZtz(String ztz);

	/**
	 * Returns the zmj of this contract.
	 *
	 * @return the zmj of this contract
	 */
	@AutoEscape
	public String getZmj();

	/**
	 * Sets the zmj of this contract.
	 *
	 * @param zmj the zmj of this contract
	 */
	public void setZmj(String zmj);

	/**
	 * Returns the xmfl of this contract.
	 *
	 * @return the xmfl of this contract
	 */
	@AutoEscape
	public String getXmfl();

	/**
	 * Sets the xmfl of this contract.
	 *
	 * @param xmfl the xmfl of this contract
	 */
	public void setXmfl(String xmfl);

	/**
	 * Returns the jsgm of this contract.
	 *
	 * @return the jsgm of this contract
	 */
	@AutoEscape
	public String getJsgm();

	/**
	 * Sets the jsgm of this contract.
	 *
	 * @param jsgm the jsgm of this contract
	 */
	public void setJsgm(String jsgm);

	/**
	 * Returns the bdh of this contract.
	 *
	 * @return the bdh of this contract
	 */
	@AutoEscape
	public String getBdh();

	/**
	 * Sets the bdh of this contract.
	 *
	 * @param bdh the bdh of this contract
	 */
	public void setBdh(String bdh);

	/**
	 * Returns the fbfs of this contract.
	 *
	 * @return the fbfs of this contract
	 */
	@AutoEscape
	public String getFbfs();

	/**
	 * Sets the fbfs of this contract.
	 *
	 * @param fbfs the fbfs of this contract
	 */
	public void setFbfs(String fbfs);

	/**
	 * Returns the cbfs of this contract.
	 *
	 * @return the cbfs of this contract
	 */
	@AutoEscape
	public String getCbfs();

	/**
	 * Sets the cbfs of this contract.
	 *
	 * @param cbfs the cbfs of this contract
	 */
	public void setCbfs(String cbfs);

	/**
	 * Returns the zycbht of this contract.
	 *
	 * @return the zycbht of this contract
	 */
	@AutoEscape
	public String getZycbht();

	/**
	 * Sets the zycbht of this contract.
	 *
	 * @param zycbht the zycbht of this contract
	 */
	public void setZycbht(String zycbht);

	/**
	 * Returns the zygclb of this contract.
	 *
	 * @return the zygclb of this contract
	 */
	@AutoEscape
	public String getZygclb();

	/**
	 * Sets the zygclb of this contract.
	 *
	 * @param zygclb the zygclb of this contract
	 */
	public void setZygclb(String zygclb);

	/**
	 * Returns the htmc of this contract.
	 *
	 * @return the htmc of this contract
	 */
	@AutoEscape
	public String getHtmc();

	/**
	 * Sets the htmc of this contract.
	 *
	 * @param htmc the htmc of this contract
	 */
	public void setHtmc(String htmc);

	/**
	 * Returns the fbdw of this contract.
	 *
	 * @return the fbdw of this contract
	 */
	@AutoEscape
	public String getFbdw();

	/**
	 * Sets the fbdw of this contract.
	 *
	 * @param fbdw the fbdw of this contract
	 */
	public void setFbdw(String fbdw);

	/**
	 * Returns the cbdw of this contract.
	 *
	 * @return the cbdw of this contract
	 */
	@AutoEscape
	public String getCbdw();

	/**
	 * Sets the cbdw of this contract.
	 *
	 * @param cbdw the cbdw of this contract
	 */
	public void setCbdw(String cbdw);

	/**
	 * Returns the sjdw of this contract.
	 *
	 * @return the sjdw of this contract
	 */
	@AutoEscape
	public String getSjdw();

	/**
	 * Sets the sjdw of this contract.
	 *
	 * @param sjdw the sjdw of this contract
	 */
	public void setSjdw(String sjdw);

	/**
	 * Returns the xmfzr of this contract.
	 *
	 * @return the xmfzr of this contract
	 */
	@AutoEscape
	public String getXmfzr();

	/**
	 * Sets the xmfzr of this contract.
	 *
	 * @param xmfzr the xmfzr of this contract
	 */
	public void setXmfzr(String xmfzr);

	/**
	 * Returns the xmfzrzjlx of this contract.
	 *
	 * @return the xmfzrzjlx of this contract
	 */
	@AutoEscape
	public String getXmfzrzjlx();

	/**
	 * Sets the xmfzrzjlx of this contract.
	 *
	 * @param xmfzrzjlx the xmfzrzjlx of this contract
	 */
	public void setXmfzrzjlx(String xmfzrzjlx);

	/**
	 * Returns the xmfzrzjh of this contract.
	 *
	 * @return the xmfzrzjh of this contract
	 */
	@AutoEscape
	public String getXmfzrzjh();

	/**
	 * Sets the xmfzrzjh of this contract.
	 *
	 * @param xmfzrzjh the xmfzrzjh of this contract
	 */
	public void setXmfzrzjh(String xmfzrzjh);

	/**
	 * Returns the sjfzr of this contract.
	 *
	 * @return the sjfzr of this contract
	 */
	@AutoEscape
	public String getSjfzr();

	/**
	 * Sets the sjfzr of this contract.
	 *
	 * @param sjfzr the sjfzr of this contract
	 */
	public void setSjfzr(String sjfzr);

	/**
	 * Returns the sjfzrzjlx of this contract.
	 *
	 * @return the sjfzrzjlx of this contract
	 */
	@AutoEscape
	public String getSjfzrzjlx();

	/**
	 * Sets the sjfzrzjlx of this contract.
	 *
	 * @param sjfzrzjlx the sjfzrzjlx of this contract
	 */
	public void setSjfzrzjlx(String sjfzrzjlx);

	/**
	 * Returns the sjfzrzjh of this contract.
	 *
	 * @return the sjfzrzjh of this contract
	 */
	@AutoEscape
	public String getSjfzrzjh();

	/**
	 * Sets the sjfzrzjh of this contract.
	 *
	 * @param sjfzrzjh the sjfzrzjh of this contract
	 */
	public void setSjfzrzjh(String sjfzrzjh);

	/**
	 * Returns the kcdw of this contract.
	 *
	 * @return the kcdw of this contract
	 */
	@AutoEscape
	public String getKcdw();

	/**
	 * Sets the kcdw of this contract.
	 *
	 * @param kcdw the kcdw of this contract
	 */
	public void setKcdw(String kcdw);

	/**
	 * Returns the kcfzr of this contract.
	 *
	 * @return the kcfzr of this contract
	 */
	@AutoEscape
	public String getKcfzr();

	/**
	 * Sets the kcfzr of this contract.
	 *
	 * @param kcfzr the kcfzr of this contract
	 */
	public void setKcfzr(String kcfzr);

	/**
	 * Returns the kcfzrzjlx of this contract.
	 *
	 * @return the kcfzrzjlx of this contract
	 */
	@AutoEscape
	public String getKcfzrzjlx();

	/**
	 * Sets the kcfzrzjlx of this contract.
	 *
	 * @param kcfzrzjlx the kcfzrzjlx of this contract
	 */
	public void setKcfzrzjlx(String kcfzrzjlx);

	/**
	 * Returns the kcfzrzjh of this contract.
	 *
	 * @return the kcfzrzjh of this contract
	 */
	@AutoEscape
	public String getKcfzrzjh();

	/**
	 * Sets the kcfzrzjh of this contract.
	 *
	 * @param kcfzrzjh the kcfzrzjh of this contract
	 */
	public void setKcfzrzjh(String kcfzrzjh);

	/**
	 * Returns the sgdw of this contract.
	 *
	 * @return the sgdw of this contract
	 */
	@AutoEscape
	public String getSgdw();

	/**
	 * Sets the sgdw of this contract.
	 *
	 * @param sgdw the sgdw of this contract
	 */
	public void setSgdw(String sgdw);

	/**
	 * Returns the sgfzr of this contract.
	 *
	 * @return the sgfzr of this contract
	 */
	@AutoEscape
	public String getSgfzr();

	/**
	 * Sets the sgfzr of this contract.
	 *
	 * @param sgfzr the sgfzr of this contract
	 */
	public void setSgfzr(String sgfzr);

	/**
	 * Returns the sgfzrzjlx of this contract.
	 *
	 * @return the sgfzrzjlx of this contract
	 */
	@AutoEscape
	public String getSgfzrzjlx();

	/**
	 * Sets the sgfzrzjlx of this contract.
	 *
	 * @param sgfzrzjlx the sgfzrzjlx of this contract
	 */
	public void setSgfzrzjlx(String sgfzrzjlx);

	/**
	 * Returns the sgfzrzjh of this contract.
	 *
	 * @return the sgfzrzjh of this contract
	 */
	@AutoEscape
	public String getSgfzrzjh();

	/**
	 * Sets the sgfzrzjh of this contract.
	 *
	 * @param sgfzrzjh the sgfzrzjh of this contract
	 */
	public void setSgfzrzjh(String sgfzrzjh);

	/**
	 * Returns the xmlb of this contract.
	 *
	 * @return the xmlb of this contract
	 */
	@AutoEscape
	public String getXmlb();

	/**
	 * Sets the xmlb of this contract.
	 *
	 * @param xmlb the xmlb of this contract
	 */
	public void setXmlb(String xmlb);

	/**
	 * Returns the gclb of this contract.
	 *
	 * @return the gclb of this contract
	 */
	@AutoEscape
	public String getGclb();

	/**
	 * Sets the gclb of this contract.
	 *
	 * @param gclb the gclb of this contract
	 */
	public void setGclb(String gclb);

	/**
	 * Returns the gcgm of this contract.
	 *
	 * @return the gcgm of this contract
	 */
	@AutoEscape
	public String getGcgm();

	/**
	 * Sets the gcgm of this contract.
	 *
	 * @param gcgm the gcgm of this contract
	 */
	public void setGcgm(String gcgm);

	/**
	 * Returns the sjxmlb of this contract.
	 *
	 * @return the sjxmlb of this contract
	 */
	@AutoEscape
	public String getSjxmlb();

	/**
	 * Sets the sjxmlb of this contract.
	 *
	 * @param sjxmlb the sjxmlb of this contract
	 */
	public void setSjxmlb(String sjxmlb);

	/**
	 * Returns the sjgclb of this contract.
	 *
	 * @return the sjgclb of this contract
	 */
	@AutoEscape
	public String getSjgclb();

	/**
	 * Sets the sjgclb of this contract.
	 *
	 * @param sjgclb the sjgclb of this contract
	 */
	public void setSjgclb(String sjgclb);

	/**
	 * Returns the sjgcgm of this contract.
	 *
	 * @return the sjgcgm of this contract
	 */
	@AutoEscape
	public String getSjgcgm();

	/**
	 * Sets the sjgcgm of this contract.
	 *
	 * @param sjgcgm the sjgcgm of this contract
	 */
	public void setSjgcgm(String sjgcgm);

	/**
	 * Returns the sgxmlb of this contract.
	 *
	 * @return the sgxmlb of this contract
	 */
	@AutoEscape
	public String getSgxmlb();

	/**
	 * Sets the sgxmlb of this contract.
	 *
	 * @param sgxmlb the sgxmlb of this contract
	 */
	public void setSgxmlb(String sgxmlb);

	/**
	 * Returns the sggclb of this contract.
	 *
	 * @return the sggclb of this contract
	 */
	@AutoEscape
	public String getSggclb();

	/**
	 * Sets the sggclb of this contract.
	 *
	 * @param sggclb the sggclb of this contract
	 */
	public void setSggclb(String sggclb);

	/**
	 * Returns the sggcgm of this contract.
	 *
	 * @return the sggcgm of this contract
	 */
	@AutoEscape
	public String getSggcgm();

	/**
	 * Sets the sggcgm of this contract.
	 *
	 * @param sggcgm the sggcgm of this contract
	 */
	public void setSggcgm(String sggcgm);

	/**
	 * Returns the kgrq of this contract.
	 *
	 * @return the kgrq of this contract
	 */
	public Date getKgrq();

	/**
	 * Sets the kgrq of this contract.
	 *
	 * @param kgrq the kgrq of this contract
	 */
	public void setKgrq(Date kgrq);

	/**
	 * Returns the jgrq of this contract.
	 *
	 * @return the jgrq of this contract
	 */
	public Date getJgrq();

	/**
	 * Sets the jgrq of this contract.
	 *
	 * @param jgrq the jgrq of this contract
	 */
	public void setJgrq(Date jgrq);

	/**
	 * Returns the jsfs of this contract.
	 *
	 * @return the jsfs of this contract
	 */
	@AutoEscape
	public String getJsfs();

	/**
	 * Sets the jsfs of this contract.
	 *
	 * @param jsfs the jsfs of this contract
	 */
	public void setJsfs(String jsfs);

	/**
	 * Returns the htj of this contract.
	 *
	 * @return the htj of this contract
	 */
	@AutoEscape
	public String getHtj();

	/**
	 * Sets the htj of this contract.
	 *
	 * @param htj the htj of this contract
	 */
	public void setHtj(String htj);

	/**
	 * Returns the sjf of this contract.
	 *
	 * @return the sjf of this contract
	 */
	@AutoEscape
	public String getSjf();

	/**
	 * Sets the sjf of this contract.
	 *
	 * @param sjf the sjf of this contract
	 */
	public void setSjf(String sjf);

	/**
	 * Returns the kcf of this contract.
	 *
	 * @return the kcf of this contract
	 */
	@AutoEscape
	public String getKcf();

	/**
	 * Sets the kcf of this contract.
	 *
	 * @param kcf the kcf of this contract
	 */
	public void setKcf(String kcf);

	/**
	 * Returns the jazj of this contract.
	 *
	 * @return the jazj of this contract
	 */
	@AutoEscape
	public String getJazj();

	/**
	 * Sets the jazj of this contract.
	 *
	 * @param jazj the jazj of this contract
	 */
	public void setJazj(String jazj);

	/**
	 * Returns the zlje of this contract.
	 *
	 * @return the zlje of this contract
	 */
	@AutoEscape
	public String getZlje();

	/**
	 * Sets the zlje of this contract.
	 *
	 * @param zlje the zlje of this contract
	 */
	public void setZlje(String zlje);

	/**
	 * Returns the zgj of this contract.
	 *
	 * @return the zgj of this contract
	 */
	@AutoEscape
	public String getZgj();

	/**
	 * Sets the zgj of this contract.
	 *
	 * @param zgj the zgj of this contract
	 */
	public void setZgj(String zgj);

	/**
	 * Returns the wmcsf of this contract.
	 *
	 * @return the wmcsf of this contract
	 */
	@AutoEscape
	public String getWmcsf();

	/**
	 * Sets the wmcsf of this contract.
	 *
	 * @param wmcsf the wmcsf of this contract
	 */
	public void setWmcsf(String wmcsf);

	/**
	 * Returns the htqdrq of this contract.
	 *
	 * @return the htqdrq of this contract
	 */
	public Date getHtqdrq();

	/**
	 * Sets the htqdrq of this contract.
	 *
	 * @param htqdrq the htqdrq of this contract
	 */
	public void setHtqdrq(Date htqdrq);

	/**
	 * Returns the htqzrq of this contract.
	 *
	 * @return the htqzrq of this contract
	 */
	@AutoEscape
	public String getHtqzrq();

	/**
	 * Sets the htqzrq of this contract.
	 *
	 * @param htqzrq the htqzrq of this contract
	 */
	public void setHtqzrq(String htqzrq);

	/**
	 * Returns the cbnr of this contract.
	 *
	 * @return the cbnr of this contract
	 */
	@AutoEscape
	public String getCbnr();

	/**
	 * Sets the cbnr of this contract.
	 *
	 * @param cbnr the cbnr of this contract
	 */
	public void setCbnr(String cbnr);

	/**
	 * Returns the htsfwbmc of this contract.
	 *
	 * @return the htsfwbmc of this contract
	 */
	@AutoEscape
	public String getHtsfwbmc();

	/**
	 * Sets the htsfwbmc of this contract.
	 *
	 * @param htsfwbmc the htsfwbmc of this contract
	 */
	public void setHtsfwbmc(String htsfwbmc);

	/**
	 * Returns the bz of this contract.
	 *
	 * @return the bz of this contract
	 */
	@AutoEscape
	public String getBz();

	/**
	 * Sets the bz of this contract.
	 *
	 * @param bz the bz of this contract
	 */
	public void setBz(String bz);

	/**
	 * Returns the sfzx of this contract.
	 *
	 * @return the sfzx of this contract
	 */
	@AutoEscape
	public String getSfzx();

	/**
	 * Sets the sfzx of this contract.
	 *
	 * @param sfzx the sfzx of this contract
	 */
	public void setSfzx(String sfzx);

	/**
	 * Returns the zxsj of this contract.
	 *
	 * @return the zxsj of this contract
	 */
	public Date getZxsj();

	/**
	 * Sets the zxsj of this contract.
	 *
	 * @param zxsj the zxsj of this contract
	 */
	public void setZxsj(Date zxsj);

	/**
	 * Returns the zxsm of this contract.
	 *
	 * @return the zxsm of this contract
	 */
	@AutoEscape
	public String getZxsm();

	/**
	 * Sets the zxsm of this contract.
	 *
	 * @param zxsm the zxsm of this contract
	 */
	public void setZxsm(String zxsm);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.justonetech.cp.contract.model.Contract contract);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.cp.contract.model.Contract> toCacheModel();

	@Override
	public com.justonetech.cp.contract.model.Contract toEscapedModel();

	@Override
	public com.justonetech.cp.contract.model.Contract toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}