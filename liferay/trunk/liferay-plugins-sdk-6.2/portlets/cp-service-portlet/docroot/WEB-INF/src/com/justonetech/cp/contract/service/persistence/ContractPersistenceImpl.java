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

package com.justonetech.cp.contract.service.persistence;

import com.justonetech.cp.contract.NoSuchContractException;
import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.model.impl.ContractImpl;
import com.justonetech.cp.contract.model.impl.ContractModelImpl;

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
 * The persistence implementation for the contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see ContractPersistence
 * @see ContractUtil
 * @generated
 */
public class ContractPersistenceImpl extends BasePersistenceImpl<Contract>
	implements ContractPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContractUtil} to access the contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContractImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, ContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ContractPersistenceImpl() {
		setModelClass(Contract.class);
	}

	/**
	 * Caches the contract in the entity cache if it is enabled.
	 *
	 * @param contract the contract
	 */
	@Override
	public void cacheResult(Contract contract) {
		EntityCacheUtil.putResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractImpl.class, contract.getPrimaryKey(), contract);

		contract.resetOriginalValues();
	}

	/**
	 * Caches the contracts in the entity cache if it is enabled.
	 *
	 * @param contracts the contracts
	 */
	@Override
	public void cacheResult(List<Contract> contracts) {
		for (Contract contract : contracts) {
			if (EntityCacheUtil.getResult(
						ContractModelImpl.ENTITY_CACHE_ENABLED,
						ContractImpl.class, contract.getPrimaryKey()) == null) {
				cacheResult(contract);
			}
			else {
				contract.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contracts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContractImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContractImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contract.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Contract contract) {
		EntityCacheUtil.removeResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractImpl.class, contract.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Contract> contracts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Contract contract : contracts) {
			EntityCacheUtil.removeResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
				ContractImpl.class, contract.getPrimaryKey());
		}
	}

	/**
	 * Creates a new contract with the primary key. Does not add the contract to the database.
	 *
	 * @param contractId the primary key for the new contract
	 * @return the new contract
	 */
	@Override
	public Contract create(String contractId) {
		Contract contract = new ContractImpl();

		contract.setNew(true);
		contract.setPrimaryKey(contractId);

		return contract;
	}

	/**
	 * Removes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contractId the primary key of the contract
	 * @return the contract that was removed
	 * @throws com.justonetech.cp.contract.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract remove(String contractId)
		throws NoSuchContractException, SystemException {
		return remove((Serializable)contractId);
	}

	/**
	 * Removes the contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contract
	 * @return the contract that was removed
	 * @throws com.justonetech.cp.contract.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract remove(Serializable primaryKey)
		throws NoSuchContractException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Contract contract = (Contract)session.get(ContractImpl.class,
					primaryKey);

			if (contract == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contract);
		}
		catch (NoSuchContractException nsee) {
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
	protected Contract removeImpl(Contract contract) throws SystemException {
		contract = toUnwrappedModel(contract);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contract)) {
				contract = (Contract)session.get(ContractImpl.class,
						contract.getPrimaryKeyObj());
			}

			if (contract != null) {
				session.delete(contract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (contract != null) {
			clearCache(contract);
		}

		return contract;
	}

	@Override
	public Contract updateImpl(
		com.justonetech.cp.contract.model.Contract contract)
		throws SystemException {
		contract = toUnwrappedModel(contract);

		boolean isNew = contract.isNew();

		Session session = null;

		try {
			session = openSession();

			if (contract.isNew()) {
				session.save(contract);

				contract.setNew(false);
			}
			else {
				session.merge(contract);
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

		EntityCacheUtil.putResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
			ContractImpl.class, contract.getPrimaryKey(), contract);

		return contract;
	}

	protected Contract toUnwrappedModel(Contract contract) {
		if (contract instanceof ContractImpl) {
			return contract;
		}

		ContractImpl contractImpl = new ContractImpl();

		contractImpl.setNew(contract.isNew());
		contractImpl.setPrimaryKey(contract.getPrimaryKey());

		contractImpl.setContractId(contract.getContractId());
		contractImpl.setHtlb(contract.getHtlb());
		contractImpl.setBjbh(contract.getBjbh());
		contractImpl.setBdh(contract.getBdh());
		contractImpl.setCbfs(contract.getCbfs());
		contractImpl.setHtmc(contract.getHtmc());

		return contractImpl;
	}

	/**
	 * Returns the contract with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contract
	 * @return the contract
	 * @throws com.justonetech.cp.contract.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContractException, SystemException {
		Contract contract = fetchByPrimaryKey(primaryKey);

		if (contract == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return contract;
	}

	/**
	 * Returns the contract with the primary key or throws a {@link com.justonetech.cp.contract.NoSuchContractException} if it could not be found.
	 *
	 * @param contractId the primary key of the contract
	 * @return the contract
	 * @throws com.justonetech.cp.contract.NoSuchContractException if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract findByPrimaryKey(String contractId)
		throws NoSuchContractException, SystemException {
		return findByPrimaryKey((Serializable)contractId);
	}

	/**
	 * Returns the contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contract
	 * @return the contract, or <code>null</code> if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Contract contract = (Contract)EntityCacheUtil.getResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
				ContractImpl.class, primaryKey);

		if (contract == _nullContract) {
			return null;
		}

		if (contract == null) {
			Session session = null;

			try {
				session = openSession();

				contract = (Contract)session.get(ContractImpl.class, primaryKey);

				if (contract != null) {
					cacheResult(contract);
				}
				else {
					EntityCacheUtil.putResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
						ContractImpl.class, primaryKey, _nullContract);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ContractModelImpl.ENTITY_CACHE_ENABLED,
					ContractImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return contract;
	}

	/**
	 * Returns the contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contractId the primary key of the contract
	 * @return the contract, or <code>null</code> if a contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Contract fetchByPrimaryKey(String contractId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)contractId);
	}

	/**
	 * Returns all the contracts.
	 *
	 * @return the contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contracts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.contract.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contracts
	 * @param end the upper bound of the range of contracts (not inclusive)
	 * @return the range of contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contracts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.cp.contract.model.impl.ContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of contracts
	 * @param end the upper bound of the range of contracts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Contract> findAll(int start, int end,
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

		List<Contract> list = (List<Contract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTRACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTRACT;

				if (pagination) {
					sql = sql.concat(ContractModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Contract>(list);
				}
				else {
					list = (List<Contract>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the contracts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Contract contract : findAll()) {
			remove(contract);
		}
	}

	/**
	 * Returns the number of contracts.
	 *
	 * @return the number of contracts
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

				Query q = session.createQuery(_SQL_COUNT_CONTRACT);

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
	 * Initializes the contract persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.justonetech.cp.contract.model.Contract")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Contract>> listenersList = new ArrayList<ModelListener<Contract>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Contract>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContractImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CONTRACT = "SELECT contract FROM Contract contract";
	private static final String _SQL_COUNT_CONTRACT = "SELECT COUNT(contract) FROM Contract contract";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contract.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contract exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContractPersistenceImpl.class);
	private static Contract _nullContract = new ContractImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Contract> toCacheModel() {
				return _nullContractCacheModel;
			}
		};

	private static CacheModel<Contract> _nullContractCacheModel = new CacheModel<Contract>() {
			@Override
			public Contract toEntityModel() {
				return _nullContract;
			}
		};
}