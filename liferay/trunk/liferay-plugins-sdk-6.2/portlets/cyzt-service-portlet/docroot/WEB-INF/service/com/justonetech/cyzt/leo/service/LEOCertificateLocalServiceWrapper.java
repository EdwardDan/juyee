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

package com.justonetech.cyzt.leo.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LEOCertificateLocalService}.
 *
 * @author fanqi
 * @see LEOCertificateLocalService
 * @generated
 */
public class LEOCertificateLocalServiceWrapper
	implements LEOCertificateLocalService,
		ServiceWrapper<LEOCertificateLocalService> {
	public LEOCertificateLocalServiceWrapper(
		LEOCertificateLocalService leoCertificateLocalService) {
		_leoCertificateLocalService = leoCertificateLocalService;
	}

	/**
	* Adds the l e o certificate to the database. Also notifies the appropriate model listeners.
	*
	* @param leoCertificate the l e o certificate
	* @return the l e o certificate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate addLEOCertificate(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.addLEOCertificate(leoCertificate);
	}

	/**
	* Creates a new l e o certificate with the primary key. Does not add the l e o certificate to the database.
	*
	* @param certificateId the primary key for the new l e o certificate
	* @return the new l e o certificate
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate createLEOCertificate(
		java.lang.String certificateId) {
		return _leoCertificateLocalService.createLEOCertificate(certificateId);
	}

	/**
	* Deletes the l e o certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate that was removed
	* @throws PortalException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate deleteLEOCertificate(
		java.lang.String certificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.deleteLEOCertificate(certificateId);
	}

	/**
	* Deletes the l e o certificate from the database. Also notifies the appropriate model listeners.
	*
	* @param leoCertificate the l e o certificate
	* @return the l e o certificate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate deleteLEOCertificate(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.deleteLEOCertificate(leoCertificate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _leoCertificateLocalService.dynamicQuery();
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
		return _leoCertificateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leoCertificateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _leoCertificateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _leoCertificateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _leoCertificateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate fetchLEOCertificate(
		java.lang.String certificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.fetchLEOCertificate(certificateId);
	}

	/**
	* Returns the l e o certificate with the primary key.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate
	* @throws PortalException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate getLEOCertificate(
		java.lang.String certificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.getLEOCertificate(certificateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the l e o certificates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l e o certificates
	* @param end the upper bound of the range of l e o certificates (not inclusive)
	* @return the range of l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> getLEOCertificates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.getLEOCertificates(start, end);
	}

	/**
	* Returns the number of l e o certificates.
	*
	* @return the number of l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLEOCertificatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.getLEOCertificatesCount();
	}

	/**
	* Updates the l e o certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leoCertificate the l e o certificate
	* @return the l e o certificate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cyzt.leo.model.LEOCertificate updateLEOCertificate(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _leoCertificateLocalService.updateLEOCertificate(leoCertificate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _leoCertificateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_leoCertificateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _leoCertificateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LEOCertificateLocalService getWrappedLEOCertificateLocalService() {
		return _leoCertificateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLEOCertificateLocalService(
		LEOCertificateLocalService leoCertificateLocalService) {
		_leoCertificateLocalService = leoCertificateLocalService;
	}

	@Override
	public LEOCertificateLocalService getWrappedService() {
		return _leoCertificateLocalService;
	}

	@Override
	public void setWrappedService(
		LEOCertificateLocalService leoCertificateLocalService) {
		_leoCertificateLocalService = leoCertificateLocalService;
	}

	private LEOCertificateLocalService _leoCertificateLocalService;
}