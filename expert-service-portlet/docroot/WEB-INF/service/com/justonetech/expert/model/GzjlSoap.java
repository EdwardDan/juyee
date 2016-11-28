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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author fanqi
 * @generated
 */
public class GzjlSoap implements Serializable {
	public static GzjlSoap toSoapModel(Gzjl model) {
		GzjlSoap soapModel = new GzjlSoap();

		soapModel.setGzjlId(model.getGzjlId());
		soapModel.setExpertId(model.getExpertId());
		soapModel.setGzdw(model.getGzdw());
		soapModel.setQzny(model.getQzny());
		soapModel.setCszyzygz(model.getCszyzygz());
		soapModel.setZw(model.getZw());

		return soapModel;
	}

	public static GzjlSoap[] toSoapModels(Gzjl[] models) {
		GzjlSoap[] soapModels = new GzjlSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GzjlSoap[][] toSoapModels(Gzjl[][] models) {
		GzjlSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GzjlSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GzjlSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GzjlSoap[] toSoapModels(List<Gzjl> models) {
		List<GzjlSoap> soapModels = new ArrayList<GzjlSoap>(models.size());

		for (Gzjl model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GzjlSoap[soapModels.size()]);
	}

	public GzjlSoap() {
	}

	public long getPrimaryKey() {
		return _GzjlId;
	}

	public void setPrimaryKey(long pk) {
		setGzjlId(pk);
	}

	public long getGzjlId() {
		return _GzjlId;
	}

	public void setGzjlId(long GzjlId) {
		_GzjlId = GzjlId;
	}

	public long getExpertId() {
		return _expertId;
	}

	public void setExpertId(long expertId) {
		_expertId = expertId;
	}

	public String getGzdw() {
		return _gzdw;
	}

	public void setGzdw(String gzdw) {
		_gzdw = gzdw;
	}

	public String getQzny() {
		return _qzny;
	}

	public void setQzny(String qzny) {
		_qzny = qzny;
	}

	public String getCszyzygz() {
		return _cszyzygz;
	}

	public void setCszyzygz(String cszyzygz) {
		_cszyzygz = cszyzygz;
	}

	public String getZw() {
		return _zw;
	}

	public void setZw(String zw) {
		_zw = zw;
	}

	private long _GzjlId;
	private long _expertId;
	private String _gzdw;
	private String _qzny;
	private String _cszyzygz;
	private String _zw;
}