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

package com.justonetech.expert.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Jbxx}.
 * </p>
 *
 * @author fanqi
 * @see Jbxx
 * @generated
 */
public class JbxxWrapper implements Jbxx, ModelWrapper<Jbxx> {
	public JbxxWrapper(Jbxx jbxx) {
		_jbxx = jbxx;
	}

	@Override
	public Class<?> getModelClass() {
		return Jbxx.class;
	}

	@Override
	public String getModelClassName() {
		return Jbxx.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jbxxId", getJbxxId());
		attributes.put("xm", getXm());
		attributes.put("xb", getXb());
		attributes.put("sfzh", getSfzh());
		attributes.put("csny", getCsny());
		attributes.put("gzdw", getGzdw());
		attributes.put("dzyx", getDzyx());
		attributes.put("txdz", getTxdz());
		attributes.put("yzbm", getYzbm());
		attributes.put("xrzw", getXrzw());
		attributes.put("zc", getZc());
		attributes.put("zyzg", getZyzg());
		attributes.put("cszy", getCszy());
		attributes.put("zygznx", getZygznx());
		attributes.put("sjhm", getSjhm());
		attributes.put("lxdh", getLxdh());
		attributes.put("cz", getCz());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jbxxId = (Long)attributes.get("jbxxId");

		if (jbxxId != null) {
			setJbxxId(jbxxId);
		}

		String xm = (String)attributes.get("xm");

		if (xm != null) {
			setXm(xm);
		}

		String xb = (String)attributes.get("xb");

		if (xb != null) {
			setXb(xb);
		}

		String sfzh = (String)attributes.get("sfzh");

		if (sfzh != null) {
			setSfzh(sfzh);
		}

		Date csny = (Date)attributes.get("csny");

		if (csny != null) {
			setCsny(csny);
		}

		String gzdw = (String)attributes.get("gzdw");

		if (gzdw != null) {
			setGzdw(gzdw);
		}

		String dzyx = (String)attributes.get("dzyx");

		if (dzyx != null) {
			setDzyx(dzyx);
		}

		String txdz = (String)attributes.get("txdz");

		if (txdz != null) {
			setTxdz(txdz);
		}

		String yzbm = (String)attributes.get("yzbm");

		if (yzbm != null) {
			setYzbm(yzbm);
		}

		String xrzw = (String)attributes.get("xrzw");

		if (xrzw != null) {
			setXrzw(xrzw);
		}

		String zc = (String)attributes.get("zc");

		if (zc != null) {
			setZc(zc);
		}

		String zyzg = (String)attributes.get("zyzg");

		if (zyzg != null) {
			setZyzg(zyzg);
		}

		String cszy = (String)attributes.get("cszy");

		if (cszy != null) {
			setCszy(cszy);
		}

		String zygznx = (String)attributes.get("zygznx");

		if (zygznx != null) {
			setZygznx(zygznx);
		}

		String sjhm = (String)attributes.get("sjhm");

		if (sjhm != null) {
			setSjhm(sjhm);
		}

		String lxdh = (String)attributes.get("lxdh");

		if (lxdh != null) {
			setLxdh(lxdh);
		}

		String cz = (String)attributes.get("cz");

		if (cz != null) {
			setCz(cz);
		}
	}

	/**
	* Returns the primary key of this jbxx.
	*
	* @return the primary key of this jbxx
	*/
	@Override
	public long getPrimaryKey() {
		return _jbxx.getPrimaryKey();
	}

	/**
	* Sets the primary key of this jbxx.
	*
	* @param primaryKey the primary key of this jbxx
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jbxx.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the jbxx ID of this jbxx.
	*
	* @return the jbxx ID of this jbxx
	*/
	@Override
	public long getJbxxId() {
		return _jbxx.getJbxxId();
	}

	/**
	* Sets the jbxx ID of this jbxx.
	*
	* @param jbxxId the jbxx ID of this jbxx
	*/
	@Override
	public void setJbxxId(long jbxxId) {
		_jbxx.setJbxxId(jbxxId);
	}

	/**
	* Returns the xm of this jbxx.
	*
	* @return the xm of this jbxx
	*/
	@Override
	public java.lang.String getXm() {
		return _jbxx.getXm();
	}

