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
public class UnitProjectSoap implements Serializable {
	public static UnitProjectSoap toSoapModel(UnitProject model) {
		UnitProjectSoap soapModel = new UnitProjectSoap();

		soapModel.setProjectId(model.getProjectId());
		soapModel.setPermitId(model.getPermitId());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setGcbh(model.getGcbh());
		soapModel.setGcmc(model.getGcmc());
		soapModel.setJsnr(model.getJsnr());

		return soapModel;
	}

	public static UnitProjectSoap[] toSoapModels(UnitProject[] models) {
		UnitProjectSoap[] soapModels = new UnitProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UnitProjectSoap[][] toSoapModels(UnitProject[][] models) {
		UnitProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UnitProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UnitProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UnitProjectSoap[] toSoapModels(List<UnitProject> models) {
		List<UnitProjectSoap> soapModels = new ArrayList<UnitProjectSoap>(models.size());

		for (UnitProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UnitProjectSoap[soapModels.size()]);
	}

	public UnitProjectSoap() {
	}

	public long getPrimaryKey() {
		return _projectId;
	}

	public void setPrimaryKey(long pk) {
		setProjectId(pk);
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getPermitId() {
		return _permitId;
	}

	public void setPermitId(long permitId) {
		_permitId = permitId;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public String getGcbh() {
		return _gcbh;
	}

	public void setGcbh(String gcbh) {
		_gcbh = gcbh;
	}

	public String getGcmc() {
		return _gcmc;
	}

	public void setGcmc(String gcmc) {
		_gcmc = gcmc;
	}

	public String getJsnr() {
		return _jsnr;
	}

	public void setJsnr(String jsnr) {
		_jsnr = jsnr;
	}

	private long _projectId;
	private long _permitId;
	private String _bjbh;
	private String _gcbh;
	private String _gcmc;
	private String _jsnr;
}