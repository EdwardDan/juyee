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

import com.justonetech.expert.NoSuchJbxxException;
import com.justonetech.expert.model.Jbxx;
import com.justonetech.expert.model.impl.JbxxImpl;
import com.justonetech.expert.model.impl.JbxxModelImpl;

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
 * The persistence implementation for the jbxx service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see JbxxPersistence
 * @see JbxxUtil
 * @generated
 */
public class JbxxPersistenceImpl extends BasePersistenceImpl<Jbxx>
	implements JbxxPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JbxxUtil} to access the jbxx persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JbxxImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JbxxModelImpl.ENTITY_CACHE_ENABLED,
			JbxxModelImpl.FINDER_CACHE_ENABLED, JbxxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JbxxModelImpl.ENTITY_CACHE_ENABLED,
			JbxxModelImpl.FINDER_CACHE_ENABLED, JbxxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JbxxModelImpl.ENTITY_CACHE_ENABLED,
			JbxxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public JbxxPersistenceImpl() {
		setModelClass(Jbxx.class);
	}

	/**
	 * Caches the jbxx in the entity cache if it is enabled.
	 *
	 * @param jbxx the jbxx
	 */
	@Override
	public void cacheResult(Jbxx jbxx) {
		EntityCacheUtil.putResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
			JbxxImpl.class, jbxx.getPrimaryKey(), jbxx);

		jbxx.resetOriginalValues();
	}

	/**
	 * Caches the jbxxs in the entity cache if it is enabled.
	 *
	 * @param jbxxs the jbxxs
	 */
	@Override
	public void cacheResult(List<Jbxx> jbxxs) {
		for (Jbxx jbxx : jbxxs) {
			if (EntityCacheUtil.getResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
						JbxxImpl.class, jbxx.getPrimaryKey()) == null) {
				cacheResult(jbxx);
			}
			else {
				jbxx.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all jbxxs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JbxxImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JbxxImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the jbxx.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Jbxx jbxx) {
		EntityCacheUtil.removeResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
			JbxxImpl.class, jbxx.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Jbxx> jbxxs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Jbxx jbxx : jbxxs) {
			EntityCacheUtil.removeResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
				JbxxImpl.class, jbxx.getPrimaryKey());
		}
	}

	/**
	 * Creates a new jbxx with the primary key. Does not add the jbxx to the database.
	 *
	 * @param jbxxId the primary key for the new jbxx
	 * @return the new jbxx
	 */
	@Override
	public Jbxx create(long jbxxId) {
		Jbxx jbxx = new JbxxImpl();

		jbxx.setNew(true);
		jbxx.setPrimaryKey(jbxxId);

		return jbxx;
	}

	/**
	 * Removes the jbxx with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jbxxId the primary key of the jbxx
	 * @return the jbxx that was removed
	 * @throws com.justonetech.expert.NoSuchJbxxException if a jbxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jbxx remove(long jbxxId) throws NoSuchJbxxException, SystemException {
		return remove((Serializable)jbxxId);
	}

	/**
	 * Removes the jbxx with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the jbxx
	 * @return the jbxx that was removed
	 * @throws com.justonetech.expert.NoSuchJbxxException if a jbxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jbxx remove(Serializable primaryKey)
		throws NoSuchJbxxException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Jbxx jbxx = (Jbxx)session.get(JbxxImpl.class, primaryKey);

			if (jbxx == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJbxxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jbxx);
		}
		catch (NoSuchJbxxException nsee) {
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
	protected Jbxx removeImpl(Jbxx jbxx) throws SystemException {
		jbxx = toUnwrappedModel(jbxx);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jbxx)) {
				jbxx = (Jbxx)session.get(JbxxImpl.class, jbxx.getPrimaryKeyObj());
			}

			if (jbxx != null) {
				session.delete(jbxx);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jbxx != null) {
			clearCache(jbxx);
		}

		return jbxx;
	}

	@Override
	public Jbxx updateImpl(com.justonetech.expert.model.Jbxx jbxx)
		throws SystemException {
		jbxx = toUnwrappedModel(jbxx);

		boolean isNew = jbxx.isNew();

		Session session = null;

		try {
			session = openSession();

			if (jbxx.isNew()) {
				session.save(jbxx);

				jbxx.setNew(false);
			}
			else {
				session.merge(jbxx);
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

		EntityCacheUtil.putResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
			JbxxImpl.class, jbxx.getPrimaryKey(), jbxx);

		return jbxx;
	}

	protected Jbxx toUnwrappedModel(Jbxx jbxx) {
		if (jbxx instanceof JbxxImpl) {
			return jbxx;
		}

		JbxxImpl jbxxImpl = new JbxxImpl();

		jbxxImpl.setNew(jbxx.isNew());
		jbxxImpl.setPrimaryKey(jbxx.getPrimaryKey());

		jbxxImpl.setJbxxId(jbxx.getJbxxId());
		jbxxImpl.setXm(jbxx.getXm());
		jbxxImpl.setXb(jbxx.getXb());
		jbxxImpl.setSfzh(jbxx.getSfzh());
		jbxxImpl.setCsny(jbxx.getCsny());
		jbxxImpl.setGzdw(jbxx.getGzdw());
		jbxxImpl.setDzyx(jbxx.getDzyx());
		jbxxImpl.setTxdz(jbxx.getTxdz());
		jbxxImpl.setYzbm(jbxx.getYzbm());
		jbxxImpl.setXrzw(jbxx.getXrzw());
		jbxxImpl.setZc(jbxx.getZc());
		jbxxImpl.setZyzg(jbxx.getZyzg());
		jbxxImpl.setCszy(jbxx.getCszy());
		jbxxImpl.setZygznx(jbxx.getZygznx());
		jbxxImpl.setSjhm(jbxx.getSjhm());
		jbxxImpl.setLxdh(jbxx.getLxdh());
		jbxxImpl.setCz(jbxx.getCz());

		return jbxxImpl;
	}

	/**
	 * Returns the jbxx with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the jbxx
	 * @return the jbxx
	 * @throws com.justonetech.expert.NoSuchJbxxException if a jbxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jbxx findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJbxxException, SystemException {
		Jbxx jbxx = fetchByPrimaryKey(primaryKey);

		if (jbxx == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJbxxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jbxx;
	}

	/**
	 * Returns the jbxx with the primary key or throws a {@link com.justonetech.expert.NoSuchJbxxException} if it could not be found.
	 *
	 * @param jbxxId the primary key of the jbxx
	 * @return the jbxx
	 * @throws com.justonetech.expert.NoSuchJbxxException if a jbxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jbxx findByPrimaryKey(long jbxxId)
		throws NoSuchJbxxException, SystemException {
		return findByPrimaryKey((Serializable)jbxxId);
	}

	/**
	 * Returns the jbxx with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the jbxx
	 * @return the jbxx, or <code>null</code> if a jbxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jbxx fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Jbxx jbxx = (Jbxx)EntityCacheUtil.getResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
				JbxxImpl.class, primaryKey);

		if (jbxx == _nullJbxx) {
			return null;
		}

		if (jbxx == null) {
			Session session = null;

			try {
				session = openSession();

				jbxx = (Jbxx)session.get(JbxxImpl.class, primaryKey);

				if (jbxx != null) {
					cacheResult(jbxx);
				}
				else {
					EntityCacheUtil.putResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
						JbxxImpl.class, primaryKey, _nullJbxx);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JbxxModelImpl.ENTITY_CACHE_ENABLED,
					JbxxImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jbxx;
	}

	/**
	 * Returns the jbxx with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jbxxId the primary key of the jbxx
	 * @return the jbxx, or <code>null</code> if a jbxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Jbxx fetchByPrimaryKey(long jbxxId) throws SystemException {
		return fetchByPrimaryKey((Serializable)jbxxId);
	}

	/**
	 * Returns all the jbxxs.
	 *
	 * @return the jbxxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Jbxx> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the jbxxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.JbxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jbxxs
	 * @param end the upper bound of the range of jbxxs (not inclusive)
	 * @return the range of jbxxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Jbxx> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the jbxxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.JbxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of jbxxs
	 * @param end the upper bound of the range of jbxxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of jbxxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Jbxx> findAll(int start, int end,
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

		List<Jbxx> list = (List<Jbxx>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JBXX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JBXX;

				if (pagination) {
					sql = sql.concat(JbxxModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Jbxx>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Jbxx>(list);
				}
				else {
					list = (List<Jbxx>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the jbxxs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Jbxx jbxx : findAll()) {
			remove(jbxx);
		}
	}

	/**
	 * Returns the number of jbxxs.
	 *
	 * @return the number of jbxxs
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

				Query q = session.createQuery(_SQL_COUNT_JBXX);

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
	 * Initializes the jbxx persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.expert.model.Jbxx")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Jbxx>> listenersList = new ArrayList<ModelListener<Jbxx>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Jbxx>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JbxxImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JBXX = "SELECT jbxx FROM Jbxx jbxx";
	private static final String _SQL_COUNT_JBXX = "SELECT COUNT(jbxx) FROM Jbxx jbxx";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jbxx.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Jbxx exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JbxxPersistenceImpl.class);
	private static Jbxx _nullJbxx = new JbxxImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Jbxx> toCacheModel() {
				return _nullJbxxCacheModel;
			}
		};

	private static CacheModel<Jbxx> _nullJbxxCacheModel = new CacheModel<Jbxx>() {
			@Override
			public Jbxx toEntityModel() {
				return _nullJbxx;
			}
		};
}