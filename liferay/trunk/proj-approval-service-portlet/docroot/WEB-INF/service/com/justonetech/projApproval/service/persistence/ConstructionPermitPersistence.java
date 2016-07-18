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

import com.justonetech.projApproval.model.ConstructionPermit;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the construction permit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionPermitPersistenceImpl
 * @see ConstructionPermitUtil
 * @generated
 */
public interface ConstructionPermitPersistence extends BasePersistence<ConstructionPermit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConstructionPermitUtil} to access the construction permit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the construction permits where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching construction permits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionPermit> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the construction permits where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of construction permits
	* @param end the upper bound of the range of construction permits (not inclusive)
	* @return the range of matching construction permits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionPermit> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the construction permits where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of construction permits
	* @param end the upper bound of the range of construction permits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching construction permits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionPermit> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first construction permit in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching construction permit
	* @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a matching construction permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionPermitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first construction permit in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching construction permit, or <code>null</code> if a matching construction permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last construction permit in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching construction permit
	* @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a matching construction permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionPermitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last construction permit in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching construction permit, or <code>null</code> if a matching construction permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction permits before and after the current construction permit in the ordered set where userId = &#63;.
	*
	* @param constructionPermitId the primary key of the current construction permit
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next construction permit
	* @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit[] findByUserId_PrevAndNext(
		long constructionPermitId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.projApproval.NoSuchConstructionPermitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the construction permits where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of construction permits where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching construction permits
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the construction permit in the entity cache if it is enabled.
	*
	* @param constructionPermit the construction permit
	*/
	public void cacheResult(
		com.justonetech.projApproval.model.ConstructionPermit constructionPermit);

	/**
	* Caches the construction permits in the entity cache if it is enabled.
	*
	* @param constructionPermits the construction permits
	*/
	public void cacheResult(
		java.util.List<com.justonetech.projApproval.model.ConstructionPermit> constructionPermits);

	/**
	* Creates a new construction permit with the primary key. Does not add the construction permit to the database.
	*
	* @param constructionPermitId the primary key for the new construction permit
	* @return the new construction permit
	*/
	public com.justonetech.projApproval.model.ConstructionPermit create(
		long constructionPermitId);

	/**
	* Removes the construction permit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param constructionPermitId the primary key of the construction permit
	* @return the construction permit that was removed
	* @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit remove(
		long constructionPermitId)
		throws com.justonetech.projApproval.NoSuchConstructionPermitException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.projApproval.model.ConstructionPermit updateImpl(
		com.justonetech.projApproval.model.ConstructionPermit constructionPermit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction permit with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionPermitException} if it could not be found.
	*
	* @param constructionPermitId the primary key of the construction permit
	* @return the construction permit
	* @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit findByPrimaryKey(
		long constructionPermitId)
		throws com.justonetech.projApproval.NoSuchConstructionPermitException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the construction permit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param constructionPermitId the primary key of the construction permit
	* @return the construction permit, or <code>null</code> if a construction permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.projApproval.model.ConstructionPermit fetchByPrimaryKey(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the construction permits.
	*
	* @return the construction permits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionPermit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the construction permits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of construction permits
	* @param end the upper bound of the range of construction permits (not inclusive)
	* @return the range of construction permits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionPermit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the construction permits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of construction permits
	* @param end the upper bound of the range of construction permits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of construction permits
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.projApproval.model.ConstructionPermit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the construction permits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of construction permits.
	*
	* @return the number of construction permits
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}