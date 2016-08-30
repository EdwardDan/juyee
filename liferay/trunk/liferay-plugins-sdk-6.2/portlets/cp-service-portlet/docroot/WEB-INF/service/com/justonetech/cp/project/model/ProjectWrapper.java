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

package com.justonetech.cp.project.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author fanqi
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
	public ProjectWrapper(Project project) {
		_project = project;
	}

	@Override
	public Class<?> getModelClass() {
		return Project.class;
	}

	@Override
	public String getModelClassName() {
		return Project.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectId", getProjectId());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("bjrq", getBjrq());
		attributes.put("bjWebid", getBjWebid());
		attributes.put("xmmc", getXmmc());
		attributes.put("bjwcbj", getBjwcbj());
		attributes.put("jsdwmc", getJsdwmc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String projectId = (String)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		String zzjgdm = (String)attributes.get("zzjgdm");

		if (zzjgdm != null) {
			setZzjgdm(zzjgdm);
		}

		Date bjrq = (Date)attributes.get("bjrq");

		if (bjrq != null) {
			setBjrq(bjrq);
		}

		String bjWebid = (String)attributes.get("bjWebid");

		if (bjWebid != null) {
			setBjWebid(bjWebid);
		}

		String xmmc = (String)attributes.get("xmmc");

		if (xmmc != null) {
			setXmmc(xmmc);
		}

		String bjwcbj = (String)attributes.get("bjwcbj");

		if (bjwcbj != null) {
			setBjwcbj(bjwcbj);
		}

		String jsdwmc = (String)attributes.get("jsdwmc");

		if (jsdwmc != null) {
			setJsdwmc(jsdwmc);
		}
	}

	/**
	* Returns the primary key of this project.
	*
	* @return the primary key of this project
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _project.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project.
	*
	* @param primaryKey the primary key of this project
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_project.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the project ID of this project.
	*
	* @return the project ID of this project
	*/
	@Override
	public java.lang.String getProjectId() {
		return _project.getProjectId();
	}

	/**
	* Sets the project ID of this project.
	*
	* @param projectId the project ID of this project
	*/
	@Override
	public void setProjectId(java.lang.String projectId) {
		_project.setProjectId(projectId);
	}

	/**
	* Returns the zzjgdm of this project.
	*
	* @return the zzjgdm of this project
	*/
	@Override
	public java.lang.String getZzjgdm() {
		return _project.getZzjgdm();
	}

	/**
	* Sets the zzjgdm of this project.
	*
	* @param zzjgdm the zzjgdm of this project
	*/
	@Override
	public void setZzjgdm(java.lang.String zzjgdm) {
		_project.setZzjgdm(zzjgdm);
	}

	/**
	* Returns the bjrq of this project.
	*
	* @return the bjrq of this project
	*/
	@Override
	public java.util.Date getBjrq() {
		return _project.getBjrq();
	}

	/**
	* Sets the bjrq of this project.
	*
	* @param bjrq the bjrq of this project
	*/
	@Override
	public void setBjrq(java.util.Date bjrq) {
		_project.setBjrq(bjrq);
	}

	/**
	* Returns the bj webid of this project.
	*
	* @return the bj webid of this project
	*/
	@Override
	public java.lang.String getBjWebid() {
		return _project.getBjWebid();
	}

	/**
	* Sets the bj webid of this project.
	*
	* @param bjWebid the bj webid of this project
	*/
	@Override
	public void setBjWebid(java.lang.String bjWebid) {
		_project.setBjWebid(bjWebid);
	}

	/**
	* Returns the xmmc of this project.
	*
	* @return the xmmc of this project
	*/
	@Override
	public java.lang.String getXmmc() {
		return _project.getXmmc();
	}

	/**
	* Sets the xmmc of this project.
	*
	* @param xmmc the xmmc of this project
	*/
	@Override
	public void setXmmc(java.lang.String xmmc) {
		_project.setXmmc(xmmc);
	}

	/**
	* Returns the bjwcbj of this project.
	*
	* @return the bjwcbj of this project
	*/
	@Override
	public java.lang.String getBjwcbj() {
		return _project.getBjwcbj();
	}

	/**
	* Sets the bjwcbj of this project.
	*
	* @param bjwcbj the bjwcbj of this project
	*/
	@Override
	public void setBjwcbj(java.lang.String bjwcbj) {
		_project.setBjwcbj(bjwcbj);
	}

	/**
	* Returns the jsdwmc of this project.
	*
	* @return the jsdwmc of this project
	*/
	@Override
	public java.lang.String getJsdwmc() {
		return _project.getJsdwmc();
	}

	/**
	* Sets the jsdwmc of this project.
	*
	* @param jsdwmc the jsdwmc of this project
	*/
	@Override
	public void setJsdwmc(java.lang.String jsdwmc) {
		_project.setJsdwmc(jsdwmc);
	}

	@Override
	public boolean isNew() {
		return _project.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_project.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _project.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_project.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _project.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _project.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_project.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _project.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_project.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_project.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_project.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectWrapper((Project)_project.clone());
	}

	@Override
	public int compareTo(com.justonetech.cp.project.model.Project project) {
		return _project.compareTo(project);
	}

	@Override
	public int hashCode() {
		return _project.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.project.model.Project> toCacheModel() {
		return _project.toCacheModel();
	}

	@Override
	public com.justonetech.cp.project.model.Project toEscapedModel() {
		return new ProjectWrapper(_project.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.project.model.Project toUnescapedModel() {
		return new ProjectWrapper(_project.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _project.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _project.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_project.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectWrapper)) {
			return false;
		}

		ProjectWrapper projectWrapper = (ProjectWrapper)obj;

		if (Validator.equals(_project, projectWrapper._project)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Project getWrappedProject() {
		return _project;
	}

	@Override
	public Project getWrappedModel() {
		return _project;
	}

	@Override
	public void resetOriginalValues() {
		_project.resetOriginalValues();
	}

	private Project _project;
}