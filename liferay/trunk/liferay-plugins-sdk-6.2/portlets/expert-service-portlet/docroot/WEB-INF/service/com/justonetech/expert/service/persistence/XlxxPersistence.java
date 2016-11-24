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

import com.justonetech.expert.model.Xlxx;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the xlxx service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see XlxxPersistenceImpl
 * @see XlxxUtil
 * @generated
 */
public interface XlxxPersistence extends BasePersistence<Xlxx> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link XlxxUtil} to access the xlxx persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the xlxx in the entity cache if it is enabled.
	*
	* @param xlxx the xlxx
	*/
	public void cacheResult(com.justonetech.expert.model.Xlxx xlxx);

	/**
	* Caches the xlxxs in the entity cache if it is enabled.
	*
	* @param xlxxs the xlxxs
	*/
	public void cacheResult(
		java.util.List<com.justonetech.expert.model.Xlxx> xlxxs);

	/**
	* Creates a new xlxx with the primary key. Does not add the xlxx to the database.
	*
	* @param xlxxId the primary key for the new xlxx
	* @return the new xlxx
	*/
	public com.justonetech.expert.model.Xlxx create(long xlxxId);

	/**
	* Removes the xlxx with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param xlxxId the primary key of the xlxx
	* @return the xlxx that was removed
	* @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Xlxx remove(long xlxxId)
		throws com.justonetech.expert.NoSuchXlxxException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.expert.model.Xlxx updateImpl(
		com.justonetech.expert.model.Xlxx xlxx)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the xlxx with the primary key or throws a {@link com.justonetech.expert.NoSuchXlxxException} if it could not be found.
	*
	* @param xlxxId the primary key of the xlxx
	* @return the xlxx
	* @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Xlxx findByPrimaryKey(long xlxxId)
		throws com.justonetech.expert.NoSuchXlxxException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the xlxx with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param xlxxId the primary key of the xlxx
	* @return the xlxx, or <code>null</code> if a xlxx with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Xlxx fetchByPrimaryKey(long xlxxId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the xlxxs.
	*
	* @return the xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Xlxx> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the xlxxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.XlxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of xlxxs
	* @param end the upper bound of the range of xlxxs (not inclusive)
	* @return the range of xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Xlxx> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the xlxxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.XlxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of xlxxs
	* @param end the upper bound of the range of xlxxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Xlxx> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the xlxxs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of xlxxs.
	*
	* @return the number of xlxxs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}