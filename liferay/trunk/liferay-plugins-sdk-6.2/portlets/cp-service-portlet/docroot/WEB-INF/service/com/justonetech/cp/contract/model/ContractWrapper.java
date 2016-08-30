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

package com.justonetech.cp.contract.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contract}.
 * </p>
 *
 * @author fanqi
 * @see Contract
 * @generated
 */
public class ContractWrapper implements Contract, ModelWrapper<Contract> {
	public ContractWrapper(Contract contract) {
		_contract = contract;
	}

	@Override
	public Class<?> getModelClass() {
		return Contract.class;
	}

	@Override
	public String getModelClassName() {
		return Contract.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contractId", getContractId());
		attributes.put("htlb", getHtlb());
		attributes.put("bjbh", getBjbh());
		attributes.put("bdh", getBdh());
		attributes.put("cbfs", getCbfs());
		attributes.put("htmc", getHtmc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String contractId = (String)attributes.get("contractId");

		if (contractId != null) {
			setContractId(contractId);
		}

		String htlb = (String)attributes.get("htlb");

		if (htlb != null) {
			setHtlb(htlb);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String bdh = (String)attributes.get("bdh");

		if (bdh != null) {
			setBdh(bdh);
		}

		String cbfs = (String)attributes.get("cbfs");

		if (cbfs != null) {
			setCbfs(cbfs);
		}

		String htmc = (String)attributes.get("htmc");

		if (htmc != null) {
			setHtmc(htmc);
		}
	}

	/**
	* Returns the primary key of this contract.
	*
	* @return the primary key of this contract
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _contract.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contract.
	*
	* @param primaryKey the primary key of this contract
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_contract.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contract ID of this contract.
	*
	* @return the contract ID of this contract
	*/
	@Override
	public java.lang.String getContractId() {
		return _contract.getContractId();
	}

	/**
	* Sets the contract ID of this contract.
	*
	* @param contractId the contract ID of this contract
	*/
	@Override
	public void setContractId(java.lang.String contractId) {
		_contract.setContractId(contractId);
	}

	/**
	* Returns the htlb of this contract.
	*
	* @return the htlb of this contract
	*/
	@Override
	public java.lang.String getHtlb() {
		return _contract.getHtlb();
	}

	/**
	* Sets the htlb of this contract.
	*
	* @param htlb the htlb of this contract
	*/
	@Override
	public void setHtlb(java.lang.String htlb) {
		_contract.setHtlb(htlb);
	}

	/**
	* Returns the bjbh of this contract.
	*
	* @return the bjbh of this contract
	*/
	@Override
	public java.lang.String getBjbh() {
		return _contract.getBjbh();
	}

	/**
	* Sets the bjbh of this contract.
	*
	* @param bjbh the bjbh of this contract
	*/
	@Override
	public void setBjbh(java.lang.String bjbh) {
		_contract.setBjbh(bjbh);
	}

	/**
	* Returns the bdh of this contract.
	*
	* @return the bdh of this contract
	*/
	@Override
	public java.lang.String getBdh() {
		return _contract.getBdh();
	}

	/**
	* Sets the bdh of this contract.
	*
	* @param bdh the bdh of this contract
	*/
	@Override
	public void setBdh(java.lang.String bdh) {
		_contract.setBdh(bdh);
	}

	/**
	* Returns the cbfs of this contract.
	*
	* @return the cbfs of this contract
	*/
	@Override
	public java.lang.String getCbfs() {
		return _contract.getCbfs();
	}

	/**
	* Sets the cbfs of this contract.
	*
	* @param cbfs the cbfs of this contract
	*/
	@Override
	public void setCbfs(java.lang.String cbfs) {
		_contract.setCbfs(cbfs);
	}

	/**
	* Returns the htmc of this contract.
	*
	* @return the htmc of this contract
	*/
	@Override
	public java.lang.String getHtmc() {
		return _contract.getHtmc();
	}

	/**
	* Sets the htmc of this contract.
	*
	* @param htmc the htmc of this contract
	*/
	@Override
	public void setHtmc(java.lang.String htmc) {
		_contract.setHtmc(htmc);
	}

	@Override
	public boolean isNew() {
		return _contract.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_contract.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _contract.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_contract.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _contract.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _contract.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contract.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contract.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_contract.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_contract.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contract.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContractWrapper((Contract)_contract.clone());
	}

	@Override
	public int compareTo(com.justonetech.cp.contract.model.Contract contract) {
		return _contract.compareTo(contract);
	}

	@Override
	public int hashCode() {
		return _contract.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.cp.contract.model.Contract> toCacheModel() {
		return _contract.toCacheModel();
	}

	@Override
	public com.justonetech.cp.contract.model.Contract toEscapedModel() {
		return new ContractWrapper(_contract.toEscapedModel());
	}

	@Override
	public com.justonetech.cp.contract.model.Contract toUnescapedModel() {
		return new ContractWrapper(_contract.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contract.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _contract.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contract.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ContractWrapper)) {
			return false;
		}

		ContractWrapper contractWrapper = (ContractWrapper)obj;

		if (Validator.equals(_contract, contractWrapper._contract)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Contract getWrappedContract() {
		return _contract;
	}

	@Override
	public Contract getWrappedModel() {
		return _contract;
	}

	@Override
	public void resetOriginalValues() {
		_contract.resetOriginalValues();
	}

	private Contract _contract;
}