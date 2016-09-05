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

import com.justonetech.cp.permit.model.ParticipationUnit;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the participation unit service. This utility wraps {@link ParticipationUnitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ParticipationUnitPersistence
 * @see ParticipationUnitPersistenceImpl
 * @generated
 */
public class ParticipationUnitUtil {
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
	public static void clearCache(ParticipationUnit participationUnit) {
		getPersistence().clearCache(participationUnit);
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
	public static List<ParticipationUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ParticipationUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ParticipationUnit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ParticipationUnit update(ParticipationUnit participationUnit)
		throws SystemException {
		return getPersistence().update(participationUnit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ParticipationUnit update(
		ParticipationUnit participationUnit, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(participationUnit, serviceContext);
	}

	/**
	* Returns all the participation units where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the matching participation units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findByPermitId(
		java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId(permitId);
	}

	/**
	* Returns a range of all the participation units where permitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param permitId the permit ID
	* @param start the lower bound of the range of participation units
	* @param end the upper bound of the range of participation units (not inclusive)
	* @return the range of matching participation units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findByPermitId(
		java.lang.String permitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId(permitId, start, end);
	}

	/**
	* Returns an ordered range of all the participation units where permitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param permitId the permit ID
	* @param start the lower bound of the range of participation units
	* @param end the upper bound of the range of participation units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching participation units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findByPermitId(
		java.lang.String permitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPermitId(permitId, start, end, orderByComparator);
	}

	/**
	* Returns the first participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participation unit
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit findByPermitId_First(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId_First(permitId, orderByComparator);
	}

	/**
	* Returns the first participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participation unit, or <code>null</code> if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit fetchByPermitId_First(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPermitId_First(permitId, orderByComparator);
	}

	/**
	* Returns the last participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participation unit
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit findByPermitId_Last(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId_Last(permitId, orderByComparator);
	}

	/**
	* Returns the last participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participation unit, or <code>null</code> if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit fetchByPermitId_Last(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPermitId_Last(permitId, orderByComparator);
	}

	/**
	* Returns the participation units before and after the current participation unit in the ordered set where permitId = &#63;.
	*
	* @param unitId the primary key of the current participation unit
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next participation unit
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit[] findByPermitId_PrevAndNext(
		long unitId, java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPermitId_PrevAndNext(unitId, permitId,
			orderByComparator);
	}

	/**
	* Removes all the participation units where permitId = &#63; from the database.
	*
	* @param permitId the permit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPermitId(java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPermitId(permitId);
	}

	/**
	* Returns the number of participation units where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the number of matching participation units
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPermitId(java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPermitId(permitId);
	}

	/**
	* Caches the participation unit in the entity cache if it is enabled.
	*
	* @param participationUnit the participation unit
	*/
	public static void cacheResult(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit) {
		getPersistence().cacheResult(participationUnit);
	}

	/**
	* Caches the participation units in the entity cache if it is enabled.
	*
	* @param participationUnits the participation units
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> participationUnits) {
		getPersistence().cacheResult(participationUnits);
	}

	/**
	* Creates a new participation unit with the primary key. Does not add the participation unit to the database.
	*
	* @param unitId the primary key for the new participation unit
	* @return the new participation unit
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit create(
		long unitId) {
		return getPersistence().create(unitId);
	}

	/**
	* Removes the participation unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit that was removed
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit remove(
		long unitId)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(unitId);
	}

	public static com.justonetech.cp.permit.model.ParticipationUnit updateImpl(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(participationUnit);
	}

	/**
	* Returns the participation unit with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchParticipationUnitException} if it could not be found.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit findByPrimaryKey(
		long unitId)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(unitId);
	}

	/**
	* Returns the participation unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit, or <code>null</code> if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ParticipationUnit fetchByPrimaryKey(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(unitId);
	}

	/**
	* Returns all the participation units.
	*
	* @return the participation units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the participation units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of participation units
	* @param end the upper bound of the range of participation units (not inclusive)
	* @return the range of participation units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the participation units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of participation units
	* @param end the upper bound of the range of participation units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of participation units
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the participation units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of participation units.
	*
	* @return the number of participation units
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ParticipationUnitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ParticipationUnitPersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.permit.service.ClpSerializer.getServletContextName(),
					ParticipationUnitPersistence.class.getName());

			ReferenceRegistry.registerReference(ParticipationUnitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ParticipationUnitPersistence persistence) {
	}

	private static ParticipationUnitPersistence _persistence;
}