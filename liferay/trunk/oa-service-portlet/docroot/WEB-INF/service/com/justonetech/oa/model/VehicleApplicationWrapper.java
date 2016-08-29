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
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("proposeVehicle", getProposeVehicle());
		attributes.put("isProposeDriver", getIsProposeDriver());
		attributes.put("driver", getDriver());
		attributes.put("phone", getPhone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vehicleApplicationId = (Long)attributes.get("vehicleApplicationId");

		if (vehicleApplicationId != null) {
			setVehicleApplicationId(vehicleApplicationId);
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long proposeVehicle = (Long)attributes.get("proposeVehicle");

		if (proposeVehicle != null) {
			setProposeVehicle(proposeVehicle);
		}

		Integer isProposeDriver = (Integer)attributes.get("isProposeDriver");

		if (isProposeDriver != null) {
			setIsProposeDriver(isProposeDriver);
		}

		String driver = (String)attributes.get("driver");

		if (driver != null) {
			setDriver(driver);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
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
	* Returns the title of this vehicle application.
	*
	* @return the title of this vehicle application
	*/
	@Override
	public java.lang.String getTitle() {
		return _vehicleApplication.getTitle();
	}

	/**
	* Sets the title of this vehicle application.
	*
	* @param title the title of this vehicle application
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_vehicleApplication.setTitle(title);
	}

	/**
	* Returns the content of this vehicle application.
	*
	* @return the content of this vehicle application
	*/
	@Override
	public java.lang.String getContent() {
		return _vehicleApplication.getContent();
	}

	/**
	* Sets the content of this vehicle application.
	*
	* @param content the content of this vehicle application
	*/
	@Override
	public void setContent(java.lang.String content) {
		_vehicleApplication.setContent(content);
	}

	/**
	* Returns the status of this vehicle application.
	*
	* @return the status of this vehicle application
	*/
	@Override
	public int getStatus() {
		return _vehicleApplication.getStatus();
	}

	/**
	* Sets the status of this vehicle application.
	*
	* @param status the status of this vehicle application
	*/
	@Override
	public void setStatus(int status) {
		_vehicleApplication.setStatus(status);
	}

	/**
	* Returns the status by user ID of this vehicle application.
	*
	* @return the status by user ID of this vehicle application
	*/
	@Override
	public long getStatusByUserId() {
		return _vehicleApplication.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this vehicle application.
	*
	* @param statusByUserId the status by user ID of this vehicle application
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_vehicleApplication.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this vehicle application.
	*
	* @return the status by user uuid of this vehicle application
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplication.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this vehicle application.
	*
	* @param statusByUserUuid the status by user uuid of this vehicle application
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_vehicleApplication.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this vehicle application.
	*
	* @return the status by user name of this vehicle application
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _vehicleApplication.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this vehicle application.
	*
	* @param statusByUserName the status by user name of this vehicle application
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_vehicleApplication.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this vehicle application.
	*
	* @return the status date of this vehicle application
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _vehicleApplication.getStatusDate();
	}

	/**
	* Sets the status date of this vehicle application.
	*
	* @param statusDate the status date of this vehicle application
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_vehicleApplication.setStatusDate(statusDate);
	}

	/**
	* Returns the propose vehicle of this vehicle application.
	*
	* @return the propose vehicle of this vehicle application
	*/
	@Override
	public long getProposeVehicle() {
		return _vehicleApplication.getProposeVehicle();
	}

	/**
	* Sets the propose vehicle of this vehicle application.
	*
	* @param proposeVehicle the propose vehicle of this vehicle application
	*/
	@Override
	public void setProposeVehicle(long proposeVehicle) {
		_vehicleApplication.setProposeVehicle(proposeVehicle);
	}

	/**
	* Returns the is propose driver of this vehicle application.
	*
	* @return the is propose driver of this vehicle application
	*/
	@Override
	public int getIsProposeDriver() {
		return _vehicleApplication.getIsProposeDriver();
	}

	/**
	* Sets the is propose driver of this vehicle application.
	*
	* @param isProposeDriver the is propose driver of this vehicle application
	*/
	@Override
	public void setIsProposeDriver(int isProposeDriver) {
		_vehicleApplication.setIsProposeDriver(isProposeDriver);
	}

	/**
	* Returns the driver of this vehicle application.
	*
	* @return the driver of this vehicle application
	*/
	@Override
	public java.lang.String getDriver() {
		return _vehicleApplication.getDriver();
	}

	/**
	* Sets the driver of this vehicle application.
	*
	* @param driver the driver of this vehicle application
	*/
	@Override
	public void setDriver(java.lang.String driver) {
		_vehicleApplication.setDriver(driver);
	}

	/**
	* Returns the phone of this vehicle application.
	*
	* @return the phone of this vehicle application
	*/
	@Override
	public java.lang.String getPhone() {
		return _vehicleApplication.getPhone();
	}

	/**
	* Sets the phone of this vehicle application.
	*
	* @param phone the phone of this vehicle application
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_vehicleApplication.setPhone(phone);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _vehicleApplication.getApproved();
	}

	/**
	* Returns <code>true</code> if this vehicle application is approved.
	*
	* @return <code>true</code> if this vehicle application is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _vehicleApplication.isApproved();
	}

	/**
	* Returns <code>true</code> if this vehicle application is denied.
	*
	* @return <code>true</code> if this vehicle application is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _vehicleApplication.isDenied();
	}

	/**
	* Returns <code>true</code> if this vehicle application is a draft.
	*
	* @return <code>true</code> if this vehicle application is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _vehicleApplication.isDraft();
	}

	/**
	* Returns <code>true</code> if this vehicle application is expired.
	*
	* @return <code>true</code> if this vehicle application is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _vehicleApplication.isExpired();
	}

	/**
	* Returns <code>true</code> if this vehicle application is inactive.
	*
	* @return <code>true</code> if this vehicle application is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _vehicleApplication.isInactive();
	}

	/**
	* Returns <code>true</code> if this vehicle application is incomplete.
	*
	* @return <code>true</code> if this vehicle application is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _vehicleApplication.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this vehicle application is pending.
	*
	* @return <code>true</code> if this vehicle application is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _vehicleApplication.isPending();
	}

	/**
	* Returns <code>true</code> if this vehicle application is scheduled.
	*
	* @return <code>true</code> if this vehicle application is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _vehicleApplication.isScheduled();
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