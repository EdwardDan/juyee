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

package com.justonetech.cp.contract.model;

import com.justonetech.cp.contract.service.ClpSerializer;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;

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
 * @author fanqi
 */
public class ContractClp extends BaseModelImpl<Contract> implements Contract {
	public ContractClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Contract.class;
	}

	@Override
	public String getModelClassName() {
		return Contract.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _contractId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setContractId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contractId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contractId", getContractId());
		attributes.put("htlb", getHtlb());
		attributes.put("bjbh", getBjbh());
		attributes.put("bdh", getBdh());
		attributes.put("cbfs", getCbfs());
		attributes.put("htmc", getHtmc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String contractId = (String)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		String htlb = (String)attributes.get("htlb");

		if (htlb != null) {
			setHtlb(htlb);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String bdh = (String)attributes.get("bdh");

		if (bdh != null) {
			setBdh(bdh);
		}

		String cbfs = (String)attributes.get("cbfs");

		if (cbfs != null) {
			setCbfs(cbfs);
		}

		String htmc = (String)attributes.get("htmc");

		if (htmc != null) {
			setHtmc(htmc);
		}
	}

	@Override
	public String getContractId() {
		return _contractId;
	}

	@Override
	public void setContractId(String contractId) {
		_contractId = contractId;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setContractId", String.class);

				method.invoke(_contractRemoteModel, contractId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtlb() {
		return _htlb;
	}

	@Override
	public void setHtlb(String htlb) {
		_htlb = htlb;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtlb", String.class);

				method.invoke(_contractRemoteModel, htlb);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjbh() {
		return _bjbh;
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_contractRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBdh() {
		return _bdh;
	}

	@Override
	public void setBdh(String bdh) {
		_bdh = bdh;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setBdh", String.class);

				method.invoke(_contractRemoteModel, bdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCbfs() {
		return _cbfs;
	}

	@Override
	public void setCbfs(String cbfs) {
		_cbfs = cbfs;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setCbfs", String.class);

				method.invoke(_contractRemoteModel, cbfs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtmc() {
		return _htmc;
	}

	@Override
	public void setHtmc(String htmc) {
		_htmc = htmc;

		if (_contractRemoteModel != null) {
			try {
				Class<?> clazz = _contractRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmc", String.class);

				method.invoke(_contractRemoteModel, htmc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getContractRemoteModel() {
		return _contractRemoteModel;
	}

	public void setContractRemoteModel(BaseModel<?> contractRemoteModel) {
		_contractRemoteModel = contractRemoteModel;
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

		Class<?> remoteModelClass = _contractRemoteModel.getClass();

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

		Object returnValue = method.invoke(_contractRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ContractLocalServiceUtil.addContract(this);
		}
		else {
			ContractLocalServiceUtil.updateContract(this);
		}
	}

	@Override
	public Contract toEscapedModel() {
		return (Contract)ProxyUtil.newProxyInstance(Contract.class.getClassLoader(),
			new Class[] { Contract.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContractClp clone = new ContractClp();

		clone.setContractId(getContractId());
		clone.setHtlb(getHtlb());
		clone.setBjbh(getBjbh());
		clone.setBdh(getBdh());
		clone.setCbfs(getCbfs());
		clone.setHtmc(getHtmc());

		return clone;
	}

	@Override
	public int compareTo(Contract contract) {
		String primaryKey = contract.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContractClp)) {
			return false;
		}

		ContractClp contract = (ContractClp)obj;

		String primaryKey = contract.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{contractId=");
		sb.append(getContractId());
		sb.append(", htlb=");
		sb.append(getHtlb());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", bdh=");
		sb.append(getBdh());
		sb.append(", cbfs=");
		sb.append(getCbfs());
		sb.append(", htmc=");
		sb.append(getHtmc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.contract.model.Contract");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contractId</column-name><column-value><![CDATA[");
		sb.append(getContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htlb</column-name><column-value><![CDATA[");
		sb.append(getHtlb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bdh</column-name><column-value><![CDATA[");
		sb.append(getBdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cbfs</column-name><column-value><![CDATA[");
		sb.append(getCbfs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmc</column-name><column-value><![CDATA[");
		sb.append(getHtmc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _contractId;
	private String _htlb;
	private String _bjbh;
	private String _bdh;
	private String _cbfs;
	private String _htmc;
	private BaseModel<?> _contractRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.contract.service.ClpSerializer.class;
}