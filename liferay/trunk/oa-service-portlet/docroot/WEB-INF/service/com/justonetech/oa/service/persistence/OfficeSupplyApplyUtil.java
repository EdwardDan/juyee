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

import com.justonetech.oa.model.OfficeSupplyApply;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the office supply apply service. This utility wraps {@link OfficeSupplyApplyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplyPersistence
 * @see OfficeSupplyApplyPersistenceImpl
 * @generated
 */
public class OfficeSupplyApplyUtil {
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
	public static void clearCache(OfficeSupplyApply officeSupplyApply) {
		getPersistence().clearCache(officeSupplyApply);
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
	public static List<OfficeSupplyApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OfficeSupplyApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OfficeSupplyApply> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OfficeSupplyApply update(OfficeSupplyApply officeSupplyApply)
		throws SystemException {
		return getPersistence().update(officeSupplyApply);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OfficeSupplyApply update(
		OfficeSupplyApply officeSupplyApply, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(officeSupplyApply, serviceContext);
	}

	/**
	* Returns all the office supply applies where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @return the matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByDeptName(
		java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName(deptName);
	}

	/**
	* Returns a range of all the office supply applies where deptName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deptName the dept name
	* @param start the lower bound of the range of office supply applies
	* @param end the upper bound of the range of office supply applies (not inclusive)
	* @return the range of matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByDeptName(
		java.lang.String deptName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName(deptName, start, end);
	}

	/**
	* Returns an ordered range of all the office supply applies where deptName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deptName the dept name
	* @param start the lower bound of the range of office supply applies
	* @param end the upper bound of the range of office supply applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByDeptName(
		java.lang.String deptName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeptName(deptName, start, end, orderByComparator);
	}

	/**
	* Returns the first office supply apply in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply apply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply findByDeptName_First(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName_First(deptName, orderByComparator);
	}

	/**
	* Returns the first office supply apply in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply fetchByDeptName_First(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDeptName_First(deptName, orderByComparator);
	}

	/**
	* Returns the last office supply apply in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply apply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply findByDeptName_Last(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeptName_Last(deptName, orderByComparator);
	}

	/**
	* Returns the last office supply apply in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply fetchByDeptName_Last(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDeptName_Last(deptName, orderByComparator);
	}

	/**
	* Returns the office supply applies before and after the current office supply apply in the ordered set where deptName LIKE &#63;.
	*
	* @param officeSupplyApplyId the primary key of the current office supply apply
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next office supply apply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply[] findByDeptName_PrevAndNext(
		long officeSupplyApplyId, java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeptName_PrevAndNext(officeSupplyApplyId, deptName,
			orderByComparator);
	}

	/**
	* Removes all the office supply applies where deptName LIKE &#63; from the database.
	*
	* @param deptName the dept name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDeptName(deptName);
	}

	/**
	* Returns the number of office supply applies where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @return the number of matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDeptName(deptName);
	}

	/**
	* Returns all the office supply applies where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByApplicantName(
		java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicantName(applicantName);
	}

	/**
	* Returns a range of all the office supply applies where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of office supply applies
	* @param end the upper bound of the range of office supply applies (not inclusive)
	* @return the range of matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByApplicantName(
		java.lang.String applicantName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByApplicantName(applicantName, start, end);
	}

	/**
	* Returns an ordered range of all the office supply applies where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of office supply applies
	* @param end the upper bound of the range of office supply applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findByApplicantName(
		java.lang.String applicantName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName(applicantName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first office supply apply in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply apply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply findByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName_First(applicantName, orderByComparator);
	}

	/**
	* Returns the first office supply apply in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply fetchByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicantName_First(applicantName, orderByComparator);
	}

	/**
	* Returns the last office supply apply in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply apply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply findByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName_Last(applicantName, orderByComparator);
	}

	/**
	* Returns the last office supply apply in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply fetchByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByApplicantName_Last(applicantName, orderByComparator);
	}

	/**
	* Returns the office supply applies before and after the current office supply apply in the ordered set where applicantName LIKE &#63;.
	*
	* @param officeSupplyApplyId the primary key of the current office supply apply
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next office supply apply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply[] findByApplicantName_PrevAndNext(
		long officeSupplyApplyId, java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByApplicantName_PrevAndNext(officeSupplyApplyId,
			applicantName, orderByComparator);
	}

	/**
	* Removes all the office supply applies where applicantName LIKE &#63; from the database.
	*
	* @param applicantName the applicant name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByApplicantName(applicantName);
	}

	/**
	* Returns the number of office supply applies where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the number of matching office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByApplicantName(applicantName);
	}

	/**
	* Caches the office supply apply in the entity cache if it is enabled.
	*
	* @param officeSupplyApply the office supply apply
	*/
	public static void cacheResult(
		com.justonetech.oa.model.OfficeSupplyApply officeSupplyApply) {
		getPersistence().cacheResult(officeSupplyApply);
	}

	/**
	* Caches the office supply applies in the entity cache if it is enabled.
	*
	* @param officeSupplyApplies the office supply applies
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.oa.model.OfficeSupplyApply> officeSupplyApplies) {
		getPersistence().cacheResult(officeSupplyApplies);
	}

	/**
	* Creates a new office supply apply with the primary key. Does not add the office supply apply to the database.
	*
	* @param officeSupplyApplyId the primary key for the new office supply apply
	* @return the new office supply apply
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply create(
		long officeSupplyApplyId) {
		return getPersistence().create(officeSupplyApplyId);
	}

	/**
	* Removes the office supply apply with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyApplyId the primary key of the office supply apply
	* @return the office supply apply that was removed
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply remove(
		long officeSupplyApplyId)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(officeSupplyApplyId);
	}

	public static com.justonetech.oa.model.OfficeSupplyApply updateImpl(
		com.justonetech.oa.model.OfficeSupplyApply officeSupplyApply)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(officeSupplyApply);
	}

	/**
	* Returns the office supply apply with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyApplyException} if it could not be found.
	*
	* @param officeSupplyApplyId the primary key of the office supply apply
	* @return the office supply apply
	* @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply findByPrimaryKey(
		long officeSupplyApplyId)
		throws com.justonetech.oa.NoSuchOfficeSupplyApplyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(officeSupplyApplyId);
	}

	/**
	* Returns the office supply apply with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeSupplyApplyId the primary key of the office supply apply
	* @return the office supply apply, or <code>null</code> if a office supply apply with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.OfficeSupplyApply fetchByPrimaryKey(
		long officeSupplyApplyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(officeSupplyApplyId);
	}

	/**
	* Returns all the office supply applies.
	*
	* @return the office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the office supply applies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply applies
	* @param end the upper bound of the range of office supply applies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.OfficeSupplyApply> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the office supply applies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of office supply applies.
	*
	* @return the number of office supply applies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OfficeSupplyApplyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OfficeSupplyApplyPersistence)PortletBeanLocatorUtil.locate(com.justonetech.oa.service.ClpSerializer.getServletContextName(),
					OfficeSupplyApplyPersistence.class.getName());

			ReferenceRegistry.registerReference(OfficeSupplyApplyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OfficeSupplyApplyPersistence persistence) {
	}

	private static OfficeSupplyApplyPersistence _persistence;
}