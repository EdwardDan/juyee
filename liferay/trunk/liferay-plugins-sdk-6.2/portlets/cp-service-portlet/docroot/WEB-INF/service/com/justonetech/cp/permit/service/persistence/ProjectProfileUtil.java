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

package com.justonetech.cp.permit.service.persistence;

import com.justonetech.cp.permit.model.ProjectProfile;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the project profile service. This utility wraps {@link ProjectProfilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ProjectProfilePersistence
 * @see ProjectProfilePersistenceImpl
 * @generated
 */
public class ProjectProfileUtil {
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
	public static void clearCache(ProjectProfile projectProfile) {
		getPersistence().clearCache(projectProfile);
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
	public static List<ProjectProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectProfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ProjectProfile update(ProjectProfile projectProfile)
		throws SystemException {
		return getPersistence().update(projectProfile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ProjectProfile update(ProjectProfile projectProfile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(projectProfile, serviceContext);
	}

	/**
	* Caches the project profile in the entity cache if it is enabled.
	*
	* @param projectProfile the project profile
	*/
	public static void cacheResult(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile) {
		getPersistence().cacheResult(projectProfile);
	}

	/**
	* Caches the project profiles in the entity cache if it is enabled.
	*
	* @param projectProfiles the project profiles
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.ProjectProfile> projectProfiles) {
		getPersistence().cacheResult(projectProfiles);
	}

	/**
	* Creates a new project profile with the primary key. Does not add the project profile to the database.
	*
	* @param permitId the primary key for the new project profile
	* @return the new project profile
	*/
	public static com.justonetech.cp.permit.model.ProjectProfile create(
		long permitId) {
		return getPersistence().create(permitId);
	}

	/**
	* Removes the project profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile that was removed
	* @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ProjectProfile remove(
		long permitId)
		throws com.justonetech.cp.permit.NoSuchProjectProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(permitId);
	}

	public static com.justonetech.cp.permit.model.ProjectProfile updateImpl(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(projectProfile);
	}

	/**
	* Returns the project profile with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchProjectProfileException} if it could not be found.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile
	* @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ProjectProfile findByPrimaryKey(
		long permitId)
		throws com.justonetech.cp.permit.NoSuchProjectProfileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(permitId);
	}

	/**
	* Returns the project profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile, or <code>null</code> if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ProjectProfile fetchByPrimaryKey(
		long permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(permitId);
	}

	/**
	* Returns all the project profiles.
	*
	* @return the project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ProjectProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the project profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project profiles
	* @param end the upper bound of the range of project profiles (not inclusive)
	* @return the range of project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ProjectProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the project profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project profiles
	* @param end the upper bound of the range of project profiles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ProjectProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the project profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of project profiles.
	*
	* @return the number of project profiles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProjectProfilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProjectProfilePersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.permit.service.ClpSerializer.getServletContextName(),
					ProjectProfilePersistence.class.getName());

			ReferenceRegistry.registerReference(ProjectProfileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ProjectProfilePersistence persistence) {
	}

	private static ProjectProfilePersistence _persistence;
}