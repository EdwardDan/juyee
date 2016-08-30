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

package com.justonetech.cp.contract.service.persistence;

import com.justonetech.cp.contract.model.Contract;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ContractPersistenceImpl
 * @see ContractUtil
 * @generated
 */
public interface ContractPersistence extends BasePersistence<Contract> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContractUtil} to access the contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contract in the entity cache if it is enabled.
	*
	* @param contract the contract
	*/
	public void cacheResult(com.justonetech.cp.contract.model.Contract contract);

	/**
	* Caches the contracts in the entity cache if it is enabled.
	*
	* @param contracts the contracts
	*/
	public void cacheResult(
		java.util.List<com.justonetech.cp.contract.model.Contract> contracts);

	/**
	* Creates a new contract with the primary key. Does not add the contract to the database.
	*
	* @param contractId the primary key for the new contract
	* @return the new contract
	*/
	public com.justonetech.cp.contract.model.Contract create(
		java.lang.String contractId);

	/**
	* Removes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contractId the primary key of the contract
	* @return the contract that was removed
	* @throws com.justonetech.cp.contract.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.contract.model.Contract remove(
		java.lang.String contractId)
		throws com.justonetech.cp.contract.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.cp.contract.model.Contract updateImpl(
		com.justonetech.cp.contract.model.Contract contract)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contract with the primary key or throws a {@link com.justonetech.cp.contract.NoSuchContractException} if it could not be found.
	*
	* @param contractId the primary key of the contract
	* @return the contract
	* @throws com.justonetech.cp.contract.NoSuchContractException if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.contract.model.Contract findByPrimaryKey(
		java.lang.String contractId)
		throws com.justonetech.cp.contract.NoSuchContractException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contract with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contractId the primary key of the contract
	* @return the contract, or <code>null</code> if a contract with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.contract.model.Contract fetchByPrimaryKey(
		java.lang.String contractId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contracts.
	*
	* @return the contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.contract.model.Contract> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cp.contract.model.Contract> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contracts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.contract.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of contracts
	* @param end the upper bound of the range of contracts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contracts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.contract.model.Contract> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contracts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contracts.
	*
	* @return the number of contracts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}