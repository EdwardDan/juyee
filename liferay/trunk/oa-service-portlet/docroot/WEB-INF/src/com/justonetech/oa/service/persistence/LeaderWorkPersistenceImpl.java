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

import com.justonetech.oa.NoSuchLeaderWorkException;
import com.justonetech.oa.model.LeaderWork;
import com.justonetech.oa.model.impl.LeaderWorkImpl;
import com.justonetech.oa.model.impl.LeaderWorkModelImpl;

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
 * The persistence implementation for the leader work service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see LeaderWorkPersistence
 * @see LeaderWorkUtil
 * @generated
 */
public class LeaderWorkPersistenceImpl extends BasePersistenceImpl<LeaderWork>
	implements LeaderWorkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LeaderWorkUtil} to access the leader work persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LeaderWorkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
			LeaderWorkModelImpl.FINDER_CACHE_ENABLED, LeaderWorkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
			LeaderWorkModelImpl.FINDER_CACHE_ENABLED, LeaderWorkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
			LeaderWorkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LeaderWorkPersistenceImpl() {
		setModelClass(LeaderWork.class);
	}

	/**
	 * Caches the leader work in the entity cache if it is enabled.
	 *
	 * @param leaderWork the leader work
	 */
	@Override
	public void cacheResult(LeaderWork leaderWork) {
		EntityCacheUtil.putResult(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
			LeaderWorkImpl.class, leaderWork.getPrimaryKey(), leaderWork);

		leaderWork.resetOriginalValues();
	}

	/**
	 * Caches the leader works in the entity cache if it is enabled.
	 *
	 * @param leaderWorks the leader works
	 */
	@Override
	public void cacheResult(List<LeaderWork> leaderWorks) {
		for (LeaderWork leaderWork : leaderWorks) {
			if (EntityCacheUtil.getResult(
						LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
						LeaderWorkImpl.class, leaderWork.getPrimaryKey()) == null) {
				cacheResult(leaderWork);
			}
			else {
				leaderWork.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all leader works.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LeaderWorkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LeaderWorkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the leader work.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LeaderWork leaderWork) {
		EntityCacheUtil.removeResult(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
			LeaderWorkImpl.class, leaderWork.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LeaderWork> leaderWorks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LeaderWork leaderWork : leaderWorks) {
			EntityCacheUtil.removeResult(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
				LeaderWorkImpl.class, leaderWork.getPrimaryKey());
		}
	}

	/**
	 * Creates a new leader work with the primary key. Does not add the leader work to the database.
	 *
	 * @param leaderWorkPK the primary key for the new leader work
	 * @return the new leader work
	 */
	@Override
	public LeaderWork create(LeaderWorkPK leaderWorkPK) {
		LeaderWork leaderWork = new LeaderWorkImpl();

		leaderWork.setNew(true);
		leaderWork.setPrimaryKey(leaderWorkPK);

		return leaderWork;
	}

	/**
	 * Removes the leader work with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param leaderWorkPK the primary key of the leader work
	 * @return the leader work that was removed
	 * @throws com.justonetech.oa.NoSuchLeaderWorkException if a leader work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaderWork remove(LeaderWorkPK leaderWorkPK)
		throws NoSuchLeaderWorkException, SystemException {
		return remove((Serializable)leaderWorkPK);
	}

	/**
	 * Removes the leader work with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the leader work
	 * @return the leader work that was removed
	 * @throws com.justonetech.oa.NoSuchLeaderWorkException if a leader work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaderWork remove(Serializable primaryKey)
		throws NoSuchLeaderWorkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LeaderWork leaderWork = (LeaderWork)session.get(LeaderWorkImpl.class,
					primaryKey);

			if (leaderWork == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLeaderWorkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leaderWork);
		}
		catch (NoSuchLeaderWorkException nsee) {
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
	protected LeaderWork removeImpl(LeaderWork leaderWork)
		throws SystemException {
		leaderWork = toUnwrappedModel(leaderWork);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leaderWork)) {
				leaderWork = (LeaderWork)session.get(LeaderWorkImpl.class,
						leaderWork.getPrimaryKeyObj());
			}

			if (leaderWork != null) {
				session.delete(leaderWork);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leaderWork != null) {
			clearCache(leaderWork);
		}

		return leaderWork;
	}

	@Override
	public LeaderWork updateImpl(com.justonetech.oa.model.LeaderWork leaderWork)
		throws SystemException {
		leaderWork = toUnwrappedModel(leaderWork);

		boolean isNew = leaderWork.isNew();

		Session session = null;

		try {
			session = openSession();

			if (leaderWork.isNew()) {
				session.save(leaderWork);

				leaderWork.setNew(false);
			}
			else {
				session.merge(leaderWork);
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

		EntityCacheUtil.putResult(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
			LeaderWorkImpl.class, leaderWork.getPrimaryKey(), leaderWork);

		return leaderWork;
	}

	protected LeaderWork toUnwrappedModel(LeaderWork leaderWork) {
		if (leaderWork instanceof LeaderWorkImpl) {
			return leaderWork;
		}

		LeaderWorkImpl leaderWorkImpl = new LeaderWorkImpl();

		leaderWorkImpl.setNew(leaderWork.isNew());
		leaderWorkImpl.setPrimaryKey(leaderWork.getPrimaryKey());

		leaderWorkImpl.setUserId(leaderWork.getUserId());
		leaderWorkImpl.setWorkDate(leaderWork.getWorkDate());
		leaderWorkImpl.setAmOrPm(leaderWork.getAmOrPm());
		leaderWorkImpl.setUserName(leaderWork.getUserName());
		leaderWorkImpl.setCreateTime(leaderWork.getCreateTime());
		leaderWorkImpl.setModifiedTime(leaderWork.getModifiedTime());
		leaderWorkImpl.setContent(leaderWork.getContent());

		return leaderWorkImpl;
	}

	/**
	 * Returns the leader work with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the leader work
	 * @return the leader work
	 * @throws com.justonetech.oa.NoSuchLeaderWorkException if a leader work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaderWork findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLeaderWorkException, SystemException {
		LeaderWork leaderWork = fetchByPrimaryKey(primaryKey);

		if (leaderWork == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLeaderWorkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leaderWork;
	}

	/**
	 * Returns the leader work with the primary key or throws a {@link com.justonetech.oa.NoSuchLeaderWorkException} if it could not be found.
	 *
	 * @param leaderWorkPK the primary key of the leader work
	 * @return the leader work
	 * @throws com.justonetech.oa.NoSuchLeaderWorkException if a leader work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaderWork findByPrimaryKey(LeaderWorkPK leaderWorkPK)
		throws NoSuchLeaderWorkException, SystemException {
		return findByPrimaryKey((Serializable)leaderWorkPK);
	}

	/**
	 * Returns the leader work with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the leader work
	 * @return the leader work, or <code>null</code> if a leader work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaderWork fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LeaderWork leaderWork = (LeaderWork)EntityCacheUtil.getResult(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
				LeaderWorkImpl.class, primaryKey);

		if (leaderWork == _nullLeaderWork) {
			return null;
		}

		if (leaderWork == null) {
			Session session = null;

			try {
				session = openSession();

				leaderWork = (LeaderWork)session.get(LeaderWorkImpl.class,
						primaryKey);

				if (leaderWork != null) {
					cacheResult(leaderWork);
				}
				else {
					EntityCacheUtil.putResult(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
						LeaderWorkImpl.class, primaryKey, _nullLeaderWork);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LeaderWorkModelImpl.ENTITY_CACHE_ENABLED,
					LeaderWorkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leaderWork;
	}

	/**
	 * Returns the leader work with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param leaderWorkPK the primary key of the leader work
	 * @return the leader work, or <code>null</code> if a leader work with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LeaderWork fetchByPrimaryKey(LeaderWorkPK leaderWorkPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)leaderWorkPK);
	}

	/**
	 * Returns all the leader works.
	 *
	 * @return the leader works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaderWork> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the leader works.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.LeaderWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leader works
	 * @param end the upper bound of the range of leader works (not inclusive)
	 * @return the range of leader works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaderWork> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the leader works.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.LeaderWorkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of leader works
	 * @param end the upper bound of the range of leader works (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of leader works
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LeaderWork> findAll(int start, int end,
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

		List<LeaderWork> list = (List<LeaderWork>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEADERWORK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEADERWORK;

				if (pagination) {
					sql = sql.concat(LeaderWorkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LeaderWork>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LeaderWork>(list);
				}
				else {
					list = (List<LeaderWork>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the leader works from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LeaderWork leaderWork : findAll()) {
			remove(leaderWork);
		}
	}

	/**
	 * Returns the number of leader works.
	 *
	 * @return the number of leader works
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

				Query q = session.createQuery(_SQL_COUNT_LEADERWORK);

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
	 * Initializes the leader work persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.LeaderWork")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LeaderWork>> listenersList = new ArrayList<ModelListener<LeaderWork>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LeaderWork>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LeaderWorkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEADERWORK = "SELECT leaderWork FROM LeaderWork leaderWork";
	private static final String _SQL_COUNT_LEADERWORK = "SELECT COUNT(leaderWork) FROM LeaderWork leaderWork";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leaderWork.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LeaderWork exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LeaderWorkPersistenceImpl.class);
	private static LeaderWork _nullLeaderWork = new LeaderWorkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LeaderWork> toCacheModel() {
				return _nullLeaderWorkCacheModel;
			}
		};

	private static CacheModel<LeaderWork> _nullLeaderWorkCacheModel = new CacheModel<LeaderWork>() {
			@Override
			public LeaderWork toEntityModel() {
				return _nullLeaderWork;
			}
		};
}