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

import com.justonetech.expert.NoSuchGzjlException;
import com.justonetech.expert.model.Gzjl;
import com.justonetech.expert.model.impl.GzjlImpl;
import com.justonetech.expert.model.impl.GzjlModelImpl;

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
 * The persistence implementation for the gzjl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see GzjlPersistence
 * @see GzjlUtil
 * @generated
 */
public class GzjlPersistenceImpl extends BasePersistenceImpl<Gzjl>
	implements GzjlPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GzjlUtil} to access the gzjl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GzjlImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GzjlModelImpl.ENTITY_CACHE_ENABLED,
			GzjlModelImpl.FINDER_CACHE_ENABLED, GzjlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GzjlModelImpl.ENTITY_CACHE_ENABLED,
			GzjlModelImpl.FINDER_CACHE_ENABLED, GzjlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GzjlModelImpl.ENTITY_CACHE_ENABLED,
			GzjlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GzjlPersistenceImpl() {
		setModelClass(Gzjl.class);
	}

	/**
	 * Caches the gzjl in the entity cache if it is enabled.
	 *
	 * @param gzjl the gzjl
	 */
	@Override
	public void cacheResult(Gzjl gzjl) {
		EntityCacheUtil.putResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
			GzjlImpl.class, gzjl.getPrimaryKey(), gzjl);

		gzjl.resetOriginalValues();
	}

	/**
	 * Caches the gzjls in the entity cache if it is enabled.
	 *
	 * @param gzjls the gzjls
	 */
	@Override
	public void cacheResult(List<Gzjl> gzjls) {
		for (Gzjl gzjl : gzjls) {
			if (EntityCacheUtil.getResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
						GzjlImpl.class, gzjl.getPrimaryKey()) == null) {
				cacheResult(gzjl);
			}
			else {
				gzjl.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all gzjls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GzjlImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GzjlImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gzjl.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Gzjl gzjl) {
		EntityCacheUtil.removeResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
			GzjlImpl.class, gzjl.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Gzjl> gzjls) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Gzjl gzjl : gzjls) {
			EntityCacheUtil.removeResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
				GzjlImpl.class, gzjl.getPrimaryKey());
		}
	}

	/**
	 * Creates a new gzjl with the primary key. Does not add the gzjl to the database.
	 *
	 * @param GzjlId the primary key for the new gzjl
	 * @return the new gzjl
	 */
	@Override
	public Gzjl create(long GzjlId) {
		Gzjl gzjl = new GzjlImpl();

		gzjl.setNew(true);
		gzjl.setPrimaryKey(GzjlId);

		return gzjl;
	}

	/**
	 * Removes the gzjl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param GzjlId the primary key of the gzjl
	 * @return the gzjl that was removed
	 * @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gzjl remove(long GzjlId) throws NoSuchGzjlException, SystemException {
		return remove((Serializable)GzjlId);
	}

	/**
	 * Removes the gzjl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gzjl
	 * @return the gzjl that was removed
	 * @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gzjl remove(Serializable primaryKey)
		throws NoSuchGzjlException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Gzjl gzjl = (Gzjl)session.get(GzjlImpl.class, primaryKey);

			if (gzjl == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGzjlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gzjl);
		}
		catch (NoSuchGzjlException nsee) {
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
	protected Gzjl removeImpl(Gzjl gzjl) throws SystemException {
		gzjl = toUnwrappedModel(gzjl);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gzjl)) {
				gzjl = (Gzjl)session.get(GzjlImpl.class, gzjl.getPrimaryKeyObj());
			}

			if (gzjl != null) {
				session.delete(gzjl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gzjl != null) {
			clearCache(gzjl);
		}

		return gzjl;
	}

	@Override
	public Gzjl updateImpl(com.justonetech.expert.model.Gzjl gzjl)
		throws SystemException {
		gzjl = toUnwrappedModel(gzjl);

		boolean isNew = gzjl.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gzjl.isNew()) {
				session.save(gzjl);

				gzjl.setNew(false);
			}
			else {
				session.merge(gzjl);
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

		EntityCacheUtil.putResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
			GzjlImpl.class, gzjl.getPrimaryKey(), gzjl);

		return gzjl;
	}

	protected Gzjl toUnwrappedModel(Gzjl gzjl) {
		if (gzjl instanceof GzjlImpl) {
			return gzjl;
		}

		GzjlImpl gzjlImpl = new GzjlImpl();

		gzjlImpl.setNew(gzjl.isNew());
		gzjlImpl.setPrimaryKey(gzjl.getPrimaryKey());

		gzjlImpl.setGzjlId(gzjl.getGzjlId());
		gzjlImpl.setExpertId(gzjl.getExpertId());
		gzjlImpl.setGzdw(gzjl.getGzdw());
		gzjlImpl.setQzny(gzjl.getQzny());
		gzjlImpl.setCszyzygz(gzjl.getCszyzygz());
		gzjlImpl.setZw(gzjl.getZw());

		return gzjlImpl;
	}

	/**
	 * Returns the gzjl with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the gzjl
	 * @return the gzjl
	 * @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gzjl findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGzjlException, SystemException {
		Gzjl gzjl = fetchByPrimaryKey(primaryKey);

		if (gzjl == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGzjlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gzjl;
	}

	/**
	 * Returns the gzjl with the primary key or throws a {@link com.justonetech.expert.NoSuchGzjlException} if it could not be found.
	 *
	 * @param GzjlId the primary key of the gzjl
	 * @return the gzjl
	 * @throws com.justonetech.expert.NoSuchGzjlException if a gzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gzjl findByPrimaryKey(long GzjlId)
		throws NoSuchGzjlException, SystemException {
		return findByPrimaryKey((Serializable)GzjlId);
	}

	/**
	 * Returns the gzjl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gzjl
	 * @return the gzjl, or <code>null</code> if a gzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gzjl fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Gzjl gzjl = (Gzjl)EntityCacheUtil.getResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
				GzjlImpl.class, primaryKey);

		if (gzjl == _nullGzjl) {
			return null;
		}

		if (gzjl == null) {
			Session session = null;

			try {
				session = openSession();

				gzjl = (Gzjl)session.get(GzjlImpl.class, primaryKey);

				if (gzjl != null) {
					cacheResult(gzjl);
				}
				else {
					EntityCacheUtil.putResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
						GzjlImpl.class, primaryKey, _nullGzjl);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GzjlModelImpl.ENTITY_CACHE_ENABLED,
					GzjlImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gzjl;
	}

	/**
	 * Returns the gzjl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param GzjlId the primary key of the gzjl
	 * @return the gzjl, or <code>null</code> if a gzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Gzjl fetchByPrimaryKey(long GzjlId) throws SystemException {
		return fetchByPrimaryKey((Serializable)GzjlId);
	}

	/**
	 * Returns all the gzjls.
	 *
	 * @return the gzjls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gzjl> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gzjls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gzjls
	 * @param end the upper bound of the range of gzjls (not inclusive)
	 * @return the range of gzjls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gzjl> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gzjls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.GzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of gzjls
	 * @param end the upper bound of the range of gzjls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gzjls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Gzjl> findAll(int start, int end,
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

		List<Gzjl> list = (List<Gzjl>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GZJL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GZJL;

				if (pagination) {
					sql = sql.concat(GzjlModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Gzjl>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Gzjl>(list);
				}
				else {
					list = (List<Gzjl>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the gzjls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Gzjl gzjl : findAll()) {
			remove(gzjl);
		}
	}

	/**
	 * Returns the number of gzjls.
	 *
	 * @return the number of gzjls
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

				Query q = session.createQuery(_SQL_COUNT_GZJL);

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
	 * Initializes the gzjl persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.expert.model.Gzjl")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Gzjl>> listenersList = new ArrayList<ModelListener<Gzjl>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Gzjl>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GzjlImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GZJL = "SELECT gzjl FROM Gzjl gzjl";
	private static final String _SQL_COUNT_GZJL = "SELECT COUNT(gzjl) FROM Gzjl gzjl";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gzjl.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Gzjl exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GzjlPersistenceImpl.class);
	private static Gzjl _nullGzjl = new GzjlImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Gzjl> toCacheModel() {
				return _nullGzjlCacheModel;
			}
		};

	private static CacheModel<Gzjl> _nullGzjlCacheModel = new CacheModel<Gzjl>() {
			@Override
			public Gzjl toEntityModel() {
				return _nullGzjl;
			}
		};
}