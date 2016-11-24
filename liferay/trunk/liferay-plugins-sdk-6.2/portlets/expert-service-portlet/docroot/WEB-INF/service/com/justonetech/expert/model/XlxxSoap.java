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
public class XlxxSoap implements Serializable {
	public static XlxxSoap toSoapModel(Xlxx model) {
		XlxxSoap soapModel = new XlxxSoap();

		soapModel.setXlxxId(model.getXlxxId());
		soapModel.setByyx(model.getByyx());
		soapModel.setSxzy(model.getSxzy());
		soapModel.setXlhxw(model.getXlhxw());
		soapModel.setZxsj(model.getZxsj());

		return soapModel;
	}

	public static XlxxSoap[] toSoapModels(Xlxx[] models) {
		XlxxSoap[] soapModels = new XlxxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static XlxxSoap[][] toSoapModels(Xlxx[][] models) {
		XlxxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new XlxxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new XlxxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static XlxxSoap[] toSoapModels(List<Xlxx> models) {
		List<XlxxSoap> soapModels = new ArrayList<XlxxSoap>(models.size());

		for (Xlxx model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new XlxxSoap[soapModels.size()]);
	}

	public XlxxSoap() {
	}

	public long getPrimaryKey() {
		return _xlxxId;
	}

	public void setPrimaryKey(long pk) {
		setXlxxId(pk);
	}

	public long getXlxxId() {
		return _xlxxId;
	}

	public void setXlxxId(long xlxxId) {
		_xlxxId = xlxxId;
	}

	public String getByyx() {
		return _byyx;
	}

	public void setByyx(String byyx) {
		_byyx = byyx;
	}

	public String getSxzy() {
		return _sxzy;
	}

	public void setSxzy(String sxzy) {
		_sxzy = sxzy;
	}

	public String getXlhxw() {
		return _xlhxw;
	}

	public void setXlhxw(String xlhxw) {
		_xlhxw = xlhxw;
	}

	public String getZxsj() {
		return _zxsj;
	}

	public void setZxsj(String zxsj) {
		_zxsj = zxsj;
	}

	private long _xlxxId;
	private String _byyx;
	private String _sxzy;
	private String _xlhxw;
	private String _zxsj;
}