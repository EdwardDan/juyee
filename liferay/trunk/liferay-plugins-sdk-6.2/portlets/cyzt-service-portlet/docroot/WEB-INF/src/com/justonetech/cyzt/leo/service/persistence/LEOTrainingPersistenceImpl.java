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

package com.justonetech.cyzt.leo.service.persistence;

import com.justonetech.cyzt.leo.NoSuchLEOTrainingException;
import com.justonetech.cyzt.leo.model.LEOTraining;
import com.justonetech.cyzt.leo.model.impl.LEOTrainingImpl;
import com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl;

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
 * The persistence implementation for the l e o training service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see LEOTrainingPersistence
 * @see LEOTrainingUtil
 * @generated
 */
public class LEOTrainingPersistenceImpl extends BasePersistenceImpl<LEOTraining>
	implements LEOTrainingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LEOTrainingUtil} to access the l e o training persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LEOTrainingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingModelImpl.FINDER_CACHE_ENABLED, LEOTrainingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingModelImpl.FINDER_CACHE_ENABLED, LEOTrainingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ZJBH = new FinderPath(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingModelImpl.FINDER_CACHE_ENABLED, LEOTrainingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByZjbh",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZJBH = new FinderPath(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingModelImpl.FINDER_CACHE_ENABLED, LEOTrainingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByZjbh",
			new String[] { String.class.getName() },
			LEOTrainingModelImpl.ZJBH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ZJBH = new FinderPath(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByZjbh",
			new String[] { String.class.getName() });

	/**
	 * Returns all the l e o trainings where zjbh = &#63;.
	 *
	 * @param zjbh the zjbh
	 * @return the matching l e o trainings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOTraining> findByZjbh(String zjbh) throws SystemException {
		return findByZjbh(zjbh, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l e o trainings where zjbh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zjbh the zjbh
	 * @param start the lower bound of the range of l e o trainings
	 * @param end the upper bound of the range of l e o trainings (not inclusive)
	 * @return the range of matching l e o trainings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOTraining> findByZjbh(String zjbh, int start, int end)
		throws SystemException {
		return findByZjbh(zjbh, start, end, null);
	}

	/**
	 * Returns an ordered range of all the l e o trainings where zjbh = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param zjbh the zjbh
	 * @param start the lower bound of the range of l e o trainings
	 * @param end the upper bound of the range of l e o trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching l e o trainings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOTraining> findByZjbh(String zjbh, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZJBH;
			finderArgs = new Object[] { zjbh };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ZJBH;
			finderArgs = new Object[] { zjbh, start, end, orderByComparator };
		}

		List<LEOTraining> list = (List<LEOTraining>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (LEOTraining leoTraining : list) {
				if (!Validator.equals(zjbh, leoTraining.getZjbh())) {
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

			query.append(_SQL_SELECT_LEOTRAINING_WHERE);

			boolean bindZjbh = false;

			if (zjbh == null) {
				query.append(_FINDER_COLUMN_ZJBH_ZJBH_1);
			}
			else if (zjbh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ZJBH_ZJBH_3);
			}
			else {
				bindZjbh = true;

				query.append(_FINDER_COLUMN_ZJBH_ZJBH_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LEOTrainingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindZjbh) {
					qPos.add(zjbh);
				}

				if (!pagination) {
					list = (List<LEOTraining>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LEOTraining>(list);
				}
				else {
					list = (List<LEOTraining>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first l e o training in the ordered set where zjbh = &#63;.
	 *
	 * @param zjbh the zjbh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l e o training
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a matching l e o training could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining findByZjbh_First(String zjbh,
		OrderByComparator orderByComparator)
		throws NoSuchLEOTrainingException, SystemException {
		LEOTraining leoTraining = fetchByZjbh_First(zjbh, orderByComparator);

		if (leoTraining != null) {
			return leoTraining;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zjbh=");
		msg.append(zjbh);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLEOTrainingException(msg.toString());
	}

	/**
	 * Returns the first l e o training in the ordered set where zjbh = &#63;.
	 *
	 * @param zjbh the zjbh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching l e o training, or <code>null</code> if a matching l e o training could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining fetchByZjbh_First(String zjbh,
		OrderByComparator orderByComparator) throws SystemException {
		List<LEOTraining> list = findByZjbh(zjbh, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last l e o training in the ordered set where zjbh = &#63;.
	 *
	 * @param zjbh the zjbh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l e o training
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a matching l e o training could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining findByZjbh_Last(String zjbh,
		OrderByComparator orderByComparator)
		throws NoSuchLEOTrainingException, SystemException {
		LEOTraining leoTraining = fetchByZjbh_Last(zjbh, orderByComparator);

		if (leoTraining != null) {
			return leoTraining;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zjbh=");
		msg.append(zjbh);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLEOTrainingException(msg.toString());
	}

	/**
	 * Returns the last l e o training in the ordered set where zjbh = &#63;.
	 *
	 * @param zjbh the zjbh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching l e o training, or <code>null</code> if a matching l e o training could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining fetchByZjbh_Last(String zjbh,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByZjbh(zjbh);

		if (count == 0) {
			return null;
		}

		List<LEOTraining> list = findByZjbh(zjbh, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the l e o trainings before and after the current l e o training in the ordered set where zjbh = &#63;.
	 *
	 * @param trainingId the primary key of the current l e o training
	 * @param zjbh the zjbh
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next l e o training
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining[] findByZjbh_PrevAndNext(long trainingId, String zjbh,
		OrderByComparator orderByComparator)
		throws NoSuchLEOTrainingException, SystemException {
		LEOTraining leoTraining = findByPrimaryKey(trainingId);

		Session session = null;

		try {
			session = openSession();

			LEOTraining[] array = new LEOTrainingImpl[3];

			array[0] = getByZjbh_PrevAndNext(session, leoTraining, zjbh,
					orderByComparator, true);

			array[1] = leoTraining;

			array[2] = getByZjbh_PrevAndNext(session, leoTraining, zjbh,
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

	protected LEOTraining getByZjbh_PrevAndNext(Session session,
		LEOTraining leoTraining, String zjbh,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LEOTRAINING_WHERE);

		boolean bindZjbh = false;

		if (zjbh == null) {
			query.append(_FINDER_COLUMN_ZJBH_ZJBH_1);
		}
		else if (zjbh.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ZJBH_ZJBH_3);
		}
		else {
			bindZjbh = true;

			query.append(_FINDER_COLUMN_ZJBH_ZJBH_2);
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
			query.append(LEOTrainingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindZjbh) {
			qPos.add(zjbh);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(leoTraining);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LEOTraining> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the l e o trainings where zjbh = &#63; from the database.
	 *
	 * @param zjbh the zjbh
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByZjbh(String zjbh) throws SystemException {
		for (LEOTraining leoTraining : findByZjbh(zjbh, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(leoTraining);
		}
	}

	/**
	 * Returns the number of l e o trainings where zjbh = &#63;.
	 *
	 * @param zjbh the zjbh
	 * @return the number of matching l e o trainings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByZjbh(String zjbh) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ZJBH;

		Object[] finderArgs = new Object[] { zjbh };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEOTRAINING_WHERE);

			boolean bindZjbh = false;

			if (zjbh == null) {
				query.append(_FINDER_COLUMN_ZJBH_ZJBH_1);
			}
			else if (zjbh.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ZJBH_ZJBH_3);
			}
			else {
				bindZjbh = true;

				query.append(_FINDER_COLUMN_ZJBH_ZJBH_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindZjbh) {
					qPos.add(zjbh);
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

	private static final String _FINDER_COLUMN_ZJBH_ZJBH_1 = "leoTraining.zjbh IS NULL";
	private static final String _FINDER_COLUMN_ZJBH_ZJBH_2 = "leoTraining.zjbh = ?";
	private static final String _FINDER_COLUMN_ZJBH_ZJBH_3 = "(leoTraining.zjbh IS NULL OR leoTraining.zjbh = '')";

	public LEOTrainingPersistenceImpl() {
		setModelClass(LEOTraining.class);
	}

	/**
	 * Caches the l e o training in the entity cache if it is enabled.
	 *
	 * @param leoTraining the l e o training
	 */
	@Override
	public void cacheResult(LEOTraining leoTraining) {
		EntityCacheUtil.putResult(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingImpl.class, leoTraining.getPrimaryKey(), leoTraining);

		leoTraining.resetOriginalValues();
	}

	/**
	 * Caches the l e o trainings in the entity cache if it is enabled.
	 *
	 * @param leoTrainings the l e o trainings
	 */
	@Override
	public void cacheResult(List<LEOTraining> leoTrainings) {
		for (LEOTraining leoTraining : leoTrainings) {
			if (EntityCacheUtil.getResult(
						LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
						LEOTrainingImpl.class, leoTraining.getPrimaryKey()) == null) {
				cacheResult(leoTraining);
			}
			else {
				leoTraining.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l e o trainings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LEOTrainingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LEOTrainingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l e o training.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LEOTraining leoTraining) {
		EntityCacheUtil.removeResult(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingImpl.class, leoTraining.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LEOTraining> leoTrainings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LEOTraining leoTraining : leoTrainings) {
			EntityCacheUtil.removeResult(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
				LEOTrainingImpl.class, leoTraining.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l e o training with the primary key. Does not add the l e o training to the database.
	 *
	 * @param trainingId the primary key for the new l e o training
	 * @return the new l e o training
	 */
	@Override
	public LEOTraining create(long trainingId) {
		LEOTraining leoTraining = new LEOTrainingImpl();

		leoTraining.setNew(true);
		leoTraining.setPrimaryKey(trainingId);

		return leoTraining;
	}

	/**
	 * Removes the l e o training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trainingId the primary key of the l e o training
	 * @return the l e o training that was removed
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining remove(long trainingId)
		throws NoSuchLEOTrainingException, SystemException {
		return remove((Serializable)trainingId);
	}

	/**
	 * Removes the l e o training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l e o training
	 * @return the l e o training that was removed
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining remove(Serializable primaryKey)
		throws NoSuchLEOTrainingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LEOTraining leoTraining = (LEOTraining)session.get(LEOTrainingImpl.class,
					primaryKey);

			if (leoTraining == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLEOTrainingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leoTraining);
		}
		catch (NoSuchLEOTrainingException nsee) {
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
	protected LEOTraining removeImpl(LEOTraining leoTraining)
		throws SystemException {
		leoTraining = toUnwrappedModel(leoTraining);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leoTraining)) {
				leoTraining = (LEOTraining)session.get(LEOTrainingImpl.class,
						leoTraining.getPrimaryKeyObj());
			}

			if (leoTraining != null) {
				session.delete(leoTraining);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leoTraining != null) {
			clearCache(leoTraining);
		}

		return leoTraining;
	}

	@Override
	public LEOTraining updateImpl(
		com.justonetech.cyzt.leo.model.LEOTraining leoTraining)
		throws SystemException {
		leoTraining = toUnwrappedModel(leoTraining);

		boolean isNew = leoTraining.isNew();

		LEOTrainingModelImpl leoTrainingModelImpl = (LEOTrainingModelImpl)leoTraining;

		Session session = null;

		try {
			session = openSession();

			if (leoTraining.isNew()) {
				session.save(leoTraining);

				leoTraining.setNew(false);
			}
			else {
				session.merge(leoTraining);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LEOTrainingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((leoTrainingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZJBH.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						leoTrainingModelImpl.getOriginalZjbh()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZJBH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZJBH,
					args);

				args = new Object[] { leoTrainingModelImpl.getZjbh() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZJBH, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZJBH,
					args);
			}
		}

		EntityCacheUtil.putResult(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
			LEOTrainingImpl.class, leoTraining.getPrimaryKey(), leoTraining);

		return leoTraining;
	}

	protected LEOTraining toUnwrappedModel(LEOTraining leoTraining) {
		if (leoTraining instanceof LEOTrainingImpl) {
			return leoTraining;
		}

		LEOTrainingImpl leoTrainingImpl = new LEOTrainingImpl();

		leoTrainingImpl.setNew(leoTraining.isNew());
		leoTrainingImpl.setPrimaryKey(leoTraining.getPrimaryKey());

		leoTrainingImpl.setTrainingId(leoTraining.getTrainingId());
		leoTrainingImpl.setGroupId(leoTraining.getGroupId());
		leoTrainingImpl.setCompanyId(leoTraining.getCompanyId());
		leoTrainingImpl.setUserId(leoTraining.getUserId());
		leoTrainingImpl.setUserName(leoTraining.getUserName());
		leoTrainingImpl.setCreateDate(leoTraining.getCreateDate());
		leoTrainingImpl.setModifiedDate(leoTraining.getModifiedDate());
		leoTrainingImpl.setZjbh(leoTraining.getZjbh());
		leoTrainingImpl.setPxsj(leoTraining.getPxsj());
		leoTrainingImpl.setXcjysj(leoTraining.getXcjysj());
		leoTrainingImpl.setPxnr(leoTraining.getPxnr());

		return leoTrainingImpl;
	}

	/**
	 * Returns the l e o training with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l e o training
	 * @return the l e o training
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLEOTrainingException, SystemException {
		LEOTraining leoTraining = fetchByPrimaryKey(primaryKey);

		if (leoTraining == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLEOTrainingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leoTraining;
	}

	/**
	 * Returns the l e o training with the primary key or throws a {@link com.justonetech.cyzt.leo.NoSuchLEOTrainingException} if it could not be found.
	 *
	 * @param trainingId the primary key of the l e o training
	 * @return the l e o training
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOTrainingException if a l e o training with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining findByPrimaryKey(long trainingId)
		throws NoSuchLEOTrainingException, SystemException {
		return findByPrimaryKey((Serializable)trainingId);
	}

	/**
	 * Returns the l e o training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l e o training
	 * @return the l e o training, or <code>null</code> if a l e o training with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LEOTraining leoTraining = (LEOTraining)EntityCacheUtil.getResult(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
				LEOTrainingImpl.class, primaryKey);

		if (leoTraining == _nullLEOTraining) {
			return null;
		}

		if (leoTraining == null) {
			Session session = null;

			try {
				session = openSession();

				leoTraining = (LEOTraining)session.get(LEOTrainingImpl.class,
						primaryKey);

				if (leoTraining != null) {
					cacheResult(leoTraining);
				}
				else {
					EntityCacheUtil.putResult(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
						LEOTrainingImpl.class, primaryKey, _nullLEOTraining);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LEOTrainingModelImpl.ENTITY_CACHE_ENABLED,
					LEOTrainingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leoTraining;
	}

	/**
	 * Returns the l e o training with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param trainingId the primary key of the l e o training
	 * @return the l e o training, or <code>null</code> if a l e o training with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOTraining fetchByPrimaryKey(long trainingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)trainingId);
	}

	/**
	 * Returns all the l e o trainings.
	 *
	 * @return the l e o trainings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOTraining> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l e o trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l e o trainings
	 * @param end the upper bound of the range of l e o trainings (not inclusive)
	 * @return the range of l e o trainings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOTraining> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l e o trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOTrainingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l e o trainings
	 * @param end the upper bound of the range of l e o trainings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l e o trainings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOTraining> findAll(int start, int end,
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

		List<LEOTraining> list = (List<LEOTraining>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEOTRAINING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEOTRAINING;

				if (pagination) {
					sql = sql.concat(LEOTrainingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LEOTraining>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LEOTraining>(list);
				}
				else {
					list = (List<LEOTraining>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the l e o trainings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LEOTraining leoTraining : findAll()) {
			remove(leoTraining);
		}
	}

	/**
	 * Returns the number of l e o trainings.
	 *
	 * @return the number of l e o trainings
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

				Query q = session.createQuery(_SQL_COUNT_LEOTRAINING);

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
	 * Initializes the l e o training persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cyzt.leo.model.LEOTraining")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LEOTraining>> listenersList = new ArrayList<ModelListener<LEOTraining>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LEOTraining>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LEOTrainingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEOTRAINING = "SELECT leoTraining FROM LEOTraining leoTraining";
	private static final String _SQL_SELECT_LEOTRAINING_WHERE = "SELECT leoTraining FROM LEOTraining leoTraining WHERE ";
	private static final String _SQL_COUNT_LEOTRAINING = "SELECT COUNT(leoTraining) FROM LEOTraining leoTraining";
	private static final String _SQL_COUNT_LEOTRAINING_WHERE = "SELECT COUNT(leoTraining) FROM LEOTraining leoTraining WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leoTraining.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LEOTraining exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LEOTraining exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LEOTrainingPersistenceImpl.class);
	private static LEOTraining _nullLEOTraining = new LEOTrainingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LEOTraining> toCacheModel() {
				return _nullLEOTrainingCacheModel;
			}
		};

	private static CacheModel<LEOTraining> _nullLEOTrainingCacheModel = new CacheModel<LEOTraining>() {
			@Override
			public LEOTraining toEntityModel() {
				return _nullLEOTraining;
			}
		};
}