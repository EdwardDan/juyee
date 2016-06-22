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

package com.justonetech.proj.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.justonetech.proj.service.http.CompanyServiceSoap}.
 *
 * @author fanqi
 * @see com.justonetech.proj.service.http.CompanyServiceSoap
 * @generated
 */
public class CompanySoap implements Serializable {
	public static CompanySoap toSoapModel(Company model) {
		CompanySoap soapModel = new CompanySoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setType(model.getType());
		soapModel.setUnitName(model.getUnitName());
		soapModel.setIndepLegal(model.getIndepLegal());
		soapModel.setIndepLegalTel(model.getIndepLegalTel());
		soapModel.setIndepLegalFax(model.getIndepLegalFax());
		soapModel.setIndepLegalPhone(model.getIndepLegalPhone());
		soapModel.setProjLegal(model.getProjLegal());
		soapModel.setProjLegalTel(model.getProjLegalTel());
		soapModel.setProjLegalFax(model.getProjLegalFax());
		soapModel.setProjLegalPhone(model.getProjLegalPhone());
		soapModel.setLinkman(model.getLinkman());
		soapModel.setLinkmanTel(model.getLinkmanTel());
		soapModel.setLinkmanFax(model.getLinkmanFax());
		soapModel.setLinkmanPhone(model.getLinkmanPhone());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setBiddingId(model.getBiddingId());

		return soapModel;
	}

	public static CompanySoap[] toSoapModels(Company[] models) {
		CompanySoap[] soapModels = new CompanySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompanySoap[][] toSoapModels(Company[][] models) {
		CompanySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompanySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompanySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompanySoap[] toSoapModels(List<Company> models) {
		List<CompanySoap> soapModels = new ArrayList<CompanySoap>(models.size());

		for (Company model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompanySoap[soapModels.size()]);
	}

	public CompanySoap() {
	}

	public long getPrimaryKey() {
		return _companyId;
	}

	public void setPrimaryKey(long pk) {
		setCompanyId(pk);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getType() {
		return _type;
	}

	public void setType(long type) {
		_type = type;
	}

	public String getUnitName() {
		return _unitName;
	}

	public void setUnitName(String unitName) {
		_unitName = unitName;
	}

	public String getIndepLegal() {
		return _indepLegal;
	}

	public void setIndepLegal(String indepLegal) {
		_indepLegal = indepLegal;
	}

	public String getIndepLegalTel() {
		return _indepLegalTel;
	}

	public void setIndepLegalTel(String indepLegalTel) {
		_indepLegalTel = indepLegalTel;
	}

	public String getIndepLegalFax() {
		return _indepLegalFax;
	}

	public void setIndepLegalFax(String indepLegalFax) {
		_indepLegalFax = indepLegalFax;
	}

	public String getIndepLegalPhone() {
		return _indepLegalPhone;
	}

	public void setIndepLegalPhone(String indepLegalPhone) {
		_indepLegalPhone = indepLegalPhone;
	}

	public String getProjLegal() {
		return _projLegal;
	}

	public void setProjLegal(String projLegal) {
		_projLegal = projLegal;
	}

	public String getProjLegalTel() {
		return _projLegalTel;
	}

	public void setProjLegalTel(String projLegalTel) {
		_projLegalTel = projLegalTel;
	}

	public String getProjLegalFax() {
		return _projLegalFax;
	}

	public void setProjLegalFax(String projLegalFax) {
		_projLegalFax = projLegalFax;
	}

	public String getProjLegalPhone() {
		return _projLegalPhone;
	}

	public void setProjLegalPhone(String projLegalPhone) {
		_projLegalPhone = projLegalPhone;
	}

	public String getLinkman() {
		return _linkman;
	}

	public void setLinkman(String linkman) {
		_linkman = linkman;
	}

	public String getLinkmanTel() {
		return _linkmanTel;
	}

	public void setLinkmanTel(String linkmanTel) {
		_linkmanTel = linkmanTel;
	}

	public String getLinkmanFax() {
		return _linkmanFax;
	}

	public void setLinkmanFax(String linkmanFax) {
		_linkmanFax = linkmanFax;
	}

	public String getLinkmanPhone() {
		return _linkmanPhone;
	}

	public void setLinkmanPhone(String linkmanPhone) {
		_linkmanPhone = linkmanPhone;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getBiddingId() {
		return _biddingId;
	}

	public void setBiddingId(long biddingId) {
		_biddingId = biddingId;
	}

	private long _companyId;
	private long _type;
	private String _unitName;
	private String _indepLegal;
	private String _indepLegalTel;
	private String _indepLegalFax;
	private String _indepLegalPhone;
	private String _projLegal;
	private String _projLegalTel;
	private String _projLegalFax;
	private String _projLegalPhone;
	private String _linkman;
	private String _linkmanTel;
	private String _linkmanFax;
	private String _linkmanPhone;
	private long _projectId;
	private long _biddingId;
}