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

package com.justonetech.projApproval.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author justonetech
 * @generated
 */
public class ConstructionParticipantUnitsSoap implements Serializable {
	public static ConstructionParticipantUnitsSoap toSoapModel(
		ConstructionParticipantUnits model) {
		ConstructionParticipantUnitsSoap soapModel = new ConstructionParticipantUnitsSoap();

		soapModel.setConstructionParticipantUnitsId(model.getConstructionParticipantUnitsId());
		soapModel.setSortNo(model.getSortNo());
		soapModel.setContractInfoSubmitNum(model.getContractInfoSubmitNum());
		soapModel.setUnitType(model.getUnitType());
		soapModel.setUnitName(model.getUnitName());
		soapModel.setProjectLeader(model.getProjectLeader());
		soapModel.setTelephoneNum(model.getTelephoneNum());
		soapModel.setConstructionPermitId(model.getConstructionPermitId());

		return soapModel;
	}

	public static ConstructionParticipantUnitsSoap[] toSoapModels(
		ConstructionParticipantUnits[] models) {
		ConstructionParticipantUnitsSoap[] soapModels = new ConstructionParticipantUnitsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConstructionParticipantUnitsSoap[][] toSoapModels(
		ConstructionParticipantUnits[][] models) {
		ConstructionParticipantUnitsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConstructionParticipantUnitsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConstructionParticipantUnitsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConstructionParticipantUnitsSoap[] toSoapModels(
		List<ConstructionParticipantUnits> models) {
		List<ConstructionParticipantUnitsSoap> soapModels = new ArrayList<ConstructionParticipantUnitsSoap>(models.size());

		for (ConstructionParticipantUnits model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConstructionParticipantUnitsSoap[soapModels.size()]);
	}

	public ConstructionParticipantUnitsSoap() {
	}

	public long getPrimaryKey() {
		return _constructionParticipantUnitsId;
	}

	public void setPrimaryKey(long pk) {
		setConstructionParticipantUnitsId(pk);
	}

	public long getConstructionParticipantUnitsId() {
		return _constructionParticipantUnitsId;
	}

	public void setConstructionParticipantUnitsId(
		long constructionParticipantUnitsId) {
		_constructionParticipantUnitsId = constructionParticipantUnitsId;
	}

	public int getSortNo() {
		return _sortNo;
	}

	public void setSortNo(int sortNo) {
		_sortNo = sortNo;
	}

	public String getContractInfoSubmitNum() {
		return _contractInfoSubmitNum;
	}

	public void setContractInfoSubmitNum(String contractInfoSubmitNum) {
		_contractInfoSubmitNum = contractInfoSubmitNum;
	}

	public long getUnitType() {
		return _unitType;
	}

	public void setUnitType(long unitType) {
		_unitType = unitType;
	}

	public String getUnitName() {
		return _unitName;
	}

	public void setUnitName(String unitName) {
		_unitName = unitName;
	}

	public String getProjectLeader() {
		return _projectLeader;
	}

	public void setProjectLeader(String projectLeader) {
		_projectLeader = projectLeader;
	}

	public String getTelephoneNum() {
		return _telephoneNum;
	}

	public void setTelephoneNum(String telephoneNum) {
		_telephoneNum = telephoneNum;
	}

	public long getConstructionPermitId() {
		return _constructionPermitId;
	}

	public void setConstructionPermitId(long constructionPermitId) {
		_constructionPermitId = constructionPermitId;
	}

	private long _constructionParticipantUnitsId;
	private int _sortNo;
	private String _contractInfoSubmitNum;
	private long _unitType;
	private String _unitName;
	private String _projectLeader;
	private String _telephoneNum;
	private long _constructionPermitId;
}