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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Gzjl}.
 * </p>
 *
 * @author fanqi
 * @see Gzjl
 * @generated
 */
public class GzjlWrapper implements Gzjl, ModelWrapper<Gzjl> {
	public GzjlWrapper(Gzjl gzjl) {
		_gzjl = gzjl;
	}

	@Override
	public Class<?> getModelClass() {
		return Gzjl.class;
	}

	@Override
	public String getModelClassName() {
		return Gzjl.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("GzjlId", getGzjlId());
		attributes.put("expertId", getExpertId());
		attributes.put("gzdw", getGzdw());
		attributes.put("qzny", getQzny());
		attributes.put("cszyzygz", getCszyzygz());
		attributes.put("zw", getZw());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long GzjlId = (Long)attributes.get("GzjlId");

		if (GzjlId != null) {
			setGzjlId(GzjlId);
		}

		Long expertId = (Long)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String gzdw = (String)attributes.get("gzdw");

		if (gzdw != null) {
			setGzdw(gzdw);
		}

		String qzny = (String)attributes.get("qzny");

		if (qzny != null) {
			setQzny(qzny);
		}

		String cszyzygz = (String)attributes.get("cszyzygz");

		if (cszyzygz != null) {
			setCszyzygz(cszyzygz);
		}

		String zw = (String)attributes.get("zw");

		if (zw != null) {
			setZw(zw);
		}
	}

	/**
	* Returns the primary key of this gzjl.
	*
	* @return the primary key of this gzjl
	*/
	@Override
	public long getPrimaryKey() {
		return _gzjl.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gzjl.
	*
	* @param primaryKey the primary key of this gzjl
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gzjl.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the gzjl ID of this gzjl.
	*
	* @return the gzjl ID of this gzjl
	*/
	@Override
	public long getGzjlId() {
		return _gzjl.getGzjlId();
	}

	/**
	* Sets the gzjl ID of this gzjl.
	*
	* @param GzjlId the gzjl ID of this gzjl
	*/
	@Override
	public void setGzjlId(long GzjlId) {
		_gzjl.setGzjlId(GzjlId);
	}

	/**
	* Returns the expert ID of this gzjl.
	*
	* @return the expert ID of this gzjl
	*/
	@Override
	public long getExpertId() {
		return _gzjl.getExpertId();
	}

	/**
	* Sets the expert ID of this gzjl.
	*
	* @param expertId the expert ID of this gzjl
	*/
	@Override
	public void setExpertId(long expertId) {
		_gzjl.setExpertId(expertId);
	}

	/**
	* Returns the gzdw of this gzjl.
	*
	* @return the gzdw of this gzjl
	*/
	@Override
	public java.lang.String getGzdw() {
		return _gzjl.getGzdw();
	}

	/**
	* Sets the gzdw of this gzjl.
	*
	* @param gzdw the gzdw of this gzjl
	*/
	@Override
	public void setGzdw(java.lang.String gzdw) {
		_gzjl.setGzdw(gzdw);
	}

	/**
	* Returns the qzny of this gzjl.
	*
	* @return the qzny of this gzjl
	*/
	@Override
	public java.lang.String getQzny() {
		return _gzjl.getQzny();
	}

	/**
	* Sets the qzny of this gzjl.
	*
	* @param qzny the qzny of this gzjl
	*/
	@Override
	public void setQzny(java.lang.String qzny) {
		_gzjl.setQzny(qzny);
	}

	/**
	* Returns the cszyzygz of this gzjl.
	*
	* @return the cszyzygz of this gzjl
	*/
	@Override
	public java.lang.String getCszyzygz() {
		return _gzjl.getCszyzygz();
	}

	/**
	* Sets the cszyzygz of this gzjl.
	*
	* @param cszyzygz the cszyzygz of this gzjl
	*/
	@Override
	public void setCszyzygz(java.lang.String cszyzygz) {
		_gzjl.setCszyzygz(cszyzygz);
	}

	/**
	* Returns the zw of this gzjl.
	*
	* @return the zw of this gzjl
	*/
	@Override
	public java.lang.String getZw() {
		return _gzjl.getZw();
	}

	/**
	* Sets the zw of this gzjl.
	*
	* @param zw the zw of this gzjl
	*/
	@Override
	public void setZw(java.lang.String zw) {
		_gzjl.setZw(zw);
	}

	@Override
	public boolean isNew() {
		return _gzjl.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gzjl.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gzjl.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gzjl.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gzjl.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gzjl.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gzjl.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gzjl.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gzjl.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gzjl.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gzjl.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GzjlWrapper((Gzjl)_gzjl.clone());
	}

	@Override
	public int compareTo(com.justonetech.expert.model.Gzjl gzjl) {
		return _gzjl.compareTo(gzjl);
	}

	@Override
	public int hashCode() {
		return _gzjl.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.expert.model.Gzjl> toCacheModel() {
		return _gzjl.toCacheModel();
	}

	@Override
	public com.justonetech.expert.model.Gzjl toEscapedModel() {
		return new GzjlWrapper(_gzjl.toEscapedModel());
	}

	@Override
	public com.justonetech.expert.model.Gzjl toUnescapedModel() {
		return new GzjlWrapper(_gzjl.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gzjl.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gzjl.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gzjl.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GzjlWrapper)) {
			return false;
		}

		GzjlWrapper gzjlWrapper = (GzjlWrapper)obj;

		if (Validator.equals(_gzjl, gzjlWrapper._gzjl)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Gzjl getWrappedGzjl() {
		return _gzjl;
	}

	@Override
	public Gzjl getWrappedModel() {
		return _gzjl;
	}

	@Override
	public void resetOriginalValues() {
		_gzjl.resetOriginalValues();
	}

	private Gzjl _gzjl;
}