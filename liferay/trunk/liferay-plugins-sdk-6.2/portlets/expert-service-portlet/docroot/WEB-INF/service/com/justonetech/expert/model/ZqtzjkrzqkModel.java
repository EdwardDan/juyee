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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Zqtzjkrzqk service. Represents a row in the &quot;expert_Zqtzjkrzqk&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.expert.model.impl.ZqtzjkrzqkImpl}.
 * </p>
 *
 * @author fanqi
 * @see Zqtzjkrzqk
 * @see com.justonetech.expert.model.impl.ZqtzjkrzqkImpl
 * @see com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl
 * @generated
 */
public interface ZqtzjkrzqkModel extends BaseModel<Zqtzjkrzqk> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a zqtzjkrzqk model instance should use the {@link Zqtzjkrzqk} interface instead.
	 */

	/**
	 * Returns the primary key of this zqtzjkrzqk.
	 *
	 * @return the primary key of this zqtzjkrzqk
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this zqtzjkrzqk.
	 *
	 * @param primaryKey the primary key of this zqtzjkrzqk
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the zqtzjkrzqk ID of this zqtzjkrzqk.
	 *
	 * @return the zqtzjkrzqk ID of this zqtzjkrzqk
	 */
	public long getZqtzjkrzqkId();

	/**
	 * Sets the zqtzjkrzqk ID of this zqtzjkrzqk.
	 *
	 * @param zqtzjkrzqkId the zqtzjkrzqk ID of this zqtzjkrzqk
	 */
	public void setZqtzjkrzqkId(long zqtzjkrzqkId);

	/**
	 * Returns the zjkxtlsdw of this zqtzjkrzqk.
	 *
	 * @return the zjkxtlsdw of this zqtzjkrzqk
	 */
	@AutoEscape
	public String getZjkxtlsdw();

	/**
	 * Sets the zjkxtlsdw of this zqtzjkrzqk.
	 *
	 * @param zjkxtlsdw the zjkxtlsdw of this zqtzjkrzqk
	 */
	public void setZjkxtlsdw(String zjkxtlsdw);

	/**
	 * Returns the sqzy of this zqtzjkrzqk.
	 *
	 * @return the sqzy of this zqtzjkrzqk
	 */
	@AutoEscape
	public String getSqzy();

	/**
	 * Sets the sqzy of this zqtzjkrzqk.
	 *
	 * @param sqzy the sqzy of this zqtzjkrzqk
	 */
	public void setSqzy(String sqzy);

	/**
	 * Returns the pzrq of this zqtzjkrzqk.
	 *
	 * @return the pzrq of this zqtzjkrzqk
	 */
	public Date getPzrq();

	/**
	 * Sets the pzrq of this zqtzjkrzqk.
	 *
	 * @param pzrq the pzrq of this zqtzjkrzqk
	 */
	public void setPzrq(Date pzrq);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.expert.model.Zqtzjkrzqk> toCacheModel();

	@Override
	public com.justonetech.expert.model.Zqtzjkrzqk toEscapedModel();

	@Override
	public com.justonetech.expert.model.Zqtzjkrzqk toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}