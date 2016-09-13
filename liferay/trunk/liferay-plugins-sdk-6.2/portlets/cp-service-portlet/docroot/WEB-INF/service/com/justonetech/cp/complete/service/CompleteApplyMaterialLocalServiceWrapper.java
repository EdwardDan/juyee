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

package com.justonetech.cp.complete.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CompleteApplyMaterialLocalService}.
 *
 * @author fanqi
 * @see CompleteApplyMaterialLocalService
 * @generated
 */
public class CompleteApplyMaterialLocalServiceWrapper
	implements CompleteApplyMaterialLocalService,
		ServiceWrapper<CompleteApplyMaterialLocalService> {
	public CompleteApplyMaterialLocalServiceWrapper(
		CompleteApplyMaterialLocalService completeApplyMaterialLocalService) {
		_completeApplyMaterialLocalService = completeApplyMaterialLocalService;
	}

	/**
	* Adds the complete apply material to the database. Also notifies the appropriate model listeners.
	*
	* @param completeApplyMaterial the complete apply material
	* @return the complete apply material that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteApplyMaterial addCompleteApplyMaterial(
		com.justonetech.cp.complete.model.CompleteApplyMaterial completeApplyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.addCompleteApplyMaterial(completeApplyMaterial);
	}

	/**
	* Creates a new complete apply material with the primary key. Does not add the complete apply material to the database.
	*
	* @param materialId the primary key for the new complete apply material
	* @return the new complete apply material
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteApplyMaterial createCompleteApplyMaterial(
		long materialId) {
		return _completeApplyMaterialLocalService.createCompleteApplyMaterial(materialId);
	}

	/**
	* Deletes the complete apply material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param materialId the primary key of the complete apply material
	* @return the complete apply material that was removed
	* @throws PortalException if a complete apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteApplyMaterial deleteCompleteApplyMaterial(
		long materialId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.deleteCompleteApplyMaterial(materialId);
	}

	/**
	* Deletes the complete apply material from the database. Also notifies the appropriate model listeners.
	*
	* @param completeApplyMaterial the complete apply material
	* @return the complete apply material that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteApplyMaterial deleteCompleteApplyMaterial(
		com.justonetech.cp.complete.model.CompleteApplyMaterial completeApplyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.deleteCompleteApplyMaterial(completeApplyMaterial);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _completeApplyMaterialLocalService.dynamicQuery();
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
		return _completeApplyMaterialLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _completeApplyMaterialLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _completeApplyMaterialLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _completeApplyMaterialLocalService.dynamicQueryCount(dynamicQuery);
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
		return _completeApplyMaterialLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.cp.complete.model.CompleteApplyMaterial fetchCompleteApplyMaterial(
		long materialId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.fetchCompleteApplyMaterial(materialId);
	}

	/**
	* Returns the complete apply material with the primary key.
	*
	* @param materialId the primary key of the complete apply material
	* @return the complete apply material
	* @throws PortalException if a complete apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteApplyMaterial getCompleteApplyMaterial(
		long materialId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.getCompleteApplyMaterial(materialId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the complete apply materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of complete apply materials
	* @param end the upper bound of the range of complete apply materials (not inclusive)
	* @return the range of complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> getCompleteApplyMaterials(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.getCompleteApplyMaterials(start,
			end);
	}

	/**
	* Returns the number of complete apply materials.
	*
	* @return the number of complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCompleteApplyMaterialsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.getCompleteApplyMaterialsCount();
	}

	/**
	* Updates the complete apply material in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param completeApplyMaterial the complete apply material
	* @return the complete apply material that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.cp.complete.model.CompleteApplyMaterial updateCompleteApplyMaterial(
		com.justonetech.cp.complete.model.CompleteApplyMaterial completeApplyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _completeApplyMaterialLocalService.updateCompleteApplyMaterial(completeApplyMaterial);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _completeApplyMaterialLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_completeApplyMaterialLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _completeApplyMaterialLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> findByCompleteId(
		long completeId, int start, int end) {
		return _completeApplyMaterialLocalService.findByCompleteId(completeId,
			start, end);
	}

	@Override
	public int countByCompleteId(long completeId) {
		return _completeApplyMaterialLocalService.countByCompleteId(completeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CompleteApplyMaterialLocalService getWrappedCompleteApplyMaterialLocalService() {
		return _completeApplyMaterialLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCompleteApplyMaterialLocalService(
		CompleteApplyMaterialLocalService completeApplyMaterialLocalService) {
		_completeApplyMaterialLocalService = completeApplyMaterialLocalService;
	}

	@Override
	public CompleteApplyMaterialLocalService getWrappedService() {
		return _completeApplyMaterialLocalService;
	}

	@Override
	public void setWrappedService(
		CompleteApplyMaterialLocalService completeApplyMaterialLocalService) {
		_completeApplyMaterialLocalService = completeApplyMaterialLocalService;
	}

	private CompleteApplyMaterialLocalService _completeApplyMaterialLocalService;
}