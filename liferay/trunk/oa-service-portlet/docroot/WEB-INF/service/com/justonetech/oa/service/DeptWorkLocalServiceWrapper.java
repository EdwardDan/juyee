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
 * Provides a wrapper for {@link DeptWorkLocalService}.
 *
 * @author justonetech
 * @see DeptWorkLocalService
 * @generated
 */
public class DeptWorkLocalServiceWrapper implements DeptWorkLocalService,
	ServiceWrapper<DeptWorkLocalService> {
	public DeptWorkLocalServiceWrapper(
		DeptWorkLocalService deptWorkLocalService) {
		_deptWorkLocalService = deptWorkLocalService;
	}

	/**
	* Adds the dept work to the database. Also notifies the appropriate model listeners.
	*
	* @param deptWork the dept work
	* @return the dept work that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.DeptWork addDeptWork(
		com.justonetech.oa.model.DeptWork deptWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.addDeptWork(deptWork);
	}

	/**
	* Creates a new dept work with the primary key. Does not add the dept work to the database.
	*
	* @param deptWorkId the primary key for the new dept work
	* @return the new dept work
	*/
	@Override
	public com.justonetech.oa.model.DeptWork createDeptWork(long deptWorkId) {
		return _deptWorkLocalService.createDeptWork(deptWorkId);
	}

	/**
	* Deletes the dept work with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deptWorkId the primary key of the dept work
	* @return the dept work that was removed
	* @throws PortalException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.DeptWork deleteDeptWork(long deptWorkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.deleteDeptWork(deptWorkId);
	}

	/**
	* Deletes the dept work from the database. Also notifies the appropriate model listeners.
	*
	* @param deptWork the dept work
	* @return the dept work that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.DeptWork deleteDeptWork(
		com.justonetech.oa.model.DeptWork deptWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.deleteDeptWork(deptWork);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _deptWorkLocalService.dynamicQuery();
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
		return _deptWorkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _deptWorkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _deptWorkLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _deptWorkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _deptWorkLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.oa.model.DeptWork fetchDeptWork(long deptWorkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.fetchDeptWork(deptWorkId);
	}

	/**
	* Returns the dept work with the primary key.
	*
	* @param deptWorkId the primary key of the dept work
	* @return the dept work
	* @throws PortalException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.DeptWork getDeptWork(long deptWorkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getDeptWork(deptWorkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dept works.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @return the range of dept works
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.DeptWork> getDeptWorks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getDeptWorks(start, end);
	}

	/**
	* Returns the number of dept works.
	*
	* @return the number of dept works
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDeptWorksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getDeptWorksCount();
	}

	/**
	* Updates the dept work in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param deptWork the dept work
	* @return the dept work that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.DeptWork updateDeptWork(
		com.justonetech.oa.model.DeptWork deptWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.updateDeptWork(deptWork);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _deptWorkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_deptWorkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _deptWorkLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.DeptWork> getDeptWorksByUserName(
		java.lang.String userName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getDeptWorksByUserName(userName, start, end);
	}

	@Override
	public int getDeptWorksCountByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getDeptWorksCountByUserName(userName);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.DeptWork> getDeptWorksByDeptName(
		java.lang.String deptName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getDeptWorksByDeptName(deptName, start, end);
	}

	@Override
	public int getDeptWorksCountByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deptWorkLocalService.getDeptWorksCountByDeptName(deptName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeptWorkLocalService getWrappedDeptWorkLocalService() {
		return _deptWorkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeptWorkLocalService(
		DeptWorkLocalService deptWorkLocalService) {
		_deptWorkLocalService = deptWorkLocalService;
	}

	@Override
	public DeptWorkLocalService getWrappedService() {
		return _deptWorkLocalService;
	}

	@Override
	public void setWrappedService(DeptWorkLocalService deptWorkLocalService) {
		_deptWorkLocalService = deptWorkLocalService;
	}

	private DeptWorkLocalService _deptWorkLocalService;
}