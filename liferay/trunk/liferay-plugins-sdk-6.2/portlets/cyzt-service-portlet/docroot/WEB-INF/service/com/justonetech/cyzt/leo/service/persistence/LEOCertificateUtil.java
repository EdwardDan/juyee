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

package com.justonetech.cyzt.leo.service.persistence;

import com.justonetech.cyzt.leo.model.LEOCertificate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the l e o certificate service. This utility wraps {@link LEOCertificatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see LEOCertificatePersistence
 * @see LEOCertificatePersistenceImpl
 * @generated
 */
public class LEOCertificateUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(LEOCertificate leoCertificate) {
		getPersistence().clearCache(leoCertificate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<LEOCertificate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LEOCertificate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LEOCertificate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static LEOCertificate update(LEOCertificate leoCertificate)
		throws SystemException {
		return getPersistence().update(leoCertificate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static LEOCertificate update(LEOCertificate leoCertificate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(leoCertificate, serviceContext);
	}

	/**
	* Caches the l e o certificate in the entity cache if it is enabled.
	*
	* @param leoCertificate the l e o certificate
	*/
	public static void cacheResult(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate) {
		getPersistence().cacheResult(leoCertificate);
	}

	/**
	* Caches the l e o certificates in the entity cache if it is enabled.
	*
	* @param leoCertificates the l e o certificates
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> leoCertificates) {
		getPersistence().cacheResult(leoCertificates);
	}

	/**
	* Creates a new l e o certificate with the primary key. Does not add the l e o certificate to the database.
	*
	* @param certificateId the primary key for the new l e o certificate
	* @return the new l e o certificate
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate create(
		long certificateId) {
		return getPersistence().create(certificateId);
	}

	/**
	* Removes the l e o certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate that was removed
	* @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate remove(
		long certificateId)
		throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(certificateId);
	}

	public static com.justonetech.cyzt.leo.model.LEOCertificate updateImpl(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(leoCertificate);
	}

	/**
	* Returns the l e o certificate with the primary key or throws a {@link com.justonetech.cyzt.leo.NoSuchLEOCertificateException} if it could not be found.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate
	* @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate findByPrimaryKey(
		long certificateId)
		throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(certificateId);
	}

	/**
	* Returns the l e o certificate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate, or <code>null</code> if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cyzt.leo.model.LEOCertificate fetchByPrimaryKey(
		long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(certificateId);
	}

	/**
	* Returns all the l e o certificates.
	*
	* @return the l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l e o certificates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of l e o certificates
	* @param end the upper bound of the range of l e o certificates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l e o certificates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l e o certificates.
	*
	* @return the number of l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LEOCertificatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LEOCertificatePersistence)PortletBeanLocatorUtil.locate(com.justonetech.cyzt.leo.service.ClpSerializer.getServletContextName(),
					LEOCertificatePersistence.class.getName());

			ReferenceRegistry.registerReference(LEOCertificateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LEOCertificatePersistence persistence) {
	}

	private static LEOCertificatePersistence _persistence;
}