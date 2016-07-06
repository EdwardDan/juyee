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

package com.justonetech.oa.service.persistence;

import com.justonetech.oa.model.OfficeSupply;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the office supply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyPersistenceImpl
 * @see OfficeSupplyUtil
 * @generated
 */
public interface OfficeSupplyPersistence extends BasePersistence<OfficeSupply> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfficeSupplyUtil} to access the office supply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the office supplies where name LIKE &#63;.
	*
	* @param name the name
	* @return the matching office supplies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupply> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the office supplies where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of office supplies
	* @param end the upper bound of the range of office supplies (not inclusive)
	* @return the range of matching office supplies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupply> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the office supplies where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of office supplies
	* @param end the upper bound of the range of office supplies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching office supplies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupply> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyException if a matching office supply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply, or <code>null</code> if a matching office supply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyException if a matching office supply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply, or <code>null</code> if a matching office supply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supplies before and after the current office supply in the ordered set where name LIKE &#63;.
	*
	* @param officeSupplyId the primary key of the current office supply
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next office supply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply[] findByName_PrevAndNext(
		long officeSupplyId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the office supplies where name LIKE &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of office supplies where name LIKE &#63;.
	*
	* @param name the name
	* @return the number of matching office supplies
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the office supply in the entity cache if it is enabled.
	*
	* @param officeSupply the office supply
	*/
	public void cacheResult(com.justonetech.oa.model.OfficeSupply officeSupply);

	/**
	* Caches the office supplies in the entity cache if it is enabled.
	*
	* @param officeSupplies the office supplies
	*/
	public void cacheResult(
		java.util.List<com.justonetech.oa.model.OfficeSupply> officeSupplies);

	/**
	* Creates a new office supply with the primary key. Does not add the office supply to the database.
	*
	* @param officeSupplyId the primary key for the new office supply
	* @return the new office supply
	*/
	public com.justonetech.oa.model.OfficeSupply create(long officeSupplyId);

	/**
	* Removes the office supply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyId the primary key of the office supply
	* @return the office supply that was removed
	* @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply remove(long officeSupplyId)
		throws com.justonetech.oa.NoSuchOfficeSupplyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.oa.model.OfficeSupply updateImpl(
		com.justonetech.oa.model.OfficeSupply officeSupply)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyException} if it could not be found.
	*
	* @param officeSupplyId the primary key of the office supply
	* @return the office supply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply findByPrimaryKey(
		long officeSupplyId)
		throws com.justonetech.oa.NoSuchOfficeSupplyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeSupplyId the primary key of the office supply
	* @return the office supply, or <code>null</code> if a office supply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupply fetchByPrimaryKey(
		long officeSupplyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the office supplies.
	*
	* @return the office supplies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupply> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the office supplies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supplies
	* @param end the upper bound of the range of office supplies (not inclusive)
	* @return the range of office supplies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupply> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the office supplies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supplies
	* @param end the upper bound of the range of office supplies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of office supplies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupply> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the office supplies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of office supplies.
	*
	* @return the number of office supplies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}