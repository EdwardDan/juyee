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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author justonetech
 * @generated
 */
public class OfficeSupplyApplicationItemSoap implements Serializable {
	public static OfficeSupplyApplicationItemSoap toSoapModel(
		OfficeSupplyApplicationItem model) {
		OfficeSupplyApplicationItemSoap soapModel = new OfficeSupplyApplicationItemSoap();

		soapModel.setOfficeSupplyApplicationItemId(model.getOfficeSupplyApplicationItemId());
		soapModel.setName(model.getName());
		soapModel.setModel(model.getModel());
		soapModel.setUnit(model.getUnit());
		soapModel.setUnitPrice(model.getUnitPrice());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setOfficeSupplyApplicationId(model.getOfficeSupplyApplicationId());
		soapModel.setOfficeSupplyId(model.getOfficeSupplyId());

		return soapModel;
	}

	public static OfficeSupplyApplicationItemSoap[] toSoapModels(
		OfficeSupplyApplicationItem[] models) {
		OfficeSupplyApplicationItemSoap[] soapModels = new OfficeSupplyApplicationItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplicationItemSoap[][] toSoapModels(
		OfficeSupplyApplicationItem[][] models) {
		OfficeSupplyApplicationItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSupplyApplicationItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSupplyApplicationItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplicationItemSoap[] toSoapModels(
		List<OfficeSupplyApplicationItem> models) {
		List<OfficeSupplyApplicationItemSoap> soapModels = new ArrayList<OfficeSupplyApplicationItemSoap>(models.size());

		for (OfficeSupplyApplicationItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSupplyApplicationItemSoap[soapModels.size()]);
	}

	public OfficeSupplyApplicationItemSoap() {
	}

	public long getPrimaryKey() {
		return _officeSupplyApplicationItemId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeSupplyApplicationItemId(pk);
	}

	public long getOfficeSupplyApplicationItemId() {
		return _officeSupplyApplicationItemId;
	}

	public void setOfficeSupplyApplicationItemId(
		long officeSupplyApplicationItemId) {
		_officeSupplyApplicationItemId = officeSupplyApplicationItemId;
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

	public long getOfficeSupplyApplicationId() {
		return _officeSupplyApplicationId;
	}

	public void setOfficeSupplyApplicationId(long officeSupplyApplicationId) {
		_officeSupplyApplicationId = officeSupplyApplicationId;
	}

	public long getOfficeSupplyId() {
		return _officeSupplyId;
	}

	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyId = officeSupplyId;
	}

	private long _officeSupplyApplicationItemId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private long _officeSupplyApplicationId;
	private long _officeSupplyId;
}