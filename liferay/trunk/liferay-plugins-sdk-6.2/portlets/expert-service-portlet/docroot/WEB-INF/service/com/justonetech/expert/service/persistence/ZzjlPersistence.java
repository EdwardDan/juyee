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

import com.justonetech.expert.model.Zzjl;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the zzjl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZzjlPersistenceImpl
 * @see ZzjlUtil
 * @generated
 */
public interface ZzjlPersistence extends BasePersistence<Zzjl> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ZzjlUtil} to access the zzjl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the zzjl in the entity cache if it is enabled.
	*
	* @param zzjl the zzjl
	*/
	public void cacheResult(com.justonetech.expert.model.Zzjl zzjl);

	/**
	* Caches the zzjls in the entity cache if it is enabled.
	*
	* @param zzjls the zzjls
	*/
	public void cacheResult(
		java.util.List<com.justonetech.expert.model.Zzjl> zzjls);

	/**
	* Creates a new zzjl with the primary key. Does not add the zzjl to the database.
	*
	* @param zzjlId the primary key for the new zzjl
	* @return the new zzjl
	*/
	public com.justonetech.expert.model.Zzjl create(long zzjlId);

	/**
	* Removes the zzjl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl that was removed
	* @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Zzjl remove(long zzjlId)
		throws com.justonetech.expert.NoSuchZzjlException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.expert.model.Zzjl updateImpl(
		com.justonetech.expert.model.Zzjl zzjl)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the zzjl with the primary key or throws a {@link com.justonetech.expert.NoSuchZzjlException} if it could not be found.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl
	* @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Zzjl findByPrimaryKey(long zzjlId)
		throws com.justonetech.expert.NoSuchZzjlException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the zzjl with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl, or <code>null</code> if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.expert.model.Zzjl fetchByPrimaryKey(long zzjlId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the zzjls.
	*
	* @return the zzjls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Zzjl> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the zzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zzjls
	* @param end the upper bound of the range of zzjls (not inclusive)
	* @return the range of zzjls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Zzjl> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the zzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zzjls
	* @param end the upper bound of the range of zzjls (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of zzjls
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.expert.model.Zzjl> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the zzjls from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of zzjls.
	*
	* @return the number of zzjls
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}