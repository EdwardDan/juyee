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

import com.justonetech.cp.complete.NoSuchCompleteException;
import com.justonetech.cp.complete.model.Complete;
import com.justonetech.cp.complete.model.impl.CompleteImpl;
import com.justonetech.cp.complete.model.impl.CompleteModelImpl;

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

/**
 * The persistence implementation for the complete service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompletePersistence
 * @see CompleteUtil
 * @generated
 */
public class CompletePersistenceImpl extends BasePersistenceImpl<Complete>
	implements CompletePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompleteUtil} to access the complete persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompleteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteModelImpl.FINDER_CACHE_ENABLED, CompleteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteModelImpl.FINDER_CACHE_ENABLED, CompleteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ZZJGDM = new FinderPath(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteModelImpl.FINDER_CACHE_ENABLED, CompleteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByZzjgdm",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM =
		new FinderPath(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteModelImpl.FINDER_CACHE_ENABLED, CompleteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByZzjgdm",
			new String[] { String.class.getName() },
			CompleteModelImpl.ZZJGDM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ZZJGDM = new FinderPath(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByZzjgdm",
			new String[] { String.class.getName() });

	/**
	 * Returns all the completes where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @return the matching completes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Complete> findByZzjgdm(String zzjgdm) throws SystemException {
		return findByZzjgdm(zzjgdm, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Complete> findByZzjgdm(String zzjgdm, int start, int end)
		throws SystemException {
		return findByZzjgdm(zzjgdm, start, end, null);
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
	@Override
	public List<Complete> findByZzjgdm(String zzjgdm, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM;
			finderArgs = new Object[] { zzjgdm };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ZZJGDM;
			finderArgs = new Object[] { zzjgdm, start, end, orderByComparator };
		}

		List<Complete> list = (List<Complete>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Complete complete : list) {
				if (!Validator.equals(zzjgdm, complete.getZzjgdm())) {
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

			query.append(_SQL_SELECT_COMPLETE_WHERE);

			boolean bindZzjgdm = false;

			if (zzjgdm == null) {
				query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_1);
			}
			else if (zzjgdm.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_3);
			}
			else {
				bindZzjgdm = true;

				query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompleteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindZzjgdm) {
					qPos.add(zzjgdm);
				}

				if (!pagination) {
					list = (List<Complete>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Complete>(list);
				}
				else {
					list = (List<Complete>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first complete in the ordered set where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complete
	 * @throws com.justonetech.cp.complete.NoSuchCompleteException if a matching complete could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete findByZzjgdm_First(String zzjgdm,
		OrderByComparator orderByComparator)
		throws NoSuchCompleteException, SystemException {
		Complete complete = fetchByZzjgdm_First(zzjgdm, orderByComparator);

		if (complete != null) {
			return complete;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zzjgdm=");
		msg.append(zzjgdm);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompleteException(msg.toString());
	}

	/**
	 * Returns the first complete in the ordered set where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complete, or <code>null</code> if a matching complete could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete fetchByZzjgdm_First(String zzjgdm,
		OrderByComparator orderByComparator) throws SystemException {
		List<Complete> list = findByZzjgdm(zzjgdm, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Complete findByZzjgdm_Last(String zzjgdm,
		OrderByComparator orderByComparator)
		throws NoSuchCompleteException, SystemException {
		Complete complete = fetchByZzjgdm_Last(zzjgdm, orderByComparator);

		if (complete != null) {
			return complete;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zzjgdm=");
		msg.append(zzjgdm);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompleteException(msg.toString());
	}

	/**
	 * Returns the last complete in the ordered set where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complete, or <code>null</code> if a matching complete could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete fetchByZzjgdm_Last(String zzjgdm,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByZzjgdm(zzjgdm);

		if (count == 0) {
			return null;
		}

		List<Complete> list = findByZzjgdm(zzjgdm, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Complete[] findByZzjgdm_PrevAndNext(long completeId, String zzjgdm,
		OrderByComparator orderByComparator)
		throws NoSuchCompleteException, SystemException {
		Complete complete = findByPrimaryKey(completeId);

		Session session = null;

		try {
			session = openSession();

			Complete[] array = new CompleteImpl[3];

			array[0] = getByZzjgdm_PrevAndNext(session, complete, zzjgdm,
					orderByComparator, true);

			array[1] = complete;

			array[2] = getByZzjgdm_PrevAndNext(session, complete, zzjgdm,
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

	protected Complete getByZzjgdm_PrevAndNext(Session session,
		Complete complete, String zzjgdm, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLETE_WHERE);

		boolean bindZzjgdm = false;

		if (zzjgdm == null) {
			query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_1);
		}
		else if (zzjgdm.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_3);
		}
		else {
			bindZzjgdm = true;

			query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_2);
		}

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
			query.append(CompleteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindZzjgdm) {
			qPos.add(zzjgdm);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(complete);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Complete> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the completes where zzjgdm = &#63; from the database.
	 *
	 * @param zzjgdm the zzjgdm
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByZzjgdm(String zzjgdm) throws SystemException {
		for (Complete complete : findByZzjgdm(zzjgdm, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(complete);
		}
	}

	/**
	 * Returns the number of completes where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @return the number of matching completes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByZzjgdm(String zzjgdm) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ZZJGDM;

		Object[] finderArgs = new Object[] { zzjgdm };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLETE_WHERE);

			boolean bindZzjgdm = false;

			if (zzjgdm == null) {
				query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_1);
			}
			else if (zzjgdm.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_3);
			}
			else {
				bindZzjgdm = true;

				query.append(_FINDER_COLUMN_ZZJGDM_ZZJGDM_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindZzjgdm) {
					qPos.add(zzjgdm);
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

	private static final String _FINDER_COLUMN_ZZJGDM_ZZJGDM_1 = "complete.zzjgdm IS NULL";
	private static final String _FINDER_COLUMN_ZZJGDM_ZZJGDM_2 = "complete.zzjgdm = ?";
	private static final String _FINDER_COLUMN_ZZJGDM_ZZJGDM_3 = "(complete.zzjgdm IS NULL OR complete.zzjgdm = '')";

	public CompletePersistenceImpl() {
		setModelClass(Complete.class);
	}

	/**
	 * Caches the complete in the entity cache if it is enabled.
	 *
	 * @param complete the complete
	 */
	@Override
	public void cacheResult(Complete complete) {
		EntityCacheUtil.putResult(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteImpl.class, complete.getPrimaryKey(), complete);

		complete.resetOriginalValues();
	}

	/**
	 * Caches the completes in the entity cache if it is enabled.
	 *
	 * @param completes the completes
	 */
	@Override
	public void cacheResult(List<Complete> completes) {
		for (Complete complete : completes) {
			if (EntityCacheUtil.getResult(
						CompleteModelImpl.ENTITY_CACHE_ENABLED,
						CompleteImpl.class, complete.getPrimaryKey()) == null) {
				cacheResult(complete);
			}
			else {
				complete.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all completes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CompleteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CompleteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complete.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Complete complete) {
		EntityCacheUtil.removeResult(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteImpl.class, complete.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Complete> completes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Complete complete : completes) {
			EntityCacheUtil.removeResult(CompleteModelImpl.ENTITY_CACHE_ENABLED,
				CompleteImpl.class, complete.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complete with the primary key. Does not add the complete to the database.
	 *
	 * @param completeId the primary key for the new complete
	 * @return the new complete
	 */
	@Override
	public Complete create(long completeId) {
		Complete complete = new CompleteImpl();

		complete.setNew(true);
		complete.setPrimaryKey(completeId);

		return complete;
	}

	/**
	 * Removes the complete with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param completeId the primary key of the complete
	 * @return the complete that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteException if a complete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete remove(long completeId)
		throws NoSuchCompleteException, SystemException {
		return remove((Serializable)completeId);
	}

	/**
	 * Removes the complete with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complete
	 * @return the complete that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteException if a complete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete remove(Serializable primaryKey)
		throws NoSuchCompleteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Complete complete = (Complete)session.get(CompleteImpl.class,
					primaryKey);

			if (complete == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompleteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(complete);
		}
		catch (NoSuchCompleteException nsee) {
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
	protected Complete removeImpl(Complete complete) throws SystemException {
		complete = toUnwrappedModel(complete);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(complete)) {
				complete = (Complete)session.get(CompleteImpl.class,
						complete.getPrimaryKeyObj());
			}

			if (complete != null) {
				session.delete(complete);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (complete != null) {
			clearCache(complete);
		}

		return complete;
	}

	@Override
	public Complete updateImpl(
		com.justonetech.cp.complete.model.Complete complete)
		throws SystemException {
		complete = toUnwrappedModel(complete);

		boolean isNew = complete.isNew();

		CompleteModelImpl completeModelImpl = (CompleteModelImpl)complete;

		Session session = null;

		try {
			session = openSession();

			if (complete.isNew()) {
				session.save(complete);

				complete.setNew(false);
			}
			else {
				session.merge(complete);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CompleteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((completeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						completeModelImpl.getOriginalZzjgdm()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZZJGDM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM,
					args);

				args = new Object[] { completeModelImpl.getZzjgdm() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZZJGDM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM,
					args);
			}
		}

		EntityCacheUtil.putResult(CompleteModelImpl.ENTITY_CACHE_ENABLED,
			CompleteImpl.class, complete.getPrimaryKey(), complete);

		return complete;
	}

	protected Complete toUnwrappedModel(Complete complete) {
		if (complete instanceof CompleteImpl) {
			return complete;
		}

		CompleteImpl completeImpl = new CompleteImpl();

		completeImpl.setNew(complete.isNew());
		completeImpl.setPrimaryKey(complete.getPrimaryKey());

		completeImpl.setCompleteId(complete.getCompleteId());
		completeImpl.setGroupId(complete.getGroupId());
		completeImpl.setCompanyId(complete.getCompanyId());
		completeImpl.setUserId(complete.getUserId());
		completeImpl.setUserName(complete.getUserName());
		completeImpl.setCreateDate(complete.getCreateDate());
		completeImpl.setModifiedDate(complete.getModifiedDate());
		completeImpl.setZzjgdm(complete.getZzjgdm());
		completeImpl.setBjbh(complete.getBjbh());
		completeImpl.setSqbz(complete.getSqbz());
		completeImpl.setStatus(complete.getStatus());
		completeImpl.setBabh(complete.getBabh());
		completeImpl.setWssqbh(complete.getWssqbh());
		completeImpl.setSbrq(complete.getSbrq());

		return completeImpl;
	}

	/**
	 * Returns the complete with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete
	 * @return the complete
	 * @throws com.justonetech.cp.complete.NoSuchCompleteException if a complete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompleteException, SystemException {
		Complete complete = fetchByPrimaryKey(primaryKey);

		if (complete == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompleteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return complete;
	}

	/**
	 * Returns the complete with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteException} if it could not be found.
	 *
	 * @param completeId the primary key of the complete
	 * @return the complete
	 * @throws com.justonetech.cp.complete.NoSuchCompleteException if a complete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete findByPrimaryKey(long completeId)
		throws NoSuchCompleteException, SystemException {
		return findByPrimaryKey((Serializable)completeId);
	}

	/**
	 * Returns the complete with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete
	 * @return the complete, or <code>null</code> if a complete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Complete complete = (Complete)EntityCacheUtil.getResult(CompleteModelImpl.ENTITY_CACHE_ENABLED,
				CompleteImpl.class, primaryKey);

		if (complete == _nullComplete) {
			return null;
		}

		if (complete == null) {
			Session session = null;

			try {
				session = openSession();

				complete = (Complete)session.get(CompleteImpl.class, primaryKey);

				if (complete != null) {
					cacheResult(complete);
				}
				else {
					EntityCacheUtil.putResult(CompleteModelImpl.ENTITY_CACHE_ENABLED,
						CompleteImpl.class, primaryKey, _nullComplete);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CompleteModelImpl.ENTITY_CACHE_ENABLED,
					CompleteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return complete;
	}

	/**
	 * Returns the complete with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param completeId the primary key of the complete
	 * @return the complete, or <code>null</code> if a complete with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Complete fetchByPrimaryKey(long completeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)completeId);
	}

	/**
	 * Returns all the completes.
	 *
	 * @return the completes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Complete> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Complete> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Complete> findAll(int start, int end,
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

		List<Complete> list = (List<Complete>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLETE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLETE;

				if (pagination) {
					sql = sql.concat(CompleteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Complete>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Complete>(list);
				}
				else {
					list = (List<Complete>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the completes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Complete complete : findAll()) {
			remove(complete);
		}
	}

	/**
	 * Returns the number of completes.
	 *
	 * @return the number of completes
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

				Query q = session.createQuery(_SQL_COUNT_COMPLETE);

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

	/**
	 * Initializes the complete persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.complete.model.Complete")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Complete>> listenersList = new ArrayList<ModelListener<Complete>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Complete>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CompleteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMPLETE = "SELECT complete FROM Complete complete";
	private static final String _SQL_SELECT_COMPLETE_WHERE = "SELECT complete FROM Complete complete WHERE ";
	private static final String _SQL_COUNT_COMPLETE = "SELECT COUNT(complete) FROM Complete complete";
	private static final String _SQL_COUNT_COMPLETE_WHERE = "SELECT COUNT(complete) FROM Complete complete WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "complete.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Complete exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Complete exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CompletePersistenceImpl.class);
	private static Complete _nullComplete = new CompleteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Complete> toCacheModel() {
				return _nullCompleteCacheModel;
			}
		};

	private static CacheModel<Complete> _nullCompleteCacheModel = new CacheModel<Complete>() {
			@Override
			public Complete toEntityModel() {
				return _nullComplete;
			}
		};
}