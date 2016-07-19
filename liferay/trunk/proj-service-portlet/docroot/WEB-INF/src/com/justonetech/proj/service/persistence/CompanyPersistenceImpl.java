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

import com.justonetech.proj.NoSuchCompanyException;
import com.justonetech.proj.model.Company;
import com.justonetech.proj.model.impl.CompanyImpl;
import com.justonetech.proj.model.impl.CompanyModelImpl;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompanyPersistence
 * @see CompanyUtil
 * @generated
 */
public class CompanyPersistenceImpl extends BasePersistenceImpl<Company>
	implements CompanyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompanyUtil} to access the company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompanyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, CompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, CompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, CompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID =
		new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, CompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectId",
			new String[] { Long.class.getName() },
			CompanyModelImpl.PROJECTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTID = new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the companies where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findByProjectId(long projectId)
		throws SystemException {
		return findByProjectId(projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the companies where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of companies
	 * @param end the upper bound of the range of companies (not inclusive)
	 * @return the range of matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findByProjectId(long projectId, int start, int end)
		throws SystemException {
		return findByProjectId(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the companies where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of companies
	 * @param end the upper bound of the range of companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findByProjectId(long projectId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] { projectId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTID;
			finderArgs = new Object[] { projectId, start, end, orderByComparator };
		}

		List<Company> list = (List<Company>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Company company : list) {
				if ((projectId != company.getProjectId())) {
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

			query.append(_SQL_SELECT_COMPANY_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

				if (!pagination) {
					list = (List<Company>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Company>(list);
				}
				else {
					list = (List<Company>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first company in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company findByProjectId_First(long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchCompanyException, SystemException {
		Company company = fetchByProjectId_First(projectId, orderByComparator);

		if (company != null) {
			return company;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompanyException(msg.toString());
	}

	/**
	 * Returns the first company in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company, or <code>null</code> if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company fetchByProjectId_First(long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Company> list = findByProjectId(projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company findByProjectId_Last(long projectId,
		OrderByComparator orderByComparator)
		throws NoSuchCompanyException, SystemException {
		Company company = fetchByProjectId_Last(projectId, orderByComparator);

		if (company != null) {
			return company;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("projectId=");
		msg.append(projectId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompanyException(msg.toString());
	}

	/**
	 * Returns the last company in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company, or <code>null</code> if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company fetchByProjectId_Last(long projectId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByProjectId(projectId);

		if (count == 0) {
			return null;
		}

		List<Company> list = findByProjectId(projectId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the companies before and after the current company in the ordered set where projectId = &#63;.
	 *
	 * @param companyId the primary key of the current company
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company[] findByProjectId_PrevAndNext(long companyId,
		long projectId, OrderByComparator orderByComparator)
		throws NoSuchCompanyException, SystemException {
		Company company = findByPrimaryKey(companyId);

		Session session = null;

		try {
			session = openSession();

			Company[] array = new CompanyImpl[3];

			array[0] = getByProjectId_PrevAndNext(session, company, projectId,
					orderByComparator, true);

			array[1] = company;

			array[2] = getByProjectId_PrevAndNext(session, company, projectId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Company getByProjectId_PrevAndNext(Session session,
		Company company, long projectId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPANY_WHERE);

		query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

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
			query.append(CompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(projectId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(company);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Company> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the companies where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByProjectId(long projectId) throws SystemException {
		for (Company company : findByProjectId(projectId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(company);
		}
	}

	/**
	 * Returns the number of companies where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByProjectId(long projectId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTID;

		Object[] finderArgs = new Object[] { projectId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPANY_WHERE);

			query.append(_FINDER_COLUMN_PROJECTID_PROJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(projectId);

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

	private static final String _FINDER_COLUMN_PROJECTID_PROJECTID_2 = "company.projectId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BIDDINGID =
		new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, CompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBiddingId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIDDINGID =
		new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, CompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBiddingId",
			new String[] { Long.class.getName() },
			CompanyModelImpl.BIDDINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIDDINGID = new FinderPath(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBiddingId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the companies where biddingId = &#63;.
	 *
	 * @param biddingId the bidding ID
	 * @return the matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findByBiddingId(long biddingId)
		throws SystemException {
		return findByBiddingId(biddingId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the companies where biddingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biddingId the bidding ID
	 * @param start the lower bound of the range of companies
	 * @param end the upper bound of the range of companies (not inclusive)
	 * @return the range of matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findByBiddingId(long biddingId, int start, int end)
		throws SystemException {
		return findByBiddingId(biddingId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the companies where biddingId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param biddingId the bidding ID
	 * @param start the lower bound of the range of companies
	 * @param end the upper bound of the range of companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findByBiddingId(long biddingId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIDDINGID;
			finderArgs = new Object[] { biddingId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BIDDINGID;
			finderArgs = new Object[] { biddingId, start, end, orderByComparator };
		}

		List<Company> list = (List<Company>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Company company : list) {
				if ((biddingId != company.getBiddingId())) {
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

			query.append(_SQL_SELECT_COMPANY_WHERE);

			query.append(_FINDER_COLUMN_BIDDINGID_BIDDINGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompanyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biddingId);

				if (!pagination) {
					list = (List<Company>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Company>(list);
				}
				else {
					list = (List<Company>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first company in the ordered set where biddingId = &#63;.
	 *
	 * @param biddingId the bidding ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company findByBiddingId_First(long biddingId,
		OrderByComparator orderByComparator)
		throws NoSuchCompanyException, SystemException {
		Company company = fetchByBiddingId_First(biddingId, orderByComparator);

		if (company != null) {
			return company;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biddingId=");
		msg.append(biddingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompanyException(msg.toString());
	}

	/**
	 * Returns the first company in the ordered set where biddingId = &#63;.
	 *
	 * @param biddingId the bidding ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company, or <code>null</code> if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company fetchByBiddingId_First(long biddingId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Company> list = findByBiddingId(biddingId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company in the ordered set where biddingId = &#63;.
	 *
	 * @param biddingId the bidding ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company findByBiddingId_Last(long biddingId,
		OrderByComparator orderByComparator)
		throws NoSuchCompanyException, SystemException {
		Company company = fetchByBiddingId_Last(biddingId, orderByComparator);

		if (company != null) {
			return company;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("biddingId=");
		msg.append(biddingId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompanyException(msg.toString());
	}

	/**
	 * Returns the last company in the ordered set where biddingId = &#63;.
	 *
	 * @param biddingId the bidding ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company, or <code>null</code> if a matching company could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company fetchByBiddingId_Last(long biddingId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBiddingId(biddingId);

		if (count == 0) {
			return null;
		}

		List<Company> list = findByBiddingId(biddingId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the companies before and after the current company in the ordered set where biddingId = &#63;.
	 *
	 * @param companyId the primary key of the current company
	 * @param biddingId the bidding ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company[] findByBiddingId_PrevAndNext(long companyId,
		long biddingId, OrderByComparator orderByComparator)
		throws NoSuchCompanyException, SystemException {
		Company company = findByPrimaryKey(companyId);

		Session session = null;

		try {
			session = openSession();

			Company[] array = new CompanyImpl[3];

			array[0] = getByBiddingId_PrevAndNext(session, company, biddingId,
					orderByComparator, true);

			array[1] = company;

			array[2] = getByBiddingId_PrevAndNext(session, company, biddingId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Company getByBiddingId_PrevAndNext(Session session,
		Company company, long biddingId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPANY_WHERE);

		query.append(_FINDER_COLUMN_BIDDINGID_BIDDINGID_2);

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
			query.append(CompanyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(biddingId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(company);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Company> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the companies where biddingId = &#63; from the database.
	 *
	 * @param biddingId the bidding ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBiddingId(long biddingId) throws SystemException {
		for (Company company : findByBiddingId(biddingId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(company);
		}
	}

	/**
	 * Returns the number of companies where biddingId = &#63;.
	 *
	 * @param biddingId the bidding ID
	 * @return the number of matching companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBiddingId(long biddingId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIDDINGID;

		Object[] finderArgs = new Object[] { biddingId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPANY_WHERE);

			query.append(_FINDER_COLUMN_BIDDINGID_BIDDINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(biddingId);

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

	private static final String _FINDER_COLUMN_BIDDINGID_BIDDINGID_2 = "company.biddingId = ?";

	public CompanyPersistenceImpl() {
		setModelClass(Company.class);
	}

	/**
	 * Caches the company in the entity cache if it is enabled.
	 *
	 * @param company the company
	 */
	@Override
	public void cacheResult(Company company) {
		EntityCacheUtil.putResult(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyImpl.class, company.getPrimaryKey(), company);

		company.resetOriginalValues();
	}

	/**
	 * Caches the companies in the entity cache if it is enabled.
	 *
	 * @param companies the companies
	 */
	@Override
	public void cacheResult(List<Company> companies) {
		for (Company company : companies) {
			if (EntityCacheUtil.getResult(
						CompanyModelImpl.ENTITY_CACHE_ENABLED,
						CompanyImpl.class, company.getPrimaryKey()) == null) {
				cacheResult(company);
			}
			else {
				company.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all companies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CompanyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CompanyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the company.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Company company) {
		EntityCacheUtil.removeResult(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyImpl.class, company.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Company> companies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Company company : companies) {
			EntityCacheUtil.removeResult(CompanyModelImpl.ENTITY_CACHE_ENABLED,
				CompanyImpl.class, company.getPrimaryKey());
		}
	}

	/**
	 * Creates a new company with the primary key. Does not add the company to the database.
	 *
	 * @param companyId the primary key for the new company
	 * @return the new company
	 */
	@Override
	public Company create(long companyId) {
		Company company = new CompanyImpl();

		company.setNew(true);
		company.setPrimaryKey(companyId);

		return company;
	}

	/**
	 * Removes the company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyId the primary key of the company
	 * @return the company that was removed
	 * @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company remove(long companyId)
		throws NoSuchCompanyException, SystemException {
		return remove((Serializable)companyId);
	}

	/**
	 * Removes the company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the company
	 * @return the company that was removed
	 * @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company remove(Serializable primaryKey)
		throws NoSuchCompanyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Company company = (Company)session.get(CompanyImpl.class, primaryKey);

			if (company == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(company);
		}
		catch (NoSuchCompanyException nsee) {
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
	protected Company removeImpl(Company company) throws SystemException {
		company = toUnwrappedModel(company);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(company)) {
				company = (Company)session.get(CompanyImpl.class,
						company.getPrimaryKeyObj());
			}

			if (company != null) {
				session.delete(company);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (company != null) {
			clearCache(company);
		}

		return company;
	}

	@Override
	public Company updateImpl(com.justonetech.proj.model.Company company)
		throws SystemException {
		company = toUnwrappedModel(company);

		boolean isNew = company.isNew();

		CompanyModelImpl companyModelImpl = (CompanyModelImpl)company;

		Session session = null;

		try {
			session = openSession();

			if (company.isNew()) {
				session.save(company);

				company.setNew(false);
			}
			else {
				session.merge(company);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CompanyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((companyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						companyModelImpl.getOriginalProjectId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);

				args = new Object[] { companyModelImpl.getProjectId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTID,
					args);
			}

			if ((companyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIDDINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						companyModelImpl.getOriginalBiddingId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIDDINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIDDINGID,
					args);

				args = new Object[] { companyModelImpl.getBiddingId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIDDINGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BIDDINGID,
					args);
			}
		}

		EntityCacheUtil.putResult(CompanyModelImpl.ENTITY_CACHE_ENABLED,
			CompanyImpl.class, company.getPrimaryKey(), company);

		return company;
	}

	protected Company toUnwrappedModel(Company company) {
		if (company instanceof CompanyImpl) {
			return company;
		}

		CompanyImpl companyImpl = new CompanyImpl();

		companyImpl.setNew(company.isNew());
		companyImpl.setPrimaryKey(company.getPrimaryKey());

		companyImpl.setCompanyId(company.getCompanyId());
		companyImpl.setType(company.getType());
		companyImpl.setUnitName(company.getUnitName());
		companyImpl.setIndepLegal(company.getIndepLegal());
		companyImpl.setIndepLegalTel(company.getIndepLegalTel());
		companyImpl.setIndepLegalFax(company.getIndepLegalFax());
		companyImpl.setIndepLegalPhone(company.getIndepLegalPhone());
		companyImpl.setProjLegal(company.getProjLegal());
		companyImpl.setProjLegalTel(company.getProjLegalTel());
		companyImpl.setProjLegalFax(company.getProjLegalFax());
		companyImpl.setProjLegalPhone(company.getProjLegalPhone());
		companyImpl.setLinkman(company.getLinkman());
		companyImpl.setLinkmanTel(company.getLinkmanTel());
		companyImpl.setLinkmanFax(company.getLinkmanFax());
		companyImpl.setLinkmanPhone(company.getLinkmanPhone());
		companyImpl.setProjectId(company.getProjectId());
		companyImpl.setBiddingId(company.getBiddingId());

		return companyImpl;
	}

	/**
	 * Returns the company with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the company
	 * @return the company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompanyException, SystemException {
		Company company = fetchByPrimaryKey(primaryKey);

		if (company == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return company;
	}

	/**
	 * Returns the company with the primary key or throws a {@link com.justonetech.proj.NoSuchCompanyException} if it could not be found.
	 *
	 * @param companyId the primary key of the company
	 * @return the company
	 * @throws com.justonetech.proj.NoSuchCompanyException if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company findByPrimaryKey(long companyId)
		throws NoSuchCompanyException, SystemException {
		return findByPrimaryKey((Serializable)companyId);
	}

	/**
	 * Returns the company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the company
	 * @return the company, or <code>null</code> if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Company company = (Company)EntityCacheUtil.getResult(CompanyModelImpl.ENTITY_CACHE_ENABLED,
				CompanyImpl.class, primaryKey);

		if (company == _nullCompany) {
			return null;
		}

		if (company == null) {
			Session session = null;

			try {
				session = openSession();

				company = (Company)session.get(CompanyImpl.class, primaryKey);

				if (company != null) {
					cacheResult(company);
				}
				else {
					EntityCacheUtil.putResult(CompanyModelImpl.ENTITY_CACHE_ENABLED,
						CompanyImpl.class, primaryKey, _nullCompany);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CompanyModelImpl.ENTITY_CACHE_ENABLED,
					CompanyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return company;
	}

	/**
	 * Returns the company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyId the primary key of the company
	 * @return the company, or <code>null</code> if a company with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Company fetchByPrimaryKey(long companyId) throws SystemException {
		return fetchByPrimaryKey((Serializable)companyId);
	}

	/**
	 * Returns all the companies.
	 *
	 * @return the companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the companies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of companies
	 * @param end the upper bound of the range of companies (not inclusive)
	 * @return the range of companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the companies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.proj.model.impl.CompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of companies
	 * @param end the upper bound of the range of companies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of companies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Company> findAll(int start, int end,
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

		List<Company> list = (List<Company>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPANY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPANY;

				if (pagination) {
					sql = sql.concat(CompanyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Company>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Company>(list);
				}
				else {
					list = (List<Company>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the companies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Company company : findAll()) {
			remove(company);
		}
	}

	/**
	 * Returns the number of companies.
	 *
	 * @return the number of companies
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

				Query q = session.createQuery(_SQL_COUNT_COMPANY);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the company persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.proj.model.Company")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Company>> listenersList = new ArrayList<ModelListener<Company>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Company>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CompanyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMPANY = "SELECT company FROM Company company";
	private static final String _SQL_SELECT_COMPANY_WHERE = "SELECT company FROM Company company WHERE ";
	private static final String _SQL_COUNT_COMPANY = "SELECT COUNT(company) FROM Company company";
	private static final String _SQL_COUNT_COMPANY_WHERE = "SELECT COUNT(company) FROM Company company WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "company.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Company exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Company exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CompanyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static Company _nullCompany = new CompanyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Company> toCacheModel() {
				return _nullCompanyCacheModel;
			}
		};

	private static CacheModel<Company> _nullCompanyCacheModel = new CacheModel<Company>() {
			@Override
			public Company toEntityModel() {
				return _nullCompany;
			}
		};
}