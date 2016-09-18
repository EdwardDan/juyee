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

package com.justonetech.portal.feedback.service.persistence;

import com.justonetech.portal.feedback.NoSuchFeedbackException;
import com.justonetech.portal.feedback.model.Feedback;
import com.justonetech.portal.feedback.model.impl.FeedbackImpl;
import com.justonetech.portal.feedback.model.impl.FeedbackModelImpl;

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
 * The persistence implementation for the feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see FeedbackPersistence
 * @see FeedbackUtil
 * @generated
 */
public class FeedbackPersistenceImpl extends BasePersistenceImpl<Feedback>
	implements FeedbackPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeedbackUtil} to access the feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeedbackImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FeedbackPersistenceImpl() {
		setModelClass(Feedback.class);
	}

	/**
	 * Caches the feedback in the entity cache if it is enabled.
	 *
	 * @param feedback the feedback
	 */
	@Override
	public void cacheResult(Feedback feedback) {
		EntityCacheUtil.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey(), feedback);

		feedback.resetOriginalValues();
	}

	/**
	 * Caches the feedbacks in the entity cache if it is enabled.
	 *
	 * @param feedbacks the feedbacks
	 */
	@Override
	public void cacheResult(List<Feedback> feedbacks) {
		for (Feedback feedback : feedbacks) {
			if (EntityCacheUtil.getResult(
						FeedbackModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackImpl.class, feedback.getPrimaryKey()) == null) {
				cacheResult(feedback);
			}
			else {
				feedback.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all feedbacks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FeedbackImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FeedbackImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the feedback.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Feedback feedback) {
		EntityCacheUtil.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Feedback> feedbacks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Feedback feedback : feedbacks) {
			EntityCacheUtil.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackImpl.class, feedback.getPrimaryKey());
		}
	}

	/**
	 * Creates a new feedback with the primary key. Does not add the feedback to the database.
	 *
	 * @param feedbackId the primary key for the new feedback
	 * @return the new feedback
	 */
	@Override
	public Feedback create(long feedbackId) {
		Feedback feedback = new FeedbackImpl();

		feedback.setNew(true);
		feedback.setPrimaryKey(feedbackId);

		return feedback;
	}

	/**
	 * Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws com.justonetech.portal.feedback.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback remove(long feedbackId)
		throws NoSuchFeedbackException, SystemException {
		return remove((Serializable)feedbackId);
	}

	/**
	 * Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws com.justonetech.portal.feedback.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback remove(Serializable primaryKey)
		throws NoSuchFeedbackException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Feedback feedback = (Feedback)session.get(FeedbackImpl.class,
					primaryKey);

			if (feedback == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feedback);
		}
		catch (NoSuchFeedbackException nsee) {
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
	protected Feedback removeImpl(Feedback feedback) throws SystemException {
		feedback = toUnwrappedModel(feedback);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feedback)) {
				feedback = (Feedback)session.get(FeedbackImpl.class,
						feedback.getPrimaryKeyObj());
			}

			if (feedback != null) {
				session.delete(feedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feedback != null) {
			clearCache(feedback);
		}

		return feedback;
	}

	@Override
	public Feedback updateImpl(
		com.justonetech.portal.feedback.model.Feedback feedback)
		throws SystemException {
		feedback = toUnwrappedModel(feedback);

		boolean isNew = feedback.isNew();

		Session session = null;

		try {
			session = openSession();

			if (feedback.isNew()) {
				session.save(feedback);

				feedback.setNew(false);
			}
			else {
				session.merge(feedback);
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

		EntityCacheUtil.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey(), feedback);

		return feedback;
	}

	protected Feedback toUnwrappedModel(Feedback feedback) {
		if (feedback instanceof FeedbackImpl) {
			return feedback;
		}

		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setNew(feedback.isNew());
		feedbackImpl.setPrimaryKey(feedback.getPrimaryKey());

		feedbackImpl.setFeedbackId(feedback.getFeedbackId());
		feedbackImpl.setGroupId(feedback.getGroupId());
		feedbackImpl.setCompanyId(feedback.getCompanyId());
		feedbackImpl.setZt(feedback.getZt());
		feedbackImpl.setLx(feedback.getLx());
		feedbackImpl.setFkrId(feedback.getFkrId());
		feedbackImpl.setFkrq(feedback.getFkrq());
		feedbackImpl.setFknr(feedback.getFknr());
		feedbackImpl.setHfrId(feedback.getHfrId());
		feedbackImpl.setHfrq(feedback.getHfrq());
		feedbackImpl.setHfjg(feedback.getHfjg());

		return feedbackImpl;
	}

	/**
	 * Returns the feedback with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback
	 * @throws com.justonetech.portal.feedback.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeedbackException, SystemException {
		Feedback feedback = fetchByPrimaryKey(primaryKey);

		if (feedback == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feedback;
	}

	/**
	 * Returns the feedback with the primary key or throws a {@link com.justonetech.portal.feedback.NoSuchFeedbackException} if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback
	 * @throws com.justonetech.portal.feedback.NoSuchFeedbackException if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback findByPrimaryKey(long feedbackId)
		throws NoSuchFeedbackException, SystemException {
		return findByPrimaryKey((Serializable)feedbackId);
	}

	/**
	 * Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Feedback feedback = (Feedback)EntityCacheUtil.getResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackImpl.class, primaryKey);

		if (feedback == _nullFeedback) {
			return null;
		}

		if (feedback == null) {
			Session session = null;

			try {
				session = openSession();

				feedback = (Feedback)session.get(FeedbackImpl.class, primaryKey);

				if (feedback != null) {
					cacheResult(feedback);
				}
				else {
					EntityCacheUtil.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackImpl.class, primaryKey, _nullFeedback);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feedback;
	}

	/**
	 * Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Feedback fetchByPrimaryKey(long feedbackId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)feedbackId);
	}

	/**
	 * Returns all the feedbacks.
	 *
	 * @return the feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.portal.feedback.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.portal.feedback.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feedbacks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Feedback> findAll(int start, int end,
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

		List<Feedback> list = (List<Feedback>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FEEDBACK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDBACK;

				if (pagination) {
					sql = sql.concat(FeedbackModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Feedback>(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the feedbacks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Feedback feedback : findAll()) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks.
	 *
	 * @return the number of feedbacks
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

				Query q = session.createQuery(_SQL_COUNT_FEEDBACK);

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
	 * Initializes the feedback persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.portal.feedback.model.Feedback")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Feedback>> listenersList = new ArrayList<ModelListener<Feedback>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Feedback>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FeedbackImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FEEDBACK = "SELECT feedback FROM Feedback feedback";
	private static final String _SQL_COUNT_FEEDBACK = "SELECT COUNT(feedback) FROM Feedback feedback";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feedback.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Feedback exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FeedbackPersistenceImpl.class);
	private static Feedback _nullFeedback = new FeedbackImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Feedback> toCacheModel() {
				return _nullFeedbackCacheModel;
			}
		};

	private static CacheModel<Feedback> _nullFeedbackCacheModel = new CacheModel<Feedback>() {
			@Override
			public Feedback toEntityModel() {
				return _nullFeedback;
			}
		};
}