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
public class OfficeSupplyApplySoap implements Serializable {
	public static OfficeSupplyApplySoap toSoapModel(OfficeSupplyApply model) {
		OfficeSupplyApplySoap soapModel = new OfficeSupplyApplySoap();

		soapModel.setOfficeSupplyApplyId(model.getOfficeSupplyApplyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setDeptId(model.getDeptId());
		soapModel.setDeptName(model.getDeptName());
		soapModel.setApplicantId(model.getApplicantId());
		soapModel.setApplicantName(model.getApplicantName());
		soapModel.setIntroductions(model.getIntroductions());

		return soapModel;
	}

	public static OfficeSupplyApplySoap[] toSoapModels(
		OfficeSupplyApply[] models) {
		OfficeSupplyApplySoap[] soapModels = new OfficeSupplyApplySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplySoap[][] toSoapModels(
		OfficeSupplyApply[][] models) {
		OfficeSupplyApplySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSupplyApplySoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSupplyApplySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplySoap[] toSoapModels(
		List<OfficeSupplyApply> models) {
		List<OfficeSupplyApplySoap> soapModels = new ArrayList<OfficeSupplyApplySoap>(models.size());

		for (OfficeSupplyApply model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSupplyApplySoap[soapModels.size()]);
	}

	public OfficeSupplyApplySoap() {
	}

	public long getPrimaryKey() {
		return _officeSupplyApplyId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeSupplyApplyId(pk);
	}

	public long getOfficeSupplyApplyId() {
		return _officeSupplyApplyId;
	}

	public void setOfficeSupplyApplyId(long officeSupplyApplyId) {
		_officeSupplyApplyId = officeSupplyApplyId;
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

	public String getIntroductions() {
		return _introductions;
	}

	public void setIntroductions(String introductions) {
		_introductions = introductions;
	}

	private long _officeSupplyApplyId;
	private long _userId;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private long _applicantId;
	private String _applicantName;
	private String _introductions;
}