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

package com.justonetech.cp.complete.service.persistence;

import com.justonetech.cp.complete.NoSuchCompleteUnitProjectException;
import com.justonetech.cp.complete.model.CompleteUnitProject;
import com.justonetech.cp.complete.model.impl.CompleteUnitProjectImpl;
import com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl;

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
 * The persistence implementation for the complete unit project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompleteUnitProjectPersistence
 * @see CompleteUnitProjectUtil
 * @generated
 */
public class CompleteUnitProjectPersistenceImpl extends BasePersistenceImpl<CompleteUnitProject>
	implements CompleteUnitProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompleteUnitProjectUtil} to access the complete unit project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompleteUnitProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectModelImpl.FINDER_CACHE_ENABLED,
			CompleteUnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectModelImpl.FINDER_CACHE_ENABLED,
			CompleteUnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLETEID =
		new FinderPath(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectModelImpl.FINDER_CACHE_ENABLED,
			CompleteUnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompleteId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID =
		new FinderPath(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectModelImpl.FINDER_CACHE_ENABLED,
			CompleteUnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompleteId",
			new String[] { Long.class.getName() },
			CompleteUnitProjectModelImpl.COMPLETEID_COLUMN_BITMASK |
			CompleteUnitProjectModelImpl.GCBH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPLETEID = new FinderPath(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompleteId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the complete unit projects where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @return the matching complete unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteUnitProject> findByCompleteId(long completeId)
		throws SystemException {
		return findByCompleteId(completeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complete unit projects where completeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param completeId the complete ID
	 * @param start the lower bound of the range of complete unit projects
	 * @param end the upper bound of the range of complete unit projects (not inclusive)
	 * @return the range of matching complete unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteUnitProject> findByCompleteId(long completeId,
		int start, int end) throws SystemException {
		return findByCompleteId(completeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complete unit projects where completeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param completeId the complete ID
	 * @param start the lower bound of the range of complete unit projects
	 * @param end the upper bound of the range of complete unit projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complete unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteUnitProject> findByCompleteId(long completeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID;
			finderArgs = new Object[] { completeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLETEID;
			finderArgs = new Object[] { completeId, start, end, orderByComparator };
		}

		List<CompleteUnitProject> list = (List<CompleteUnitProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CompleteUnitProject completeUnitProject : list) {
				if ((completeId != completeUnitProject.getCompleteId())) {
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

			query.append(_SQL_SELECT_COMPLETEUNITPROJECT_WHERE);

			query.append(_FINDER_COLUMN_COMPLETEID_COMPLETEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompleteUnitProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(completeId);

				if (!pagination) {
					list = (List<CompleteUnitProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompleteUnitProject>(list);
				}
				else {
					list = (List<CompleteUnitProject>)QueryUtil.list(q,
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
	 * Returns the first complete unit project in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complete unit project
	 * @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a matching complete unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject findByCompleteId_First(long completeId,
		OrderByComparator orderByComparator)
		throws NoSuchCompleteUnitProjectException, SystemException {
		CompleteUnitProject completeUnitProject = fetchByCompleteId_First(completeId,
				orderByComparator);

		if (completeUnitProject != null) {
			return completeUnitProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("completeId=");
		msg.append(completeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompleteUnitProjectException(msg.toString());
	}

	/**
	 * Returns the first complete unit project in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complete unit project, or <code>null</code> if a matching complete unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject fetchByCompleteId_First(long completeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CompleteUnitProject> list = findByCompleteId(completeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complete unit project in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complete unit project
	 * @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a matching complete unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject findByCompleteId_Last(long completeId,
		OrderByComparator orderByComparator)
		throws NoSuchCompleteUnitProjectException, SystemException {
		CompleteUnitProject completeUnitProject = fetchByCompleteId_Last(completeId,
				orderByComparator);

		if (completeUnitProject != null) {
			return completeUnitProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("completeId=");
		msg.append(completeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompleteUnitProjectException(msg.toString());
	}

	/**
	 * Returns the last complete unit project in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complete unit project, or <code>null</code> if a matching complete unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject fetchByCompleteId_Last(long completeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompleteId(completeId);

		if (count == 0) {
			return null;
		}

		List<CompleteUnitProject> list = findByCompleteId(completeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complete unit projects before and after the current complete unit project in the ordered set where completeId = &#63;.
	 *
	 * @param projectId the primary key of the current complete unit project
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complete unit project
	 * @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject[] findByCompleteId_PrevAndNext(long projectId,
		long completeId, OrderByComparator orderByComparator)
		throws NoSuchCompleteUnitProjectException, SystemException {
		CompleteUnitProject completeUnitProject = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			CompleteUnitProject[] array = new CompleteUnitProjectImpl[3];

			array[0] = getByCompleteId_PrevAndNext(session,
					completeUnitProject, completeId, orderByComparator, true);

			array[1] = completeUnitProject;

			array[2] = getByCompleteId_PrevAndNext(session,
					completeUnitProject, completeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CompleteUnitProject getByCompleteId_PrevAndNext(Session session,
		CompleteUnitProject completeUnitProject, long completeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLETEUNITPROJECT_WHERE);

		query.append(_FINDER_COLUMN_COMPLETEID_COMPLETEID_2);

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
			query.append(CompleteUnitProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(completeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(completeUnitProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CompleteUnitProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the complete unit projects where completeId = &#63; from the database.
	 *
	 * @param completeId the complete ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompleteId(long completeId) throws SystemException {
		for (CompleteUnitProject completeUnitProject : findByCompleteId(
				completeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(completeUnitProject);
		}
	}

	/**
	 * Returns the number of complete unit projects where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @return the number of matching complete unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompleteId(long completeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPLETEID;

		Object[] finderArgs = new Object[] { completeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLETEUNITPROJECT_WHERE);

			query.append(_FINDER_COLUMN_COMPLETEID_COMPLETEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(completeId);

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

	private static final String _FINDER_COLUMN_COMPLETEID_COMPLETEID_2 = "completeUnitProject.completeId = ?";

	public CompleteUnitProjectPersistenceImpl() {
		setModelClass(CompleteUnitProject.class);
	}

	/**
	 * Caches the complete unit project in the entity cache if it is enabled.
	 *
	 * @param completeUnitProject the complete unit project
	 */
	@Override
	public void cacheResult(CompleteUnitProject completeUnitProject) {
		EntityCacheUtil.putResult(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectImpl.class, completeUnitProject.getPrimaryKey(),
			completeUnitProject);

		completeUnitProject.resetOriginalValues();
	}

	/**
	 * Caches the complete unit projects in the entity cache if it is enabled.
	 *
	 * @param completeUnitProjects the complete unit projects
	 */
	@Override
	public void cacheResult(List<CompleteUnitProject> completeUnitProjects) {
		for (CompleteUnitProject completeUnitProject : completeUnitProjects) {
			if (EntityCacheUtil.getResult(
						CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
						CompleteUnitProjectImpl.class,
						completeUnitProject.getPrimaryKey()) == null) {
				cacheResult(completeUnitProject);
			}
			else {
				completeUnitProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all complete unit projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CompleteUnitProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CompleteUnitProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complete unit project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompleteUnitProject completeUnitProject) {
		EntityCacheUtil.removeResult(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectImpl.class, completeUnitProject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CompleteUnitProject> completeUnitProjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CompleteUnitProject completeUnitProject : completeUnitProjects) {
			EntityCacheUtil.removeResult(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
				CompleteUnitProjectImpl.class,
				completeUnitProject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complete unit project with the primary key. Does not add the complete unit project to the database.
	 *
	 * @param projectId the primary key for the new complete unit project
	 * @return the new complete unit project
	 */
	@Override
	public CompleteUnitProject create(long projectId) {
		CompleteUnitProject completeUnitProject = new CompleteUnitProjectImpl();

		completeUnitProject.setNew(true);
		completeUnitProject.setPrimaryKey(projectId);

		return completeUnitProject;
	}

	/**
	 * Removes the complete unit project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the complete unit project
	 * @return the complete unit project that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject remove(long projectId)
		throws NoSuchCompleteUnitProjectException, SystemException {
		return remove((Serializable)projectId);
	}

	/**
	 * Removes the complete unit project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complete unit project
	 * @return the complete unit project that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject remove(Serializable primaryKey)
		throws NoSuchCompleteUnitProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CompleteUnitProject completeUnitProject = (CompleteUnitProject)session.get(CompleteUnitProjectImpl.class,
					primaryKey);

			if (completeUnitProject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompleteUnitProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(completeUnitProject);
		}
		catch (NoSuchCompleteUnitProjectException nsee) {
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
	protected CompleteUnitProject removeImpl(
		CompleteUnitProject completeUnitProject) throws SystemException {
		completeUnitProject = toUnwrappedModel(completeUnitProject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(completeUnitProject)) {
				completeUnitProject = (CompleteUnitProject)session.get(CompleteUnitProjectImpl.class,
						completeUnitProject.getPrimaryKeyObj());
			}

			if (completeUnitProject != null) {
				session.delete(completeUnitProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (completeUnitProject != null) {
			clearCache(completeUnitProject);
		}

		return completeUnitProject;
	}

	@Override
	public CompleteUnitProject updateImpl(
		com.justonetech.cp.complete.model.CompleteUnitProject completeUnitProject)
		throws SystemException {
		completeUnitProject = toUnwrappedModel(completeUnitProject);

		boolean isNew = completeUnitProject.isNew();

		CompleteUnitProjectModelImpl completeUnitProjectModelImpl = (CompleteUnitProjectModelImpl)completeUnitProject;

		Session session = null;

		try {
			session = openSession();

			if (completeUnitProject.isNew()) {
				session.save(completeUnitProject);

				completeUnitProject.setNew(false);
			}
			else {
				session.merge(completeUnitProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CompleteUnitProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((completeUnitProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						completeUnitProjectModelImpl.getOriginalCompleteId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLETEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID,
					args);

				args = new Object[] { completeUnitProjectModelImpl.getCompleteId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLETEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID,
					args);
			}
		}

		EntityCacheUtil.putResult(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			CompleteUnitProjectImpl.class, completeUnitProject.getPrimaryKey(),
			completeUnitProject);

		return completeUnitProject;
	}

	protected CompleteUnitProject toUnwrappedModel(
		CompleteUnitProject completeUnitProject) {
		if (completeUnitProject instanceof CompleteUnitProjectImpl) {
			return completeUnitProject;
		}

		CompleteUnitProjectImpl completeUnitProjectImpl = new CompleteUnitProjectImpl();

		completeUnitProjectImpl.setNew(completeUnitProject.isNew());
		completeUnitProjectImpl.setPrimaryKey(completeUnitProject.getPrimaryKey());

		completeUnitProjectImpl.setProjectId(completeUnitProject.getProjectId());
		completeUnitProjectImpl.setCompleteId(completeUnitProject.getCompleteId());
		completeUnitProjectImpl.setBjbh(completeUnitProject.getBjbh());
		completeUnitProjectImpl.setSgxkzbh(completeUnitProject.getSgxkzbh());
		completeUnitProjectImpl.setGcbh(completeUnitProject.getGcbh());
		completeUnitProjectImpl.setGcmc(completeUnitProject.getGcmc());
		completeUnitProjectImpl.setJsnr(completeUnitProject.getJsnr());

		return completeUnitProjectImpl;
	}

	/**
	 * Returns the complete unit project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete unit project
	 * @return the complete unit project
	 * @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompleteUnitProjectException, SystemException {
		CompleteUnitProject completeUnitProject = fetchByPrimaryKey(primaryKey);

		if (completeUnitProject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompleteUnitProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return completeUnitProject;
	}

	/**
	 * Returns the complete unit project with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteUnitProjectException} if it could not be found.
	 *
	 * @param projectId the primary key of the complete unit project
	 * @return the complete unit project
	 * @throws com.justonetech.cp.complete.NoSuchCompleteUnitProjectException if a complete unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject findByPrimaryKey(long projectId)
		throws NoSuchCompleteUnitProjectException, SystemException {
		return findByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns the complete unit project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete unit project
	 * @return the complete unit project, or <code>null</code> if a complete unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CompleteUnitProject completeUnitProject = (CompleteUnitProject)EntityCacheUtil.getResult(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
				CompleteUnitProjectImpl.class, primaryKey);

		if (completeUnitProject == _nullCompleteUnitProject) {
			return null;
		}

		if (completeUnitProject == null) {
			Session session = null;

			try {
				session = openSession();

				completeUnitProject = (CompleteUnitProject)session.get(CompleteUnitProjectImpl.class,
						primaryKey);

				if (completeUnitProject != null) {
					cacheResult(completeUnitProject);
				}
				else {
					EntityCacheUtil.putResult(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
						CompleteUnitProjectImpl.class, primaryKey,
						_nullCompleteUnitProject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CompleteUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
					CompleteUnitProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return completeUnitProject;
	}

	/**
	 * Returns the complete unit project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the complete unit project
	 * @return the complete unit project, or <code>null</code> if a complete unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteUnitProject fetchByPrimaryKey(long projectId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns all the complete unit projects.
	 *
	 * @return the complete unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteUnitProject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complete unit projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of complete unit projects
	 * @param end the upper bound of the range of complete unit projects (not inclusive)
	 * @return the range of complete unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteUnitProject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complete unit projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of complete unit projects
	 * @param end the upper bound of the range of complete unit projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complete unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteUnitProject> findAll(int start, int end,
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

		List<CompleteUnitProject> list = (List<CompleteUnitProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLETEUNITPROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLETEUNITPROJECT;

				if (pagination) {
					sql = sql.concat(CompleteUnitProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CompleteUnitProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompleteUnitProject>(list);
				}
				else {
					list = (List<CompleteUnitProject>)QueryUtil.list(q,
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
	 * Removes all the complete unit projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CompleteUnitProject completeUnitProject : findAll()) {
			remove(completeUnitProject);
		}
	}

	/**
	 * Returns the number of complete unit projects.
	 *
	 * @return the number of complete unit projects
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

				Query q = session.createQuery(_SQL_COUNT_COMPLETEUNITPROJECT);

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
	 * Initializes the complete unit project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.complete.model.CompleteUnitProject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CompleteUnitProject>> listenersList = new ArrayList<ModelListener<CompleteUnitProject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CompleteUnitProject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CompleteUnitProjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMPLETEUNITPROJECT = "SELECT completeUnitProject FROM CompleteUnitProject completeUnitProject";
	private static final String _SQL_SELECT_COMPLETEUNITPROJECT_WHERE = "SELECT completeUnitProject FROM CompleteUnitProject completeUnitProject WHERE ";
	private static final String _SQL_COUNT_COMPLETEUNITPROJECT = "SELECT COUNT(completeUnitProject) FROM CompleteUnitProject completeUnitProject";
	private static final String _SQL_COUNT_COMPLETEUNITPROJECT_WHERE = "SELECT COUNT(completeUnitProject) FROM CompleteUnitProject completeUnitProject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "completeUnitProject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CompleteUnitProject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CompleteUnitProject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CompleteUnitProjectPersistenceImpl.class);
	private static CompleteUnitProject _nullCompleteUnitProject = new CompleteUnitProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CompleteUnitProject> toCacheModel() {
				return _nullCompleteUnitProjectCacheModel;
			}
		};

	private static CacheModel<CompleteUnitProject> _nullCompleteUnitProjectCacheModel =
		new CacheModel<CompleteUnitProject>() {
			@Override
			public CompleteUnitProject toEntityModel() {
				return _nullCompleteUnitProject;
			}
		};
}