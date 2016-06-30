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
 * Provides a wrapper for {@link VehicleRequisitionLocalService}.
 *
 * @author justonetech
 * @see VehicleRequisitionLocalService
 * @generated
 */
public class VehicleRequisitionLocalServiceWrapper
	implements VehicleRequisitionLocalService,
		ServiceWrapper<VehicleRequisitionLocalService> {
	public VehicleRequisitionLocalServiceWrapper(
		VehicleRequisitionLocalService vehicleRequisitionLocalService) {
		_vehicleRequisitionLocalService = vehicleRequisitionLocalService;
	}

	/**
	* Adds the vehicle requisition to the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleRequisition the vehicle requisition
	* @return the vehicle requisition that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleRequisition addVehicleRequisition(
		com.justonetech.oa.model.VehicleRequisition vehicleRequisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.addVehicleRequisition(vehicleRequisition);
	}

	/**
	* Creates a new vehicle requisition with the primary key. Does not add the vehicle requisition to the database.
	*
	* @param vehicleRequisitionId the primary key for the new vehicle requisition
	* @return the new vehicle requisition
	*/
	@Override
	public com.justonetech.oa.model.VehicleRequisition createVehicleRequisition(
		long vehicleRequisitionId) {
		return _vehicleRequisitionLocalService.createVehicleRequisition(vehicleRequisitionId);
	}

	/**
	* Deletes the vehicle requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleRequisitionId the primary key of the vehicle requisition
	* @return the vehicle requisition that was removed
	* @throws PortalException if a vehicle requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleRequisition deleteVehicleRequisition(
		long vehicleRequisitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.deleteVehicleRequisition(vehicleRequisitionId);
	}

	/**
	* Deletes the vehicle requisition from the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleRequisition the vehicle requisition
	* @return the vehicle requisition that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleRequisition deleteVehicleRequisition(
		com.justonetech.oa.model.VehicleRequisition vehicleRequisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.deleteVehicleRequisition(vehicleRequisition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vehicleRequisitionLocalService.dynamicQuery();
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
		return _vehicleRequisitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vehicleRequisitionLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vehicleRequisitionLocalService.dynamicQuery(dynamicQuery,
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
		return _vehicleRequisitionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vehicleRequisitionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.VehicleRequisition fetchVehicleRequisition(
		long vehicleRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.fetchVehicleRequisition(vehicleRequisitionId);
	}

	/**
	* Returns the vehicle requisition with the primary key.
	*
	* @param vehicleRequisitionId the primary key of the vehicle requisition
	* @return the vehicle requisition
	* @throws PortalException if a vehicle requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleRequisition getVehicleRequisition(
		long vehicleRequisitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.getVehicleRequisition(vehicleRequisitionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vehicle requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vehicle requisitions
	* @param end the upper bound of the range of vehicle requisitions (not inclusive)
	* @return the range of vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.VehicleRequisition> getVehicleRequisitions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.getVehicleRequisitions(start, end);
	}

	/**
	* Returns the number of vehicle requisitions.
	*
	* @return the number of vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVehicleRequisitionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.getVehicleRequisitionsCount();
	}

	/**
	* Updates the vehicle requisition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vehicleRequisition the vehicle requisition
	* @return the vehicle requisition that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.VehicleRequisition updateVehicleRequisition(
		com.justonetech.oa.model.VehicleRequisition vehicleRequisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.updateVehicleRequisition(vehicleRequisition);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vehicleRequisitionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vehicleRequisitionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vehicleRequisitionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.VehicleRequisition> findByApplicantName(
		java.lang.String applicantName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.findByApplicantName(applicantName,
			start, end);
	}

	@Override
	public int countByName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vehicleRequisitionLocalService.countByName(applicantName);
	}

	@Override
	public void deleteVehicleRequisitions(
		java.lang.String[] vehicleRequisitionIds) {
		_vehicleRequisitionLocalService.deleteVehicleRequisitions(vehicleRequisitionIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VehicleRequisitionLocalService getWrappedVehicleRequisitionLocalService() {
		return _vehicleRequisitionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVehicleRequisitionLocalService(
		VehicleRequisitionLocalService vehicleRequisitionLocalService) {
		_vehicleRequisitionLocalService = vehicleRequisitionLocalService;
	}

	@Override
	public VehicleRequisitionLocalService getWrappedService() {
		return _vehicleRequisitionLocalService;
	}

	@Override
	public void setWrappedService(
		VehicleRequisitionLocalService vehicleRequisitionLocalService) {
		_vehicleRequisitionLocalService = vehicleRequisitionLocalService;
	}

	private VehicleRequisitionLocalService _vehicleRequisitionLocalService;
}