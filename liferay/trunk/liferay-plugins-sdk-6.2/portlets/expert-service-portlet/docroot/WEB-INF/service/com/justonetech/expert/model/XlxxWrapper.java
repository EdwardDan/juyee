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

package com.justonetech.expert.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Xlxx}.
 * </p>
 *
 * @author fanqi
 * @see Xlxx
 * @generated
 */
public class XlxxWrapper implements Xlxx, ModelWrapper<Xlxx> {
	public XlxxWrapper(Xlxx xlxx) {
		_xlxx = xlxx;
	}

	@Override
	public Class<?> getModelClass() {
		return Xlxx.class;
	}

	@Override
	public String getModelClassName() {
		return Xlxx.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("xlxxId", getXlxxId());
		attributes.put("byyx", getByyx());
		attributes.put("sxzy", getSxzy());
		attributes.put("xlhxw", getXlhxw());
		attributes.put("zxsj", getZxsj());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long xlxxId = (Long)attributes.get("xlxxId");

		if (xlxxId != null) {
			setXlxxId(xlxxId);
		}

		String byyx = (String)attributes.get("byyx");

		if (byyx != null) {
			setByyx(byyx);
		}

		String sxzy = (String)attributes.get("sxzy");

		if (sxzy != null) {
			setSxzy(sxzy);
		}

		String xlhxw = (String)attributes.get("xlhxw");

		if (xlhxw != null) {
			setXlhxw(xlhxw);
		}

		String zxsj = (String)attributes.get("zxsj");

		if (zxsj != null) {
			setZxsj(zxsj);
		}
	}

	/**
	* Returns the primary key of this xlxx.
	*
	* @return the primary key of this xlxx
	*/
	@Override
	public long getPrimaryKey() {
		return _xlxx.getPrimaryKey();
	}

	/**
	* Sets the primary key of this xlxx.
	*
	* @param primaryKey the primary key of this xlxx
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_xlxx.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the xlxx ID of this xlxx.
	*
	* @return the xlxx ID of this xlxx
	*/
	@Override
	public long getXlxxId() {
		return _xlxx.getXlxxId();
	}

	/**
	* Sets the xlxx ID of this xlxx.
	*
	* @param xlxxId the xlxx ID of this xlxx
	*/
	@Override
	public void setXlxxId(long xlxxId) {
		_xlxx.setXlxxId(xlxxId);
	}

	/**
	* Returns the byyx of this xlxx.
	*
	* @return the byyx of this xlxx
	*/
	@Override
	public java.lang.String getByyx() {
		return _xlxx.getByyx();
	}

	/**
	* Sets the byyx of this xlxx.
	*
	* @param byyx the byyx of this xlxx
	*/
	@Override
	public void setByyx(java.lang.String byyx) {
		_xlxx.setByyx(byyx);
	}

	/**
	* Returns the sxzy of this xlxx.
	*
	* @return the sxzy of this xlxx
	*/
	@Override
	public java.lang.String getSxzy() {
		return _xlxx.getSxzy();
	}

	/**
	* Sets the sxzy of this xlxx.
	*
	* @param sxzy the sxzy of this xlxx
	*/
	@Override
	public void setSxzy(java.lang.String sxzy) {
		_xlxx.setSxzy(sxzy);
	}

	/**
	* Returns the xlhxw of this xlxx.
	*
	* @return the xlhxw of this xlxx
	*/
	@Override
	public java.lang.String getXlhxw() {
		return _xlxx.getXlhxw();
	}

	/**
	* Sets the xlhxw of this xlxx.
	*
	* @param xlhxw the xlhxw of this xlxx
	*/
	@Override
	public void setXlhxw(java.lang.String xlhxw) {
		_xlxx.setXlhxw(xlhxw);
	}

	/**
	* Returns the zxsj of this xlxx.
	*
	* @return the zxsj of this xlxx
	*/
	@Override
	public java.lang.String getZxsj() {
		return _xlxx.getZxsj();
	}

	/**
	* Sets the zxsj of this xlxx.
	*
	* @param zxsj the zxsj of this xlxx
	*/
	@Override
	public void setZxsj(java.lang.String zxsj) {
		_xlxx.setZxsj(zxsj);
	}

	@Override
	public boolean isNew() {
		return _xlxx.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_xlxx.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _xlxx.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_xlxx.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _xlxx.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _xlxx.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_xlxx.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _xlxx.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_xlxx.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_xlxx.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_xlxx.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new XlxxWrapper((Xlxx)_xlxx.clone());
	}

	@Override
	public int compareTo(com.justonetech.expert.model.Xlxx xlxx) {
		return _xlxx.compareTo(xlxx);
	}

	@Override
	public int hashCode() {
		return _xlxx.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.expert.model.Xlxx> toCacheModel() {
		return _xlxx.toCacheModel();
	}

	@Override
	public com.justonetech.expert.model.Xlxx toEscapedModel() {
		return new XlxxWrapper(_xlxx.toEscapedModel());
	}

	@Override
	public com.justonetech.expert.model.Xlxx toUnescapedModel() {
		return new XlxxWrapper(_xlxx.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _xlxx.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _xlxx.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_xlxx.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof XlxxWrapper)) {
			return false;
		}

		XlxxWrapper xlxxWrapper = (XlxxWrapper)obj;

		if (Validator.equals(_xlxx, xlxxWrapper._xlxx)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Xlxx getWrappedXlxx() {
		return _xlxx;
	}

	@Override
	public Xlxx getWrappedModel() {
		return _xlxx;
	}

	@Override
	public void resetOriginalValues() {
		_xlxx.resetOriginalValues();
	}

	private Xlxx _xlxx;
}