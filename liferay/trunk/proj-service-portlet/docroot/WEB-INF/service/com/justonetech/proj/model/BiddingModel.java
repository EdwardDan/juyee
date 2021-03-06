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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Bidding service. Represents a row in the &quot;proj_Bidding&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.justonetech.proj.model.impl.BiddingModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.justonetech.proj.model.impl.BiddingImpl}.
 * </p>
 *
 * @author fanqi
 * @see Bidding
 * @see com.justonetech.proj.model.impl.BiddingImpl
 * @see com.justonetech.proj.model.impl.BiddingModelImpl
 * @generated
 */
public interface BiddingModel extends BaseModel<Bidding> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bidding model instance should use the {@link Bidding} interface instead.
	 */

	/**
	 * Returns the primary key of this bidding.
	 *
	 * @return the primary key of this bidding
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bidding.
	 *
	 * @param primaryKey the primary key of this bidding
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the bidding ID of this bidding.
	 *
	 * @return the bidding ID of this bidding
	 */
	public long getBiddingId();

	/**
	 * Sets the bidding ID of this bidding.
	 *
	 * @param biddingId the bidding ID of this bidding
	 */
	public void setBiddingId(long biddingId);

	/**
	 * Returns the user ID of this bidding.
	 *
	 * @return the user ID of this bidding
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this bidding.
	 *
	 * @param userId the user ID of this bidding
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this bidding.
	 *
	 * @return the user uuid of this bidding
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this bidding.
	 *
	 * @param userUuid the user uuid of this bidding
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this bidding.
	 *
	 * @return the user name of this bidding
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this bidding.
	 *
	 * @param userName the user name of this bidding
	 */
	public void setUserName(String userName);

	/**
	 * Returns the create date of this bidding.
	 *
	 * @return the create date of this bidding
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this bidding.
	 *
	 * @param createDate the create date of this bidding
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this bidding.
	 *
	 * @return the modified date of this bidding
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this bidding.
	 *
	 * @param modifiedDate the modified date of this bidding
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sort no of this bidding.
	 *
	 * @return the sort no of this bidding
	 */
	public int getSortNo();

	/**
	 * Sets the sort no of this bidding.
	 *
	 * @param sortNo the sort no of this bidding
	 */
	public void setSortNo(int sortNo);

	/**
	 * Returns the bid name of this bidding.
	 *
	 * @return the bid name of this bidding
	 */
	@AutoEscape
	public String getBidName();

	/**
	 * Sets the bid name of this bidding.
	 *
	 * @param bidName the bid name of this bidding
	 */
	public void setBidName(String bidName);

	/**
	 * Returns the bid category code of this bidding.
	 *
	 * @return the bid category code of this bidding
	 */
	@AutoEscape
	public String getBidCategoryCode();

	/**
	 * Sets the bid category code of this bidding.
	 *
	 * @param bidCategoryCode the bid category code of this bidding
	 */
	public void setBidCategoryCode(String bidCategoryCode);

	/**
	 * Returns the build mileage of this bidding.
	 *
	 * @return the build mileage of this bidding
	 */
	@AutoEscape
	public String getBuildMileage();

	/**
	 * Sets the build mileage of this bidding.
	 *
	 * @param buildMileage the build mileage of this bidding
	 */
	public void setBuildMileage(String buildMileage);

	/**
	 * Returns the involve county of this bidding.
	 *
	 * @return the involve county of this bidding
	 */
	@AutoEscape
	public String getInvolveCounty();

	/**
	 * Sets the involve county of this bidding.
	 *
	 * @param involveCounty the involve county of this bidding
	 */
	public void setInvolveCounty(String involveCounty);

	/**
	 * Returns the proj linkman of this bidding.
	 *
	 * @return the proj linkman of this bidding
	 */
	@AutoEscape
	public String getProjLinkman();

	/**
	 * Sets the proj linkman of this bidding.
	 *
	 * @param projLinkman the proj linkman of this bidding
	 */
	public void setProjLinkman(String projLinkman);

	/**
	 * Returns the link tel of this bidding.
	 *
	 * @return the link tel of this bidding
	 */
	@AutoEscape
	public String getLinkTel();

	/**
	 * Sets the link tel of this bidding.
	 *
	 * @param linkTel the link tel of this bidding
	 */
	public void setLinkTel(String linkTel);

	/**
	 * Returns the start date of this bidding.
	 *
	 * @return the start date of this bidding
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this bidding.
	 *
	 * @param startDate the start date of this bidding
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the project ID of this bidding.
	 *
	 * @return the project ID of this bidding
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this bidding.
	 *
	 * @param projectId the project ID of this bidding
	 */
	public void setProjectId(long projectId);

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
	public int compareTo(com.justonetech.proj.model.Bidding bidding);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.justonetech.proj.model.Bidding> toCacheModel();

	@Override
	public com.justonetech.proj.model.Bidding toEscapedModel();

	@Override
	public com.justonetech.proj.model.Bidding toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}