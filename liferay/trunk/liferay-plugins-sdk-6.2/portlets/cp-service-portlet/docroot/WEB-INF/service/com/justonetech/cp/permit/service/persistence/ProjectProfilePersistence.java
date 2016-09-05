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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the project profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ProjectProfilePersistenceImpl
 * @see ProjectProfileUtil
 * @generated
 */
public interface ProjectProfilePersistence extends BasePersistence<ProjectProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectProfileUtil} to access the project profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the project profile in the entity cache if it is enabled.
	*
	* @param projectProfile the project profile
	*/
	public void cacheResult(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile);

	/**
	* Caches the project profiles in the entity cache if it is enabled.
	*
	* @param projectProfiles the project profiles
	*/
	public void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.ProjectProfile> projectProfiles);

	/**
	* Creates a new project profile with the primary key. Does not add the project profile to the database.
	*
	* @param permitId the primary key for the new project profile
	* @return the new project profile
	*/
	public com.justonetech.cp.permit.model.ProjectProfile create(long permitId);

	/**
	* Removes the project profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile that was removed
	* @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ProjectProfile remove(long permitId)
		throws com.justonetech.cp.permit.NoSuchProjectProfileException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.cp.permit.model.ProjectProfile updateImpl(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project profile with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchProjectProfileException} if it could not be found.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile
	* @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ProjectProfile findByPrimaryKey(
		long permitId)
		throws com.justonetech.cp.permit.NoSuchProjectProfileException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the project profile with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile, or <code>null</code> if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ProjectProfile fetchByPrimaryKey(
		long permitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the project profiles.
	*
	* @return the project profiles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.ProjectProfile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cp.permit.model.ProjectProfile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cp.permit.model.ProjectProfile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the project profiles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of project profiles.
	*
	* @return the number of project profiles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}