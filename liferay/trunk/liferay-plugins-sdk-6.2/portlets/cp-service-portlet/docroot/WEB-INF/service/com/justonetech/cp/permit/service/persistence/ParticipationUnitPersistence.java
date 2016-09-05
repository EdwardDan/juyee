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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the participation unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ParticipationUnitPersistenceImpl
 * @see ParticipationUnitUtil
 * @generated
 */
public interface ParticipationUnitPersistence extends BasePersistence<ParticipationUnit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParticipationUnitUtil} to access the participation unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the participation units where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the matching participation units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findByPermitId(
		java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findByPermitId(
		java.lang.String permitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findByPermitId(
		java.lang.String permitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participation unit
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit findByPermitId_First(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching participation unit, or <code>null</code> if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit fetchByPermitId_First(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participation unit
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit findByPermitId_Last(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last participation unit in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching participation unit, or <code>null</code> if a matching participation unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit fetchByPermitId_Last(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.justonetech.cp.permit.model.ParticipationUnit[] findByPermitId_PrevAndNext(
		long unitId, java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the participation units where permitId = &#63; from the database.
	*
	* @param permitId the permit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPermitId(java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of participation units where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the number of matching participation units
	* @throws SystemException if a system exception occurred
	*/
	public int countByPermitId(java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the participation unit in the entity cache if it is enabled.
	*
	* @param participationUnit the participation unit
	*/
	public void cacheResult(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit);

	/**
	* Caches the participation units in the entity cache if it is enabled.
	*
	* @param participationUnits the participation units
	*/
	public void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> participationUnits);

	/**
	* Creates a new participation unit with the primary key. Does not add the participation unit to the database.
	*
	* @param unitId the primary key for the new participation unit
	* @return the new participation unit
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit create(long unitId);

	/**
	* Removes the participation unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit that was removed
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit remove(long unitId)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.cp.permit.model.ParticipationUnit updateImpl(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the participation unit with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchParticipationUnitException} if it could not be found.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit
	* @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit findByPrimaryKey(
		long unitId)
		throws com.justonetech.cp.permit.NoSuchParticipationUnitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the participation unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit, or <code>null</code> if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cp.permit.model.ParticipationUnit fetchByPrimaryKey(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the participation units.
	*
	* @return the participation units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the participation units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of participation units.
	*
	* @return the number of participation units
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}