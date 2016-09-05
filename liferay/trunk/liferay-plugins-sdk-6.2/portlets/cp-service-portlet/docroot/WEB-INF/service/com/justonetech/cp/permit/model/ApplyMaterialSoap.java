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

package com.justonetech.cp.permit.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class ApplyMaterialSoap implements Serializable {
	public static ApplyMaterialSoap toSoapModel(ApplyMaterial model) {
		ApplyMaterialSoap soapModel = new ApplyMaterialSoap();

		soapModel.setMaterialId(model.getMaterialId());
		soapModel.setPermitId(model.getPermitId());
		soapModel.setXh(model.getXh());
		soapModel.setClmc(model.getClmc());
		soapModel.setYjfs(model.getYjfs());
		soapModel.setSjfs(model.getSjfs());

		return soapModel;
	}

	public static ApplyMaterialSoap[] toSoapModels(ApplyMaterial[] models) {
		ApplyMaterialSoap[] soapModels = new ApplyMaterialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplyMaterialSoap[][] toSoapModels(ApplyMaterial[][] models) {
		ApplyMaterialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplyMaterialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplyMaterialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplyMaterialSoap[] toSoapModels(List<ApplyMaterial> models) {
		List<ApplyMaterialSoap> soapModels = new ArrayList<ApplyMaterialSoap>(models.size());

		for (ApplyMaterial model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplyMaterialSoap[soapModels.size()]);
	}

	public ApplyMaterialSoap() {
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

	public String getPermitId() {
		return _permitId;
	}

	public void setPermitId(String permitId) {
		_permitId = permitId;
	}

	public int getXh() {
		return _xh;
	}

	public void setXh(int xh) {
		_xh = xh;
	}

	public String getClmc() {
		return _clmc;
	}

	public void setClmc(String clmc) {
		_clmc = clmc;
	}

	public int getYjfs() {
		return _yjfs;
	}

	public void setYjfs(int yjfs) {
		_yjfs = yjfs;
	}

	public int getSjfs() {
		return _sjfs;
	}

	public void setSjfs(int sjfs) {
		_sjfs = sjfs;
	}

	private long _materialId;
	private String _permitId;
	private int _xh;
	private String _clmc;
	private int _yjfs;
	private int _sjfs;
}