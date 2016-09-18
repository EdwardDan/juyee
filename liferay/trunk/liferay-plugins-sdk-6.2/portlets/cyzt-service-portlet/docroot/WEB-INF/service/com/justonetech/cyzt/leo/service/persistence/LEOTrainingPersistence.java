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

package com.justonetech.cyzt.leo.service.persistence;

import com.justonetech.cyzt.leo.model.LEOTraining;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l e o training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see LEOTrainingPersistenceImpl
 * @see LEOTrainingUtil
 * @generated
 */
public interface LEOTrainingPersistence extends BasePersistence<LEOTraining> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LEOTrainingUtil} to access the l e o training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the l e o trainings where zjbh = &#63;.
	*
	* @param zjbh the zjbh
	* @return the matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findByZjbh(
		java.lang.String zjbh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l e o trainings where zjbh = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param zjbh the zjbh
	* @param start the lower bound of the range of l e o trainings
	* @param end the upper bound of the range of l e o trainings (not inclusive)
	* @return the range of matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findByZjbh(
		java.lang.String zjbh, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l e o trainings where zjbh = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param zjbh the zjbh
	* @param start the lower bound of the range of l e o trainings
	* @param end the upper bound of the range of l e o trainings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findByZjbh(
		java.lang.String zjbh, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l e o training in the ordered set where zjbh = &#63;.
	*
	* @param zjbh the zjbh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining findByZjbh_First(
		java.lang.String zjbh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first l e o training in the ordered set where zjbh = &#63;.
	*
	* @param zjbh the zjbh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l e o training, or <code>null</code> if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining fetchByZjbh_First(
		java.lang.String zjbh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l e o training in the ordered set where zjbh = &#63;.
	*
	* @param zjbh the zjbh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining findByZjbh_Last(
		java.lang.String zjbh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last l e o training in the ordered set where zjbh = &#63;.
	*
	* @param zjbh the zjbh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l e o training, or <code>null</code> if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining fetchByZjbh_Last(
		java.lang.String zjbh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l e o trainings before and after the current l e o training in the ordered set where zjbh = &#63;.
	*
	* @param trainingId the primary key of the current l e o training
	* @param zjbh the zjbh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining[] findByZjbh_PrevAndNext(
		long trainingId, java.lang.String zjbh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l e o trainings where zjbh = &#63; from the database.
	*
	* @param zjbh the zjbh
	* @throws SystemException if a system exception occurred
	*/
	public void removeByZjbh(java.lang.String zjbh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l e o trainings where zjbh = &#63;.
	*
	* @param zjbh the zjbh
	* @return the number of matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public int countByZjbh(java.lang.String zjbh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l e o training in the entity cache if it is enabled.
	*
	* @param leoTraining the l e o training
	*/
	public void cacheResult(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining);

	/**
	* Caches the l e o trainings in the entity cache if it is enabled.
	*
	* @param leoTrainings the l e o trainings
	*/
	public void cacheResult(
		java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> leoTrainings);

	/**
	* Creates a new l e o training with the primary key. Does not add the l e o training to the database.
	*
	* @param trainingId the primary key for the new l e o training
	* @return the new l e o training
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining create(long trainingId);

	/**
	* Removes the l e o training with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training that was removed
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining remove(long trainingId)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.cyzt.leo.model.LEOTraining updateImpl(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l e o training with the primary key or throws a {@link com.justonetech.cyzt.leo.NoSuchLEOTrainingException} if it could not be found.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining findByPrimaryKey(
		long trainingId)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l e o training with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training, or <code>null</code> if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOTraining fetchByPrimaryKey(
		long trainingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l e o trainings.
	*
	* @return the l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the l e o trainings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l e o trainings
	* @param end the upper bound of the range of l e o trainings (not inclusive)
	* @return the range of l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the l e o trainings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l e o trainings
	* @param end the upper bound of the range of l e o trainings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l e o trainings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l e o trainings.
	*
	* @return the number of l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}