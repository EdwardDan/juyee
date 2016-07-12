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

package com.justonetech.sys.service.persistence;

import com.justonetech.sys.model.SMS;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the s m s service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see SMSPersistenceImpl
 * @see SMSUtil
 * @generated
 */
public interface SMSPersistence extends BasePersistence<SMS> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SMSUtil} to access the s m s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the s m s in the entity cache if it is enabled.
	*
	* @param sms the s m s
	*/
	public void cacheResult(com.justonetech.sys.model.SMS sms);

	/**
	* Caches the s m ses in the entity cache if it is enabled.
	*
	* @param smses the s m ses
	*/
	public void cacheResult(java.util.List<com.justonetech.sys.model.SMS> smses);

	/**
	* Creates a new s m s with the primary key. Does not add the s m s to the database.
	*
	* @param smsId the primary key for the new s m s
	* @return the new s m s
	*/
	public com.justonetech.sys.model.SMS create(long smsId);

	/**
	* Removes the s m s with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param smsId the primary key of the s m s
	* @return the s m s that was removed
	* @throws com.justonetech.sys.NoSuchSMSException if a s m s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.SMS remove(long smsId)
		throws com.justonetech.sys.NoSuchSMSException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.sys.model.SMS updateImpl(
		com.justonetech.sys.model.SMS sms)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s m s with the primary key or throws a {@link com.justonetech.sys.NoSuchSMSException} if it could not be found.
	*
	* @param smsId the primary key of the s m s
	* @return the s m s
	* @throws com.justonetech.sys.NoSuchSMSException if a s m s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.SMS findByPrimaryKey(long smsId)
		throws com.justonetech.sys.NoSuchSMSException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s m s with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param smsId the primary key of the s m s
	* @return the s m s, or <code>null</code> if a s m s with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.SMS fetchByPrimaryKey(long smsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s m ses.
	*
	* @return the s m ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.sys.model.SMS> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s m ses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.SMSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s m ses
	* @param end the upper bound of the range of s m ses (not inclusive)
	* @return the range of s m ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.sys.model.SMS> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s m ses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.SMSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s m ses
	* @param end the upper bound of the range of s m ses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s m ses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.sys.model.SMS> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s m ses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s m ses.
	*
	* @return the number of s m ses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}