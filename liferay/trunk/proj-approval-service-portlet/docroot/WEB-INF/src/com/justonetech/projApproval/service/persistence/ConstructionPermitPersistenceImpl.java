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

import com.justonetech.projApproval.NoSuchConstructionPermitException;
import com.justonetech.projApproval.model.ConstructionPermit;
import com.justonetech.projApproval.model.impl.ConstructionPermitImpl;
import com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl;

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
 * The persistence implementation for the construction permit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionPermitPersistence
 * @see ConstructionPermitUtil
 * @generated
 */
public class ConstructionPermitPersistenceImpl extends BasePersistenceImpl<ConstructionPermit>
	implements ConstructionPermitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConstructionPermitUtil} to access the construction permit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConstructionPermitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitModelImpl.FINDER_CACHE_ENABLED,
			ConstructionPermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitModelImpl.FINDER_CACHE_ENABLED,
			ConstructionPermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitModelImpl.FINDER_CACHE_ENABLED,
			ConstructionPermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitModelImpl.FINDER_CACHE_ENABLED,
			ConstructionPermitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ConstructionPermitModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the construction permits where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionPermit> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the construction permits where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of construction permits
	 * @param end the upper bound of the range of construction permits (not inclusive)
	 * @return the range of matching construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionPermit> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the construction permits where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of construction permits
	 * @param end the upper bound of the range of construction permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionPermit> findByUserId(long userId, int start,
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

		List<ConstructionPermit> list = (List<ConstructionPermit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ConstructionPermit constructionPermit : list) {
				if ((userId != constructionPermit.getUserId())) {
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

			query.append(_SQL_SELECT_CONSTRUCTIONPERMIT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ConstructionPermitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<ConstructionPermit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConstructionPermit>(list);
				}
				else {
					list = (List<ConstructionPermit>)QueryUtil.list(q,
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
	 * Returns the first construction permit in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching construction permit
	 * @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a matching construction permit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchConstructionPermitException, SystemException {
		ConstructionPermit constructionPermit = fetchByUserId_First(userId,
				orderByComparator);

		if (constructionPermit != null) {
			return constructionPermit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConstructionPermitException(msg.toString());
	}

	/**
	 * Returns the first construction permit in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching construction permit, or <code>null</code> if a matching construction permit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ConstructionPermit> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last construction permit in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching construction permit
	 * @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a matching construction permit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchConstructionPermitException, SystemException {
		ConstructionPermit constructionPermit = fetchByUserId_Last(userId,
				orderByComparator);

		if (constructionPermit != null) {
			return constructionPermit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchConstructionPermitException(msg.toString());
	}

	/**
	 * Returns the last construction permit in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching construction permit, or <code>null</code> if a matching construction permit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<ConstructionPermit> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the construction permits before and after the current construction permit in the ordered set where userId = &#63;.
	 *
	 * @param constructionPermitId the primary key of the current construction permit
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next construction permit
	 * @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit[] findByUserId_PrevAndNext(
		long constructionPermitId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchConstructionPermitException, SystemException {
		ConstructionPermit constructionPermit = findByPrimaryKey(constructionPermitId);

		Session session = null;

		try {
			session = openSession();

			ConstructionPermit[] array = new ConstructionPermitImpl[3];

			array[0] = getByUserId_PrevAndNext(session, constructionPermit,
					userId, orderByComparator, true);

			array[1] = constructionPermit;

			array[2] = getByUserId_PrevAndNext(session, constructionPermit,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConstructionPermit getByUserId_PrevAndNext(Session session,
		ConstructionPermit constructionPermit, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONSTRUCTIONPERMIT_WHERE);

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
			query.append(ConstructionPermitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(constructionPermit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ConstructionPermit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the construction permits where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (ConstructionPermit constructionPermit : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(constructionPermit);
		}
	}

	/**
	 * Returns the number of construction permits where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching construction permits
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

			query.append(_SQL_COUNT_CONSTRUCTIONPERMIT_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "constructionPermit.userId = ?";

	public ConstructionPermitPersistenceImpl() {
		setModelClass(ConstructionPermit.class);
	}

	/**
	 * Caches the construction permit in the entity cache if it is enabled.
	 *
	 * @param constructionPermit the construction permit
	 */
	@Override
	public void cacheResult(ConstructionPermit constructionPermit) {
		EntityCacheUtil.putResult(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitImpl.class, constructionPermit.getPrimaryKey(),
			constructionPermit);

		constructionPermit.resetOriginalValues();
	}

	/**
	 * Caches the construction permits in the entity cache if it is enabled.
	 *
	 * @param constructionPermits the construction permits
	 */
	@Override
	public void cacheResult(List<ConstructionPermit> constructionPermits) {
		for (ConstructionPermit constructionPermit : constructionPermits) {
			if (EntityCacheUtil.getResult(
						ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
						ConstructionPermitImpl.class,
						constructionPermit.getPrimaryKey()) == null) {
				cacheResult(constructionPermit);
			}
			else {
				constructionPermit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all construction permits.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConstructionPermitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConstructionPermitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the construction permit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConstructionPermit constructionPermit) {
		EntityCacheUtil.removeResult(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitImpl.class, constructionPermit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ConstructionPermit> constructionPermits) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConstructionPermit constructionPermit : constructionPermits) {
			EntityCacheUtil.removeResult(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
				ConstructionPermitImpl.class, constructionPermit.getPrimaryKey());
		}
	}

	/**
	 * Creates a new construction permit with the primary key. Does not add the construction permit to the database.
	 *
	 * @param constructionPermitId the primary key for the new construction permit
	 * @return the new construction permit
	 */
	@Override
	public ConstructionPermit create(long constructionPermitId) {
		ConstructionPermit constructionPermit = new ConstructionPermitImpl();

		constructionPermit.setNew(true);
		constructionPermit.setPrimaryKey(constructionPermitId);

		return constructionPermit;
	}

	/**
	 * Removes the construction permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param constructionPermitId the primary key of the construction permit
	 * @return the construction permit that was removed
	 * @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit remove(long constructionPermitId)
		throws NoSuchConstructionPermitException, SystemException {
		return remove((Serializable)constructionPermitId);
	}

	/**
	 * Removes the construction permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the construction permit
	 * @return the construction permit that was removed
	 * @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit remove(Serializable primaryKey)
		throws NoSuchConstructionPermitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConstructionPermit constructionPermit = (ConstructionPermit)session.get(ConstructionPermitImpl.class,
					primaryKey);

			if (constructionPermit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConstructionPermitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(constructionPermit);
		}
		catch (NoSuchConstructionPermitException nsee) {
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
	protected ConstructionPermit removeImpl(
		ConstructionPermit constructionPermit) throws SystemException {
		constructionPermit = toUnwrappedModel(constructionPermit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(constructionPermit)) {
				constructionPermit = (ConstructionPermit)session.get(ConstructionPermitImpl.class,
						constructionPermit.getPrimaryKeyObj());
			}

			if (constructionPermit != null) {
				session.delete(constructionPermit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (constructionPermit != null) {
			clearCache(constructionPermit);
		}

		return constructionPermit;
	}

	@Override
	public ConstructionPermit updateImpl(
		com.justonetech.projApproval.model.ConstructionPermit constructionPermit)
		throws SystemException {
		constructionPermit = toUnwrappedModel(constructionPermit);

		boolean isNew = constructionPermit.isNew();

		ConstructionPermitModelImpl constructionPermitModelImpl = (ConstructionPermitModelImpl)constructionPermit;

		Session session = null;

		try {
			session = openSession();

			if (constructionPermit.isNew()) {
				session.save(constructionPermit);

				constructionPermit.setNew(false);
			}
			else {
				session.merge(constructionPermit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConstructionPermitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((constructionPermitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						constructionPermitModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { constructionPermitModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionPermitImpl.class, constructionPermit.getPrimaryKey(),
			constructionPermit);

		return constructionPermit;
	}

	protected ConstructionPermit toUnwrappedModel(
		ConstructionPermit constructionPermit) {
		if (constructionPermit instanceof ConstructionPermitImpl) {
			return constructionPermit;
		}

		ConstructionPermitImpl constructionPermitImpl = new ConstructionPermitImpl();

		constructionPermitImpl.setNew(constructionPermit.isNew());
		constructionPermitImpl.setPrimaryKey(constructionPermit.getPrimaryKey());

		constructionPermitImpl.setConstructionPermitId(constructionPermit.getConstructionPermitId());
		constructionPermitImpl.setUserId(constructionPermit.getUserId());
		constructionPermitImpl.setUserName(constructionPermit.getUserName());
		constructionPermitImpl.setCreateTime(constructionPermit.getCreateTime());
		constructionPermitImpl.setModifiedTime(constructionPermit.getModifiedTime());
		constructionPermitImpl.setProjType(constructionPermit.getProjType());
		constructionPermitImpl.setProjProperty(constructionPermit.getProjProperty());
		constructionPermitImpl.setCounty(constructionPermit.getCounty());
		constructionPermitImpl.setConstructionCode(constructionPermit.getConstructionCode());
		constructionPermitImpl.setBidingCode(constructionPermit.getBidingCode());
		constructionPermitImpl.setBusinessCode(constructionPermit.getBusinessCode());
		constructionPermitImpl.setProjName(constructionPermit.getProjName());
		constructionPermitImpl.setCompany(constructionPermit.getCompany());
		constructionPermitImpl.setCompanyProperty(constructionPermit.getCompanyProperty());
		constructionPermitImpl.setCompanyAddress(constructionPermit.getCompanyAddress());
		constructionPermitImpl.setLegalPerson(constructionPermit.getLegalPerson());
		constructionPermitImpl.setCompanyTel(constructionPermit.getCompanyTel());
		constructionPermitImpl.setCompanyContacts(constructionPermit.getCompanyContacts());
		constructionPermitImpl.setCompanyContactPhone(constructionPermit.getCompanyContactPhone());
		constructionPermitImpl.setCompanySite(constructionPermit.getCompanySite());
		constructionPermitImpl.setCompanySiteCounty(constructionPermit.getCompanySiteCounty());
		constructionPermitImpl.setEngineerCategory(constructionPermit.getEngineerCategory());
		constructionPermitImpl.setEngineerAttribute(constructionPermit.getEngineerAttribute());
		constructionPermitImpl.setEngineerScale(constructionPermit.getEngineerScale());
		constructionPermitImpl.setNationalFundsProportion(constructionPermit.getNationalFundsProportion());
		constructionPermitImpl.setContractPrice(constructionPermit.getContractPrice());
		constructionPermitImpl.setContractSchedule(constructionPermit.getContractSchedule());
		constructionPermitImpl.setBidPrice(constructionPermit.getBidPrice());
		constructionPermitImpl.setInvestBudget(constructionPermit.getInvestBudget());
		constructionPermitImpl.setPlanStartDate(constructionPermit.getPlanStartDate());
		constructionPermitImpl.setPlanEndDate(constructionPermit.getPlanEndDate());
		constructionPermitImpl.setWorkSituation(constructionPermit.getWorkSituation());
		constructionPermitImpl.setOtherInfo(constructionPermit.getOtherInfo());
		constructionPermitImpl.setApplyMaterial(constructionPermit.getApplyMaterial());
		constructionPermitImpl.setReceiptNum(constructionPermit.getReceiptNum());
		constructionPermitImpl.setCertificationDate(constructionPermit.getCertificationDate());
		constructionPermitImpl.setConstructionPermitCode(constructionPermit.getConstructionPermitCode());

		return constructionPermitImpl;
	}

	/**
	 * Returns the construction permit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the construction permit
	 * @return the construction permit
	 * @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConstructionPermitException, SystemException {
		ConstructionPermit constructionPermit = fetchByPrimaryKey(primaryKey);

		if (constructionPermit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConstructionPermitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return constructionPermit;
	}

	/**
	 * Returns the construction permit with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionPermitException} if it could not be found.
	 *
	 * @param constructionPermitId the primary key of the construction permit
	 * @return the construction permit
	 * @throws com.justonetech.projApproval.NoSuchConstructionPermitException if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit findByPrimaryKey(long constructionPermitId)
		throws NoSuchConstructionPermitException, SystemException {
		return findByPrimaryKey((Serializable)constructionPermitId);
	}

	/**
	 * Returns the construction permit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the construction permit
	 * @return the construction permit, or <code>null</code> if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ConstructionPermit constructionPermit = (ConstructionPermit)EntityCacheUtil.getResult(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
				ConstructionPermitImpl.class, primaryKey);

		if (constructionPermit == _nullConstructionPermit) {
			return null;
		}

		if (constructionPermit == null) {
			Session session = null;

			try {
				session = openSession();

				constructionPermit = (ConstructionPermit)session.get(ConstructionPermitImpl.class,
						primaryKey);

				if (constructionPermit != null) {
					cacheResult(constructionPermit);
				}
				else {
					EntityCacheUtil.putResult(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
						ConstructionPermitImpl.class, primaryKey,
						_nullConstructionPermit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConstructionPermitModelImpl.ENTITY_CACHE_ENABLED,
					ConstructionPermitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return constructionPermit;
	}

	/**
	 * Returns the construction permit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param constructionPermitId the primary key of the construction permit
	 * @return the construction permit, or <code>null</code> if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit fetchByPrimaryKey(long constructionPermitId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)constructionPermitId);
	}

	/**
	 * Returns all the construction permits.
	 *
	 * @return the construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionPermit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the construction permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of construction permits
	 * @param end the upper bound of the range of construction permits (not inclusive)
	 * @return the range of construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionPermit> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the construction permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of construction permits
	 * @param end the upper bound of the range of construction permits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionPermit> findAll(int start, int end,
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

		List<ConstructionPermit> list = (List<ConstructionPermit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONSTRUCTIONPERMIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONSTRUCTIONPERMIT;

				if (pagination) {
					sql = sql.concat(ConstructionPermitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConstructionPermit>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConstructionPermit>(list);
				}
				else {
					list = (List<ConstructionPermit>)QueryUtil.list(q,
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
	 * Removes all the construction permits from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConstructionPermit constructionPermit : findAll()) {
			remove(constructionPermit);
		}
	}

	/**
	 * Returns the number of construction permits.
	 *
	 * @return the number of construction permits
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

				Query q = session.createQuery(_SQL_COUNT_CONSTRUCTIONPERMIT);

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
	 * Initializes the construction permit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.projApproval.model.ConstructionPermit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConstructionPermit>> listenersList = new ArrayList<ModelListener<ConstructionPermit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConstructionPermit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConstructionPermitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONSTRUCTIONPERMIT = "SELECT constructionPermit FROM ConstructionPermit constructionPermit";
	private static final String _SQL_SELECT_CONSTRUCTIONPERMIT_WHERE = "SELECT constructionPermit FROM ConstructionPermit constructionPermit WHERE ";
	private static final String _SQL_COUNT_CONSTRUCTIONPERMIT = "SELECT COUNT(constructionPermit) FROM ConstructionPermit constructionPermit";
	private static final String _SQL_COUNT_CONSTRUCTIONPERMIT_WHERE = "SELECT COUNT(constructionPermit) FROM ConstructionPermit constructionPermit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "constructionPermit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConstructionPermit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConstructionPermit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConstructionPermitPersistenceImpl.class);
	private static ConstructionPermit _nullConstructionPermit = new ConstructionPermitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConstructionPermit> toCacheModel() {
				return _nullConstructionPermitCacheModel;
			}
		};

	private static CacheModel<ConstructionPermit> _nullConstructionPermitCacheModel =
		new CacheModel<ConstructionPermit>() {
			@Override
			public ConstructionPermit toEntityModel() {
				return _nullConstructionPermit;
			}
		};
}