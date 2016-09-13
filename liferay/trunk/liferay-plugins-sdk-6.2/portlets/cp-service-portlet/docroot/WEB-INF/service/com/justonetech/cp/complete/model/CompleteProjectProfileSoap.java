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
public class CompleteProjectProfileSoap implements Serializable {
	public static CompleteProjectProfileSoap toSoapModel(
		CompleteProjectProfile model) {
		CompleteProjectProfileSoap soapModel = new CompleteProjectProfileSoap();

		soapModel.setCompleteId(model.getCompleteId());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setXmlx(model.getXmlx());
		soapModel.setJsgcsx(model.getJsgcsx());
		soapModel.setGcmc(model.getGcmc());
		soapModel.setJsdwmc(model.getJsdwmc());
		soapModel.setJsdwdz(model.getJsdwdz());
		soapModel.setJsdd(model.getJsdd());
		soapModel.setSzqx(model.getSzqx());
		soapModel.setFddbr(model.getFddbr());
		soapModel.setLxr(model.getLxr());
		soapModel.setLxdh(model.getLxdh());
		soapModel.setBz(model.getBz());

		return soapModel;
	}

	public static CompleteProjectProfileSoap[] toSoapModels(
		CompleteProjectProfile[] models) {
		CompleteProjectProfileSoap[] soapModels = new CompleteProjectProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompleteProjectProfileSoap[][] toSoapModels(
		CompleteProjectProfile[][] models) {
		CompleteProjectProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompleteProjectProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompleteProjectProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompleteProjectProfileSoap[] toSoapModels(
		List<CompleteProjectProfile> models) {
		List<CompleteProjectProfileSoap> soapModels = new ArrayList<CompleteProjectProfileSoap>(models.size());

		for (CompleteProjectProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompleteProjectProfileSoap[soapModels.size()]);
	}

	public CompleteProjectProfileSoap() {
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

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public long getXmlx() {
		return _xmlx;
	}

	public void setXmlx(long xmlx) {
		_xmlx = xmlx;
	}

	public long getJsgcsx() {
		return _jsgcsx;
	}

	public void setJsgcsx(long jsgcsx) {
		_jsgcsx = jsgcsx;
	}

	public String getGcmc() {
		return _gcmc;
	}

	public void setGcmc(String gcmc) {
		_gcmc = gcmc;
	}

	public String getJsdwmc() {
		return _jsdwmc;
	}

	public void setJsdwmc(String jsdwmc) {
		_jsdwmc = jsdwmc;
	}

	public String getJsdwdz() {
		return _jsdwdz;
	}

	public void setJsdwdz(String jsdwdz) {
		_jsdwdz = jsdwdz;
	}

	public String getJsdd() {
		return _jsdd;
	}

	public void setJsdd(String jsdd) {
		_jsdd = jsdd;
	}

	public String getSzqx() {
		return _szqx;
	}

	public void setSzqx(String szqx) {
		_szqx = szqx;
	}

	public String getFddbr() {
		return _fddbr;
	}

	public void setFddbr(String fddbr) {
		_fddbr = fddbr;
	}

	public String getLxr() {
		return _lxr;
	}

	public void setLxr(String lxr) {
		_lxr = lxr;
	}

	public String getLxdh() {
		return _lxdh;
	}

	public void setLxdh(String lxdh) {
		_lxdh = lxdh;
	}

	public String getBz() {
		return _bz;
	}

	public void setBz(String bz) {
		_bz = bz;
	}

	private long _completeId;
	private String _bjbh;
	private long _xmlx;
	private long _jsgcsx;
	private String _gcmc;
	private String _jsdwmc;
	private String _jsdwdz;
	private String _jsdd;
	private String _szqx;
	private String _fddbr;
	private String _lxr;
	private String _lxdh;
	private String _bz;
}