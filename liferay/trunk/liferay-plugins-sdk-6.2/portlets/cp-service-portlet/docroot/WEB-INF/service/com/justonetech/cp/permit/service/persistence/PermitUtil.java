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

import com.justonetech.cp.permit.model.Permit;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the permit service. This utility wraps {@link PermitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see PermitPersistence
 * @see PermitPersistenceImpl
 * @generated
 */
public class PermitUtil {
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
	public static void clearCache(Permit permit) {
		getPersistence().clearCache(permit);
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
	public static List<Permit> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Permit> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Permit> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Permit update(Permit permit) throws SystemException {
		return getPersistence().update(permit);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Permit update(Permit permit, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(permit, serviceContext);
	}

	/**
	* Returns all the permits where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @return the matching permits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.Permit> findByZzjgdm(
		java.lang.String zzjgdm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm(zzjgdm);
	}

	/**
	* Returns a range of all the permits where zzjgdm = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.PermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param zzjgdm the zzjgdm
	* @param start the lower bound of the range of permits
	* @param end the upper bound of the range of permits (not inclusive)
	* @return the range of matching permits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.Permit> findByZzjgdm(
		java.lang.String zzjgdm, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm(zzjgdm, start, end);
	}

	/**
	* Returns an ordered range of all the permits where zzjgdm = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.PermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param zzjgdm the zzjgdm
	* @param start the lower bound of the range of permits
	* @param end the upper bound of the range of permits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching permits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.Permit> findByZzjgdm(
		java.lang.String zzjgdm, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByZzjgdm(zzjgdm, start, end, orderByComparator);
	}

	/**
	* Returns the first permit in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching permit
	* @throws com.justonetech.cp.permit.NoSuchPermitException if a matching permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit findByZzjgdm_First(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchPermitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm_First(zzjgdm, orderByComparator);
	}

	/**
	* Returns the first permit in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching permit, or <code>null</code> if a matching permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit fetchByZzjgdm_First(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByZzjgdm_First(zzjgdm, orderByComparator);
	}

	/**
	* Returns the last permit in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching permit
	* @throws com.justonetech.cp.permit.NoSuchPermitException if a matching permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit findByZzjgdm_Last(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchPermitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm_Last(zzjgdm, orderByComparator);
	}

	/**
	* Returns the last permit in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching permit, or <code>null</code> if a matching permit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit fetchByZzjgdm_Last(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByZzjgdm_Last(zzjgdm, orderByComparator);
	}

	/**
	* Returns the permits before and after the current permit in the ordered set where zzjgdm = &#63;.
	*
	* @param permitId the primary key of the current permit
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next permit
	* @throws com.justonetech.cp.permit.NoSuchPermitException if a permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit[] findByZzjgdm_PrevAndNext(
		long permitId, java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.permit.NoSuchPermitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByZzjgdm_PrevAndNext(permitId, zzjgdm, orderByComparator);
	}

	/**
	* Removes all the permits where zzjgdm = &#63; from the database.
	*
	* @param zzjgdm the zzjgdm
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByZzjgdm(java.lang.String zzjgdm)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByZzjgdm(zzjgdm);
	}

	/**
	* Returns the number of permits where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @return the number of matching permits
	* @throws SystemException if a system exception occurred
	*/
	public static int countByZzjgdm(java.lang.String zzjgdm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByZzjgdm(zzjgdm);
	}

	/**
	* Caches the permit in the entity cache if it is enabled.
	*
	* @param permit the permit
	*/
	public static void cacheResult(
		com.justonetech.cp.permit.model.Permit permit) {
		getPersistence().cacheResult(permit);
	}

	/**
	* Caches the permits in the entity cache if it is enabled.
	*
	* @param permits the permits
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.permit.model.Permit> permits) {
		getPersistence().cacheResult(permits);
	}

	/**
	* Creates a new permit with the primary key. Does not add the permit to the database.
	*
	* @param permitId the primary key for the new permit
	* @return the new permit
	*/
	public static com.justonetech.cp.permit.model.Permit create(long permitId) {
		return getPersistence().create(permitId);
	}

	/**
	* Removes the permit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param permitId the primary key of the permit
	* @return the permit that was removed
	* @throws com.justonetech.cp.permit.NoSuchPermitException if a permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit remove(long permitId)
		throws com.justonetech.cp.permit.NoSuchPermitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(permitId);
	}

	public static com.justonetech.cp.permit.model.Permit updateImpl(
		com.justonetech.cp.permit.model.Permit permit)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(permit);
	}

	/**
	* Returns the permit with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchPermitException} if it could not be found.
	*
	* @param permitId the primary key of the permit
	* @return the permit
	* @throws com.justonetech.cp.permit.NoSuchPermitException if a permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit findByPrimaryKey(
		long permitId)
		throws com.justonetech.cp.permit.NoSuchPermitException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(permitId);
	}

	/**
	* Returns the permit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param permitId the primary key of the permit
	* @return the permit, or <code>null</code> if a permit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.permit.model.Permit fetchByPrimaryKey(
		long permitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(permitId);
	}

	/**
	* Returns all the permits.
	*
	* @return the permits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.Permit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the permits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.PermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of permits
	* @param end the upper bound of the range of permits (not inclusive)
	* @return the range of permits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.Permit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the permits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.PermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of permits
	* @param end the upper bound of the range of permits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of permits
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.permit.model.Permit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the permits from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of permits.
	*
	* @return the number of permits
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PermitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PermitPersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.permit.service.ClpSerializer.getServletContextName(),
					PermitPersistence.class.getName());

			ReferenceRegistry.registerReference(PermitUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PermitPersistence persistence) {
	}

	private static PermitPersistence _persistence;
}