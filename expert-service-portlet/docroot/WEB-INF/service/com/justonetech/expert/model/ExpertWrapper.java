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
 * This class is a wrapper for {@link Expert}.
 * </p>
 *
 * @author fanqi
 * @see Expert
 * @generated
 */
public class ExpertWrapper implements Expert, ModelWrapper<Expert> {
	public ExpertWrapper(Expert expert) {
		_expert = expert;
	}

	@Override
	public Class<?> getModelClass() {
		return Expert.class;
	}

	@Override
	public String getModelClassName() {
		return Expert.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expertId", getExpertId());
		attributes.put("userId", getUserId());
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
		attributes.put("sqbz", getSqbz());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expertId = (Long)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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

		Integer sqbz = (Integer)attributes.get("sqbz");

		if (sqbz != null) {
			setSqbz(sqbz);
		}
	}

	/**
	* Returns the primary key of this expert.
	*
	* @return the primary key of this expert
	*/
	@Override
	public long getPrimaryKey() {
		return _expert.getPrimaryKey();
	}

	/**
	* Sets the primary key of this expert.
	*
	* @param primaryKey the primary key of this expert
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_expert.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the expert ID of this expert.
	*
	* @return the expert ID of this expert
	*/
	@Override
	public long getExpertId() {
		return _expert.getExpertId();
	}

	/**
	* Sets the expert ID of this expert.
	*
	* @param expertId the expert ID of this expert
	*/
	@Override
	public void setExpertId(long expertId) {
		_expert.setExpertId(expertId);
	}

	/**
	* Returns the user ID of this expert.
	*
	* @return the user ID of this expert
	*/
	@Override
	public long getUserId() {
		return _expert.getUserId();
	}

	/**
	* Sets the user ID of this expert.
	*
	* @param userId the user ID of this expert
	*/
	@Override
	public void setUserId(long userId) {
		_expert.setUserId(userId);
	}

	/**
	* Returns the user uuid of this expert.
	*
	* @return the user uuid of this expert
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _expert.getUserUuid();
	}

	/**
	* Sets the user uuid of this expert.
	*
	* @param userUuid the user uuid of this expert
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_expert.setUserUuid(userUuid);
	}

	/**
	* Returns the xm of this expert.
	*
	* @return the xm of this expert
	*/
	@Override
	public java.lang.String getXm() {
		return _expert.getXm();
	}

	/**
	* Sets the xm of this expert.
	*
	* @param xm the xm of this expert
	*/
	@Override
	public void setXm(java.lang.String xm) {
		_expert.setXm(xm);
	}

	/**
	* Returns the xb of this expert.
	*
	* @return the xb of this expert
	*/
	@Override
	public java.lang.String getXb() {
		return _expert.getXb();
	}

	/**
	* Sets the xb of this expert.
	*
	* @param xb the xb of this expert
	*/
	@Override
	public void setXb(java.lang.String xb) {
		_expert.setXb(xb);
	}

	/**
	* Returns the sfzh of this expert.
	*
	* @return the sfzh of this expert
	*/
	@Override
	public java.lang.String getSfzh() {
		return _expert.getSfzh();
	}

	/**
	* Sets the sfzh of this expert.
	*
	* @param sfzh the sfzh of this expert
	*/
	@Override
	public void setSfzh(java.lang.String sfzh) {
		_expert.setSfzh(sfzh);
	}

	/**
	* Returns the csny of this expert.
	*
	* @return the csny of this expert
	*/
	@Override
	public java.util.Date getCsny() {
		return _expert.getCsny();
	}

	/**
	* Sets the csny of this expert.
	*
	* @param csny the csny of this expert
	*/
	@Override
	public void setCsny(java.util.Date csny) {
		_expert.setCsny(csny);
	}

	/**
	* Returns the gzdw of this expert.
	*
	* @return the gzdw of this expert
	*/
	@Override
	public java.lang.String getGzdw() {
		return _expert.getGzdw();
	}

	/**
	* Sets the gzdw of this expert.
	*
	* @param gzdw the gzdw of this expert
	*/
	@Override
	public void setGzdw(java.lang.String gzdw) {
		_expert.setGzdw(gzdw);
	}

	/**
	* Returns the dzyx of this expert.
	*
	* @return the dzyx of this expert
	*/
	@Override
	public java.lang.String getDzyx() {
		return _expert.getDzyx();
	}

	/**
	* Sets the dzyx of this expert.
	*
	* @param dzyx the dzyx of this expert
	*/
	@Override
	public void setDzyx(java.lang.String dzyx) {
		_expert.setDzyx(dzyx);
	}

	/**
	* Returns the txdz of this expert.
	*
	* @return the txdz of this expert
	*/
	@Override
	public java.lang.String getTxdz() {
		return _expert.getTxdz();
	}

	/**
	* Sets the txdz of this expert.
	*
	* @param txdz the txdz of this expert
	*/
	@Override
	public void setTxdz(java.lang.String txdz) {
		_expert.setTxdz(txdz);
	}

	/**
	* Returns the yzbm of this expert.
	*
	* @return the yzbm of this expert
	*/
	@Override
	public java.lang.String getYzbm() {
		return _expert.getYzbm();
	}