	/**
	* Sets the xm of this jbxx.
	*
	* @param xm the xm of this jbxx
	*/
	@Override
	public void setXm(java.lang.String xm) {
		_jbxx.setXm(xm);
	}

	/**
	* Returns the xb of this jbxx.
	*
	* @return the xb of this jbxx
	*/
	@Override
	public java.lang.String getXb() {
		return _jbxx.getXb();
	}

	/**
	* Sets the xb of this jbxx.
	*
	* @param xb the xb of this jbxx
	*/
	@Override
	public void setXb(java.lang.String xb) {
		_jbxx.setXb(xb);
	}

	/**
	* Returns the sfzh of this jbxx.
	*
	* @return the sfzh of this jbxx
	*/
	@Override
	public java.lang.String getSfzh() {
		return _jbxx.getSfzh();
	}

	/**
	* Sets the sfzh of this jbxx.
	*
	* @param sfzh the sfzh of this jbxx
	*/
	@Override
	public void setSfzh(java.lang.String sfzh) {
		_jbxx.setSfzh(sfzh);
	}

	/**
	* Returns the csny of this jbxx.
	*
	* @return the csny of this jbxx
	*/
	@Override
	public java.util.Date getCsny() {
		return _jbxx.getCsny();
	}

	/**
	* Sets the csny of this jbxx.
	*
	* @param csny the csny of this jbxx
	*/
	@Override
	public void setCsny(java.util.Date csny) {
		_jbxx.setCsny(csny);
	}

	/**
	* Returns the gzdw of this jbxx.
	*
	* @return the gzdw of this jbxx
	*/
	@Override
	public java.lang.String getGzdw() {
		return _jbxx.getGzdw();
	}

	/**
	* Sets the gzdw of this jbxx.
	*
	* @param gzdw the gzdw of this jbxx
	*/
	@Override
	public void setGzdw(java.lang.String gzdw) {
		_jbxx.setGzdw(gzdw);
	}

	/**
	* Returns the dzyx of this jbxx.
	*
	* @return the dzyx of this jbxx
	*/
	@Override
	public java.lang.String getDzyx() {
		return _jbxx.getDzyx();
	}

	/**
	* Sets the dzyx of this jbxx.
	*
	* @param dzyx the dzyx of this jbxx
	*/
	@Override
	public void setDzyx(java.lang.String dzyx) {
		_jbxx.setDzyx(dzyx);
	}

	/**
	* Returns the txdz of this jbxx.
	*
	* @return the txdz of this jbxx
	*/
	@Override
	public java.lang.String getTxdz() {
		return _jbxx.getTxdz();
	}

	/**
	* Sets the txdz of this jbxx.
	*
	* @param txdz the txdz of this jbxx
	*/
	@Override
	public void setTxdz(java.lang.String txdz) {
		_jbxx.setTxdz(txdz);
	}

	/**
	* Returns the yzbm of this jbxx.
	*
	* @return the yzbm of this jbxx
	*/
	@Override
	public java.lang.String getYzbm() {
		return _jbxx.getYzbm();
	}

	/**
	* Sets the yzbm of this jbxx.
	*
	* @param yzbm the yzbm of this jbxx
	*/
	@Override
	public void setYzbm(java.lang.String yzbm) {
		_jbxx.setYzbm(yzbm);
	}

	/**
	* Returns the xrzw of this jbxx.
	*
	* @return the xrzw of this jbxx
	*/
	@Override
	public java.lang.String getXrzw() {
		return _jbxx.getXrzw();
	}

	/**
	* Sets the xrzw of this jbxx.
	*
	* @param xrzw the xrzw of this jbxx
	*/
	@Override
	public void setXrzw(java.lang.String xrzw) {
		_jbxx.setXrzw(xrzw);
	}

	/**
	* Returns the zc of this jbxx.
	*
	* @return the zc of this jbxx
	*/
	@Override
	public java.lang.String getZc() {
		return _jbxx.getZc();
	}

	/**
	* Sets the zc of this jbxx.
	*
	* @param zc the zc of this jbxx
	*/
	@Override
	public void setZc(java.lang.String zc) {
		_jbxx.setZc(zc);
	}

