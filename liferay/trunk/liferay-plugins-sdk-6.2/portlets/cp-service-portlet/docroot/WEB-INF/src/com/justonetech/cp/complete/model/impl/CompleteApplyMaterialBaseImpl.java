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

package com.justonetech.cp.complete.model.impl;

import com.justonetech.cp.complete.model.CompleteApplyMaterial;
import com.justonetech.cp.complete.service.CompleteApplyMaterialLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the CompleteApplyMaterial service. Represents a row in the &quot;cp_CompleteApplyMaterial&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CompleteApplyMaterialImpl}.
 * </p>
 *
 * @author fanqi
 * @see CompleteApplyMaterialImpl
 * @see com.justonetech.cp.complete.model.CompleteApplyMaterial
 * @generated
 */
public abstract class CompleteApplyMaterialBaseImpl
	extends CompleteApplyMaterialModelImpl implements CompleteApplyMaterial {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a complete apply material model instance should use the {@link CompleteApplyMaterial} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CompleteApplyMaterialLocalServiceUtil.addCompleteApplyMaterial(this);
		}
		else {
			CompleteApplyMaterialLocalServiceUtil.updateCompleteApplyMaterial(this);
		}
	}
}