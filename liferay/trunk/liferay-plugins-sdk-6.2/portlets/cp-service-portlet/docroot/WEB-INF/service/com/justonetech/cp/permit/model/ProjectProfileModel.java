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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ProjectProfile service. Represents a row in the &quot;cp_ProjectProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.cp.permit.model.impl.ProjectProfileImpl}.
 * </p>
 *
 * @author fanqi
 * @see ProjectProfile
 * @see com.justonetech.cp.permit.model.impl.ProjectProfileImpl
 * @see com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl
 * @generated
 */
public interface ProjectProfileModel extends BaseModel<ProjectProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project profile model instance should use the {@link ProjectProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this project profile.
	 *
	 * @return the primary key of this project profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project profile.
	 *
	 * @param primaryKey the primary key of this project profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the permit ID of this project profile.
	 *
	 * @return the permit ID of this project profile
	 */
	public long getPermitId();

	/**
	 * Sets the permit ID of this project profile.
	 *
	 * @param permitId the permit ID of this project profile
	 */
	public void setPermitId(long permitId);

	/**
	 * Returns the bjbh of this project profile.
	 *
	 * @return the bjbh of this project profile
	 */
	@AutoEscape
	public String getBjbh();

	/**
	 * Sets the bjbh of this project profile.
	 *
	 * @param bjbh the bjbh of this project profile
	 */
	public void setBjbh(String bjbh);

	/**
	 * Returns the jsdwmc of this project profile.
	 *
	 * @return the jsdwmc of this project profile
	 */
	@AutoEscape
	public String getJsdwmc();

	/**
	 * Sets the jsdwmc of this project profile.
	 *
	 * @param jsdwmc the jsdwmc of this project profile
	 */
	public void setJsdwmc(String jsdwmc);

	/**
	 * Returns the jsdwxz of this project profile.
	 *
	 * @return the jsdwxz of this project profile
	 */
	@AutoEscape
	public String getJsdwxz();

	/**
	 * Sets the jsdwxz of this project profile.
	 *
	 * @param jsdwxz the jsdwxz of this project profile
	 */
	public void setJsdwxz(String jsdwxz);

	/**
	 * Returns the jsdwdz of this project profile.
	 *
	 * @return the jsdwdz of this project profile
	 */
	@AutoEscape
	public String getJsdwdz();

	/**
	 * Sets the jsdwdz of this project profile.
	 *
	 * @param jsdwdz the jsdwdz of this project profile
	 */
	public void setJsdwdz(String jsdwdz);

	/**
	 * Returns the gcmc of this project profile.
	 *
	 * @return the gcmc of this project profile
	 */
	@AutoEscape
	public String getGcmc();

	/**
	 * Sets the gcmc of this project profile.
	 *
	 * @param gcmc the gcmc of this project profile
	 */
	public void setGcmc(String gcmc);

	/**
	 * Returns the jsdd of this project profile.
	 *
	 * @return the jsdd of this project profile
	 */
	@AutoEscape
	public String getJsdd();

	/**
	 * Sets the jsdd of this project profile.
	 *
	 * @param jsdd the jsdd of this project profile
	 */
	public void setJsdd(String jsdd);

	/**
	 * Returns the jsgcgm of this project profile.
	 *
	 * @return the jsgcgm of this project profile
	 */
	@AutoEscape
	public String getJsgcgm();

	/**
	 * Sets the jsgcgm of this project profile.
	 *
	 * @param jsgcgm the jsgcgm of this project profile
	 */
	public void setJsgcgm(String jsgcgm);

	/**
	 * Returns the fwjzmj of this project profile.
	 *
	 * @return the fwjzmj of this project profile
	 */
	@AutoEscape
	public String getFwjzmj();

	/**
	 * Sets the fwjzmj of this project profile.
	 *
	 * @param fwjzmj the fwjzmj of this project profile
	 */
	public void setFwjzmj(String fwjzmj);

	/**
	 * Returns the htjg of this project profile.
	 *
	 * @return the htjg of this project profile
	 */
	@AutoEscape
	public String getHtjg();

	/**
	 * Sets the htjg of this project profile.
	 *
	 * @param htjg the htjg of this project profile
	 */
	public void setHtjg(String htjg);

