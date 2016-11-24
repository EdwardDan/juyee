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

package com.justonetech.expert.model;

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
public class ZqtzjkrzqkSoap implements Serializable {
	public static ZqtzjkrzqkSoap toSoapModel(Zqtzjkrzqk model) {
		ZqtzjkrzqkSoap soapModel = new ZqtzjkrzqkSoap();

		soapModel.setZqtzjkrzqkId(model.getZqtzjkrzqkId());
		soapModel.setZjkxtlsdw(model.getZjkxtlsdw());
		soapModel.setSqzy(model.getSqzy());
		soapModel.setPzrq(model.getPzrq());

		return soapModel;
	}

	public static ZqtzjkrzqkSoap[] toSoapModels(Zqtzjkrzqk[] models) {
		ZqtzjkrzqkSoap[] soapModels = new ZqtzjkrzqkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ZqtzjkrzqkSoap[][] toSoapModels(Zqtzjkrzqk[][] models) {
		ZqtzjkrzqkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ZqtzjkrzqkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ZqtzjkrzqkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ZqtzjkrzqkSoap[] toSoapModels(List<Zqtzjkrzqk> models) {
		List<ZqtzjkrzqkSoap> soapModels = new ArrayList<ZqtzjkrzqkSoap>(models.size());

		for (Zqtzjkrzqk model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ZqtzjkrzqkSoap[soapModels.size()]);
	}

	public ZqtzjkrzqkSoap() {
	}

	public long getPrimaryKey() {
		return _zqtzjkrzqkId;
	}

	public void setPrimaryKey(long pk) {
		setZqtzjkrzqkId(pk);
	}

	public long getZqtzjkrzqkId() {
		return _zqtzjkrzqkId;
	}

	public void setZqtzjkrzqkId(long zqtzjkrzqkId) {
		_zqtzjkrzqkId = zqtzjkrzqkId;
	}

	public String getZjkxtlsdw() {
		return _zjkxtlsdw;
	}

	public void setZjkxtlsdw(String zjkxtlsdw) {
		_zjkxtlsdw = zjkxtlsdw;
	}

	public String getSqzy() {
		return _sqzy;
	}

	public void setSqzy(String sqzy) {
		_sqzy = sqzy;
	}

	public Date getPzrq() {
		return _pzrq;
	}

	public void setPzrq(Date pzrq) {
		_pzrq = pzrq;
	}

	private long _zqtzjkrzqkId;
	private String _zjkxtlsdw;
	private String _sqzy;
	private Date _pzrq;
}