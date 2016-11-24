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

import com.justonetech.expert.model.Zysqlb;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the zysqlb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZysqlbPersistenceImpl
 * @see ZysqlbUtil
 * @generated
 */
public interface ZysqlbPersistence extends BasePersistence<Zysqlb> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ZysqlbUtil} to access the zysqlb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the zysqlb in the entity cache if it is enabled.
	*
	* @param zysqlb the zysqlb
	*/
	public void cacheResult(com.justonetech.expert.model.Zysqlb zysqlb);

	/**
	* Caches the zysqlbs in the entity cache if it is enabled.
	*
	* @param zysqlbs the zysqlbs
	*/
	public void cacheResult(
		java.util.List<com.justonetech.expert.model.Zysqlb> zysqlbs);

	/**
	* Creates a new zysqlb with the primary key. Does not add the zysqlb to the database.
	*
	* @param zysqlbId the primary key for the new zysqlb
	* @return the new zysqlb
	*/
	public com.justonetech.expert.model.Zysqlb create(long zysqlbId);

	/**
	* Removes the zysqlb with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb that was removed
	* @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Zysqlb remove(long zysqlbId)
		throws com.justonetech.expert.NoSuchZysqlbException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.expert.model.Zysqlb updateImpl(
		com.justonetech.expert.model.Zysqlb zysqlb)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the zysqlb with the primary key or throws a {@link com.justonetech.expert.NoSuchZysqlbException} if it could not be found.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb
	* @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Zysqlb findByPrimaryKey(long zysqlbId)
		throws com.justonetech.expert.NoSuchZysqlbException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the zysqlb with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb, or <code>null</code> if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Zysqlb fetchByPrimaryKey(long zysqlbId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the zysqlbs.
	*
	* @return the zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Zysqlb> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the zysqlbs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zysqlbs
	* @param end the upper bound of the range of zysqlbs (not inclusive)
	* @return the range of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Zysqlb> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the zysqlbs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zysqlbs
	* @param end the upper bound of the range of zysqlbs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Zysqlb> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the zysqlbs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of zysqlbs.
	*
	* @return the number of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}