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
 * This class is a wrapper for {@link ConstructionParticipantUnits}.
 * </p>
 *
 * @author justonetech
 * @see ConstructionParticipantUnits
 * @generated
 */
public class ConstructionParticipantUnitsWrapper
	implements ConstructionParticipantUnits,
		ModelWrapper<ConstructionParticipantUnits> {
	public ConstructionParticipantUnitsWrapper(
		ConstructionParticipantUnits constructionParticipantUnits) {
		_constructionParticipantUnits = constructionParticipantUnits;
	}

	@Override
	public Class<?> getModelClass() {
		return ConstructionParticipantUnits.class;
	}

	@Override
	public String getModelClassName() {
		return ConstructionParticipantUnits.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("constructionParticipantUnitsId",
			getConstructionParticipantUnitsId());
		attributes.put("sortNo", getSortNo());
		attributes.put("contractInfoSubmitNum", getContractInfoSubmitNum());
		attributes.put("unitType", getUnitType());
		attributes.put("unitName", getUnitName());
		attributes.put("projectLeader", getProjectLeader());
		attributes.put("telephoneNum", getTelephoneNum());
		attributes.put("constructionPermitId", getConstructionPermitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long constructionParticipantUnitsId = (Long)attributes.get(
				"constructionParticipantUnitsId");

		if (constructionParticipantUnitsId != null) {
			setConstructionParticipantUnitsId(constructionParticipantUnitsId);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String contractInfoSubmitNum = (String)attributes.get(
				"contractInfoSubmitNum");

		if (contractInfoSubmitNum != null) {
			setContractInfoSubmitNum(contractInfoSubmitNum);
		}

		Long unitType = (Long)attributes.get("unitType");

		if (unitType != null) {
			setUnitType(unitType);
		}

		String unitName = (String)attributes.get("unitName");

		if (unitName != null) {
			setUnitName(unitName);
		}

		String projectLeader = (String)attributes.get("projectLeader");

		if (projectLeader != null) {
			setProjectLeader(projectLeader);
		}

		String telephoneNum = (String)attributes.get("telephoneNum");

		if (telephoneNum != null) {
			setTelephoneNum(telephoneNum);
		}

		Long constructionPermitId = (Long)attributes.get("constructionPermitId");

		if (constructionPermitId != null) {
			setConstructionPermitId(constructionPermitId);
		}
	}

	/**
	* Returns the primary key of this construction participant units.
	*
	* @return the primary key of this construction participant units
	*/
	@Override
	public long getPrimaryKey() {
		return _constructionParticipantUnits.getPrimaryKey();
	}

	/**
	* Sets the primary key of this construction participant units.
	*
	* @param primaryKey the primary key of this construction participant units
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_constructionParticipantUnits.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the construction participant units ID of this construction participant units.
	*
	* @return the construction participant units ID of this construction participant units
	*/
	@Override
	public long getConstructionParticipantUnitsId() {
		return _constructionParticipantUnits.getConstructionParticipantUnitsId();
	}

	/**
	* Sets the construction participant units ID of this construction participant units.
	*
	* @param constructionParticipantUnitsId the construction participant units ID of this construction participant units
	*/
	@Override
	public void setConstructionParticipantUnitsId(
		long constructionParticipantUnitsId) {
		_constructionParticipantUnits.setConstructionParticipantUnitsId(constructionParticipantUnitsId);
	}

	/**
	* Returns the sort no of this construction participant units.
	*
	* @return the sort no of this construction participant units
	*/
	@Override
	public int getSortNo() {
		return _constructionParticipantUnits.getSortNo();
	}

	/**
	* Sets the sort no of this construction participant units.
	*
	* @param sortNo the sort no of this construction participant units
	*/
	@Override
	public void setSortNo(int sortNo) {
		_constructionParticipantUnits.setSortNo(sortNo);
	}

	/**
	* Returns the contract info submit num of this construction participant units.
	*
	* @return the contract info submit num of this construction participant units
	*/
	@Override
	public java.lang.String getContractInfoSubmitNum() {
		return _constructionParticipantUnits.getContractInfoSubmitNum();
	}

	/**
	* Sets the contract info submit num of this construction participant units.
	*
	* @param contractInfoSubmitNum the contract info submit num of this construction participant units
	*/
	@Override
	public void setContractInfoSubmitNum(java.lang.String contractInfoSubmitNum) {
		_constructionParticipantUnits.setContractInfoSubmitNum(contractInfoSubmitNum);
	}

	/**
	* Returns the unit type of this construction participant units.
	*
	* @return the unit type of this construction participant units
	*/
	@Override
	public long getUnitType() {
		return _constructionParticipantUnits.getUnitType();
	}

	/**
	* Sets the unit type of this construction participant units.
	*
	* @param unitType the unit type of this construction participant units
	*/
	@Override
	public void setUnitType(long unitType) {
		_constructionParticipantUnits.setUnitType(unitType);
	}

	/**
	* Returns the unit name of this construction participant units.
	*
	* @return the unit name of this construction participant units
	*/
	@Override
	public java.lang.String getUnitName() {
		return _constructionParticipantUnits.getUnitName();
	}

	/**
	* Sets the unit name of this construction participant units.
	*
	* @param unitName the unit name of this construction participant units
	*/
	@Override
	public void setUnitName(java.lang.String unitName) {
		_constructionParticipantUnits.setUnitName(unitName);
	}

	/**
	* Returns the project leader of this construction participant units.
	*
	* @return the project leader of this construction participant units
	*/
	@Override
	public java.lang.String getProjectLeader() {
		return _constructionParticipantUnits.getProjectLeader();
	}

	/**
	* Sets the project leader of this construction participant units.
	*
	* @param projectLeader the project leader of this construction participant units
	*/
	@Override
	public void setProjectLeader(java.lang.String projectLeader) {
		_constructionParticipantUnits.setProjectLeader(projectLeader);
	}

	/**
	* Returns the telephone num of this construction participant units.
	*
	* @return the telephone num of this construction participant units
	*/
	@Override
	public java.lang.String getTelephoneNum() {
		return _constructionParticipantUnits.getTelephoneNum();
	}

	/**
	* Sets the telephone num of this construction participant units.
	*
	* @param telephoneNum the telephone num of this construction participant units
	*/
	@Override
	public void setTelephoneNum(java.lang.String telephoneNum) {
		_constructionParticipantUnits.setTelephoneNum(telephoneNum);
	}

	/**
	* Returns the construction permit ID of this construction participant units.
	*
	* @return the construction permit ID of this construction participant units
	*/
	@Override
	public long getConstructionPermitId() {
		return _constructionParticipantUnits.getConstructionPermitId();
	}

	/**
	* Sets the construction permit ID of this construction participant units.
	*
	* @param constructionPermitId the construction permit ID of this construction participant units
	*/
	@Override
	public void setConstructionPermitId(long constructionPermitId) {
		_constructionParticipantUnits.setConstructionPermitId(constructionPermitId);
	}

	@Override
	public boolean isNew() {
		return _constructionParticipantUnits.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_constructionParticipantUnits.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _constructionParticipantUnits.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_constructionParticipantUnits.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _constructionParticipantUnits.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _constructionParticipantUnits.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_constructionParticipantUnits.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _constructionParticipantUnits.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_constructionParticipantUnits.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_constructionParticipantUnits.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_constructionParticipantUnits.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConstructionParticipantUnitsWrapper((ConstructionParticipantUnits)_constructionParticipantUnits.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.projApproval.model.ConstructionParticipantUnits constructionParticipantUnits) {
		return _constructionParticipantUnits.compareTo(constructionParticipantUnits);
	}

	@Override
	public int hashCode() {
		return _constructionParticipantUnits.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.projApproval.model.ConstructionParticipantUnits> toCacheModel() {
		return _constructionParticipantUnits.toCacheModel();
	}

	@Override
	public com.justonetech.projApproval.model.ConstructionParticipantUnits toEscapedModel() {
		return new ConstructionParticipantUnitsWrapper(_constructionParticipantUnits.toEscapedModel());
	}

	@Override
	public com.justonetech.projApproval.model.ConstructionParticipantUnits toUnescapedModel() {
		return new ConstructionParticipantUnitsWrapper(_constructionParticipantUnits.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _constructionParticipantUnits.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _constructionParticipantUnits.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_constructionParticipantUnits.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConstructionParticipantUnitsWrapper)) {
			return false;
		}

		ConstructionParticipantUnitsWrapper constructionParticipantUnitsWrapper = (ConstructionParticipantUnitsWrapper)obj;

		if (Validator.equals(_constructionParticipantUnits,
					constructionParticipantUnitsWrapper._constructionParticipantUnits)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConstructionParticipantUnits getWrappedConstructionParticipantUnits() {
		return _constructionParticipantUnits;
	}

	@Override
	public ConstructionParticipantUnits getWrappedModel() {
		return _constructionParticipantUnits;
	}

	@Override
	public void resetOriginalValues() {
		_constructionParticipantUnits.resetOriginalValues();
	}

	private ConstructionParticipantUnits _constructionParticipantUnits;
}