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

package com.justonetech.cp.complete.service.persistence;

import com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException;
import com.justonetech.cp.complete.model.CompleteApplyMaterial;
import com.justonetech.cp.complete.model.impl.CompleteApplyMaterialImpl;
import com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl;

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
 * The persistence implementation for the complete apply material service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see CompleteApplyMaterialPersistence
 * @see CompleteApplyMaterialUtil
 * @generated
 */
public class CompleteApplyMaterialPersistenceImpl extends BasePersistenceImpl<CompleteApplyMaterial>
	implements CompleteApplyMaterialPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompleteApplyMaterialUtil} to access the complete apply material persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompleteApplyMaterialImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			CompleteApplyMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			CompleteApplyMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLETEID =
		new FinderPath(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			CompleteApplyMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompleteId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID =
		new FinderPath(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialModelImpl.FINDER_CACHE_ENABLED,
			CompleteApplyMaterialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompleteId",
			new String[] { Long.class.getName() },
			CompleteApplyMaterialModelImpl.COMPLETEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPLETEID = new FinderPath(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompleteId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the complete apply materials where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @return the matching complete apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteApplyMaterial> findByCompleteId(long completeId)
		throws SystemException {
		return findByCompleteId(completeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complete apply materials where completeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param completeId the complete ID
	 * @param start the lower bound of the range of complete apply materials
	 * @param end the upper bound of the range of complete apply materials (not inclusive)
	 * @return the range of matching complete apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteApplyMaterial> findByCompleteId(long completeId,
		int start, int end) throws SystemException {
		return findByCompleteId(completeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the complete apply materials where completeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param completeId the complete ID
	 * @param start the lower bound of the range of complete apply materials
	 * @param end the upper bound of the range of complete apply materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching complete apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteApplyMaterial> findByCompleteId(long completeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID;
			finderArgs = new Object[] { completeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPLETEID;
			finderArgs = new Object[] { completeId, start, end, orderByComparator };
		}

		List<CompleteApplyMaterial> list = (List<CompleteApplyMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CompleteApplyMaterial completeApplyMaterial : list) {
				if ((completeId != completeApplyMaterial.getCompleteId())) {
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

			query.append(_SQL_SELECT_COMPLETEAPPLYMATERIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPLETEID_COMPLETEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompleteApplyMaterialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(completeId);

				if (!pagination) {
					list = (List<CompleteApplyMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompleteApplyMaterial>(list);
				}
				else {
					list = (List<CompleteApplyMaterial>)QueryUtil.list(q,
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
	 * Returns the first complete apply material in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complete apply material
	 * @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a matching complete apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial findByCompleteId_First(long completeId,
		OrderByComparator orderByComparator)
		throws NoSuchCompleteApplyMaterialException, SystemException {
		CompleteApplyMaterial completeApplyMaterial = fetchByCompleteId_First(completeId,
				orderByComparator);

		if (completeApplyMaterial != null) {
			return completeApplyMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("completeId=");
		msg.append(completeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompleteApplyMaterialException(msg.toString());
	}

	/**
	 * Returns the first complete apply material in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching complete apply material, or <code>null</code> if a matching complete apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial fetchByCompleteId_First(long completeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CompleteApplyMaterial> list = findByCompleteId(completeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last complete apply material in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complete apply material
	 * @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a matching complete apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial findByCompleteId_Last(long completeId,
		OrderByComparator orderByComparator)
		throws NoSuchCompleteApplyMaterialException, SystemException {
		CompleteApplyMaterial completeApplyMaterial = fetchByCompleteId_Last(completeId,
				orderByComparator);

		if (completeApplyMaterial != null) {
			return completeApplyMaterial;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("completeId=");
		msg.append(completeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompleteApplyMaterialException(msg.toString());
	}

	/**
	 * Returns the last complete apply material in the ordered set where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching complete apply material, or <code>null</code> if a matching complete apply material could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial fetchByCompleteId_Last(long completeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompleteId(completeId);

		if (count == 0) {
			return null;
		}

		List<CompleteApplyMaterial> list = findByCompleteId(completeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the complete apply materials before and after the current complete apply material in the ordered set where completeId = &#63;.
	 *
	 * @param materialId the primary key of the current complete apply material
	 * @param completeId the complete ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next complete apply material
	 * @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial[] findByCompleteId_PrevAndNext(
		long materialId, long completeId, OrderByComparator orderByComparator)
		throws NoSuchCompleteApplyMaterialException, SystemException {
		CompleteApplyMaterial completeApplyMaterial = findByPrimaryKey(materialId);

		Session session = null;

		try {
			session = openSession();

			CompleteApplyMaterial[] array = new CompleteApplyMaterialImpl[3];

			array[0] = getByCompleteId_PrevAndNext(session,
					completeApplyMaterial, completeId, orderByComparator, true);

			array[1] = completeApplyMaterial;

			array[2] = getByCompleteId_PrevAndNext(session,
					completeApplyMaterial, completeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CompleteApplyMaterial getByCompleteId_PrevAndNext(
		Session session, CompleteApplyMaterial completeApplyMaterial,
		long completeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPLETEAPPLYMATERIAL_WHERE);

		query.append(_FINDER_COLUMN_COMPLETEID_COMPLETEID_2);

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
			query.append(CompleteApplyMaterialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(completeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(completeApplyMaterial);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CompleteApplyMaterial> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the complete apply materials where completeId = &#63; from the database.
	 *
	 * @param completeId the complete ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompleteId(long completeId) throws SystemException {
		for (CompleteApplyMaterial completeApplyMaterial : findByCompleteId(
				completeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(completeApplyMaterial);
		}
	}

	/**
	 * Returns the number of complete apply materials where completeId = &#63;.
	 *
	 * @param completeId the complete ID
	 * @return the number of matching complete apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompleteId(long completeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPLETEID;

		Object[] finderArgs = new Object[] { completeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPLETEAPPLYMATERIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPLETEID_COMPLETEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(completeId);

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

	private static final String _FINDER_COLUMN_COMPLETEID_COMPLETEID_2 = "completeApplyMaterial.completeId = ?";

	public CompleteApplyMaterialPersistenceImpl() {
		setModelClass(CompleteApplyMaterial.class);
	}

	/**
	 * Caches the complete apply material in the entity cache if it is enabled.
	 *
	 * @param completeApplyMaterial the complete apply material
	 */
	@Override
	public void cacheResult(CompleteApplyMaterial completeApplyMaterial) {
		EntityCacheUtil.putResult(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialImpl.class,
			completeApplyMaterial.getPrimaryKey(), completeApplyMaterial);

		completeApplyMaterial.resetOriginalValues();
	}

	/**
	 * Caches the complete apply materials in the entity cache if it is enabled.
	 *
	 * @param completeApplyMaterials the complete apply materials
	 */
	@Override
	public void cacheResult(List<CompleteApplyMaterial> completeApplyMaterials) {
		for (CompleteApplyMaterial completeApplyMaterial : completeApplyMaterials) {
			if (EntityCacheUtil.getResult(
						CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
						CompleteApplyMaterialImpl.class,
						completeApplyMaterial.getPrimaryKey()) == null) {
				cacheResult(completeApplyMaterial);
			}
			else {
				completeApplyMaterial.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all complete apply materials.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CompleteApplyMaterialImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CompleteApplyMaterialImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the complete apply material.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompleteApplyMaterial completeApplyMaterial) {
		EntityCacheUtil.removeResult(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialImpl.class,
			completeApplyMaterial.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CompleteApplyMaterial> completeApplyMaterials) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CompleteApplyMaterial completeApplyMaterial : completeApplyMaterials) {
			EntityCacheUtil.removeResult(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
				CompleteApplyMaterialImpl.class,
				completeApplyMaterial.getPrimaryKey());
		}
	}

	/**
	 * Creates a new complete apply material with the primary key. Does not add the complete apply material to the database.
	 *
	 * @param materialId the primary key for the new complete apply material
	 * @return the new complete apply material
	 */
	@Override
	public CompleteApplyMaterial create(long materialId) {
		CompleteApplyMaterial completeApplyMaterial = new CompleteApplyMaterialImpl();

		completeApplyMaterial.setNew(true);
		completeApplyMaterial.setPrimaryKey(materialId);

		return completeApplyMaterial;
	}

	/**
	 * Removes the complete apply material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param materialId the primary key of the complete apply material
	 * @return the complete apply material that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial remove(long materialId)
		throws NoSuchCompleteApplyMaterialException, SystemException {
		return remove((Serializable)materialId);
	}

	/**
	 * Removes the complete apply material with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the complete apply material
	 * @return the complete apply material that was removed
	 * @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial remove(Serializable primaryKey)
		throws NoSuchCompleteApplyMaterialException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CompleteApplyMaterial completeApplyMaterial = (CompleteApplyMaterial)session.get(CompleteApplyMaterialImpl.class,
					primaryKey);

			if (completeApplyMaterial == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompleteApplyMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(completeApplyMaterial);
		}
		catch (NoSuchCompleteApplyMaterialException nsee) {
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
	protected CompleteApplyMaterial removeImpl(
		CompleteApplyMaterial completeApplyMaterial) throws SystemException {
		completeApplyMaterial = toUnwrappedModel(completeApplyMaterial);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(completeApplyMaterial)) {
				completeApplyMaterial = (CompleteApplyMaterial)session.get(CompleteApplyMaterialImpl.class,
						completeApplyMaterial.getPrimaryKeyObj());
			}

			if (completeApplyMaterial != null) {
				session.delete(completeApplyMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (completeApplyMaterial != null) {
			clearCache(completeApplyMaterial);
		}

		return completeApplyMaterial;
	}

	@Override
	public CompleteApplyMaterial updateImpl(
		com.justonetech.cp.complete.model.CompleteApplyMaterial completeApplyMaterial)
		throws SystemException {
		completeApplyMaterial = toUnwrappedModel(completeApplyMaterial);

		boolean isNew = completeApplyMaterial.isNew();

		CompleteApplyMaterialModelImpl completeApplyMaterialModelImpl = (CompleteApplyMaterialModelImpl)completeApplyMaterial;

		Session session = null;

		try {
			session = openSession();

			if (completeApplyMaterial.isNew()) {
				session.save(completeApplyMaterial);

				completeApplyMaterial.setNew(false);
			}
			else {
				session.merge(completeApplyMaterial);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CompleteApplyMaterialModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((completeApplyMaterialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						completeApplyMaterialModelImpl.getOriginalCompleteId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLETEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID,
					args);

				args = new Object[] {
						completeApplyMaterialModelImpl.getCompleteId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPLETEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPLETEID,
					args);
			}
		}

		EntityCacheUtil.putResult(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
			CompleteApplyMaterialImpl.class,
			completeApplyMaterial.getPrimaryKey(), completeApplyMaterial);

		return completeApplyMaterial;
	}

	protected CompleteApplyMaterial toUnwrappedModel(
		CompleteApplyMaterial completeApplyMaterial) {
		if (completeApplyMaterial instanceof CompleteApplyMaterialImpl) {
			return completeApplyMaterial;
		}

		CompleteApplyMaterialImpl completeApplyMaterialImpl = new CompleteApplyMaterialImpl();

		completeApplyMaterialImpl.setNew(completeApplyMaterial.isNew());
		completeApplyMaterialImpl.setPrimaryKey(completeApplyMaterial.getPrimaryKey());

		completeApplyMaterialImpl.setMaterialId(completeApplyMaterial.getMaterialId());
		completeApplyMaterialImpl.setCompleteId(completeApplyMaterial.getCompleteId());
		completeApplyMaterialImpl.setXh(completeApplyMaterial.getXh());
		completeApplyMaterialImpl.setClmc(completeApplyMaterial.getClmc());
		completeApplyMaterialImpl.setFileEntryIds(completeApplyMaterial.getFileEntryIds());

		return completeApplyMaterialImpl;
	}

	/**
	 * Returns the complete apply material with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete apply material
	 * @return the complete apply material
	 * @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompleteApplyMaterialException, SystemException {
		CompleteApplyMaterial completeApplyMaterial = fetchByPrimaryKey(primaryKey);

		if (completeApplyMaterial == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompleteApplyMaterialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return completeApplyMaterial;
	}

	/**
	 * Returns the complete apply material with the primary key or throws a {@link com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException} if it could not be found.
	 *
	 * @param materialId the primary key of the complete apply material
	 * @return the complete apply material
	 * @throws com.justonetech.cp.complete.NoSuchCompleteApplyMaterialException if a complete apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial findByPrimaryKey(long materialId)
		throws NoSuchCompleteApplyMaterialException, SystemException {
		return findByPrimaryKey((Serializable)materialId);
	}

	/**
	 * Returns the complete apply material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the complete apply material
	 * @return the complete apply material, or <code>null</code> if a complete apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CompleteApplyMaterial completeApplyMaterial = (CompleteApplyMaterial)EntityCacheUtil.getResult(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
				CompleteApplyMaterialImpl.class, primaryKey);

		if (completeApplyMaterial == _nullCompleteApplyMaterial) {
			return null;
		}

		if (completeApplyMaterial == null) {
			Session session = null;

			try {
				session = openSession();

				completeApplyMaterial = (CompleteApplyMaterial)session.get(CompleteApplyMaterialImpl.class,
						primaryKey);

				if (completeApplyMaterial != null) {
					cacheResult(completeApplyMaterial);
				}
				else {
					EntityCacheUtil.putResult(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
						CompleteApplyMaterialImpl.class, primaryKey,
						_nullCompleteApplyMaterial);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CompleteApplyMaterialModelImpl.ENTITY_CACHE_ENABLED,
					CompleteApplyMaterialImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return completeApplyMaterial;
	}

	/**
	 * Returns the complete apply material with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param materialId the primary key of the complete apply material
	 * @return the complete apply material, or <code>null</code> if a complete apply material with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompleteApplyMaterial fetchByPrimaryKey(long materialId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)materialId);
	}

	/**
	 * Returns all the complete apply materials.
	 *
	 * @return the complete apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteApplyMaterial> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the complete apply materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of complete apply materials
	 * @param end the upper bound of the range of complete apply materials (not inclusive)
	 * @return the range of complete apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteApplyMaterial> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the complete apply materials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.complete.model.impl.CompleteApplyMaterialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of complete apply materials
	 * @param end the upper bound of the range of complete apply materials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of complete apply materials
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompleteApplyMaterial> findAll(int start, int end,
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

		List<CompleteApplyMaterial> list = (List<CompleteApplyMaterial>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPLETEAPPLYMATERIAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPLETEAPPLYMATERIAL;

				if (pagination) {
					sql = sql.concat(CompleteApplyMaterialModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CompleteApplyMaterial>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompleteApplyMaterial>(list);
				}
				else {
					list = (List<CompleteApplyMaterial>)QueryUtil.list(q,
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
	 * Removes all the complete apply materials from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CompleteApplyMaterial completeApplyMaterial : findAll()) {
			remove(completeApplyMaterial);
		}
	}

	/**
	 * Returns the number of complete apply materials.
	 *
	 * @return the number of complete apply materials
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

				Query q = session.createQuery(_SQL_COUNT_COMPLETEAPPLYMATERIAL);

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
	 * Initializes the complete apply material persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.complete.model.CompleteApplyMaterial")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CompleteApplyMaterial>> listenersList = new ArrayList<ModelListener<CompleteApplyMaterial>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CompleteApplyMaterial>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CompleteApplyMaterialImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMPLETEAPPLYMATERIAL = "SELECT completeApplyMaterial FROM CompleteApplyMaterial completeApplyMaterial";
	private static final String _SQL_SELECT_COMPLETEAPPLYMATERIAL_WHERE = "SELECT completeApplyMaterial FROM CompleteApplyMaterial completeApplyMaterial WHERE ";
	private static final String _SQL_COUNT_COMPLETEAPPLYMATERIAL = "SELECT COUNT(completeApplyMaterial) FROM CompleteApplyMaterial completeApplyMaterial";
	private static final String _SQL_COUNT_COMPLETEAPPLYMATERIAL_WHERE = "SELECT COUNT(completeApplyMaterial) FROM CompleteApplyMaterial completeApplyMaterial WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "completeApplyMaterial.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CompleteApplyMaterial exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CompleteApplyMaterial exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CompleteApplyMaterialPersistenceImpl.class);
	private static CompleteApplyMaterial _nullCompleteApplyMaterial = new CompleteApplyMaterialImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CompleteApplyMaterial> toCacheModel() {
				return _nullCompleteApplyMaterialCacheModel;
			}
		};

	private static CacheModel<CompleteApplyMaterial> _nullCompleteApplyMaterialCacheModel =
		new CacheModel<CompleteApplyMaterial>() {
			@Override
			public CompleteApplyMaterial toEntityModel() {
				return _nullCompleteApplyMaterial;
			}
		};
}