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

package com.justonetech.sys.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DictionaryLocalService}.
 *
 * @author justonetech
 * @see DictionaryLocalService
 * @generated
 */
public class DictionaryLocalServiceWrapper implements DictionaryLocalService,
	ServiceWrapper<DictionaryLocalService> {
	public DictionaryLocalServiceWrapper(
		DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	/**
	* Adds the dictionary to the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.Dictionary addDictionary(
		com.justonetech.sys.model.Dictionary dictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.addDictionary(dictionary);
	}

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	@Override
	public com.justonetech.sys.model.Dictionary createDictionary(
		long dictionaryId) {
		return _dictionaryLocalService.createDictionary(dictionaryId);
	}

	/**
	* Deletes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws PortalException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.Dictionary deleteDictionary(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.deleteDictionary(dictionaryId);
	}

	/**
	* Deletes the dictionary from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.Dictionary deleteDictionary(
		com.justonetech.sys.model.Dictionary dictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.deleteDictionary(dictionary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dictionaryLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.justonetech.sys.model.Dictionary fetchDictionary(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.fetchDictionary(dictionaryId);
	}

	/**
	* Returns the dictionary with the primary key.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws PortalException if a dictionary with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.Dictionary getDictionary(long dictionaryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.getDictionary(dictionaryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.justonetech.sys.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.justonetech.sys.model.Dictionary> getDictionaries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.getDictionaries(start, end);
	}

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDictionariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.getDictionariesCount();
	}

	/**
	* Updates the dictionary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.justonetech.sys.model.Dictionary updateDictionary(
		com.justonetech.sys.model.Dictionary dictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.updateDictionary(dictionary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dictionaryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dictionaryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dictionaryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.justonetech.sys.model.Dictionary findByCode(long groupId,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.findByCode(groupId, code);
	}

	@Override
	public com.justonetech.sys.model.Dictionary findByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.findByGroupIdAndCode(groupId, code);
	}

	@Override
	public java.util.List<com.justonetech.sys.model.Dictionary> findByParentId(
		long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.findByParentId(parentId, start, end);
	}

	@Override
	public java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.findByGroupIdAndParentId(groupId,
			parentId, start, end);
	}

	@Override
	public int countByGroupIdAndParentId(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.countByGroupIdAndParentId(groupId,
			parentId);
	}

	@Override
	public java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.findByParentIdAndIsValid(parentId,
			isValid, start, end);
	}

	@Override
	public int countByParentIdAndIsValid(long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.countByParentIdAndIsValid(parentId,
			isValid);
	}

	@Override
	public java.util.List<com.justonetech.sys.model.Dictionary> findByG_P_K(
		long groupId, long parentId, java.lang.String keywords, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.findByG_P_K(groupId, parentId, keywords,
			start, end);
	}

	@Override
	public int countByG_P_K(long groupId, long parentId,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.countByG_P_K(groupId, parentId, keywords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery createDynamicQueryByG_P_K(
		long groupId, long parentId, java.lang.String keywords) {
		return _dictionaryLocalService.createDynamicQueryByG_P_K(groupId,
			parentId, keywords);
	}

	@Override
	public void deleteDictionaries(java.lang.String[] dictionaryIds) {
		_dictionaryLocalService.deleteDictionaries(dictionaryIds);
	}

	@Override
	public void recursiveDeleteDictionaries(java.lang.String[] dictionaryIds) {
		_dictionaryLocalService.recursiveDeleteDictionaries(dictionaryIds);
	}

	@Override
	public void recursiveDeleteDictionary(
		com.justonetech.sys.model.Dictionary parentDictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictionaryLocalService.recursiveDeleteDictionary(parentDictionary);
	}

	@Override
	public com.justonetech.sys.model.Dictionary updateIsLeaf(
		com.justonetech.sys.model.Dictionary dictionary, boolean isLeaf,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryLocalService.updateIsLeaf(dictionary, isLeaf, user);
	}

	@Override
	public void recursiveUpdateSortPath(
		com.justonetech.sys.model.Dictionary parentDictionary)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictionaryLocalService.recursiveUpdateSortPath(parentDictionary);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DictionaryLocalService getWrappedDictionaryLocalService() {
		return _dictionaryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDictionaryLocalService(
		DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	@Override
	public DictionaryLocalService getWrappedService() {
		return _dictionaryLocalService;
	}

	@Override
	public void setWrappedService(DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	private DictionaryLocalService _dictionaryLocalService;
}