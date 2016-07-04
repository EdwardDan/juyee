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

import com.justonetech.oa.model.OfficeSupplyApplyItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the office supply apply item service. This utility wraps {@link OfficeSupplyApplyItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplyItemPersistence
 * @see OfficeSupplyApplyItemPersistenceImpl
 * @generated
 */
public class OfficeSupplyApplyItemUtil {
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
	public static void clearCache(OfficeSupplyApplyItem officeSupplyApplyItem) {
		getPersistence().clearCache(officeSupplyApplyItem);
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
	public static List<OfficeSupplyApplyItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OfficeSupplyApplyItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OfficeSupplyApplyItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OfficeSupplyApplyItem update(
		OfficeSupplyApplyItem officeSupplyApplyItem) throws SystemException {
		return getPersistence().update(officeSupplyApplyItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OfficeSupplyApplyItem update(
		OfficeSupplyApplyItem officeSupplyApplyItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(officeSupplyApplyItem, serviceContext);
	}

	/**
	* Caches the office supply apply item in the entity cache if it is enabled.
	*
	* @param officeSupplyApplyItem the office supply apply item
	*/
	public static void cacheResult(
		com.justonetech.oa.model.OfficeSupplyApplyItem officeSupplyApplyItem) {
		getPersistence().cacheResult(officeSupplyApplyItem);
	}

	/**
	* Caches the office supply apply items in the entity cache if it is enabled.
	*
	* @param officeSupplyApplyItems the office supply apply items
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.OfficeSupplyApplyItem> officeSupplyApplyItems) {
		getPersistence().cacheResult(officeSupplyApplyItems);
	}

	/**
	* Creates a new office supply apply item with the primary key. Does not add the office supply apply item to the database.
	*
	* @param officeSupplyApplyItemId the primary key for the new office supply apply item
	* @return the new office supply apply item
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplyItem create(
		long officeSupplyApplyItemId) {
		return getPersistence().create(officeSupplyApplyItemId);
	}

	/**
	* Removes the office supply apply item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplyItemId the primary key of the office supply apply item
	* @return the office supply apply item that was removed
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException if a office supply apply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplyItem remove(
		long officeSupplyApplyItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(officeSupplyApplyItemId);
	}

	public static com.justonetech.oa.model.OfficeSupplyApplyItem updateImpl(
		com.justonetech.oa.model.OfficeSupplyApplyItem officeSupplyApplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(officeSupplyApplyItem);
	}

	/**
	* Returns the office supply apply item with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyApplyItemException} if it could not be found.
	*
	* @param officeSupplyApplyItemId the primary key of the office supply apply item
	* @return the office supply apply item
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException if a office supply apply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplyItem findByPrimaryKey(
		long officeSupplyApplyItemId)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(officeSupplyApplyItemId);
	}

	/**
	* Returns the office supply apply item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeSupplyApplyItemId the primary key of the office supply apply item
	* @return the office supply apply item, or <code>null</code> if a office supply apply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApplyItem fetchByPrimaryKey(
		long officeSupplyApplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(officeSupplyApplyItemId);
	}

	/**
	* Returns all the office supply apply items.
	*
	* @return the office supply apply items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplyItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the office supply apply items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply apply items
	* @param end the upper bound of the range of office supply apply items (not inclusive)
	* @return the range of office supply apply items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplyItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the office supply apply items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply apply items
	* @param end the upper bound of the range of office supply apply items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of office supply apply items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApplyItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the office supply apply items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of office supply apply items.
	*
	* @return the number of office supply apply items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OfficeSupplyApplyItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OfficeSupplyApplyItemPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					OfficeSupplyApplyItemPersistence.class.getName());

			ReferenceRegistry.registerReference(OfficeSupplyApplyItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OfficeSupplyApplyItemPersistence persistence) {
	}

	private static OfficeSupplyApplyItemPersistence _persistence;
}