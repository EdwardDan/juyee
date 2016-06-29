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

import com.justonetech.oa.model.DeptWork;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dept work service. This utility wraps {@link DeptWorkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DeptWorkPersistence
 * @see DeptWorkPersistenceImpl
 * @generated
 */
public class DeptWorkUtil {
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
	public static void clearCache(DeptWork deptWork) {
		getPersistence().clearCache(deptWork);
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
	public static List<DeptWork> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DeptWork> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DeptWork> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DeptWork update(DeptWork deptWork) throws SystemException {
		return getPersistence().update(deptWork);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DeptWork update(DeptWork deptWork,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(deptWork, serviceContext);
	}

	/**
	* Returns all the dept works where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @return the matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findByDeptName(
		java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName(deptName);
	}

	/**
	* Returns a range of all the dept works where deptName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deptName the dept name
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @return the range of matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findByDeptName(
		java.lang.String deptName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName(deptName, start, end);
	}

	/**
	* Returns an ordered range of all the dept works where deptName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deptName the dept name
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findByDeptName(
		java.lang.String deptName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeptName(deptName, start, end, orderByComparator);
	}

	/**
	* Returns the first dept work in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dept work
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork findByDeptName_First(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName_First(deptName, orderByComparator);
	}

	/**
	* Returns the first dept work in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dept work, or <code>null</code> if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork fetchByDeptName_First(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDeptName_First(deptName, orderByComparator);
	}

	/**
	* Returns the last dept work in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dept work
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork findByDeptName_Last(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName_Last(deptName, orderByComparator);
	}

	/**
	* Returns the last dept work in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dept work, or <code>null</code> if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork fetchByDeptName_Last(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDeptName_Last(deptName, orderByComparator);
	}

	/**
	* Returns the dept works before and after the current dept work in the ordered set where deptName LIKE &#63;.
	*
	* @param deptWorkId the primary key of the current dept work
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dept work
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork[] findByDeptName_PrevAndNext(
		long deptWorkId, java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeptName_PrevAndNext(deptWorkId, deptName,
			orderByComparator);
	}

	/**
	* Removes all the dept works where deptName LIKE &#63; from the database.
	*
	* @param deptName the dept name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDeptName(deptName);
	}

	/**
	* Returns the number of dept works where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @return the number of matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDeptName(deptName);
	}

	/**
	* Returns all the dept works where userName LIKE &#63;.
	*
	* @param userName the user name
	* @return the matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findByUserName(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserName(userName);
	}

	/**
	* Returns a range of all the dept works where userName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @return the range of matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findByUserName(
		java.lang.String userName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserName(userName, start, end);
	}

	/**
	* Returns an ordered range of all the dept works where userName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findByUserName(
		java.lang.String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserName(userName, start, end, orderByComparator);
	}

	/**
	* Returns the first dept work in the ordered set where userName LIKE &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dept work
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork findByUserName_First(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserName_First(userName, orderByComparator);
	}

	/**
	* Returns the first dept work in the ordered set where userName LIKE &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dept work, or <code>null</code> if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork fetchByUserName_First(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserName_First(userName, orderByComparator);
	}

	/**
	* Returns the last dept work in the ordered set where userName LIKE &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dept work
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork findByUserName_Last(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserName_Last(userName, orderByComparator);
	}

	/**
	* Returns the last dept work in the ordered set where userName LIKE &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dept work, or <code>null</code> if a matching dept work could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork fetchByUserName_Last(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserName_Last(userName, orderByComparator);
	}

	/**
	* Returns the dept works before and after the current dept work in the ordered set where userName LIKE &#63;.
	*
	* @param deptWorkId the primary key of the current dept work
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dept work
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork[] findByUserName_PrevAndNext(
		long deptWorkId, java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserName_PrevAndNext(deptWorkId, userName,
			orderByComparator);
	}

	/**
	* Removes all the dept works where userName LIKE &#63; from the database.
	*
	* @param userName the user name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserName(userName);
	}

	/**
	* Returns the number of dept works where userName LIKE &#63;.
	*
	* @param userName the user name
	* @return the number of matching dept works
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserName(userName);
	}

	/**
	* Caches the dept work in the entity cache if it is enabled.
	*
	* @param deptWork the dept work
	*/
	public static void cacheResult(com.justonetech.oa.model.DeptWork deptWork) {
		getPersistence().cacheResult(deptWork);
	}

	/**
	* Caches the dept works in the entity cache if it is enabled.
	*
	* @param deptWorks the dept works
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.DeptWork> deptWorks) {
		getPersistence().cacheResult(deptWorks);
	}

	/**
	* Creates a new dept work with the primary key. Does not add the dept work to the database.
	*
	* @param deptWorkId the primary key for the new dept work
	* @return the new dept work
	*/
	public static com.justonetech.oa.model.DeptWork create(long deptWorkId) {
		return getPersistence().create(deptWorkId);
	}

	/**
	* Removes the dept work with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deptWorkId the primary key of the dept work
	* @return the dept work that was removed
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork remove(long deptWorkId)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(deptWorkId);
	}

	public static com.justonetech.oa.model.DeptWork updateImpl(
		com.justonetech.oa.model.DeptWork deptWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(deptWork);
	}

	/**
	* Returns the dept work with the primary key or throws a {@link com.justonetech.oa.NoSuchDeptWorkException} if it could not be found.
	*
	* @param deptWorkId the primary key of the dept work
	* @return the dept work
	* @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork findByPrimaryKey(
		long deptWorkId)
		throws com.justonetech.oa.NoSuchDeptWorkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(deptWorkId);
	}

	/**
	* Returns the dept work with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param deptWorkId the primary key of the dept work
	* @return the dept work, or <code>null</code> if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork fetchByPrimaryKey(
		long deptWorkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(deptWorkId);
	}

	/**
	* Returns all the dept works.
	*
	* @return the dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dept works.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @return the range of dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dept works.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dept works from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dept works.
	*
	* @return the number of dept works
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DeptWorkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DeptWorkPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					DeptWorkPersistence.class.getName());

			ReferenceRegistry.registerReference(DeptWorkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DeptWorkPersistence persistence) {
	}

	private static DeptWorkPersistence _persistence;
}