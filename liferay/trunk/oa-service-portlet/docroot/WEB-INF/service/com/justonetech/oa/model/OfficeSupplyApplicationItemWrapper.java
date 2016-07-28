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
 * This class is a wrapper for {@link OfficeSupplyApplicationItem}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplicationItem
 * @generated
 */
public class OfficeSupplyApplicationItemWrapper
	implements OfficeSupplyApplicationItem,
		ModelWrapper<OfficeSupplyApplicationItem> {
	public OfficeSupplyApplicationItemWrapper(
		OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		_officeSupplyApplicationItem = officeSupplyApplicationItem;
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyApplicationItem.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyApplicationItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyApplicationItemId",
			getOfficeSupplyApplicationItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("name", getName());
		attributes.put("model", getModel());
		attributes.put("unit", getUnit());
		attributes.put("unitPrice", getUnitPrice());
		attributes.put("quantity", getQuantity());
		attributes.put("officeSupplyApplicationId",
			getOfficeSupplyApplicationId());
		attributes.put("officeSupplyId", getOfficeSupplyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyApplicationItemId = (Long)attributes.get(
				"officeSupplyApplicationItemId");

		if (officeSupplyApplicationItemId != null) {
			setOfficeSupplyApplicationItemId(officeSupplyApplicationItemId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long officeSupplyApplicationId = (Long)attributes.get(
				"officeSupplyApplicationId");

		if (officeSupplyApplicationId != null) {
			setOfficeSupplyApplicationId(officeSupplyApplicationId);
		}

		Long officeSupplyId = (Long)attributes.get("officeSupplyId");

		if (officeSupplyId != null) {
			setOfficeSupplyId(officeSupplyId);
		}
	}

	/**
	* Returns the primary key of this office supply application item.
	*
	* @return the primary key of this office supply application item
	*/
	@Override
	public long getPrimaryKey() {
		return _officeSupplyApplicationItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office supply application item.
	*
	* @param primaryKey the primary key of this office supply application item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_officeSupplyApplicationItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office supply application item ID of this office supply application item.
	*
	* @return the office supply application item ID of this office supply application item
	*/
	@Override
	public long getOfficeSupplyApplicationItemId() {
		return _officeSupplyApplicationItem.getOfficeSupplyApplicationItemId();
	}

	/**
	* Sets the office supply application item ID of this office supply application item.
	*
	* @param officeSupplyApplicationItemId the office supply application item ID of this office supply application item
	*/
	@Override
	public void setOfficeSupplyApplicationItemId(
		long officeSupplyApplicationItemId) {
		_officeSupplyApplicationItem.setOfficeSupplyApplicationItemId(officeSupplyApplicationItemId);
	}

	/**
	* Returns the group ID of this office supply application item.
	*
	* @return the group ID of this office supply application item
	*/
	@Override
	public long getGroupId() {
		return _officeSupplyApplicationItem.getGroupId();
	}

	/**
	* Sets the group ID of this office supply application item.
	*
	* @param groupId the group ID of this office supply application item
	*/
	@Override
	public void setGroupId(long groupId) {
		_officeSupplyApplicationItem.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this office supply application item.
	*
	* @return the company ID of this office supply application item
	*/
	@Override
	public long getCompanyId() {
		return _officeSupplyApplicationItem.getCompanyId();
	}

	/**
	* Sets the company ID of this office supply application item.
	*
	* @param companyId the company ID of this office supply application item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_officeSupplyApplicationItem.setCompanyId(companyId);
	}

	/**
	* Returns the name of this office supply application item.
	*
	* @return the name of this office supply application item
	*/
	@Override
	public java.lang.String getName() {
		return _officeSupplyApplicationItem.getName();
	}

	/**
	* Sets the name of this office supply application item.
	*
	* @param name the name of this office supply application item
	*/
	@Override
	public void setName(java.lang.String name) {
		_officeSupplyApplicationItem.setName(name);
	}

	/**
	* Returns the model of this office supply application item.
	*
	* @return the model of this office supply application item
	*/
	@Override
	public java.lang.String getModel() {
		return _officeSupplyApplicationItem.getModel();
	}

	/**
	* Sets the model of this office supply application item.
	*
	* @param model the model of this office supply application item
	*/
	@Override
	public void setModel(java.lang.String model) {
		_officeSupplyApplicationItem.setModel(model);
	}

	/**
	* Returns the unit of this office supply application item.
	*
	* @return the unit of this office supply application item
	*/
	@Override
	public java.lang.String getUnit() {
		return _officeSupplyApplicationItem.getUnit();
	}

	/**
	* Sets the unit of this office supply application item.
	*
	* @param unit the unit of this office supply application item
	*/
	@Override
	public void setUnit(java.lang.String unit) {
		_officeSupplyApplicationItem.setUnit(unit);
	}

	/**
	* Returns the unit price of this office supply application item.
	*
	* @return the unit price of this office supply application item
	*/
	@Override
	public double getUnitPrice() {
		return _officeSupplyApplicationItem.getUnitPrice();
	}

	/**
	* Sets the unit price of this office supply application item.
	*
	* @param unitPrice the unit price of this office supply application item
	*/
	@Override
	public void setUnitPrice(double unitPrice) {
		_officeSupplyApplicationItem.setUnitPrice(unitPrice);
	}

	/**
	* Returns the quantity of this office supply application item.
	*
	* @return the quantity of this office supply application item
	*/
	@Override
	public int getQuantity() {
		return _officeSupplyApplicationItem.getQuantity();
	}

	/**
	* Sets the quantity of this office supply application item.
	*
	* @param quantity the quantity of this office supply application item
	*/
	@Override
	public void setQuantity(int quantity) {
		_officeSupplyApplicationItem.setQuantity(quantity);
	}

	/**
	* Returns the office supply application ID of this office supply application item.
	*
	* @return the office supply application ID of this office supply application item
	*/
	@Override
	public long getOfficeSupplyApplicationId() {
		return _officeSupplyApplicationItem.getOfficeSupplyApplicationId();
	}

	/**
	* Sets the office supply application ID of this office supply application item.
	*
	* @param officeSupplyApplicationId the office supply application ID of this office supply application item
	*/
	@Override
	public void setOfficeSupplyApplicationId(long officeSupplyApplicationId) {
		_officeSupplyApplicationItem.setOfficeSupplyApplicationId(officeSupplyApplicationId);
	}

	/**
	* Returns the office supply ID of this office supply application item.
	*
	* @return the office supply ID of this office supply application item
	*/
	@Override
	public long getOfficeSupplyId() {
		return _officeSupplyApplicationItem.getOfficeSupplyId();
	}

	/**
	* Sets the office supply ID of this office supply application item.
	*
	* @param officeSupplyId the office supply ID of this office supply application item
	*/
	@Override
	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyApplicationItem.setOfficeSupplyId(officeSupplyId);
	}

	@Override
	public boolean isNew() {
		return _officeSupplyApplicationItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_officeSupplyApplicationItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _officeSupplyApplicationItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_officeSupplyApplicationItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _officeSupplyApplicationItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _officeSupplyApplicationItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_officeSupplyApplicationItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _officeSupplyApplicationItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_officeSupplyApplicationItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_officeSupplyApplicationItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_officeSupplyApplicationItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeSupplyApplicationItemWrapper((OfficeSupplyApplicationItem)_officeSupplyApplicationItem.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.oa.model.OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		return _officeSupplyApplicationItem.compareTo(officeSupplyApplicationItem);
	}

	@Override
	public int hashCode() {
		return _officeSupplyApplicationItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.OfficeSupplyApplicationItem> toCacheModel() {
		return _officeSupplyApplicationItem.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApplicationItem toEscapedModel() {
		return new OfficeSupplyApplicationItemWrapper(_officeSupplyApplicationItem.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApplicationItem toUnescapedModel() {
		return new OfficeSupplyApplicationItemWrapper(_officeSupplyApplicationItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _officeSupplyApplicationItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _officeSupplyApplicationItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_officeSupplyApplicationItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyApplicationItemWrapper)) {
			return false;
		}

		OfficeSupplyApplicationItemWrapper officeSupplyApplicationItemWrapper = (OfficeSupplyApplicationItemWrapper)obj;

		if (Validator.equals(_officeSupplyApplicationItem,
					officeSupplyApplicationItemWrapper._officeSupplyApplicationItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OfficeSupplyApplicationItem getWrappedOfficeSupplyApplicationItem() {
		return _officeSupplyApplicationItem;
	}

	@Override
	public OfficeSupplyApplicationItem getWrappedModel() {
		return _officeSupplyApplicationItem;
	}

	@Override
	public void resetOriginalValues() {
		_officeSupplyApplicationItem.resetOriginalValues();
	}

	private OfficeSupplyApplicationItem _officeSupplyApplicationItem;
}