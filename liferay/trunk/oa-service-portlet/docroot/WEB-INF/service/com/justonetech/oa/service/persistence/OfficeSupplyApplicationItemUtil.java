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

import com.justonetech.oa.model.OfficeSupplyApplicationItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the office supply application item service. This utility wraps {@link OfficeSupplyApplicationItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplicationItemPersistence
 * @see OfficeSupplyApplicationItemPersistenceImpl
 * @generated
 */
public class OfficeSupplyApplicationItemUtil {
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
		OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		getPersistence().clearCache(officeSupplyApplicationItem);
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
	public static List<OfficeSupplyApplicationItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OfficeSupplyApplicationItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OfficeSupplyApplicationItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OfficeSupplyApplicationItem update(
		OfficeSupplyApplicationItem officeSupplyApplicationItem)
		throws SystemException {
		return getPersistence().update(officeSupplyApplicationItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OfficeSupplyApplicationItem update(
		OfficeSupplyApplicationItem officeSupplyApplicationItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(officeSupplyApplicationItem, serviceContext);
	}

	/**
	* Returns all the office supply application items where officeSupplyApplicationId = &#63;.
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @return the matching office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplicationItem> findByOfficeSupplyApplicationId(
		long officeSupplyApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyApplicationId(officeSupplyApplicationId);
	}

	/**
	* Returns a range of all the office supply application items where officeSupplyApplicationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @param start the lower bound of the range of office supply application items
	* @param end the upper bound of the range of office supply application items (not inclusive)
	* @return the range of matching office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplicationItem> findByOfficeSupplyApplicationId(
		long officeSupplyApplicationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyApplicationId(officeSupplyApplicationId,
			start, end);
	}

	/**
	* Returns an ordered range of all the office supply application items where officeSupplyApplicationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @param start the lower bound of the range of office supply application items
	* @param end the upper bound of the range of office supply application items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplicationItem> findByOfficeSupplyApplicationId(
		long officeSupplyApplicationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyApplicationId(officeSupplyApplicationId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply application item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a matching office supply application item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem findByOfficeSupplyApplicationId_First(
		long officeSupplyApplicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyApplicationId_First(officeSupplyApplicationId,
			orderByComparator);
	}

	/**
	* Returns the first office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply application item, or <code>null</code> if a matching office supply application item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem fetchByOfficeSupplyApplicationId_First(
		long officeSupplyApplicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOfficeSupplyApplicationId_First(officeSupplyApplicationId,
			orderByComparator);
	}

	/**
	* Returns the last office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply application item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a matching office supply application item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem findByOfficeSupplyApplicationId_Last(
		long officeSupplyApplicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyApplicationId_Last(officeSupplyApplicationId,
			orderByComparator);
	}

	/**
	* Returns the last office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply application item, or <code>null</code> if a matching office supply application item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem fetchByOfficeSupplyApplicationId_Last(
		long officeSupplyApplicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOfficeSupplyApplicationId_Last(officeSupplyApplicationId,
			orderByComparator);
	}

	/**
	* Returns the office supply application items before and after the current office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	*
	* @param officeSupplyApplicationItemId the primary key of the current office supply application item
	* @param officeSupplyApplicationId the office supply application ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next office supply application item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem[] findByOfficeSupplyApplicationId_PrevAndNext(
		long officeSupplyApplicationItemId, long officeSupplyApplicationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOfficeSupplyApplicationId_PrevAndNext(officeSupplyApplicationItemId,
			officeSupplyApplicationId, orderByComparator);
	}

	/**
	* Removes all the office supply application items where officeSupplyApplicationId = &#63; from the database.
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOfficeSupplyApplicationId(
		long officeSupplyApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByOfficeSupplyApplicationId(officeSupplyApplicationId);
	}

	/**
	* Returns the number of office supply application items where officeSupplyApplicationId = &#63;.
	*
	* @param officeSupplyApplicationId the office supply application ID
	* @return the number of matching office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOfficeSupplyApplicationId(
		long officeSupplyApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOfficeSupplyApplicationId(officeSupplyApplicationId);
	}

	/**
	* Caches the office supply application item in the entity cache if it is enabled.
	*
	* @param officeSupplyApplicationItem the office supply application item
	*/
	public static void cacheResult(
		com.justonetech.oa.model.OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		getPersistence().cacheResult(officeSupplyApplicationItem);
	}

	/**
	* Caches the office supply application items in the entity cache if it is enabled.
	*
	* @param officeSupplyApplicationItems the office supply application items
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.OfficeSupplyApplicationItem> officeSupplyApplicationItems) {
		getPersistence().cacheResult(officeSupplyApplicationItems);
	}

	/**
	* Creates a new office supply application item with the primary key. Does not add the office supply application item to the database.
	*
	* @param officeSupplyApplicationItemId the primary key for the new office supply application item
	* @return the new office supply application item
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem create(
		long officeSupplyApplicationItemId) {
		return getPersistence().create(officeSupplyApplicationItemId);
	}

	/**
	* Removes the office supply application item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplicationItemId the primary key of the office supply application item
	* @return the office supply application item that was removed
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem remove(
		long officeSupplyApplicationItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(officeSupplyApplicationItemId);
	}

	public static com.justonetech.oa.model.OfficeSupplyApplicationItem updateImpl(
		com.justonetech.oa.model.OfficeSupplyApplicationItem officeSupplyApplicationItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(officeSupplyApplicationItem);
	}

	/**
	* Returns the office supply application item with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException} if it could not be found.
	*
	* @param officeSupplyApplicationItemId the primary key of the office supply application item
	* @return the office supply application item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem findByPrimaryKey(
		long officeSupplyApplicationItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(officeSupplyApplicationItemId);
	}

	/**
	* Returns the office supply application item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeSupplyApplicationItemId the primary key of the office supply application item
	* @return the office supply application item, or <code>null</code> if a office supply application item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplicationItem fetchByPrimaryKey(
		long officeSupplyApplicationItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(officeSupplyApplicationItemId);
	}

	/**
	* Returns all the office supply application items.
	*
	* @return the office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplicationItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the office supply application items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply application items
	* @param end the upper bound of the range of office supply application items (not inclusive)
	* @return the range of office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplicationItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the office supply application items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply application items
	* @param end the upper bound of the range of office supply application items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplicationItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the office supply application items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of office supply application items.
	*
	* @return the number of office supply application items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OfficeSupplyApplicationItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OfficeSupplyApplicationItemPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					OfficeSupplyApplicationItemPersistence.class.getName());

			ReferenceRegistry.registerReference(OfficeSupplyApplicationItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		OfficeSupplyApplicationItemPersistence persistence) {
	}

	private static OfficeSupplyApplicationItemPersistence _persistence;
}