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

import com.justonetech.sys.NoSuchDictionaryException;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.model.impl.DictionaryImpl;
import com.justonetech.sys.model.impl.DictionaryModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DictionaryPersistence
 * @see DictionaryUtil
 * @generated
 */
public class DictionaryPersistenceImpl extends BasePersistenceImpl<Dictionary>
	implements DictionaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictionaryUtil} to access the dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictionaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			DictionaryModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the dictionary where code = &#63; or throws a {@link com.justonetech.sys.NoSuchDictionaryException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching dictionary
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByCode(String code)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByCode(code);

		if (dictionary == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDictionaryException(msg.toString());
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the dictionary where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof Dictionary) {
			Dictionary dictionary = (Dictionary)result;

			if (!Validator.equals(code, dictionary.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				List<Dictionary> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DictionaryPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Dictionary dictionary = list.get(0);

					result = dictionary;

					cacheResult(dictionary);

					if ((dictionary.getCode() == null) ||
							!dictionary.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, dictionary);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Dictionary)result;
		}
	}

	/**
	 * Removes the dictionary where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the dictionary that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary removeByCode(String code)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = findByCode(code);

		return remove(dictionary);
	}

	/**
	 * Returns the number of dictionaries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "dictionary.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "dictionary.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(dictionary.code IS NULL OR dictionary.code = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { Long.class.getName() },
			DictionaryModelImpl.PARENTID_COLUMN_BITMASK |
			DictionaryModelImpl.SORTPATH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dictionaries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findByParentId(long parentId)
		throws SystemException {
		return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dictionaries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findByParentId(long parentId, int start, int end)
		throws SystemException {
		return findByParentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findByParentId(long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<Dictionary> list = (List<Dictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Dictionary dictionary : list) {
				if ((parentId != dictionary.getParentId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dictionary>(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first dictionary in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByParentId_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByParentId_First(parentId,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the first dictionary in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByParentId_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Dictionary> list = findByParentId(parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByParentId_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByParentId_Last(parentId, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the last dictionary in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByParentId_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentId(parentId);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findByParentId(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set where parentId = &#63;.
	 *
	 * @param dictionaryId the primary key of the current dictionary
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary[] findByParentId_PrevAndNext(long dictionaryId,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = findByPrimaryKey(dictionaryId);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getByParentId_PrevAndNext(session, dictionary, parentId,
					orderByComparator, true);

			array[1] = dictionary;

			array[2] = getByParentId_PrevAndNext(session, dictionary, parentId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dictionary getByParentId_PrevAndNext(Session session,
		Dictionary dictionary, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentId(long parentId) throws SystemException {
		for (Dictionary dictionary : findByParentId(parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentId(long parentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "dictionary.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDISVALID =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentIdIsValid",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDISVALID =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentIdIsValid",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			DictionaryModelImpl.PARENTID_COLUMN_BITMASK |
			DictionaryModelImpl.ISVALID_COLUMN_BITMASK |
			DictionaryModelImpl.SORTPATH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTIDISVALID = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentIdIsValid",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the dictionaries where parentId = &#63; and isValid = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param isValid the is valid
	 * @return the matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findByParentIdIsValid(long parentId, boolean isValid)
		throws SystemException {
		return findByParentIdIsValid(parentId, isValid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dictionary> findByParentIdIsValid(long parentId,
		boolean isValid, int start, int end) throws SystemException {
		return findByParentIdIsValid(parentId, isValid, start, end, null);
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
	@Override
	public List<Dictionary> findByParentIdIsValid(long parentId,
		boolean isValid, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDISVALID;
			finderArgs = new Object[] { parentId, isValid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTIDISVALID;
			finderArgs = new Object[] {
					parentId, isValid,
					
					start, end, orderByComparator
				};
		}

		List<Dictionary> list = (List<Dictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Dictionary dictionary : list) {
				if ((parentId != dictionary.getParentId()) ||
						(isValid != dictionary.getIsValid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDISVALID_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDISVALID_ISVALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(isValid);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dictionary>(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Dictionary findByParentIdIsValid_First(long parentId,
		boolean isValid, OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByParentIdIsValid_First(parentId, isValid,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", isValid=");
		msg.append(isValid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
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
	@Override
	public Dictionary fetchByParentIdIsValid_First(long parentId,
		boolean isValid, OrderByComparator orderByComparator)
		throws SystemException {
		List<Dictionary> list = findByParentIdIsValid(parentId, isValid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dictionary findByParentIdIsValid_Last(long parentId,
		boolean isValid, OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByParentIdIsValid_Last(parentId, isValid,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(", isValid=");
		msg.append(isValid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
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
	@Override
	public Dictionary fetchByParentIdIsValid_Last(long parentId,
		boolean isValid, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentIdIsValid(parentId, isValid);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findByParentIdIsValid(parentId, isValid,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Dictionary[] findByParentIdIsValid_PrevAndNext(long dictionaryId,
		long parentId, boolean isValid, OrderByComparator orderByComparator)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = findByPrimaryKey(dictionaryId);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getByParentIdIsValid_PrevAndNext(session, dictionary,
					parentId, isValid, orderByComparator, true);

			array[1] = dictionary;

			array[2] = getByParentIdIsValid_PrevAndNext(session, dictionary,
					parentId, isValid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Dictionary getByParentIdIsValid_PrevAndNext(Session session,
		Dictionary dictionary, long parentId, boolean isValid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

		query.append(_FINDER_COLUMN_PARENTIDISVALID_PARENTID_2);

		query.append(_FINDER_COLUMN_PARENTIDISVALID_ISVALID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		qPos.add(isValid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where parentId = &#63; and isValid = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @param isValid the is valid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentIdIsValid(long parentId, boolean isValid)
		throws SystemException {
		for (Dictionary dictionary : findByParentIdIsValid(parentId, isValid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where parentId = &#63; and isValid = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param isValid the is valid
	 * @return the number of matching dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentIdIsValid(long parentId, boolean isValid)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTIDISVALID;

		Object[] finderArgs = new Object[] { parentId, isValid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			query.append(_FINDER_COLUMN_PARENTIDISVALID_PARENTID_2);

			query.append(_FINDER_COLUMN_PARENTIDISVALID_ISVALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				qPos.add(isValid);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PARENTIDISVALID_PARENTID_2 = "dictionary.parentId = ? AND ";
	private static final String _FINDER_COLUMN_PARENTIDISVALID_ISVALID_2 = "dictionary.isValid = ?";

	public DictionaryPersistenceImpl() {
		setModelClass(Dictionary.class);
	}

	/**
	 * Caches the dictionary in the entity cache if it is enabled.
	 *
	 * @param dictionary the dictionary
	 */
	@Override
	public void cacheResult(Dictionary dictionary) {
		EntityCacheUtil.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { dictionary.getCode() }, dictionary);

		dictionary.resetOriginalValues();
	}

	/**
	 * Caches the dictionaries in the entity cache if it is enabled.
	 *
	 * @param dictionaries the dictionaries
	 */
	@Override
	public void cacheResult(List<Dictionary> dictionaries) {
		for (Dictionary dictionary : dictionaries) {
			if (EntityCacheUtil.getResult(
						DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, dictionary.getPrimaryKey()) == null) {
				cacheResult(dictionary);
			}
			else {
				dictionary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dictionaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DictionaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DictionaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dictionary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dictionary dictionary) {
		EntityCacheUtil.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(dictionary);
	}

	@Override
	public void clearCache(List<Dictionary> dictionaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dictionary dictionary : dictionaries) {
			EntityCacheUtil.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, dictionary.getPrimaryKey());

			clearUniqueFindersCache(dictionary);
		}
	}

	protected void cacheUniqueFindersCache(Dictionary dictionary) {
		if (dictionary.isNew()) {
			Object[] args = new Object[] { dictionary.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
				dictionary);
		}
		else {
			DictionaryModelImpl dictionaryModelImpl = (DictionaryModelImpl)dictionary;

			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { dictionary.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					dictionary);
			}
		}
	}

	protected void clearUniqueFindersCache(Dictionary dictionary) {
		DictionaryModelImpl dictionaryModelImpl = (DictionaryModelImpl)dictionary;

		Object[] args = new Object[] { dictionary.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((dictionaryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { dictionaryModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	 *
	 * @param dictionaryId the primary key for the new dictionary
	 * @return the new dictionary
	 */
	@Override
	public Dictionary create(long dictionaryId) {
		Dictionary dictionary = new DictionaryImpl();

		dictionary.setNew(true);
		dictionary.setPrimaryKey(dictionaryId);

		return dictionary;
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary remove(long dictionaryId)
		throws NoSuchDictionaryException, SystemException {
		return remove((Serializable)dictionaryId);
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary remove(Serializable primaryKey)
		throws NoSuchDictionaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Dictionary dictionary = (Dictionary)session.get(DictionaryImpl.class,
					primaryKey);

			if (dictionary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictionary);
		}
		catch (NoSuchDictionaryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Dictionary removeImpl(Dictionary dictionary)
		throws SystemException {
		dictionary = toUnwrappedModel(dictionary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictionary)) {
				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						dictionary.getPrimaryKeyObj());
			}

			if (dictionary != null) {
				session.delete(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictionary != null) {
			clearCache(dictionary);
		}

		return dictionary;
	}

	@Override
	public Dictionary updateImpl(
		com.justonetech.sys.model.Dictionary dictionary)
		throws SystemException {
		dictionary = toUnwrappedModel(dictionary);

		boolean isNew = dictionary.isNew();

		DictionaryModelImpl dictionaryModelImpl = (DictionaryModelImpl)dictionary;

		Session session = null;

		try {
			session = openSession();

			if (dictionary.isNew()) {
				session.save(dictionary);

				dictionary.setNew(false);
			}
			else {
				session.merge(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictionaryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { dictionaryModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDISVALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalParentId(),
						dictionaryModelImpl.getOriginalIsValid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDISVALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDISVALID,
					args);

				args = new Object[] {
						dictionaryModelImpl.getParentId(),
						dictionaryModelImpl.getIsValid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTIDISVALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTIDISVALID,
					args);
			}
		}

		EntityCacheUtil.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary);

		clearUniqueFindersCache(dictionary);
		cacheUniqueFindersCache(dictionary);

		return dictionary;
	}

	protected Dictionary toUnwrappedModel(Dictionary dictionary) {
		if (dictionary instanceof DictionaryImpl) {
			return dictionary;
		}

		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		dictionaryImpl.setNew(dictionary.isNew());
		dictionaryImpl.setPrimaryKey(dictionary.getPrimaryKey());

		dictionaryImpl.setDictionaryId(dictionary.getDictionaryId());
		dictionaryImpl.setUserId(dictionary.getUserId());
		dictionaryImpl.setUserName(dictionary.getUserName());
		dictionaryImpl.setCreateTime(dictionary.getCreateTime());
		dictionaryImpl.setModifiedTime(dictionary.getModifiedTime());
		dictionaryImpl.setCode(dictionary.getCode());
		dictionaryImpl.setName(dictionary.getName());
		dictionaryImpl.setIsLeaf(dictionary.isIsLeaf());
		dictionaryImpl.setSortNo(dictionary.getSortNo());
		dictionaryImpl.setDesc(dictionary.getDesc());
		dictionaryImpl.setTag(dictionary.getTag());
		dictionaryImpl.setIsValid(dictionary.isIsValid());
		dictionaryImpl.setTreePath(dictionary.getTreePath());
		dictionaryImpl.setSortPath(dictionary.getSortPath());
		dictionaryImpl.setCustomContent(dictionary.getCustomContent());
		dictionaryImpl.setParentId(dictionary.getParentId());

		return dictionaryImpl;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictionaryException, SystemException {
		Dictionary dictionary = fetchByPrimaryKey(primaryKey);

		if (dictionary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link com.justonetech.sys.NoSuchDictionaryException} if it could not be found.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary
	 * @throws com.justonetech.sys.NoSuchDictionaryException if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary findByPrimaryKey(long dictionaryId)
		throws NoSuchDictionaryException, SystemException {
		return findByPrimaryKey((Serializable)dictionaryId);
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Dictionary dictionary = (Dictionary)EntityCacheUtil.getResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, primaryKey);

		if (dictionary == _nullDictionary) {
			return null;
		}

		if (dictionary == null) {
			Session session = null;

			try {
				session = openSession();

				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						primaryKey);

				if (dictionary != null) {
					cacheResult(dictionary);
				}
				else {
					EntityCacheUtil.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, primaryKey, _nullDictionary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dictionary fetchByPrimaryKey(long dictionaryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dictionaryId);
	}

	/**
	 * Returns all the dictionaries.
	 *
	 * @return the dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dictionary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Dictionary> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Dictionary> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Dictionary> list = (List<Dictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DICTIONARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTIONARY;

				if (pagination) {
					sql = sql.concat(DictionaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dictionary>(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the dictionaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Dictionary dictionary : findAll()) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries.
	 *
	 * @return the number of dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DICTIONARY);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the dictionary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.sys.model.Dictionary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Dictionary>> listenersList = new ArrayList<ModelListener<Dictionary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Dictionary>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(DictionaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DICTIONARY = "SELECT dictionary FROM Dictionary dictionary";
	private static final String _SQL_SELECT_DICTIONARY_WHERE = "SELECT dictionary FROM Dictionary dictionary WHERE ";
	private static final String _SQL_COUNT_DICTIONARY = "SELECT COUNT(dictionary) FROM Dictionary dictionary";
	private static final String _SQL_COUNT_DICTIONARY_WHERE = "SELECT COUNT(dictionary) FROM Dictionary dictionary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictionary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dictionary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dictionary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DictionaryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code", "desc"
			});
	private static Dictionary _nullDictionary = new DictionaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Dictionary> toCacheModel() {
				return _nullDictionaryCacheModel;
			}
		};

	private static CacheModel<Dictionary> _nullDictionaryCacheModel = new CacheModel<Dictionary>() {
			@Override
			public Dictionary toEntityModel() {
				return _nullDictionary;
			}
		};
}