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

import com.justonetech.oa.service.persistence.LeaderWorkPK;

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
public class LeaderWorkSoap implements Serializable {
	public static LeaderWorkSoap toSoapModel(LeaderWork model) {
		LeaderWorkSoap soapModel = new LeaderWorkSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setWorkDate(model.getWorkDate());
		soapModel.setAmOrPm(model.getAmOrPm());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static LeaderWorkSoap[] toSoapModels(LeaderWork[] models) {
		LeaderWorkSoap[] soapModels = new LeaderWorkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LeaderWorkSoap[][] toSoapModels(LeaderWork[][] models) {
		LeaderWorkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LeaderWorkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LeaderWorkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LeaderWorkSoap[] toSoapModels(List<LeaderWork> models) {
		List<LeaderWorkSoap> soapModels = new ArrayList<LeaderWorkSoap>(models.size());

		for (LeaderWork model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LeaderWorkSoap[soapModels.size()]);
	}

	public LeaderWorkSoap() {
	}

	public LeaderWorkPK getPrimaryKey() {
		return new LeaderWorkPK(_userId, _workDate, _amOrPm);
	}

	public void setPrimaryKey(LeaderWorkPK pk) {
		setUserId(pk.userId);
		setWorkDate(pk.workDate);
		setAmOrPm(pk.amOrPm);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getWorkDate() {
		return _workDate;
	}

	public void setWorkDate(long workDate) {
		_workDate = workDate;
	}

	public long getAmOrPm() {
		return _amOrPm;
	}

	public void setAmOrPm(long amOrPm) {
		_amOrPm = amOrPm;
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

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private long _userId;
	private long _workDate;
	private long _amOrPm;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private String _content;
}