	/**
	 * Returns the htgq of this project profile.
	 *
	 * @return the htgq of this project profile
	 */
	public int getHtgq();

	/**
	 * Sets the htgq of this project profile.
	 *
	 * @param htgq the htgq of this project profile
	 */
	public void setHtgq(int htgq);

	/**
	 * Returns the fddbr of this project profile.
	 *
	 * @return the fddbr of this project profile
	 */
	@AutoEscape
	public String getFddbr();

	/**
	 * Sets the fddbr of this project profile.
	 *
	 * @param fddbr the fddbr of this project profile
	 */
	public void setFddbr(String fddbr);

	/**
	 * Returns the jsdwlxdh of this project profile.
	 *
	 * @return the jsdwlxdh of this project profile
	 */
	@AutoEscape
	public String getJsdwlxdh();

	/**
	 * Sets the jsdwlxdh of this project profile.
	 *
	 * @param jsdwlxdh the jsdwlxdh of this project profile
	 */
	public void setJsdwlxdh(String jsdwlxdh);

	/**
	 * Returns the jsdwlxr of this project profile.
	 *
	 * @return the jsdwlxr of this project profile
	 */
	@AutoEscape
	public String getJsdwlxr();

	/**
	 * Sets the jsdwlxr of this project profile.
	 *
	 * @param jsdwlxr the jsdwlxr of this project profile
	 */
	public void setJsdwlxr(String jsdwlxr);

	/**
	 * Returns the jsdwsjh of this project profile.
	 *
	 * @return the jsdwsjh of this project profile
	 */
	@AutoEscape
	public String getJsdwsjh();

	/**
	 * Sets the jsdwsjh of this project profile.
	 *
	 * @param jsdwsjh the jsdwsjh of this project profile
	 */
	public void setJsdwsjh(String jsdwsjh);

	/**
	 * Returns the jsgcghxkzbh of this project profile.
	 *
	 * @return the jsgcghxkzbh of this project profile
	 */
	@AutoEscape
	public String getJsgcghxkzbh();

	/**
	 * Sets the jsgcghxkzbh of this project profile.
	 *
	 * @param jsgcghxkzbh the jsgcghxkzbh of this project profile
	 */
	public void setJsgcghxkzbh(String jsgcghxkzbh);

	/**
	 * Returns the xckgqk of this project profile.
	 *
	 * @return the xckgqk of this project profile
	 */
	@AutoEscape
	public String getXckgqk();

	/**
	 * Sets the xckgqk of this project profile.
	 *
	 * @param xckgqk the xckgqk of this project profile
	 */
	public void setXckgqk(String xckgqk);

	/**
	 * Returns the xmlx of this project profile.
	 *
	 * @return the xmlx of this project profile
	 */
	public long getXmlx();

	/**
	 * Sets the xmlx of this project profile.
	 *
	 * @param xmlx the xmlx of this project profile
	 */
	public void setXmlx(long xmlx);

	/**
	 * Returns the lxjb of this project profile.
	 *
	 * @return the lxjb of this project profile
	 */
	@AutoEscape
	public String getLxjb();

	/**
	 * Sets the lxjb of this project profile.
	 *
	 * @param lxjb the lxjb of this project profile
	 */
	public void setLxjb(String lxjb);

	/**
	 * Returns the xmxz of this project profile.
	 *
	 * @return the xmxz of this project profile
	 */
	public long getXmxz();

	/**
	 * Sets the xmxz of this project profile.
	 *
	 * @param xmxz the xmxz of this project profile
	 */
	public void setXmxz(long xmxz);

	/**
	 * Returns the ssqx of this project profile.
	 *
	 * @return the ssqx of this project profile
	 */
	@AutoEscape
	public String getSsqx();

	/**
	 * Sets the ssqx of this project profile.
	 *
	 * @param ssqx the ssqx of this project profile
	 */
	public void setSsqx(String ssqx);

	/**
	 * Returns the ywbm of this project profile.
	 *
	 * @return the ywbm of this project profile
	 */
	@AutoEscape
	public String getYwbm();

