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

import com.justonetech.cp.permit.NoSuchParticipationUnitException;
import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.impl.ParticipationUnitImpl;
import com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl;

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
 * The persistence implementation for the participation unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ParticipationUnitPersistence
 * @see ParticipationUnitUtil
 * @generated
 */
public class ParticipationUnitPersistenceImpl extends BasePersistenceImpl<ParticipationUnit>
	implements ParticipationUnitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ParticipationUnitUtil} to access the participation unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ParticipationUnitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitModelImpl.FINDER_CACHE_ENABLED,
			ParticipationUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitModelImpl.FINDER_CACHE_ENABLED,
			ParticipationUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMITID = new FinderPath(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitModelImpl.FINDER_CACHE_ENABLED,
			ParticipationUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPermitId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID =
		new FinderPath(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitModelImpl.FINDER_CACHE_ENABLED,
			ParticipationUnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPermitId",
			new String[] { String.class.getName() },
			ParticipationUnitModelImpl.PERMITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERMITID = new FinderPath(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPermitId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the participation units where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @return the matching participation units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParticipationUnit> findByPermitId(String permitId)
		throws SystemException {
		return findByPermitId(permitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the participation units where permitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param permitId the permit ID
	 * @param start the lower bound of the range of participation units
	 * @param end the upper bound of the range of participation units (not inclusive)
	 * @return the range of matching participation units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParticipationUnit> findByPermitId(String permitId, int start,
		int end) throws SystemException {
		return findByPermitId(permitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the participation units where permitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param permitId the permit ID
	 * @param start the lower bound of the range of participation units
	 * @param end the upper bound of the range of participation units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching participation units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParticipationUnit> findByPermitId(String permitId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID;
			finderArgs = new Object[] { permitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMITID;
			finderArgs = new Object[] { permitId, start, end, orderByComparator };
		}

		List<ParticipationUnit> list = (List<ParticipationUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ParticipationUnit participationUnit : list) {
				if (!Validator.equals(permitId, participationUnit.getPermitId())) {
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

			query.append(_SQL_SELECT_PARTICIPATIONUNIT_WHERE);

			boolean bindPermitId = false;

			if (permitId == null) {
				query.append(_FINDER_COLUMN_PERMITID_PERMITID_1);
			}
			else if (permitId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERMITID_PERMITID_3);
			}
			else {
				bindPermitId = true;

				query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ParticipationUnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPermitId) {
					qPos.add(permitId);
				}

				if (!pagination) {
					list = (List<ParticipationUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ParticipationUnit>(list);
				}
				else {
					list = (List<ParticipationUnit>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first participation unit in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation unit
	 * @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a matching participation unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit findByPermitId_First(String permitId,
		OrderByComparator orderByComparator)
		throws NoSuchParticipationUnitException, SystemException {
		ParticipationUnit participationUnit = fetchByPermitId_First(permitId,
				orderByComparator);

		if (participationUnit != null) {
			return participationUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permitId=");
		msg.append(permitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipationUnitException(msg.toString());
	}

	/**
	 * Returns the first participation unit in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching participation unit, or <code>null</code> if a matching participation unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit fetchByPermitId_First(String permitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ParticipationUnit> list = findByPermitId(permitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last participation unit in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation unit
	 * @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a matching participation unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit findByPermitId_Last(String permitId,
		OrderByComparator orderByComparator)
		throws NoSuchParticipationUnitException, SystemException {
		ParticipationUnit participationUnit = fetchByPermitId_Last(permitId,
				orderByComparator);

		if (participationUnit != null) {
			return participationUnit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permitId=");
		msg.append(permitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchParticipationUnitException(msg.toString());
	}

	/**
	 * Returns the last participation unit in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching participation unit, or <code>null</code> if a matching participation unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit fetchByPermitId_Last(String permitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPermitId(permitId);

		if (count == 0) {
			return null;
		}

		List<ParticipationUnit> list = findByPermitId(permitId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the participation units before and after the current participation unit in the ordered set where permitId = &#63;.
	 *
	 * @param unitId the primary key of the current participation unit
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next participation unit
	 * @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit[] findByPermitId_PrevAndNext(long unitId,
		String permitId, OrderByComparator orderByComparator)
		throws NoSuchParticipationUnitException, SystemException {
		ParticipationUnit participationUnit = findByPrimaryKey(unitId);

		Session session = null;

		try {
			session = openSession();

			ParticipationUnit[] array = new ParticipationUnitImpl[3];

			array[0] = getByPermitId_PrevAndNext(session, participationUnit,
					permitId, orderByComparator, true);

			array[1] = participationUnit;

			array[2] = getByPermitId_PrevAndNext(session, participationUnit,
					permitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ParticipationUnit getByPermitId_PrevAndNext(Session session,
		ParticipationUnit participationUnit, String permitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PARTICIPATIONUNIT_WHERE);

		boolean bindPermitId = false;

		if (permitId == null) {
			query.append(_FINDER_COLUMN_PERMITID_PERMITID_1);
		}
		else if (permitId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PERMITID_PERMITID_3);
		}
		else {
			bindPermitId = true;

			query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);
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
			query.append(ParticipationUnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPermitId) {
			qPos.add(permitId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(participationUnit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ParticipationUnit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the participation units where permitId = &#63; from the database.
	 *
	 * @param permitId the permit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPermitId(String permitId) throws SystemException {
		for (ParticipationUnit participationUnit : findByPermitId(permitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(participationUnit);
		}
	}

	/**
	 * Returns the number of participation units where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @return the number of matching participation units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPermitId(String permitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERMITID;

		Object[] finderArgs = new Object[] { permitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PARTICIPATIONUNIT_WHERE);

			boolean bindPermitId = false;

			if (permitId == null) {
				query.append(_FINDER_COLUMN_PERMITID_PERMITID_1);
			}
			else if (permitId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERMITID_PERMITID_3);
			}
			else {
				bindPermitId = true;

				query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPermitId) {
					qPos.add(permitId);
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

	private static final String _FINDER_COLUMN_PERMITID_PERMITID_1 = "participationUnit.permitId IS NULL";
	private static final String _FINDER_COLUMN_PERMITID_PERMITID_2 = "participationUnit.permitId = ?";
	private static final String _FINDER_COLUMN_PERMITID_PERMITID_3 = "(participationUnit.permitId IS NULL OR participationUnit.permitId = '')";

	public ParticipationUnitPersistenceImpl() {
		setModelClass(ParticipationUnit.class);
	}

	/**
	 * Caches the participation unit in the entity cache if it is enabled.
	 *
	 * @param participationUnit the participation unit
	 */
	@Override
	public void cacheResult(ParticipationUnit participationUnit) {
		EntityCacheUtil.putResult(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitImpl.class, participationUnit.getPrimaryKey(),
			participationUnit);

		participationUnit.resetOriginalValues();
	}

	/**
	 * Caches the participation units in the entity cache if it is enabled.
	 *
	 * @param participationUnits the participation units
	 */
	@Override
	public void cacheResult(List<ParticipationUnit> participationUnits) {
		for (ParticipationUnit participationUnit : participationUnits) {
			if (EntityCacheUtil.getResult(
						ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
						ParticipationUnitImpl.class,
						participationUnit.getPrimaryKey()) == null) {
				cacheResult(participationUnit);
			}
			else {
				participationUnit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all participation units.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ParticipationUnitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ParticipationUnitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the participation unit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ParticipationUnit participationUnit) {
		EntityCacheUtil.removeResult(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitImpl.class, participationUnit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ParticipationUnit> participationUnits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ParticipationUnit participationUnit : participationUnits) {
			EntityCacheUtil.removeResult(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
				ParticipationUnitImpl.class, participationUnit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new participation unit with the primary key. Does not add the participation unit to the database.
	 *
	 * @param unitId the primary key for the new participation unit
	 * @return the new participation unit
	 */
	@Override
	public ParticipationUnit create(long unitId) {
		ParticipationUnit participationUnit = new ParticipationUnitImpl();

		participationUnit.setNew(true);
		participationUnit.setPrimaryKey(unitId);

		return participationUnit;
	}

	/**
	 * Removes the participation unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitId the primary key of the participation unit
	 * @return the participation unit that was removed
	 * @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit remove(long unitId)
		throws NoSuchParticipationUnitException, SystemException {
		return remove((Serializable)unitId);
	}

	/**
	 * Removes the participation unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the participation unit
	 * @return the participation unit that was removed
	 * @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit remove(Serializable primaryKey)
		throws NoSuchParticipationUnitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ParticipationUnit participationUnit = (ParticipationUnit)session.get(ParticipationUnitImpl.class,
					primaryKey);

			if (participationUnit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParticipationUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(participationUnit);
		}
		catch (NoSuchParticipationUnitException nsee) {
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
	protected ParticipationUnit removeImpl(ParticipationUnit participationUnit)
		throws SystemException {
		participationUnit = toUnwrappedModel(participationUnit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(participationUnit)) {
				participationUnit = (ParticipationUnit)session.get(ParticipationUnitImpl.class,
						participationUnit.getPrimaryKeyObj());
			}

			if (participationUnit != null) {
				session.delete(participationUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (participationUnit != null) {
			clearCache(participationUnit);
		}

		return participationUnit;
	}

	@Override
	public ParticipationUnit updateImpl(
		com.justonetech.cp.permit.model.ParticipationUnit participationUnit)
		throws SystemException {
		participationUnit = toUnwrappedModel(participationUnit);

		boolean isNew = participationUnit.isNew();

		ParticipationUnitModelImpl participationUnitModelImpl = (ParticipationUnitModelImpl)participationUnit;

		Session session = null;

		try {
			session = openSession();

			if (participationUnit.isNew()) {
				session.save(participationUnit);

				participationUnit.setNew(false);
			}
			else {
				session.merge(participationUnit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ParticipationUnitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((participationUnitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						participationUnitModelImpl.getOriginalPermitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMITID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID,
					args);

				args = new Object[] { participationUnitModelImpl.getPermitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMITID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID,
					args);
			}
		}

		EntityCacheUtil.putResult(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
			ParticipationUnitImpl.class, participationUnit.getPrimaryKey(),
			participationUnit);

		return participationUnit;
	}

	protected ParticipationUnit toUnwrappedModel(
		ParticipationUnit participationUnit) {
		if (participationUnit instanceof ParticipationUnitImpl) {
			return participationUnit;
		}

		ParticipationUnitImpl participationUnitImpl = new ParticipationUnitImpl();

		participationUnitImpl.setNew(participationUnit.isNew());
		participationUnitImpl.setPrimaryKey(participationUnit.getPrimaryKey());

		participationUnitImpl.setUnitId(participationUnit.getUnitId());
		participationUnitImpl.setPermitId(participationUnit.getPermitId());
		participationUnitImpl.setHtxxbsbh(participationUnit.getHtxxbsbh());
		participationUnitImpl.setDwlx(participationUnit.getDwlx());
		participationUnitImpl.setDwmc(participationUnit.getDwmc());
		participationUnitImpl.setXmfzr(participationUnit.getXmfzr());
		participationUnitImpl.setDhhm(participationUnit.getDhhm());

		return participationUnitImpl;
	}

	/**
	 * Returns the participation unit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the participation unit
	 * @return the participation unit
	 * @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchParticipationUnitException, SystemException {
		ParticipationUnit participationUnit = fetchByPrimaryKey(primaryKey);

		if (participationUnit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchParticipationUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return participationUnit;
	}

	/**
	 * Returns the participation unit with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchParticipationUnitException} if it could not be found.
	 *
	 * @param unitId the primary key of the participation unit
	 * @return the participation unit
	 * @throws com.justonetech.cp.permit.NoSuchParticipationUnitException if a participation unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit findByPrimaryKey(long unitId)
		throws NoSuchParticipationUnitException, SystemException {
		return findByPrimaryKey((Serializable)unitId);
	}

	/**
	 * Returns the participation unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the participation unit
	 * @return the participation unit, or <code>null</code> if a participation unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ParticipationUnit participationUnit = (ParticipationUnit)EntityCacheUtil.getResult(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
				ParticipationUnitImpl.class, primaryKey);

		if (participationUnit == _nullParticipationUnit) {
			return null;
		}

		if (participationUnit == null) {
			Session session = null;

			try {
				session = openSession();

				participationUnit = (ParticipationUnit)session.get(ParticipationUnitImpl.class,
						primaryKey);

				if (participationUnit != null) {
					cacheResult(participationUnit);
				}
				else {
					EntityCacheUtil.putResult(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
						ParticipationUnitImpl.class, primaryKey,
						_nullParticipationUnit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ParticipationUnitModelImpl.ENTITY_CACHE_ENABLED,
					ParticipationUnitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return participationUnit;
	}

	/**
	 * Returns the participation unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitId the primary key of the participation unit
	 * @return the participation unit, or <code>null</code> if a participation unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ParticipationUnit fetchByPrimaryKey(long unitId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)unitId);
	}

	/**
	 * Returns all the participation units.
	 *
	 * @return the participation units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParticipationUnit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the participation units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation units
	 * @param end the upper bound of the range of participation units (not inclusive)
	 * @return the range of participation units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParticipationUnit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the participation units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ParticipationUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of participation units
	 * @param end the upper bound of the range of participation units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of participation units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ParticipationUnit> findAll(int start, int end,
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

		List<ParticipationUnit> list = (List<ParticipationUnit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PARTICIPATIONUNIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARTICIPATIONUNIT;

				if (pagination) {
					sql = sql.concat(ParticipationUnitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ParticipationUnit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ParticipationUnit>(list);
				}
				else {
					list = (List<ParticipationUnit>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the participation units from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ParticipationUnit participationUnit : findAll()) {
			remove(participationUnit);
		}
	}

	/**
	 * Returns the number of participation units.
	 *
	 * @return the number of participation units
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

				Query q = session.createQuery(_SQL_COUNT_PARTICIPATIONUNIT);

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
	 * Initializes the participation unit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.permit.model.ParticipationUnit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ParticipationUnit>> listenersList = new ArrayList<ModelListener<ParticipationUnit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ParticipationUnit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ParticipationUnitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PARTICIPATIONUNIT = "SELECT participationUnit FROM ParticipationUnit participationUnit";
	private static final String _SQL_SELECT_PARTICIPATIONUNIT_WHERE = "SELECT participationUnit FROM ParticipationUnit participationUnit WHERE ";
	private static final String _SQL_COUNT_PARTICIPATIONUNIT = "SELECT COUNT(participationUnit) FROM ParticipationUnit participationUnit";
	private static final String _SQL_COUNT_PARTICIPATIONUNIT_WHERE = "SELECT COUNT(participationUnit) FROM ParticipationUnit participationUnit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "participationUnit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ParticipationUnit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ParticipationUnit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ParticipationUnitPersistenceImpl.class);
	private static ParticipationUnit _nullParticipationUnit = new ParticipationUnitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ParticipationUnit> toCacheModel() {
				return _nullParticipationUnitCacheModel;
			}
		};

	private static CacheModel<ParticipationUnit> _nullParticipationUnitCacheModel =
		new CacheModel<ParticipationUnit>() {
			@Override
			public ParticipationUnit toEntityModel() {
				return _nullParticipationUnit;
			}
		};
}