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
 * This class is a wrapper for {@link ApplyMaterial}.
 * </p>
 *
 * @author fanqi
 * @see ApplyMaterial
 * @generated
 */
public class ApplyMaterialWrapper implements ApplyMaterial,
	ModelWrapper<ApplyMaterial> {
	public ApplyMaterialWrapper(ApplyMaterial applyMaterial) {
		_applyMaterial = applyMaterial;
	}

	@Override
	public Class<?> getModelClass() {
		return ApplyMaterial.class;
	}

	@Override
	public String getModelClassName() {
		return ApplyMaterial.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("materialId", getMaterialId());
		attributes.put("permitId", getPermitId());
		attributes.put("xh", getXh());
		attributes.put("clmc", getClmc());
		attributes.put("yjfs", getYjfs());
		attributes.put("sjfs", getSjfs());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long materialId = (Long)attributes.get("materialId");

		if (materialId != null) {
			setMaterialId(materialId);
		}

		String permitId = (String)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		Integer xh = (Integer)attributes.get("xh");

		if (xh != null) {
			setXh(xh);
		}

		String clmc = (String)attributes.get("clmc");

		if (clmc != null) {
			setClmc(clmc);
		}

		Integer yjfs = (Integer)attributes.get("yjfs");

		if (yjfs != null) {
			setYjfs(yjfs);
		}

		Integer sjfs = (Integer)attributes.get("sjfs");

		if (sjfs != null) {
			setSjfs(sjfs);
		}
	}

	/**
	* Returns the primary key of this apply material.
	*
	* @return the primary key of this apply material
	*/
	@Override
	public long getPrimaryKey() {
		return _applyMaterial.getPrimaryKey();
	}

	/**
	* Sets the primary key of this apply material.
	*
	* @param primaryKey the primary key of this apply material
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applyMaterial.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the material ID of this apply material.
	*
	* @return the material ID of this apply material
	*/
	@Override
	public long getMaterialId() {
		return _applyMaterial.getMaterialId();
	}

	/**
	* Sets the material ID of this apply material.
	*
	* @param materialId the material ID of this apply material
	*/
	@Override
	public void setMaterialId(long materialId) {
		_applyMaterial.setMaterialId(materialId);
	}

	/**
	* Returns the permit ID of this apply material.
	*
	* @return the permit ID of this apply material
	*/
	@Override
	public java.lang.String getPermitId() {
		return _applyMaterial.getPermitId();
	}

	/**
	* Sets the permit ID of this apply material.
	*
	* @param permitId the permit ID of this apply material
	*/
	@Override
	public void setPermitId(java.lang.String permitId) {
		_applyMaterial.setPermitId(permitId);
	}

	/**
	* Returns the xh of this apply material.
	*
	* @return the xh of this apply material
	*/
	@Override
	public int getXh() {
		return _applyMaterial.getXh();
	}

	/**
	* Sets the xh of this apply material.
	*
	* @param xh the xh of this apply material
	*/
	@Override
	public void setXh(int xh) {
		_applyMaterial.setXh(xh);
	}

	/**
	* Returns the clmc of this apply material.
	*
	* @return the clmc of this apply material
	*/
	@Override
	public java.lang.String getClmc() {
		return _applyMaterial.getClmc();
	}

	/**
	* Sets the clmc of this apply material.
	*
	* @param clmc the clmc of this apply material
	*/
	@Override
	public void setClmc(java.lang.String clmc) {
		_applyMaterial.setClmc(clmc);
	}

	/**
	* Returns the yjfs of this apply material.
	*
	* @return the yjfs of this apply material
	*/
	@Override
	public int getYjfs() {
		return _applyMaterial.getYjfs();
	}

	/**
	* Sets the yjfs of this apply material.
	*
	* @param yjfs the yjfs of this apply material
	*/
	@Override
	public void setYjfs(int yjfs) {
		_applyMaterial.setYjfs(yjfs);
	}

	/**
	* Returns the sjfs of this apply material.
	*
	* @return the sjfs of this apply material
	*/
	@Override
	public int getSjfs() {
		return _applyMaterial.getSjfs();
	}

	/**
	* Sets the sjfs of this apply material.
	*
	* @param sjfs the sjfs of this apply material
	*/
	@Override
	public void setSjfs(int sjfs) {
		_applyMaterial.setSjfs(sjfs);
	}

	@Override
	public boolean isNew() {
		return _applyMaterial.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_applyMaterial.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _applyMaterial.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applyMaterial.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _applyMaterial.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _applyMaterial.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_applyMaterial.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _applyMaterial.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_applyMaterial.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_applyMaterial.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_applyMaterial.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ApplyMaterialWrapper((ApplyMaterial)_applyMaterial.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cp.permit.model.ApplyMaterial applyMaterial) {
		return _applyMaterial.compareTo(applyMaterial);
	}

	@Override
	public int hashCode() {
		return _applyMaterial.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.permit.model.ApplyMaterial> toCacheModel() {
		return _applyMaterial.toCacheModel();
	}

	@Override
	public com.justonetech.cp.permit.model.ApplyMaterial toEscapedModel() {
		return new ApplyMaterialWrapper(_applyMaterial.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.permit.model.ApplyMaterial toUnescapedModel() {
		return new ApplyMaterialWrapper(_applyMaterial.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _applyMaterial.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applyMaterial.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_applyMaterial.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplyMaterialWrapper)) {
			return false;
		}

		ApplyMaterialWrapper applyMaterialWrapper = (ApplyMaterialWrapper)obj;

		if (Validator.equals(_applyMaterial, applyMaterialWrapper._applyMaterial)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ApplyMaterial getWrappedApplyMaterial() {
		return _applyMaterial;
	}

	@Override
	public ApplyMaterial getWrappedModel() {
		return _applyMaterial;
	}

	@Override
	public void resetOriginalValues() {
		_applyMaterial.resetOriginalValues();
	}

	private ApplyMaterial _applyMaterial;
}