	/**
	 * Sets the ywbm of this project profile.
	 *
	 * @param ywbm the ywbm of this project profile
	 */
	public void setYwbm(String ywbm);

	/**
	 * Returns the jsddssqx of this project profile.
	 *
	 * @return the jsddssqx of this project profile
	 */
	public long getJsddssqx();

	/**
	 * Sets the jsddssqx of this project profile.
	 *
	 * @param jsddssqx the jsddssqx of this project profile
	 */
	public void setJsddssqx(long jsddssqx);

	/**
	 * Returns the jsgclb of this project profile.
	 *
	 * @return the jsgclb of this project profile
	 */
	@AutoEscape
	public String getJsgclb();

	/**
	 * Sets the jsgclb of this project profile.
	 *
	 * @param jsgclb the jsgclb of this project profile
	 */
	public void setJsgclb(String jsgclb);

	/**
	 * Returns the jsgcsx of this project profile.
	 *
	 * @return the jsgcsx of this project profile
	 */
	public long getJsgcsx();

	/**
	 * Sets the jsgcsx of this project profile.
	 *
	 * @param jsgcsx the jsgcsx of this project profile
	 */
	public void setJsgcsx(long jsgcsx);

	/**
	 * Returns the gyzjbz of this project profile.
	 *
	 * @return the gyzjbz of this project profile
	 */
	@AutoEscape
	public String getGyzjbz();

	/**
	 * Sets the gyzjbz of this project profile.
	 *
	 * @param gyzjbz the gyzjbz of this project profile
	 */
	public void setGyzjbz(String gyzjbz);

	/**
	 * Returns the zbjg of this project profile.
	 *
	 * @return the zbjg of this project profile
	 */
	@AutoEscape
	public String getZbjg();

	/**
	 * Sets the zbjg of this project profile.
	 *
	 * @param zbjg the zbjg of this project profile
	 */
	public void setZbjg(String zbjg);

	/**
	 * Returns the xmtzgs of this project profile.
	 *
	 * @return the xmtzgs of this project profile
	 */
	@AutoEscape
	public String getXmtzgs();

	/**
	 * Sets the xmtzgs of this project profile.
	 *
	 * @param xmtzgs the xmtzgs of this project profile
	 */
	public void setXmtzgs(String xmtzgs);

	/**
	 * Returns the jhkg of this project profile.
	 *
	 * @return the jhkg of this project profile
	 */
	public Date getJhkg();

	/**
	 * Sets the jhkg of this project profile.
	 *
	 * @param jhkg the jhkg of this project profile
	 */
	public void setJhkg(Date jhkg);

	/**
	 * Returns the jhjg of this project profile.
	 *
	 * @return the jhjg of this project profile
	 */
	public Date getJhjg();

	/**
	 * Sets the jhjg of this project profile.
	 *
	 * @param jhjg the jhjg of this project profile
	 */
	public void setJhjg(Date jhjg);

	/**
	 * Returns the sfzftzl of this project profile.
	 *
	 * @return the sfzftzl of this project profile
	 */
	public boolean getSfzftzl();

	/**
	 * Returns <code>true</code> if this project profile is sfzftzl.
	 *
	 * @return <code>true</code> if this project profile is sfzftzl; <code>false</code> otherwise
	 */
	public boolean isSfzftzl();

	/**
	 * Sets whether this project profile is sfzftzl.
	 *
	 * @param sfzftzl the sfzftzl of this project profile
	 */
	public void setSfzftzl(boolean sfzftzl);

	/**
	 * Returns the yzzpl1 of this project profile.
	 *
	 * @return the yzzpl1 of this project profile
	 */
	@AutoEscape
	public String getYzzpl1();

	/**
	 * Sets the yzzpl1 of this project profile.
	 *
	 * @param yzzpl1 the yzzpl1 of this project profile
	 */
	public void setYzzpl1(String yzzpl1);

	/**
	 * Returns the yzzpl2 of this project profile.
	 *
	 * @return the yzzpl2 of this project profile
	 */
	@AutoEscape
	public String getYzzpl2();

	/**
	 * Sets the yzzpl2 of this project profile.
	 *
	 * @param yzzpl2 the yzzpl2 of this project profile
	 */
	public void setYzzpl2(String yzzpl2);

