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

package com.justonetech.cyzt.leo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LEOTrainingLocalService}.
 *
 * @author fanqi
 * @see LEOTrainingLocalService
 * @generated
 */
public class LEOTrainingLocalServiceWrapper implements LEOTrainingLocalService,
	ServiceWrapper<LEOTrainingLocalService> {
	public LEOTrainingLocalServiceWrapper(
		LEOTrainingLocalService leoTrainingLocalService) {
		_leoTrainingLocalService = leoTrainingLocalService;
	}

	/**
	* Adds the l e o training to the database. Also notifies the appropriate model listeners.
	*
	* @param leoTraining the l e o training
	* @return the l e o training that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining addLEOTraining(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.addLEOTraining(leoTraining);
	}

	/**
	* Creates a new l e o training with the primary key. Does not add the l e o training to the database.
	*
	* @param trainingId the primary key for the new l e o training
	* @return the new l e o training
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining createLEOTraining(
		long trainingId) {
		return _leoTrainingLocalService.createLEOTraining(trainingId);
	}

	/**
	* Deletes the l e o training with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training that was removed
	* @throws PortalException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining deleteLEOTraining(
		long trainingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.deleteLEOTraining(trainingId);
	}

	/**
	* Deletes the l e o training from the database. Also notifies the appropriate model listeners.
	*
	* @param leoTraining the l e o training
	* @return the l e o training that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining deleteLEOTraining(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.deleteLEOTraining(leoTraining);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leoTrainingLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining fetchLEOTraining(
		long trainingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.fetchLEOTraining(trainingId);
	}

	/**
	* Returns the l e o training with the primary key.
	*
	* @param trainingId the primary key of the l e o training
	* @return the l e o training
	* @throws PortalException if a l e o training with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining getLEOTraining(
		long trainingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.getLEOTraining(trainingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.justonetech.cyzt.leo.model.LEOTraining> getLEOTrainings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.getLEOTrainings(start, end);
	}

	/**
	* Returns the number of l e o trainings.
	*
	* @return the number of l e o trainings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLEOTrainingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.getLEOTrainingsCount();
	}

	/**
	* Updates the l e o training in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leoTraining the l e o training
	* @return the l e o training that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOTraining updateLEOTraining(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoTrainingLocalService.updateLEOTraining(leoTraining);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leoTrainingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leoTrainingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leoTrainingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LEOTrainingLocalService getWrappedLEOTrainingLocalService() {
		return _leoTrainingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLEOTrainingLocalService(
		LEOTrainingLocalService leoTrainingLocalService) {
		_leoTrainingLocalService = leoTrainingLocalService;
	}

	@Override
	public LEOTrainingLocalService getWrappedService() {
		return _leoTrainingLocalService;
	}

	@Override
	public void setWrappedService(
		LEOTrainingLocalService leoTrainingLocalService) {
		_leoTrainingLocalService = leoTrainingLocalService;
	}

	private LEOTrainingLocalService _leoTrainingLocalService;
}