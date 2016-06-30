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
 * Provides a wrapper for {@link DictionaryService}.
 *
 * @author justonetech
 * @see DictionaryService
 * @generated
 */
public class DictionaryServiceWrapper implements DictionaryService,
	ServiceWrapper<DictionaryService> {
	public DictionaryServiceWrapper(DictionaryService dictionaryService) {
		_dictionaryService = dictionaryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _dictionaryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dictionaryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dictionaryService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.justonetech.sys.model.Dictionary findByGroupIdAndCode(
		long groupId, java.lang.String code)
		throws com.justonetech.sys.NoSuchDictionaryException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryService.findByGroupIdAndCode(groupId, code);
	}

	@Override
	public java.util.List<com.justonetech.sys.model.Dictionary> findByGroupIdAndParentId(
		long groupId, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryService.findByGroupIdAndParentId(groupId, parentId,
			start, end);
	}

	@Override
	public int countByGroupIdAndParentId(long groupId, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryService.countByGroupIdAndParentId(groupId, parentId);
	}

	@Override
	public java.util.List<com.justonetech.sys.model.Dictionary> findByParentIdAndIsValid(
		long parentId, boolean isValid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryService.findByParentIdAndIsValid(parentId, isValid,
			start, end);
	}

	@Override
	public int countByParentIdAndIsValid(long parentId, boolean isValid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionaryService.countByParentIdAndIsValid(parentId, isValid);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DictionaryService getWrappedDictionaryService() {
		return _dictionaryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDictionaryService(DictionaryService dictionaryService) {
		_dictionaryService = dictionaryService;
	}

	@Override
	public DictionaryService getWrappedService() {
		return _dictionaryService;
	}

	@Override
	public void setWrappedService(DictionaryService dictionaryService) {
		_dictionaryService = dictionaryService;
	}

	private DictionaryService _dictionaryService;
}