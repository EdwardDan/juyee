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
 * Provides a wrapper for {@link OfficeSupplyApplyItemLocalService}.
 *
 * @author justonetech
 * @see OfficeSupplyApplyItemLocalService
 * @generated
 */
public class OfficeSupplyApplyItemLocalServiceWrapper
	implements OfficeSupplyApplyItemLocalService,
		ServiceWrapper<OfficeSupplyApplyItemLocalService> {
	public OfficeSupplyApplyItemLocalServiceWrapper(
		OfficeSupplyApplyItemLocalService officeSupplyApplyItemLocalService) {
		_officeSupplyApplyItemLocalService = officeSupplyApplyItemLocalService;
	}

	/**
	* Adds the office supply apply item to the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplyItem the office supply apply item
	* @return the office supply apply item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem addOfficeSupplyApplyItem(
		com.justonetech.oa.model.OfficeSupplyApplyItem officeSupplyApplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.addOfficeSupplyApplyItem(officeSupplyApplyItem);
	}

	/**
	* Creates a new office supply apply item with the primary key. Does not add the office supply apply item to the database.
	*
	* @param officeSupplyApplyItemId the primary key for the new office supply apply item
	* @return the new office supply apply item
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem createOfficeSupplyApplyItem(
		long officeSupplyApplyItemId) {
		return _officeSupplyApplyItemLocalService.createOfficeSupplyApplyItem(officeSupplyApplyItemId);
	}

	/**
	* Deletes the office supply apply item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplyItemId the primary key of the office supply apply item
	* @return the office supply apply item that was removed
	* @throws PortalException if a office supply apply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem deleteOfficeSupplyApplyItem(
		long officeSupplyApplyItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.deleteOfficeSupplyApplyItem(officeSupplyApplyItemId);
	}

	/**
	* Deletes the office supply apply item from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplyItem the office supply apply item
	* @return the office supply apply item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem deleteOfficeSupplyApplyItem(
		com.justonetech.oa.model.OfficeSupplyApplyItem officeSupplyApplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.deleteOfficeSupplyApplyItem(officeSupplyApplyItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _officeSupplyApplyItemLocalService.dynamicQuery();
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
		return _officeSupplyApplyItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyApplyItemLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyApplyItemLocalService.dynamicQuery(dynamicQuery,
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
		return _officeSupplyApplyItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _officeSupplyApplyItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem fetchOfficeSupplyApplyItem(
		long officeSupplyApplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.fetchOfficeSupplyApplyItem(officeSupplyApplyItemId);
	}

	/**
	* Returns the office supply apply item with the primary key.
	*
	* @param officeSupplyApplyItemId the primary key of the office supply apply item
	* @return the office supply apply item
	* @throws PortalException if a office supply apply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem getOfficeSupplyApplyItem(
		long officeSupplyApplyItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.getOfficeSupplyApplyItem(officeSupplyApplyItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the office supply apply items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply apply items
	* @param end the upper bound of the range of office supply apply items (not inclusive)
	* @return the range of office supply apply items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyApplyItem> getOfficeSupplyApplyItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.getOfficeSupplyApplyItems(start,
			end);
	}

	/**
	* Returns the number of office supply apply items.
	*
	* @return the number of office supply apply items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOfficeSupplyApplyItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.getOfficeSupplyApplyItemsCount();
	}

	/**
	* Updates the office supply apply item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplyItem the office supply apply item
	* @return the office supply apply item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApplyItem updateOfficeSupplyApplyItem(
		com.justonetech.oa.model.OfficeSupplyApplyItem officeSupplyApplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyItemLocalService.updateOfficeSupplyApplyItem(officeSupplyApplyItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _officeSupplyApplyItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_officeSupplyApplyItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _officeSupplyApplyItemLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OfficeSupplyApplyItemLocalService getWrappedOfficeSupplyApplyItemLocalService() {
		return _officeSupplyApplyItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOfficeSupplyApplyItemLocalService(
		OfficeSupplyApplyItemLocalService officeSupplyApplyItemLocalService) {
		_officeSupplyApplyItemLocalService = officeSupplyApplyItemLocalService;
	}

	@Override
	public OfficeSupplyApplyItemLocalService getWrappedService() {
		return _officeSupplyApplyItemLocalService;
	}

	@Override
	public void setWrappedService(
		OfficeSupplyApplyItemLocalService officeSupplyApplyItemLocalService) {
		_officeSupplyApplyItemLocalService = officeSupplyApplyItemLocalService;
	}

	private OfficeSupplyApplyItemLocalService _officeSupplyApplyItemLocalService;
}