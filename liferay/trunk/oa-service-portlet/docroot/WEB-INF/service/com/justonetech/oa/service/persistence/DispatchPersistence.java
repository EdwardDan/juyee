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

import com.justonetech.oa.model.Dispatch;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dispatch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DispatchPersistenceImpl
 * @see DispatchUtil
 * @generated
 */
public interface DispatchPersistence extends BasePersistence<Dispatch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DispatchUtil} to access the dispatch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dispatchs where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.Dispatch> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dispatchs where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @return the range of matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.Dispatch> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dispatchs where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.Dispatch> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dispatch, or <code>null</code> if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dispatch in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dispatch, or <code>null</code> if a matching dispatch could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dispatchs before and after the current dispatch in the ordered set where title LIKE &#63;.
	*
	* @param dispatchId the primary key of the current dispatch
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch[] findByTitle_PrevAndNext(
		long dispatchId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dispatchs where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dispatchs where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dispatch in the entity cache if it is enabled.
	*
	* @param dispatch the dispatch
	*/
	public void cacheResult(com.justonetech.oa.model.Dispatch dispatch);

	/**
	* Caches the dispatchs in the entity cache if it is enabled.
	*
	* @param dispatchs the dispatchs
	*/
	public void cacheResult(
		java.util.List<com.justonetech.oa.model.Dispatch> dispatchs);

	/**
	* Creates a new dispatch with the primary key. Does not add the dispatch to the database.
	*
	* @param dispatchId the primary key for the new dispatch
	* @return the new dispatch
	*/
	public com.justonetech.oa.model.Dispatch create(long dispatchId);

	/**
	* Removes the dispatch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch that was removed
	* @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch remove(long dispatchId)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.oa.model.Dispatch updateImpl(
		com.justonetech.oa.model.Dispatch dispatch)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dispatch with the primary key or throws a {@link com.justonetech.oa.NoSuchDispatchException} if it could not be found.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch
	* @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch findByPrimaryKey(long dispatchId)
		throws com.justonetech.oa.NoSuchDispatchException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dispatch with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch, or <code>null</code> if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.Dispatch fetchByPrimaryKey(long dispatchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dispatchs.
	*
	* @return the dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.Dispatch> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the dispatchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @return the range of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.Dispatch> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the dispatchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.Dispatch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dispatchs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dispatchs.
	*
	* @return the number of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}