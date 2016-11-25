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

import com.justonetech.expert.model.Gzjl;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the gzjl service. This utility wraps {@link GzjlPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see GzjlPersistence
 * @see GzjlPersistenceImpl
 * @generated
 */
public class GzjlUtil {
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
	public static void clearCache(Gzjl gzjl) {
		getPersistence().clearCache(gzjl);
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
	public static List<Gzjl> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Gzjl> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Gzjl> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Gzjl update(Gzjl gzjl) throws SystemException {
		return getPersistence().update(gzjl);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Gzjl update(Gzjl gzjl, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(gzjl, serviceContext);
	}

	/**
	* Caches the gzjl in the entity cache if it is enabled.
	*
	* @param gzjl the gzjl
	*/
	public static void cacheResult(com.justonetech.expert.model.Gzjl gzjl) {
		getPersistence().cacheResult(gzjl);
	}

	/**
	* Caches the gzjls in the entity cache if it is enabled.
	*
	* @param gzjls the gzjls
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.expert.model.Gzjl> gzjls) {
		getPersistence().cacheResult(gzjls);
	}

	/**
	* Creates a new gzjl with the primary key. Does not add the gzjl to the database.
	*
	* @param GzjlId the primary key for the new gzjl
	* @return the new gzjl
	*/
	public static com.justonetech.expert.model.Gzjl create(long GzjlId) {
		return getPersistence().create(GzjlId);
	}

	/**
	* Removes the gzjl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl that was removed
	* @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Gzjl remove(long GzjlId)
		throws com.justonetech.expert.NoSuchGzjlException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(GzjlId);
	}

	public static com.justonetech.expert.model.Gzjl updateImpl(
		com.justonetech.expert.model.Gzjl gzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gzjl);
	}

	/**
	* Returns the gzjl with the primary key or throws a {@link com.justonetech.expert.NoSuchGzjlException} if it could not be found.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl
	* @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Gzjl findByPrimaryKey(
		long GzjlId)
		throws com.justonetech.expert.NoSuchGzjlException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(GzjlId);
	}

	/**
	* Returns the gzjl with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl, or <code>null</code> if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Gzjl fetchByPrimaryKey(
		long GzjlId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(GzjlId);
	}

	/**
	* Returns all the gzjls.
	*
	* @return the gzjls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Gzjl> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the gzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gzjls
	* @param end the upper bound of the range of gzjls (not inclusive)
	* @return the range of gzjls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Gzjl> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the gzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gzjls
	* @param end the upper bound of the range of gzjls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gzjls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Gzjl> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the gzjls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of gzjls.
	*
	* @return the number of gzjls
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GzjlPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GzjlPersistence)PortletBeanLocatorUtil.locate(com.justonetech.expert.service.ClpSerializer.getServletContextName(),
					GzjlPersistence.class.getName());

			ReferenceRegistry.registerReference(GzjlUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GzjlPersistence persistence) {
	}

	private static GzjlPersistence _persistence;
}