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

package com.justonetech.oa.service.persistence;

import com.justonetech.oa.NoSuchDeptWorkItemException;
import com.justonetech.oa.model.DeptWorkItem;
import com.justonetech.oa.model.impl.DeptWorkItemImpl;
import com.justonetech.oa.model.impl.DeptWorkItemModelImpl;

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
 * The persistence implementation for the dept work item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DeptWorkItemPersistence
 * @see DeptWorkItemUtil
 * @generated
 */
public class DeptWorkItemPersistenceImpl extends BasePersistenceImpl<DeptWorkItem>
	implements DeptWorkItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DeptWorkItemUtil} to access the dept work item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DeptWorkItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemModelImpl.FINDER_CACHE_ENABLED, DeptWorkItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemModelImpl.FINDER_CACHE_ENABLED, DeptWorkItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPTWORKID =
		new FinderPath(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemModelImpl.FINDER_CACHE_ENABLED, DeptWorkItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeptWorkId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPTWORKID =
		new FinderPath(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemModelImpl.FINDER_CACHE_ENABLED, DeptWorkItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeptWorkId",
			new String[] { Long.class.getName() },
			DeptWorkItemModelImpl.DEPTWORKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPTWORKID = new FinderPath(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeptWorkId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dept work items where deptWorkId = &#63;.
	 *
	 * @param deptWorkId the dept work ID
	 * @return the matching dept work items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWorkItem> findByDeptWorkId(long deptWorkId)
		throws SystemException {
		return findByDeptWorkId(deptWorkId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dept work items where deptWorkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deptWorkId the dept work ID
	 * @param start the lower bound of the range of dept work items
	 * @param end the upper bound of the range of dept work items (not inclusive)
	 * @return the range of matching dept work items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWorkItem> findByDeptWorkId(long deptWorkId, int start,
		int end) throws SystemException {
		return findByDeptWorkId(deptWorkId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dept work items where deptWorkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deptWorkId the dept work ID
	 * @param start the lower bound of the range of dept work items
	 * @param end the upper bound of the range of dept work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dept work items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWorkItem> findByDeptWorkId(long deptWorkId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPTWORKID;
			finderArgs = new Object[] { deptWorkId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPTWORKID;
			finderArgs = new Object[] { deptWorkId, start, end, orderByComparator };
		}

		List<DeptWorkItem> list = (List<DeptWorkItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeptWorkItem deptWorkItem : list) {
				if ((deptWorkId != deptWorkItem.getDeptWorkId())) {
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

			query.append(_SQL_SELECT_DEPTWORKITEM_WHERE);

			query.append(_FINDER_COLUMN_DEPTWORKID_DEPTWORKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeptWorkItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(deptWorkId);

				if (!pagination) {
					list = (List<DeptWorkItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeptWorkItem>(list);
				}
				else {
					list = (List<DeptWorkItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dept work item in the ordered set where deptWorkId = &#63;.
	 *
	 * @param deptWorkId the dept work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dept work item
	 * @throws com.justonetech.oa.NoSuchDeptWorkItemException if a matching dept work item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem findByDeptWorkId_First(long deptWorkId,
		OrderByComparator orderByComparator)
		throws NoSuchDeptWorkItemException, SystemException {
		DeptWorkItem deptWorkItem = fetchByDeptWorkId_First(deptWorkId,
				orderByComparator);

		if (deptWorkItem != null) {
			return deptWorkItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deptWorkId=");
		msg.append(deptWorkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeptWorkItemException(msg.toString());
	}

	/**
	 * Returns the first dept work item in the ordered set where deptWorkId = &#63;.
	 *
	 * @param deptWorkId the dept work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dept work item, or <code>null</code> if a matching dept work item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem fetchByDeptWorkId_First(long deptWorkId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DeptWorkItem> list = findByDeptWorkId(deptWorkId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dept work item in the ordered set where deptWorkId = &#63;.
	 *
	 * @param deptWorkId the dept work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dept work item
	 * @throws com.justonetech.oa.NoSuchDeptWorkItemException if a matching dept work item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem findByDeptWorkId_Last(long deptWorkId,
		OrderByComparator orderByComparator)
		throws NoSuchDeptWorkItemException, SystemException {
		DeptWorkItem deptWorkItem = fetchByDeptWorkId_Last(deptWorkId,
				orderByComparator);

		if (deptWorkItem != null) {
			return deptWorkItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deptWorkId=");
		msg.append(deptWorkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeptWorkItemException(msg.toString());
	}

	/**
	 * Returns the last dept work item in the ordered set where deptWorkId = &#63;.
	 *
	 * @param deptWorkId the dept work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dept work item, or <code>null</code> if a matching dept work item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem fetchByDeptWorkId_Last(long deptWorkId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDeptWorkId(deptWorkId);

		if (count == 0) {
			return null;
		}

		List<DeptWorkItem> list = findByDeptWorkId(deptWorkId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dept work items before and after the current dept work item in the ordered set where deptWorkId = &#63;.
	 *
	 * @param deptWorkItemId the primary key of the current dept work item
	 * @param deptWorkId the dept work ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dept work item
	 * @throws com.justonetech.oa.NoSuchDeptWorkItemException if a dept work item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem[] findByDeptWorkId_PrevAndNext(long deptWorkItemId,
		long deptWorkId, OrderByComparator orderByComparator)
		throws NoSuchDeptWorkItemException, SystemException {
		DeptWorkItem deptWorkItem = findByPrimaryKey(deptWorkItemId);

		Session session = null;

		try {
			session = openSession();

			DeptWorkItem[] array = new DeptWorkItemImpl[3];

			array[0] = getByDeptWorkId_PrevAndNext(session, deptWorkItem,
					deptWorkId, orderByComparator, true);

			array[1] = deptWorkItem;

			array[2] = getByDeptWorkId_PrevAndNext(session, deptWorkItem,
					deptWorkId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeptWorkItem getByDeptWorkId_PrevAndNext(Session session,
		DeptWorkItem deptWorkItem, long deptWorkId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEPTWORKITEM_WHERE);

		query.append(_FINDER_COLUMN_DEPTWORKID_DEPTWORKID_2);

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
			query.append(DeptWorkItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(deptWorkId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(deptWorkItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeptWorkItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dept work items where deptWorkId = &#63; from the database.
	 *
	 * @param deptWorkId the dept work ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDeptWorkId(long deptWorkId) throws SystemException {
		for (DeptWorkItem deptWorkItem : findByDeptWorkId(deptWorkId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(deptWorkItem);
		}
	}

	/**
	 * Returns the number of dept work items where deptWorkId = &#63;.
	 *
	 * @param deptWorkId the dept work ID
	 * @return the number of matching dept work items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDeptWorkId(long deptWorkId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPTWORKID;

		Object[] finderArgs = new Object[] { deptWorkId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEPTWORKITEM_WHERE);

			query.append(_FINDER_COLUMN_DEPTWORKID_DEPTWORKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(deptWorkId);

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

	private static final String _FINDER_COLUMN_DEPTWORKID_DEPTWORKID_2 = "deptWorkItem.deptWorkId = ?";

	public DeptWorkItemPersistenceImpl() {
		setModelClass(DeptWorkItem.class);
	}

	/**
	 * Caches the dept work item in the entity cache if it is enabled.
	 *
	 * @param deptWorkItem the dept work item
	 */
	@Override
	public void cacheResult(DeptWorkItem deptWorkItem) {
		EntityCacheUtil.putResult(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemImpl.class, deptWorkItem.getPrimaryKey(), deptWorkItem);

		deptWorkItem.resetOriginalValues();
	}

	/**
	 * Caches the dept work items in the entity cache if it is enabled.
	 *
	 * @param deptWorkItems the dept work items
	 */
	@Override
	public void cacheResult(List<DeptWorkItem> deptWorkItems) {
		for (DeptWorkItem deptWorkItem : deptWorkItems) {
			if (EntityCacheUtil.getResult(
						DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
						DeptWorkItemImpl.class, deptWorkItem.getPrimaryKey()) == null) {
				cacheResult(deptWorkItem);
			}
			else {
				deptWorkItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dept work items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DeptWorkItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DeptWorkItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dept work item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeptWorkItem deptWorkItem) {
		EntityCacheUtil.removeResult(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemImpl.class, deptWorkItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DeptWorkItem> deptWorkItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DeptWorkItem deptWorkItem : deptWorkItems) {
			EntityCacheUtil.removeResult(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
				DeptWorkItemImpl.class, deptWorkItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dept work item with the primary key. Does not add the dept work item to the database.
	 *
	 * @param deptWorkItemId the primary key for the new dept work item
	 * @return the new dept work item
	 */
	@Override
	public DeptWorkItem create(long deptWorkItemId) {
		DeptWorkItem deptWorkItem = new DeptWorkItemImpl();

		deptWorkItem.setNew(true);
		deptWorkItem.setPrimaryKey(deptWorkItemId);

		return deptWorkItem;
	}

	/**
	 * Removes the dept work item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deptWorkItemId the primary key of the dept work item
	 * @return the dept work item that was removed
	 * @throws com.justonetech.oa.NoSuchDeptWorkItemException if a dept work item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem remove(long deptWorkItemId)
		throws NoSuchDeptWorkItemException, SystemException {
		return remove((Serializable)deptWorkItemId);
	}

	/**
	 * Removes the dept work item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dept work item
	 * @return the dept work item that was removed
	 * @throws com.justonetech.oa.NoSuchDeptWorkItemException if a dept work item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem remove(Serializable primaryKey)
		throws NoSuchDeptWorkItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DeptWorkItem deptWorkItem = (DeptWorkItem)session.get(DeptWorkItemImpl.class,
					primaryKey);

			if (deptWorkItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeptWorkItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(deptWorkItem);
		}
		catch (NoSuchDeptWorkItemException nsee) {
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
	protected DeptWorkItem removeImpl(DeptWorkItem deptWorkItem)
		throws SystemException {
		deptWorkItem = toUnwrappedModel(deptWorkItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(deptWorkItem)) {
				deptWorkItem = (DeptWorkItem)session.get(DeptWorkItemImpl.class,
						deptWorkItem.getPrimaryKeyObj());
			}

			if (deptWorkItem != null) {
				session.delete(deptWorkItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (deptWorkItem != null) {
			clearCache(deptWorkItem);
		}

		return deptWorkItem;
	}

	@Override
	public DeptWorkItem updateImpl(
		com.justonetech.oa.model.DeptWorkItem deptWorkItem)
		throws SystemException {
		deptWorkItem = toUnwrappedModel(deptWorkItem);

		boolean isNew = deptWorkItem.isNew();

		DeptWorkItemModelImpl deptWorkItemModelImpl = (DeptWorkItemModelImpl)deptWorkItem;

		Session session = null;

		try {
			session = openSession();

			if (deptWorkItem.isNew()) {
				session.save(deptWorkItem);

				deptWorkItem.setNew(false);
			}
			else {
				session.merge(deptWorkItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DeptWorkItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((deptWorkItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPTWORKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						deptWorkItemModelImpl.getOriginalDeptWorkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPTWORKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPTWORKID,
					args);

				args = new Object[] { deptWorkItemModelImpl.getDeptWorkId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPTWORKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPTWORKID,
					args);
			}
		}

		EntityCacheUtil.putResult(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkItemImpl.class, deptWorkItem.getPrimaryKey(), deptWorkItem);

		return deptWorkItem;
	}

	protected DeptWorkItem toUnwrappedModel(DeptWorkItem deptWorkItem) {
		if (deptWorkItem instanceof DeptWorkItemImpl) {
			return deptWorkItem;
		}

		DeptWorkItemImpl deptWorkItemImpl = new DeptWorkItemImpl();

		deptWorkItemImpl.setNew(deptWorkItem.isNew());
		deptWorkItemImpl.setPrimaryKey(deptWorkItem.getPrimaryKey());

		deptWorkItemImpl.setDeptWorkItemId(deptWorkItem.getDeptWorkItemId());
		deptWorkItemImpl.setDeptWorkId(deptWorkItem.getDeptWorkId());
		deptWorkItemImpl.setSortNo(deptWorkItem.getSortNo());
		deptWorkItemImpl.setDutyPerosn(deptWorkItem.getDutyPerosn());
		deptWorkItemImpl.setMainWork(deptWorkItem.isMainWork());
		deptWorkItemImpl.setSchedule(deptWorkItem.getSchedule());
		deptWorkItemImpl.setContent(deptWorkItem.getContent());
		deptWorkItemImpl.setAgentPerson(deptWorkItem.getAgentPerson());

		return deptWorkItemImpl;
	}

	/**
	 * Returns the dept work item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dept work item
	 * @return the dept work item
	 * @throws com.justonetech.oa.NoSuchDeptWorkItemException if a dept work item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeptWorkItemException, SystemException {
		DeptWorkItem deptWorkItem = fetchByPrimaryKey(primaryKey);

		if (deptWorkItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeptWorkItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return deptWorkItem;
	}

	/**
	 * Returns the dept work item with the primary key or throws a {@link com.justonetech.oa.NoSuchDeptWorkItemException} if it could not be found.
	 *
	 * @param deptWorkItemId the primary key of the dept work item
	 * @return the dept work item
	 * @throws com.justonetech.oa.NoSuchDeptWorkItemException if a dept work item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem findByPrimaryKey(long deptWorkItemId)
		throws NoSuchDeptWorkItemException, SystemException {
		return findByPrimaryKey((Serializable)deptWorkItemId);
	}

	/**
	 * Returns the dept work item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dept work item
	 * @return the dept work item, or <code>null</code> if a dept work item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DeptWorkItem deptWorkItem = (DeptWorkItem)EntityCacheUtil.getResult(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
				DeptWorkItemImpl.class, primaryKey);

		if (deptWorkItem == _nullDeptWorkItem) {
			return null;
		}

		if (deptWorkItem == null) {
			Session session = null;

			try {
				session = openSession();

				deptWorkItem = (DeptWorkItem)session.get(DeptWorkItemImpl.class,
						primaryKey);

				if (deptWorkItem != null) {
					cacheResult(deptWorkItem);
				}
				else {
					EntityCacheUtil.putResult(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
						DeptWorkItemImpl.class, primaryKey, _nullDeptWorkItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DeptWorkItemModelImpl.ENTITY_CACHE_ENABLED,
					DeptWorkItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return deptWorkItem;
	}

	/**
	 * Returns the dept work item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deptWorkItemId the primary key of the dept work item
	 * @return the dept work item, or <code>null</code> if a dept work item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWorkItem fetchByPrimaryKey(long deptWorkItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)deptWorkItemId);
	}

	/**
	 * Returns all the dept work items.
	 *
	 * @return the dept work items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWorkItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dept work items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dept work items
	 * @param end the upper bound of the range of dept work items (not inclusive)
	 * @return the range of dept work items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWorkItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dept work items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dept work items
	 * @param end the upper bound of the range of dept work items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dept work items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWorkItem> findAll(int start, int end,
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

		List<DeptWorkItem> list = (List<DeptWorkItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPTWORKITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPTWORKITEM;

				if (pagination) {
					sql = sql.concat(DeptWorkItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DeptWorkItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeptWorkItem>(list);
				}
				else {
					list = (List<DeptWorkItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dept work items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DeptWorkItem deptWorkItem : findAll()) {
			remove(deptWorkItem);
		}
	}

	/**
	 * Returns the number of dept work items.
	 *
	 * @return the number of dept work items
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

				Query q = session.createQuery(_SQL_COUNT_DEPTWORKITEM);

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
	 * Initializes the dept work item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.DeptWorkItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DeptWorkItem>> listenersList = new ArrayList<ModelListener<DeptWorkItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DeptWorkItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DeptWorkItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEPTWORKITEM = "SELECT deptWorkItem FROM DeptWorkItem deptWorkItem";
	private static final String _SQL_SELECT_DEPTWORKITEM_WHERE = "SELECT deptWorkItem FROM DeptWorkItem deptWorkItem WHERE ";
	private static final String _SQL_COUNT_DEPTWORKITEM = "SELECT COUNT(deptWorkItem) FROM DeptWorkItem deptWorkItem";
	private static final String _SQL_COUNT_DEPTWORKITEM_WHERE = "SELECT COUNT(deptWorkItem) FROM DeptWorkItem deptWorkItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "deptWorkItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DeptWorkItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DeptWorkItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DeptWorkItemPersistenceImpl.class);
	private static DeptWorkItem _nullDeptWorkItem = new DeptWorkItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DeptWorkItem> toCacheModel() {
				return _nullDeptWorkItemCacheModel;
			}
		};

	private static CacheModel<DeptWorkItem> _nullDeptWorkItemCacheModel = new CacheModel<DeptWorkItem>() {
			@Override
			public DeptWorkItem toEntityModel() {
				return _nullDeptWorkItem;
			}
		};
}