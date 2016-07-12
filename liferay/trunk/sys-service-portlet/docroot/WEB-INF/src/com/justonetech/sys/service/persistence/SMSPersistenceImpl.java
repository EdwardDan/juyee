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

package com.justonetech.sys.service.persistence;

import com.justonetech.sys.NoSuchSMSException;
import com.justonetech.sys.model.SMS;
import com.justonetech.sys.model.impl.SMSImpl;
import com.justonetech.sys.model.impl.SMSModelImpl;

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
 * The persistence implementation for the s m s service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see SMSPersistence
 * @see SMSUtil
 * @generated
 */
public class SMSPersistenceImpl extends BasePersistenceImpl<SMS>
	implements SMSPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SMSUtil} to access the s m s persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SMSImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, SMSImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SMSPersistenceImpl() {
		setModelClass(SMS.class);
	}

	/**
	 * Caches the s m s in the entity cache if it is enabled.
	 *
	 * @param sms the s m s
	 */
	@Override
	public void cacheResult(SMS sms) {
		EntityCacheUtil.putResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSImpl.class, sms.getPrimaryKey(), sms);

		sms.resetOriginalValues();
	}

	/**
	 * Caches the s m ses in the entity cache if it is enabled.
	 *
	 * @param smses the s m ses
	 */
	@Override
	public void cacheResult(List<SMS> smses) {
		for (SMS sms : smses) {
			if (EntityCacheUtil.getResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
						SMSImpl.class, sms.getPrimaryKey()) == null) {
				cacheResult(sms);
			}
			else {
				sms.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all s m ses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SMSImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SMSImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the s m s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SMS sms) {
		EntityCacheUtil.removeResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSImpl.class, sms.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SMS> smses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SMS sms : smses) {
			EntityCacheUtil.removeResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
				SMSImpl.class, sms.getPrimaryKey());
		}
	}

	/**
	 * Creates a new s m s with the primary key. Does not add the s m s to the database.
	 *
	 * @param smsId the primary key for the new s m s
	 * @return the new s m s
	 */
	@Override
	public SMS create(long smsId) {
		SMS sms = new SMSImpl();

		sms.setNew(true);
		sms.setPrimaryKey(smsId);

		return sms;
	}

	/**
	 * Removes the s m s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param smsId the primary key of the s m s
	 * @return the s m s that was removed
	 * @throws com.justonetech.sys.NoSuchSMSException if a s m s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SMS remove(long smsId) throws NoSuchSMSException, SystemException {
		return remove((Serializable)smsId);
	}

	/**
	 * Removes the s m s with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the s m s
	 * @return the s m s that was removed
	 * @throws com.justonetech.sys.NoSuchSMSException if a s m s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SMS remove(Serializable primaryKey)
		throws NoSuchSMSException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SMS sms = (SMS)session.get(SMSImpl.class, primaryKey);

			if (sms == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSMSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sms);
		}
		catch (NoSuchSMSException nsee) {
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
	protected SMS removeImpl(SMS sms) throws SystemException {
		sms = toUnwrappedModel(sms);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sms)) {
				sms = (SMS)session.get(SMSImpl.class, sms.getPrimaryKeyObj());
			}

			if (sms != null) {
				session.delete(sms);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sms != null) {
			clearCache(sms);
		}

		return sms;
	}

	@Override
	public SMS updateImpl(com.justonetech.sys.model.SMS sms)
		throws SystemException {
		sms = toUnwrappedModel(sms);

		boolean isNew = sms.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sms.isNew()) {
				session.save(sms);

				sms.setNew(false);
			}
			else {
				session.merge(sms);
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

		EntityCacheUtil.putResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
			SMSImpl.class, sms.getPrimaryKey(), sms);

		return sms;
	}

	protected SMS toUnwrappedModel(SMS sms) {
		if (sms instanceof SMSImpl) {
			return sms;
		}

		SMSImpl smsImpl = new SMSImpl();

		smsImpl.setNew(sms.isNew());
		smsImpl.setPrimaryKey(sms.getPrimaryKey());

		smsImpl.setSmsId(sms.getSmsId());
		smsImpl.setCreateTime(sms.getCreateTime());
		smsImpl.setModifiedTime(sms.getModifiedTime());
		smsImpl.setContent(sms.getContent());
		smsImpl.setSenderId(sms.getSenderId());
		smsImpl.setSenderName(sms.getSenderName());
		smsImpl.setReceiver(sms.getReceiver());
		smsImpl.setSendTime(sms.getSendTime());

		return smsImpl;
	}

	/**
	 * Returns the s m s with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the s m s
	 * @return the s m s
	 * @throws com.justonetech.sys.NoSuchSMSException if a s m s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SMS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSMSException, SystemException {
		SMS sms = fetchByPrimaryKey(primaryKey);

		if (sms == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSMSException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sms;
	}

	/**
	 * Returns the s m s with the primary key or throws a {@link com.justonetech.sys.NoSuchSMSException} if it could not be found.
	 *
	 * @param smsId the primary key of the s m s
	 * @return the s m s
	 * @throws com.justonetech.sys.NoSuchSMSException if a s m s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SMS findByPrimaryKey(long smsId)
		throws NoSuchSMSException, SystemException {
		return findByPrimaryKey((Serializable)smsId);
	}

	/**
	 * Returns the s m s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the s m s
	 * @return the s m s, or <code>null</code> if a s m s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SMS fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SMS sms = (SMS)EntityCacheUtil.getResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
				SMSImpl.class, primaryKey);

		if (sms == _nullSMS) {
			return null;
		}

		if (sms == null) {
			Session session = null;

			try {
				session = openSession();

				sms = (SMS)session.get(SMSImpl.class, primaryKey);

				if (sms != null) {
					cacheResult(sms);
				}
				else {
					EntityCacheUtil.putResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
						SMSImpl.class, primaryKey, _nullSMS);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SMSModelImpl.ENTITY_CACHE_ENABLED,
					SMSImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sms;
	}

	/**
	 * Returns the s m s with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param smsId the primary key of the s m s
	 * @return the s m s, or <code>null</code> if a s m s with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SMS fetchByPrimaryKey(long smsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)smsId);
	}

	/**
	 * Returns all the s m ses.
	 *
	 * @return the s m ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SMS> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the s m ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.SMSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s m ses
	 * @param end the upper bound of the range of s m ses (not inclusive)
	 * @return the range of s m ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SMS> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the s m ses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.SMSModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of s m ses
	 * @param end the upper bound of the range of s m ses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of s m ses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SMS> findAll(int start, int end,
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

		List<SMS> list = (List<SMS>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SMS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SMS;

				if (pagination) {
					sql = sql.concat(SMSModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SMS>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SMS>(list);
				}
				else {
					list = (List<SMS>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the s m ses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SMS sms : findAll()) {
			remove(sms);
		}
	}

	/**
	 * Returns the number of s m ses.
	 *
	 * @return the number of s m ses
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

				Query q = session.createQuery(_SQL_COUNT_SMS);

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
	 * Initializes the s m s persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.sys.model.SMS")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SMS>> listenersList = new ArrayList<ModelListener<SMS>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SMS>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SMSImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SMS = "SELECT sms FROM SMS sms";
	private static final String _SQL_COUNT_SMS = "SELECT COUNT(sms) FROM SMS sms";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sms.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SMS exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SMSPersistenceImpl.class);
	private static SMS _nullSMS = new SMSImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SMS> toCacheModel() {
				return _nullSMSCacheModel;
			}
		};

	private static CacheModel<SMS> _nullSMSCacheModel = new CacheModel<SMS>() {
			@Override
			public SMS toEntityModel() {
				return _nullSMS;
			}
		};
}