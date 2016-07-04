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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the office supply requisition item service. This utility wraps {@link OfficeSupplyRequisitionItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionItemPersistence
 * @see OfficeSupplyRequisitionItemPersistenceImpl
 * @generated
 */
public class OfficeSupplyRequisitionItemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		getPersistence().clearCache(officeSupplyRequisitionItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OfficeSupplyRequisitionItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OfficeSupplyRequisitionItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OfficeSupplyRequisitionItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OfficeSupplyRequisitionItem update(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws SystemException {
		return getPersistence().update(officeSupplyRequisitionItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OfficeSupplyRequisitionItem update(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(officeSupplyRequisitionItem, serviceContext);
	}

	/**
	* Returns all the office supply requisition items where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @return the matching office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

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
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyRequisitionId(officeSupplyRequisitionId,
			start, end);
	}

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
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyRequisitionId(officeSupplyRequisitionId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem findByOfficeSupplyRequisitionId_First(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyRequisitionId_First(officeSupplyRequisitionId,
			orderByComparator);
	}

	/**
	* Returns the first office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition item, or <code>null</code> if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem fetchByOfficeSupplyRequisitionId_First(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOfficeSupplyRequisitionId_First(officeSupplyRequisitionId,
			orderByComparator);
	}

	/**
	* Returns the last office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem findByOfficeSupplyRequisitionId_Last(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyRequisitionId_Last(officeSupplyRequisitionId,
			orderByComparator);
	}

	/**
	* Returns the last office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition item, or <code>null</code> if a matching office supply requisition item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem fetchByOfficeSupplyRequisitionId_Last(
		long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOfficeSupplyRequisitionId_Last(officeSupplyRequisitionId,
			orderByComparator);
	}

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
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem[] findByOfficeSupplyRequisitionId_PrevAndNext(
		long officeSupplyRequisitionItemId, long officeSupplyRequisitionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyRequisitionId_PrevAndNext(officeSupplyRequisitionItemId,
			officeSupplyRequisitionId, orderByComparator);
	}

	/**
	* Removes all the office supply requisition items where officeSupplyRequisitionId = &#63; from the database.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

	/**
	* Returns the number of office supply requisition items where officeSupplyRequisitionId = &#63;.
	*
	* @param officeSupplyRequisitionId the office supply requisition ID
	* @return the number of matching office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

	/**
	* Caches the office supply requisition item in the entity cache if it is enabled.
	*
	* @param officeSupplyRequisitionItem the office supply requisition item
	*/
	public static void cacheResult(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		getPersistence().cacheResult(officeSupplyRequisitionItem);
	}

	/**
	* Caches the office supply requisition items in the entity cache if it is enabled.
	*
	* @param officeSupplyRequisitionItems the office supply requisition items
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> officeSupplyRequisitionItems) {
		getPersistence().cacheResult(officeSupplyRequisitionItems);
	}

	/**
	* Creates a new office supply requisition item with the primary key. Does not add the office supply requisition item to the database.
	*
	* @param officeSupplyRequisitionItemId the primary key for the new office supply requisition item
	* @return the new office supply requisition item
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem create(
		long officeSupplyRequisitionItemId) {
		return getPersistence().create(officeSupplyRequisitionItemId);
	}

	/**
	* Removes the office supply requisition item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item that was removed
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem remove(
		long officeSupplyRequisitionItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(officeSupplyRequisitionItemId);
	}

	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem updateImpl(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(officeSupplyRequisitionItem);
	}

	/**
	* Returns the office supply requisition item with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException} if it could not be found.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem findByPrimaryKey(
		long officeSupplyRequisitionItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(officeSupplyRequisitionItemId);
	}

	/**
	* Returns the office supply requisition item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item, or <code>null</code> if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyRequisitionItem fetchByPrimaryKey(
		long officeSupplyRequisitionItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(officeSupplyRequisitionItemId);
	}

	/**
	* Returns all the office supply requisition items.
	*
	* @return the office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the office supply requisition items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of office supply requisition items.
	*
	* @return the number of office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OfficeSupplyRequisitionItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OfficeSupplyRequisitionItemPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					OfficeSupplyRequisitionItemPersistence.class.getName());

			ReferenceRegistry.registerReference(OfficeSupplyRequisitionItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		OfficeSupplyRequisitionItemPersistence persistence) {
	}

	private static OfficeSupplyRequisitionItemPersistence _persistence;
}