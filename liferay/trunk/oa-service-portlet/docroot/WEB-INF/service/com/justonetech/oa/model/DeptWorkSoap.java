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
public class DeptWorkSoap implements Serializable {
	public static DeptWorkSoap toSoapModel(DeptWork model) {
		DeptWorkSoap soapModel = new DeptWorkSoap();

		soapModel.setDeptWorkId(model.getDeptWorkId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setDeptId(model.getDeptId());
		soapModel.setDeptName(model.getDeptName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static DeptWorkSoap[] toSoapModels(DeptWork[] models) {
		DeptWorkSoap[] soapModels = new DeptWorkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeptWorkSoap[][] toSoapModels(DeptWork[][] models) {
		DeptWorkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeptWorkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeptWorkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeptWorkSoap[] toSoapModels(List<DeptWork> models) {
		List<DeptWorkSoap> soapModels = new ArrayList<DeptWorkSoap>(models.size());

		for (DeptWork model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeptWorkSoap[soapModels.size()]);
	}

	public DeptWorkSoap() {
	}

	public long getPrimaryKey() {
		return _deptWorkId;
	}

	public void setPrimaryKey(long pk) {
		setDeptWorkId(pk);
	}

	public long getDeptWorkId() {
		return _deptWorkId;
	}

	public void setDeptWorkId(long deptWorkId) {
		_deptWorkId = deptWorkId;
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

	public long getDeptId() {
		return _deptId;
	}

	public void setDeptId(long deptId) {
		_deptId = deptId;
	}

	public String getDeptName() {
		return _deptName;
	}

	public void setDeptName(String deptName) {
		_deptName = deptName;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _deptWorkId;
	private long _userId;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private Date _startDate;
	private Date _endDate;
	private String _status;
}