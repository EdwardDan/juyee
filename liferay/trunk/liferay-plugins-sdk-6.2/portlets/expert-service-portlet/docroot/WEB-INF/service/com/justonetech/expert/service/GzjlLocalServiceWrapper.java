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

package com.justonetech.expert.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GzjlLocalService}.
 *
 * @author fanqi
 * @see GzjlLocalService
 * @generated
 */
public class GzjlLocalServiceWrapper implements GzjlLocalService,
	ServiceWrapper<GzjlLocalService> {
	public GzjlLocalServiceWrapper(GzjlLocalService gzjlLocalService) {
		_gzjlLocalService = gzjlLocalService;
	}

	/**
	* Adds the gzjl to the database. Also notifies the appropriate model listeners.
	*
	* @param gzjl the gzjl
	* @return the gzjl that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Gzjl addGzjl(
		com.justonetech.expert.model.Gzjl gzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.addGzjl(gzjl);
	}

	/**
	* Creates a new gzjl with the primary key. Does not add the gzjl to the database.
	*
	* @param GzjlId the primary key for the new gzjl
	* @return the new gzjl
	*/
	@Override
	public com.justonetech.expert.model.Gzjl createGzjl(long GzjlId) {
		return _gzjlLocalService.createGzjl(GzjlId);
	}

	/**
	* Deletes the gzjl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl that was removed
	* @throws PortalException if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Gzjl deleteGzjl(long GzjlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.deleteGzjl(GzjlId);
	}

	/**
	* Deletes the gzjl from the database. Also notifies the appropriate model listeners.
	*
	* @param gzjl the gzjl
	* @return the gzjl that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Gzjl deleteGzjl(
		com.justonetech.expert.model.Gzjl gzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.deleteGzjl(gzjl);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gzjlLocalService.dynamicQuery();
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
		return _gzjlLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gzjlLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _gzjlLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _gzjlLocalService.dynamicQueryCount(dynamicQuery);
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
		return _gzjlLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.expert.model.Gzjl fetchGzjl(long GzjlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.fetchGzjl(GzjlId);
	}

	/**
	* Returns the gzjl with the primary key.
	*
	* @param GzjlId the primary key of the gzjl
	* @return the gzjl
	* @throws PortalException if a gzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Gzjl getGzjl(long GzjlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.getGzjl(GzjlId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the gzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of gzjls
	* @param end the upper bound of the range of gzjls (not inclusive)
	* @return the range of gzjls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.expert.model.Gzjl> getGzjls(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.getGzjls(start, end);
	}

	/**
	* Returns the number of gzjls.
	*
	* @return the number of gzjls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGzjlsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.getGzjlsCount();
	}

	/**
	* Updates the gzjl in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param gzjl the gzjl
	* @return the gzjl that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Gzjl updateGzjl(
		com.justonetech.expert.model.Gzjl gzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gzjlLocalService.updateGzjl(gzjl);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _gzjlLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_gzjlLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _gzjlLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.expert.model.Gzjl> getGzjls(
		long expertId, int start, int end) {
		return _gzjlLocalService.getGzjls(expertId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		long expertId) {
		return _gzjlLocalService.createDynamicQuery(expertId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GzjlLocalService getWrappedGzjlLocalService() {
		return _gzjlLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGzjlLocalService(GzjlLocalService gzjlLocalService) {
		_gzjlLocalService = gzjlLocalService;
	}

	@Override
	public GzjlLocalService getWrappedService() {
		return _gzjlLocalService;
	}

	@Override
	public void setWrappedService(GzjlLocalService gzjlLocalService) {
		_gzjlLocalService = gzjlLocalService;
	}

	private GzjlLocalService _gzjlLocalService;
}