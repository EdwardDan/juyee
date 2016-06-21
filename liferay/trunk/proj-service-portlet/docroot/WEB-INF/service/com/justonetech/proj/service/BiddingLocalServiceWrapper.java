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

package com.justonetech.proj.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BiddingLocalService}.
 *
 * @author fanqi
 * @see BiddingLocalService
 * @generated
 */
public class BiddingLocalServiceWrapper implements BiddingLocalService,
	ServiceWrapper<BiddingLocalService> {
	public BiddingLocalServiceWrapper(BiddingLocalService biddingLocalService) {
		_biddingLocalService = biddingLocalService;
	}

	/**
	* Adds the bidding to the database. Also notifies the appropriate model listeners.
	*
	* @param bidding the bidding
	* @return the bidding that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.proj.model.Bidding addBidding(
		com.justonetech.proj.model.Bidding bidding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.addBidding(bidding);
	}

	/**
	* Creates a new bidding with the primary key. Does not add the bidding to the database.
	*
	* @param biddingId the primary key for the new bidding
	* @return the new bidding
	*/
	@Override
	public com.justonetech.proj.model.Bidding createBidding(long biddingId) {
		return _biddingLocalService.createBidding(biddingId);
	}

	/**
	* Deletes the bidding with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param biddingId the primary key of the bidding
	* @return the bidding that was removed
	* @throws PortalException if a bidding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.proj.model.Bidding deleteBidding(long biddingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.deleteBidding(biddingId);
	}

	/**
	* Deletes the bidding from the database. Also notifies the appropriate model listeners.
	*
	* @param bidding the bidding
	* @return the bidding that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.proj.model.Bidding deleteBidding(
		com.justonetech.proj.model.Bidding bidding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.deleteBidding(bidding);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _biddingLocalService.dynamicQuery();
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
		return _biddingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.BiddingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biddingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.BiddingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _biddingLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _biddingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _biddingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.proj.model.Bidding fetchBidding(long biddingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.fetchBidding(biddingId);
	}

	/**
	* Returns the bidding with the primary key.
	*
	* @param biddingId the primary key of the bidding
	* @return the bidding
	* @throws PortalException if a bidding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.proj.model.Bidding getBidding(long biddingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.getBidding(biddingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the biddings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.BiddingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of biddings
	* @param end the upper bound of the range of biddings (not inclusive)
	* @return the range of biddings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.proj.model.Bidding> getBiddings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.getBiddings(start, end);
	}

	/**
	* Returns the number of biddings.
	*
	* @return the number of biddings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBiddingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.getBiddingsCount();
	}

	/**
	* Updates the bidding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bidding the bidding
	* @return the bidding that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.proj.model.Bidding updateBidding(
		com.justonetech.proj.model.Bidding bidding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _biddingLocalService.updateBidding(bidding);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _biddingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_biddingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _biddingLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BiddingLocalService getWrappedBiddingLocalService() {
		return _biddingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBiddingLocalService(
		BiddingLocalService biddingLocalService) {
		_biddingLocalService = biddingLocalService;
	}

	@Override
	public BiddingLocalService getWrappedService() {
		return _biddingLocalService;
	}

	@Override
	public void setWrappedService(BiddingLocalService biddingLocalService) {
		_biddingLocalService = biddingLocalService;
	}

	private BiddingLocalService _biddingLocalService;
}