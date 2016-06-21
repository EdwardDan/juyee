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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Company}.
 * </p>
 *
 * @author fanqi
 * @see Company
 * @generated
 */
public class CompanyWrapper implements Company, ModelWrapper<Company> {
	public CompanyWrapper(Company company) {
		_company = company;
	}

	@Override
	public Class<?> getModelClass() {
		return Company.class;
	}

	@Override
	public String getModelClassName() {
		return Company.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("type", getType());
		attributes.put("unitName", getUnitName());
		attributes.put("indepLegal", getIndepLegal());
		attributes.put("indepLegalTel", getIndepLegalTel());
		attributes.put("indepLegalFax", getIndepLegalFax());
		attributes.put("indepLegalPhone", getIndepLegalPhone());
		attributes.put("projLegal", getProjLegal());
		attributes.put("projLegalTel", getProjLegalTel());
		attributes.put("projLegalFax", getProjLegalFax());
		attributes.put("projLegalPhone", getProjLegalPhone());
		attributes.put("linkman", getLinkman());
		attributes.put("linkmanTel", getLinkmanTel());
		attributes.put("linkmanFax", getLinkmanFax());
		attributes.put("linkmanPhone", getLinkmanPhone());
		attributes.put("projectId", getProjectId());
		attributes.put("biddingId", getBiddingId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String unitName = (String)attributes.get("unitName");

		if (unitName != null) {
			setUnitName(unitName);
		}

		String indepLegal = (String)attributes.get("indepLegal");

		if (indepLegal != null) {
			setIndepLegal(indepLegal);
		}

		String indepLegalTel = (String)attributes.get("indepLegalTel");

		if (indepLegalTel != null) {
			setIndepLegalTel(indepLegalTel);
		}

		String indepLegalFax = (String)attributes.get("indepLegalFax");

		if (indepLegalFax != null) {
			setIndepLegalFax(indepLegalFax);
		}

		String indepLegalPhone = (String)attributes.get("indepLegalPhone");

		if (indepLegalPhone != null) {
			setIndepLegalPhone(indepLegalPhone);
		}

		String projLegal = (String)attributes.get("projLegal");

		if (projLegal != null) {
			setProjLegal(projLegal);
		}

		String projLegalTel = (String)attributes.get("projLegalTel");

		if (projLegalTel != null) {
			setProjLegalTel(projLegalTel);
		}

		String projLegalFax = (String)attributes.get("projLegalFax");

		if (projLegalFax != null) {
			setProjLegalFax(projLegalFax);
		}

		String projLegalPhone = (String)attributes.get("projLegalPhone");

		if (projLegalPhone != null) {
			setProjLegalPhone(projLegalPhone);
		}

		String linkman = (String)attributes.get("linkman");

		if (linkman != null) {
			setLinkman(linkman);
		}

		String linkmanTel = (String)attributes.get("linkmanTel");

		if (linkmanTel != null) {
			setLinkmanTel(linkmanTel);
		}

		String linkmanFax = (String)attributes.get("linkmanFax");

		if (linkmanFax != null) {
			setLinkmanFax(linkmanFax);
		}

		String linkmanPhone = (String)attributes.get("linkmanPhone");

		if (linkmanPhone != null) {
			setLinkmanPhone(linkmanPhone);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long biddingId = (Long)attributes.get("biddingId");

		if (biddingId != null) {
			setBiddingId(biddingId);
		}
	}

	/**
	* Returns the primary key of this company.
	*
	* @return the primary key of this company
	*/
	@Override
	public long getPrimaryKey() {
		return _company.getPrimaryKey();
	}

	/**
	* Sets the primary key of this company.
	*
	* @param primaryKey the primary key of this company
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_company.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the company ID of this company.
	*
	* @return the company ID of this company
	*/
	@Override
	public long getCompanyId() {
		return _company.getCompanyId();
	}

	/**
	* Sets the company ID of this company.
	*
	* @param companyId the company ID of this company
	*/
	@Override
	public void setCompanyId(long companyId) {
		_company.setCompanyId(companyId);
	}

	/**
	* Returns the type of this company.
	*
	* @return the type of this company
	*/
	@Override
	public java.lang.String getType() {
		return _company.getType();
	}

	/**
	* Sets the type of this company.
	*
	* @param type the type of this company
	*/
	@Override
	public void setType(java.lang.String type) {
		_company.setType(type);
	}

	/**
	* Returns the unit name of this company.
	*
	* @return the unit name of this company
	*/
	@Override
	public java.lang.String getUnitName() {
		return _company.getUnitName();
	}

	/**
	* Sets the unit name of this company.
	*
	* @param unitName the unit name of this company
	*/
	@Override
	public void setUnitName(java.lang.String unitName) {
		_company.setUnitName(unitName);
	}

	/**
	* Returns the indep legal of this company.
	*
	* @return the indep legal of this company
	*/
	@Override
	public java.lang.String getIndepLegal() {
		return _company.getIndepLegal();
	}

	/**
	* Sets the indep legal of this company.
	*
	* @param indepLegal the indep legal of this company
	*/
	@Override
	public void setIndepLegal(java.lang.String indepLegal) {
		_company.setIndepLegal(indepLegal);
	}

	/**
	* Returns the indep legal tel of this company.
	*
	* @return the indep legal tel of this company
	*/
	@Override
	public java.lang.String getIndepLegalTel() {
		return _company.getIndepLegalTel();
	}

	/**
	* Sets the indep legal tel of this company.
	*
	* @param indepLegalTel the indep legal tel of this company
	*/
	@Override
	public void setIndepLegalTel(java.lang.String indepLegalTel) {
		_company.setIndepLegalTel(indepLegalTel);
	}

	/**
	* Returns the indep legal fax of this company.
	*
	* @return the indep legal fax of this company
	*/
	@Override
	public java.lang.String getIndepLegalFax() {
		return _company.getIndepLegalFax();
	}

	/**
	* Sets the indep legal fax of this company.
	*
	* @param indepLegalFax the indep legal fax of this company
	*/
	@Override
	public void setIndepLegalFax(java.lang.String indepLegalFax) {
		_company.setIndepLegalFax(indepLegalFax);
	}

	/**
	* Returns the indep legal phone of this company.
	*
	* @return the indep legal phone of this company
	*/
	@Override
	public java.lang.String getIndepLegalPhone() {
		return _company.getIndepLegalPhone();
	}

	/**
	* Sets the indep legal phone of this company.
	*
	* @param indepLegalPhone the indep legal phone of this company
	*/
	@Override
	public void setIndepLegalPhone(java.lang.String indepLegalPhone) {
		_company.setIndepLegalPhone(indepLegalPhone);
	}

	/**
	* Returns the proj legal of this company.
	*
	* @return the proj legal of this company
	*/
	@Override
	public java.lang.String getProjLegal() {
		return _company.getProjLegal();
	}

	/**
	* Sets the proj legal of this company.
	*
	* @param projLegal the proj legal of this company
	*/
	@Override
	public void setProjLegal(java.lang.String projLegal) {
		_company.setProjLegal(projLegal);
	}

	/**
	* Returns the proj legal tel of this company.
	*
	* @return the proj legal tel of this company
	*/
	@Override
	public java.lang.String getProjLegalTel() {
		return _company.getProjLegalTel();
	}

	/**
	* Sets the proj legal tel of this company.
	*
	* @param projLegalTel the proj legal tel of this company
	*/
	@Override
	public void setProjLegalTel(java.lang.String projLegalTel) {
		_company.setProjLegalTel(projLegalTel);
	}

	/**
	* Returns the proj legal fax of this company.
	*
	* @return the proj legal fax of this company
	*/
	@Override
	public java.lang.String getProjLegalFax() {
		return _company.getProjLegalFax();
	}

	/**
	* Sets the proj legal fax of this company.
	*
	* @param projLegalFax the proj legal fax of this company
	*/
	@Override
	public void setProjLegalFax(java.lang.String projLegalFax) {
		_company.setProjLegalFax(projLegalFax);
	}

	/**
	* Returns the proj legal phone of this company.
	*
	* @return the proj legal phone of this company
	*/
	@Override
	public java.lang.String getProjLegalPhone() {
		return _company.getProjLegalPhone();
	}

	/**
	* Sets the proj legal phone of this company.
	*
	* @param projLegalPhone the proj legal phone of this company
	*/
	@Override
	public void setProjLegalPhone(java.lang.String projLegalPhone) {
		_company.setProjLegalPhone(projLegalPhone);
	}

	/**
	* Returns the linkman of this company.
	*
	* @return the linkman of this company
	*/
	@Override
	public java.lang.String getLinkman() {
		return _company.getLinkman();
	}

	/**
	* Sets the linkman of this company.
	*
	* @param linkman the linkman of this company
	*/
	@Override
	public void setLinkman(java.lang.String linkman) {
		_company.setLinkman(linkman);
	}

	/**
	* Returns the linkman tel of this company.
	*
	* @return the linkman tel of this company
	*/
	@Override
	public java.lang.String getLinkmanTel() {
		return _company.getLinkmanTel();
	}

	/**
	* Sets the linkman tel of this company.
	*
	* @param linkmanTel the linkman tel of this company
	*/
	@Override
	public void setLinkmanTel(java.lang.String linkmanTel) {
		_company.setLinkmanTel(linkmanTel);
	}

	/**
	* Returns the linkman fax of this company.
	*
	* @return the linkman fax of this company
	*/
	@Override
	public java.lang.String getLinkmanFax() {
		return _company.getLinkmanFax();
	}

	/**
	* Sets the linkman fax of this company.
	*
	* @param linkmanFax the linkman fax of this company
	*/
	@Override
	public void setLinkmanFax(java.lang.String linkmanFax) {
		_company.setLinkmanFax(linkmanFax);
	}

	/**
	* Returns the linkman phone of this company.
	*
	* @return the linkman phone of this company
	*/
	@Override
	public java.lang.String getLinkmanPhone() {
		return _company.getLinkmanPhone();
	}

	/**
	* Sets the linkman phone of this company.
	*
	* @param linkmanPhone the linkman phone of this company
	*/
	@Override
	public void setLinkmanPhone(java.lang.String linkmanPhone) {
		_company.setLinkmanPhone(linkmanPhone);
	}

	/**
	* Returns the project ID of this company.
	*
	* @return the project ID of this company
	*/
	@Override
	public long getProjectId() {
		return _company.getProjectId();
	}

	/**
	* Sets the project ID of this company.
	*
	* @param projectId the project ID of this company
	*/
	@Override
	public void setProjectId(long projectId) {
		_company.setProjectId(projectId);
	}

	/**
	* Returns the bidding ID of this company.
	*
	* @return the bidding ID of this company
	*/
	@Override
	public long getBiddingId() {
		return _company.getBiddingId();
	}

	/**
	* Sets the bidding ID of this company.
	*
	* @param biddingId the bidding ID of this company
	*/
	@Override
	public void setBiddingId(long biddingId) {
		_company.setBiddingId(biddingId);
	}

	@Override
	public boolean isNew() {
		return _company.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_company.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _company.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_company.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _company.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _company.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_company.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _company.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_company.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_company.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_company.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CompanyWrapper((Company)_company.clone());
	}

	@Override
	public int compareTo(com.justonetech.proj.model.Company company) {
		return _company.compareTo(company);
	}

	@Override
	public int hashCode() {
		return _company.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.proj.model.Company> toCacheModel() {
		return _company.toCacheModel();
	}

	@Override
	public com.justonetech.proj.model.Company toEscapedModel() {
		return new CompanyWrapper(_company.toEscapedModel());
	}

	@Override
	public com.justonetech.proj.model.Company toUnescapedModel() {
		return new CompanyWrapper(_company.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _company.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _company.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_company.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CompanyWrapper)) {
			return false;
		}

		CompanyWrapper companyWrapper = (CompanyWrapper)obj;

		if (Validator.equals(_company, companyWrapper._company)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Company getWrappedCompany() {
		return _company;
	}

	@Override
	public Company getWrappedModel() {
		return _company;
	}

	@Override
	public void resetOriginalValues() {
		_company.resetOriginalValues();
	}

	private Company _company;
}