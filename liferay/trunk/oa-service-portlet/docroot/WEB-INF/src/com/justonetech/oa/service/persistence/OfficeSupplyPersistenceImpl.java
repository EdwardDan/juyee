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

import com.justonetech.oa.NoSuchOfficeSupplyException;
import com.justonetech.oa.model.OfficeSupply;
import com.justonetech.oa.model.impl.OfficeSupplyImpl;
import com.justonetech.oa.model.impl.OfficeSupplyModelImpl;

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
import com.liferay.portal.kernel.util.CharPool;
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
 * The persistence implementation for the office supply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyPersistence
 * @see OfficeSupplyUtil
 * @generated
 */
public class OfficeSupplyPersistenceImpl extends BasePersistenceImpl<OfficeSupply>
	implements OfficeSupplyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeSupplyUtil} to access the office supply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeSupplyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyModelImpl.FINDER_CACHE_ENABLED, OfficeSupplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyModelImpl.FINDER_CACHE_ENABLED, OfficeSupplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyModelImpl.FINDER_CACHE_ENABLED, OfficeSupplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME = new FinderPath(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the office supplies where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching office supplies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupply> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supplies where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of office supplies
	 * @param end the upper bound of the range of office supplies (not inclusive)
	 * @return the range of matching office supplies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupply> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supplies where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of office supplies
	 * @param end the upper bound of the range of office supplies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching office supplies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupply> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
		finderArgs = new Object[] { name, start, end, orderByComparator };

		List<OfficeSupply> list = (List<OfficeSupply>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OfficeSupply officeSupply : list) {
				if (!StringUtil.wildcardMatches(officeSupply.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_OFFICESUPPLY_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficeSupplyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<OfficeSupply>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupply>(list);
				}
				else {
					list = (List<OfficeSupply>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first office supply in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyException if a matching office supply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyException, SystemException {
		OfficeSupply officeSupply = fetchByName_First(name, orderByComparator);

		if (officeSupply != null) {
			return officeSupply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyException(msg.toString());
	}

	/**
	 * Returns the first office supply in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply, or <code>null</code> if a matching office supply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<OfficeSupply> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last office supply in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyException if a matching office supply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyException, SystemException {
		OfficeSupply officeSupply = fetchByName_Last(name, orderByComparator);

		if (officeSupply != null) {
			return officeSupply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyException(msg.toString());
	}

	/**
	 * Returns the last office supply in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply, or <code>null</code> if a matching office supply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<OfficeSupply> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the office supplies before and after the current office supply in the ordered set where name LIKE &#63;.
	 *
	 * @param officeSupplyId the primary key of the current office supply
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office supply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply[] findByName_PrevAndNext(long officeSupplyId,
		String name, OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyException, SystemException {
		OfficeSupply officeSupply = findByPrimaryKey(officeSupplyId);

		Session session = null;

		try {
			session = openSession();

			OfficeSupply[] array = new OfficeSupplyImpl[3];

			array[0] = getByName_PrevAndNext(session, officeSupply, name,
					orderByComparator, true);

			array[1] = officeSupply;

			array[2] = getByName_PrevAndNext(session, officeSupply, name,
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

	protected OfficeSupply getByName_PrevAndNext(Session session,
		OfficeSupply officeSupply, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OFFICESUPPLY_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
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
			query.append(OfficeSupplyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(officeSupply);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OfficeSupply> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the office supplies where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (OfficeSupply officeSupply : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(officeSupply);
		}
	}

	/**
	 * Returns the number of office supplies where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching office supplies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICESUPPLY_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "officeSupply.name LIKE NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "officeSupply.name LIKE ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(officeSupply.name IS NULL OR officeSupply.name LIKE '')";

	public OfficeSupplyPersistenceImpl() {
		setModelClass(OfficeSupply.class);
	}

	/**
	 * Caches the office supply in the entity cache if it is enabled.
	 *
	 * @param officeSupply the office supply
	 */
	@Override
	public void cacheResult(OfficeSupply officeSupply) {
		EntityCacheUtil.putResult(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyImpl.class, officeSupply.getPrimaryKey(), officeSupply);

		officeSupply.resetOriginalValues();
	}

	/**
	 * Caches the office supplies in the entity cache if it is enabled.
	 *
	 * @param officeSupplies the office supplies
	 */
	@Override
	public void cacheResult(List<OfficeSupply> officeSupplies) {
		for (OfficeSupply officeSupply : officeSupplies) {
			if (EntityCacheUtil.getResult(
						OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyImpl.class, officeSupply.getPrimaryKey()) == null) {
				cacheResult(officeSupply);
			}
			else {
				officeSupply.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all office supplies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeSupplyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeSupplyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office supply.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OfficeSupply officeSupply) {
		EntityCacheUtil.removeResult(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyImpl.class, officeSupply.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OfficeSupply> officeSupplies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OfficeSupply officeSupply : officeSupplies) {
			EntityCacheUtil.removeResult(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyImpl.class, officeSupply.getPrimaryKey());
		}
	}

	/**
	 * Creates a new office supply with the primary key. Does not add the office supply to the database.
	 *
	 * @param officeSupplyId the primary key for the new office supply
	 * @return the new office supply
	 */
	@Override
	public OfficeSupply create(long officeSupplyId) {
		OfficeSupply officeSupply = new OfficeSupplyImpl();

		officeSupply.setNew(true);
		officeSupply.setPrimaryKey(officeSupplyId);

		return officeSupply;
	}

	/**
	 * Removes the office supply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyId the primary key of the office supply
	 * @return the office supply that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply remove(long officeSupplyId)
		throws NoSuchOfficeSupplyException, SystemException {
		return remove((Serializable)officeSupplyId);
	}

	/**
	 * Removes the office supply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office supply
	 * @return the office supply that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply remove(Serializable primaryKey)
		throws NoSuchOfficeSupplyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OfficeSupply officeSupply = (OfficeSupply)session.get(OfficeSupplyImpl.class,
					primaryKey);

			if (officeSupply == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeSupplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(officeSupply);
		}
		catch (NoSuchOfficeSupplyException nsee) {
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
	protected OfficeSupply removeImpl(OfficeSupply officeSupply)
		throws SystemException {
		officeSupply = toUnwrappedModel(officeSupply);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(officeSupply)) {
				officeSupply = (OfficeSupply)session.get(OfficeSupplyImpl.class,
						officeSupply.getPrimaryKeyObj());
			}

			if (officeSupply != null) {
				session.delete(officeSupply);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (officeSupply != null) {
			clearCache(officeSupply);
		}

		return officeSupply;
	}

	@Override
	public OfficeSupply updateImpl(
		com.justonetech.oa.model.OfficeSupply officeSupply)
		throws SystemException {
		officeSupply = toUnwrappedModel(officeSupply);

		boolean isNew = officeSupply.isNew();

		Session session = null;

		try {
			session = openSession();

			if (officeSupply.isNew()) {
				session.save(officeSupply);

				officeSupply.setNew(false);
			}
			else {
				session.merge(officeSupply);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OfficeSupplyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyImpl.class, officeSupply.getPrimaryKey(), officeSupply);

		return officeSupply;
	}

	protected OfficeSupply toUnwrappedModel(OfficeSupply officeSupply) {
		if (officeSupply instanceof OfficeSupplyImpl) {
			return officeSupply;
		}

		OfficeSupplyImpl officeSupplyImpl = new OfficeSupplyImpl();

		officeSupplyImpl.setNew(officeSupply.isNew());
		officeSupplyImpl.setPrimaryKey(officeSupply.getPrimaryKey());

		officeSupplyImpl.setOfficeSupplyId(officeSupply.getOfficeSupplyId());
		officeSupplyImpl.setGroupId(officeSupply.getGroupId());
		officeSupplyImpl.setCompanyId(officeSupply.getCompanyId());
		officeSupplyImpl.setUserId(officeSupply.getUserId());
		officeSupplyImpl.setUserName(officeSupply.getUserName());
		officeSupplyImpl.setCreateTime(officeSupply.getCreateTime());
		officeSupplyImpl.setModifiedTime(officeSupply.getModifiedTime());
		officeSupplyImpl.setName(officeSupply.getName());
		officeSupplyImpl.setModel(officeSupply.getModel());
		officeSupplyImpl.setUnit(officeSupply.getUnit());
		officeSupplyImpl.setUnitPrice(officeSupply.getUnitPrice());
		officeSupplyImpl.setQuantity(officeSupply.getQuantity());

		return officeSupplyImpl;
	}

	/**
	 * Returns the office supply with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply
	 * @return the office supply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeSupplyException, SystemException {
		OfficeSupply officeSupply = fetchByPrimaryKey(primaryKey);

		if (officeSupply == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeSupplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return officeSupply;
	}

	/**
	 * Returns the office supply with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyException} if it could not be found.
	 *
	 * @param officeSupplyId the primary key of the office supply
	 * @return the office supply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyException if a office supply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply findByPrimaryKey(long officeSupplyId)
		throws NoSuchOfficeSupplyException, SystemException {
		return findByPrimaryKey((Serializable)officeSupplyId);
	}

	/**
	 * Returns the office supply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply
	 * @return the office supply, or <code>null</code> if a office supply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OfficeSupply officeSupply = (OfficeSupply)EntityCacheUtil.getResult(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyImpl.class, primaryKey);

		if (officeSupply == _nullOfficeSupply) {
			return null;
		}

		if (officeSupply == null) {
			Session session = null;

			try {
				session = openSession();

				officeSupply = (OfficeSupply)session.get(OfficeSupplyImpl.class,
						primaryKey);

				if (officeSupply != null) {
					cacheResult(officeSupply);
				}
				else {
					EntityCacheUtil.putResult(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyImpl.class, primaryKey, _nullOfficeSupply);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeSupplyModelImpl.ENTITY_CACHE_ENABLED,
					OfficeSupplyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return officeSupply;
	}

	/**
	 * Returns the office supply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeSupplyId the primary key of the office supply
	 * @return the office supply, or <code>null</code> if a office supply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupply fetchByPrimaryKey(long officeSupplyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)officeSupplyId);
	}

	/**
	 * Returns all the office supplies.
	 *
	 * @return the office supplies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupply> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supplies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supplies
	 * @param end the upper bound of the range of office supplies (not inclusive)
	 * @return the range of office supplies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupply> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supplies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supplies
	 * @param end the upper bound of the range of office supplies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of office supplies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupply> findAll(int start, int end,
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

		List<OfficeSupply> list = (List<OfficeSupply>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICESUPPLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICESUPPLY;

				if (pagination) {
					sql = sql.concat(OfficeSupplyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OfficeSupply>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupply>(list);
				}
				else {
					list = (List<OfficeSupply>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the office supplies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OfficeSupply officeSupply : findAll()) {
			remove(officeSupply);
		}
	}

	/**
	 * Returns the number of office supplies.
	 *
	 * @return the number of office supplies
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

				Query q = session.createQuery(_SQL_COUNT_OFFICESUPPLY);

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
	 * Initializes the office supply persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.OfficeSupply")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OfficeSupply>> listenersList = new ArrayList<ModelListener<OfficeSupply>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OfficeSupply>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeSupplyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICESUPPLY = "SELECT officeSupply FROM OfficeSupply officeSupply";
	private static final String _SQL_SELECT_OFFICESUPPLY_WHERE = "SELECT officeSupply FROM OfficeSupply officeSupply WHERE ";
	private static final String _SQL_COUNT_OFFICESUPPLY = "SELECT COUNT(officeSupply) FROM OfficeSupply officeSupply";
	private static final String _SQL_COUNT_OFFICESUPPLY_WHERE = "SELECT COUNT(officeSupply) FROM OfficeSupply officeSupply WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "officeSupply.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OfficeSupply exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OfficeSupply exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficeSupplyPersistenceImpl.class);
	private static OfficeSupply _nullOfficeSupply = new OfficeSupplyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OfficeSupply> toCacheModel() {
				return _nullOfficeSupplyCacheModel;
			}
		};

	private static CacheModel<OfficeSupply> _nullOfficeSupplyCacheModel = new CacheModel<OfficeSupply>() {
			@Override
			public OfficeSupply toEntityModel() {
				return _nullOfficeSupply;
			}
		};
}