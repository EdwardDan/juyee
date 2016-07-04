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
 * Provides a wrapper for {@link OfficeSupplyApplyLocalService}.
 *
 * @author justonetech
 * @see OfficeSupplyApplyLocalService
 * @generated
 */
public class OfficeSupplyApplyLocalServiceWrapper
	implements OfficeSupplyApplyLocalService,
		ServiceWrapper<OfficeSupplyApplyLocalService> {
	public OfficeSupplyApplyLocalServiceWrapper(
		OfficeSupplyApplyLocalService officeSupplyApplyLocalService) {
		_officeSupplyApplyLocalService = officeSupplyApplyLocalService;
	}

	/**
	* Adds the office supply apply to the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApply the office supply apply
	* @return the office supply apply that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApply addOfficeSupplyApply(
		com.justonetech.oa.model.OfficeSupplyApply officeSupplyApply)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.addOfficeSupplyApply(officeSupplyApply);
	}

	/**
	* Creates a new office supply apply with the primary key. Does not add the office supply apply to the database.
	*
	* @param officeSupplyApplyId the primary key for the new office supply apply
	* @return the new office supply apply
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApply createOfficeSupplyApply(
		long officeSupplyApplyId) {
		return _officeSupplyApplyLocalService.createOfficeSupplyApply(officeSupplyApplyId);
	}

	/**
	* Deletes the office supply apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplyId the primary key of the office supply apply
	* @return the office supply apply that was removed
	* @throws PortalException if a office supply apply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApply deleteOfficeSupplyApply(
		long officeSupplyApplyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.deleteOfficeSupplyApply(officeSupplyApplyId);
	}

	/**
	* Deletes the office supply apply from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApply the office supply apply
	* @return the office supply apply that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApply deleteOfficeSupplyApply(
		com.justonetech.oa.model.OfficeSupplyApply officeSupplyApply)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.deleteOfficeSupplyApply(officeSupplyApply);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _officeSupplyApplyLocalService.dynamicQuery();
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
		return _officeSupplyApplyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyApplyLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _officeSupplyApplyLocalService.dynamicQuery(dynamicQuery, start,
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
		return _officeSupplyApplyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _officeSupplyApplyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.oa.model.OfficeSupplyApply fetchOfficeSupplyApply(
		long officeSupplyApplyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.fetchOfficeSupplyApply(officeSupplyApplyId);
	}

	/**
	* Returns the office supply apply with the primary key.
	*
	* @param officeSupplyApplyId the primary key of the office supply apply
	* @return the office supply apply
	* @throws PortalException if a office supply apply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApply getOfficeSupplyApply(
		long officeSupplyApplyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.getOfficeSupplyApply(officeSupplyApplyId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the office supply applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply applies
	* @param end the upper bound of the range of office supply applies (not inclusive)
	* @return the range of office supply applies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyApply> getOfficeSupplyApplies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.getOfficeSupplyApplies(start, end);
	}

	/**
	* Returns the number of office supply applies.
	*
	* @return the number of office supply applies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOfficeSupplyAppliesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.getOfficeSupplyAppliesCount();
	}

	/**
	* Updates the office supply apply in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApply the office supply apply
	* @return the office supply apply that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.oa.model.OfficeSupplyApply updateOfficeSupplyApply(
		com.justonetech.oa.model.OfficeSupplyApply officeSupplyApply)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.updateOfficeSupplyApply(officeSupplyApply);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _officeSupplyApplyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_officeSupplyApplyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _officeSupplyApplyLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByApplicantName(
		java.lang.String applicantName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.findByApplicantName(applicantName,
			start, end);
	}

	@Override
	public int countByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.countByApplicantName(applicantName);
	}

	@Override
	public java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByDeptName(
		java.lang.String deptName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.findByDeptName(deptName, start,
			end);
	}

	@Override
	public int countByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _officeSupplyApplyLocalService.countByDeptName(deptName);
	}

	@Override
	public void deleteOfficeSupplies(java.lang.String[] officeSupplyApplyIds) {
		_officeSupplyApplyLocalService.deleteOfficeSupplies(officeSupplyApplyIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OfficeSupplyApplyLocalService getWrappedOfficeSupplyApplyLocalService() {
		return _officeSupplyApplyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOfficeSupplyApplyLocalService(
		OfficeSupplyApplyLocalService officeSupplyApplyLocalService) {
		_officeSupplyApplyLocalService = officeSupplyApplyLocalService;
	}

	@Override
	public OfficeSupplyApplyLocalService getWrappedService() {
		return _officeSupplyApplyLocalService;
	}

	@Override
	public void setWrappedService(
		OfficeSupplyApplyLocalService officeSupplyApplyLocalService) {
		_officeSupplyApplyLocalService = officeSupplyApplyLocalService;
	}

	private OfficeSupplyApplyLocalService _officeSupplyApplyLocalService;
}