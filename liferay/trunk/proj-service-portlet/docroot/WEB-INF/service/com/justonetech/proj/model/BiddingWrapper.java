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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Bidding}.
 * </p>
 *
 * @author fanqi
 * @see Bidding
 * @generated
 */
public class BiddingWrapper implements Bidding, ModelWrapper<Bidding> {
	public BiddingWrapper(Bidding bidding) {
		_bidding = bidding;
	}

	@Override
	public Class<?> getModelClass() {
		return Bidding.class;
	}

	@Override
	public String getModelClassName() {
		return Bidding.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biddingId", getBiddingId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bidCode", getBidCode());
		attributes.put("sortNo", getSortNo());
		attributes.put("bidName", getBidName());
		attributes.put("bidCategoryCode", getBidCategoryCode());
		attributes.put("buildMileage", getBuildMileage());
		attributes.put("involveCounty", getInvolveCounty());
		attributes.put("projLinkman", getProjLinkman());
		attributes.put("linkTel", getLinkTel());
		attributes.put("startDate", getStartDate());
		attributes.put("projectId", getProjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biddingId = (Long)attributes.get("biddingId");

		if (biddingId != null) {
			setBiddingId(biddingId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String bidCode = (String)attributes.get("bidCode");

		if (bidCode != null) {
			setBidCode(bidCode);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String bidName = (String)attributes.get("bidName");

		if (bidName != null) {
			setBidName(bidName);
		}

		String bidCategoryCode = (String)attributes.get("bidCategoryCode");

		if (bidCategoryCode != null) {
			setBidCategoryCode(bidCategoryCode);
		}

		String buildMileage = (String)attributes.get("buildMileage");

		if (buildMileage != null) {
			setBuildMileage(buildMileage);
		}

		String involveCounty = (String)attributes.get("involveCounty");

		if (involveCounty != null) {
			setInvolveCounty(involveCounty);
		}

		String projLinkman = (String)attributes.get("projLinkman");

		if (projLinkman != null) {
			setProjLinkman(projLinkman);
		}

		String linkTel = (String)attributes.get("linkTel");

		if (linkTel != null) {
			setLinkTel(linkTel);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	/**
	* Returns the primary key of this bidding.
	*
	* @return the primary key of this bidding
	*/
	@Override
	public long getPrimaryKey() {
		return _bidding.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bidding.
	*
	* @param primaryKey the primary key of this bidding
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bidding.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bidding ID of this bidding.
	*
	* @return the bidding ID of this bidding
	*/
	@Override
	public long getBiddingId() {
		return _bidding.getBiddingId();
	}

	/**
	* Sets the bidding ID of this bidding.
	*
	* @param biddingId the bidding ID of this bidding
	*/
	@Override
	public void setBiddingId(long biddingId) {
		_bidding.setBiddingId(biddingId);
	}

	/**
	* Returns the user ID of this bidding.
	*
	* @return the user ID of this bidding
	*/
	@Override
	public long getUserId() {
		return _bidding.getUserId();
	}

	/**
	* Sets the user ID of this bidding.
	*
	* @param userId the user ID of this bidding
	*/
	@Override
	public void setUserId(long userId) {
		_bidding.setUserId(userId);
	}

	/**
	* Returns the user uuid of this bidding.
	*
	* @return the user uuid of this bidding
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bidding.getUserUuid();
	}

	/**
	* Sets the user uuid of this bidding.
	*
	* @param userUuid the user uuid of this bidding
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_bidding.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this bidding.
	*
	* @return the user name of this bidding
	*/
	@Override
	public java.lang.String getUserName() {
		return _bidding.getUserName();
	}

	/**
	* Sets the user name of this bidding.
	*
	* @param userName the user name of this bidding
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_bidding.setUserName(userName);
	}

	/**
	* Returns the create date of this bidding.
	*
	* @return the create date of this bidding
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _bidding.getCreateDate();
	}

	/**
	* Sets the create date of this bidding.
	*
	* @param createDate the create date of this bidding
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_bidding.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this bidding.
	*
	* @return the modified date of this bidding
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _bidding.getModifiedDate();
	}

	/**
	* Sets the modified date of this bidding.
	*
	* @param modifiedDate the modified date of this bidding
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_bidding.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the bid code of this bidding.
	*
	* @return the bid code of this bidding
	*/
	@Override
	public java.lang.String getBidCode() {
		return _bidding.getBidCode();
	}

	/**
	* Sets the bid code of this bidding.
	*
	* @param bidCode the bid code of this bidding
	*/
	@Override
	public void setBidCode(java.lang.String bidCode) {
		_bidding.setBidCode(bidCode);
	}

	/**
	* Returns the sort no of this bidding.
	*
	* @return the sort no of this bidding
	*/
	@Override
	public int getSortNo() {
		return _bidding.getSortNo();
	}

	/**
	* Sets the sort no of this bidding.
	*
	* @param sortNo the sort no of this bidding
	*/
	@Override
	public void setSortNo(int sortNo) {
		_bidding.setSortNo(sortNo);
	}

	/**
	* Returns the bid name of this bidding.
	*
	* @return the bid name of this bidding
	*/
	@Override
	public java.lang.String getBidName() {
		return _bidding.getBidName();
	}

	/**
	* Sets the bid name of this bidding.
	*
	* @param bidName the bid name of this bidding
	*/
	@Override
	public void setBidName(java.lang.String bidName) {
		_bidding.setBidName(bidName);
	}

	/**
	* Returns the bid category code of this bidding.
	*
	* @return the bid category code of this bidding
	*/
	@Override
	public java.lang.String getBidCategoryCode() {
		return _bidding.getBidCategoryCode();
	}

	/**
	* Sets the bid category code of this bidding.
	*
	* @param bidCategoryCode the bid category code of this bidding
	*/
	@Override
	public void setBidCategoryCode(java.lang.String bidCategoryCode) {
		_bidding.setBidCategoryCode(bidCategoryCode);
	}

	/**
	* Returns the build mileage of this bidding.
	*
	* @return the build mileage of this bidding
	*/
	@Override
	public java.lang.String getBuildMileage() {
		return _bidding.getBuildMileage();
	}

	/**
	* Sets the build mileage of this bidding.
	*
	* @param buildMileage the build mileage of this bidding
	*/
	@Override
	public void setBuildMileage(java.lang.String buildMileage) {
		_bidding.setBuildMileage(buildMileage);
	}

	/**
	* Returns the involve county of this bidding.
	*
	* @return the involve county of this bidding
	*/
	@Override
	public java.lang.String getInvolveCounty() {
		return _bidding.getInvolveCounty();
	}

	/**
	* Sets the involve county of this bidding.
	*
	* @param involveCounty the involve county of this bidding
	*/
	@Override
	public void setInvolveCounty(java.lang.String involveCounty) {
		_bidding.setInvolveCounty(involveCounty);
	}

	/**
	* Returns the proj linkman of this bidding.
	*
	* @return the proj linkman of this bidding
	*/
	@Override
	public java.lang.String getProjLinkman() {
		return _bidding.getProjLinkman();
	}

	/**
	* Sets the proj linkman of this bidding.
	*
	* @param projLinkman the proj linkman of this bidding
	*/
	@Override
	public void setProjLinkman(java.lang.String projLinkman) {
		_bidding.setProjLinkman(projLinkman);
	}

	/**
	* Returns the link tel of this bidding.
	*
	* @return the link tel of this bidding
	*/
	@Override
	public java.lang.String getLinkTel() {
		return _bidding.getLinkTel();
	}

	/**
	* Sets the link tel of this bidding.
	*
	* @param linkTel the link tel of this bidding
	*/
	@Override
	public void setLinkTel(java.lang.String linkTel) {
		_bidding.setLinkTel(linkTel);
	}

	/**
	* Returns the start date of this bidding.
	*
	* @return the start date of this bidding
	*/
	@Override
	public java.util.Date getStartDate() {
		return _bidding.getStartDate();
	}

	/**
	* Sets the start date of this bidding.
	*
	* @param startDate the start date of this bidding
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_bidding.setStartDate(startDate);
	}

	/**
	* Returns the project ID of this bidding.
	*
	* @return the project ID of this bidding
	*/
	@Override
	public long getProjectId() {
		return _bidding.getProjectId();
	}

	/**
	* Sets the project ID of this bidding.
	*
	* @param projectId the project ID of this bidding
	*/
	@Override
	public void setProjectId(long projectId) {
		_bidding.setProjectId(projectId);
	}

	@Override
	public boolean isNew() {
		return _bidding.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bidding.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bidding.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bidding.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bidding.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bidding.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bidding.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bidding.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bidding.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bidding.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bidding.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BiddingWrapper((Bidding)_bidding.clone());
	}

	@Override
	public int compareTo(com.justonetech.proj.model.Bidding bidding) {
		return _bidding.compareTo(bidding);
	}

	@Override
	public int hashCode() {
		return _bidding.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.proj.model.Bidding> toCacheModel() {
		return _bidding.toCacheModel();
	}

	@Override
	public com.justonetech.proj.model.Bidding toEscapedModel() {
		return new BiddingWrapper(_bidding.toEscapedModel());
	}

	@Override
	public com.justonetech.proj.model.Bidding toUnescapedModel() {
		return new BiddingWrapper(_bidding.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bidding.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bidding.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bidding.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BiddingWrapper)) {
			return false;
		}

		BiddingWrapper biddingWrapper = (BiddingWrapper)obj;

		if (Validator.equals(_bidding, biddingWrapper._bidding)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Bidding getWrappedBidding() {
		return _bidding;
	}

	@Override
	public Bidding getWrappedModel() {
		return _bidding;
	}

	@Override
	public void resetOriginalValues() {
		_bidding.resetOriginalValues();
	}

	private Bidding _bidding;
}