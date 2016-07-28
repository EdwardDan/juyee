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
public class DispatchSoap implements Serializable {
	public static DispatchSoap toSoapModel(Dispatch model) {
		DispatchSoap soapModel = new DispatchSoap();

		soapModel.setDispatchId(model.getDispatchId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setRecordType(model.getRecordType());
		soapModel.setSecurityLevel(model.getSecurityLevel());
		soapModel.setOrganaAbbreviation(model.getOrganaAbbreviation());
		soapModel.setYear(model.getYear());
		soapModel.setSerialNo(model.getSerialNo());
		soapModel.setTitle(model.getTitle());
		soapModel.setSendOrgan(model.getSendOrgan());
		soapModel.setCcOrgan(model.getCcOrgan());
		soapModel.setWrittenOrgan(model.getWrittenOrgan());
		soapModel.setWrittenDate(model.getWrittenDate());
		soapModel.setUrgencyDegree(model.getUrgencyDegree());

		return soapModel;
	}

	public static DispatchSoap[] toSoapModels(Dispatch[] models) {
		DispatchSoap[] soapModels = new DispatchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DispatchSoap[][] toSoapModels(Dispatch[][] models) {
		DispatchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DispatchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DispatchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DispatchSoap[] toSoapModels(List<Dispatch> models) {
		List<DispatchSoap> soapModels = new ArrayList<DispatchSoap>(models.size());

		for (Dispatch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DispatchSoap[soapModels.size()]);
	}

	public DispatchSoap() {
	}

	public long getPrimaryKey() {
		return _dispatchId;
	}

	public void setPrimaryKey(long pk) {
		setDispatchId(pk);
	}

	public long getDispatchId() {
		return _dispatchId;
	}

	public void setDispatchId(long dispatchId) {
		_dispatchId = dispatchId;
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

	public long getRecordType() {
		return _recordType;
	}

	public void setRecordType(long recordType) {
		_recordType = recordType;
	}

	public long getSecurityLevel() {
		return _securityLevel;
	}

	public void setSecurityLevel(long securityLevel) {
		_securityLevel = securityLevel;
	}

	public long getOrganaAbbreviation() {
		return _organaAbbreviation;
	}

	public void setOrganaAbbreviation(long organaAbbreviation) {
		_organaAbbreviation = organaAbbreviation;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public int getSerialNo() {
		return _serialNo;
	}

	public void setSerialNo(int serialNo) {
		_serialNo = serialNo;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getSendOrgan() {
		return _sendOrgan;
	}

	public void setSendOrgan(String sendOrgan) {
		_sendOrgan = sendOrgan;
	}

	public String getCcOrgan() {
		return _ccOrgan;
	}

	public void setCcOrgan(String ccOrgan) {
		_ccOrgan = ccOrgan;
	}

	public String getWrittenOrgan() {
		return _writtenOrgan;
	}

	public void setWrittenOrgan(String writtenOrgan) {
		_writtenOrgan = writtenOrgan;
	}

	public Date getWrittenDate() {
		return _writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		_writtenDate = writtenDate;
	}

	public long getUrgencyDegree() {
		return _urgencyDegree;
	}

	public void setUrgencyDegree(long urgencyDegree) {
		_urgencyDegree = urgencyDegree;
	}

	private long _dispatchId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _recordType;
	private long _securityLevel;
	private long _organaAbbreviation;
	private int _year;
	private int _serialNo;
	private String _title;
	private String _sendOrgan;
	private String _ccOrgan;
	private String _writtenOrgan;
	private Date _writtenDate;
	private long _urgencyDegree;
}