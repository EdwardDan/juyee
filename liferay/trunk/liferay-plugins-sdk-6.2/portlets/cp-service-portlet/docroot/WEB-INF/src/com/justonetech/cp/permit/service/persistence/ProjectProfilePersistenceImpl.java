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

import com.justonetech.cp.permit.NoSuchProjectProfileException;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.model.impl.ProjectProfileImpl;
import com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the project profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ProjectProfilePersistence
 * @see ProjectProfileUtil
 * @generated
 */
public class ProjectProfilePersistenceImpl extends BasePersistenceImpl<ProjectProfile>
	implements ProjectProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProjectProfileUtil} to access the project profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProjectProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProjectProfileModelImpl.FINDER_CACHE_ENABLED,
			ProjectProfileImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProjectProfileModelImpl.FINDER_CACHE_ENABLED,
			ProjectProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProjectProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ProjectProfilePersistenceImpl() {
		setModelClass(ProjectProfile.class);
	}

	/**
	 * Caches the project profile in the entity cache if it is enabled.
	 *
	 * @param projectProfile the project profile
	 */
	@Override
	public void cacheResult(ProjectProfile projectProfile) {
		EntityCacheUtil.putResult(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProjectProfileImpl.class, projectProfile.getPrimaryKey(),
			projectProfile);

		projectProfile.resetOriginalValues();
	}

	/**
	 * Caches the project profiles in the entity cache if it is enabled.
	 *
	 * @param projectProfiles the project profiles
	 */
	@Override
	public void cacheResult(List<ProjectProfile> projectProfiles) {
		for (ProjectProfile projectProfile : projectProfiles) {
			if (EntityCacheUtil.getResult(
						ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
						ProjectProfileImpl.class, projectProfile.getPrimaryKey()) == null) {
				cacheResult(projectProfile);
			}
			else {
				projectProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project profiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProjectProfileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProjectProfileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project profile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectProfile projectProfile) {
		EntityCacheUtil.removeResult(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProjectProfileImpl.class, projectProfile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProjectProfile> projectProfiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectProfile projectProfile : projectProfiles) {
			EntityCacheUtil.removeResult(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
				ProjectProfileImpl.class, projectProfile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new project profile with the primary key. Does not add the project profile to the database.
	 *
	 * @param permitId the primary key for the new project profile
	 * @return the new project profile
	 */
	@Override
	public ProjectProfile create(long permitId) {
		ProjectProfile projectProfile = new ProjectProfileImpl();

		projectProfile.setNew(true);
		projectProfile.setPrimaryKey(permitId);

		return projectProfile;
	}

	/**
	 * Removes the project profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permitId the primary key of the project profile
	 * @return the project profile that was removed
	 * @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectProfile remove(long permitId)
		throws NoSuchProjectProfileException, SystemException {
		return remove((Serializable)permitId);
	}

	/**
	 * Removes the project profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project profile
	 * @return the project profile that was removed
	 * @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectProfile remove(Serializable primaryKey)
		throws NoSuchProjectProfileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProjectProfile projectProfile = (ProjectProfile)session.get(ProjectProfileImpl.class,
					primaryKey);

			if (projectProfile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(projectProfile);
		}
		catch (NoSuchProjectProfileException nsee) {
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
	protected ProjectProfile removeImpl(ProjectProfile projectProfile)
		throws SystemException {
		projectProfile = toUnwrappedModel(projectProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectProfile)) {
				projectProfile = (ProjectProfile)session.get(ProjectProfileImpl.class,
						projectProfile.getPrimaryKeyObj());
			}

			if (projectProfile != null) {
				session.delete(projectProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (projectProfile != null) {
			clearCache(projectProfile);
		}

		return projectProfile;
	}

	@Override
	public ProjectProfile updateImpl(
		com.justonetech.cp.permit.model.ProjectProfile projectProfile)
		throws SystemException {
		projectProfile = toUnwrappedModel(projectProfile);

		boolean isNew = projectProfile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (projectProfile.isNew()) {
				session.save(projectProfile);

				projectProfile.setNew(false);
			}
			else {
				session.merge(projectProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			ProjectProfileImpl.class, projectProfile.getPrimaryKey(),
			projectProfile);

		return projectProfile;
	}

	protected ProjectProfile toUnwrappedModel(ProjectProfile projectProfile) {
		if (projectProfile instanceof ProjectProfileImpl) {
			return projectProfile;
		}

		ProjectProfileImpl projectProfileImpl = new ProjectProfileImpl();

		projectProfileImpl.setNew(projectProfile.isNew());
		projectProfileImpl.setPrimaryKey(projectProfile.getPrimaryKey());

		projectProfileImpl.setPermitId(projectProfile.getPermitId());
		projectProfileImpl.setBjbh(projectProfile.getBjbh());
		projectProfileImpl.setJsdwmc(projectProfile.getJsdwmc());
		projectProfileImpl.setJsdwxz(projectProfile.getJsdwxz());
		projectProfileImpl.setJsdwdz(projectProfile.getJsdwdz());
		projectProfileImpl.setGcmc(projectProfile.getGcmc());
		projectProfileImpl.setJsdd(projectProfile.getJsdd());
		projectProfileImpl.setJsgcgm(projectProfile.getJsgcgm());
		projectProfileImpl.setFwjzmj(projectProfile.getFwjzmj());
		projectProfileImpl.setHtjg(projectProfile.getHtjg());
		projectProfileImpl.setHtgq(projectProfile.getHtgq());
		projectProfileImpl.setFddbr(projectProfile.getFddbr());
		projectProfileImpl.setJsdwlxdh(projectProfile.getJsdwlxdh());
		projectProfileImpl.setJsdwlxr(projectProfile.getJsdwlxr());
		projectProfileImpl.setJsdwsjh(projectProfile.getJsdwsjh());
		projectProfileImpl.setJsydpzwjhfdccqzbh(projectProfile.getJsydpzwjhfdccqzbh());
		projectProfileImpl.setJsgcghxkzbh(projectProfile.getJsgcghxkzbh());
		projectProfileImpl.setXckgqk(projectProfile.getXckgqk());

		return projectProfileImpl;
	}

	/**
	 * Returns the project profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the project profile
	 * @return the project profile
	 * @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectProfileException, SystemException {
		ProjectProfile projectProfile = fetchByPrimaryKey(primaryKey);

		if (projectProfile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return projectProfile;
	}

	/**
	 * Returns the project profile with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchProjectProfileException} if it could not be found.
	 *
	 * @param permitId the primary key of the project profile
	 * @return the project profile
	 * @throws com.justonetech.cp.permit.NoSuchProjectProfileException if a project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectProfile findByPrimaryKey(long permitId)
		throws NoSuchProjectProfileException, SystemException {
		return findByPrimaryKey((Serializable)permitId);
	}

	/**
	 * Returns the project profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project profile
	 * @return the project profile, or <code>null</code> if a project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectProfile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ProjectProfile projectProfile = (ProjectProfile)EntityCacheUtil.getResult(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
				ProjectProfileImpl.class, primaryKey);

		if (projectProfile == _nullProjectProfile) {
			return null;
		}

		if (projectProfile == null) {
			Session session = null;

			try {
				session = openSession();

				projectProfile = (ProjectProfile)session.get(ProjectProfileImpl.class,
						primaryKey);

				if (projectProfile != null) {
					cacheResult(projectProfile);
				}
				else {
					EntityCacheUtil.putResult(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
						ProjectProfileImpl.class, primaryKey,
						_nullProjectProfile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
					ProjectProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return projectProfile;
	}

	/**
	 * Returns the project profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permitId the primary key of the project profile
	 * @return the project profile, or <code>null</code> if a project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProjectProfile fetchByPrimaryKey(long permitId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)permitId);
	}

	/**
	 * Returns all the project profiles.
	 *
	 * @return the project profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectProfile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the project profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project profiles
	 * @param end the upper bound of the range of project profiles (not inclusive)
	 * @return the range of project profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectProfile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the project profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of project profiles
	 * @param end the upper bound of the range of project profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ProjectProfile> findAll(int start, int end,
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

		List<ProjectProfile> list = (List<ProjectProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROJECTPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTPROFILE;

				if (pagination) {
					sql = sql.concat(ProjectProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ProjectProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ProjectProfile>(list);
				}
				else {
					list = (List<ProjectProfile>)QueryUtil.list(q,
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
	 * Removes all the project profiles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ProjectProfile projectProfile : findAll()) {
			remove(projectProfile);
		}
	}

	/**
	 * Returns the number of project profiles.
	 *
	 * @return the number of project profiles
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

				Query q = session.createQuery(_SQL_COUNT_PROJECTPROFILE);

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
	 * Initializes the project profile persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.permit.model.ProjectProfile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProjectProfile>> listenersList = new ArrayList<ModelListener<ProjectProfile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProjectProfile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProjectProfileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROJECTPROFILE = "SELECT projectProfile FROM ProjectProfile projectProfile";
	private static final String _SQL_COUNT_PROJECTPROFILE = "SELECT COUNT(projectProfile) FROM ProjectProfile projectProfile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "projectProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProjectProfile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProjectProfilePersistenceImpl.class);
	private static ProjectProfile _nullProjectProfile = new ProjectProfileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProjectProfile> toCacheModel() {
				return _nullProjectProfileCacheModel;
			}
		};

	private static CacheModel<ProjectProfile> _nullProjectProfileCacheModel = new CacheModel<ProjectProfile>() {
			@Override
			public ProjectProfile toEntityModel() {
				return _nullProjectProfile;
			}
		};
}