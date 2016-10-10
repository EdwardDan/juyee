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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectProfile}.
 * </p>
 *
 * @author fanqi
 * @see ProjectProfile
 * @generated
 */
public class ProjectProfileWrapper implements ProjectProfile,
	ModelWrapper<ProjectProfile> {
	public ProjectProfileWrapper(ProjectProfile projectProfile) {
		_projectProfile = projectProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectProfile.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("permitId", getPermitId());
		attributes.put("bjbh", getBjbh());
		attributes.put("jsdwmc", getJsdwmc());
		attributes.put("jsdwxz", getJsdwxz());
		attributes.put("jsdwdz", getJsdwdz());
		attributes.put("gcmc", getGcmc());
		attributes.put("jsdd", getJsdd());
		attributes.put("jsgcgm", getJsgcgm());
		attributes.put("fwjzmj", getFwjzmj());
		attributes.put("htjg", getHtjg());
		attributes.put("htgq", getHtgq());
		attributes.put("fddbr", getFddbr());
		attributes.put("jsdwlxdh", getJsdwlxdh());
		attributes.put("jsdwlxr", getJsdwlxr());
		attributes.put("jsdwsjh", getJsdwsjh());
		attributes.put("jsgcghxkzbh", getJsgcghxkzbh());
		attributes.put("xckgqk", getXckgqk());
		attributes.put("xmlx", getXmlx());
		attributes.put("lxjb", getLxjb());
		attributes.put("xmxz", getXmxz());
		attributes.put("ssqx", getSsqx());
		attributes.put("ywbm", getYwbm());
		attributes.put("jsddssqx", getJsddssqx());
		attributes.put("jsgclb", getJsgclb());
		attributes.put("jsgcsx", getJsgcsx());
		attributes.put("gyzjbz", getGyzjbz());
		attributes.put("zbjg", getZbjg());
		attributes.put("xmtzgs", getXmtzgs());
		attributes.put("jhkg", getJhkg());
		attributes.put("jhjg", getJhjg());
		attributes.put("sfzftzl", getSfzftzl());
		attributes.put("yzzpl1", getYzzpl1());
		attributes.put("yzzpl2", getYzzpl2());
		attributes.put("yzzpl3", getYzzpl3());
		attributes.put("yzzpl4", getYzzpl4());
		attributes.put("tjsj", getTjsj());
		attributes.put("gcnr", getGcnr());
		attributes.put("sgxkzsbz", getSgxkzsbz());
		attributes.put("gkpzhhzjghwh", getGkpzhhzjghwh());
		attributes.put("pfhhzrq", getPfhhzrq());
		attributes.put("cbsjpzjghwh", getCbsjpzjghwh());
		attributes.put("pfrq", getPfrq());
		attributes.put("pfgq", getPfgq());
		attributes.put("pzjghwh", getPzjghwh());
		attributes.put("xmdw", getXmdw());
		attributes.put("xmfzr", getXmfzr());
		attributes.put("xmfzrlxdh", getXmfzrlxdh());
		attributes.put("zysjdw", getZysjdw());
		attributes.put("sj_zbfs", getSj_zbfs());
		attributes.put("sj_zbj", getSj_zbj());
		attributes.put("sj_zzdj", getSj_zzdj());
		attributes.put("sj_zzdjzsbh", getSj_zzdjzsbh());
		attributes.put("sj_xmfzr", getSj_xmfzr());
		attributes.put("sj_zmfzrzsbh", getSj_zmfzrzsbh());
		attributes.put("zyjldw", getZyjldw());
		attributes.put("jl_zbfs", getJl_zbfs());
		attributes.put("jl_zbj", getJl_zbj());
		attributes.put("jl_zzdj", getJl_zzdj());
		attributes.put("jl_zzdjzsbh", getJl_zzdjzsbh());
		attributes.put("jl_zj", getJl_zj());
		attributes.put("jl_zjzsbh", getJl_zjzsbh());
		attributes.put("zysgdw", getZysgdw());
		attributes.put("sg_zbfs", getSg_zbfs());
		attributes.put("sg_zbj", getSg_zbj());
		attributes.put("sg_zzdj", getSg_zzdj());
		attributes.put("sg_zzdjzsbh", getSg_zzdjzsbh());
		attributes.put("sg_xmjl", getSg_xmjl());
		attributes.put("sg_xmjlzsbh", getSg_xmjlzsbh());
		attributes.put("jszjjhlsqk", getJszjjhlsqk());
		attributes.put("dcqwcqk", getDcqwcqk());
		attributes.put("sgzbqk", getSgzbqk());
		attributes.put("sytdxgwj", getSytdxgwj());
		attributes.put("gczljddjqk", getGczljddjqk());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String jsdwmc = (String)attributes.get("jsdwmc");

		if (jsdwmc != null) {
			setJsdwmc(jsdwmc);
		}

		String jsdwxz = (String)attributes.get("jsdwxz");

		if (jsdwxz != null) {
			setJsdwxz(jsdwxz);
		}

		String jsdwdz = (String)attributes.get("jsdwdz");

		if (jsdwdz != null) {
			setJsdwdz(jsdwdz);
		}

		String gcmc = (String)attributes.get("gcmc");

		if (gcmc != null) {
			setGcmc(gcmc);
		}

		String jsdd = (String)attributes.get("jsdd");

		if (jsdd != null) {
			setJsdd(jsdd);
		}

		String jsgcgm = (String)attributes.get("jsgcgm");

		if (jsgcgm != null) {
			setJsgcgm(jsgcgm);
		}

		String fwjzmj = (String)attributes.get("fwjzmj");

		if (fwjzmj != null) {
			setFwjzmj(fwjzmj);
		}

		String htjg = (String)attributes.get("htjg");

		if (htjg != null) {
			setHtjg(htjg);
		}

		Integer htgq = (Integer)attributes.get("htgq");

		if (htgq != null) {
			setHtgq(htgq);
		}

		String fddbr = (String)attributes.get("fddbr");

		if (fddbr != null) {
			setFddbr(fddbr);
		}

		String jsdwlxdh = (String)attributes.get("jsdwlxdh");

		if (jsdwlxdh != null) {
			setJsdwlxdh(jsdwlxdh);
		}

		String jsdwlxr = (String)attributes.get("jsdwlxr");

		if (jsdwlxr != null) {
			setJsdwlxr(jsdwlxr);
		}

		String jsdwsjh = (String)attributes.get("jsdwsjh");

		if (jsdwsjh != null) {
			setJsdwsjh(jsdwsjh);
		}

		String jsgcghxkzbh = (String)attributes.get("jsgcghxkzbh");

		if (jsgcghxkzbh != null) {
			setJsgcghxkzbh(jsgcghxkzbh);
		}

		String xckgqk = (String)attributes.get("xckgqk");

		if (xckgqk != null) {
			setXckgqk(xckgqk);
		}

		Long xmlx = (Long)attributes.get("xmlx");

		if (xmlx != null) {
			setXmlx(xmlx);
		}

		String lxjb = (String)attributes.get("lxjb");

		if (lxjb != null) {
			setLxjb(lxjb);
		}

		Long xmxz = (Long)attributes.get("xmxz");

		if (xmxz != null) {
			setXmxz(xmxz);
		}

		String ssqx = (String)attributes.get("ssqx");

		if (ssqx != null) {
			setSsqx(ssqx);
		}

		String ywbm = (String)attributes.get("ywbm");

		if (ywbm != null) {
			setYwbm(ywbm);
		}

		Long jsddssqx = (Long)attributes.get("jsddssqx");

		if (jsddssqx != null) {
			setJsddssqx(jsddssqx);
		}

		String jsgclb = (String)attributes.get("jsgclb");

		if (jsgclb != null) {
			setJsgclb(jsgclb);
		}

		Long jsgcsx = (Long)attributes.get("jsgcsx");

		if (jsgcsx != null) {
			setJsgcsx(jsgcsx);
		}

		String gyzjbz = (String)attributes.get("gyzjbz");

		if (gyzjbz != null) {
			setGyzjbz(gyzjbz);
		}

		String zbjg = (String)attributes.get("zbjg");

		if (zbjg != null) {
			setZbjg(zbjg);
		}

		String xmtzgs = (String)attributes.get("xmtzgs");

		if (xmtzgs != null) {
			setXmtzgs(xmtzgs);
		}

		Date jhkg = (Date)attributes.get("jhkg");

		if (jhkg != null) {
			setJhkg(jhkg);
		}

		Date jhjg = (Date)attributes.get("jhjg");

		if (jhjg != null) {
			setJhjg(jhjg);
		}

		Boolean sfzftzl = (Boolean)attributes.get("sfzftzl");

		if (sfzftzl != null) {
			setSfzftzl(sfzftzl);
		}

		String yzzpl1 = (String)attributes.get("yzzpl1");

		if (yzzpl1 != null) {
			setYzzpl1(yzzpl1);
		}

		String yzzpl2 = (String)attributes.get("yzzpl2");

		if (yzzpl2 != null) {
			setYzzpl2(yzzpl2);
		}

		String yzzpl3 = (String)attributes.get("yzzpl3");

		if (yzzpl3 != null) {
			setYzzpl3(yzzpl3);
		}

		String yzzpl4 = (String)attributes.get("yzzpl4");

		if (yzzpl4 != null) {
			setYzzpl4(yzzpl4);
		}

		Date tjsj = (Date)attributes.get("tjsj");

		if (tjsj != null) {
			setTjsj(tjsj);
		}

		String gcnr = (String)attributes.get("gcnr");

		if (gcnr != null) {
			setGcnr(gcnr);
		}

		String sgxkzsbz = (String)attributes.get("sgxkzsbz");

		if (sgxkzsbz != null) {
			setSgxkzsbz(sgxkzsbz);
		}

		String gkpzhhzjghwh = (String)attributes.get("gkpzhhzjghwh");

		if (gkpzhhzjghwh != null) {
			setGkpzhhzjghwh(gkpzhhzjghwh);
		}

		Date pfhhzrq = (Date)attributes.get("pfhhzrq");

		if (pfhhzrq != null) {
			setPfhhzrq(pfhhzrq);
		}

		String cbsjpzjghwh = (String)attributes.get("cbsjpzjghwh");

		if (cbsjpzjghwh != null) {
			setCbsjpzjghwh(cbsjpzjghwh);
		}

		Date pfrq = (Date)attributes.get("pfrq");

		if (pfrq != null) {
			setPfrq(pfrq);
		}

		Integer pfgq = (Integer)attributes.get("pfgq");

		if (pfgq != null) {
			setPfgq(pfgq);
		}

		String pzjghwh = (String)attributes.get("pzjghwh");

		if (pzjghwh != null) {
			setPzjghwh(pzjghwh);
		}

		String xmdw = (String)attributes.get("xmdw");

		if (xmdw != null) {
			setXmdw(xmdw);
		}

		String xmfzr = (String)attributes.get("xmfzr");

		if (xmfzr != null) {
			setXmfzr(xmfzr);
		}

		String xmfzrlxdh = (String)attributes.get("xmfzrlxdh");

		if (xmfzrlxdh != null) {
			setXmfzrlxdh(xmfzrlxdh);
		}

		String zysjdw = (String)attributes.get("zysjdw");

		if (zysjdw != null) {
			setZysjdw(zysjdw);
		}

		String sj_zbfs = (String)attributes.get("sj_zbfs");

		if (sj_zbfs != null) {
			setSj_zbfs(sj_zbfs);
		}

		String sj_zbj = (String)attributes.get("sj_zbj");

		if (sj_zbj != null) {
			setSj_zbj(sj_zbj);
		}

		String sj_zzdj = (String)attributes.get("sj_zzdj");

		if (sj_zzdj != null) {
			setSj_zzdj(sj_zzdj);
		}

		String sj_zzdjzsbh = (String)attributes.get("sj_zzdjzsbh");

		if (sj_zzdjzsbh != null) {
			setSj_zzdjzsbh(sj_zzdjzsbh);
		}

		String sj_xmfzr = (String)attributes.get("sj_xmfzr");

		if (sj_xmfzr != null) {
			setSj_xmfzr(sj_xmfzr);
		}

		String sj_zmfzrzsbh = (String)attributes.get("sj_zmfzrzsbh");

		if (sj_zmfzrzsbh != null) {
			setSj_zmfzrzsbh(sj_zmfzrzsbh);
		}

		String zyjldw = (String)attributes.get("zyjldw");

		if (zyjldw != null) {
			setZyjldw(zyjldw);
		}

		String jl_zbfs = (String)attributes.get("jl_zbfs");

		if (jl_zbfs != null) {
			setJl_zbfs(jl_zbfs);
		}

		String jl_zbj = (String)attributes.get("jl_zbj");

		if (jl_zbj != null) {
			setJl_zbj(jl_zbj);
		}

		String jl_zzdj = (String)attributes.get("jl_zzdj");

		if (jl_zzdj != null) {
			setJl_zzdj(jl_zzdj);
		}

		String jl_zzdjzsbh = (String)attributes.get("jl_zzdjzsbh");

		if (jl_zzdjzsbh != null) {
			setJl_zzdjzsbh(jl_zzdjzsbh);
		}

		String jl_zj = (String)attributes.get("jl_zj");

		if (jl_zj != null) {
			setJl_zj(jl_zj);
		}

		String jl_zjzsbh = (String)attributes.get("jl_zjzsbh");

		if (jl_zjzsbh != null) {
			setJl_zjzsbh(jl_zjzsbh);
		}

		String zysgdw = (String)attributes.get("zysgdw");

		if (zysgdw != null) {
			setZysgdw(zysgdw);
		}

		String sg_zbfs = (String)attributes.get("sg_zbfs");

		if (sg_zbfs != null) {
			setSg_zbfs(sg_zbfs);
		}

		String sg_zbj = (String)attributes.get("sg_zbj");

		if (sg_zbj != null) {
			setSg_zbj(sg_zbj);
		}

		String sg_zzdj = (String)attributes.get("sg_zzdj");

		if (sg_zzdj != null) {
			setSg_zzdj(sg_zzdj);
		}

		String sg_zzdjzsbh = (String)attributes.get("sg_zzdjzsbh");

		if (sg_zzdjzsbh != null) {
			setSg_zzdjzsbh(sg_zzdjzsbh);
		}

		String sg_xmjl = (String)attributes.get("sg_xmjl");

		if (sg_xmjl != null) {
			setSg_xmjl(sg_xmjl);
		}

		String sg_xmjlzsbh = (String)attributes.get("sg_xmjlzsbh");

		if (sg_xmjlzsbh != null) {
			setSg_xmjlzsbh(sg_xmjlzsbh);
		}

		String jszjjhlsqk = (String)attributes.get("jszjjhlsqk");

		if (jszjjhlsqk != null) {
			setJszjjhlsqk(jszjjhlsqk);
		}

		String dcqwcqk = (String)attributes.get("dcqwcqk");

		if (dcqwcqk != null) {
			setDcqwcqk(dcqwcqk);
		}

		String sgzbqk = (String)attributes.get("sgzbqk");

		if (sgzbqk != null) {
			setSgzbqk(sgzbqk);
		}

		String sytdxgwj = (String)attributes.get("sytdxgwj");

		if (sytdxgwj != null) {
			setSytdxgwj(sytdxgwj);
		}

		String gczljddjqk = (String)attributes.get("gczljddjqk");

		if (gczljddjqk != null) {
			setGczljddjqk(gczljddjqk);
		}
	}

	/**
	* Returns the primary key of this project profile.
	*
	* @return the primary key of this project profile
	*/
	@Override
	public long getPrimaryKey() {
		return _projectProfile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project profile.
	*
	* @param primaryKey the primary key of this project profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectProfile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the permit ID of this project profile.
	*
	* @return the permit ID of this project profile
	*/
	@Override
	public long getPermitId() {
		return _projectProfile.getPermitId();
	}

	/**
	* Sets the permit ID of this project profile.
	*
	* @param permitId the permit ID of this project profile
	*/
	@Override
	public void setPermitId(long permitId) {
		_projectProfile.setPermitId(permitId);
	}

	/**
	* Returns the bjbh of this project profile.
	*
	* @return the bjbh of this project profile
	*/
	@Override
	public java.lang.String getBjbh() {
		return _projectProfile.getBjbh();
	}

	/**
	* Sets the bjbh of this project profile.
	*
	* @param bjbh the bjbh of this project profile
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_projectProfile.setBjbh(bjbh);
	}

	/**
	* Returns the jsdwmc of this project profile.
	*
	* @return the jsdwmc of this project profile
	*/
	@Override
	public java.lang.String getJsdwmc() {
		return _projectProfile.getJsdwmc();
	}

	/**
	* Sets the jsdwmc of this project profile.
	*
	* @param jsdwmc the jsdwmc of this project profile
	*/
	@Override
	public void setJsdwmc(java.lang.String jsdwmc) {
		_projectProfile.setJsdwmc(jsdwmc);
	}

	/**
	* Returns the jsdwxz of this project profile.
	*
	* @return the jsdwxz of this project profile
	*/
	@Override
	public java.lang.String getJsdwxz() {
		return _projectProfile.getJsdwxz();
	}

	/**
	* Sets the jsdwxz of this project profile.
	*
	* @param jsdwxz the jsdwxz of this project profile
	*/
	@Override
	public void setJsdwxz(java.lang.String jsdwxz) {
		_projectProfile.setJsdwxz(jsdwxz);
	}

	/**
	* Returns the jsdwdz of this project profile.
	*
	* @return the jsdwdz of this project profile
	*/
	@Override
	public java.lang.String getJsdwdz() {
		return _projectProfile.getJsdwdz();
	}

	/**
	* Sets the jsdwdz of this project profile.
	*
	* @param jsdwdz the jsdwdz of this project profile
	*/
	@Override
	public void setJsdwdz(java.lang.String jsdwdz) {
		_projectProfile.setJsdwdz(jsdwdz);
	}

	/**
	* Returns the gcmc of this project profile.
	*
	* @return the gcmc of this project profile
	*/
	@Override
	public java.lang.String getGcmc() {
		return _projectProfile.getGcmc();
	}

	/**
	* Sets the gcmc of this project profile.
	*
	* @param gcmc the gcmc of this project profile
	*/
	@Override
	public void setGcmc(java.lang.String gcmc) {
		_projectProfile.setGcmc(gcmc);
	}

	/**
	* Returns the jsdd of this project profile.
	*
	* @return the jsdd of this project profile
	*/
	@Override
	public java.lang.String getJsdd() {
		return _projectProfile.getJsdd();
	}

	/**
	* Sets the jsdd of this project profile.
	*
	* @param jsdd the jsdd of this project profile
	*/
	@Override
	public void setJsdd(java.lang.String jsdd) {
		_projectProfile.setJsdd(jsdd);
	}

	/**
	* Returns the jsgcgm of this project profile.
	*
	* @return the jsgcgm of this project profile
	*/
	@Override
	public java.lang.String getJsgcgm() {
		return _projectProfile.getJsgcgm();
	}

	/**
	* Sets the jsgcgm of this project profile.
	*
	* @param jsgcgm the jsgcgm of this project profile
	*/
	@Override
	public void setJsgcgm(java.lang.String jsgcgm) {
		_projectProfile.setJsgcgm(jsgcgm);
	}

	/**
	* Returns the fwjzmj of this project profile.
	*
	* @return the fwjzmj of this project profile
	*/
	@Override
	public java.lang.String getFwjzmj() {
		return _projectProfile.getFwjzmj();
	}

	/**
	* Sets the fwjzmj of this project profile.
	*
	* @param fwjzmj the fwjzmj of this project profile
	*/
	@Override
	public void setFwjzmj(java.lang.String fwjzmj) {
		_projectProfile.setFwjzmj(fwjzmj);
	}

	/**
	* Returns the htjg of this project profile.
	*
	* @return the htjg of this project profile
	*/
	@Override
	public java.lang.String getHtjg() {
		return _projectProfile.getHtjg();
	}

	/**
	* Sets the htjg of this project profile.
	*
	* @param htjg the htjg of this project profile
	*/
	@Override
	public void setHtjg(java.lang.String htjg) {
		_projectProfile.setHtjg(htjg);
	}

	/**
	* Returns the htgq of this project profile.
	*
	* @return the htgq of this project profile
	*/
	@Override
	public int getHtgq() {
		return _projectProfile.getHtgq();
	}

	/**
	* Sets the htgq of this project profile.
	*
	* @param htgq the htgq of this project profile
	*/
	@Override
	public void setHtgq(int htgq) {
		_projectProfile.setHtgq(htgq);
	}

	/**
	* Returns the fddbr of this project profile.
	*
	* @return the fddbr of this project profile
	*/
	@Override
	public java.lang.String getFddbr() {
		return _projectProfile.getFddbr();
	}

	/**
	* Sets the fddbr of this project profile.
	*
	* @param fddbr the fddbr of this project profile
	*/
	@Override
	public void setFddbr(java.lang.String fddbr) {
		_projectProfile.setFddbr(fddbr);
	}

	/**
	* Returns the jsdwlxdh of this project profile.
	*
	* @return the jsdwlxdh of this project profile
	*/
	@Override
	public java.lang.String getJsdwlxdh() {
		return _projectProfile.getJsdwlxdh();
	}

	/**
	* Sets the jsdwlxdh of this project profile.
	*
	* @param jsdwlxdh the jsdwlxdh of this project profile
	*/
	@Override
	public void setJsdwlxdh(java.lang.String jsdwlxdh) {
		_projectProfile.setJsdwlxdh(jsdwlxdh);
	}

	/**
	* Returns the jsdwlxr of this project profile.
	*
	* @return the jsdwlxr of this project profile
	*/
	@Override
	public java.lang.String getJsdwlxr() {
		return _projectProfile.getJsdwlxr();
	}

	/**
	* Sets the jsdwlxr of this project profile.
	*
	* @param jsdwlxr the jsdwlxr of this project profile
	*/
	@Override
	public void setJsdwlxr(java.lang.String jsdwlxr) {
		_projectProfile.setJsdwlxr(jsdwlxr);
	}

	/**
	* Returns the jsdwsjh of this project profile.
	*
	* @return the jsdwsjh of this project profile
	*/
	@Override
	public java.lang.String getJsdwsjh() {
		return _projectProfile.getJsdwsjh();
	}

	/**
	* Sets the jsdwsjh of this project profile.
	*
	* @param jsdwsjh the jsdwsjh of this project profile
	*/
	@Override
	public void setJsdwsjh(java.lang.String jsdwsjh) {
		_projectProfile.setJsdwsjh(jsdwsjh);
	}

	/**
	* Returns the jsgcghxkzbh of this project profile.
	*
	* @return the jsgcghxkzbh of this project profile
	*/
	@Override
	public java.lang.String getJsgcghxkzbh() {
		return _projectProfile.getJsgcghxkzbh();
	}

	/**
	* Sets the jsgcghxkzbh of this project profile.
	*
	* @param jsgcghxkzbh the jsgcghxkzbh of this project profile
	*/
	@Override
	public void setJsgcghxkzbh(java.lang.String jsgcghxkzbh) {
		_projectProfile.setJsgcghxkzbh(jsgcghxkzbh);
	}

	/**
	* Returns the xckgqk of this project profile.
	*
	* @return the xckgqk of this project profile
	*/
	@Override
	public java.lang.String getXckgqk() {
		return _projectProfile.getXckgqk();
	}

	/**
	* Sets the xckgqk of this project profile.
	*
	* @param xckgqk the xckgqk of this project profile
	*/
	@Override
	public void setXckgqk(java.lang.String xckgqk) {
		_projectProfile.setXckgqk(xckgqk);
	}

	/**
	* Returns the xmlx of this project profile.
	*
	* @return the xmlx of this project profile
	*/
	@Override
	public long getXmlx() {
		return _projectProfile.getXmlx();
	}

	/**
	* Sets the xmlx of this project profile.
	*
	* @param xmlx the xmlx of this project profile
	*/
	@Override
	public void setXmlx(long xmlx) {
		_projectProfile.setXmlx(xmlx);
	}

	/**
	* Returns the lxjb of this project profile.
	*
	* @return the lxjb of this project profile
	*/
	@Override
	public java.lang.String getLxjb() {
		return _projectProfile.getLxjb();
	}

	/**
	* Sets the lxjb of this project profile.
	*
	* @param lxjb the lxjb of this project profile
	*/
	@Override
	public void setLxjb(java.lang.String lxjb) {
		_projectProfile.setLxjb(lxjb);
	}

	/**
	* Returns the xmxz of this project profile.
	*
	* @return the xmxz of this project profile
	*/
	@Override
	public long getXmxz() {
		return _projectProfile.getXmxz();
	}

	/**
	* Sets the xmxz of this project profile.
	*
	* @param xmxz the xmxz of this project profile
	*/
	@Override
	public void setXmxz(long xmxz) {
		_projectProfile.setXmxz(xmxz);
	}

	/**
	* Returns the ssqx of this project profile.
	*
	* @return the ssqx of this project profile
	*/
	@Override
	public java.lang.String getSsqx() {
		return _projectProfile.getSsqx();
	}

	/**
	* Sets the ssqx of this project profile.
	*
	* @param ssqx the ssqx of this project profile
	*/
	@Override
	public void setSsqx(java.lang.String ssqx) {
		_projectProfile.setSsqx(ssqx);
	}

	/**
	* Returns the ywbm of this project profile.
	*
	* @return the ywbm of this project profile
	*/
	@Override
	public java.lang.String getYwbm() {
		return _projectProfile.getYwbm();
	}

	/**
	* Sets the ywbm of this project profile.
	*
	* @param ywbm the ywbm of this project profile
	*/
	@Override
	public void setYwbm(java.lang.String ywbm) {
		_projectProfile.setYwbm(ywbm);
	}

	/**
	* Returns the jsddssqx of this project profile.
	*
	* @return the jsddssqx of this project profile
	*/
	@Override
	public long getJsddssqx() {
		return _projectProfile.getJsddssqx();
	}

	/**
	* Sets the jsddssqx of this project profile.
	*
	* @param jsddssqx the jsddssqx of this project profile
	*/
	@Override
	public void setJsddssqx(long jsddssqx) {
		_projectProfile.setJsddssqx(jsddssqx);
	}

	/**
	* Returns the jsgclb of this project profile.
	*
	* @return the jsgclb of this project profile
	*/
	@Override
	public java.lang.String getJsgclb() {
		return _projectProfile.getJsgclb();
	}

	/**
	* Sets the jsgclb of this project profile.
	*
	* @param jsgclb the jsgclb of this project profile
	*/
	@Override
	public void setJsgclb(java.lang.String jsgclb) {
		_projectProfile.setJsgclb(jsgclb);
	}

	/**
	* Returns the jsgcsx of this project profile.
	*
	* @return the jsgcsx of this project profile
	*/
	@Override
	public long getJsgcsx() {
		return _projectProfile.getJsgcsx();
	}

	/**
	* Sets the jsgcsx of this project profile.
	*
	* @param jsgcsx the jsgcsx of this project profile
	*/
	@Override
	public void setJsgcsx(long jsgcsx) {
		_projectProfile.setJsgcsx(jsgcsx);
	}

	/**
	* Returns the gyzjbz of this project profile.
	*
	* @return the gyzjbz of this project profile
	*/
	@Override
	public java.lang.String getGyzjbz() {
		return _projectProfile.getGyzjbz();
	}

	/**
	* Sets the gyzjbz of this project profile.
	*
	* @param gyzjbz the gyzjbz of this project profile
	*/
	@Override
	public void setGyzjbz(java.lang.String gyzjbz) {
		_projectProfile.setGyzjbz(gyzjbz);
	}

	/**
	* Returns the zbjg of this project profile.
	*
	* @return the zbjg of this project profile
	*/
	@Override
	public java.lang.String getZbjg() {
		return _projectProfile.getZbjg();
	}

	/**
	* Sets the zbjg of this project profile.
	*
	* @param zbjg the zbjg of this project profile
	*/
	@Override
	public void setZbjg(java.lang.String zbjg) {
		_projectProfile.setZbjg(zbjg);
	}

	/**
	* Returns the xmtzgs of this project profile.
	*
	* @return the xmtzgs of this project profile
	*/
	@Override
	public java.lang.String getXmtzgs() {
		return _projectProfile.getXmtzgs();
	}

	/**
	* Sets the xmtzgs of this project profile.
	*
	* @param xmtzgs the xmtzgs of this project profile
	*/
	@Override
	public void setXmtzgs(java.lang.String xmtzgs) {
		_projectProfile.setXmtzgs(xmtzgs);
	}

	/**
	* Returns the jhkg of this project profile.
	*
	* @return the jhkg of this project profile
	*/
	@Override
	public java.util.Date getJhkg() {
		return _projectProfile.getJhkg();
	}

	/**
	* Sets the jhkg of this project profile.
	*
	* @param jhkg the jhkg of this project profile
	*/
	@Override
	public void setJhkg(java.util.Date jhkg) {
		_projectProfile.setJhkg(jhkg);
	}

	/**
	* Returns the jhjg of this project profile.
	*
	* @return the jhjg of this project profile
	*/
	@Override
	public java.util.Date getJhjg() {
		return _projectProfile.getJhjg();
	}

	/**
	* Sets the jhjg of this project profile.
	*
	* @param jhjg the jhjg of this project profile
	*/
	@Override
	public void setJhjg(java.util.Date jhjg) {
		_projectProfile.setJhjg(jhjg);
	}

	/**
	* Returns the sfzftzl of this project profile.
	*
	* @return the sfzftzl of this project profile
	*/
	@Override
	public boolean getSfzftzl() {
		return _projectProfile.getSfzftzl();
	}

	/**
	* Returns <code>true</code> if this project profile is sfzftzl.
	*
	* @return <code>true</code> if this project profile is sfzftzl; <code>false</code> otherwise
	*/
	@Override
	public boolean isSfzftzl() {
		return _projectProfile.isSfzftzl();
	}

	/**
	* Sets whether this project profile is sfzftzl.
	*
	* @param sfzftzl the sfzftzl of this project profile
	*/
	@Override
	public void setSfzftzl(boolean sfzftzl) {
		_projectProfile.setSfzftzl(sfzftzl);
	}

	/**
	* Returns the yzzpl1 of this project profile.
	*
	* @return the yzzpl1 of this project profile
	*/
	@Override
	public java.lang.String getYzzpl1() {
		return _projectProfile.getYzzpl1();
	}

	/**
	* Sets the yzzpl1 of this project profile.
	*
	* @param yzzpl1 the yzzpl1 of this project profile
	*/
	@Override
	public void setYzzpl1(java.lang.String yzzpl1) {
		_projectProfile.setYzzpl1(yzzpl1);
	}

	/**
	* Returns the yzzpl2 of this project profile.
	*
	* @return the yzzpl2 of this project profile
	*/
	@Override
	public java.lang.String getYzzpl2() {
		return _projectProfile.getYzzpl2();
	}

	/**
	* Sets the yzzpl2 of this project profile.
	*
	* @param yzzpl2 the yzzpl2 of this project profile
	*/
	@Override
	public void setYzzpl2(java.lang.String yzzpl2) {
		_projectProfile.setYzzpl2(yzzpl2);
	}

	/**
	* Returns the yzzpl3 of this project profile.
	*
	* @return the yzzpl3 of this project profile
	*/
	@Override
	public java.lang.String getYzzpl3() {
		return _projectProfile.getYzzpl3();
	}

	/**
	* Sets the yzzpl3 of this project profile.
	*
	* @param yzzpl3 the yzzpl3 of this project profile
	*/
	@Override
	public void setYzzpl3(java.lang.String yzzpl3) {
		_projectProfile.setYzzpl3(yzzpl3);
	}

	/**
	* Returns the yzzpl4 of this project profile.
	*
	* @return the yzzpl4 of this project profile
	*/
	@Override
	public java.lang.String getYzzpl4() {
		return _projectProfile.getYzzpl4();
	}

	/**
	* Sets the yzzpl4 of this project profile.
	*
	* @param yzzpl4 the yzzpl4 of this project profile
	*/
	@Override
	public void setYzzpl4(java.lang.String yzzpl4) {
		_projectProfile.setYzzpl4(yzzpl4);
	}

	/**
	* Returns the tjsj of this project profile.
	*
	* @return the tjsj of this project profile
	*/
	@Override
	public java.util.Date getTjsj() {
		return _projectProfile.getTjsj();
	}

	/**
	* Sets the tjsj of this project profile.
	*
	* @param tjsj the tjsj of this project profile
	*/
	@Override
	public void setTjsj(java.util.Date tjsj) {
		_projectProfile.setTjsj(tjsj);
	}

	/**
	* Returns the gcnr of this project profile.
	*
	* @return the gcnr of this project profile
	*/
	@Override
	public java.lang.String getGcnr() {
		return _projectProfile.getGcnr();
	}

	/**
	* Sets the gcnr of this project profile.
	*
	* @param gcnr the gcnr of this project profile
	*/
	@Override
	public void setGcnr(java.lang.String gcnr) {
		_projectProfile.setGcnr(gcnr);
	}

	/**
	* Returns the sgxkzsbz of this project profile.
	*
	* @return the sgxkzsbz of this project profile
	*/
	@Override
	public java.lang.String getSgxkzsbz() {
		return _projectProfile.getSgxkzsbz();
	}

	/**
	* Sets the sgxkzsbz of this project profile.
	*
	* @param sgxkzsbz the sgxkzsbz of this project profile
	*/
	@Override
	public void setSgxkzsbz(java.lang.String sgxkzsbz) {
		_projectProfile.setSgxkzsbz(sgxkzsbz);
	}

	/**
	* Returns the gkpzhhzjghwh of this project profile.
	*
	* @return the gkpzhhzjghwh of this project profile
	*/
	@Override
	public java.lang.String getGkpzhhzjghwh() {
		return _projectProfile.getGkpzhhzjghwh();
	}

	/**
	* Sets the gkpzhhzjghwh of this project profile.
	*
	* @param gkpzhhzjghwh the gkpzhhzjghwh of this project profile
	*/
	@Override
	public void setGkpzhhzjghwh(java.lang.String gkpzhhzjghwh) {
		_projectProfile.setGkpzhhzjghwh(gkpzhhzjghwh);
	}

	/**
	* Returns the pfhhzrq of this project profile.
	*
	* @return the pfhhzrq of this project profile
	*/
	@Override
	public java.util.Date getPfhhzrq() {
		return _projectProfile.getPfhhzrq();
	}

	/**
	* Sets the pfhhzrq of this project profile.
	*
	* @param pfhhzrq the pfhhzrq of this project profile
	*/
	@Override
	public void setPfhhzrq(java.util.Date pfhhzrq) {
		_projectProfile.setPfhhzrq(pfhhzrq);
	}

	/**
	* Returns the cbsjpzjghwh of this project profile.
	*
	* @return the cbsjpzjghwh of this project profile
	*/
	@Override
	public java.lang.String getCbsjpzjghwh() {
		return _projectProfile.getCbsjpzjghwh();
	}

	/**
	* Sets the cbsjpzjghwh of this project profile.
	*
	* @param cbsjpzjghwh the cbsjpzjghwh of this project profile
	*/
	@Override
	public void setCbsjpzjghwh(java.lang.String cbsjpzjghwh) {
		_projectProfile.setCbsjpzjghwh(cbsjpzjghwh);
	}

	/**
	* Returns the pfrq of this project profile.
	*
	* @return the pfrq of this project profile
	*/
	@Override
	public java.util.Date getPfrq() {
		return _projectProfile.getPfrq();
	}

	/**
	* Sets the pfrq of this project profile.
	*
	* @param pfrq the pfrq of this project profile
	*/
	@Override
	public void setPfrq(java.util.Date pfrq) {
		_projectProfile.setPfrq(pfrq);
	}

	/**
	* Returns the pfgq of this project profile.
	*
	* @return the pfgq of this project profile
	*/
	@Override
	public int getPfgq() {
		return _projectProfile.getPfgq();
	}

	/**
	* Sets the pfgq of this project profile.
	*
	* @param pfgq the pfgq of this project profile
	*/
	@Override
	public void setPfgq(int pfgq) {
		_projectProfile.setPfgq(pfgq);
	}

	/**
	* Returns the pzjghwh of this project profile.
	*
	* @return the pzjghwh of this project profile
	*/
	@Override
	public java.lang.String getPzjghwh() {
		return _projectProfile.getPzjghwh();
	}

	/**
	* Sets the pzjghwh of this project profile.
	*
	* @param pzjghwh the pzjghwh of this project profile
	*/
	@Override
	public void setPzjghwh(java.lang.String pzjghwh) {
		_projectProfile.setPzjghwh(pzjghwh);
	}

	/**
	* Returns the xmdw of this project profile.
	*
	* @return the xmdw of this project profile
	*/
	@Override
	public java.lang.String getXmdw() {
		return _projectProfile.getXmdw();
	}

	/**
	* Sets the xmdw of this project profile.
	*
	* @param xmdw the xmdw of this project profile
	*/
	@Override
	public void setXmdw(java.lang.String xmdw) {
		_projectProfile.setXmdw(xmdw);
	}

	/**
	* Returns the xmfzr of this project profile.
	*
	* @return the xmfzr of this project profile
	*/
	@Override
	public java.lang.String getXmfzr() {
		return _projectProfile.getXmfzr();
	}

	/**
	* Sets the xmfzr of this project profile.
	*
	* @param xmfzr the xmfzr of this project profile
	*/
	@Override
	public void setXmfzr(java.lang.String xmfzr) {
		_projectProfile.setXmfzr(xmfzr);
	}

	/**
	* Returns the xmfzrlxdh of this project profile.
	*
	* @return the xmfzrlxdh of this project profile
	*/
	@Override
	public java.lang.String getXmfzrlxdh() {
		return _projectProfile.getXmfzrlxdh();
	}

	/**
	* Sets the xmfzrlxdh of this project profile.
	*
	* @param xmfzrlxdh the xmfzrlxdh of this project profile
	*/
	@Override
	public void setXmfzrlxdh(java.lang.String xmfzrlxdh) {
		_projectProfile.setXmfzrlxdh(xmfzrlxdh);
	}

	/**
	* Returns the zysjdw of this project profile.
	*
	* @return the zysjdw of this project profile
	*/
	@Override
	public java.lang.String getZysjdw() {
		return _projectProfile.getZysjdw();
	}

	/**
	* Sets the zysjdw of this project profile.
	*
	* @param zysjdw the zysjdw of this project profile
	*/
	@Override
	public void setZysjdw(java.lang.String zysjdw) {
		_projectProfile.setZysjdw(zysjdw);
	}

	/**
	* Returns the sj_zbfs of this project profile.
	*
	* @return the sj_zbfs of this project profile
	*/
	@Override
	public java.lang.String getSj_zbfs() {
		return _projectProfile.getSj_zbfs();
	}

	/**
	* Sets the sj_zbfs of this project profile.
	*
	* @param sj_zbfs the sj_zbfs of this project profile
	*/
	@Override
	public void setSj_zbfs(java.lang.String sj_zbfs) {
		_projectProfile.setSj_zbfs(sj_zbfs);
	}

	/**
	* Returns the sj_zbj of this project profile.
	*
	* @return the sj_zbj of this project profile
	*/
	@Override
	public java.lang.String getSj_zbj() {
		return _projectProfile.getSj_zbj();
	}

	/**
	* Sets the sj_zbj of this project profile.
	*
	* @param sj_zbj the sj_zbj of this project profile
	*/
	@Override
	public void setSj_zbj(java.lang.String sj_zbj) {
		_projectProfile.setSj_zbj(sj_zbj);
	}

	/**
	* Returns the sj_zzdj of this project profile.
	*
	* @return the sj_zzdj of this project profile
	*/
	@Override
	public java.lang.String getSj_zzdj() {
		return _projectProfile.getSj_zzdj();
	}

	/**
	* Sets the sj_zzdj of this project profile.
	*
	* @param sj_zzdj the sj_zzdj of this project profile
	*/
	@Override
	public void setSj_zzdj(java.lang.String sj_zzdj) {
		_projectProfile.setSj_zzdj(sj_zzdj);
	}

	/**
	* Returns the sj_zzdjzsbh of this project profile.
	*
	* @return the sj_zzdjzsbh of this project profile
	*/
	@Override
	public java.lang.String getSj_zzdjzsbh() {
		return _projectProfile.getSj_zzdjzsbh();
	}

	/**
	* Sets the sj_zzdjzsbh of this project profile.
	*
	* @param sj_zzdjzsbh the sj_zzdjzsbh of this project profile
	*/
	@Override
	public void setSj_zzdjzsbh(java.lang.String sj_zzdjzsbh) {
		_projectProfile.setSj_zzdjzsbh(sj_zzdjzsbh);
	}

	/**
	* Returns the sj_xmfzr of this project profile.
	*
	* @return the sj_xmfzr of this project profile
	*/
	@Override
	public java.lang.String getSj_xmfzr() {
		return _projectProfile.getSj_xmfzr();
	}

	/**
	* Sets the sj_xmfzr of this project profile.
	*
	* @param sj_xmfzr the sj_xmfzr of this project profile
	*/
	@Override
	public void setSj_xmfzr(java.lang.String sj_xmfzr) {
		_projectProfile.setSj_xmfzr(sj_xmfzr);
	}

	/**
	* Returns the sj_zmfzrzsbh of this project profile.
	*
	* @return the sj_zmfzrzsbh of this project profile
	*/
	@Override
	public java.lang.String getSj_zmfzrzsbh() {
		return _projectProfile.getSj_zmfzrzsbh();
	}

	/**
	* Sets the sj_zmfzrzsbh of this project profile.
	*
	* @param sj_zmfzrzsbh the sj_zmfzrzsbh of this project profile
	*/
	@Override
	public void setSj_zmfzrzsbh(java.lang.String sj_zmfzrzsbh) {
		_projectProfile.setSj_zmfzrzsbh(sj_zmfzrzsbh);
	}

	/**
	* Returns the zyjldw of this project profile.
	*
	* @return the zyjldw of this project profile
	*/
	@Override
	public java.lang.String getZyjldw() {
		return _projectProfile.getZyjldw();
	}

	/**
	* Sets the zyjldw of this project profile.
	*
	* @param zyjldw the zyjldw of this project profile
	*/
	@Override
	public void setZyjldw(java.lang.String zyjldw) {
		_projectProfile.setZyjldw(zyjldw);
	}

	/**
	* Returns the jl_zbfs of this project profile.
	*
	* @return the jl_zbfs of this project profile
	*/
	@Override
	public java.lang.String getJl_zbfs() {
		return _projectProfile.getJl_zbfs();
	}

	/**
	* Sets the jl_zbfs of this project profile.
	*
	* @param jl_zbfs the jl_zbfs of this project profile
	*/
	@Override
	public void setJl_zbfs(java.lang.String jl_zbfs) {
		_projectProfile.setJl_zbfs(jl_zbfs);
	}

	/**
	* Returns the jl_zbj of this project profile.
	*
	* @return the jl_zbj of this project profile
	*/
	@Override
	public java.lang.String getJl_zbj() {
		return _projectProfile.getJl_zbj();
	}

	/**
	* Sets the jl_zbj of this project profile.
	*
	* @param jl_zbj the jl_zbj of this project profile
	*/
	@Override
	public void setJl_zbj(java.lang.String jl_zbj) {
		_projectProfile.setJl_zbj(jl_zbj);
	}

	/**
	* Returns the jl_zzdj of this project profile.
	*
	* @return the jl_zzdj of this project profile
	*/
	@Override
	public java.lang.String getJl_zzdj() {
		return _projectProfile.getJl_zzdj();
	}

	/**
	* Sets the jl_zzdj of this project profile.
	*
	* @param jl_zzdj the jl_zzdj of this project profile
	*/
	@Override
	public void setJl_zzdj(java.lang.String jl_zzdj) {
		_projectProfile.setJl_zzdj(jl_zzdj);
	}

	/**
	* Returns the jl_zzdjzsbh of this project profile.
	*
	* @return the jl_zzdjzsbh of this project profile
	*/
	@Override
	public java.lang.String getJl_zzdjzsbh() {
		return _projectProfile.getJl_zzdjzsbh();
	}

	/**
	* Sets the jl_zzdjzsbh of this project profile.
	*
	* @param jl_zzdjzsbh the jl_zzdjzsbh of this project profile
	*/
	@Override
	public void setJl_zzdjzsbh(java.lang.String jl_zzdjzsbh) {
		_projectProfile.setJl_zzdjzsbh(jl_zzdjzsbh);
	}

	/**
	* Returns the jl_zj of this project profile.
	*
	* @return the jl_zj of this project profile
	*/
	@Override
	public java.lang.String getJl_zj() {
		return _projectProfile.getJl_zj();
	}

	/**
	* Sets the jl_zj of this project profile.
	*
	* @param jl_zj the jl_zj of this project profile
	*/
	@Override
	public void setJl_zj(java.lang.String jl_zj) {
		_projectProfile.setJl_zj(jl_zj);
	}

	/**
	* Returns the jl_zjzsbh of this project profile.
	*
	* @return the jl_zjzsbh of this project profile
	*/
	@Override
	public java.lang.String getJl_zjzsbh() {
		return _projectProfile.getJl_zjzsbh();
	}

	/**
	* Sets the jl_zjzsbh of this project profile.
	*
	* @param jl_zjzsbh the jl_zjzsbh of this project profile
	*/
	@Override
	public void setJl_zjzsbh(java.lang.String jl_zjzsbh) {
		_projectProfile.setJl_zjzsbh(jl_zjzsbh);
	}

	/**
	* Returns the zysgdw of this project profile.
	*
	* @return the zysgdw of this project profile
	*/
	@Override
	public java.lang.String getZysgdw() {
		return _projectProfile.getZysgdw();
	}

	/**
	* Sets the zysgdw of this project profile.
	*
	* @param zysgdw the zysgdw of this project profile
	*/
	@Override
	public void setZysgdw(java.lang.String zysgdw) {
		_projectProfile.setZysgdw(zysgdw);
	}

	/**
	* Returns the sg_zbfs of this project profile.
	*
	* @return the sg_zbfs of this project profile
	*/
	@Override
	public java.lang.String getSg_zbfs() {
		return _projectProfile.getSg_zbfs();
	}

	/**
	* Sets the sg_zbfs of this project profile.
	*
	* @param sg_zbfs the sg_zbfs of this project profile
	*/
	@Override
	public void setSg_zbfs(java.lang.String sg_zbfs) {
		_projectProfile.setSg_zbfs(sg_zbfs);
	}

	/**
	* Returns the sg_zbj of this project profile.
	*
	* @return the sg_zbj of this project profile
	*/
	@Override
	public java.lang.String getSg_zbj() {
		return _projectProfile.getSg_zbj();
	}

	/**
	* Sets the sg_zbj of this project profile.
	*
	* @param sg_zbj the sg_zbj of this project profile
	*/
	@Override
	public void setSg_zbj(java.lang.String sg_zbj) {
		_projectProfile.setSg_zbj(sg_zbj);
	}

	/**
	* Returns the sg_zzdj of this project profile.
	*
	* @return the sg_zzdj of this project profile
	*/
	@Override
	public java.lang.String getSg_zzdj() {
		return _projectProfile.getSg_zzdj();
	}

	/**
	* Sets the sg_zzdj of this project profile.
	*
	* @param sg_zzdj the sg_zzdj of this project profile
	*/
	@Override
	public void setSg_zzdj(java.lang.String sg_zzdj) {
		_projectProfile.setSg_zzdj(sg_zzdj);
	}

	/**
	* Returns the sg_zzdjzsbh of this project profile.
	*
	* @return the sg_zzdjzsbh of this project profile
	*/
	@Override
	public java.lang.String getSg_zzdjzsbh() {
		return _projectProfile.getSg_zzdjzsbh();
	}

	/**
	* Sets the sg_zzdjzsbh of this project profile.
	*
	* @param sg_zzdjzsbh the sg_zzdjzsbh of this project profile
	*/
	@Override
	public void setSg_zzdjzsbh(java.lang.String sg_zzdjzsbh) {
		_projectProfile.setSg_zzdjzsbh(sg_zzdjzsbh);
	}

	/**
	* Returns the sg_xmjl of this project profile.
	*
	* @return the sg_xmjl of this project profile
	*/
	@Override
	public java.lang.String getSg_xmjl() {
		return _projectProfile.getSg_xmjl();
	}

	/**
	* Sets the sg_xmjl of this project profile.
	*
	* @param sg_xmjl the sg_xmjl of this project profile
	*/
	@Override
	public void setSg_xmjl(java.lang.String sg_xmjl) {
		_projectProfile.setSg_xmjl(sg_xmjl);
	}

	/**
	* Returns the sg_xmjlzsbh of this project profile.
	*
	* @return the sg_xmjlzsbh of this project profile
	*/
	@Override
	public java.lang.String getSg_xmjlzsbh() {
		return _projectProfile.getSg_xmjlzsbh();
	}

	/**
	* Sets the sg_xmjlzsbh of this project profile.
	*
	* @param sg_xmjlzsbh the sg_xmjlzsbh of this project profile
	*/
	@Override
	public void setSg_xmjlzsbh(java.lang.String sg_xmjlzsbh) {
		_projectProfile.setSg_xmjlzsbh(sg_xmjlzsbh);
	}

	/**
	* Returns the jszjjhlsqk of this project profile.
	*
	* @return the jszjjhlsqk of this project profile
	*/
	@Override
	public java.lang.String getJszjjhlsqk() {
		return _projectProfile.getJszjjhlsqk();
	}

	/**
	* Sets the jszjjhlsqk of this project profile.
	*
	* @param jszjjhlsqk the jszjjhlsqk of this project profile
	*/
	@Override
	public void setJszjjhlsqk(java.lang.String jszjjhlsqk) {
		_projectProfile.setJszjjhlsqk(jszjjhlsqk);
	}

	/**
	* Returns the dcqwcqk of this project profile.
	*
	* @return the dcqwcqk of this project profile
	*/
	@Override
	public java.lang.String getDcqwcqk() {
		return _projectProfile.getDcqwcqk();
	}

	/**
	* Sets the dcqwcqk of this project profile.
	*
	* @param dcqwcqk the dcqwcqk of this project profile
	*/
	@Override
	public void setDcqwcqk(java.lang.String dcqwcqk) {
		_projectProfile.setDcqwcqk(dcqwcqk);
	}

	/**
	* Returns the sgzbqk of this project profile.
	*
	* @return the sgzbqk of this project profile
	*/
	@Override
	public java.lang.String getSgzbqk() {
		return _projectProfile.getSgzbqk();
	}

	/**
	* Sets the sgzbqk of this project profile.
	*
	* @param sgzbqk the sgzbqk of this project profile
	*/
	@Override
	public void setSgzbqk(java.lang.String sgzbqk) {
		_projectProfile.setSgzbqk(sgzbqk);
	}

	/**
	* Returns the sytdxgwj of this project profile.
	*
	* @return the sytdxgwj of this project profile
	*/
	@Override
	public java.lang.String getSytdxgwj() {
		return _projectProfile.getSytdxgwj();
	}

	/**
	* Sets the sytdxgwj of this project profile.
	*
	* @param sytdxgwj the sytdxgwj of this project profile
	*/
	@Override
	public void setSytdxgwj(java.lang.String sytdxgwj) {
		_projectProfile.setSytdxgwj(sytdxgwj);
	}

	/**
	* Returns the gczljddjqk of this project profile.
	*
	* @return the gczljddjqk of this project profile
	*/
	@Override
	public java.lang.String getGczljddjqk() {
		return _projectProfile.getGczljddjqk();
	}

	/**
	* Sets the gczljddjqk of this project profile.
	*
	* @param gczljddjqk the gczljddjqk of this project profile
	*/
	@Override
	public void setGczljddjqk(java.lang.String gczljddjqk) {
		_projectProfile.setGczljddjqk(gczljddjqk);
	}

	@Override
	public boolean isNew() {
		return _projectProfile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_projectProfile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _projectProfile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectProfile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _projectProfile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _projectProfile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_projectProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _projectProfile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_projectProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_projectProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_projectProfile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectProfileWrapper((ProjectProfile)_projectProfile.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile) {
		return _projectProfile.compareTo(projectProfile);
	}

	@Override
	public int hashCode() {
		return _projectProfile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.permit.model.ProjectProfile> toCacheModel() {
		return _projectProfile.toCacheModel();
	}

	@Override
	public com.justonetech.cp.permit.model.ProjectProfile toEscapedModel() {
		return new ProjectProfileWrapper(_projectProfile.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.permit.model.ProjectProfile toUnescapedModel() {
		return new ProjectProfileWrapper(_projectProfile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _projectProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectProfile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectProfile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectProfileWrapper)) {
			return false;
		}

		ProjectProfileWrapper projectProfileWrapper = (ProjectProfileWrapper)obj;

		if (Validator.equals(_projectProfile,
					projectProfileWrapper._projectProfile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProjectProfile getWrappedProjectProfile() {
		return _projectProfile;
	}

	@Override
	public ProjectProfile getWrappedModel() {
		return _projectProfile;
	}

	@Override
	public void resetOriginalValues() {
		_projectProfile.resetOriginalValues();
	}

	private ProjectProfile _projectProfile;
}