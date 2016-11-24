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

import com.justonetech.expert.NoSuchXlxxException;
import com.justonetech.expert.model.Xlxx;
import com.justonetech.expert.model.impl.XlxxImpl;
import com.justonetech.expert.model.impl.XlxxModelImpl;

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
 * The persistence implementation for the xlxx service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see XlxxPersistence
 * @see XlxxUtil
 * @generated
 */
public class XlxxPersistenceImpl extends BasePersistenceImpl<Xlxx>
	implements XlxxPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link XlxxUtil} to access the xlxx persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = XlxxImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(XlxxModelImpl.ENTITY_CACHE_ENABLED,
			XlxxModelImpl.FINDER_CACHE_ENABLED, XlxxImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(XlxxModelImpl.ENTITY_CACHE_ENABLED,
			XlxxModelImpl.FINDER_CACHE_ENABLED, XlxxImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(XlxxModelImpl.ENTITY_CACHE_ENABLED,
			XlxxModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public XlxxPersistenceImpl() {
		setModelClass(Xlxx.class);
	}

	/**
	 * Caches the xlxx in the entity cache if it is enabled.
	 *
	 * @param xlxx the xlxx
	 */
	@Override
	public void cacheResult(Xlxx xlxx) {
		EntityCacheUtil.putResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
			XlxxImpl.class, xlxx.getPrimaryKey(), xlxx);

		xlxx.resetOriginalValues();
	}

	/**
	 * Caches the xlxxs in the entity cache if it is enabled.
	 *
	 * @param xlxxs the xlxxs
	 */
	@Override
	public void cacheResult(List<Xlxx> xlxxs) {
		for (Xlxx xlxx : xlxxs) {
			if (EntityCacheUtil.getResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
						XlxxImpl.class, xlxx.getPrimaryKey()) == null) {
				cacheResult(xlxx);
			}
			else {
				xlxx.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all xlxxs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(XlxxImpl.class.getName());
		}

		EntityCacheUtil.clearCache(XlxxImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the xlxx.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Xlxx xlxx) {
		EntityCacheUtil.removeResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
			XlxxImpl.class, xlxx.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Xlxx> xlxxs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Xlxx xlxx : xlxxs) {
			EntityCacheUtil.removeResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
				XlxxImpl.class, xlxx.getPrimaryKey());
		}
	}

	/**
	 * Creates a new xlxx with the primary key. Does not add the xlxx to the database.
	 *
	 * @param xlxxId the primary key for the new xlxx
	 * @return the new xlxx
	 */
	@Override
	public Xlxx create(long xlxxId) {
		Xlxx xlxx = new XlxxImpl();

		xlxx.setNew(true);
		xlxx.setPrimaryKey(xlxxId);

		return xlxx;
	}

	/**
	 * Removes the xlxx with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param xlxxId the primary key of the xlxx
	 * @return the xlxx that was removed
	 * @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Xlxx remove(long xlxxId) throws NoSuchXlxxException, SystemException {
		return remove((Serializable)xlxxId);
	}

	/**
	 * Removes the xlxx with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the xlxx
	 * @return the xlxx that was removed
	 * @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Xlxx remove(Serializable primaryKey)
		throws NoSuchXlxxException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Xlxx xlxx = (Xlxx)session.get(XlxxImpl.class, primaryKey);

			if (xlxx == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchXlxxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(xlxx);
		}
		catch (NoSuchXlxxException nsee) {
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
	protected Xlxx removeImpl(Xlxx xlxx) throws SystemException {
		xlxx = toUnwrappedModel(xlxx);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(xlxx)) {
				xlxx = (Xlxx)session.get(XlxxImpl.class, xlxx.getPrimaryKeyObj());
			}

			if (xlxx != null) {
				session.delete(xlxx);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (xlxx != null) {
			clearCache(xlxx);
		}

		return xlxx;
	}

	@Override
	public Xlxx updateImpl(com.justonetech.expert.model.Xlxx xlxx)
		throws SystemException {
		xlxx = toUnwrappedModel(xlxx);

		boolean isNew = xlxx.isNew();

		Session session = null;

		try {
			session = openSession();

			if (xlxx.isNew()) {
				session.save(xlxx);

				xlxx.setNew(false);
			}
			else {
				session.merge(xlxx);
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

		EntityCacheUtil.putResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
			XlxxImpl.class, xlxx.getPrimaryKey(), xlxx);

		return xlxx;
	}

	protected Xlxx toUnwrappedModel(Xlxx xlxx) {
		if (xlxx instanceof XlxxImpl) {
			return xlxx;
		}

		XlxxImpl xlxxImpl = new XlxxImpl();

		xlxxImpl.setNew(xlxx.isNew());
		xlxxImpl.setPrimaryKey(xlxx.getPrimaryKey());

		xlxxImpl.setXlxxId(xlxx.getXlxxId());
		xlxxImpl.setByyx(xlxx.getByyx());
		xlxxImpl.setSxzy(xlxx.getSxzy());
		xlxxImpl.setXlhxw(xlxx.getXlhxw());
		xlxxImpl.setZxsj(xlxx.getZxsj());

		return xlxxImpl;
	}

	/**
	 * Returns the xlxx with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the xlxx
	 * @return the xlxx
	 * @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Xlxx findByPrimaryKey(Serializable primaryKey)
		throws NoSuchXlxxException, SystemException {
		Xlxx xlxx = fetchByPrimaryKey(primaryKey);

		if (xlxx == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchXlxxException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return xlxx;
	}

	/**
	 * Returns the xlxx with the primary key or throws a {@link com.justonetech.expert.NoSuchXlxxException} if it could not be found.
	 *
	 * @param xlxxId the primary key of the xlxx
	 * @return the xlxx
	 * @throws com.justonetech.expert.NoSuchXlxxException if a xlxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Xlxx findByPrimaryKey(long xlxxId)
		throws NoSuchXlxxException, SystemException {
		return findByPrimaryKey((Serializable)xlxxId);
	}

	/**
	 * Returns the xlxx with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the xlxx
	 * @return the xlxx, or <code>null</code> if a xlxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Xlxx fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Xlxx xlxx = (Xlxx)EntityCacheUtil.getResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
				XlxxImpl.class, primaryKey);

		if (xlxx == _nullXlxx) {
			return null;
		}

		if (xlxx == null) {
			Session session = null;

			try {
				session = openSession();

				xlxx = (Xlxx)session.get(XlxxImpl.class, primaryKey);

				if (xlxx != null) {
					cacheResult(xlxx);
				}
				else {
					EntityCacheUtil.putResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
						XlxxImpl.class, primaryKey, _nullXlxx);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(XlxxModelImpl.ENTITY_CACHE_ENABLED,
					XlxxImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return xlxx;
	}

	/**
	 * Returns the xlxx with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param xlxxId the primary key of the xlxx
	 * @return the xlxx, or <code>null</code> if a xlxx with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Xlxx fetchByPrimaryKey(long xlxxId) throws SystemException {
		return fetchByPrimaryKey((Serializable)xlxxId);
	}

	/**
	 * Returns all the xlxxs.
	 *
	 * @return the xlxxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Xlxx> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the xlxxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.XlxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of xlxxs
	 * @param end the upper bound of the range of xlxxs (not inclusive)
	 * @return the range of xlxxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Xlxx> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the xlxxs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.XlxxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of xlxxs
	 * @param end the upper bound of the range of xlxxs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of xlxxs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Xlxx> findAll(int start, int end,
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

		List<Xlxx> list = (List<Xlxx>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_XLXX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_XLXX;

				if (pagination) {
					sql = sql.concat(XlxxModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Xlxx>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Xlxx>(list);
				}
				else {
					list = (List<Xlxx>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the xlxxs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Xlxx xlxx : findAll()) {
			remove(xlxx);
		}
	}

	/**
	 * Returns the number of xlxxs.
	 *
	 * @return the number of xlxxs
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

				Query q = session.createQuery(_SQL_COUNT_XLXX);

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
	 * Initializes the xlxx persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.expert.model.Xlxx")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Xlxx>> listenersList = new ArrayList<ModelListener<Xlxx>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Xlxx>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(XlxxImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_XLXX = "SELECT xlxx FROM Xlxx xlxx";
	private static final String _SQL_COUNT_XLXX = "SELECT COUNT(xlxx) FROM Xlxx xlxx";
	private static final String _ORDER_BY_ENTITY_ALIAS = "xlxx.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Xlxx exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(XlxxPersistenceImpl.class);
	private static Xlxx _nullXlxx = new XlxxImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Xlxx> toCacheModel() {
				return _nullXlxxCacheModel;
			}
		};

	private static CacheModel<Xlxx> _nullXlxxCacheModel = new CacheModel<Xlxx>() {
			@Override
			public Xlxx toEntityModel() {
				return _nullXlxx;
			}
		};
}