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

package com.justonetech.oa.model;

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
public class OfficeSupplySoap implements Serializable {
	public static OfficeSupplySoap toSoapModel(OfficeSupply model) {
		OfficeSupplySoap soapModel = new OfficeSupplySoap();

		soapModel.setOfficeSupplyId(model.getOfficeSupplyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateTime(model.getCreateTime());
		soapModel.setModifiedTime(model.getModifiedTime());
		soapModel.setName(model.getName());
		soapModel.setModel(model.getModel());
		soapModel.setUnit(model.getUnit());
		soapModel.setUnitPrice(model.getUnitPrice());
		soapModel.setQuantity(model.getQuantity());

		return soapModel;
	}

	public static OfficeSupplySoap[] toSoapModels(OfficeSupply[] models) {
		OfficeSupplySoap[] soapModels = new OfficeSupplySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplySoap[][] toSoapModels(OfficeSupply[][] models) {
		OfficeSupplySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSupplySoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSupplySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplySoap[] toSoapModels(List<OfficeSupply> models) {
		List<OfficeSupplySoap> soapModels = new ArrayList<OfficeSupplySoap>(models.size());

		for (OfficeSupply model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSupplySoap[soapModels.size()]);
	}

	public OfficeSupplySoap() {
	}

	public long getPrimaryKey() {
		return _officeSupplyId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeSupplyId(pk);
	}

	public long getOfficeSupplyId() {
		return _officeSupplyId;
	}

	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyId = officeSupplyId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getModel() {
		return _model;
	}

	public void setModel(String model) {
		_model = model;
	}

	public String getUnit() {
		return _unit;
	}

	public void setUnit(String unit) {
		_unit = unit;
	}

	public double getUnitPrice() {
		return _unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		_unitPrice = unitPrice;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	private long _officeSupplyId;
	private long _userId;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
}