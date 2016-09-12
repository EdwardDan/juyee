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

import com.justonetech.cp.permit.NoSuchPermitException;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.impl.PermitImpl;
import com.justonetech.cp.permit.model.impl.PermitModelImpl;

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
 * The persistence implementation for the permit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see PermitPersistence
 * @see PermitUtil
 * @generated
 */
public class PermitPersistenceImpl extends BasePersistenceImpl<Permit>
	implements PermitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PermitUtil} to access the permit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PermitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitModelImpl.FINDER_CACHE_ENABLED, PermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitModelImpl.FINDER_CACHE_ENABLED, PermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ZZJGDM = new FinderPath(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitModelImpl.FINDER_CACHE_ENABLED, PermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByZzjgdm",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM =
		new FinderPath(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitModelImpl.FINDER_CACHE_ENABLED, PermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByZzjgdm",
			new String[] { String.class.getName() },
			PermitModelImpl.ZZJGDM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ZZJGDM = new FinderPath(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByZzjgdm",
			new String[] { String.class.getName() });

	/**
	 * Returns all the permits where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @return the matching permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Permit> findByZzjgdm(String zzjgdm) throws SystemException {
		return findByZzjgdm(zzjgdm, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Permit> findByZzjgdm(String zzjgdm, int start, int end)
		throws SystemException {
		return findByZzjgdm(zzjgdm, start, end, null);
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
	@Override
	public List<Permit> findByZzjgdm(String zzjgdm, int start, int end,
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

		List<Permit> list = (List<Permit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Permit permit : list) {
				if (!Validator.equals(zzjgdm, permit.getZzjgdm())) {
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

			query.append(_SQL_SELECT_PERMIT_WHERE);

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
				query.append(PermitModelImpl.ORDER_BY_JPQL);
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
					list = (List<Permit>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Permit>(list);
				}
				else {
					list = (List<Permit>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first permit in the ordered set where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permit
	 * @throws com.justonetech.cp.permit.NoSuchPermitException if a matching permit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit findByZzjgdm_First(String zzjgdm,
		OrderByComparator orderByComparator)
		throws NoSuchPermitException, SystemException {
		Permit permit = fetchByZzjgdm_First(zzjgdm, orderByComparator);

		if (permit != null) {
			return permit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zzjgdm=");
		msg.append(zzjgdm);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPermitException(msg.toString());
	}

	/**
	 * Returns the first permit in the ordered set where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permit, or <code>null</code> if a matching permit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit fetchByZzjgdm_First(String zzjgdm,
		OrderByComparator orderByComparator) throws SystemException {
		List<Permit> list = findByZzjgdm(zzjgdm, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Permit findByZzjgdm_Last(String zzjgdm,
		OrderByComparator orderByComparator)
		throws NoSuchPermitException, SystemException {
		Permit permit = fetchByZzjgdm_Last(zzjgdm, orderByComparator);

		if (permit != null) {
			return permit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("zzjgdm=");
		msg.append(zzjgdm);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPermitException(msg.toString());
	}

	/**
	 * Returns the last permit in the ordered set where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permit, or <code>null</code> if a matching permit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit fetchByZzjgdm_Last(String zzjgdm,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByZzjgdm(zzjgdm);

		if (count == 0) {
			return null;
		}

		List<Permit> list = findByZzjgdm(zzjgdm, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Permit[] findByZzjgdm_PrevAndNext(long permitId, String zzjgdm,
		OrderByComparator orderByComparator)
		throws NoSuchPermitException, SystemException {
		Permit permit = findByPrimaryKey(permitId);

		Session session = null;

		try {
			session = openSession();

			Permit[] array = new PermitImpl[3];

			array[0] = getByZzjgdm_PrevAndNext(session, permit, zzjgdm,
					orderByComparator, true);

			array[1] = permit;

			array[2] = getByZzjgdm_PrevAndNext(session, permit, zzjgdm,
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

	protected Permit getByZzjgdm_PrevAndNext(Session session, Permit permit,
		String zzjgdm, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERMIT_WHERE);

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
			query.append(PermitModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(permit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Permit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permits where zzjgdm = &#63; from the database.
	 *
	 * @param zzjgdm the zzjgdm
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByZzjgdm(String zzjgdm) throws SystemException {
		for (Permit permit : findByZzjgdm(zzjgdm, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(permit);
		}
	}

	/**
	 * Returns the number of permits where zzjgdm = &#63;.
	 *
	 * @param zzjgdm the zzjgdm
	 * @return the number of matching permits
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

			query.append(_SQL_COUNT_PERMIT_WHERE);

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

	private static final String _FINDER_COLUMN_ZZJGDM_ZZJGDM_1 = "permit.zzjgdm IS NULL";
	private static final String _FINDER_COLUMN_ZZJGDM_ZZJGDM_2 = "permit.zzjgdm = ?";
	private static final String _FINDER_COLUMN_ZZJGDM_ZZJGDM_3 = "(permit.zzjgdm IS NULL OR permit.zzjgdm = '')";

	public PermitPersistenceImpl() {
		setModelClass(Permit.class);
	}

	/**
	 * Caches the permit in the entity cache if it is enabled.
	 *
	 * @param permit the permit
	 */
	@Override
	public void cacheResult(Permit permit) {
		EntityCacheUtil.putResult(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitImpl.class, permit.getPrimaryKey(), permit);

		permit.resetOriginalValues();
	}

	/**
	 * Caches the permits in the entity cache if it is enabled.
	 *
	 * @param permits the permits
	 */
	@Override
	public void cacheResult(List<Permit> permits) {
		for (Permit permit : permits) {
			if (EntityCacheUtil.getResult(
						PermitModelImpl.ENTITY_CACHE_ENABLED, PermitImpl.class,
						permit.getPrimaryKey()) == null) {
				cacheResult(permit);
			}
			else {
				permit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all permits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PermitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PermitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the permit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Permit permit) {
		EntityCacheUtil.removeResult(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitImpl.class, permit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Permit> permits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Permit permit : permits) {
			EntityCacheUtil.removeResult(PermitModelImpl.ENTITY_CACHE_ENABLED,
				PermitImpl.class, permit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new permit with the primary key. Does not add the permit to the database.
	 *
	 * @param permitId the primary key for the new permit
	 * @return the new permit
	 */
	@Override
	public Permit create(long permitId) {
		Permit permit = new PermitImpl();

		permit.setNew(true);
		permit.setPrimaryKey(permitId);

		return permit;
	}

	/**
	 * Removes the permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permitId the primary key of the permit
	 * @return the permit that was removed
	 * @throws com.justonetech.cp.permit.NoSuchPermitException if a permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit remove(long permitId)
		throws NoSuchPermitException, SystemException {
		return remove((Serializable)permitId);
	}

	/**
	 * Removes the permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the permit
	 * @return the permit that was removed
	 * @throws com.justonetech.cp.permit.NoSuchPermitException if a permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit remove(Serializable primaryKey)
		throws NoSuchPermitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Permit permit = (Permit)session.get(PermitImpl.class, primaryKey);

			if (permit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPermitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(permit);
		}
		catch (NoSuchPermitException nsee) {
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
	protected Permit removeImpl(Permit permit) throws SystemException {
		permit = toUnwrappedModel(permit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(permit)) {
				permit = (Permit)session.get(PermitImpl.class,
						permit.getPrimaryKeyObj());
			}

			if (permit != null) {
				session.delete(permit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (permit != null) {
			clearCache(permit);
		}

		return permit;
	}

	@Override
	public Permit updateImpl(com.justonetech.cp.permit.model.Permit permit)
		throws SystemException {
		permit = toUnwrappedModel(permit);

		boolean isNew = permit.isNew();

		PermitModelImpl permitModelImpl = (PermitModelImpl)permit;

		Session session = null;

		try {
			session = openSession();

			if (permit.isNew()) {
				session.save(permit);

				permit.setNew(false);
			}
			else {
				session.merge(permit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PermitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((permitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { permitModelImpl.getOriginalZzjgdm() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZZJGDM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM,
					args);

				args = new Object[] { permitModelImpl.getZzjgdm() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ZZJGDM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ZZJGDM,
					args);
			}
		}

		EntityCacheUtil.putResult(PermitModelImpl.ENTITY_CACHE_ENABLED,
			PermitImpl.class, permit.getPrimaryKey(), permit);

		return permit;
	}

	protected Permit toUnwrappedModel(Permit permit) {
		if (permit instanceof PermitImpl) {
			return permit;
		}

		PermitImpl permitImpl = new PermitImpl();

		permitImpl.setNew(permit.isNew());
		permitImpl.setPrimaryKey(permit.getPrimaryKey());

		permitImpl.setPermitId(permit.getPermitId());
		permitImpl.setGroupId(permit.getGroupId());
		permitImpl.setCompanyId(permit.getCompanyId());
		permitImpl.setUserId(permit.getUserId());
		permitImpl.setUserName(permit.getUserName());
		permitImpl.setCreateDate(permit.getCreateDate());
		permitImpl.setModifiedDate(permit.getModifiedDate());
		permitImpl.setZzjgdm(permit.getZzjgdm());
		permitImpl.setBjbh(permit.getBjbh());
		permitImpl.setHtxxbsbh(permit.getHtxxbsbh());
		permitImpl.setSqbz(permit.getSqbz());
		permitImpl.setSqzt(permit.getSqzt());
		permitImpl.setBdh(permit.getBdh());
		permitImpl.setYwbh(permit.getYwbh());
		permitImpl.setSgxkzbh(permit.getSgxkzbh());
		permitImpl.setSlbh(permit.getSlbh());
		permitImpl.setHjgsz(permit.getHjgsz());
		permitImpl.setHjgsh(permit.getHjgsh());
		permitImpl.setSqr(permit.getSqr());
		permitImpl.setSqsx(permit.getSqsx());
		permitImpl.setSqh(permit.getSqh());
		permitImpl.setCltjr(permit.getCltjr());
		permitImpl.setCltjrlxdh(permit.getCltjrlxdh());
		permitImpl.setCltjrlxdz(permit.getCltjrlxdz());
		permitImpl.setSjr(permit.getSjr());
		permitImpl.setSjrlxdh(permit.getSjrlxdh());
		permitImpl.setSlyj(permit.getSlyj());
		permitImpl.setSlsj(permit.getSlsj());

		return permitImpl;
	}

	/**
	 * Returns the permit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the permit
	 * @return the permit
	 * @throws com.justonetech.cp.permit.NoSuchPermitException if a permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPermitException, SystemException {
		Permit permit = fetchByPrimaryKey(primaryKey);

		if (permit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPermitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return permit;
	}

	/**
	 * Returns the permit with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchPermitException} if it could not be found.
	 *
	 * @param permitId the primary key of the permit
	 * @return the permit
	 * @throws com.justonetech.cp.permit.NoSuchPermitException if a permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit findByPrimaryKey(long permitId)
		throws NoSuchPermitException, SystemException {
		return findByPrimaryKey((Serializable)permitId);
	}

	/**
	 * Returns the permit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the permit
	 * @return the permit, or <code>null</code> if a permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Permit permit = (Permit)EntityCacheUtil.getResult(PermitModelImpl.ENTITY_CACHE_ENABLED,
				PermitImpl.class, primaryKey);

		if (permit == _nullPermit) {
			return null;
		}

		if (permit == null) {
			Session session = null;

			try {
				session = openSession();

				permit = (Permit)session.get(PermitImpl.class, primaryKey);

				if (permit != null) {
					cacheResult(permit);
				}
				else {
					EntityCacheUtil.putResult(PermitModelImpl.ENTITY_CACHE_ENABLED,
						PermitImpl.class, primaryKey, _nullPermit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PermitModelImpl.ENTITY_CACHE_ENABLED,
					PermitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return permit;
	}

	/**
	 * Returns the permit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permitId the primary key of the permit
	 * @return the permit, or <code>null</code> if a permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Permit fetchByPrimaryKey(long permitId) throws SystemException {
		return fetchByPrimaryKey((Serializable)permitId);
	}

	/**
	 * Returns all the permits.
	 *
	 * @return the permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Permit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Permit> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Permit> findAll(int start, int end,
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

		List<Permit> list = (List<Permit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PERMIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERMIT;

				if (pagination) {
					sql = sql.concat(PermitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Permit>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Permit>(list);
				}
				else {
					list = (List<Permit>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the permits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Permit permit : findAll()) {
			remove(permit);
		}
	}

	/**
	 * Returns the number of permits.
	 *
	 * @return the number of permits
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

				Query q = session.createQuery(_SQL_COUNT_PERMIT);

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
	 * Initializes the permit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.permit.model.Permit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Permit>> listenersList = new ArrayList<ModelListener<Permit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Permit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PermitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PERMIT = "SELECT permit FROM Permit permit";
	private static final String _SQL_SELECT_PERMIT_WHERE = "SELECT permit FROM Permit permit WHERE ";
	private static final String _SQL_COUNT_PERMIT = "SELECT COUNT(permit) FROM Permit permit";
	private static final String _SQL_COUNT_PERMIT_WHERE = "SELECT COUNT(permit) FROM Permit permit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "permit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Permit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Permit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PermitPersistenceImpl.class);
	private static Permit _nullPermit = new PermitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Permit> toCacheModel() {
				return _nullPermitCacheModel;
			}
		};

	private static CacheModel<Permit> _nullPermitCacheModel = new CacheModel<Permit>() {
			@Override
			public Permit toEntityModel() {
				return _nullPermit;
			}
		};
}