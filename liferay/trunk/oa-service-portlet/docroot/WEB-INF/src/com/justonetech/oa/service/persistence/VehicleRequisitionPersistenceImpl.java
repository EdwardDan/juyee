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

import com.justonetech.oa.NoSuchVehicleRequisitionException;
import com.justonetech.oa.model.VehicleRequisition;
import com.justonetech.oa.model.impl.VehicleRequisitionImpl;
import com.justonetech.oa.model.impl.VehicleRequisitionModelImpl;

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
 * The persistence implementation for the vehicle requisition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see VehicleRequisitionPersistence
 * @see VehicleRequisitionUtil
 * @generated
 */
public class VehicleRequisitionPersistenceImpl extends BasePersistenceImpl<VehicleRequisition>
	implements VehicleRequisitionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VehicleRequisitionUtil} to access the vehicle requisition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VehicleRequisitionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionModelImpl.FINDER_CACHE_ENABLED,
			VehicleRequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionModelImpl.FINDER_CACHE_ENABLED,
			VehicleRequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNAME =
		new FinderPath(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionModelImpl.FINDER_CACHE_ENABLED,
			VehicleRequisitionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicantName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_APPLICANTNAME =
		new FinderPath(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByApplicantName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vehicle requisitions where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @return the matching vehicle requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleRequisition> findByApplicantName(String applicantName)
		throws SystemException {
		return findByApplicantName(applicantName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vehicle requisitions where applicantName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantName the applicant name
	 * @param start the lower bound of the range of vehicle requisitions
	 * @param end the upper bound of the range of vehicle requisitions (not inclusive)
	 * @return the range of matching vehicle requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleRequisition> findByApplicantName(String applicantName,
		int start, int end) throws SystemException {
		return findByApplicantName(applicantName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vehicle requisitions where applicantName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantName the applicant name
	 * @param start the lower bound of the range of vehicle requisitions
	 * @param end the upper bound of the range of vehicle requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vehicle requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleRequisition> findByApplicantName(String applicantName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNAME;
		finderArgs = new Object[] { applicantName, start, end, orderByComparator };

		List<VehicleRequisition> list = (List<VehicleRequisition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VehicleRequisition vehicleRequisition : list) {
				if (!StringUtil.wildcardMatches(
							vehicleRequisition.getApplicantName(),
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

			query.append(_SQL_SELECT_VEHICLEREQUISITION_WHERE);

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
				query.append(VehicleRequisitionModelImpl.ORDER_BY_JPQL);
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
					list = (List<VehicleRequisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VehicleRequisition>(list);
				}
				else {
					list = (List<VehicleRequisition>)QueryUtil.list(q,
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
	 * Returns the first vehicle requisition in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vehicle requisition
	 * @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a matching vehicle requisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition findByApplicantName_First(String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchVehicleRequisitionException, SystemException {
		VehicleRequisition vehicleRequisition = fetchByApplicantName_First(applicantName,
				orderByComparator);

		if (vehicleRequisition != null) {
			return vehicleRequisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantName=");
		msg.append(applicantName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVehicleRequisitionException(msg.toString());
	}

	/**
	 * Returns the first vehicle requisition in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vehicle requisition, or <code>null</code> if a matching vehicle requisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition fetchByApplicantName_First(String applicantName,
		OrderByComparator orderByComparator) throws SystemException {
		List<VehicleRequisition> list = findByApplicantName(applicantName, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vehicle requisition in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vehicle requisition
	 * @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a matching vehicle requisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition findByApplicantName_Last(String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchVehicleRequisitionException, SystemException {
		VehicleRequisition vehicleRequisition = fetchByApplicantName_Last(applicantName,
				orderByComparator);

		if (vehicleRequisition != null) {
			return vehicleRequisition;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantName=");
		msg.append(applicantName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVehicleRequisitionException(msg.toString());
	}

	/**
	 * Returns the last vehicle requisition in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vehicle requisition, or <code>null</code> if a matching vehicle requisition could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition fetchByApplicantName_Last(String applicantName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByApplicantName(applicantName);

		if (count == 0) {
			return null;
		}

		List<VehicleRequisition> list = findByApplicantName(applicantName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vehicle requisitions before and after the current vehicle requisition in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param vehicleRequisitionId the primary key of the current vehicle requisition
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vehicle requisition
	 * @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition[] findByApplicantName_PrevAndNext(
		long vehicleRequisitionId, String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchVehicleRequisitionException, SystemException {
		VehicleRequisition vehicleRequisition = findByPrimaryKey(vehicleRequisitionId);

		Session session = null;

		try {
			session = openSession();

			VehicleRequisition[] array = new VehicleRequisitionImpl[3];

			array[0] = getByApplicantName_PrevAndNext(session,
					vehicleRequisition, applicantName, orderByComparator, true);

			array[1] = vehicleRequisition;

			array[2] = getByApplicantName_PrevAndNext(session,
					vehicleRequisition, applicantName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VehicleRequisition getByApplicantName_PrevAndNext(
		Session session, VehicleRequisition vehicleRequisition,
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

		query.append(_SQL_SELECT_VEHICLEREQUISITION_WHERE);

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
			query.append(VehicleRequisitionModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(vehicleRequisition);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VehicleRequisition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vehicle requisitions where applicantName LIKE &#63; from the database.
	 *
	 * @param applicantName the applicant name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApplicantName(String applicantName)
		throws SystemException {
		for (VehicleRequisition vehicleRequisition : findByApplicantName(
				applicantName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vehicleRequisition);
		}
	}

	/**
	 * Returns the number of vehicle requisitions where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @return the number of matching vehicle requisitions
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

			query.append(_SQL_COUNT_VEHICLEREQUISITION_WHERE);

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

	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_1 = "vehicleRequisition.applicantName LIKE NULL";
	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_2 = "vehicleRequisition.applicantName LIKE ?";
	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_3 = "(vehicleRequisition.applicantName IS NULL OR vehicleRequisition.applicantName LIKE '')";

	public VehicleRequisitionPersistenceImpl() {
		setModelClass(VehicleRequisition.class);
	}

	/**
	 * Caches the vehicle requisition in the entity cache if it is enabled.
	 *
	 * @param vehicleRequisition the vehicle requisition
	 */
	@Override
	public void cacheResult(VehicleRequisition vehicleRequisition) {
		EntityCacheUtil.putResult(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionImpl.class, vehicleRequisition.getPrimaryKey(),
			vehicleRequisition);

		vehicleRequisition.resetOriginalValues();
	}

	/**
	 * Caches the vehicle requisitions in the entity cache if it is enabled.
	 *
	 * @param vehicleRequisitions the vehicle requisitions
	 */
	@Override
	public void cacheResult(List<VehicleRequisition> vehicleRequisitions) {
		for (VehicleRequisition vehicleRequisition : vehicleRequisitions) {
			if (EntityCacheUtil.getResult(
						VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
						VehicleRequisitionImpl.class,
						vehicleRequisition.getPrimaryKey()) == null) {
				cacheResult(vehicleRequisition);
			}
			else {
				vehicleRequisition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vehicle requisitions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VehicleRequisitionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VehicleRequisitionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vehicle requisition.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VehicleRequisition vehicleRequisition) {
		EntityCacheUtil.removeResult(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionImpl.class, vehicleRequisition.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VehicleRequisition> vehicleRequisitions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VehicleRequisition vehicleRequisition : vehicleRequisitions) {
			EntityCacheUtil.removeResult(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
				VehicleRequisitionImpl.class, vehicleRequisition.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vehicle requisition with the primary key. Does not add the vehicle requisition to the database.
	 *
	 * @param vehicleRequisitionId the primary key for the new vehicle requisition
	 * @return the new vehicle requisition
	 */
	@Override
	public VehicleRequisition create(long vehicleRequisitionId) {
		VehicleRequisition vehicleRequisition = new VehicleRequisitionImpl();

		vehicleRequisition.setNew(true);
		vehicleRequisition.setPrimaryKey(vehicleRequisitionId);

		return vehicleRequisition;
	}

	/**
	 * Removes the vehicle requisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vehicleRequisitionId the primary key of the vehicle requisition
	 * @return the vehicle requisition that was removed
	 * @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition remove(long vehicleRequisitionId)
		throws NoSuchVehicleRequisitionException, SystemException {
		return remove((Serializable)vehicleRequisitionId);
	}

	/**
	 * Removes the vehicle requisition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vehicle requisition
	 * @return the vehicle requisition that was removed
	 * @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition remove(Serializable primaryKey)
		throws NoSuchVehicleRequisitionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VehicleRequisition vehicleRequisition = (VehicleRequisition)session.get(VehicleRequisitionImpl.class,
					primaryKey);

			if (vehicleRequisition == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVehicleRequisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vehicleRequisition);
		}
		catch (NoSuchVehicleRequisitionException nsee) {
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
	protected VehicleRequisition removeImpl(
		VehicleRequisition vehicleRequisition) throws SystemException {
		vehicleRequisition = toUnwrappedModel(vehicleRequisition);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vehicleRequisition)) {
				vehicleRequisition = (VehicleRequisition)session.get(VehicleRequisitionImpl.class,
						vehicleRequisition.getPrimaryKeyObj());
			}

			if (vehicleRequisition != null) {
				session.delete(vehicleRequisition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vehicleRequisition != null) {
			clearCache(vehicleRequisition);
		}

		return vehicleRequisition;
	}

	@Override
	public VehicleRequisition updateImpl(
		com.justonetech.oa.model.VehicleRequisition vehicleRequisition)
		throws SystemException {
		vehicleRequisition = toUnwrappedModel(vehicleRequisition);

		boolean isNew = vehicleRequisition.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vehicleRequisition.isNew()) {
				session.save(vehicleRequisition);

				vehicleRequisition.setNew(false);
			}
			else {
				session.merge(vehicleRequisition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VehicleRequisitionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
			VehicleRequisitionImpl.class, vehicleRequisition.getPrimaryKey(),
			vehicleRequisition);

		return vehicleRequisition;
	}

	protected VehicleRequisition toUnwrappedModel(
		VehicleRequisition vehicleRequisition) {
		if (vehicleRequisition instanceof VehicleRequisitionImpl) {
			return vehicleRequisition;
		}

		VehicleRequisitionImpl vehicleRequisitionImpl = new VehicleRequisitionImpl();

		vehicleRequisitionImpl.setNew(vehicleRequisition.isNew());
		vehicleRequisitionImpl.setPrimaryKey(vehicleRequisition.getPrimaryKey());

		vehicleRequisitionImpl.setVehicleRequisitionId(vehicleRequisition.getVehicleRequisitionId());
		vehicleRequisitionImpl.setUserId(vehicleRequisition.getUserId());
		vehicleRequisitionImpl.setUserName(vehicleRequisition.getUserName());
		vehicleRequisitionImpl.setCreateTime(vehicleRequisition.getCreateTime());
		vehicleRequisitionImpl.setModifiedTime(vehicleRequisition.getModifiedTime());
		vehicleRequisitionImpl.setApplicantDeptId(vehicleRequisition.getApplicantDeptId());
		vehicleRequisitionImpl.setApplicantDeptName(vehicleRequisition.getApplicantDeptName());
		vehicleRequisitionImpl.setApplicantId(vehicleRequisition.getApplicantId());
		vehicleRequisitionImpl.setApplicantName(vehicleRequisition.getApplicantName());
		vehicleRequisitionImpl.setStartTime(vehicleRequisition.getStartTime());
		vehicleRequisitionImpl.setEndTime(vehicleRequisition.getEndTime());
		vehicleRequisitionImpl.setPassengerNum(vehicleRequisition.getPassengerNum());
		vehicleRequisitionImpl.setReason(vehicleRequisition.getReason());
		vehicleRequisitionImpl.setDestination(vehicleRequisition.getDestination());

		return vehicleRequisitionImpl;
	}

	/**
	 * Returns the vehicle requisition with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vehicle requisition
	 * @return the vehicle requisition
	 * @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVehicleRequisitionException, SystemException {
		VehicleRequisition vehicleRequisition = fetchByPrimaryKey(primaryKey);

		if (vehicleRequisition == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVehicleRequisitionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vehicleRequisition;
	}

	/**
	 * Returns the vehicle requisition with the primary key or throws a {@link com.justonetech.oa.NoSuchVehicleRequisitionException} if it could not be found.
	 *
	 * @param vehicleRequisitionId the primary key of the vehicle requisition
	 * @return the vehicle requisition
	 * @throws com.justonetech.oa.NoSuchVehicleRequisitionException if a vehicle requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition findByPrimaryKey(long vehicleRequisitionId)
		throws NoSuchVehicleRequisitionException, SystemException {
		return findByPrimaryKey((Serializable)vehicleRequisitionId);
	}

	/**
	 * Returns the vehicle requisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vehicle requisition
	 * @return the vehicle requisition, or <code>null</code> if a vehicle requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VehicleRequisition vehicleRequisition = (VehicleRequisition)EntityCacheUtil.getResult(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
				VehicleRequisitionImpl.class, primaryKey);

		if (vehicleRequisition == _nullVehicleRequisition) {
			return null;
		}

		if (vehicleRequisition == null) {
			Session session = null;

			try {
				session = openSession();

				vehicleRequisition = (VehicleRequisition)session.get(VehicleRequisitionImpl.class,
						primaryKey);

				if (vehicleRequisition != null) {
					cacheResult(vehicleRequisition);
				}
				else {
					EntityCacheUtil.putResult(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
						VehicleRequisitionImpl.class, primaryKey,
						_nullVehicleRequisition);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VehicleRequisitionModelImpl.ENTITY_CACHE_ENABLED,
					VehicleRequisitionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vehicleRequisition;
	}

	/**
	 * Returns the vehicle requisition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vehicleRequisitionId the primary key of the vehicle requisition
	 * @return the vehicle requisition, or <code>null</code> if a vehicle requisition with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VehicleRequisition fetchByPrimaryKey(long vehicleRequisitionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vehicleRequisitionId);
	}

	/**
	 * Returns all the vehicle requisitions.
	 *
	 * @return the vehicle requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleRequisition> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vehicle requisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehicle requisitions
	 * @param end the upper bound of the range of vehicle requisitions (not inclusive)
	 * @return the range of vehicle requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleRequisition> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vehicle requisitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.VehicleRequisitionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vehicle requisitions
	 * @param end the upper bound of the range of vehicle requisitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vehicle requisitions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VehicleRequisition> findAll(int start, int end,
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

		List<VehicleRequisition> list = (List<VehicleRequisition>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VEHICLEREQUISITION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VEHICLEREQUISITION;

				if (pagination) {
					sql = sql.concat(VehicleRequisitionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VehicleRequisition>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VehicleRequisition>(list);
				}
				else {
					list = (List<VehicleRequisition>)QueryUtil.list(q,
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
	 * Removes all the vehicle requisitions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VehicleRequisition vehicleRequisition : findAll()) {
			remove(vehicleRequisition);
		}
	}

	/**
	 * Returns the number of vehicle requisitions.
	 *
	 * @return the number of vehicle requisitions
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

				Query q = session.createQuery(_SQL_COUNT_VEHICLEREQUISITION);

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
	 * Initializes the vehicle requisition persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.VehicleRequisition")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VehicleRequisition>> listenersList = new ArrayList<ModelListener<VehicleRequisition>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VehicleRequisition>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VehicleRequisitionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VEHICLEREQUISITION = "SELECT vehicleRequisition FROM VehicleRequisition vehicleRequisition";
	private static final String _SQL_SELECT_VEHICLEREQUISITION_WHERE = "SELECT vehicleRequisition FROM VehicleRequisition vehicleRequisition WHERE ";
	private static final String _SQL_COUNT_VEHICLEREQUISITION = "SELECT COUNT(vehicleRequisition) FROM VehicleRequisition vehicleRequisition";
	private static final String _SQL_COUNT_VEHICLEREQUISITION_WHERE = "SELECT COUNT(vehicleRequisition) FROM VehicleRequisition vehicleRequisition WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vehicleRequisition.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VehicleRequisition exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VehicleRequisition exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VehicleRequisitionPersistenceImpl.class);
	private static VehicleRequisition _nullVehicleRequisition = new VehicleRequisitionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VehicleRequisition> toCacheModel() {
				return _nullVehicleRequisitionCacheModel;
			}
		};

	private static CacheModel<VehicleRequisition> _nullVehicleRequisitionCacheModel =
		new CacheModel<VehicleRequisition>() {
			@Override
			public VehicleRequisition toEntityModel() {
				return _nullVehicleRequisition;
			}
		};
}