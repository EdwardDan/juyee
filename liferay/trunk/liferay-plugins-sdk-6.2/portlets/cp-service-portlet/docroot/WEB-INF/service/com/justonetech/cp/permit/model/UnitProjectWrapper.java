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
 * This class is a wrapper for {@link UnitProject}.
 * </p>
 *
 * @author fanqi
 * @see UnitProject
 * @generated
 */
public class UnitProjectWrapper implements UnitProject,
	ModelWrapper<UnitProject> {
	public UnitProjectWrapper(UnitProject unitProject) {
		_unitProject = unitProject;
	}

	@Override
	public Class<?> getModelClass() {
		return UnitProject.class;
	}

	@Override
	public String getModelClassName() {
		return UnitProject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("permitId", getPermitId());
		attributes.put("bjbh", getBjbh());
		attributes.put("gcbh", getGcbh());
		attributes.put("gcmc", getGcmc());
		attributes.put("jsnr", getJsnr());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String gcbh = (String)attributes.get("gcbh");

		if (gcbh != null) {
			setGcbh(gcbh);
		}

		String gcmc = (String)attributes.get("gcmc");

		if (gcmc != null) {
			setGcmc(gcmc);
		}

		String jsnr = (String)attributes.get("jsnr");

		if (jsnr != null) {
			setJsnr(jsnr);
		}
	}

	/**
	* Returns the primary key of this unit project.
	*
	* @return the primary key of this unit project
	*/
	@Override
	public long getPrimaryKey() {
		return _unitProject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this unit project.
	*
	* @param primaryKey the primary key of this unit project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_unitProject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project ID of this unit project.
	*
	* @return the project ID of this unit project
	*/
	@Override
	public long getProjectId() {
		return _unitProject.getProjectId();
	}

	/**
	* Sets the project ID of this unit project.
	*
	* @param projectId the project ID of this unit project
	*/
	@Override
	public void setProjectId(long projectId) {
		_unitProject.setProjectId(projectId);
	}

	/**
	* Returns the permit ID of this unit project.
	*
	* @return the permit ID of this unit project
	*/
	@Override
	public long getPermitId() {
		return _unitProject.getPermitId();
	}

	/**
	* Sets the permit ID of this unit project.
	*
	* @param permitId the permit ID of this unit project
	*/
	@Override
	public void setPermitId(long permitId) {
		_unitProject.setPermitId(permitId);
	}

	/**
	* Returns the bjbh of this unit project.
	*
	* @return the bjbh of this unit project
	*/
	@Override
	public java.lang.String getBjbh() {
		return _unitProject.getBjbh();
	}

	/**
	* Sets the bjbh of this unit project.
	*
	* @param bjbh the bjbh of this unit project
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_unitProject.setBjbh(bjbh);
	}

	/**
	* Returns the gcbh of this unit project.
	*
	* @return the gcbh of this unit project
	*/
	@Override
	public java.lang.String getGcbh() {
		return _unitProject.getGcbh();
	}

	/**
	* Sets the gcbh of this unit project.
	*
	* @param gcbh the gcbh of this unit project
	*/
	@Override
	public void setGcbh(java.lang.String gcbh) {
		_unitProject.setGcbh(gcbh);
	}

	/**
	* Returns the gcmc of this unit project.
	*
	* @return the gcmc of this unit project
	*/
	@Override
	public java.lang.String getGcmc() {
		return _unitProject.getGcmc();
	}

	/**
	* Sets the gcmc of this unit project.
	*
	* @param gcmc the gcmc of this unit project
	*/
	@Override
	public void setGcmc(java.lang.String gcmc) {
		_unitProject.setGcmc(gcmc);
	}

	/**
	* Returns the jsnr of this unit project.
	*
	* @return the jsnr of this unit project
	*/
	@Override
	public java.lang.String getJsnr() {
		return _unitProject.getJsnr();
	}

	/**
	* Sets the jsnr of this unit project.
	*
	* @param jsnr the jsnr of this unit project
	*/
	@Override
	public void setJsnr(java.lang.String jsnr) {
		_unitProject.setJsnr(jsnr);
	}

	@Override
	public boolean isNew() {
		return _unitProject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_unitProject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _unitProject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_unitProject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _unitProject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _unitProject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_unitProject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _unitProject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_unitProject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_unitProject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_unitProject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UnitProjectWrapper((UnitProject)_unitProject.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cp.permit.model.UnitProject unitProject) {
		return _unitProject.compareTo(unitProject);
	}

	@Override
	public int hashCode() {
		return _unitProject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.permit.model.UnitProject> toCacheModel() {
		return _unitProject.toCacheModel();
	}

	@Override
	public com.justonetech.cp.permit.model.UnitProject toEscapedModel() {
		return new UnitProjectWrapper(_unitProject.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.permit.model.UnitProject toUnescapedModel() {
		return new UnitProjectWrapper(_unitProject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _unitProject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _unitProject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_unitProject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UnitProjectWrapper)) {
			return false;
		}

		UnitProjectWrapper unitProjectWrapper = (UnitProjectWrapper)obj;

		if (Validator.equals(_unitProject, unitProjectWrapper._unitProject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UnitProject getWrappedUnitProject() {
		return _unitProject;
	}

	@Override
	public UnitProject getWrappedModel() {
		return _unitProject;
	}

	@Override
	public void resetOriginalValues() {
		_unitProject.resetOriginalValues();
	}

	private UnitProject _unitProject;
}