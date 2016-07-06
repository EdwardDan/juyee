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

package com.justonetech.oa.model.impl;

import com.justonetech.oa.model.OfficeSupplyApplyItem;
import com.justonetech.oa.model.OfficeSupplyApplyItemModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OfficeSupplyApplyItem service. Represents a row in the &quot;oa_OfficeSupplyApplyItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.oa.model.OfficeSupplyApplyItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficeSupplyApplyItemImpl}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplyItemImpl
 * @see com.justonetech.oa.model.OfficeSupplyApplyItem
 * @see com.justonetech.oa.model.OfficeSupplyApplyItemModel
 * @generated
 */
public class OfficeSupplyApplyItemModelImpl extends BaseModelImpl<OfficeSupplyApplyItem>
	implements OfficeSupplyApplyItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a office supply apply item model instance should use the {@link com.justonetech.oa.model.OfficeSupplyApplyItem} interface instead.
	 */
	public static final String TABLE_NAME = "oa_OfficeSupplyApplyItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "officeSupplyApplyItemId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "model", Types.VARCHAR },
			{ "unit", Types.VARCHAR },
			{ "unitPrice", Types.DOUBLE },
			{ "quantity", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table oa_OfficeSupplyApplyItem (officeSupplyApplyItemId LONG not null primary key,name VARCHAR(75) null,model VARCHAR(75) null,unit VARCHAR(75) null,unitPrice DOUBLE,quantity INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table oa_OfficeSupplyApplyItem";
	public static final String ORDER_BY_JPQL = " ORDER BY officeSupplyApplyItem.officeSupplyApplyItemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY oa_OfficeSupplyApplyItem.officeSupplyApplyItemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.oa.model.OfficeSupplyApplyItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.oa.model.OfficeSupplyApplyItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.oa.model.OfficeSupplyApplyItem"));

	public OfficeSupplyApplyItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officeSupplyApplyItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSupplyApplyItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSupplyApplyItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getOfficeSupplyApplyItemId() {
		return _officeSupplyApplyItemId;
	}

	@Override
	public void setOfficeSupplyApplyItemId(long officeSupplyApplyItemId) {
		_officeSupplyApplyItemId = officeSupplyApplyItemId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getModel() {
		if (_model == null) {
			return StringPool.BLANK;
		}
		else {
			return _model;
		}
	}

	@Override
	public void setModel(String model) {
		_model = model;
	}

	@Override
	public String getUnit() {
		if (_unit == null) {
			return StringPool.BLANK;
		}
		else {
			return _unit;
		}
	}

	@Override
	public void setUnit(String unit) {
		_unit = unit;
	}

	@Override
	public double getUnitPrice() {
		return _unitPrice;
	}

	@Override
	public void setUnitPrice(double unitPrice) {
		_unitPrice = unitPrice;
	}

	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			OfficeSupplyApplyItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OfficeSupplyApplyItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OfficeSupplyApplyItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OfficeSupplyApplyItemImpl officeSupplyApplyItemImpl = new OfficeSupplyApplyItemImpl();

		officeSupplyApplyItemImpl.setOfficeSupplyApplyItemId(getOfficeSupplyApplyItemId());
		officeSupplyApplyItemImpl.setName(getName());
		officeSupplyApplyItemImpl.setModel(getModel());
		officeSupplyApplyItemImpl.setUnit(getUnit());
		officeSupplyApplyItemImpl.setUnitPrice(getUnitPrice());
		officeSupplyApplyItemImpl.setQuantity(getQuantity());

		officeSupplyApplyItemImpl.resetOriginalValues();

		return officeSupplyApplyItemImpl;
	}

	@Override
	public int compareTo(OfficeSupplyApplyItem officeSupplyApplyItem) {
		long primaryKey = officeSupplyApplyItem.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyApplyItem)) {
			return false;
		}

		OfficeSupplyApplyItem officeSupplyApplyItem = (OfficeSupplyApplyItem)obj;

		long primaryKey = officeSupplyApplyItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<OfficeSupplyApplyItem> toCacheModel() {
		OfficeSupplyApplyItemCacheModel officeSupplyApplyItemCacheModel = new OfficeSupplyApplyItemCacheModel();

		officeSupplyApplyItemCacheModel.officeSupplyApplyItemId = getOfficeSupplyApplyItemId();

		officeSupplyApplyItemCacheModel.name = getName();

		String name = officeSupplyApplyItemCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			officeSupplyApplyItemCacheModel.name = null;
		}

		officeSupplyApplyItemCacheModel.model = getModel();

		String model = officeSupplyApplyItemCacheModel.model;

		if ((model != null) && (model.length() == 0)) {
			officeSupplyApplyItemCacheModel.model = null;
		}

		officeSupplyApplyItemCacheModel.unit = getUnit();

		String unit = officeSupplyApplyItemCacheModel.unit;

		if ((unit != null) && (unit.length() == 0)) {
			officeSupplyApplyItemCacheModel.unit = null;
		}

		officeSupplyApplyItemCacheModel.unitPrice = getUnitPrice();

		officeSupplyApplyItemCacheModel.quantity = getQuantity();

		return officeSupplyApplyItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{officeSupplyApplyItemId=");
		sb.append(getOfficeSupplyApplyItemId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", model=");
		sb.append(getModel());
		sb.append(", unit=");
		sb.append(getUnit());
		sb.append(", unitPrice=");
		sb.append(getUnitPrice());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupplyApplyItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyApplyItemId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyApplyItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>model</column-name><column-value><![CDATA[");
		sb.append(getModel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unit</column-name><column-value><![CDATA[");
		sb.append(getUnit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitPrice</column-name><column-value><![CDATA[");
		sb.append(getUnitPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OfficeSupplyApplyItem.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OfficeSupplyApplyItem.class
		};
	private long _officeSupplyApplyItemId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private OfficeSupplyApplyItem _escapedModel;
}