	/**
	 * Returns the yzzpl3 of this project profile.
	 *
	 * @return the yzzpl3 of this project profile
	 */
	@AutoEscape
	public String getYzzpl3();

	/**
	 * Sets the yzzpl3 of this project profile.
	 *
	 * @param yzzpl3 the yzzpl3 of this project profile
	 */
	public void setYzzpl3(String yzzpl3);

	/**
	 * Returns the yzzpl4 of this project profile.
	 *
	 * @return the yzzpl4 of this project profile
	 */
	@AutoEscape
	public String getYzzpl4();

	/**
	 * Sets the yzzpl4 of this project profile.
	 *
	 * @param yzzpl4 the yzzpl4 of this project profile
	 */
	public void setYzzpl4(String yzzpl4);

	/**
	 * Returns the bimsj of this project profile.
	 *
	 * @return the bimsj of this project profile
	 */
	@AutoEscape
	public String getBimsj();

	/**
	 * Sets the bimsj of this project profile.
	 *
	 * @param bimsj the bimsj of this project profile
	 */
	public void setBimsj(String bimsj);

	/**
	 * Returns the bimsg of this project profile.
	 *
	 * @return the bimsg of this project profile
	 */
	@AutoEscape
	public String getBimsg();

	/**
	 * Sets the bimsg of this project profile.
	 *
	 * @param bimsg the bimsg of this project profile
	 */
	public void setBimsg(String bimsg);

	/**
	 * Returns the bimyw of this project profile.
	 *
	 * @return the bimyw of this project profile
	 */
	@AutoEscape
	public String getBimyw();

	/**
	 * Sets the bimyw of this project profile.
	 *
	 * @param bimyw the bimyw of this project profile
	 */
	public void setBimyw(String bimyw);

	/**
	 * Returns the tjsj of this project profile.
	 *
	 * @return the tjsj of this project profile
	 */
	public Date getTjsj();

	/**
	 * Sets the tjsj of this project profile.
	 *
	 * @param tjsj the tjsj of this project profile
	 */
	public void setTjsj(Date tjsj);

	/**
	 * Returns the gcnr of this project profile.
	 *
	 * @return the gcnr of this project profile
	 */
	@AutoEscape
	public String getGcnr();

	/**
	 * Sets the gcnr of this project profile.
	 *
	 * @param gcnr the gcnr of this project profile
	 */
	public void setGcnr(String gcnr);

	/**
	 * Returns the sgxkzsbz of this project profile.
	 *
	 * @return the sgxkzsbz of this project profile
	 */
	@AutoEscape
	public String getSgxkzsbz();

	/**
	 * Sets the sgxkzsbz of this project profile.
	 *
	 * @param sgxkzsbz the sgxkzsbz of this project profile
	 */
	public void setSgxkzsbz(String sgxkzsbz);

	/**
	 * Returns the gls of this project profile.
	 *
	 * @return the gls of this project profile
	 */
	@AutoEscape
	public String getGls();

	/**
	 * Sets the gls of this project profile.
	 *
	 * @param gls the gls of this project profile
	 */
	public void setGls(String gls);

	/**
	 * Returns the jzmj of this project profile.
	 *
	 * @return the jzmj of this project profile
	 */
	@AutoEscape
	public String getJzmj();

	/**
	 * Sets the jzmj of this project profile.
	 *
	 * @param jzmj the jzmj of this project profile
	 */
	public void setJzmj(String jzmj);

	/**
	 * Returns the qlsl of this project profile.
	 *
	 * @return the qlsl of this project profile
	 */
	public int getQlsl();

	/**
	 * Sets the qlsl of this project profile.
	 *
	 * @param qlsl the qlsl of this project profile
	 */
	public void setQlsl(int qlsl);

	/**
	 * Returns the qlkd of this project profile.
	 *
	 * @return the qlkd of this project profile
	 */
	@AutoEscape
	public String getQlkd();

	/**
	 * Sets the qlkd of this project profile.
	 *
	 * @param qlkd the qlkd of this project profile
	 */
	public void setQlkd(String qlkd);

