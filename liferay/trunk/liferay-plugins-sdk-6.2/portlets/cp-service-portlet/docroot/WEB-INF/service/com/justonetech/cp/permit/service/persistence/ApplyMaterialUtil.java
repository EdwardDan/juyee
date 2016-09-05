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

package com.justonetech.cp.permit.service.persistence;

import com.justonetech.cp.permit.model.ApplyMaterial;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the apply material service. This utility wraps {@link ApplyMaterialPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ApplyMaterialPersistence
 * @see ApplyMaterialPersistenceImpl
 * @generated
 */
public class ApplyMaterialUtil {
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
	public static void clearCache(ApplyMaterial applyMaterial) {
		getPersistence().clearCache(applyMaterial);
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
	public static List<ApplyMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplyMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplyMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ApplyMaterial update(ApplyMaterial applyMaterial)
		throws SystemException {
		return getPersistence().update(applyMaterial);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ApplyMaterial update(ApplyMaterial applyMaterial,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(applyMaterial, serviceContext);
	}

	/**
	* Returns all the apply materials where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the matching apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> findByPermitId(
		java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId(permitId);
	}

	/**
	* Returns a range of all the apply materials where permitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param permitId the permit ID
	* @param start the lower bound of the range of apply materials
	* @param end the upper bound of the range of apply materials (not inclusive)
	* @return the range of matching apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> findByPermitId(
		java.lang.String permitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId(permitId, start, end);
	}

	/**
	* Returns an ordered range of all the apply materials where permitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param permitId the permit ID
	* @param start the lower bound of the range of apply materials
	* @param end the upper bound of the range of apply materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> findByPermitId(
		java.lang.String permitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPermitId(permitId, start, end, orderByComparator);
	}

	/**
	* Returns the first apply material in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching apply material
	* @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a matching apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial findByPermitId_First(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId_First(permitId, orderByComparator);
	}

	/**
	* Returns the first apply material in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching apply material, or <code>null</code> if a matching apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial fetchByPermitId_First(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPermitId_First(permitId, orderByComparator);
	}

	/**
	* Returns the last apply material in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching apply material
	* @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a matching apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial findByPermitId_Last(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPermitId_Last(permitId, orderByComparator);
	}

	/**
	* Returns the last apply material in the ordered set where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching apply material, or <code>null</code> if a matching apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial fetchByPermitId_Last(
		java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPermitId_Last(permitId, orderByComparator);
	}

	/**
	* Returns the apply materials before and after the current apply material in the ordered set where permitId = &#63;.
	*
	* @param materialId the primary key of the current apply material
	* @param permitId the permit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next apply material
	* @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial[] findByPermitId_PrevAndNext(
		long materialId, java.lang.String permitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPermitId_PrevAndNext(materialId, permitId,
			orderByComparator);
	}

	/**
	* Removes all the apply materials where permitId = &#63; from the database.
	*
	* @param permitId the permit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPermitId(java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPermitId(permitId);
	}

	/**
	* Returns the number of apply materials where permitId = &#63;.
	*
	* @param permitId the permit ID
	* @return the number of matching apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPermitId(java.lang.String permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPermitId(permitId);
	}

	/**
	* Caches the apply material in the entity cache if it is enabled.
	*
	* @param applyMaterial the apply material
	*/
	public static void cacheResult(
		com.justonetech.cp.permit.model.ApplyMaterial applyMaterial) {
		getPersistence().cacheResult(applyMaterial);
	}

	/**
	* Caches the apply materials in the entity cache if it is enabled.
	*
	* @param applyMaterials the apply materials
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> applyMaterials) {
		getPersistence().cacheResult(applyMaterials);
	}

	/**
	* Creates a new apply material with the primary key. Does not add the apply material to the database.
	*
	* @param materialId the primary key for the new apply material
	* @return the new apply material
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial create(
		long materialId) {
		return getPersistence().create(materialId);
	}

	/**
	* Removes the apply material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param materialId the primary key of the apply material
	* @return the apply material that was removed
	* @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial remove(
		long materialId)
		throws com.justonetech.cp.permit.NoSuchApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(materialId);
	}

	public static com.justonetech.cp.permit.model.ApplyMaterial updateImpl(
		com.justonetech.cp.permit.model.ApplyMaterial applyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(applyMaterial);
	}

	/**
	* Returns the apply material with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchApplyMaterialException} if it could not be found.
	*
	* @param materialId the primary key of the apply material
	* @return the apply material
	* @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial findByPrimaryKey(
		long materialId)
		throws com.justonetech.cp.permit.NoSuchApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(materialId);
	}

	/**
	* Returns the apply material with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param materialId the primary key of the apply material
	* @return the apply material, or <code>null</code> if a apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.ApplyMaterial fetchByPrimaryKey(
		long materialId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(materialId);
	}

	/**
	* Returns all the apply materials.
	*
	* @return the apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the apply materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of apply materials
	* @param end the upper bound of the range of apply materials (not inclusive)
	* @return the range of apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the apply materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of apply materials
	* @param end the upper bound of the range of apply materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.ApplyMaterial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the apply materials from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of apply materials.
	*
	* @return the number of apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ApplyMaterialPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApplyMaterialPersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.permit.service.ClpSerializer.getServletContextName(),
					ApplyMaterialPersistence.class.getName());

			ReferenceRegistry.registerReference(ApplyMaterialUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ApplyMaterialPersistence persistence) {
	}

	private static ApplyMaterialPersistence _persistence;
}