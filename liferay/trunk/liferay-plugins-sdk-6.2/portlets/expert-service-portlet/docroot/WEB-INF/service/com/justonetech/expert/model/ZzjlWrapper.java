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
 * This class is a wrapper for {@link Zzjl}.
 * </p>
 *
 * @author fanqi
 * @see Zzjl
 * @generated
 */
public class ZzjlWrapper implements Zzjl, ModelWrapper<Zzjl> {
	public ZzjlWrapper(Zzjl zzjl) {
		_zzjl = zzjl;
	}

	@Override
	public Class<?> getModelClass() {
		return Zzjl.class;
	}

	@Override
	public String getModelClassName() {
		return Zzjl.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("zzjlId", getZzjlId());
		attributes.put("expertId", getExpertId());
		attributes.put("zzdw", getZzdw());
		attributes.put("qzny", getQzny());
		attributes.put("cszyzygz", getCszyzygz());
		attributes.put("zw", getZw());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long zzjlId = (Long)attributes.get("zzjlId");

		if (zzjlId != null) {
			setZzjlId(zzjlId);
		}

		String expertId = (String)attributes.get("expertId");

		if (expertId != null) {
			setExpertId(expertId);
		}

		String zzdw = (String)attributes.get("zzdw");

		if (zzdw != null) {
			setZzdw(zzdw);
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
	* Returns the primary key of this zzjl.
	*
	* @return the primary key of this zzjl
	*/
	@Override
	public long getPrimaryKey() {
		return _zzjl.getPrimaryKey();
	}

	/**
	* Sets the primary key of this zzjl.
	*
	* @param primaryKey the primary key of this zzjl
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_zzjl.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the zzjl ID of this zzjl.
	*
	* @return the zzjl ID of this zzjl
	*/
	@Override
	public long getZzjlId() {
		return _zzjl.getZzjlId();
	}

	/**
	* Sets the zzjl ID of this zzjl.
	*
	* @param zzjlId the zzjl ID of this zzjl
	*/
	@Override
	public void setZzjlId(long zzjlId) {
		_zzjl.setZzjlId(zzjlId);
	}

	/**
	* Returns the expert ID of this zzjl.
	*
	* @return the expert ID of this zzjl
	*/
	@Override
	public java.lang.String getExpertId() {
		return _zzjl.getExpertId();
	}

	/**
	* Sets the expert ID of this zzjl.
	*
	* @param expertId the expert ID of this zzjl
	*/
	@Override
	public void setExpertId(java.lang.String expertId) {
		_zzjl.setExpertId(expertId);
	}

	/**
	* Returns the zzdw of this zzjl.
	*
	* @return the zzdw of this zzjl
	*/
	@Override
	public java.lang.String getZzdw() {
		return _zzjl.getZzdw();
	}

	/**
	* Sets the zzdw of this zzjl.
	*
	* @param zzdw the zzdw of this zzjl
	*/
	@Override
	public void setZzdw(java.lang.String zzdw) {
		_zzjl.setZzdw(zzdw);
	}

	/**
	* Returns the qzny of this zzjl.
	*
	* @return the qzny of this zzjl
	*/
	@Override
	public java.lang.String getQzny() {
		return _zzjl.getQzny();
	}

	/**
	* Sets the qzny of this zzjl.
	*
	* @param qzny the qzny of this zzjl
	*/
	@Override
	public void setQzny(java.lang.String qzny) {
		_zzjl.setQzny(qzny);
	}

	/**
	* Returns the cszyzygz of this zzjl.
	*
	* @return the cszyzygz of this zzjl
	*/
	@Override
	public java.lang.String getCszyzygz() {
		return _zzjl.getCszyzygz();
	}

	/**
	* Sets the cszyzygz of this zzjl.
	*
	* @param cszyzygz the cszyzygz of this zzjl
	*/
	@Override
	public void setCszyzygz(java.lang.String cszyzygz) {
		_zzjl.setCszyzygz(cszyzygz);
	}

	/**
	* Returns the zw of this zzjl.
	*
	* @return the zw of this zzjl
	*/
	@Override
	public java.lang.String getZw() {
		return _zzjl.getZw();
	}

	/**
	* Sets the zw of this zzjl.
	*
	* @param zw the zw of this zzjl
	*/
	@Override
	public void setZw(java.lang.String zw) {
		_zzjl.setZw(zw);
	}

	@Override
	public boolean isNew() {
		return _zzjl.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_zzjl.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _zzjl.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_zzjl.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _zzjl.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _zzjl.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_zzjl.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _zzjl.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_zzjl.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_zzjl.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_zzjl.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ZzjlWrapper((Zzjl)_zzjl.clone());
	}

	@Override
	public int compareTo(com.justonetech.expert.model.Zzjl zzjl) {
		return _zzjl.compareTo(zzjl);
	}

	@Override
	public int hashCode() {
		return _zzjl.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.expert.model.Zzjl> toCacheModel() {
		return _zzjl.toCacheModel();
	}

	@Override
	public com.justonetech.expert.model.Zzjl toEscapedModel() {
		return new ZzjlWrapper(_zzjl.toEscapedModel());
	}

	@Override
	public com.justonetech.expert.model.Zzjl toUnescapedModel() {
		return new ZzjlWrapper(_zzjl.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _zzjl.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _zzjl.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_zzjl.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ZzjlWrapper)) {
			return false;
		}

		ZzjlWrapper zzjlWrapper = (ZzjlWrapper)obj;

		if (Validator.equals(_zzjl, zzjlWrapper._zzjl)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Zzjl getWrappedZzjl() {
		return _zzjl;
	}

	@Override
	public Zzjl getWrappedModel() {
		return _zzjl;
	}

	@Override
	public void resetOriginalValues() {
		_zzjl.resetOriginalValues();
	}

	private Zzjl _zzjl;
}