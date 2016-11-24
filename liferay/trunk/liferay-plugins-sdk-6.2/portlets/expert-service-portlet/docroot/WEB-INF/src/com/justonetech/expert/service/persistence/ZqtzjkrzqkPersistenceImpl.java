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

package com.justonetech.expert.service.persistence;

import com.justonetech.expert.NoSuchZqtzjkrzqkException;
import com.justonetech.expert.model.Zqtzjkrzqk;
import com.justonetech.expert.model.impl.ZqtzjkrzqkImpl;
import com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl;

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
 * The persistence implementation for the zqtzjkrzqk service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZqtzjkrzqkPersistence
 * @see ZqtzjkrzqkUtil
 * @generated
 */
public class ZqtzjkrzqkPersistenceImpl extends BasePersistenceImpl<Zqtzjkrzqk>
	implements ZqtzjkrzqkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ZqtzjkrzqkUtil} to access the zqtzjkrzqk persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ZqtzjkrzqkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
			ZqtzjkrzqkModelImpl.FINDER_CACHE_ENABLED, ZqtzjkrzqkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
			ZqtzjkrzqkModelImpl.FINDER_CACHE_ENABLED, ZqtzjkrzqkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
			ZqtzjkrzqkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ZqtzjkrzqkPersistenceImpl() {
		setModelClass(Zqtzjkrzqk.class);
	}

	/**
	 * Caches the zqtzjkrzqk in the entity cache if it is enabled.
	 *
	 * @param zqtzjkrzqk the zqtzjkrzqk
	 */
	@Override
	public void cacheResult(Zqtzjkrzqk zqtzjkrzqk) {
		EntityCacheUtil.putResult(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
			ZqtzjkrzqkImpl.class, zqtzjkrzqk.getPrimaryKey(), zqtzjkrzqk);

		zqtzjkrzqk.resetOriginalValues();
	}

	/**
	 * Caches the zqtzjkrzqks in the entity cache if it is enabled.
	 *
	 * @param zqtzjkrzqks the zqtzjkrzqks
	 */
	@Override
	public void cacheResult(List<Zqtzjkrzqk> zqtzjkrzqks) {
		for (Zqtzjkrzqk zqtzjkrzqk : zqtzjkrzqks) {
			if (EntityCacheUtil.getResult(
						ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
						ZqtzjkrzqkImpl.class, zqtzjkrzqk.getPrimaryKey()) == null) {
				cacheResult(zqtzjkrzqk);
			}
			else {
				zqtzjkrzqk.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all zqtzjkrzqks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ZqtzjkrzqkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ZqtzjkrzqkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the zqtzjkrzqk.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Zqtzjkrzqk zqtzjkrzqk) {
		EntityCacheUtil.removeResult(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
			ZqtzjkrzqkImpl.class, zqtzjkrzqk.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Zqtzjkrzqk> zqtzjkrzqks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Zqtzjkrzqk zqtzjkrzqk : zqtzjkrzqks) {
			EntityCacheUtil.removeResult(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
				ZqtzjkrzqkImpl.class, zqtzjkrzqk.getPrimaryKey());
		}
	}

	/**
	 * Creates a new zqtzjkrzqk with the primary key. Does not add the zqtzjkrzqk to the database.
	 *
	 * @param zqtzjkrzqkId the primary key for the new zqtzjkrzqk
	 * @return the new zqtzjkrzqk
	 */
	@Override
	public Zqtzjkrzqk create(long zqtzjkrzqkId) {
		Zqtzjkrzqk zqtzjkrzqk = new ZqtzjkrzqkImpl();

		zqtzjkrzqk.setNew(true);
		zqtzjkrzqk.setPrimaryKey(zqtzjkrzqkId);

		return zqtzjkrzqk;
	}

	/**
	 * Removes the zqtzjkrzqk with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk that was removed
	 * @throws com.justonetech.expert.NoSuchZqtzjkrzqkException if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zqtzjkrzqk remove(long zqtzjkrzqkId)
		throws NoSuchZqtzjkrzqkException, SystemException {
		return remove((Serializable)zqtzjkrzqkId);
	}

	/**
	 * Removes the zqtzjkrzqk with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk that was removed
	 * @throws com.justonetech.expert.NoSuchZqtzjkrzqkException if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zqtzjkrzqk remove(Serializable primaryKey)
		throws NoSuchZqtzjkrzqkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Zqtzjkrzqk zqtzjkrzqk = (Zqtzjkrzqk)session.get(ZqtzjkrzqkImpl.class,
					primaryKey);

			if (zqtzjkrzqk == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchZqtzjkrzqkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(zqtzjkrzqk);
		}
		catch (NoSuchZqtzjkrzqkException nsee) {
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
	protected Zqtzjkrzqk removeImpl(Zqtzjkrzqk zqtzjkrzqk)
		throws SystemException {
		zqtzjkrzqk = toUnwrappedModel(zqtzjkrzqk);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(zqtzjkrzqk)) {
				zqtzjkrzqk = (Zqtzjkrzqk)session.get(ZqtzjkrzqkImpl.class,
						zqtzjkrzqk.getPrimaryKeyObj());
			}

			if (zqtzjkrzqk != null) {
				session.delete(zqtzjkrzqk);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (zqtzjkrzqk != null) {
			clearCache(zqtzjkrzqk);
		}

		return zqtzjkrzqk;
	}

	@Override
	public Zqtzjkrzqk updateImpl(
		com.justonetech.expert.model.Zqtzjkrzqk zqtzjkrzqk)
		throws SystemException {
		zqtzjkrzqk = toUnwrappedModel(zqtzjkrzqk);

		boolean isNew = zqtzjkrzqk.isNew();

		Session session = null;

		try {
			session = openSession();

			if (zqtzjkrzqk.isNew()) {
				session.save(zqtzjkrzqk);

				zqtzjkrzqk.setNew(false);
			}
			else {
				session.merge(zqtzjkrzqk);
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

		EntityCacheUtil.putResult(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
			ZqtzjkrzqkImpl.class, zqtzjkrzqk.getPrimaryKey(), zqtzjkrzqk);

		return zqtzjkrzqk;
	}

	protected Zqtzjkrzqk toUnwrappedModel(Zqtzjkrzqk zqtzjkrzqk) {
		if (zqtzjkrzqk instanceof ZqtzjkrzqkImpl) {
			return zqtzjkrzqk;
		}

		ZqtzjkrzqkImpl zqtzjkrzqkImpl = new ZqtzjkrzqkImpl();

		zqtzjkrzqkImpl.setNew(zqtzjkrzqk.isNew());
		zqtzjkrzqkImpl.setPrimaryKey(zqtzjkrzqk.getPrimaryKey());

		zqtzjkrzqkImpl.setZqtzjkrzqkId(zqtzjkrzqk.getZqtzjkrzqkId());
		zqtzjkrzqkImpl.setZjkxtlsdw(zqtzjkrzqk.getZjkxtlsdw());
		zqtzjkrzqkImpl.setSqzy(zqtzjkrzqk.getSqzy());
		zqtzjkrzqkImpl.setPzrq(zqtzjkrzqk.getPzrq());

		return zqtzjkrzqkImpl;
	}

	/**
	 * Returns the zqtzjkrzqk with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk
	 * @throws com.justonetech.expert.NoSuchZqtzjkrzqkException if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zqtzjkrzqk findByPrimaryKey(Serializable primaryKey)
		throws NoSuchZqtzjkrzqkException, SystemException {
		Zqtzjkrzqk zqtzjkrzqk = fetchByPrimaryKey(primaryKey);

		if (zqtzjkrzqk == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchZqtzjkrzqkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return zqtzjkrzqk;
	}

	/**
	 * Returns the zqtzjkrzqk with the primary key or throws a {@link com.justonetech.expert.NoSuchZqtzjkrzqkException} if it could not be found.
	 *
	 * @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk
	 * @throws com.justonetech.expert.NoSuchZqtzjkrzqkException if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zqtzjkrzqk findByPrimaryKey(long zqtzjkrzqkId)
		throws NoSuchZqtzjkrzqkException, SystemException {
		return findByPrimaryKey((Serializable)zqtzjkrzqkId);
	}

	/**
	 * Returns the zqtzjkrzqk with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk, or <code>null</code> if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zqtzjkrzqk fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Zqtzjkrzqk zqtzjkrzqk = (Zqtzjkrzqk)EntityCacheUtil.getResult(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
				ZqtzjkrzqkImpl.class, primaryKey);

		if (zqtzjkrzqk == _nullZqtzjkrzqk) {
			return null;
		}

		if (zqtzjkrzqk == null) {
			Session session = null;

			try {
				session = openSession();

				zqtzjkrzqk = (Zqtzjkrzqk)session.get(ZqtzjkrzqkImpl.class,
						primaryKey);

				if (zqtzjkrzqk != null) {
					cacheResult(zqtzjkrzqk);
				}
				else {
					EntityCacheUtil.putResult(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
						ZqtzjkrzqkImpl.class, primaryKey, _nullZqtzjkrzqk);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ZqtzjkrzqkModelImpl.ENTITY_CACHE_ENABLED,
					ZqtzjkrzqkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return zqtzjkrzqk;
	}

	/**
	 * Returns the zqtzjkrzqk with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk, or <code>null</code> if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zqtzjkrzqk fetchByPrimaryKey(long zqtzjkrzqkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)zqtzjkrzqkId);
	}

	/**
	 * Returns all the zqtzjkrzqks.
	 *
	 * @return the zqtzjkrzqks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zqtzjkrzqk> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the zqtzjkrzqks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of zqtzjkrzqks
	 * @param end the upper bound of the range of zqtzjkrzqks (not inclusive)
	 * @return the range of zqtzjkrzqks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zqtzjkrzqk> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the zqtzjkrzqks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of zqtzjkrzqks
	 * @param end the upper bound of the range of zqtzjkrzqks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of zqtzjkrzqks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zqtzjkrzqk> findAll(int start, int end,
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

		List<Zqtzjkrzqk> list = (List<Zqtzjkrzqk>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ZQTZJKRZQK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ZQTZJKRZQK;

				if (pagination) {
					sql = sql.concat(ZqtzjkrzqkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Zqtzjkrzqk>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Zqtzjkrzqk>(list);
				}
				else {
					list = (List<Zqtzjkrzqk>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the zqtzjkrzqks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Zqtzjkrzqk zqtzjkrzqk : findAll()) {
			remove(zqtzjkrzqk);
		}
	}

	/**
	 * Returns the number of zqtzjkrzqks.
	 *
	 * @return the number of zqtzjkrzqks
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

				Query q = session.createQuery(_SQL_COUNT_ZQTZJKRZQK);

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
	 * Initializes the zqtzjkrzqk persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.expert.model.Zqtzjkrzqk")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Zqtzjkrzqk>> listenersList = new ArrayList<ModelListener<Zqtzjkrzqk>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Zqtzjkrzqk>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ZqtzjkrzqkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ZQTZJKRZQK = "SELECT zqtzjkrzqk FROM Zqtzjkrzqk zqtzjkrzqk";
	private static final String _SQL_COUNT_ZQTZJKRZQK = "SELECT COUNT(zqtzjkrzqk) FROM Zqtzjkrzqk zqtzjkrzqk";
	private static final String _ORDER_BY_ENTITY_ALIAS = "zqtzjkrzqk.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Zqtzjkrzqk exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ZqtzjkrzqkPersistenceImpl.class);
	private static Zqtzjkrzqk _nullZqtzjkrzqk = new ZqtzjkrzqkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Zqtzjkrzqk> toCacheModel() {
				return _nullZqtzjkrzqkCacheModel;
			}
		};

	private static CacheModel<Zqtzjkrzqk> _nullZqtzjkrzqkCacheModel = new CacheModel<Zqtzjkrzqk>() {
			@Override
			public Zqtzjkrzqk toEntityModel() {
				return _nullZqtzjkrzqk;
			}
		};
}