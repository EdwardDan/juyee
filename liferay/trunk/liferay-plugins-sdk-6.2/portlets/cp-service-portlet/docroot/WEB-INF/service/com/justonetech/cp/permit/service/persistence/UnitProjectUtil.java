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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the unit project service. This utility wraps {@link UnitProjectPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see UnitProjectPersistence
 * @see UnitProjectPersistenceImpl
 * @generated
 */
public class UnitProjectUtil {
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
	public static void clearCache(UnitProject unitProject) {
		getPersistence().clearCache(unitProject);
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
	public static List<UnitProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UnitProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UnitProject> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UnitProject update(UnitProject unitProject)
		throws SystemException {
		return getPersistence().update(unitProject);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UnitProject update(UnitProject unitProject,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(unitProject, serviceContext);
	}

	/**
	* Returns all the unit projects where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the matching unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.UnitProject> findByPermitId(
		long permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId(permitId);
	}

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
	public static java.util.List<com.justonetech.cp.permit.model.UnitProject> findByPermitId(
		long permitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId(permitId, start, end);
	}

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
	public static java.util.List<com.justonetech.cp.permit.model.UnitProject> findByPermitId(
		long permitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPermitId(permitId, start, end, orderByComparator);
	}

	/**
	* Returns the first unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit project
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.UnitProject findByPermitId_First(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId_First(permitId, orderByComparator);
	}

	/**
	* Returns the first unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit project, or <code>null</code> if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.UnitProject fetchByPermitId_First(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPermitId_First(permitId, orderByComparator);
	}

	/**
	* Returns the last unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit project
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.UnitProject findByPermitId_Last(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId_Last(permitId, orderByComparator);
	}

	/**
	* Returns the last unit project in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit project, or <code>null</code> if a matching unit project could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.UnitProject fetchByPermitId_Last(
		long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPermitId_Last(permitId, orderByComparator);
	}

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
	public static com.justonetech.cp.permit.model.UnitProject[] findByPermitId_PrevAndNext(
		long projectId, long permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPermitId_PrevAndNext(projectId, permitId,
			orderByComparator);
	}

	/**
	* Removes all the unit projects where permitId = &#63; from the database.
	*
	* @param permitId the permit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPermitId(long permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPermitId(permitId);
	}

	/**
	* Returns the number of unit projects where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the number of matching unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPermitId(long permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPermitId(permitId);
	}

	/**
	* Caches the unit project in the entity cache if it is enabled.
	*
	* @param unitProject the unit project
	*/
	public static void cacheResult(
		com.justonetech.cp.permit.model.UnitProject unitProject) {
		getPersistence().cacheResult(unitProject);
	}

	/**
	* Caches the unit projects in the entity cache if it is enabled.
	*
	* @param unitProjects the unit projects
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.UnitProject> unitProjects) {
		getPersistence().cacheResult(unitProjects);
	}

	/**
	* Creates a new unit project with the primary key. Does not add the unit project to the database.
	*
	* @param projectId the primary key for the new unit project
	* @return the new unit project
	*/
	public static com.justonetech.cp.permit.model.UnitProject create(
		long projectId) {
		return getPersistence().create(projectId);
	}

	/**
	* Removes the unit project with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project that was removed
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.UnitProject remove(
		long projectId)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(projectId);
	}

	public static com.justonetech.cp.permit.model.UnitProject updateImpl(
		com.justonetech.cp.permit.model.UnitProject unitProject)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(unitProject);
	}

	/**
	* Returns the unit project with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchUnitProjectException} if it could not be found.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project
	* @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.UnitProject findByPrimaryKey(
		long projectId)
		throws com.justonetech.cp.permit.NoSuchUnitProjectException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(projectId);
	}

	/**
	* Returns the unit project with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param projectId the primary key of the unit project
	* @return the unit project, or <code>null</code> if a unit project with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.UnitProject fetchByPrimaryKey(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(projectId);
	}

	/**
	* Returns all the unit projects.
	*
	* @return the unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.UnitProject> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.justonetech.cp.permit.model.UnitProject> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.justonetech.cp.permit.model.UnitProject> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the unit projects from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of unit projects.
	*
	* @return the number of unit projects
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UnitProjectPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UnitProjectPersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.permit.service.ClpSerializer.getServletContextName(),
					UnitProjectPersistence.class.getName());

			ReferenceRegistry.registerReference(UnitProjectUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UnitProjectPersistence persistence) {
	}

	private static UnitProjectPersistence _persistence;
}