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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l e o training service. This utility wraps {@link LEOTrainingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see LEOTrainingPersistence
 * @see LEOTrainingPersistenceImpl
 * @generated
 */
public class LEOTrainingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LEOTraining leoTraining) {
		getPersistence().clearCache(leoTraining);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LEOTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LEOTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LEOTraining> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LEOTraining update(LEOTraining leoTraining)
		throws SystemException {
		return getPersistence().update(leoTraining);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LEOTraining update(LEOTraining leoTraining,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(leoTraining, serviceContext);
	}

	/**
	* Returns all the l e o trainings where certificateId = &#63;.
	*
	* @param certificateId the certificate ID
	* @return the matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findByCertificateId(
		long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCertificateId(certificateId);
	}

	/**
	* Returns a range of all the l e o trainings where certificateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param certificateId the certificate ID
	* @param start the lower bound of the range of l e o trainings
	* @param end the upper bound of the range of l e o trainings (not inclusive)
	* @return the range of matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findByCertificateId(
		long certificateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCertificateId(certificateId, start, end);
	}

	/**
	* Returns an ordered range of all the l e o trainings where certificateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param certificateId the certificate ID
	* @param start the lower bound of the range of l e o trainings
	* @param end the upper bound of the range of l e o trainings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findByCertificateId(
		long certificateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCertificateId(certificateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first l e o training in the ordered set where certificateId = &#63;.
	*
	* @param certificateId the certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining findByCertificateId_First(
		long certificateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCertificateId_First(certificateId, orderByComparator);
	}

	/**
	* Returns the first l e o training in the ordered set where certificateId = &#63;.
	*
	* @param certificateId the certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l e o training, or <code>null</code> if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining fetchByCertificateId_First(
		long certificateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCertificateId_First(certificateId, orderByComparator);
	}

	/**
	* Returns the last l e o training in the ordered set where certificateId = &#63;.
	*
	* @param certificateId the certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining findByCertificateId_Last(
		long certificateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCertificateId_Last(certificateId, orderByComparator);
	}

	/**
	* Returns the last l e o training in the ordered set where certificateId = &#63;.
	*
	* @param certificateId the certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l e o training, or <code>null</code> if a matching l e o training could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining fetchByCertificateId_Last(
		long certificateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCertificateId_Last(certificateId, orderByComparator);
	}

	/**
	* Returns the l e o trainings before and after the current l e o training in the ordered set where certificateId = &#63;.
	*
	* @param trainingId the primary key of the current l e o training
	* @param certificateId the certificate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining[] findByCertificateId_PrevAndNext(
		long trainingId, long certificateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCertificateId_PrevAndNext(trainingId, certificateId,
			orderByComparator);
	}

	/**
	* Removes all the l e o trainings where certificateId = &#63; from the database.
	*
	* @param certificateId the certificate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCertificateId(long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCertificateId(certificateId);
	}

	/**
	* Returns the number of l e o trainings where certificateId = &#63;.
	*
	* @param certificateId the certificate ID
	* @return the number of matching l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCertificateId(long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCertificateId(certificateId);
	}

	/**
	* Caches the l e o training in the entity cache if it is enabled.
	*
	* @param leoTraining the l e o training
	*/
	public static void cacheResult(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining) {
		getPersistence().cacheResult(leoTraining);
	}

	/**
	* Caches the l e o trainings in the entity cache if it is enabled.
	*
	* @param leoTrainings the l e o trainings
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> leoTrainings) {
		getPersistence().cacheResult(leoTrainings);
	}

	/**
	* Creates a new l e o training with the primary key. Does not add the l e o training to the database.
	*
	* @param trainingId the primary key for the new l e o training
	* @return the new l e o training
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining create(
		long trainingId) {
		return getPersistence().create(trainingId);
	}

	/**
	* Removes the l e o training with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training that was removed
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining remove(
		long trainingId)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(trainingId);
	}

	public static com.justonetech.cyzt.leo.model.LEOTraining updateImpl(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(leoTraining);
	}

	/**
	* Returns the l e o training with the primary key or throws a {@link com.justonetech.cyzt.leo.NoSuchLEOTrainingException} if it could not be found.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training
	* @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining findByPrimaryKey(
		long trainingId)
		throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(trainingId);
	}

	/**
	* Returns the l e o training with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training, or <code>null</code> if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOTraining fetchByPrimaryKey(
		long trainingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(trainingId);
	}

	/**
	* Returns all the l e o trainings.
	*
	* @return the l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l e o trainings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l e o trainings.
	*
	* @return the number of l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LEOTrainingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LEOTrainingPersistence)PortletBeanLocatorUtil.locate(com.justonetech.cyzt.leo.service.ClpSerializer.getServletContextName(),
					LEOTrainingPersistence.class.getName());

			ReferenceRegistry.registerReference(LEOTrainingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LEOTrainingPersistence persistence) {
	}

	private static LEOTrainingPersistence _persistence;
}