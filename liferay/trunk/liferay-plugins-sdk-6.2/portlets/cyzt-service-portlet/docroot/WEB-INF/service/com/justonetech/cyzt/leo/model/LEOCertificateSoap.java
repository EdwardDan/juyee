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

package com.justonetech.cyzt.leo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class LEOCertificateSoap implements Serializable {
	public static LEOCertificateSoap toSoapModel(LEOCertificate model) {
		LEOCertificateSoap soapModel = new LEOCertificateSoap();

		soapModel.setCertificateId(model.getCertificateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setXm(model.getXm());
		soapModel.setZylx(model.getZylx());
		soapModel.setYxq(model.getYxq());
		soapModel.setFzrq(model.getFzrq());

		return soapModel;
	}

	public static LEOCertificateSoap[] toSoapModels(LEOCertificate[] models) {
		LEOCertificateSoap[] soapModels = new LEOCertificateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LEOCertificateSoap[][] toSoapModels(LEOCertificate[][] models) {
		LEOCertificateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LEOCertificateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LEOCertificateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LEOCertificateSoap[] toSoapModels(List<LEOCertificate> models) {
		List<LEOCertificateSoap> soapModels = new ArrayList<LEOCertificateSoap>(models.size());

		for (LEOCertificate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LEOCertificateSoap[soapModels.size()]);
	}

	public LEOCertificateSoap() {
	}

	public String getPrimaryKey() {
		return _certificateId;
	}

	public void setPrimaryKey(String pk) {
		setCertificateId(pk);
	}

	public String getCertificateId() {
		return _certificateId;
	}

	public void setCertificateId(String certificateId) {
		_certificateId = certificateId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getXm() {
		return _xm;
	}

	public void setXm(String xm) {
		_xm = xm;
	}

	public String getZylx() {
		return _zylx;
	}

	public void setZylx(String zylx) {
		_zylx = zylx;
	}

	public Date getYxq() {
		return _yxq;
	}

	public void setYxq(Date yxq) {
		_yxq = yxq;
	}

	public Date getFzrq() {
		return _fzrq;
	}

	public void setFzrq(Date fzrq) {
		_fzrq = fzrq;
	}

	private String _certificateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _xm;
	private String _zylx;
	private Date _yxq;
	private Date _fzrq;
}