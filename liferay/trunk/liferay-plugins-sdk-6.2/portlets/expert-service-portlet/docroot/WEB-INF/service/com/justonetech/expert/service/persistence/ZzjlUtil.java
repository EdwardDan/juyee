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

import com.justonetech.expert.model.Zzjl;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the zzjl service. This utility wraps {@link ZzjlPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZzjlPersistence
 * @see ZzjlPersistenceImpl
 * @generated
 */
public class ZzjlUtil {
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
	public static void clearCache(Zzjl zzjl) {
		getPersistence().clearCache(zzjl);
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
	public static List<Zzjl> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Zzjl> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Zzjl> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Zzjl update(Zzjl zzjl) throws SystemException {
		return getPersistence().update(zzjl);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Zzjl update(Zzjl zzjl, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(zzjl, serviceContext);
	}

	/**
	* Caches the zzjl in the entity cache if it is enabled.
	*
	* @param zzjl the zzjl
	*/
	public static void cacheResult(com.justonetech.expert.model.Zzjl zzjl) {
		getPersistence().cacheResult(zzjl);
	}

	/**
	* Caches the zzjls in the entity cache if it is enabled.
	*
	* @param zzjls the zzjls
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.expert.model.Zzjl> zzjls) {
		getPersistence().cacheResult(zzjls);
	}

	/**
	* Creates a new zzjl with the primary key. Does not add the zzjl to the database.
	*
	* @param zzjlId the primary key for the new zzjl
	* @return the new zzjl
	*/
	public static com.justonetech.expert.model.Zzjl create(long zzjlId) {
		return getPersistence().create(zzjlId);
	}

	/**
	* Removes the zzjl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl that was removed
	* @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zzjl remove(long zzjlId)
		throws com.justonetech.expert.NoSuchZzjlException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(zzjlId);
	}

	public static com.justonetech.expert.model.Zzjl updateImpl(
		com.justonetech.expert.model.Zzjl zzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(zzjl);
	}

	/**
	* Returns the zzjl with the primary key or throws a {@link com.justonetech.expert.NoSuchZzjlException} if it could not be found.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl
	* @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zzjl findByPrimaryKey(
		long zzjlId)
		throws com.justonetech.expert.NoSuchZzjlException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(zzjlId);
	}

	/**
	* Returns the zzjl with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl, or <code>null</code> if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zzjl fetchByPrimaryKey(
		long zzjlId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(zzjlId);
	}

	/**
	* Returns all the zzjls.
	*
	* @return the zzjls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zzjl> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the zzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zzjls
	* @param end the upper bound of the range of zzjls (not inclusive)
	* @return the range of zzjls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zzjl> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the zzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zzjls
	* @param end the upper bound of the range of zzjls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of zzjls
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zzjl> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the zzjls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of zzjls.
	*
	* @return the number of zzjls
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ZzjlPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ZzjlPersistence)PortletBeanLocatorUtil.locate(com.justonetech.expert.service.ClpSerializer.getServletContextName(),
					ZzjlPersistence.class.getName());

			ReferenceRegistry.registerReference(ZzjlUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ZzjlPersistence persistence) {
	}

	private static ZzjlPersistence _persistence;
}