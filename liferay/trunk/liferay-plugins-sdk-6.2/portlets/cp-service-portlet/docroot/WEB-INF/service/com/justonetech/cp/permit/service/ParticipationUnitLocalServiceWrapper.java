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
 * Provides a wrapper for {@link ParticipationUnitLocalService}.
 *
 * @author fanqi
 * @see ParticipationUnitLocalService
 * @generated
 */
public class ParticipationUnitLocalServiceWrapper
	implements ParticipationUnitLocalService,
		ServiceWrapper<ParticipationUnitLocalService> {
	public ParticipationUnitLocalServiceWrapper(
		ParticipationUnitLocalService participationUnitLocalService) {
		_participationUnitLocalService = participationUnitLocalService;
	}

	/**
	* Adds the participation unit to the database. Also notifies the appropriate model listeners.
	*
	* @param participationUnit the participation unit
	* @return the participation unit that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit addParticipationUnit(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.addParticipationUnit(participationUnit);
	}

	/**
	* Creates a new participation unit with the primary key. Does not add the participation unit to the database.
	*
	* @param unitId the primary key for the new participation unit
	* @return the new participation unit
	*/
	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit createParticipationUnit(
		long unitId) {
		return _participationUnitLocalService.createParticipationUnit(unitId);
	}

	/**
	* Deletes the participation unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit that was removed
	* @throws PortalException if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit deleteParticipationUnit(
		long unitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.deleteParticipationUnit(unitId);
	}

	/**
	* Deletes the participation unit from the database. Also notifies the appropriate model listeners.
	*
	* @param participationUnit the participation unit
	* @return the participation unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit deleteParticipationUnit(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.deleteParticipationUnit(participationUnit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _participationUnitLocalService.dynamicQuery();
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
		return _participationUnitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _participationUnitLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _participationUnitLocalService.dynamicQuery(dynamicQuery, start,
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
		return _participationUnitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _participationUnitLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit fetchParticipationUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.fetchParticipationUnit(unitId);
	}

	/**
	* Returns the participation unit with the primary key.
	*
	* @param unitId the primary key of the participation unit
	* @return the participation unit
	* @throws PortalException if a participation unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit getParticipationUnit(
		long unitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.getParticipationUnit(unitId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the participation units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of participation units
	* @param end the upper bound of the range of participation units (not inclusive)
	* @return the range of participation units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> getParticipationUnits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.getParticipationUnits(start, end);
	}

	/**
	* Returns the number of participation units.
	*
	* @return the number of participation units
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getParticipationUnitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.getParticipationUnitsCount();
	}

	/**
	* Updates the participation unit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param participationUnit the participation unit
	* @return the participation unit that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.permit.model.ParticipationUnit updateParticipationUnit(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _participationUnitLocalService.updateParticipationUnit(participationUnit);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _participationUnitLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_participationUnitLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _participationUnitLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.cp.permit.model.ParticipationUnit> findByPermitId(
		long permitId, int start, int end) {
		return _participationUnitLocalService.findByPermitId(permitId, start,
			end);
	}

	@Override
	public int countByPermitId(long permitId) {
		return _participationUnitLocalService.countByPermitId(permitId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ParticipationUnitLocalService getWrappedParticipationUnitLocalService() {
		return _participationUnitLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedParticipationUnitLocalService(
		ParticipationUnitLocalService participationUnitLocalService) {
		_participationUnitLocalService = participationUnitLocalService;
	}

	@Override
	public ParticipationUnitLocalService getWrappedService() {
		return _participationUnitLocalService;
	}

	@Override
	public void setWrappedService(
		ParticipationUnitLocalService participationUnitLocalService) {
		_participationUnitLocalService = participationUnitLocalService;
	}

	private ParticipationUnitLocalService _participationUnitLocalService;
}