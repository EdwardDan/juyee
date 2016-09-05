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
		attributes.put("jsydpzwjhfdccqzbh", getJsydpzwjhfdccqzbh());
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
		attributes.put("slbh", getSlbh());
		attributes.put("hjgsz", getHjgsz());
		attributes.put("hjgsh", getHjgsh());
		attributes.put("sqr", getSqr());
		attributes.put("sqsx", getSqsx());
		attributes.put("sqh", getSqh());
		attributes.put("cltjr", getCltjr());
		attributes.put("cltjrlxdh", getCltjrlxdh());
		attributes.put("cltjrlxdz", getCltjrlxdz());
		attributes.put("sjr", getSjr());
		attributes.put("sjrlxdh", getSjrlxdh());
		attributes.put("slyj", getSlyj());
		attributes.put("slsj", getSlsj());

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

		String jsydpzwjhfdccqzbh = (String)attributes.get("jsydpzwjhfdccqzbh");

		if (jsydpzwjhfdccqzbh != null) {
			setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
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

		String slbh = (String)attributes.get("slbh");

		if (slbh != null) {
			setSlbh(slbh);
		}

		Integer hjgsz = (Integer)attributes.get("hjgsz");

		if (hjgsz != null) {
			setHjgsz(hjgsz);
		}

		Integer hjgsh = (Integer)attributes.get("hjgsh");

		if (hjgsh != null) {
			setHjgsh(hjgsh);
		}

		String sqr = (String)attributes.get("sqr");

		if (sqr != null) {
			setSqr(sqr);
		}

		String sqsx = (String)attributes.get("sqsx");

		if (sqsx != null) {
			setSqsx(sqsx);
		}

		String sqh = (String)attributes.get("sqh");

		if (sqh != null) {
			setSqh(sqh);
		}

		String cltjr = (String)attributes.get("cltjr");

		if (cltjr != null) {
			setCltjr(cltjr);
		}

		String cltjrlxdh = (String)attributes.get("cltjrlxdh");

		if (cltjrlxdh != null) {
			setCltjrlxdh(cltjrlxdh);
		}

		String cltjrlxdz = (String)attributes.get("cltjrlxdz");

		if (cltjrlxdz != null) {
			setCltjrlxdz(cltjrlxdz);
		}

		String sjr = (String)attributes.get("sjr");

		if (sjr != null) {
			setSjr(sjr);
		}

		String sjrlxdh = (String)attributes.get("sjrlxdh");

		if (sjrlxdh != null) {
			setSjrlxdh(sjrlxdh);
		}

		String slyj = (String)attributes.get("slyj");

		if (slyj != null) {
			setSlyj(slyj);
		}

		String slsj = (String)attributes.get("slsj");

		if (slsj != null) {
			setSlsj(slsj);
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
	public String getJsydpzwjhfdccqzbh() {
		return _jsydpzwjhfdccqzbh;
	}

	@Override
	public void setJsydpzwjhfdccqzbh(String jsydpzwjhfdccqzbh) {
		_jsydpzwjhfdccqzbh = jsydpzwjhfdccqzbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setJsydpzwjhfdccqzbh",
						String.class);

				method.invoke(_projectProfileRemoteModel, jsydpzwjhfdccqzbh);
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
	public String getSlbh() {
		return _slbh;
	}

	@Override
	public void setSlbh(String slbh) {
		_slbh = slbh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSlbh", String.class);

				method.invoke(_projectProfileRemoteModel, slbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHjgsz() {
		return _hjgsz;
	}

	@Override
	public void setHjgsz(int hjgsz) {
		_hjgsz = hjgsz;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setHjgsz", int.class);

				method.invoke(_projectProfileRemoteModel, hjgsz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHjgsh() {
		return _hjgsh;
	}

	@Override
	public void setHjgsh(int hjgsh) {
		_hjgsh = hjgsh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setHjgsh", int.class);

				method.invoke(_projectProfileRemoteModel, hjgsh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSqr() {
		return _sqr;
	}

	@Override
	public void setSqr(String sqr) {
		_sqr = sqr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSqr", String.class);

				method.invoke(_projectProfileRemoteModel, sqr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSqsx() {
		return _sqsx;
	}

	@Override
	public void setSqsx(String sqsx) {
		_sqsx = sqsx;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSqsx", String.class);

				method.invoke(_projectProfileRemoteModel, sqsx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSqh() {
		return _sqh;
	}

	@Override
	public void setSqh(String sqh) {
		_sqh = sqh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSqh", String.class);

				method.invoke(_projectProfileRemoteModel, sqh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCltjr() {
		return _cltjr;
	}

	@Override
	public void setCltjr(String cltjr) {
		_cltjr = cltjr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCltjr", String.class);

				method.invoke(_projectProfileRemoteModel, cltjr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCltjrlxdh() {
		return _cltjrlxdh;
	}

	@Override
	public void setCltjrlxdh(String cltjrlxdh) {
		_cltjrlxdh = cltjrlxdh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCltjrlxdh", String.class);

				method.invoke(_projectProfileRemoteModel, cltjrlxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCltjrlxdz() {
		return _cltjrlxdz;
	}

	@Override
	public void setCltjrlxdz(String cltjrlxdz) {
		_cltjrlxdz = cltjrlxdz;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCltjrlxdz", String.class);

				method.invoke(_projectProfileRemoteModel, cltjrlxdz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjr() {
		return _sjr;
	}

	@Override
	public void setSjr(String sjr) {
		_sjr = sjr;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSjr", String.class);

				method.invoke(_projectProfileRemoteModel, sjr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjrlxdh() {
		return _sjrlxdh;
	}

	@Override
	public void setSjrlxdh(String sjrlxdh) {
		_sjrlxdh = sjrlxdh;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSjrlxdh", String.class);

				method.invoke(_projectProfileRemoteModel, sjrlxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSlyj() {
		return _slyj;
	}

	@Override
	public void setSlyj(String slyj) {
		_slyj = slyj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSlyj", String.class);

				method.invoke(_projectProfileRemoteModel, slyj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSlsj() {
		return _slsj;
	}

	@Override
	public void setSlsj(String slsj) {
		_slsj = slsj;

		if (_projectProfileRemoteModel != null) {
			try {
				Class<?> clazz = _projectProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSlsj", String.class);

				method.invoke(_projectProfileRemoteModel, slsj);
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
		clone.setJsydpzwjhfdccqzbh(getJsydpzwjhfdccqzbh());
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
		clone.setSlbh(getSlbh());
		clone.setHjgsz(getHjgsz());
		clone.setHjgsh(getHjgsh());
		clone.setSqr(getSqr());
		clone.setSqsx(getSqsx());
		clone.setSqh(getSqh());
		clone.setCltjr(getCltjr());
		clone.setCltjrlxdh(getCltjrlxdh());
		clone.setCltjrlxdz(getCltjrlxdz());
		clone.setSjr(getSjr());
		clone.setSjrlxdh(getSjrlxdh());
		clone.setSlyj(getSlyj());
		clone.setSlsj(getSlsj());

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
		StringBundler sb = new StringBundler(101);

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
		sb.append(", jsydpzwjhfdccqzbh=");
		sb.append(getJsydpzwjhfdccqzbh());
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
		sb.append(", slbh=");
		sb.append(getSlbh());
		sb.append(", hjgsz=");
		sb.append(getHjgsz());
		sb.append(", hjgsh=");
		sb.append(getHjgsh());
		sb.append(", sqr=");
		sb.append(getSqr());
		sb.append(", sqsx=");
		sb.append(getSqsx());
		sb.append(", sqh=");
		sb.append(getSqh());
		sb.append(", cltjr=");
		sb.append(getCltjr());
		sb.append(", cltjrlxdh=");
		sb.append(getCltjrlxdh());
		sb.append(", cltjrlxdz=");
		sb.append(getCltjrlxdz());
		sb.append(", sjr=");
		sb.append(getSjr());
		sb.append(", sjrlxdh=");
		sb.append(getSjrlxdh());
		sb.append(", slyj=");
		sb.append(getSlyj());
		sb.append(", slsj=");
		sb.append(getSlsj());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(154);

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
			"<column><column-name>jsydpzwjhfdccqzbh</column-name><column-value><![CDATA[");
		sb.append(getJsydpzwjhfdccqzbh());
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
			"<column><column-name>slbh</column-name><column-value><![CDATA[");
		sb.append(getSlbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hjgsz</column-name><column-value><![CDATA[");
		sb.append(getHjgsz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hjgsh</column-name><column-value><![CDATA[");
		sb.append(getHjgsh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqr</column-name><column-value><![CDATA[");
		sb.append(getSqr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqsx</column-name><column-value><![CDATA[");
		sb.append(getSqsx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqh</column-name><column-value><![CDATA[");
		sb.append(getSqh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cltjr</column-name><column-value><![CDATA[");
		sb.append(getCltjr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cltjrlxdh</column-name><column-value><![CDATA[");
		sb.append(getCltjrlxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cltjrlxdz</column-name><column-value><![CDATA[");
		sb.append(getCltjrlxdz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjr</column-name><column-value><![CDATA[");
		sb.append(getSjr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjrlxdh</column-name><column-value><![CDATA[");
		sb.append(getSjrlxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slyj</column-name><column-value><![CDATA[");
		sb.append(getSlyj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slsj</column-name><column-value><![CDATA[");
		sb.append(getSlsj());
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
	private String _slbh;
	private int _hjgsz;
	private int _hjgsh;
	private String _sqr;
	private String _sqsx;
	private String _sqh;
	private String _cltjr;
	private String _cltjrlxdh;
	private String _cltjrlxdz;
	private String _sjr;
	private String _sjrlxdh;
	private String _slyj;
	private String _slsj;
	private BaseModel<?> _projectProfileRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}