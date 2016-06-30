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

package com.justonetech.sys.service.persistence;

import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author justonetech
 * @generated
 */
public abstract class DictionaryActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public DictionaryActionableDynamicQuery() throws SystemException {
		setBaseLocalService(DictionaryLocalServiceUtil.getService());
		setClass(Dictionary.class);

		setClassLoader(com.justonetech.sys.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("dictionaryId");
	}
}