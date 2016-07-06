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

package com.justonetech.oa.service.persistence;

import com.justonetech.oa.model.VehicleApplication;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the vehicle application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see VehicleApplicationPersistenceImpl
 * @see VehicleApplicationUtil
 * @generated
 */
public interface VehicleApplicationPersistence extends BasePersistence<VehicleApplication> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VehicleApplicationUtil} to access the vehicle application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the vehicle applications where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the matching vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.VehicleApplication> findByApplicantName(
		java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vehicle applications where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of vehicle applications
	* @param end the upper bound of the range of vehicle applications (not inclusive)
	* @return the range of matching vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.VehicleApplication> findByApplicantName(
		java.lang.String applicantName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vehicle applications where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of vehicle applications
	* @param end the upper bound of the range of vehicle applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.VehicleApplication> findByApplicantName(
		java.lang.String applicantName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vehicle application in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vehicle application
	* @throws com.justonetech.oa.NoSuchVehicleApplicationException if a matching vehicle application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication findByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchVehicleApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vehicle application in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vehicle application, or <code>null</code> if a matching vehicle application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication fetchByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vehicle application in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vehicle application
	* @throws com.justonetech.oa.NoSuchVehicleApplicationException if a matching vehicle application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication findByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchVehicleApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vehicle application in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vehicle application, or <code>null</code> if a matching vehicle application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication fetchByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vehicle applications before and after the current vehicle application in the ordered set where applicantName LIKE &#63;.
	*
	* @param vehicleApplicationId the primary key of the current vehicle application
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vehicle application
	* @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication[] findByApplicantName_PrevAndNext(
		long vehicleApplicationId, java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchVehicleApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vehicle applications where applicantName LIKE &#63; from the database.
	*
	* @param applicantName the applicant name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vehicle applications where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the number of matching vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the vehicle application in the entity cache if it is enabled.
	*
	* @param vehicleApplication the vehicle application
	*/
	public void cacheResult(
		com.justonetech.oa.model.VehicleApplication vehicleApplication);

	/**
	* Caches the vehicle applications in the entity cache if it is enabled.
	*
	* @param vehicleApplications the vehicle applications
	*/
	public void cacheResult(
		java.util.List<com.justonetech.oa.model.VehicleApplication> vehicleApplications);

	/**
	* Creates a new vehicle application with the primary key. Does not add the vehicle application to the database.
	*
	* @param vehicleApplicationId the primary key for the new vehicle application
	* @return the new vehicle application
	*/
	public com.justonetech.oa.model.VehicleApplication create(
		long vehicleApplicationId);

	/**
	* Removes the vehicle application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleApplicationId the primary key of the vehicle application
	* @return the vehicle application that was removed
	* @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication remove(
		long vehicleApplicationId)
		throws com.justonetech.oa.NoSuchVehicleApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.oa.model.VehicleApplication updateImpl(
		com.justonetech.oa.model.VehicleApplication vehicleApplication)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vehicle application with the primary key or throws a {@link com.justonetech.oa.NoSuchVehicleApplicationException} if it could not be found.
	*
	* @param vehicleApplicationId the primary key of the vehicle application
	* @return the vehicle application
	* @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication findByPrimaryKey(
		long vehicleApplicationId)
		throws com.justonetech.oa.NoSuchVehicleApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vehicle application with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vehicleApplicationId the primary key of the vehicle application
	* @return the vehicle application, or <code>null</code> if a vehicle application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.VehicleApplication fetchByPrimaryKey(
		long vehicleApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vehicle applications.
	*
	* @return the vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.VehicleApplication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vehicle applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vehicle applications
	* @param end the upper bound of the range of vehicle applications (not inclusive)
	* @return the range of vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.VehicleApplication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vehicle applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vehicle applications
	* @param end the upper bound of the range of vehicle applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.VehicleApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vehicle applications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vehicle applications.
	*
	* @return the number of vehicle applications
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}