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

import com.justonetech.oa.model.OfficeSupplyRequisitionItem;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the office supply requisition item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionItemPersistenceImpl
 * @see OfficeSupplyRequisitionItemUtil
 * @generated
 */
public interface OfficeSupplyRequisitionItemPersistence extends BasePersistence<OfficeSupplyRequisitionItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfficeSupplyRequisitionItemUtil} to access the office supply requisition item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the office supply requisition items where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @return the matching office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the office supply requisition items where officeSupplyRequisitionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param start the lower bound of the range of office supply requisition items
	* @param end the upper bound of the range of office supply requisition items (not inclusive)
	* @return the range of matching office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the office supply requisition items where officeSupplyRequisitionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param start the lower bound of the range of office supply requisition items
	* @param end the upper bound of the range of office supply requisition items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem findByOfficeSupplyRequisitionId_First(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition item, or <code>null</code> if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem fetchByOfficeSupplyRequisitionId_First(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem findByOfficeSupplyRequisitionId_Last(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition item, or <code>null</code> if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem fetchByOfficeSupplyRequisitionId_Last(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply requisition items before and after the current office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionItemId the primary key of the current office supply requisition item
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next office supply requisition item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem[] findByOfficeSupplyRequisitionId_PrevAndNext(
		long officeSupplyRequisitionItemId, long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the office supply requisition items where officeSupplyRequisitionId = &#63; from the database.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of office supply requisition items where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @return the number of matching office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public int countByOfficeSupplyRequisitionId(long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the office supply requisition item in the entity cache if it is enabled.
	*
	* @param officeSupplyRequisitionItem the office supply requisition item
	*/
	public void cacheResult(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem);

	/**
	* Caches the office supply requisition items in the entity cache if it is enabled.
	*
	* @param officeSupplyRequisitionItems the office supply requisition items
	*/
	public void cacheResult(
		java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> officeSupplyRequisitionItems);

	/**
	* Creates a new office supply requisition item with the primary key. Does not add the office supply requisition item to the database.
	*
	* @param officeSupplyRequisitionItemId the primary key for the new office supply requisition item
	* @return the new office supply requisition item
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem create(
		long officeSupplyRequisitionItemId);

	/**
	* Removes the office supply requisition item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item that was removed
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem remove(
		long officeSupplyRequisitionItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.oa.model.OfficeSupplyRequisitionItem updateImpl(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply requisition item with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException} if it could not be found.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem findByPrimaryKey(
		long officeSupplyRequisitionItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply requisition item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item, or <code>null</code> if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem fetchByPrimaryKey(
		long officeSupplyRequisitionItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the office supply requisition items.
	*
	* @return the office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the office supply requisition items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply requisition items
	* @param end the upper bound of the range of office supply requisition items (not inclusive)
	* @return the range of office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the office supply requisition items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply requisition items
	* @param end the upper bound of the range of office supply requisition items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the office supply requisition items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of office supply requisition items.
	*
	* @return the number of office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}