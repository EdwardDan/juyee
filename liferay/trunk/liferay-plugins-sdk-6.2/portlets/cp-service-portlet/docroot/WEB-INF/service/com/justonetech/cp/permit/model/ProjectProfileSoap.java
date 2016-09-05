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
public class ProjectProfileSoap implements Serializable {
	public static ProjectProfileSoap toSoapModel(ProjectProfile model) {
		ProjectProfileSoap soapModel = new ProjectProfileSoap();

		soapModel.setPermitId(model.getPermitId());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setJsdwmc(model.getJsdwmc());
		soapModel.setJsdwxz(model.getJsdwxz());
		soapModel.setJsdwdz(model.getJsdwdz());
		soapModel.setGcmc(model.getGcmc());
		soapModel.setJsdd(model.getJsdd());
		soapModel.setJsgcgm(model.getJsgcgm());
		soapModel.setFwjzmj(model.getFwjzmj());
		soapModel.setHtjg(model.getHtjg());
		soapModel.setHtgq(model.getHtgq());
		soapModel.setFddbr(model.getFddbr());
		soapModel.setJsdwlxdh(model.getJsdwlxdh());
		soapModel.setJsdwlxr(model.getJsdwlxr());
		soapModel.setJsdwsjh(model.getJsdwsjh());
		soapModel.setJsydpzwjhfdccqzbh(model.getJsydpzwjhfdccqzbh());
		soapModel.setJsgcghxkzbh(model.getJsgcghxkzbh());
		soapModel.setXckgqk(model.getXckgqk());

		return soapModel;
	}

	public static ProjectProfileSoap[] toSoapModels(ProjectProfile[] models) {
		ProjectProfileSoap[] soapModels = new ProjectProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectProfileSoap[][] toSoapModels(ProjectProfile[][] models) {
		ProjectProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProjectProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectProfileSoap[] toSoapModels(List<ProjectProfile> models) {
		List<ProjectProfileSoap> soapModels = new ArrayList<ProjectProfileSoap>(models.size());

		for (ProjectProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectProfileSoap[soapModels.size()]);
	}

	public ProjectProfileSoap() {
	}

	public long getPrimaryKey() {
		return _permitId;
	}

	public void setPrimaryKey(long pk) {
		setPermitId(pk);
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

	public String getJsdwmc() {
		return _jsdwmc;
	}

	public void setJsdwmc(String jsdwmc) {
		_jsdwmc = jsdwmc;
	}

	public String getJsdwxz() {
		return _jsdwxz;
	}

	public void setJsdwxz(String jsdwxz) {
		_jsdwxz = jsdwxz;
	}

	public String getJsdwdz() {
		return _jsdwdz;
	}

	public void setJsdwdz(String jsdwdz) {
		_jsdwdz = jsdwdz;
	}

	public String getGcmc() {
		return _gcmc;
	}

	public void setGcmc(String gcmc) {
		_gcmc = gcmc;
	}

	public String getJsdd() {
		return _jsdd;
	}

	public void setJsdd(String jsdd) {
		_jsdd = jsdd;
	}

	public String getJsgcgm() {
		return _jsgcgm;
	}

	public void setJsgcgm(String jsgcgm) {
		_jsgcgm = jsgcgm;
	}

	public String getFwjzmj() {
		return _fwjzmj;
	}

	public void setFwjzmj(String fwjzmj) {
		_fwjzmj = fwjzmj;
	}

	public String getHtjg() {
		return _htjg;
	}

	public void setHtjg(String htjg) {
		_htjg = htjg;
	}

	public int getHtgq() {
		return _htgq;
	}

	public void setHtgq(int htgq) {
		_htgq = htgq;
	}

	public String getFddbr() {
		return _fddbr;
	}

	public void setFddbr(String fddbr) {
		_fddbr = fddbr;
	}

	public String getJsdwlxdh() {
		return _jsdwlxdh;
	}

	public void setJsdwlxdh(String jsdwlxdh) {
		_jsdwlxdh = jsdwlxdh;
	}

	public String getJsdwlxr() {
		return _jsdwlxr;
	}

	public void setJsdwlxr(String jsdwlxr) {
		_jsdwlxr = jsdwlxr;
	}

	public String getJsdwsjh() {
		return _jsdwsjh;
	}

	public void setJsdwsjh(String jsdwsjh) {
		_jsdwsjh = jsdwsjh;
	}

	public String getJsydpzwjhfdccqzbh() {
		return _jsydpzwjhfdccqzbh;
	}

	public void setJsydpzwjhfdccqzbh(String jsydpzwjhfdccqzbh) {
		_jsydpzwjhfdccqzbh = jsydpzwjhfdccqzbh;
	}

	public String getJsgcghxkzbh() {
		return _jsgcghxkzbh;
	}

	public void setJsgcghxkzbh(String jsgcghxkzbh) {
		_jsgcghxkzbh = jsgcghxkzbh;
	}

	public String getXckgqk() {
		return _xckgqk;
	}

	public void setXckgqk(String xckgqk) {
		_xckgqk = xckgqk;
	}

	private long _permitId;
	private String _bjbh;
	private String _jsdwmc;
	private String _jsdwxz;
	private String _jsdwdz;
	private String _gcmc;
	private String _jsdd;
	private String _jsgcgm;
	private String _fwjzmj;
	private String _htjg;
	private int _htgq;
	private String _fddbr;
	private String _jsdwlxdh;
	private String _jsdwlxr;
	private String _jsdwsjh;
	private String _jsydpzwjhfdccqzbh;
	private String _jsgcghxkzbh;
	private String _xckgqk;
}