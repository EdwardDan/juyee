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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the construction unit project service. This utility wraps {@link ConstructionUnitProjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionUnitProjectPersistence
 * @see ConstructionUnitProjectPersistenceImpl
 * @generated
 */
public class ConstructionUnitProjectUtil {
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
	public static void clearCache(
		ConstructionUnitProject constructionUnitProject) {
		getPersistence().clearCache(constructionUnitProject);
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
	public static List<ConstructionUnitProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConstructionUnitProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConstructionUnitProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ConstructionUnitProject update(
		ConstructionUnitProject constructionUnitProject)
		throws SystemException {
		return getPersistence().update(constructionUnitProject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ConstructionUnitProject update(
		ConstructionUnitProject constructionUnitProject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(constructionUnitProject, serviceContext);
	}

	/**
	* Returns all the construction unit projects where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @return the matching construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findByConstructionPermitId(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConstructionPermitId(constructionPermitId);
	}

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
	public static java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findByConstructionPermitId(
		long constructionPermitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConstructionPermitId(constructionPermitId, start, end);
	}

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
	public static java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findByConstructionPermitId(
		long constructionPermitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConstructionPermitId(constructionPermitId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching construction unit project
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject findByConstructionPermitId_First(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConstructionPermitId_First(constructionPermitId,
			orderByComparator);
	}

	/**
	* Returns the first construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching construction unit project, or <code>null</code> if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject fetchByConstructionPermitId_First(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConstructionPermitId_First(constructionPermitId,
			orderByComparator);
	}

	/**
	* Returns the last construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching construction unit project
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject findByConstructionPermitId_Last(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConstructionPermitId_Last(constructionPermitId,
			orderByComparator);
	}

	/**
	* Returns the last construction unit project in the ordered set where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching construction unit project, or <code>null</code> if a matching construction unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject fetchByConstructionPermitId_Last(
		long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConstructionPermitId_Last(constructionPermitId,
			orderByComparator);
	}

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
	public static com.justonetech.projApproval.model.ConstructionUnitProject[] findByConstructionPermitId_PrevAndNext(
		long constructionUnitProjectId, long constructionPermitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByConstructionPermitId_PrevAndNext(constructionUnitProjectId,
			constructionPermitId, orderByComparator);
	}

	/**
	* Removes all the construction unit projects where constructionPermitId = &#63; from the database.
	*
	* @param constructionPermitId the construction permit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByConstructionPermitId(long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByConstructionPermitId(constructionPermitId);
	}

	/**
	* Returns the number of construction unit projects where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @return the number of matching construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByConstructionPermitId(long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByConstructionPermitId(constructionPermitId);
	}

	/**
	* Caches the construction unit project in the entity cache if it is enabled.
	*
	* @param constructionUnitProject the construction unit project
	*/
	public static void cacheResult(
		com.justonetech.projApproval.model.ConstructionUnitProject constructionUnitProject) {
		getPersistence().cacheResult(constructionUnitProject);
	}

	/**
	* Caches the construction unit projects in the entity cache if it is enabled.
	*
	* @param constructionUnitProjects the construction unit projects
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> constructionUnitProjects) {
		getPersistence().cacheResult(constructionUnitProjects);
	}

	/**
	* Creates a new construction unit project with the primary key. Does not add the construction unit project to the database.
	*
	* @param constructionUnitProjectId the primary key for the new construction unit project
	* @return the new construction unit project
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject create(
		long constructionUnitProjectId) {
		return getPersistence().create(constructionUnitProjectId);
	}

	/**
	* Removes the construction unit project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param constructionUnitProjectId the primary key of the construction unit project
	* @return the construction unit project that was removed
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject remove(
		long constructionUnitProjectId)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(constructionUnitProjectId);
	}

	public static com.justonetech.projApproval.model.ConstructionUnitProject updateImpl(
		com.justonetech.projApproval.model.ConstructionUnitProject constructionUnitProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(constructionUnitProject);
	}

	/**
	* Returns the construction unit project with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionUnitProjectException} if it could not be found.
	*
	* @param constructionUnitProjectId the primary key of the construction unit project
	* @return the construction unit project
	* @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject findByPrimaryKey(
		long constructionUnitProjectId)
		throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(constructionUnitProjectId);
	}

	/**
	* Returns the construction unit project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param constructionUnitProjectId the primary key of the construction unit project
	* @return the construction unit project, or <code>null</code> if a construction unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionUnitProject fetchByPrimaryKey(
		long constructionUnitProjectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(constructionUnitProjectId);
	}

	/**
	* Returns all the construction unit projects.
	*
	* @return the construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.justonetech.projApproval.model.ConstructionUnitProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the construction unit projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of construction unit projects.
	*
	* @return the number of construction unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConstructionUnitProjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConstructionUnitProjectPersistence)PortletBeanLocatorUtil.locate(com.justonetech.projApproval.service.ClpSerializer.getServletContextName(),
					ConstructionUnitProjectPersistence.class.getName());

			ReferenceRegistry.registerReference(ConstructionUnitProjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ConstructionUnitProjectPersistence persistence) {
	}

	private static ConstructionUnitProjectPersistence _persistence;
}