	/**
	 * Returns the guijiaosl of this project profile.
	 *
	 * @return the guijiaosl of this project profile
	 */
	public int getGuijiaosl();

	/**
	 * Sets the guijiaosl of this project profile.
	 *
	 * @param guijiaosl the guijiaosl of this project profile
	 */
	public void setGuijiaosl(int guijiaosl);

	/**
	 * Returns the sdsl of this project profile.
	 *
	 * @return the sdsl of this project profile
	 */
	public int getSdsl();

	/**
	 * Sets the sdsl of this project profile.
	 *
	 * @param sdsl the sdsl of this project profile
	 */
	public void setSdsl(int sdsl);

	/**
	 * Returns the gaojiasl of this project profile.
	 *
	 * @return the gaojiasl of this project profile
	 */
	public int getGaojiasl();

	/**
	 * Sets the gaojiasl of this project profile.
	 *
	 * @param gaojiasl the gaojiasl of this project profile
	 */
	public void setGaojiasl(int gaojiasl);

	/**
	 * Returns the zgj of this project profile.
	 *
	 * @return the zgj of this project profile
	 */
	@AutoEscape
	public String getZgj();

	/**
	 * Sets the zgj of this project profile.
	 *
	 * @param zgj the zgj of this project profile
	 */
	public void setZgj(String zgj);

	/**
	 * Returns the zsqxks of this project profile.
	 *
	 * @return the zsqxks of this project profile
	 */
	public Date getZsqxks();

	/**
	 * Sets the zsqxks of this project profile.
	 *
	 * @param zsqxks the zsqxks of this project profile
	 */
	public void setZsqxks(Date zsqxks);

	/**
	 * Returns the zsqxjs of this project profile.
	 *
	 * @return the zsqxjs of this project profile
	 */
	public Date getZsqxjs();

	/**
	 * Sets the zsqxjs of this project profile.
	 *
	 * @param zsqxjs the zsqxjs of this project profile
	 */
	public void setZsqxjs(Date zsqxjs);

	/**
	 * Returns the cnsx of this project profile.
	 *
	 * @return the cnsx of this project profile
	 */
	@AutoEscape
	public String getCnsx();

	/**
	 * Sets the cnsx of this project profile.
	 *
	 * @param cnsx the cnsx of this project profile
	 */
	public void setCnsx(String cnsx);

	/**
	 * Returns the tzly of this project profile.
	 *
	 * @return the tzly of this project profile
	 */
	@AutoEscape
	public String getTzly();

	/**
	 * Sets the tzly of this project profile.
	 *
	 * @param tzly the tzly of this project profile
	 */
	public void setTzly(String tzly);

	/**
	 * Returns the gkpzhhzjghwh of this project profile.
	 *
	 * @return the gkpzhhzjghwh of this project profile
	 */
	@AutoEscape
	public String getGkpzhhzjghwh();

	/**
	 * Sets the gkpzhhzjghwh of this project profile.
	 *
	 * @param gkpzhhzjghwh the gkpzhhzjghwh of this project profile
	 */
	public void setGkpzhhzjghwh(String gkpzhhzjghwh);

	/**
	 * Returns the pfhhzrq of this project profile.
	 *
	 * @return the pfhhzrq of this project profile
	 */
	public Date getPfhhzrq();

	/**
	 * Sets the pfhhzrq of this project profile.
	 *
	 * @param pfhhzrq the pfhhzrq of this project profile
	 */
	public void setPfhhzrq(Date pfhhzrq);

	/**
	 * Returns the cbsjpzjghwh of this project profile.
	 *
	 * @return the cbsjpzjghwh of this project profile
	 */
	@AutoEscape
	public String getCbsjpzjghwh();

	/**
	 * Sets the cbsjpzjghwh of this project profile.
	 *
	 * @param cbsjpzjghwh the cbsjpzjghwh of this project profile
	 */
	public void setCbsjpzjghwh(String cbsjpzjghwh);

	/**
	 * Returns the pfrq of this project profile.
	 *
	 * @return the pfrq of this project profile
	 */
	public Date getPfrq();

	/**
	 * Sets the pfrq of this project profile.
	 *
	 * @param pfrq the pfrq of this project profile
	 */
	public void setPfrq(Date pfrq);

