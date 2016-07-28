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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OfficeSupply}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupply
 * @generated
 */
public class OfficeSupplyWrapper implements OfficeSupply,
	ModelWrapper<OfficeSupply> {
	public OfficeSupplyWrapper(OfficeSupply officeSupply) {
		_officeSupply = officeSupply;
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupply.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupply.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyId", getOfficeSupplyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("name", getName());
		attributes.put("model", getModel());
		attributes.put("unit", getUnit());
		attributes.put("unitPrice", getUnitPrice());
		attributes.put("quantity", getQuantity());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyId = (Long)attributes.get("officeSupplyId");

		if (officeSupplyId != null) {
			setOfficeSupplyId(officeSupplyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createTime = (Date)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Date modifiedTime = (Date)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
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
	* Returns the primary key of this office supply.
	*
	* @return the primary key of this office supply
	*/
	@Override
	public long getPrimaryKey() {
		return _officeSupply.getPrimaryKey();
	}

	/**
	* Sets the primary key of this office supply.
	*
	* @param primaryKey the primary key of this office supply
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_officeSupply.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the office supply ID of this office supply.
	*
	* @return the office supply ID of this office supply
	*/
	@Override
	public long getOfficeSupplyId() {
		return _officeSupply.getOfficeSupplyId();
	}

	/**
	* Sets the office supply ID of this office supply.
	*
	* @param officeSupplyId the office supply ID of this office supply
	*/
	@Override
	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupply.setOfficeSupplyId(officeSupplyId);
	}

	/**
	* Returns the group ID of this office supply.
	*
	* @return the group ID of this office supply
	*/
	@Override
	public long getGroupId() {
		return _officeSupply.getGroupId();
	}

	/**
	* Sets the group ID of this office supply.
	*
	* @param groupId the group ID of this office supply
	*/
	@Override
	public void setGroupId(long groupId) {
		_officeSupply.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this office supply.
	*
	* @return the company ID of this office supply
	*/
	@Override
	public long getCompanyId() {
		return _officeSupply.getCompanyId();
	}

	/**
	* Sets the company ID of this office supply.
	*
	* @param companyId the company ID of this office supply
	*/
	@Override
	public void setCompanyId(long companyId) {
		_officeSupply.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this office supply.
	*
	* @return the user ID of this office supply
	*/
	@Override
	public long getUserId() {
		return _officeSupply.getUserId();
	}

	/**
	* Sets the user ID of this office supply.
	*
	* @param userId the user ID of this office supply
	*/
	@Override
	public void setUserId(long userId) {
		_officeSupply.setUserId(userId);
	}

	/**
	* Returns the user uuid of this office supply.
	*
	* @return the user uuid of this office supply
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupply.getUserUuid();
	}

	/**
	* Sets the user uuid of this office supply.
	*
	* @param userUuid the user uuid of this office supply
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_officeSupply.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this office supply.
	*
	* @return the user name of this office supply
	*/
	@Override
	public java.lang.String getUserName() {
		return _officeSupply.getUserName();
	}

	/**
	* Sets the user name of this office supply.
	*
	* @param userName the user name of this office supply
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_officeSupply.setUserName(userName);
	}

	/**
	* Returns the create time of this office supply.
	*
	* @return the create time of this office supply
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _officeSupply.getCreateTime();
	}

	/**
	* Sets the create time of this office supply.
	*
	* @param createTime the create time of this office supply
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_officeSupply.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this office supply.
	*
	* @return the modified time of this office supply
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _officeSupply.getModifiedTime();
	}

	/**
	* Sets the modified time of this office supply.
	*
	* @param modifiedTime the modified time of this office supply
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_officeSupply.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the name of this office supply.
	*
	* @return the name of this office supply
	*/
	@Override
	public java.lang.String getName() {
		return _officeSupply.getName();
	}

	/**
	* Sets the name of this office supply.
	*
	* @param name the name of this office supply
	*/
	@Override
	public void setName(java.lang.String name) {
		_officeSupply.setName(name);
	}

	/**
	* Returns the model of this office supply.
	*
	* @return the model of this office supply
	*/
	@Override
	public java.lang.String getModel() {
		return _officeSupply.getModel();
	}

	/**
	* Sets the model of this office supply.
	*
	* @param model the model of this office supply
	*/
	@Override
	public void setModel(java.lang.String model) {
		_officeSupply.setModel(model);
	}

	/**
	* Returns the unit of this office supply.
	*
	* @return the unit of this office supply
	*/
	@Override
	public java.lang.String getUnit() {
		return _officeSupply.getUnit();
	}

	/**
	* Sets the unit of this office supply.
	*
	* @param unit the unit of this office supply
	*/
	@Override
	public void setUnit(java.lang.String unit) {
		_officeSupply.setUnit(unit);
	}

	/**
	* Returns the unit price of this office supply.
	*
	* @return the unit price of this office supply
	*/
	@Override
	public double getUnitPrice() {
		return _officeSupply.getUnitPrice();
	}

	/**
	* Sets the unit price of this office supply.
	*
	* @param unitPrice the unit price of this office supply
	*/
	@Override
	public void setUnitPrice(double unitPrice) {
		_officeSupply.setUnitPrice(unitPrice);
	}

	/**
	* Returns the quantity of this office supply.
	*
	* @return the quantity of this office supply
	*/
	@Override
	public int getQuantity() {
		return _officeSupply.getQuantity();
	}

	/**
	* Sets the quantity of this office supply.
	*
	* @param quantity the quantity of this office supply
	*/
	@Override
	public void setQuantity(int quantity) {
		_officeSupply.setQuantity(quantity);
	}

	@Override
	public boolean isNew() {
		return _officeSupply.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_officeSupply.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _officeSupply.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_officeSupply.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _officeSupply.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _officeSupply.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_officeSupply.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _officeSupply.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_officeSupply.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_officeSupply.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_officeSupply.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OfficeSupplyWrapper((OfficeSupply)_officeSupply.clone());
	}

	@Override
	public int compareTo(com.justonetech.oa.model.OfficeSupply officeSupply) {
		return _officeSupply.compareTo(officeSupply);
	}

	@Override
	public int hashCode() {
		return _officeSupply.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.oa.model.OfficeSupply> toCacheModel() {
		return _officeSupply.toCacheModel();
	}

	@Override
	public com.justonetech.oa.model.OfficeSupply toEscapedModel() {
		return new OfficeSupplyWrapper(_officeSupply.toEscapedModel());
	}

	@Override
	public com.justonetech.oa.model.OfficeSupply toUnescapedModel() {
		return new OfficeSupplyWrapper(_officeSupply.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _officeSupply.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _officeSupply.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_officeSupply.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyWrapper)) {
			return false;
		}

		OfficeSupplyWrapper officeSupplyWrapper = (OfficeSupplyWrapper)obj;

		if (Validator.equals(_officeSupply, officeSupplyWrapper._officeSupply)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OfficeSupply getWrappedOfficeSupply() {
		return _officeSupply;
	}

	@Override
	public OfficeSupply getWrappedModel() {
		return _officeSupply;
	}

	@Override
	public void resetOriginalValues() {
		_officeSupply.resetOriginalValues();
	}

	private OfficeSupply _officeSupply;
}