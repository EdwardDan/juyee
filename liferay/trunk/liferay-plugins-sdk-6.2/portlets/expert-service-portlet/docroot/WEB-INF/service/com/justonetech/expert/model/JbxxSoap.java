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
public class JbxxSoap implements Serializable {
	public static JbxxSoap toSoapModel(Jbxx model) {
		JbxxSoap soapModel = new JbxxSoap();

		soapModel.setJbxxId(model.getJbxxId());
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

		return soapModel;
	}

	public static JbxxSoap[] toSoapModels(Jbxx[] models) {
		JbxxSoap[] soapModels = new JbxxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JbxxSoap[][] toSoapModels(Jbxx[][] models) {
		JbxxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JbxxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JbxxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JbxxSoap[] toSoapModels(List<Jbxx> models) {
		List<JbxxSoap> soapModels = new ArrayList<JbxxSoap>(models.size());

		for (Jbxx model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JbxxSoap[soapModels.size()]);
	}

	public JbxxSoap() {
	}

	public long getPrimaryKey() {
		return _jbxxId;
	}

	public void setPrimaryKey(long pk) {
		setJbxxId(pk);
	}

	public long getJbxxId() {
		return _jbxxId;
	}

	public void setJbxxId(long jbxxId) {
		_jbxxId = jbxxId;
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

	private long _jbxxId;
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
}