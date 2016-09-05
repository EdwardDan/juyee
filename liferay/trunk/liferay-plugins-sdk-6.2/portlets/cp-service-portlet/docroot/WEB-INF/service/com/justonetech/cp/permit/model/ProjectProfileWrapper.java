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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectProfile}.
 * </p>
 *
 * @author fanqi
 * @see ProjectProfile
 * @generated
 */
public class ProjectProfileWrapper implements ProjectProfile,
	ModelWrapper<ProjectProfile> {
	public ProjectProfileWrapper(ProjectProfile projectProfile) {
		_projectProfile = projectProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectProfile.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("permitId", getPermitId());
		attributes.put("bjbh", getBjbh());
		attributes.put("jsdwmc", getJsdwmc());
		attributes.put("jsdwxz", getJsdwxz());
		attributes.put("jsdwdz", getJsdwdz());
		attributes.put("gcmc", getGcmc());
		attributes.put("jsdd", getJsdd());
		attributes.put("jsgcgm", getJsgcgm());
		attributes.put("fwjzmj", getFwjzmj());
		attributes.put("htjg", getHtjg());
		attributes.put("htgq", getHtgq());
		attributes.put("fddbr", getFddbr());
		attributes.put("jsdwlxdh", getJsdwlxdh());
		attributes.put("jsdwlxr", getJsdwlxr());
		attributes.put("jsdwsjh", getJsdwsjh());
		attributes.put("jsydpzwjhfdccqzbh", getJsydpzwjhfdccqzbh());
		attributes.put("jsgcghxkzbh", getJsgcghxkzbh());
		attributes.put("xckgqk", getXckgqk());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String jsdwmc = (String)attributes.get("jsdwmc");

		if (jsdwmc != null) {
			setJsdwmc(jsdwmc);
		}

		String jsdwxz = (String)attributes.get("jsdwxz");

		if (jsdwxz != null) {
			setJsdwxz(jsdwxz);
		}

		String jsdwdz = (String)attributes.get("jsdwdz");

		if (jsdwdz != null) {
			setJsdwdz(jsdwdz);
		}

		String gcmc = (String)attributes.get("gcmc");

		if (gcmc != null) {
			setGcmc(gcmc);
		}

		String jsdd = (String)attributes.get("jsdd");

		if (jsdd != null) {
			setJsdd(jsdd);
		}

		String jsgcgm = (String)attributes.get("jsgcgm");

		if (jsgcgm != null) {
			setJsgcgm(jsgcgm);
		}

		String fwjzmj = (String)attributes.get("fwjzmj");

		if (fwjzmj != null) {
			setFwjzmj(fwjzmj);
		}

		String htjg = (String)attributes.get("htjg");

		if (htjg != null) {
			setHtjg(htjg);
		}

		Integer htgq = (Integer)attributes.get("htgq");

		if (htgq != null) {
			setHtgq(htgq);
		}

		String fddbr = (String)attributes.get("fddbr");

		if (fddbr != null) {
			setFddbr(fddbr);
		}

		String jsdwlxdh = (String)attributes.get("jsdwlxdh");

		if (jsdwlxdh != null) {
			setJsdwlxdh(jsdwlxdh);
		}

		String jsdwlxr = (String)attributes.get("jsdwlxr");

		if (jsdwlxr != null) {
			setJsdwlxr(jsdwlxr);
		}

		String jsdwsjh = (String)attributes.get("jsdwsjh");

		if (jsdwsjh != null) {
			setJsdwsjh(jsdwsjh);
		}

		String jsydpzwjhfdccqzbh = (String)attributes.get("jsydpzwjhfdccqzbh");

		if (jsydpzwjhfdccqzbh != null) {
			setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
		}

		String jsgcghxkzbh = (String)attributes.get("jsgcghxkzbh");

		if (jsgcghxkzbh != null) {
			setJsgcghxkzbh(jsgcghxkzbh);
		}

		String xckgqk = (String)attributes.get("xckgqk");

		if (xckgqk != null) {
			setXckgqk(xckgqk);
		}
	}

	/**
	* Returns the primary key of this project profile.
	*
	* @return the primary key of this project profile
	*/
	@Override
	public long getPrimaryKey() {
		return _projectProfile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this project profile.
	*
	* @param primaryKey the primary key of this project profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_projectProfile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the permit ID of this project profile.
	*
	* @return the permit ID of this project profile
	*/
	@Override
	public long getPermitId() {
		return _projectProfile.getPermitId();
	}

	/**
	* Sets the permit ID of this project profile.
	*
	* @param permitId the permit ID of this project profile
	*/
	@Override
	public void setPermitId(long permitId) {
		_projectProfile.setPermitId(permitId);
	}

	/**
	* Returns the bjbh of this project profile.
	*
	* @return the bjbh of this project profile
	*/
	@Override
	public java.lang.String getBjbh() {
		return _projectProfile.getBjbh();
	}

	/**
	* Sets the bjbh of this project profile.
	*
	* @param bjbh the bjbh of this project profile
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_projectProfile.setBjbh(bjbh);
	}

	/**
	* Returns the jsdwmc of this project profile.
	*
	* @return the jsdwmc of this project profile
	*/
	@Override
	public java.lang.String getJsdwmc() {
		return _projectProfile.getJsdwmc();
	}

	/**
	* Sets the jsdwmc of this project profile.
	*
	* @param jsdwmc the jsdwmc of this project profile
	*/
	@Override
	public void setJsdwmc(java.lang.String jsdwmc) {
		_projectProfile.setJsdwmc(jsdwmc);
	}

	/**
	* Returns the jsdwxz of this project profile.
	*
	* @return the jsdwxz of this project profile
	*/
	@Override
	public java.lang.String getJsdwxz() {
		return _projectProfile.getJsdwxz();
	}

	/**
	* Sets the jsdwxz of this project profile.
	*
	* @param jsdwxz the jsdwxz of this project profile
	*/
	@Override
	public void setJsdwxz(java.lang.String jsdwxz) {
		_projectProfile.setJsdwxz(jsdwxz);
	}

	/**
	* Returns the jsdwdz of this project profile.
	*
	* @return the jsdwdz of this project profile
	*/
	@Override
	public java.lang.String getJsdwdz() {
		return _projectProfile.getJsdwdz();
	}

	/**
	* Sets the jsdwdz of this project profile.
	*
	* @param jsdwdz the jsdwdz of this project profile
	*/
	@Override
	public void setJsdwdz(java.lang.String jsdwdz) {
		_projectProfile.setJsdwdz(jsdwdz);
	}

	/**
	* Returns the gcmc of this project profile.
	*
	* @return the gcmc of this project profile
	*/
	@Override
	public java.lang.String getGcmc() {
		return _projectProfile.getGcmc();
	}

	/**
	* Sets the gcmc of this project profile.
	*
	* @param gcmc the gcmc of this project profile
	*/
	@Override
	public void setGcmc(java.lang.String gcmc) {
		_projectProfile.setGcmc(gcmc);
	}

	/**
	* Returns the jsdd of this project profile.
	*
	* @return the jsdd of this project profile
	*/
	@Override
	public java.lang.String getJsdd() {
		return _projectProfile.getJsdd();
	}

	/**
	* Sets the jsdd of this project profile.
	*
	* @param jsdd the jsdd of this project profile
	*/
	@Override
	public void setJsdd(java.lang.String jsdd) {
		_projectProfile.setJsdd(jsdd);
	}

	/**
	* Returns the jsgcgm of this project profile.
	*
	* @return the jsgcgm of this project profile
	*/
	@Override
	public java.lang.String getJsgcgm() {
		return _projectProfile.getJsgcgm();
	}

	/**
	* Sets the jsgcgm of this project profile.
	*
	* @param jsgcgm the jsgcgm of this project profile
	*/
	@Override
	public void setJsgcgm(java.lang.String jsgcgm) {
		_projectProfile.setJsgcgm(jsgcgm);
	}

	/**
	* Returns the fwjzmj of this project profile.
	*
	* @return the fwjzmj of this project profile
	*/
	@Override
	public java.lang.String getFwjzmj() {
		return _projectProfile.getFwjzmj();
	}

	/**
	* Sets the fwjzmj of this project profile.
	*
	* @param fwjzmj the fwjzmj of this project profile
	*/
	@Override
	public void setFwjzmj(java.lang.String fwjzmj) {
		_projectProfile.setFwjzmj(fwjzmj);
	}

	/**
	* Returns the htjg of this project profile.
	*
	* @return the htjg of this project profile
	*/
	@Override
	public java.lang.String getHtjg() {
		return _projectProfile.getHtjg();
	}

	/**
	* Sets the htjg of this project profile.
	*
	* @param htjg the htjg of this project profile
	*/
	@Override
	public void setHtjg(java.lang.String htjg) {
		_projectProfile.setHtjg(htjg);
	}

	/**
	* Returns the htgq of this project profile.
	*
	* @return the htgq of this project profile
	*/
	@Override
	public int getHtgq() {
		return _projectProfile.getHtgq();
	}

	/**
	* Sets the htgq of this project profile.
	*
	* @param htgq the htgq of this project profile
	*/
	@Override
	public void setHtgq(int htgq) {
		_projectProfile.setHtgq(htgq);
	}

	/**
	* Returns the fddbr of this project profile.
	*
	* @return the fddbr of this project profile
	*/
	@Override
	public java.lang.String getFddbr() {
		return _projectProfile.getFddbr();
	}

	/**
	* Sets the fddbr of this project profile.
	*
	* @param fddbr the fddbr of this project profile
	*/
	@Override
	public void setFddbr(java.lang.String fddbr) {
		_projectProfile.setFddbr(fddbr);
	}

	/**
	* Returns the jsdwlxdh of this project profile.
	*
	* @return the jsdwlxdh of this project profile
	*/
	@Override
	public java.lang.String getJsdwlxdh() {
		return _projectProfile.getJsdwlxdh();
	}

	/**
	* Sets the jsdwlxdh of this project profile.
	*
	* @param jsdwlxdh the jsdwlxdh of this project profile
	*/
	@Override
	public void setJsdwlxdh(java.lang.String jsdwlxdh) {
		_projectProfile.setJsdwlxdh(jsdwlxdh);
	}

	/**
	* Returns the jsdwlxr of this project profile.
	*
	* @return the jsdwlxr of this project profile
	*/
	@Override
	public java.lang.String getJsdwlxr() {
		return _projectProfile.getJsdwlxr();
	}

	/**
	* Sets the jsdwlxr of this project profile.
	*
	* @param jsdwlxr the jsdwlxr of this project profile
	*/
	@Override
	public void setJsdwlxr(java.lang.String jsdwlxr) {
		_projectProfile.setJsdwlxr(jsdwlxr);
	}

	/**
	* Returns the jsdwsjh of this project profile.
	*
	* @return the jsdwsjh of this project profile
	*/
	@Override
	public java.lang.String getJsdwsjh() {
		return _projectProfile.getJsdwsjh();
	}

	/**
	* Sets the jsdwsjh of this project profile.
	*
	* @param jsdwsjh the jsdwsjh of this project profile
	*/
	@Override
	public void setJsdwsjh(java.lang.String jsdwsjh) {
		_projectProfile.setJsdwsjh(jsdwsjh);
	}

	/**
	* Returns the jsydpzwjhfdccqzbh of this project profile.
	*
	* @return the jsydpzwjhfdccqzbh of this project profile
	*/
	@Override
	public java.lang.String getJsydpzwjhfdccqzbh() {
		return _projectProfile.getJsydpzwjhfdccqzbh();
	}

	/**
	* Sets the jsydpzwjhfdccqzbh of this project profile.
	*
	* @param jsydpzwjhfdccqzbh the jsydpzwjhfdccqzbh of this project profile
	*/
	@Override
	public void setJsydpzwjhfdccqzbh(java.lang.String jsydpzwjhfdccqzbh) {
		_projectProfile.setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
	}

	/**
	* Returns the jsgcghxkzbh of this project profile.
	*
	* @return the jsgcghxkzbh of this project profile
	*/
	@Override
	public java.lang.String getJsgcghxkzbh() {
		return _projectProfile.getJsgcghxkzbh();
	}

	/**
	* Sets the jsgcghxkzbh of this project profile.
	*
	* @param jsgcghxkzbh the jsgcghxkzbh of this project profile
	*/
	@Override
	public void setJsgcghxkzbh(java.lang.String jsgcghxkzbh) {
		_projectProfile.setJsgcghxkzbh(jsgcghxkzbh);
	}

	/**
	* Returns the xckgqk of this project profile.
	*
	* @return the xckgqk of this project profile
	*/
	@Override
	public java.lang.String getXckgqk() {
		return _projectProfile.getXckgqk();
	}

	/**
	* Sets the xckgqk of this project profile.
	*
	* @param xckgqk the xckgqk of this project profile
	*/
	@Override
	public void setXckgqk(java.lang.String xckgqk) {
		_projectProfile.setXckgqk(xckgqk);
	}

	@Override
	public boolean isNew() {
		return _projectProfile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_projectProfile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _projectProfile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_projectProfile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _projectProfile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _projectProfile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_projectProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _projectProfile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_projectProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_projectProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_projectProfile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProjectProfileWrapper((ProjectProfile)_projectProfile.clone());
	}

	@Override
	public int compareTo(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile) {
		return _projectProfile.compareTo(projectProfile);
	}

	@Override
	public int hashCode() {
		return _projectProfile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.permit.model.ProjectProfile> toCacheModel() {
		return _projectProfile.toCacheModel();
	}

	@Override
	public com.justonetech.cp.permit.model.ProjectProfile toEscapedModel() {
		return new ProjectProfileWrapper(_projectProfile.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.permit.model.ProjectProfile toUnescapedModel() {
		return new ProjectProfileWrapper(_projectProfile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _projectProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _projectProfile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_projectProfile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProjectProfileWrapper)) {
			return false;
		}

		ProjectProfileWrapper projectProfileWrapper = (ProjectProfileWrapper)obj;

		if (Validator.equals(_projectProfile,
					projectProfileWrapper._projectProfile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProjectProfile getWrappedProjectProfile() {
		return _projectProfile;
	}

	@Override
	public ProjectProfile getWrappedModel() {
		return _projectProfile;
	}

	@Override
	public void resetOriginalValues() {
		_projectProfile.resetOriginalValues();
	}

	private ProjectProfile _projectProfile;
}