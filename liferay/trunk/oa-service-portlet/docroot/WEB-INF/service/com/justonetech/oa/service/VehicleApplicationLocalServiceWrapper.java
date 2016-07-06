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

package com.justonetech.oa.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VehicleApplicationLocalService}.
 *
 * @author justonetech
 * @see VehicleApplicationLocalService
 * @generated
 */
public class VehicleApplicationLocalServiceWrapper
	implements VehicleApplicationLocalService,
		ServiceWrapper<VehicleApplicationLocalService> {
	public VehicleApplicationLocalServiceWrapper(
		VehicleApplicationLocalService vehicleApplicationLocalService) {
		_vehicleApplicationLocalService = vehicleApplicationLocalService;
	}

	/**
	* Adds the vehicle application to the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleApplication the vehicle application
	* @return the vehicle application that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleApplication addVehicleApplication(
		com.justonetech.oa.model.VehicleApplication vehicleApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.addVehicleApplication(vehicleApplication);
	}

	/**
	* Creates a new vehicle application with the primary key. Does not add the vehicle application to the database.
	*
	* @param vehicleApplicationId the primary key for the new vehicle application
	* @return the new vehicle application
	*/
	@Override
	public com.justonetech.oa.model.VehicleApplication createVehicleApplication(
		long vehicleApplicationId) {
		return _vehicleApplicationLocalService.createVehicleApplication(vehicleApplicationId);
	}

	/**
	* Deletes the vehicle application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleApplicationId the primary key of the vehicle application
	* @return the vehicle application that was removed
	* @throws PortalException if a vehicle application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleApplication deleteVehicleApplication(
		long vehicleApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.deleteVehicleApplication(vehicleApplicationId);
	}

	/**
	* Deletes the vehicle application from the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleApplication the vehicle application
	* @return the vehicle application that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleApplication deleteVehicleApplication(
		com.justonetech.oa.model.VehicleApplication vehicleApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.deleteVehicleApplication(vehicleApplication);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vehicleApplicationLocalService.dynamicQuery();
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
		return _vehicleApplicationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vehicleApplicationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vehicleApplicationLocalService.dynamicQuery(dynamicQuery,
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
		return _vehicleApplicationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vehicleApplicationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.VehicleApplication fetchVehicleApplication(
		long vehicleApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.fetchVehicleApplication(vehicleApplicationId);
	}

	/**
	* Returns the vehicle application with the primary key.
	*
	* @param vehicleApplicationId the primary key of the vehicle application
	* @return the vehicle application
	* @throws PortalException if a vehicle application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleApplication getVehicleApplication(
		long vehicleApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.getVehicleApplication(vehicleApplicationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vehicle applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vehicle applications
	* @param end the upper bound of the range of vehicle applications (not inclusive)
	* @return the range of vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.VehicleApplication> getVehicleApplications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.getVehicleApplications(start, end);
	}

	/**
	* Returns the number of vehicle applications.
	*
	* @return the number of vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVehicleApplicationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.getVehicleApplicationsCount();
	}

	/**
	* Updates the vehicle application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vehicleApplication the vehicle application
	* @return the vehicle application that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleApplication updateVehicleApplication(
		com.justonetech.oa.model.VehicleApplication vehicleApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.updateVehicleApplication(vehicleApplication);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vehicleApplicationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vehicleApplicationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vehicleApplicationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.VehicleApplication> findByApplicantName(
		java.lang.String applicantName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.findByApplicantName(applicantName,
			start, end);
	}

	@Override
	public int countByName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleApplicationLocalService.countByName(applicantName);
	}

	@Override
	public void deleteVehicleApplications(
		java.lang.String[] vehicleApplicationIds) {
		_vehicleApplicationLocalService.deleteVehicleApplications(vehicleApplicationIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VehicleApplicationLocalService getWrappedVehicleApplicationLocalService() {
		return _vehicleApplicationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVehicleApplicationLocalService(
		VehicleApplicationLocalService vehicleApplicationLocalService) {
		_vehicleApplicationLocalService = vehicleApplicationLocalService;
	}

	@Override
	public VehicleApplicationLocalService getWrappedService() {
		return _vehicleApplicationLocalService;
	}

	@Override
	public void setWrappedService(
		VehicleApplicationLocalService vehicleApplicationLocalService) {
		_vehicleApplicationLocalService = vehicleApplicationLocalService;
	}

	private VehicleApplicationLocalService _vehicleApplicationLocalService;
}