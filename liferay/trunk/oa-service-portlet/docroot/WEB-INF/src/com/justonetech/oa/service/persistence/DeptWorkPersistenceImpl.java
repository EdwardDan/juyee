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

import com.justonetech.oa.NoSuchDeptWorkException;
import com.justonetech.oa.model.DeptWork;
import com.justonetech.oa.model.impl.DeptWorkImpl;
import com.justonetech.oa.model.impl.DeptWorkModelImpl;

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
 * The persistence implementation for the dept work service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see DeptWorkPersistence
 * @see DeptWorkUtil
 * @generated
 */
public class DeptWorkPersistenceImpl extends BasePersistenceImpl<DeptWork>
	implements DeptWorkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DeptWorkUtil} to access the dept work persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DeptWorkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkModelImpl.FINDER_CACHE_ENABLED, DeptWorkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkModelImpl.FINDER_CACHE_ENABLED, DeptWorkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPTNAME = new FinderPath(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkModelImpl.FINDER_CACHE_ENABLED, DeptWorkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeptName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DEPTNAME =
		new FinderPath(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDeptName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dept works where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @return the matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findByDeptName(String deptName)
		throws SystemException {
		return findByDeptName(deptName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dept works where deptName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deptName the dept name
	 * @param start the lower bound of the range of dept works
	 * @param end the upper bound of the range of dept works (not inclusive)
	 * @return the range of matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findByDeptName(String deptName, int start, int end)
		throws SystemException {
		return findByDeptName(deptName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dept works where deptName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deptName the dept name
	 * @param start the lower bound of the range of dept works
	 * @param end the upper bound of the range of dept works (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findByDeptName(String deptName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPTNAME;
		finderArgs = new Object[] { deptName, start, end, orderByComparator };

		List<DeptWork> list = (List<DeptWork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeptWork deptWork : list) {
				if (!StringUtil.wildcardMatches(deptWork.getDeptName(),
							deptName, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_DEPTWORK_WHERE);

			boolean bindDeptName = false;

			if (deptName == null) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_1);
			}
			else if (deptName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_3);
			}
			else {
				bindDeptName = true;

				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeptWorkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeptName) {
					qPos.add(deptName);
				}

				if (!pagination) {
					list = (List<DeptWork>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeptWork>(list);
				}
				else {
					list = (List<DeptWork>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dept work in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork findByDeptName_First(String deptName,
		OrderByComparator orderByComparator)
		throws NoSuchDeptWorkException, SystemException {
		DeptWork deptWork = fetchByDeptName_First(deptName, orderByComparator);

		if (deptWork != null) {
			return deptWork;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deptName=");
		msg.append(deptName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeptWorkException(msg.toString());
	}

	/**
	 * Returns the first dept work in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dept work, or <code>null</code> if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork fetchByDeptName_First(String deptName,
		OrderByComparator orderByComparator) throws SystemException {
		List<DeptWork> list = findByDeptName(deptName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dept work in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork findByDeptName_Last(String deptName,
		OrderByComparator orderByComparator)
		throws NoSuchDeptWorkException, SystemException {
		DeptWork deptWork = fetchByDeptName_Last(deptName, orderByComparator);

		if (deptWork != null) {
			return deptWork;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deptName=");
		msg.append(deptName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeptWorkException(msg.toString());
	}

	/**
	 * Returns the last dept work in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dept work, or <code>null</code> if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork fetchByDeptName_Last(String deptName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDeptName(deptName);

		if (count == 0) {
			return null;
		}

		List<DeptWork> list = findByDeptName(deptName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dept works before and after the current dept work in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptWorkId the primary key of the current dept work
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork[] findByDeptName_PrevAndNext(long deptWorkId,
		String deptName, OrderByComparator orderByComparator)
		throws NoSuchDeptWorkException, SystemException {
		DeptWork deptWork = findByPrimaryKey(deptWorkId);

		Session session = null;

		try {
			session = openSession();

			DeptWork[] array = new DeptWorkImpl[3];

			array[0] = getByDeptName_PrevAndNext(session, deptWork, deptName,
					orderByComparator, true);

			array[1] = deptWork;

			array[2] = getByDeptName_PrevAndNext(session, deptWork, deptName,
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

	protected DeptWork getByDeptName_PrevAndNext(Session session,
		DeptWork deptWork, String deptName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEPTWORK_WHERE);

		boolean bindDeptName = false;

		if (deptName == null) {
			query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_1);
		}
		else if (deptName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_3);
		}
		else {
			bindDeptName = true;

			query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_2);
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
			query.append(DeptWorkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDeptName) {
			qPos.add(deptName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(deptWork);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeptWork> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dept works where deptName LIKE &#63; from the database.
	 *
	 * @param deptName the dept name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDeptName(String deptName) throws SystemException {
		for (DeptWork deptWork : findByDeptName(deptName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(deptWork);
		}
	}

	/**
	 * Returns the number of dept works where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @return the number of matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDeptName(String deptName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DEPTNAME;

		Object[] finderArgs = new Object[] { deptName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEPTWORK_WHERE);

			boolean bindDeptName = false;

			if (deptName == null) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_1);
			}
			else if (deptName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_3);
			}
			else {
				bindDeptName = true;

				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeptName) {
					qPos.add(deptName);
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

	private static final String _FINDER_COLUMN_DEPTNAME_DEPTNAME_1 = "deptWork.deptName LIKE NULL";
	private static final String _FINDER_COLUMN_DEPTNAME_DEPTNAME_2 = "deptWork.deptName LIKE ?";
	private static final String _FINDER_COLUMN_DEPTNAME_DEPTNAME_3 = "(deptWork.deptName IS NULL OR deptWork.deptName LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME = new FinderPath(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkModelImpl.FINDER_CACHE_ENABLED, DeptWorkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERNAME =
		new FinderPath(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByUserName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dept works where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @return the matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findByUserName(String userName)
		throws SystemException {
		return findByUserName(userName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dept works where userName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of dept works
	 * @param end the upper bound of the range of dept works (not inclusive)
	 * @return the range of matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findByUserName(String userName, int start, int end)
		throws SystemException {
		return findByUserName(userName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dept works where userName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of dept works
	 * @param end the upper bound of the range of dept works (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findByUserName(String userName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERNAME;
		finderArgs = new Object[] { userName, start, end, orderByComparator };

		List<DeptWork> list = (List<DeptWork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeptWork deptWork : list) {
				if (!StringUtil.wildcardMatches(deptWork.getUserName(),
							userName, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_DEPTWORK_WHERE);

			boolean bindUserName = false;

			if (userName == null) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
			}
			else if (userName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeptWorkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
				}

				if (!pagination) {
					list = (List<DeptWork>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeptWork>(list);
				}
				else {
					list = (List<DeptWork>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dept work in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork findByUserName_First(String userName,
		OrderByComparator orderByComparator)
		throws NoSuchDeptWorkException, SystemException {
		DeptWork deptWork = fetchByUserName_First(userName, orderByComparator);

		if (deptWork != null) {
			return deptWork;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeptWorkException(msg.toString());
	}

	/**
	 * Returns the first dept work in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dept work, or <code>null</code> if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork fetchByUserName_First(String userName,
		OrderByComparator orderByComparator) throws SystemException {
		List<DeptWork> list = findByUserName(userName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dept work in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork findByUserName_Last(String userName,
		OrderByComparator orderByComparator)
		throws NoSuchDeptWorkException, SystemException {
		DeptWork deptWork = fetchByUserName_Last(userName, orderByComparator);

		if (deptWork != null) {
			return deptWork;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userName=");
		msg.append(userName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeptWorkException(msg.toString());
	}

	/**
	 * Returns the last dept work in the ordered set where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dept work, or <code>null</code> if a matching dept work could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork fetchByUserName_Last(String userName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserName(userName);

		if (count == 0) {
			return null;
		}

		List<DeptWork> list = findByUserName(userName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dept works before and after the current dept work in the ordered set where userName LIKE &#63;.
	 *
	 * @param deptWorkId the primary key of the current dept work
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork[] findByUserName_PrevAndNext(long deptWorkId,
		String userName, OrderByComparator orderByComparator)
		throws NoSuchDeptWorkException, SystemException {
		DeptWork deptWork = findByPrimaryKey(deptWorkId);

		Session session = null;

		try {
			session = openSession();

			DeptWork[] array = new DeptWorkImpl[3];

			array[0] = getByUserName_PrevAndNext(session, deptWork, userName,
					orderByComparator, true);

			array[1] = deptWork;

			array[2] = getByUserName_PrevAndNext(session, deptWork, userName,
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

	protected DeptWork getByUserName_PrevAndNext(Session session,
		DeptWork deptWork, String userName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEPTWORK_WHERE);

		boolean bindUserName = false;

		if (userName == null) {
			query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
		}
		else if (userName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
		}
		else {
			bindUserName = true;

			query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
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
			query.append(DeptWorkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserName) {
			qPos.add(userName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(deptWork);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeptWork> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dept works where userName LIKE &#63; from the database.
	 *
	 * @param userName the user name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserName(String userName) throws SystemException {
		for (DeptWork deptWork : findByUserName(userName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(deptWork);
		}
	}

	/**
	 * Returns the number of dept works where userName LIKE &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserName(String userName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_USERNAME;

		Object[] finderArgs = new Object[] { userName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEPTWORK_WHERE);

			boolean bindUserName = false;

			if (userName == null) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
			}
			else if (userName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
			}
			else {
				bindUserName = true;

				query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserName) {
					qPos.add(userName);
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

	private static final String _FINDER_COLUMN_USERNAME_USERNAME_1 = "deptWork.userName LIKE NULL";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 = "deptWork.userName LIKE ?";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 = "(deptWork.userName IS NULL OR deptWork.userName LIKE '')";

	public DeptWorkPersistenceImpl() {
		setModelClass(DeptWork.class);
	}

	/**
	 * Caches the dept work in the entity cache if it is enabled.
	 *
	 * @param deptWork the dept work
	 */
	@Override
	public void cacheResult(DeptWork deptWork) {
		EntityCacheUtil.putResult(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkImpl.class, deptWork.getPrimaryKey(), deptWork);

		deptWork.resetOriginalValues();
	}

	/**
	 * Caches the dept works in the entity cache if it is enabled.
	 *
	 * @param deptWorks the dept works
	 */
	@Override
	public void cacheResult(List<DeptWork> deptWorks) {
		for (DeptWork deptWork : deptWorks) {
			if (EntityCacheUtil.getResult(
						DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
						DeptWorkImpl.class, deptWork.getPrimaryKey()) == null) {
				cacheResult(deptWork);
			}
			else {
				deptWork.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dept works.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DeptWorkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DeptWorkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dept work.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeptWork deptWork) {
		EntityCacheUtil.removeResult(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkImpl.class, deptWork.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DeptWork> deptWorks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DeptWork deptWork : deptWorks) {
			EntityCacheUtil.removeResult(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
				DeptWorkImpl.class, deptWork.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dept work with the primary key. Does not add the dept work to the database.
	 *
	 * @param deptWorkId the primary key for the new dept work
	 * @return the new dept work
	 */
	@Override
	public DeptWork create(long deptWorkId) {
		DeptWork deptWork = new DeptWorkImpl();

		deptWork.setNew(true);
		deptWork.setPrimaryKey(deptWorkId);

		return deptWork;
	}

	/**
	 * Removes the dept work with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deptWorkId the primary key of the dept work
	 * @return the dept work that was removed
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork remove(long deptWorkId)
		throws NoSuchDeptWorkException, SystemException {
		return remove((Serializable)deptWorkId);
	}

	/**
	 * Removes the dept work with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dept work
	 * @return the dept work that was removed
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork remove(Serializable primaryKey)
		throws NoSuchDeptWorkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DeptWork deptWork = (DeptWork)session.get(DeptWorkImpl.class,
					primaryKey);

			if (deptWork == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeptWorkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(deptWork);
		}
		catch (NoSuchDeptWorkException nsee) {
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
	protected DeptWork removeImpl(DeptWork deptWork) throws SystemException {
		deptWork = toUnwrappedModel(deptWork);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(deptWork)) {
				deptWork = (DeptWork)session.get(DeptWorkImpl.class,
						deptWork.getPrimaryKeyObj());
			}

			if (deptWork != null) {
				session.delete(deptWork);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (deptWork != null) {
			clearCache(deptWork);
		}

		return deptWork;
	}

	@Override
	public DeptWork updateImpl(com.justonetech.oa.model.DeptWork deptWork)
		throws SystemException {
		deptWork = toUnwrappedModel(deptWork);

		boolean isNew = deptWork.isNew();

		Session session = null;

		try {
			session = openSession();

			if (deptWork.isNew()) {
				session.save(deptWork);

				deptWork.setNew(false);
			}
			else {
				session.merge(deptWork);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DeptWorkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
			DeptWorkImpl.class, deptWork.getPrimaryKey(), deptWork);

		return deptWork;
	}

	protected DeptWork toUnwrappedModel(DeptWork deptWork) {
		if (deptWork instanceof DeptWorkImpl) {
			return deptWork;
		}

		DeptWorkImpl deptWorkImpl = new DeptWorkImpl();

		deptWorkImpl.setNew(deptWork.isNew());
		deptWorkImpl.setPrimaryKey(deptWork.getPrimaryKey());

		deptWorkImpl.setDeptWorkId(deptWork.getDeptWorkId());
		deptWorkImpl.setGroupId(deptWork.getGroupId());
		deptWorkImpl.setCompanyId(deptWork.getCompanyId());
		deptWorkImpl.setUserId(deptWork.getUserId());
		deptWorkImpl.setUserName(deptWork.getUserName());
		deptWorkImpl.setCreateTime(deptWork.getCreateTime());
		deptWorkImpl.setModifiedTime(deptWork.getModifiedTime());
		deptWorkImpl.setDeptId(deptWork.getDeptId());
		deptWorkImpl.setDeptName(deptWork.getDeptName());
		deptWorkImpl.setStartDate(deptWork.getStartDate());
		deptWorkImpl.setEndDate(deptWork.getEndDate());
		deptWorkImpl.setStatus(deptWork.getStatus());

		return deptWorkImpl;
	}

	/**
	 * Returns the dept work with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dept work
	 * @return the dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeptWorkException, SystemException {
		DeptWork deptWork = fetchByPrimaryKey(primaryKey);

		if (deptWork == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeptWorkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return deptWork;
	}

	/**
	 * Returns the dept work with the primary key or throws a {@link com.justonetech.oa.NoSuchDeptWorkException} if it could not be found.
	 *
	 * @param deptWorkId the primary key of the dept work
	 * @return the dept work
	 * @throws com.justonetech.oa.NoSuchDeptWorkException if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork findByPrimaryKey(long deptWorkId)
		throws NoSuchDeptWorkException, SystemException {
		return findByPrimaryKey((Serializable)deptWorkId);
	}

	/**
	 * Returns the dept work with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dept work
	 * @return the dept work, or <code>null</code> if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DeptWork deptWork = (DeptWork)EntityCacheUtil.getResult(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
				DeptWorkImpl.class, primaryKey);

		if (deptWork == _nullDeptWork) {
			return null;
		}

		if (deptWork == null) {
			Session session = null;

			try {
				session = openSession();

				deptWork = (DeptWork)session.get(DeptWorkImpl.class, primaryKey);

				if (deptWork != null) {
					cacheResult(deptWork);
				}
				else {
					EntityCacheUtil.putResult(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
						DeptWorkImpl.class, primaryKey, _nullDeptWork);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DeptWorkModelImpl.ENTITY_CACHE_ENABLED,
					DeptWorkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return deptWork;
	}

	/**
	 * Returns the dept work with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deptWorkId the primary key of the dept work
	 * @return the dept work, or <code>null</code> if a dept work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeptWork fetchByPrimaryKey(long deptWorkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)deptWorkId);
	}

	/**
	 * Returns all the dept works.
	 *
	 * @return the dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dept works.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dept works
	 * @param end the upper bound of the range of dept works (not inclusive)
	 * @return the range of dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dept works.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.DeptWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dept works
	 * @param end the upper bound of the range of dept works (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dept works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeptWork> findAll(int start, int end,
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

		List<DeptWork> list = (List<DeptWork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPTWORK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPTWORK;

				if (pagination) {
					sql = sql.concat(DeptWorkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DeptWork>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeptWork>(list);
				}
				else {
					list = (List<DeptWork>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dept works from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DeptWork deptWork : findAll()) {
			remove(deptWork);
		}
	}

	/**
	 * Returns the number of dept works.
	 *
	 * @return the number of dept works
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

				Query q = session.createQuery(_SQL_COUNT_DEPTWORK);

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
	 * Initializes the dept work persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.DeptWork")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DeptWork>> listenersList = new ArrayList<ModelListener<DeptWork>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DeptWork>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DeptWorkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEPTWORK = "SELECT deptWork FROM DeptWork deptWork";
	private static final String _SQL_SELECT_DEPTWORK_WHERE = "SELECT deptWork FROM DeptWork deptWork WHERE ";
	private static final String _SQL_COUNT_DEPTWORK = "SELECT COUNT(deptWork) FROM DeptWork deptWork";
	private static final String _SQL_COUNT_DEPTWORK_WHERE = "SELECT COUNT(deptWork) FROM DeptWork deptWork WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "deptWork.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DeptWork exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DeptWork exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DeptWorkPersistenceImpl.class);
	private static DeptWork _nullDeptWork = new DeptWorkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DeptWork> toCacheModel() {
				return _nullDeptWorkCacheModel;
			}
		};

	private static CacheModel<DeptWork> _nullDeptWorkCacheModel = new CacheModel<DeptWork>() {
			@Override
			public DeptWork toEntityModel() {
				return _nullDeptWork;
			}
		};
}