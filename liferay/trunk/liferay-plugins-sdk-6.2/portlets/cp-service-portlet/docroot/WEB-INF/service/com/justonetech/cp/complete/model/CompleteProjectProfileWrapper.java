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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CompleteProjectProfile}.
 * </p>
 *
 * @author fanqi
 * @see CompleteProjectProfile
 * @generated
 */
public class CompleteProjectProfileWrapper implements CompleteProjectProfile,
	ModelWrapper<CompleteProjectProfile> {
	public CompleteProjectProfileWrapper(
		CompleteProjectProfile completeProjectProfile) {
		_completeProjectProfile = completeProjectProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return CompleteProjectProfile.class;
	}

	@Override
	public String getModelClassName() {
		return CompleteProjectProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("completeId", getCompleteId());
		attributes.put("bjbh", getBjbh());
		attributes.put("gcmc", getGcmc());
		attributes.put("jsdwmc", getJsdwmc());
		attributes.put("jsdwdz", getJsdwdz());
		attributes.put("jsdd", getJsdd());
		attributes.put("szqx", getSzqx());
		attributes.put("fddbr", getFddbr());
		attributes.put("lxr", getLxr());
		attributes.put("lxdh", getLxdh());
		attributes.put("bz", getBz());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long completeId = (Long)attributes.get("completeId");

		if (completeId != null) {
			setCompleteId(completeId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String gcmc = (String)attributes.get("gcmc");

		if (gcmc != null) {
			setGcmc(gcmc);
		}

		String jsdwmc = (String)attributes.get("jsdwmc");

		if (jsdwmc != null) {
			setJsdwmc(jsdwmc);
		}

		String jsdwdz = (String)attributes.get("jsdwdz");

		if (jsdwdz != null) {
			setJsdwdz(jsdwdz);
		}

		String jsdd = (String)attributes.get("jsdd");

		if (jsdd != null) {
			setJsdd(jsdd);
		}

		String szqx = (String)attributes.get("szqx");

		if (szqx != null) {
			setSzqx(szqx);
		}

		String fddbr = (String)attributes.get("fddbr");

		if (fddbr != null) {
			setFddbr(fddbr);
		}

		String lxr = (String)attributes.get("lxr");

		if (lxr != null) {
			setLxr(lxr);
		}

		String lxdh = (String)attributes.get("lxdh");

		if (lxdh != null) {
			setLxdh(lxdh);
		}

		String bz = (String)attributes.get("bz");

		if (bz != null) {
			setBz(bz);
		}
	}

	/**
	* Returns the primary key of this complete project profile.
	*
	* @return the primary key of this complete project profile
	*/
	@Override
	public long getPrimaryKey() {
		return _completeProjectProfile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this complete project profile.
	*
	* @param primaryKey the primary key of this complete project profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_completeProjectProfile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the complete ID of this complete project profile.
	*
	* @return the complete ID of this complete project profile
	*/
	@Override
	public long getCompleteId() {
		return _completeProjectProfile.getCompleteId();
	}

	/**
	* Sets the complete ID of this complete project profile.
	*
	* @param completeId the complete ID of this complete project profile
	*/
	@Override
	public void setCompleteId(long completeId) {
		_completeProjectProfile.setCompleteId(completeId);
	}

	/**
	* Returns the bjbh of this complete project profile.
	*
	* @return the bjbh of this complete project profile
	*/
	@Override
	public java.lang.String getBjbh() {
		return _completeProjectProfile.getBjbh();
	}

	/**
	* Sets the bjbh of this complete project profile.
	*
	* @param bjbh the bjbh of this complete project profile
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_completeProjectProfile.setBjbh(bjbh);
	}

	/**
	* Returns the gcmc of this complete project profile.
	*
	* @return the gcmc of this complete project profile
	*/
	@Override
	public java.lang.String getGcmc() {
		return _completeProjectProfile.getGcmc();
	}

	/**
	* Sets the gcmc of this complete project profile.
	*
	* @param gcmc the gcmc of this complete project profile
	*/
	@Override
	public void setGcmc(java.lang.String gcmc) {
		_completeProjectProfile.setGcmc(gcmc);
	}

	/**
	* Returns the jsdwmc of this complete project profile.
	*
	* @return the jsdwmc of this complete project profile
	*/
	@Override
	public java.lang.String getJsdwmc() {
		return _completeProjectProfile.getJsdwmc();
	}

	/**
	* Sets the jsdwmc of this complete project profile.
	*
	* @param jsdwmc the jsdwmc of this complete project profile
	*/
	@Override
	public void setJsdwmc(java.lang.String jsdwmc) {
		_completeProjectProfile.setJsdwmc(jsdwmc);
	}

	/**
	* Returns the jsdwdz of this complete project profile.
	*
	* @return the jsdwdz of this complete project profile
	*/
	@Override
	public java.lang.String getJsdwdz() {
		return _completeProjectProfile.getJsdwdz();
	}

	/**
	* Sets the jsdwdz of this complete project profile.
	*
	* @param jsdwdz the jsdwdz of this complete project profile
	*/
	@Override
	public void setJsdwdz(java.lang.String jsdwdz) {
		_completeProjectProfile.setJsdwdz(jsdwdz);
	}

	/**
	* Returns the jsdd of this complete project profile.
	*
	* @return the jsdd of this complete project profile
	*/
	@Override
	public java.lang.String getJsdd() {
		return _completeProjectProfile.getJsdd();
	}

	/**
	* Sets the jsdd of this complete project profile.
	*
	* @param jsdd the jsdd of this complete project profile
	*/
	@Override
	public void setJsdd(java.lang.String jsdd) {
		_completeProjectProfile.setJsdd(jsdd);
	}

	/**
	* Returns the szqx of this complete project profile.
	*
	* @return the szqx of this complete project profile
	*/
	@Override
	public java.lang.String getSzqx() {
		return _completeProjectProfile.getSzqx();
	}

	/**
	* Sets the szqx of this complete project profile.
	*
	* @param szqx the szqx of this complete project profile
	*/
	@Override
	public void setSzqx(java.lang.String szqx) {
		_completeProjectProfile.setSzqx(szqx);
	}

	/**
	* Returns the fddbr of this complete project profile.
	*
	* @return the fddbr of this complete project profile
	*/
	@Override
	public java.lang.String getFddbr() {
		return _completeProjectProfile.getFddbr();
	}

	/**
	* Sets the fddbr of this complete project profile.
	*
	* @param fddbr the fddbr of this complete project profile
	*/
	@Override
	public void setFddbr(java.lang.String fddbr) {
		_completeProjectProfile.setFddbr(fddbr);
	}

	/**
	* Returns the lxr of this complete project profile.
	*
	* @return the lxr of this complete project profile
	*/
	@Override
	public java.lang.String getLxr() {
		return _completeProjectProfile.getLxr();
	}

	/**
	* Sets the lxr of this complete project profile.
	*
	* @param lxr the lxr of this complete project profile
	*/
	@Override
	public void setLxr(java.lang.String lxr) {
		_completeProjectProfile.setLxr(lxr);
	}

	/**
	* Returns the lxdh of this complete project profile.
	*
	* @return the lxdh of this complete project profile
	*/
	@Override
	public java.lang.String getLxdh() {
		return _completeProjectProfile.getLxdh();
	}

	/**
	* Sets the lxdh of this complete project profile.
	*
	* @param lxdh the lxdh of this complete project profile
	*/
	@Override
	public void setLxdh(java.lang.String lxdh) {
		_completeProjectProfile.setLxdh(lxdh);
	}

	/**
	* Returns the bz of this complete project profile.
	*
	* @return the bz of this complete project profile
	*/
	@Override
	public java.lang.String getBz() {
		return _completeProjectProfile.getBz();
	}

	/**
	* Sets the bz of this complete project profile.
	*
	* @param bz the bz of this complete project profile
	*/
	@Override
	public void setBz(java.lang.String bz) {
		_completeProjectProfile.setBz(bz);
	}

	@Override
	public boolean isNew() {
		return _completeProjectProfile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_completeProjectProfile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _completeProjectProfile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_completeProjectProfile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _completeProjectProfile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _completeProjectProfile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_completeProjectProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _completeProjectProfile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_completeProjectProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_completeProjectProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_completeProjectProfile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CompleteProjectProfileWrapper((CompleteProjectProfile)_completeProjectProfile.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile) {
		return _completeProjectProfile.compareTo(completeProjectProfile);
	}

	@Override
	public int hashCode() {
		return _completeProjectProfile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.complete.model.CompleteProjectProfile> toCacheModel() {
		return _completeProjectProfile.toCacheModel();
	}

	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile toEscapedModel() {
		return new CompleteProjectProfileWrapper(_completeProjectProfile.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile toUnescapedModel() {
		return new CompleteProjectProfileWrapper(_completeProjectProfile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _completeProjectProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _completeProjectProfile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_completeProjectProfile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompleteProjectProfileWrapper)) {
			return false;
		}

		CompleteProjectProfileWrapper completeProjectProfileWrapper = (CompleteProjectProfileWrapper)obj;

		if (Validator.equals(_completeProjectProfile,
					completeProjectProfileWrapper._completeProjectProfile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CompleteProjectProfile getWrappedCompleteProjectProfile() {
		return _completeProjectProfile;
	}

	@Override
	public CompleteProjectProfile getWrappedModel() {
		return _completeProjectProfile;
	}

	@Override
	public void resetOriginalValues() {
		_completeProjectProfile.resetOriginalValues();
	}

	private CompleteProjectProfile _completeProjectProfile;
}