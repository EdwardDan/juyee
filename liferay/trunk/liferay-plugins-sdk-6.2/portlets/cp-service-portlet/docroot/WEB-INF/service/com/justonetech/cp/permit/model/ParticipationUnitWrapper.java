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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ParticipationUnit}.
 * </p>
 *
 * @author fanqi
 * @see ParticipationUnit
 * @generated
 */
public class ParticipationUnitWrapper implements ParticipationUnit,
	ModelWrapper<ParticipationUnit> {
	public ParticipationUnitWrapper(ParticipationUnit participationUnit) {
		_participationUnit = participationUnit;
	}

	@Override
	public Class<?> getModelClass() {
		return ParticipationUnit.class;
	}

	@Override
	public String getModelClassName() {
		return ParticipationUnit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("unitId", getUnitId());
		attributes.put("permitId", getPermitId());
		attributes.put("htxxbsbh", getHtxxbsbh());
		attributes.put("dwlx", getDwlx());
		attributes.put("dwmc", getDwmc());
		attributes.put("xmfzr", getXmfzr());
		attributes.put("dhhm", getDhhm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		String permitId = (String)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String htxxbsbh = (String)attributes.get("htxxbsbh");

		if (htxxbsbh != null) {
			setHtxxbsbh(htxxbsbh);
		}

		String dwlx = (String)attributes.get("dwlx");

		if (dwlx != null) {
			setDwlx(dwlx);
		}

		String dwmc = (String)attributes.get("dwmc");

		if (dwmc != null) {
			setDwmc(dwmc);
		}

		String xmfzr = (String)attributes.get("xmfzr");

		if (xmfzr != null) {
			setXmfzr(xmfzr);
		}

		String dhhm = (String)attributes.get("dhhm");

		if (dhhm != null) {
			setDhhm(dhhm);
		}
	}

	/**
	* Returns the primary key of this participation unit.
	*
	* @return the primary key of this participation unit
	*/
	@Override
	public long getPrimaryKey() {
		return _participationUnit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this participation unit.
	*
	* @param primaryKey the primary key of this participation unit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_participationUnit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the unit ID of this participation unit.
	*
	* @return the unit ID of this participation unit
	*/
	@Override
	public long getUnitId() {
		return _participationUnit.getUnitId();
	}

	/**
	* Sets the unit ID of this participation unit.
	*
	* @param unitId the unit ID of this participation unit
	*/
	@Override
	public void setUnitId(long unitId) {
		_participationUnit.setUnitId(unitId);
	}

	/**
	* Returns the permit ID of this participation unit.
	*
	* @return the permit ID of this participation unit
	*/
	@Override
	public java.lang.String getPermitId() {
		return _participationUnit.getPermitId();
	}

	/**
	* Sets the permit ID of this participation unit.
	*
	* @param permitId the permit ID of this participation unit
	*/
	@Override
	public void setPermitId(java.lang.String permitId) {
		_participationUnit.setPermitId(permitId);
	}

	/**
	* Returns the htxxbsbh of this participation unit.
	*
	* @return the htxxbsbh of this participation unit
	*/
	@Override
	public java.lang.String getHtxxbsbh() {
		return _participationUnit.getHtxxbsbh();
	}

	/**
	* Sets the htxxbsbh of this participation unit.
	*
	* @param htxxbsbh the htxxbsbh of this participation unit
	*/
	@Override
	public void setHtxxbsbh(java.lang.String htxxbsbh) {
		_participationUnit.setHtxxbsbh(htxxbsbh);
	}

	/**
	* Returns the dwlx of this participation unit.
	*
	* @return the dwlx of this participation unit
	*/
	@Override
	public java.lang.String getDwlx() {
		return _participationUnit.getDwlx();
	}

	/**
	* Sets the dwlx of this participation unit.
	*
	* @param dwlx the dwlx of this participation unit
	*/
	@Override
	public void setDwlx(java.lang.String dwlx) {
		_participationUnit.setDwlx(dwlx);
	}

	/**
	* Returns the dwmc of this participation unit.
	*
	* @return the dwmc of this participation unit
	*/
	@Override
	public java.lang.String getDwmc() {
		return _participationUnit.getDwmc();
	}

	/**
	* Sets the dwmc of this participation unit.
	*
	* @param dwmc the dwmc of this participation unit
	*/
	@Override
	public void setDwmc(java.lang.String dwmc) {
		_participationUnit.setDwmc(dwmc);
	}

	/**
	* Returns the xmfzr of this participation unit.
	*
	* @return the xmfzr of this participation unit
	*/
	@Override
	public java.lang.String getXmfzr() {
		return _participationUnit.getXmfzr();
	}

	/**
	* Sets the xmfzr of this participation unit.
	*
	* @param xmfzr the xmfzr of this participation unit
	*/
	@Override
	public void setXmfzr(java.lang.String xmfzr) {
		_participationUnit.setXmfzr(xmfzr);
	}

	/**
	* Returns the dhhm of this participation unit.
	*
	* @return the dhhm of this participation unit
	*/
	@Override
	public java.lang.String getDhhm() {
		return _participationUnit.getDhhm();
	}

	/**
	* Sets the dhhm of this participation unit.
	*
	* @param dhhm the dhhm of this participation unit
	*/
	@Override
	public void setDhhm(java.lang.String dhhm) {
		_participationUnit.setDhhm(dhhm);
	}

	@Override
	public boolean isNew() {
		return _participationUnit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_participationUnit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _participationUnit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_participationUnit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _participationUnit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _participationUnit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_participationUnit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _participationUnit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_participationUnit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_participationUnit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_participationUnit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ParticipationUnitWrapper((ParticipationUnit)_participationUnit.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit) {
		return _participationUnit.compareTo(participationUnit);
	}

	@Override
	public int hashCode() {
		return _participationUnit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.permit.model.ParticipationUnit> toCacheModel() {
		return _participationUnit.toCacheModel();
	}

	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit toEscapedModel() {
		return new ParticipationUnitWrapper(_participationUnit.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit toUnescapedModel() {
		return new ParticipationUnitWrapper(_participationUnit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _participationUnit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _participationUnit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_participationUnit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParticipationUnitWrapper)) {
			return false;
		}

		ParticipationUnitWrapper participationUnitWrapper = (ParticipationUnitWrapper)obj;

		if (Validator.equals(_participationUnit,
					participationUnitWrapper._participationUnit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ParticipationUnit getWrappedParticipationUnit() {
		return _participationUnit;
	}

	@Override
	public ParticipationUnit getWrappedModel() {
		return _participationUnit;
	}

	@Override
	public void resetOriginalValues() {
		_participationUnit.resetOriginalValues();
	}

	private ParticipationUnit _participationUnit;
}