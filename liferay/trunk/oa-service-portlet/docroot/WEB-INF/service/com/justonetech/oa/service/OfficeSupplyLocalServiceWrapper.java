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
 * Provides a wrapper for {@link OfficeSupplyLocalService}.
 *
 * @author justonetech
 * @see OfficeSupplyLocalService
 * @generated
 */
public class OfficeSupplyLocalServiceWrapper implements OfficeSupplyLocalService,
	ServiceWrapper<OfficeSupplyLocalService> {
	public OfficeSupplyLocalServiceWrapper(
		OfficeSupplyLocalService officeSupplyLocalService) {
		_officeSupplyLocalService = officeSupplyLocalService;
	}

	/**
	* Adds the office supply to the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupply the office supply
	* @return the office supply that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupply addOfficeSupply(
		com.justonetech.oa.model.OfficeSupply officeSupply)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.addOfficeSupply(officeSupply);
	}

	/**
	* Creates a new office supply with the primary key. Does not add the office supply to the database.
	*
	* @param officeSupplyId the primary key for the new office supply
	* @return the new office supply
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupply createOfficeSupply(
		long officeSupplyId) {
		return _officeSupplyLocalService.createOfficeSupply(officeSupplyId);
	}

	/**
	* Deletes the office supply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyId the primary key of the office supply
	* @return the office supply that was removed
	* @throws PortalException if a office supply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupply deleteOfficeSupply(
		long officeSupplyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.deleteOfficeSupply(officeSupplyId);
	}

	/**
	* Deletes the office supply from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupply the office supply
	* @return the office supply that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupply deleteOfficeSupply(
		com.justonetech.oa.model.OfficeSupply officeSupply)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.deleteOfficeSupply(officeSupply);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _officeSupplyLocalService.dynamicQuery();
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
		return _officeSupplyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _officeSupplyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _officeSupplyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.OfficeSupply fetchOfficeSupply(
		long officeSupplyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.fetchOfficeSupply(officeSupplyId);
	}

	/**
	* Returns the office supply with the primary key.
	*
	* @param officeSupplyId the primary key of the office supply
	* @return the office supply
	* @throws PortalException if a office supply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupply getOfficeSupply(
		long officeSupplyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.getOfficeSupply(officeSupplyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the office supplies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supplies
	* @param end the upper bound of the range of office supplies (not inclusive)
	* @return the range of office supplies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupply> getOfficeSupplies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.getOfficeSupplies(start, end);
	}

	/**
	* Returns the number of office supplies.
	*
	* @return the number of office supplies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOfficeSuppliesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.getOfficeSuppliesCount();
	}

	/**
	* Updates the office supply in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param officeSupply the office supply
	* @return the office supply that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupply updateOfficeSupply(
		com.justonetech.oa.model.OfficeSupply officeSupply)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.updateOfficeSupply(officeSupply);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _officeSupplyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_officeSupplyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _officeSupplyLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupply> getOfficeSuppliesByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.getOfficeSuppliesByName(name, start,
			end);
	}

	@Override
	public int getOfficeSuppliesCountByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyLocalService.getOfficeSuppliesCountByName(name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OfficeSupplyLocalService getWrappedOfficeSupplyLocalService() {
		return _officeSupplyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOfficeSupplyLocalService(
		OfficeSupplyLocalService officeSupplyLocalService) {
		_officeSupplyLocalService = officeSupplyLocalService;
	}

	@Override
	public OfficeSupplyLocalService getWrappedService() {
		return _officeSupplyLocalService;
	}

	@Override
	public void setWrappedService(
		OfficeSupplyLocalService officeSupplyLocalService) {
		_officeSupplyLocalService = officeSupplyLocalService;
	}

	private OfficeSupplyLocalService _officeSupplyLocalService;
}