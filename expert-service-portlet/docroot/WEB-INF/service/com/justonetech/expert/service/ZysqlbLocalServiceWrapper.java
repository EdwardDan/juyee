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

package com.justonetech.expert.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ZysqlbLocalService}.
 *
 * @author fanqi
 * @see ZysqlbLocalService
 * @generated
 */
public class ZysqlbLocalServiceWrapper implements ZysqlbLocalService,
	ServiceWrapper<ZysqlbLocalService> {
	public ZysqlbLocalServiceWrapper(ZysqlbLocalService zysqlbLocalService) {
		_zysqlbLocalService = zysqlbLocalService;
	}

	/**
	* Adds the zysqlb to the database. Also notifies the appropriate model listeners.
	*
	* @param zysqlb the zysqlb
	* @return the zysqlb that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zysqlb addZysqlb(
		com.justonetech.expert.model.Zysqlb zysqlb)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.addZysqlb(zysqlb);
	}

	/**
	* Creates a new zysqlb with the primary key. Does not add the zysqlb to the database.
	*
	* @param zysqlbId the primary key for the new zysqlb
	* @return the new zysqlb
	*/
	@Override
	public com.justonetech.expert.model.Zysqlb createZysqlb(long zysqlbId) {
		return _zysqlbLocalService.createZysqlb(zysqlbId);
	}

	/**
	* Deletes the zysqlb with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb that was removed
	* @throws PortalException if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zysqlb deleteZysqlb(long zysqlbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.deleteZysqlb(zysqlbId);
	}

	/**
	* Deletes the zysqlb from the database. Also notifies the appropriate model listeners.
	*
	* @param zysqlb the zysqlb
	* @return the zysqlb that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zysqlb deleteZysqlb(
		com.justonetech.expert.model.Zysqlb zysqlb)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.deleteZysqlb(zysqlb);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _zysqlbLocalService.dynamicQuery();
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
		return _zysqlbLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zysqlbLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zysqlbLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _zysqlbLocalService.dynamicQueryCount(dynamicQuery);
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
		return _zysqlbLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.expert.model.Zysqlb fetchZysqlb(long zysqlbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.fetchZysqlb(zysqlbId);
	}

	/**
	* Returns the zysqlb with the primary key.
	*
	* @param zysqlbId the primary key of the zysqlb
	* @return the zysqlb
	* @throws PortalException if a zysqlb with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zysqlb getZysqlb(long zysqlbId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.getZysqlb(zysqlbId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the zysqlbs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zysqlbs
	* @param end the upper bound of the range of zysqlbs (not inclusive)
	* @return the range of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.expert.model.Zysqlb> getZysqlbs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.getZysqlbs(start, end);
	}

	/**
	* Returns the number of zysqlbs.
	*
	* @return the number of zysqlbs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getZysqlbsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.getZysqlbsCount();
	}

	/**
	* Updates the zysqlb in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param zysqlb the zysqlb
	* @return the zysqlb that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zysqlb updateZysqlb(
		com.justonetech.expert.model.Zysqlb zysqlb)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zysqlbLocalService.updateZysqlb(zysqlb);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _zysqlbLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_zysqlbLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _zysqlbLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.expert.model.Zysqlb> getZysqlbs(
		java.lang.String keyWord, int start, int end) {
		return _zysqlbLocalService.getZysqlbs(keyWord, start, end);
	}

	@Override
	public java.util.List<com.justonetech.expert.model.Zysqlb> getZysqlbs(
		long expertId, int start, int end) {
		return _zysqlbLocalService.getZysqlbs(expertId, start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		long expertId) {
		return _zysqlbLocalService.createDynamicQuery(expertId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQuery(
		java.lang.String keyWord) {
		return _zysqlbLocalService.createDynamicQuery(keyWord);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ZysqlbLocalService getWrappedZysqlbLocalService() {
		return _zysqlbLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedZysqlbLocalService(
		ZysqlbLocalService zysqlbLocalService) {
		_zysqlbLocalService = zysqlbLocalService;
	}

	@Override
	public ZysqlbLocalService getWrappedService() {
		return _zysqlbLocalService;
	}

	@Override
	public void setWrappedService(ZysqlbLocalService zysqlbLocalService) {
		_zysqlbLocalService = zysqlbLocalService;
	}

	private ZysqlbLocalService _zysqlbLocalService;
}