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
public class ConstructionUnitProjectSoap implements Serializable {
	public static ConstructionUnitProjectSoap toSoapModel(
		ConstructionUnitProject model) {
		ConstructionUnitProjectSoap soapModel = new ConstructionUnitProjectSoap();

		soapModel.setConstructionUnitProjectId(model.getConstructionUnitProjectId());
		soapModel.setSortNo(model.getSortNo());
		soapModel.setUnitProjectNum(model.getUnitProjectNum());
		soapModel.setUnitProjectName(model.getUnitProjectName());
		soapModel.setConstructionContent(model.getConstructionContent());
		soapModel.setConstructionPermitId(model.getConstructionPermitId());

		return soapModel;
	}

	public static ConstructionUnitProjectSoap[] toSoapModels(
		ConstructionUnitProject[] models) {
		ConstructionUnitProjectSoap[] soapModels = new ConstructionUnitProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConstructionUnitProjectSoap[][] toSoapModels(
		ConstructionUnitProject[][] models) {
		ConstructionUnitProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConstructionUnitProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConstructionUnitProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConstructionUnitProjectSoap[] toSoapModels(
		List<ConstructionUnitProject> models) {
		List<ConstructionUnitProjectSoap> soapModels = new ArrayList<ConstructionUnitProjectSoap>(models.size());

		for (ConstructionUnitProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConstructionUnitProjectSoap[soapModels.size()]);
	}

	public ConstructionUnitProjectSoap() {
	}

	public long getPrimaryKey() {
		return _constructionUnitProjectId;
	}

	public void setPrimaryKey(long pk) {
		setConstructionUnitProjectId(pk);
	}

	public long getConstructionUnitProjectId() {
		return _constructionUnitProjectId;
	}

	public void setConstructionUnitProjectId(long constructionUnitProjectId) {
		_constructionUnitProjectId = constructionUnitProjectId;
	}

	public int getSortNo() {
		return _sortNo;
	}

	public void setSortNo(int sortNo) {
		_sortNo = sortNo;
	}

	public String getUnitProjectNum() {
		return _unitProjectNum;
	}

	public void setUnitProjectNum(String unitProjectNum) {
		_unitProjectNum = unitProjectNum;
	}

	public String getUnitProjectName() {
		return _unitProjectName;
	}

	public void setUnitProjectName(String unitProjectName) {
		_unitProjectName = unitProjectName;
	}

	public String getConstructionContent() {
		return _constructionContent;
	}

	public void setConstructionContent(String constructionContent) {
		_constructionContent = constructionContent;
	}

	public long getConstructionPermitId() {
		return _constructionPermitId;
	}

	public void setConstructionPermitId(long constructionPermitId) {
		_constructionPermitId = constructionPermitId;
	}

	private long _constructionUnitProjectId;
	private int _sortNo;
	private String _unitProjectNum;
	private String _unitProjectName;
	private String _constructionContent;
	private long _constructionPermitId;
}