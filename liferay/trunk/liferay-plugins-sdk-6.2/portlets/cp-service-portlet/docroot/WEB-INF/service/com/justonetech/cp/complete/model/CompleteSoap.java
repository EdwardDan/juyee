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

package com.justonetech.cp.complete.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class CompleteSoap implements Serializable {
	public static CompleteSoap toSoapModel(Complete model) {
		CompleteSoap soapModel = new CompleteSoap();

		soapModel.setCompleteId(model.getCompleteId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setZzjgdm(model.getZzjgdm());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setSqbz(model.getSqbz());
		soapModel.setSqzt(model.getSqzt());
		soapModel.setBabh(model.getBabh());

		return soapModel;
	}

	public static CompleteSoap[] toSoapModels(Complete[] models) {
		CompleteSoap[] soapModels = new CompleteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompleteSoap[][] toSoapModels(Complete[][] models) {
		CompleteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompleteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompleteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompleteSoap[] toSoapModels(List<Complete> models) {
		List<CompleteSoap> soapModels = new ArrayList<CompleteSoap>(models.size());

		for (Complete model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompleteSoap[soapModels.size()]);
	}

	public CompleteSoap() {
	}

	public long getPrimaryKey() {
		return _completeId;
	}

	public void setPrimaryKey(long pk) {
		setCompleteId(pk);
	}

	public long getCompleteId() {
		return _completeId;
	}

	public void setCompleteId(long completeId) {
		_completeId = completeId;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getZzjgdm() {
		return _zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		_zzjgdm = zzjgdm;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public int getSqbz() {
		return _sqbz;
	}

	public void setSqbz(int sqbz) {
		_sqbz = sqbz;
	}

	public int getSqzt() {
		return _sqzt;
	}

	public void setSqzt(int sqzt) {
		_sqzt = sqzt;
	}

	public String getBabh() {
		return _babh;
	}

	public void setBabh(String babh) {
		_babh = babh;
	}

	private long _completeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _zzjgdm;
	private String _bjbh;
	private int _sqbz;
	private int _sqzt;
	private String _babh;
}