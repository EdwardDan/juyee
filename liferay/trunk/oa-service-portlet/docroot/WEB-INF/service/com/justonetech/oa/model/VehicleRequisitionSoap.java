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
public class VehicleRequisitionSoap implements Serializable {
	public static VehicleRequisitionSoap toSoapModel(VehicleRequisition model) {
		VehicleRequisitionSoap soapModel = new VehicleRequisitionSoap();

		soapModel.setVehicleRequisitionId(model.getVehicleRequisitionId());
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

		return soapModel;
	}

	public static VehicleRequisitionSoap[] toSoapModels(
		VehicleRequisition[] models) {
		VehicleRequisitionSoap[] soapModels = new VehicleRequisitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VehicleRequisitionSoap[][] toSoapModels(
		VehicleRequisition[][] models) {
		VehicleRequisitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VehicleRequisitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VehicleRequisitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VehicleRequisitionSoap[] toSoapModels(
		List<VehicleRequisition> models) {
		List<VehicleRequisitionSoap> soapModels = new ArrayList<VehicleRequisitionSoap>(models.size());

		for (VehicleRequisition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VehicleRequisitionSoap[soapModels.size()]);
	}

	public VehicleRequisitionSoap() {
	}

	public long getPrimaryKey() {
		return _vehicleRequisitionId;
	}

	public void setPrimaryKey(long pk) {
		setVehicleRequisitionId(pk);
	}

	public long getVehicleRequisitionId() {
		return _vehicleRequisitionId;
	}

	public void setVehicleRequisitionId(long vehicleRequisitionId) {
		_vehicleRequisitionId = vehicleRequisitionId;
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

	private long _vehicleRequisitionId;
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
}