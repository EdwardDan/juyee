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

package com.justonetech.oa.service.persistence;

import com.justonetech.oa.model.LeaderWork;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the leader work service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see LeaderWorkPersistenceImpl
 * @see LeaderWorkUtil
 * @generated
 */
public interface LeaderWorkPersistence extends BasePersistence<LeaderWork> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LeaderWorkUtil} to access the leader work persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the leader work in the entity cache if it is enabled.
	*
	* @param leaderWork the leader work
	*/
	public void cacheResult(com.justonetech.oa.model.LeaderWork leaderWork);

	/**
	* Caches the leader works in the entity cache if it is enabled.
	*
	* @param leaderWorks the leader works
	*/
	public void cacheResult(
		java.util.List<com.justonetech.oa.model.LeaderWork> leaderWorks);

	/**
	* Creates a new leader work with the primary key. Does not add the leader work to the database.
	*
	* @param leaderWorkPK the primary key for the new leader work
	* @return the new leader work
	*/
	public com.justonetech.oa.model.LeaderWork create(LeaderWorkPK leaderWorkPK);

	/**
	* Removes the leader work with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaderWorkPK the primary key of the leader work
	* @return the leader work that was removed
	* @throws com.justonetech.oa.NoSuchLeaderWorkException if a leader work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.LeaderWork remove(LeaderWorkPK leaderWorkPK)
		throws com.justonetech.oa.NoSuchLeaderWorkException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.oa.model.LeaderWork updateImpl(
		com.justonetech.oa.model.LeaderWork leaderWork)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leader work with the primary key or throws a {@link com.justonetech.oa.NoSuchLeaderWorkException} if it could not be found.
	*
	* @param leaderWorkPK the primary key of the leader work
	* @return the leader work
	* @throws com.justonetech.oa.NoSuchLeaderWorkException if a leader work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.LeaderWork findByPrimaryKey(
		LeaderWorkPK leaderWorkPK)
		throws com.justonetech.oa.NoSuchLeaderWorkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the leader work with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param leaderWorkPK the primary key of the leader work
	* @return the leader work, or <code>null</code> if a leader work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.LeaderWork fetchByPrimaryKey(
		LeaderWorkPK leaderWorkPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the leader works.
	*
	* @return the leader works
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.LeaderWork> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the leader works.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.LeaderWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leader works
	* @param end the upper bound of the range of leader works (not inclusive)
	* @return the range of leader works
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.LeaderWork> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the leader works.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.LeaderWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leader works
	* @param end the upper bound of the range of leader works (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of leader works
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.LeaderWork> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the leader works from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of leader works.
	*
	* @return the number of leader works
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}