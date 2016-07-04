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
public class OfficeSupplyRequisitionItemSoap implements Serializable {
	public static OfficeSupplyRequisitionItemSoap toSoapModel(
		OfficeSupplyRequisitionItem model) {
		OfficeSupplyRequisitionItemSoap soapModel = new OfficeSupplyRequisitionItemSoap();

		soapModel.setOfficeSupplyRequisitionItemId(model.getOfficeSupplyRequisitionItemId());
		soapModel.setName(model.getName());
		soapModel.setModel(model.getModel());
		soapModel.setUnit(model.getUnit());
		soapModel.setUnitPrice(model.getUnitPrice());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setOfficeSupplyRequisitionId(model.getOfficeSupplyRequisitionId());
		soapModel.setOfficeSupplyId(model.getOfficeSupplyId());

		return soapModel;
	}

	public static OfficeSupplyRequisitionItemSoap[] toSoapModels(
		OfficeSupplyRequisitionItem[] models) {
		OfficeSupplyRequisitionItemSoap[] soapModels = new OfficeSupplyRequisitionItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyRequisitionItemSoap[][] toSoapModels(
		OfficeSupplyRequisitionItem[][] models) {
		OfficeSupplyRequisitionItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OfficeSupplyRequisitionItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OfficeSupplyRequisitionItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OfficeSupplyRequisitionItemSoap[] toSoapModels(
		List<OfficeSupplyRequisitionItem> models) {
		List<OfficeSupplyRequisitionItemSoap> soapModels = new ArrayList<OfficeSupplyRequisitionItemSoap>(models.size());

		for (OfficeSupplyRequisitionItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OfficeSupplyRequisitionItemSoap[soapModels.size()]);
	}

	public OfficeSupplyRequisitionItemSoap() {
	}

	public long getPrimaryKey() {
		return _officeSupplyRequisitionItemId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeSupplyRequisitionItemId(pk);
	}

	public long getOfficeSupplyRequisitionItemId() {
		return _officeSupplyRequisitionItemId;
	}

	public void setOfficeSupplyRequisitionItemId(
		long officeSupplyRequisitionItemId) {
		_officeSupplyRequisitionItemId = officeSupplyRequisitionItemId;
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

	public long getOfficeSupplyRequisitionId() {
		return _officeSupplyRequisitionId;
	}

	public void setOfficeSupplyRequisitionId(long officeSupplyRequisitionId) {
		_officeSupplyRequisitionId = officeSupplyRequisitionId;
	}

	public long getOfficeSupplyId() {
		return _officeSupplyId;
	}

	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyId = officeSupplyId;
	}

	private long _officeSupplyRequisitionItemId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private long _officeSupplyRequisitionId;
	private long _officeSupplyId;
}