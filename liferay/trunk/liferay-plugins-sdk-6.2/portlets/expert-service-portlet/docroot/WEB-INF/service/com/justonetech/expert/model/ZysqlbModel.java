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
 * The base model interface for the Zysqlb service. Represents a row in the &quot;expert_Zysqlb&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.expert.model.impl.ZysqlbModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.expert.model.impl.ZysqlbImpl}.
 * </p>
 *
 * @author fanqi
 * @see Zysqlb
 * @see com.justonetech.expert.model.impl.ZysqlbImpl
 * @see com.justonetech.expert.model.impl.ZysqlbModelImpl
 * @generated
 */
public interface ZysqlbModel extends BaseModel<Zysqlb> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a zysqlb model instance should use the {@link Zysqlb} interface instead.
	 */

	/**
	 * Returns the primary key of this zysqlb.
	 *
	 * @return the primary key of this zysqlb
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this zysqlb.
	 *
	 * @param primaryKey the primary key of this zysqlb
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the zysqlb ID of this zysqlb.
	 *
	 * @return the zysqlb ID of this zysqlb
	 */
	public long getZysqlbId();

	/**
	 * Sets the zysqlb ID of this zysqlb.
	 *
	 * @param zysqlbId the zysqlb ID of this zysqlb
	 */
	public void setZysqlbId(long zysqlbId);

	/**
	 * Returns the sx of this zysqlb.
	 *
	 * @return the sx of this zysqlb
	 */
	@AutoEscape
	public String getSx();

	/**
	 * Sets the sx of this zysqlb.
	 *
	 * @param sx the sx of this zysqlb
	 */
	public void setSx(String sx);

	/**
	 * Returns the zy of this zysqlb.
	 *
	 * @return the zy of this zysqlb
	 */
	@AutoEscape
	public String getZy();

	/**
	 * Sets the zy of this zysqlb.
	 *
	 * @param zy the zy of this zysqlb
	 */
	public void setZy(String zy);

	/**
	 * Returns the zt of this zysqlb.
	 *
	 * @return the zt of this zysqlb
	 */
	@AutoEscape
	public String getZt();

	/**
	 * Sets the zt of this zysqlb.
	 *
	 * @param zt the zt of this zysqlb
	 */
	public void setZt(String zt);

	/**
	 * Returns the shyj of this zysqlb.
	 *
	 * @return the shyj of this zysqlb
	 */
	@AutoEscape
	public String getShyj();

	/**
	 * Sets the shyj of this zysqlb.
	 *
	 * @param shyj the shyj of this zysqlb
	 */
	public void setShyj(String shyj);

	/**
	 * Returns the shr of this zysqlb.
	 *
	 * @return the shr of this zysqlb
	 */
	@AutoEscape
	public String getShr();

	/**
	 * Sets the shr of this zysqlb.
	 *
	 * @param shr the shr of this zysqlb
	 */
	public void setShr(String shr);

	/**
	 * Returns the shrq of this zysqlb.
	 *
	 * @return the shrq of this zysqlb
	 */
	public Date getShrq();

	/**
	 * Sets the shrq of this zysqlb.
	 *
	 * @param shrq the shrq of this zysqlb
	 */
	public void setShrq(Date shrq);

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
	public int compareTo(com.justonetech.expert.model.Zysqlb zysqlb);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.expert.model.Zysqlb> toCacheModel();

	@Override
	public com.justonetech.expert.model.Zysqlb toEscapedModel();

	@Override
	public com.justonetech.expert.model.Zysqlb toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}