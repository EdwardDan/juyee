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
 * Provides a wrapper for {@link DispatchLocalService}.
 *
 * @author justonetech
 * @see DispatchLocalService
 * @generated
 */
public class DispatchLocalServiceWrapper implements DispatchLocalService,
	ServiceWrapper<DispatchLocalService> {
	public DispatchLocalServiceWrapper(
		DispatchLocalService dispatchLocalService) {
		_dispatchLocalService = dispatchLocalService;
	}

	/**
	* Adds the dispatch to the database. Also notifies the appropriate model listeners.
	*
	* @param dispatch the dispatch
	* @return the dispatch that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.Dispatch addDispatch(
		com.justonetech.oa.model.Dispatch dispatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.addDispatch(dispatch);
	}

	/**
	* Creates a new dispatch with the primary key. Does not add the dispatch to the database.
	*
	* @param dispatchId the primary key for the new dispatch
	* @return the new dispatch
	*/
	@Override
	public com.justonetech.oa.model.Dispatch createDispatch(long dispatchId) {
		return _dispatchLocalService.createDispatch(dispatchId);
	}

	/**
	* Deletes the dispatch with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch that was removed
	* @throws PortalException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.Dispatch deleteDispatch(long dispatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.deleteDispatch(dispatchId);
	}

	/**
	* Deletes the dispatch from the database. Also notifies the appropriate model listeners.
	*
	* @param dispatch the dispatch
	* @return the dispatch that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.Dispatch deleteDispatch(
		com.justonetech.oa.model.Dispatch dispatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.deleteDispatch(dispatch);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dispatchLocalService.dynamicQuery();
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
		return _dispatchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dispatchLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dispatchLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _dispatchLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dispatchLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.oa.model.Dispatch fetchDispatch(long dispatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.fetchDispatch(dispatchId);
	}

	/**
	* Returns the dispatch with the primary key.
	*
	* @param dispatchId the primary key of the dispatch
	* @return the dispatch
	* @throws PortalException if a dispatch with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.Dispatch getDispatch(long dispatchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.getDispatch(dispatchId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dispatchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dispatchs
	* @param end the upper bound of the range of dispatchs (not inclusive)
	* @return the range of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.Dispatch> getDispatchs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.getDispatchs(start, end);
	}

	/**
	* Returns the number of dispatchs.
	*
	* @return the number of dispatchs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDispatchsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.getDispatchsCount();
	}

	/**
	* Updates the dispatch in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dispatch the dispatch
	* @return the dispatch that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.Dispatch updateDispatch(
		com.justonetech.oa.model.Dispatch dispatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.updateDispatch(dispatch);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dispatchLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dispatchLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dispatchLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.Dispatch> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.findByTitle(title, start, end);
	}

	@Override
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dispatchLocalService.countByTitle(title);
	}

	@Override
	public void deleteDispatchs(java.lang.String[] dispatchIds) {
		_dispatchLocalService.deleteDispatchs(dispatchIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DispatchLocalService getWrappedDispatchLocalService() {
		return _dispatchLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDispatchLocalService(
		DispatchLocalService dispatchLocalService) {
		_dispatchLocalService = dispatchLocalService;
	}

	@Override
	public DispatchLocalService getWrappedService() {
		return _dispatchLocalService;
	}

	@Override
	public void setWrappedService(DispatchLocalService dispatchLocalService) {
		_dispatchLocalService = dispatchLocalService;
	}

	private DispatchLocalService _dispatchLocalService;
}