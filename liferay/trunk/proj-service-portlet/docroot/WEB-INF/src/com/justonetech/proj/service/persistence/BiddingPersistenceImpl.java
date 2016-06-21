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

package com.justonetech.proj.service.persistence;

import com.justonetech.proj.NoSuchBiddingException;
import com.justonetech.proj.model.Bidding;
import com.justonetech.proj.model.impl.BiddingImpl;
import com.justonetech.proj.model.impl.BiddingModelImpl;

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
 * The persistence implementation for the bidding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see BiddingPersistence
 * @see BiddingUtil
 * @generated
 */
public class BiddingPersistenceImpl extends BasePersistenceImpl<Bidding>
	implements BiddingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiddingUtil} to access the bidding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiddingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiddingModelImpl.ENTITY_CACHE_ENABLED,
			BiddingModelImpl.FINDER_CACHE_ENABLED, BiddingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiddingModelImpl.ENTITY_CACHE_ENABLED,
			BiddingModelImpl.FINDER_CACHE_ENABLED, BiddingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiddingModelImpl.ENTITY_CACHE_ENABLED,
			BiddingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BiddingPersistenceImpl() {
		setModelClass(Bidding.class);
	}

	/**
	 * Caches the bidding in the entity cache if it is enabled.
	 *
	 * @param bidding the bidding
	 */
	@Override
	public void cacheResult(Bidding bidding) {
		EntityCacheUtil.putResult(BiddingModelImpl.ENTITY_CACHE_ENABLED,
			BiddingImpl.class, bidding.getPrimaryKey(), bidding);

		bidding.resetOriginalValues();
	}

	/**
	 * Caches the biddings in the entity cache if it is enabled.
	 *
	 * @param biddings the biddings
	 */
	@Override
	public void cacheResult(List<Bidding> biddings) {
		for (Bidding bidding : biddings) {
			if (EntityCacheUtil.getResult(
						BiddingModelImpl.ENTITY_CACHE_ENABLED,
						BiddingImpl.class, bidding.getPrimaryKey()) == null) {
				cacheResult(bidding);
			}
			else {
				bidding.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biddings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiddingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiddingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bidding.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Bidding bidding) {
		EntityCacheUtil.removeResult(BiddingModelImpl.ENTITY_CACHE_ENABLED,
			BiddingImpl.class, bidding.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Bidding> biddings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Bidding bidding : biddings) {
			EntityCacheUtil.removeResult(BiddingModelImpl.ENTITY_CACHE_ENABLED,
				BiddingImpl.class, bidding.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bidding with the primary key. Does not add the bidding to the database.
	 *
	 * @param biddingId the primary key for the new bidding
	 * @return the new bidding
	 */
	@Override
	public Bidding create(long biddingId) {
		Bidding bidding = new BiddingImpl();

		bidding.setNew(true);
		bidding.setPrimaryKey(biddingId);

		return bidding;
	}

	/**
	 * Removes the bidding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biddingId the primary key of the bidding
	 * @return the bidding that was removed
	 * @throws com.justonetech.proj.NoSuchBiddingException if a bidding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bidding remove(long biddingId)
		throws NoSuchBiddingException, SystemException {
		return remove((Serializable)biddingId);
	}

	/**
	 * Removes the bidding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bidding
	 * @return the bidding that was removed
	 * @throws com.justonetech.proj.NoSuchBiddingException if a bidding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bidding remove(Serializable primaryKey)
		throws NoSuchBiddingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Bidding bidding = (Bidding)session.get(BiddingImpl.class, primaryKey);

			if (bidding == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiddingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bidding);
		}
		catch (NoSuchBiddingException nsee) {
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
	protected Bidding removeImpl(Bidding bidding) throws SystemException {
		bidding = toUnwrappedModel(bidding);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bidding)) {
				bidding = (Bidding)session.get(BiddingImpl.class,
						bidding.getPrimaryKeyObj());
			}

			if (bidding != null) {
				session.delete(bidding);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bidding != null) {
			clearCache(bidding);
		}

		return bidding;
	}

	@Override
	public Bidding updateImpl(com.justonetech.proj.model.Bidding bidding)
		throws SystemException {
		bidding = toUnwrappedModel(bidding);

		boolean isNew = bidding.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bidding.isNew()) {
				session.save(bidding);

				bidding.setNew(false);
			}
			else {
				session.merge(bidding);
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

		EntityCacheUtil.putResult(BiddingModelImpl.ENTITY_CACHE_ENABLED,
			BiddingImpl.class, bidding.getPrimaryKey(), bidding);

		return bidding;
	}

	protected Bidding toUnwrappedModel(Bidding bidding) {
		if (bidding instanceof BiddingImpl) {
			return bidding;
		}

		BiddingImpl biddingImpl = new BiddingImpl();

		biddingImpl.setNew(bidding.isNew());
		biddingImpl.setPrimaryKey(bidding.getPrimaryKey());

		biddingImpl.setBiddingId(bidding.getBiddingId());
		biddingImpl.setUserId(bidding.getUserId());
		biddingImpl.setUserName(bidding.getUserName());
		biddingImpl.setCreateDate(bidding.getCreateDate());
		biddingImpl.setModifiedDate(bidding.getModifiedDate());
		biddingImpl.setBidCode(bidding.getBidCode());
		biddingImpl.setSortNo(bidding.getSortNo());
		biddingImpl.setBidName(bidding.getBidName());
		biddingImpl.setBidCategoryCode(bidding.getBidCategoryCode());
		biddingImpl.setBuildMileage(bidding.getBuildMileage());
		biddingImpl.setInvolveCounty(bidding.getInvolveCounty());
		biddingImpl.setProjLinkman(bidding.getProjLinkman());
		biddingImpl.setLinkTel(bidding.getLinkTel());
		biddingImpl.setStartDate(bidding.getStartDate());
		biddingImpl.setProjectId(bidding.getProjectId());

		return biddingImpl;
	}

	/**
	 * Returns the bidding with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bidding
	 * @return the bidding
	 * @throws com.justonetech.proj.NoSuchBiddingException if a bidding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bidding findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiddingException, SystemException {
		Bidding bidding = fetchByPrimaryKey(primaryKey);

		if (bidding == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiddingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bidding;
	}

	/**
	 * Returns the bidding with the primary key or throws a {@link com.justonetech.proj.NoSuchBiddingException} if it could not be found.
	 *
	 * @param biddingId the primary key of the bidding
	 * @return the bidding
	 * @throws com.justonetech.proj.NoSuchBiddingException if a bidding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bidding findByPrimaryKey(long biddingId)
		throws NoSuchBiddingException, SystemException {
		return findByPrimaryKey((Serializable)biddingId);
	}

	/**
	 * Returns the bidding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bidding
	 * @return the bidding, or <code>null</code> if a bidding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bidding fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Bidding bidding = (Bidding)EntityCacheUtil.getResult(BiddingModelImpl.ENTITY_CACHE_ENABLED,
				BiddingImpl.class, primaryKey);

		if (bidding == _nullBidding) {
			return null;
		}

		if (bidding == null) {
			Session session = null;

			try {
				session = openSession();

				bidding = (Bidding)session.get(BiddingImpl.class, primaryKey);

				if (bidding != null) {
					cacheResult(bidding);
				}
				else {
					EntityCacheUtil.putResult(BiddingModelImpl.ENTITY_CACHE_ENABLED,
						BiddingImpl.class, primaryKey, _nullBidding);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiddingModelImpl.ENTITY_CACHE_ENABLED,
					BiddingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bidding;
	}

	/**
	 * Returns the bidding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biddingId the primary key of the bidding
	 * @return the bidding, or <code>null</code> if a bidding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Bidding fetchByPrimaryKey(long biddingId) throws SystemException {
		return fetchByPrimaryKey((Serializable)biddingId);
	}

	/**
	 * Returns all the biddings.
	 *
	 * @return the biddings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bidding> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the biddings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.BiddingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biddings
	 * @param end the upper bound of the range of biddings (not inclusive)
	 * @return the range of biddings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bidding> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the biddings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.BiddingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biddings
	 * @param end the upper bound of the range of biddings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of biddings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Bidding> findAll(int start, int end,
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

		List<Bidding> list = (List<Bidding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIDDING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIDDING;

				if (pagination) {
					sql = sql.concat(BiddingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Bidding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Bidding>(list);
				}
				else {
					list = (List<Bidding>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the biddings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Bidding bidding : findAll()) {
			remove(bidding);
		}
	}

	/**
	 * Returns the number of biddings.
	 *
	 * @return the number of biddings
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

				Query q = session.createQuery(_SQL_COUNT_BIDDING);

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
	 * Initializes the bidding persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.proj.model.Bidding")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Bidding>> listenersList = new ArrayList<ModelListener<Bidding>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Bidding>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BiddingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIDDING = "SELECT bidding FROM Bidding bidding";
	private static final String _SQL_COUNT_BIDDING = "SELECT COUNT(bidding) FROM Bidding bidding";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bidding.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Bidding exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiddingPersistenceImpl.class);
	private static Bidding _nullBidding = new BiddingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Bidding> toCacheModel() {
				return _nullBiddingCacheModel;
			}
		};

	private static CacheModel<Bidding> _nullBiddingCacheModel = new CacheModel<Bidding>() {
			@Override
			public Bidding toEntityModel() {
				return _nullBidding;
			}
		};
}