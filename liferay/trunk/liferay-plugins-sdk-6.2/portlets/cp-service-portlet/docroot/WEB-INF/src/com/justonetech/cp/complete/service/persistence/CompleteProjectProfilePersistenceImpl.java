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

import com.justonetech.cp.complete.NoSuchCompleteProjectProfileException;
import com.justonetech.cp.complete.model.CompleteProjectProfile;
import com.justonetech.cp.complete.model.impl.CompleteProjectProfileImpl;
import com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl;

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
 * The persistence implementation for the complete project profile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompleteProjectProfilePersistence
 * @see CompleteProjectProfileUtil
 * @generated
 */
public class CompleteProjectProfilePersistenceImpl extends BasePersistenceImpl<CompleteProjectProfile>
	implements CompleteProjectProfilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompleteProjectProfileUtil} to access the complete project profile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompleteProjectProfileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			CompleteProjectProfileModelImpl.FINDER_CACHE_ENABLED,
			CompleteProjectProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			CompleteProjectProfileModelImpl.FINDER_CACHE_ENABLED,
			CompleteProjectProfileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			CompleteProjectProfileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CompleteProjectProfilePersistenceImpl() {
		setModelClass(CompleteProjectProfile.class);
	}

	/**
	 * Caches the complete project profile in the entity cache if it is enabled.
	 *
	 * @param completeProjectProfile the complete project profile
	 */
	@Override
	public void cacheResult(CompleteProjectProfile completeProjectProfile) {
		EntityCacheUtil.putResult(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			CompleteProjectProfileImpl.class,
			completeProjectProfile.getPrimaryKey(), completeProjectProfile);

		completeProjectProfile.resetOriginalValues();
	}

	/**
	 * Caches the complete project profiles in the entity cache if it is enabled.
	 *
	 * @param completeProjectProfiles the complete project profiles
	 */
	@Override
	public void cacheResult(
		List<CompleteProjectProfile> completeProjectProfiles) {
		for (CompleteProjectProfile completeProjectProfile : completeProjectProfiles) {
			if (EntityCacheUtil.getResult(
						CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
						CompleteProjectProfileImpl.class,
						completeProjectProfile.getPrimaryKey()) == null) {
				cacheResult(completeProjectProfile);
			}
			else {
				completeProjectProfile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all complete project profiles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CompleteProjectProfileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CompleteProjectProfileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complete project profile.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompleteProjectProfile completeProjectProfile) {
		EntityCacheUtil.removeResult(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			CompleteProjectProfileImpl.class,
			completeProjectProfile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CompleteProjectProfile> completeProjectProfiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CompleteProjectProfile completeProjectProfile : completeProjectProfiles) {
			EntityCacheUtil.removeResult(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
				CompleteProjectProfileImpl.class,
				completeProjectProfile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complete project profile with the primary key. Does not add the complete project profile to the database.
	 *
	 * @param completeId the primary key for the new complete project profile
	 * @return the new complete project profile
	 */
	@Override
	public CompleteProjectProfile create(long completeId) {
		CompleteProjectProfile completeProjectProfile = new CompleteProjectProfileImpl();

		completeProjectProfile.setNew(true);
		completeProjectProfile.setPrimaryKey(completeId);

		return completeProjectProfile;
	}

	/**
	 * Removes the complete project profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param completeId the primary key of the complete project profile
	 * @return the complete project profile that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException if a complete project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteProjectProfile remove(long completeId)
		throws NoSuchCompleteProjectProfileException, SystemException {
		return remove((Serializable)completeId);
	}

	/**
	 * Removes the complete project profile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complete project profile
	 * @return the complete project profile that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException if a complete project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteProjectProfile remove(Serializable primaryKey)
		throws NoSuchCompleteProjectProfileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CompleteProjectProfile completeProjectProfile = (CompleteProjectProfile)session.get(CompleteProjectProfileImpl.class,
					primaryKey);

			if (completeProjectProfile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompleteProjectProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(completeProjectProfile);
		}
		catch (NoSuchCompleteProjectProfileException nsee) {
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
	protected CompleteProjectProfile removeImpl(
		CompleteProjectProfile completeProjectProfile)
		throws SystemException {
		completeProjectProfile = toUnwrappedModel(completeProjectProfile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(completeProjectProfile)) {
				completeProjectProfile = (CompleteProjectProfile)session.get(CompleteProjectProfileImpl.class,
						completeProjectProfile.getPrimaryKeyObj());
			}

			if (completeProjectProfile != null) {
				session.delete(completeProjectProfile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (completeProjectProfile != null) {
			clearCache(completeProjectProfile);
		}

		return completeProjectProfile;
	}

	@Override
	public CompleteProjectProfile updateImpl(
		com.justonetech.cp.complete.model.CompleteProjectProfile completeProjectProfile)
		throws SystemException {
		completeProjectProfile = toUnwrappedModel(completeProjectProfile);

		boolean isNew = completeProjectProfile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (completeProjectProfile.isNew()) {
				session.save(completeProjectProfile);

				completeProjectProfile.setNew(false);
			}
			else {
				session.merge(completeProjectProfile);
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

		EntityCacheUtil.putResult(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
			CompleteProjectProfileImpl.class,
			completeProjectProfile.getPrimaryKey(), completeProjectProfile);

		return completeProjectProfile;
	}

	protected CompleteProjectProfile toUnwrappedModel(
		CompleteProjectProfile completeProjectProfile) {
		if (completeProjectProfile instanceof CompleteProjectProfileImpl) {
			return completeProjectProfile;
		}

		CompleteProjectProfileImpl completeProjectProfileImpl = new CompleteProjectProfileImpl();

		completeProjectProfileImpl.setNew(completeProjectProfile.isNew());
		completeProjectProfileImpl.setPrimaryKey(completeProjectProfile.getPrimaryKey());

		completeProjectProfileImpl.setCompleteId(completeProjectProfile.getCompleteId());
		completeProjectProfileImpl.setBjbh(completeProjectProfile.getBjbh());
		completeProjectProfileImpl.setXmlx(completeProjectProfile.getXmlx());
		completeProjectProfileImpl.setJsgcsx(completeProjectProfile.getJsgcsx());
		completeProjectProfileImpl.setGcmc(completeProjectProfile.getGcmc());
		completeProjectProfileImpl.setLxjb(completeProjectProfile.getLxjb());
		completeProjectProfileImpl.setJsdwmc(completeProjectProfile.getJsdwmc());
		completeProjectProfileImpl.setJsdwdz(completeProjectProfile.getJsdwdz());
		completeProjectProfileImpl.setJsdd(completeProjectProfile.getJsdd());
		completeProjectProfileImpl.setSzqx(completeProjectProfile.getSzqx());
		completeProjectProfileImpl.setFddbr(completeProjectProfile.getFddbr());
		completeProjectProfileImpl.setLxr(completeProjectProfile.getLxr());
		completeProjectProfileImpl.setLxdh(completeProjectProfile.getLxdh());
		completeProjectProfileImpl.setBz(completeProjectProfile.getBz());

		return completeProjectProfileImpl;
	}

	/**
	 * Returns the complete project profile with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete project profile
	 * @return the complete project profile
	 * @throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException if a complete project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteProjectProfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompleteProjectProfileException, SystemException {
		CompleteProjectProfile completeProjectProfile = fetchByPrimaryKey(primaryKey);

		if (completeProjectProfile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompleteProjectProfileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return completeProjectProfile;
	}

	/**
	 * Returns the complete project profile with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteProjectProfileException} if it could not be found.
	 *
	 * @param completeId the primary key of the complete project profile
	 * @return the complete project profile
	 * @throws com.justonetech.cp.complete.NoSuchCompleteProjectProfileException if a complete project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteProjectProfile findByPrimaryKey(long completeId)
		throws NoSuchCompleteProjectProfileException, SystemException {
		return findByPrimaryKey((Serializable)completeId);
	}

	/**
	 * Returns the complete project profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete project profile
	 * @return the complete project profile, or <code>null</code> if a complete project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteProjectProfile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CompleteProjectProfile completeProjectProfile = (CompleteProjectProfile)EntityCacheUtil.getResult(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
				CompleteProjectProfileImpl.class, primaryKey);

		if (completeProjectProfile == _nullCompleteProjectProfile) {
			return null;
		}

		if (completeProjectProfile == null) {
			Session session = null;

			try {
				session = openSession();

				completeProjectProfile = (CompleteProjectProfile)session.get(CompleteProjectProfileImpl.class,
						primaryKey);

				if (completeProjectProfile != null) {
					cacheResult(completeProjectProfile);
				}
				else {
					EntityCacheUtil.putResult(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
						CompleteProjectProfileImpl.class, primaryKey,
						_nullCompleteProjectProfile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CompleteProjectProfileModelImpl.ENTITY_CACHE_ENABLED,
					CompleteProjectProfileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return completeProjectProfile;
	}

	/**
	 * Returns the complete project profile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param completeId the primary key of the complete project profile
	 * @return the complete project profile, or <code>null</code> if a complete project profile with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteProjectProfile fetchByPrimaryKey(long completeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)completeId);
	}

	/**
	 * Returns all the complete project profiles.
	 *
	 * @return the complete project profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteProjectProfile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complete project profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of complete project profiles
	 * @param end the upper bound of the range of complete project profiles (not inclusive)
	 * @return the range of complete project profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteProjectProfile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complete project profiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteProjectProfileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of complete project profiles
	 * @param end the upper bound of the range of complete project profiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complete project profiles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteProjectProfile> findAll(int start, int end,
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

		List<CompleteProjectProfile> list = (List<CompleteProjectProfile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLETEPROJECTPROFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLETEPROJECTPROFILE;

				if (pagination) {
					sql = sql.concat(CompleteProjectProfileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CompleteProjectProfile>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompleteProjectProfile>(list);
				}
				else {
					list = (List<CompleteProjectProfile>)QueryUtil.list(q,
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
	 * Removes all the complete project profiles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CompleteProjectProfile completeProjectProfile : findAll()) {
			remove(completeProjectProfile);
		}
	}

	/**
	 * Returns the number of complete project profiles.
	 *
	 * @return the number of complete project profiles
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

				Query q = session.createQuery(_SQL_COUNT_COMPLETEPROJECTPROFILE);

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
	 * Initializes the complete project profile persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.complete.model.CompleteProjectProfile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CompleteProjectProfile>> listenersList = new ArrayList<ModelListener<CompleteProjectProfile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CompleteProjectProfile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CompleteProjectProfileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMPLETEPROJECTPROFILE = "SELECT completeProjectProfile FROM CompleteProjectProfile completeProjectProfile";
	private static final String _SQL_COUNT_COMPLETEPROJECTPROFILE = "SELECT COUNT(completeProjectProfile) FROM CompleteProjectProfile completeProjectProfile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "completeProjectProfile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CompleteProjectProfile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CompleteProjectProfilePersistenceImpl.class);
	private static CompleteProjectProfile _nullCompleteProjectProfile = new CompleteProjectProfileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CompleteProjectProfile> toCacheModel() {
				return _nullCompleteProjectProfileCacheModel;
			}
		};

	private static CacheModel<CompleteProjectProfile> _nullCompleteProjectProfileCacheModel =
		new CacheModel<CompleteProjectProfile>() {
			@Override
			public CompleteProjectProfile toEntityModel() {
				return _nullCompleteProjectProfile;
			}
		};
}