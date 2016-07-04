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

package com.justonetech.oa.service.impl;

import java.util.List;

import com.justonetech.oa.model.OfficeSupplyRequisitionItem;
import com.justonetech.oa.service.base.OfficeSupplyRequisitionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the office supply requisition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.oa.service.OfficeSupplyRequisitionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.oa.service.base.OfficeSupplyRequisitionLocalServiceBaseImpl
 * @see com.justonetech.oa.service.OfficeSupplyRequisitionLocalServiceUtil
 */
public class OfficeSupplyRequisitionLocalServiceImpl
	extends OfficeSupplyRequisitionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.oa.service.OfficeSupplyRequisitionLocalServiceUtil} to access the office supply requisition local service.
	 */
	public List<OfficeSupplyRequisitionItem> findByDeptWorkId(
			long officeSupplyRequisitionId) throws SystemException {
		return officeSupplyRequisitionItemPersistence
				.findByOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}

	public int countByTitle(long officeSupplyRequisitionId)
			throws SystemException {

		return officeSupplyRequisitionItemPersistence
				.countByOfficeSupplyRequisitionId(officeSupplyRequisitionId);
	}
}