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

package com.justonetech.cp.complete.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CompleteProjectProfile service. Represents a row in the &quot;cp_CompleteProjectProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileImpl}.
 * </p>
 *
 * @author fanqi
 * @see CompleteProjectProfile
 * @see com.justonetech.cp.complete.model.impl.CompleteProjectProfileImpl
 * @see com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl
 * @generated
 */
public interface CompleteProjectProfileModel extends BaseModel<CompleteProjectProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a complete project profile model instance should use the {@link CompleteProjectProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this complete project profile.
	 *
	 * @return the primary key of this complete project profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this complete project profile.
	 *
	 * @param primaryKey the primary key of this complete project profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the complete ID of this complete project profile.
	 *
	 * @return the complete ID of this complete project profile
	 */
	public long getCompleteId();

	/**
	 * Sets the complete ID of this complete project profile.
	 *
	 * @param completeId the complete ID of this complete project profile
	 */
	public void setCompleteId(long completeId);

	/**
	 * Returns the bjbh of this complete project profile.
	 *
	 * @return the bjbh of this complete project profile
	 */
	@AutoEscape
	public String getBjbh();

	/**
	 * Sets the bjbh of this complete project profile.
	 *
	 * @param bjbh the bjbh of this complete project profile
	 */
	public void setBjbh(String bjbh);

	/**
	 * Returns the xmlx of this complete project profile.
	 *
	 * @return the xmlx of this complete project profile
	 */
	public long getXmlx();

	/**
	 * Sets the xmlx of this complete project profile.
	 *
	 * @param xmlx the xmlx of this complete project profile
	 */
	public void setXmlx(long xmlx);

	/**
	 * Returns the jsgcsx of this complete project profile.
	 *
	 * @return the jsgcsx of this complete project profile
	 */
	public long getJsgcsx();

	/**
	 * Sets the jsgcsx of this complete project profile.
	 *
	 * @param jsgcsx the jsgcsx of this complete project profile
	 */
	public void setJsgcsx(long jsgcsx);

	/**
	 * Returns the gcmc of this complete project profile.
	 *
	 * @return the gcmc of this complete project profile
	 */
	@AutoEscape
	public String getGcmc();

	/**
	 * Sets the gcmc of this complete project profile.
	 *
	 * @param gcmc the gcmc of this complete project profile
	 */
	public void setGcmc(String gcmc);

	/**
	 * Returns the lxjb of this complete project profile.
	 *
	 * @return the lxjb of this complete project profile
	 */
	@AutoEscape
	public String getLxjb();

	/**
	 * Sets the lxjb of this complete project profile.
	 *
	 * @param lxjb the lxjb of this complete project profile
	 */
	public void setLxjb(String lxjb);

	/**
	 * Returns the jsdwmc of this complete project profile.
	 *
	 * @return the jsdwmc of this complete project profile
	 */
	@AutoEscape
	public String getJsdwmc();

	/**
	 * Sets the jsdwmc of this complete project profile.
	 *
	 * @param jsdwmc the jsdwmc of this complete project profile
	 */
	public void setJsdwmc(String jsdwmc);

	/**
	 * Returns the jsdwdz of this complete project profile.
	 *
	 * @return the jsdwdz of this complete project profile
	 */
	@AutoEscape
	public String getJsdwdz();

	/**
	 * Sets the jsdwdz of this complete project profile.
	 *
	 * @param jsdwdz the jsdwdz of this complete project profile
	 */
	public void setJsdwdz(String jsdwdz);

	/**
	 * Returns the jsdd of this complete project profile.
	 *
	 * @return the jsdd of this complete project profile
	 */
	@AutoEscape
	public String getJsdd();

	/**
	 * Sets the jsdd of this complete project profile.
	 *
	 * @param jsdd the jsdd of this complete project profile
	 */
	public void setJsdd(String jsdd);

	/**
	 * Returns the szqx of this complete project profile.
	 *
	 * @return the szqx of this complete project profile
	 */
	@AutoEscape
	public String getSzqx();

	/**
	 * Sets the szqx of this complete project profile.
	 *
	 * @param szqx the szqx of this complete project profile
	 */
	public void setSzqx(String szqx);

	/**
	 * Returns the fddbr of this complete project profile.
	 *
	 * @return the fddbr of this complete project profile
	 */
	@AutoEscape
	public String getFddbr();

	/**
	 * Sets the fddbr of this complete project profile.
	 *
	 * @param fddbr the fddbr of this complete project profile
	 */
	public void setFddbr(String fddbr);

	/**
	 * Returns the lxr of this complete project profile.
	 *
	 * @return the lxr of this complete project profile
	 */
	@AutoEscape
	public String getLxr();

	/**
	 * Sets the lxr of this complete project profile.
	 *
	 * @param lxr the lxr of this complete project profile
	 */
	public void setLxr(String lxr);

	/**
	 * Returns the lxdh of this complete project profile.
	 *
	 * @return the lxdh of this complete project profile
	 */
	@AutoEscape
	public String getLxdh();

	/**
	 * Sets the lxdh of this complete project profile.
	 *
	 * @param lxdh the lxdh of this complete project profile
	 */
	public void setLxdh(String lxdh);

	/**
	 * Returns the bz of this complete project profile.
	 *
	 * @return the bz of this complete project profile
	 */
	@AutoEscape
	public String getBz();

	/**
	 * Sets the bz of this complete project profile.
	 *
	 * @param bz the bz of this complete project profile
	 */
	public void setBz(String bz);

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
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.cp.complete.model.CompleteProjectProfile> toCacheModel();

	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile toEscapedModel();

	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}