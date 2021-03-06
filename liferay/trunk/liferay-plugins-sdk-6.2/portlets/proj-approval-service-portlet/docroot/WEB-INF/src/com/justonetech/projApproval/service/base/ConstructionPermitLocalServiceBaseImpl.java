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

package com.justonetech.projApproval.service.base;

import com.justonetech.projApproval.model.ConstructionPermit;
import com.justonetech.projApproval.service.ConstructionPermitLocalService;
import com.justonetech.projApproval.service.persistence.ConstructionParticipantUnitsPersistence;
import com.justonetech.projApproval.service.persistence.ConstructionPermitPersistence;
import com.justonetech.projApproval.service.persistence.ConstructionUnitProjectPersistence;

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
import com.liferay.portal.service.persistence.WorkflowInstanceLinkPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the construction permit local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.justonetech.projApproval.service.impl.ConstructionPermitLocalServiceImpl}.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.projApproval.service.impl.ConstructionPermitLocalServiceImpl
 * @see com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil
 * @generated
 */
public abstract class ConstructionPermitLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ConstructionPermitLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil} to access the construction permit local service.
	 */

	/**
	 * Adds the construction permit to the database. Also notifies the appropriate model listeners.
	 *
	 * @param constructionPermit the construction permit
	 * @return the construction permit that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConstructionPermit addConstructionPermit(
		ConstructionPermit constructionPermit) throws SystemException {
		constructionPermit.setNew(true);

		return constructionPermitPersistence.update(constructionPermit);
	}

	/**
	 * Creates a new construction permit with the primary key. Does not add the construction permit to the database.
	 *
	 * @param constructionPermitId the primary key for the new construction permit
	 * @return the new construction permit
	 */
	@Override
	public ConstructionPermit createConstructionPermit(
		long constructionPermitId) {
		return constructionPermitPersistence.create(constructionPermitId);
	}

	/**
	 * Deletes the construction permit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param constructionPermitId the primary key of the construction permit
	 * @return the construction permit that was removed
	 * @throws PortalException if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ConstructionPermit deleteConstructionPermit(
		long constructionPermitId) throws PortalException, SystemException {
		return constructionPermitPersistence.remove(constructionPermitId);
	}

	/**
	 * Deletes the construction permit from the database. Also notifies the appropriate model listeners.
	 *
	 * @param constructionPermit the construction permit
	 * @return the construction permit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ConstructionPermit deleteConstructionPermit(
		ConstructionPermit constructionPermit) throws SystemException {
		return constructionPermitPersistence.remove(constructionPermit);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ConstructionPermit.class,
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
		return constructionPermitPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return constructionPermitPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return constructionPermitPersistence.findWithDynamicQuery(dynamicQuery,
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
		return constructionPermitPersistence.countWithDynamicQuery(dynamicQuery);
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
		return constructionPermitPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ConstructionPermit fetchConstructionPermit(long constructionPermitId)
		throws SystemException {
		return constructionPermitPersistence.fetchByPrimaryKey(constructionPermitId);
	}

	/**
	 * Returns the construction permit with the primary key.
	 *
	 * @param constructionPermitId the primary key of the construction permit
	 * @return the construction permit
	 * @throws PortalException if a construction permit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConstructionPermit getConstructionPermit(long constructionPermitId)
		throws PortalException, SystemException {
		return constructionPermitPersistence.findByPrimaryKey(constructionPermitId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return constructionPermitPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the construction permits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.projApproval.model.impl.ConstructionPermitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of construction permits
	 * @param end the upper bound of the range of construction permits (not inclusive)
	 * @return the range of construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ConstructionPermit> getConstructionPermits(int start, int end)
		throws SystemException {
		return constructionPermitPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of construction permits.
	 *
	 * @return the number of construction permits
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getConstructionPermitsCount() throws SystemException {
		return constructionPermitPersistence.countAll();
	}

	/**
	 * Updates the construction permit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param constructionPermit the construction permit
	 * @return the construction permit that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ConstructionPermit updateConstructionPermit(
		ConstructionPermit constructionPermit) throws SystemException {
		return constructionPermitPersistence.update(constructionPermit);
	}

	/**
	 * Returns the construction participant units local service.
	 *
	 * @return the construction participant units local service
	 */
	public com.justonetech.projApproval.service.ConstructionParticipantUnitsLocalService getConstructionParticipantUnitsLocalService() {
		return constructionParticipantUnitsLocalService;
	}

	/**
	 * Sets the construction participant units local service.
	 *
	 * @param constructionParticipantUnitsLocalService the construction participant units local service
	 */
	public void setConstructionParticipantUnitsLocalService(
		com.justonetech.projApproval.service.ConstructionParticipantUnitsLocalService constructionParticipantUnitsLocalService) {
		this.constructionParticipantUnitsLocalService = constructionParticipantUnitsLocalService;
	}

	/**
	 * Returns the construction participant units persistence.
	 *
	 * @return the construction participant units persistence
	 */
	public ConstructionParticipantUnitsPersistence getConstructionParticipantUnitsPersistence() {
		return constructionParticipantUnitsPersistence;
	}

	/**
	 * Sets the construction participant units persistence.
	 *
	 * @param constructionParticipantUnitsPersistence the construction participant units persistence
	 */
	public void setConstructionParticipantUnitsPersistence(
		ConstructionParticipantUnitsPersistence constructionParticipantUnitsPersistence) {
		this.constructionParticipantUnitsPersistence = constructionParticipantUnitsPersistence;
	}

	/**
	 * Returns the construction permit local service.
	 *
	 * @return the construction permit local service
	 */
	public com.justonetech.projApproval.service.ConstructionPermitLocalService getConstructionPermitLocalService() {
		return constructionPermitLocalService;
	}

	/**
	 * Sets the construction permit local service.
	 *
	 * @param constructionPermitLocalService the construction permit local service
	 */
	public void setConstructionPermitLocalService(
		com.justonetech.projApproval.service.ConstructionPermitLocalService constructionPermitLocalService) {
		this.constructionPermitLocalService = constructionPermitLocalService;
	}

	/**
	 * Returns the construction permit remote service.
	 *
	 * @return the construction permit remote service
	 */
	public com.justonetech.projApproval.service.ConstructionPermitService getConstructionPermitService() {
		return constructionPermitService;
	}

	/**
	 * Sets the construction permit remote service.
	 *
	 * @param constructionPermitService the construction permit remote service
	 */
	public void setConstructionPermitService(
		com.justonetech.projApproval.service.ConstructionPermitService constructionPermitService) {
		this.constructionPermitService = constructionPermitService;
	}

	/**
	 * Returns the construction permit persistence.
	 *
	 * @return the construction permit persistence
	 */
	public ConstructionPermitPersistence getConstructionPermitPersistence() {
		return constructionPermitPersistence;
	}

	/**
	 * Sets the construction permit persistence.
	 *
	 * @param constructionPermitPersistence the construction permit persistence
	 */
	public void setConstructionPermitPersistence(
		ConstructionPermitPersistence constructionPermitPersistence) {
		this.constructionPermitPersistence = constructionPermitPersistence;
	}

	/**
	 * Returns the construction unit project local service.
	 *
	 * @return the construction unit project local service
	 */
	public com.justonetech.projApproval.service.ConstructionUnitProjectLocalService getConstructionUnitProjectLocalService() {
		return constructionUnitProjectLocalService;
	}

	/**
	 * Sets the construction unit project local service.
	 *
	 * @param constructionUnitProjectLocalService the construction unit project local service
	 */
	public void setConstructionUnitProjectLocalService(
		com.justonetech.projApproval.service.ConstructionUnitProjectLocalService constructionUnitProjectLocalService) {
		this.constructionUnitProjectLocalService = constructionUnitProjectLocalService;
	}

	/**
	 * Returns the construction unit project persistence.
	 *
	 * @return the construction unit project persistence
	 */
	public ConstructionUnitProjectPersistence getConstructionUnitProjectPersistence() {
		return constructionUnitProjectPersistence;
	}

	/**
	 * Sets the construction unit project persistence.
	 *
	 * @param constructionUnitProjectPersistence the construction unit project persistence
	 */
	public void setConstructionUnitProjectPersistence(
		ConstructionUnitProjectPersistence constructionUnitProjectPersistence) {
		this.constructionUnitProjectPersistence = constructionUnitProjectPersistence;
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

	/**
	 * Returns the workflow instance link local service.
	 *
	 * @return the workflow instance link local service
	 */
	public com.liferay.portal.service.WorkflowInstanceLinkLocalService getWorkflowInstanceLinkLocalService() {
		return workflowInstanceLinkLocalService;
	}

	/**
	 * Sets the workflow instance link local service.
	 *
	 * @param workflowInstanceLinkLocalService the workflow instance link local service
	 */
	public void setWorkflowInstanceLinkLocalService(
		com.liferay.portal.service.WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService) {
		this.workflowInstanceLinkLocalService = workflowInstanceLinkLocalService;
	}

	/**
	 * Returns the workflow instance link persistence.
	 *
	 * @return the workflow instance link persistence
	 */
	public WorkflowInstanceLinkPersistence getWorkflowInstanceLinkPersistence() {
		return workflowInstanceLinkPersistence;
	}

	/**
	 * Sets the workflow instance link persistence.
	 *
	 * @param workflowInstanceLinkPersistence the workflow instance link persistence
	 */
	public void setWorkflowInstanceLinkPersistence(
		WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence) {
		this.workflowInstanceLinkPersistence = workflowInstanceLinkPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.justonetech.projApproval.model.ConstructionPermit",
			constructionPermitLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.justonetech.projApproval.model.ConstructionPermit");
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
		return ConstructionPermit.class;
	}

	protected String getModelClassName() {
		return ConstructionPermit.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = constructionPermitPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.justonetech.projApproval.service.ConstructionParticipantUnitsLocalService.class)
	protected com.justonetech.projApproval.service.ConstructionParticipantUnitsLocalService constructionParticipantUnitsLocalService;
	@BeanReference(type = ConstructionParticipantUnitsPersistence.class)
	protected ConstructionParticipantUnitsPersistence constructionParticipantUnitsPersistence;
	@BeanReference(type = com.justonetech.projApproval.service.ConstructionPermitLocalService.class)
	protected com.justonetech.projApproval.service.ConstructionPermitLocalService constructionPermitLocalService;
	@BeanReference(type = com.justonetech.projApproval.service.ConstructionPermitService.class)
	protected com.justonetech.projApproval.service.ConstructionPermitService constructionPermitService;
	@BeanReference(type = ConstructionPermitPersistence.class)
	protected ConstructionPermitPersistence constructionPermitPersistence;
	@BeanReference(type = com.justonetech.projApproval.service.ConstructionUnitProjectLocalService.class)
	protected com.justonetech.projApproval.service.ConstructionUnitProjectLocalService constructionUnitProjectLocalService;
	@BeanReference(type = ConstructionUnitProjectPersistence.class)
	protected ConstructionUnitProjectPersistence constructionUnitProjectPersistence;
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
	@BeanReference(type = com.liferay.portal.service.WorkflowInstanceLinkLocalService.class)
	protected com.liferay.portal.service.WorkflowInstanceLinkLocalService workflowInstanceLinkLocalService;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ConstructionPermitLocalServiceClpInvoker _clpInvoker = new ConstructionPermitLocalServiceClpInvoker();
}