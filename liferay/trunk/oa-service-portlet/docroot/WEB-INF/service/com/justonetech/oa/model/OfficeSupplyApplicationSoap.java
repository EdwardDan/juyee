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
public class OfficeSupplyApplicationSoap implements Serializable {
	public static OfficeSupplyApplicationSoap toSoapModel(
		OfficeSupplyApplication model) {
		OfficeSupplyApplicationSoap soapModel = new OfficeSupplyApplicationSoap();

		soapModel.setOfficeSupplyApplicationId(model.getOfficeSupplyApplicationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setDeptId(model.getDeptId());
		soapModel.setDeptName(model.getDeptName());
		soapModel.setIntroductions(model.getIntroductions());

		return soapModel;
	}

	public static OfficeSupplyApplicationSoap[] toSoapModels(
		OfficeSupplyApplication[] models) {
		OfficeSupplyApplicationSoap[] soapModels = new OfficeSupplyApplicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplicationSoap[][] toSoapModels(
		OfficeSupplyApplication[][] models) {
		OfficeSupplyApplicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSupplyApplicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSupplyApplicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplicationSoap[] toSoapModels(
		List<OfficeSupplyApplication> models) {
		List<OfficeSupplyApplicationSoap> soapModels = new ArrayList<OfficeSupplyApplicationSoap>(models.size());

		for (OfficeSupplyApplication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSupplyApplicationSoap[soapModels.size()]);
	}

	public OfficeSupplyApplicationSoap() {
	}

	public long getPrimaryKey() {
		return _officeSupplyApplicationId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeSupplyApplicationId(pk);
	}

	public long getOfficeSupplyApplicationId() {
		return _officeSupplyApplicationId;
	}

	public void setOfficeSupplyApplicationId(long officeSupplyApplicationId) {
		_officeSupplyApplicationId = officeSupplyApplicationId;
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

	private long _officeSupplyApplicationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private String _introductions;
}