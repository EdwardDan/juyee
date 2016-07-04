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
public class OfficeSupplyApplyItemSoap implements Serializable {
	public static OfficeSupplyApplyItemSoap toSoapModel(
		OfficeSupplyApplyItem model) {
		OfficeSupplyApplyItemSoap soapModel = new OfficeSupplyApplyItemSoap();

		soapModel.setOfficeSupplyApplyItemId(model.getOfficeSupplyApplyItemId());
		soapModel.setName(model.getName());
		soapModel.setModel(model.getModel());
		soapModel.setUnit(model.getUnit());
		soapModel.setUnitPrice(model.getUnitPrice());
		soapModel.setQuantity(model.getQuantity());

		return soapModel;
	}

	public static OfficeSupplyApplyItemSoap[] toSoapModels(
		OfficeSupplyApplyItem[] models) {
		OfficeSupplyApplyItemSoap[] soapModels = new OfficeSupplyApplyItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplyItemSoap[][] toSoapModels(
		OfficeSupplyApplyItem[][] models) {
		OfficeSupplyApplyItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSupplyApplyItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSupplyApplyItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyApplyItemSoap[] toSoapModels(
		List<OfficeSupplyApplyItem> models) {
		List<OfficeSupplyApplyItemSoap> soapModels = new ArrayList<OfficeSupplyApplyItemSoap>(models.size());

		for (OfficeSupplyApplyItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSupplyApplyItemSoap[soapModels.size()]);
	}

	public OfficeSupplyApplyItemSoap() {
	}

	public long getPrimaryKey() {
		return _officeSupplyApplyItemId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeSupplyApplyItemId(pk);
	}

	public long getOfficeSupplyApplyItemId() {
		return _officeSupplyApplyItemId;
	}

	public void setOfficeSupplyApplyItemId(long officeSupplyApplyItemId) {
		_officeSupplyApplyItemId = officeSupplyApplyItemId;
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

	private long _officeSupplyApplyItemId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
}