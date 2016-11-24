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

import com.justonetech.expert.NoSuchZzjlException;
import com.justonetech.expert.model.Zzjl;
import com.justonetech.expert.model.impl.ZzjlImpl;
import com.justonetech.expert.model.impl.ZzjlModelImpl;

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
 * The persistence implementation for the zzjl service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ZzjlPersistence
 * @see ZzjlUtil
 * @generated
 */
public class ZzjlPersistenceImpl extends BasePersistenceImpl<Zzjl>
	implements ZzjlPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ZzjlUtil} to access the zzjl persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ZzjlImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
			ZzjlModelImpl.FINDER_CACHE_ENABLED, ZzjlImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
			ZzjlModelImpl.FINDER_CACHE_ENABLED, ZzjlImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
			ZzjlModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ZzjlPersistenceImpl() {
		setModelClass(Zzjl.class);
	}

	/**
	 * Caches the zzjl in the entity cache if it is enabled.
	 *
	 * @param zzjl the zzjl
	 */
	@Override
	public void cacheResult(Zzjl zzjl) {
		EntityCacheUtil.putResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
			ZzjlImpl.class, zzjl.getPrimaryKey(), zzjl);

		zzjl.resetOriginalValues();
	}

	/**
	 * Caches the zzjls in the entity cache if it is enabled.
	 *
	 * @param zzjls the zzjls
	 */
	@Override
	public void cacheResult(List<Zzjl> zzjls) {
		for (Zzjl zzjl : zzjls) {
			if (EntityCacheUtil.getResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
						ZzjlImpl.class, zzjl.getPrimaryKey()) == null) {
				cacheResult(zzjl);
			}
			else {
				zzjl.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all zzjls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ZzjlImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ZzjlImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the zzjl.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Zzjl zzjl) {
		EntityCacheUtil.removeResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
			ZzjlImpl.class, zzjl.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Zzjl> zzjls) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Zzjl zzjl : zzjls) {
			EntityCacheUtil.removeResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
				ZzjlImpl.class, zzjl.getPrimaryKey());
		}
	}

	/**
	 * Creates a new zzjl with the primary key. Does not add the zzjl to the database.
	 *
	 * @param zzjlId the primary key for the new zzjl
	 * @return the new zzjl
	 */
	@Override
	public Zzjl create(long zzjlId) {
		Zzjl zzjl = new ZzjlImpl();

		zzjl.setNew(true);
		zzjl.setPrimaryKey(zzjlId);

		return zzjl;
	}

	/**
	 * Removes the zzjl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param zzjlId the primary key of the zzjl
	 * @return the zzjl that was removed
	 * @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zzjl remove(long zzjlId) throws NoSuchZzjlException, SystemException {
		return remove((Serializable)zzjlId);
	}

	/**
	 * Removes the zzjl with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the zzjl
	 * @return the zzjl that was removed
	 * @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zzjl remove(Serializable primaryKey)
		throws NoSuchZzjlException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Zzjl zzjl = (Zzjl)session.get(ZzjlImpl.class, primaryKey);

			if (zzjl == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchZzjlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(zzjl);
		}
		catch (NoSuchZzjlException nsee) {
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
	protected Zzjl removeImpl(Zzjl zzjl) throws SystemException {
		zzjl = toUnwrappedModel(zzjl);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(zzjl)) {
				zzjl = (Zzjl)session.get(ZzjlImpl.class, zzjl.getPrimaryKeyObj());
			}

			if (zzjl != null) {
				session.delete(zzjl);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (zzjl != null) {
			clearCache(zzjl);
		}

		return zzjl;
	}

	@Override
	public Zzjl updateImpl(com.justonetech.expert.model.Zzjl zzjl)
		throws SystemException {
		zzjl = toUnwrappedModel(zzjl);

		boolean isNew = zzjl.isNew();

		Session session = null;

		try {
			session = openSession();

			if (zzjl.isNew()) {
				session.save(zzjl);

				zzjl.setNew(false);
			}
			else {
				session.merge(zzjl);
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

		EntityCacheUtil.putResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
			ZzjlImpl.class, zzjl.getPrimaryKey(), zzjl);

		return zzjl;
	}

	protected Zzjl toUnwrappedModel(Zzjl zzjl) {
		if (zzjl instanceof ZzjlImpl) {
			return zzjl;
		}

		ZzjlImpl zzjlImpl = new ZzjlImpl();

		zzjlImpl.setNew(zzjl.isNew());
		zzjlImpl.setPrimaryKey(zzjl.getPrimaryKey());

		zzjlImpl.setZzjlId(zzjl.getZzjlId());
		zzjlImpl.setExpertId(zzjl.getExpertId());
		zzjlImpl.setGzdw(zzjl.getGzdw());
		zzjlImpl.setQzny(zzjl.getQzny());
		zzjlImpl.setCszyzygz(zzjl.getCszyzygz());
		zzjlImpl.setZw(zzjl.getZw());

		return zzjlImpl;
	}

	/**
	 * Returns the zzjl with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the zzjl
	 * @return the zzjl
	 * @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zzjl findByPrimaryKey(Serializable primaryKey)
		throws NoSuchZzjlException, SystemException {
		Zzjl zzjl = fetchByPrimaryKey(primaryKey);

		if (zzjl == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchZzjlException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return zzjl;
	}

	/**
	 * Returns the zzjl with the primary key or throws a {@link com.justonetech.expert.NoSuchZzjlException} if it could not be found.
	 *
	 * @param zzjlId the primary key of the zzjl
	 * @return the zzjl
	 * @throws com.justonetech.expert.NoSuchZzjlException if a zzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zzjl findByPrimaryKey(long zzjlId)
		throws NoSuchZzjlException, SystemException {
		return findByPrimaryKey((Serializable)zzjlId);
	}

	/**
	 * Returns the zzjl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the zzjl
	 * @return the zzjl, or <code>null</code> if a zzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zzjl fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Zzjl zzjl = (Zzjl)EntityCacheUtil.getResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
				ZzjlImpl.class, primaryKey);

		if (zzjl == _nullZzjl) {
			return null;
		}

		if (zzjl == null) {
			Session session = null;

			try {
				session = openSession();

				zzjl = (Zzjl)session.get(ZzjlImpl.class, primaryKey);

				if (zzjl != null) {
					cacheResult(zzjl);
				}
				else {
					EntityCacheUtil.putResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
						ZzjlImpl.class, primaryKey, _nullZzjl);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ZzjlModelImpl.ENTITY_CACHE_ENABLED,
					ZzjlImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return zzjl;
	}

	/**
	 * Returns the zzjl with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param zzjlId the primary key of the zzjl
	 * @return the zzjl, or <code>null</code> if a zzjl with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zzjl fetchByPrimaryKey(long zzjlId) throws SystemException {
		return fetchByPrimaryKey((Serializable)zzjlId);
	}

	/**
	 * Returns all the zzjls.
	 *
	 * @return the zzjls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zzjl> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the zzjls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of zzjls
	 * @param end the upper bound of the range of zzjls (not inclusive)
	 * @return the range of zzjls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zzjl> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the zzjls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZzjlModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of zzjls
	 * @param end the upper bound of the range of zzjls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of zzjls
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zzjl> findAll(int start, int end,
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

		List<Zzjl> list = (List<Zzjl>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ZZJL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ZZJL;

				if (pagination) {
					sql = sql.concat(ZzjlModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Zzjl>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Zzjl>(list);
				}
				else {
					list = (List<Zzjl>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the zzjls from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Zzjl zzjl : findAll()) {
			remove(zzjl);
		}
	}

	/**
	 * Returns the number of zzjls.
	 *
	 * @return the number of zzjls
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

				Query q = session.createQuery(_SQL_COUNT_ZZJL);

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
	 * Initializes the zzjl persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.expert.model.Zzjl")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Zzjl>> listenersList = new ArrayList<ModelListener<Zzjl>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Zzjl>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ZzjlImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ZZJL = "SELECT zzjl FROM Zzjl zzjl";
	private static final String _SQL_COUNT_ZZJL = "SELECT COUNT(zzjl) FROM Zzjl zzjl";
	private static final String _ORDER_BY_ENTITY_ALIAS = "zzjl.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Zzjl exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ZzjlPersistenceImpl.class);
	private static Zzjl _nullZzjl = new ZzjlImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Zzjl> toCacheModel() {
				return _nullZzjlCacheModel;
			}
		};

	private static CacheModel<Zzjl> _nullZzjlCacheModel = new CacheModel<Zzjl>() {
			@Override
			public Zzjl toEntityModel() {
				return _nullZzjl;
			}
		};
}