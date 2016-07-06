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

package com.justonetech.oa.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DeptWork. This utility wraps
 * {@link com.justonetech.oa.service.impl.DeptWorkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author justonetech
 * @see DeptWorkLocalService
 * @see com.justonetech.oa.service.base.DeptWorkLocalServiceBaseImpl
 * @see com.justonetech.oa.service.impl.DeptWorkLocalServiceImpl
 * @generated
 */
public class DeptWorkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.justonetech.oa.service.impl.DeptWorkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the dept work to the database. Also notifies the appropriate model listeners.
	*
	* @param deptWork the dept work
	* @return the dept work that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork addDeptWork(
		com.justonetech.oa.model.DeptWork deptWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDeptWork(deptWork);
	}

	/**
	* Creates a new dept work with the primary key. Does not add the dept work to the database.
	*
	* @param deptWorkId the primary key for the new dept work
	* @return the new dept work
	*/
	public static com.justonetech.oa.model.DeptWork createDeptWork(
		long deptWorkId) {
		return getService().createDeptWork(deptWorkId);
	}

	/**
	* Deletes the dept work with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deptWorkId the primary key of the dept work
	* @return the dept work that was removed
	* @throws PortalException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork deleteDeptWork(
		long deptWorkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDeptWork(deptWorkId);
	}

	/**
	* Deletes the dept work from the database. Also notifies the appropriate model listeners.
	*
	* @param deptWork the dept work
	* @return the dept work that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork deleteDeptWork(
		com.justonetech.oa.model.DeptWork deptWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDeptWork(deptWork);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.justonetech.oa.model.DeptWork fetchDeptWork(
		long deptWorkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDeptWork(deptWorkId);
	}

	/**
	* Returns the dept work with the primary key.
	*
	* @param deptWorkId the primary key of the dept work
	* @return the dept work
	* @throws PortalException if a dept work with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork getDeptWork(long deptWorkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeptWork(deptWorkId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dept works.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dept works
	* @param end the upper bound of the range of dept works (not inclusive)
	* @return the range of dept works
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.oa.model.DeptWork> getDeptWorks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeptWorks(start, end);
	}

	/**
	* Returns the number of dept works.
	*
	* @return the number of dept works
	* @throws SystemException if a system exception occurred
	*/
	public static int getDeptWorksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeptWorksCount();
	}

	/**
	* Updates the dept work in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param deptWork the dept work
	* @return the dept work that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.oa.model.DeptWork updateDeptWork(
		com.justonetech.oa.model.DeptWork deptWork)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDeptWork(deptWork);
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

	public static java.util.List<com.justonetech.oa.model.DeptWork> findByUserName(
		java.lang.String userName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserName(userName, start, end);
	}

	public static int countByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserName(userName);
	}

	public static java.util.List<com.justonetech.oa.model.DeptWork> findByDeptName(
		java.lang.String deptName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByDeptName(deptName, start, end);
	}

	public static int countByDeptName(java.lang.String deptName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByDeptName(deptName);
	}

	public static void deleteDeptWorks(java.lang.String[] deptWorkIds) {
		getService().deleteDeptWorks(deptWorkIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static DeptWorkLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DeptWorkLocalService.class.getName());

			if (invokableLocalService instanceof DeptWorkLocalService) {
				_service = (DeptWorkLocalService)invokableLocalService;
			}
			else {
				_service = new DeptWorkLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DeptWorkLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DeptWorkLocalService service) {
	}

	private static DeptWorkLocalService _service;
}