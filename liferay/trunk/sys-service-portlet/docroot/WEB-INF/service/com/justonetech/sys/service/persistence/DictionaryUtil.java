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

package com.justonetech.sys.service.persistence;

import com.justonetech.sys.model.Dictionary;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dictionary service. This utility wraps {@link DictionaryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DictionaryPersistence
 * @see DictionaryPersistenceImpl
 * @generated
 */
public class DictionaryUtil {
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
	public static void clearCache(Dictionary dictionary) {
		getPersistence().clearCache(dictionary);
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
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Dictionary update(Dictionary dictionary)
		throws SystemException {
		return getPersistence().update(dictionary);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Dictionary update(Dictionary dictionary,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(dictionary, serviceContext);
	}

	/**
	* Returns the dictionary where groupId = &#63; and code = &#63; or throws a {@link com.justonetech.sys.NoSuchDictionaryException} if it could not be found.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdAndCode(groupId, code);
	}

	/**
	* Returns the dictionary where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupIdAndCode(groupId, code);
	}

	/**
	* Returns the dictionary where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByGroupIdAndCode(
		long groupId, java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndCode(groupId, code, retrieveFromCache);
	}

	/**
	* Removes the dictionary where groupId = &#63; and code = &#63; from the database.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the dictionary that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary removeByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByGroupIdAndCode(groupId, code);
	}

	/**
	* Returns the number of dictionaries where groupId = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndCode(long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdAndCode(groupId, code);
	}

	/**
	* Returns all the dictionaries where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @return the matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByG_P_N_C(
		long groupId, long parentId, java.lang.String name,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_P_N_C(groupId, parentId, name, code);
	}

	/**
	* Returns a range of all the dictionaries where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByG_P_N_C(
		long groupId, long parentId, java.lang.String name,
		java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_N_C(groupId, parentId, name, code, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByG_P_N_C(
		long groupId, long parentId, java.lang.String name,
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_N_C(groupId, parentId, name, code, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByG_P_N_C_First(
		long groupId, long parentId, java.lang.String name,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_N_C_First(groupId, parentId, name, code,
			orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByG_P_N_C_First(
		long groupId, long parentId, java.lang.String name,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_N_C_First(groupId, parentId, name, code,
			orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByG_P_N_C_Last(
		long groupId, long parentId, java.lang.String name,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_N_C_Last(groupId, parentId, name, code,
			orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByG_P_N_C_Last(
		long groupId, long parentId, java.lang.String name,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_P_N_C_Last(groupId, parentId, name, code,
			orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary[] findByG_P_N_C_PrevAndNext(
		long dictionaryId, long groupId, long parentId, java.lang.String name,
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_P_N_C_PrevAndNext(dictionaryId, groupId, parentId,
			name, code, orderByComparator);
	}

	/**
	* Removes all the dictionaries where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_P_N_C(long groupId, long parentId,
		java.lang.String name, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_P_N_C(groupId, parentId, name, code);
	}

	/**
	* Returns the number of dictionaries where groupId = &#63; and parentId = &#63; and name = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param name the name
	* @param code the code
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_P_N_C(long groupId, long parentId,
		java.lang.String name, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_P_N_C(groupId, parentId, name, code);
	}

	/**
	* Returns all the dictionaries where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdAndParentId(groupId, parentId);
	}

	/**
	* Returns a range of all the dictionaries where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndParentId(groupId, parentId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries where groupId = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndParentId(groupId, parentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByGroupIdAndParentId_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndParentId_First(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByGroupIdAndParentId_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndParentId_First(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByGroupIdAndParentId_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndParentId_Last(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByGroupIdAndParentId_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdAndParentId_Last(groupId, parentId,
			orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary[] findByGroupIdAndParentId_PrevAndNext(
		long dictionaryId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdAndParentId_PrevAndNext(dictionaryId, groupId,
			parentId, orderByComparator);
	}

	/**
	* Removes all the dictionaries where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdAndParentId(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdAndParentId(groupId, parentId);
	}

	/**
	* Returns the number of dictionaries where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdAndParentId(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdAndParentId(groupId, parentId);
	}

	/**
	* Returns all the dictionaries where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @return the matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByParentIdAndIsValid(parentId, isValid);
	}

	/**
	* Returns a range of all the dictionaries where parentId = &#63; and isValid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdAndIsValid(parentId, isValid, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries where parentId = &#63; and isValid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdAndIsValid(parentId, isValid, start, end,
			orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByParentIdAndIsValid_First(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdAndIsValid_First(parentId, isValid,
			orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByParentIdAndIsValid_First(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdAndIsValid_First(parentId, isValid,
			orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByParentIdAndIsValid_Last(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdAndIsValid_Last(parentId, isValid,
			orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByParentIdAndIsValid_Last(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByParentIdAndIsValid_Last(parentId, isValid,
			orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where parentId = &#63; and isValid = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary[] findByParentIdAndIsValid_PrevAndNext(
		long dictionaryId, long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByParentIdAndIsValid_PrevAndNext(dictionaryId,
			parentId, isValid, orderByComparator);
	}

	/**
	* Removes all the dictionaries where parentId = &#63; and isValid = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByParentIdAndIsValid(long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByParentIdAndIsValid(parentId, isValid);
	}

	/**
	* Returns the number of dictionaries where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByParentIdAndIsValid(long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByParentIdAndIsValid(parentId, isValid);
	}

	/**
	* Caches the dictionary in the entity cache if it is enabled.
	*
	* @param dictionary the dictionary
	*/
	public static void cacheResult(
		com.justonetech.sys.model.Dictionary dictionary) {
		getPersistence().cacheResult(dictionary);
	}

	/**
	* Caches the dictionaries in the entity cache if it is enabled.
	*
	* @param dictionaries the dictionaries
	*/
	public static void cacheResult(
		java.util.List<com.justonetech.sys.model.Dictionary> dictionaries) {
		getPersistence().cacheResult(dictionaries);
	}

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	public static com.justonetech.sys.model.Dictionary create(long dictionaryId) {
		return getPersistence().create(dictionaryId);
	}

	/**
	* Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary remove(long dictionaryId)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(dictionaryId);
	}

	public static com.justonetech.sys.model.Dictionary updateImpl(
		com.justonetech.sys.model.Dictionary dictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(dictionary);
	}

	/**
	* Returns the dictionary with the primary key or throws a {@link com.justonetech.sys.NoSuchDictionaryException} if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary findByPrimaryKey(
		long dictionaryId)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(dictionaryId);
	}

	/**
	* Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.justonetech.sys.model.Dictionary fetchByPrimaryKey(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dictionaryId);
	}

	/**
	* Returns all the dictionaries.
	*
	* @return the dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.justonetech.sys.model.Dictionary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the dictionaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DictionaryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DictionaryPersistence)PortletBeanLocatorUtil.locate(com.justonetech.sys.service.ClpSerializer.getServletContextName(),
					DictionaryPersistence.class.getName());

			ReferenceRegistry.registerReference(DictionaryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DictionaryPersistence persistence) {
	}

	private static DictionaryPersistence _persistence;
}