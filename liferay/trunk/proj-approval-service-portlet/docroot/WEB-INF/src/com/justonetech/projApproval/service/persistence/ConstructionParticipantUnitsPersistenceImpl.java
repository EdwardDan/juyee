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

package com.justonetech.projApproval.service.persistence;

import com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException;
import com.justonetech.projApproval.model.ConstructionParticipantUnits;
import com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsImpl;
import com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the construction participant units service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionParticipantUnitsPersistence
 * @see ConstructionParticipantUnitsUtil
 * @generated
 */
public class ConstructionParticipantUnitsPersistenceImpl
	extends BasePersistenceImpl<ConstructionParticipantUnits>
	implements ConstructionParticipantUnitsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConstructionParticipantUnitsUtil} to access the construction participant units persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConstructionParticipantUnitsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsModelImpl.FINDER_CACHE_ENABLED,
			ConstructionParticipantUnitsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsModelImpl.FINDER_CACHE_ENABLED,
			ConstructionParticipantUnitsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSTRUCTIONPERMITID =
		new FinderPath(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsModelImpl.FINDER_CACHE_ENABLED,
			ConstructionParticipantUnitsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByConstructionPermitId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSTRUCTIONPERMITID =
		new FinderPath(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsModelImpl.FINDER_CACHE_ENABLED,
			ConstructionParticipantUnitsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByConstructionPermitId",
			new String[] { Long.class.getName() },
			ConstructionParticipantUnitsModelImpl.CONSTRUCTIONPERMITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID = new FinderPath(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConstructionPermitId", new String[] { Long.class.getName() });

	/**
	 * Returns all the construction participant unitses where constructionPermitId = &#63;.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @return the matching construction participant unitses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionParticipantUnits> findByConstructionPermitId(
		long constructionPermitId) throws SystemException {
		return findByConstructionPermitId(constructionPermitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the construction participant unitses where constructionPermitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param constructionPermitId the construction permit ID
	 * @param start the lower bound of the range of construction participant unitses
	 * @param end the upper bound of the range of construction participant unitses (not inclusive)
	 * @return the range of matching construction participant unitses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionParticipantUnits> findByConstructionPermitId(
		long constructionPermitId, int start, int end)
		throws SystemException {
		return findByConstructionPermitId(constructionPermitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the construction participant unitses where constructionPermitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param constructionPermitId the construction permit ID
	 * @param start the lower bound of the range of construction participant unitses
	 * @param end the upper bound of the range of construction participant unitses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching construction participant unitses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionParticipantUnits> findByConstructionPermitId(
		long constructionPermitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSTRUCTIONPERMITID;
			finderArgs = new Object[] { constructionPermitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONSTRUCTIONPERMITID;
			finderArgs = new Object[] {
					constructionPermitId,
					
					start, end, orderByComparator
				};
		}

		List<ConstructionParticipantUnits> list = (List<ConstructionParticipantUnits>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConstructionParticipantUnits constructionParticipantUnits : list) {
				if ((constructionPermitId != constructionParticipantUnits.getConstructionPermitId())) {
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

			query.append(_SQL_SELECT_CONSTRUCTIONPARTICIPANTUNITS_WHERE);

			query.append(_FINDER_COLUMN_CONSTRUCTIONPERMITID_CONSTRUCTIONPERMITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConstructionParticipantUnitsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(constructionPermitId);

				if (!pagination) {
					list = (List<ConstructionParticipantUnits>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConstructionParticipantUnits>(list);
				}
				else {
					list = (List<ConstructionParticipantUnits>)QueryUtil.list(q,
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
	 * Returns the first construction participant units in the ordered set where constructionPermitId = &#63;.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching construction participant units
	 * @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a matching construction participant units could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits findByConstructionPermitId_First(
		long constructionPermitId, OrderByComparator orderByComparator)
		throws NoSuchConstructionParticipantUnitsException, SystemException {
		ConstructionParticipantUnits constructionParticipantUnits = fetchByConstructionPermitId_First(constructionPermitId,
				orderByComparator);

		if (constructionParticipantUnits != null) {
			return constructionParticipantUnits;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("constructionPermitId=");
		msg.append(constructionPermitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConstructionParticipantUnitsException(msg.toString());
	}

	/**
	 * Returns the first construction participant units in the ordered set where constructionPermitId = &#63;.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching construction participant units, or <code>null</code> if a matching construction participant units could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits fetchByConstructionPermitId_First(
		long constructionPermitId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ConstructionParticipantUnits> list = findByConstructionPermitId(constructionPermitId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last construction participant units in the ordered set where constructionPermitId = &#63;.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching construction participant units
	 * @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a matching construction participant units could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits findByConstructionPermitId_Last(
		long constructionPermitId, OrderByComparator orderByComparator)
		throws NoSuchConstructionParticipantUnitsException, SystemException {
		ConstructionParticipantUnits constructionParticipantUnits = fetchByConstructionPermitId_Last(constructionPermitId,
				orderByComparator);

		if (constructionParticipantUnits != null) {
			return constructionParticipantUnits;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("constructionPermitId=");
		msg.append(constructionPermitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConstructionParticipantUnitsException(msg.toString());
	}

	/**
	 * Returns the last construction participant units in the ordered set where constructionPermitId = &#63;.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching construction participant units, or <code>null</code> if a matching construction participant units could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits fetchByConstructionPermitId_Last(
		long constructionPermitId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByConstructionPermitId(constructionPermitId);

		if (count == 0) {
			return null;
		}

		List<ConstructionParticipantUnits> list = findByConstructionPermitId(constructionPermitId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the construction participant unitses before and after the current construction participant units in the ordered set where constructionPermitId = &#63;.
	 *
	 * @param constructionParticipantUnitsId the primary key of the current construction participant units
	 * @param constructionPermitId the construction permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next construction participant units
	 * @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits[] findByConstructionPermitId_PrevAndNext(
		long constructionParticipantUnitsId, long constructionPermitId,
		OrderByComparator orderByComparator)
		throws NoSuchConstructionParticipantUnitsException, SystemException {
		ConstructionParticipantUnits constructionParticipantUnits = findByPrimaryKey(constructionParticipantUnitsId);

		Session session = null;

		try {
			session = openSession();

			ConstructionParticipantUnits[] array = new ConstructionParticipantUnitsImpl[3];

			array[0] = getByConstructionPermitId_PrevAndNext(session,
					constructionParticipantUnits, constructionPermitId,
					orderByComparator, true);

			array[1] = constructionParticipantUnits;

			array[2] = getByConstructionPermitId_PrevAndNext(session,
					constructionParticipantUnits, constructionPermitId,
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

	protected ConstructionParticipantUnits getByConstructionPermitId_PrevAndNext(
		Session session,
		ConstructionParticipantUnits constructionParticipantUnits,
		long constructionPermitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSTRUCTIONPARTICIPANTUNITS_WHERE);

		query.append(_FINDER_COLUMN_CONSTRUCTIONPERMITID_CONSTRUCTIONPERMITID_2);

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
			query.append(ConstructionParticipantUnitsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(constructionPermitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(constructionParticipantUnits);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConstructionParticipantUnits> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the construction participant unitses where constructionPermitId = &#63; from the database.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByConstructionPermitId(long constructionPermitId)
		throws SystemException {
		for (ConstructionParticipantUnits constructionParticipantUnits : findByConstructionPermitId(
				constructionPermitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(constructionParticipantUnits);
		}
	}

	/**
	 * Returns the number of construction participant unitses where constructionPermitId = &#63;.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @return the number of matching construction participant unitses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByConstructionPermitId(long constructionPermitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID;

		Object[] finderArgs = new Object[] { constructionPermitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONSTRUCTIONPARTICIPANTUNITS_WHERE);

			query.append(_FINDER_COLUMN_CONSTRUCTIONPERMITID_CONSTRUCTIONPERMITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(constructionPermitId);

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

	private static final String _FINDER_COLUMN_CONSTRUCTIONPERMITID_CONSTRUCTIONPERMITID_2 =
		"constructionParticipantUnits.constructionPermitId = ?";

	public ConstructionParticipantUnitsPersistenceImpl() {
		setModelClass(ConstructionParticipantUnits.class);
	}

	/**
	 * Caches the construction participant units in the entity cache if it is enabled.
	 *
	 * @param constructionParticipantUnits the construction participant units
	 */
	@Override
	public void cacheResult(
		ConstructionParticipantUnits constructionParticipantUnits) {
		EntityCacheUtil.putResult(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsImpl.class,
			constructionParticipantUnits.getPrimaryKey(),
			constructionParticipantUnits);

		constructionParticipantUnits.resetOriginalValues();
	}

	/**
	 * Caches the construction participant unitses in the entity cache if it is enabled.
	 *
	 * @param constructionParticipantUnitses the construction participant unitses
	 */
	@Override
	public void cacheResult(
		List<ConstructionParticipantUnits> constructionParticipantUnitses) {
		for (ConstructionParticipantUnits constructionParticipantUnits : constructionParticipantUnitses) {
			if (EntityCacheUtil.getResult(
						ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
						ConstructionParticipantUnitsImpl.class,
						constructionParticipantUnits.getPrimaryKey()) == null) {
				cacheResult(constructionParticipantUnits);
			}
			else {
				constructionParticipantUnits.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all construction participant unitses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConstructionParticipantUnitsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConstructionParticipantUnitsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the construction participant units.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ConstructionParticipantUnits constructionParticipantUnits) {
		EntityCacheUtil.removeResult(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsImpl.class,
			constructionParticipantUnits.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ConstructionParticipantUnits> constructionParticipantUnitses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConstructionParticipantUnits constructionParticipantUnits : constructionParticipantUnitses) {
			EntityCacheUtil.removeResult(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
				ConstructionParticipantUnitsImpl.class,
				constructionParticipantUnits.getPrimaryKey());
		}
	}

	/**
	 * Creates a new construction participant units with the primary key. Does not add the construction participant units to the database.
	 *
	 * @param constructionParticipantUnitsId the primary key for the new construction participant units
	 * @return the new construction participant units
	 */
	@Override
	public ConstructionParticipantUnits create(
		long constructionParticipantUnitsId) {
		ConstructionParticipantUnits constructionParticipantUnits = new ConstructionParticipantUnitsImpl();

		constructionParticipantUnits.setNew(true);
		constructionParticipantUnits.setPrimaryKey(constructionParticipantUnitsId);

		return constructionParticipantUnits;
	}

	/**
	 * Removes the construction participant units with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param constructionParticipantUnitsId the primary key of the construction participant units
	 * @return the construction participant units that was removed
	 * @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits remove(
		long constructionParticipantUnitsId)
		throws NoSuchConstructionParticipantUnitsException, SystemException {
		return remove((Serializable)constructionParticipantUnitsId);
	}

	/**
	 * Removes the construction participant units with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the construction participant units
	 * @return the construction participant units that was removed
	 * @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits remove(Serializable primaryKey)
		throws NoSuchConstructionParticipantUnitsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConstructionParticipantUnits constructionParticipantUnits = (ConstructionParticipantUnits)session.get(ConstructionParticipantUnitsImpl.class,
					primaryKey);

			if (constructionParticipantUnits == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConstructionParticipantUnitsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(constructionParticipantUnits);
		}
		catch (NoSuchConstructionParticipantUnitsException nsee) {
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
	protected ConstructionParticipantUnits removeImpl(
		ConstructionParticipantUnits constructionParticipantUnits)
		throws SystemException {
		constructionParticipantUnits = toUnwrappedModel(constructionParticipantUnits);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(constructionParticipantUnits)) {
				constructionParticipantUnits = (ConstructionParticipantUnits)session.get(ConstructionParticipantUnitsImpl.class,
						constructionParticipantUnits.getPrimaryKeyObj());
			}

			if (constructionParticipantUnits != null) {
				session.delete(constructionParticipantUnits);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (constructionParticipantUnits != null) {
			clearCache(constructionParticipantUnits);
		}

		return constructionParticipantUnits;
	}

	@Override
	public ConstructionParticipantUnits updateImpl(
		com.justonetech.projApproval.model.ConstructionParticipantUnits constructionParticipantUnits)
		throws SystemException {
		constructionParticipantUnits = toUnwrappedModel(constructionParticipantUnits);

		boolean isNew = constructionParticipantUnits.isNew();

		ConstructionParticipantUnitsModelImpl constructionParticipantUnitsModelImpl =
			(ConstructionParticipantUnitsModelImpl)constructionParticipantUnits;

		Session session = null;

		try {
			session = openSession();

			if (constructionParticipantUnits.isNew()) {
				session.save(constructionParticipantUnits);

				constructionParticipantUnits.setNew(false);
			}
			else {
				session.merge(constructionParticipantUnits);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ConstructionParticipantUnitsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((constructionParticipantUnitsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSTRUCTIONPERMITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						constructionParticipantUnitsModelImpl.getOriginalConstructionPermitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSTRUCTIONPERMITID,
					args);

				args = new Object[] {
						constructionParticipantUnitsModelImpl.getConstructionPermitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONSTRUCTIONPERMITID,
					args);
			}
		}

		EntityCacheUtil.putResult(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionParticipantUnitsImpl.class,
			constructionParticipantUnits.getPrimaryKey(),
			constructionParticipantUnits);

		return constructionParticipantUnits;
	}

	protected ConstructionParticipantUnits toUnwrappedModel(
		ConstructionParticipantUnits constructionParticipantUnits) {
		if (constructionParticipantUnits instanceof ConstructionParticipantUnitsImpl) {
			return constructionParticipantUnits;
		}

		ConstructionParticipantUnitsImpl constructionParticipantUnitsImpl = new ConstructionParticipantUnitsImpl();

		constructionParticipantUnitsImpl.setNew(constructionParticipantUnits.isNew());
		constructionParticipantUnitsImpl.setPrimaryKey(constructionParticipantUnits.getPrimaryKey());

		constructionParticipantUnitsImpl.setConstructionParticipantUnitsId(constructionParticipantUnits.getConstructionParticipantUnitsId());
		constructionParticipantUnitsImpl.setSortNo(constructionParticipantUnits.getSortNo());
		constructionParticipantUnitsImpl.setContractInfoSubmitNum(constructionParticipantUnits.getContractInfoSubmitNum());
		constructionParticipantUnitsImpl.setUnitType(constructionParticipantUnits.getUnitType());
		constructionParticipantUnitsImpl.setUnitName(constructionParticipantUnits.getUnitName());
		constructionParticipantUnitsImpl.setProjectLeader(constructionParticipantUnits.getProjectLeader());
		constructionParticipantUnitsImpl.setTelephoneNum(constructionParticipantUnits.getTelephoneNum());
		constructionParticipantUnitsImpl.setConstructionPermitId(constructionParticipantUnits.getConstructionPermitId());

		return constructionParticipantUnitsImpl;
	}

	/**
	 * Returns the construction participant units with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the construction participant units
	 * @return the construction participant units
	 * @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchConstructionParticipantUnitsException, SystemException {
		ConstructionParticipantUnits constructionParticipantUnits = fetchByPrimaryKey(primaryKey);

		if (constructionParticipantUnits == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConstructionParticipantUnitsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return constructionParticipantUnits;
	}

	/**
	 * Returns the construction participant units with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException} if it could not be found.
	 *
	 * @param constructionParticipantUnitsId the primary key of the construction participant units
	 * @return the construction participant units
	 * @throws com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException if a construction participant units with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits findByPrimaryKey(
		long constructionParticipantUnitsId)
		throws NoSuchConstructionParticipantUnitsException, SystemException {
		return findByPrimaryKey((Serializable)constructionParticipantUnitsId);
	}

	/**
	 * Returns the construction participant units with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the construction participant units
	 * @return the construction participant units, or <code>null</code> if a construction participant units with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		ConstructionParticipantUnits constructionParticipantUnits = (ConstructionParticipantUnits)EntityCacheUtil.getResult(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
				ConstructionParticipantUnitsImpl.class, primaryKey);

		if (constructionParticipantUnits == _nullConstructionParticipantUnits) {
			return null;
		}

		if (constructionParticipantUnits == null) {
			Session session = null;

			try {
				session = openSession();

				constructionParticipantUnits = (ConstructionParticipantUnits)session.get(ConstructionParticipantUnitsImpl.class,
						primaryKey);

				if (constructionParticipantUnits != null) {
					cacheResult(constructionParticipantUnits);
				}
				else {
					EntityCacheUtil.putResult(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
						ConstructionParticipantUnitsImpl.class, primaryKey,
						_nullConstructionParticipantUnits);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConstructionParticipantUnitsModelImpl.ENTITY_CACHE_ENABLED,
					ConstructionParticipantUnitsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return constructionParticipantUnits;
	}

	/**
	 * Returns the construction participant units with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param constructionParticipantUnitsId the primary key of the construction participant units
	 * @return the construction participant units, or <code>null</code> if a construction participant units with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionParticipantUnits fetchByPrimaryKey(
		long constructionParticipantUnitsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)constructionParticipantUnitsId);
	}

	/**
	 * Returns all the construction participant unitses.
	 *
	 * @return the construction participant unitses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionParticipantUnits> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the construction participant unitses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of construction participant unitses
	 * @param end the upper bound of the range of construction participant unitses (not inclusive)
	 * @return the range of construction participant unitses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionParticipantUnits> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the construction participant unitses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionParticipantUnitsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of construction participant unitses
	 * @param end the upper bound of the range of construction participant unitses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of construction participant unitses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionParticipantUnits> findAll(int start, int end,
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

		List<ConstructionParticipantUnits> list = (List<ConstructionParticipantUnits>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONSTRUCTIONPARTICIPANTUNITS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONSTRUCTIONPARTICIPANTUNITS;

				if (pagination) {
					sql = sql.concat(ConstructionParticipantUnitsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConstructionParticipantUnits>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConstructionParticipantUnits>(list);
				}
				else {
					list = (List<ConstructionParticipantUnits>)QueryUtil.list(q,
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
	 * Removes all the construction participant unitses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConstructionParticipantUnits constructionParticipantUnits : findAll()) {
			remove(constructionParticipantUnits);
		}
	}

	/**
	 * Returns the number of construction participant unitses.
	 *
	 * @return the number of construction participant unitses
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

				Query q = session.createQuery(_SQL_COUNT_CONSTRUCTIONPARTICIPANTUNITS);

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
	 * Initializes the construction participant units persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.projApproval.model.ConstructionParticipantUnits")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConstructionParticipantUnits>> listenersList = new ArrayList<ModelListener<ConstructionParticipantUnits>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConstructionParticipantUnits>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConstructionParticipantUnitsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONSTRUCTIONPARTICIPANTUNITS = "SELECT constructionParticipantUnits FROM ConstructionParticipantUnits constructionParticipantUnits";
	private static final String _SQL_SELECT_CONSTRUCTIONPARTICIPANTUNITS_WHERE = "SELECT constructionParticipantUnits FROM ConstructionParticipantUnits constructionParticipantUnits WHERE ";
	private static final String _SQL_COUNT_CONSTRUCTIONPARTICIPANTUNITS = "SELECT COUNT(constructionParticipantUnits) FROM ConstructionParticipantUnits constructionParticipantUnits";
	private static final String _SQL_COUNT_CONSTRUCTIONPARTICIPANTUNITS_WHERE = "SELECT COUNT(constructionParticipantUnits) FROM ConstructionParticipantUnits constructionParticipantUnits WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "constructionParticipantUnits.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConstructionParticipantUnits exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConstructionParticipantUnits exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConstructionParticipantUnitsPersistenceImpl.class);
	private static ConstructionParticipantUnits _nullConstructionParticipantUnits =
		new ConstructionParticipantUnitsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConstructionParticipantUnits> toCacheModel() {
				return _nullConstructionParticipantUnitsCacheModel;
			}
		};

	private static CacheModel<ConstructionParticipantUnits> _nullConstructionParticipantUnitsCacheModel =
		new CacheModel<ConstructionParticipantUnits>() {
			@Override
			public ConstructionParticipantUnits toEntityModel() {
				return _nullConstructionParticipantUnits;
			}
		};
}