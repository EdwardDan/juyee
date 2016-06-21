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

package com.justonetech.proj.service.persistence;

import com.justonetech.proj.model.Bidding;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bidding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see BiddingPersistenceImpl
 * @see BiddingUtil
 * @generated
 */
public interface BiddingPersistence extends BasePersistence<Bidding> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BiddingUtil} to access the bidding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bidding in the entity cache if it is enabled.
	*
	* @param bidding the bidding
	*/
	public void cacheResult(com.justonetech.proj.model.Bidding bidding);

	/**
	* Caches the biddings in the entity cache if it is enabled.
	*
	* @param biddings the biddings
	*/
	public void cacheResult(
		java.util.List<com.justonetech.proj.model.Bidding> biddings);

	/**
	* Creates a new bidding with the primary key. Does not add the bidding to the database.
	*
	* @param biddingId the primary key for the new bidding
	* @return the new bidding
	*/
	public com.justonetech.proj.model.Bidding create(long biddingId);

	/**
	* Removes the bidding with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biddingId the primary key of the bidding
	* @return the bidding that was removed
	* @throws com.justonetech.proj.NoSuchBiddingException if a bidding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Bidding remove(long biddingId)
		throws com.justonetech.proj.NoSuchBiddingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.proj.model.Bidding updateImpl(
		com.justonetech.proj.model.Bidding bidding)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bidding with the primary key or throws a {@link com.justonetech.proj.NoSuchBiddingException} if it could not be found.
	*
	* @param biddingId the primary key of the bidding
	* @return the bidding
	* @throws com.justonetech.proj.NoSuchBiddingException if a bidding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Bidding findByPrimaryKey(long biddingId)
		throws com.justonetech.proj.NoSuchBiddingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bidding with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param biddingId the primary key of the bidding
	* @return the bidding, or <code>null</code> if a bidding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Bidding fetchByPrimaryKey(long biddingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the biddings.
	*
	* @return the biddings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Bidding> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the biddings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.BiddingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biddings
	* @param end the upper bound of the range of biddings (not inclusive)
	* @return the range of biddings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Bidding> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the biddings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.BiddingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biddings
	* @param end the upper bound of the range of biddings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of biddings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Bidding> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the biddings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of biddings.
	*
	* @return the number of biddings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}