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
 * Provides a wrapper for {@link LeaderWorkLocalService}.
 *
 * @author justonetech
 * @see LeaderWorkLocalService
 * @generated
 */
public class LeaderWorkLocalServiceWrapper implements LeaderWorkLocalService,
	ServiceWrapper<LeaderWorkLocalService> {
	public LeaderWorkLocalServiceWrapper(
		LeaderWorkLocalService leaderWorkLocalService) {
		_leaderWorkLocalService = leaderWorkLocalService;
	}

	/**
	* Adds the leader work to the database. Also notifies the appropriate model listeners.
	*
	* @param leaderWork the leader work
	* @return the leader work that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.LeaderWork addLeaderWork(
		com.justonetech.oa.model.LeaderWork leaderWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.addLeaderWork(leaderWork);
	}

	/**
	* Creates a new leader work with the primary key. Does not add the leader work to the database.
	*
	* @param leaderWorkPK the primary key for the new leader work
	* @return the new leader work
	*/
	@Override
	public com.justonetech.oa.model.LeaderWork createLeaderWork(
		com.justonetech.oa.service.persistence.LeaderWorkPK leaderWorkPK) {
		return _leaderWorkLocalService.createLeaderWork(leaderWorkPK);
	}

	/**
	* Deletes the leader work with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param leaderWorkPK the primary key of the leader work
	* @return the leader work that was removed
	* @throws PortalException if a leader work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.LeaderWork deleteLeaderWork(
		com.justonetech.oa.service.persistence.LeaderWorkPK leaderWorkPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.deleteLeaderWork(leaderWorkPK);
	}

	/**
	* Deletes the leader work from the database. Also notifies the appropriate model listeners.
	*
	* @param leaderWork the leader work
	* @return the leader work that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.LeaderWork deleteLeaderWork(
		com.justonetech.oa.model.LeaderWork leaderWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.deleteLeaderWork(leaderWork);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leaderWorkLocalService.dynamicQuery();
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
		return _leaderWorkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.LeaderWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaderWorkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.LeaderWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leaderWorkLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _leaderWorkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leaderWorkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.LeaderWork fetchLeaderWork(
		com.justonetech.oa.service.persistence.LeaderWorkPK leaderWorkPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.fetchLeaderWork(leaderWorkPK);
	}

	/**
	* Returns the leader work with the primary key.
	*
	* @param leaderWorkPK the primary key of the leader work
	* @return the leader work
	* @throws PortalException if a leader work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.LeaderWork getLeaderWork(
		com.justonetech.oa.service.persistence.LeaderWorkPK leaderWorkPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.getLeaderWork(leaderWorkPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the leader works.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.LeaderWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of leader works
	* @param end the upper bound of the range of leader works (not inclusive)
	* @return the range of leader works
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.LeaderWork> getLeaderWorks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.getLeaderWorks(start, end);
	}

	/**
	* Returns the number of leader works.
	*
	* @return the number of leader works
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLeaderWorksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.getLeaderWorksCount();
	}

	/**
	* Updates the leader work in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leaderWork the leader work
	* @return the leader work that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.LeaderWork updateLeaderWork(
		com.justonetech.oa.model.LeaderWork leaderWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leaderWorkLocalService.updateLeaderWork(leaderWork);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leaderWorkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leaderWorkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leaderWorkLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LeaderWorkLocalService getWrappedLeaderWorkLocalService() {
		return _leaderWorkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLeaderWorkLocalService(
		LeaderWorkLocalService leaderWorkLocalService) {
		_leaderWorkLocalService = leaderWorkLocalService;
	}

	@Override
	public LeaderWorkLocalService getWrappedService() {
		return _leaderWorkLocalService;
	}

	@Override
	public void setWrappedService(LeaderWorkLocalService leaderWorkLocalService) {
		_leaderWorkLocalService = leaderWorkLocalService;
	}

	private LeaderWorkLocalService _leaderWorkLocalService;
}