	/**
	 * Returns the pfgq of this project profile.
	 *
	 * @return the pfgq of this project profile
	 */
	public int getPfgq();

	/**
	 * Sets the pfgq of this project profile.
	 *
	 * @param pfgq the pfgq of this project profile
	 */
	public void setPfgq(int pfgq);

	/**
	 * Returns the pzjghwh of this project profile.
	 *
	 * @return the pzjghwh of this project profile
	 */
	@AutoEscape
	public String getPzjghwh();

	/**
	 * Sets the pzjghwh of this project profile.
	 *
	 * @param pzjghwh the pzjghwh of this project profile
	 */
	public void setPzjghwh(String pzjghwh);

	/**
	 * Returns the xmdw of this project profile.
	 *
	 * @return the xmdw of this project profile
	 */
	@AutoEscape
	public String getXmdw();

	/**
	 * Sets the xmdw of this project profile.
	 *
	 * @param xmdw the xmdw of this project profile
	 */
	public void setXmdw(String xmdw);

	/**
	 * Returns the xmfzr of this project profile.
	 *
	 * @return the xmfzr of this project profile
	 */
	@AutoEscape
	public String getXmfzr();

	/**
	 * Sets the xmfzr of this project profile.
	 *
	 * @param xmfzr the xmfzr of this project profile
	 */
	public void setXmfzr(String xmfzr);

	/**
	 * Returns the xmfzrlxdh of this project profile.
	 *
	 * @return the xmfzrlxdh of this project profile
	 */
	@AutoEscape
	public String getXmfzrlxdh();

	/**
	 * Sets the xmfzrlxdh of this project profile.
	 *
	 * @param xmfzrlxdh the xmfzrlxdh of this project profile
	 */
	public void setXmfzrlxdh(String xmfzrlxdh);

	/**
	 * Returns the zysjdw of this project profile.
	 *
	 * @return the zysjdw of this project profile
	 */
	@AutoEscape
	public String getZysjdw();

	/**
	 * Sets the zysjdw of this project profile.
	 *
	 * @param zysjdw the zysjdw of this project profile
	 */
	public void setZysjdw(String zysjdw);

	/**
	 * Returns the sj_zbfs of this project profile.
	 *
	 * @return the sj_zbfs of this project profile
	 */
	@AutoEscape
	public String getSj_zbfs();

	/**
	 * Sets the sj_zbfs of this project profile.
	 *
	 * @param sj_zbfs the sj_zbfs of this project profile
	 */
	public void setSj_zbfs(String sj_zbfs);

	/**
	 * Returns the sj_zbj of this project profile.
	 *
	 * @return the sj_zbj of this project profile
	 */
	@AutoEscape
	public String getSj_zbj();

	/**
	 * Sets the sj_zbj of this project profile.
	 *
	 * @param sj_zbj the sj_zbj of this project profile
	 */
	public void setSj_zbj(String sj_zbj);

	/**
	 * Returns the sj_zzdj of this project profile.
	 *
	 * @return the sj_zzdj of this project profile
	 */
	@AutoEscape
	public String getSj_zzdj();

	/**
	 * Sets the sj_zzdj of this project profile.
	 *
	 * @param sj_zzdj the sj_zzdj of this project profile
	 */
	public void setSj_zzdj(String sj_zzdj);

	/**
	 * Returns the sj_zzdjzsbh of this project profile.
	 *
	 * @return the sj_zzdjzsbh of this project profile
	 */
	@AutoEscape
	public String getSj_zzdjzsbh();

	/**
	 * Sets the sj_zzdjzsbh of this project profile.
	 *
	 * @param sj_zzdjzsbh the sj_zzdjzsbh of this project profile
	 */
	public void setSj_zzdjzsbh(String sj_zzdjzsbh);

	/**
	 * Returns the sj_xmfzr of this project profile.
	 *
	 * @return the sj_xmfzr of this project profile
	 */
	@AutoEscape
	public String getSj_xmfzr();

	/**
	 * Sets the sj_xmfzr of this project profile.
	 *
	 * @param sj_xmfzr the sj_xmfzr of this project profile
	 */
	public void setSj_xmfzr(String sj_xmfzr);

