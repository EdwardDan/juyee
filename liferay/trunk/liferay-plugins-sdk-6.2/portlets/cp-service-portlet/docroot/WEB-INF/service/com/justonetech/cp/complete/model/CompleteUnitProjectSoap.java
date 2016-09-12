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
public class CompleteUnitProjectSoap implements Serializable {
	public static CompleteUnitProjectSoap toSoapModel(CompleteUnitProject model) {
		CompleteUnitProjectSoap soapModel = new CompleteUnitProjectSoap();

		soapModel.setProjectId(model.getProjectId());
		soapModel.setCompleteId(model.getCompleteId());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setSgxkzbh(model.getSgxkzbh());
		soapModel.setGcbh(model.getGcbh());
		soapModel.setGcmc(model.getGcmc());
		soapModel.setJsnr(model.getJsnr());

		return soapModel;
	}

	public static CompleteUnitProjectSoap[] toSoapModels(
		CompleteUnitProject[] models) {
		CompleteUnitProjectSoap[] soapModels = new CompleteUnitProjectSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompleteUnitProjectSoap[][] toSoapModels(
		CompleteUnitProject[][] models) {
		CompleteUnitProjectSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompleteUnitProjectSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompleteUnitProjectSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompleteUnitProjectSoap[] toSoapModels(
		List<CompleteUnitProject> models) {
		List<CompleteUnitProjectSoap> soapModels = new ArrayList<CompleteUnitProjectSoap>(models.size());

		for (CompleteUnitProject model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompleteUnitProjectSoap[soapModels.size()]);
	}

	public CompleteUnitProjectSoap() {
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

	public long getCompleteId() {
		return _completeId;
	}

	public void setCompleteId(long completeId) {
		_completeId = completeId;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public String getSgxkzbh() {
		return _sgxkzbh;
	}

	public void setSgxkzbh(String sgxkzbh) {
		_sgxkzbh = sgxkzbh;
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
	private long _completeId;
	private String _bjbh;
	private String _sgxkzbh;
	private String _gcbh;
	private String _gcmc;
	private String _jsnr;
}