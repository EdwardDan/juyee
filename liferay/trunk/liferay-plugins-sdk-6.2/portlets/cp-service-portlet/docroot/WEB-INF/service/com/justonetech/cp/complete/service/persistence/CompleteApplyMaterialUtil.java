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

package com.justonetech.cp.complete.service.persistence;

import com.justonetech.cp.complete.model.CompleteApplyMaterial;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the complete apply material service. This utility wraps {@link CompleteApplyMaterialPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompleteApplyMaterialPersistence
 * @see CompleteApplyMaterialPersistenceImpl
 * @generated
 */
public class CompleteApplyMaterialUtil {
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
	public static void clearCache(CompleteApplyMaterial completeApplyMaterial) {
		getPersistence().clearCache(completeApplyMaterial);
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
	public static List<CompleteApplyMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CompleteApplyMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CompleteApplyMaterial> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CompleteApplyMaterial update(
		CompleteApplyMaterial completeApplyMaterial) throws SystemException {
		return getPersistence().update(completeApplyMaterial);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CompleteApplyMaterial update(
		CompleteApplyMaterial completeApplyMaterial,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(completeApplyMaterial, serviceContext);
	}

	/**
	* Returns all the complete apply materials where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @return the matching complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> findByCompleteId(
		long completeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompleteId(completeId);
	}

	/**
	* Returns a range of all the complete apply materials where completeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param completeId the complete ID
	* @param start the lower bound of the range of complete apply materials
	* @param end the upper bound of the range of complete apply materials (not inclusive)
	* @return the range of matching complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> findByCompleteId(
		long completeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompleteId(completeId, start, end);
	}

	/**
	* Returns an ordered range of all the complete apply materials where completeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param completeId the complete ID
	* @param start the lower bound of the range of complete apply materials
	* @param end the upper bound of the range of complete apply materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> findByCompleteId(
		long completeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompleteId(completeId, start, end, orderByComparator);
	}

	/**
	* Returns the first complete apply material in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complete apply material
	* @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a matching complete apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial findByCompleteId_First(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompleteId_First(completeId, orderByComparator);
	}

	/**
	* Returns the first complete apply material in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complete apply material, or <code>null</code> if a matching complete apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial fetchByCompleteId_First(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompleteId_First(completeId, orderByComparator);
	}

	/**
	* Returns the last complete apply material in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complete apply material
	* @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a matching complete apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial findByCompleteId_Last(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompleteId_Last(completeId, orderByComparator);
	}

	/**
	* Returns the last complete apply material in the ordered set where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complete apply material, or <code>null</code> if a matching complete apply material could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial fetchByCompleteId_Last(
		long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompleteId_Last(completeId, orderByComparator);
	}

	/**
	* Returns the complete apply materials before and after the current complete apply material in the ordered set where completeId = &#63;.
	*
	* @param materialId the primary key of the current complete apply material
	* @param completeId the complete ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complete apply material
	* @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial[] findByCompleteId_PrevAndNext(
		long materialId, long completeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompleteId_PrevAndNext(materialId, completeId,
			orderByComparator);
	}

	/**
	* Removes all the complete apply materials where completeId = &#63; from the database.
	*
	* @param completeId the complete ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompleteId(long completeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompleteId(completeId);
	}

	/**
	* Returns the number of complete apply materials where completeId = &#63;.
	*
	* @param completeId the complete ID
	* @return the number of matching complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompleteId(long completeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompleteId(completeId);
	}

	/**
	* Caches the complete apply material in the entity cache if it is enabled.
	*
	* @param completeApplyMaterial the complete apply material
	*/
	public static void cacheResult(
		com.justonetech.cp.complete.model.CompleteApplyMaterial completeApplyMaterial) {
		getPersistence().cacheResult(completeApplyMaterial);
	}

	/**
	* Caches the complete apply materials in the entity cache if it is enabled.
	*
	* @param completeApplyMaterials the complete apply materials
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> completeApplyMaterials) {
		getPersistence().cacheResult(completeApplyMaterials);
	}

	/**
	* Creates a new complete apply material with the primary key. Does not add the complete apply material to the database.
	*
	* @param materialId the primary key for the new complete apply material
	* @return the new complete apply material
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial create(
		long materialId) {
		return getPersistence().create(materialId);
	}

	/**
	* Removes the complete apply material with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param materialId the primary key of the complete apply material
	* @return the complete apply material that was removed
	* @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial remove(
		long materialId)
		throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(materialId);
	}

	public static com.justonetech.cp.complete.model.CompleteApplyMaterial updateImpl(
		com.justonetech.cp.complete.model.CompleteApplyMaterial completeApplyMaterial)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(completeApplyMaterial);
	}

	/**
	* Returns the complete apply material with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException} if it could not be found.
	*
	* @param materialId the primary key of the complete apply material
	* @return the complete apply material
	* @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial findByPrimaryKey(
		long materialId)
		throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(materialId);
	}

	/**
	* Returns the complete apply material with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param materialId the primary key of the complete apply material
	* @return the complete apply material, or <code>null</code> if a complete apply material with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.CompleteApplyMaterial fetchByPrimaryKey(
		long materialId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(materialId);
	}

	/**
	* Returns all the complete apply materials.
	*
	* @return the complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the complete apply materials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of complete apply materials
	* @param end the upper bound of the range of complete apply materials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.CompleteApplyMaterial> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the complete apply materials from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of complete apply materials.
	*
	* @return the number of complete apply materials
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CompleteApplyMaterialPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CompleteApplyMaterialPersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.complete.service.ClpSerializer.getServletContextName(),
					CompleteApplyMaterialPersistence.class.getName());

			ReferenceRegistry.registerReference(CompleteApplyMaterialUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CompleteApplyMaterialPersistence persistence) {
	}

	private static CompleteApplyMaterialPersistence _persistence;
}