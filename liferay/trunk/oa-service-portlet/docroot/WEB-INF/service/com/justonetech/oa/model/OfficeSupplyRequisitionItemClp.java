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
import com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalServiceUtil;

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
public class OfficeSupplyRequisitionItemClp extends BaseModelImpl<OfficeSupplyRequisitionItem>
	implements OfficeSupplyRequisitionItem {
	public OfficeSupplyRequisitionItemClp() {
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
	public long getPrimaryKey() {
		return _officeSupplyRequisitionItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSupplyRequisitionItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSupplyRequisitionItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getOfficeSupplyRequisitionItemId() {
		return _officeSupplyRequisitionItemId;
	}

	@Override
	public void setOfficeSupplyRequisitionItemId(
		long officeSupplyRequisitionItemId) {
		_officeSupplyRequisitionItemId = officeSupplyRequisitionItemId;

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyRequisitionItemId",
						long.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel,
					officeSupplyRequisitionItemId);
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

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel, name);
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

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModel", String.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel, model);
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

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUnit", String.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel, unit);
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

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitPrice", double.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel, unitPrice);
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

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", int.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOfficeSupplyRequisitionId() {
		return _officeSupplyRequisitionId;
	}

	@Override
	public void setOfficeSupplyRequisitionId(long officeSupplyRequisitionId) {
		_officeSupplyRequisitionId = officeSupplyRequisitionId;

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyRequisitionId",
						long.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel,
					officeSupplyRequisitionId);
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

		if (_officeSupplyRequisitionItemRemoteModel != null) {
			try {
				Class<?> clazz = _officeSupplyRequisitionItemRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSupplyId", long.class);

				method.invoke(_officeSupplyRequisitionItemRemoteModel,
					officeSupplyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOfficeSupplyRequisitionItemRemoteModel() {
		return _officeSupplyRequisitionItemRemoteModel;
	}

	public void setOfficeSupplyRequisitionItemRemoteModel(
		BaseModel<?> officeSupplyRequisitionItemRemoteModel) {
		_officeSupplyRequisitionItemRemoteModel = officeSupplyRequisitionItemRemoteModel;
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

		Class<?> remoteModelClass = _officeSupplyRequisitionItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_officeSupplyRequisitionItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OfficeSupplyRequisitionItemLocalServiceUtil.addOfficeSupplyRequisitionItem(this);
		}
		else {
			OfficeSupplyRequisitionItemLocalServiceUtil.updateOfficeSupplyRequisitionItem(this);
		}
	}

	@Override
	public OfficeSupplyRequisitionItem toEscapedModel() {
		return (OfficeSupplyRequisitionItem)ProxyUtil.newProxyInstance(OfficeSupplyRequisitionItem.class.getClassLoader(),
			new Class[] { OfficeSupplyRequisitionItem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OfficeSupplyRequisitionItemClp clone = new OfficeSupplyRequisitionItemClp();

		clone.setOfficeSupplyRequisitionItemId(getOfficeSupplyRequisitionItemId());
		clone.setName(getName());
		clone.setModel(getModel());
		clone.setUnit(getUnit());
		clone.setUnitPrice(getUnitPrice());
		clone.setQuantity(getQuantity());
		clone.setOfficeSupplyRequisitionId(getOfficeSupplyRequisitionId());
		clone.setOfficeSupplyId(getOfficeSupplyId());

		return clone;
	}

	@Override
	public int compareTo(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		long primaryKey = officeSupplyRequisitionItem.getPrimaryKey();

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

		if (!(obj instanceof OfficeSupplyRequisitionItemClp)) {
			return false;
		}

		OfficeSupplyRequisitionItemClp officeSupplyRequisitionItem = (OfficeSupplyRequisitionItemClp)obj;

		long primaryKey = officeSupplyRequisitionItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{officeSupplyRequisitionItemId=");
		sb.append(getOfficeSupplyRequisitionItemId());
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
		sb.append(", officeSupplyRequisitionId=");
		sb.append(getOfficeSupplyRequisitionId());
		sb.append(", officeSupplyId=");
		sb.append(getOfficeSupplyId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupplyRequisitionItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyRequisitionItemId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyRequisitionItemId());
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
			"<column><column-name>officeSupplyRequisitionId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyRequisitionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSupplyId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _officeSupplyRequisitionItemId;
	private String _name;
	private String _model;
	private String _unit;
	private double _unitPrice;
	private int _quantity;
	private long _officeSupplyRequisitionId;
	private long _officeSupplyId;
	private BaseModel<?> _officeSupplyRequisitionItemRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.oa.service.ClpSerializer.class;
}