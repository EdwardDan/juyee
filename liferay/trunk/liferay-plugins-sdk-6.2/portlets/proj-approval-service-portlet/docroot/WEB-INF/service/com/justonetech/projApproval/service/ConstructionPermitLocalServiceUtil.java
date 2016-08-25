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

package com.justonetech.projApproval.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ConstructionPermit. This utility wraps
 * {@link com.justonetech.projApproval.service.impl.ConstructionPermitLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author justonetech
 * @see ConstructionPermitLocalService
 * @see com.justonetech.projApproval.service.base.ConstructionPermitLocalServiceBaseImpl
 * @see com.justonetech.projApproval.service.impl.ConstructionPermitLocalServiceImpl
 * @generated
 */
public class ConstructionPermitLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.justonetech.projApproval.service.impl.ConstructionPermitLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the construction permit to the database. Also notifies the appropriate model listeners.
	*
	* @param constructionPermit the construction permit
	* @return the construction permit that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionPermit addConstructionPermit(
		com.justonetech.projApproval.model.ConstructionPermit constructionPermit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addConstructionPermit(constructionPermit);
	}

	/**
	* Creates a new construction permit with the primary key. Does not add the construction permit to the database.
	*
	* @param constructionPermitId the primary key for the new construction permit
	* @return the new construction permit
	*/
	public static com.justonetech.projApproval.model.ConstructionPermit createConstructionPermit(
		long constructionPermitId) {
		return getService().createConstructionPermit(constructionPermitId);
	}

	/**
	* Deletes the construction permit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param constructionPermitId the primary key of the construction permit
	* @return the construction permit that was removed
	* @throws PortalException if a construction permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionPermit deleteConstructionPermit(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConstructionPermit(constructionPermitId);
	}

	/**
	* Deletes the construction permit from the database. Also notifies the appropriate model listeners.
	*
	* @param constructionPermit the construction permit
	* @return the construction permit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionPermit deleteConstructionPermit(
		com.justonetech.projApproval.model.ConstructionPermit constructionPermit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteConstructionPermit(constructionPermit);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.justonetech.projApproval.model.ConstructionPermit fetchConstructionPermit(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchConstructionPermit(constructionPermitId);
	}

	/**
	* Returns the construction permit with the primary key.
	*
	* @param constructionPermitId the primary key of the construction permit
	* @return the construction permit
	* @throws PortalException if a construction permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionPermit getConstructionPermit(
		long constructionPermitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConstructionPermit(constructionPermitId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the construction permits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of construction permits
	* @param end the upper bound of the range of construction permits (not inclusive)
	* @return the range of construction permits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.projApproval.model.ConstructionPermit> getConstructionPermits(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConstructionPermits(start, end);
	}

	/**
	* Returns the number of construction permits.
	*
	* @return the number of construction permits
	* @throws SystemException if a system exception occurred
	*/
	public static int getConstructionPermitsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConstructionPermitsCount();
	}

	/**
	* Updates the construction permit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param constructionPermit the construction permit
	* @return the construction permit that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.projApproval.model.ConstructionPermit updateConstructionPermit(
		com.justonetech.projApproval.model.ConstructionPermit constructionPermit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateConstructionPermit(constructionPermit);
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

	public static java.util.List<com.justonetech.projApproval.model.ConstructionPermit> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId(userId, start, end);
	}

	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserId(userId);
	}

	public static void deleteConstructionPermits(
		java.lang.String[] constructionPermitIds) {
		getService().deleteConstructionPermits(constructionPermitIds);
	}

	public static com.justonetech.projApproval.model.ConstructionPermit updateStatus(
		long userId, long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, resourcePrimKey, status, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConstructionPermitLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConstructionPermitLocalService.class.getName());

			if (invokableLocalService instanceof ConstructionPermitLocalService) {
				_service = (ConstructionPermitLocalService)invokableLocalService;
			}
			else {
				_service = new ConstructionPermitLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ConstructionPermitLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ConstructionPermitLocalService service) {
	}

	private static ConstructionPermitLocalService _service;
}