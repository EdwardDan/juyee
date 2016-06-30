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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DictionaryPersistenceImpl
 * @see DictionaryUtil
 * @generated
 */
public interface DictionaryPersistence extends BasePersistence<Dictionary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictionaryUtil} to access the dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the dictionary where groupId = &#63; and code = &#63; or throws a {@link com.justonetech.sys.NoSuchDictionaryException} if it could not be found.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the matching dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary findByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary fetchByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary where groupId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary fetchByGroupIdAndCode(
		long groupId, java.lang.String code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the dictionary where groupId = &#63; and code = &#63; from the database.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the dictionary that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary removeByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionaries where groupId = &#63; and code = &#63;.
	*
	* @param groupId the group ID
	* @param code the code
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndCode(long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dictionaries where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.justonetech.sys.model.Dictionary findByGroupIdAndParentId_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary fetchByGroupIdAndParentId_First(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.justonetech.sys.model.Dictionary findByGroupIdAndParentId_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary in the ordered set where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary fetchByGroupIdAndParentId_Last(
		long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.justonetech.sys.model.Dictionary[] findByGroupIdAndParentId_PrevAndNext(
		long dictionaryId, long groupId, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionaries where groupId = &#63; and parentId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdAndParentId(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionaries where groupId = &#63; and parentId = &#63;.
	*
	* @param groupId the group ID
	* @param parentId the parent ID
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdAndParentId(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dictionaries where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @return the matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.justonetech.sys.model.Dictionary findByParentIdAndIsValid_First(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first dictionary in the ordered set where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary fetchByParentIdAndIsValid_First(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.justonetech.sys.model.Dictionary findByParentIdAndIsValid_Last(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last dictionary in the ordered set where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary fetchByParentIdAndIsValid_Last(
		long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.justonetech.sys.model.Dictionary[] findByParentIdAndIsValid_PrevAndNext(
		long dictionaryId, long parentId, boolean isValid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionaries where parentId = &#63; and isValid = &#63; from the database.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentIdAndIsValid(long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionaries where parentId = &#63; and isValid = &#63;.
	*
	* @param parentId the parent ID
	* @param isValid the is valid
	* @return the number of matching dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentIdAndIsValid(long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the dictionary in the entity cache if it is enabled.
	*
	* @param dictionary the dictionary
	*/
	public void cacheResult(com.justonetech.sys.model.Dictionary dictionary);

	/**
	* Caches the dictionaries in the entity cache if it is enabled.
	*
	* @param dictionaries the dictionaries
	*/
	public void cacheResult(
		java.util.List<com.justonetech.sys.model.Dictionary> dictionaries);

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	public com.justonetech.sys.model.Dictionary create(long dictionaryId);

	/**
	* Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary remove(long dictionaryId)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.sys.model.Dictionary updateImpl(
		com.justonetech.sys.model.Dictionary dictionary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary with the primary key or throws a {@link com.justonetech.sys.NoSuchDictionaryException} if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary findByPrimaryKey(
		long dictionaryId)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.justonetech.sys.model.Dictionary fetchByPrimaryKey(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the dictionaries.
	*
	* @return the dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.justonetech.sys.model.Dictionary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.sys.model.Dictionary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.justonetech.sys.model.Dictionary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the dictionaries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}