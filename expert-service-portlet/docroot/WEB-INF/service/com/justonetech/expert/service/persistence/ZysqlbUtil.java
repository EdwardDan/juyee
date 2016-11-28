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

import com.justonetech.expert.model.Zysqlb;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the zysqlb service. This utility wraps {@link ZysqlbPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZysqlbPersistence
 * @see ZysqlbPersistenceImpl
 * @generated
 */
public class ZysqlbUtil {
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
	public static void clearCache(Zysqlb zysqlb) {
		getPersistence().clearCache(zysqlb);
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
	public static List<Zysqlb> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Zysqlb> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Zysqlb> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Zysqlb update(Zysqlb zysqlb) throws SystemException {
		return getPersistence().update(zysqlb);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Zysqlb update(Zysqlb zysqlb, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(zysqlb, serviceContext);
	}

	/**
	* Caches the zysqlb in the entity cache if it is enabled.
	*
	* @param zysqlb the zysqlb
	*/
	public static void cacheResult(com.justonetech.expert.model.Zysqlb zysqlb) {
		getPersistence().cacheResult(zysqlb);
	}

	/**
	* Caches the zysqlbs in the entity cache if it is enabled.
	*
	* @param zysqlbs the zysqlbs
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.expert.model.Zysqlb> zysqlbs) {
		getPersistence().cacheResult(zysqlbs);
	}

	/**
	* Creates a new zysqlb with the primary key. Does not add the zysqlb to the database.
	*
	* @param zysqlbId the primary key for the new zysqlb
	* @return the new zysqlb
	*/
	public static com.justonetech.expert.model.Zysqlb create(long zysqlbId) {
		return getPersistence().create(zysqlbId);
	}

	/**
	* Removes the zysqlb with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb that was removed
	* @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zysqlb remove(long zysqlbId)
		throws com.justonetech.expert.NoSuchZysqlbException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(zysqlbId);
	}

	public static com.justonetech.expert.model.Zysqlb updateImpl(
		com.justonetech.expert.model.Zysqlb zysqlb)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(zysqlb);
	}

	/**
	* Returns the zysqlb with the primary key or throws a {@link com.justonetech.expert.NoSuchZysqlbException} if it could not be found.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb
	* @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zysqlb findByPrimaryKey(
		long zysqlbId)
		throws com.justonetech.expert.NoSuchZysqlbException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(zysqlbId);
	}

	/**
	* Returns the zysqlb with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb, or <code>null</code> if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zysqlb fetchByPrimaryKey(
		long zysqlbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(zysqlbId);
	}

	/**
	* Returns all the zysqlbs.
	*
	* @return the zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zysqlb> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the zysqlbs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zysqlbs
	* @param end the upper bound of the range of zysqlbs (not inclusive)
	* @return the range of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zysqlb> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the zysqlbs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zysqlbs
	* @param end the upper bound of the range of zysqlbs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zysqlb> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the zysqlbs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of zysqlbs.
	*
	* @return the number of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ZysqlbPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ZysqlbPersistence)PortletBeanLocatorUtil.locate(com.justonetech.expert.service.ClpSerializer.getServletContextName(),
					ZysqlbPersistence.class.getName());

			ReferenceRegistry.registerReference(ZysqlbUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ZysqlbPersistence persistence) {
	}

	private static ZysqlbPersistence _persistence;
}