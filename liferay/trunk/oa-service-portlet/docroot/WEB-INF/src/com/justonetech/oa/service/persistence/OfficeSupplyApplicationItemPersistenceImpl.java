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

import com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException;
import com.justonetech.oa.model.OfficeSupplyApplicationItem;
import com.justonetech.oa.model.impl.OfficeSupplyApplicationItemImpl;
import com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl;

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
 * The persistence implementation for the office supply application item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplicationItemPersistence
 * @see OfficeSupplyApplicationItemUtil
 * @generated
 */
public class OfficeSupplyApplicationItemPersistenceImpl
	extends BasePersistenceImpl<OfficeSupplyApplicationItem>
	implements OfficeSupplyApplicationItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeSupplyApplicationItemUtil} to access the office supply application item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeSupplyApplicationItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICESUPPLYAPPLICATIONID =
		new FinderPath(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOfficeSupplyApplicationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYAPPLICATIONID =
		new FinderPath(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOfficeSupplyApplicationId",
			new String[] { Long.class.getName() },
			OfficeSupplyApplicationItemModelImpl.OFFICESUPPLYAPPLICATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OFFICESUPPLYAPPLICATIONID =
		new FinderPath(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOfficeSupplyApplicationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the office supply application items where officeSupplyApplicationId = &#63;.
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @return the matching office supply application items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplicationItem> findByOfficeSupplyApplicationId(
		long officeSupplyApplicationId) throws SystemException {
		return findByOfficeSupplyApplicationId(officeSupplyApplicationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply application items where officeSupplyApplicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @param start the lower bound of the range of office supply application items
	 * @param end the upper bound of the range of office supply application items (not inclusive)
	 * @return the range of matching office supply application items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplicationItem> findByOfficeSupplyApplicationId(
		long officeSupplyApplicationId, int start, int end)
		throws SystemException {
		return findByOfficeSupplyApplicationId(officeSupplyApplicationId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply application items where officeSupplyApplicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @param start the lower bound of the range of office supply application items
	 * @param end the upper bound of the range of office supply application items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching office supply application items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplicationItem> findByOfficeSupplyApplicationId(
		long officeSupplyApplicationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYAPPLICATIONID;
			finderArgs = new Object[] { officeSupplyApplicationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICESUPPLYAPPLICATIONID;
			finderArgs = new Object[] {
					officeSupplyApplicationId,
					
					start, end, orderByComparator
				};
		}

		List<OfficeSupplyApplicationItem> list = (List<OfficeSupplyApplicationItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OfficeSupplyApplicationItem officeSupplyApplicationItem : list) {
				if ((officeSupplyApplicationId != officeSupplyApplicationItem.getOfficeSupplyApplicationId())) {
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

			query.append(_SQL_SELECT_OFFICESUPPLYAPPLICATIONITEM_WHERE);

			query.append(_FINDER_COLUMN_OFFICESUPPLYAPPLICATIONID_OFFICESUPPLYAPPLICATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficeSupplyApplicationItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeSupplyApplicationId);

				if (!pagination) {
					list = (List<OfficeSupplyApplicationItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApplicationItem>(list);
				}
				else {
					list = (List<OfficeSupplyApplicationItem>)QueryUtil.list(q,
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
	 * Returns the first office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply application item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a matching office supply application item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem findByOfficeSupplyApplicationId_First(
		long officeSupplyApplicationId, OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplicationItemException, SystemException {
		OfficeSupplyApplicationItem officeSupplyApplicationItem = fetchByOfficeSupplyApplicationId_First(officeSupplyApplicationId,
				orderByComparator);

		if (officeSupplyApplicationItem != null) {
			return officeSupplyApplicationItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeSupplyApplicationId=");
		msg.append(officeSupplyApplicationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplicationItemException(msg.toString());
	}

	/**
	 * Returns the first office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply application item, or <code>null</code> if a matching office supply application item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem fetchByOfficeSupplyApplicationId_First(
		long officeSupplyApplicationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<OfficeSupplyApplicationItem> list = findByOfficeSupplyApplicationId(officeSupplyApplicationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply application item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a matching office supply application item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem findByOfficeSupplyApplicationId_Last(
		long officeSupplyApplicationId, OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplicationItemException, SystemException {
		OfficeSupplyApplicationItem officeSupplyApplicationItem = fetchByOfficeSupplyApplicationId_Last(officeSupplyApplicationId,
				orderByComparator);

		if (officeSupplyApplicationItem != null) {
			return officeSupplyApplicationItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeSupplyApplicationId=");
		msg.append(officeSupplyApplicationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplicationItemException(msg.toString());
	}

	/**
	 * Returns the last office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply application item, or <code>null</code> if a matching office supply application item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem fetchByOfficeSupplyApplicationId_Last(
		long officeSupplyApplicationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOfficeSupplyApplicationId(officeSupplyApplicationId);

		if (count == 0) {
			return null;
		}

		List<OfficeSupplyApplicationItem> list = findByOfficeSupplyApplicationId(officeSupplyApplicationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the office supply application items before and after the current office supply application item in the ordered set where officeSupplyApplicationId = &#63;.
	 *
	 * @param officeSupplyApplicationItemId the primary key of the current office supply application item
	 * @param officeSupplyApplicationId the office supply application ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office supply application item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem[] findByOfficeSupplyApplicationId_PrevAndNext(
		long officeSupplyApplicationItemId, long officeSupplyApplicationId,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplicationItemException, SystemException {
		OfficeSupplyApplicationItem officeSupplyApplicationItem = findByPrimaryKey(officeSupplyApplicationItemId);

		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApplicationItem[] array = new OfficeSupplyApplicationItemImpl[3];

			array[0] = getByOfficeSupplyApplicationId_PrevAndNext(session,
					officeSupplyApplicationItem, officeSupplyApplicationId,
					orderByComparator, true);

			array[1] = officeSupplyApplicationItem;

			array[2] = getByOfficeSupplyApplicationId_PrevAndNext(session,
					officeSupplyApplicationItem, officeSupplyApplicationId,
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

	protected OfficeSupplyApplicationItem getByOfficeSupplyApplicationId_PrevAndNext(
		Session session,
		OfficeSupplyApplicationItem officeSupplyApplicationItem,
		long officeSupplyApplicationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OFFICESUPPLYAPPLICATIONITEM_WHERE);

		query.append(_FINDER_COLUMN_OFFICESUPPLYAPPLICATIONID_OFFICESUPPLYAPPLICATIONID_2);

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
			query.append(OfficeSupplyApplicationItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(officeSupplyApplicationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(officeSupplyApplicationItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OfficeSupplyApplicationItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the office supply application items where officeSupplyApplicationId = &#63; from the database.
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOfficeSupplyApplicationId(
		long officeSupplyApplicationId) throws SystemException {
		for (OfficeSupplyApplicationItem officeSupplyApplicationItem : findByOfficeSupplyApplicationId(
				officeSupplyApplicationId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(officeSupplyApplicationItem);
		}
	}

	/**
	 * Returns the number of office supply application items where officeSupplyApplicationId = &#63;.
	 *
	 * @param officeSupplyApplicationId the office supply application ID
	 * @return the number of matching office supply application items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOfficeSupplyApplicationId(long officeSupplyApplicationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OFFICESUPPLYAPPLICATIONID;

		Object[] finderArgs = new Object[] { officeSupplyApplicationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICESUPPLYAPPLICATIONITEM_WHERE);

			query.append(_FINDER_COLUMN_OFFICESUPPLYAPPLICATIONID_OFFICESUPPLYAPPLICATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeSupplyApplicationId);

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

	private static final String _FINDER_COLUMN_OFFICESUPPLYAPPLICATIONID_OFFICESUPPLYAPPLICATIONID_2 =
		"officeSupplyApplicationItem.officeSupplyApplicationId = ?";

	public OfficeSupplyApplicationItemPersistenceImpl() {
		setModelClass(OfficeSupplyApplicationItem.class);
	}

	/**
	 * Caches the office supply application item in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApplicationItem the office supply application item
	 */
	@Override
	public void cacheResult(
		OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		EntityCacheUtil.putResult(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemImpl.class,
			officeSupplyApplicationItem.getPrimaryKey(),
			officeSupplyApplicationItem);

		officeSupplyApplicationItem.resetOriginalValues();
	}

	/**
	 * Caches the office supply application items in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApplicationItems the office supply application items
	 */
	@Override
	public void cacheResult(
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems) {
		for (OfficeSupplyApplicationItem officeSupplyApplicationItem : officeSupplyApplicationItems) {
			if (EntityCacheUtil.getResult(
						OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplicationItemImpl.class,
						officeSupplyApplicationItem.getPrimaryKey()) == null) {
				cacheResult(officeSupplyApplicationItem);
			}
			else {
				officeSupplyApplicationItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all office supply application items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeSupplyApplicationItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeSupplyApplicationItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office supply application item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		EntityCacheUtil.removeResult(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemImpl.class,
			officeSupplyApplicationItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OfficeSupplyApplicationItem officeSupplyApplicationItem : officeSupplyApplicationItems) {
			EntityCacheUtil.removeResult(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplicationItemImpl.class,
				officeSupplyApplicationItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new office supply application item with the primary key. Does not add the office supply application item to the database.
	 *
	 * @param officeSupplyApplicationItemId the primary key for the new office supply application item
	 * @return the new office supply application item
	 */
	@Override
	public OfficeSupplyApplicationItem create(
		long officeSupplyApplicationItemId) {
		OfficeSupplyApplicationItem officeSupplyApplicationItem = new OfficeSupplyApplicationItemImpl();

		officeSupplyApplicationItem.setNew(true);
		officeSupplyApplicationItem.setPrimaryKey(officeSupplyApplicationItemId);

		return officeSupplyApplicationItem;
	}

	/**
	 * Removes the office supply application item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyApplicationItemId the primary key of the office supply application item
	 * @return the office supply application item that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem remove(
		long officeSupplyApplicationItemId)
		throws NoSuchOfficeSupplyApplicationItemException, SystemException {
		return remove((Serializable)officeSupplyApplicationItemId);
	}

	/**
	 * Removes the office supply application item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office supply application item
	 * @return the office supply application item that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem remove(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplicationItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApplicationItem officeSupplyApplicationItem = (OfficeSupplyApplicationItem)session.get(OfficeSupplyApplicationItemImpl.class,
					primaryKey);

			if (officeSupplyApplicationItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeSupplyApplicationItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(officeSupplyApplicationItem);
		}
		catch (NoSuchOfficeSupplyApplicationItemException nsee) {
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
	protected OfficeSupplyApplicationItem removeImpl(
		OfficeSupplyApplicationItem officeSupplyApplicationItem)
		throws SystemException {
		officeSupplyApplicationItem = toUnwrappedModel(officeSupplyApplicationItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(officeSupplyApplicationItem)) {
				officeSupplyApplicationItem = (OfficeSupplyApplicationItem)session.get(OfficeSupplyApplicationItemImpl.class,
						officeSupplyApplicationItem.getPrimaryKeyObj());
			}

			if (officeSupplyApplicationItem != null) {
				session.delete(officeSupplyApplicationItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (officeSupplyApplicationItem != null) {
			clearCache(officeSupplyApplicationItem);
		}

		return officeSupplyApplicationItem;
	}

	@Override
	public OfficeSupplyApplicationItem updateImpl(
		com.justonetech.oa.model.OfficeSupplyApplicationItem officeSupplyApplicationItem)
		throws SystemException {
		officeSupplyApplicationItem = toUnwrappedModel(officeSupplyApplicationItem);

		boolean isNew = officeSupplyApplicationItem.isNew();

		OfficeSupplyApplicationItemModelImpl officeSupplyApplicationItemModelImpl =
			(OfficeSupplyApplicationItemModelImpl)officeSupplyApplicationItem;

		Session session = null;

		try {
			session = openSession();

			if (officeSupplyApplicationItem.isNew()) {
				session.save(officeSupplyApplicationItem);

				officeSupplyApplicationItem.setNew(false);
			}
			else {
				session.merge(officeSupplyApplicationItem);
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
				!OfficeSupplyApplicationItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((officeSupplyApplicationItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYAPPLICATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						officeSupplyApplicationItemModelImpl.getOriginalOfficeSupplyApplicationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OFFICESUPPLYAPPLICATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYAPPLICATIONID,
					args);

				args = new Object[] {
						officeSupplyApplicationItemModelImpl.getOfficeSupplyApplicationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OFFICESUPPLYAPPLICATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYAPPLICATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationItemImpl.class,
			officeSupplyApplicationItem.getPrimaryKey(),
			officeSupplyApplicationItem);

		return officeSupplyApplicationItem;
	}

	protected OfficeSupplyApplicationItem toUnwrappedModel(
		OfficeSupplyApplicationItem officeSupplyApplicationItem) {
		if (officeSupplyApplicationItem instanceof OfficeSupplyApplicationItemImpl) {
			return officeSupplyApplicationItem;
		}

		OfficeSupplyApplicationItemImpl officeSupplyApplicationItemImpl = new OfficeSupplyApplicationItemImpl();

		officeSupplyApplicationItemImpl.setNew(officeSupplyApplicationItem.isNew());
		officeSupplyApplicationItemImpl.setPrimaryKey(officeSupplyApplicationItem.getPrimaryKey());

		officeSupplyApplicationItemImpl.setOfficeSupplyApplicationItemId(officeSupplyApplicationItem.getOfficeSupplyApplicationItemId());
		officeSupplyApplicationItemImpl.setName(officeSupplyApplicationItem.getName());
		officeSupplyApplicationItemImpl.setModel(officeSupplyApplicationItem.getModel());
		officeSupplyApplicationItemImpl.setUnit(officeSupplyApplicationItem.getUnit());
		officeSupplyApplicationItemImpl.setUnitPrice(officeSupplyApplicationItem.getUnitPrice());
		officeSupplyApplicationItemImpl.setQuantity(officeSupplyApplicationItem.getQuantity());
		officeSupplyApplicationItemImpl.setOfficeSupplyApplicationId(officeSupplyApplicationItem.getOfficeSupplyApplicationId());
		officeSupplyApplicationItemImpl.setOfficeSupplyId(officeSupplyApplicationItem.getOfficeSupplyId());

		return officeSupplyApplicationItemImpl;
	}

	/**
	 * Returns the office supply application item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply application item
	 * @return the office supply application item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplicationItemException, SystemException {
		OfficeSupplyApplicationItem officeSupplyApplicationItem = fetchByPrimaryKey(primaryKey);

		if (officeSupplyApplicationItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeSupplyApplicationItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return officeSupplyApplicationItem;
	}

	/**
	 * Returns the office supply application item with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException} if it could not be found.
	 *
	 * @param officeSupplyApplicationItemId the primary key of the office supply application item
	 * @return the office supply application item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationItemException if a office supply application item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem findByPrimaryKey(
		long officeSupplyApplicationItemId)
		throws NoSuchOfficeSupplyApplicationItemException, SystemException {
		return findByPrimaryKey((Serializable)officeSupplyApplicationItemId);
	}

	/**
	 * Returns the office supply application item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply application item
	 * @return the office supply application item, or <code>null</code> if a office supply application item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		OfficeSupplyApplicationItem officeSupplyApplicationItem = (OfficeSupplyApplicationItem)EntityCacheUtil.getResult(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplicationItemImpl.class, primaryKey);

		if (officeSupplyApplicationItem == _nullOfficeSupplyApplicationItem) {
			return null;
		}

		if (officeSupplyApplicationItem == null) {
			Session session = null;

			try {
				session = openSession();

				officeSupplyApplicationItem = (OfficeSupplyApplicationItem)session.get(OfficeSupplyApplicationItemImpl.class,
						primaryKey);

				if (officeSupplyApplicationItem != null) {
					cacheResult(officeSupplyApplicationItem);
				}
				else {
					EntityCacheUtil.putResult(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplicationItemImpl.class, primaryKey,
						_nullOfficeSupplyApplicationItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeSupplyApplicationItemModelImpl.ENTITY_CACHE_ENABLED,
					OfficeSupplyApplicationItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return officeSupplyApplicationItem;
	}

	/**
	 * Returns the office supply application item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeSupplyApplicationItemId the primary key of the office supply application item
	 * @return the office supply application item, or <code>null</code> if a office supply application item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplicationItem fetchByPrimaryKey(
		long officeSupplyApplicationItemId) throws SystemException {
		return fetchByPrimaryKey((Serializable)officeSupplyApplicationItemId);
	}

	/**
	 * Returns all the office supply application items.
	 *
	 * @return the office supply application items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplicationItem> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply application items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply application items
	 * @param end the upper bound of the range of office supply application items (not inclusive)
	 * @return the range of office supply application items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplicationItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply application items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply application items
	 * @param end the upper bound of the range of office supply application items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of office supply application items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplicationItem> findAll(int start, int end,
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

		List<OfficeSupplyApplicationItem> list = (List<OfficeSupplyApplicationItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICESUPPLYAPPLICATIONITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICESUPPLYAPPLICATIONITEM;

				if (pagination) {
					sql = sql.concat(OfficeSupplyApplicationItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OfficeSupplyApplicationItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApplicationItem>(list);
				}
				else {
					list = (List<OfficeSupplyApplicationItem>)QueryUtil.list(q,
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
	 * Removes all the office supply application items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OfficeSupplyApplicationItem officeSupplyApplicationItem : findAll()) {
			remove(officeSupplyApplicationItem);
		}
	}

	/**
	 * Returns the number of office supply application items.
	 *
	 * @return the number of office supply application items
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

				Query q = session.createQuery(_SQL_COUNT_OFFICESUPPLYAPPLICATIONITEM);

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
	 * Initializes the office supply application item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.OfficeSupplyApplicationItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OfficeSupplyApplicationItem>> listenersList = new ArrayList<ModelListener<OfficeSupplyApplicationItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OfficeSupplyApplicationItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeSupplyApplicationItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICESUPPLYAPPLICATIONITEM = "SELECT officeSupplyApplicationItem FROM OfficeSupplyApplicationItem officeSupplyApplicationItem";
	private static final String _SQL_SELECT_OFFICESUPPLYAPPLICATIONITEM_WHERE = "SELECT officeSupplyApplicationItem FROM OfficeSupplyApplicationItem officeSupplyApplicationItem WHERE ";
	private static final String _SQL_COUNT_OFFICESUPPLYAPPLICATIONITEM = "SELECT COUNT(officeSupplyApplicationItem) FROM OfficeSupplyApplicationItem officeSupplyApplicationItem";
	private static final String _SQL_COUNT_OFFICESUPPLYAPPLICATIONITEM_WHERE = "SELECT COUNT(officeSupplyApplicationItem) FROM OfficeSupplyApplicationItem officeSupplyApplicationItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "officeSupplyApplicationItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OfficeSupplyApplicationItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OfficeSupplyApplicationItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficeSupplyApplicationItemPersistenceImpl.class);
	private static OfficeSupplyApplicationItem _nullOfficeSupplyApplicationItem = new OfficeSupplyApplicationItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OfficeSupplyApplicationItem> toCacheModel() {
				return _nullOfficeSupplyApplicationItemCacheModel;
			}
		};

	private static CacheModel<OfficeSupplyApplicationItem> _nullOfficeSupplyApplicationItemCacheModel =
		new CacheModel<OfficeSupplyApplicationItem>() {
			@Override
			public OfficeSupplyApplicationItem toEntityModel() {
				return _nullOfficeSupplyApplicationItem;
			}
		};
}