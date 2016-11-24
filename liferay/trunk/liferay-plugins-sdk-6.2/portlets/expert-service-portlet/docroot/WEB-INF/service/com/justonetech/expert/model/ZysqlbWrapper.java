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
 * This class is a wrapper for {@link Zysqlb}.
 * </p>
 *
 * @author fanqi
 * @see Zysqlb
 * @generated
 */
public class ZysqlbWrapper implements Zysqlb, ModelWrapper<Zysqlb> {
	public ZysqlbWrapper(Zysqlb zysqlb) {
		_zysqlb = zysqlb;
	}

	@Override
	public Class<?> getModelClass() {
		return Zysqlb.class;
	}

	@Override
	public String getModelClassName() {
		return Zysqlb.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("zysqlbId", getZysqlbId());
		attributes.put("expertId", getExpertId());
		attributes.put("sx", getSx());
		attributes.put("zy", getZy());
		attributes.put("zt", getZt());
		attributes.put("shyj", getShyj());
		attributes.put("shr", getShr());
		attributes.put("shrq", getShrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long zysqlbId = (Long)attributes.get("zysqlbId");

		if (zysqlbId != null) {
			setZysqlbId(zysqlbId);
		}

		String expertId = (String)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String sx = (String)attributes.get("sx");

		if (sx != null) {
			setSx(sx);
		}

		String zy = (String)attributes.get("zy");

		if (zy != null) {
			setZy(zy);
		}

		Integer zt = (Integer)attributes.get("zt");

		if (zt != null) {
			setZt(zt);
		}

		String shyj = (String)attributes.get("shyj");

		if (shyj != null) {
			setShyj(shyj);
		}

		String shr = (String)attributes.get("shr");

		if (shr != null) {
			setShr(shr);
		}

		Date shrq = (Date)attributes.get("shrq");

		if (shrq != null) {
			setShrq(shrq);
		}
	}

	/**
	* Returns the primary key of this zysqlb.
	*
	* @return the primary key of this zysqlb
	*/
	@Override
	public long getPrimaryKey() {
		return _zysqlb.getPrimaryKey();
	}

	/**
	* Sets the primary key of this zysqlb.
	*
	* @param primaryKey the primary key of this zysqlb
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_zysqlb.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the zysqlb ID of this zysqlb.
	*
	* @return the zysqlb ID of this zysqlb
	*/
	@Override
	public long getZysqlbId() {
		return _zysqlb.getZysqlbId();
	}

	/**
	* Sets the zysqlb ID of this zysqlb.
	*
	* @param zysqlbId the zysqlb ID of this zysqlb
	*/
	@Override
	public void setZysqlbId(long zysqlbId) {
		_zysqlb.setZysqlbId(zysqlbId);
	}

	/**
	* Returns the expert ID of this zysqlb.
	*
	* @return the expert ID of this zysqlb
	*/
	@Override
	public java.lang.String getExpertId() {
		return _zysqlb.getExpertId();
	}

	/**
	* Sets the expert ID of this zysqlb.
	*
	* @param expertId the expert ID of this zysqlb
	*/
	@Override
	public void setExpertId(java.lang.String expertId) {
		_zysqlb.setExpertId(expertId);
	}

	/**
	* Returns the sx of this zysqlb.
	*
	* @return the sx of this zysqlb
	*/
	@Override
	public java.lang.String getSx() {
		return _zysqlb.getSx();
	}

	/**
	* Sets the sx of this zysqlb.
	*
	* @param sx the sx of this zysqlb
	*/
	@Override
	public void setSx(java.lang.String sx) {
		_zysqlb.setSx(sx);
	}

	/**
	* Returns the zy of this zysqlb.
	*
	* @return the zy of this zysqlb
	*/
	@Override
	public java.lang.String getZy() {
		return _zysqlb.getZy();
	}

	/**
	* Sets the zy of this zysqlb.
	*
	* @param zy the zy of this zysqlb
	*/
	@Override
	public void setZy(java.lang.String zy) {
		_zysqlb.setZy(zy);
	}

	/**
	* Returns the zt of this zysqlb.
	*
	* @return the zt of this zysqlb
	*/
	@Override
	public int getZt() {
		return _zysqlb.getZt();
	}

	/**
	* Sets the zt of this zysqlb.
	*
	* @param zt the zt of this zysqlb
	*/
	@Override
	public void setZt(int zt) {
		_zysqlb.setZt(zt);
	}

	/**
	* Returns the shyj of this zysqlb.
	*
	* @return the shyj of this zysqlb
	*/
	@Override
	public java.lang.String getShyj() {
		return _zysqlb.getShyj();
	}

	/**
	* Sets the shyj of this zysqlb.
	*
	* @param shyj the shyj of this zysqlb
	*/
	@Override
	public void setShyj(java.lang.String shyj) {
		_zysqlb.setShyj(shyj);
	}

	/**
	* Returns the shr of this zysqlb.
	*
	* @return the shr of this zysqlb
	*/
	@Override
	public java.lang.String getShr() {
		return _zysqlb.getShr();
	}

	/**
	* Sets the shr of this zysqlb.
	*
	* @param shr the shr of this zysqlb
	*/
	@Override
	public void setShr(java.lang.String shr) {
		_zysqlb.setShr(shr);
	}

	/**
	* Returns the shrq of this zysqlb.
	*
	* @return the shrq of this zysqlb
	*/
	@Override
	public java.util.Date getShrq() {
		return _zysqlb.getShrq();
	}

	/**
	* Sets the shrq of this zysqlb.
	*
	* @param shrq the shrq of this zysqlb
	*/
	@Override
	public void setShrq(java.util.Date shrq) {
		_zysqlb.setShrq(shrq);
	}

	@Override
	public boolean isNew() {
		return _zysqlb.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_zysqlb.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _zysqlb.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_zysqlb.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _zysqlb.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _zysqlb.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_zysqlb.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _zysqlb.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_zysqlb.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_zysqlb.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_zysqlb.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ZysqlbWrapper((Zysqlb)_zysqlb.clone());
	}

	@Override
	public int compareTo(com.justonetech.expert.model.Zysqlb zysqlb) {
		return _zysqlb.compareTo(zysqlb);
	}

	@Override
	public int hashCode() {
		return _zysqlb.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.expert.model.Zysqlb> toCacheModel() {
		return _zysqlb.toCacheModel();
	}

	@Override
	public com.justonetech.expert.model.Zysqlb toEscapedModel() {
		return new ZysqlbWrapper(_zysqlb.toEscapedModel());
	}

	@Override
	public com.justonetech.expert.model.Zysqlb toUnescapedModel() {
		return new ZysqlbWrapper(_zysqlb.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _zysqlb.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _zysqlb.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_zysqlb.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ZysqlbWrapper)) {
			return false;
		}

		ZysqlbWrapper zysqlbWrapper = (ZysqlbWrapper)obj;

		if (Validator.equals(_zysqlb, zysqlbWrapper._zysqlb)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Zysqlb getWrappedZysqlb() {
		return _zysqlb;
	}

	@Override
	public Zysqlb getWrappedModel() {
		return _zysqlb;
	}

	@Override
	public void resetOriginalValues() {
		_zysqlb.resetOriginalValues();
	}

	private Zysqlb _zysqlb;
}