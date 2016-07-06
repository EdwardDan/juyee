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
public class OfficeSupplyRequisitionSoap implements Serializable {
	public static OfficeSupplyRequisitionSoap toSoapModel(
		OfficeSupplyRequisition model) {
		OfficeSupplyRequisitionSoap soapModel = new OfficeSupplyRequisitionSoap();

		soapModel.setOfficeSupplyRequisitionId(model.getOfficeSupplyRequisitionId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setDeptId(model.getDeptId());
		soapModel.setDeptName(model.getDeptName());
		soapModel.setIntroductions(model.getIntroductions());

		return soapModel;
	}

	public static OfficeSupplyRequisitionSoap[] toSoapModels(
		OfficeSupplyRequisition[] models) {
		OfficeSupplyRequisitionSoap[] soapModels = new OfficeSupplyRequisitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyRequisitionSoap[][] toSoapModels(
		OfficeSupplyRequisition[][] models) {
		OfficeSupplyRequisitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSupplyRequisitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSupplyRequisitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyRequisitionSoap[] toSoapModels(
		List<OfficeSupplyRequisition> models) {
		List<OfficeSupplyRequisitionSoap> soapModels = new ArrayList<OfficeSupplyRequisitionSoap>(models.size());

		for (OfficeSupplyRequisition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSupplyRequisitionSoap[soapModels.size()]);
	}

	public OfficeSupplyRequisitionSoap() {
	}

	public long getPrimaryKey() {
		return _officeSupplyRequisitionId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeSupplyRequisitionId(pk);
	}

	public long getOfficeSupplyRequisitionId() {
		return _officeSupplyRequisitionId;
	}

	public void setOfficeSupplyRequisitionId(long officeSupplyRequisitionId) {
		_officeSupplyRequisitionId = officeSupplyRequisitionId;
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

	public String getIntroductions() {
		return _introductions;
	}

	public void setIntroductions(String introductions) {
		_introductions = introductions;
	}

	private long _officeSupplyRequisitionId;
	private long _userId;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private String _introductions;
}