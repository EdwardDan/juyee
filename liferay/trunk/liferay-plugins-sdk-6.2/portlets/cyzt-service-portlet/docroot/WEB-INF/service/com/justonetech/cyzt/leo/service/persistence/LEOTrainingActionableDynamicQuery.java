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

package com.justonetech.cyzt.leo.service.persistence;

import com.justonetech.cyzt.leo.model.LEOTraining;
import com.justonetech.cyzt.leo.service.LEOTrainingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author fanqi
 * @generated
 */
public abstract class LEOTrainingActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public LEOTrainingActionableDynamicQuery() throws SystemException {
		setBaseLocalService(LEOTrainingLocalServiceUtil.getService());
		setClass(LEOTraining.class);

		setClassLoader(com.justonetech.cyzt.leo.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("trainingId");
	}
}