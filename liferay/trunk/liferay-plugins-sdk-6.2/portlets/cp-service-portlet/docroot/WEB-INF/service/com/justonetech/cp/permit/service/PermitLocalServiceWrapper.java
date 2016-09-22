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

package com.justonetech.cp.permit.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PermitLocalService}.
 *
 * @author fanqi
 * @see PermitLocalService
 * @generated
 */
public class PermitLocalServiceWrapper implements PermitLocalService,
	ServiceWrapper<PermitLocalService> {
	public PermitLocalServiceWrapper(PermitLocalService permitLocalService) {
		_permitLocalService = permitLocalService;
	}

	/**
	* Adds the permit to the database. Also notifies the appropriate model listeners.
	*
	* @param permit the permit
	* @return the permit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.Permit addPermit(
		com.justonetech.cp.permit.model.Permit permit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.addPermit(permit);
	}

	/**
	* Creates a new permit with the primary key. Does not add the permit to the database.
	*
	* @param permitId the primary key for the new permit
	* @return the new permit
	*/
	@Override
	public com.justonetech.cp.permit.model.Permit createPermit(long permitId) {
		return _permitLocalService.createPermit(permitId);
	}

	/**
	* Deletes the permit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param permitId the primary key of the permit
	* @return the permit that was removed
	* @throws PortalException if a permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.Permit deletePermit(long permitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.deletePermit(permitId);
	}

	/**
	* Deletes the permit from the database. Also notifies the appropriate model listeners.
	*
	* @param permit the permit
	* @return the permit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.Permit deletePermit(
		com.justonetech.cp.permit.model.Permit permit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.deletePermit(permit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _permitLocalService.dynamicQuery();
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
		return _permitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.PermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _permitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.PermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _permitLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _permitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _permitLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.cp.permit.model.Permit fetchPermit(long permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.fetchPermit(permitId);
	}

	/**
	* Returns the permit with the primary key.
	*
	* @param permitId the primary key of the permit
	* @return the permit
	* @throws PortalException if a permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.Permit getPermit(long permitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.getPermit(permitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the permits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.PermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of permits
	* @param end the upper bound of the range of permits (not inclusive)
	* @return the range of permits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.permit.model.Permit> getPermits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.getPermits(start, end);
	}

	/**
	* Returns the number of permits.
	*
	* @return the number of permits
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPermitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.getPermitsCount();
	}

	/**
	* Updates the permit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param permit the permit
	* @return the permit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.Permit updatePermit(
		com.justonetech.cp.permit.model.Permit permit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permitLocalService.updatePermit(permit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _permitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_permitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _permitLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.cp.permit.model.Permit> getPermits(
		java.lang.String zzjgdm, java.lang.String bjbh,
		java.lang.String wssqbh, java.lang.String gcmc, int start, int end) {
		return _permitLocalService.getPermits(zzjgdm, bjbh, wssqbh, gcmc,
			start, end);
	}

	@Override
	public java.util.List<com.justonetech.cp.permit.model.Permit> getPermits(
		java.lang.String ywbh, java.lang.String bjbh, java.lang.String gcmc,
		java.lang.Long xmlx, java.lang.String jsdwmc, java.lang.String status,
		java.lang.String gs, int start, int end) {
		return _permitLocalService.getPermits(ywbh, bjbh, gcmc, xmlx, jsdwmc,
			status, gs, start, end);
	}

	@Override
	public int getPermitsCount(java.lang.String zzjgdm, java.lang.String bjbh,
		java.lang.String wssqbh, java.lang.String gcmc) {
		return _permitLocalService.getPermitsCount(zzjgdm, bjbh, wssqbh, gcmc);
	}

	@Override
	public int getPermitsCount(java.lang.String ywbh, java.lang.String bjbh,
		java.lang.String gcmc, java.lang.Long xmlx, java.lang.String jsdwmc,
		java.lang.String status, java.lang.String gs) {
		return _permitLocalService.getPermitsCount(ywbh, bjbh, gcmc, xmlx,
			jsdwmc, status, gs);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		java.lang.String zzjgdm, java.lang.String bjbh,
		java.lang.String wssqbh, java.lang.String gcmc) {
		return _permitLocalService.createDynamicQuery(zzjgdm, bjbh, wssqbh, gcmc);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		java.lang.String ywbh, java.lang.String bjbh, java.lang.String gcmc,
		java.lang.Long xmlx, java.lang.String jsdwmc, java.lang.String status,
		java.lang.String gs) {
		return _permitLocalService.createDynamicQuery(ywbh, bjbh, gcmc, xmlx,
			jsdwmc, status, gs);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PermitLocalService getWrappedPermitLocalService() {
		return _permitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPermitLocalService(
		PermitLocalService permitLocalService) {
		_permitLocalService = permitLocalService;
	}

	@Override
	public PermitLocalService getWrappedService() {
		return _permitLocalService;
	}

	@Override
	public void setWrappedService(PermitLocalService permitLocalService) {
		_permitLocalService = permitLocalService;
	}

	private PermitLocalService _permitLocalService;
}