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

import com.justonetech.oa.service.ClpSerializer;
import com.justonetech.oa.service.OfficeSupplyLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author justonetech
 */
public class OfficeSupplyClp extends BaseModelImpl<OfficeSupply>
	implements OfficeSupply {
	public OfficeSupplyClp() {
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyId", getOfficeSupplyId());
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

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyId", long.class);

				method.invoke(_officeSupplyRemoteModel, officeSupplyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_officeSupplyRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_officeSupplyRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		_createTime = createTime;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateTime", Date.class);

				method.invoke(_officeSupplyRemoteModel, createTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(Date modifiedTime) {
		_modifiedTime = modifiedTime;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedTime", Date.class);

				method.invoke(_officeSupplyRemoteModel, modifiedTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_officeSupplyRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModel() {
		return _model;
	}

	@Override
	public void setModel(String model) {
		_model = model;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setModel", String.class);

				method.invoke(_officeSupplyRemoteModel, model);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnit() {
		return _unit;
	}

	@Override
	public void setUnit(String unit) {
		_unit = unit;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setUnit", String.class);

				method.invoke(_officeSupplyRemoteModel, unit);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getUnitPrice() {
		return _unitPrice;
	}

	@Override
	public void setUnitPrice(double unitPrice) {
		_unitPrice = unitPrice;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitPrice", double.class);

				method.invoke(_officeSupplyRemoteModel, unitPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		_quantity = quantity;

		if (_officeSupplyRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_officeSupplyRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOfficeSupplyRemoteModel() {
		return _officeSupplyRemoteModel;
	}

	public void setOfficeSupplyRemoteModel(BaseModel<?> officeSupplyRemoteModel) {
		_officeSupplyRemoteModel = officeSupplyRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _officeSupplyRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_officeSupplyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OfficeSupplyLocalServiceUtil.addOfficeSupply(this);
		}
		else {
			OfficeSupplyLocalServiceUtil.updateOfficeSupply(this);
		}
	}

	@Override
	public OfficeSupply toEscapedModel() {
		return (OfficeSupply)ProxyUtil.newProxyInstance(OfficeSupply.class.getClassLoader(),
			new Class[] { OfficeSupply.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfficeSupplyClp clone = new OfficeSupplyClp();

		clone.setOfficeSupplyId(getOfficeSupplyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateTime(getCreateTime());
		clone.setModifiedTime(getModifiedTime());
		clone.setName(getName());
		clone.setModel(getModel());
		clone.setUnit(getUnit());
		clone.setUnitPrice(getUnitPrice());
		clone.setQuantity(getQuantity());

		return clone;
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

		if (!(obj instanceof OfficeSupplyClp)) {
			return false;
		}

		OfficeSupplyClp officeSupply = (OfficeSupplyClp)obj;

		long primaryKey = officeSupply.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{officeSupplyId=");
		sb.append(getOfficeSupplyId());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupply");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyId());
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

	private long _officeSupplyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private BaseModel<?> _officeSupplyRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}