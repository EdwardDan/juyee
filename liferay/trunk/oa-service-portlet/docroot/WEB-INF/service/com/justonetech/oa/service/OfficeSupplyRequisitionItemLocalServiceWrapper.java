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
 * Provides a wrapper for {@link OfficeSupplyRequisitionItemLocalService}.
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionItemLocalService
 * @generated
 */
public class OfficeSupplyRequisitionItemLocalServiceWrapper
	implements OfficeSupplyRequisitionItemLocalService,
		ServiceWrapper<OfficeSupplyRequisitionItemLocalService> {
	public OfficeSupplyRequisitionItemLocalServiceWrapper(
		OfficeSupplyRequisitionItemLocalService officeSupplyRequisitionItemLocalService) {
		_officeSupplyRequisitionItemLocalService = officeSupplyRequisitionItemLocalService;
	}

	/**
	* Adds the office supply requisition item to the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionItem the office supply requisition item
	* @return the office supply requisition item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem addOfficeSupplyRequisitionItem(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.addOfficeSupplyRequisitionItem(officeSupplyRequisitionItem);
	}

	/**
	* Creates a new office supply requisition item with the primary key. Does not add the office supply requisition item to the database.
	*
	* @param officeSupplyRequisitionItemId the primary key for the new office supply requisition item
	* @return the new office supply requisition item
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem createOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId) {
		return _officeSupplyRequisitionItemLocalService.createOfficeSupplyRequisitionItem(officeSupplyRequisitionItemId);
	}

	/**
	* Deletes the office supply requisition item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item that was removed
	* @throws PortalException if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem deleteOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.deleteOfficeSupplyRequisitionItem(officeSupplyRequisitionItemId);
	}

	/**
	* Deletes the office supply requisition item from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionItem the office supply requisition item
	* @return the office supply requisition item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem deleteOfficeSupplyRequisitionItem(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.deleteOfficeSupplyRequisitionItem(officeSupplyRequisitionItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _officeSupplyRequisitionItemLocalService.dynamicQuery();
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
		return _officeSupplyRequisitionItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyRequisitionItemLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyRequisitionItemLocalService.dynamicQuery(dynamicQuery,
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
		return _officeSupplyRequisitionItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _officeSupplyRequisitionItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem fetchOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.fetchOfficeSupplyRequisitionItem(officeSupplyRequisitionItemId);
	}

	/**
	* Returns the office supply requisition item with the primary key.
	*
	* @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	* @return the office supply requisition item
	* @throws PortalException if a office supply requisition item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem getOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.getOfficeSupplyRequisitionItem(officeSupplyRequisitionItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the office supply requisition items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply requisition items
	* @param end the upper bound of the range of office supply requisition items (not inclusive)
	* @return the range of office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisitionItem> getOfficeSupplyRequisitionItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.getOfficeSupplyRequisitionItems(start,
			end);
	}

	/**
	* Returns the number of office supply requisition items.
	*
	* @return the number of office supply requisition items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOfficeSupplyRequisitionItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.getOfficeSupplyRequisitionItemsCount();
	}

	/**
	* Updates the office supply requisition item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionItem the office supply requisition item
	* @return the office supply requisition item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyRequisitionItem updateOfficeSupplyRequisitionItem(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyRequisitionItemLocalService.updateOfficeSupplyRequisitionItem(officeSupplyRequisitionItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _officeSupplyRequisitionItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_officeSupplyRequisitionItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _officeSupplyRequisitionItemLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OfficeSupplyRequisitionItemLocalService getWrappedOfficeSupplyRequisitionItemLocalService() {
		return _officeSupplyRequisitionItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOfficeSupplyRequisitionItemLocalService(
		OfficeSupplyRequisitionItemLocalService officeSupplyRequisitionItemLocalService) {
		_officeSupplyRequisitionItemLocalService = officeSupplyRequisitionItemLocalService;
	}

	@Override
	public OfficeSupplyRequisitionItemLocalService getWrappedService() {
		return _officeSupplyRequisitionItemLocalService;
	}

	@Override
	public void setWrappedService(
		OfficeSupplyRequisitionItemLocalService officeSupplyRequisitionItemLocalService) {
		_officeSupplyRequisitionItemLocalService = officeSupplyRequisitionItemLocalService;
	}

	private OfficeSupplyRequisitionItemLocalService _officeSupplyRequisitionItemLocalService;
}