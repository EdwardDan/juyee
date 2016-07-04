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

import com.justonetech.oa.NoSuchOfficeSupplyApplyException;
import com.justonetech.oa.model.OfficeSupplyApply;
import com.justonetech.oa.model.impl.OfficeSupplyApplyImpl;
import com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl;

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
 * The persistence implementation for the office supply apply service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyApplyPersistence
 * @see OfficeSupplyApplyUtil
 * @generated
 */
public class OfficeSupplyApplyPersistenceImpl extends BasePersistenceImpl<OfficeSupplyApply>
	implements OfficeSupplyApplyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficeSupplyApplyUtil} to access the office supply apply persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficeSupplyApplyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPTNAME = new FinderPath(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeptName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_DEPTNAME =
		new FinderPath(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByDeptName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the office supply applies where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @return the matching office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findByDeptName(String deptName)
		throws SystemException {
		return findByDeptName(deptName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the office supply applies where deptName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deptName the dept name
	 * @param start the lower bound of the range of office supply applies
	 * @param end the upper bound of the range of office supply applies (not inclusive)
	 * @return the range of matching office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findByDeptName(String deptName, int start,
		int end) throws SystemException {
		return findByDeptName(deptName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply applies where deptName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deptName the dept name
	 * @param start the lower bound of the range of office supply applies
	 * @param end the upper bound of the range of office supply applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findByDeptName(String deptName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPTNAME;
		finderArgs = new Object[] { deptName, start, end, orderByComparator };

		List<OfficeSupplyApply> list = (List<OfficeSupplyApply>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OfficeSupplyApply officeSupplyApply : list) {
				if (!StringUtil.wildcardMatches(
							officeSupplyApply.getDeptName(), deptName,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_OFFICESUPPLYAPPLY_WHERE);

			boolean bindDeptName = false;

			if (deptName == null) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_1);
			}
			else if (deptName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_3);
			}
			else {
				bindDeptName = true;

				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficeSupplyApplyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeptName) {
					qPos.add(deptName);
				}

				if (!pagination) {
					list = (List<OfficeSupplyApply>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApply>(list);
				}
				else {
					list = (List<OfficeSupplyApply>)QueryUtil.list(q,
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
	 * Returns the first office supply apply in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply findByDeptName_First(String deptName,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		OfficeSupplyApply officeSupplyApply = fetchByDeptName_First(deptName,
				orderByComparator);

		if (officeSupplyApply != null) {
			return officeSupplyApply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deptName=");
		msg.append(deptName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplyException(msg.toString());
	}

	/**
	 * Returns the first office supply apply in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply fetchByDeptName_First(String deptName,
		OrderByComparator orderByComparator) throws SystemException {
		List<OfficeSupplyApply> list = findByDeptName(deptName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last office supply apply in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply findByDeptName_Last(String deptName,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		OfficeSupplyApply officeSupplyApply = fetchByDeptName_Last(deptName,
				orderByComparator);

		if (officeSupplyApply != null) {
			return officeSupplyApply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deptName=");
		msg.append(deptName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplyException(msg.toString());
	}

	/**
	 * Returns the last office supply apply in the ordered set where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply fetchByDeptName_Last(String deptName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDeptName(deptName);

		if (count == 0) {
			return null;
		}

		List<OfficeSupplyApply> list = findByDeptName(deptName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the office supply applies before and after the current office supply apply in the ordered set where deptName LIKE &#63;.
	 *
	 * @param officeSupplyApplyId the primary key of the current office supply apply
	 * @param deptName the dept name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply[] findByDeptName_PrevAndNext(
		long officeSupplyApplyId, String deptName,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		OfficeSupplyApply officeSupplyApply = findByPrimaryKey(officeSupplyApplyId);

		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApply[] array = new OfficeSupplyApplyImpl[3];

			array[0] = getByDeptName_PrevAndNext(session, officeSupplyApply,
					deptName, orderByComparator, true);

			array[1] = officeSupplyApply;

			array[2] = getByDeptName_PrevAndNext(session, officeSupplyApply,
					deptName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OfficeSupplyApply getByDeptName_PrevAndNext(Session session,
		OfficeSupplyApply officeSupplyApply, String deptName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OFFICESUPPLYAPPLY_WHERE);

		boolean bindDeptName = false;

		if (deptName == null) {
			query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_1);
		}
		else if (deptName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_3);
		}
		else {
			bindDeptName = true;

			query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_2);
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
			query.append(OfficeSupplyApplyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDeptName) {
			qPos.add(deptName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(officeSupplyApply);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OfficeSupplyApply> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the office supply applies where deptName LIKE &#63; from the database.
	 *
	 * @param deptName the dept name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDeptName(String deptName) throws SystemException {
		for (OfficeSupplyApply officeSupplyApply : findByDeptName(deptName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(officeSupplyApply);
		}
	}

	/**
	 * Returns the number of office supply applies where deptName LIKE &#63;.
	 *
	 * @param deptName the dept name
	 * @return the number of matching office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDeptName(String deptName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_DEPTNAME;

		Object[] finderArgs = new Object[] { deptName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICESUPPLYAPPLY_WHERE);

			boolean bindDeptName = false;

			if (deptName == null) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_1);
			}
			else if (deptName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_3);
			}
			else {
				bindDeptName = true;

				query.append(_FINDER_COLUMN_DEPTNAME_DEPTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeptName) {
					qPos.add(deptName);
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

	private static final String _FINDER_COLUMN_DEPTNAME_DEPTNAME_1 = "officeSupplyApply.deptName LIKE NULL";
	private static final String _FINDER_COLUMN_DEPTNAME_DEPTNAME_2 = "officeSupplyApply.deptName LIKE ?";
	private static final String _FINDER_COLUMN_DEPTNAME_DEPTNAME_3 = "(officeSupplyApply.deptName IS NULL OR officeSupplyApply.deptName LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNAME =
		new FinderPath(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyModelImpl.FINDER_CACHE_ENABLED,
			OfficeSupplyApplyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByApplicantName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_APPLICANTNAME =
		new FinderPath(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByApplicantName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the office supply applies where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @return the matching office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findByApplicantName(String applicantName)
		throws SystemException {
		return findByApplicantName(applicantName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply applies where applicantName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantName the applicant name
	 * @param start the lower bound of the range of office supply applies
	 * @param end the upper bound of the range of office supply applies (not inclusive)
	 * @return the range of matching office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findByApplicantName(String applicantName,
		int start, int end) throws SystemException {
		return findByApplicantName(applicantName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply applies where applicantName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicantName the applicant name
	 * @param start the lower bound of the range of office supply applies
	 * @param end the upper bound of the range of office supply applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findByApplicantName(String applicantName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICANTNAME;
		finderArgs = new Object[] { applicantName, start, end, orderByComparator };

		List<OfficeSupplyApply> list = (List<OfficeSupplyApply>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OfficeSupplyApply officeSupplyApply : list) {
				if (!StringUtil.wildcardMatches(
							officeSupplyApply.getApplicantName(),
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

			query.append(_SQL_SELECT_OFFICESUPPLYAPPLY_WHERE);

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
				query.append(OfficeSupplyApplyModelImpl.ORDER_BY_JPQL);
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
					list = (List<OfficeSupplyApply>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApply>(list);
				}
				else {
					list = (List<OfficeSupplyApply>)QueryUtil.list(q,
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
	 * Returns the first office supply apply in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply findByApplicantName_First(String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		OfficeSupplyApply officeSupplyApply = fetchByApplicantName_First(applicantName,
				orderByComparator);

		if (officeSupplyApply != null) {
			return officeSupplyApply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantName=");
		msg.append(applicantName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplyException(msg.toString());
	}

	/**
	 * Returns the first office supply apply in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply fetchByApplicantName_First(String applicantName,
		OrderByComparator orderByComparator) throws SystemException {
		List<OfficeSupplyApply> list = findByApplicantName(applicantName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last office supply apply in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply findByApplicantName_Last(String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		OfficeSupplyApply officeSupplyApply = fetchByApplicantName_Last(applicantName,
				orderByComparator);

		if (officeSupplyApply != null) {
			return officeSupplyApply;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicantName=");
		msg.append(applicantName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficeSupplyApplyException(msg.toString());
	}

	/**
	 * Returns the last office supply apply in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching office supply apply, or <code>null</code> if a matching office supply apply could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply fetchByApplicantName_Last(String applicantName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByApplicantName(applicantName);

		if (count == 0) {
			return null;
		}

		List<OfficeSupplyApply> list = findByApplicantName(applicantName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the office supply applies before and after the current office supply apply in the ordered set where applicantName LIKE &#63;.
	 *
	 * @param officeSupplyApplyId the primary key of the current office supply apply
	 * @param applicantName the applicant name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply[] findByApplicantName_PrevAndNext(
		long officeSupplyApplyId, String applicantName,
		OrderByComparator orderByComparator)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		OfficeSupplyApply officeSupplyApply = findByPrimaryKey(officeSupplyApplyId);

		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApply[] array = new OfficeSupplyApplyImpl[3];

			array[0] = getByApplicantName_PrevAndNext(session,
					officeSupplyApply, applicantName, orderByComparator, true);

			array[1] = officeSupplyApply;

			array[2] = getByApplicantName_PrevAndNext(session,
					officeSupplyApply, applicantName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OfficeSupplyApply getByApplicantName_PrevAndNext(
		Session session, OfficeSupplyApply officeSupplyApply,
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

		query.append(_SQL_SELECT_OFFICESUPPLYAPPLY_WHERE);

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
			query.append(OfficeSupplyApplyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(officeSupplyApply);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OfficeSupplyApply> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the office supply applies where applicantName LIKE &#63; from the database.
	 *
	 * @param applicantName the applicant name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByApplicantName(String applicantName)
		throws SystemException {
		for (OfficeSupplyApply officeSupplyApply : findByApplicantName(
				applicantName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(officeSupplyApply);
		}
	}

	/**
	 * Returns the number of office supply applies where applicantName LIKE &#63;.
	 *
	 * @param applicantName the applicant name
	 * @return the number of matching office supply applies
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

			query.append(_SQL_COUNT_OFFICESUPPLYAPPLY_WHERE);

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

	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_1 = "officeSupplyApply.applicantName LIKE NULL";
	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_2 = "officeSupplyApply.applicantName LIKE ?";
	private static final String _FINDER_COLUMN_APPLICANTNAME_APPLICANTNAME_3 = "(officeSupplyApply.applicantName IS NULL OR officeSupplyApply.applicantName LIKE '')";

	public OfficeSupplyApplyPersistenceImpl() {
		setModelClass(OfficeSupplyApply.class);
	}

	/**
	 * Caches the office supply apply in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApply the office supply apply
	 */
	@Override
	public void cacheResult(OfficeSupplyApply officeSupplyApply) {
		EntityCacheUtil.putResult(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyImpl.class, officeSupplyApply.getPrimaryKey(),
			officeSupplyApply);

		officeSupplyApply.resetOriginalValues();
	}

	/**
	 * Caches the office supply applies in the entity cache if it is enabled.
	 *
	 * @param officeSupplyApplies the office supply applies
	 */
	@Override
	public void cacheResult(List<OfficeSupplyApply> officeSupplyApplies) {
		for (OfficeSupplyApply officeSupplyApply : officeSupplyApplies) {
			if (EntityCacheUtil.getResult(
						OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplyImpl.class,
						officeSupplyApply.getPrimaryKey()) == null) {
				cacheResult(officeSupplyApply);
			}
			else {
				officeSupplyApply.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all office supply applies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OfficeSupplyApplyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OfficeSupplyApplyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the office supply apply.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OfficeSupplyApply officeSupplyApply) {
		EntityCacheUtil.removeResult(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyImpl.class, officeSupplyApply.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OfficeSupplyApply> officeSupplyApplies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OfficeSupplyApply officeSupplyApply : officeSupplyApplies) {
			EntityCacheUtil.removeResult(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplyImpl.class, officeSupplyApply.getPrimaryKey());
		}
	}

	/**
	 * Creates a new office supply apply with the primary key. Does not add the office supply apply to the database.
	 *
	 * @param officeSupplyApplyId the primary key for the new office supply apply
	 * @return the new office supply apply
	 */
	@Override
	public OfficeSupplyApply create(long officeSupplyApplyId) {
		OfficeSupplyApply officeSupplyApply = new OfficeSupplyApplyImpl();

		officeSupplyApply.setNew(true);
		officeSupplyApply.setPrimaryKey(officeSupplyApplyId);

		return officeSupplyApply;
	}

	/**
	 * Removes the office supply apply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyApplyId the primary key of the office supply apply
	 * @return the office supply apply that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply remove(long officeSupplyApplyId)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		return remove((Serializable)officeSupplyApplyId);
	}

	/**
	 * Removes the office supply apply with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the office supply apply
	 * @return the office supply apply that was removed
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply remove(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OfficeSupplyApply officeSupplyApply = (OfficeSupplyApply)session.get(OfficeSupplyApplyImpl.class,
					primaryKey);

			if (officeSupplyApply == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficeSupplyApplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(officeSupplyApply);
		}
		catch (NoSuchOfficeSupplyApplyException nsee) {
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
	protected OfficeSupplyApply removeImpl(OfficeSupplyApply officeSupplyApply)
		throws SystemException {
		officeSupplyApply = toUnwrappedModel(officeSupplyApply);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(officeSupplyApply)) {
				officeSupplyApply = (OfficeSupplyApply)session.get(OfficeSupplyApplyImpl.class,
						officeSupplyApply.getPrimaryKeyObj());
			}

			if (officeSupplyApply != null) {
				session.delete(officeSupplyApply);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (officeSupplyApply != null) {
			clearCache(officeSupplyApply);
		}

		return officeSupplyApply;
	}

	@Override
	public OfficeSupplyApply updateImpl(
		com.justonetech.oa.model.OfficeSupplyApply officeSupplyApply)
		throws SystemException {
		officeSupplyApply = toUnwrappedModel(officeSupplyApply);

		boolean isNew = officeSupplyApply.isNew();

		Session session = null;

		try {
			session = openSession();

			if (officeSupplyApply.isNew()) {
				session.save(officeSupplyApply);

				officeSupplyApply.setNew(false);
			}
			else {
				session.merge(officeSupplyApply);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OfficeSupplyApplyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
			OfficeSupplyApplyImpl.class, officeSupplyApply.getPrimaryKey(),
			officeSupplyApply);

		return officeSupplyApply;
	}

	protected OfficeSupplyApply toUnwrappedModel(
		OfficeSupplyApply officeSupplyApply) {
		if (officeSupplyApply instanceof OfficeSupplyApplyImpl) {
			return officeSupplyApply;
		}

		OfficeSupplyApplyImpl officeSupplyApplyImpl = new OfficeSupplyApplyImpl();

		officeSupplyApplyImpl.setNew(officeSupplyApply.isNew());
		officeSupplyApplyImpl.setPrimaryKey(officeSupplyApply.getPrimaryKey());

		officeSupplyApplyImpl.setOfficeSupplyApplyId(officeSupplyApply.getOfficeSupplyApplyId());
		officeSupplyApplyImpl.setUserId(officeSupplyApply.getUserId());
		officeSupplyApplyImpl.setUserName(officeSupplyApply.getUserName());
		officeSupplyApplyImpl.setCreateTime(officeSupplyApply.getCreateTime());
		officeSupplyApplyImpl.setModifiedTime(officeSupplyApply.getModifiedTime());
		officeSupplyApplyImpl.setDeptId(officeSupplyApply.getDeptId());
		officeSupplyApplyImpl.setDeptName(officeSupplyApply.getDeptName());
		officeSupplyApplyImpl.setApplicantId(officeSupplyApply.getApplicantId());
		officeSupplyApplyImpl.setApplicantName(officeSupplyApply.getApplicantName());
		officeSupplyApplyImpl.setIntroductions(officeSupplyApply.getIntroductions());

		return officeSupplyApplyImpl;
	}

	/**
	 * Returns the office supply apply with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply apply
	 * @return the office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		OfficeSupplyApply officeSupplyApply = fetchByPrimaryKey(primaryKey);

		if (officeSupplyApply == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficeSupplyApplyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return officeSupplyApply;
	}

	/**
	 * Returns the office supply apply with the primary key or throws a {@link com.justonetech.oa.NoSuchOfficeSupplyApplyException} if it could not be found.
	 *
	 * @param officeSupplyApplyId the primary key of the office supply apply
	 * @return the office supply apply
	 * @throws com.justonetech.oa.NoSuchOfficeSupplyApplyException if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply findByPrimaryKey(long officeSupplyApplyId)
		throws NoSuchOfficeSupplyApplyException, SystemException {
		return findByPrimaryKey((Serializable)officeSupplyApplyId);
	}

	/**
	 * Returns the office supply apply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the office supply apply
	 * @return the office supply apply, or <code>null</code> if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OfficeSupplyApply officeSupplyApply = (OfficeSupplyApply)EntityCacheUtil.getResult(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
				OfficeSupplyApplyImpl.class, primaryKey);

		if (officeSupplyApply == _nullOfficeSupplyApply) {
			return null;
		}

		if (officeSupplyApply == null) {
			Session session = null;

			try {
				session = openSession();

				officeSupplyApply = (OfficeSupplyApply)session.get(OfficeSupplyApplyImpl.class,
						primaryKey);

				if (officeSupplyApply != null) {
					cacheResult(officeSupplyApply);
				}
				else {
					EntityCacheUtil.putResult(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
						OfficeSupplyApplyImpl.class, primaryKey,
						_nullOfficeSupplyApply);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OfficeSupplyApplyModelImpl.ENTITY_CACHE_ENABLED,
					OfficeSupplyApplyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return officeSupplyApply;
	}

	/**
	 * Returns the office supply apply with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeSupplyApplyId the primary key of the office supply apply
	 * @return the office supply apply, or <code>null</code> if a office supply apply with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyApply fetchByPrimaryKey(long officeSupplyApplyId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)officeSupplyApplyId);
	}

	/**
	 * Returns all the office supply applies.
	 *
	 * @return the office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the office supply applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply applies
	 * @param end the upper bound of the range of office supply applies (not inclusive)
	 * @return the range of office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the office supply applies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyApplyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply applies
	 * @param end the upper bound of the range of office supply applies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of office supply applies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyApply> findAll(int start, int end,
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

		List<OfficeSupplyApply> list = (List<OfficeSupplyApply>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OFFICESUPPLYAPPLY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICESUPPLYAPPLY;

				if (pagination) {
					sql = sql.concat(OfficeSupplyApplyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OfficeSupplyApply>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OfficeSupplyApply>(list);
				}
				else {
					list = (List<OfficeSupplyApply>)QueryUtil.list(q,
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
	 * Removes all the office supply applies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OfficeSupplyApply officeSupplyApply : findAll()) {
			remove(officeSupplyApply);
		}
	}

	/**
	 * Returns the number of office supply applies.
	 *
	 * @return the number of office supply applies
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

				Query q = session.createQuery(_SQL_COUNT_OFFICESUPPLYAPPLY);

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
	 * Initializes the office supply apply persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.oa.model.OfficeSupplyApply")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OfficeSupplyApply>> listenersList = new ArrayList<ModelListener<OfficeSupplyApply>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OfficeSupplyApply>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OfficeSupplyApplyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OFFICESUPPLYAPPLY = "SELECT officeSupplyApply FROM OfficeSupplyApply officeSupplyApply";
	private static final String _SQL_SELECT_OFFICESUPPLYAPPLY_WHERE = "SELECT officeSupplyApply FROM OfficeSupplyApply officeSupplyApply WHERE ";
	private static final String _SQL_COUNT_OFFICESUPPLYAPPLY = "SELECT COUNT(officeSupplyApply) FROM OfficeSupplyApply officeSupplyApply";
	private static final String _SQL_COUNT_OFFICESUPPLYAPPLY_WHERE = "SELECT COUNT(officeSupplyApply) FROM OfficeSupplyApply officeSupplyApply WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "officeSupplyApply.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OfficeSupplyApply exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OfficeSupplyApply exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OfficeSupplyApplyPersistenceImpl.class);
	private static OfficeSupplyApply _nullOfficeSupplyApply = new OfficeSupplyApplyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OfficeSupplyApply> toCacheModel() {
				return _nullOfficeSupplyApplyCacheModel;
			}
		};

	private static CacheModel<OfficeSupplyApply> _nullOfficeSupplyApplyCacheModel =
		new CacheModel<OfficeSupplyApply>() {
			@Override
			public OfficeSupplyApply toEntityModel() {
				return _nullOfficeSupplyApply;
			}
		};
}