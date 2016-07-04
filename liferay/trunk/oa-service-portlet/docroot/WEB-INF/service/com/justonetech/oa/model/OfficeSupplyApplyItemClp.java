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
import com.justonetech.oa.service.OfficeSupplyApplyItemLocalServiceUtil;

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
public class OfficeSupplyApplyItemClp extends BaseModelImpl<OfficeSupplyApplyItem>
	implements OfficeSupplyApplyItem {
	public OfficeSupplyApplyItemClp() {
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

		if (_officeSupplyApplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyApplyItemId",
						long.class);

				method.invoke(_officeSupplyApplyItemRemoteModel,
					officeSupplyApplyItemId);
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

		if (_officeSupplyApplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_officeSupplyApplyItemRemoteModel, name);
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

		if (_officeSupplyApplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModel", String.class);

				method.invoke(_officeSupplyApplyItemRemoteModel, model);
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

		if (_officeSupplyApplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUnit", String.class);

				method.invoke(_officeSupplyApplyItemRemoteModel, unit);
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

		if (_officeSupplyApplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitPrice", double.class);

				method.invoke(_officeSupplyApplyItemRemoteModel, unitPrice);
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

		if (_officeSupplyApplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyApplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_officeSupplyApplyItemRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOfficeSupplyApplyItemRemoteModel() {
		return _officeSupplyApplyItemRemoteModel;
	}

	public void setOfficeSupplyApplyItemRemoteModel(
		BaseModel<?> officeSupplyApplyItemRemoteModel) {
		_officeSupplyApplyItemRemoteModel = officeSupplyApplyItemRemoteModel;
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

		Class<?> remoteModelClass = _officeSupplyApplyItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_officeSupplyApplyItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OfficeSupplyApplyItemLocalServiceUtil.addOfficeSupplyApplyItem(this);
		}
		else {
			OfficeSupplyApplyItemLocalServiceUtil.updateOfficeSupplyApplyItem(this);
		}
	}

	@Override
	public OfficeSupplyApplyItem toEscapedModel() {
		return (OfficeSupplyApplyItem)ProxyUtil.newProxyInstance(OfficeSupplyApplyItem.class.getClassLoader(),
			new Class[] { OfficeSupplyApplyItem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfficeSupplyApplyItemClp clone = new OfficeSupplyApplyItemClp();

		clone.setOfficeSupplyApplyItemId(getOfficeSupplyApplyItemId());
		clone.setName(getName());
		clone.setModel(getModel());
		clone.setUnit(getUnit());
		clone.setUnitPrice(getUnitPrice());
		clone.setQuantity(getQuantity());

		return clone;
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

		if (!(obj instanceof OfficeSupplyApplyItemClp)) {
			return false;
		}

		OfficeSupplyApplyItemClp officeSupplyApplyItem = (OfficeSupplyApplyItemClp)obj;

		long primaryKey = officeSupplyApplyItem.getPrimaryKey();

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

	private long _officeSupplyApplyItemId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private BaseModel<?> _officeSupplyApplyItemRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}