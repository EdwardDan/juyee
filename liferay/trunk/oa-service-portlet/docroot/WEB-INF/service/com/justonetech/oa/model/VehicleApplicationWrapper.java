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
 * This class is a wrapper for {@link VehicleApplication}.
 * </p>
 *
 * @author justonetech
 * @see VehicleApplication
 * @generated
 */
public class VehicleApplicationWrapper implements VehicleApplication,
	ModelWrapper<VehicleApplication> {
	public VehicleApplicationWrapper(VehicleApplication vehicleApplication) {
		_vehicleApplication = vehicleApplication;
	}

	@Override
	public Class<?> getModelClass() {
		return VehicleApplication.class;
	}

	@Override
	public String getModelClassName() {
		return VehicleApplication.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vehicleApplicationId", getVehicleApplicationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
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
		Long vehicleApplicationId = (Long)attributes.get("vehicleApplicationId");

		if (vehicleApplicationId != null) {
			setVehicleApplicationId(vehicleApplicationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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
	* Returns the primary key of this vehicle application.
	*
	* @return the primary key of this vehicle application
	*/
	@Override
	public long getPrimaryKey() {
		return _vehicleApplication.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vehicle application.
	*
	* @param primaryKey the primary key of this vehicle application
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vehicleApplication.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vehicle application ID of this vehicle application.
	*
	* @return the vehicle application ID of this vehicle application
	*/
	@Override
	public long getVehicleApplicationId() {
		return _vehicleApplication.getVehicleApplicationId();
	}

	/**
	* Sets the vehicle application ID of this vehicle application.
	*
	* @param vehicleApplicationId the vehicle application ID of this vehicle application
	*/
	@Override
	public void setVehicleApplicationId(long vehicleApplicationId) {
		_vehicleApplication.setVehicleApplicationId(vehicleApplicationId);
	}

	/**
	* Returns the group ID of this vehicle application.
	*
	* @return the group ID of this vehicle application
	*/
	@Override
	public long getGroupId() {
		return _vehicleApplication.getGroupId();
	}

	/**
	* Sets the group ID of this vehicle application.
	*
	* @param groupId the group ID of this vehicle application
	*/
	@Override
	public void setGroupId(long groupId) {
		_vehicleApplication.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vehicle application.
	*
	* @return the company ID of this vehicle application
	*/
	@Override
	public long getCompanyId() {
		return _vehicleApplication.getCompanyId();
	}

	/**
	* Sets the company ID of this vehicle application.
	*
	* @param companyId the company ID of this vehicle application
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vehicleApplication.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vehicle application.
	*
	* @return the user ID of this vehicle application
	*/
	@Override
	public long getUserId() {
		return _vehicleApplication.getUserId();
	}

	/**
	* Sets the user ID of this vehicle application.
	*
	* @param userId the user ID of this vehicle application
	*/
	@Override
	public void setUserId(long userId) {
		_vehicleApplication.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vehicle application.
	*
	* @return the user uuid of this vehicle application
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplication.getUserUuid();
	}

	/**
	* Sets the user uuid of this vehicle application.
	*
	* @param userUuid the user uuid of this vehicle application
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vehicleApplication.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vehicle application.
	*
	* @return the user name of this vehicle application
	*/
	@Override
	public java.lang.String getUserName() {
		return _vehicleApplication.getUserName();
	}

	/**
	* Sets the user name of this vehicle application.
	*
	* @param userName the user name of this vehicle application
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vehicleApplication.setUserName(userName);
	}

	/**
	* Returns the create time of this vehicle application.
	*
	* @return the create time of this vehicle application
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _vehicleApplication.getCreateTime();
	}

	/**
	* Sets the create time of this vehicle application.
	*
	* @param createTime the create time of this vehicle application
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_vehicleApplication.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this vehicle application.
	*
	* @return the modified time of this vehicle application
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _vehicleApplication.getModifiedTime();
	}

	/**
	* Sets the modified time of this vehicle application.
	*
	* @param modifiedTime the modified time of this vehicle application
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_vehicleApplication.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the applicant dept ID of this vehicle application.
	*
	* @return the applicant dept ID of this vehicle application
	*/
	@Override
	public long getApplicantDeptId() {
		return _vehicleApplication.getApplicantDeptId();
	}

	/**
	* Sets the applicant dept ID of this vehicle application.
	*
	* @param applicantDeptId the applicant dept ID of this vehicle application
	*/
	@Override
	public void setApplicantDeptId(long applicantDeptId) {
		_vehicleApplication.setApplicantDeptId(applicantDeptId);
	}

	/**
	* Returns the applicant dept name of this vehicle application.
	*
	* @return the applicant dept name of this vehicle application
	*/
	@Override
	public java.lang.String getApplicantDeptName() {
		return _vehicleApplication.getApplicantDeptName();
	}

	/**
	* Sets the applicant dept name of this vehicle application.
	*
	* @param applicantDeptName the applicant dept name of this vehicle application
	*/
	@Override
	public void setApplicantDeptName(java.lang.String applicantDeptName) {
		_vehicleApplication.setApplicantDeptName(applicantDeptName);
	}

	/**
	* Returns the applicant ID of this vehicle application.
	*
	* @return the applicant ID of this vehicle application
	*/
	@Override
	public long getApplicantId() {
		return _vehicleApplication.getApplicantId();
	}

	/**
	* Sets the applicant ID of this vehicle application.
	*
	* @param applicantId the applicant ID of this vehicle application
	*/
	@Override
	public void setApplicantId(long applicantId) {
		_vehicleApplication.setApplicantId(applicantId);
	}

	/**
	* Returns the applicant name of this vehicle application.
	*
	* @return the applicant name of this vehicle application
	*/
	@Override
	public java.lang.String getApplicantName() {
		return _vehicleApplication.getApplicantName();
	}

	/**
	* Sets the applicant name of this vehicle application.
	*
	* @param applicantName the applicant name of this vehicle application
	*/
	@Override
	public void setApplicantName(java.lang.String applicantName) {
		_vehicleApplication.setApplicantName(applicantName);
	}

	/**
	* Returns the start time of this vehicle application.
	*
	* @return the start time of this vehicle application
	*/
	@Override
	public java.util.Date getStartTime() {
		return _vehicleApplication.getStartTime();
	}

	/**
	* Sets the start time of this vehicle application.
	*
	* @param startTime the start time of this vehicle application
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_vehicleApplication.setStartTime(startTime);
	}

	/**
	* Returns the end time of this vehicle application.
	*
	* @return the end time of this vehicle application
	*/
	@Override
	public java.util.Date getEndTime() {
		return _vehicleApplication.getEndTime();
	}

	/**
	* Sets the end time of this vehicle application.
	*
	* @param endTime the end time of this vehicle application
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_vehicleApplication.setEndTime(endTime);
	}

	/**
	* Returns the passenger num of this vehicle application.
	*
	* @return the passenger num of this vehicle application
	*/
	@Override
	public int getPassengerNum() {
		return _vehicleApplication.getPassengerNum();
	}

	/**
	* Sets the passenger num of this vehicle application.
	*
	* @param passengerNum the passenger num of this vehicle application
	*/
	@Override
	public void setPassengerNum(int passengerNum) {
		_vehicleApplication.setPassengerNum(passengerNum);
	}

	/**
	* Returns the reason of this vehicle application.
	*
	* @return the reason of this vehicle application
	*/
	@Override
	public java.lang.String getReason() {
		return _vehicleApplication.getReason();
	}

	/**
	* Sets the reason of this vehicle application.
	*
	* @param reason the reason of this vehicle application
	*/
	@Override
	public void setReason(java.lang.String reason) {
		_vehicleApplication.setReason(reason);
	}

	/**
	* Returns the destination of this vehicle application.
	*
	* @return the destination of this vehicle application
	*/
	@Override
	public java.lang.String getDestination() {
		return _vehicleApplication.getDestination();
	}

	/**
	* Sets the destination of this vehicle application.
	*
	* @param destination the destination of this vehicle application
	*/
	@Override
	public void setDestination(java.lang.String destination) {
		_vehicleApplication.setDestination(destination);
	}

	@Override
	public boolean isNew() {
		return _vehicleApplication.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vehicleApplication.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vehicleApplication.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vehicleApplication.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vehicleApplication.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vehicleApplication.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vehicleApplication.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vehicleApplication.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vehicleApplication.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vehicleApplication.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vehicleApplication.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VehicleApplicationWrapper((VehicleApplication)_vehicleApplication.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.VehicleApplication vehicleApplication) {
		return _vehicleApplication.compareTo(vehicleApplication);
	}

	@Override
	public int hashCode() {
		return _vehicleApplication.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.VehicleApplication> toCacheModel() {
		return _vehicleApplication.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.VehicleApplication toEscapedModel() {
		return new VehicleApplicationWrapper(_vehicleApplication.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.VehicleApplication toUnescapedModel() {
		return new VehicleApplicationWrapper(_vehicleApplication.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vehicleApplication.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vehicleApplication.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vehicleApplication.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VehicleApplicationWrapper)) {
			return false;
		}

		VehicleApplicationWrapper vehicleApplicationWrapper = (VehicleApplicationWrapper)obj;

		if (Validator.equals(_vehicleApplication,
					vehicleApplicationWrapper._vehicleApplication)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VehicleApplication getWrappedVehicleApplication() {
		return _vehicleApplication;
	}

	@Override
	public VehicleApplication getWrappedModel() {
		return _vehicleApplication;
	}

	@Override
	public void resetOriginalValues() {
		_vehicleApplication.resetOriginalValues();
	}

	private VehicleApplication _vehicleApplication;
}