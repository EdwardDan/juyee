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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Permit}.
 * </p>
 *
 * @author fanqi
 * @see Permit
 * @generated
 */
public class PermitWrapper implements Permit, ModelWrapper<Permit> {
	public PermitWrapper(Permit permit) {
		_permit = permit;
	}

	@Override
	public Class<?> getModelClass() {
		return Permit.class;
	}

	@Override
	public String getModelClassName() {
		return Permit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("permitId", getPermitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("bjbh", getBjbh());
		attributes.put("htxxbsbh", getHtxxbsbh());
		attributes.put("sqbz", getSqbz());
		attributes.put("sqzt", getSqzt());
		attributes.put("bdh", getBdh());
		attributes.put("ywbh", getYwbh());
		attributes.put("sgxkzbh", getSgxkzbh());
		attributes.put("slbh", getSlbh());
		attributes.put("hjgsz", getHjgsz());
		attributes.put("hjgsh", getHjgsh());
		attributes.put("sqr", getSqr());
		attributes.put("sqsx", getSqsx());
		attributes.put("sqh", getSqh());
		attributes.put("cltjr", getCltjr());
		attributes.put("cltjrlxdh", getCltjrlxdh());
		attributes.put("cltjrlxdz", getCltjrlxdz());
		attributes.put("sjr", getSjr());
		attributes.put("sjrlxdh", getSjrlxdh());
		attributes.put("slyj", getSlyj());
		attributes.put("slsj", getSlsj());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
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

		String htxxbsbh = (String)attributes.get("htxxbsbh");

		if (htxxbsbh != null) {
			setHtxxbsbh(htxxbsbh);
		}

		Integer sqbz = (Integer)attributes.get("sqbz");

		if (sqbz != null) {
			setSqbz(sqbz);
		}

		Integer sqzt = (Integer)attributes.get("sqzt");

		if (sqzt != null) {
			setSqzt(sqzt);
		}

		String bdh = (String)attributes.get("bdh");

		if (bdh != null) {
			setBdh(bdh);
		}

		String ywbh = (String)attributes.get("ywbh");

		if (ywbh != null) {
			setYwbh(ywbh);
		}

		String sgxkzbh = (String)attributes.get("sgxkzbh");

		if (sgxkzbh != null) {
			setSgxkzbh(sgxkzbh);
		}

		String slbh = (String)attributes.get("slbh");

		if (slbh != null) {
			setSlbh(slbh);
		}

		Integer hjgsz = (Integer)attributes.get("hjgsz");

		if (hjgsz != null) {
			setHjgsz(hjgsz);
		}

		Integer hjgsh = (Integer)attributes.get("hjgsh");

		if (hjgsh != null) {
			setHjgsh(hjgsh);
		}

		String sqr = (String)attributes.get("sqr");

		if (sqr != null) {
			setSqr(sqr);
		}

		String sqsx = (String)attributes.get("sqsx");

		if (sqsx != null) {
			setSqsx(sqsx);
		}

		String sqh = (String)attributes.get("sqh");

		if (sqh != null) {
			setSqh(sqh);
		}

		String cltjr = (String)attributes.get("cltjr");

		if (cltjr != null) {
			setCltjr(cltjr);
		}

		String cltjrlxdh = (String)attributes.get("cltjrlxdh");

		if (cltjrlxdh != null) {
			setCltjrlxdh(cltjrlxdh);
		}

		String cltjrlxdz = (String)attributes.get("cltjrlxdz");

		if (cltjrlxdz != null) {
			setCltjrlxdz(cltjrlxdz);
		}

		String sjr = (String)attributes.get("sjr");

		if (sjr != null) {
			setSjr(sjr);
		}

		String sjrlxdh = (String)attributes.get("sjrlxdh");

		if (sjrlxdh != null) {
			setSjrlxdh(sjrlxdh);
		}

		String slyj = (String)attributes.get("slyj");

		if (slyj != null) {
			setSlyj(slyj);
		}

		String slsj = (String)attributes.get("slsj");

		if (slsj != null) {
			setSlsj(slsj);
		}
	}

	/**
	* Returns the primary key of this permit.
	*
	* @return the primary key of this permit
	*/
	@Override
	public long getPrimaryKey() {
		return _permit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this permit.
	*
	* @param primaryKey the primary key of this permit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_permit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the permit ID of this permit.
	*
	* @return the permit ID of this permit
	*/
	@Override
	public long getPermitId() {
		return _permit.getPermitId();
	}

	/**
	* Sets the permit ID of this permit.
	*
	* @param permitId the permit ID of this permit
	*/
	@Override
	public void setPermitId(long permitId) {
		_permit.setPermitId(permitId);
	}

	/**
	* Returns the group ID of this permit.
	*
	* @return the group ID of this permit
	*/
	@Override
	public long getGroupId() {
		return _permit.getGroupId();
	}

	/**
	* Sets the group ID of this permit.
	*
	* @param groupId the group ID of this permit
	*/
	@Override
	public void setGroupId(long groupId) {
		_permit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this permit.
	*
	* @return the company ID of this permit
	*/
	@Override
	public long getCompanyId() {
		return _permit.getCompanyId();
	}

	/**
	* Sets the company ID of this permit.
	*
	* @param companyId the company ID of this permit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_permit.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this permit.
	*
	* @return the user ID of this permit
	*/
	@Override
	public long getUserId() {
		return _permit.getUserId();
	}

	/**
	* Sets the user ID of this permit.
	*
	* @param userId the user ID of this permit
	*/
	@Override
	public void setUserId(long userId) {
		_permit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this permit.
	*
	* @return the user uuid of this permit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permit.getUserUuid();
	}

	/**
	* Sets the user uuid of this permit.
	*
	* @param userUuid the user uuid of this permit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_permit.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this permit.
	*
	* @return the user name of this permit
	*/
	@Override
	public java.lang.String getUserName() {
		return _permit.getUserName();
	}

	/**
	* Sets the user name of this permit.
	*
	* @param userName the user name of this permit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_permit.setUserName(userName);
	}

	/**
	* Returns the create date of this permit.
	*
	* @return the create date of this permit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _permit.getCreateDate();
	}

	/**
	* Sets the create date of this permit.
	*
	* @param createDate the create date of this permit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_permit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this permit.
	*
	* @return the modified date of this permit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _permit.getModifiedDate();
	}

	/**
	* Sets the modified date of this permit.
	*
	* @param modifiedDate the modified date of this permit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_permit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the zzjgdm of this permit.
	*
	* @return the zzjgdm of this permit
	*/
	@Override
	public java.lang.String getZzjgdm() {
		return _permit.getZzjgdm();
	}

	/**
	* Sets the zzjgdm of this permit.
	*
	* @param zzjgdm the zzjgdm of this permit
	*/
	@Override
	public void setZzjgdm(java.lang.String zzjgdm) {
		_permit.setZzjgdm(zzjgdm);
	}

	/**
	* Returns the bjbh of this permit.
	*
	* @return the bjbh of this permit
	*/
	@Override
	public java.lang.String getBjbh() {
		return _permit.getBjbh();
	}

	/**
	* Sets the bjbh of this permit.
	*
	* @param bjbh the bjbh of this permit
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_permit.setBjbh(bjbh);
	}

	/**
	* Returns the htxxbsbh of this permit.
	*
	* @return the htxxbsbh of this permit
	*/
	@Override
	public java.lang.String getHtxxbsbh() {
		return _permit.getHtxxbsbh();
	}

	/**
	* Sets the htxxbsbh of this permit.
	*
	* @param htxxbsbh the htxxbsbh of this permit
	*/
	@Override
	public void setHtxxbsbh(java.lang.String htxxbsbh) {
		_permit.setHtxxbsbh(htxxbsbh);
	}

	/**
	* Returns the sqbz of this permit.
	*
	* @return the sqbz of this permit
	*/
	@Override
	public int getSqbz() {
		return _permit.getSqbz();
	}

	/**
	* Sets the sqbz of this permit.
	*
	* @param sqbz the sqbz of this permit
	*/
	@Override
	public void setSqbz(int sqbz) {
		_permit.setSqbz(sqbz);
	}

	/**
	* Returns the sqzt of this permit.
	*
	* @return the sqzt of this permit
	*/
	@Override
	public int getSqzt() {
		return _permit.getSqzt();
	}

	/**
	* Sets the sqzt of this permit.
	*
	* @param sqzt the sqzt of this permit
	*/
	@Override
	public void setSqzt(int sqzt) {
		_permit.setSqzt(sqzt);
	}

	/**
	* Returns the bdh of this permit.
	*
	* @return the bdh of this permit
	*/
	@Override
	public java.lang.String getBdh() {
		return _permit.getBdh();
	}

	/**
	* Sets the bdh of this permit.
	*
	* @param bdh the bdh of this permit
	*/
	@Override
	public void setBdh(java.lang.String bdh) {
		_permit.setBdh(bdh);
	}

	/**
	* Returns the ywbh of this permit.
	*
	* @return the ywbh of this permit
	*/
	@Override
	public java.lang.String getYwbh() {
		return _permit.getYwbh();
	}

	/**
	* Sets the ywbh of this permit.
	*
	* @param ywbh the ywbh of this permit
	*/
	@Override
	public void setYwbh(java.lang.String ywbh) {
		_permit.setYwbh(ywbh);
	}

	/**
	* Returns the sgxkzbh of this permit.
	*
	* @return the sgxkzbh of this permit
	*/
	@Override
	public java.lang.String getSgxkzbh() {
		return _permit.getSgxkzbh();
	}

	/**
	* Sets the sgxkzbh of this permit.
	*
	* @param sgxkzbh the sgxkzbh of this permit
	*/
	@Override
	public void setSgxkzbh(java.lang.String sgxkzbh) {
		_permit.setSgxkzbh(sgxkzbh);
	}

	/**
	* Returns the slbh of this permit.
	*
	* @return the slbh of this permit
	*/
	@Override
	public java.lang.String getSlbh() {
		return _permit.getSlbh();
	}

	/**
	* Sets the slbh of this permit.
	*
	* @param slbh the slbh of this permit
	*/
	@Override
	public void setSlbh(java.lang.String slbh) {
		_permit.setSlbh(slbh);
	}

	/**
	* Returns the hjgsz of this permit.
	*
	* @return the hjgsz of this permit
	*/
	@Override
	public int getHjgsz() {
		return _permit.getHjgsz();
	}

	/**
	* Sets the hjgsz of this permit.
	*
	* @param hjgsz the hjgsz of this permit
	*/
	@Override
	public void setHjgsz(int hjgsz) {
		_permit.setHjgsz(hjgsz);
	}

	/**
	* Returns the hjgsh of this permit.
	*
	* @return the hjgsh of this permit
	*/
	@Override
	public int getHjgsh() {
		return _permit.getHjgsh();
	}

	/**
	* Sets the hjgsh of this permit.
	*
	* @param hjgsh the hjgsh of this permit
	*/
	@Override
	public void setHjgsh(int hjgsh) {
		_permit.setHjgsh(hjgsh);
	}

	/**
	* Returns the sqr of this permit.
	*
	* @return the sqr of this permit
	*/
	@Override
	public java.lang.String getSqr() {
		return _permit.getSqr();
	}

	/**
	* Sets the sqr of this permit.
	*
	* @param sqr the sqr of this permit
	*/
	@Override
	public void setSqr(java.lang.String sqr) {
		_permit.setSqr(sqr);
	}

	/**
	* Returns the sqsx of this permit.
	*
	* @return the sqsx of this permit
	*/
	@Override
	public java.lang.String getSqsx() {
		return _permit.getSqsx();
	}

	/**
	* Sets the sqsx of this permit.
	*
	* @param sqsx the sqsx of this permit
	*/
	@Override
	public void setSqsx(java.lang.String sqsx) {
		_permit.setSqsx(sqsx);
	}

	/**
	* Returns the sqh of this permit.
	*
	* @return the sqh of this permit
	*/
	@Override
	public java.lang.String getSqh() {
		return _permit.getSqh();
	}

	/**
	* Sets the sqh of this permit.
	*
	* @param sqh the sqh of this permit
	*/
	@Override
	public void setSqh(java.lang.String sqh) {
		_permit.setSqh(sqh);
	}

	/**
	* Returns the cltjr of this permit.
	*
	* @return the cltjr of this permit
	*/
	@Override
	public java.lang.String getCltjr() {
		return _permit.getCltjr();
	}

	/**
	* Sets the cltjr of this permit.
	*
	* @param cltjr the cltjr of this permit
	*/
	@Override
	public void setCltjr(java.lang.String cltjr) {
		_permit.setCltjr(cltjr);
	}

	/**
	* Returns the cltjrlxdh of this permit.
	*
	* @return the cltjrlxdh of this permit
	*/
	@Override
	public java.lang.String getCltjrlxdh() {
		return _permit.getCltjrlxdh();
	}

	/**
	* Sets the cltjrlxdh of this permit.
	*
	* @param cltjrlxdh the cltjrlxdh of this permit
	*/
	@Override
	public void setCltjrlxdh(java.lang.String cltjrlxdh) {
		_permit.setCltjrlxdh(cltjrlxdh);
	}

	/**
	* Returns the cltjrlxdz of this permit.
	*
	* @return the cltjrlxdz of this permit
	*/
	@Override
	public java.lang.String getCltjrlxdz() {
		return _permit.getCltjrlxdz();
	}

	/**
	* Sets the cltjrlxdz of this permit.
	*
	* @param cltjrlxdz the cltjrlxdz of this permit
	*/
	@Override
	public void setCltjrlxdz(java.lang.String cltjrlxdz) {
		_permit.setCltjrlxdz(cltjrlxdz);
	}

	/**
	* Returns the sjr of this permit.
	*
	* @return the sjr of this permit
	*/
	@Override
	public java.lang.String getSjr() {
		return _permit.getSjr();
	}

	/**
	* Sets the sjr of this permit.
	*
	* @param sjr the sjr of this permit
	*/
	@Override
	public void setSjr(java.lang.String sjr) {
		_permit.setSjr(sjr);
	}

	/**
	* Returns the sjrlxdh of this permit.
	*
	* @return the sjrlxdh of this permit
	*/
	@Override
	public java.lang.String getSjrlxdh() {
		return _permit.getSjrlxdh();
	}

	/**
	* Sets the sjrlxdh of this permit.
	*
	* @param sjrlxdh the sjrlxdh of this permit
	*/
	@Override
	public void setSjrlxdh(java.lang.String sjrlxdh) {
		_permit.setSjrlxdh(sjrlxdh);
	}

	/**
	* Returns the slyj of this permit.
	*
	* @return the slyj of this permit
	*/
	@Override
	public java.lang.String getSlyj() {
		return _permit.getSlyj();
	}

	/**
	* Sets the slyj of this permit.
	*
	* @param slyj the slyj of this permit
	*/
	@Override
	public void setSlyj(java.lang.String slyj) {
		_permit.setSlyj(slyj);
	}

	/**
	* Returns the slsj of this permit.
	*
	* @return the slsj of this permit
	*/
	@Override
	public java.lang.String getSlsj() {
		return _permit.getSlsj();
	}

	/**
	* Sets the slsj of this permit.
	*
	* @param slsj the slsj of this permit
	*/
	@Override
	public void setSlsj(java.lang.String slsj) {
		_permit.setSlsj(slsj);
	}

	@Override
	public boolean isNew() {
		return _permit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_permit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _permit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_permit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _permit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _permit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_permit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _permit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_permit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_permit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_permit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PermitWrapper((Permit)_permit.clone());
	}

	@Override
	public int compareTo(com.justonetech.cp.permit.model.Permit permit) {
		return _permit.compareTo(permit);
	}

	@Override
	public int hashCode() {
		return _permit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.permit.model.Permit> toCacheModel() {
		return _permit.toCacheModel();
	}

	@Override
	public com.justonetech.cp.permit.model.Permit toEscapedModel() {
		return new PermitWrapper(_permit.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.permit.model.Permit toUnescapedModel() {
		return new PermitWrapper(_permit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _permit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _permit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_permit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PermitWrapper)) {
			return false;
		}

		PermitWrapper permitWrapper = (PermitWrapper)obj;

		if (Validator.equals(_permit, permitWrapper._permit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Permit getWrappedPermit() {
		return _permit;
	}

	@Override
	public Permit getWrappedModel() {
		return _permit;
	}

	@Override
	public void resetOriginalValues() {
		_permit.resetOriginalValues();
	}

	private Permit _permit;
}