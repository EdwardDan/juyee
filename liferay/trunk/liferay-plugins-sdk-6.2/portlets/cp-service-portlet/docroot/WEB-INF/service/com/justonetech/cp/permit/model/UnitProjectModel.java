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

package com.justonetech.cp.permit.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UnitProject service. Represents a row in the &quot;cp_UnitProject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.cp.permit.model.impl.UnitProjectImpl}.
 * </p>
 *
 * @author fanqi
 * @see UnitProject
 * @see com.justonetech.cp.permit.model.impl.UnitProjectImpl
 * @see com.justonetech.cp.permit.model.impl.UnitProjectModelImpl
 * @generated
 */
public interface UnitProjectModel extends BaseModel<UnitProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a unit project model instance should use the {@link UnitProject} interface instead.
	 */

	/**
	 * Returns the primary key of this unit project.
	 *
	 * @return the primary key of this unit project
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this unit project.
	 *
	 * @param primaryKey the primary key of this unit project
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the project ID of this unit project.
	 *
	 * @return the project ID of this unit project
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this unit project.
	 *
	 * @param projectId the project ID of this unit project
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the permit ID of this unit project.
	 *
	 * @return the permit ID of this unit project
	 */
	public long getPermitId();

	/**
	 * Sets the permit ID of this unit project.
	 *
	 * @param permitId the permit ID of this unit project
	 */
	public void setPermitId(long permitId);

	/**
	 * Returns the bjbh of this unit project.
	 *
	 * @return the bjbh of this unit project
	 */
	@AutoEscape
	public String getBjbh();

	/**
	 * Sets the bjbh of this unit project.
	 *
	 * @param bjbh the bjbh of this unit project
	 */
	public void setBjbh(String bjbh);

	/**
	 * Returns the gcbh of this unit project.
	 *
	 * @return the gcbh of this unit project
	 */
	@AutoEscape
	public String getGcbh();

	/**
	 * Sets the gcbh of this unit project.
	 *
	 * @param gcbh the gcbh of this unit project
	 */
	public void setGcbh(String gcbh);

	/**
	 * Returns the gcmc of this unit project.
	 *
	 * @return the gcmc of this unit project
	 */
	@AutoEscape
	public String getGcmc();

	/**
	 * Sets the gcmc of this unit project.
	 *
	 * @param gcmc the gcmc of this unit project
	 */
	public void setGcmc(String gcmc);

	/**
	 * Returns the jsnr of this unit project.
	 *
	 * @return the jsnr of this unit project
	 */
	@AutoEscape
	public String getJsnr();

	/**
	 * Sets the jsnr of this unit project.
	 *
	 * @param jsnr the jsnr of this unit project
	 */
	public void setJsnr(String jsnr);

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
	public int compareTo(
		com.justonetech.cp.permit.model.UnitProject unitProject);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.cp.permit.model.UnitProject> toCacheModel();

	@Override
	public com.justonetech.cp.permit.model.UnitProject toEscapedModel();

	@Override
	public com.justonetech.cp.permit.model.UnitProject toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}