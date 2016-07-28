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

package com.justonetech.sys.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author justonetech
 * @generated
 */
public class SMSSoap implements Serializable {
	public static SMSSoap toSoapModel(SMS model) {
		SMSSoap soapModel = new SMSSoap();

		soapModel.setSmsId(model.getSmsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setContent(model.getContent());
		soapModel.setSenderId(model.getSenderId());
		soapModel.setSenderName(model.getSenderName());
		soapModel.setReceiver(model.getReceiver());
		soapModel.setSendTime(model.getSendTime());

		return soapModel;
	}

	public static SMSSoap[] toSoapModels(SMS[] models) {
		SMSSoap[] soapModels = new SMSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SMSSoap[][] toSoapModels(SMS[][] models) {
		SMSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SMSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SMSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SMSSoap[] toSoapModels(List<SMS> models) {
		List<SMSSoap> soapModels = new ArrayList<SMSSoap>(models.size());

		for (SMS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SMSSoap[soapModels.size()]);
	}

	public SMSSoap() {
	}

	public long getPrimaryKey() {
		return _smsId;
	}

	public void setPrimaryKey(long pk) {
		setSmsId(pk);
	}

	public long getSmsId() {
		return _smsId;
	}

	public void setSmsId(long smsId) {
		_smsId = smsId;
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

	public Date getCreateTime() {
		return _createTime;
	}

	public void setCreateTime(Date createTime) {
		_createTime = createTime;
	}

	public Date getModifiedTime() {
		return _modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		_modifiedTime = modifiedTime;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getSenderId() {
		return _senderId;
	}

	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	public String getSenderName() {
		return _senderName;
	}

	public void setSenderName(String senderName) {
		_senderName = senderName;
	}

	public String getReceiver() {
		return _receiver;
	}

	public void setReceiver(String receiver) {
		_receiver = receiver;
	}

	public Date getSendTime() {
		return _sendTime;
	}

	public void setSendTime(Date sendTime) {
		_sendTime = sendTime;
	}

	private long _smsId;
	private long _groupId;
	private long _companyId;
	private Date _createTime;
	private Date _modifiedTime;
	private String _content;
	private long _senderId;
	private String _senderName;
	private String _receiver;
	private Date _sendTime;
}