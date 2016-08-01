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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author justonetech
 * @generated
 */
public class VehicleApplicationSoap implements Serializable {
	public static VehicleApplicationSoap toSoapModel(VehicleApplication model) {
		VehicleApplicationSoap soapModel = new VehicleApplicationSoap();

		soapModel.setVehicleApplicationId(model.getVehicleApplicationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setApplicantDeptId(model.getApplicantDeptId());
		soapModel.setApplicantDeptName(model.getApplicantDeptName());
		soapModel.setApplicantId(model.getApplicantId());
		soapModel.setApplicantName(model.getApplicantName());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setPassengerNum(model.getPassengerNum());
		soapModel.setReason(model.getReason());
		soapModel.setDestination(model.getDestination());
		soapModel.setProposeVehicle(model.getProposeVehicle());
		soapModel.setIsProposeDriver(model.getIsProposeDriver());
		soapModel.setDriver(model.getDriver());
		soapModel.setPhone(model.getPhone());

		return soapModel;
	}

	public static VehicleApplicationSoap[] toSoapModels(
		VehicleApplication[] models) {
		VehicleApplicationSoap[] soapModels = new VehicleApplicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VehicleApplicationSoap[][] toSoapModels(
		VehicleApplication[][] models) {
		VehicleApplicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VehicleApplicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VehicleApplicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VehicleApplicationSoap[] toSoapModels(
		List<VehicleApplication> models) {
		List<VehicleApplicationSoap> soapModels = new ArrayList<VehicleApplicationSoap>(models.size());

		for (VehicleApplication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VehicleApplicationSoap[soapModels.size()]);
	}

	public VehicleApplicationSoap() {
	}

	public long getPrimaryKey() {
		return _vehicleApplicationId;
	}

	public void setPrimaryKey(long pk) {
		setVehicleApplicationId(pk);
	}

	public long getVehicleApplicationId() {
		return _vehicleApplicationId;
	}

	public void setVehicleApplicationId(long vehicleApplicationId) {
		_vehicleApplicationId = vehicleApplicationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateTime() {
		return _createTime;
	}

	public void setCreateTime(Date createTime) {
		_createTime = createTime;
	}

	public Date getModifiedTime() {
		return _modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		_modifiedTime = modifiedTime;
	}

	public long getApplicantDeptId() {
		return _applicantDeptId;
	}

	public void setApplicantDeptId(long applicantDeptId) {
		_applicantDeptId = applicantDeptId;
	}

	public String getApplicantDeptName() {
		return _applicantDeptName;
	}

	public void setApplicantDeptName(String applicantDeptName) {
		_applicantDeptName = applicantDeptName;
	}

	public long getApplicantId() {
		return _applicantId;
	}

	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;
	}

	public String getApplicantName() {
		return _applicantName;
	}

	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public int getPassengerNum() {
		return _passengerNum;
	}

	public void setPassengerNum(int passengerNum) {
		_passengerNum = passengerNum;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public String getDestination() {
		return _destination;
	}

	public void setDestination(String destination) {
		_destination = destination;
	}

	public long getProposeVehicle() {
		return _proposeVehicle;
	}

	public void setProposeVehicle(long proposeVehicle) {
		_proposeVehicle = proposeVehicle;
	}

	public int getIsProposeDriver() {
		return _isProposeDriver;
	}

	public void setIsProposeDriver(int isProposeDriver) {
		_isProposeDriver = isProposeDriver;
	}

	public String getDriver() {
		return _driver;
	}

	public void setDriver(String driver) {
		_driver = driver;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	private long _vehicleApplicationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
}