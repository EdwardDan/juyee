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

package com.justonetech.cyzt.leo.service.persistence;

import com.justonetech.cyzt.leo.NoSuchLEOCertificateException;
import com.justonetech.cyzt.leo.model.LEOCertificate;
import com.justonetech.cyzt.leo.model.impl.LEOCertificateImpl;
import com.justonetech.cyzt.leo.model.impl.LEOCertificateModelImpl;

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
 * The persistence implementation for the l e o certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see LEOCertificatePersistence
 * @see LEOCertificateUtil
 * @generated
 */
public class LEOCertificatePersistenceImpl extends BasePersistenceImpl<LEOCertificate>
	implements LEOCertificatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LEOCertificateUtil} to access the l e o certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LEOCertificateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
			LEOCertificateModelImpl.FINDER_CACHE_ENABLED,
			LEOCertificateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
			LEOCertificateModelImpl.FINDER_CACHE_ENABLED,
			LEOCertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
			LEOCertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public LEOCertificatePersistenceImpl() {
		setModelClass(LEOCertificate.class);
	}

	/**
	 * Caches the l e o certificate in the entity cache if it is enabled.
	 *
	 * @param leoCertificate the l e o certificate
	 */
	@Override
	public void cacheResult(LEOCertificate leoCertificate) {
		EntityCacheUtil.putResult(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
			LEOCertificateImpl.class, leoCertificate.getPrimaryKey(),
			leoCertificate);

		leoCertificate.resetOriginalValues();
	}

	/**
	 * Caches the l e o certificates in the entity cache if it is enabled.
	 *
	 * @param leoCertificates the l e o certificates
	 */
	@Override
	public void cacheResult(List<LEOCertificate> leoCertificates) {
		for (LEOCertificate leoCertificate : leoCertificates) {
			if (EntityCacheUtil.getResult(
						LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
						LEOCertificateImpl.class, leoCertificate.getPrimaryKey()) == null) {
				cacheResult(leoCertificate);
			}
			else {
				leoCertificate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all l e o certificates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LEOCertificateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LEOCertificateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the l e o certificate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LEOCertificate leoCertificate) {
		EntityCacheUtil.removeResult(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
			LEOCertificateImpl.class, leoCertificate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LEOCertificate> leoCertificates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LEOCertificate leoCertificate : leoCertificates) {
			EntityCacheUtil.removeResult(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
				LEOCertificateImpl.class, leoCertificate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new l e o certificate with the primary key. Does not add the l e o certificate to the database.
	 *
	 * @param certificateId the primary key for the new l e o certificate
	 * @return the new l e o certificate
	 */
	@Override
	public LEOCertificate create(String certificateId) {
		LEOCertificate leoCertificate = new LEOCertificateImpl();

		leoCertificate.setNew(true);
		leoCertificate.setPrimaryKey(certificateId);

		return leoCertificate;
	}

	/**
	 * Removes the l e o certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param certificateId the primary key of the l e o certificate
	 * @return the l e o certificate that was removed
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOCertificate remove(String certificateId)
		throws NoSuchLEOCertificateException, SystemException {
		return remove((Serializable)certificateId);
	}

	/**
	 * Removes the l e o certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the l e o certificate
	 * @return the l e o certificate that was removed
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOCertificate remove(Serializable primaryKey)
		throws NoSuchLEOCertificateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LEOCertificate leoCertificate = (LEOCertificate)session.get(LEOCertificateImpl.class,
					primaryKey);

			if (leoCertificate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLEOCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(leoCertificate);
		}
		catch (NoSuchLEOCertificateException nsee) {
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
	protected LEOCertificate removeImpl(LEOCertificate leoCertificate)
		throws SystemException {
		leoCertificate = toUnwrappedModel(leoCertificate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(leoCertificate)) {
				leoCertificate = (LEOCertificate)session.get(LEOCertificateImpl.class,
						leoCertificate.getPrimaryKeyObj());
			}

			if (leoCertificate != null) {
				session.delete(leoCertificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (leoCertificate != null) {
			clearCache(leoCertificate);
		}

		return leoCertificate;
	}

	@Override
	public LEOCertificate updateImpl(
		com.justonetech.cyzt.leo.model.LEOCertificate leoCertificate)
		throws SystemException {
		leoCertificate = toUnwrappedModel(leoCertificate);

		boolean isNew = leoCertificate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (leoCertificate.isNew()) {
				session.save(leoCertificate);

				leoCertificate.setNew(false);
			}
			else {
				session.merge(leoCertificate);
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

		EntityCacheUtil.putResult(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
			LEOCertificateImpl.class, leoCertificate.getPrimaryKey(),
			leoCertificate);

		return leoCertificate;
	}

	protected LEOCertificate toUnwrappedModel(LEOCertificate leoCertificate) {
		if (leoCertificate instanceof LEOCertificateImpl) {
			return leoCertificate;
		}

		LEOCertificateImpl leoCertificateImpl = new LEOCertificateImpl();

		leoCertificateImpl.setNew(leoCertificate.isNew());
		leoCertificateImpl.setPrimaryKey(leoCertificate.getPrimaryKey());

		leoCertificateImpl.setCertificateId(leoCertificate.getCertificateId());
		leoCertificateImpl.setGroupId(leoCertificate.getGroupId());
		leoCertificateImpl.setCompanyId(leoCertificate.getCompanyId());
		leoCertificateImpl.setUserId(leoCertificate.getUserId());
		leoCertificateImpl.setUserName(leoCertificate.getUserName());
		leoCertificateImpl.setCreateDate(leoCertificate.getCreateDate());
		leoCertificateImpl.setModifiedDate(leoCertificate.getModifiedDate());
		leoCertificateImpl.setXm(leoCertificate.getXm());
		leoCertificateImpl.setZjlx(leoCertificate.getZjlx());
		leoCertificateImpl.setYxq(leoCertificate.getYxq());
		leoCertificateImpl.setFzrq(leoCertificate.getFzrq());

		return leoCertificateImpl;
	}

	/**
	 * Returns the l e o certificate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the l e o certificate
	 * @return the l e o certificate
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOCertificate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLEOCertificateException, SystemException {
		LEOCertificate leoCertificate = fetchByPrimaryKey(primaryKey);

		if (leoCertificate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLEOCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return leoCertificate;
	}

	/**
	 * Returns the l e o certificate with the primary key or throws a {@link com.justonetech.cyzt.leo.NoSuchLEOCertificateException} if it could not be found.
	 *
	 * @param certificateId the primary key of the l e o certificate
	 * @return the l e o certificate
	 * @throws com.justonetech.cyzt.leo.NoSuchLEOCertificateException if a l e o certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOCertificate findByPrimaryKey(String certificateId)
		throws NoSuchLEOCertificateException, SystemException {
		return findByPrimaryKey((Serializable)certificateId);
	}

	/**
	 * Returns the l e o certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the l e o certificate
	 * @return the l e o certificate, or <code>null</code> if a l e o certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOCertificate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		LEOCertificate leoCertificate = (LEOCertificate)EntityCacheUtil.getResult(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
				LEOCertificateImpl.class, primaryKey);

		if (leoCertificate == _nullLEOCertificate) {
			return null;
		}

		if (leoCertificate == null) {
			Session session = null;

			try {
				session = openSession();

				leoCertificate = (LEOCertificate)session.get(LEOCertificateImpl.class,
						primaryKey);

				if (leoCertificate != null) {
					cacheResult(leoCertificate);
				}
				else {
					EntityCacheUtil.putResult(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
						LEOCertificateImpl.class, primaryKey,
						_nullLEOCertificate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LEOCertificateModelImpl.ENTITY_CACHE_ENABLED,
					LEOCertificateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return leoCertificate;
	}

	/**
	 * Returns the l e o certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param certificateId the primary key of the l e o certificate
	 * @return the l e o certificate, or <code>null</code> if a l e o certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LEOCertificate fetchByPrimaryKey(String certificateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)certificateId);
	}

	/**
	 * Returns all the l e o certificates.
	 *
	 * @return the l e o certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOCertificate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the l e o certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l e o certificates
	 * @param end the upper bound of the range of l e o certificates (not inclusive)
	 * @return the range of l e o certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOCertificate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the l e o certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cyzt.leo.model.impl.LEOCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of l e o certificates
	 * @param end the upper bound of the range of l e o certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of l e o certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LEOCertificate> findAll(int start, int end,
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

		List<LEOCertificate> list = (List<LEOCertificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEOCERTIFICATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEOCERTIFICATE;

				if (pagination) {
					sql = sql.concat(LEOCertificateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LEOCertificate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<LEOCertificate>(list);
				}
				else {
					list = (List<LEOCertificate>)QueryUtil.list(q,
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
	 * Removes all the l e o certificates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (LEOCertificate leoCertificate : findAll()) {
			remove(leoCertificate);
		}
	}

	/**
	 * Returns the number of l e o certificates.
	 *
	 * @return the number of l e o certificates
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

				Query q = session.createQuery(_SQL_COUNT_LEOCERTIFICATE);

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
	 * Initializes the l e o certificate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cyzt.leo.model.LEOCertificate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LEOCertificate>> listenersList = new ArrayList<ModelListener<LEOCertificate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LEOCertificate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LEOCertificateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEOCERTIFICATE = "SELECT leoCertificate FROM LEOCertificate leoCertificate";
	private static final String _SQL_COUNT_LEOCERTIFICATE = "SELECT COUNT(leoCertificate) FROM LEOCertificate leoCertificate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "leoCertificate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LEOCertificate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LEOCertificatePersistenceImpl.class);
	private static LEOCertificate _nullLEOCertificate = new LEOCertificateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LEOCertificate> toCacheModel() {
				return _nullLEOCertificateCacheModel;
			}
		};

	private static CacheModel<LEOCertificate> _nullLEOCertificateCacheModel = new CacheModel<LEOCertificate>() {
			@Override
			public LEOCertificate toEntityModel() {
				return _nullLEOCertificate;
			}
		};
}