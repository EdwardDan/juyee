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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class CompleteApplyMaterialSoap implements Serializable {
	public static CompleteApplyMaterialSoap toSoapModel(
		CompleteApplyMaterial model) {
		CompleteApplyMaterialSoap soapModel = new CompleteApplyMaterialSoap();

		soapModel.setMaterialId(model.getMaterialId());
		soapModel.setCompleteId(model.getCompleteId());
		soapModel.setXh(model.getXh());
		soapModel.setClmc(model.getClmc());
		soapModel.setFileEntryIds(model.getFileEntryIds());

		return soapModel;
	}

	public static CompleteApplyMaterialSoap[] toSoapModels(
		CompleteApplyMaterial[] models) {
		CompleteApplyMaterialSoap[] soapModels = new CompleteApplyMaterialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompleteApplyMaterialSoap[][] toSoapModels(
		CompleteApplyMaterial[][] models) {
		CompleteApplyMaterialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompleteApplyMaterialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompleteApplyMaterialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompleteApplyMaterialSoap[] toSoapModels(
		List<CompleteApplyMaterial> models) {
		List<CompleteApplyMaterialSoap> soapModels = new ArrayList<CompleteApplyMaterialSoap>(models.size());

		for (CompleteApplyMaterial model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompleteApplyMaterialSoap[soapModels.size()]);
	}

	public CompleteApplyMaterialSoap() {
	}

	public long getPrimaryKey() {
		return _materialId;
	}

	public void setPrimaryKey(long pk) {
		setMaterialId(pk);
	}

	public long getMaterialId() {
		return _materialId;
	}

	public void setMaterialId(long materialId) {
		_materialId = materialId;
	}

	public long getCompleteId() {
		return _completeId;
	}

	public void setCompleteId(long completeId) {
		_completeId = completeId;
	}

	public String getXh() {
		return _xh;
	}

	public void setXh(String xh) {
		_xh = xh;
	}

	public String getClmc() {
		return _clmc;
	}

	public void setClmc(String clmc) {
		_clmc = clmc;
	}

	public String getFileEntryIds() {
		return _fileEntryIds;
	}

	public void setFileEntryIds(String fileEntryIds) {
		_fileEntryIds = fileEntryIds;
	}

	private long _materialId;
	private long _completeId;
	private String _xh;
	private String _clmc;
	private String _fileEntryIds;
}