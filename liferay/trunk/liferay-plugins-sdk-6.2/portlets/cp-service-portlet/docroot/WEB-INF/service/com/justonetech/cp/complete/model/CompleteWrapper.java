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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Complete}.
 * </p>
 *
 * @author fanqi
 * @see Complete
 * @generated
 */
public class CompleteWrapper implements Complete, ModelWrapper<Complete> {
	public CompleteWrapper(Complete complete) {
		_complete = complete;
	}

	@Override
	public Class<?> getModelClass() {
		return Complete.class;
	}

	@Override
	public String getModelClassName() {
		return Complete.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("completeId", getCompleteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("bjbh", getBjbh());
		attributes.put("sqbz", getSqbz());
		attributes.put("status", getStatus());
		attributes.put("babh", getBabh());
		attributes.put("wssqbh", getWssqbh());
		attributes.put("sbrq", getSbrq());
		attributes.put("shyj", getShyj());
		attributes.put("shr", getShr());
		attributes.put("shrq", getShrq());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long completeId = (Long)attributes.get("completeId");

		if (completeId != null) {
			setCompleteId(completeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String zzjgdm = (String)attributes.get("zzjgdm");

		if (zzjgdm != null) {
			setZzjgdm(zzjgdm);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		Integer sqbz = (Integer)attributes.get("sqbz");

		if (sqbz != null) {
			setSqbz(sqbz);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String babh = (String)attributes.get("babh");

		if (babh != null) {
			setBabh(babh);
		}

		String wssqbh = (String)attributes.get("wssqbh");

		if (wssqbh != null) {
			setWssqbh(wssqbh);
		}

		Date sbrq = (Date)attributes.get("sbrq");

		if (sbrq != null) {
			setSbrq(sbrq);
		}

		String shyj = (String)attributes.get("shyj");

		if (shyj != null) {
			setShyj(shyj);
		}

		String shr = (String)attributes.get("shr");

		if (shr != null) {
			setShr(shr);
		}

		Date shrq = (Date)attributes.get("shrq");

		if (shrq != null) {
			setShrq(shrq);
		}
	}

	/**
	* Returns the primary key of this complete.
	*
	* @return the primary key of this complete
	*/
	@Override
	public long getPrimaryKey() {
		return _complete.getPrimaryKey();
	}

	/**
	* Sets the primary key of this complete.
	*
	* @param primaryKey the primary key of this complete
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_complete.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the complete ID of this complete.
	*
	* @return the complete ID of this complete
	*/
	@Override
	public long getCompleteId() {
		return _complete.getCompleteId();
	}

	/**
	* Sets the complete ID of this complete.
	*
	* @param completeId the complete ID of this complete
	*/
	@Override
	public void setCompleteId(long completeId) {
		_complete.setCompleteId(completeId);
	}

	/**
	* Returns the group ID of this complete.
	*
	* @return the group ID of this complete
	*/
	@Override
	public long getGroupId() {
		return _complete.getGroupId();
	}

	/**
	* Sets the group ID of this complete.
	*
	* @param groupId the group ID of this complete
	*/
	@Override
	public void setGroupId(long groupId) {
		_complete.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this complete.
	*
	* @return the company ID of this complete
	*/
	@Override
	public long getCompanyId() {
		return _complete.getCompanyId();
	}

	/**
	* Sets the company ID of this complete.
	*
	* @param companyId the company ID of this complete
	*/
	@Override
	public void setCompanyId(long companyId) {
		_complete.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this complete.
	*
	* @return the user ID of this complete
	*/
	@Override
	public long getUserId() {
		return _complete.getUserId();
	}

	/**
	* Sets the user ID of this complete.
	*
	* @param userId the user ID of this complete
	*/
	@Override
	public void setUserId(long userId) {
		_complete.setUserId(userId);
	}

	/**
	* Returns the user uuid of this complete.
	*
	* @return the user uuid of this complete
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _complete.getUserUuid();
	}

	/**
	* Sets the user uuid of this complete.
	*
	* @param userUuid the user uuid of this complete
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_complete.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this complete.
	*
	* @return the user name of this complete
	*/
	@Override
	public java.lang.String getUserName() {
		return _complete.getUserName();
	}

	/**
	* Sets the user name of this complete.
	*
	* @param userName the user name of this complete
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_complete.setUserName(userName);
	}

	/**
	* Returns the create date of this complete.
	*
	* @return the create date of this complete
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _complete.getCreateDate();
	}

	/**
	* Sets the create date of this complete.
	*
	* @param createDate the create date of this complete
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_complete.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this complete.
	*
	* @return the modified date of this complete
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _complete.getModifiedDate();
	}

	/**
	* Sets the modified date of this complete.
	*
	* @param modifiedDate the modified date of this complete
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_complete.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the zzjgdm of this complete.
	*
	* @return the zzjgdm of this complete
	*/
	@Override
	public java.lang.String getZzjgdm() {
		return _complete.getZzjgdm();
	}

	/**
	* Sets the zzjgdm of this complete.
	*
	* @param zzjgdm the zzjgdm of this complete
	*/
	@Override
	public void setZzjgdm(java.lang.String zzjgdm) {
		_complete.setZzjgdm(zzjgdm);
	}

	/**
	* Returns the bjbh of this complete.
	*
	* @return the bjbh of this complete
	*/
	@Override
	public java.lang.String getBjbh() {
		return _complete.getBjbh();
	}

	/**
	* Sets the bjbh of this complete.
	*
	* @param bjbh the bjbh of this complete
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_complete.setBjbh(bjbh);
	}

	/**
	* Returns the sqbz of this complete.
	*
	* @return the sqbz of this complete
	*/
	@Override
	public int getSqbz() {
		return _complete.getSqbz();
	}

	/**
	* Sets the sqbz of this complete.
	*
	* @param sqbz the sqbz of this complete
	*/
	@Override
	public void setSqbz(int sqbz) {
		_complete.setSqbz(sqbz);
	}

	/**
	* Returns the status of this complete.
	*
	* @return the status of this complete
	*/
	@Override
	public int getStatus() {
		return _complete.getStatus();
	}

	/**
	* Sets the status of this complete.
	*
	* @param status the status of this complete
	*/
	@Override
	public void setStatus(int status) {
		_complete.setStatus(status);
	}

	/**
	* Returns the babh of this complete.
	*
	* @return the babh of this complete
	*/
	@Override
	public java.lang.String getBabh() {
		return _complete.getBabh();
	}

	/**
	* Sets the babh of this complete.
	*
	* @param babh the babh of this complete
	*/
	@Override
	public void setBabh(java.lang.String babh) {
		_complete.setBabh(babh);
	}

	/**
	* Returns the wssqbh of this complete.
	*
	* @return the wssqbh of this complete
	*/
	@Override
	public java.lang.String getWssqbh() {
		return _complete.getWssqbh();
	}

	/**
	* Sets the wssqbh of this complete.
	*
	* @param wssqbh the wssqbh of this complete
	*/
	@Override
	public void setWssqbh(java.lang.String wssqbh) {
		_complete.setWssqbh(wssqbh);
	}

	/**
	* Returns the sbrq of this complete.
	*
	* @return the sbrq of this complete
	*/
	@Override
	public java.util.Date getSbrq() {
		return _complete.getSbrq();
	}

	/**
	* Sets the sbrq of this complete.
	*
	* @param sbrq the sbrq of this complete
	*/
	@Override
	public void setSbrq(java.util.Date sbrq) {
		_complete.setSbrq(sbrq);
	}

	/**
	* Returns the shyj of this complete.
	*
	* @return the shyj of this complete
	*/
	@Override
	public java.lang.String getShyj() {
		return _complete.getShyj();
	}

	/**
	* Sets the shyj of this complete.
	*
	* @param shyj the shyj of this complete
	*/
	@Override
	public void setShyj(java.lang.String shyj) {
		_complete.setShyj(shyj);
	}

	/**
	* Returns the shr of this complete.
	*
	* @return the shr of this complete
	*/
	@Override
	public java.lang.String getShr() {
		return _complete.getShr();
	}

	/**
	* Sets the shr of this complete.
	*
	* @param shr the shr of this complete
	*/
	@Override
	public void setShr(java.lang.String shr) {
		_complete.setShr(shr);
	}

	/**
	* Returns the shrq of this complete.
	*
	* @return the shrq of this complete
	*/
	@Override
	public java.util.Date getShrq() {
		return _complete.getShrq();
	}

	/**
	* Sets the shrq of this complete.
	*
	* @param shrq the shrq of this complete
	*/
	@Override
	public void setShrq(java.util.Date shrq) {
		_complete.setShrq(shrq);
	}

	@Override
	public boolean isNew() {
		return _complete.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_complete.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _complete.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_complete.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _complete.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _complete.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_complete.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _complete.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_complete.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_complete.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_complete.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CompleteWrapper((Complete)_complete.clone());
	}

	@Override
	public int compareTo(com.justonetech.cp.complete.model.Complete complete) {
		return _complete.compareTo(complete);
	}

	@Override
	public int hashCode() {
		return _complete.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.complete.model.Complete> toCacheModel() {
		return _complete.toCacheModel();
	}

	@Override
	public com.justonetech.cp.complete.model.Complete toEscapedModel() {
		return new CompleteWrapper(_complete.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.complete.model.Complete toUnescapedModel() {
		return new CompleteWrapper(_complete.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _complete.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _complete.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_complete.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompleteWrapper)) {
			return false;
		}

		CompleteWrapper completeWrapper = (CompleteWrapper)obj;

		if (Validator.equals(_complete, completeWrapper._complete)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Complete getWrappedComplete() {
		return _complete;
	}

	@Override
	public Complete getWrappedModel() {
		return _complete;
	}

	@Override
	public void resetOriginalValues() {
		_complete.resetOriginalValues();
	}

	private Complete _complete;
}