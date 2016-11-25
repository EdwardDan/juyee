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

import com.justonetech.expert.NoSuchExpertException;
import com.justonetech.expert.model.Expert;
import com.justonetech.expert.model.impl.ExpertImpl;
import com.justonetech.expert.model.impl.ExpertModelImpl;

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
 * The persistence implementation for the expert service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ExpertPersistence
 * @see ExpertUtil
 * @generated
 */
public class ExpertPersistenceImpl extends BasePersistenceImpl<Expert>
	implements ExpertPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExpertUtil} to access the expert persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExpertImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExpertModelImpl.ENTITY_CACHE_ENABLED,
			ExpertModelImpl.FINDER_CACHE_ENABLED, ExpertImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExpertModelImpl.ENTITY_CACHE_ENABLED,
			ExpertModelImpl.FINDER_CACHE_ENABLED, ExpertImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpertModelImpl.ENTITY_CACHE_ENABLED,
			ExpertModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ExpertPersistenceImpl() {
		setModelClass(Expert.class);
	}

	/**
	 * Caches the expert in the entity cache if it is enabled.
	 *
	 * @param expert the expert
	 */
	@Override
	public void cacheResult(Expert expert) {
		EntityCacheUtil.putResult(ExpertModelImpl.ENTITY_CACHE_ENABLED,
			ExpertImpl.class, expert.getPrimaryKey(), expert);

		expert.resetOriginalValues();
	}

	/**
	 * Caches the experts in the entity cache if it is enabled.
	 *
	 * @param experts the experts
	 */
	@Override
	public void cacheResult(List<Expert> experts) {
		for (Expert expert : experts) {
			if (EntityCacheUtil.getResult(
						ExpertModelImpl.ENTITY_CACHE_ENABLED, ExpertImpl.class,
						expert.getPrimaryKey()) == null) {
				cacheResult(expert);
			}
			else {
				expert.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all experts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExpertImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExpertImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expert.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Expert expert) {
		EntityCacheUtil.removeResult(ExpertModelImpl.ENTITY_CACHE_ENABLED,
			ExpertImpl.class, expert.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Expert> experts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Expert expert : experts) {
			EntityCacheUtil.removeResult(ExpertModelImpl.ENTITY_CACHE_ENABLED,
				ExpertImpl.class, expert.getPrimaryKey());
		}
	}

	/**
	 * Creates a new expert with the primary key. Does not add the expert to the database.
	 *
	 * @param expertId the primary key for the new expert
	 * @return the new expert
	 */
	@Override
	public Expert create(long expertId) {
		Expert expert = new ExpertImpl();

		expert.setNew(true);
		expert.setPrimaryKey(expertId);

		return expert;
	}

	/**
	 * Removes the expert with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expertId the primary key of the expert
	 * @return the expert that was removed
	 * @throws com.justonetech.expert.NoSuchExpertException if a expert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expert remove(long expertId)
		throws NoSuchExpertException, SystemException {
		return remove((Serializable)expertId);
	}

	/**
	 * Removes the expert with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expert
	 * @return the expert that was removed
	 * @throws com.justonetech.expert.NoSuchExpertException if a expert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expert remove(Serializable primaryKey)
		throws NoSuchExpertException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Expert expert = (Expert)session.get(ExpertImpl.class, primaryKey);

			if (expert == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpertException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(expert);
		}
		catch (NoSuchExpertException nsee) {
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
	protected Expert removeImpl(Expert expert) throws SystemException {
		expert = toUnwrappedModel(expert);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expert)) {
				expert = (Expert)session.get(ExpertImpl.class,
						expert.getPrimaryKeyObj());
			}

			if (expert != null) {
				session.delete(expert);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expert != null) {
			clearCache(expert);
		}

		return expert;
	}

	@Override
	public Expert updateImpl(com.justonetech.expert.model.Expert expert)
		throws SystemException {
		expert = toUnwrappedModel(expert);

		boolean isNew = expert.isNew();

		Session session = null;

		try {
			session = openSession();

			if (expert.isNew()) {
				session.save(expert);

				expert.setNew(false);
			}
			else {
				session.merge(expert);
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

		EntityCacheUtil.putResult(ExpertModelImpl.ENTITY_CACHE_ENABLED,
			ExpertImpl.class, expert.getPrimaryKey(), expert);

		return expert;
	}

	protected Expert toUnwrappedModel(Expert expert) {
		if (expert instanceof ExpertImpl) {
			return expert;
		}

		ExpertImpl expertImpl = new ExpertImpl();

		expertImpl.setNew(expert.isNew());
		expertImpl.setPrimaryKey(expert.getPrimaryKey());

		expertImpl.setExpertId(expert.getExpertId());
		expertImpl.setXm(expert.getXm());
		expertImpl.setXb(expert.getXb());
		expertImpl.setSfzh(expert.getSfzh());
		expertImpl.setCsny(expert.getCsny());
		expertImpl.setGzdw(expert.getGzdw());
		expertImpl.setDzyx(expert.getDzyx());
		expertImpl.setTxdz(expert.getTxdz());
		expertImpl.setYzbm(expert.getYzbm());
		expertImpl.setXrzw(expert.getXrzw());
		expertImpl.setZc(expert.getZc());
		expertImpl.setZyzg(expert.getZyzg());
		expertImpl.setCszy(expert.getCszy());
		expertImpl.setZygznx(expert.getZygznx());
		expertImpl.setSjhm(expert.getSjhm());
		expertImpl.setLxdh(expert.getLxdh());
		expertImpl.setCz(expert.getCz());
		expertImpl.setSqbz(expert.getSqbz());

		return expertImpl;
	}

	/**
	 * Returns the expert with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expert
	 * @return the expert
	 * @throws com.justonetech.expert.NoSuchExpertException if a expert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expert findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpertException, SystemException {
		Expert expert = fetchByPrimaryKey(primaryKey);

		if (expert == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpertException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return expert;
	}

	/**
	 * Returns the expert with the primary key or throws a {@link com.justonetech.expert.NoSuchExpertException} if it could not be found.
	 *
	 * @param expertId the primary key of the expert
	 * @return the expert
	 * @throws com.justonetech.expert.NoSuchExpertException if a expert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expert findByPrimaryKey(long expertId)
		throws NoSuchExpertException, SystemException {
		return findByPrimaryKey((Serializable)expertId);
	}

	/**
	 * Returns the expert with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expert
	 * @return the expert, or <code>null</code> if a expert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expert fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Expert expert = (Expert)EntityCacheUtil.getResult(ExpertModelImpl.ENTITY_CACHE_ENABLED,
				ExpertImpl.class, primaryKey);

		if (expert == _nullExpert) {
			return null;
		}

		if (expert == null) {
			Session session = null;

			try {
				session = openSession();

				expert = (Expert)session.get(ExpertImpl.class, primaryKey);

				if (expert != null) {
					cacheResult(expert);
				}
				else {
					EntityCacheUtil.putResult(ExpertModelImpl.ENTITY_CACHE_ENABLED,
						ExpertImpl.class, primaryKey, _nullExpert);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExpertModelImpl.ENTITY_CACHE_ENABLED,
					ExpertImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return expert;
	}

	/**
	 * Returns the expert with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expertId the primary key of the expert
	 * @return the expert, or <code>null</code> if a expert with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Expert fetchByPrimaryKey(long expertId) throws SystemException {
		return fetchByPrimaryKey((Serializable)expertId);
	}

	/**
	 * Returns all the experts.
	 *
	 * @return the experts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expert> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ExpertModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experts
	 * @param end the upper bound of the range of experts (not inclusive)
	 * @return the range of experts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expert> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the experts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ExpertModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experts
	 * @param end the upper bound of the range of experts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Expert> findAll(int start, int end,
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

		List<Expert> list = (List<Expert>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXPERT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPERT;

				if (pagination) {
					sql = sql.concat(ExpertModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Expert>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Expert>(list);
				}
				else {
					list = (List<Expert>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the experts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Expert expert : findAll()) {
			remove(expert);
		}
	}

	/**
	 * Returns the number of experts.
	 *
	 * @return the number of experts
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

				Query q = session.createQuery(_SQL_COUNT_EXPERT);

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
	 * Initializes the expert persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.expert.model.Expert")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Expert>> listenersList = new ArrayList<ModelListener<Expert>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Expert>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExpertImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXPERT = "SELECT expert FROM Expert expert";
	private static final String _SQL_COUNT_EXPERT = "SELECT COUNT(expert) FROM Expert expert";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expert.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Expert exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExpertPersistenceImpl.class);
	private static Expert _nullExpert = new ExpertImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Expert> toCacheModel() {
				return _nullExpertCacheModel;
			}
		};

	private static CacheModel<Expert> _nullExpertCacheModel = new CacheModel<Expert>() {
			@Override
			public Expert toEntityModel() {
				return _nullExpert;
			}
		};
}