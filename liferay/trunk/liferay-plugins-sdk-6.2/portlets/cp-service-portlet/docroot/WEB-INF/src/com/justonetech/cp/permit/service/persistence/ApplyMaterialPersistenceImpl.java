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

package com.justonetech.cp.permit.service.persistence;

import com.justonetech.cp.permit.NoSuchApplyMaterialException;
import com.justonetech.cp.permit.model.ApplyMaterial;
import com.justonetech.cp.permit.model.impl.ApplyMaterialImpl;
import com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl;

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
 * The persistence implementation for the apply material service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ApplyMaterialPersistence
 * @see ApplyMaterialUtil
 * @generated
 */
public class ApplyMaterialPersistenceImpl extends BasePersistenceImpl<ApplyMaterial>
	implements ApplyMaterialPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplyMaterialUtil} to access the apply material persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplyMaterialImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			ApplyMaterialImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			ApplyMaterialImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMITID = new FinderPath(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			ApplyMaterialImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPermitId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID =
		new FinderPath(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			ApplyMaterialImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPermitId", new String[] { Long.class.getName() },
			ApplyMaterialModelImpl.PERMITID_COLUMN_BITMASK |
			ApplyMaterialModelImpl.XH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERMITID = new FinderPath(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPermitId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the apply materials where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @return the matching apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApplyMaterial> findByPermitId(long permitId)
		throws SystemException {
		return findByPermitId(permitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the apply materials where permitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param permitId the permit ID
	 * @param start the lower bound of the range of apply materials
	 * @param end the upper bound of the range of apply materials (not inclusive)
	 * @return the range of matching apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApplyMaterial> findByPermitId(long permitId, int start, int end)
		throws SystemException {
		return findByPermitId(permitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the apply materials where permitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param permitId the permit ID
	 * @param start the lower bound of the range of apply materials
	 * @param end the upper bound of the range of apply materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApplyMaterial> findByPermitId(long permitId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID;
			finderArgs = new Object[] { permitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERMITID;
			finderArgs = new Object[] { permitId, start, end, orderByComparator };
		}

		List<ApplyMaterial> list = (List<ApplyMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ApplyMaterial applyMaterial : list) {
				if ((permitId != applyMaterial.getPermitId())) {
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

			query.append(_SQL_SELECT_APPLYMATERIAL_WHERE);

			query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplyMaterialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permitId);

				if (!pagination) {
					list = (List<ApplyMaterial>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApplyMaterial>(list);
				}
				else {
					list = (List<ApplyMaterial>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first apply material in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apply material
	 * @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a matching apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial findByPermitId_First(long permitId,
		OrderByComparator orderByComparator)
		throws NoSuchApplyMaterialException, SystemException {
		ApplyMaterial applyMaterial = fetchByPermitId_First(permitId,
				orderByComparator);

		if (applyMaterial != null) {
			return applyMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permitId=");
		msg.append(permitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplyMaterialException(msg.toString());
	}

	/**
	 * Returns the first apply material in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching apply material, or <code>null</code> if a matching apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial fetchByPermitId_First(long permitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ApplyMaterial> list = findByPermitId(permitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last apply material in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apply material
	 * @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a matching apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial findByPermitId_Last(long permitId,
		OrderByComparator orderByComparator)
		throws NoSuchApplyMaterialException, SystemException {
		ApplyMaterial applyMaterial = fetchByPermitId_Last(permitId,
				orderByComparator);

		if (applyMaterial != null) {
			return applyMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permitId=");
		msg.append(permitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplyMaterialException(msg.toString());
	}

	/**
	 * Returns the last apply material in the ordered set where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching apply material, or <code>null</code> if a matching apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial fetchByPermitId_Last(long permitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPermitId(permitId);

		if (count == 0) {
			return null;
		}

		List<ApplyMaterial> list = findByPermitId(permitId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the apply materials before and after the current apply material in the ordered set where permitId = &#63;.
	 *
	 * @param materialId the primary key of the current apply material
	 * @param permitId the permit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next apply material
	 * @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial[] findByPermitId_PrevAndNext(long materialId,
		long permitId, OrderByComparator orderByComparator)
		throws NoSuchApplyMaterialException, SystemException {
		ApplyMaterial applyMaterial = findByPrimaryKey(materialId);

		Session session = null;

		try {
			session = openSession();

			ApplyMaterial[] array = new ApplyMaterialImpl[3];

			array[0] = getByPermitId_PrevAndNext(session, applyMaterial,
					permitId, orderByComparator, true);

			array[1] = applyMaterial;

			array[2] = getByPermitId_PrevAndNext(session, applyMaterial,
					permitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApplyMaterial getByPermitId_PrevAndNext(Session session,
		ApplyMaterial applyMaterial, long permitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLYMATERIAL_WHERE);

		query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);

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
			query.append(ApplyMaterialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(permitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applyMaterial);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplyMaterial> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the apply materials where permitId = &#63; from the database.
	 *
	 * @param permitId the permit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPermitId(long permitId) throws SystemException {
		for (ApplyMaterial applyMaterial : findByPermitId(permitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(applyMaterial);
		}
	}

	/**
	 * Returns the number of apply materials where permitId = &#63;.
	 *
	 * @param permitId the permit ID
	 * @return the number of matching apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPermitId(long permitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PERMITID;

		Object[] finderArgs = new Object[] { permitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLYMATERIAL_WHERE);

			query.append(_FINDER_COLUMN_PERMITID_PERMITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permitId);

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

	private static final String _FINDER_COLUMN_PERMITID_PERMITID_2 = "applyMaterial.permitId = ?";

	public ApplyMaterialPersistenceImpl() {
		setModelClass(ApplyMaterial.class);
	}

	/**
	 * Caches the apply material in the entity cache if it is enabled.
	 *
	 * @param applyMaterial the apply material
	 */
	@Override
	public void cacheResult(ApplyMaterial applyMaterial) {
		EntityCacheUtil.putResult(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialImpl.class, applyMaterial.getPrimaryKey(),
			applyMaterial);

		applyMaterial.resetOriginalValues();
	}

	/**
	 * Caches the apply materials in the entity cache if it is enabled.
	 *
	 * @param applyMaterials the apply materials
	 */
	@Override
	public void cacheResult(List<ApplyMaterial> applyMaterials) {
		for (ApplyMaterial applyMaterial : applyMaterials) {
			if (EntityCacheUtil.getResult(
						ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
						ApplyMaterialImpl.class, applyMaterial.getPrimaryKey()) == null) {
				cacheResult(applyMaterial);
			}
			else {
				applyMaterial.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all apply materials.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ApplyMaterialImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ApplyMaterialImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the apply material.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplyMaterial applyMaterial) {
		EntityCacheUtil.removeResult(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialImpl.class, applyMaterial.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ApplyMaterial> applyMaterials) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApplyMaterial applyMaterial : applyMaterials) {
			EntityCacheUtil.removeResult(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
				ApplyMaterialImpl.class, applyMaterial.getPrimaryKey());
		}
	}

	/**
	 * Creates a new apply material with the primary key. Does not add the apply material to the database.
	 *
	 * @param materialId the primary key for the new apply material
	 * @return the new apply material
	 */
	@Override
	public ApplyMaterial create(long materialId) {
		ApplyMaterial applyMaterial = new ApplyMaterialImpl();

		applyMaterial.setNew(true);
		applyMaterial.setPrimaryKey(materialId);

		return applyMaterial;
	}

	/**
	 * Removes the apply material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param materialId the primary key of the apply material
	 * @return the apply material that was removed
	 * @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial remove(long materialId)
		throws NoSuchApplyMaterialException, SystemException {
		return remove((Serializable)materialId);
	}

	/**
	 * Removes the apply material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the apply material
	 * @return the apply material that was removed
	 * @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial remove(Serializable primaryKey)
		throws NoSuchApplyMaterialException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ApplyMaterial applyMaterial = (ApplyMaterial)session.get(ApplyMaterialImpl.class,
					primaryKey);

			if (applyMaterial == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplyMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applyMaterial);
		}
		catch (NoSuchApplyMaterialException nsee) {
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
	protected ApplyMaterial removeImpl(ApplyMaterial applyMaterial)
		throws SystemException {
		applyMaterial = toUnwrappedModel(applyMaterial);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applyMaterial)) {
				applyMaterial = (ApplyMaterial)session.get(ApplyMaterialImpl.class,
						applyMaterial.getPrimaryKeyObj());
			}

			if (applyMaterial != null) {
				session.delete(applyMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applyMaterial != null) {
			clearCache(applyMaterial);
		}

		return applyMaterial;
	}

	@Override
	public ApplyMaterial updateImpl(
		com.justonetech.cp.permit.model.ApplyMaterial applyMaterial)
		throws SystemException {
		applyMaterial = toUnwrappedModel(applyMaterial);

		boolean isNew = applyMaterial.isNew();

		ApplyMaterialModelImpl applyMaterialModelImpl = (ApplyMaterialModelImpl)applyMaterial;

		Session session = null;

		try {
			session = openSession();

			if (applyMaterial.isNew()) {
				session.save(applyMaterial);

				applyMaterial.setNew(false);
			}
			else {
				session.merge(applyMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApplyMaterialModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((applyMaterialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applyMaterialModelImpl.getOriginalPermitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMITID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID,
					args);

				args = new Object[] { applyMaterialModelImpl.getPermitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERMITID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERMITID,
					args);
			}
		}

		EntityCacheUtil.putResult(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			ApplyMaterialImpl.class, applyMaterial.getPrimaryKey(),
			applyMaterial);

		return applyMaterial;
	}

	protected ApplyMaterial toUnwrappedModel(ApplyMaterial applyMaterial) {
		if (applyMaterial instanceof ApplyMaterialImpl) {
			return applyMaterial;
		}

		ApplyMaterialImpl applyMaterialImpl = new ApplyMaterialImpl();

		applyMaterialImpl.setNew(applyMaterial.isNew());
		applyMaterialImpl.setPrimaryKey(applyMaterial.getPrimaryKey());

		applyMaterialImpl.setMaterialId(applyMaterial.getMaterialId());
		applyMaterialImpl.setPermitId(applyMaterial.getPermitId());
		applyMaterialImpl.setXh(applyMaterial.getXh());
		applyMaterialImpl.setClmc(applyMaterial.getClmc());
		applyMaterialImpl.setYjfs(applyMaterial.getYjfs());
		applyMaterialImpl.setSjfs(applyMaterial.getSjfs());
		applyMaterialImpl.setFileEntryIds(applyMaterial.getFileEntryIds());

		return applyMaterialImpl;
	}

	/**
	 * Returns the apply material with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the apply material
	 * @return the apply material
	 * @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplyMaterialException, SystemException {
		ApplyMaterial applyMaterial = fetchByPrimaryKey(primaryKey);

		if (applyMaterial == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplyMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applyMaterial;
	}

	/**
	 * Returns the apply material with the primary key or throws a {@link com.justonetech.cp.permit.NoSuchApplyMaterialException} if it could not be found.
	 *
	 * @param materialId the primary key of the apply material
	 * @return the apply material
	 * @throws com.justonetech.cp.permit.NoSuchApplyMaterialException if a apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial findByPrimaryKey(long materialId)
		throws NoSuchApplyMaterialException, SystemException {
		return findByPrimaryKey((Serializable)materialId);
	}

	/**
	 * Returns the apply material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the apply material
	 * @return the apply material, or <code>null</code> if a apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ApplyMaterial applyMaterial = (ApplyMaterial)EntityCacheUtil.getResult(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
				ApplyMaterialImpl.class, primaryKey);

		if (applyMaterial == _nullApplyMaterial) {
			return null;
		}

		if (applyMaterial == null) {
			Session session = null;

			try {
				session = openSession();

				applyMaterial = (ApplyMaterial)session.get(ApplyMaterialImpl.class,
						primaryKey);

				if (applyMaterial != null) {
					cacheResult(applyMaterial);
				}
				else {
					EntityCacheUtil.putResult(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
						ApplyMaterialImpl.class, primaryKey, _nullApplyMaterial);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
					ApplyMaterialImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applyMaterial;
	}

	/**
	 * Returns the apply material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param materialId the primary key of the apply material
	 * @return the apply material, or <code>null</code> if a apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ApplyMaterial fetchByPrimaryKey(long materialId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)materialId);
	}

	/**
	 * Returns all the apply materials.
	 *
	 * @return the apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApplyMaterial> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the apply materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of apply materials
	 * @param end the upper bound of the range of apply materials (not inclusive)
	 * @return the range of apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApplyMaterial> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the apply materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.permit.model.impl.ApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of apply materials
	 * @param end the upper bound of the range of apply materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ApplyMaterial> findAll(int start, int end,
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

		List<ApplyMaterial> list = (List<ApplyMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_APPLYMATERIAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLYMATERIAL;

				if (pagination) {
					sql = sql.concat(ApplyMaterialModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApplyMaterial>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ApplyMaterial>(list);
				}
				else {
					list = (List<ApplyMaterial>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the apply materials from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ApplyMaterial applyMaterial : findAll()) {
			remove(applyMaterial);
		}
	}

	/**
	 * Returns the number of apply materials.
	 *
	 * @return the number of apply materials
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

				Query q = session.createQuery(_SQL_COUNT_APPLYMATERIAL);

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
	 * Initializes the apply material persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.permit.model.ApplyMaterial")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ApplyMaterial>> listenersList = new ArrayList<ModelListener<ApplyMaterial>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ApplyMaterial>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ApplyMaterialImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_APPLYMATERIAL = "SELECT applyMaterial FROM ApplyMaterial applyMaterial";
	private static final String _SQL_SELECT_APPLYMATERIAL_WHERE = "SELECT applyMaterial FROM ApplyMaterial applyMaterial WHERE ";
	private static final String _SQL_COUNT_APPLYMATERIAL = "SELECT COUNT(applyMaterial) FROM ApplyMaterial applyMaterial";
	private static final String _SQL_COUNT_APPLYMATERIAL_WHERE = "SELECT COUNT(applyMaterial) FROM ApplyMaterial applyMaterial WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applyMaterial.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplyMaterial exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplyMaterial exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ApplyMaterialPersistenceImpl.class);
	private static ApplyMaterial _nullApplyMaterial = new ApplyMaterialImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApplyMaterial> toCacheModel() {
				return _nullApplyMaterialCacheModel;
			}
		};

	private static CacheModel<ApplyMaterial> _nullApplyMaterialCacheModel = new CacheModel<ApplyMaterial>() {
			@Override
			public ApplyMaterial toEntityModel() {
				return _nullApplyMaterial;
			}
		};
}