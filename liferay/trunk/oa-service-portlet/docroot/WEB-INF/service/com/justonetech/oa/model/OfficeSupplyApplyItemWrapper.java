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
 * This class is a wrapper for {@link OfficeSupplyApplyItem}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplyItem
 * @generated
 */
public class OfficeSupplyApplyItemWrapper implements OfficeSupplyApplyItem,
	ModelWrapper<OfficeSupplyApplyItem> {
	public OfficeSupplyApplyItemWrapper(
		OfficeSupplyApplyItem officeSupplyApplyItem) {
		_officeSupplyApplyItem = officeSupplyApplyItem;
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyApplyItem.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyApplyItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyApplyItemId", getOfficeSupplyApplyItemId());
		attributes.put("name", getName());
		attributes.put("model", getModel());
		attributes.put("unit", getUnit());
		attributes.put("unitPrice", getUnitPrice());
		attributes.put("quantity", getQuantity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyApplyItemId = (Long)attributes.get(
				"officeSupplyApplyItemId");

		if (officeSupplyApplyItemId != null) {
			setOfficeSupplyApplyItemId(officeSupplyApplyItemId);
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
	}

	/**
	* Returns the primary key of this office supply apply item.
	*
	* @return the primary key of this office supply apply item
	*/
	@Override
	public long getPrimaryKey() {
		return _officeSupplyApplyItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office supply apply item.
	*
	* @param primaryKey the primary key of this office supply apply item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_officeSupplyApplyItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office supply apply item ID of this office supply apply item.
	*
	* @return the office supply apply item ID of this office supply apply item
	*/
	@Override
	public long getOfficeSupplyApplyItemId() {
		return _officeSupplyApplyItem.getOfficeSupplyApplyItemId();
	}

	/**
	* Sets the office supply apply item ID of this office supply apply item.
	*
	* @param officeSupplyApplyItemId the office supply apply item ID of this office supply apply item
	*/
	@Override
	public void setOfficeSupplyApplyItemId(long officeSupplyApplyItemId) {
		_officeSupplyApplyItem.setOfficeSupplyApplyItemId(officeSupplyApplyItemId);
	}

	/**
	* Returns the name of this office supply apply item.
	*
	* @return the name of this office supply apply item
	*/
	@Override
	public java.lang.String getName() {
		return _officeSupplyApplyItem.getName();
	}

	/**
	* Sets the name of this office supply apply item.
	*
	* @param name the name of this office supply apply item
	*/
	@Override
	public void setName(java.lang.String name) {
		_officeSupplyApplyItem.setName(name);
	}

	/**
	* Returns the model of this office supply apply item.
	*
	* @return the model of this office supply apply item
	*/
	@Override
	public java.lang.String getModel() {
		return _officeSupplyApplyItem.getModel();
	}

	/**
	* Sets the model of this office supply apply item.
	*
	* @param model the model of this office supply apply item
	*/
	@Override
	public void setModel(java.lang.String model) {
		_officeSupplyApplyItem.setModel(model);
	}

	/**
	* Returns the unit of this office supply apply item.
	*
	* @return the unit of this office supply apply item
	*/
	@Override
	public java.lang.String getUnit() {
		return _officeSupplyApplyItem.getUnit();
	}

	/**
	* Sets the unit of this office supply apply item.
	*
	* @param unit the unit of this office supply apply item
	*/
	@Override
	public void setUnit(java.lang.String unit) {
		_officeSupplyApplyItem.setUnit(unit);
	}

	/**
	* Returns the unit price of this office supply apply item.
	*
	* @return the unit price of this office supply apply item
	*/
	@Override
	public double getUnitPrice() {
		return _officeSupplyApplyItem.getUnitPrice();
	}

	/**
	* Sets the unit price of this office supply apply item.
	*
	* @param unitPrice the unit price of this office supply apply item
	*/
	@Override
	public void setUnitPrice(double unitPrice) {
		_officeSupplyApplyItem.setUnitPrice(unitPrice);
	}

	/**
	* Returns the quantity of this office supply apply item.
	*
	* @return the quantity of this office supply apply item
	*/
	@Override
	public int getQuantity() {
		return _officeSupplyApplyItem.getQuantity();
	}

	/**
	* Sets the quantity of this office supply apply item.
	*
	* @param quantity the quantity of this office supply apply item
	*/
	@Override
	public void setQuantity(int quantity) {
		_officeSupplyApplyItem.setQuantity(quantity);
	}

	@Override
	public boolean isNew() {
		return _officeSupplyApplyItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_officeSupplyApplyItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _officeSupplyApplyItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_officeSupplyApplyItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _officeSupplyApplyItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _officeSupplyApplyItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_officeSupplyApplyItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _officeSupplyApplyItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_officeSupplyApplyItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_officeSupplyApplyItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_officeSupplyApplyItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeSupplyApplyItemWrapper((OfficeSupplyApplyItem)_officeSupplyApplyItem.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.OfficeSupplyApplyItem officeSupplyApplyItem) {
		return _officeSupplyApplyItem.compareTo(officeSupplyApplyItem);
	}

	@Override
	public int hashCode() {
		return _officeSupplyApplyItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.OfficeSupplyApplyItem> toCacheModel() {
		return _officeSupplyApplyItem.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem toEscapedModel() {
		return new OfficeSupplyApplyItemWrapper(_officeSupplyApplyItem.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem toUnescapedModel() {
		return new OfficeSupplyApplyItemWrapper(_officeSupplyApplyItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _officeSupplyApplyItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _officeSupplyApplyItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_officeSupplyApplyItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyApplyItemWrapper)) {
			return false;
		}

		OfficeSupplyApplyItemWrapper officeSupplyApplyItemWrapper = (OfficeSupplyApplyItemWrapper)obj;

		if (Validator.equals(_officeSupplyApplyItem,
					officeSupplyApplyItemWrapper._officeSupplyApplyItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OfficeSupplyApplyItem getWrappedOfficeSupplyApplyItem() {
		return _officeSupplyApplyItem;
	}

	@Override
	public OfficeSupplyApplyItem getWrappedModel() {
		return _officeSupplyApplyItem;
	}

	@Override
	public void resetOriginalValues() {
		_officeSupplyApplyItem.resetOriginalValues();
	}

	private OfficeSupplyApplyItem _officeSupplyApplyItem;
}