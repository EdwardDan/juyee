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
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
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
		StringBundler sb = new StringBundler(41);

		sb.append("{vehicleApplicationId=");
		sb.append(getVehicleApplicationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
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
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.VehicleApplication");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vehicleApplicationId</column-name><column-value><![CDATA[");
		sb.append(getVehicleApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
	private long _groupId;
	private long _companyId;
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
	private long _proposeVehicle;
	private int _isProposeDriver;
	private String _driver;
	private String _phone;
	private BaseModel<?> _vehicleApplicationRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}