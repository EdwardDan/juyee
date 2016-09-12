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
 * Provides a wrapper for {@link CompleteLocalService}.
 *
 * @author fanqi
 * @see CompleteLocalService
 * @generated
 */
public class CompleteLocalServiceWrapper implements CompleteLocalService,
	ServiceWrapper<CompleteLocalService> {
	public CompleteLocalServiceWrapper(
		CompleteLocalService completeLocalService) {
		_completeLocalService = completeLocalService;
	}

	/**
	* Adds the complete to the database. Also notifies the appropriate model listeners.
	*
	* @param complete the complete
	* @return the complete that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.Complete addComplete(
		com.justonetech.cp.complete.model.Complete complete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.addComplete(complete);
	}

	/**
	* Creates a new complete with the primary key. Does not add the complete to the database.
	*
	* @param completeId the primary key for the new complete
	* @return the new complete
	*/
	@Override
	public com.justonetech.cp.complete.model.Complete createComplete(
		long completeId) {
		return _completeLocalService.createComplete(completeId);
	}

	/**
	* Deletes the complete with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param completeId the primary key of the complete
	* @return the complete that was removed
	* @throws PortalException if a complete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.Complete deleteComplete(
		long completeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.deleteComplete(completeId);
	}

	/**
	* Deletes the complete from the database. Also notifies the appropriate model listeners.
	*
	* @param complete the complete
	* @return the complete that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.Complete deleteComplete(
		com.justonetech.cp.complete.model.Complete complete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.deleteComplete(complete);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _completeLocalService.dynamicQuery();
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
		return _completeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _completeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _completeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _completeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _completeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.cp.complete.model.Complete fetchComplete(
		long completeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.fetchComplete(completeId);
	}

	/**
	* Returns the complete with the primary key.
	*
	* @param completeId the primary key of the complete
	* @return the complete
	* @throws PortalException if a complete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.Complete getComplete(
		long completeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.getComplete(completeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the completes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of completes
	* @param end the upper bound of the range of completes (not inclusive)
	* @return the range of completes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.complete.model.Complete> getCompletes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.getCompletes(start, end);
	}

	/**
	* Returns the number of completes.
	*
	* @return the number of completes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCompletesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.getCompletesCount();
	}

	/**
	* Updates the complete in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param complete the complete
	* @return the complete that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.Complete updateComplete(
		com.justonetech.cp.complete.model.Complete complete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeLocalService.updateComplete(complete);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _completeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_completeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _completeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CompleteLocalService getWrappedCompleteLocalService() {
		return _completeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCompleteLocalService(
		CompleteLocalService completeLocalService) {
		_completeLocalService = completeLocalService;
	}

	@Override
	public CompleteLocalService getWrappedService() {
		return _completeLocalService;
	}

	@Override
	public void setWrappedService(CompleteLocalService completeLocalService) {
		_completeLocalService = completeLocalService;
	}

	private CompleteLocalService _completeLocalService;
}