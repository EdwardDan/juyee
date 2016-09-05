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

package com.justonetech.cp.permit.service.persistence;

import com.justonetech.cp.permit.NoSuchUnitProjectException;
import com.justonetech.cp.permit.model.UnitProject;
import com.justonetech.cp.permit.model.impl.UnitProjectImpl;
import com.justonetech.cp.permit.model.impl.UnitProjectModelImpl;

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
 * The persistence implementation for the unit project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see UnitProjectPersistence
 * @see UnitProjectUtil
 * @generated
 */
public class UnitProjectPersistenceImpl extends BasePersistenceImpl<UnitProject>
	implements UnitProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UnitProjectUtil} to access the unit project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UnitProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectModelImpl.FINDER_CACHE_ENABLED, UnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectModelImpl.FINDER_CACHE_ENABLED, UnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMITID = new FinderPath(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectModelImpl.FINDER_CACHE_ENABLED, UnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPermitId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID =
		new FinderPath(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectModelImpl.FINDER_CACHE_ENABLED, UnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPermitId",
			new String[] { Long.class.getName() },
			UnitProjectModelImpl.PERMITID_COLUMN_BITMASK |
			UnitProjectModelImpl.GCBH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERMITID = new FinderPath(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPermitId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the unit projects where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @return the matching unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitProject> findByPermitId(long permitId)
		throws SystemException {
		return findByPermitId(permitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the unit projects where permitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param permitId the permit ID
	 * @param start the lower bound of the range of unit projects
	 * @param end the upper bound of the range of unit projects (not inclusive)
	 * @return the range of matching unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitProject> findByPermitId(long permitId, int start, int end)
		throws SystemException {
		return findByPermitId(permitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the unit projects where permitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param permitId the permit ID
	 * @param start the lower bound of the range of unit projects
	 * @param end the upper bound of the range of unit projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitProject> findByPermitId(long permitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID;
			finderArgs = new Object[] { permitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMITID;
			finderArgs = new Object[] { permitId, start, end, orderByComparator };
		}

		List<UnitProject> list = (List<UnitProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UnitProject unitProject : list) {
				if ((permitId != unitProject.getPermitId())) {
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

			query.append(_SQL_SELECT_UNITPROJECT_WHERE);

			query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UnitProjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permitId);

				if (!pagination) {
					list = (List<UnitProject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UnitProject>(list);
				}
				else {
					list = (List<UnitProject>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first unit project in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unit project
	 * @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a matching unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject findByPermitId_First(long permitId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitProjectException, SystemException {
		UnitProject unitProject = fetchByPermitId_First(permitId,
				orderByComparator);

		if (unitProject != null) {
			return unitProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permitId=");
		msg.append(permitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitProjectException(msg.toString());
	}

	/**
	 * Returns the first unit project in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unit project, or <code>null</code> if a matching unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject fetchByPermitId_First(long permitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UnitProject> list = findByPermitId(permitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last unit project in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unit project
	 * @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a matching unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject findByPermitId_Last(long permitId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitProjectException, SystemException {
		UnitProject unitProject = fetchByPermitId_Last(permitId,
				orderByComparator);

		if (unitProject != null) {
			return unitProject;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permitId=");
		msg.append(permitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitProjectException(msg.toString());
	}

	/**
	 * Returns the last unit project in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unit project, or <code>null</code> if a matching unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject fetchByPermitId_Last(long permitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPermitId(permitId);

		if (count == 0) {
			return null;
		}

		List<UnitProject> list = findByPermitId(permitId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the unit projects before and after the current unit project in the ordered set where permitId = &#63;.
	 *
	 * @param projectId the primary key of the current unit project
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next unit project
	 * @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject[] findByPermitId_PrevAndNext(long projectId,
		long permitId, OrderByComparator orderByComparator)
		throws NoSuchUnitProjectException, SystemException {
		UnitProject unitProject = findByPrimaryKey(projectId);

		Session session = null;

		try {
			session = openSession();

			UnitProject[] array = new UnitProjectImpl[3];

			array[0] = getByPermitId_PrevAndNext(session, unitProject,
					permitId, orderByComparator, true);

			array[1] = unitProject;

			array[2] = getByPermitId_PrevAndNext(session, unitProject,
					permitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UnitProject getByPermitId_PrevAndNext(Session session,
		UnitProject unitProject, long permitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UNITPROJECT_WHERE);

		query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);

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
			query.append(UnitProjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(permitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(unitProject);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UnitProject> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the unit projects where permitId = &#63; from the database.
	 *
	 * @param permitId the permit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPermitId(long permitId) throws SystemException {
		for (UnitProject unitProject : findByPermitId(permitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(unitProject);
		}
	}

	/**
	 * Returns the number of unit projects where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @return the number of matching unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPermitId(long permitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERMITID;

		Object[] finderArgs = new Object[] { permitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UNITPROJECT_WHERE);

			query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permitId);

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

	private static final String _FINDER_COLUMN_PERMITID_PERMITID_2 = "unitProject.permitId = ?";

	public UnitProjectPersistenceImpl() {
		setModelClass(UnitProject.class);
	}

	/**
	 * Caches the unit project in the entity cache if it is enabled.
	 *
	 * @param unitProject the unit project
	 */
	@Override
	public void cacheResult(UnitProject unitProject) {
		EntityCacheUtil.putResult(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectImpl.class, unitProject.getPrimaryKey(), unitProject);

		unitProject.resetOriginalValues();
	}

	/**
	 * Caches the unit projects in the entity cache if it is enabled.
	 *
	 * @param unitProjects the unit projects
	 */
	@Override
	public void cacheResult(List<UnitProject> unitProjects) {
		for (UnitProject unitProject : unitProjects) {
			if (EntityCacheUtil.getResult(
						UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
						UnitProjectImpl.class, unitProject.getPrimaryKey()) == null) {
				cacheResult(unitProject);
			}
			else {
				unitProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all unit projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UnitProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UnitProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the unit project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UnitProject unitProject) {
		EntityCacheUtil.removeResult(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectImpl.class, unitProject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UnitProject> unitProjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UnitProject unitProject : unitProjects) {
			EntityCacheUtil.removeResult(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
				UnitProjectImpl.class, unitProject.getPrimaryKey());
		}
	}

	/**
	 * Creates a new unit project with the primary key. Does not add the unit project to the database.
	 *
	 * @param projectId the primary key for the new unit project
	 * @return the new unit project
	 */
	@Override
	public UnitProject create(long projectId) {
		UnitProject unitProject = new UnitProjectImpl();

		unitProject.setNew(true);
		unitProject.setPrimaryKey(projectId);

		return unitProject;
	}

	/**
	 * Removes the unit project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectId the primary key of the unit project
	 * @return the unit project that was removed
	 * @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject remove(long projectId)
		throws NoSuchUnitProjectException, SystemException {
		return remove((Serializable)projectId);
	}

	/**
	 * Removes the unit project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the unit project
	 * @return the unit project that was removed
	 * @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject remove(Serializable primaryKey)
		throws NoSuchUnitProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UnitProject unitProject = (UnitProject)session.get(UnitProjectImpl.class,
					primaryKey);

			if (unitProject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUnitProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(unitProject);
		}
		catch (NoSuchUnitProjectException nsee) {
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
	protected UnitProject removeImpl(UnitProject unitProject)
		throws SystemException {
		unitProject = toUnwrappedModel(unitProject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(unitProject)) {
				unitProject = (UnitProject)session.get(UnitProjectImpl.class,
						unitProject.getPrimaryKeyObj());
			}

			if (unitProject != null) {
				session.delete(unitProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (unitProject != null) {
			clearCache(unitProject);
		}

		return unitProject;
	}

	@Override
	public UnitProject updateImpl(
		com.justonetech.cp.permit.model.UnitProject unitProject)
		throws SystemException {
		unitProject = toUnwrappedModel(unitProject);

		boolean isNew = unitProject.isNew();

		UnitProjectModelImpl unitProjectModelImpl = (UnitProjectModelImpl)unitProject;

		Session session = null;

		try {
			session = openSession();

			if (unitProject.isNew()) {
				session.save(unitProject);

				unitProject.setNew(false);
			}
			else {
				session.merge(unitProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UnitProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((unitProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						unitProjectModelImpl.getOriginalPermitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMITID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID,
					args);

				args = new Object[] { unitProjectModelImpl.getPermitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMITID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID,
					args);
			}
		}

		EntityCacheUtil.putResult(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			UnitProjectImpl.class, unitProject.getPrimaryKey(), unitProject);

		return unitProject;
	}

	protected UnitProject toUnwrappedModel(UnitProject unitProject) {
		if (unitProject instanceof UnitProjectImpl) {
			return unitProject;
		}

		UnitProjectImpl unitProjectImpl = new UnitProjectImpl();

		unitProjectImpl.setNew(unitProject.isNew());
		unitProjectImpl.setPrimaryKey(unitProject.getPrimaryKey());

		unitProjectImpl.setProjectId(unitProject.getProjectId());
		unitProjectImpl.setPermitId(unitProject.getPermitId());
		unitProjectImpl.setBjbh(unitProject.getBjbh());
		unitProjectImpl.setGcbh(unitProject.getGcbh());
		unitProjectImpl.setGcmc(unitProject.getGcmc());
		unitProjectImpl.setJsnr(unitProject.getJsnr());

		return unitProjectImpl;
	}

	/**
	 * Returns the unit project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the unit project
	 * @return the unit project
	 * @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUnitProjectException, SystemException {
		UnitProject unitProject = fetchByPrimaryKey(primaryKey);

		if (unitProject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUnitProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return unitProject;
	}

	/**
	 * Returns the unit project with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchUnitProjectException} if it could not be found.
	 *
	 * @param projectId the primary key of the unit project
	 * @return the unit project
	 * @throws com.justonetech.cp.permit.NoSuchUnitProjectException if a unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject findByPrimaryKey(long projectId)
		throws NoSuchUnitProjectException, SystemException {
		return findByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns the unit project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the unit project
	 * @return the unit project, or <code>null</code> if a unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UnitProject unitProject = (UnitProject)EntityCacheUtil.getResult(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
				UnitProjectImpl.class, primaryKey);

		if (unitProject == _nullUnitProject) {
			return null;
		}

		if (unitProject == null) {
			Session session = null;

			try {
				session = openSession();

				unitProject = (UnitProject)session.get(UnitProjectImpl.class,
						primaryKey);

				if (unitProject != null) {
					cacheResult(unitProject);
				}
				else {
					EntityCacheUtil.putResult(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
						UnitProjectImpl.class, primaryKey, _nullUnitProject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UnitProjectModelImpl.ENTITY_CACHE_ENABLED,
					UnitProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return unitProject;
	}

	/**
	 * Returns the unit project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectId the primary key of the unit project
	 * @return the unit project, or <code>null</code> if a unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitProject fetchByPrimaryKey(long projectId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)projectId);
	}

	/**
	 * Returns all the unit projects.
	 *
	 * @return the unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitProject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the unit projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit projects
	 * @param end the upper bound of the range of unit projects (not inclusive)
	 * @return the range of unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitProject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the unit projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.UnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit projects
	 * @param end the upper bound of the range of unit projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitProject> findAll(int start, int end,
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

		List<UnitProject> list = (List<UnitProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UNITPROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNITPROJECT;

				if (pagination) {
					sql = sql.concat(UnitProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UnitProject>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UnitProject>(list);
				}
				else {
					list = (List<UnitProject>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the unit projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UnitProject unitProject : findAll()) {
			remove(unitProject);
		}
	}

	/**
	 * Returns the number of unit projects.
	 *
	 * @return the number of unit projects
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

				Query q = session.createQuery(_SQL_COUNT_UNITPROJECT);

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
	 * Initializes the unit project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.permit.model.UnitProject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UnitProject>> listenersList = new ArrayList<ModelListener<UnitProject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UnitProject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UnitProjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UNITPROJECT = "SELECT unitProject FROM UnitProject unitProject";
	private static final String _SQL_SELECT_UNITPROJECT_WHERE = "SELECT unitProject FROM UnitProject unitProject WHERE ";
	private static final String _SQL_COUNT_UNITPROJECT = "SELECT COUNT(unitProject) FROM UnitProject unitProject";
	private static final String _SQL_COUNT_UNITPROJECT_WHERE = "SELECT COUNT(unitProject) FROM UnitProject unitProject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "unitProject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UnitProject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UnitProject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UnitProjectPersistenceImpl.class);
	private static UnitProject _nullUnitProject = new UnitProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UnitProject> toCacheModel() {
				return _nullUnitProjectCacheModel;
			}
		};

	private static CacheModel<UnitProject> _nullUnitProjectCacheModel = new CacheModel<UnitProject>() {
			@Override
			public UnitProject toEntityModel() {
				return _nullUnitProject;
			}
		};
}