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

package com.justonetech.proj.model;

import com.justonetech.proj.service.ClpSerializer;
import com.justonetech.proj.service.CompanyLocalServiceUtil;

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
public class CompanyClp extends BaseModelImpl<Company> implements Company {
	public CompanyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Company.class;
	}

	@Override
	public String getModelClassName() {
		return Company.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _companyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCompanyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _companyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("type", getType());
		attributes.put("unitName", getUnitName());
		attributes.put("indepLegal", getIndepLegal());
		attributes.put("indepLegalTel", getIndepLegalTel());
		attributes.put("indepLegalFax", getIndepLegalFax());
		attributes.put("indepLegalPhone", getIndepLegalPhone());
		attributes.put("projLegal", getProjLegal());
		attributes.put("projLegalTel", getProjLegalTel());
		attributes.put("projLegalFax", getProjLegalFax());
		attributes.put("projLegalPhone", getProjLegalPhone());
		attributes.put("linkman", getLinkman());
		attributes.put("linkmanTel", getLinkmanTel());
		attributes.put("linkmanFax", getLinkmanFax());
		attributes.put("linkmanPhone", getLinkmanPhone());
		attributes.put("projectId", getProjectId());
		attributes.put("biddingId", getBiddingId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String unitName = (String)attributes.get("unitName");

		if (unitName != null) {
			setUnitName(unitName);
		}

		String indepLegal = (String)attributes.get("indepLegal");

		if (indepLegal != null) {
			setIndepLegal(indepLegal);
		}

		String indepLegalTel = (String)attributes.get("indepLegalTel");

		if (indepLegalTel != null) {
			setIndepLegalTel(indepLegalTel);
		}

		String indepLegalFax = (String)attributes.get("indepLegalFax");

		if (indepLegalFax != null) {
			setIndepLegalFax(indepLegalFax);
		}

		String indepLegalPhone = (String)attributes.get("indepLegalPhone");

		if (indepLegalPhone != null) {
			setIndepLegalPhone(indepLegalPhone);
		}

		String projLegal = (String)attributes.get("projLegal");

		if (projLegal != null) {
			setProjLegal(projLegal);
		}

		String projLegalTel = (String)attributes.get("projLegalTel");

		if (projLegalTel != null) {
			setProjLegalTel(projLegalTel);
		}

		String projLegalFax = (String)attributes.get("projLegalFax");

		if (projLegalFax != null) {
			setProjLegalFax(projLegalFax);
		}

		String projLegalPhone = (String)attributes.get("projLegalPhone");

		if (projLegalPhone != null) {
			setProjLegalPhone(projLegalPhone);
		}

		String linkman = (String)attributes.get("linkman");

		if (linkman != null) {
			setLinkman(linkman);
		}

		String linkmanTel = (String)attributes.get("linkmanTel");

		if (linkmanTel != null) {
			setLinkmanTel(linkmanTel);
		}

		String linkmanFax = (String)attributes.get("linkmanFax");

		if (linkmanFax != null) {
			setLinkmanFax(linkmanFax);
		}

		String linkmanPhone = (String)attributes.get("linkmanPhone");

		if (linkmanPhone != null) {
			setLinkmanPhone(linkmanPhone);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long biddingId = (Long)attributes.get("biddingId");

		if (biddingId != null) {
			setBiddingId(biddingId);
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_companyRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_companyRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnitName() {
		return _unitName;
	}

	@Override
	public void setUnitName(String unitName) {
		_unitName = unitName;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitName", String.class);

				method.invoke(_companyRemoteModel, unitName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndepLegal() {
		return _indepLegal;
	}

	@Override
	public void setIndepLegal(String indepLegal) {
		_indepLegal = indepLegal;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setIndepLegal", String.class);

				method.invoke(_companyRemoteModel, indepLegal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndepLegalTel() {
		return _indepLegalTel;
	}

	@Override
	public void setIndepLegalTel(String indepLegalTel) {
		_indepLegalTel = indepLegalTel;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setIndepLegalTel", String.class);

				method.invoke(_companyRemoteModel, indepLegalTel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndepLegalFax() {
		return _indepLegalFax;
	}

	@Override
	public void setIndepLegalFax(String indepLegalFax) {
		_indepLegalFax = indepLegalFax;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setIndepLegalFax", String.class);

				method.invoke(_companyRemoteModel, indepLegalFax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndepLegalPhone() {
		return _indepLegalPhone;
	}

	@Override
	public void setIndepLegalPhone(String indepLegalPhone) {
		_indepLegalPhone = indepLegalPhone;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setIndepLegalPhone",
						String.class);

				method.invoke(_companyRemoteModel, indepLegalPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjLegal() {
		return _projLegal;
	}

	@Override
	public void setProjLegal(String projLegal) {
		_projLegal = projLegal;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setProjLegal", String.class);

				method.invoke(_companyRemoteModel, projLegal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjLegalTel() {
		return _projLegalTel;
	}

	@Override
	public void setProjLegalTel(String projLegalTel) {
		_projLegalTel = projLegalTel;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setProjLegalTel", String.class);

				method.invoke(_companyRemoteModel, projLegalTel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjLegalFax() {
		return _projLegalFax;
	}

	@Override
	public void setProjLegalFax(String projLegalFax) {
		_projLegalFax = projLegalFax;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setProjLegalFax", String.class);

				method.invoke(_companyRemoteModel, projLegalFax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjLegalPhone() {
		return _projLegalPhone;
	}

	@Override
	public void setProjLegalPhone(String projLegalPhone) {
		_projLegalPhone = projLegalPhone;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setProjLegalPhone",
						String.class);

				method.invoke(_companyRemoteModel, projLegalPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkman() {
		return _linkman;
	}

	@Override
	public void setLinkman(String linkman) {
		_linkman = linkman;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkman", String.class);

				method.invoke(_companyRemoteModel, linkman);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkmanTel() {
		return _linkmanTel;
	}

	@Override
	public void setLinkmanTel(String linkmanTel) {
		_linkmanTel = linkmanTel;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkmanTel", String.class);

				method.invoke(_companyRemoteModel, linkmanTel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkmanFax() {
		return _linkmanFax;
	}

	@Override
	public void setLinkmanFax(String linkmanFax) {
		_linkmanFax = linkmanFax;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkmanFax", String.class);

				method.invoke(_companyRemoteModel, linkmanFax);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkmanPhone() {
		return _linkmanPhone;
	}

	@Override
	public void setLinkmanPhone(String linkmanPhone) {
		_linkmanPhone = linkmanPhone;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkmanPhone", String.class);

				method.invoke(_companyRemoteModel, linkmanPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", long.class);

				method.invoke(_companyRemoteModel, projectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBiddingId() {
		return _biddingId;
	}

	@Override
	public void setBiddingId(long biddingId) {
		_biddingId = biddingId;

		if (_companyRemoteModel != null) {
			try {
				Class<?> clazz = _companyRemoteModel.getClass();

				Method method = clazz.getMethod("setBiddingId", long.class);

				method.invoke(_companyRemoteModel, biddingId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCompanyRemoteModel() {
		return _companyRemoteModel;
	}

	public void setCompanyRemoteModel(BaseModel<?> companyRemoteModel) {
		_companyRemoteModel = companyRemoteModel;
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

		Class<?> remoteModelClass = _companyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_companyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompanyLocalServiceUtil.addCompany(this);
		}
		else {
			CompanyLocalServiceUtil.updateCompany(this);
		}
	}

	@Override
	public Company toEscapedModel() {
		return (Company)ProxyUtil.newProxyInstance(Company.class.getClassLoader(),
			new Class[] { Company.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CompanyClp clone = new CompanyClp();

		clone.setCompanyId(getCompanyId());
		clone.setType(getType());
		clone.setUnitName(getUnitName());
		clone.setIndepLegal(getIndepLegal());
		clone.setIndepLegalTel(getIndepLegalTel());
		clone.setIndepLegalFax(getIndepLegalFax());
		clone.setIndepLegalPhone(getIndepLegalPhone());
		clone.setProjLegal(getProjLegal());
		clone.setProjLegalTel(getProjLegalTel());
		clone.setProjLegalFax(getProjLegalFax());
		clone.setProjLegalPhone(getProjLegalPhone());
		clone.setLinkman(getLinkman());
		clone.setLinkmanTel(getLinkmanTel());
		clone.setLinkmanFax(getLinkmanFax());
		clone.setLinkmanPhone(getLinkmanPhone());
		clone.setProjectId(getProjectId());
		clone.setBiddingId(getBiddingId());

		return clone;
	}

	@Override
	public int compareTo(Company company) {
		int value = 0;

		if (getCompanyId() < company.getCompanyId()) {
			value = -1;
		}
		else if (getCompanyId() > company.getCompanyId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof CompanyClp)) {
			return false;
		}

		CompanyClp company = (CompanyClp)obj;

		long primaryKey = company.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{companyId=");
		sb.append(getCompanyId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", unitName=");
		sb.append(getUnitName());
		sb.append(", indepLegal=");
		sb.append(getIndepLegal());
		sb.append(", indepLegalTel=");
		sb.append(getIndepLegalTel());
		sb.append(", indepLegalFax=");
		sb.append(getIndepLegalFax());
		sb.append(", indepLegalPhone=");
		sb.append(getIndepLegalPhone());
		sb.append(", projLegal=");
		sb.append(getProjLegal());
		sb.append(", projLegalTel=");
		sb.append(getProjLegalTel());
		sb.append(", projLegalFax=");
		sb.append(getProjLegalFax());
		sb.append(", projLegalPhone=");
		sb.append(getProjLegalPhone());
		sb.append(", linkman=");
		sb.append(getLinkman());
		sb.append(", linkmanTel=");
		sb.append(getLinkmanTel());
		sb.append(", linkmanFax=");
		sb.append(getLinkmanFax());
		sb.append(", linkmanPhone=");
		sb.append(getLinkmanPhone());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", biddingId=");
		sb.append(getBiddingId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.proj.model.Company");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitName</column-name><column-value><![CDATA[");
		sb.append(getUnitName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indepLegal</column-name><column-value><![CDATA[");
		sb.append(getIndepLegal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indepLegalTel</column-name><column-value><![CDATA[");
		sb.append(getIndepLegalTel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indepLegalFax</column-name><column-value><![CDATA[");
		sb.append(getIndepLegalFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indepLegalPhone</column-name><column-value><![CDATA[");
		sb.append(getIndepLegalPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projLegal</column-name><column-value><![CDATA[");
		sb.append(getProjLegal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projLegalTel</column-name><column-value><![CDATA[");
		sb.append(getProjLegalTel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projLegalFax</column-name><column-value><![CDATA[");
		sb.append(getProjLegalFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projLegalPhone</column-name><column-value><![CDATA[");
		sb.append(getProjLegalPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkman</column-name><column-value><![CDATA[");
		sb.append(getLinkman());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkmanTel</column-name><column-value><![CDATA[");
		sb.append(getLinkmanTel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkmanFax</column-name><column-value><![CDATA[");
		sb.append(getLinkmanFax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkmanPhone</column-name><column-value><![CDATA[");
		sb.append(getLinkmanPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biddingId</column-name><column-value><![CDATA[");
		sb.append(getBiddingId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _companyId;
	private String _type;
	private String _unitName;
	private String _indepLegal;
	private String _indepLegalTel;
	private String _indepLegalFax;
	private String _indepLegalPhone;
	private String _projLegal;
	private String _projLegalTel;
	private String _projLegalFax;
	private String _projLegalPhone;
	private String _linkman;
	private String _linkmanTel;
	private String _linkmanFax;
	private String _linkmanPhone;
	private long _projectId;
	private long _biddingId;
	private BaseModel<?> _companyRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.proj.service.ClpSerializer.class;
}