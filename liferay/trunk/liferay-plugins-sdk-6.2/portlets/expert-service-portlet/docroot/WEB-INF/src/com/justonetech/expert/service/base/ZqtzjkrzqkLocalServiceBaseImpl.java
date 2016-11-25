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

package com.justonetech.expert.service.base;

import com.justonetech.expert.model.Zqtzjkrzqk;
import com.justonetech.expert.service.ZqtzjkrzqkLocalService;
import com.justonetech.expert.service.persistence.ExpertPersistence;
import com.justonetech.expert.service.persistence.GzjlPersistence;
import com.justonetech.expert.service.persistence.XlxxPersistence;
import com.justonetech.expert.service.persistence.ZqtzjkrzqkPersistence;
import com.justonetech.expert.service.persistence.ZysqlbPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the zqtzjkrzqk local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.justonetech.expert.service.impl.ZqtzjkrzqkLocalServiceImpl}.
 * </p>
 *
 * @author fanqi
 * @see com.justonetech.expert.service.impl.ZqtzjkrzqkLocalServiceImpl
 * @see com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil
 * @generated
 */
public abstract class ZqtzjkrzqkLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ZqtzjkrzqkLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil} to access the zqtzjkrzqk local service.
	 */

	/**
	 * Adds the zqtzjkrzqk to the database. Also notifies the appropriate model listeners.
	 *
	 * @param zqtzjkrzqk the zqtzjkrzqk
	 * @return the zqtzjkrzqk that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Zqtzjkrzqk addZqtzjkrzqk(Zqtzjkrzqk zqtzjkrzqk)
		throws SystemException {
		zqtzjkrzqk.setNew(true);

		return zqtzjkrzqkPersistence.update(zqtzjkrzqk);
	}

	/**
	 * Creates a new zqtzjkrzqk with the primary key. Does not add the zqtzjkrzqk to the database.
	 *
	 * @param zqtzjkrzqkId the primary key for the new zqtzjkrzqk
	 * @return the new zqtzjkrzqk
	 */
	@Override
	public Zqtzjkrzqk createZqtzjkrzqk(long zqtzjkrzqkId) {
		return zqtzjkrzqkPersistence.create(zqtzjkrzqkId);
	}

	/**
	 * Deletes the zqtzjkrzqk with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk that was removed
	 * @throws PortalException if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Zqtzjkrzqk deleteZqtzjkrzqk(long zqtzjkrzqkId)
		throws PortalException, SystemException {
		return zqtzjkrzqkPersistence.remove(zqtzjkrzqkId);
	}

	/**
	 * Deletes the zqtzjkrzqk from the database. Also notifies the appropriate model listeners.
	 *
	 * @param zqtzjkrzqk the zqtzjkrzqk
	 * @return the zqtzjkrzqk that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Zqtzjkrzqk deleteZqtzjkrzqk(Zqtzjkrzqk zqtzjkrzqk)
		throws SystemException {
		return zqtzjkrzqkPersistence.remove(zqtzjkrzqk);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Zqtzjkrzqk.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return zqtzjkrzqkPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return zqtzjkrzqkPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return zqtzjkrzqkPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return zqtzjkrzqkPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return zqtzjkrzqkPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Zqtzjkrzqk fetchZqtzjkrzqk(long zqtzjkrzqkId)
		throws SystemException {
		return zqtzjkrzqkPersistence.fetchByPrimaryKey(zqtzjkrzqkId);
	}

	/**
	 * Returns the zqtzjkrzqk with the primary key.
	 *
	 * @param zqtzjkrzqkId the primary key of the zqtzjkrzqk
	 * @return the zqtzjkrzqk
	 * @throws PortalException if a zqtzjkrzqk with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Zqtzjkrzqk getZqtzjkrzqk(long zqtzjkrzqkId)
		throws PortalException, SystemException {
		return zqtzjkrzqkPersistence.findByPrimaryKey(zqtzjkrzqkId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return zqtzjkrzqkPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the zqtzjkrzqks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.expert.model.impl.ZqtzjkrzqkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of zqtzjkrzqks
	 * @param end the upper bound of the range of zqtzjkrzqks (not inclusive)
	 * @return the range of zqtzjkrzqks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Zqtzjkrzqk> getZqtzjkrzqks(int start, int end)
		throws SystemException {
		return zqtzjkrzqkPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of zqtzjkrzqks.
	 *
	 * @return the number of zqtzjkrzqks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getZqtzjkrzqksCount() throws SystemException {
		return zqtzjkrzqkPersistence.countAll();
	}

	/**
	 * Updates the zqtzjkrzqk in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param zqtzjkrzqk the zqtzjkrzqk
	 * @return the zqtzjkrzqk that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Zqtzjkrzqk updateZqtzjkrzqk(Zqtzjkrzqk zqtzjkrzqk)
		throws SystemException {
		return zqtzjkrzqkPersistence.update(zqtzjkrzqk);
	}

	/**
	 * Returns the expert local service.
	 *
	 * @return the expert local service
	 */
	public com.justonetech.expert.service.ExpertLocalService getExpertLocalService() {
		return expertLocalService;
	}

	/**
	 * Sets the expert local service.
	 *
	 * @param expertLocalService the expert local service
	 */
	public void setExpertLocalService(
		com.justonetech.expert.service.ExpertLocalService expertLocalService) {
		this.expertLocalService = expertLocalService;
	}

	/**
	 * Returns the expert persistence.
	 *
	 * @return the expert persistence
	 */
	public ExpertPersistence getExpertPersistence() {
		return expertPersistence;
	}

	/**
	 * Sets the expert persistence.
	 *
	 * @param expertPersistence the expert persistence
	 */
	public void setExpertPersistence(ExpertPersistence expertPersistence) {
		this.expertPersistence = expertPersistence;
	}

	/**
	 * Returns the gzjl local service.
	 *
	 * @return the gzjl local service
	 */
	public com.justonetech.expert.service.GzjlLocalService getGzjlLocalService() {
		return gzjlLocalService;
	}

	/**
	 * Sets the gzjl local service.
	 *
	 * @param gzjlLocalService the gzjl local service
	 */
	public void setGzjlLocalService(
		com.justonetech.expert.service.GzjlLocalService gzjlLocalService) {
		this.gzjlLocalService = gzjlLocalService;
	}

	/**
	 * Returns the gzjl persistence.
	 *
	 * @return the gzjl persistence
	 */
	public GzjlPersistence getGzjlPersistence() {
		return gzjlPersistence;
	}

	/**
	 * Sets the gzjl persistence.
	 *
	 * @param gzjlPersistence the gzjl persistence
	 */
	public void setGzjlPersistence(GzjlPersistence gzjlPersistence) {
		this.gzjlPersistence = gzjlPersistence;
	}

	/**
	 * Returns the xlxx local service.
	 *
	 * @return the xlxx local service
	 */
	public com.justonetech.expert.service.XlxxLocalService getXlxxLocalService() {
		return xlxxLocalService;
	}

	/**
	 * Sets the xlxx local service.
	 *
	 * @param xlxxLocalService the xlxx local service
	 */
	public void setXlxxLocalService(
		com.justonetech.expert.service.XlxxLocalService xlxxLocalService) {
		this.xlxxLocalService = xlxxLocalService;
	}

	/**
	 * Returns the xlxx persistence.
	 *
	 * @return the xlxx persistence
	 */
	public XlxxPersistence getXlxxPersistence() {
		return xlxxPersistence;
	}

	/**
	 * Sets the xlxx persistence.
	 *
	 * @param xlxxPersistence the xlxx persistence
	 */
	public void setXlxxPersistence(XlxxPersistence xlxxPersistence) {
		this.xlxxPersistence = xlxxPersistence;
	}

	/**
	 * Returns the zqtzjkrzqk local service.
	 *
	 * @return the zqtzjkrzqk local service
	 */
	public com.justonetech.expert.service.ZqtzjkrzqkLocalService getZqtzjkrzqkLocalService() {
		return zqtzjkrzqkLocalService;
	}

	/**
	 * Sets the zqtzjkrzqk local service.
	 *
	 * @param zqtzjkrzqkLocalService the zqtzjkrzqk local service
	 */
	public void setZqtzjkrzqkLocalService(
		com.justonetech.expert.service.ZqtzjkrzqkLocalService zqtzjkrzqkLocalService) {
		this.zqtzjkrzqkLocalService = zqtzjkrzqkLocalService;
	}

	/**
	 * Returns the zqtzjkrzqk persistence.
	 *
	 * @return the zqtzjkrzqk persistence
	 */
	public ZqtzjkrzqkPersistence getZqtzjkrzqkPersistence() {
		return zqtzjkrzqkPersistence;
	}

	/**
	 * Sets the zqtzjkrzqk persistence.
	 *
	 * @param zqtzjkrzqkPersistence the zqtzjkrzqk persistence
	 */
	public void setZqtzjkrzqkPersistence(
		ZqtzjkrzqkPersistence zqtzjkrzqkPersistence) {
		this.zqtzjkrzqkPersistence = zqtzjkrzqkPersistence;
	}

	/**
	 * Returns the zysqlb local service.
	 *
	 * @return the zysqlb local service
	 */
	public com.justonetech.expert.service.ZysqlbLocalService getZysqlbLocalService() {
		return zysqlbLocalService;
	}

	/**
	 * Sets the zysqlb local service.
	 *
	 * @param zysqlbLocalService the zysqlb local service
	 */
	public void setZysqlbLocalService(
		com.justonetech.expert.service.ZysqlbLocalService zysqlbLocalService) {
		this.zysqlbLocalService = zysqlbLocalService;
	}

	/**
	 * Returns the zysqlb persistence.
	 *
	 * @return the zysqlb persistence
	 */
	public ZysqlbPersistence getZysqlbPersistence() {
		return zysqlbPersistence;
	}

	/**
	 * Sets the zysqlb persistence.
	 *
	 * @param zysqlbPersistence the zysqlb persistence
	 */
	public void setZysqlbPersistence(ZysqlbPersistence zysqlbPersistence) {
		this.zysqlbPersistence = zysqlbPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.justonetech.expert.model.Zqtzjkrzqk",
			zqtzjkrzqkLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.justonetech.expert.model.Zqtzjkrzqk");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Zqtzjkrzqk.class;
	}

	protected String getModelClassName() {
		return Zqtzjkrzqk.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = zqtzjkrzqkPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.justonetech.expert.service.ExpertLocalService.class)
	protected com.justonetech.expert.service.ExpertLocalService expertLocalService;
	@BeanReference(type = ExpertPersistence.class)
	protected ExpertPersistence expertPersistence;
	@BeanReference(type = com.justonetech.expert.service.GzjlLocalService.class)
	protected com.justonetech.expert.service.GzjlLocalService gzjlLocalService;
	@BeanReference(type = GzjlPersistence.class)
	protected GzjlPersistence gzjlPersistence;
	@BeanReference(type = com.justonetech.expert.service.XlxxLocalService.class)
	protected com.justonetech.expert.service.XlxxLocalService xlxxLocalService;
	@BeanReference(type = XlxxPersistence.class)
	protected XlxxPersistence xlxxPersistence;
	@BeanReference(type = com.justonetech.expert.service.ZqtzjkrzqkLocalService.class)
	protected com.justonetech.expert.service.ZqtzjkrzqkLocalService zqtzjkrzqkLocalService;
	@BeanReference(type = ZqtzjkrzqkPersistence.class)
	protected ZqtzjkrzqkPersistence zqtzjkrzqkPersistence;
	@BeanReference(type = com.justonetech.expert.service.ZysqlbLocalService.class)
	protected com.justonetech.expert.service.ZysqlbLocalService zysqlbLocalService;
	@BeanReference(type = ZysqlbPersistence.class)
	protected ZysqlbPersistence zysqlbPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ZqtzjkrzqkLocalServiceClpInvoker _clpInvoker = new ZqtzjkrzqkLocalServiceClpInvoker();
}