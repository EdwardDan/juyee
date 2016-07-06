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

import com.justonetech.oa.NoSuchOfficeSupplyRequisitionException;
import com.justonetech.oa.model.OfficeSupplyRequisition;
import com.justonetech.oa.model.impl.OfficeSupplyRequisitionImpl;
import com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl;

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
 * The persistence implementation for the office supply requisition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionPersistence
 * @see OfficeSupplyRequisitionUtil
 * @generated
 */
public class OfficeSupplyRequisitionPersistenceImpl extends BasePersistenceImpl<OfficeSupplyRequisition>
	implements OfficeSupplyRequisitionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeSupplyRequisitionUtil} to access the office supply requisition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeSupplyRequisitionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyRequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyRequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public OfficeSupplyRequisitionPersistenceImpl() {
		setModelClass(OfficeSupplyRequisition.class);
	}

	/**
	 * Caches the office supply requisition in the entity cache if it is enabled.
	 *
	 * @param officeSupplyRequisition the office supply requisition
	 */
	@Override
	public void cacheResult(OfficeSupplyRequisition officeSupplyRequisition) {
		EntityCacheUtil.putResult(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionImpl.class,
			officeSupplyRequisition.getPrimaryKey(), officeSupplyRequisition);

		officeSupplyRequisition.resetOriginalValues();
	}

	/**
	 * Caches the office supply requisitions in the entity cache if it is enabled.
	 *
	 * @param officeSupplyRequisitions the office supply requisitions
	 */
	@Override
	public void cacheResult(
		List<OfficeSupplyRequisition> officeSupplyRequisitions) {
		for (OfficeSupplyRequisition officeSupplyRequisition : officeSupplyRequisitions) {
			if (EntityCacheUtil.getResult(
						OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyRequisitionImpl.class,
						officeSupplyRequisition.getPrimaryKey()) == null) {
				cacheResult(officeSupplyRequisition);
			}
			else {
				officeSupplyRequisition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all office supply requisitions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeSupplyRequisitionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeSupplyRequisitionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office supply requisition.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OfficeSupplyRequisition officeSupplyRequisition) {
		EntityCacheUtil.removeResult(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionImpl.class,
			officeSupplyRequisition.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<OfficeSupplyRequisition> officeSupplyRequisitions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OfficeSupplyRequisition officeSupplyRequisition : officeSupplyRequisitions) {
			EntityCacheUtil.removeResult(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyRequisitionImpl.class,
				officeSupplyRequisition.getPrimaryKey());
		}
	}

	/**
	 * Creates a new office supply requisition with the primary key. Does not add the office supply requisition to the database.
	 *
	 * @param officeSupplyRequisitionId the primary key for the new office supply requisition
	 * @return the new office supply requisition
	 */
	@Override
	public OfficeSupplyRequisition create(long officeSupplyRequisitionId) {
		OfficeSupplyRequisition officeSupplyRequisition = new OfficeSupplyRequisitionImpl();

		officeSupplyRequisition.setNew(true);
		officeSupplyRequisition.setPrimaryKey(officeSupplyRequisitionId);

		return officeSupplyRequisition;
	}

	/**
	 * Removes the office supply requisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyRequisitionId the primary key of the office supply requisition
	 * @return the office supply requisition that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisition remove(long officeSupplyRequisitionId)
		throws NoSuchOfficeSupplyRequisitionException, SystemException {
		return remove((Serializable)officeSupplyRequisitionId);
	}

	/**
	 * Removes the office supply requisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office supply requisition
	 * @return the office supply requisition that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisition remove(Serializable primaryKey)
		throws NoSuchOfficeSupplyRequisitionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OfficeSupplyRequisition officeSupplyRequisition = (OfficeSupplyRequisition)session.get(OfficeSupplyRequisitionImpl.class,
					primaryKey);

			if (officeSupplyRequisition == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeSupplyRequisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(officeSupplyRequisition);
		}
		catch (NoSuchOfficeSupplyRequisitionException nsee) {
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
	protected OfficeSupplyRequisition removeImpl(
		OfficeSupplyRequisition officeSupplyRequisition)
		throws SystemException {
		officeSupplyRequisition = toUnwrappedModel(officeSupplyRequisition);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(officeSupplyRequisition)) {
				officeSupplyRequisition = (OfficeSupplyRequisition)session.get(OfficeSupplyRequisitionImpl.class,
						officeSupplyRequisition.getPrimaryKeyObj());
			}

			if (officeSupplyRequisition != null) {
				session.delete(officeSupplyRequisition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (officeSupplyRequisition != null) {
			clearCache(officeSupplyRequisition);
		}

		return officeSupplyRequisition;
	}

	@Override
	public OfficeSupplyRequisition updateImpl(
		com.justonetech.oa.model.OfficeSupplyRequisition officeSupplyRequisition)
		throws SystemException {
		officeSupplyRequisition = toUnwrappedModel(officeSupplyRequisition);

		boolean isNew = officeSupplyRequisition.isNew();

		Session session = null;

		try {
			session = openSession();

			if (officeSupplyRequisition.isNew()) {
				session.save(officeSupplyRequisition);

				officeSupplyRequisition.setNew(false);
			}
			else {
				session.merge(officeSupplyRequisition);
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

		EntityCacheUtil.putResult(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyRequisitionImpl.class,
			officeSupplyRequisition.getPrimaryKey(), officeSupplyRequisition);

		return officeSupplyRequisition;
	}

	protected OfficeSupplyRequisition toUnwrappedModel(
		OfficeSupplyRequisition officeSupplyRequisition) {
		if (officeSupplyRequisition instanceof OfficeSupplyRequisitionImpl) {
			return officeSupplyRequisition;
		}

		OfficeSupplyRequisitionImpl officeSupplyRequisitionImpl = new OfficeSupplyRequisitionImpl();

		officeSupplyRequisitionImpl.setNew(officeSupplyRequisition.isNew());
		officeSupplyRequisitionImpl.setPrimaryKey(officeSupplyRequisition.getPrimaryKey());

		officeSupplyRequisitionImpl.setOfficeSupplyRequisitionId(officeSupplyRequisition.getOfficeSupplyRequisitionId());
		officeSupplyRequisitionImpl.setUserId(officeSupplyRequisition.getUserId());
		officeSupplyRequisitionImpl.setUserName(officeSupplyRequisition.getUserName());
		officeSupplyRequisitionImpl.setCreateTime(officeSupplyRequisition.getCreateTime());
		officeSupplyRequisitionImpl.setModifiedTime(officeSupplyRequisition.getModifiedTime());
		officeSupplyRequisitionImpl.setDeptId(officeSupplyRequisition.getDeptId());
		officeSupplyRequisitionImpl.setDeptName(officeSupplyRequisition.getDeptName());
		officeSupplyRequisitionImpl.setIntroductions(officeSupplyRequisition.getIntroductions());

		return officeSupplyRequisitionImpl;
	}

	/**
	 * Returns the office supply requisition with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply requisition
	 * @return the office supply requisition
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeSupplyRequisitionException, SystemException {
		OfficeSupplyRequisition officeSupplyRequisition = fetchByPrimaryKey(primaryKey);

		if (officeSupplyRequisition == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeSupplyRequisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return officeSupplyRequisition;
	}

	/**
	 * Returns the office supply requisition with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyRequisitionException} if it could not be found.
	 *
	 * @param officeSupplyRequisitionId the primary key of the office supply requisition
	 * @return the office supply requisition
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyRequisitionException if a office supply requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisition findByPrimaryKey(
		long officeSupplyRequisitionId)
		throws NoSuchOfficeSupplyRequisitionException, SystemException {
		return findByPrimaryKey((Serializable)officeSupplyRequisitionId);
	}

	/**
	 * Returns the office supply requisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply requisition
	 * @return the office supply requisition, or <code>null</code> if a office supply requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisition fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OfficeSupplyRequisition officeSupplyRequisition = (OfficeSupplyRequisition)EntityCacheUtil.getResult(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyRequisitionImpl.class, primaryKey);

		if (officeSupplyRequisition == _nullOfficeSupplyRequisition) {
			return null;
		}

		if (officeSupplyRequisition == null) {
			Session session = null;

			try {
				session = openSession();

				officeSupplyRequisition = (OfficeSupplyRequisition)session.get(OfficeSupplyRequisitionImpl.class,
						primaryKey);

				if (officeSupplyRequisition != null) {
					cacheResult(officeSupplyRequisition);
				}
				else {
					EntityCacheUtil.putResult(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyRequisitionImpl.class, primaryKey,
						_nullOfficeSupplyRequisition);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeSupplyRequisitionModelImpl.ENTITY_CACHE_ENABLED,
					OfficeSupplyRequisitionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return officeSupplyRequisition;
	}

	/**
	 * Returns the office supply requisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeSupplyRequisitionId the primary key of the office supply requisition
	 * @return the office supply requisition, or <code>null</code> if a office supply requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisition fetchByPrimaryKey(
		long officeSupplyRequisitionId) throws SystemException {
		return fetchByPrimaryKey((Serializable)officeSupplyRequisitionId);
	}

	/**
	 * Returns all the office supply requisitions.
	 *
	 * @return the office supply requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisition> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply requisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply requisitions
	 * @param end the upper bound of the range of office supply requisitions (not inclusive)
	 * @return the range of office supply requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisition> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply requisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply requisitions
	 * @param end the upper bound of the range of office supply requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of office supply requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisition> findAll(int start, int end,
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

		List<OfficeSupplyRequisition> list = (List<OfficeSupplyRequisition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICESUPPLYREQUISITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICESUPPLYREQUISITION;

				if (pagination) {
					sql = sql.concat(OfficeSupplyRequisitionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OfficeSupplyRequisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyRequisition>(list);
				}
				else {
					list = (List<OfficeSupplyRequisition>)QueryUtil.list(q,
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
	 * Removes all the office supply requisitions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OfficeSupplyRequisition officeSupplyRequisition : findAll()) {
			remove(officeSupplyRequisition);
		}
	}

	/**
	 * Returns the number of office supply requisitions.
	 *
	 * @return the number of office supply requisitions
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

				Query q = session.createQuery(_SQL_COUNT_OFFICESUPPLYREQUISITION);

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
	 * Initializes the office supply requisition persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.OfficeSupplyRequisition")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OfficeSupplyRequisition>> listenersList = new ArrayList<ModelListener<OfficeSupplyRequisition>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OfficeSupplyRequisition>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeSupplyRequisitionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICESUPPLYREQUISITION = "SELECT officeSupplyRequisition FROM OfficeSupplyRequisition officeSupplyRequisition";
	private static final String _SQL_COUNT_OFFICESUPPLYREQUISITION = "SELECT COUNT(officeSupplyRequisition) FROM OfficeSupplyRequisition officeSupplyRequisition";
	private static final String _ORDER_BY_ENTITY_ALIAS = "officeSupplyRequisition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OfficeSupplyRequisition exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficeSupplyRequisitionPersistenceImpl.class);
	private static OfficeSupplyRequisition _nullOfficeSupplyRequisition = new OfficeSupplyRequisitionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OfficeSupplyRequisition> toCacheModel() {
				return _nullOfficeSupplyRequisitionCacheModel;
			}
		};

	private static CacheModel<OfficeSupplyRequisition> _nullOfficeSupplyRequisitionCacheModel =
		new CacheModel<OfficeSupplyRequisition>() {
			@Override
			public OfficeSupplyRequisition toEntityModel() {
				return _nullOfficeSupplyRequisition;
			}
		};
}