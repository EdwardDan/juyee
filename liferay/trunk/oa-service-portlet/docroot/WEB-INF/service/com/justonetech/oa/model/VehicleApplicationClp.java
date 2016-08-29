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

import com.justonetech.oa.service.ClpSerializer;
import com.justonetech.oa.service.VehicleApplicationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author justonetech
 */
public class VehicleApplicationClp extends BaseModelImpl<VehicleApplication>
	implements VehicleApplication {
	public VehicleApplicationClp() {
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
	public long getPrimaryKey() {
		return _vehicleApplicationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVehicleApplicationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vehicleApplicationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getVehicleApplicationId() {
		return _vehicleApplicationId;
	}

	@Override
	public void setVehicleApplicationId(long vehicleApplicationId) {
		_vehicleApplicationId = vehicleApplicationId;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setVehicleApplicationId",
						long.class);

				method.invoke(_vehicleApplicationRemoteModel,
					vehicleApplicationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vehicleApplicationRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vehicleApplicationRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		_createTime = createTime;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_vehicleApplicationRemoteModel, createTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(Date modifiedTime) {
		_modifiedTime = modifiedTime;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_vehicleApplicationRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicantDeptId() {
		return _applicantDeptId;
	}

	@Override
	public void setApplicantDeptId(long applicantDeptId) {
		_applicantDeptId = applicantDeptId;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantDeptId", long.class);

				method.invoke(_vehicleApplicationRemoteModel, applicantDeptId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicantDeptName() {
		return _applicantDeptName;
	}

	@Override
	public void setApplicantDeptName(String applicantDeptName) {
		_applicantDeptName = applicantDeptName;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantDeptName",
						String.class);

				method.invoke(_vehicleApplicationRemoteModel, applicantDeptName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicantId() {
		return _applicantId;
	}

	@Override
	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantId", long.class);

				method.invoke(_vehicleApplicationRemoteModel, applicantId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicantName() {
		return _applicantName;
	}

	@Override
	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicantName", String.class);

				method.invoke(_vehicleApplicationRemoteModel, applicantName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_vehicleApplicationRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_vehicleApplicationRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPassengerNum() {
		return _passengerNum;
	}

	@Override
	public void setPassengerNum(int passengerNum) {
		_passengerNum = passengerNum;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPassengerNum", int.class);

				method.invoke(_vehicleApplicationRemoteModel, passengerNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReason() {
		return _reason;
	}

	@Override
	public void setReason(String reason) {
		_reason = reason;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setReason", String.class);

				method.invoke(_vehicleApplicationRemoteModel, reason);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDestination() {
		return _destination;
	}

	@Override
	public void setDestination(String destination) {
		_destination = destination;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setDestination", String.class);

				method.invoke(_vehicleApplicationRemoteModel, destination);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vehicleApplicationRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vehicleApplicationRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_vehicleApplicationRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_vehicleApplicationRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_vehicleApplicationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserId", long.class);

				method.invoke(_vehicleApplicationRemoteModel, statusByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusByUserName",
						String.class);

				method.invoke(_vehicleApplicationRemoteModel, statusByUserName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_vehicleApplicationRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProposeVehicle() {
		return _proposeVehicle;
	}

	@Override
	public void setProposeVehicle(long proposeVehicle) {
		_proposeVehicle = proposeVehicle;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setProposeVehicle", long.class);

				method.invoke(_vehicleApplicationRemoteModel, proposeVehicle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsProposeDriver() {
		return _isProposeDriver;
	}

	@Override
	public void setIsProposeDriver(int isProposeDriver) {
		_isProposeDriver = isProposeDriver;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsProposeDriver", int.class);

				method.invoke(_vehicleApplicationRemoteModel, isProposeDriver);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDriver() {
		return _driver;
	}

	@Override
	public void setDriver(String driver) {
		_driver = driver;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setDriver", String.class);

				method.invoke(_vehicleApplicationRemoteModel, driver);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_vehicleApplicationRemoteModel != null) {
			try {
				Class<?> clazz = _vehicleApplicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_vehicleApplicationRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public BaseModel<?> getVehicleApplicationRemoteModel() {
		return _vehicleApplicationRemoteModel;
	}

	public void setVehicleApplicationRemoteModel(
		BaseModel<?> vehicleApplicationRemoteModel) {
		_vehicleApplicationRemoteModel = vehicleApplicationRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _vehicleApplicationRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_vehicleApplicationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VehicleApplicationLocalServiceUtil.addVehicleApplication(this);
		}
		else {
			VehicleApplicationLocalServiceUtil.updateVehicleApplication(this);
		}
	}

	@Override
	public VehicleApplication toEscapedModel() {
		return (VehicleApplication)ProxyUtil.newProxyInstance(VehicleApplication.class.getClassLoader(),
			new Class[] { VehicleApplication.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VehicleApplicationClp clone = new VehicleApplicationClp();

		clone.setVehicleApplicationId(getVehicleApplicationId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setApplicantDeptId(getApplicantDeptId());
		clone.setApplicantDeptName(getApplicantDeptName());
		clone.setApplicantId(getApplicantId());
		clone.setApplicantName(getApplicantName());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setPassengerNum(getPassengerNum());
		clone.setReason(getReason());
		clone.setDestination(getDestination());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setStatus(getStatus());
		clone.setStatusByUserId(getStatusByUserId());
		clone.setStatusByUserName(getStatusByUserName());
		clone.setStatusDate(getStatusDate());
		clone.setProposeVehicle(getProposeVehicle());
		clone.setIsProposeDriver(getIsProposeDriver());
		clone.setDriver(getDriver());
		clone.setPhone(getPhone());

		return clone;
	}

	@Override
	public int compareTo(VehicleApplication vehicleApplication) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedTime(),
				vehicleApplication.getModifiedTime());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VehicleApplicationClp)) {
			return false;
		}

		VehicleApplicationClp vehicleApplication = (VehicleApplicationClp)obj;

		long primaryKey = vehicleApplication.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{vehicleApplicationId=");
		sb.append(getVehicleApplicationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", applicantDeptId=");
		sb.append(getApplicantDeptId());
		sb.append(", applicantDeptName=");
		sb.append(getApplicantDeptName());
		sb.append(", applicantId=");
		sb.append(getApplicantId());
		sb.append(", applicantName=");
		sb.append(getApplicantName());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", passengerNum=");
		sb.append(getPassengerNum());
		sb.append(", reason=");
		sb.append(getReason());
		sb.append(", destination=");
		sb.append(getDestination());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", proposeVehicle=");
		sb.append(getProposeVehicle());
		sb.append(", isProposeDriver=");
		sb.append(getIsProposeDriver());
		sb.append(", driver=");
		sb.append(getDriver());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.VehicleApplication");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vehicleApplicationId</column-name><column-value><![CDATA[");
		sb.append(getVehicleApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantDeptId</column-name><column-value><![CDATA[");
		sb.append(getApplicantDeptId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantDeptName</column-name><column-value><![CDATA[");
		sb.append(getApplicantDeptName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantId</column-name><column-value><![CDATA[");
		sb.append(getApplicantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantName</column-name><column-value><![CDATA[");
		sb.append(getApplicantName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passengerNum</column-name><column-value><![CDATA[");
		sb.append(getPassengerNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>destination</column-name><column-value><![CDATA[");
		sb.append(getDestination());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>proposeVehicle</column-name><column-value><![CDATA[");
		sb.append(getProposeVehicle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isProposeDriver</column-name><column-value><![CDATA[");
		sb.append(getIsProposeDriver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>driver</column-name><column-value><![CDATA[");
		sb.append(getDriver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _vehicleApplicationId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _applicantDeptId;
	private String _applicantDeptName;
	private long _applicantId;
	private String _applicantName;
	private Date _startTime;
	private Date _endTime;
	private int _passengerNum;
	private String _reason;
	private String _destination;
	private long _companyId;
	private long _groupId;
	private String _title;
	private String _content;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private long _proposeVehicle;
	private int _isProposeDriver;
	private String _driver;
	private String _phone;
	private BaseModel<?> _vehicleApplicationRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}