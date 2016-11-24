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
 * Provides a wrapper for {@link ZzjlLocalService}.
 *
 * @author fanqi
 * @see ZzjlLocalService
 * @generated
 */
public class ZzjlLocalServiceWrapper implements ZzjlLocalService,
	ServiceWrapper<ZzjlLocalService> {
	public ZzjlLocalServiceWrapper(ZzjlLocalService zzjlLocalService) {
		_zzjlLocalService = zzjlLocalService;
	}

	/**
	* Adds the zzjl to the database. Also notifies the appropriate model listeners.
	*
	* @param zzjl the zzjl
	* @return the zzjl that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zzjl addZzjl(
		com.justonetech.expert.model.Zzjl zzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.addZzjl(zzjl);
	}

	/**
	* Creates a new zzjl with the primary key. Does not add the zzjl to the database.
	*
	* @param zzjlId the primary key for the new zzjl
	* @return the new zzjl
	*/
	@Override
	public com.justonetech.expert.model.Zzjl createZzjl(long zzjlId) {
		return _zzjlLocalService.createZzjl(zzjlId);
	}

	/**
	* Deletes the zzjl with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl that was removed
	* @throws PortalException if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zzjl deleteZzjl(long zzjlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.deleteZzjl(zzjlId);
	}

	/**
	* Deletes the zzjl from the database. Also notifies the appropriate model listeners.
	*
	* @param zzjl the zzjl
	* @return the zzjl that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zzjl deleteZzjl(
		com.justonetech.expert.model.Zzjl zzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.deleteZzjl(zzjl);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _zzjlLocalService.dynamicQuery();
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
		return _zzjlLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zzjlLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _zzjlLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _zzjlLocalService.dynamicQueryCount(dynamicQuery);
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
		return _zzjlLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.justonetech.expert.model.Zzjl fetchZzjl(long zzjlId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.fetchZzjl(zzjlId);
	}

	/**
	* Returns the zzjl with the primary key.
	*
	* @param zzjlId the primary key of the zzjl
	* @return the zzjl
	* @throws PortalException if a zzjl with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zzjl getZzjl(long zzjlId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.getZzjl(zzjlId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the zzjls.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zzjls
	* @param end the upper bound of the range of zzjls (not inclusive)
	* @return the range of zzjls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.expert.model.Zzjl> getZzjls(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.getZzjls(start, end);
	}

	/**
	* Returns the number of zzjls.
	*
	* @return the number of zzjls
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getZzjlsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.getZzjlsCount();
	}

	/**
	* Updates the zzjl in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param zzjl the zzjl
	* @return the zzjl that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.expert.model.Zzjl updateZzjl(
		com.justonetech.expert.model.Zzjl zzjl)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _zzjlLocalService.updateZzjl(zzjl);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _zzjlLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_zzjlLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _zzjlLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ZzjlLocalService getWrappedZzjlLocalService() {
		return _zzjlLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedZzjlLocalService(ZzjlLocalService zzjlLocalService) {
		_zzjlLocalService = zzjlLocalService;
	}

	@Override
	public ZzjlLocalService getWrappedService() {
		return _zzjlLocalService;
	}

	@Override
	public void setWrappedService(ZzjlLocalService zzjlLocalService) {
		_zzjlLocalService = zzjlLocalService;
	}

	private ZzjlLocalService _zzjlLocalService;
}