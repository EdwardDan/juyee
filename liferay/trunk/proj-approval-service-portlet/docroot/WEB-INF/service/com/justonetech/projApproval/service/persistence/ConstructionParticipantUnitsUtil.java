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

import com.justonetech.projApproval.model.ConstructionParticipantUnits;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the construction participant units service. This utility wraps {@link ConstructionParticipantUnitsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionParticipantUnitsPersistence
 * @see ConstructionParticipantUnitsPersistenceImpl
 * @generated
 */
public class ConstructionParticipantUnitsUtil {
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
		ConstructionParticipantUnits constructionParticipantUnits) {
		getPersistence().clearCache(constructionParticipantUnits);
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
	public static List<ConstructionParticipantUnits> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConstructionParticipantUnits> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConstructionParticipantUnits> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ConstructionParticipantUnits update(
		ConstructionParticipantUnits constructionParticipantUnits)
		throws SystemException {
		return getPersistence().update(constructionParticipantUnits);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ConstructionParticipantUnits update(
		ConstructionParticipantUnits constructionParticipantUnits,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(constructionParticipantUnits, serviceContext);
	}

	/**
	* Returns the construction participant units where constructionPermitId = &#63; or throws a {@link com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException} if it could not be found.
	*
	* @param constructionPermitId the construction permit ID
	* @return the matching construction participant units
	* @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a matching construction participant units could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits findByConstructionPermitId(
		long constructionPermitId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByConstructionPermitId(constructionPermitId);
	}

	/**
	* Returns the construction participant units where constructionPermitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param constructionPermitId the construction permit ID
	* @return the matching construction participant units, or <code>null</code> if a matching construction participant units could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits fetchByConstructionPermitId(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByConstructionPermitId(constructionPermitId);
	}

	/**
	* Returns the construction participant units where constructionPermitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param constructionPermitId the construction permit ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching construction participant units, or <code>null</code> if a matching construction participant units could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits fetchByConstructionPermitId(
		long constructionPermitId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByConstructionPermitId(constructionPermitId,
			retrieveFromCache);
	}

	/**
	* Removes the construction participant units where constructionPermitId = &#63; from the database.
	*
	* @param constructionPermitId the construction permit ID
	* @return the construction participant units that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits removeByConstructionPermitId(
		long constructionPermitId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByConstructionPermitId(constructionPermitId);
	}

	/**
	* Returns the number of construction participant unitses where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @return the number of matching construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByConstructionPermitId(long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByConstructionPermitId(constructionPermitId);
	}

	/**
	* Caches the construction participant units in the entity cache if it is enabled.
	*
	* @param constructionParticipantUnits the construction participant units
	*/
	public static void cacheResult(
		com.justonetech.projApproval.model.ConstructionParticipantUnits constructionParticipantUnits) {
		getPersistence().cacheResult(constructionParticipantUnits);
	}

	/**
	* Caches the construction participant unitses in the entity cache if it is enabled.
	*
	* @param constructionParticipantUnitses the construction participant unitses
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> constructionParticipantUnitses) {
		getPersistence().cacheResult(constructionParticipantUnitses);
	}

	/**
	* Creates a new construction participant units with the primary key. Does not add the construction participant units to the database.
	*
	* @param constructionParticipantUnitsId the primary key for the new construction participant units
	* @return the new construction participant units
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits create(
		long constructionParticipantUnitsId) {
		return getPersistence().create(constructionParticipantUnitsId);
	}

	/**
	* Removes the construction participant units with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param constructionParticipantUnitsId the primary key of the construction participant units
	* @return the construction participant units that was removed
	* @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits remove(
		long constructionParticipantUnitsId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(constructionParticipantUnitsId);
	}

	public static com.justonetech.projApproval.model.ConstructionParticipantUnits updateImpl(
		com.justonetech.projApproval.model.ConstructionParticipantUnits constructionParticipantUnits)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(constructionParticipantUnits);
	}

	/**
	* Returns the construction participant units with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException} if it could not be found.
	*
	* @param constructionParticipantUnitsId the primary key of the construction participant units
	* @return the construction participant units
	* @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits findByPrimaryKey(
		long constructionParticipantUnitsId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(constructionParticipantUnitsId);
	}

	/**
	* Returns the construction participant units with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param constructionParticipantUnitsId the primary key of the construction participant units
	* @return the construction participant units, or <code>null</code> if a construction participant units with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionParticipantUnits fetchByPrimaryKey(
		long constructionParticipantUnitsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(constructionParticipantUnitsId);
	}

	/**
	* Returns all the construction participant unitses.
	*
	* @return the construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the construction participant unitses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of construction participant unitses
	* @param end the upper bound of the range of construction participant unitses (not inclusive)
	* @return the range of construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the construction participant unitses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of construction participant unitses
	* @param end the upper bound of the range of construction participant unitses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the construction participant unitses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of construction participant unitses.
	*
	* @return the number of construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConstructionParticipantUnitsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConstructionParticipantUnitsPersistence)PortletBeanLocatorUtil.locate(com.justonetech.projApproval.service.ClpSerializer.getServletContextName(),
					ConstructionParticipantUnitsPersistence.class.getName());

			ReferenceRegistry.registerReference(ConstructionParticipantUnitsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ConstructionParticipantUnitsPersistence persistence) {
	}

	private static ConstructionParticipantUnitsPersistence _persistence;
}