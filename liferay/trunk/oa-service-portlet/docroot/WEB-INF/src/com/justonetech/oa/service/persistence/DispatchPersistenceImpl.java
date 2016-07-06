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

import com.justonetech.oa.NoSuchDispatchException;
import com.justonetech.oa.model.Dispatch;
import com.justonetech.oa.model.impl.DispatchImpl;
import com.justonetech.oa.model.impl.DispatchModelImpl;

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
 * The persistence implementation for the dispatch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DispatchPersistence
 * @see DispatchUtil
 * @generated
 */
public class DispatchPersistenceImpl extends BasePersistenceImpl<Dispatch>
	implements DispatchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DispatchUtil} to access the dispatch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DispatchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchModelImpl.FINDER_CACHE_ENABLED, DispatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchModelImpl.FINDER_CACHE_ENABLED, DispatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchModelImpl.FINDER_CACHE_ENABLED, DispatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE = new FinderPath(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dispatchs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching dispatchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dispatch> findByTitle(String title) throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dispatchs where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of dispatchs
	 * @param end the upper bound of the range of dispatchs (not inclusive)
	 * @return the range of matching dispatchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dispatch> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dispatchs where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of dispatchs
	 * @param end the upper bound of the range of dispatchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dispatchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dispatch> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
		finderArgs = new Object[] { title, start, end, orderByComparator };

		List<Dispatch> list = (List<Dispatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Dispatch dispatch : list) {
				if (!StringUtil.wildcardMatches(dispatch.getTitle(), title,
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

			query.append(_SQL_SELECT_DISPATCH_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DispatchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<Dispatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dispatch>(list);
				}
				else {
					list = (List<Dispatch>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dispatch in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dispatch
	 * @throws com.justonetech.oa.NoSuchDispatchException if a matching dispatch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchDispatchException, SystemException {
		Dispatch dispatch = fetchByTitle_First(title, orderByComparator);

		if (dispatch != null) {
			return dispatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDispatchException(msg.toString());
	}

	/**
	 * Returns the first dispatch in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dispatch, or <code>null</code> if a matching dispatch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<Dispatch> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dispatch in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dispatch
	 * @throws com.justonetech.oa.NoSuchDispatchException if a matching dispatch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchDispatchException, SystemException {
		Dispatch dispatch = fetchByTitle_Last(title, orderByComparator);

		if (dispatch != null) {
			return dispatch;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDispatchException(msg.toString());
	}

	/**
	 * Returns the last dispatch in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dispatch, or <code>null</code> if a matching dispatch could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<Dispatch> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dispatchs before and after the current dispatch in the ordered set where title LIKE &#63;.
	 *
	 * @param dispatchId the primary key of the current dispatch
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dispatch
	 * @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch[] findByTitle_PrevAndNext(long dispatchId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchDispatchException, SystemException {
		Dispatch dispatch = findByPrimaryKey(dispatchId);

		Session session = null;

		try {
			session = openSession();

			Dispatch[] array = new DispatchImpl[3];

			array[0] = getByTitle_PrevAndNext(session, dispatch, title,
					orderByComparator, true);

			array[1] = dispatch;

			array[2] = getByTitle_PrevAndNext(session, dispatch, title,
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

	protected Dispatch getByTitle_PrevAndNext(Session session,
		Dispatch dispatch, String title, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISPATCH_WHERE);

		boolean bindTitle = false;

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else if (title.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
			query.append(DispatchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dispatch);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dispatch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dispatchs where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitle(String title) throws SystemException {
		for (Dispatch dispatch : findByTitle(title, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(dispatch);
		}
	}

	/**
	 * Returns the number of dispatchs where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching dispatchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitle(String title) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE;

		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISPATCH_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "dispatch.title LIKE NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "dispatch.title LIKE ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(dispatch.title IS NULL OR dispatch.title LIKE '')";

	public DispatchPersistenceImpl() {
		setModelClass(Dispatch.class);
	}

	/**
	 * Caches the dispatch in the entity cache if it is enabled.
	 *
	 * @param dispatch the dispatch
	 */
	@Override
	public void cacheResult(Dispatch dispatch) {
		EntityCacheUtil.putResult(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchImpl.class, dispatch.getPrimaryKey(), dispatch);

		dispatch.resetOriginalValues();
	}

	/**
	 * Caches the dispatchs in the entity cache if it is enabled.
	 *
	 * @param dispatchs the dispatchs
	 */
	@Override
	public void cacheResult(List<Dispatch> dispatchs) {
		for (Dispatch dispatch : dispatchs) {
			if (EntityCacheUtil.getResult(
						DispatchModelImpl.ENTITY_CACHE_ENABLED,
						DispatchImpl.class, dispatch.getPrimaryKey()) == null) {
				cacheResult(dispatch);
			}
			else {
				dispatch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dispatchs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DispatchImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DispatchImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dispatch.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dispatch dispatch) {
		EntityCacheUtil.removeResult(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchImpl.class, dispatch.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dispatch> dispatchs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dispatch dispatch : dispatchs) {
			EntityCacheUtil.removeResult(DispatchModelImpl.ENTITY_CACHE_ENABLED,
				DispatchImpl.class, dispatch.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dispatch with the primary key. Does not add the dispatch to the database.
	 *
	 * @param dispatchId the primary key for the new dispatch
	 * @return the new dispatch
	 */
	@Override
	public Dispatch create(long dispatchId) {
		Dispatch dispatch = new DispatchImpl();

		dispatch.setNew(true);
		dispatch.setPrimaryKey(dispatchId);

		return dispatch;
	}

	/**
	 * Removes the dispatch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dispatchId the primary key of the dispatch
	 * @return the dispatch that was removed
	 * @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch remove(long dispatchId)
		throws NoSuchDispatchException, SystemException {
		return remove((Serializable)dispatchId);
	}

	/**
	 * Removes the dispatch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dispatch
	 * @return the dispatch that was removed
	 * @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch remove(Serializable primaryKey)
		throws NoSuchDispatchException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Dispatch dispatch = (Dispatch)session.get(DispatchImpl.class,
					primaryKey);

			if (dispatch == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDispatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dispatch);
		}
		catch (NoSuchDispatchException nsee) {
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
	protected Dispatch removeImpl(Dispatch dispatch) throws SystemException {
		dispatch = toUnwrappedModel(dispatch);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dispatch)) {
				dispatch = (Dispatch)session.get(DispatchImpl.class,
						dispatch.getPrimaryKeyObj());
			}

			if (dispatch != null) {
				session.delete(dispatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dispatch != null) {
			clearCache(dispatch);
		}

		return dispatch;
	}

	@Override
	public Dispatch updateImpl(com.justonetech.oa.model.Dispatch dispatch)
		throws SystemException {
		dispatch = toUnwrappedModel(dispatch);

		boolean isNew = dispatch.isNew();

		Session session = null;

		try {
			session = openSession();

			if (dispatch.isNew()) {
				session.save(dispatch);

				dispatch.setNew(false);
			}
			else {
				session.merge(dispatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DispatchModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DispatchModelImpl.ENTITY_CACHE_ENABLED,
			DispatchImpl.class, dispatch.getPrimaryKey(), dispatch);

		return dispatch;
	}

	protected Dispatch toUnwrappedModel(Dispatch dispatch) {
		if (dispatch instanceof DispatchImpl) {
			return dispatch;
		}

		DispatchImpl dispatchImpl = new DispatchImpl();

		dispatchImpl.setNew(dispatch.isNew());
		dispatchImpl.setPrimaryKey(dispatch.getPrimaryKey());

		dispatchImpl.setDispatchId(dispatch.getDispatchId());
		dispatchImpl.setUserId(dispatch.getUserId());
		dispatchImpl.setUserName(dispatch.getUserName());
		dispatchImpl.setCreateTime(dispatch.getCreateTime());
		dispatchImpl.setModifiedTime(dispatch.getModifiedTime());
		dispatchImpl.setRocordType(dispatch.getRocordType());
		dispatchImpl.setSecurityLevel(dispatch.getSecurityLevel());
		dispatchImpl.setOrganaAbbreviation(dispatch.getOrganaAbbreviation());
		dispatchImpl.setYear(dispatch.getYear());
		dispatchImpl.setSerialNo(dispatch.getSerialNo());
		dispatchImpl.setTitle(dispatch.getTitle());
		dispatchImpl.setSendOrgan(dispatch.getSendOrgan());
		dispatchImpl.setCcOrgan(dispatch.getCcOrgan());
		dispatchImpl.setWrittenOrgan(dispatch.getWrittenOrgan());
		dispatchImpl.setWrittenDate(dispatch.getWrittenDate());
		dispatchImpl.setUrgencyDegree(dispatch.getUrgencyDegree());

		return dispatchImpl;
	}

	/**
	 * Returns the dispatch with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dispatch
	 * @return the dispatch
	 * @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDispatchException, SystemException {
		Dispatch dispatch = fetchByPrimaryKey(primaryKey);

		if (dispatch == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDispatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dispatch;
	}

	/**
	 * Returns the dispatch with the primary key or throws a {@link com.justonetech.oa.NoSuchDispatchException} if it could not be found.
	 *
	 * @param dispatchId the primary key of the dispatch
	 * @return the dispatch
	 * @throws com.justonetech.oa.NoSuchDispatchException if a dispatch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch findByPrimaryKey(long dispatchId)
		throws NoSuchDispatchException, SystemException {
		return findByPrimaryKey((Serializable)dispatchId);
	}

	/**
	 * Returns the dispatch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dispatch
	 * @return the dispatch, or <code>null</code> if a dispatch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Dispatch dispatch = (Dispatch)EntityCacheUtil.getResult(DispatchModelImpl.ENTITY_CACHE_ENABLED,
				DispatchImpl.class, primaryKey);

		if (dispatch == _nullDispatch) {
			return null;
		}

		if (dispatch == null) {
			Session session = null;

			try {
				session = openSession();

				dispatch = (Dispatch)session.get(DispatchImpl.class, primaryKey);

				if (dispatch != null) {
					cacheResult(dispatch);
				}
				else {
					EntityCacheUtil.putResult(DispatchModelImpl.ENTITY_CACHE_ENABLED,
						DispatchImpl.class, primaryKey, _nullDispatch);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DispatchModelImpl.ENTITY_CACHE_ENABLED,
					DispatchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dispatch;
	}

	/**
	 * Returns the dispatch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dispatchId the primary key of the dispatch
	 * @return the dispatch, or <code>null</code> if a dispatch with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Dispatch fetchByPrimaryKey(long dispatchId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dispatchId);
	}

	/**
	 * Returns all the dispatchs.
	 *
	 * @return the dispatchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dispatch> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dispatchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dispatchs
	 * @param end the upper bound of the range of dispatchs (not inclusive)
	 * @return the range of dispatchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dispatch> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dispatchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DispatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dispatchs
	 * @param end the upper bound of the range of dispatchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dispatchs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Dispatch> findAll(int start, int end,
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

		List<Dispatch> list = (List<Dispatch>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISPATCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISPATCH;

				if (pagination) {
					sql = sql.concat(DispatchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dispatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Dispatch>(list);
				}
				else {
					list = (List<Dispatch>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dispatchs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Dispatch dispatch : findAll()) {
			remove(dispatch);
		}
	}

	/**
	 * Returns the number of dispatchs.
	 *
	 * @return the number of dispatchs
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

				Query q = session.createQuery(_SQL_COUNT_DISPATCH);

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
	 * Initializes the dispatch persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.Dispatch")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Dispatch>> listenersList = new ArrayList<ModelListener<Dispatch>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Dispatch>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DispatchImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DISPATCH = "SELECT dispatch FROM Dispatch dispatch";
	private static final String _SQL_SELECT_DISPATCH_WHERE = "SELECT dispatch FROM Dispatch dispatch WHERE ";
	private static final String _SQL_COUNT_DISPATCH = "SELECT COUNT(dispatch) FROM Dispatch dispatch";
	private static final String _SQL_COUNT_DISPATCH_WHERE = "SELECT COUNT(dispatch) FROM Dispatch dispatch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dispatch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dispatch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dispatch exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DispatchPersistenceImpl.class);
	private static Dispatch _nullDispatch = new DispatchImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Dispatch> toCacheModel() {
				return _nullDispatchCacheModel;
			}
		};

	private static CacheModel<Dispatch> _nullDispatchCacheModel = new CacheModel<Dispatch>() {
			@Override
			public Dispatch toEntityModel() {
				return _nullDispatch;
			}
		};
}