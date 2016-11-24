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

import com.justonetech.expert.NoSuchZysqlbException;
import com.justonetech.expert.model.Zysqlb;
import com.justonetech.expert.model.impl.ZysqlbImpl;
import com.justonetech.expert.model.impl.ZysqlbModelImpl;

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
 * The persistence implementation for the zysqlb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZysqlbPersistence
 * @see ZysqlbUtil
 * @generated
 */
public class ZysqlbPersistenceImpl extends BasePersistenceImpl<Zysqlb>
	implements ZysqlbPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ZysqlbUtil} to access the zysqlb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ZysqlbImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
			ZysqlbModelImpl.FINDER_CACHE_ENABLED, ZysqlbImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
			ZysqlbModelImpl.FINDER_CACHE_ENABLED, ZysqlbImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
			ZysqlbModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ZysqlbPersistenceImpl() {
		setModelClass(Zysqlb.class);
	}

	/**
	 * Caches the zysqlb in the entity cache if it is enabled.
	 *
	 * @param zysqlb the zysqlb
	 */
	@Override
	public void cacheResult(Zysqlb zysqlb) {
		EntityCacheUtil.putResult(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
			ZysqlbImpl.class, zysqlb.getPrimaryKey(), zysqlb);

		zysqlb.resetOriginalValues();
	}

	/**
	 * Caches the zysqlbs in the entity cache if it is enabled.
	 *
	 * @param zysqlbs the zysqlbs
	 */
	@Override
	public void cacheResult(List<Zysqlb> zysqlbs) {
		for (Zysqlb zysqlb : zysqlbs) {
			if (EntityCacheUtil.getResult(
						ZysqlbModelImpl.ENTITY_CACHE_ENABLED, ZysqlbImpl.class,
						zysqlb.getPrimaryKey()) == null) {
				cacheResult(zysqlb);
			}
			else {
				zysqlb.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all zysqlbs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ZysqlbImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ZysqlbImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the zysqlb.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Zysqlb zysqlb) {
		EntityCacheUtil.removeResult(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
			ZysqlbImpl.class, zysqlb.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Zysqlb> zysqlbs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Zysqlb zysqlb : zysqlbs) {
			EntityCacheUtil.removeResult(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
				ZysqlbImpl.class, zysqlb.getPrimaryKey());
		}
	}

	/**
	 * Creates a new zysqlb with the primary key. Does not add the zysqlb to the database.
	 *
	 * @param zysqlbId the primary key for the new zysqlb
	 * @return the new zysqlb
	 */
	@Override
	public Zysqlb create(long zysqlbId) {
		Zysqlb zysqlb = new ZysqlbImpl();

		zysqlb.setNew(true);
		zysqlb.setPrimaryKey(zysqlbId);

		return zysqlb;
	}

	/**
	 * Removes the zysqlb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param zysqlbId the primary key of the zysqlb
	 * @return the zysqlb that was removed
	 * @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zysqlb remove(long zysqlbId)
		throws NoSuchZysqlbException, SystemException {
		return remove((Serializable)zysqlbId);
	}

	/**
	 * Removes the zysqlb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the zysqlb
	 * @return the zysqlb that was removed
	 * @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zysqlb remove(Serializable primaryKey)
		throws NoSuchZysqlbException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Zysqlb zysqlb = (Zysqlb)session.get(ZysqlbImpl.class, primaryKey);

			if (zysqlb == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchZysqlbException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(zysqlb);
		}
		catch (NoSuchZysqlbException nsee) {
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
	protected Zysqlb removeImpl(Zysqlb zysqlb) throws SystemException {
		zysqlb = toUnwrappedModel(zysqlb);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(zysqlb)) {
				zysqlb = (Zysqlb)session.get(ZysqlbImpl.class,
						zysqlb.getPrimaryKeyObj());
			}

			if (zysqlb != null) {
				session.delete(zysqlb);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (zysqlb != null) {
			clearCache(zysqlb);
		}

		return zysqlb;
	}

	@Override
	public Zysqlb updateImpl(com.justonetech.expert.model.Zysqlb zysqlb)
		throws SystemException {
		zysqlb = toUnwrappedModel(zysqlb);

		boolean isNew = zysqlb.isNew();

		Session session = null;

		try {
			session = openSession();

			if (zysqlb.isNew()) {
				session.save(zysqlb);

				zysqlb.setNew(false);
			}
			else {
				session.merge(zysqlb);
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

		EntityCacheUtil.putResult(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
			ZysqlbImpl.class, zysqlb.getPrimaryKey(), zysqlb);

		return zysqlb;
	}

	protected Zysqlb toUnwrappedModel(Zysqlb zysqlb) {
		if (zysqlb instanceof ZysqlbImpl) {
			return zysqlb;
		}

		ZysqlbImpl zysqlbImpl = new ZysqlbImpl();

		zysqlbImpl.setNew(zysqlb.isNew());
		zysqlbImpl.setPrimaryKey(zysqlb.getPrimaryKey());

		zysqlbImpl.setZysqlbId(zysqlb.getZysqlbId());
		zysqlbImpl.setSx(zysqlb.getSx());
		zysqlbImpl.setZy(zysqlb.getZy());
		zysqlbImpl.setZt(zysqlb.getZt());
		zysqlbImpl.setShyj(zysqlb.getShyj());

		return zysqlbImpl;
	}

	/**
	 * Returns the zysqlb with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the zysqlb
	 * @return the zysqlb
	 * @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zysqlb findByPrimaryKey(Serializable primaryKey)
		throws NoSuchZysqlbException, SystemException {
		Zysqlb zysqlb = fetchByPrimaryKey(primaryKey);

		if (zysqlb == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchZysqlbException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return zysqlb;
	}

	/**
	 * Returns the zysqlb with the primary key or throws a {@link com.justonetech.expert.NoSuchZysqlbException} if it could not be found.
	 *
	 * @param zysqlbId the primary key of the zysqlb
	 * @return the zysqlb
	 * @throws com.justonetech.expert.NoSuchZysqlbException if a zysqlb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zysqlb findByPrimaryKey(long zysqlbId)
		throws NoSuchZysqlbException, SystemException {
		return findByPrimaryKey((Serializable)zysqlbId);
	}

	/**
	 * Returns the zysqlb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the zysqlb
	 * @return the zysqlb, or <code>null</code> if a zysqlb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zysqlb fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Zysqlb zysqlb = (Zysqlb)EntityCacheUtil.getResult(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
				ZysqlbImpl.class, primaryKey);

		if (zysqlb == _nullZysqlb) {
			return null;
		}

		if (zysqlb == null) {
			Session session = null;

			try {
				session = openSession();

				zysqlb = (Zysqlb)session.get(ZysqlbImpl.class, primaryKey);

				if (zysqlb != null) {
					cacheResult(zysqlb);
				}
				else {
					EntityCacheUtil.putResult(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
						ZysqlbImpl.class, primaryKey, _nullZysqlb);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ZysqlbModelImpl.ENTITY_CACHE_ENABLED,
					ZysqlbImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return zysqlb;
	}

	/**
	 * Returns the zysqlb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param zysqlbId the primary key of the zysqlb
	 * @return the zysqlb, or <code>null</code> if a zysqlb with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zysqlb fetchByPrimaryKey(long zysqlbId) throws SystemException {
		return fetchByPrimaryKey((Serializable)zysqlbId);
	}

	/**
	 * Returns all the zysqlbs.
	 *
	 * @return the zysqlbs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zysqlb> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the zysqlbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of zysqlbs
	 * @param end the upper bound of the range of zysqlbs (not inclusive)
	 * @return the range of zysqlbs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zysqlb> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the zysqlbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZysqlbModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of zysqlbs
	 * @param end the upper bound of the range of zysqlbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of zysqlbs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zysqlb> findAll(int start, int end,
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

		List<Zysqlb> list = (List<Zysqlb>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ZYSQLB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ZYSQLB;

				if (pagination) {
					sql = sql.concat(ZysqlbModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Zysqlb>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Zysqlb>(list);
				}
				else {
					list = (List<Zysqlb>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the zysqlbs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Zysqlb zysqlb : findAll()) {
			remove(zysqlb);
		}
	}

	/**
	 * Returns the number of zysqlbs.
	 *
	 * @return the number of zysqlbs
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

				Query q = session.createQuery(_SQL_COUNT_ZYSQLB);

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
	 * Initializes the zysqlb persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.expert.model.Zysqlb")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Zysqlb>> listenersList = new ArrayList<ModelListener<Zysqlb>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Zysqlb>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ZysqlbImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ZYSQLB = "SELECT zysqlb FROM Zysqlb zysqlb";
	private static final String _SQL_COUNT_ZYSQLB = "SELECT COUNT(zysqlb) FROM Zysqlb zysqlb";
	private static final String _ORDER_BY_ENTITY_ALIAS = "zysqlb.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Zysqlb exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ZysqlbPersistenceImpl.class);
	private static Zysqlb _nullZysqlb = new ZysqlbImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Zysqlb> toCacheModel() {
				return _nullZysqlbCacheModel;
			}
		};

	private static CacheModel<Zysqlb> _nullZysqlbCacheModel = new CacheModel<Zysqlb>() {
			@Override
			public Zysqlb toEntityModel() {
				return _nullZysqlb;
			}
		};
}