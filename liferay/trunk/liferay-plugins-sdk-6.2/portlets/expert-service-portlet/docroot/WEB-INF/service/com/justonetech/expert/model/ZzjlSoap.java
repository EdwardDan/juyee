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
public class ZzjlSoap implements Serializable {
	public static ZzjlSoap toSoapModel(Zzjl model) {
		ZzjlSoap soapModel = new ZzjlSoap();

		soapModel.setZzjlId(model.getZzjlId());
		soapModel.setExpertId(model.getExpertId());
		soapModel.setZzdw(model.getZzdw());
		soapModel.setQzny(model.getQzny());
		soapModel.setCszyzygz(model.getCszyzygz());
		soapModel.setZw(model.getZw());

		return soapModel;
	}

	public static ZzjlSoap[] toSoapModels(Zzjl[] models) {
		ZzjlSoap[] soapModels = new ZzjlSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ZzjlSoap[][] toSoapModels(Zzjl[][] models) {
		ZzjlSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ZzjlSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ZzjlSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ZzjlSoap[] toSoapModels(List<Zzjl> models) {
		List<ZzjlSoap> soapModels = new ArrayList<ZzjlSoap>(models.size());

		for (Zzjl model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ZzjlSoap[soapModels.size()]);
	}

	public ZzjlSoap() {
	}

	public long getPrimaryKey() {
		return _zzjlId;
	}

	public void setPrimaryKey(long pk) {
		setZzjlId(pk);
	}

	public long getZzjlId() {
		return _zzjlId;
	}

	public void setZzjlId(long zzjlId) {
		_zzjlId = zzjlId;
	}

	public long getExpertId() {
		return _expertId;
	}

	public void setExpertId(long expertId) {
		_expertId = expertId;
	}

	public String getZzdw() {
		return _zzdw;
	}

	public void setZzdw(String zzdw) {
		_zzdw = zzdw;
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

	private long _zzjlId;
	private long _expertId;
	private String _zzdw;
	private String _qzny;
	private String _cszyzygz;
	private String _zw;
}