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

import com.justonetech.cp.permit.service.ClpSerializer;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class ProjectProfileClp extends BaseModelImpl<ProjectProfile>
	implements ProjectProfile {
	public ProjectProfileClp() {
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
	public long getPrimaryKey() {
		return _permitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPermitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _permitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("gls", getGls());
		attributes.put("jzmj", getJzmj());
		attributes.put("qlsl", getQlsl());
		attributes.put("qlkd", getQlkd());
		attributes.put("guijiaosl", getGuijiaosl());
		attributes.put("sdsl", getSdsl());
		attributes.put("gaojiasl", getGaojiasl());
		attributes.put("zgj", getZgj());
		attributes.put("zsqxks", getZsqxks());
		attributes.put("zsqxjs", getZsqxjs());
		attributes.put("cnsx", getCnsx());
		attributes.put("tzly", getTzly());
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
		attributes.put("sj_xmfzrzsbh", getSj_xmfzrzsbh());
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

		String gls = (String)attributes.get("gls");

		if (gls != null) {
			setGls(gls);
		}

		String jzmj = (String)attributes.get("jzmj");

		if (jzmj != null) {
			setJzmj(jzmj);
		}

		Integer qlsl = (Integer)attributes.get("qlsl");

		if (qlsl != null) {
			setQlsl(qlsl);
		}

		String qlkd = (String)attributes.get("qlkd");

		if (qlkd != null) {
			setQlkd(qlkd);
		}

		Integer guijiaosl = (Integer)attributes.get("guijiaosl");

		if (guijiaosl != null) {
			setGuijiaosl(guijiaosl);
		}

		Integer sdsl = (Integer)attributes.get("sdsl");

		if (sdsl != null) {
			setSdsl(sdsl);
		}

		Integer gaojiasl = (Integer)attributes.get("gaojiasl");

		if (gaojiasl != null) {
			setGaojiasl(gaojiasl);
		}

		String zgj = (String)attributes.get("zgj");

		if (zgj != null) {
			setZgj(zgj);
		}

		Date zsqxks = (Date)attributes.get("zsqxks");

		if (zsqxks != null) {
			setZsqxks(zsqxks);
		}

		Date zsqxjs = (Date)attributes.get("zsqxjs");

		if (zsqxjs != null) {
			setZsqxjs(zsqxjs);
		}

		String cnsx = (String)attributes.get("cnsx");

		if (cnsx != null) {
			setCnsx(cnsx);
		}

		String tzly = (String)attributes.get("tzly");

		if (tzly != null) {
			setTzly(tzly);
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

		String sj_xmfzrzsbh = (String)attributes.get("sj_xmfzrzsbh");

		if (sj_xmfzrzsbh != null) {
			setSj_xmfzrzsbh(sj_xmfzrzsbh);
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

	@Override
	public long getPermitId() {
		return _permitId;
	}

	@Override
	public void setPermitId(long permitId) {
		_permitId = permitId;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitId", long.class);

				method.invoke(_projectProfileRemoteModel, permitId);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_projectProfileRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwmc() {
		return _jsdwmc;
	}

	@Override
	public void setJsdwmc(String jsdwmc) {
		_jsdwmc = jsdwmc;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwmc", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwmc);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwxz", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwxz);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwdz", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwdz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGcmc() {
		return _gcmc;
	}

	@Override
	public void setGcmc(String gcmc) {
		_gcmc = gcmc;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGcmc", String.class);

				method.invoke(_projectProfileRemoteModel, gcmc);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdd", String.class);

				method.invoke(_projectProfileRemoteModel, jsdd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsgcgm() {
		return _jsgcgm;
	}

	@Override
	public void setJsgcgm(String jsgcgm) {
		_jsgcgm = jsgcgm;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgcgm", String.class);

				method.invoke(_projectProfileRemoteModel, jsgcgm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFwjzmj() {
		return _fwjzmj;
	}

	@Override
	public void setFwjzmj(String fwjzmj) {
		_fwjzmj = fwjzmj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFwjzmj", String.class);

				method.invoke(_projectProfileRemoteModel, fwjzmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtjg() {
		return _htjg;
	}

	@Override
	public void setHtjg(String htjg) {
		_htjg = htjg;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setHtjg", String.class);

				method.invoke(_projectProfileRemoteModel, htjg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHtgq() {
		return _htgq;
	}

	@Override
	public void setHtgq(int htgq) {
		_htgq = htgq;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setHtgq", int.class);

				method.invoke(_projectProfileRemoteModel, htgq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFddbr() {
		return _fddbr;
	}

	@Override
	public void setFddbr(String fddbr) {
		_fddbr = fddbr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFddbr", String.class);

				method.invoke(_projectProfileRemoteModel, fddbr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwlxdh() {
		return _jsdwlxdh;
	}

	@Override
	public void setJsdwlxdh(String jsdwlxdh) {
		_jsdwlxdh = jsdwlxdh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwlxdh", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwlxdh);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwlxr", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwlxr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsdwsjh() {
		return _jsdwsjh;
	}

	@Override
	public void setJsdwsjh(String jsdwsjh) {
		_jsdwsjh = jsdwsjh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsdwsjh", String.class);

				method.invoke(_projectProfileRemoteModel, jsdwsjh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsgcghxkzbh() {
		return _jsgcghxkzbh;
	}

	@Override
	public void setJsgcghxkzbh(String jsgcghxkzbh) {
		_jsgcghxkzbh = jsgcghxkzbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgcghxkzbh", String.class);

				method.invoke(_projectProfileRemoteModel, jsgcghxkzbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXckgqk() {
		return _xckgqk;
	}

	@Override
	public void setXckgqk(String xckgqk) {
		_xckgqk = xckgqk;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXckgqk", String.class);

				method.invoke(_projectProfileRemoteModel, xckgqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXmlx() {
		return _xmlx;
	}

	@Override
	public void setXmlx(long xmlx) {
		_xmlx = xmlx;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXmlx", long.class);

				method.invoke(_projectProfileRemoteModel, xmlx);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLxjb", String.class);

				method.invoke(_projectProfileRemoteModel, lxjb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXmxz() {
		return _xmxz;
	}

	@Override
	public void setXmxz(long xmxz) {
		_xmxz = xmxz;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXmxz", long.class);

				method.invoke(_projectProfileRemoteModel, xmxz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSsqx() {
		return _ssqx;
	}

	@Override
	public void setSsqx(String ssqx) {
		_ssqx = ssqx;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSsqx", String.class);

				method.invoke(_projectProfileRemoteModel, ssqx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYwbm() {
		return _ywbm;
	}

	@Override
	public void setYwbm(String ywbm) {
		_ywbm = ywbm;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYwbm", String.class);

				method.invoke(_projectProfileRemoteModel, ywbm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJsddssqx() {
		return _jsddssqx;
	}

	@Override
	public void setJsddssqx(long jsddssqx) {
		_jsddssqx = jsddssqx;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsddssqx", long.class);

				method.invoke(_projectProfileRemoteModel, jsddssqx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJsgclb() {
		return _jsgclb;
	}

	@Override
	public void setJsgclb(String jsgclb) {
		_jsgclb = jsgclb;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgclb", String.class);

				method.invoke(_projectProfileRemoteModel, jsgclb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJsgcsx() {
		return _jsgcsx;
	}

	@Override
	public void setJsgcsx(long jsgcsx) {
		_jsgcsx = jsgcsx;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsgcsx", long.class);

				method.invoke(_projectProfileRemoteModel, jsgcsx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGyzjbz() {
		return _gyzjbz;
	}

	@Override
	public void setGyzjbz(String gyzjbz) {
		_gyzjbz = gyzjbz;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGyzjbz", String.class);

				method.invoke(_projectProfileRemoteModel, gyzjbz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZbjg() {
		return _zbjg;
	}

	@Override
	public void setZbjg(String zbjg) {
		_zbjg = zbjg;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setZbjg", String.class);

				method.invoke(_projectProfileRemoteModel, zbjg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmtzgs() {
		return _xmtzgs;
	}

	@Override
	public void setXmtzgs(String xmtzgs) {
		_xmtzgs = xmtzgs;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXmtzgs", String.class);

				method.invoke(_projectProfileRemoteModel, xmtzgs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJhkg() {
		return _jhkg;
	}

	@Override
	public void setJhkg(Date jhkg) {
		_jhkg = jhkg;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJhkg", Date.class);

				method.invoke(_projectProfileRemoteModel, jhkg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJhjg() {
		return _jhjg;
	}

	@Override
	public void setJhjg(Date jhjg) {
		_jhjg = jhjg;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJhjg", Date.class);

				method.invoke(_projectProfileRemoteModel, jhjg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSfzftzl() {
		return _sfzftzl;
	}

	@Override
	public boolean isSfzftzl() {
		return _sfzftzl;
	}

	@Override
	public void setSfzftzl(boolean sfzftzl) {
		_sfzftzl = sfzftzl;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSfzftzl", boolean.class);

				method.invoke(_projectProfileRemoteModel, sfzftzl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYzzpl1() {
		return _yzzpl1;
	}

	@Override
	public void setYzzpl1(String yzzpl1) {
		_yzzpl1 = yzzpl1;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYzzpl1", String.class);

				method.invoke(_projectProfileRemoteModel, yzzpl1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYzzpl2() {
		return _yzzpl2;
	}

	@Override
	public void setYzzpl2(String yzzpl2) {
		_yzzpl2 = yzzpl2;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYzzpl2", String.class);

				method.invoke(_projectProfileRemoteModel, yzzpl2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYzzpl3() {
		return _yzzpl3;
	}

	@Override
	public void setYzzpl3(String yzzpl3) {
		_yzzpl3 = yzzpl3;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYzzpl3", String.class);

				method.invoke(_projectProfileRemoteModel, yzzpl3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYzzpl4() {
		return _yzzpl4;
	}

	@Override
	public void setYzzpl4(String yzzpl4) {
		_yzzpl4 = yzzpl4;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYzzpl4", String.class);

				method.invoke(_projectProfileRemoteModel, yzzpl4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTjsj() {
		return _tjsj;
	}

	@Override
	public void setTjsj(Date tjsj) {
		_tjsj = tjsj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTjsj", Date.class);

				method.invoke(_projectProfileRemoteModel, tjsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGcnr() {
		return _gcnr;
	}

	@Override
	public void setGcnr(String gcnr) {
		_gcnr = gcnr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGcnr", String.class);

				method.invoke(_projectProfileRemoteModel, gcnr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgxkzsbz() {
		return _sgxkzsbz;
	}

	@Override
	public void setSgxkzsbz(String sgxkzsbz) {
		_sgxkzsbz = sgxkzsbz;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSgxkzsbz", String.class);

				method.invoke(_projectProfileRemoteModel, sgxkzsbz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGls() {
		return _gls;
	}

	@Override
	public void setGls(String gls) {
		_gls = gls;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGls", String.class);

				method.invoke(_projectProfileRemoteModel, gls);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJzmj() {
		return _jzmj;
	}

	@Override
	public void setJzmj(String jzmj) {
		_jzmj = jzmj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJzmj", String.class);

				method.invoke(_projectProfileRemoteModel, jzmj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQlsl() {
		return _qlsl;
	}

	@Override
	public void setQlsl(int qlsl) {
		_qlsl = qlsl;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setQlsl", int.class);

				method.invoke(_projectProfileRemoteModel, qlsl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQlkd() {
		return _qlkd;
	}

	@Override
	public void setQlkd(String qlkd) {
		_qlkd = qlkd;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setQlkd", String.class);

				method.invoke(_projectProfileRemoteModel, qlkd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGuijiaosl() {
		return _guijiaosl;
	}

	@Override
	public void setGuijiaosl(int guijiaosl) {
		_guijiaosl = guijiaosl;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGuijiaosl", int.class);

				method.invoke(_projectProfileRemoteModel, guijiaosl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSdsl() {
		return _sdsl;
	}

	@Override
	public void setSdsl(int sdsl) {
		_sdsl = sdsl;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSdsl", int.class);

				method.invoke(_projectProfileRemoteModel, sdsl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGaojiasl() {
		return _gaojiasl;
	}

	@Override
	public void setGaojiasl(int gaojiasl) {
		_gaojiasl = gaojiasl;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGaojiasl", int.class);

				method.invoke(_projectProfileRemoteModel, gaojiasl);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setZgj", String.class);

				method.invoke(_projectProfileRemoteModel, zgj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getZsqxks() {
		return _zsqxks;
	}

	@Override
	public void setZsqxks(Date zsqxks) {
		_zsqxks = zsqxks;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setZsqxks", Date.class);

				method.invoke(_projectProfileRemoteModel, zsqxks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getZsqxjs() {
		return _zsqxjs;
	}

	@Override
	public void setZsqxjs(Date zsqxjs) {
		_zsqxjs = zsqxjs;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setZsqxjs", Date.class);

				method.invoke(_projectProfileRemoteModel, zsqxjs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCnsx() {
		return _cnsx;
	}

	@Override
	public void setCnsx(String cnsx) {
		_cnsx = cnsx;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCnsx", String.class);

				method.invoke(_projectProfileRemoteModel, cnsx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTzly() {
		return _tzly;
	}

	@Override
	public void setTzly(String tzly) {
		_tzly = tzly;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTzly", String.class);

				method.invoke(_projectProfileRemoteModel, tzly);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGkpzhhzjghwh() {
		return _gkpzhhzjghwh;
	}

	@Override
	public void setGkpzhhzjghwh(String gkpzhhzjghwh) {
		_gkpzhhzjghwh = gkpzhhzjghwh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGkpzhhzjghwh", String.class);

				method.invoke(_projectProfileRemoteModel, gkpzhhzjghwh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPfhhzrq() {
		return _pfhhzrq;
	}

	@Override
	public void setPfhhzrq(Date pfhhzrq) {
		_pfhhzrq = pfhhzrq;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setPfhhzrq", Date.class);

				method.invoke(_projectProfileRemoteModel, pfhhzrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCbsjpzjghwh() {
		return _cbsjpzjghwh;
	}

	@Override
	public void setCbsjpzjghwh(String cbsjpzjghwh) {
		_cbsjpzjghwh = cbsjpzjghwh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCbsjpzjghwh", String.class);

				method.invoke(_projectProfileRemoteModel, cbsjpzjghwh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPfrq() {
		return _pfrq;
	}

	@Override
	public void setPfrq(Date pfrq) {
		_pfrq = pfrq;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setPfrq", Date.class);

				method.invoke(_projectProfileRemoteModel, pfrq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPfgq() {
		return _pfgq;
	}

	@Override
	public void setPfgq(int pfgq) {
		_pfgq = pfgq;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setPfgq", int.class);

				method.invoke(_projectProfileRemoteModel, pfgq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPzjghwh() {
		return _pzjghwh;
	}

	@Override
	public void setPzjghwh(String pzjghwh) {
		_pzjghwh = pzjghwh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setPzjghwh", String.class);

				method.invoke(_projectProfileRemoteModel, pzjghwh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmdw() {
		return _xmdw;
	}

	@Override
	public void setXmdw(String xmdw) {
		_xmdw = xmdw;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXmdw", String.class);

				method.invoke(_projectProfileRemoteModel, xmdw);
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

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfzr", String.class);

				method.invoke(_projectProfileRemoteModel, xmfzr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXmfzrlxdh() {
		return _xmfzrlxdh;
	}

	@Override
	public void setXmfzrlxdh(String xmfzrlxdh) {
		_xmfzrlxdh = xmfzrlxdh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setXmfzrlxdh", String.class);

				method.invoke(_projectProfileRemoteModel, xmfzrlxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZysjdw() {
		return _zysjdw;
	}

	@Override
	public void setZysjdw(String zysjdw) {
		_zysjdw = zysjdw;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setZysjdw", String.class);

				method.invoke(_projectProfileRemoteModel, zysjdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSj_zbfs() {
		return _sj_zbfs;
	}

	@Override
	public void setSj_zbfs(String sj_zbfs) {
		_sj_zbfs = sj_zbfs;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSj_zbfs", String.class);

				method.invoke(_projectProfileRemoteModel, sj_zbfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSj_zbj() {
		return _sj_zbj;
	}

	@Override
	public void setSj_zbj(String sj_zbj) {
		_sj_zbj = sj_zbj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSj_zbj", String.class);

				method.invoke(_projectProfileRemoteModel, sj_zbj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSj_zzdj() {
		return _sj_zzdj;
	}

	@Override
	public void setSj_zzdj(String sj_zzdj) {
		_sj_zzdj = sj_zzdj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSj_zzdj", String.class);

				method.invoke(_projectProfileRemoteModel, sj_zzdj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSj_zzdjzsbh() {
		return _sj_zzdjzsbh;
	}

	@Override
	public void setSj_zzdjzsbh(String sj_zzdjzsbh) {
		_sj_zzdjzsbh = sj_zzdjzsbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSj_zzdjzsbh", String.class);

				method.invoke(_projectProfileRemoteModel, sj_zzdjzsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSj_xmfzr() {
		return _sj_xmfzr;
	}

	@Override
	public void setSj_xmfzr(String sj_xmfzr) {
		_sj_xmfzr = sj_xmfzr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSj_xmfzr", String.class);

				method.invoke(_projectProfileRemoteModel, sj_xmfzr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSj_xmfzrzsbh() {
		return _sj_xmfzrzsbh;
	}

	@Override
	public void setSj_xmfzrzsbh(String sj_xmfzrzsbh) {
		_sj_xmfzrzsbh = sj_xmfzrzsbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSj_xmfzrzsbh", String.class);

				method.invoke(_projectProfileRemoteModel, sj_xmfzrzsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZyjldw() {
		return _zyjldw;
	}

	@Override
	public void setZyjldw(String zyjldw) {
		_zyjldw = zyjldw;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setZyjldw", String.class);

				method.invoke(_projectProfileRemoteModel, zyjldw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJl_zbfs() {
		return _jl_zbfs;
	}

	@Override
	public void setJl_zbfs(String jl_zbfs) {
		_jl_zbfs = jl_zbfs;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJl_zbfs", String.class);

				method.invoke(_projectProfileRemoteModel, jl_zbfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJl_zbj() {
		return _jl_zbj;
	}

	@Override
	public void setJl_zbj(String jl_zbj) {
		_jl_zbj = jl_zbj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJl_zbj", String.class);

				method.invoke(_projectProfileRemoteModel, jl_zbj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJl_zzdj() {
		return _jl_zzdj;
	}

	@Override
	public void setJl_zzdj(String jl_zzdj) {
		_jl_zzdj = jl_zzdj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJl_zzdj", String.class);

				method.invoke(_projectProfileRemoteModel, jl_zzdj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJl_zzdjzsbh() {
		return _jl_zzdjzsbh;
	}

	@Override
	public void setJl_zzdjzsbh(String jl_zzdjzsbh) {
		_jl_zzdjzsbh = jl_zzdjzsbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJl_zzdjzsbh", String.class);

				method.invoke(_projectProfileRemoteModel, jl_zzdjzsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJl_zj() {
		return _jl_zj;
	}

	@Override
	public void setJl_zj(String jl_zj) {
		_jl_zj = jl_zj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJl_zj", String.class);

				method.invoke(_projectProfileRemoteModel, jl_zj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJl_zjzsbh() {
		return _jl_zjzsbh;
	}

	@Override
	public void setJl_zjzsbh(String jl_zjzsbh) {
		_jl_zjzsbh = jl_zjzsbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJl_zjzsbh", String.class);

				method.invoke(_projectProfileRemoteModel, jl_zjzsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZysgdw() {
		return _zysgdw;
	}

	@Override
	public void setZysgdw(String zysgdw) {
		_zysgdw = zysgdw;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setZysgdw", String.class);

				method.invoke(_projectProfileRemoteModel, zysgdw);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSg_zbfs() {
		return _sg_zbfs;
	}

	@Override
	public void setSg_zbfs(String sg_zbfs) {
		_sg_zbfs = sg_zbfs;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSg_zbfs", String.class);

				method.invoke(_projectProfileRemoteModel, sg_zbfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSg_zbj() {
		return _sg_zbj;
	}

	@Override
	public void setSg_zbj(String sg_zbj) {
		_sg_zbj = sg_zbj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSg_zbj", String.class);

				method.invoke(_projectProfileRemoteModel, sg_zbj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSg_zzdj() {
		return _sg_zzdj;
	}

	@Override
	public void setSg_zzdj(String sg_zzdj) {
		_sg_zzdj = sg_zzdj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSg_zzdj", String.class);

				method.invoke(_projectProfileRemoteModel, sg_zzdj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSg_zzdjzsbh() {
		return _sg_zzdjzsbh;
	}

	@Override
	public void setSg_zzdjzsbh(String sg_zzdjzsbh) {
		_sg_zzdjzsbh = sg_zzdjzsbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSg_zzdjzsbh", String.class);

				method.invoke(_projectProfileRemoteModel, sg_zzdjzsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSg_xmjl() {
		return _sg_xmjl;
	}

	@Override
	public void setSg_xmjl(String sg_xmjl) {
		_sg_xmjl = sg_xmjl;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSg_xmjl", String.class);

				method.invoke(_projectProfileRemoteModel, sg_xmjl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSg_xmjlzsbh() {
		return _sg_xmjlzsbh;
	}

	@Override
	public void setSg_xmjlzsbh(String sg_xmjlzsbh) {
		_sg_xmjlzsbh = sg_xmjlzsbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSg_xmjlzsbh", String.class);

				method.invoke(_projectProfileRemoteModel, sg_xmjlzsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJszjjhlsqk() {
		return _jszjjhlsqk;
	}

	@Override
	public void setJszjjhlsqk(String jszjjhlsqk) {
		_jszjjhlsqk = jszjjhlsqk;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJszjjhlsqk", String.class);

				method.invoke(_projectProfileRemoteModel, jszjjhlsqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDcqwcqk() {
		return _dcqwcqk;
	}

	@Override
	public void setDcqwcqk(String dcqwcqk) {
		_dcqwcqk = dcqwcqk;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setDcqwcqk", String.class);

				method.invoke(_projectProfileRemoteModel, dcqwcqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgzbqk() {
		return _sgzbqk;
	}

	@Override
	public void setSgzbqk(String sgzbqk) {
		_sgzbqk = sgzbqk;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSgzbqk", String.class);

				method.invoke(_projectProfileRemoteModel, sgzbqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSytdxgwj() {
		return _sytdxgwj;
	}

	@Override
	public void setSytdxgwj(String sytdxgwj) {
		_sytdxgwj = sytdxgwj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSytdxgwj", String.class);

				method.invoke(_projectProfileRemoteModel, sytdxgwj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGczljddjqk() {
		return _gczljddjqk;
	}

	@Override
	public void setGczljddjqk(String gczljddjqk) {
		_gczljddjqk = gczljddjqk;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGczljddjqk", String.class);

				method.invoke(_projectProfileRemoteModel, gczljddjqk);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProjectProfileRemoteModel() {
		return _projectProfileRemoteModel;
	}

	public void setProjectProfileRemoteModel(
		BaseModel<?> projectProfileRemoteModel) {
		_projectProfileRemoteModel = projectProfileRemoteModel;
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

		Class<?> remoteModelClass = _projectProfileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_projectProfileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProjectProfileLocalServiceUtil.addProjectProfile(this);
		}
		else {
			ProjectProfileLocalServiceUtil.updateProjectProfile(this);
		}
	}

	@Override
	public ProjectProfile toEscapedModel() {
		return (ProjectProfile)ProxyUtil.newProxyInstance(ProjectProfile.class.getClassLoader(),
			new Class[] { ProjectProfile.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProjectProfileClp clone = new ProjectProfileClp();

		clone.setPermitId(getPermitId());
		clone.setBjbh(getBjbh());
		clone.setJsdwmc(getJsdwmc());
		clone.setJsdwxz(getJsdwxz());
		clone.setJsdwdz(getJsdwdz());
		clone.setGcmc(getGcmc());
		clone.setJsdd(getJsdd());
		clone.setJsgcgm(getJsgcgm());
		clone.setFwjzmj(getFwjzmj());
		clone.setHtjg(getHtjg());
		clone.setHtgq(getHtgq());
		clone.setFddbr(getFddbr());
		clone.setJsdwlxdh(getJsdwlxdh());
		clone.setJsdwlxr(getJsdwlxr());
		clone.setJsdwsjh(getJsdwsjh());
		clone.setJsgcghxkzbh(getJsgcghxkzbh());
		clone.setXckgqk(getXckgqk());
		clone.setXmlx(getXmlx());
		clone.setLxjb(getLxjb());
		clone.setXmxz(getXmxz());
		clone.setSsqx(getSsqx());
		clone.setYwbm(getYwbm());
		clone.setJsddssqx(getJsddssqx());
		clone.setJsgclb(getJsgclb());
		clone.setJsgcsx(getJsgcsx());
		clone.setGyzjbz(getGyzjbz());
		clone.setZbjg(getZbjg());
		clone.setXmtzgs(getXmtzgs());
		clone.setJhkg(getJhkg());
		clone.setJhjg(getJhjg());
		clone.setSfzftzl(getSfzftzl());
		clone.setYzzpl1(getYzzpl1());
		clone.setYzzpl2(getYzzpl2());
		clone.setYzzpl3(getYzzpl3());
		clone.setYzzpl4(getYzzpl4());
		clone.setTjsj(getTjsj());
		clone.setGcnr(getGcnr());
		clone.setSgxkzsbz(getSgxkzsbz());
		clone.setGls(getGls());
		clone.setJzmj(getJzmj());
		clone.setQlsl(getQlsl());
		clone.setQlkd(getQlkd());
		clone.setGuijiaosl(getGuijiaosl());
		clone.setSdsl(getSdsl());
		clone.setGaojiasl(getGaojiasl());
		clone.setZgj(getZgj());
		clone.setZsqxks(getZsqxks());
		clone.setZsqxjs(getZsqxjs());
		clone.setCnsx(getCnsx());
		clone.setTzly(getTzly());
		clone.setGkpzhhzjghwh(getGkpzhhzjghwh());
		clone.setPfhhzrq(getPfhhzrq());
		clone.setCbsjpzjghwh(getCbsjpzjghwh());
		clone.setPfrq(getPfrq());
		clone.setPfgq(getPfgq());
		clone.setPzjghwh(getPzjghwh());
		clone.setXmdw(getXmdw());
		clone.setXmfzr(getXmfzr());
		clone.setXmfzrlxdh(getXmfzrlxdh());
		clone.setZysjdw(getZysjdw());
		clone.setSj_zbfs(getSj_zbfs());
		clone.setSj_zbj(getSj_zbj());
		clone.setSj_zzdj(getSj_zzdj());
		clone.setSj_zzdjzsbh(getSj_zzdjzsbh());
		clone.setSj_xmfzr(getSj_xmfzr());
		clone.setSj_xmfzrzsbh(getSj_xmfzrzsbh());
		clone.setZyjldw(getZyjldw());
		clone.setJl_zbfs(getJl_zbfs());
		clone.setJl_zbj(getJl_zbj());
		clone.setJl_zzdj(getJl_zzdj());
		clone.setJl_zzdjzsbh(getJl_zzdjzsbh());
		clone.setJl_zj(getJl_zj());
		clone.setJl_zjzsbh(getJl_zjzsbh());
		clone.setZysgdw(getZysgdw());
		clone.setSg_zbfs(getSg_zbfs());
		clone.setSg_zbj(getSg_zbj());
		clone.setSg_zzdj(getSg_zzdj());
		clone.setSg_zzdjzsbh(getSg_zzdjzsbh());
		clone.setSg_xmjl(getSg_xmjl());
		clone.setSg_xmjlzsbh(getSg_xmjlzsbh());
		clone.setJszjjhlsqk(getJszjjhlsqk());
		clone.setDcqwcqk(getDcqwcqk());
		clone.setSgzbqk(getSgzbqk());
		clone.setSytdxgwj(getSytdxgwj());
		clone.setGczljddjqk(getGczljddjqk());

		return clone;
	}

	@Override
	public int compareTo(ProjectProfile projectProfile) {
		long primaryKey = projectProfile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectProfileClp)) {
			return false;
		}

		ProjectProfileClp projectProfile = (ProjectProfileClp)obj;

		long primaryKey = projectProfile.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(171);

		sb.append("{permitId=");
		sb.append(getPermitId());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", jsdwmc=");
		sb.append(getJsdwmc());
		sb.append(", jsdwxz=");
		sb.append(getJsdwxz());
		sb.append(", jsdwdz=");
		sb.append(getJsdwdz());
		sb.append(", gcmc=");
		sb.append(getGcmc());
		sb.append(", jsdd=");
		sb.append(getJsdd());
		sb.append(", jsgcgm=");
		sb.append(getJsgcgm());
		sb.append(", fwjzmj=");
		sb.append(getFwjzmj());
		sb.append(", htjg=");
		sb.append(getHtjg());
		sb.append(", htgq=");
		sb.append(getHtgq());
		sb.append(", fddbr=");
		sb.append(getFddbr());
		sb.append(", jsdwlxdh=");
		sb.append(getJsdwlxdh());
		sb.append(", jsdwlxr=");
		sb.append(getJsdwlxr());
		sb.append(", jsdwsjh=");
		sb.append(getJsdwsjh());
		sb.append(", jsgcghxkzbh=");
		sb.append(getJsgcghxkzbh());
		sb.append(", xckgqk=");
		sb.append(getXckgqk());
		sb.append(", xmlx=");
		sb.append(getXmlx());
		sb.append(", lxjb=");
		sb.append(getLxjb());
		sb.append(", xmxz=");
		sb.append(getXmxz());
		sb.append(", ssqx=");
		sb.append(getSsqx());
		sb.append(", ywbm=");
		sb.append(getYwbm());
		sb.append(", jsddssqx=");
		sb.append(getJsddssqx());
		sb.append(", jsgclb=");
		sb.append(getJsgclb());
		sb.append(", jsgcsx=");
		sb.append(getJsgcsx());
		sb.append(", gyzjbz=");
		sb.append(getGyzjbz());
		sb.append(", zbjg=");
		sb.append(getZbjg());
		sb.append(", xmtzgs=");
		sb.append(getXmtzgs());
		sb.append(", jhkg=");
		sb.append(getJhkg());
		sb.append(", jhjg=");
		sb.append(getJhjg());
		sb.append(", sfzftzl=");
		sb.append(getSfzftzl());
		sb.append(", yzzpl1=");
		sb.append(getYzzpl1());
		sb.append(", yzzpl2=");
		sb.append(getYzzpl2());
		sb.append(", yzzpl3=");
		sb.append(getYzzpl3());
		sb.append(", yzzpl4=");
		sb.append(getYzzpl4());
		sb.append(", tjsj=");
		sb.append(getTjsj());
		sb.append(", gcnr=");
		sb.append(getGcnr());
		sb.append(", sgxkzsbz=");
		sb.append(getSgxkzsbz());
		sb.append(", gls=");
		sb.append(getGls());
		sb.append(", jzmj=");
		sb.append(getJzmj());
		sb.append(", qlsl=");
		sb.append(getQlsl());
		sb.append(", qlkd=");
		sb.append(getQlkd());
		sb.append(", guijiaosl=");
		sb.append(getGuijiaosl());
		sb.append(", sdsl=");
		sb.append(getSdsl());
		sb.append(", gaojiasl=");
		sb.append(getGaojiasl());
		sb.append(", zgj=");
		sb.append(getZgj());
		sb.append(", zsqxks=");
		sb.append(getZsqxks());
		sb.append(", zsqxjs=");
		sb.append(getZsqxjs());
		sb.append(", cnsx=");
		sb.append(getCnsx());
		sb.append(", tzly=");
		sb.append(getTzly());
		sb.append(", gkpzhhzjghwh=");
		sb.append(getGkpzhhzjghwh());
		sb.append(", pfhhzrq=");
		sb.append(getPfhhzrq());
		sb.append(", cbsjpzjghwh=");
		sb.append(getCbsjpzjghwh());
		sb.append(", pfrq=");
		sb.append(getPfrq());
		sb.append(", pfgq=");
		sb.append(getPfgq());
		sb.append(", pzjghwh=");
		sb.append(getPzjghwh());
		sb.append(", xmdw=");
		sb.append(getXmdw());
		sb.append(", xmfzr=");
		sb.append(getXmfzr());
		sb.append(", xmfzrlxdh=");
		sb.append(getXmfzrlxdh());
		sb.append(", zysjdw=");
		sb.append(getZysjdw());
		sb.append(", sj_zbfs=");
		sb.append(getSj_zbfs());
		sb.append(", sj_zbj=");
		sb.append(getSj_zbj());
		sb.append(", sj_zzdj=");
		sb.append(getSj_zzdj());
		sb.append(", sj_zzdjzsbh=");
		sb.append(getSj_zzdjzsbh());
		sb.append(", sj_xmfzr=");
		sb.append(getSj_xmfzr());
		sb.append(", sj_xmfzrzsbh=");
		sb.append(getSj_xmfzrzsbh());
		sb.append(", zyjldw=");
		sb.append(getZyjldw());
		sb.append(", jl_zbfs=");
		sb.append(getJl_zbfs());
		sb.append(", jl_zbj=");
		sb.append(getJl_zbj());
		sb.append(", jl_zzdj=");
		sb.append(getJl_zzdj());
		sb.append(", jl_zzdjzsbh=");
		sb.append(getJl_zzdjzsbh());
		sb.append(", jl_zj=");
		sb.append(getJl_zj());
		sb.append(", jl_zjzsbh=");
		sb.append(getJl_zjzsbh());
		sb.append(", zysgdw=");
		sb.append(getZysgdw());
		sb.append(", sg_zbfs=");
		sb.append(getSg_zbfs());
		sb.append(", sg_zbj=");
		sb.append(getSg_zbj());
		sb.append(", sg_zzdj=");
		sb.append(getSg_zzdj());
		sb.append(", sg_zzdjzsbh=");
		sb.append(getSg_zzdjzsbh());
		sb.append(", sg_xmjl=");
		sb.append(getSg_xmjl());
		sb.append(", sg_xmjlzsbh=");
		sb.append(getSg_xmjlzsbh());
		sb.append(", jszjjhlsqk=");
		sb.append(getJszjjhlsqk());
		sb.append(", dcqwcqk=");
		sb.append(getDcqwcqk());
		sb.append(", sgzbqk=");
		sb.append(getSgzbqk());
		sb.append(", sytdxgwj=");
		sb.append(getSytdxgwj());
		sb.append(", gczljddjqk=");
		sb.append(getGczljddjqk());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(259);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.permit.model.ProjectProfile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>permitId</column-name><column-value><![CDATA[");
		sb.append(getPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwmc</column-name><column-value><![CDATA[");
		sb.append(getJsdwmc());
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
			"<column><column-name>gcmc</column-name><column-value><![CDATA[");
		sb.append(getGcmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdd</column-name><column-value><![CDATA[");
		sb.append(getJsdd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgcgm</column-name><column-value><![CDATA[");
		sb.append(getJsgcgm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fwjzmj</column-name><column-value><![CDATA[");
		sb.append(getFwjzmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htjg</column-name><column-value><![CDATA[");
		sb.append(getHtjg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htgq</column-name><column-value><![CDATA[");
		sb.append(getHtgq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fddbr</column-name><column-value><![CDATA[");
		sb.append(getFddbr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwlxdh</column-name><column-value><![CDATA[");
		sb.append(getJsdwlxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwlxr</column-name><column-value><![CDATA[");
		sb.append(getJsdwlxr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsdwsjh</column-name><column-value><![CDATA[");
		sb.append(getJsdwsjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgcghxkzbh</column-name><column-value><![CDATA[");
		sb.append(getJsgcghxkzbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xckgqk</column-name><column-value><![CDATA[");
		sb.append(getXckgqk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmlx</column-name><column-value><![CDATA[");
		sb.append(getXmlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lxjb</column-name><column-value><![CDATA[");
		sb.append(getLxjb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmxz</column-name><column-value><![CDATA[");
		sb.append(getXmxz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ssqx</column-name><column-value><![CDATA[");
		sb.append(getSsqx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ywbm</column-name><column-value><![CDATA[");
		sb.append(getYwbm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsddssqx</column-name><column-value><![CDATA[");
		sb.append(getJsddssqx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgclb</column-name><column-value><![CDATA[");
		sb.append(getJsgclb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jsgcsx</column-name><column-value><![CDATA[");
		sb.append(getJsgcsx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gyzjbz</column-name><column-value><![CDATA[");
		sb.append(getGyzjbz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zbjg</column-name><column-value><![CDATA[");
		sb.append(getZbjg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmtzgs</column-name><column-value><![CDATA[");
		sb.append(getXmtzgs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jhkg</column-name><column-value><![CDATA[");
		sb.append(getJhkg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jhjg</column-name><column-value><![CDATA[");
		sb.append(getJhjg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfzftzl</column-name><column-value><![CDATA[");
		sb.append(getSfzftzl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yzzpl1</column-name><column-value><![CDATA[");
		sb.append(getYzzpl1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yzzpl2</column-name><column-value><![CDATA[");
		sb.append(getYzzpl2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yzzpl3</column-name><column-value><![CDATA[");
		sb.append(getYzzpl3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yzzpl4</column-name><column-value><![CDATA[");
		sb.append(getYzzpl4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tjsj</column-name><column-value><![CDATA[");
		sb.append(getTjsj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gcnr</column-name><column-value><![CDATA[");
		sb.append(getGcnr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgxkzsbz</column-name><column-value><![CDATA[");
		sb.append(getSgxkzsbz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gls</column-name><column-value><![CDATA[");
		sb.append(getGls());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jzmj</column-name><column-value><![CDATA[");
		sb.append(getJzmj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qlsl</column-name><column-value><![CDATA[");
		sb.append(getQlsl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qlkd</column-name><column-value><![CDATA[");
		sb.append(getQlkd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>guijiaosl</column-name><column-value><![CDATA[");
		sb.append(getGuijiaosl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sdsl</column-name><column-value><![CDATA[");
		sb.append(getSdsl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gaojiasl</column-name><column-value><![CDATA[");
		sb.append(getGaojiasl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zgj</column-name><column-value><![CDATA[");
		sb.append(getZgj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zsqxks</column-name><column-value><![CDATA[");
		sb.append(getZsqxks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zsqxjs</column-name><column-value><![CDATA[");
		sb.append(getZsqxjs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cnsx</column-name><column-value><![CDATA[");
		sb.append(getCnsx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tzly</column-name><column-value><![CDATA[");
		sb.append(getTzly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gkpzhhzjghwh</column-name><column-value><![CDATA[");
		sb.append(getGkpzhhzjghwh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pfhhzrq</column-name><column-value><![CDATA[");
		sb.append(getPfhhzrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cbsjpzjghwh</column-name><column-value><![CDATA[");
		sb.append(getCbsjpzjghwh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pfrq</column-name><column-value><![CDATA[");
		sb.append(getPfrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pfgq</column-name><column-value><![CDATA[");
		sb.append(getPfgq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pzjghwh</column-name><column-value><![CDATA[");
		sb.append(getPzjghwh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmdw</column-name><column-value><![CDATA[");
		sb.append(getXmdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfzr</column-name><column-value><![CDATA[");
		sb.append(getXmfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfzrlxdh</column-name><column-value><![CDATA[");
		sb.append(getXmfzrlxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zysjdw</column-name><column-value><![CDATA[");
		sb.append(getZysjdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sj_zbfs</column-name><column-value><![CDATA[");
		sb.append(getSj_zbfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sj_zbj</column-name><column-value><![CDATA[");
		sb.append(getSj_zbj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sj_zzdj</column-name><column-value><![CDATA[");
		sb.append(getSj_zzdj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sj_zzdjzsbh</column-name><column-value><![CDATA[");
		sb.append(getSj_zzdjzsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sj_xmfzr</column-name><column-value><![CDATA[");
		sb.append(getSj_xmfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sj_xmfzrzsbh</column-name><column-value><![CDATA[");
		sb.append(getSj_xmfzrzsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zyjldw</column-name><column-value><![CDATA[");
		sb.append(getZyjldw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jl_zbfs</column-name><column-value><![CDATA[");
		sb.append(getJl_zbfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jl_zbj</column-name><column-value><![CDATA[");
		sb.append(getJl_zbj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jl_zzdj</column-name><column-value><![CDATA[");
		sb.append(getJl_zzdj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jl_zzdjzsbh</column-name><column-value><![CDATA[");
		sb.append(getJl_zzdjzsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jl_zj</column-name><column-value><![CDATA[");
		sb.append(getJl_zj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jl_zjzsbh</column-name><column-value><![CDATA[");
		sb.append(getJl_zjzsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zysgdw</column-name><column-value><![CDATA[");
		sb.append(getZysgdw());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sg_zbfs</column-name><column-value><![CDATA[");
		sb.append(getSg_zbfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sg_zbj</column-name><column-value><![CDATA[");
		sb.append(getSg_zbj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sg_zzdj</column-name><column-value><![CDATA[");
		sb.append(getSg_zzdj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sg_zzdjzsbh</column-name><column-value><![CDATA[");
		sb.append(getSg_zzdjzsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sg_xmjl</column-name><column-value><![CDATA[");
		sb.append(getSg_xmjl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sg_xmjlzsbh</column-name><column-value><![CDATA[");
		sb.append(getSg_xmjlzsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jszjjhlsqk</column-name><column-value><![CDATA[");
		sb.append(getJszjjhlsqk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dcqwcqk</column-name><column-value><![CDATA[");
		sb.append(getDcqwcqk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgzbqk</column-name><column-value><![CDATA[");
		sb.append(getSgzbqk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sytdxgwj</column-name><column-value><![CDATA[");
		sb.append(getSytdxgwj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gczljddjqk</column-name><column-value><![CDATA[");
		sb.append(getGczljddjqk());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _projectProfileRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}