	/**
	 * Returns the sj_xmfzrzsbh of this project profile.
	 *
	 * @return the sj_xmfzrzsbh of this project profile
	 */
	@AutoEscape
	public String getSj_xmfzrzsbh();

	/**
	 * Sets the sj_xmfzrzsbh of this project profile.
	 *
	 * @param sj_xmfzrzsbh the sj_xmfzrzsbh of this project profile
	 */
	public void setSj_xmfzrzsbh(String sj_xmfzrzsbh);

	/**
	 * Returns the zyjldw of this project profile.
	 *
	 * @return the zyjldw of this project profile
	 */
	@AutoEscape
	public String getZyjldw();

	/**
	 * Sets the zyjldw of this project profile.
	 *
	 * @param zyjldw the zyjldw of this project profile
	 */
	public void setZyjldw(String zyjldw);

	/**
	 * Returns the jl_zbfs of this project profile.
	 *
	 * @return the jl_zbfs of this project profile
	 */
	@AutoEscape
	public String getJl_zbfs();

	/**
	 * Sets the jl_zbfs of this project profile.
	 *
	 * @param jl_zbfs the jl_zbfs of this project profile
	 */
	public void setJl_zbfs(String jl_zbfs);

	/**
	 * Returns the jl_zbj of this project profile.
	 *
	 * @return the jl_zbj of this project profile
	 */
	@AutoEscape
	public String getJl_zbj();

	/**
	 * Sets the jl_zbj of this project profile.
	 *
	 * @param jl_zbj the jl_zbj of this project profile
	 */
	public void setJl_zbj(String jl_zbj);

	/**
	 * Returns the jl_zzdj of this project profile.
	 *
	 * @return the jl_zzdj of this project profile
	 */
	@AutoEscape
	public String getJl_zzdj();

	/**
	 * Sets the jl_zzdj of this project profile.
	 *
	 * @param jl_zzdj the jl_zzdj of this project profile
	 */
	public void setJl_zzdj(String jl_zzdj);

	/**
	 * Returns the jl_zzdjzsbh of this project profile.
	 *
	 * @return the jl_zzdjzsbh of this project profile
	 */
	@AutoEscape
	public String getJl_zzdjzsbh();

	/**
	 * Sets the jl_zzdjzsbh of this project profile.
	 *
	 * @param jl_zzdjzsbh the jl_zzdjzsbh of this project profile
	 */
	public void setJl_zzdjzsbh(String jl_zzdjzsbh);

	/**
	 * Returns the jl_zj of this project profile.
	 *
	 * @return the jl_zj of this project profile
	 */
	@AutoEscape
	public String getJl_zj();

	/**
	 * Sets the jl_zj of this project profile.
	 *
	 * @param jl_zj the jl_zj of this project profile
	 */
	public void setJl_zj(String jl_zj);

	/**
	 * Returns the jl_zjzsbh of this project profile.
	 *
	 * @return the jl_zjzsbh of this project profile
	 */
	@AutoEscape
	public String getJl_zjzsbh();

	/**
	 * Sets the jl_zjzsbh of this project profile.
	 *
	 * @param jl_zjzsbh the jl_zjzsbh of this project profile
	 */
	public void setJl_zjzsbh(String jl_zjzsbh);

	/**
	 * Returns the zysgdw of this project profile.
	 *
	 * @return the zysgdw of this project profile
	 */
	@AutoEscape
	public String getZysgdw();

	/**
	 * Sets the zysgdw of this project profile.
	 *
	 * @param zysgdw the zysgdw of this project profile
	 */
	public void setZysgdw(String zysgdw);

	/**
	 * Returns the sg_zbfs of this project profile.
	 *
	 * @return the sg_zbfs of this project profile
	 */
	@AutoEscape
	public String getSg_zbfs();

	/**
	 * Sets the sg_zbfs of this project profile.
	 *
	 * @param sg_zbfs the sg_zbfs of this project profile
	 */
	public void setSg_zbfs(String sg_zbfs);

	/**
	 * Returns the sg_zbj of this project profile.
	 *
	 * @return the sg_zbj of this project profile
	 */
	@AutoEscape
	public String getSg_zbj();

