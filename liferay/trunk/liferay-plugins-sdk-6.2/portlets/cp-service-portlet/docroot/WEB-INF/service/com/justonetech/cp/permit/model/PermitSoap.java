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

package com.justonetech.cp.permit.model;

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
public class PermitSoap implements Serializable {
	public static PermitSoap toSoapModel(Permit model) {
		PermitSoap soapModel = new PermitSoap();

		soapModel.setPermitId(model.getPermitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setZzjgdm(model.getZzjgdm());
		soapModel.setBjbh(model.getBjbh());
		soapModel.setHtxxbsbh(model.getHtxxbsbh());
		soapModel.setSqbz(model.getSqbz());
		soapModel.setStatus(model.getStatus());
		soapModel.setBdh(model.getBdh());
		soapModel.setYwbh(model.getYwbh());
		soapModel.setSgxkzbh(model.getSgxkzbh());
		soapModel.setSlbh(model.getSlbh());
		soapModel.setHjgsz(model.getHjgsz());
		soapModel.setHjgsh(model.getHjgsh());
		soapModel.setSqr(model.getSqr());
		soapModel.setSqsx(model.getSqsx());
		soapModel.setSqh(model.getSqh());
		soapModel.setCltjr(model.getCltjr());
		soapModel.setCltjrlxdh(model.getCltjrlxdh());
		soapModel.setCltjrlxdz(model.getCltjrlxdz());
		soapModel.setSjr(model.getSjr());
		soapModel.setSjrlxdh(model.getSjrlxdh());
		soapModel.setSlyj(model.getSlyj());
		soapModel.setSlsj(model.getSlsj());
		soapModel.setNsgnr(model.getNsgnr());
		soapModel.setSgxkzFileEntryId(model.getSgxkzFileEntryId());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());

		return soapModel;
	}

	public static PermitSoap[] toSoapModels(Permit[] models) {
		PermitSoap[] soapModels = new PermitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PermitSoap[][] toSoapModels(Permit[][] models) {
		PermitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PermitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PermitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PermitSoap[] toSoapModels(List<Permit> models) {
		List<PermitSoap> soapModels = new ArrayList<PermitSoap>(models.size());

		for (Permit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PermitSoap[soapModels.size()]);
	}

	public PermitSoap() {
	}

	public long getPrimaryKey() {
		return _permitId;
	}

	public void setPrimaryKey(long pk) {
		setPermitId(pk);
	}

	public long getPermitId() {
		return _permitId;
	}

	public void setPermitId(long permitId) {
		_permitId = permitId;
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

	public String getZzjgdm() {
		return _zzjgdm;
	}

	public void setZzjgdm(String zzjgdm) {
		_zzjgdm = zzjgdm;
	}

	public String getBjbh() {
		return _bjbh;
	}

	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	public String getHtxxbsbh() {
		return _htxxbsbh;
	}

	public void setHtxxbsbh(String htxxbsbh) {
		_htxxbsbh = htxxbsbh;
	}

	public int getSqbz() {
		return _sqbz;
	}

	public void setSqbz(int sqbz) {
		_sqbz = sqbz;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getBdh() {
		return _bdh;
	}

	public void setBdh(String bdh) {
		_bdh = bdh;
	}

	public String getYwbh() {
		return _ywbh;
	}

	public void setYwbh(String ywbh) {
		_ywbh = ywbh;
	}

	public String getSgxkzbh() {
		return _sgxkzbh;
	}

	public void setSgxkzbh(String sgxkzbh) {
		_sgxkzbh = sgxkzbh;
	}

	public String getSlbh() {
		return _slbh;
	}

	public void setSlbh(String slbh) {
		_slbh = slbh;
	}

	public int getHjgsz() {
		return _hjgsz;
	}

	public void setHjgsz(int hjgsz) {
		_hjgsz = hjgsz;
	}

	public int getHjgsh() {
		return _hjgsh;
	}

	public void setHjgsh(int hjgsh) {
		_hjgsh = hjgsh;
	}

	public String getSqr() {
		return _sqr;
	}

	public void setSqr(String sqr) {
		_sqr = sqr;
	}

	public String getSqsx() {
		return _sqsx;
	}

	public void setSqsx(String sqsx) {
		_sqsx = sqsx;
	}

	public String getSqh() {
		return _sqh;
	}

	public void setSqh(String sqh) {
		_sqh = sqh;
	}

	public String getCltjr() {
		return _cltjr;
	}

	public void setCltjr(String cltjr) {
		_cltjr = cltjr;
	}

	public String getCltjrlxdh() {
		return _cltjrlxdh;
	}

	public void setCltjrlxdh(String cltjrlxdh) {
		_cltjrlxdh = cltjrlxdh;
	}

	public String getCltjrlxdz() {
		return _cltjrlxdz;
	}

	public void setCltjrlxdz(String cltjrlxdz) {
		_cltjrlxdz = cltjrlxdz;
	}

	public String getSjr() {
		return _sjr;
	}

	public void setSjr(String sjr) {
		_sjr = sjr;
	}

	public String getSjrlxdh() {
		return _sjrlxdh;
	}

	public void setSjrlxdh(String sjrlxdh) {
		_sjrlxdh = sjrlxdh;
	}

	public String getSlyj() {
		return _slyj;
	}

	public void setSlyj(String slyj) {
		_slyj = slyj;
	}

	public String getSlsj() {
		return _slsj;
	}

	public void setSlsj(String slsj) {
		_slsj = slsj;
	}

	public String getNsgnr() {
		return _nsgnr;
	}

	public void setNsgnr(String nsgnr) {
		_nsgnr = nsgnr;
	}

	public long getSgxkzFileEntryId() {
		return _sgxkzFileEntryId;
	}

	public void setSgxkzFileEntryId(long sgxkzFileEntryId) {
		_sgxkzFileEntryId = sgxkzFileEntryId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	private long _permitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _zzjgdm;
	private String _bjbh;
	private String _htxxbsbh;
	private int _sqbz;
	private int _status;
	private String _bdh;
	private String _ywbh;
	private String _sgxkzbh;
	private String _slbh;
	private int _hjgsz;
	private int _hjgsh;
	private String _sqr;
	private String _sqsx;
	private String _sqh;
	private String _cltjr;
	private String _cltjrlxdh;
	private String _cltjrlxdz;
	private String _sjr;
	private String _sjrlxdh;
	private String _slyj;
	private String _slsj;
	private String _nsgnr;
	private long _sgxkzFileEntryId;
	private String _title;
	private String _content;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
}