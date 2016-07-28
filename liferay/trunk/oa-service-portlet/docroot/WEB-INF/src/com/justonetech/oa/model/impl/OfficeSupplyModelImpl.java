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

import com.justonetech.oa.model.OfficeSupply;
import com.justonetech.oa.model.OfficeSupplyModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OfficeSupply service. Represents a row in the &quot;oa_OfficeSupply&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.oa.model.OfficeSupplyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficeSupplyImpl}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyImpl
 * @see com.justonetech.oa.model.OfficeSupply
 * @see com.justonetech.oa.model.OfficeSupplyModel
 * @generated
 */
public class OfficeSupplyModelImpl extends BaseModelImpl<OfficeSupply>
	implements OfficeSupplyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a office supply model instance should use the {@link com.justonetech.oa.model.OfficeSupply} interface instead.
	 */
	public static final String TABLE_NAME = "oa_OfficeSupply";
	public static final Object[][] TABLE_COLUMNS = {
			{ "officeSupplyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createTime", Types.TIMESTAMP },
			{ "modifiedTime", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "model", Types.VARCHAR },
			{ "unit", Types.VARCHAR },
			{ "unitPrice", Types.DOUBLE },
			{ "quantity", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table oa_OfficeSupply (officeSupplyId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createTime DATE null,modifiedTime DATE null,name VARCHAR(75) null,model VARCHAR(75) null,unit VARCHAR(75) null,unitPrice DOUBLE,quantity INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table oa_OfficeSupply";
	public static final String ORDER_BY_JPQL = " ORDER BY officeSupply.modifiedTime DESC";
	public static final String ORDER_BY_SQL = " ORDER BY oa_OfficeSupply.modifiedTime DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.oa.model.OfficeSupply"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.oa.model.OfficeSupply"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.justonetech.oa.model.OfficeSupply"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;
	public static long MODIFIEDTIME_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.oa.model.OfficeSupply"));

	public OfficeSupplyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officeSupplyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSupplyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSupplyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getOfficeSupplyId() {
		return _officeSupplyId;
	}

	@Override
	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyId = officeSupplyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		_createTime = createTime;
	}

	@Override
	public Date getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(Date modifiedTime) {
		_columnBitmask = -1L;

		_modifiedTime = modifiedTime;
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
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OfficeSupply.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OfficeSupply toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OfficeSupply)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OfficeSupplyImpl officeSupplyImpl = new OfficeSupplyImpl();

		officeSupplyImpl.setOfficeSupplyId(getOfficeSupplyId());
		officeSupplyImpl.setGroupId(getGroupId());
		officeSupplyImpl.setCompanyId(getCompanyId());
		officeSupplyImpl.setUserId(getUserId());
		officeSupplyImpl.setUserName(getUserName());
		officeSupplyImpl.setCreateTime(getCreateTime());
		officeSupplyImpl.setModifiedTime(getModifiedTime());
		officeSupplyImpl.setName(getName());
		officeSupplyImpl.setModel(getModel());
		officeSupplyImpl.setUnit(getUnit());
		officeSupplyImpl.setUnitPrice(getUnitPrice());
		officeSupplyImpl.setQuantity(getQuantity());

		officeSupplyImpl.resetOriginalValues();

		return officeSupplyImpl;
	}

	@Override
	public int compareTo(OfficeSupply officeSupply) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedTime(),
				officeSupply.getModifiedTime());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupply)) {
			return false;
		}

		OfficeSupply officeSupply = (OfficeSupply)obj;

		long primaryKey = officeSupply.getPrimaryKey();

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
		OfficeSupplyModelImpl officeSupplyModelImpl = this;

		officeSupplyModelImpl._originalName = officeSupplyModelImpl._name;

		officeSupplyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OfficeSupply> toCacheModel() {
		OfficeSupplyCacheModel officeSupplyCacheModel = new OfficeSupplyCacheModel();

		officeSupplyCacheModel.officeSupplyId = getOfficeSupplyId();

		officeSupplyCacheModel.groupId = getGroupId();

		officeSupplyCacheModel.companyId = getCompanyId();

		officeSupplyCacheModel.userId = getUserId();

		officeSupplyCacheModel.userName = getUserName();

		String userName = officeSupplyCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			officeSupplyCacheModel.userName = null;
		}

		Date createTime = getCreateTime();

		if (createTime != null) {
			officeSupplyCacheModel.createTime = createTime.getTime();
		}
		else {
			officeSupplyCacheModel.createTime = Long.MIN_VALUE;
		}

		Date modifiedTime = getModifiedTime();

		if (modifiedTime != null) {
			officeSupplyCacheModel.modifiedTime = modifiedTime.getTime();
		}
		else {
			officeSupplyCacheModel.modifiedTime = Long.MIN_VALUE;
		}

		officeSupplyCacheModel.name = getName();

		String name = officeSupplyCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			officeSupplyCacheModel.name = null;
		}

		officeSupplyCacheModel.model = getModel();

		String model = officeSupplyCacheModel.model;

		if ((model != null) && (model.length() == 0)) {
			officeSupplyCacheModel.model = null;
		}

		officeSupplyCacheModel.unit = getUnit();

		String unit = officeSupplyCacheModel.unit;

		if ((unit != null) && (unit.length() == 0)) {
			officeSupplyCacheModel.unit = null;
		}

		officeSupplyCacheModel.unitPrice = getUnitPrice();

		officeSupplyCacheModel.quantity = getQuantity();

		return officeSupplyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{officeSupplyId=");
		sb.append(getOfficeSupplyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupply");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
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

	private static ClassLoader _classLoader = OfficeSupply.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OfficeSupply.class
		};
	private long _officeSupplyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private String _name;
	private String _originalName;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private long _columnBitmask;
	private OfficeSupply _escapedModel;
}