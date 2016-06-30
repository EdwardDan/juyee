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

package com.justonetech.oa.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VehicleRequisition}.
 * </p>
 *
 * @author justonetech
 * @see VehicleRequisition
 * @generated
 */
public class VehicleRequisitionWrapper implements VehicleRequisition,
	ModelWrapper<VehicleRequisition> {
	public VehicleRequisitionWrapper(VehicleRequisition vehicleRequisition) {
		_vehicleRequisition = vehicleRequisition;
	}

	@Override
	public Class<?> getModelClass() {
		return VehicleRequisition.class;
	}

	@Override
	public String getModelClassName() {
		return VehicleRequisition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vehicleRequisitionId", getVehicleRequisitionId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("applicantDeptId", getApplicantDeptId());
		attributes.put("applicantDeptName", getApplicantDeptName());
		attributes.put("applicantId", getApplicantId());
		attributes.put("applicantName", getApplicantName());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("passengerNum", getPassengerNum());
		attributes.put("reason", getReason());
		attributes.put("destination", getDestination());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vehicleRequisitionId = (Long)attributes.get("vehicleRequisitionId");

		if (vehicleRequisitionId != null) {
			setVehicleRequisitionId(vehicleRequisitionId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createTime = (Date)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Date modifiedTime = (Date)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
		}

		Long applicantDeptId = (Long)attributes.get("applicantDeptId");

		if (applicantDeptId != null) {
			setApplicantDeptId(applicantDeptId);
		}

		String applicantDeptName = (String)attributes.get("applicantDeptName");

		if (applicantDeptName != null) {
			setApplicantDeptName(applicantDeptName);
		}

		Long applicantId = (Long)attributes.get("applicantId");

		if (applicantId != null) {
			setApplicantId(applicantId);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Integer passengerNum = (Integer)attributes.get("passengerNum");

		if (passengerNum != null) {
			setPassengerNum(passengerNum);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String destination = (String)attributes.get("destination");

		if (destination != null) {
			setDestination(destination);
		}
	}

	/**
	* Returns the primary key of this vehicle requisition.
	*
	* @return the primary key of this vehicle requisition
	*/
	@Override
	public long getPrimaryKey() {
		return _vehicleRequisition.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vehicle requisition.
	*
	* @param primaryKey the primary key of this vehicle requisition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vehicleRequisition.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vehicle requisition ID of this vehicle requisition.
	*
	* @return the vehicle requisition ID of this vehicle requisition
	*/
	@Override
	public long getVehicleRequisitionId() {
		return _vehicleRequisition.getVehicleRequisitionId();
	}

	/**
	* Sets the vehicle requisition ID of this vehicle requisition.
	*
	* @param vehicleRequisitionId the vehicle requisition ID of this vehicle requisition
	*/
	@Override
	public void setVehicleRequisitionId(long vehicleRequisitionId) {
		_vehicleRequisition.setVehicleRequisitionId(vehicleRequisitionId);
	}

	/**
	* Returns the user ID of this vehicle requisition.
	*
	* @return the user ID of this vehicle requisition
	*/
	@Override
	public long getUserId() {
		return _vehicleRequisition.getUserId();
	}

	/**
	* Sets the user ID of this vehicle requisition.
	*
	* @param userId the user ID of this vehicle requisition
	*/
	@Override
	public void setUserId(long userId) {
		_vehicleRequisition.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vehicle requisition.
	*
	* @return the user uuid of this vehicle requisition
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisition.getUserUuid();
	}

	/**
	* Sets the user uuid of this vehicle requisition.
	*
	* @param userUuid the user uuid of this vehicle requisition
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vehicleRequisition.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vehicle requisition.
	*
	* @return the user name of this vehicle requisition
	*/
	@Override
	public java.lang.String getUserName() {
		return _vehicleRequisition.getUserName();
	}

	/**
	* Sets the user name of this vehicle requisition.
	*
	* @param userName the user name of this vehicle requisition
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vehicleRequisition.setUserName(userName);
	}

	/**
	* Returns the create time of this vehicle requisition.
	*
	* @return the create time of this vehicle requisition
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _vehicleRequisition.getCreateTime();
	}

	/**
	* Sets the create time of this vehicle requisition.
	*
	* @param createTime the create time of this vehicle requisition
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_vehicleRequisition.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this vehicle requisition.
	*
	* @return the modified time of this vehicle requisition
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _vehicleRequisition.getModifiedTime();
	}

	/**
	* Sets the modified time of this vehicle requisition.
	*
	* @param modifiedTime the modified time of this vehicle requisition
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_vehicleRequisition.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the applicant dept ID of this vehicle requisition.
	*
	* @return the applicant dept ID of this vehicle requisition
	*/
	@Override
	public long getApplicantDeptId() {
		return _vehicleRequisition.getApplicantDeptId();
	}

	/**
	* Sets the applicant dept ID of this vehicle requisition.
	*
	* @param applicantDeptId the applicant dept ID of this vehicle requisition
	*/
	@Override
	public void setApplicantDeptId(long applicantDeptId) {
		_vehicleRequisition.setApplicantDeptId(applicantDeptId);
	}

	/**
	* Returns the applicant dept name of this vehicle requisition.
	*
	* @return the applicant dept name of this vehicle requisition
	*/
	@Override
	public java.lang.String getApplicantDeptName() {
		return _vehicleRequisition.getApplicantDeptName();
	}

	/**
	* Sets the applicant dept name of this vehicle requisition.
	*
	* @param applicantDeptName the applicant dept name of this vehicle requisition
	*/
	@Override
	public void setApplicantDeptName(java.lang.String applicantDeptName) {
		_vehicleRequisition.setApplicantDeptName(applicantDeptName);
	}

	/**
	* Returns the applicant ID of this vehicle requisition.
	*
	* @return the applicant ID of this vehicle requisition
	*/
	@Override
	public long getApplicantId() {
		return _vehicleRequisition.getApplicantId();
	}

	/**
	* Sets the applicant ID of this vehicle requisition.
	*
	* @param applicantId the applicant ID of this vehicle requisition
	*/
	@Override
	public void setApplicantId(long applicantId) {
		_vehicleRequisition.setApplicantId(applicantId);
	}

	/**
	* Returns the applicant name of this vehicle requisition.
	*
	* @return the applicant name of this vehicle requisition
	*/
	@Override
	public java.lang.String getApplicantName() {
		return _vehicleRequisition.getApplicantName();
	}

	/**
	* Sets the applicant name of this vehicle requisition.
	*
	* @param applicantName the applicant name of this vehicle requisition
	*/
	@Override
	public void setApplicantName(java.lang.String applicantName) {
		_vehicleRequisition.setApplicantName(applicantName);
	}

	/**
	* Returns the start time of this vehicle requisition.
	*
	* @return the start time of this vehicle requisition
	*/
	@Override
	public java.util.Date getStartTime() {
		return _vehicleRequisition.getStartTime();
	}

	/**
	* Sets the start time of this vehicle requisition.
	*
	* @param startTime the start time of this vehicle requisition
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_vehicleRequisition.setStartTime(startTime);
	}

	/**
	* Returns the end time of this vehicle requisition.
	*
	* @return the end time of this vehicle requisition
	*/
	@Override
	public java.util.Date getEndTime() {
		return _vehicleRequisition.getEndTime();
	}

	/**
	* Sets the end time of this vehicle requisition.
	*
	* @param endTime the end time of this vehicle requisition
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_vehicleRequisition.setEndTime(endTime);
	}

	/**
	* Returns the passenger num of this vehicle requisition.
	*
	* @return the passenger num of this vehicle requisition
	*/
	@Override
	public int getPassengerNum() {
		return _vehicleRequisition.getPassengerNum();
	}

	/**
	* Sets the passenger num of this vehicle requisition.
	*
	* @param passengerNum the passenger num of this vehicle requisition
	*/
	@Override
	public void setPassengerNum(int passengerNum) {
		_vehicleRequisition.setPassengerNum(passengerNum);
	}

	/**
	* Returns the reason of this vehicle requisition.
	*
	* @return the reason of this vehicle requisition
	*/
	@Override
	public java.lang.String getReason() {
		return _vehicleRequisition.getReason();
	}

	/**
	* Sets the reason of this vehicle requisition.
	*
	* @param reason the reason of this vehicle requisition
	*/
	@Override
	public void setReason(java.lang.String reason) {
		_vehicleRequisition.setReason(reason);
	}

	/**
	* Returns the destination of this vehicle requisition.
	*
	* @return the destination of this vehicle requisition
	*/
	@Override
	public java.lang.String getDestination() {
		return _vehicleRequisition.getDestination();
	}

	/**
	* Sets the destination of this vehicle requisition.
	*
	* @param destination the destination of this vehicle requisition
	*/
	@Override
	public void setDestination(java.lang.String destination) {
		_vehicleRequisition.setDestination(destination);
	}

	@Override
	public boolean isNew() {
		return _vehicleRequisition.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vehicleRequisition.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vehicleRequisition.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vehicleRequisition.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vehicleRequisition.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vehicleRequisition.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vehicleRequisition.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vehicleRequisition.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vehicleRequisition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vehicleRequisition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vehicleRequisition.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VehicleRequisitionWrapper((VehicleRequisition)_vehicleRequisition.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.VehicleRequisition vehicleRequisition) {
		return _vehicleRequisition.compareTo(vehicleRequisition);
	}

	@Override
	public int hashCode() {
		return _vehicleRequisition.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.VehicleRequisition> toCacheModel() {
		return _vehicleRequisition.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.VehicleRequisition toEscapedModel() {
		return new VehicleRequisitionWrapper(_vehicleRequisition.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.VehicleRequisition toUnescapedModel() {
		return new VehicleRequisitionWrapper(_vehicleRequisition.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vehicleRequisition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vehicleRequisition.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vehicleRequisition.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VehicleRequisitionWrapper)) {
			return false;
		}

		VehicleRequisitionWrapper vehicleRequisitionWrapper = (VehicleRequisitionWrapper)obj;

		if (Validator.equals(_vehicleRequisition,
					vehicleRequisitionWrapper._vehicleRequisition)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VehicleRequisition getWrappedVehicleRequisition() {
		return _vehicleRequisition;
	}

	@Override
	public VehicleRequisition getWrappedModel() {
		return _vehicleRequisition;
	}

	@Override
	public void resetOriginalValues() {
		_vehicleRequisition.resetOriginalValues();
	}

	private VehicleRequisition _vehicleRequisition;
}