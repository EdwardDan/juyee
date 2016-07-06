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

package com.justonetech.oa.service.base;

import com.justonetech.oa.model.OfficeSupplyRequisitionItem;
import com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalService;
import com.justonetech.oa.service.persistence.DeptWorkItemPersistence;
import com.justonetech.oa.service.persistence.DeptWorkPersistence;
import com.justonetech.oa.service.persistence.DispatchPersistence;
import com.justonetech.oa.service.persistence.LeaderWorkPersistence;
import com.justonetech.oa.service.persistence.OfficeSupplyPersistence;
import com.justonetech.oa.service.persistence.OfficeSupplyRequisitionItemPersistence;
import com.justonetech.oa.service.persistence.OfficeSupplyRequisitionPersistence;
import com.justonetech.oa.service.persistence.VehicleRequisitionPersistence;

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
 * Provides the base implementation for the office supply requisition item local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.justonetech.oa.service.impl.OfficeSupplyRequisitionItemLocalServiceImpl}.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.oa.service.impl.OfficeSupplyRequisitionItemLocalServiceImpl
 * @see com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalServiceUtil
 * @generated
 */
public abstract class OfficeSupplyRequisitionItemLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements OfficeSupplyRequisitionItemLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalServiceUtil} to access the office supply requisition item local service.
	 */

	/**
	 * Adds the office supply requisition item to the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyRequisitionItem the office supply requisition item
	 * @return the office supply requisition item that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public OfficeSupplyRequisitionItem addOfficeSupplyRequisitionItem(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws SystemException {
		officeSupplyRequisitionItem.setNew(true);

		return officeSupplyRequisitionItemPersistence.update(officeSupplyRequisitionItem);
	}

	/**
	 * Creates a new office supply requisition item with the primary key. Does not add the office supply requisition item to the database.
	 *
	 * @param officeSupplyRequisitionItemId the primary key for the new office supply requisition item
	 * @return the new office supply requisition item
	 */
	@Override
	public OfficeSupplyRequisitionItem createOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId) {
		return officeSupplyRequisitionItemPersistence.create(officeSupplyRequisitionItemId);
	}

	/**
	 * Deletes the office supply requisition item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	 * @return the office supply requisition item that was removed
	 * @throws PortalException if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public OfficeSupplyRequisitionItem deleteOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId)
		throws PortalException, SystemException {
		return officeSupplyRequisitionItemPersistence.remove(officeSupplyRequisitionItemId);
	}

	/**
	 * Deletes the office supply requisition item from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyRequisitionItem the office supply requisition item
	 * @return the office supply requisition item that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public OfficeSupplyRequisitionItem deleteOfficeSupplyRequisitionItem(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws SystemException {
		return officeSupplyRequisitionItemPersistence.remove(officeSupplyRequisitionItem);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(OfficeSupplyRequisitionItem.class,
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
		return officeSupplyRequisitionItemPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return officeSupplyRequisitionItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return officeSupplyRequisitionItemPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return officeSupplyRequisitionItemPersistence.countWithDynamicQuery(dynamicQuery);
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
		return officeSupplyRequisitionItemPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public OfficeSupplyRequisitionItem fetchOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId) throws SystemException {
		return officeSupplyRequisitionItemPersistence.fetchByPrimaryKey(officeSupplyRequisitionItemId);
	}

	/**
	 * Returns the office supply requisition item with the primary key.
	 *
	 * @param officeSupplyRequisitionItemId the primary key of the office supply requisition item
	 * @return the office supply requisition item
	 * @throws PortalException if a office supply requisition item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OfficeSupplyRequisitionItem getOfficeSupplyRequisitionItem(
		long officeSupplyRequisitionItemId)
		throws PortalException, SystemException {
		return officeSupplyRequisitionItemPersistence.findByPrimaryKey(officeSupplyRequisitionItemId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return officeSupplyRequisitionItemPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the office supply requisition items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.oa.model.impl.OfficeSupplyRequisitionItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of office supply requisition items
	 * @param end the upper bound of the range of office supply requisition items (not inclusive)
	 * @return the range of office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OfficeSupplyRequisitionItem> getOfficeSupplyRequisitionItems(
		int start, int end) throws SystemException {
		return officeSupplyRequisitionItemPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of office supply requisition items.
	 *
	 * @return the number of office supply requisition items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getOfficeSupplyRequisitionItemsCount() throws SystemException {
		return officeSupplyRequisitionItemPersistence.countAll();
	}

	/**
	 * Updates the office supply requisition item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param officeSupplyRequisitionItem the office supply requisition item
	 * @return the office supply requisition item that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public OfficeSupplyRequisitionItem updateOfficeSupplyRequisitionItem(
		OfficeSupplyRequisitionItem officeSupplyRequisitionItem)
		throws SystemException {
		return officeSupplyRequisitionItemPersistence.update(officeSupplyRequisitionItem);
	}

	/**
	 * Returns the dept work local service.
	 *
	 * @return the dept work local service
	 */
	public com.justonetech.oa.service.DeptWorkLocalService getDeptWorkLocalService() {
		return deptWorkLocalService;
	}

	/**
	 * Sets the dept work local service.
	 *
	 * @param deptWorkLocalService the dept work local service
	 */
	public void setDeptWorkLocalService(
		com.justonetech.oa.service.DeptWorkLocalService deptWorkLocalService) {
		this.deptWorkLocalService = deptWorkLocalService;
	}

	/**
	 * Returns the dept work persistence.
	 *
	 * @return the dept work persistence
	 */
	public DeptWorkPersistence getDeptWorkPersistence() {
		return deptWorkPersistence;
	}

	/**
	 * Sets the dept work persistence.
	 *
	 * @param deptWorkPersistence the dept work persistence
	 */
	public void setDeptWorkPersistence(DeptWorkPersistence deptWorkPersistence) {
		this.deptWorkPersistence = deptWorkPersistence;
	}

	/**
	 * Returns the dept work item local service.
	 *
	 * @return the dept work item local service
	 */
	public com.justonetech.oa.service.DeptWorkItemLocalService getDeptWorkItemLocalService() {
		return deptWorkItemLocalService;
	}

	/**
	 * Sets the dept work item local service.
	 *
	 * @param deptWorkItemLocalService the dept work item local service
	 */
	public void setDeptWorkItemLocalService(
		com.justonetech.oa.service.DeptWorkItemLocalService deptWorkItemLocalService) {
		this.deptWorkItemLocalService = deptWorkItemLocalService;
	}

	/**
	 * Returns the dept work item persistence.
	 *
	 * @return the dept work item persistence
	 */
	public DeptWorkItemPersistence getDeptWorkItemPersistence() {
		return deptWorkItemPersistence;
	}

	/**
	 * Sets the dept work item persistence.
	 *
	 * @param deptWorkItemPersistence the dept work item persistence
	 */
	public void setDeptWorkItemPersistence(
		DeptWorkItemPersistence deptWorkItemPersistence) {
		this.deptWorkItemPersistence = deptWorkItemPersistence;
	}

	/**
	 * Returns the dispatch local service.
	 *
	 * @return the dispatch local service
	 */
	public com.justonetech.oa.service.DispatchLocalService getDispatchLocalService() {
		return dispatchLocalService;
	}

	/**
	 * Sets the dispatch local service.
	 *
	 * @param dispatchLocalService the dispatch local service
	 */
	public void setDispatchLocalService(
		com.justonetech.oa.service.DispatchLocalService dispatchLocalService) {
		this.dispatchLocalService = dispatchLocalService;
	}

	/**
	 * Returns the dispatch persistence.
	 *
	 * @return the dispatch persistence
	 */
	public DispatchPersistence getDispatchPersistence() {
		return dispatchPersistence;
	}

	/**
	 * Sets the dispatch persistence.
	 *
	 * @param dispatchPersistence the dispatch persistence
	 */
	public void setDispatchPersistence(DispatchPersistence dispatchPersistence) {
		this.dispatchPersistence = dispatchPersistence;
	}

	/**
	 * Returns the leader work local service.
	 *
	 * @return the leader work local service
	 */
	public com.justonetech.oa.service.LeaderWorkLocalService getLeaderWorkLocalService() {
		return leaderWorkLocalService;
	}

	/**
	 * Sets the leader work local service.
	 *
	 * @param leaderWorkLocalService the leader work local service
	 */
	public void setLeaderWorkLocalService(
		com.justonetech.oa.service.LeaderWorkLocalService leaderWorkLocalService) {
		this.leaderWorkLocalService = leaderWorkLocalService;
	}

	/**
	 * Returns the leader work persistence.
	 *
	 * @return the leader work persistence
	 */
	public LeaderWorkPersistence getLeaderWorkPersistence() {
		return leaderWorkPersistence;
	}

	/**
	 * Sets the leader work persistence.
	 *
	 * @param leaderWorkPersistence the leader work persistence
	 */
	public void setLeaderWorkPersistence(
		LeaderWorkPersistence leaderWorkPersistence) {
		this.leaderWorkPersistence = leaderWorkPersistence;
	}

	/**
	 * Returns the office supply local service.
	 *
	 * @return the office supply local service
	 */
	public com.justonetech.oa.service.OfficeSupplyLocalService getOfficeSupplyLocalService() {
		return officeSupplyLocalService;
	}

	/**
	 * Sets the office supply local service.
	 *
	 * @param officeSupplyLocalService the office supply local service
	 */
	public void setOfficeSupplyLocalService(
		com.justonetech.oa.service.OfficeSupplyLocalService officeSupplyLocalService) {
		this.officeSupplyLocalService = officeSupplyLocalService;
	}

	/**
	 * Returns the office supply persistence.
	 *
	 * @return the office supply persistence
	 */
	public OfficeSupplyPersistence getOfficeSupplyPersistence() {
		return officeSupplyPersistence;
	}

	/**
	 * Sets the office supply persistence.
	 *
	 * @param officeSupplyPersistence the office supply persistence
	 */
	public void setOfficeSupplyPersistence(
		OfficeSupplyPersistence officeSupplyPersistence) {
		this.officeSupplyPersistence = officeSupplyPersistence;
	}

	/**
	 * Returns the office supply requisition local service.
	 *
	 * @return the office supply requisition local service
	 */
	public com.justonetech.oa.service.OfficeSupplyRequisitionLocalService getOfficeSupplyRequisitionLocalService() {
		return officeSupplyRequisitionLocalService;
	}

	/**
	 * Sets the office supply requisition local service.
	 *
	 * @param officeSupplyRequisitionLocalService the office supply requisition local service
	 */
	public void setOfficeSupplyRequisitionLocalService(
		com.justonetech.oa.service.OfficeSupplyRequisitionLocalService officeSupplyRequisitionLocalService) {
		this.officeSupplyRequisitionLocalService = officeSupplyRequisitionLocalService;
	}

	/**
	 * Returns the office supply requisition persistence.
	 *
	 * @return the office supply requisition persistence
	 */
	public OfficeSupplyRequisitionPersistence getOfficeSupplyRequisitionPersistence() {
		return officeSupplyRequisitionPersistence;
	}

	/**
	 * Sets the office supply requisition persistence.
	 *
	 * @param officeSupplyRequisitionPersistence the office supply requisition persistence
	 */
	public void setOfficeSupplyRequisitionPersistence(
		OfficeSupplyRequisitionPersistence officeSupplyRequisitionPersistence) {
		this.officeSupplyRequisitionPersistence = officeSupplyRequisitionPersistence;
	}

	/**
	 * Returns the office supply requisition item local service.
	 *
	 * @return the office supply requisition item local service
	 */
	public com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalService getOfficeSupplyRequisitionItemLocalService() {
		return officeSupplyRequisitionItemLocalService;
	}

	/**
	 * Sets the office supply requisition item local service.
	 *
	 * @param officeSupplyRequisitionItemLocalService the office supply requisition item local service
	 */
	public void setOfficeSupplyRequisitionItemLocalService(
		com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalService officeSupplyRequisitionItemLocalService) {
		this.officeSupplyRequisitionItemLocalService = officeSupplyRequisitionItemLocalService;
	}

	/**
	 * Returns the office supply requisition item persistence.
	 *
	 * @return the office supply requisition item persistence
	 */
	public OfficeSupplyRequisitionItemPersistence getOfficeSupplyRequisitionItemPersistence() {
		return officeSupplyRequisitionItemPersistence;
	}

	/**
	 * Sets the office supply requisition item persistence.
	 *
	 * @param officeSupplyRequisitionItemPersistence the office supply requisition item persistence
	 */
	public void setOfficeSupplyRequisitionItemPersistence(
		OfficeSupplyRequisitionItemPersistence officeSupplyRequisitionItemPersistence) {
		this.officeSupplyRequisitionItemPersistence = officeSupplyRequisitionItemPersistence;
	}

	/**
	 * Returns the vehicle requisition local service.
	 *
	 * @return the vehicle requisition local service
	 */
	public com.justonetech.oa.service.VehicleRequisitionLocalService getVehicleRequisitionLocalService() {
		return vehicleRequisitionLocalService;
	}

	/**
	 * Sets the vehicle requisition local service.
	 *
	 * @param vehicleRequisitionLocalService the vehicle requisition local service
	 */
	public void setVehicleRequisitionLocalService(
		com.justonetech.oa.service.VehicleRequisitionLocalService vehicleRequisitionLocalService) {
		this.vehicleRequisitionLocalService = vehicleRequisitionLocalService;
	}

	/**
	 * Returns the vehicle requisition persistence.
	 *
	 * @return the vehicle requisition persistence
	 */
	public VehicleRequisitionPersistence getVehicleRequisitionPersistence() {
		return vehicleRequisitionPersistence;
	}

	/**
	 * Sets the vehicle requisition persistence.
	 *
	 * @param vehicleRequisitionPersistence the vehicle requisition persistence
	 */
	public void setVehicleRequisitionPersistence(
		VehicleRequisitionPersistence vehicleRequisitionPersistence) {
		this.vehicleRequisitionPersistence = vehicleRequisitionPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.justonetech.oa.model.OfficeSupplyRequisitionItem",
			officeSupplyRequisitionItemLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.justonetech.oa.model.OfficeSupplyRequisitionItem");
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
		return OfficeSupplyRequisitionItem.class;
	}

	protected String getModelClassName() {
		return OfficeSupplyRequisitionItem.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = officeSupplyRequisitionItemPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.justonetech.oa.service.DeptWorkLocalService.class)
	protected com.justonetech.oa.service.DeptWorkLocalService deptWorkLocalService;
	@BeanReference(type = DeptWorkPersistence.class)
	protected DeptWorkPersistence deptWorkPersistence;
	@BeanReference(type = com.justonetech.oa.service.DeptWorkItemLocalService.class)
	protected com.justonetech.oa.service.DeptWorkItemLocalService deptWorkItemLocalService;
	@BeanReference(type = DeptWorkItemPersistence.class)
	protected DeptWorkItemPersistence deptWorkItemPersistence;
	@BeanReference(type = com.justonetech.oa.service.DispatchLocalService.class)
	protected com.justonetech.oa.service.DispatchLocalService dispatchLocalService;
	@BeanReference(type = DispatchPersistence.class)
	protected DispatchPersistence dispatchPersistence;
	@BeanReference(type = com.justonetech.oa.service.LeaderWorkLocalService.class)
	protected com.justonetech.oa.service.LeaderWorkLocalService leaderWorkLocalService;
	@BeanReference(type = LeaderWorkPersistence.class)
	protected LeaderWorkPersistence leaderWorkPersistence;
	@BeanReference(type = com.justonetech.oa.service.OfficeSupplyLocalService.class)
	protected com.justonetech.oa.service.OfficeSupplyLocalService officeSupplyLocalService;
	@BeanReference(type = OfficeSupplyPersistence.class)
	protected OfficeSupplyPersistence officeSupplyPersistence;
	@BeanReference(type = com.justonetech.oa.service.OfficeSupplyRequisitionLocalService.class)
	protected com.justonetech.oa.service.OfficeSupplyRequisitionLocalService officeSupplyRequisitionLocalService;
	@BeanReference(type = OfficeSupplyRequisitionPersistence.class)
	protected OfficeSupplyRequisitionPersistence officeSupplyRequisitionPersistence;
	@BeanReference(type = com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalService.class)
	protected com.justonetech.oa.service.OfficeSupplyRequisitionItemLocalService officeSupplyRequisitionItemLocalService;
	@BeanReference(type = OfficeSupplyRequisitionItemPersistence.class)
	protected OfficeSupplyRequisitionItemPersistence officeSupplyRequisitionItemPersistence;
	@BeanReference(type = com.justonetech.oa.service.VehicleRequisitionLocalService.class)
	protected com.justonetech.oa.service.VehicleRequisitionLocalService vehicleRequisitionLocalService;
	@BeanReference(type = VehicleRequisitionPersistence.class)
	protected VehicleRequisitionPersistence vehicleRequisitionPersistence;
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
	private OfficeSupplyRequisitionItemLocalServiceClpInvoker _clpInvoker = new OfficeSupplyRequisitionItemLocalServiceClpInvoker();
}