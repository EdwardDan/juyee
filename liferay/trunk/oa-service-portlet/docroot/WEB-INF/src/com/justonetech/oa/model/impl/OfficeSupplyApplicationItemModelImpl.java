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

import com.justonetech.oa.model.OfficeSupplyApplicationItem;
import com.justonetech.oa.model.OfficeSupplyApplicationItemModel;

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
 * The base model implementation for the OfficeSupplyApplicationItem service. Represents a row in the &quot;oa_OfficeSupplyApplicationItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.oa.model.OfficeSupplyApplicationItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficeSupplyApplicationItemImpl}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplicationItemImpl
 * @see com.justonetech.oa.model.OfficeSupplyApplicationItem
 * @see com.justonetech.oa.model.OfficeSupplyApplicationItemModel
 * @generated
 */
public class OfficeSupplyApplicationItemModelImpl extends BaseModelImpl<OfficeSupplyApplicationItem>
	implements OfficeSupplyApplicationItemModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a office supply application item model instance should use the {@link com.justonetech.oa.model.OfficeSupplyApplicationItem} interface instead.
	 */
	public static final String TABLE_NAME = "oa_OfficeSupplyApplicationItem";
	public static final Object[][] TABLE_COLUMNS = {
			{ "officeSupplyApplicationItemId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "model", Types.VARCHAR },
			{ "unit", Types.VARCHAR },
			{ "unitPrice", Types.DOUBLE },
			{ "quantity", Types.INTEGER },
			{ "officeSupplyApplicationId", Types.BIGINT },
			{ "officeSupplyId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table oa_OfficeSupplyApplicationItem (officeSupplyApplicationItemId LONG not null primary key,name VARCHAR(75) null,model VARCHAR(75) null,unit VARCHAR(75) null,unitPrice DOUBLE,quantity INTEGER,officeSupplyApplicationId LONG,officeSupplyId LONG)";
	public static final String TABLE_SQL_DROP = "drop table oa_OfficeSupplyApplicationItem";
	public static final String ORDER_BY_JPQL = " ORDER BY officeSupplyApplicationItem.officeSupplyApplicationItemId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY oa_OfficeSupplyApplicationItem.officeSupplyApplicationItemId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.oa.model.OfficeSupplyApplicationItem"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.oa.model.OfficeSupplyApplicationItem"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.justonetech.oa.model.OfficeSupplyApplicationItem"),
			true);
	public static long OFFICESUPPLYAPPLICATIONID_COLUMN_BITMASK = 1L;
	public static long OFFICESUPPLYAPPLICATIONITEMID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.oa.model.OfficeSupplyApplicationItem"));

	public OfficeSupplyApplicationItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officeSupplyApplicationItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSupplyApplicationItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSupplyApplicationItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getOfficeSupplyApplicationItemId() {
		return _officeSupplyApplicationItemId;
	}

	@Override
	public void setOfficeSupplyApplicationItemId(
		long officeSupplyApplicationItemId) {
		_officeSupplyApplicationItemId = officeSupplyApplicationItemId;
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
	public long getOfficeSupplyApplicationId() {
		return _officeSupplyApplicationId;
	}

	@Override
	public void setOfficeSupplyApplicationId(long officeSupplyApplicationId) {
		_columnBitmask |= OFFICESUPPLYAPPLICATIONID_COLUMN_BITMASK;

		if (!_setOriginalOfficeSupplyApplicationId) {
			_setOriginalOfficeSupplyApplicationId = true;

			_originalOfficeSupplyApplicationId = _officeSupplyApplicationId;
		}

		_officeSupplyApplicationId = officeSupplyApplicationId;
	}

	public long getOriginalOfficeSupplyApplicationId() {
		return _originalOfficeSupplyApplicationId;
	}

	@Override
	public long getOfficeSupplyId() {
		return _officeSupplyId;
	}

	@Override
	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyId = officeSupplyId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			OfficeSupplyApplicationItem.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OfficeSupplyApplicationItem toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OfficeSupplyApplicationItem)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OfficeSupplyApplicationItemImpl officeSupplyApplicationItemImpl = new OfficeSupplyApplicationItemImpl();

		officeSupplyApplicationItemImpl.setOfficeSupplyApplicationItemId(getOfficeSupplyApplicationItemId());
		officeSupplyApplicationItemImpl.setName(getName());
		officeSupplyApplicationItemImpl.setModel(getModel());
		officeSupplyApplicationItemImpl.setUnit(getUnit());
		officeSupplyApplicationItemImpl.setUnitPrice(getUnitPrice());
		officeSupplyApplicationItemImpl.setQuantity(getQuantity());
		officeSupplyApplicationItemImpl.setOfficeSupplyApplicationId(getOfficeSupplyApplicationId());
		officeSupplyApplicationItemImpl.setOfficeSupplyId(getOfficeSupplyId());

		officeSupplyApplicationItemImpl.resetOriginalValues();

		return officeSupplyApplicationItemImpl;
	}

	@Override
	public int compareTo(
		OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		long primaryKey = officeSupplyApplicationItem.getPrimaryKey();

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

		if (!(obj instanceof OfficeSupplyApplicationItem)) {
			return false;
		}

		OfficeSupplyApplicationItem officeSupplyApplicationItem = (OfficeSupplyApplicationItem)obj;

		long primaryKey = officeSupplyApplicationItem.getPrimaryKey();

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
		OfficeSupplyApplicationItemModelImpl officeSupplyApplicationItemModelImpl =
			this;

		officeSupplyApplicationItemModelImpl._originalOfficeSupplyApplicationId = officeSupplyApplicationItemModelImpl._officeSupplyApplicationId;

		officeSupplyApplicationItemModelImpl._setOriginalOfficeSupplyApplicationId = false;

		officeSupplyApplicationItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OfficeSupplyApplicationItem> toCacheModel() {
		OfficeSupplyApplicationItemCacheModel officeSupplyApplicationItemCacheModel =
			new OfficeSupplyApplicationItemCacheModel();

		officeSupplyApplicationItemCacheModel.officeSupplyApplicationItemId = getOfficeSupplyApplicationItemId();

		officeSupplyApplicationItemCacheModel.name = getName();

		String name = officeSupplyApplicationItemCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			officeSupplyApplicationItemCacheModel.name = null;
		}

		officeSupplyApplicationItemCacheModel.model = getModel();

		String model = officeSupplyApplicationItemCacheModel.model;

		if ((model != null) && (model.length() == 0)) {
			officeSupplyApplicationItemCacheModel.model = null;
		}

		officeSupplyApplicationItemCacheModel.unit = getUnit();

		String unit = officeSupplyApplicationItemCacheModel.unit;

		if ((unit != null) && (unit.length() == 0)) {
			officeSupplyApplicationItemCacheModel.unit = null;
		}

		officeSupplyApplicationItemCacheModel.unitPrice = getUnitPrice();

		officeSupplyApplicationItemCacheModel.quantity = getQuantity();

		officeSupplyApplicationItemCacheModel.officeSupplyApplicationId = getOfficeSupplyApplicationId();

		officeSupplyApplicationItemCacheModel.officeSupplyId = getOfficeSupplyId();

		return officeSupplyApplicationItemCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{officeSupplyApplicationItemId=");
		sb.append(getOfficeSupplyApplicationItemId());
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
		sb.append(", officeSupplyApplicationId=");
		sb.append(getOfficeSupplyApplicationId());
		sb.append(", officeSupplyId=");
		sb.append(getOfficeSupplyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupplyApplicationItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyApplicationItemId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyApplicationItemId());
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
		sb.append(
			"<column><column-name>officeSupplyApplicationId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSupplyId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OfficeSupplyApplicationItem.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OfficeSupplyApplicationItem.class
		};
	private long _officeSupplyApplicationItemId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private long _officeSupplyApplicationId;
	private long _originalOfficeSupplyApplicationId;
	private boolean _setOriginalOfficeSupplyApplicationId;
	private long _officeSupplyId;
	private long _columnBitmask;
	private OfficeSupplyApplicationItem _escapedModel;
}