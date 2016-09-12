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

package com.justonetech.cp.complete.service.persistence;

import com.justonetech.cp.complete.model.CompleteProjectProfile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the complete project profile service. This utility wraps {@link CompleteProjectProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompleteProjectProfilePersistence
 * @see CompleteProjectProfilePersistenceImpl
 * @generated
 */
public class CompleteProjectProfileUtil {
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
	public static void clearCache(CompleteProjectProfile completeProjectProfile) {
		getPersistence().clearCache(completeProjectProfile);
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
	public static List<CompleteProjectProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompleteProjectProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompleteProjectProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CompleteProjectProfile update(
		CompleteProjectProfile completeProjectProfile)
		throws SystemException {
		return getPersistence().update(completeProjectProfile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CompleteProjectProfile update(
		CompleteProjectProfile completeProjectProfile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(completeProjectProfile, serviceContext);
	}

	/**
	* Caches the complete project profile in the entity cache if it is enabled.
	*
	* @param completeProjectProfile the complete project profile
	*/
	public static void cacheResult(
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile) {
		getPersistence().cacheResult(completeProjectProfile);
	}

	/**
	* Caches the complete project profiles in the entity cache if it is enabled.
	*
	* @param completeProjectProfiles the complete project profiles
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.complete.model.CompleteProjectProfile> completeProjectProfiles) {
		getPersistence().cacheResult(completeProjectProfiles);
	}

	/**
	* Creates a new complete project profile with the primary key. Does not add the complete project profile to the database.
	*
	* @param completeId the primary key for the new complete project profile
	* @return the new complete project profile
	*/
	public static com.justonetech.cp.complete.model.CompleteProjectProfile create(
		long completeId) {
		return getPersistence().create(completeId);
	}

	/**
	* Removes the complete project profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param completeId the primary key of the complete project profile
	* @return the complete project profile that was removed
	* @throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException if a complete project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteProjectProfile remove(
		long completeId)
		throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(completeId);
	}

	public static com.justonetech.cp.complete.model.CompleteProjectProfile updateImpl(
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(completeProjectProfile);
	}

	/**
	* Returns the complete project profile with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteProjectProfileException} if it could not be found.
	*
	* @param completeId the primary key of the complete project profile
	* @return the complete project profile
	* @throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException if a complete project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteProjectProfile findByPrimaryKey(
		long completeId)
		throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(completeId);
	}

	/**
	* Returns the complete project profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param completeId the primary key of the complete project profile
	* @return the complete project profile, or <code>null</code> if a complete project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteProjectProfile fetchByPrimaryKey(
		long completeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(completeId);
	}

	/**
	* Returns all the complete project profiles.
	*
	* @return the complete project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteProjectProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the complete project profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of complete project profiles
	* @param end the upper bound of the range of complete project profiles (not inclusive)
	* @return the range of complete project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteProjectProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the complete project profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of complete project profiles
	* @param end the upper bound of the range of complete project profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of complete project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteProjectProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the complete project profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of complete project profiles.
	*
	* @return the number of complete project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CompleteProjectProfilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CompleteProjectProfilePersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.complete.service.ClpSerializer.getServletContextName(),
					CompleteProjectProfilePersistence.class.getName());

			ReferenceRegistry.registerReference(CompleteProjectProfileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CompleteProjectProfilePersistence persistence) {
	}

	private static CompleteProjectProfilePersistence _persistence;
}