	/**
	* Returns the zyzg of this jbxx.
	*
	* @return the zyzg of this jbxx
	*/
	@Override
	public java.lang.String getZyzg() {
		return _jbxx.getZyzg();
	}

	/**
	* Sets the zyzg of this jbxx.
	*
	* @param zyzg the zyzg of this jbxx
	*/
	@Override
	public void setZyzg(java.lang.String zyzg) {
		_jbxx.setZyzg(zyzg);
	}

	/**
	* Returns the cszy of this jbxx.
	*
	* @return the cszy of this jbxx
	*/
	@Override
	public java.lang.String getCszy() {
		return _jbxx.getCszy();
	}

	/**
	* Sets the cszy of this jbxx.
	*
	* @param cszy the cszy of this jbxx
	*/
	@Override
	public void setCszy(java.lang.String cszy) {
		_jbxx.setCszy(cszy);
	}

	/**
	* Returns the zygznx of this jbxx.
	*
	* @return the zygznx of this jbxx
	*/
	@Override
	public java.lang.String getZygznx() {
		return _jbxx.getZygznx();
	}

	/**
	* Sets the zygznx of this jbxx.
	*
	* @param zygznx the zygznx of this jbxx
	*/
	@Override
	public void setZygznx(java.lang.String zygznx) {
		_jbxx.setZygznx(zygznx);
	}

	/**
	* Returns the sjhm of this jbxx.
	*
	* @return the sjhm of this jbxx
	*/
	@Override
	public java.lang.String getSjhm() {
		return _jbxx.getSjhm();
	}

	/**
	* Sets the sjhm of this jbxx.
	*
	* @param sjhm the sjhm of this jbxx
	*/
	@Override
	public void setSjhm(java.lang.String sjhm) {
		_jbxx.setSjhm(sjhm);
	}

	/**
	* Returns the lxdh of this jbxx.
	*
	* @return the lxdh of this jbxx
	*/
	@Override
	public java.lang.String getLxdh() {
		return _jbxx.getLxdh();
	}

	/**
	* Sets the lxdh of this jbxx.
	*
	* @param lxdh the lxdh of this jbxx
	*/
	@Override
	public void setLxdh(java.lang.String lxdh) {
		_jbxx.setLxdh(lxdh);
	}

	/**
	* Returns the cz of this jbxx.
	*
	* @return the cz of this jbxx
	*/
	@Override
	public java.lang.String getCz() {
		return _jbxx.getCz();
	}

	/**
	* Sets the cz of this jbxx.
	*
	* @param cz the cz of this jbxx
	*/
	@Override
	public void setCz(java.lang.String cz) {
		_jbxx.setCz(cz);
	}

	@Override
	public boolean isNew() {
		return _jbxx.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jbxx.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jbxx.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jbxx.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jbxx.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jbxx.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jbxx.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jbxx.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jbxx.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jbxx.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jbxx.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JbxxWrapper((Jbxx)_jbxx.clone());
	}

	@Override
	public int compareTo(com.justonetech.expert.model.Jbxx jbxx) {
		return _jbxx.compareTo(jbxx);
	}

	@Override
	public int hashCode() {
		return _jbxx.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.expert.model.Jbxx> toCacheModel() {
		return _jbxx.toCacheModel();
	}

	@Override
	public com.justonetech.expert.model.Jbxx toEscapedModel() {
		return new JbxxWrapper(_jbxx.toEscapedModel());
	}

	@Override
	public com.justonetech.expert.model.Jbxx toUnescapedModel() {
		return new JbxxWrapper(_jbxx.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jbxx.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jbxx.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jbxx.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JbxxWrapper)) {
			return false;
		}

		JbxxWrapper jbxxWrapper = (JbxxWrapper)obj;

		if (Validator.equals(_jbxx, jbxxWrapper._jbxx)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Jbxx getWrappedJbxx() {
		return _jbxx;
	}

	@Override
	public Jbxx getWrappedModel() {
		return _jbxx;
	}

	@Override
	public void resetOriginalValues() {
		_jbxx.resetOriginalValues();
	}

	private Jbxx _jbxx;
}