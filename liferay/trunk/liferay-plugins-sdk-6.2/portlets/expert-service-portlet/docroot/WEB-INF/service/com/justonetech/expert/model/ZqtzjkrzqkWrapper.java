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
 * This class is a wrapper for {@link Zqtzjkrzqk}.
 * </p>
 *
 * @author fanqi
 * @see Zqtzjkrzqk
 * @generated
 */
public class ZqtzjkrzqkWrapper implements Zqtzjkrzqk, ModelWrapper<Zqtzjkrzqk> {
	public ZqtzjkrzqkWrapper(Zqtzjkrzqk zqtzjkrzqk) {
		_zqtzjkrzqk = zqtzjkrzqk;
	}

	@Override
	public Class<?> getModelClass() {
		return Zqtzjkrzqk.class;
	}

	@Override
	public String getModelClassName() {
		return Zqtzjkrzqk.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("zqtzjkrzqkId", getZqtzjkrzqkId());
		attributes.put("zjkxtlsdw", getZjkxtlsdw());
		attributes.put("sqzy", getSqzy());
		attributes.put("pzrq", getPzrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long zqtzjkrzqkId = (Long)attributes.get("zqtzjkrzqkId");

		if (zqtzjkrzqkId != null) {
			setZqtzjkrzqkId(zqtzjkrzqkId);
		}

		String zjkxtlsdw = (String)attributes.get("zjkxtlsdw");

		if (zjkxtlsdw != null) {
			setZjkxtlsdw(zjkxtlsdw);
		}

		String sqzy = (String)attributes.get("sqzy");

		if (sqzy != null) {
			setSqzy(sqzy);
		}

		Date pzrq = (Date)attributes.get("pzrq");

		if (pzrq != null) {
			setPzrq(pzrq);
		}
	}

	/**
	* Returns the primary key of this zqtzjkrzqk.
	*
	* @return the primary key of this zqtzjkrzqk
	*/
	@Override
	public long getPrimaryKey() {
		return _zqtzjkrzqk.getPrimaryKey();
	}

	/**
	* Sets the primary key of this zqtzjkrzqk.
	*
	* @param primaryKey the primary key of this zqtzjkrzqk
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_zqtzjkrzqk.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the zqtzjkrzqk ID of this zqtzjkrzqk.
	*
	* @return the zqtzjkrzqk ID of this zqtzjkrzqk
	*/
	@Override
	public long getZqtzjkrzqkId() {
		return _zqtzjkrzqk.getZqtzjkrzqkId();
	}

	/**
	* Sets the zqtzjkrzqk ID of this zqtzjkrzqk.
	*
	* @param zqtzjkrzqkId the zqtzjkrzqk ID of this zqtzjkrzqk
	*/
	@Override
	public void setZqtzjkrzqkId(long zqtzjkrzqkId) {
		_zqtzjkrzqk.setZqtzjkrzqkId(zqtzjkrzqkId);
	}

	/**
	* Returns the zjkxtlsdw of this zqtzjkrzqk.
	*
	* @return the zjkxtlsdw of this zqtzjkrzqk
	*/
	@Override
	public java.lang.String getZjkxtlsdw() {
		return _zqtzjkrzqk.getZjkxtlsdw();
	}

	/**
	* Sets the zjkxtlsdw of this zqtzjkrzqk.
	*
	* @param zjkxtlsdw the zjkxtlsdw of this zqtzjkrzqk
	*/
	@Override
	public void setZjkxtlsdw(java.lang.String zjkxtlsdw) {
		_zqtzjkrzqk.setZjkxtlsdw(zjkxtlsdw);
	}

	/**
	* Returns the sqzy of this zqtzjkrzqk.
	*
	* @return the sqzy of this zqtzjkrzqk
	*/
	@Override
	public java.lang.String getSqzy() {
		return _zqtzjkrzqk.getSqzy();
	}

	/**
	* Sets the sqzy of this zqtzjkrzqk.
	*
	* @param sqzy the sqzy of this zqtzjkrzqk
	*/
	@Override
	public void setSqzy(java.lang.String sqzy) {
		_zqtzjkrzqk.setSqzy(sqzy);
	}

	/**
	* Returns the pzrq of this zqtzjkrzqk.
	*
	* @return the pzrq of this zqtzjkrzqk
	*/
	@Override
	public java.util.Date getPzrq() {
		return _zqtzjkrzqk.getPzrq();
	}

	/**
	* Sets the pzrq of this zqtzjkrzqk.
	*
	* @param pzrq the pzrq of this zqtzjkrzqk
	*/
	@Override
	public void setPzrq(java.util.Date pzrq) {
		_zqtzjkrzqk.setPzrq(pzrq);
	}

	@Override
	public boolean isNew() {
		return _zqtzjkrzqk.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_zqtzjkrzqk.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _zqtzjkrzqk.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_zqtzjkrzqk.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _zqtzjkrzqk.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _zqtzjkrzqk.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_zqtzjkrzqk.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _zqtzjkrzqk.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_zqtzjkrzqk.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_zqtzjkrzqk.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_zqtzjkrzqk.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ZqtzjkrzqkWrapper((Zqtzjkrzqk)_zqtzjkrzqk.clone());
	}

	@Override
	public int compareTo(com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk) {
		return _zqtzjkrzqk.compareTo(zqtzjkrzqk);
	}

	@Override
	public int hashCode() {
		return _zqtzjkrzqk.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.expert.model.Zqtzjkrzqk> toCacheModel() {
		return _zqtzjkrzqk.toCacheModel();
	}

	@Override
	public com.justonetech.expert.model.Zqtzjkrzqk toEscapedModel() {
		return new ZqtzjkrzqkWrapper(_zqtzjkrzqk.toEscapedModel());
	}

	@Override
	public com.justonetech.expert.model.Zqtzjkrzqk toUnescapedModel() {
		return new ZqtzjkrzqkWrapper(_zqtzjkrzqk.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _zqtzjkrzqk.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _zqtzjkrzqk.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_zqtzjkrzqk.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ZqtzjkrzqkWrapper)) {
			return false;
		}

		ZqtzjkrzqkWrapper zqtzjkrzqkWrapper = (ZqtzjkrzqkWrapper)obj;

		if (Validator.equals(_zqtzjkrzqk, zqtzjkrzqkWrapper._zqtzjkrzqk)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Zqtzjkrzqk getWrappedZqtzjkrzqk() {
		return _zqtzjkrzqk;
	}

	@Override
	public Zqtzjkrzqk getWrappedModel() {
		return _zqtzjkrzqk;
	}

	@Override
	public void resetOriginalValues() {
		_zqtzjkrzqk.resetOriginalValues();
	}

	private Zqtzjkrzqk _zqtzjkrzqk;
}