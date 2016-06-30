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

import com.justonetech.oa.model.VehicleRequisition;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the vehicle requisition service. This utility wraps {@link VehicleRequisitionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see VehicleRequisitionPersistence
 * @see VehicleRequisitionPersistenceImpl
 * @generated
 */
public class VehicleRequisitionUtil {
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
	public static void clearCache(VehicleRequisition vehicleRequisition) {
		getPersistence().clearCache(vehicleRequisition);
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
	public static List<VehicleRequisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VehicleRequisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VehicleRequisition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VehicleRequisition update(
		VehicleRequisition vehicleRequisition) throws SystemException {
		return getPersistence().update(vehicleRequisition);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VehicleRequisition update(
		VehicleRequisition vehicleRequisition, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(vehicleRequisition, serviceContext);
	}

	/**
	* Returns all the vehicle requisitions where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the matching vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.VehicleRequisition> findByApplicantName(
		java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicantName(applicantName);
	}

	/**
	* Returns a range of all the vehicle requisitions where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of vehicle requisitions
	* @param end the upper bound of the range of vehicle requisitions (not inclusive)
	* @return the range of matching vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.VehicleRequisition> findByApplicantName(
		java.lang.String applicantName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicantName(applicantName, start, end);
	}

	/**
	* Returns an ordered range of all the vehicle requisitions where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of vehicle requisitions
	* @param end the upper bound of the range of vehicle requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.VehicleRequisition> findByApplicantName(
		java.lang.String applicantName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName(applicantName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first vehicle requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vehicle requisition
	* @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a matching vehicle requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition findByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchVehicleRequisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName_First(applicantName, orderByComparator);
	}

	/**
	* Returns the first vehicle requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vehicle requisition, or <code>null</code> if a matching vehicle requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition fetchByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicantName_First(applicantName, orderByComparator);
	}

	/**
	* Returns the last vehicle requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vehicle requisition
	* @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a matching vehicle requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition findByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchVehicleRequisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName_Last(applicantName, orderByComparator);
	}

	/**
	* Returns the last vehicle requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vehicle requisition, or <code>null</code> if a matching vehicle requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition fetchByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicantName_Last(applicantName, orderByComparator);
	}

	/**
	* Returns the vehicle requisitions before and after the current vehicle requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param vehicleRequisitionId the primary key of the current vehicle requisition
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vehicle requisition
	* @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition[] findByApplicantName_PrevAndNext(
		long vehicleRequisitionId, java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchVehicleRequisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName_PrevAndNext(vehicleRequisitionId,
			applicantName, orderByComparator);
	}

	/**
	* Removes all the vehicle requisitions where applicantName LIKE &#63; from the database.
	*
	* @param applicantName the applicant name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByApplicantName(applicantName);
	}

	/**
	* Returns the number of vehicle requisitions where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the number of matching vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByApplicantName(applicantName);
	}

	/**
	* Caches the vehicle requisition in the entity cache if it is enabled.
	*
	* @param vehicleRequisition the vehicle requisition
	*/
	public static void cacheResult(
		com.justonetech.oa.model.VehicleRequisition vehicleRequisition) {
		getPersistence().cacheResult(vehicleRequisition);
	}

	/**
	* Caches the vehicle requisitions in the entity cache if it is enabled.
	*
	* @param vehicleRequisitions the vehicle requisitions
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.VehicleRequisition> vehicleRequisitions) {
		getPersistence().cacheResult(vehicleRequisitions);
	}

	/**
	* Creates a new vehicle requisition with the primary key. Does not add the vehicle requisition to the database.
	*
	* @param vehicleRequisitionId the primary key for the new vehicle requisition
	* @return the new vehicle requisition
	*/
	public static com.justonetech.oa.model.VehicleRequisition create(
		long vehicleRequisitionId) {
		return getPersistence().create(vehicleRequisitionId);
	}

	/**
	* Removes the vehicle requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vehicleRequisitionId the primary key of the vehicle requisition
	* @return the vehicle requisition that was removed
	* @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition remove(
		long vehicleRequisitionId)
		throws com.justonetech.oa.NoSuchVehicleRequisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(vehicleRequisitionId);
	}

	public static com.justonetech.oa.model.VehicleRequisition updateImpl(
		com.justonetech.oa.model.VehicleRequisition vehicleRequisition)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vehicleRequisition);
	}

	/**
	* Returns the vehicle requisition with the primary key or throws a {@link com.justonetech.oa.NoSuchVehicleRequisitionException} if it could not be found.
	*
	* @param vehicleRequisitionId the primary key of the vehicle requisition
	* @return the vehicle requisition
	* @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition findByPrimaryKey(
		long vehicleRequisitionId)
		throws com.justonetech.oa.NoSuchVehicleRequisitionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(vehicleRequisitionId);
	}

	/**
	* Returns the vehicle requisition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vehicleRequisitionId the primary key of the vehicle requisition
	* @return the vehicle requisition, or <code>null</code> if a vehicle requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.VehicleRequisition fetchByPrimaryKey(
		long vehicleRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(vehicleRequisitionId);
	}

	/**
	* Returns all the vehicle requisitions.
	*
	* @return the vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.VehicleRequisition> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vehicle requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vehicle requisitions
	* @param end the upper bound of the range of vehicle requisitions (not inclusive)
	* @return the range of vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.VehicleRequisition> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vehicle requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vehicle requisitions
	* @param end the upper bound of the range of vehicle requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.VehicleRequisition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vehicle requisitions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vehicle requisitions.
	*
	* @return the number of vehicle requisitions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VehicleRequisitionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VehicleRequisitionPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					VehicleRequisitionPersistence.class.getName());

			ReferenceRegistry.registerReference(VehicleRequisitionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VehicleRequisitionPersistence persistence) {
	}

	private static VehicleRequisitionPersistence _persistence;
}