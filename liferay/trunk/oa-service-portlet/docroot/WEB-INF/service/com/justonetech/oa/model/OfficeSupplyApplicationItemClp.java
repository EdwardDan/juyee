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
import com.justonetech.oa.service.OfficeSupplyApplicationItemLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author justonetech
 */
public class OfficeSupplyApplicationItemClp extends BaseModelImpl<OfficeSupplyApplicationItem>
	implements OfficeSupplyApplicationItem {
	public OfficeSupplyApplicationItemClp() {
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

	@Override
	public long getOfficeSupplyApplicationItemId() {
		return _officeSupplyApplicationItemId;
	}

	@Override
	public void setOfficeSupplyApplicationItemId(
		long officeSupplyApplicationItemId) {
		_officeSupplyApplicationItemId = officeSupplyApplicationItemId;

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyApplicationItemId",
						long.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel,
					officeSupplyApplicationItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel, companyId);
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

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel, name);
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

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModel", String.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel, model);
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

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUnit", String.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel, unit);
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

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitPrice", double.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel, unitPrice);
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

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOfficeSupplyApplicationId() {
		return _officeSupplyApplicationId;
	}

	@Override
	public void setOfficeSupplyApplicationId(long officeSupplyApplicationId) {
		_officeSupplyApplicationId = officeSupplyApplicationId;

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyApplicationId",
						long.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel,
					officeSupplyApplicationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOfficeSupplyId() {
		return _officeSupplyId;
	}

	@Override
	public void setOfficeSupplyId(long officeSupplyId) {
		_officeSupplyId = officeSupplyId;

		if (_officeSupplyApplicationItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplicationItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyId", long.class);

				method.invoke(_officeSupplyApplicationItemRemoteModel,
					officeSupplyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOfficeSupplyApplicationItemRemoteModel() {
		return _officeSupplyApplicationItemRemoteModel;
	}

	public void setOfficeSupplyApplicationItemRemoteModel(
		BaseModel<?> officeSupplyApplicationItemRemoteModel) {
		_officeSupplyApplicationItemRemoteModel = officeSupplyApplicationItemRemoteModel;
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

		Class<?> remoteModelClass = _officeSupplyApplicationItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_officeSupplyApplicationItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OfficeSupplyApplicationItemLocalServiceUtil.addOfficeSupplyApplicationItem(this);
		}
		else {
			OfficeSupplyApplicationItemLocalServiceUtil.updateOfficeSupplyApplicationItem(this);
		}
	}

	@Override
	public OfficeSupplyApplicationItem toEscapedModel() {
		return (OfficeSupplyApplicationItem)ProxyUtil.newProxyInstance(OfficeSupplyApplicationItem.class.getClassLoader(),
			new Class[] { OfficeSupplyApplicationItem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfficeSupplyApplicationItemClp clone = new OfficeSupplyApplicationItemClp();

		clone.setOfficeSupplyApplicationItemId(getOfficeSupplyApplicationItemId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setName(getName());
		clone.setModel(getModel());
		clone.setUnit(getUnit());
		clone.setUnitPrice(getUnitPrice());
		clone.setQuantity(getQuantity());
		clone.setOfficeSupplyApplicationId(getOfficeSupplyApplicationId());
		clone.setOfficeSupplyId(getOfficeSupplyId());

		return clone;
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

		if (!(obj instanceof OfficeSupplyApplicationItemClp)) {
			return false;
		}

		OfficeSupplyApplicationItemClp officeSupplyApplicationItem = (OfficeSupplyApplicationItemClp)obj;

		long primaryKey = officeSupplyApplicationItem.getPrimaryKey();

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

		sb.append("{officeSupplyApplicationItemId=");
		sb.append(getOfficeSupplyApplicationItemId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupplyApplicationItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyApplicationItemId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyApplicationItemId());
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

	private long _officeSupplyApplicationItemId;
	private long _groupId;
	private long _companyId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private long _officeSupplyApplicationId;
	private long _officeSupplyId;
	private BaseModel<?> _officeSupplyApplicationItemRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}