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

package com.justonetech.projApproval.service.impl;

import java.util.List;

import com.justonetech.projApproval.NoSuchConstructionUnitProjectException;
import com.justonetech.projApproval.model.ConstructionUnitProject;
import com.justonetech.projApproval.service.base.ConstructionUnitProjectLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the construction unit project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.projApproval.service.ConstructionUnitProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.projApproval.service.base.ConstructionUnitProjectLocalServiceBaseImpl
 * @see com.justonetech.projApproval.service.ConstructionUnitProjectLocalServiceUtil
 */
public class ConstructionUnitProjectLocalServiceImpl
	extends ConstructionUnitProjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.projApproval.service.ConstructionUnitProjectLocalServiceUtil} to access the construction unit project local service.
	 */
	
	public List<ConstructionUnitProject> findByConstructionPermitId(
			long constructionPermitId)
			throws NoSuchConstructionUnitProjectException, SystemException {
		return constructionUnitProjectPersistence
				.findByConstructionPermitId(constructionPermitId);
	}
}