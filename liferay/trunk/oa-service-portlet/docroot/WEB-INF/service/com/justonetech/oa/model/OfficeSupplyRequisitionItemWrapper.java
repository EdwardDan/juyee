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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OfficeSupplyRequisitionItem}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionItem
 * @generated
 */
public class OfficeSupplyRequisitionItemWrapper
	implements OfficeSupplyRequisitionItem,
		ModelWrapper<OfficeSupplyRequisitionItem> {
	public OfficeSupplyRequisitionItemWrapper(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		_officeSupplyRequisitionItem = officeSupplyRequisitionItem;
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyRequisitionItem.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyRequisitionItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyRequisitionItemId",
			getOfficeSupplyRequisitionItemId());
		attributes.put("name", getName());
		attributes.put("model", getModel());
		attributes.put("unit", getUnit());
		attributes.put("unitPrice", getUnitPrice());
		attributes.put("quantity", getQuantity());
		attributes.put("officeSupplyRequisitionId",
			getOfficeSupplyRequisitionId());
		attributes.put("officeSupplyId", getOfficeSupplyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyRequisitionItemId = (Long)attributes.get(
				"officeSupplyRequisitionItemId");

		if (officeSupplyRequisitionItemId != null) {
			setOfficeSupplyRequisitionItemId(officeSupplyRequisitionItemId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String model = (String)attributes.get("model");

		if (model != null) {
			setModel(model);
		}

		String unit = (String)attributes.get("unit");

		if (unit != null) {
			setUnit(unit);
		}

		Double unitPrice = (Double)attributes.get("unitPrice");

		if (unitPrice != null) {
			setUnitPrice(unitPrice);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Long officeSupplyRequisitionId = (Long)attributes.get(
				"officeSupplyRequisitionId");

		if (officeSupplyRequisitionId != null) {
			setOfficeSupplyRequisitionId(officeSupplyRequisitionId);
		}

		Long officeSupplyId = (Long)attributes.get("officeSupplyId");

		if (officeSupplyId != null) {
			setOfficeSupplyId(officeSupplyId);
		}
	}

	/**
	* Returns the primary key of this office supply requisition item.
	*
	* @return the primary key of this office supply requisition item
	*/
	@Override
	public long getPrimaryKey() {
		return _officeSupplyRequisitionItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office supply requisition item.
	*
	* @param primaryKey the primary key of this office supply requisition item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_officeSupplyRequisitionItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office supply requisition item ID of this office supply requisition item.
	*
	* @return the office supply requisition item ID of this office supply requisition item
	*/
	@Override
	public long getOfficeSupplyRequisitionItemId() {
		return _officeSupplyRequisitionItem.getOfficeSupplyRequisitionItemId();
	}

	/**
	* Sets the office supply requisition item ID of this office supply requisition item.
	*
	* @param officeSupplyRequisitionItemId the office supply requisition item ID of this office supply requisition item
	*/
	@Override
	public void setOfficeSupplyRequisitionItemId(
		long officeSupplyRequisitionItemId) {
		_officeSupplyRequisitionItem.setOfficeSupplyRequisitionItemId(officeSupplyRequisitionItemId);
	}

	/**
	* Returns the name of this office supply requisition item.
	*
	* @return the name of this office supply requisition item
	*/
	@Override
	public java.lang.String getName() {
		return _officeSupplyRequisitionItem.getName();
	}

	/**
	* Sets the name of this office supply requisition item.
	*
	* @param name the name of this office supply requisition item
	*/
	@Override
	public void setName(java.lang.String name) {
		_officeSupplyRequisitionItem.setName(name);
	}

	/**
	* Returns the model of this office supply requisition item.
	*
	* @return the model of this office supply requisition item
	*/
	@Override
	public java.lang.String getModel() {
		return _officeSupplyRequisitionItem.getModel();
	}

	/**
	* Sets the model of this office supply requisition item.
	*
	* @param model the model of this office supply requisition item
	*/
	@Override
	public void setModel(java.lang.String model) {
		_officeSupplyRequisitionItem.setModel(model);
	}

	/**
	* Returns the unit of this office supply requisition item.
	*
	* @return the unit of this office supply requisition item
	*/
	@Override
	public java.lang.String getUnit() {
		return _officeSupplyRequisitionItem.getUnit();
	}

	/**
	* Sets the unit of this office supply requisition item.
	*
	* @param unit the unit of this office supply requisition item
	*/
	@Override
	public void setUnit(java.lang.String unit) {
		_officeSupplyRequisitionItem.setUnit(unit);
	}

	/**
	* Returns the unit price of this office supply requisition item.
	*
	* @return the unit price of this office supply requisition item
	*/
	@Override
	public double getUnitPrice() {
		return _officeSupplyRequisitionItem.getUnitPrice();
	}

	/**
	* Sets the unit price of this office supply requisition item.
	*
	* @param unitPrice the unit price of this office supply requisition item
	*/
	@Override
	public void setUnitPrice(double unitPrice) {
		_officeSupplyRequisitionItem.setUnitPrice(unitPrice);
	}

	/**
	* Returns the quantity of this office supply requisition item.
	*
	* @return the quantity of this office supply requisition item
	*/
	@Override
	public int getQuantity() {
		return _officeSupplyRequisitionItem.getQuantity();
	}

	/**
	* Sets the quantity of this office supply requisition item.
	*
	* @param quantity the quantity of this office supply requisition item
	*/
	@Override
	public void setQuantity(int quantity) {
		_officeSupplyRequisitionItem.setQuantity(quantity);
	}

	/**
	* Returns the office supply requisition ID of this office supply requisition item.
	*
	* @return the office supply requisition ID of this office supply requisition item
	*/
	@Override
	public long getOfficeSupplyRequisitionId() {
		return _officeSupplyRequisitionItem.getOfficeSupplyRequisitionId();
	}

	/**
	* Sets the office supply requisition ID of this office supply requisition item.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID of this office supply requisition item
	*/
	@Override
	public void setOfficeSupplyRequisitionId(long officeSupplyRequisitionId) {
		_officeSupplyRequisitionItem.setOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

	/**
	* Returns the office supply ID of this office supply requisition item.
	*
	* @return the office supply ID of this office supply requisition item
	*/
	@Override
	public long getOfficeSupplyId() {
		return _officeSupplyRequisitionItem.getOfficeSupplyId();
	}

	/**
	* Sets the office supply ID of this office supply requisition item.
	*
	* @param officeSupplyId the office supply ID of this office supply requisition item
	*/
	@Override
	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyRequisitionItem.setOfficeSupplyId(officeSupplyId);
	}

	@Override
	public boolean isNew() {
		return _officeSupplyRequisitionItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_officeSupplyRequisitionItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _officeSupplyRequisitionItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_officeSupplyRequisitionItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _officeSupplyRequisitionItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _officeSupplyRequisitionItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_officeSupplyRequisitionItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _officeSupplyRequisitionItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_officeSupplyRequisitionItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_officeSupplyRequisitionItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_officeSupplyRequisitionItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeSupplyRequisitionItemWrapper((OfficeSupplyRequisitionItem)_officeSupplyRequisitionItem.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		return _officeSupplyRequisitionItem.compareTo(officeSupplyRequisitionItem);
	}

	@Override
	public int hashCode() {
		return _officeSupplyRequisitionItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.OfficeSupplyRequisitionItem> toCacheModel() {
		return _officeSupplyRequisitionItem.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem toEscapedModel() {
		return new OfficeSupplyRequisitionItemWrapper(_officeSupplyRequisitionItem.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem toUnescapedModel() {
		return new OfficeSupplyRequisitionItemWrapper(_officeSupplyRequisitionItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _officeSupplyRequisitionItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _officeSupplyRequisitionItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_officeSupplyRequisitionItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyRequisitionItemWrapper)) {
			return false;
		}

		OfficeSupplyRequisitionItemWrapper officeSupplyRequisitionItemWrapper = (OfficeSupplyRequisitionItemWrapper)obj;

		if (Validator.equals(_officeSupplyRequisitionItem,
					officeSupplyRequisitionItemWrapper._officeSupplyRequisitionItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OfficeSupplyRequisitionItem getWrappedOfficeSupplyRequisitionItem() {
		return _officeSupplyRequisitionItem;
	}

	@Override
	public OfficeSupplyRequisitionItem getWrappedModel() {
		return _officeSupplyRequisitionItem;
	}

	@Override
	public void resetOriginalValues() {
		_officeSupplyRequisitionItem.resetOriginalValues();
	}

	private OfficeSupplyRequisitionItem _officeSupplyRequisitionItem;
}