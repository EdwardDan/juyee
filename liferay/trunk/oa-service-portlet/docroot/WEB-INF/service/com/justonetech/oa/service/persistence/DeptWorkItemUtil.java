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

import com.justonetech.oa.model.DeptWorkItem;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dept work item service. This utility wraps {@link DeptWorkItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DeptWorkItemPersistence
 * @see DeptWorkItemPersistenceImpl
 * @generated
 */
public class DeptWorkItemUtil {
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
	public static void clearCache(DeptWorkItem deptWorkItem) {
		getPersistence().clearCache(deptWorkItem);
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
	public static List<DeptWorkItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DeptWorkItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DeptWorkItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DeptWorkItem update(DeptWorkItem deptWorkItem)
		throws SystemException {
		return getPersistence().update(deptWorkItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DeptWorkItem update(DeptWorkItem deptWorkItem,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(deptWorkItem, serviceContext);
	}

	/**
	* Caches the dept work item in the entity cache if it is enabled.
	*
	* @param deptWorkItem the dept work item
	*/
	public static void cacheResult(
		com.justonetech.oa.model.DeptWorkItem deptWorkItem) {
		getPersistence().cacheResult(deptWorkItem);
	}

	/**
	* Caches the dept work items in the entity cache if it is enabled.
	*
	* @param deptWorkItems the dept work items
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.DeptWorkItem> deptWorkItems) {
		getPersistence().cacheResult(deptWorkItems);
	}

	/**
	* Creates a new dept work item with the primary key. Does not add the dept work item to the database.
	*
	* @param deptWorkItemId the primary key for the new dept work item
	* @return the new dept work item
	*/
	public static com.justonetech.oa.model.DeptWorkItem create(
		long deptWorkItemId) {
		return getPersistence().create(deptWorkItemId);
	}

	/**
	* Removes the dept work item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deptWorkItemId the primary key of the dept work item
	* @return the dept work item that was removed
	* @throws com.justonetech.oa.NoSuchDeptWorkItemException if a dept work item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWorkItem remove(
		long deptWorkItemId)
		throws com.justonetech.oa.NoSuchDeptWorkItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(deptWorkItemId);
	}

	public static com.justonetech.oa.model.DeptWorkItem updateImpl(
		com.justonetech.oa.model.DeptWorkItem deptWorkItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(deptWorkItem);
	}

	/**
	* Returns the dept work item with the primary key or throws a {@link com.justonetech.oa.NoSuchDeptWorkItemException} if it could not be found.
	*
	* @param deptWorkItemId the primary key of the dept work item
	* @return the dept work item
	* @throws com.justonetech.oa.NoSuchDeptWorkItemException if a dept work item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWorkItem findByPrimaryKey(
		long deptWorkItemId)
		throws com.justonetech.oa.NoSuchDeptWorkItemException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(deptWorkItemId);
	}

	/**
	* Returns the dept work item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param deptWorkItemId the primary key of the dept work item
	* @return the dept work item, or <code>null</code> if a dept work item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWorkItem fetchByPrimaryKey(
		long deptWorkItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(deptWorkItemId);
	}

	/**
	* Returns all the dept work items.
	*
	* @return the dept work items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWorkItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dept work items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dept work items
	* @param end the upper bound of the range of dept work items (not inclusive)
	* @return the range of dept work items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWorkItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dept work items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dept work items
	* @param end the upper bound of the range of dept work items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dept work items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWorkItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dept work items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dept work items.
	*
	* @return the number of dept work items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DeptWorkItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DeptWorkItemPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					DeptWorkItemPersistence.class.getName());

			ReferenceRegistry.registerReference(DeptWorkItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DeptWorkItemPersistence persistence) {
	}

	private static DeptWorkItemPersistence _persistence;
}