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

import com.justonetech.cp.complete.model.Complete;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the complete service. This utility wraps {@link CompletePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompletePersistence
 * @see CompletePersistenceImpl
 * @generated
 */
public class CompleteUtil {
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
	public static void clearCache(Complete complete) {
		getPersistence().clearCache(complete);
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
	public static List<Complete> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Complete> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Complete> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Complete update(Complete complete) throws SystemException {
		return getPersistence().update(complete);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Complete update(Complete complete,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(complete, serviceContext);
	}

	/**
	* Returns all the completes where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @return the matching completes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.Complete> findByZzjgdm(
		java.lang.String zzjgdm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm(zzjgdm);
	}

	/**
	* Returns a range of all the completes where zzjgdm = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param zzjgdm the zzjgdm
	* @param start the lower bound of the range of completes
	* @param end the upper bound of the range of completes (not inclusive)
	* @return the range of matching completes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.Complete> findByZzjgdm(
		java.lang.String zzjgdm, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm(zzjgdm, start, end);
	}

	/**
	* Returns an ordered range of all the completes where zzjgdm = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param zzjgdm the zzjgdm
	* @param start the lower bound of the range of completes
	* @param end the upper bound of the range of completes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching completes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.Complete> findByZzjgdm(
		java.lang.String zzjgdm, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByZzjgdm(zzjgdm, start, end, orderByComparator);
	}

	/**
	* Returns the first complete in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complete
	* @throws com.justonetech.cp.complete.NoSuchCompleteException if a matching complete could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete findByZzjgdm_First(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm_First(zzjgdm, orderByComparator);
	}

	/**
	* Returns the first complete in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching complete, or <code>null</code> if a matching complete could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete fetchByZzjgdm_First(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByZzjgdm_First(zzjgdm, orderByComparator);
	}

	/**
	* Returns the last complete in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complete
	* @throws com.justonetech.cp.complete.NoSuchCompleteException if a matching complete could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete findByZzjgdm_Last(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByZzjgdm_Last(zzjgdm, orderByComparator);
	}

	/**
	* Returns the last complete in the ordered set where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching complete, or <code>null</code> if a matching complete could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete fetchByZzjgdm_Last(
		java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByZzjgdm_Last(zzjgdm, orderByComparator);
	}

	/**
	* Returns the completes before and after the current complete in the ordered set where zzjgdm = &#63;.
	*
	* @param completeId the primary key of the current complete
	* @param zzjgdm the zzjgdm
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next complete
	* @throws com.justonetech.cp.complete.NoSuchCompleteException if a complete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete[] findByZzjgdm_PrevAndNext(
		long completeId, java.lang.String zzjgdm,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.cp.complete.NoSuchCompleteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByZzjgdm_PrevAndNext(completeId, zzjgdm,
			orderByComparator);
	}

	/**
	* Removes all the completes where zzjgdm = &#63; from the database.
	*
	* @param zzjgdm the zzjgdm
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByZzjgdm(java.lang.String zzjgdm)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByZzjgdm(zzjgdm);
	}

	/**
	* Returns the number of completes where zzjgdm = &#63;.
	*
	* @param zzjgdm the zzjgdm
	* @return the number of matching completes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByZzjgdm(java.lang.String zzjgdm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByZzjgdm(zzjgdm);
	}

	/**
	* Caches the complete in the entity cache if it is enabled.
	*
	* @param complete the complete
	*/
	public static void cacheResult(
		com.justonetech.cp.complete.model.Complete complete) {
		getPersistence().cacheResult(complete);
	}

	/**
	* Caches the completes in the entity cache if it is enabled.
	*
	* @param completes the completes
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.cp.complete.model.Complete> completes) {
		getPersistence().cacheResult(completes);
	}

	/**
	* Creates a new complete with the primary key. Does not add the complete to the database.
	*
	* @param completeId the primary key for the new complete
	* @return the new complete
	*/
	public static com.justonetech.cp.complete.model.Complete create(
		long completeId) {
		return getPersistence().create(completeId);
	}

	/**
	* Removes the complete with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param completeId the primary key of the complete
	* @return the complete that was removed
	* @throws com.justonetech.cp.complete.NoSuchCompleteException if a complete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete remove(
		long completeId)
		throws com.justonetech.cp.complete.NoSuchCompleteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(completeId);
	}

	public static com.justonetech.cp.complete.model.Complete updateImpl(
		com.justonetech.cp.complete.model.Complete complete)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(complete);
	}

	/**
	* Returns the complete with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteException} if it could not be found.
	*
	* @param completeId the primary key of the complete
	* @return the complete
	* @throws com.justonetech.cp.complete.NoSuchCompleteException if a complete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete findByPrimaryKey(
		long completeId)
		throws com.justonetech.cp.complete.NoSuchCompleteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(completeId);
	}

	/**
	* Returns the complete with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param completeId the primary key of the complete
	* @return the complete, or <code>null</code> if a complete with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.cp.complete.model.Complete fetchByPrimaryKey(
		long completeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(completeId);
	}

	/**
	* Returns all the completes.
	*
	* @return the completes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.Complete> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the completes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of completes
	* @param end the upper bound of the range of completes (not inclusive)
	* @return the range of completes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.Complete> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the completes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of completes
	* @param end the upper bound of the range of completes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of completes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.cp.complete.model.Complete> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the completes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of completes.
	*
	* @return the number of completes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CompletePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CompletePersistence)PortletBeanLocatorUtil.locate(com.justonetech.cp.complete.service.ClpSerializer.getServletContextName(),
					CompletePersistence.class.getName());

			ReferenceRegistry.registerReference(CompleteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CompletePersistence persistence) {
	}

	private static CompletePersistence _persistence;
}