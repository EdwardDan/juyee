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

package com.justonetech.cp.complete.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CompleteProjectProfileLocalService}.
 *
 * @author fanqi
 * @see CompleteProjectProfileLocalService
 * @generated
 */
public class CompleteProjectProfileLocalServiceWrapper
	implements CompleteProjectProfileLocalService,
		ServiceWrapper<CompleteProjectProfileLocalService> {
	public CompleteProjectProfileLocalServiceWrapper(
		CompleteProjectProfileLocalService completeProjectProfileLocalService) {
		_completeProjectProfileLocalService = completeProjectProfileLocalService;
	}

	/**
	* Adds the complete project profile to the database. Also notifies the appropriate model listeners.
	*
	* @param completeProjectProfile the complete project profile
	* @return the complete project profile that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile addCompleteProjectProfile(
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.addCompleteProjectProfile(completeProjectProfile);
	}

	/**
	* Creates a new complete project profile with the primary key. Does not add the complete project profile to the database.
	*
	* @param completeId the primary key for the new complete project profile
	* @return the new complete project profile
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile createCompleteProjectProfile(
		long completeId) {
		return _completeProjectProfileLocalService.createCompleteProjectProfile(completeId);
	}

	/**
	* Deletes the complete project profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param completeId the primary key of the complete project profile
	* @return the complete project profile that was removed
	* @throws PortalException if a complete project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile deleteCompleteProjectProfile(
		long completeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.deleteCompleteProjectProfile(completeId);
	}

	/**
	* Deletes the complete project profile from the database. Also notifies the appropriate model listeners.
	*
	* @param completeProjectProfile the complete project profile
	* @return the complete project profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile deleteCompleteProjectProfile(
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.deleteCompleteProjectProfile(completeProjectProfile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _completeProjectProfileLocalService.dynamicQuery();
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
		return _completeProjectProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _completeProjectProfileLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _completeProjectProfileLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _completeProjectProfileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _completeProjectProfileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile fetchCompleteProjectProfile(
		long completeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.fetchCompleteProjectProfile(completeId);
	}

	/**
	* Returns the complete project profile with the primary key.
	*
	* @param completeId the primary key of the complete project profile
	* @return the complete project profile
	* @throws PortalException if a complete project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile getCompleteProjectProfile(
		long completeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.getCompleteProjectProfile(completeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the complete project profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of complete project profiles
	* @param end the upper bound of the range of complete project profiles (not inclusive)
	* @return the range of complete project profiles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.complete.model.CompleteProjectProfile> getCompleteProjectProfiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.getCompleteProjectProfiles(start,
			end);
	}

	/**
	* Returns the number of complete project profiles.
	*
	* @return the number of complete project profiles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCompleteProjectProfilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.getCompleteProjectProfilesCount();
	}

	/**
	* Updates the complete project profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param completeProjectProfile the complete project profile
	* @return the complete project profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteProjectProfile updateCompleteProjectProfile(
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeProjectProfileLocalService.updateCompleteProjectProfile(completeProjectProfile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _completeProjectProfileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_completeProjectProfileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _completeProjectProfileLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CompleteProjectProfileLocalService getWrappedCompleteProjectProfileLocalService() {
		return _completeProjectProfileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCompleteProjectProfileLocalService(
		CompleteProjectProfileLocalService completeProjectProfileLocalService) {
		_completeProjectProfileLocalService = completeProjectProfileLocalService;
	}

	@Override
	public CompleteProjectProfileLocalService getWrappedService() {
		return _completeProjectProfileLocalService;
	}

	@Override
	public void setWrappedService(
		CompleteProjectProfileLocalService completeProjectProfileLocalService) {
		_completeProjectProfileLocalService = completeProjectProfileLocalService;
	}

	private CompleteProjectProfileLocalService _completeProjectProfileLocalService;
}