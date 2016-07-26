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

package com.justonetech.projApproval.service.persistence;

import com.justonetech.projApproval.model.ConstructionUnitProject;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the construction unit project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionUnitProjectPersistenceImpl
 * @see ConstructionUnitProjectUtil
 * @generated
 */
public interface ConstructionUnitProjectPersistence extends BasePersistence<ConstructionUnitProject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConstructionUnitProjectUtil} to access the construction unit project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the construction unit projects where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @return the matching construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findByConstructionPermitId(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the construction unit projects where constructionPermitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param constructionPermitId the construction permit ID
	* @param start the lower bound of the range of construction unit projects
	* @param end the upper bound of the range of construction unit projects (not inclusive)
	* @return the range of matching construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findByConstructionPermitId(
		long constructionPermitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the construction unit projects where constructionPermitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param constructionPermitId the construction permit ID
	* @param start the lower bound of the range of construction unit projects
	* @param end the upper bound of the range of construction unit projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findByConstructionPermitId(
		long constructionPermitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching construction unit project
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject findByConstructionPermitId_First(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching construction unit project, or <code>null</code> if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject fetchByConstructionPermitId_First(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching construction unit project
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject findByConstructionPermitId_Last(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching construction unit project, or <code>null</code> if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject fetchByConstructionPermitId_Last(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction unit projects before and after the current construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionUnitProjectId the primary key of the current construction unit project
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next construction unit project
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject[] findByConstructionPermitId_PrevAndNext(
		long constructionUnitProjectId, long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the construction unit projects where constructionPermitId = &#63; from the database.
	*
	* @param constructionPermitId the construction permit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByConstructionPermitId(long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of construction unit projects where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @return the number of matching construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public int countByConstructionPermitId(long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the construction unit project in the entity cache if it is enabled.
	*
	* @param constructionUnitProject the construction unit project
	*/
	public void cacheResult(
		com.justonetech.projApproval.model.ConstructionUnitProject constructionUnitProject);

	/**
	* Caches the construction unit projects in the entity cache if it is enabled.
	*
	* @param constructionUnitProjects the construction unit projects
	*/
	public void cacheResult(
		java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> constructionUnitProjects);

	/**
	* Creates a new construction unit project with the primary key. Does not add the construction unit project to the database.
	*
	* @param constructionUnitProjectId the primary key for the new construction unit project
	* @return the new construction unit project
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject create(
		long constructionUnitProjectId);

	/**
	* Removes the construction unit project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param constructionUnitProjectId the primary key of the construction unit project
	* @return the construction unit project that was removed
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject remove(
		long constructionUnitProjectId)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.projApproval.model.ConstructionUnitProject updateImpl(
		com.justonetech.projApproval.model.ConstructionUnitProject constructionUnitProject)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction unit project with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionUnitProjectException} if it could not be found.
	*
	* @param constructionUnitProjectId the primary key of the construction unit project
	* @return the construction unit project
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject findByPrimaryKey(
		long constructionUnitProjectId)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction unit project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param constructionUnitProjectId the primary key of the construction unit project
	* @return the construction unit project, or <code>null</code> if a construction unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionUnitProject fetchByPrimaryKey(
		long constructionUnitProjectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the construction unit projects.
	*
	* @return the construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the construction unit projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of construction unit projects
	* @param end the upper bound of the range of construction unit projects (not inclusive)
	* @return the range of construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the construction unit projects.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of construction unit projects
	* @param end the upper bound of the range of construction unit projects (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the construction unit projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of construction unit projects.
	*
	* @return the number of construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}