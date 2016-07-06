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

import com.justonetech.oa.model.OfficeSupplyRequisition;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the office supply requisition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionPersistenceImpl
 * @see OfficeSupplyRequisitionUtil
 * @generated
 */
public interface OfficeSupplyRequisitionPersistence extends BasePersistence<OfficeSupplyRequisition> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OfficeSupplyRequisitionUtil} to access the office supply requisition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the office supply requisitions where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @return the matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findByDeptName(
		java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the office supply requisitions where deptName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deptName the dept name
	* @param start the lower bound of the range of office supply requisitions
	* @param end the upper bound of the range of office supply requisitions (not inclusive)
	* @return the range of matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findByDeptName(
		java.lang.String deptName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the office supply requisitions where deptName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deptName the dept name
	* @param start the lower bound of the range of office supply requisitions
	* @param end the upper bound of the range of office supply requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findByDeptName(
		java.lang.String deptName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply requisition in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition findByDeptName_First(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply requisition in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition, or <code>null</code> if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition fetchByDeptName_First(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply requisition in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition findByDeptName_Last(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply requisition in the ordered set where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition, or <code>null</code> if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition fetchByDeptName_Last(
		java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply requisitions before and after the current office supply requisition in the ordered set where deptName LIKE &#63;.
	*
	* @param officeSupplyRequisitionId the primary key of the current office supply requisition
	* @param deptName the dept name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next office supply requisition
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition[] findByDeptName_PrevAndNext(
		long officeSupplyRequisitionId, java.lang.String deptName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the office supply requisitions where deptName LIKE &#63; from the database.
	*
	* @param deptName the dept name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of office supply requisitions where deptName LIKE &#63;.
	*
	* @param deptName the dept name
	* @return the number of matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public int countByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the office supply requisitions where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findByApplicantName(
		java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the office supply requisitions where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of office supply requisitions
	* @param end the upper bound of the range of office supply requisitions (not inclusive)
	* @return the range of matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findByApplicantName(
		java.lang.String applicantName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the office supply requisitions where applicantName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicantName the applicant name
	* @param start the lower bound of the range of office supply requisitions
	* @param end the upper bound of the range of office supply requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findByApplicantName(
		java.lang.String applicantName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition findByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first office supply requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching office supply requisition, or <code>null</code> if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition fetchByApplicantName_First(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition findByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last office supply requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching office supply requisition, or <code>null</code> if a matching office supply requisition could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition fetchByApplicantName_Last(
		java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply requisitions before and after the current office supply requisition in the ordered set where applicantName LIKE &#63;.
	*
	* @param officeSupplyRequisitionId the primary key of the current office supply requisition
	* @param applicantName the applicant name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next office supply requisition
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition[] findByApplicantName_PrevAndNext(
		long officeSupplyRequisitionId, java.lang.String applicantName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the office supply requisitions where applicantName LIKE &#63; from the database.
	*
	* @param applicantName the applicant name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of office supply requisitions where applicantName LIKE &#63;.
	*
	* @param applicantName the applicant name
	* @return the number of matching office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public int countByApplicantName(java.lang.String applicantName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the office supply requisition in the entity cache if it is enabled.
	*
	* @param officeSupplyRequisition the office supply requisition
	*/
	public void cacheResult(
		com.justonetech.oa.model.OfficeSupplyRequisition officeSupplyRequisition);

	/**
	* Caches the office supply requisitions in the entity cache if it is enabled.
	*
	* @param officeSupplyRequisitions the office supply requisitions
	*/
	public void cacheResult(
		java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> officeSupplyRequisitions);

	/**
	* Creates a new office supply requisition with the primary key. Does not add the office supply requisition to the database.
	*
	* @param officeSupplyRequisitionId the primary key for the new office supply requisition
	* @return the new office supply requisition
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition create(
		long officeSupplyRequisitionId);

	/**
	* Removes the office supply requisition with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param officeSupplyRequisitionId the primary key of the office supply requisition
	* @return the office supply requisition that was removed
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition remove(
		long officeSupplyRequisitionId)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.oa.model.OfficeSupplyRequisition updateImpl(
		com.justonetech.oa.model.OfficeSupplyRequisition officeSupplyRequisition)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply requisition with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyRequisitionException} if it could not be found.
	*
	* @param officeSupplyRequisitionId the primary key of the office supply requisition
	* @return the office supply requisition
	* @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition findByPrimaryKey(
		long officeSupplyRequisitionId)
		throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the office supply requisition with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param officeSupplyRequisitionId the primary key of the office supply requisition
	* @return the office supply requisition, or <code>null</code> if a office supply requisition with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.oa.model.OfficeSupplyRequisition fetchByPrimaryKey(
		long officeSupplyRequisitionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the office supply requisitions.
	*
	* @return the office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the office supply requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply requisitions
	* @param end the upper bound of the range of office supply requisitions (not inclusive)
	* @return the range of office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the office supply requisitions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of office supply requisitions
	* @param end the upper bound of the range of office supply requisitions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.oa.model.OfficeSupplyRequisition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the office supply requisitions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of office supply requisitions.
	*
	* @return the number of office supply requisitions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}