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

import com.justonetech.expert.model.Zqtzjkrzqk;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the zqtzjkrzqk service. This utility wraps {@link ZqtzjkrzqkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZqtzjkrzqkPersistence
 * @see ZqtzjkrzqkPersistenceImpl
 * @generated
 */
public class ZqtzjkrzqkUtil {
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
	public static void clearCache(Zqtzjkrzqk zqtzjkrzqk) {
		getPersistence().clearCache(zqtzjkrzqk);
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
	public static List<Zqtzjkrzqk> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Zqtzjkrzqk> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Zqtzjkrzqk> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Zqtzjkrzqk update(Zqtzjkrzqk zqtzjkrzqk)
		throws SystemException {
		return getPersistence().update(zqtzjkrzqk);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Zqtzjkrzqk update(Zqtzjkrzqk zqtzjkrzqk,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(zqtzjkrzqk, serviceContext);
	}

	/**
	* Caches the zqtzjkrzqk in the entity cache if it is enabled.
	*
	* @param zqtzjkrzqk the zqtzjkrzqk
	*/
	public static void cacheResult(
		com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk) {
		getPersistence().cacheResult(zqtzjkrzqk);
	}

	/**
	* Caches the zqtzjkrzqks in the entity cache if it is enabled.
	*
	* @param zqtzjkrzqks the zqtzjkrzqks
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.expert.model.Zqtzjkrzqk> zqtzjkrzqks) {
		getPersistence().cacheResult(zqtzjkrzqks);
	}

	/**
	* Creates a new zqtzjkrzqk with the primary key. Does not add the zqtzjkrzqk to the database.
	*
	* @param zqtzjkrzqkId the primary key for the new zqtzjkrzqk
	* @return the new zqtzjkrzqk
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk create(
		long zqtzjkrzqkId) {
		return getPersistence().create(zqtzjkrzqkId);
	}

	/**
	* Removes the zqtzjkrzqk with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	* @return the zqtzjkrzqk that was removed
	* @throws com.justonetech.expert.NoSuchZqtzjkrzqkException if a zqtzjkrzqk with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk remove(
		long zqtzjkrzqkId)
		throws com.justonetech.expert.NoSuchZqtzjkrzqkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(zqtzjkrzqkId);
	}

	public static com.justonetech.expert.model.Zqtzjkrzqk updateImpl(
		com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(zqtzjkrzqk);
	}

	/**
	* Returns the zqtzjkrzqk with the primary key or throws a {@link com.justonetech.expert.NoSuchZqtzjkrzqkException} if it could not be found.
	*
	* @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	* @return the zqtzjkrzqk
	* @throws com.justonetech.expert.NoSuchZqtzjkrzqkException if a zqtzjkrzqk with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk findByPrimaryKey(
		long zqtzjkrzqkId)
		throws com.justonetech.expert.NoSuchZqtzjkrzqkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(zqtzjkrzqkId);
	}

	/**
	* Returns the zqtzjkrzqk with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	* @return the zqtzjkrzqk, or <code>null</code> if a zqtzjkrzqk with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk fetchByPrimaryKey(
		long zqtzjkrzqkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(zqtzjkrzqkId);
	}

	/**
	* Returns all the zqtzjkrzqks.
	*
	* @return the zqtzjkrzqks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zqtzjkrzqk> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the zqtzjkrzqks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zqtzjkrzqks
	* @param end the upper bound of the range of zqtzjkrzqks (not inclusive)
	* @return the range of zqtzjkrzqks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zqtzjkrzqk> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the zqtzjkrzqks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zqtzjkrzqks
	* @param end the upper bound of the range of zqtzjkrzqks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of zqtzjkrzqks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zqtzjkrzqk> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the zqtzjkrzqks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of zqtzjkrzqks.
	*
	* @return the number of zqtzjkrzqks
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ZqtzjkrzqkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ZqtzjkrzqkPersistence)PortletBeanLocatorUtil.locate(com.justonetech.expert.service.ClpSerializer.getServletContextName(),
					ZqtzjkrzqkPersistence.class.getName());

			ReferenceRegistry.registerReference(ZqtzjkrzqkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ZqtzjkrzqkPersistence persistence) {
	}

	private static ZqtzjkrzqkPersistence _persistence;
}