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

package com.justonetech.proj.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.justonetech.proj.service.http.BiddingServiceSoap}.
 *
 * @author fanqi
 * @see com.justonetech.proj.service.http.BiddingServiceSoap
 * @generated
 */
public class BiddingSoap implements Serializable {
	public static BiddingSoap toSoapModel(Bidding model) {
		BiddingSoap soapModel = new BiddingSoap();

		soapModel.setBiddingId(model.getBiddingId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSortNo(model.getSortNo());
		soapModel.setBidName(model.getBidName());
		soapModel.setBidCategoryCode(model.getBidCategoryCode());
		soapModel.setBuildMileage(model.getBuildMileage());
		soapModel.setInvolveCounty(model.getInvolveCounty());
		soapModel.setProjLinkman(model.getProjLinkman());
		soapModel.setLinkTel(model.getLinkTel());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setProjectId(model.getProjectId());

		return soapModel;
	}

	public static BiddingSoap[] toSoapModels(Bidding[] models) {
		BiddingSoap[] soapModels = new BiddingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BiddingSoap[][] toSoapModels(Bidding[][] models) {
		BiddingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BiddingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BiddingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BiddingSoap[] toSoapModels(List<Bidding> models) {
		List<BiddingSoap> soapModels = new ArrayList<BiddingSoap>(models.size());

		for (Bidding model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BiddingSoap[soapModels.size()]);
	}

	public BiddingSoap() {
	}

	public long getPrimaryKey() {
		return _biddingId;
	}

	public void setPrimaryKey(long pk) {
		setBiddingId(pk);
	}

	public long getBiddingId() {
		return _biddingId;
	}

	public void setBiddingId(long biddingId) {
		_biddingId = biddingId;
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

	public int getSortNo() {
		return _sortNo;
	}

	public void setSortNo(int sortNo) {
		_sortNo = sortNo;
	}

	public String getBidName() {
		return _bidName;
	}

	public void setBidName(String bidName) {
		_bidName = bidName;
	}

	public String getBidCategoryCode() {
		return _bidCategoryCode;
	}

	public void setBidCategoryCode(String bidCategoryCode) {
		_bidCategoryCode = bidCategoryCode;
	}

	public String getBuildMileage() {
		return _buildMileage;
	}

	public void setBuildMileage(String buildMileage) {
		_buildMileage = buildMileage;
	}

	public String getInvolveCounty() {
		return _involveCounty;
	}

	public void setInvolveCounty(String involveCounty) {
		_involveCounty = involveCounty;
	}

	public String getProjLinkman() {
		return _projLinkman;
	}

	public void setProjLinkman(String projLinkman) {
		_projLinkman = projLinkman;
	}

	public String getLinkTel() {
		return _linkTel;
	}

	public void setLinkTel(String linkTel) {
		_linkTel = linkTel;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	private long _biddingId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _sortNo;
	private String _bidName;
	private String _bidCategoryCode;
	private String _buildMileage;
	private String _involveCounty;
	private String _projLinkman;
	private String _linkTel;
	private Date _startDate;
	private long _projectId;
}