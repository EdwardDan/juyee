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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the l e o certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see LEOCertificatePersistenceImpl
 * @see LEOCertificateUtil
 * @generated
 */
public interface LEOCertificatePersistence extends BasePersistence<LEOCertificate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LEOCertificateUtil} to access the l e o certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the l e o certificate where zjbh = &#63; or throws a {@link com.justonetech.cyzt.leo.NoSuchLEOCertificateException} if it could not be found.
	*
	* @param zjbh the zjbh
	* @return the matching l e o certificate
	* @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a matching l e o certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate findByZjbh(
		java.lang.String zjbh)
		throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l e o certificate where zjbh = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param zjbh the zjbh
	* @return the matching l e o certificate, or <code>null</code> if a matching l e o certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate fetchByZjbh(
		java.lang.String zjbh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l e o certificate where zjbh = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param zjbh the zjbh
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching l e o certificate, or <code>null</code> if a matching l e o certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate fetchByZjbh(
		java.lang.String zjbh, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the l e o certificate where zjbh = &#63; from the database.
	*
	* @param zjbh the zjbh
	* @return the l e o certificate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate removeByZjbh(
		java.lang.String zjbh)
		throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l e o certificates where zjbh = &#63;.
	*
	* @param zjbh the zjbh
	* @return the number of matching l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countByZjbh(java.lang.String zjbh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the l e o certificate in the entity cache if it is enabled.
	*
	* @param leoCertificate the l e o certificate
	*/
	public void cacheResult(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate);

	/**
	* Caches the l e o certificates in the entity cache if it is enabled.
	*
	* @param leoCertificates the l e o certificates
	*/
	public void cacheResult(
		java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> leoCertificates);

	/**
	* Creates a new l e o certificate with the primary key. Does not add the l e o certificate to the database.
	*
	* @param certificateId the primary key for the new l e o certificate
	* @return the new l e o certificate
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate create(
		long certificateId);

	/**
	* Removes the l e o certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate that was removed
	* @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate remove(
		long certificateId)
		throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.cyzt.leo.model.LEOCertificate updateImpl(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l e o certificate with the primary key or throws a {@link com.justonetech.cyzt.leo.NoSuchLEOCertificateException} if it could not be found.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate
	* @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate findByPrimaryKey(
		long certificateId)
		throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l e o certificate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param certificateId the primary key of the l e o certificate
	* @return the l e o certificate, or <code>null</code> if a l e o certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.cyzt.leo.model.LEOCertificate fetchByPrimaryKey(
		long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the l e o certificates.
	*
	* @return the l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.cyzt.leo.model.LEOCertificate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the l e o certificates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l e o certificates.
	*
	* @return the number of l e o certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}