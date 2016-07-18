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

import com.justonetech.projApproval.model.ConstructionPermit;
import com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil;
import com.justonetech.projApproval.service.base.ConstructionPermitLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the construction permit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.projApproval.service.ConstructionPermitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.projApproval.service.base.ConstructionPermitLocalServiceBaseImpl
 * @see com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil
 */
public class ConstructionPermitLocalServiceImpl
	extends ConstructionPermitLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil} to access the construction permit local service.
	 */

	public List<ConstructionPermit> findByUserId(long userId, int start, int end)
			throws SystemException {
		return constructionPermitPersistence.findByUserId(userId, start, end);
	}

	public int countByUserId(long userId) throws SystemException {

		return constructionPermitPersistence.countByUserId(userId);
	}

	public void deleteConstructionPermits(String[] constructionPermitIds) {

		for (String constructionPermitId : constructionPermitIds) {
			try {
				ConstructionPermitLocalServiceUtil
						.deleteConstructionPermit(Long
								.parseLong(constructionPermitId));
			} catch (NumberFormatException | PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
	}
}