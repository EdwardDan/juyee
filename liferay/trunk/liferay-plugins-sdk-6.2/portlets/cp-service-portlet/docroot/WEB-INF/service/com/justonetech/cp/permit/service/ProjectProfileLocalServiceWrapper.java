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
 * Provides a wrapper for {@link ProjectProfileLocalService}.
 *
 * @author fanqi
 * @see ProjectProfileLocalService
 * @generated
 */
public class ProjectProfileLocalServiceWrapper
	implements ProjectProfileLocalService,
		ServiceWrapper<ProjectProfileLocalService> {
	public ProjectProfileLocalServiceWrapper(
		ProjectProfileLocalService projectProfileLocalService) {
		_projectProfileLocalService = projectProfileLocalService;
	}

	/**
	* Adds the project profile to the database. Also notifies the appropriate model listeners.
	*
	* @param projectProfile the project profile
	* @return the project profile that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ProjectProfile addProjectProfile(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.addProjectProfile(projectProfile);
	}

	/**
	* Creates a new project profile with the primary key. Does not add the project profile to the database.
	*
	* @param permitId the primary key for the new project profile
	* @return the new project profile
	*/
	@Override
	public com.justonetech.cp.permit.model.ProjectProfile createProjectProfile(
		long permitId) {
		return _projectProfileLocalService.createProjectProfile(permitId);
	}

	/**
	* Deletes the project profile with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile that was removed
	* @throws PortalException if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ProjectProfile deleteProjectProfile(
		long permitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.deleteProjectProfile(permitId);
	}

	/**
	* Deletes the project profile from the database. Also notifies the appropriate model listeners.
	*
	* @param projectProfile the project profile
	* @return the project profile that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ProjectProfile deleteProjectProfile(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.deleteProjectProfile(projectProfile);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectProfileLocalService.dynamicQuery();
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
		return _projectProfileLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectProfileLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _projectProfileLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _projectProfileLocalService.dynamicQueryCount(dynamicQuery);
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
		return _projectProfileLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.cp.permit.model.ProjectProfile fetchProjectProfile(
		long permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.fetchProjectProfile(permitId);
	}

	/**
	* Returns the project profile with the primary key.
	*
	* @param permitId the primary key of the project profile
	* @return the project profile
	* @throws PortalException if a project profile with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ProjectProfile getProjectProfile(
		long permitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.getProjectProfile(permitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the project profiles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of project profiles
	* @param end the upper bound of the range of project profiles (not inclusive)
	* @return the range of project profiles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.permit.model.ProjectProfile> getProjectProfiles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.getProjectProfiles(start, end);
	}

	/**
	* Returns the number of project profiles.
	*
	* @return the number of project profiles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProjectProfilesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.getProjectProfilesCount();
	}

	/**
	* Updates the project profile in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param projectProfile the project profile
	* @return the project profile that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ProjectProfile updateProjectProfile(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _projectProfileLocalService.updateProjectProfile(projectProfile);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _projectProfileLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_projectProfileLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _projectProfileLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProjectProfileLocalService getWrappedProjectProfileLocalService() {
		return _projectProfileLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProjectProfileLocalService(
		ProjectProfileLocalService projectProfileLocalService) {
		_projectProfileLocalService = projectProfileLocalService;
	}

	@Override
	public ProjectProfileLocalService getWrappedService() {
		return _projectProfileLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectProfileLocalService projectProfileLocalService) {
		_projectProfileLocalService = projectProfileLocalService;
	}

	private ProjectProfileLocalService _projectProfileLocalService;
}