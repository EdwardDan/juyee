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

import com.justonetech.oa.NoSuchOfficeSupplyApplicationException;
import com.justonetech.oa.model.OfficeSupplyApplication;
import com.justonetech.oa.model.impl.OfficeSupplyApplicationImpl;
import com.justonetech.oa.model.impl.OfficeSupplyApplicationModelImpl;

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
 * The persistence implementation for the office supply application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplicationPersistence
 * @see OfficeSupplyApplicationUtil
 * @generated
 */
public class OfficeSupplyApplicationPersistenceImpl extends BasePersistenceImpl<OfficeSupplyApplication>
	implements OfficeSupplyApplicationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeSupplyApplicationUtil} to access the office supply application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeSupplyApplicationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			OfficeSupplyApplicationModelImpl.USERID_COLUMN_BITMASK |
			OfficeSupplyApplicationModelImpl.MODIFIEDTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the office supply applications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching office supply applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplication> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply applications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of office supply applications
	 * @param end the upper bound of the range of office supply applications (not inclusive)
	 * @return the range of matching office supply applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplication> findByUserId(long userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply applications where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of office supply applications
	 * @param end the upper bound of the range of office supply applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching office supply applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplication> findByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<OfficeSupplyApplication> list = (List<OfficeSupplyApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OfficeSupplyApplication officeSupplyApplication : list) {
				if ((userId != officeSupplyApplication.getUserId())) {
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

			query.append(_SQL_SELECT_OFFICESUPPLYAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficeSupplyApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<OfficeSupplyApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApplication>(list);
				}
				else {
					list = (List<OfficeSupplyApplication>)QueryUtil.list(q,
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
	 * Returns the first office supply application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply application
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationException if a matching office supply application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplicationException, SystemException {
		OfficeSupplyApplication officeSupplyApplication = fetchByUserId_First(userId,
				orderByComparator);

		if (officeSupplyApplication != null) {
			return officeSupplyApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplicationException(msg.toString());
	}

	/**
	 * Returns the first office supply application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply application, or <code>null</code> if a matching office supply application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OfficeSupplyApplication> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last office supply application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply application
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationException if a matching office supply application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplicationException, SystemException {
		OfficeSupplyApplication officeSupplyApplication = fetchByUserId_Last(userId,
				orderByComparator);

		if (officeSupplyApplication != null) {
			return officeSupplyApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplicationException(msg.toString());
	}

	/**
	 * Returns the last office supply application in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply application, or <code>null</code> if a matching office supply application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<OfficeSupplyApplication> list = findByUserId(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the office supply applications before and after the current office supply application in the ordered set where userId = &#63;.
	 *
	 * @param officeSupplyApplicationId the primary key of the current office supply application
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office supply application
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationException if a office supply application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication[] findByUserId_PrevAndNext(
		long officeSupplyApplicationId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplicationException, SystemException {
		OfficeSupplyApplication officeSupplyApplication = findByPrimaryKey(officeSupplyApplicationId);

		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApplication[] array = new OfficeSupplyApplicationImpl[3];

			array[0] = getByUserId_PrevAndNext(session,
					officeSupplyApplication, userId, orderByComparator, true);

			array[1] = officeSupplyApplication;

			array[2] = getByUserId_PrevAndNext(session,
					officeSupplyApplication, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OfficeSupplyApplication getByUserId_PrevAndNext(Session session,
		OfficeSupplyApplication officeSupplyApplication, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OFFICESUPPLYAPPLICATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(OfficeSupplyApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(officeSupplyApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OfficeSupplyApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the office supply applications where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (OfficeSupplyApplication officeSupplyApplication : findByUserId(
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(officeSupplyApplication);
		}
	}

	/**
	 * Returns the number of office supply applications where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching office supply applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICESUPPLYAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "officeSupplyApplication.userId = ?";

	public OfficeSupplyApplicationPersistenceImpl() {
		setModelClass(OfficeSupplyApplication.class);
	}

	/**
	 * Caches the office supply application in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApplication the office supply application
	 */
	@Override
	public void cacheResult(OfficeSupplyApplication officeSupplyApplication) {
		EntityCacheUtil.putResult(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationImpl.class,
			officeSupplyApplication.getPrimaryKey(), officeSupplyApplication);

		officeSupplyApplication.resetOriginalValues();
	}

	/**
	 * Caches the office supply applications in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApplications the office supply applications
	 */
	@Override
	public void cacheResult(
		List<OfficeSupplyApplication> officeSupplyApplications) {
		for (OfficeSupplyApplication officeSupplyApplication : officeSupplyApplications) {
			if (EntityCacheUtil.getResult(
						OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplicationImpl.class,
						officeSupplyApplication.getPrimaryKey()) == null) {
				cacheResult(officeSupplyApplication);
			}
			else {
				officeSupplyApplication.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all office supply applications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeSupplyApplicationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeSupplyApplicationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office supply application.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OfficeSupplyApplication officeSupplyApplication) {
		EntityCacheUtil.removeResult(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationImpl.class,
			officeSupplyApplication.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<OfficeSupplyApplication> officeSupplyApplications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OfficeSupplyApplication officeSupplyApplication : officeSupplyApplications) {
			EntityCacheUtil.removeResult(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplicationImpl.class,
				officeSupplyApplication.getPrimaryKey());
		}
	}

	/**
	 * Creates a new office supply application with the primary key. Does not add the office supply application to the database.
	 *
	 * @param officeSupplyApplicationId the primary key for the new office supply application
	 * @return the new office supply application
	 */
	@Override
	public OfficeSupplyApplication create(long officeSupplyApplicationId) {
		OfficeSupplyApplication officeSupplyApplication = new OfficeSupplyApplicationImpl();

		officeSupplyApplication.setNew(true);
		officeSupplyApplication.setPrimaryKey(officeSupplyApplicationId);

		return officeSupplyApplication;
	}

	/**
	 * Removes the office supply application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyApplicationId the primary key of the office supply application
	 * @return the office supply application that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationException if a office supply application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication remove(long officeSupplyApplicationId)
		throws NoSuchOfficeSupplyApplicationException, SystemException {
		return remove((Serializable)officeSupplyApplicationId);
	}

	/**
	 * Removes the office supply application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office supply application
	 * @return the office supply application that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationException if a office supply application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication remove(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplicationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApplication officeSupplyApplication = (OfficeSupplyApplication)session.get(OfficeSupplyApplicationImpl.class,
					primaryKey);

			if (officeSupplyApplication == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeSupplyApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(officeSupplyApplication);
		}
		catch (NoSuchOfficeSupplyApplicationException nsee) {
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
	protected OfficeSupplyApplication removeImpl(
		OfficeSupplyApplication officeSupplyApplication)
		throws SystemException {
		officeSupplyApplication = toUnwrappedModel(officeSupplyApplication);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(officeSupplyApplication)) {
				officeSupplyApplication = (OfficeSupplyApplication)session.get(OfficeSupplyApplicationImpl.class,
						officeSupplyApplication.getPrimaryKeyObj());
			}

			if (officeSupplyApplication != null) {
				session.delete(officeSupplyApplication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (officeSupplyApplication != null) {
			clearCache(officeSupplyApplication);
		}

		return officeSupplyApplication;
	}

	@Override
	public OfficeSupplyApplication updateImpl(
		com.justonetech.oa.model.OfficeSupplyApplication officeSupplyApplication)
		throws SystemException {
		officeSupplyApplication = toUnwrappedModel(officeSupplyApplication);

		boolean isNew = officeSupplyApplication.isNew();

		OfficeSupplyApplicationModelImpl officeSupplyApplicationModelImpl = (OfficeSupplyApplicationModelImpl)officeSupplyApplication;

		Session session = null;

		try {
			session = openSession();

			if (officeSupplyApplication.isNew()) {
				session.save(officeSupplyApplication);

				officeSupplyApplication.setNew(false);
			}
			else {
				session.merge(officeSupplyApplication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OfficeSupplyApplicationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((officeSupplyApplicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						officeSupplyApplicationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { officeSupplyApplicationModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplicationImpl.class,
			officeSupplyApplication.getPrimaryKey(), officeSupplyApplication);

		return officeSupplyApplication;
	}

	protected OfficeSupplyApplication toUnwrappedModel(
		OfficeSupplyApplication officeSupplyApplication) {
		if (officeSupplyApplication instanceof OfficeSupplyApplicationImpl) {
			return officeSupplyApplication;
		}

		OfficeSupplyApplicationImpl officeSupplyApplicationImpl = new OfficeSupplyApplicationImpl();

		officeSupplyApplicationImpl.setNew(officeSupplyApplication.isNew());
		officeSupplyApplicationImpl.setPrimaryKey(officeSupplyApplication.getPrimaryKey());

		officeSupplyApplicationImpl.setOfficeSupplyApplicationId(officeSupplyApplication.getOfficeSupplyApplicationId());
		officeSupplyApplicationImpl.setGroupId(officeSupplyApplication.getGroupId());
		officeSupplyApplicationImpl.setCompanyId(officeSupplyApplication.getCompanyId());
		officeSupplyApplicationImpl.setUserId(officeSupplyApplication.getUserId());
		officeSupplyApplicationImpl.setUserName(officeSupplyApplication.getUserName());
		officeSupplyApplicationImpl.setCreateTime(officeSupplyApplication.getCreateTime());
		officeSupplyApplicationImpl.setModifiedTime(officeSupplyApplication.getModifiedTime());
		officeSupplyApplicationImpl.setDeptId(officeSupplyApplication.getDeptId());
		officeSupplyApplicationImpl.setDeptName(officeSupplyApplication.getDeptName());
		officeSupplyApplicationImpl.setIntroductions(officeSupplyApplication.getIntroductions());
		officeSupplyApplicationImpl.setPerposeClerk(officeSupplyApplication.getPerposeClerk());
		officeSupplyApplicationImpl.setTitle(officeSupplyApplication.getTitle());
		officeSupplyApplicationImpl.setContent(officeSupplyApplication.getContent());
		officeSupplyApplicationImpl.setStatus(officeSupplyApplication.getStatus());
		officeSupplyApplicationImpl.setStatusByUserId(officeSupplyApplication.getStatusByUserId());
		officeSupplyApplicationImpl.setStatusByUserName(officeSupplyApplication.getStatusByUserName());
		officeSupplyApplicationImpl.setStatusDate(officeSupplyApplication.getStatusDate());

		return officeSupplyApplicationImpl;
	}

	/**
	 * Returns the office supply application with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply application
	 * @return the office supply application
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationException if a office supply application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplicationException, SystemException {
		OfficeSupplyApplication officeSupplyApplication = fetchByPrimaryKey(primaryKey);

		if (officeSupplyApplication == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeSupplyApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return officeSupplyApplication;
	}

	/**
	 * Returns the office supply application with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyApplicationException} if it could not be found.
	 *
	 * @param officeSupplyApplicationId the primary key of the office supply application
	 * @return the office supply application
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplicationException if a office supply application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication findByPrimaryKey(
		long officeSupplyApplicationId)
		throws NoSuchOfficeSupplyApplicationException, SystemException {
		return findByPrimaryKey((Serializable)officeSupplyApplicationId);
	}

	/**
	 * Returns the office supply application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply application
	 * @return the office supply application, or <code>null</code> if a office supply application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OfficeSupplyApplication officeSupplyApplication = (OfficeSupplyApplication)EntityCacheUtil.getResult(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplicationImpl.class, primaryKey);

		if (officeSupplyApplication == _nullOfficeSupplyApplication) {
			return null;
		}

		if (officeSupplyApplication == null) {
			Session session = null;

			try {
				session = openSession();

				officeSupplyApplication = (OfficeSupplyApplication)session.get(OfficeSupplyApplicationImpl.class,
						primaryKey);

				if (officeSupplyApplication != null) {
					cacheResult(officeSupplyApplication);
				}
				else {
					EntityCacheUtil.putResult(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplicationImpl.class, primaryKey,
						_nullOfficeSupplyApplication);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeSupplyApplicationModelImpl.ENTITY_CACHE_ENABLED,
					OfficeSupplyApplicationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return officeSupplyApplication;
	}

	/**
	 * Returns the office supply application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeSupplyApplicationId the primary key of the office supply application
	 * @return the office supply application, or <code>null</code> if a office supply application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplication fetchByPrimaryKey(
		long officeSupplyApplicationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)officeSupplyApplicationId);
	}

	/**
	 * Returns all the office supply applications.
	 *
	 * @return the office supply applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplication> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply applications
	 * @param end the upper bound of the range of office supply applications (not inclusive)
	 * @return the range of office supply applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplication> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply applications
	 * @param end the upper bound of the range of office supply applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of office supply applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplication> findAll(int start, int end,
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

		List<OfficeSupplyApplication> list = (List<OfficeSupplyApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICESUPPLYAPPLICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICESUPPLYAPPLICATION;

				if (pagination) {
					sql = sql.concat(OfficeSupplyApplicationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OfficeSupplyApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApplication>(list);
				}
				else {
					list = (List<OfficeSupplyApplication>)QueryUtil.list(q,
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
	 * Removes all the office supply applications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OfficeSupplyApplication officeSupplyApplication : findAll()) {
			remove(officeSupplyApplication);
		}
	}

	/**
	 * Returns the number of office supply applications.
	 *
	 * @return the number of office supply applications
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

				Query q = session.createQuery(_SQL_COUNT_OFFICESUPPLYAPPLICATION);

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
	 * Initializes the office supply application persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.OfficeSupplyApplication")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OfficeSupplyApplication>> listenersList = new ArrayList<ModelListener<OfficeSupplyApplication>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OfficeSupplyApplication>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeSupplyApplicationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICESUPPLYAPPLICATION = "SELECT officeSupplyApplication FROM OfficeSupplyApplication officeSupplyApplication";
	private static final String _SQL_SELECT_OFFICESUPPLYAPPLICATION_WHERE = "SELECT officeSupplyApplication FROM OfficeSupplyApplication officeSupplyApplication WHERE ";
	private static final String _SQL_COUNT_OFFICESUPPLYAPPLICATION = "SELECT COUNT(officeSupplyApplication) FROM OfficeSupplyApplication officeSupplyApplication";
	private static final String _SQL_COUNT_OFFICESUPPLYAPPLICATION_WHERE = "SELECT COUNT(officeSupplyApplication) FROM OfficeSupplyApplication officeSupplyApplication WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "officeSupplyApplication.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OfficeSupplyApplication exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OfficeSupplyApplication exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficeSupplyApplicationPersistenceImpl.class);
	private static OfficeSupplyApplication _nullOfficeSupplyApplication = new OfficeSupplyApplicationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OfficeSupplyApplication> toCacheModel() {
				return _nullOfficeSupplyApplicationCacheModel;
			}
		};

	private static CacheModel<OfficeSupplyApplication> _nullOfficeSupplyApplicationCacheModel =
		new CacheModel<OfficeSupplyApplication>() {
			@Override
			public OfficeSupplyApplication toEntityModel() {
				return _nullOfficeSupplyApplication;
			}
		};
}