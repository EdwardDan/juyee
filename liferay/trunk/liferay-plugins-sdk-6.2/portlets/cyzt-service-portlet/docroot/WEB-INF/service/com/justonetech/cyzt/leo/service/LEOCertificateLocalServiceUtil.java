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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for LEOCertificate. This utility wraps
 * {@link com.justonetech.cyzt.leo.service.impl.LEOCertificateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author fanqi
 * @see LEOCertificateLocalService
 * @see com.justonetech.cyzt.leo.service.base.LEOCertificateLocalServiceBaseImpl
 * @see com.justonetech.cyzt.leo.service.impl.LEOCertificateLocalServiceImpl
 * @generated
 */
public class LEOCertificateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.justonetech.cyzt.leo.service.impl.LEOCertificateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the l e o certificate to the database. Also notifies the appropriate model listeners.
	*
	* @param leoCertificate the l e o certificate
	* @return the l e o certificate that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate addLEOCertificate(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLEOCertificate(leoCertificate);
	}

	/**
	* Creates a new l e o certificate with the primary key. Does not add the l e o certificate to the database.
	*
	* @param certificateId the primary key for the new l e o certificate
	* @return the new l e o certificate
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate createLEOCertificate(
		java.lang.String certificateId) {
		return getService().createLEOCertificate(certificateId);
	}

	/**
	* Deletes the l e o certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate that was removed
	* @throws PortalException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate deleteLEOCertificate(
		java.lang.String certificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLEOCertificate(certificateId);
	}

	/**
	* Deletes the l e o certificate from the database. Also notifies the appropriate model listeners.
	*
	* @param leoCertificate the l e o certificate
	* @return the l e o certificate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate deleteLEOCertificate(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLEOCertificate(leoCertificate);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.justonetech.cyzt.leo.model.LEOCertificate fetchLEOCertificate(
		java.lang.String certificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLEOCertificate(certificateId);
	}

	/**
	* Returns the l e o certificate with the primary key.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate
	* @throws PortalException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate getLEOCertificate(
		java.lang.String certificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLEOCertificate(certificateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> getLEOCertificates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLEOCertificates(start, end);
	}

	/**
	* Returns the number of l e o certificates.
	*
	* @return the number of l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	public static int getLEOCertificatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLEOCertificatesCount();
	}

	/**
	* Updates the l e o certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param leoCertificate the l e o certificate
	* @return the l e o certificate that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate updateLEOCertificate(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLEOCertificate(leoCertificate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> getLEOCertificates(
		java.lang.String xm, java.lang.String zylx, java.lang.String zjbh,
		java.util.Date yxq, int start, int end) {
		return getService().getLEOCertificates(xm, zylx, zjbh, yxq, start, end);
	}

	public static int getProjectsCount(java.lang.String xm,
		java.lang.String zylx, java.lang.String zjbh, java.util.Date yxq) {
		return getService().getProjectsCount(xm, zylx, zjbh, yxq);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		java.lang.String xm, java.lang.String zylx, java.lang.String zjbh,
		java.util.Date yxq) {
		return getService().createDynamicQuery(xm, zylx, zjbh, yxq);
	}

	public static void clearService() {
		_service = null;
	}

	public static LEOCertificateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LEOCertificateLocalService.class.getName());

			if (invokableLocalService instanceof LEOCertificateLocalService) {
				_service = (LEOCertificateLocalService)invokableLocalService;
			}
			else {
				_service = new LEOCertificateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LEOCertificateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(LEOCertificateLocalService service) {
	}

	private static LEOCertificateLocalService _service;
}