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
public class ParticipationUnitSoap implements Serializable {
	public static ParticipationUnitSoap toSoapModel(ParticipationUnit model) {
		ParticipationUnitSoap soapModel = new ParticipationUnitSoap();

		soapModel.setUnitId(model.getUnitId());
		soapModel.setPermitId(model.getPermitId());
		soapModel.setHtxxbsbh(model.getHtxxbsbh());
		soapModel.setDwlx(model.getDwlx());
		soapModel.setDwmc(model.getDwmc());
		soapModel.setXmfzr(model.getXmfzr());
		soapModel.setDhhm(model.getDhhm());

		return soapModel;
	}

	public static ParticipationUnitSoap[] toSoapModels(
		ParticipationUnit[] models) {
		ParticipationUnitSoap[] soapModels = new ParticipationUnitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParticipationUnitSoap[][] toSoapModels(
		ParticipationUnit[][] models) {
		ParticipationUnitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParticipationUnitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParticipationUnitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParticipationUnitSoap[] toSoapModels(
		List<ParticipationUnit> models) {
		List<ParticipationUnitSoap> soapModels = new ArrayList<ParticipationUnitSoap>(models.size());

		for (ParticipationUnit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParticipationUnitSoap[soapModels.size()]);
	}

	public ParticipationUnitSoap() {
	}

	public long getPrimaryKey() {
		return _unitId;
	}

	public void setPrimaryKey(long pk) {
		setUnitId(pk);
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public String getPermitId() {
		return _permitId;
	}

	public void setPermitId(String permitId) {
		_permitId = permitId;
	}

	public String getHtxxbsbh() {
		return _htxxbsbh;
	}

	public void setHtxxbsbh(String htxxbsbh) {
		_htxxbsbh = htxxbsbh;
	}

	public String getDwlx() {
		return _dwlx;
	}

	public void setDwlx(String dwlx) {
		_dwlx = dwlx;
	}

	public String getDwmc() {
		return _dwmc;
	}

	public void setDwmc(String dwmc) {
		_dwmc = dwmc;
	}

	public String getXmfzr() {
		return _xmfzr;
	}

	public void setXmfzr(String xmfzr) {
		_xmfzr = xmfzr;
	}

	public String getDhhm() {
		return _dhhm;
	}

	public void setDhhm(String dhhm) {
		_dhhm = dhhm;
	}

	private long _unitId;
	private String _permitId;
	private String _htxxbsbh;
	private String _dwlx;
	private String _dwmc;
	private String _xmfzr;
	private String _dhhm;
}