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

import com.justonetech.oa.NoSuchVehicleApplicationException;
import com.justonetech.oa.model.VehicleApplication;
import com.justonetech.oa.model.impl.VehicleApplicationImpl;
import com.justonetech.oa.model.impl.VehicleApplicationModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the vehicle application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see VehicleApplicationPersistence
 * @see VehicleApplicationUtil
 * @generated
 */
public class VehicleApplicationPersistenceImpl extends BasePersistenceImpl<VehicleApplication>
	implements VehicleApplicationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VehicleApplicationUtil} to access the vehicle application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VehicleApplicationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationModelImpl.FINDER_CACHE_ENABLED,
			VehicleApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationModelImpl.FINDER_CACHE_ENABLED,
			VehicleApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNAME =
		new FinderPath(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationModelImpl.FINDER_CACHE_ENABLED,
			VehicleApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicantName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_APPLICANTNAME =
		new FinderPath(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByApplicantName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vehicle applications where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @return the matching vehicle applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleApplication> findByApplicantName(String applicantName)
		throws SystemException {
		return findByApplicantName(applicantName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vehicle applications where applicantName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantName the applicant name
	 * @param start the lower bound of the range of vehicle applications
	 * @param end the upper bound of the range of vehicle applications (not inclusive)
	 * @return the range of matching vehicle applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleApplication> findByApplicantName(String applicantName,
		int start, int end) throws SystemException {
		return findByApplicantName(applicantName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vehicle applications where applicantName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantName the applicant name
	 * @param start the lower bound of the range of vehicle applications
	 * @param end the upper bound of the range of vehicle applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vehicle applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleApplication> findByApplicantName(String applicantName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNAME;
		finderArgs = new Object[] { applicantName, start, end, orderByComparator };

		List<VehicleApplication> list = (List<VehicleApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VehicleApplication vehicleApplication : list) {
				if (!StringUtil.wildcardMatches(
							vehicleApplication.getApplicantName(),
							applicantName, CharPool.UNDERLINE,
							CharPool.PERCENT, CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VEHICLEAPPLICATION_WHERE);

			boolean bindApplicantName = false;

			if (applicantName == null) {
				query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_1);
			}
			else if (applicantName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_3);
			}
			else {
				bindApplicantName = true;

				query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VehicleApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantName) {
					qPos.add(applicantName);
				}

				if (!pagination) {
					list = (List<VehicleApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VehicleApplication>(list);
				}
				else {
					list = (List<VehicleApplication>)QueryUtil.list(q,
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
	 * Returns the first vehicle application in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vehicle application
	 * @throws com.justonetech.oa.NoSuchVehicleApplicationException if a matching vehicle application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication findByApplicantName_First(String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchVehicleApplicationException, SystemException {
		VehicleApplication vehicleApplication = fetchByApplicantName_First(applicantName,
				orderByComparator);

		if (vehicleApplication != null) {
			return vehicleApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantName=");
		msg.append(applicantName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVehicleApplicationException(msg.toString());
	}

	/**
	 * Returns the first vehicle application in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vehicle application, or <code>null</code> if a matching vehicle application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication fetchByApplicantName_First(String applicantName,
		OrderByComparator orderByComparator) throws SystemException {
		List<VehicleApplication> list = findByApplicantName(applicantName, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vehicle application in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vehicle application
	 * @throws com.justonetech.oa.NoSuchVehicleApplicationException if a matching vehicle application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication findByApplicantName_Last(String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchVehicleApplicationException, SystemException {
		VehicleApplication vehicleApplication = fetchByApplicantName_Last(applicantName,
				orderByComparator);

		if (vehicleApplication != null) {
			return vehicleApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantName=");
		msg.append(applicantName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVehicleApplicationException(msg.toString());
	}

	/**
	 * Returns the last vehicle application in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vehicle application, or <code>null</code> if a matching vehicle application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication fetchByApplicantName_Last(String applicantName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByApplicantName(applicantName);

		if (count == 0) {
			return null;
		}

		List<VehicleApplication> list = findByApplicantName(applicantName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vehicle applications before and after the current vehicle application in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param vehicleApplicationId the primary key of the current vehicle application
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vehicle application
	 * @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication[] findByApplicantName_PrevAndNext(
		long vehicleApplicationId, String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchVehicleApplicationException, SystemException {
		VehicleApplication vehicleApplication = findByPrimaryKey(vehicleApplicationId);

		Session session = null;

		try {
			session = openSession();

			VehicleApplication[] array = new VehicleApplicationImpl[3];

			array[0] = getByApplicantName_PrevAndNext(session,
					vehicleApplication, applicantName, orderByComparator, true);

			array[1] = vehicleApplication;

			array[2] = getByApplicantName_PrevAndNext(session,
					vehicleApplication, applicantName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VehicleApplication getByApplicantName_PrevAndNext(
		Session session, VehicleApplication vehicleApplication,
		String applicantName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VEHICLEAPPLICATION_WHERE);

		boolean bindApplicantName = false;

		if (applicantName == null) {
			query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_1);
		}
		else if (applicantName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_3);
		}
		else {
			bindApplicantName = true;

			query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VehicleApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindApplicantName) {
			qPos.add(applicantName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vehicleApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VehicleApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vehicle applications where applicantName LIKE &#63; from the database.
	 *
	 * @param applicantName the applicant name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApplicantName(String applicantName)
		throws SystemException {
		for (VehicleApplication vehicleApplication : findByApplicantName(
				applicantName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vehicleApplication);
		}
	}

	/**
	 * Returns the number of vehicle applications where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @return the number of matching vehicle applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByApplicantName(String applicantName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_APPLICANTNAME;

		Object[] finderArgs = new Object[] { applicantName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VEHICLEAPPLICATION_WHERE);

			boolean bindApplicantName = false;

			if (applicantName == null) {
				query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_1);
			}
			else if (applicantName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_3);
			}
			else {
				bindApplicantName = true;

				query.append(_FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicantName) {
					qPos.add(applicantName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_1 = "vehicleApplication.applicantName LIKE NULL";
	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_2 = "vehicleApplication.applicantName LIKE ?";
	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_3 = "(vehicleApplication.applicantName IS NULL OR vehicleApplication.applicantName LIKE '')";

	public VehicleApplicationPersistenceImpl() {
		setModelClass(VehicleApplication.class);
	}

	/**
	 * Caches the vehicle application in the entity cache if it is enabled.
	 *
	 * @param vehicleApplication the vehicle application
	 */
	@Override
	public void cacheResult(VehicleApplication vehicleApplication) {
		EntityCacheUtil.putResult(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationImpl.class, vehicleApplication.getPrimaryKey(),
			vehicleApplication);

		vehicleApplication.resetOriginalValues();
	}

	/**
	 * Caches the vehicle applications in the entity cache if it is enabled.
	 *
	 * @param vehicleApplications the vehicle applications
	 */
	@Override
	public void cacheResult(List<VehicleApplication> vehicleApplications) {
		for (VehicleApplication vehicleApplication : vehicleApplications) {
			if (EntityCacheUtil.getResult(
						VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
						VehicleApplicationImpl.class,
						vehicleApplication.getPrimaryKey()) == null) {
				cacheResult(vehicleApplication);
			}
			else {
				vehicleApplication.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vehicle applications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VehicleApplicationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VehicleApplicationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vehicle application.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VehicleApplication vehicleApplication) {
		EntityCacheUtil.removeResult(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationImpl.class, vehicleApplication.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VehicleApplication> vehicleApplications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VehicleApplication vehicleApplication : vehicleApplications) {
			EntityCacheUtil.removeResult(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
				VehicleApplicationImpl.class, vehicleApplication.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vehicle application with the primary key. Does not add the vehicle application to the database.
	 *
	 * @param vehicleApplicationId the primary key for the new vehicle application
	 * @return the new vehicle application
	 */
	@Override
	public VehicleApplication create(long vehicleApplicationId) {
		VehicleApplication vehicleApplication = new VehicleApplicationImpl();

		vehicleApplication.setNew(true);
		vehicleApplication.setPrimaryKey(vehicleApplicationId);

		return vehicleApplication;
	}

	/**
	 * Removes the vehicle application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehicleApplicationId the primary key of the vehicle application
	 * @return the vehicle application that was removed
	 * @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication remove(long vehicleApplicationId)
		throws NoSuchVehicleApplicationException, SystemException {
		return remove((Serializable)vehicleApplicationId);
	}

	/**
	 * Removes the vehicle application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vehicle application
	 * @return the vehicle application that was removed
	 * @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication remove(Serializable primaryKey)
		throws NoSuchVehicleApplicationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VehicleApplication vehicleApplication = (VehicleApplication)session.get(VehicleApplicationImpl.class,
					primaryKey);

			if (vehicleApplication == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVehicleApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vehicleApplication);
		}
		catch (NoSuchVehicleApplicationException nsee) {
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
	protected VehicleApplication removeImpl(
		VehicleApplication vehicleApplication) throws SystemException {
		vehicleApplication = toUnwrappedModel(vehicleApplication);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vehicleApplication)) {
				vehicleApplication = (VehicleApplication)session.get(VehicleApplicationImpl.class,
						vehicleApplication.getPrimaryKeyObj());
			}

			if (vehicleApplication != null) {
				session.delete(vehicleApplication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vehicleApplication != null) {
			clearCache(vehicleApplication);
		}

		return vehicleApplication;
	}

	@Override
	public VehicleApplication updateImpl(
		com.justonetech.oa.model.VehicleApplication vehicleApplication)
		throws SystemException {
		vehicleApplication = toUnwrappedModel(vehicleApplication);

		boolean isNew = vehicleApplication.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vehicleApplication.isNew()) {
				session.save(vehicleApplication);

				vehicleApplication.setNew(false);
			}
			else {
				session.merge(vehicleApplication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VehicleApplicationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
			VehicleApplicationImpl.class, vehicleApplication.getPrimaryKey(),
			vehicleApplication);

		return vehicleApplication;
	}

	protected VehicleApplication toUnwrappedModel(
		VehicleApplication vehicleApplication) {
		if (vehicleApplication instanceof VehicleApplicationImpl) {
			return vehicleApplication;
		}

		VehicleApplicationImpl vehicleApplicationImpl = new VehicleApplicationImpl();

		vehicleApplicationImpl.setNew(vehicleApplication.isNew());
		vehicleApplicationImpl.setPrimaryKey(vehicleApplication.getPrimaryKey());

		vehicleApplicationImpl.setVehicleApplicationId(vehicleApplication.getVehicleApplicationId());
		vehicleApplicationImpl.setGroupId(vehicleApplication.getGroupId());
		vehicleApplicationImpl.setCompanyId(vehicleApplication.getCompanyId());
		vehicleApplicationImpl.setUserId(vehicleApplication.getUserId());
		vehicleApplicationImpl.setUserName(vehicleApplication.getUserName());
		vehicleApplicationImpl.setCreateTime(vehicleApplication.getCreateTime());
		vehicleApplicationImpl.setModifiedTime(vehicleApplication.getModifiedTime());
		vehicleApplicationImpl.setApplicantDeptId(vehicleApplication.getApplicantDeptId());
		vehicleApplicationImpl.setApplicantDeptName(vehicleApplication.getApplicantDeptName());
		vehicleApplicationImpl.setApplicantId(vehicleApplication.getApplicantId());
		vehicleApplicationImpl.setApplicantName(vehicleApplication.getApplicantName());
		vehicleApplicationImpl.setStartTime(vehicleApplication.getStartTime());
		vehicleApplicationImpl.setEndTime(vehicleApplication.getEndTime());
		vehicleApplicationImpl.setPassengerNum(vehicleApplication.getPassengerNum());
		vehicleApplicationImpl.setReason(vehicleApplication.getReason());
		vehicleApplicationImpl.setDestination(vehicleApplication.getDestination());

		return vehicleApplicationImpl;
	}

	/**
	 * Returns the vehicle application with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vehicle application
	 * @return the vehicle application
	 * @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVehicleApplicationException, SystemException {
		VehicleApplication vehicleApplication = fetchByPrimaryKey(primaryKey);

		if (vehicleApplication == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVehicleApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vehicleApplication;
	}

	/**
	 * Returns the vehicle application with the primary key or throws a {@link com.justonetech.oa.NoSuchVehicleApplicationException} if it could not be found.
	 *
	 * @param vehicleApplicationId the primary key of the vehicle application
	 * @return the vehicle application
	 * @throws com.justonetech.oa.NoSuchVehicleApplicationException if a vehicle application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication findByPrimaryKey(long vehicleApplicationId)
		throws NoSuchVehicleApplicationException, SystemException {
		return findByPrimaryKey((Serializable)vehicleApplicationId);
	}

	/**
	 * Returns the vehicle application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vehicle application
	 * @return the vehicle application, or <code>null</code> if a vehicle application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VehicleApplication vehicleApplication = (VehicleApplication)EntityCacheUtil.getResult(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
				VehicleApplicationImpl.class, primaryKey);

		if (vehicleApplication == _nullVehicleApplication) {
			return null;
		}

		if (vehicleApplication == null) {
			Session session = null;

			try {
				session = openSession();

				vehicleApplication = (VehicleApplication)session.get(VehicleApplicationImpl.class,
						primaryKey);

				if (vehicleApplication != null) {
					cacheResult(vehicleApplication);
				}
				else {
					EntityCacheUtil.putResult(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
						VehicleApplicationImpl.class, primaryKey,
						_nullVehicleApplication);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VehicleApplicationModelImpl.ENTITY_CACHE_ENABLED,
					VehicleApplicationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vehicleApplication;
	}

	/**
	 * Returns the vehicle application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vehicleApplicationId the primary key of the vehicle application
	 * @return the vehicle application, or <code>null</code> if a vehicle application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleApplication fetchByPrimaryKey(long vehicleApplicationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vehicleApplicationId);
	}

	/**
	 * Returns all the vehicle applications.
	 *
	 * @return the vehicle applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleApplication> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vehicle applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehicle applications
	 * @param end the upper bound of the range of vehicle applications (not inclusive)
	 * @return the range of vehicle applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleApplication> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vehicle applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehicle applications
	 * @param end the upper bound of the range of vehicle applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vehicle applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleApplication> findAll(int start, int end,
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

		List<VehicleApplication> list = (List<VehicleApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VEHICLEAPPLICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VEHICLEAPPLICATION;

				if (pagination) {
					sql = sql.concat(VehicleApplicationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VehicleApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VehicleApplication>(list);
				}
				else {
					list = (List<VehicleApplication>)QueryUtil.list(q,
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
	 * Removes all the vehicle applications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VehicleApplication vehicleApplication : findAll()) {
			remove(vehicleApplication);
		}
	}

	/**
	 * Returns the number of vehicle applications.
	 *
	 * @return the number of vehicle applications
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

				Query q = session.createQuery(_SQL_COUNT_VEHICLEAPPLICATION);

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
	 * Initializes the vehicle application persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.VehicleApplication")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VehicleApplication>> listenersList = new ArrayList<ModelListener<VehicleApplication>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VehicleApplication>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VehicleApplicationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VEHICLEAPPLICATION = "SELECT vehicleApplication FROM VehicleApplication vehicleApplication";
	private static final String _SQL_SELECT_VEHICLEAPPLICATION_WHERE = "SELECT vehicleApplication FROM VehicleApplication vehicleApplication WHERE ";
	private static final String _SQL_COUNT_VEHICLEAPPLICATION = "SELECT COUNT(vehicleApplication) FROM VehicleApplication vehicleApplication";
	private static final String _SQL_COUNT_VEHICLEAPPLICATION_WHERE = "SELECT COUNT(vehicleApplication) FROM VehicleApplication vehicleApplication WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vehicleApplication.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VehicleApplication exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VehicleApplication exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VehicleApplicationPersistenceImpl.class);
	private static VehicleApplication _nullVehicleApplication = new VehicleApplicationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VehicleApplication> toCacheModel() {
				return _nullVehicleApplicationCacheModel;
			}
		};

	private static CacheModel<VehicleApplication> _nullVehicleApplicationCacheModel =
		new CacheModel<VehicleApplication>() {
			@Override
			public VehicleApplication toEntityModel() {
				return _nullVehicleApplication;
			}
		};
}