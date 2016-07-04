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

import com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException;
import com.justonetech.oa.model.OfficeSupplyRequisitionItem;
import com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemImpl;
import com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl;

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
 * The persistence implementation for the office supply requisition item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionItemPersistence
 * @see OfficeSupplyRequisitionItemUtil
 * @generated
 */
public class OfficeSupplyRequisitionItemPersistenceImpl
	extends BasePersistenceImpl<OfficeSupplyRequisitionItem>
	implements OfficeSupplyRequisitionItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeSupplyRequisitionItemUtil} to access the office supply requisition item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeSupplyRequisitionItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyRequisitionItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyRequisitionItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICESUPPLYREQUISITIONID =
		new FinderPath(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyRequisitionItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOfficeSupplyRequisitionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYREQUISITIONID =
		new FinderPath(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyRequisitionItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOfficeSupplyRequisitionId",
			new String[] { Long.class.getName() },
			OfficeSupplyRequisitionItemModelImpl.OFFICESUPPLYREQUISITIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OFFICESUPPLYREQUISITIONID =
		new FinderPath(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOfficeSupplyRequisitionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the office supply requisition items where officeSupplyRequisitionId = &#63;.
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @return the matching office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId) throws SystemException {
		return findByOfficeSupplyRequisitionId(officeSupplyRequisitionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply requisition items where officeSupplyRequisitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @param start the lower bound of the range of office supply requisition items
	 * @param end the upper bound of the range of office supply requisition items (not inclusive)
	 * @return the range of matching office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId, int start, int end)
		throws SystemException {
		return findByOfficeSupplyRequisitionId(officeSupplyRequisitionId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply requisition items where officeSupplyRequisitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @param start the lower bound of the range of office supply requisition items
	 * @param end the upper bound of the range of office supply requisition items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisitionItem> findByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYREQUISITIONID;
			finderArgs = new Object[] { officeSupplyRequisitionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OFFICESUPPLYREQUISITIONID;
			finderArgs = new Object[] {
					officeSupplyRequisitionId,
					
					start, end, orderByComparator
				};
		}

		List<OfficeSupplyRequisitionItem> list = (List<OfficeSupplyRequisitionItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OfficeSupplyRequisitionItem officeSupplyRequisitionItem : list) {
				if ((officeSupplyRequisitionId != officeSupplyRequisitionItem.getOfficeSupplyRequisitionId())) {
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

			query.append(_SQL_SELECT_OFFICESUPPLYREQUISITIONITEM_WHERE);

			query.append(_FINDER_COLUMN_OFFICESUPPLYREQUISITIONID_OFFICESUPPLYREQUISITIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficeSupplyRequisitionItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeSupplyRequisitionId);

				if (!pagination) {
					list = (List<OfficeSupplyRequisitionItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyRequisitionItem>(list);
				}
				else {
					list = (List<OfficeSupplyRequisitionItem>)QueryUtil.list(q,
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
	 * Returns the first office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply requisition item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a matching office supply requisition item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem findByOfficeSupplyRequisitionId_First(
		long officeSupplyRequisitionId, OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyRequisitionItemException, SystemException {
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem = fetchByOfficeSupplyRequisitionId_First(officeSupplyRequisitionId,
				orderByComparator);

		if (officeSupplyRequisitionItem != null) {
			return officeSupplyRequisitionItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeSupplyRequisitionId=");
		msg.append(officeSupplyRequisitionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyRequisitionItemException(msg.toString());
	}

	/**
	 * Returns the first office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply requisition item, or <code>null</code> if a matching office supply requisition item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem fetchByOfficeSupplyRequisitionId_First(
		long officeSupplyRequisitionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<OfficeSupplyRequisitionItem> list = findByOfficeSupplyRequisitionId(officeSupplyRequisitionId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply requisition item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a matching office supply requisition item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem findByOfficeSupplyRequisitionId_Last(
		long officeSupplyRequisitionId, OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyRequisitionItemException, SystemException {
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem = fetchByOfficeSupplyRequisitionId_Last(officeSupplyRequisitionId,
				orderByComparator);

		if (officeSupplyRequisitionItem != null) {
			return officeSupplyRequisitionItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("officeSupplyRequisitionId=");
		msg.append(officeSupplyRequisitionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyRequisitionItemException(msg.toString());
	}

	/**
	 * Returns the last office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply requisition item, or <code>null</code> if a matching office supply requisition item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem fetchByOfficeSupplyRequisitionId_Last(
		long officeSupplyRequisitionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOfficeSupplyRequisitionId(officeSupplyRequisitionId);

		if (count == 0) {
			return null;
		}

		List<OfficeSupplyRequisitionItem> list = findByOfficeSupplyRequisitionId(officeSupplyRequisitionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the office supply requisition items before and after the current office supply requisition item in the ordered set where officeSupplyRequisitionId = &#63;.
	 *
	 * @param officeSupplyRequisitionItemId the primary key of the current office supply requisition item
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office supply requisition item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem[] findByOfficeSupplyRequisitionId_PrevAndNext(
		long officeSupplyRequisitionItemId, long officeSupplyRequisitionId,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyRequisitionItemException, SystemException {
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem = findByPrimaryKey(officeSupplyRequisitionItemId);

		Session session = null;

		try {
			session = openSession();

			OfficeSupplyRequisitionItem[] array = new OfficeSupplyRequisitionItemImpl[3];

			array[0] = getByOfficeSupplyRequisitionId_PrevAndNext(session,
					officeSupplyRequisitionItem, officeSupplyRequisitionId,
					orderByComparator, true);

			array[1] = officeSupplyRequisitionItem;

			array[2] = getByOfficeSupplyRequisitionId_PrevAndNext(session,
					officeSupplyRequisitionItem, officeSupplyRequisitionId,
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

	protected OfficeSupplyRequisitionItem getByOfficeSupplyRequisitionId_PrevAndNext(
		Session session,
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem,
		long officeSupplyRequisitionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OFFICESUPPLYREQUISITIONITEM_WHERE);

		query.append(_FINDER_COLUMN_OFFICESUPPLYREQUISITIONID_OFFICESUPPLYREQUISITIONID_2);

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
			query.append(OfficeSupplyRequisitionItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(officeSupplyRequisitionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(officeSupplyRequisitionItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OfficeSupplyRequisitionItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the office supply requisition items where officeSupplyRequisitionId = &#63; from the database.
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOfficeSupplyRequisitionId(
		long officeSupplyRequisitionId) throws SystemException {
		for (OfficeSupplyRequisitionItem officeSupplyRequisitionItem : findByOfficeSupplyRequisitionId(
				officeSupplyRequisitionId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(officeSupplyRequisitionItem);
		}
	}

	/**
	 * Returns the number of office supply requisition items where officeSupplyRequisitionId = &#63;.
	 *
	 * @param officeSupplyRequisitionId the office supply requisition ID
	 * @return the number of matching office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOfficeSupplyRequisitionId(long officeSupplyRequisitionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OFFICESUPPLYREQUISITIONID;

		Object[] finderArgs = new Object[] { officeSupplyRequisitionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICESUPPLYREQUISITIONITEM_WHERE);

			query.append(_FINDER_COLUMN_OFFICESUPPLYREQUISITIONID_OFFICESUPPLYREQUISITIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(officeSupplyRequisitionId);

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

	private static final String _FINDER_COLUMN_OFFICESUPPLYREQUISITIONID_OFFICESUPPLYREQUISITIONID_2 =
		"officeSupplyRequisitionItem.officeSupplyRequisitionId = ?";

	public OfficeSupplyRequisitionItemPersistenceImpl() {
		setModelClass(OfficeSupplyRequisitionItem.class);
	}

	/**
	 * Caches the office supply requisition item in the entity cache if it is enabled.
	 *
	 * @param officeSupplyRequisitionItem the office supply requisition item
	 */
	@Override
	public void cacheResult(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		EntityCacheUtil.putResult(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemImpl.class,
			officeSupplyRequisitionItem.getPrimaryKey(),
			officeSupplyRequisitionItem);

		officeSupplyRequisitionItem.resetOriginalValues();
	}

	/**
	 * Caches the office supply requisition items in the entity cache if it is enabled.
	 *
	 * @param officeSupplyRequisitionItems the office supply requisition items
	 */
	@Override
	public void cacheResult(
		List<OfficeSupplyRequisitionItem> officeSupplyRequisitionItems) {
		for (OfficeSupplyRequisitionItem officeSupplyRequisitionItem : officeSupplyRequisitionItems) {
			if (EntityCacheUtil.getResult(
						OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyRequisitionItemImpl.class,
						officeSupplyRequisitionItem.getPrimaryKey()) == null) {
				cacheResult(officeSupplyRequisitionItem);
			}
			else {
				officeSupplyRequisitionItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all office supply requisition items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeSupplyRequisitionItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeSupplyRequisitionItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office supply requisition item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		EntityCacheUtil.removeResult(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemImpl.class,
			officeSupplyRequisitionItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<OfficeSupplyRequisitionItem> officeSupplyRequisitionItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OfficeSupplyRequisitionItem officeSupplyRequisitionItem : officeSupplyRequisitionItems) {
			EntityCacheUtil.removeResult(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyRequisitionItemImpl.class,
				officeSupplyRequisitionItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new office supply requisition item with the primary key. Does not add the office supply requisition item to the database.
	 *
	 * @param officeSupplyRequisitionItemId the primary key for the new office supply requisition item
	 * @return the new office supply requisition item
	 */
	@Override
	public OfficeSupplyRequisitionItem create(
		long officeSupplyRequisitionItemId) {
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem = new OfficeSupplyRequisitionItemImpl();

		officeSupplyRequisitionItem.setNew(true);
		officeSupplyRequisitionItem.setPrimaryKey(officeSupplyRequisitionItemId);

		return officeSupplyRequisitionItem;
	}

	/**
	 * Removes the office supply requisition item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	 * @return the office supply requisition item that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem remove(
		long officeSupplyRequisitionItemId)
		throws NoSuchOfficeSupplyRequisitionItemException, SystemException {
		return remove((Serializable)officeSupplyRequisitionItemId);
	}

	/**
	 * Removes the office supply requisition item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office supply requisition item
	 * @return the office supply requisition item that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem remove(Serializable primaryKey)
		throws NoSuchOfficeSupplyRequisitionItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OfficeSupplyRequisitionItem officeSupplyRequisitionItem = (OfficeSupplyRequisitionItem)session.get(OfficeSupplyRequisitionItemImpl.class,
					primaryKey);

			if (officeSupplyRequisitionItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeSupplyRequisitionItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(officeSupplyRequisitionItem);
		}
		catch (NoSuchOfficeSupplyRequisitionItemException nsee) {
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
	protected OfficeSupplyRequisitionItem removeImpl(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws SystemException {
		officeSupplyRequisitionItem = toUnwrappedModel(officeSupplyRequisitionItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(officeSupplyRequisitionItem)) {
				officeSupplyRequisitionItem = (OfficeSupplyRequisitionItem)session.get(OfficeSupplyRequisitionItemImpl.class,
						officeSupplyRequisitionItem.getPrimaryKeyObj());
			}

			if (officeSupplyRequisitionItem != null) {
				session.delete(officeSupplyRequisitionItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (officeSupplyRequisitionItem != null) {
			clearCache(officeSupplyRequisitionItem);
		}

		return officeSupplyRequisitionItem;
	}

	@Override
	public OfficeSupplyRequisitionItem updateImpl(
		com.justonetech.oa.model.OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws SystemException {
		officeSupplyRequisitionItem = toUnwrappedModel(officeSupplyRequisitionItem);

		boolean isNew = officeSupplyRequisitionItem.isNew();

		OfficeSupplyRequisitionItemModelImpl officeSupplyRequisitionItemModelImpl =
			(OfficeSupplyRequisitionItemModelImpl)officeSupplyRequisitionItem;

		Session session = null;

		try {
			session = openSession();

			if (officeSupplyRequisitionItem.isNew()) {
				session.save(officeSupplyRequisitionItem);

				officeSupplyRequisitionItem.setNew(false);
			}
			else {
				session.merge(officeSupplyRequisitionItem);
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
				!OfficeSupplyRequisitionItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((officeSupplyRequisitionItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYREQUISITIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						officeSupplyRequisitionItemModelImpl.getOriginalOfficeSupplyRequisitionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OFFICESUPPLYREQUISITIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYREQUISITIONID,
					args);

				args = new Object[] {
						officeSupplyRequisitionItemModelImpl.getOfficeSupplyRequisitionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OFFICESUPPLYREQUISITIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OFFICESUPPLYREQUISITIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionItemImpl.class,
			officeSupplyRequisitionItem.getPrimaryKey(),
			officeSupplyRequisitionItem);

		return officeSupplyRequisitionItem;
	}

	protected OfficeSupplyRequisitionItem toUnwrappedModel(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem) {
		if (officeSupplyRequisitionItem instanceof OfficeSupplyRequisitionItemImpl) {
			return officeSupplyRequisitionItem;
		}

		OfficeSupplyRequisitionItemImpl officeSupplyRequisitionItemImpl = new OfficeSupplyRequisitionItemImpl();

		officeSupplyRequisitionItemImpl.setNew(officeSupplyRequisitionItem.isNew());
		officeSupplyRequisitionItemImpl.setPrimaryKey(officeSupplyRequisitionItem.getPrimaryKey());

		officeSupplyRequisitionItemImpl.setOfficeSupplyRequisitionItemId(officeSupplyRequisitionItem.getOfficeSupplyRequisitionItemId());
		officeSupplyRequisitionItemImpl.setName(officeSupplyRequisitionItem.getName());
		officeSupplyRequisitionItemImpl.setModel(officeSupplyRequisitionItem.getModel());
		officeSupplyRequisitionItemImpl.setUnit(officeSupplyRequisitionItem.getUnit());
		officeSupplyRequisitionItemImpl.setUnitPrice(officeSupplyRequisitionItem.getUnitPrice());
		officeSupplyRequisitionItemImpl.setQuantity(officeSupplyRequisitionItem.getQuantity());
		officeSupplyRequisitionItemImpl.setOfficeSupplyRequisitionId(officeSupplyRequisitionItem.getOfficeSupplyRequisitionId());
		officeSupplyRequisitionItemImpl.setOfficeSupplyId(officeSupplyRequisitionItem.getOfficeSupplyId());

		return officeSupplyRequisitionItemImpl;
	}

	/**
	 * Returns the office supply requisition item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply requisition item
	 * @return the office supply requisition item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeSupplyRequisitionItemException, SystemException {
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem = fetchByPrimaryKey(primaryKey);

		if (officeSupplyRequisitionItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeSupplyRequisitionItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return officeSupplyRequisitionItem;
	}

	/**
	 * Returns the office supply requisition item with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException} if it could not be found.
	 *
	 * @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	 * @return the office supply requisition item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionItemException if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem findByPrimaryKey(
		long officeSupplyRequisitionItemId)
		throws NoSuchOfficeSupplyRequisitionItemException, SystemException {
		return findByPrimaryKey((Serializable)officeSupplyRequisitionItemId);
	}

	/**
	 * Returns the office supply requisition item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply requisition item
	 * @return the office supply requisition item, or <code>null</code> if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem = (OfficeSupplyRequisitionItem)EntityCacheUtil.getResult(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyRequisitionItemImpl.class, primaryKey);

		if (officeSupplyRequisitionItem == _nullOfficeSupplyRequisitionItem) {
			return null;
		}

		if (officeSupplyRequisitionItem == null) {
			Session session = null;

			try {
				session = openSession();

				officeSupplyRequisitionItem = (OfficeSupplyRequisitionItem)session.get(OfficeSupplyRequisitionItemImpl.class,
						primaryKey);

				if (officeSupplyRequisitionItem != null) {
					cacheResult(officeSupplyRequisitionItem);
				}
				else {
					EntityCacheUtil.putResult(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyRequisitionItemImpl.class, primaryKey,
						_nullOfficeSupplyRequisitionItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeSupplyRequisitionItemModelImpl.ENTITY_CACHE_ENABLED,
					OfficeSupplyRequisitionItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return officeSupplyRequisitionItem;
	}

	/**
	 * Returns the office supply requisition item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	 * @return the office supply requisition item, or <code>null</code> if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem fetchByPrimaryKey(
		long officeSupplyRequisitionItemId) throws SystemException {
		return fetchByPrimaryKey((Serializable)officeSupplyRequisitionItemId);
	}

	/**
	 * Returns all the office supply requisition items.
	 *
	 * @return the office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisitionItem> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply requisition items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply requisition items
	 * @param end the upper bound of the range of office supply requisition items (not inclusive)
	 * @return the range of office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisitionItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply requisition items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply requisition items
	 * @param end the upper bound of the range of office supply requisition items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisitionItem> findAll(int start, int end,
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

		List<OfficeSupplyRequisitionItem> list = (List<OfficeSupplyRequisitionItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICESUPPLYREQUISITIONITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICESUPPLYREQUISITIONITEM;

				if (pagination) {
					sql = sql.concat(OfficeSupplyRequisitionItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OfficeSupplyRequisitionItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyRequisitionItem>(list);
				}
				else {
					list = (List<OfficeSupplyRequisitionItem>)QueryUtil.list(q,
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
	 * Removes all the office supply requisition items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OfficeSupplyRequisitionItem officeSupplyRequisitionItem : findAll()) {
			remove(officeSupplyRequisitionItem);
		}
	}

	/**
	 * Returns the number of office supply requisition items.
	 *
	 * @return the number of office supply requisition items
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

				Query q = session.createQuery(_SQL_COUNT_OFFICESUPPLYREQUISITIONITEM);

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
	 * Initializes the office supply requisition item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.OfficeSupplyRequisitionItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OfficeSupplyRequisitionItem>> listenersList = new ArrayList<ModelListener<OfficeSupplyRequisitionItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OfficeSupplyRequisitionItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeSupplyRequisitionItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICESUPPLYREQUISITIONITEM = "SELECT officeSupplyRequisitionItem FROM OfficeSupplyRequisitionItem officeSupplyRequisitionItem";
	private static final String _SQL_SELECT_OFFICESUPPLYREQUISITIONITEM_WHERE = "SELECT officeSupplyRequisitionItem FROM OfficeSupplyRequisitionItem officeSupplyRequisitionItem WHERE ";
	private static final String _SQL_COUNT_OFFICESUPPLYREQUISITIONITEM = "SELECT COUNT(officeSupplyRequisitionItem) FROM OfficeSupplyRequisitionItem officeSupplyRequisitionItem";
	private static final String _SQL_COUNT_OFFICESUPPLYREQUISITIONITEM_WHERE = "SELECT COUNT(officeSupplyRequisitionItem) FROM OfficeSupplyRequisitionItem officeSupplyRequisitionItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "officeSupplyRequisitionItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OfficeSupplyRequisitionItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OfficeSupplyRequisitionItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficeSupplyRequisitionItemPersistenceImpl.class);
	private static OfficeSupplyRequisitionItem _nullOfficeSupplyRequisitionItem = new OfficeSupplyRequisitionItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OfficeSupplyRequisitionItem> toCacheModel() {
				return _nullOfficeSupplyRequisitionItemCacheModel;
			}
		};

	private static CacheModel<OfficeSupplyRequisitionItem> _nullOfficeSupplyRequisitionItemCacheModel =
		new CacheModel<OfficeSupplyRequisitionItem>() {
			@Override
			public OfficeSupplyRequisitionItem toEntityModel() {
				return _nullOfficeSupplyRequisitionItem;
			}
		};
}