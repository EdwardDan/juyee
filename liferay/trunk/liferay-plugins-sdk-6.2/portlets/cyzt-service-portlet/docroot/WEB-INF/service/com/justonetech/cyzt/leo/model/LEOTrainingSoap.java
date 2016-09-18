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

package com.justonetech.cyzt.leo.model;

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
public class LEOTrainingSoap implements Serializable {
	public static LEOTrainingSoap toSoapModel(LEOTraining model) {
		LEOTrainingSoap soapModel = new LEOTrainingSoap();

		soapModel.setTrainingId(model.getTrainingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setZjbh(model.getZjbh());
		soapModel.setPxsj(model.getPxsj());
		soapModel.setXcjysj(model.getXcjysj());
		soapModel.setPxnr(model.getPxnr());

		return soapModel;
	}

	public static LEOTrainingSoap[] toSoapModels(LEOTraining[] models) {
		LEOTrainingSoap[] soapModels = new LEOTrainingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LEOTrainingSoap[][] toSoapModels(LEOTraining[][] models) {
		LEOTrainingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LEOTrainingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LEOTrainingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LEOTrainingSoap[] toSoapModels(List<LEOTraining> models) {
		List<LEOTrainingSoap> soapModels = new ArrayList<LEOTrainingSoap>(models.size());

		for (LEOTraining model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LEOTrainingSoap[soapModels.size()]);
	}

	public LEOTrainingSoap() {
	}

	public long getPrimaryKey() {
		return _trainingId;
	}

	public void setPrimaryKey(long pk) {
		setTrainingId(pk);
	}

	public long getTrainingId() {
		return _trainingId;
	}

	public void setTrainingId(long trainingId) {
		_trainingId = trainingId;
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

	public String getZjbh() {
		return _zjbh;
	}

	public void setZjbh(String zjbh) {
		_zjbh = zjbh;
	}

	public String getPxsj() {
		return _pxsj;
	}

	public void setPxsj(String pxsj) {
		_pxsj = pxsj;
	}

	public Date getXcjysj() {
		return _xcjysj;
	}

	public void setXcjysj(Date xcjysj) {
		_xcjysj = xcjysj;
	}

	public Date getPxnr() {
		return _pxnr;
	}

	public void setPxnr(Date pxnr) {
		_pxnr = pxnr;
	}

	private long _trainingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _zjbh;
	private String _pxsj;
	private Date _xcjysj;
	private Date _pxnr;
}