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

import com.justonetech.expert.model.Gzjl;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the gzjl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see GzjlPersistenceImpl
 * @see GzjlUtil
 * @generated
 */
public interface GzjlPersistence extends BasePersistence<Gzjl> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GzjlUtil} to access the gzjl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the gzjl in the entity cache if it is enabled.
	*
	* @param gzjl the gzjl
	*/
	public void cacheResult(com.justonetech.expert.model.Gzjl gzjl);

	/**
	* Caches the gzjls in the entity cache if it is enabled.
	*
	* @param gzjls the gzjls
	*/
	public void cacheResult(
		java.util.List<com.justonetech.expert.model.Gzjl> gzjls);

	/**
	* Creates a new gzjl with the primary key. Does not add the gzjl to the database.
	*
	* @param GzjlId the primary key for the new gzjl
	* @return the new gzjl
	*/
	public com.justonetech.expert.model.Gzjl create(long GzjlId);

	/**
	* Removes the gzjl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl that was removed
	* @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Gzjl remove(long GzjlId)
		throws com.justonetech.expert.NoSuchGzjlException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.expert.model.Gzjl updateImpl(
		com.justonetech.expert.model.Gzjl gzjl)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gzjl with the primary key or throws a {@link com.justonetech.expert.NoSuchGzjlException} if it could not be found.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl
	* @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Gzjl findByPrimaryKey(long GzjlId)
		throws com.justonetech.expert.NoSuchGzjlException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the gzjl with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl, or <code>null</code> if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Gzjl fetchByPrimaryKey(long GzjlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the gzjls.
	*
	* @return the gzjls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Gzjl> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the gzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gzjls
	* @param end the upper bound of the range of gzjls (not inclusive)
	* @return the range of gzjls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Gzjl> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the gzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gzjls
	* @param end the upper bound of the range of gzjls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of gzjls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Gzjl> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the gzjls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of gzjls.
	*
	* @return the number of gzjls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}