	/**
	* Sets the yzbm of this expert.
	*
	* @param yzbm the yzbm of this expert
	*/
	@Override
	public void setYzbm(java.lang.String yzbm) {
		_expert.setYzbm(yzbm);
	}

	/**
	* Returns the xrzw of this expert.
	*
	* @return the xrzw of this expert
	*/
	@Override
	public java.lang.String getXrzw() {
		return _expert.getXrzw();
	}

	/**
	* Sets the xrzw of this expert.
	*
	* @param xrzw the xrzw of this expert
	*/
	@Override
	public void setXrzw(java.lang.String xrzw) {
		_expert.setXrzw(xrzw);
	}

	/**
	* Returns the zc of this expert.
	*
	* @return the zc of this expert
	*/
	@Override
	public java.lang.String getZc() {
		return _expert.getZc();
	}

	/**
	* Sets the zc of this expert.
	*
	* @param zc the zc of this expert
	*/
	@Override
	public void setZc(java.lang.String zc) {
		_expert.setZc(zc);
	}

	/**
	* Returns the zyzg of this expert.
	*
	* @return the zyzg of this expert
	*/
	@Override
	public java.lang.String getZyzg() {
		return _expert.getZyzg();
	}

	/**
	* Sets the zyzg of this expert.
	*
	* @param zyzg the zyzg of this expert
	*/
	@Override
	public void setZyzg(java.lang.String zyzg) {
		_expert.setZyzg(zyzg);
	}

	/**
	* Returns the cszy of this expert.
	*
	* @return the cszy of this expert
	*/
	@Override
	public java.lang.String getCszy() {
		return _expert.getCszy();
	}

	/**
	* Sets the cszy of this expert.
	*
	* @param cszy the cszy of this expert
	*/
	@Override
	public void setCszy(java.lang.String cszy) {
		_expert.setCszy(cszy);
	}

	/**
	* Returns the zygznx of this expert.
	*
	* @return the zygznx of this expert
	*/
	@Override
	public java.lang.String getZygznx() {
		return _expert.getZygznx();
	}

	/**
	* Sets the zygznx of this expert.
	*
	* @param zygznx the zygznx of this expert
	*/
	@Override
	public void setZygznx(java.lang.String zygznx) {
		_expert.setZygznx(zygznx);
	}

	/**
	* Returns the sjhm of this expert.
	*
	* @return the sjhm of this expert
	*/
	@Override
	public java.lang.String getSjhm() {
		return _expert.getSjhm();
	}

	/**
	* Sets the sjhm of this expert.
	*
	* @param sjhm the sjhm of this expert
	*/
	@Override
	public void setSjhm(java.lang.String sjhm) {
		_expert.setSjhm(sjhm);
	}

	/**
	* Returns the lxdh of this expert.
	*
	* @return the lxdh of this expert
	*/
	@Override
	public java.lang.String getLxdh() {
		return _expert.getLxdh();
	}

	/**
	* Sets the lxdh of this expert.
	*
	* @param lxdh the lxdh of this expert
	*/
	@Override
	public void setLxdh(java.lang.String lxdh) {
		_expert.setLxdh(lxdh);
	}

	/**
	* Returns the cz of this expert.
	*
	* @return the cz of this expert
	*/
	@Override
	public java.lang.String getCz() {
		return _expert.getCz();
	}

	/**
	* Sets the cz of this expert.
	*
	* @param cz the cz of this expert
	*/
	@Override
	public void setCz(java.lang.String cz) {
		_expert.setCz(cz);
	}

	/**
	* Returns the sqbz of this expert.
	*
	* @return the sqbz of this expert
	*/
	@Override
	public int getSqbz() {
		return _expert.getSqbz();
	}

	/**
	* Sets the sqbz of this expert.
	*
	* @param sqbz the sqbz of this expert
	*/
	@Override
	public void setSqbz(int sqbz) {
		_expert.setSqbz(sqbz);
	}

	@Override
	public boolean isNew() {
		return _expert.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_expert.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _expert.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_expert.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _expert.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _expert.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_expert.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _expert.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_expert.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_expert.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_expert.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExpertWrapper((Expert)_expert.clone());
	}

	@Override
	public int compareTo(com.justonetech.expert.model.Expert expert) {
		return _expert.compareTo(expert);
	}

	@Override
	public int hashCode() {
		return _expert.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.expert.model.Expert> toCacheModel() {
		return _expert.toCacheModel();
	}

	@Override
	public com.justonetech.expert.model.Expert toEscapedModel() {
		return new ExpertWrapper(_expert.toEscapedModel());
	}

	@Override
	public com.justonetech.expert.model.Expert toUnescapedModel() {
		return new ExpertWrapper(_expert.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _expert.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _expert.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_expert.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpertWrapper)) {
			return false;
		}

		ExpertWrapper expertWrapper = (ExpertWrapper)obj;

		if (Validator.equals(_expert, expertWrapper._expert)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Expert getWrappedExpert() {
		return _expert;
	}

	@Override
	public Expert getWrappedModel() {
		return _expert;
	}

	@Override
	public void resetOriginalValues() {
		_expert.resetOriginalValues();
	}

	private Expert _expert;
}