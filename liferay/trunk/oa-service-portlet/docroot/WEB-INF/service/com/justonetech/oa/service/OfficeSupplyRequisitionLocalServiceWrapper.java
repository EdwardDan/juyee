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
 * Provides a wrapper for {@link OfficeSupplyRequisitionLocalService}.
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionLocalService
 * @generated
 */
public class OfficeSupplyRequisitionLocalServiceWrapper
	implements OfficeSupplyRequisitionLocalService,
		ServiceWrapper<OfficeSupplyRequisitionLocalService> {
	public OfficeSupplyRequisitionLocalServiceWrapper(
		OfficeSupplyRequisitionLocalService officeSupplyRequisitionLocalService) {
		_officeSupplyRequisitionLocalService = officeSupplyRequisitionLocalService;
	}

	/**
	* Adds the office supply requisition to the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisition the office supply requisition
	* @return the office supply requisition that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition addOfficeSupplyRequisition(
		com.justonetech.oa.model.OfficeSupplyRequisition officeSupplyRequisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.addOfficeSupplyRequisition(officeSupplyRequisition);
	}

	/**
	* Creates a new office supply requisition with the primary key. Does not add the office supply requisition to the database.
	*
	* @param officeSupplyRequisitionId the primary key for the new office supply requisition
	* @return the new office supply requisition
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition createOfficeSupplyRequisition(
		long officeSupplyRequisitionId) {
		return _officeSupplyRequisitionLocalService.createOfficeSupplyRequisition(officeSupplyRequisitionId);
	}

	/**
	* Deletes the office supply requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionId the primary key of the office supply requisition
	* @return the office supply requisition that was removed
	* @throws PortalException if a office supply requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition deleteOfficeSupplyRequisition(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.deleteOfficeSupplyRequisition(officeSupplyRequisitionId);
	}

	/**
	* Deletes the office supply requisition from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisition the office supply requisition
	* @return the office supply requisition that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition deleteOfficeSupplyRequisition(
		com.justonetech.oa.model.OfficeSupplyRequisition officeSupplyRequisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.deleteOfficeSupplyRequisition(officeSupplyRequisition);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _officeSupplyRequisitionLocalService.dynamicQuery();
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
		return _officeSupplyRequisitionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyRequisitionLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyRequisitionLocalService.dynamicQuery(dynamicQuery,
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
		return _officeSupplyRequisitionLocalService.dynamicQueryCount(dynamicQuery);
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
		return _officeSupplyRequisitionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition fetchOfficeSupplyRequisition(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.fetchOfficeSupplyRequisition(officeSupplyRequisitionId);
	}

	/**
	* Returns the office supply requisition with the primary key.
	*
	* @param officeSupplyRequisitionId the primary key of the office supply requisition
	* @return the office supply requisition
	* @throws PortalException if a office supply requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition getOfficeSupplyRequisition(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.getOfficeSupplyRequisition(officeSupplyRequisitionId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the office supply requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply requisitions
	* @param end the upper bound of the range of office supply requisitions (not inclusive)
	* @return the range of office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> getOfficeSupplyRequisitions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.getOfficeSupplyRequisitions(start,
			end);
	}

	/**
	* Returns the number of office supply requisitions.
	*
	* @return the number of office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOfficeSupplyRequisitionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.getOfficeSupplyRequisitionsCount();
	}

	/**
	* Updates the office supply requisition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisition the office supply requisition
	* @return the office supply requisition that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisition updateOfficeSupplyRequisition(
		com.justonetech.oa.model.OfficeSupplyRequisition officeSupplyRequisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.updateOfficeSupplyRequisition(officeSupplyRequisition);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _officeSupplyRequisitionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_officeSupplyRequisitionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _officeSupplyRequisitionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.findByOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

	@Override
	public int countByOfficeSupplyRequisitionId(long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.countByOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.findByUserId(userId, start,
			end);
	}

	@Override
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionLocalService.countByUserId(userId);
	}

	@Override
	public void deleteOfficeSupplyRequisitions(
		java.lang.String[] officeSupplyRequisitionIds) {
		_officeSupplyRequisitionLocalService.deleteOfficeSupplyRequisitions(officeSupplyRequisitionIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OfficeSupplyRequisitionLocalService getWrappedOfficeSupplyRequisitionLocalService() {
		return _officeSupplyRequisitionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOfficeSupplyRequisitionLocalService(
		OfficeSupplyRequisitionLocalService officeSupplyRequisitionLocalService) {
		_officeSupplyRequisitionLocalService = officeSupplyRequisitionLocalService;
	}

	@Override
	public OfficeSupplyRequisitionLocalService getWrappedService() {
		return _officeSupplyRequisitionLocalService;
	}

	@Override
	public void setWrappedService(
		OfficeSupplyRequisitionLocalService officeSupplyRequisitionLocalService) {
		_officeSupplyRequisitionLocalService = officeSupplyRequisitionLocalService;
	}

	private OfficeSupplyRequisitionLocalService _officeSupplyRequisitionLocalService;
}