	/**
	 * Sets the sg_zbj of this project profile.
	 *
	 * @param sg_zbj the sg_zbj of this project profile
	 */
	public void setSg_zbj(String sg_zbj);

	/**
	 * Returns the sg_zzdj of this project profile.
	 *
	 * @return the sg_zzdj of this project profile
	 */
	@AutoEscape
	public String getSg_zzdj();

	/**
	 * Sets the sg_zzdj of this project profile.
	 *
	 * @param sg_zzdj the sg_zzdj of this project profile
	 */
	public void setSg_zzdj(String sg_zzdj);

	/**
	 * Returns the sg_zzdjzsbh of this project profile.
	 *
	 * @return the sg_zzdjzsbh of this project profile
	 */
	@AutoEscape
	public String getSg_zzdjzsbh();

	/**
	 * Sets the sg_zzdjzsbh of this project profile.
	 *
	 * @param sg_zzdjzsbh the sg_zzdjzsbh of this project profile
	 */
	public void setSg_zzdjzsbh(String sg_zzdjzsbh);

	/**
	 * Returns the sg_xmjl of this project profile.
	 *
	 * @return the sg_xmjl of this project profile
	 */
	@AutoEscape
	public String getSg_xmjl();

	/**
	 * Sets the sg_xmjl of this project profile.
	 *
	 * @param sg_xmjl the sg_xmjl of this project profile
	 */
	public void setSg_xmjl(String sg_xmjl);

	/**
	 * Returns the sg_xmjlzsbh of this project profile.
	 *
	 * @return the sg_xmjlzsbh of this project profile
	 */
	@AutoEscape
	public String getSg_xmjlzsbh();

	/**
	 * Sets the sg_xmjlzsbh of this project profile.
	 *
	 * @param sg_xmjlzsbh the sg_xmjlzsbh of this project profile
	 */
	public void setSg_xmjlzsbh(String sg_xmjlzsbh);

	/**
	 * Returns the jszjjhlsqk of this project profile.
	 *
	 * @return the jszjjhlsqk of this project profile
	 */
	@AutoEscape
	public String getJszjjhlsqk();

	/**
	 * Sets the jszjjhlsqk of this project profile.
	 *
	 * @param jszjjhlsqk the jszjjhlsqk of this project profile
	 */
	public void setJszjjhlsqk(String jszjjhlsqk);

	/**
	 * Returns the dcqwcqk of this project profile.
	 *
	 * @return the dcqwcqk of this project profile
	 */
	@AutoEscape
	public String getDcqwcqk();

	/**
	 * Sets the dcqwcqk of this project profile.
	 *
	 * @param dcqwcqk the dcqwcqk of this project profile
	 */
	public void setDcqwcqk(String dcqwcqk);

	/**
	 * Returns the sgzbqk of this project profile.
	 *
	 * @return the sgzbqk of this project profile
	 */
	@AutoEscape
	public String getSgzbqk();

	/**
	 * Sets the sgzbqk of this project profile.
	 *
	 * @param sgzbqk the sgzbqk of this project profile
	 */
	public void setSgzbqk(String sgzbqk);

	/**
	 * Returns the sytdxgwj of this project profile.
	 *
	 * @return the sytdxgwj of this project profile
	 */
	@AutoEscape
	public String getSytdxgwj();

	/**
	 * Sets the sytdxgwj of this project profile.
	 *
	 * @param sytdxgwj the sytdxgwj of this project profile
	 */
	public void setSytdxgwj(String sytdxgwj);

	/**
	 * Returns the gczljddjqk of this project profile.
	 *
	 * @return the gczljddjqk of this project profile
	 */
	@AutoEscape
	public String getGczljddjqk();

	/**
	 * Sets the gczljddjqk of this project profile.
	 *
	 * @param gczljddjqk the gczljddjqk of this project profile
	 */
	public void setGczljddjqk(String gczljddjqk);

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
	public int compareTo(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.cp.permit.model.ProjectProfile> toCacheModel();

	@Override
	public com.justonetech.cp.permit.model.ProjectProfile toEscapedModel();

	@Override
	public com.justonetech.cp.permit.model.ProjectProfile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}