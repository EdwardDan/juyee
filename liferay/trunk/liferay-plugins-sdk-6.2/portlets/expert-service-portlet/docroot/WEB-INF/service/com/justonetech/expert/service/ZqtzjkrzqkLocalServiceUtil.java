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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Zqtzjkrzqk. This utility wraps
 * {@link com.justonetech.expert.service.impl.ZqtzjkrzqkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author fanqi
 * @see ZqtzjkrzqkLocalService
 * @see com.justonetech.expert.service.base.ZqtzjkrzqkLocalServiceBaseImpl
 * @see com.justonetech.expert.service.impl.ZqtzjkrzqkLocalServiceImpl
 * @generated
 */
public class ZqtzjkrzqkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.justonetech.expert.service.impl.ZqtzjkrzqkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the zqtzjkrzqk to the database. Also notifies the appropriate model listeners.
	*
	* @param zqtzjkrzqk the zqtzjkrzqk
	* @return the zqtzjkrzqk that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk addZqtzjkrzqk(
		com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addZqtzjkrzqk(zqtzjkrzqk);
	}

	/**
	* Creates a new zqtzjkrzqk with the primary key. Does not add the zqtzjkrzqk to the database.
	*
	* @param zqtzjkrzqkId the primary key for the new zqtzjkrzqk
	* @return the new zqtzjkrzqk
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk createZqtzjkrzqk(
		long zqtzjkrzqkId) {
		return getService().createZqtzjkrzqk(zqtzjkrzqkId);
	}

	/**
	* Deletes the zqtzjkrzqk with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	* @return the zqtzjkrzqk that was removed
	* @throws PortalException if a zqtzjkrzqk with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk deleteZqtzjkrzqk(
		long zqtzjkrzqkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteZqtzjkrzqk(zqtzjkrzqkId);
	}

	/**
	* Deletes the zqtzjkrzqk from the database. Also notifies the appropriate model listeners.
	*
	* @param zqtzjkrzqk the zqtzjkrzqk
	* @return the zqtzjkrzqk that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk deleteZqtzjkrzqk(
		com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteZqtzjkrzqk(zqtzjkrzqk);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.justonetech.expert.model.Zqtzjkrzqk fetchZqtzjkrzqk(
		long zqtzjkrzqkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchZqtzjkrzqk(zqtzjkrzqkId);
	}

	/**
	* Returns the zqtzjkrzqk with the primary key.
	*
	* @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	* @return the zqtzjkrzqk
	* @throws PortalException if a zqtzjkrzqk with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk getZqtzjkrzqk(
		long zqtzjkrzqkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getZqtzjkrzqk(zqtzjkrzqkId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the zqtzjkrzqks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of zqtzjkrzqks
	* @param end the upper bound of the range of zqtzjkrzqks (not inclusive)
	* @return the range of zqtzjkrzqks
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.expert.model.Zqtzjkrzqk> getZqtzjkrzqks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getZqtzjkrzqks(start, end);
	}

	/**
	* Returns the number of zqtzjkrzqks.
	*
	* @return the number of zqtzjkrzqks
	* @throws SystemException if a system exception occurred
	*/
	public static int getZqtzjkrzqksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getZqtzjkrzqksCount();
	}

	/**
	* Updates the zqtzjkrzqk in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param zqtzjkrzqk the zqtzjkrzqk
	* @return the zqtzjkrzqk that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.expert.model.Zqtzjkrzqk updateZqtzjkrzqk(
		com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateZqtzjkrzqk(zqtzjkrzqk);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static ZqtzjkrzqkLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ZqtzjkrzqkLocalService.class.getName());

			if (invokableLocalService instanceof ZqtzjkrzqkLocalService) {
				_service = (ZqtzjkrzqkLocalService)invokableLocalService;
			}
			else {
				_service = new ZqtzjkrzqkLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ZqtzjkrzqkLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ZqtzjkrzqkLocalService service) {
	}

	private static ZqtzjkrzqkLocalService _service;
}