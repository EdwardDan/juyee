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
public class ExpertSoap implements Serializable {
	public static ExpertSoap toSoapModel(Expert model) {
		ExpertSoap soapModel = new ExpertSoap();

		soapModel.setExpertId(model.getExpertId());
		soapModel.setUserId(model.getUserId());
		soapModel.setXm(model.getXm());
		soapModel.setXb(model.getXb());
		soapModel.setSfzh(model.getSfzh());
		soapModel.setCsny(model.getCsny());
		soapModel.setGzdw(model.getGzdw());
		soapModel.setDzyx(model.getDzyx());
		soapModel.setTxdz(model.getTxdz());
		soapModel.setYzbm(model.getYzbm());
		soapModel.setXrzw(model.getXrzw());
		soapModel.setZc(model.getZc());
		soapModel.setZyzg(model.getZyzg());
		soapModel.setCszy(model.getCszy());
		soapModel.setZygznx(model.getZygznx());
		soapModel.setSjhm(model.getSjhm());
		soapModel.setLxdh(model.getLxdh());
		soapModel.setCz(model.getCz());
		soapModel.setSqbz(model.getSqbz());

		return soapModel;
	}

	public static ExpertSoap[] toSoapModels(Expert[] models) {
		ExpertSoap[] soapModels = new ExpertSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpertSoap[][] toSoapModels(Expert[][] models) {
		ExpertSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpertSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpertSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpertSoap[] toSoapModels(List<Expert> models) {
		List<ExpertSoap> soapModels = new ArrayList<ExpertSoap>(models.size());

		for (Expert model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpertSoap[soapModels.size()]);
	}

	public ExpertSoap() {
	}

	public long getPrimaryKey() {
		return _expertId;
	}

	public void setPrimaryKey(long pk) {
		setExpertId(pk);
	}

	public long getExpertId() {
		return _expertId;
	}

	public void setExpertId(long expertId) {
		_expertId = expertId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getXm() {
		return _xm;
	}

	public void setXm(String xm) {
		_xm = xm;
	}

	public String getXb() {
		return _xb;
	}

	public void setXb(String xb) {
		_xb = xb;
	}

	public String getSfzh() {
		return _sfzh;
	}

	public void setSfzh(String sfzh) {
		_sfzh = sfzh;
	}

	public Date getCsny() {
		return _csny;
	}

	public void setCsny(Date csny) {
		_csny = csny;
	}

	public String getGzdw() {
		return _gzdw;
	}

	public void setGzdw(String gzdw) {
		_gzdw = gzdw;
	}

	public String getDzyx() {
		return _dzyx;
	}

	public void setDzyx(String dzyx) {
		_dzyx = dzyx;
	}

	public String getTxdz() {
		return _txdz;
	}

	public void setTxdz(String txdz) {
		_txdz = txdz;
	}

	public String getYzbm() {
		return _yzbm;
	}

	public void setYzbm(String yzbm) {
		_yzbm = yzbm;
	}

	public String getXrzw() {
		return _xrzw;
	}

	public void setXrzw(String xrzw) {
		_xrzw = xrzw;
	}

	public String getZc() {
		return _zc;
	}

	public void setZc(String zc) {
		_zc = zc;
	}

	public String getZyzg() {
		return _zyzg;
	}

	public void setZyzg(String zyzg) {
		_zyzg = zyzg;
	}

	public String getCszy() {
		return _cszy;
	}

	public void setCszy(String cszy) {
		_cszy = cszy;
	}

	public String getZygznx() {
		return _zygznx;
	}

	public void setZygznx(String zygznx) {
		_zygznx = zygznx;
	}

	public String getSjhm() {
		return _sjhm;
	}

	public void setSjhm(String sjhm) {
		_sjhm = sjhm;
	}

	public String getLxdh() {
		return _lxdh;
	}

	public void setLxdh(String lxdh) {
		_lxdh = lxdh;
	}

	public String getCz() {
		return _cz;
	}

	public void setCz(String cz) {
		_cz = cz;
	}

	public int getSqbz() {
		return _sqbz;
	}

	public void setSqbz(int sqbz) {
		_sqbz = sqbz;
	}

	private long _expertId;
	private long _userId;
	private String _xm;
	private String _xb;
	private String _sfzh;
	private Date _csny;
	private String _gzdw;
	private String _dzyx;
	private String _txdz;
	private String _yzbm;
	private String _xrzw;
	private String _zc;
	private String _zyzg;
	private String _cszy;
	private String _zygznx;
	private String _sjhm;
	private String _lxdh;
	private String _cz;
	private int _sqbz;
}