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

package com.justonetech.proj.service.persistence;

import com.justonetech.proj.model.Company;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompanyPersistenceImpl
 * @see CompanyUtil
 * @generated
 */
public interface CompanyPersistence extends BasePersistence<Company> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompanyUtil} to access the company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the companies where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the matching companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findByProjectId(
		long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the companies where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of companies
	* @param end the upper bound of the range of companies (not inclusive)
	* @return the range of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findByProjectId(
		long projectId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the companies where projectId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param projectId the project ID
	* @param start the lower bound of the range of companies
	* @param end the upper bound of the range of companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findByProjectId(
		long projectId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company
	* @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company findByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company fetchByProjectId_First(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last company in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company
	* @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company findByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last company in the ordered set where projectId = &#63;.
	*
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company fetchByProjectId_Last(
		long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the companies before and after the current company in the ordered set where projectId = &#63;.
	*
	* @param companyId the primary key of the current company
	* @param projectId the project ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company
	* @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company[] findByProjectId_PrevAndNext(
		long companyId, long projectId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the companies where projectId = &#63; from the database.
	*
	* @param projectId the project ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByProjectId(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of companies where projectId = &#63;.
	*
	* @param projectId the project ID
	* @return the number of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByProjectId(long projectId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the companies where biddingId = &#63;.
	*
	* @param biddingId the bidding ID
	* @return the matching companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findByBiddingId(
		long biddingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the companies where biddingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biddingId the bidding ID
	* @param start the lower bound of the range of companies
	* @param end the upper bound of the range of companies (not inclusive)
	* @return the range of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findByBiddingId(
		long biddingId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the companies where biddingId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param biddingId the bidding ID
	* @param start the lower bound of the range of companies
	* @param end the upper bound of the range of companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findByBiddingId(
		long biddingId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company in the ordered set where biddingId = &#63;.
	*
	* @param biddingId the bidding ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company
	* @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company findByBiddingId_First(
		long biddingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company in the ordered set where biddingId = &#63;.
	*
	* @param biddingId the bidding ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company fetchByBiddingId_First(
		long biddingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last company in the ordered set where biddingId = &#63;.
	*
	* @param biddingId the bidding ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company
	* @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company findByBiddingId_Last(
		long biddingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last company in the ordered set where biddingId = &#63;.
	*
	* @param biddingId the bidding ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company, or <code>null</code> if a matching company could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company fetchByBiddingId_Last(
		long biddingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the companies before and after the current company in the ordered set where biddingId = &#63;.
	*
	* @param companyId the primary key of the current company
	* @param biddingId the bidding ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company
	* @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company[] findByBiddingId_PrevAndNext(
		long companyId, long biddingId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the companies where biddingId = &#63; from the database.
	*
	* @param biddingId the bidding ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBiddingId(long biddingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of companies where biddingId = &#63;.
	*
	* @param biddingId the bidding ID
	* @return the number of matching companies
	* @throws SystemException if a system exception occurred
	*/
	public int countByBiddingId(long biddingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the company in the entity cache if it is enabled.
	*
	* @param company the company
	*/
	public void cacheResult(com.justonetech.proj.model.Company company);

	/**
	* Caches the companies in the entity cache if it is enabled.
	*
	* @param companies the companies
	*/
	public void cacheResult(
		java.util.List<com.justonetech.proj.model.Company> companies);

	/**
	* Creates a new company with the primary key. Does not add the company to the database.
	*
	* @param companyId the primary key for the new company
	* @return the new company
	*/
	public com.justonetech.proj.model.Company create(long companyId);

	/**
	* Removes the company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyId the primary key of the company
	* @return the company that was removed
	* @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company remove(long companyId)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.proj.model.Company updateImpl(
		com.justonetech.proj.model.Company company)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company with the primary key or throws a {@link com.justonetech.proj.NoSuchCompanyException} if it could not be found.
	*
	* @param companyId the primary key of the company
	* @return the company
	* @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company findByPrimaryKey(long companyId)
		throws com.justonetech.proj.NoSuchCompanyException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyId the primary key of the company
	* @return the company, or <code>null</code> if a company with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.proj.model.Company fetchByPrimaryKey(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the companies.
	*
	* @return the companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of companies
	* @param end the upper bound of the range of companies (not inclusive)
	* @return the range of companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of companies
	* @param end the upper bound of the range of companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of companies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.proj.model.Company> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the companies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of companies.
	*
	* @return the number of companies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}