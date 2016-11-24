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

package com.justonetech.expert.service.persistence;

import com.justonetech.expert.model.Xlxx;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the xlxx service. This utility wraps {@link XlxxPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see XlxxPersistence
 * @see XlxxPersistenceImpl
 * @generated
 */
public class XlxxUtil {
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
	public static void clearCache(Xlxx xlxx) {
		getPersistence().clearCache(xlxx);
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
	public static List<Xlxx> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Xlxx> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Xlxx> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Xlxx update(Xlxx xlxx) throws SystemException {
		return getPersistence().update(xlxx);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Xlxx update(Xlxx xlxx, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(xlxx, serviceContext);
	}

	/**
	* Caches the xlxx in the entity cache if it is enabled.
	*
	* @param xlxx the xlxx
	*/
	public static void cacheResult(com.justonetech.expert.model.Xlxx xlxx) {
		getPersistence().cacheResult(xlxx);
	}

	/**
	* Caches the xlxxs in the entity cache if it is enabled.
	*
	* @param xlxxs the xlxxs
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.expert.model.Xlxx> xlxxs) {
		getPersistence().cacheResult(xlxxs);
	}

	/**
	* Creates a new xlxx with the primary key. Does not add the xlxx to the database.
	*
	* @param xlxxId the primary key for the new xlxx
	* @return the new xlxx
	*/
	public static com.justonetech.expert.model.Xlxx create(long xlxxId) {
		return getPersistence().create(xlxxId);
	}

	/**
	* Removes the xlxx with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param xlxxId the primary key of the xlxx
	* @return the xlxx that was removed
	* @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Xlxx remove(long xlxxId)
		throws com.justonetech.expert.NoSuchXlxxException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(xlxxId);
	}

	public static com.justonetech.expert.model.Xlxx updateImpl(
		com.justonetech.expert.model.Xlxx xlxx)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(xlxx);
	}

	/**
	* Returns the xlxx with the primary key or throws a {@link com.justonetech.expert.NoSuchXlxxException} if it could not be found.
	*
	* @param xlxxId the primary key of the xlxx
	* @return the xlxx
	* @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Xlxx findByPrimaryKey(
		long xlxxId)
		throws com.justonetech.expert.NoSuchXlxxException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(xlxxId);
	}

	/**
	* Returns the xlxx with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param xlxxId the primary key of the xlxx
	* @return the xlxx, or <code>null</code> if a xlxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Xlxx fetchByPrimaryKey(
		long xlxxId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(xlxxId);
	}

	/**
	* Returns all the xlxxs.
	*
	* @return the xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Xlxx> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the xlxxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.XlxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of xlxxs
	* @param end the upper bound of the range of xlxxs (not inclusive)
	* @return the range of xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Xlxx> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the xlxxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.XlxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of xlxxs
	* @param end the upper bound of the range of xlxxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Xlxx> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the xlxxs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of xlxxs.
	*
	* @return the number of xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static XlxxPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (XlxxPersistence)PortletBeanLocatorUtil.locate(com.justonetech.expert.service.ClpSerializer.getServletContextName(),
					XlxxPersistence.class.getName());

			ReferenceRegistry.registerReference(XlxxUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(XlxxPersistence persistence) {
	}

	private static XlxxPersistence _persistence;
}