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

package com.justonetech.expert.service.persistence;

import com.justonetech.expert.model.Zqtzjkrzqk;
import com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author fanqi
 * @generated
 */
public abstract class ZqtzjkrzqkActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ZqtzjkrzqkActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ZqtzjkrzqkLocalServiceUtil.getService());
		setClass(Zqtzjkrzqk.class);

		setClassLoader(com.justonetech.expert.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("zqtzjkrzqkId");
	}
}