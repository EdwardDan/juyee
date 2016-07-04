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

import com.justonetech.oa.NoSuchOfficeSupplyApplyItemException;
import com.justonetech.oa.model.OfficeSupplyApplyItem;
import com.justonetech.oa.model.impl.OfficeSupplyApplyItemImpl;
import com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl;

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
 * The persistence implementation for the office supply apply item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplyItemPersistence
 * @see OfficeSupplyApplyItemUtil
 * @generated
 */
public class OfficeSupplyApplyItemPersistenceImpl extends BasePersistenceImpl<OfficeSupplyApplyItem>
	implements OfficeSupplyApplyItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeSupplyApplyItemUtil} to access the office supply apply item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeSupplyApplyItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyItemModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OfficeSupplyApplyItemPersistenceImpl() {
		setModelClass(OfficeSupplyApplyItem.class);
	}

	/**
	 * Caches the office supply apply item in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApplyItem the office supply apply item
	 */
	@Override
	public void cacheResult(OfficeSupplyApplyItem officeSupplyApplyItem) {
		EntityCacheUtil.putResult(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyItemImpl.class,
			officeSupplyApplyItem.getPrimaryKey(), officeSupplyApplyItem);

		officeSupplyApplyItem.resetOriginalValues();
	}

	/**
	 * Caches the office supply apply items in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApplyItems the office supply apply items
	 */
	@Override
	public void cacheResult(List<OfficeSupplyApplyItem> officeSupplyApplyItems) {
		for (OfficeSupplyApplyItem officeSupplyApplyItem : officeSupplyApplyItems) {
			if (EntityCacheUtil.getResult(
						OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplyItemImpl.class,
						officeSupplyApplyItem.getPrimaryKey()) == null) {
				cacheResult(officeSupplyApplyItem);
			}
			else {
				officeSupplyApplyItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all office supply apply items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeSupplyApplyItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeSupplyApplyItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office supply apply item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OfficeSupplyApplyItem officeSupplyApplyItem) {
		EntityCacheUtil.removeResult(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyItemImpl.class,
			officeSupplyApplyItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OfficeSupplyApplyItem> officeSupplyApplyItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OfficeSupplyApplyItem officeSupplyApplyItem : officeSupplyApplyItems) {
			EntityCacheUtil.removeResult(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplyItemImpl.class,
				officeSupplyApplyItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new office supply apply item with the primary key. Does not add the office supply apply item to the database.
	 *
	 * @param officeSupplyApplyItemId the primary key for the new office supply apply item
	 * @return the new office supply apply item
	 */
	@Override
	public OfficeSupplyApplyItem create(long officeSupplyApplyItemId) {
		OfficeSupplyApplyItem officeSupplyApplyItem = new OfficeSupplyApplyItemImpl();

		officeSupplyApplyItem.setNew(true);
		officeSupplyApplyItem.setPrimaryKey(officeSupplyApplyItemId);

		return officeSupplyApplyItem;
	}

	/**
	 * Removes the office supply apply item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyApplyItemId the primary key of the office supply apply item
	 * @return the office supply apply item that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException if a office supply apply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplyItem remove(long officeSupplyApplyItemId)
		throws NoSuchOfficeSupplyApplyItemException, SystemException {
		return remove((Serializable)officeSupplyApplyItemId);
	}

	/**
	 * Removes the office supply apply item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office supply apply item
	 * @return the office supply apply item that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException if a office supply apply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplyItem remove(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplyItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApplyItem officeSupplyApplyItem = (OfficeSupplyApplyItem)session.get(OfficeSupplyApplyItemImpl.class,
					primaryKey);

			if (officeSupplyApplyItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeSupplyApplyItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(officeSupplyApplyItem);
		}
		catch (NoSuchOfficeSupplyApplyItemException nsee) {
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
	protected OfficeSupplyApplyItem removeImpl(
		OfficeSupplyApplyItem officeSupplyApplyItem) throws SystemException {
		officeSupplyApplyItem = toUnwrappedModel(officeSupplyApplyItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(officeSupplyApplyItem)) {
				officeSupplyApplyItem = (OfficeSupplyApplyItem)session.get(OfficeSupplyApplyItemImpl.class,
						officeSupplyApplyItem.getPrimaryKeyObj());
			}

			if (officeSupplyApplyItem != null) {
				session.delete(officeSupplyApplyItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (officeSupplyApplyItem != null) {
			clearCache(officeSupplyApplyItem);
		}

		return officeSupplyApplyItem;
	}

	@Override
	public OfficeSupplyApplyItem updateImpl(
		com.justonetech.oa.model.OfficeSupplyApplyItem officeSupplyApplyItem)
		throws SystemException {
		officeSupplyApplyItem = toUnwrappedModel(officeSupplyApplyItem);

		boolean isNew = officeSupplyApplyItem.isNew();

		Session session = null;

		try {
			session = openSession();

			if (officeSupplyApplyItem.isNew()) {
				session.save(officeSupplyApplyItem);

				officeSupplyApplyItem.setNew(false);
			}
			else {
				session.merge(officeSupplyApplyItem);
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

		EntityCacheUtil.putResult(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyItemImpl.class,
			officeSupplyApplyItem.getPrimaryKey(), officeSupplyApplyItem);

		return officeSupplyApplyItem;
	}

	protected OfficeSupplyApplyItem toUnwrappedModel(
		OfficeSupplyApplyItem officeSupplyApplyItem) {
		if (officeSupplyApplyItem instanceof OfficeSupplyApplyItemImpl) {
			return officeSupplyApplyItem;
		}

		OfficeSupplyApplyItemImpl officeSupplyApplyItemImpl = new OfficeSupplyApplyItemImpl();

		officeSupplyApplyItemImpl.setNew(officeSupplyApplyItem.isNew());
		officeSupplyApplyItemImpl.setPrimaryKey(officeSupplyApplyItem.getPrimaryKey());

		officeSupplyApplyItemImpl.setOfficeSupplyApplyItemId(officeSupplyApplyItem.getOfficeSupplyApplyItemId());
		officeSupplyApplyItemImpl.setName(officeSupplyApplyItem.getName());
		officeSupplyApplyItemImpl.setModel(officeSupplyApplyItem.getModel());
		officeSupplyApplyItemImpl.setUnit(officeSupplyApplyItem.getUnit());
		officeSupplyApplyItemImpl.setUnitPrice(officeSupplyApplyItem.getUnitPrice());
		officeSupplyApplyItemImpl.setQuantity(officeSupplyApplyItem.getQuantity());

		return officeSupplyApplyItemImpl;
	}

	/**
	 * Returns the office supply apply item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply apply item
	 * @return the office supply apply item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException if a office supply apply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplyItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplyItemException, SystemException {
		OfficeSupplyApplyItem officeSupplyApplyItem = fetchByPrimaryKey(primaryKey);

		if (officeSupplyApplyItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeSupplyApplyItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return officeSupplyApplyItem;
	}

	/**
	 * Returns the office supply apply item with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyApplyItemException} if it could not be found.
	 *
	 * @param officeSupplyApplyItemId the primary key of the office supply apply item
	 * @return the office supply apply item
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyItemException if a office supply apply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplyItem findByPrimaryKey(long officeSupplyApplyItemId)
		throws NoSuchOfficeSupplyApplyItemException, SystemException {
		return findByPrimaryKey((Serializable)officeSupplyApplyItemId);
	}

	/**
	 * Returns the office supply apply item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply apply item
	 * @return the office supply apply item, or <code>null</code> if a office supply apply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplyItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OfficeSupplyApplyItem officeSupplyApplyItem = (OfficeSupplyApplyItem)EntityCacheUtil.getResult(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplyItemImpl.class, primaryKey);

		if (officeSupplyApplyItem == _nullOfficeSupplyApplyItem) {
			return null;
		}

		if (officeSupplyApplyItem == null) {
			Session session = null;

			try {
				session = openSession();

				officeSupplyApplyItem = (OfficeSupplyApplyItem)session.get(OfficeSupplyApplyItemImpl.class,
						primaryKey);

				if (officeSupplyApplyItem != null) {
					cacheResult(officeSupplyApplyItem);
				}
				else {
					EntityCacheUtil.putResult(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplyItemImpl.class, primaryKey,
						_nullOfficeSupplyApplyItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeSupplyApplyItemModelImpl.ENTITY_CACHE_ENABLED,
					OfficeSupplyApplyItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return officeSupplyApplyItem;
	}

	/**
	 * Returns the office supply apply item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeSupplyApplyItemId the primary key of the office supply apply item
	 * @return the office supply apply item, or <code>null</code> if a office supply apply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApplyItem fetchByPrimaryKey(long officeSupplyApplyItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)officeSupplyApplyItemId);
	}

	/**
	 * Returns all the office supply apply items.
	 *
	 * @return the office supply apply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplyItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply apply items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply apply items
	 * @param end the upper bound of the range of office supply apply items (not inclusive)
	 * @return the range of office supply apply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplyItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply apply items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply apply items
	 * @param end the upper bound of the range of office supply apply items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of office supply apply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApplyItem> findAll(int start, int end,
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

		List<OfficeSupplyApplyItem> list = (List<OfficeSupplyApplyItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICESUPPLYAPPLYITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICESUPPLYAPPLYITEM;

				if (pagination) {
					sql = sql.concat(OfficeSupplyApplyItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OfficeSupplyApplyItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApplyItem>(list);
				}
				else {
					list = (List<OfficeSupplyApplyItem>)QueryUtil.list(q,
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
	 * Removes all the office supply apply items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OfficeSupplyApplyItem officeSupplyApplyItem : findAll()) {
			remove(officeSupplyApplyItem);
		}
	}

	/**
	 * Returns the number of office supply apply items.
	 *
	 * @return the number of office supply apply items
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

				Query q = session.createQuery(_SQL_COUNT_OFFICESUPPLYAPPLYITEM);

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
	 * Initializes the office supply apply item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.OfficeSupplyApplyItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OfficeSupplyApplyItem>> listenersList = new ArrayList<ModelListener<OfficeSupplyApplyItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OfficeSupplyApplyItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeSupplyApplyItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICESUPPLYAPPLYITEM = "SELECT officeSupplyApplyItem FROM OfficeSupplyApplyItem officeSupplyApplyItem";
	private static final String _SQL_COUNT_OFFICESUPPLYAPPLYITEM = "SELECT COUNT(officeSupplyApplyItem) FROM OfficeSupplyApplyItem officeSupplyApplyItem";
	private static final String _ORDER_BY_ENTITY_ALIAS = "officeSupplyApplyItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OfficeSupplyApplyItem exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficeSupplyApplyItemPersistenceImpl.class);
	private static OfficeSupplyApplyItem _nullOfficeSupplyApplyItem = new OfficeSupplyApplyItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OfficeSupplyApplyItem> toCacheModel() {
				return _nullOfficeSupplyApplyItemCacheModel;
			}
		};

	private static CacheModel<OfficeSupplyApplyItem> _nullOfficeSupplyApplyItemCacheModel =
		new CacheModel<OfficeSupplyApplyItem>() {
			@Override
			public OfficeSupplyApplyItem toEntityModel() {
				return _nullOfficeSupplyApplyItem;
			}
		};
}