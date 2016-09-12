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

import com.justonetech.cp.complete.model.CompleteUnitProject;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the complete unit project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompleteUnitProjectPersistenceImpl
 * @see CompleteUnitProjectUtil
 * @generated
 */
public interface CompleteUnitProjectPersistence extends BasePersistence<CompleteUnitProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompleteUnitProjectUtil} to access the complete unit project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the complete unit projects where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @return the matching complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.complete.model.CompleteUnitProject> findByCompleteId(
		long completeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complete unit projects where completeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param completeId the complete ID
	* @param start the lower bound of the range of complete unit projects
	* @param end the upper bound of the range of complete unit projects (not inclusive)
	* @return the range of matching complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.complete.model.CompleteUnitProject> findByCompleteId(
		long completeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complete unit projects where completeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param completeId the complete ID
	* @param start the lower bound of the range of complete unit projects
	* @param end the upper bound of the range of complete unit projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.complete.model.CompleteUnitProject> findByCompleteId(
		long completeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complete unit project in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complete unit project
	* @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a matching complete unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject findByCompleteId_First(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first complete unit project in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complete unit project, or <code>null</code> if a matching complete unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject fetchByCompleteId_First(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complete unit project in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complete unit project
	* @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a matching complete unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject findByCompleteId_Last(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last complete unit project in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complete unit project, or <code>null</code> if a matching complete unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject fetchByCompleteId_Last(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complete unit projects before and after the current complete unit project in the ordered set where completeId = &#63;.
	*
	* @param projectId the primary key of the current complete unit project
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complete unit project
	* @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject[] findByCompleteId_PrevAndNext(
		long projectId, long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complete unit projects where completeId = &#63; from the database.
	*
	* @param completeId the complete ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompleteId(long completeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complete unit projects where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @return the number of matching complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompleteId(long completeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the complete unit project in the entity cache if it is enabled.
	*
	* @param completeUnitProject the complete unit project
	*/
	public void cacheResult(
		com.justonetech.cp.complete.model.CompleteUnitProject completeUnitProject);

	/**
	* Caches the complete unit projects in the entity cache if it is enabled.
	*
	* @param completeUnitProjects the complete unit projects
	*/
	public void cacheResult(
		java.util.List<com.justonetech.cp.complete.model.CompleteUnitProject> completeUnitProjects);

	/**
	* Creates a new complete unit project with the primary key. Does not add the complete unit project to the database.
	*
	* @param projectId the primary key for the new complete unit project
	* @return the new complete unit project
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject create(
		long projectId);

	/**
	* Removes the complete unit project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the complete unit project
	* @return the complete unit project that was removed
	* @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject remove(
		long projectId)
		throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.cp.complete.model.CompleteUnitProject updateImpl(
		com.justonetech.cp.complete.model.CompleteUnitProject completeUnitProject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complete unit project with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteUnitProjectException} if it could not be found.
	*
	* @param projectId the primary key of the complete unit project
	* @return the complete unit project
	* @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject findByPrimaryKey(
		long projectId)
		throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the complete unit project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the complete unit project
	* @return the complete unit project, or <code>null</code> if a complete unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.complete.model.CompleteUnitProject fetchByPrimaryKey(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the complete unit projects.
	*
	* @return the complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.complete.model.CompleteUnitProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the complete unit projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of complete unit projects
	* @param end the upper bound of the range of complete unit projects (not inclusive)
	* @return the range of complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.complete.model.CompleteUnitProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the complete unit projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of complete unit projects
	* @param end the upper bound of the range of complete unit projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.complete.model.CompleteUnitProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the complete unit projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of complete unit projects.
	*
	* @return the number of complete unit projects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}