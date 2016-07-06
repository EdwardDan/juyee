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

import com.justonetech.oa.model.Dispatch;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dispatch service. This utility wraps {@link DispatchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DispatchPersistence
 * @see DispatchPersistenceImpl
 * @generated
 */
public class DispatchUtil {
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
	public static void clearCache(Dispatch dispatch) {
		getPersistence().clearCache(dispatch);
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
	public static List<Dispatch> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dispatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dispatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Dispatch update(Dispatch dispatch) throws SystemException {
		return getPersistence().update(dispatch);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Dispatch update(Dispatch dispatch,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dispatch, serviceContext);
	}

	/**
	* Returns all the dispatchs where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.Dispatch> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the dispatchs where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @return the range of matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.Dispatch> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the dispatchs where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.Dispatch> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dispatch, or <code>null</code> if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dispatch, or <code>null</code> if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the dispatchs before and after the current dispatch in the ordered set where title LIKE &#63;.
	*
	* @param dispatchId the primary key of the current dispatch
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch[] findByTitle_PrevAndNext(
		long dispatchId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitle_PrevAndNext(dispatchId, title, orderByComparator);
	}

	/**
	* Removes all the dispatchs where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(title);
	}

	/**
	* Returns the number of dispatchs where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(title);
	}

	/**
	* Caches the dispatch in the entity cache if it is enabled.
	*
	* @param dispatch the dispatch
	*/
	public static void cacheResult(com.justonetech.oa.model.Dispatch dispatch) {
		getPersistence().cacheResult(dispatch);
	}

	/**
	* Caches the dispatchs in the entity cache if it is enabled.
	*
	* @param dispatchs the dispatchs
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.Dispatch> dispatchs) {
		getPersistence().cacheResult(dispatchs);
	}

	/**
	* Creates a new dispatch with the primary key. Does not add the dispatch to the database.
	*
	* @param dispatchId the primary key for the new dispatch
	* @return the new dispatch
	*/
	public static com.justonetech.oa.model.Dispatch create(long dispatchId) {
		return getPersistence().create(dispatchId);
	}

	/**
	* Removes the dispatch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch that was removed
	* @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch remove(long dispatchId)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(dispatchId);
	}

	public static com.justonetech.oa.model.Dispatch updateImpl(
		com.justonetech.oa.model.Dispatch dispatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dispatch);
	}

	/**
	* Returns the dispatch with the primary key or throws a {@link com.justonetech.oa.NoSuchDispatchException} if it could not be found.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch findByPrimaryKey(
		long dispatchId)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(dispatchId);
	}

	/**
	* Returns the dispatch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch, or <code>null</code> if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.Dispatch fetchByPrimaryKey(
		long dispatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dispatchId);
	}

	/**
	* Returns all the dispatchs.
	*
	* @return the dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.Dispatch> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dispatchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @return the range of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.Dispatch> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dispatchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.Dispatch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dispatchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dispatchs.
	*
	* @return the number of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DispatchPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DispatchPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					DispatchPersistence.class.getName());

			ReferenceRegistry.registerReference(DispatchUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DispatchPersistence persistence) {
	}

	private static DispatchPersistence _persistence;
}