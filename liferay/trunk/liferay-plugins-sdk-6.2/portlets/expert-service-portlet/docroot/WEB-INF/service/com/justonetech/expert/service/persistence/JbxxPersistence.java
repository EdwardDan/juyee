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

package com.justonetech.expert.service.persistence;

import com.justonetech.expert.model.Jbxx;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the jbxx service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see JbxxPersistenceImpl
 * @see JbxxUtil
 * @generated
 */
public interface JbxxPersistence extends BasePersistence<Jbxx> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link JbxxUtil} to access the jbxx persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the jbxx in the entity cache if it is enabled.
	*
	* @param jbxx the jbxx
	*/
	public void cacheResult(com.justonetech.expert.model.Jbxx jbxx);

	/**
	* Caches the jbxxs in the entity cache if it is enabled.
	*
	* @param jbxxs the jbxxs
	*/
	public void cacheResult(
		java.util.List<com.justonetech.expert.model.Jbxx> jbxxs);

	/**
	* Creates a new jbxx with the primary key. Does not add the jbxx to the database.
	*
	* @param jbxxId the primary key for the new jbxx
	* @return the new jbxx
	*/
	public com.justonetech.expert.model.Jbxx create(long jbxxId);

	/**
	* Removes the jbxx with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param jbxxId the primary key of the jbxx
	* @return the jbxx that was removed
	* @throws com.justonetech.expert.NoSuchJbxxException if a jbxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Jbxx remove(long jbxxId)
		throws com.justonetech.expert.NoSuchJbxxException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.expert.model.Jbxx updateImpl(
		com.justonetech.expert.model.Jbxx jbxx)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jbxx with the primary key or throws a {@link com.justonetech.expert.NoSuchJbxxException} if it could not be found.
	*
	* @param jbxxId the primary key of the jbxx
	* @return the jbxx
	* @throws com.justonetech.expert.NoSuchJbxxException if a jbxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Jbxx findByPrimaryKey(long jbxxId)
		throws com.justonetech.expert.NoSuchJbxxException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the jbxx with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param jbxxId the primary key of the jbxx
	* @return the jbxx, or <code>null</code> if a jbxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Jbxx fetchByPrimaryKey(long jbxxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the jbxxs.
	*
	* @return the jbxxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Jbxx> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the jbxxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.JbxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jbxxs
	* @param end the upper bound of the range of jbxxs (not inclusive)
	* @return the range of jbxxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Jbxx> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the jbxxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.JbxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of jbxxs
	* @param end the upper bound of the range of jbxxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of jbxxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Jbxx> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the jbxxs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of jbxxs.
	*
	* @return the number of jbxxs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}