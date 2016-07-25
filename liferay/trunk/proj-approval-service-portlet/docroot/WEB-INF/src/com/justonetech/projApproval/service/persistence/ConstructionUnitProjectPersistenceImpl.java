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

import com.justonetech.projApproval.NoSuchConstructionUnitProjectException;
import com.justonetech.projApproval.model.ConstructionUnitProject;
import com.justonetech.projApproval.model.impl.ConstructionUnitProjectImpl;
import com.justonetech.projApproval.model.impl.ConstructionUnitProjectModelImpl;

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
 * The persistence implementation for the construction unit project service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see ConstructionUnitProjectPersistence
 * @see ConstructionUnitProjectUtil
 * @generated
 */
public class ConstructionUnitProjectPersistenceImpl extends BasePersistenceImpl<ConstructionUnitProject>
	implements ConstructionUnitProjectPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConstructionUnitProjectUtil} to access the construction unit project persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConstructionUnitProjectImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectModelImpl.FINDER_CACHE_ENABLED,
			ConstructionUnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectModelImpl.FINDER_CACHE_ENABLED,
			ConstructionUnitProjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID = new FinderPath(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectModelImpl.FINDER_CACHE_ENABLED,
			ConstructionUnitProjectImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByConstructionPermitId",
			new String[] { Long.class.getName() },
			ConstructionUnitProjectModelImpl.CONSTRUCTIONPERMITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID = new FinderPath(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConstructionPermitId", new String[] { Long.class.getName() });

	/**
	 * Returns the construction unit project where constructionPermitId = &#63; or throws a {@link com.justonetech.projApproval.NoSuchConstructionUnitProjectException} if it could not be found.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @return the matching construction unit project
	 * @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a matching construction unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject findByConstructionPermitId(
		long constructionPermitId)
		throws NoSuchConstructionUnitProjectException, SystemException {
		ConstructionUnitProject constructionUnitProject = fetchByConstructionPermitId(constructionPermitId);

		if (constructionUnitProject == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("constructionPermitId=");
			msg.append(constructionPermitId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchConstructionUnitProjectException(msg.toString());
		}

		return constructionUnitProject;
	}

	/**
	 * Returns the construction unit project where constructionPermitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @return the matching construction unit project, or <code>null</code> if a matching construction unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject fetchByConstructionPermitId(
		long constructionPermitId) throws SystemException {
		return fetchByConstructionPermitId(constructionPermitId, true);
	}

	/**
	 * Returns the construction unit project where constructionPermitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching construction unit project, or <code>null</code> if a matching construction unit project could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject fetchByConstructionPermitId(
		long constructionPermitId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { constructionPermitId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
					finderArgs, this);
		}

		if (result instanceof ConstructionUnitProject) {
			ConstructionUnitProject constructionUnitProject = (ConstructionUnitProject)result;

			if ((constructionPermitId != constructionUnitProject.getConstructionPermitId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONSTRUCTIONUNITPROJECT_WHERE);

			query.append(_FINDER_COLUMN_CONSTRUCTIONPERMITID_CONSTRUCTIONPERMITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(constructionPermitId);

				List<ConstructionUnitProject> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ConstructionUnitProjectPersistenceImpl.fetchByConstructionPermitId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ConstructionUnitProject constructionUnitProject = list.get(0);

					result = constructionUnitProject;

					cacheResult(constructionUnitProject);

					if ((constructionUnitProject.getConstructionPermitId() != constructionPermitId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
							finderArgs, constructionUnitProject);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ConstructionUnitProject)result;
		}
	}

	/**
	 * Removes the construction unit project where constructionPermitId = &#63; from the database.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @return the construction unit project that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject removeByConstructionPermitId(
		long constructionPermitId)
		throws NoSuchConstructionUnitProjectException, SystemException {
		ConstructionUnitProject constructionUnitProject = findByConstructionPermitId(constructionPermitId);

		return remove(constructionUnitProject);
	}

	/**
	 * Returns the number of construction unit projects where constructionPermitId = &#63;.
	 *
	 * @param constructionPermitId the construction permit ID
	 * @return the number of matching construction unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByConstructionPermitId(long constructionPermitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID;

		Object[] finderArgs = new Object[] { constructionPermitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONSTRUCTIONUNITPROJECT_WHERE);

			query.append(_FINDER_COLUMN_CONSTRUCTIONPERMITID_CONSTRUCTIONPERMITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(constructionPermitId);

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

	private static final String _FINDER_COLUMN_CONSTRUCTIONPERMITID_CONSTRUCTIONPERMITID_2 =
		"constructionUnitProject.constructionPermitId = ?";

	public ConstructionUnitProjectPersistenceImpl() {
		setModelClass(ConstructionUnitProject.class);
	}

	/**
	 * Caches the construction unit project in the entity cache if it is enabled.
	 *
	 * @param constructionUnitProject the construction unit project
	 */
	@Override
	public void cacheResult(ConstructionUnitProject constructionUnitProject) {
		EntityCacheUtil.putResult(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectImpl.class,
			constructionUnitProject.getPrimaryKey(), constructionUnitProject);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
			new Object[] { constructionUnitProject.getConstructionPermitId() },
			constructionUnitProject);

		constructionUnitProject.resetOriginalValues();
	}

	/**
	 * Caches the construction unit projects in the entity cache if it is enabled.
	 *
	 * @param constructionUnitProjects the construction unit projects
	 */
	@Override
	public void cacheResult(
		List<ConstructionUnitProject> constructionUnitProjects) {
		for (ConstructionUnitProject constructionUnitProject : constructionUnitProjects) {
			if (EntityCacheUtil.getResult(
						ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
						ConstructionUnitProjectImpl.class,
						constructionUnitProject.getPrimaryKey()) == null) {
				cacheResult(constructionUnitProject);
			}
			else {
				constructionUnitProject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all construction unit projects.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConstructionUnitProjectImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConstructionUnitProjectImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the construction unit project.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConstructionUnitProject constructionUnitProject) {
		EntityCacheUtil.removeResult(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectImpl.class,
			constructionUnitProject.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(constructionUnitProject);
	}

	@Override
	public void clearCache(
		List<ConstructionUnitProject> constructionUnitProjects) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConstructionUnitProject constructionUnitProject : constructionUnitProjects) {
			EntityCacheUtil.removeResult(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
				ConstructionUnitProjectImpl.class,
				constructionUnitProject.getPrimaryKey());

			clearUniqueFindersCache(constructionUnitProject);
		}
	}

	protected void cacheUniqueFindersCache(
		ConstructionUnitProject constructionUnitProject) {
		if (constructionUnitProject.isNew()) {
			Object[] args = new Object[] {
					constructionUnitProject.getConstructionPermitId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
				args, constructionUnitProject);
		}
		else {
			ConstructionUnitProjectModelImpl constructionUnitProjectModelImpl = (ConstructionUnitProjectModelImpl)constructionUnitProject;

			if ((constructionUnitProjectModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						constructionUnitProject.getConstructionPermitId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
					args, constructionUnitProject);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ConstructionUnitProject constructionUnitProject) {
		ConstructionUnitProjectModelImpl constructionUnitProjectModelImpl = (ConstructionUnitProjectModelImpl)constructionUnitProject;

		Object[] args = new Object[] {
				constructionUnitProject.getConstructionPermitId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
			args);

		if ((constructionUnitProjectModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID.getColumnBitmask()) != 0) {
			args = new Object[] {
					constructionUnitProjectModelImpl.getOriginalConstructionPermitId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONSTRUCTIONPERMITID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONSTRUCTIONPERMITID,
				args);
		}
	}

	/**
	 * Creates a new construction unit project with the primary key. Does not add the construction unit project to the database.
	 *
	 * @param constructionUnitProjectId the primary key for the new construction unit project
	 * @return the new construction unit project
	 */
	@Override
	public ConstructionUnitProject create(long constructionUnitProjectId) {
		ConstructionUnitProject constructionUnitProject = new ConstructionUnitProjectImpl();

		constructionUnitProject.setNew(true);
		constructionUnitProject.setPrimaryKey(constructionUnitProjectId);

		return constructionUnitProject;
	}

	/**
	 * Removes the construction unit project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param constructionUnitProjectId the primary key of the construction unit project
	 * @return the construction unit project that was removed
	 * @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject remove(long constructionUnitProjectId)
		throws NoSuchConstructionUnitProjectException, SystemException {
		return remove((Serializable)constructionUnitProjectId);
	}

	/**
	 * Removes the construction unit project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the construction unit project
	 * @return the construction unit project that was removed
	 * @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject remove(Serializable primaryKey)
		throws NoSuchConstructionUnitProjectException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConstructionUnitProject constructionUnitProject = (ConstructionUnitProject)session.get(ConstructionUnitProjectImpl.class,
					primaryKey);

			if (constructionUnitProject == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConstructionUnitProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(constructionUnitProject);
		}
		catch (NoSuchConstructionUnitProjectException nsee) {
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
	protected ConstructionUnitProject removeImpl(
		ConstructionUnitProject constructionUnitProject)
		throws SystemException {
		constructionUnitProject = toUnwrappedModel(constructionUnitProject);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(constructionUnitProject)) {
				constructionUnitProject = (ConstructionUnitProject)session.get(ConstructionUnitProjectImpl.class,
						constructionUnitProject.getPrimaryKeyObj());
			}

			if (constructionUnitProject != null) {
				session.delete(constructionUnitProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (constructionUnitProject != null) {
			clearCache(constructionUnitProject);
		}

		return constructionUnitProject;
	}

	@Override
	public ConstructionUnitProject updateImpl(
		com.justonetech.projApproval.model.ConstructionUnitProject constructionUnitProject)
		throws SystemException {
		constructionUnitProject = toUnwrappedModel(constructionUnitProject);

		boolean isNew = constructionUnitProject.isNew();

		Session session = null;

		try {
			session = openSession();

			if (constructionUnitProject.isNew()) {
				session.save(constructionUnitProject);

				constructionUnitProject.setNew(false);
			}
			else {
				session.merge(constructionUnitProject);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ConstructionUnitProjectModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
			ConstructionUnitProjectImpl.class,
			constructionUnitProject.getPrimaryKey(), constructionUnitProject);

		clearUniqueFindersCache(constructionUnitProject);
		cacheUniqueFindersCache(constructionUnitProject);

		return constructionUnitProject;
	}

	protected ConstructionUnitProject toUnwrappedModel(
		ConstructionUnitProject constructionUnitProject) {
		if (constructionUnitProject instanceof ConstructionUnitProjectImpl) {
			return constructionUnitProject;
		}

		ConstructionUnitProjectImpl constructionUnitProjectImpl = new ConstructionUnitProjectImpl();

		constructionUnitProjectImpl.setNew(constructionUnitProject.isNew());
		constructionUnitProjectImpl.setPrimaryKey(constructionUnitProject.getPrimaryKey());

		constructionUnitProjectImpl.setConstructionUnitProjectId(constructionUnitProject.getConstructionUnitProjectId());
		constructionUnitProjectImpl.setSortNo(constructionUnitProject.getSortNo());
		constructionUnitProjectImpl.setUnitProjectNum(constructionUnitProject.getUnitProjectNum());
		constructionUnitProjectImpl.setUnitProjectName(constructionUnitProject.getUnitProjectName());
		constructionUnitProjectImpl.setConstructionContent(constructionUnitProject.getConstructionContent());
		constructionUnitProjectImpl.setConstructionPermitId(constructionUnitProject.getConstructionPermitId());

		return constructionUnitProjectImpl;
	}

	/**
	 * Returns the construction unit project with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the construction unit project
	 * @return the construction unit project
	 * @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConstructionUnitProjectException, SystemException {
		ConstructionUnitProject constructionUnitProject = fetchByPrimaryKey(primaryKey);

		if (constructionUnitProject == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConstructionUnitProjectException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return constructionUnitProject;
	}

	/**
	 * Returns the construction unit project with the primary key or throws a {@link com.justonetech.projApproval.NoSuchConstructionUnitProjectException} if it could not be found.
	 *
	 * @param constructionUnitProjectId the primary key of the construction unit project
	 * @return the construction unit project
	 * @throws com.justonetech.projApproval.NoSuchConstructionUnitProjectException if a construction unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject findByPrimaryKey(
		long constructionUnitProjectId)
		throws NoSuchConstructionUnitProjectException, SystemException {
		return findByPrimaryKey((Serializable)constructionUnitProjectId);
	}

	/**
	 * Returns the construction unit project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the construction unit project
	 * @return the construction unit project, or <code>null</code> if a construction unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ConstructionUnitProject constructionUnitProject = (ConstructionUnitProject)EntityCacheUtil.getResult(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
				ConstructionUnitProjectImpl.class, primaryKey);

		if (constructionUnitProject == _nullConstructionUnitProject) {
			return null;
		}

		if (constructionUnitProject == null) {
			Session session = null;

			try {
				session = openSession();

				constructionUnitProject = (ConstructionUnitProject)session.get(ConstructionUnitProjectImpl.class,
						primaryKey);

				if (constructionUnitProject != null) {
					cacheResult(constructionUnitProject);
				}
				else {
					EntityCacheUtil.putResult(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
						ConstructionUnitProjectImpl.class, primaryKey,
						_nullConstructionUnitProject);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ConstructionUnitProjectModelImpl.ENTITY_CACHE_ENABLED,
					ConstructionUnitProjectImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return constructionUnitProject;
	}

	/**
	 * Returns the construction unit project with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param constructionUnitProjectId the primary key of the construction unit project
	 * @return the construction unit project, or <code>null</code> if a construction unit project with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionUnitProject fetchByPrimaryKey(
		long constructionUnitProjectId) throws SystemException {
		return fetchByPrimaryKey((Serializable)constructionUnitProjectId);
	}

	/**
	 * Returns all the construction unit projects.
	 *
	 * @return the construction unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionUnitProject> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the construction unit projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of construction unit projects
	 * @param end the upper bound of the range of construction unit projects (not inclusive)
	 * @return the range of construction unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionUnitProject> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the construction unit projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionUnitProjectModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of construction unit projects
	 * @param end the upper bound of the range of construction unit projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of construction unit projects
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionUnitProject> findAll(int start, int end,
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

		List<ConstructionUnitProject> list = (List<ConstructionUnitProject>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONSTRUCTIONUNITPROJECT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONSTRUCTIONUNITPROJECT;

				if (pagination) {
					sql = sql.concat(ConstructionUnitProjectModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ConstructionUnitProject>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ConstructionUnitProject>(list);
				}
				else {
					list = (List<ConstructionUnitProject>)QueryUtil.list(q,
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
	 * Removes all the construction unit projects from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ConstructionUnitProject constructionUnitProject : findAll()) {
			remove(constructionUnitProject);
		}
	}

	/**
	 * Returns the number of construction unit projects.
	 *
	 * @return the number of construction unit projects
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

				Query q = session.createQuery(_SQL_COUNT_CONSTRUCTIONUNITPROJECT);

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
	 * Initializes the construction unit project persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.projApproval.model.ConstructionUnitProject")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConstructionUnitProject>> listenersList = new ArrayList<ModelListener<ConstructionUnitProject>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConstructionUnitProject>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConstructionUnitProjectImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONSTRUCTIONUNITPROJECT = "SELECT constructionUnitProject FROM ConstructionUnitProject constructionUnitProject";
	private static final String _SQL_SELECT_CONSTRUCTIONUNITPROJECT_WHERE = "SELECT constructionUnitProject FROM ConstructionUnitProject constructionUnitProject WHERE ";
	private static final String _SQL_COUNT_CONSTRUCTIONUNITPROJECT = "SELECT COUNT(constructionUnitProject) FROM ConstructionUnitProject constructionUnitProject";
	private static final String _SQL_COUNT_CONSTRUCTIONUNITPROJECT_WHERE = "SELECT COUNT(constructionUnitProject) FROM ConstructionUnitProject constructionUnitProject WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "constructionUnitProject.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConstructionUnitProject exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ConstructionUnitProject exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConstructionUnitProjectPersistenceImpl.class);
	private static ConstructionUnitProject _nullConstructionUnitProject = new ConstructionUnitProjectImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConstructionUnitProject> toCacheModel() {
				return _nullConstructionUnitProjectCacheModel;
			}
		};

	private static CacheModel<ConstructionUnitProject> _nullConstructionUnitProjectCacheModel =
		new CacheModel<ConstructionUnitProject>() {
			@Override
			public ConstructionUnitProject toEntityModel() {
				return _nullConstructionUnitProject;
			}
		};
}