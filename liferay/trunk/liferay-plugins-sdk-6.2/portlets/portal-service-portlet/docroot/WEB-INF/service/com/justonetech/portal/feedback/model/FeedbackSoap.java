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

package com.justonetech.portal.feedback.model;

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
public class FeedbackSoap implements Serializable {
	public static FeedbackSoap toSoapModel(Feedback model) {
		FeedbackSoap soapModel = new FeedbackSoap();

		soapModel.setFeedbackId(model.getFeedbackId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setZt(model.getZt());
		soapModel.setLxId(model.getLxId());
		soapModel.setFkrId(model.getFkrId());
		soapModel.setFkrq(model.getFkrq());
		soapModel.setFknr(model.getFknr());
		soapModel.setHfrId(model.getHfrId());
		soapModel.setHfrq(model.getHfrq());
		soapModel.setHfjg(model.getHfjg());

		return soapModel;
	}

	public static FeedbackSoap[] toSoapModels(Feedback[] models) {
		FeedbackSoap[] soapModels = new FeedbackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[][] toSoapModels(Feedback[][] models) {
		FeedbackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedbackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedbackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[] toSoapModels(List<Feedback> models) {
		List<FeedbackSoap> soapModels = new ArrayList<FeedbackSoap>(models.size());

		for (Feedback model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedbackSoap[soapModels.size()]);
	}

	public FeedbackSoap() {
	}

	public long getPrimaryKey() {
		return _feedbackId;
	}

	public void setPrimaryKey(long pk) {
		setFeedbackId(pk);
	}

	public long getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
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

	public String getZt() {
		return _zt;
	}

	public void setZt(String zt) {
		_zt = zt;
	}

	public long getLxId() {
		return _lxId;
	}

	public void setLxId(long lxId) {
		_lxId = lxId;
	}

	public long getFkrId() {
		return _fkrId;
	}

	public void setFkrId(long fkrId) {
		_fkrId = fkrId;
	}

	public Date getFkrq() {
		return _fkrq;
	}

	public void setFkrq(Date fkrq) {
		_fkrq = fkrq;
	}

	public String getFknr() {
		return _fknr;
	}

	public void setFknr(String fknr) {
		_fknr = fknr;
	}

	public long getHfrId() {
		return _hfrId;
	}

	public void setHfrId(long hfrId) {
		_hfrId = hfrId;
	}

	public Date getHfrq() {
		return _hfrq;
	}

	public void setHfrq(Date hfrq) {
		_hfrq = hfrq;
	}

	public String getHfjg() {
		return _hfjg;
	}

	public void setHfjg(String hfjg) {
		_hfjg = hfjg;
	}

	private long _feedbackId;
	private long _groupId;
	private long _companyId;
	private String _zt;
	private long _lxId;
	private long _fkrId;
	private Date _fkrq;
	private String _fknr;
	private long _hfrId;
	private Date _hfrq;
	private String _hfjg;
}