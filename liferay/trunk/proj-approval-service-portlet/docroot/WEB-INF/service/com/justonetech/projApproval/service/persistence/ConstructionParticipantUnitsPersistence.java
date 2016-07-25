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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the construction participant units service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionParticipantUnitsPersistenceImpl
 * @see ConstructionParticipantUnitsUtil
 * @generated
 */
public interface ConstructionParticipantUnitsPersistence extends BasePersistence<ConstructionParticipantUnits> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConstructionParticipantUnitsUtil} to access the construction participant units persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the construction participant units where constructionPermitId = &#63; or throws a {@link com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException} if it could not be found.
	*
	* @param constructionPermitId the construction permit ID
	* @return the matching construction participant units
	* @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a matching construction participant units could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits findByConstructionPermitId(
		long constructionPermitId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction participant units where constructionPermitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param constructionPermitId the construction permit ID
	* @return the matching construction participant units, or <code>null</code> if a matching construction participant units could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits fetchByConstructionPermitId(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction participant units where constructionPermitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param constructionPermitId the construction permit ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching construction participant units, or <code>null</code> if a matching construction participant units could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits fetchByConstructionPermitId(
		long constructionPermitId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the construction participant units where constructionPermitId = &#63; from the database.
	*
	* @param constructionPermitId the construction permit ID
	* @return the construction participant units that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits removeByConstructionPermitId(
		long constructionPermitId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of construction participant unitses where constructionPermitId = &#63;.
	*
	* @param constructionPermitId the construction permit ID
	* @return the number of matching construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public int countByConstructionPermitId(long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the construction participant units in the entity cache if it is enabled.
	*
	* @param constructionParticipantUnits the construction participant units
	*/
	public void cacheResult(
		com.justonetech.projApproval.model.ConstructionParticipantUnits constructionParticipantUnits);

	/**
	* Caches the construction participant unitses in the entity cache if it is enabled.
	*
	* @param constructionParticipantUnitses the construction participant unitses
	*/
	public void cacheResult(
		java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> constructionParticipantUnitses);

	/**
	* Creates a new construction participant units with the primary key. Does not add the construction participant units to the database.
	*
	* @param constructionParticipantUnitsId the primary key for the new construction participant units
	* @return the new construction participant units
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits create(
		long constructionParticipantUnitsId);

	/**
	* Removes the construction participant units with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param constructionParticipantUnitsId the primary key of the construction participant units
	* @return the construction participant units that was removed
	* @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits remove(
		long constructionParticipantUnitsId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.projApproval.model.ConstructionParticipantUnits updateImpl(
		com.justonetech.projApproval.model.ConstructionParticipantUnits constructionParticipantUnits)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction participant units with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException} if it could not be found.
	*
	* @param constructionParticipantUnitsId the primary key of the construction participant units
	* @return the construction participant units
	* @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits findByPrimaryKey(
		long constructionParticipantUnitsId)
		throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction participant units with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param constructionParticipantUnitsId the primary key of the construction participant units
	* @return the construction participant units, or <code>null</code> if a construction participant units with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionParticipantUnits fetchByPrimaryKey(
		long constructionParticipantUnitsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the construction participant unitses.
	*
	* @return the construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.projApproval.model.ConstructionParticipantUnits> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the construction participant unitses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of construction participant unitses.
	*
	* @return the number of construction participant unitses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}