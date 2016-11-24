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
public class ZysqlbSoap implements Serializable {
	public static ZysqlbSoap toSoapModel(Zysqlb model) {
		ZysqlbSoap soapModel = new ZysqlbSoap();

		soapModel.setZysqlbId(model.getZysqlbId());
		soapModel.setSx(model.getSx());
		soapModel.setZy(model.getZy());
		soapModel.setZt(model.getZt());
		soapModel.setShyj(model.getShyj());
		soapModel.setShr(model.getShr());
		soapModel.setShrq(model.getShrq());

		return soapModel;
	}

	public static ZysqlbSoap[] toSoapModels(Zysqlb[] models) {
		ZysqlbSoap[] soapModels = new ZysqlbSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ZysqlbSoap[][] toSoapModels(Zysqlb[][] models) {
		ZysqlbSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ZysqlbSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ZysqlbSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ZysqlbSoap[] toSoapModels(List<Zysqlb> models) {
		List<ZysqlbSoap> soapModels = new ArrayList<ZysqlbSoap>(models.size());

		for (Zysqlb model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ZysqlbSoap[soapModels.size()]);
	}

	public ZysqlbSoap() {
	}

	public long getPrimaryKey() {
		return _zysqlbId;
	}

	public void setPrimaryKey(long pk) {
		setZysqlbId(pk);
	}

	public long getZysqlbId() {
		return _zysqlbId;
	}

	public void setZysqlbId(long zysqlbId) {
		_zysqlbId = zysqlbId;
	}

	public String getSx() {
		return _sx;
	}

	public void setSx(String sx) {
		_sx = sx;
	}

	public String getZy() {
		return _zy;
	}

	public void setZy(String zy) {
		_zy = zy;
	}

	public String getZt() {
		return _zt;
	}

	public void setZt(String zt) {
		_zt = zt;
	}

	public String getShyj() {
		return _shyj;
	}

	public void setShyj(String shyj) {
		_shyj = shyj;
	}

	public String getShr() {
		return _shr;
	}

	public void setShr(String shr) {
		_shr = shr;
	}

	public Date getShrq() {
		return _shrq;
	}

	public void setShrq(Date shrq) {
		_shrq = shrq;
	}

	private long _zysqlbId;
	private String _sx;
	private String _zy;
	private String _zt;
	private String _shyj;
	private String _shr;
	private Date _shrq;
}