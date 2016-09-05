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

import com.justonetech.cp.permit.model.UnitProject;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the unit project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see UnitProjectPersistenceImpl
 * @see UnitProjectUtil
 * @generated
 */
public interface UnitProjectPersistence extends BasePersistence<UnitProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UnitProjectUtil} to access the unit project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the unit projects where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the matching unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findByPermitId(
		long permitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the unit projects where permitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param permitId the permit ID
	* @param start the lower bound of the range of unit projects
	* @param end the upper bound of the range of unit projects (not inclusive)
	* @return the range of matching unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findByPermitId(
		long permitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the unit projects where permitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param permitId the permit ID
	* @param start the lower bound of the range of unit projects
	* @param end the upper bound of the range of unit projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findByPermitId(
		long permitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit project
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject findByPermitId_First(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit project, or <code>null</code> if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject fetchByPermitId_First(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit project
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject findByPermitId_Last(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit project, or <code>null</code> if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject fetchByPermitId_Last(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unit projects before and after the current unit project in the ordered set where permitId = &#63;.
	*
	* @param projectId the primary key of the current unit project
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next unit project
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject[] findByPermitId_PrevAndNext(
		long projectId, long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the unit projects where permitId = &#63; from the database.
	*
	* @param permitId the permit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPermitId(long permitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of unit projects where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the number of matching unit projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByPermitId(long permitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the unit project in the entity cache if it is enabled.
	*
	* @param unitProject the unit project
	*/
	public void cacheResult(
		com.justonetech.cp.permit.model.UnitProject unitProject);

	/**
	* Caches the unit projects in the entity cache if it is enabled.
	*
	* @param unitProjects the unit projects
	*/
	public void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.UnitProject> unitProjects);

	/**
	* Creates a new unit project with the primary key. Does not add the unit project to the database.
	*
	* @param projectId the primary key for the new unit project
	* @return the new unit project
	*/
	public com.justonetech.cp.permit.model.UnitProject create(long projectId);

	/**
	* Removes the unit project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project that was removed
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject remove(long projectId)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.cp.permit.model.UnitProject updateImpl(
		com.justonetech.cp.permit.model.UnitProject unitProject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unit project with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchUnitProjectException} if it could not be found.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject findByPrimaryKey(
		long projectId)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unit project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project, or <code>null</code> if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.UnitProject fetchByPrimaryKey(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the unit projects.
	*
	* @return the unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the unit projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unit projects
	* @param end the upper bound of the range of unit projects (not inclusive)
	* @return the range of unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the unit projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unit projects
	* @param end the upper bound of the range of unit projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.UnitProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the unit projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of unit projects.
	*
	* @return the number of unit projects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}