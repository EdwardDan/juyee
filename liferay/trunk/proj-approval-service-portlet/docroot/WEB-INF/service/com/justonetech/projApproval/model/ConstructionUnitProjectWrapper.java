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

package com.justonetech.projApproval.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConstructionUnitProject}.
 * </p>
 *
 * @author justonetech
 * @see ConstructionUnitProject
 * @generated
 */
public class ConstructionUnitProjectWrapper implements ConstructionUnitProject,
	ModelWrapper<ConstructionUnitProject> {
	public ConstructionUnitProjectWrapper(
		ConstructionUnitProject constructionUnitProject) {
		_constructionUnitProject = constructionUnitProject;
	}

	@Override
	public Class<?> getModelClass() {
		return ConstructionUnitProject.class;
	}

	@Override
	public String getModelClassName() {
		return ConstructionUnitProject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("constructionUnitProjectId",
			getConstructionUnitProjectId());
		attributes.put("sortNo", getSortNo());
		attributes.put("unitProjectNum", getUnitProjectNum());
		attributes.put("unitProjectName", getUnitProjectName());
		attributes.put("constructionContent", getConstructionContent());
		attributes.put("constructionPermitId", getConstructionPermitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long constructionUnitProjectId = (Long)attributes.get(
				"constructionUnitProjectId");

		if (constructionUnitProjectId != null) {
			setConstructionUnitProjectId(constructionUnitProjectId);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String unitProjectNum = (String)attributes.get("unitProjectNum");

		if (unitProjectNum != null) {
			setUnitProjectNum(unitProjectNum);
		}

		String unitProjectName = (String)attributes.get("unitProjectName");

		if (unitProjectName != null) {
			setUnitProjectName(unitProjectName);
		}

		String constructionContent = (String)attributes.get(
				"constructionContent");

		if (constructionContent != null) {
			setConstructionContent(constructionContent);
		}

		Long constructionPermitId = (Long)attributes.get("constructionPermitId");

		if (constructionPermitId != null) {
			setConstructionPermitId(constructionPermitId);
		}
	}

	/**
	* Returns the primary key of this construction unit project.
	*
	* @return the primary key of this construction unit project
	*/
	@Override
	public long getPrimaryKey() {
		return _constructionUnitProject.getPrimaryKey();
	}

	/**
	* Sets the primary key of this construction unit project.
	*
	* @param primaryKey the primary key of this construction unit project
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_constructionUnitProject.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the construction unit project ID of this construction unit project.
	*
	* @return the construction unit project ID of this construction unit project
	*/
	@Override
	public long getConstructionUnitProjectId() {
		return _constructionUnitProject.getConstructionUnitProjectId();
	}

	/**
	* Sets the construction unit project ID of this construction unit project.
	*
	* @param constructionUnitProjectId the construction unit project ID of this construction unit project
	*/
	@Override
	public void setConstructionUnitProjectId(long constructionUnitProjectId) {
		_constructionUnitProject.setConstructionUnitProjectId(constructionUnitProjectId);
	}

	/**
	* Returns the sort no of this construction unit project.
	*
	* @return the sort no of this construction unit project
	*/
	@Override
	public int getSortNo() {
		return _constructionUnitProject.getSortNo();
	}

	/**
	* Sets the sort no of this construction unit project.
	*
	* @param sortNo the sort no of this construction unit project
	*/
	@Override
	public void setSortNo(int sortNo) {
		_constructionUnitProject.setSortNo(sortNo);
	}

	/**
	* Returns the unit project num of this construction unit project.
	*
	* @return the unit project num of this construction unit project
	*/
	@Override
	public java.lang.String getUnitProjectNum() {
		return _constructionUnitProject.getUnitProjectNum();
	}

	/**
	* Sets the unit project num of this construction unit project.
	*
	* @param unitProjectNum the unit project num of this construction unit project
	*/
	@Override
	public void setUnitProjectNum(java.lang.String unitProjectNum) {
		_constructionUnitProject.setUnitProjectNum(unitProjectNum);
	}

	/**
	* Returns the unit project name of this construction unit project.
	*
	* @return the unit project name of this construction unit project
	*/
	@Override
	public java.lang.String getUnitProjectName() {
		return _constructionUnitProject.getUnitProjectName();
	}

	/**
	* Sets the unit project name of this construction unit project.
	*
	* @param unitProjectName the unit project name of this construction unit project
	*/
	@Override
	public void setUnitProjectName(java.lang.String unitProjectName) {
		_constructionUnitProject.setUnitProjectName(unitProjectName);
	}

	/**
	* Returns the construction content of this construction unit project.
	*
	* @return the construction content of this construction unit project
	*/
	@Override
	public java.lang.String getConstructionContent() {
		return _constructionUnitProject.getConstructionContent();
	}

	/**
	* Sets the construction content of this construction unit project.
	*
	* @param constructionContent the construction content of this construction unit project
	*/
	@Override
	public void setConstructionContent(java.lang.String constructionContent) {
		_constructionUnitProject.setConstructionContent(constructionContent);
	}

	/**
	* Returns the construction permit ID of this construction unit project.
	*
	* @return the construction permit ID of this construction unit project
	*/
	@Override
	public long getConstructionPermitId() {
		return _constructionUnitProject.getConstructionPermitId();
	}

	/**
	* Sets the construction permit ID of this construction unit project.
	*
	* @param constructionPermitId the construction permit ID of this construction unit project
	*/
	@Override
	public void setConstructionPermitId(long constructionPermitId) {
		_constructionUnitProject.setConstructionPermitId(constructionPermitId);
	}

	@Override
	public boolean isNew() {
		return _constructionUnitProject.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_constructionUnitProject.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _constructionUnitProject.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_constructionUnitProject.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _constructionUnitProject.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _constructionUnitProject.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_constructionUnitProject.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _constructionUnitProject.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_constructionUnitProject.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_constructionUnitProject.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_constructionUnitProject.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConstructionUnitProjectWrapper((ConstructionUnitProject)_constructionUnitProject.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.projApproval.model.ConstructionUnitProject constructionUnitProject) {
		return _constructionUnitProject.compareTo(constructionUnitProject);
	}

	@Override
	public int hashCode() {
		return _constructionUnitProject.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.projApproval.model.ConstructionUnitProject> toCacheModel() {
		return _constructionUnitProject.toCacheModel();
	}

	@Override
	public com.justonetech.projApproval.model.ConstructionUnitProject toEscapedModel() {
		return new ConstructionUnitProjectWrapper(_constructionUnitProject.toEscapedModel());
	}

	@Override
	public com.justonetech.projApproval.model.ConstructionUnitProject toUnescapedModel() {
		return new ConstructionUnitProjectWrapper(_constructionUnitProject.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _constructionUnitProject.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _constructionUnitProject.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_constructionUnitProject.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConstructionUnitProjectWrapper)) {
			return false;
		}

		ConstructionUnitProjectWrapper constructionUnitProjectWrapper = (ConstructionUnitProjectWrapper)obj;

		if (Validator.equals(_constructionUnitProject,
					constructionUnitProjectWrapper._constructionUnitProject)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConstructionUnitProject getWrappedConstructionUnitProject() {
		return _constructionUnitProject;
	}

	@Override
	public ConstructionUnitProject getWrappedModel() {
		return _constructionUnitProject;
	}

	@Override
	public void resetOriginalValues() {
		_constructionUnitProject.resetOriginalValues();
	}

	private ConstructionUnitProject _constructionUnitProject;
}