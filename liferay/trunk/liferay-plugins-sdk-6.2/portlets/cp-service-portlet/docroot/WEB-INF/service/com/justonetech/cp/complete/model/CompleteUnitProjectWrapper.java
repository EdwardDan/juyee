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

package com.justonetech.cp.complete.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CompleteUnitProject}.
 * </p>
 *
 * @author fanqi
 * @see CompleteUnitProject
 * @generated
 */
public class CompleteUnitProjectWrapper implements CompleteUnitProject,
	ModelWrapper<CompleteUnitProject> {
	public CompleteUnitProjectWrapper(CompleteUnitProject completeUnitProject) {
		_completeUnitProject = completeUnitProject;
	}

	@Override
	public Class<?> getModelClass() {
		return CompleteUnitProject.class;
	}

	@Override
	public String getModelClassName() {
		return CompleteUnitProject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("completeId", getCompleteId());
		attributes.put("bjbh", getBjbh());
		attributes.put("sgxkzbh", getSgxkzbh());
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

		Long completeId = (Long)attributes.get("completeId");

		if (completeId != null) {
			setCompleteId(completeId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String sgxkzbh = (String)attributes.get("sgxkzbh");

		if (sgxkzbh != null) {
			setSgxkzbh(sgxkzbh);
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
	* Returns the primary key of this complete unit project.
	*
	* @return the primary key of this complete unit project
	*/
	@Override
	public long getPrimaryKey() {
		return _completeUnitProject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this complete unit project.
	*
	* @param primaryKey the primary key of this complete unit project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_completeUnitProject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project ID of this complete unit project.
	*
	* @return the project ID of this complete unit project
	*/
	@Override
	public long getProjectId() {
		return _completeUnitProject.getProjectId();
	}

	/**
	* Sets the project ID of this complete unit project.
	*
	* @param projectId the project ID of this complete unit project
	*/
	@Override
	public void setProjectId(long projectId) {
		_completeUnitProject.setProjectId(projectId);
	}

	/**
	* Returns the complete ID of this complete unit project.
	*
	* @return the complete ID of this complete unit project
	*/
	@Override
	public long getCompleteId() {
		return _completeUnitProject.getCompleteId();
	}

	/**
	* Sets the complete ID of this complete unit project.
	*
	* @param completeId the complete ID of this complete unit project
	*/
	@Override
	public void setCompleteId(long completeId) {
		_completeUnitProject.setCompleteId(completeId);
	}

	/**
	* Returns the bjbh of this complete unit project.
	*
	* @return the bjbh of this complete unit project
	*/
	@Override
	public java.lang.String getBjbh() {
		return _completeUnitProject.getBjbh();
	}

	/**
	* Sets the bjbh of this complete unit project.
	*
	* @param bjbh the bjbh of this complete unit project
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_completeUnitProject.setBjbh(bjbh);
	}

	/**
	* Returns the sgxkzbh of this complete unit project.
	*
	* @return the sgxkzbh of this complete unit project
	*/
	@Override
	public java.lang.String getSgxkzbh() {
		return _completeUnitProject.getSgxkzbh();
	}

	/**
	* Sets the sgxkzbh of this complete unit project.
	*
	* @param sgxkzbh the sgxkzbh of this complete unit project
	*/
	@Override
	public void setSgxkzbh(java.lang.String sgxkzbh) {
		_completeUnitProject.setSgxkzbh(sgxkzbh);
	}

	/**
	* Returns the gcbh of this complete unit project.
	*
	* @return the gcbh of this complete unit project
	*/
	@Override
	public java.lang.String getGcbh() {
		return _completeUnitProject.getGcbh();
	}

	/**
	* Sets the gcbh of this complete unit project.
	*
	* @param gcbh the gcbh of this complete unit project
	*/
	@Override
	public void setGcbh(java.lang.String gcbh) {
		_completeUnitProject.setGcbh(gcbh);
	}

	/**
	* Returns the gcmc of this complete unit project.
	*
	* @return the gcmc of this complete unit project
	*/
	@Override
	public java.lang.String getGcmc() {
		return _completeUnitProject.getGcmc();
	}

	/**
	* Sets the gcmc of this complete unit project.
	*
	* @param gcmc the gcmc of this complete unit project
	*/
	@Override
	public void setGcmc(java.lang.String gcmc) {
		_completeUnitProject.setGcmc(gcmc);
	}

	/**
	* Returns the jsnr of this complete unit project.
	*
	* @return the jsnr of this complete unit project
	*/
	@Override
	public java.lang.String getJsnr() {
		return _completeUnitProject.getJsnr();
	}

	/**
	* Sets the jsnr of this complete unit project.
	*
	* @param jsnr the jsnr of this complete unit project
	*/
	@Override
	public void setJsnr(java.lang.String jsnr) {
		_completeUnitProject.setJsnr(jsnr);
	}

	@Override
	public boolean isNew() {
		return _completeUnitProject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_completeUnitProject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _completeUnitProject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_completeUnitProject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _completeUnitProject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _completeUnitProject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_completeUnitProject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _completeUnitProject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_completeUnitProject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_completeUnitProject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_completeUnitProject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CompleteUnitProjectWrapper((CompleteUnitProject)_completeUnitProject.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cp.complete.model.CompleteUnitProject completeUnitProject) {
		return _completeUnitProject.compareTo(completeUnitProject);
	}

	@Override
	public int hashCode() {
		return _completeUnitProject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.complete.model.CompleteUnitProject> toCacheModel() {
		return _completeUnitProject.toCacheModel();
	}

	@Override
	public com.justonetech.cp.complete.model.CompleteUnitProject toEscapedModel() {
		return new CompleteUnitProjectWrapper(_completeUnitProject.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.complete.model.CompleteUnitProject toUnescapedModel() {
		return new CompleteUnitProjectWrapper(_completeUnitProject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _completeUnitProject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _completeUnitProject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_completeUnitProject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompleteUnitProjectWrapper)) {
			return false;
		}

		CompleteUnitProjectWrapper completeUnitProjectWrapper = (CompleteUnitProjectWrapper)obj;

		if (Validator.equals(_completeUnitProject,
					completeUnitProjectWrapper._completeUnitProject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CompleteUnitProject getWrappedCompleteUnitProject() {
		return _completeUnitProject;
	}

	@Override
	public CompleteUnitProject getWrappedModel() {
		return _completeUnitProject;
	}

	@Override
	public void resetOriginalValues() {
		_completeUnitProject.resetOriginalValues();
	}

	private CompleteUnitProject _completeUnitProject;
}