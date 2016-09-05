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

package com.justonetech.cp.contract.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContractLocalService}.
 *
 * @author fanqi
 * @see ContractLocalService
 * @generated
 */
public class ContractLocalServiceWrapper implements ContractLocalService,
	ServiceWrapper<ContractLocalService> {
	public ContractLocalServiceWrapper(
		ContractLocalService contractLocalService) {
		_contractLocalService = contractLocalService;
	}

	/**
	* Adds the contract to the database. Also notifies the appropriate model listeners.
	*
	* @param contract the contract
	* @return the contract that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.contract.model.Contract addContract(
		com.justonetech.cp.contract.model.Contract contract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.addContract(contract);
	}

	/**
	* Creates a new contract with the primary key. Does not add the contract to the database.
	*
	* @param contractId the primary key for the new contract
	* @return the new contract
	*/
	@Override
	public com.justonetech.cp.contract.model.Contract createContract(
		java.lang.String contractId) {
		return _contractLocalService.createContract(contractId);
	}

	/**
	* Deletes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contractId the primary key of the contract
	* @return the contract that was removed
	* @throws PortalException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.contract.model.Contract deleteContract(
		java.lang.String contractId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.deleteContract(contractId);
	}

	/**
	* Deletes the contract from the database. Also notifies the appropriate model listeners.
	*
	* @param contract the contract
	* @return the contract that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.contract.model.Contract deleteContract(
		com.justonetech.cp.contract.model.Contract contract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.deleteContract(contract);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _contractLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.contract.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.contract.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.cp.contract.model.Contract fetchContract(
		java.lang.String contractId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.fetchContract(contractId);
	}

	/**
	* Returns the contract with the primary key.
	*
	* @param contractId the primary key of the contract
	* @return the contract
	* @throws PortalException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.contract.model.Contract getContract(
		java.lang.String contractId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.getContract(contractId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.contract.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @return the range of contracts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.contract.model.Contract> getContracts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.getContracts(start, end);
	}

	/**
	* Returns the number of contracts.
	*
	* @return the number of contracts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getContractsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.getContractsCount();
	}

	/**
	* Updates the contract in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contract the contract
	* @return the contract that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.contract.model.Contract updateContract(
		com.justonetech.cp.contract.model.Contract contract)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contractLocalService.updateContract(contract);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _contractLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contractLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _contractLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.justonetech.cp.contract.model.Contract> getContracts(
		java.lang.String zzjgdm, java.lang.String bjbh, java.lang.String bdh,
		java.lang.String xmmc, java.lang.String htlb,
		java.lang.String contractId, int start, int end) {
		return _contractLocalService.getContracts(zzjgdm, bjbh, bdh, xmmc,
			htlb, contractId, start, end);
	}

	@Override
	public int getContractsCount(java.lang.String zzjgdm,
		java.lang.String bjbh, java.lang.String bdh, java.lang.String xmmc,
		java.lang.String htlb, java.lang.String contractId) {
		return _contractLocalService.getContractsCount(zzjgdm, bjbh, bdh, xmmc,
			htlb, contractId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		java.lang.String zzjgdm, java.lang.String bjbh, java.lang.String bdh,
		java.lang.String xmmc, java.lang.String htlb,
		java.lang.String contractId) {
		return _contractLocalService.createDynamicQuery(zzjgdm, bjbh, bdh,
			xmmc, htlb, contractId);
	}

	@Override
	public java.util.List<com.justonetech.cp.contract.model.Contract> getYbssgzbContracts(
		java.lang.String zzjgdm, java.lang.String bjbh, java.lang.String bdh,
		java.lang.String htmc, int start, int end) {
		return _contractLocalService.getYbssgzbContracts(zzjgdm, bjbh, bdh,
			htmc, start, end);
	}

	@Override
	public int getYbssgzbContractsCount(java.lang.String zzjgdm,
		java.lang.String bjbh, java.lang.String bdh, java.lang.String htmc) {
		return _contractLocalService.getYbssgzbContractsCount(zzjgdm, bjbh,
			bdh, htmc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createYbssgzbDQ(
		java.lang.String zzjgdm, java.lang.String bjbh, java.lang.String bdh,
		java.lang.String htmc) {
		return _contractLocalService.createYbssgzbDQ(zzjgdm, bjbh, bdh, htmc);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ContractLocalService getWrappedContractLocalService() {
		return _contractLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedContractLocalService(
		ContractLocalService contractLocalService) {
		_contractLocalService = contractLocalService;
	}

	@Override
	public ContractLocalService getWrappedService() {
		return _contractLocalService;
	}

	@Override
	public void setWrappedService(ContractLocalService contractLocalService) {
		_contractLocalService = contractLocalService;
	}

	private ContractLocalService _contractLocalService;
}