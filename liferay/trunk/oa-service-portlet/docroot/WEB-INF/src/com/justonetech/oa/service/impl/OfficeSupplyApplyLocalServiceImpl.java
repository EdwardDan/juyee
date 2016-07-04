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

import com.justonetech.oa.model.OfficeSupplyApply;
import com.justonetech.oa.service.OfficeSupplyApplyLocalServiceUtil;
import com.justonetech.oa.service.base.OfficeSupplyApplyLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the office supply apply local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.oa.service.OfficeSupplyApplyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.oa.service.base.OfficeSupplyApplyLocalServiceBaseImpl
 * @see com.justonetech.oa.service.OfficeSupplyApplyLocalServiceUtil
 */
public class OfficeSupplyApplyLocalServiceImpl
	extends OfficeSupplyApplyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.oa.service.OfficeSupplyApplyLocalServiceUtil} to access the office supply apply local service.
	 */
	public List<OfficeSupplyApply> findByApplicantName(String applicantName,
			int start, int end) throws SystemException {
		return officeSupplyApplyPersistence.findByApplicantName("%"
				+ applicantName + "%", start, end);
	}

	public int countByApplicantName(String applicantName)
			throws SystemException {

		return officeSupplyApplyPersistence.countByApplicantName("%"
				+ applicantName + "%");
	}

	public List<OfficeSupplyApply> findByDeptName(String deptName, int start,
			int end) throws SystemException {
		return officeSupplyApplyPersistence.findByDeptName(
				"%" + deptName + "%", start, end);
	}

	public int countByDeptName(String deptName) throws SystemException {

		return officeSupplyApplyPersistence.countByDeptName("%" + deptName
				+ "%");
	}

	public void deleteOfficeSupplies(String[] officeSupplyApplyIds) {

		for (String officeSupplyApplyId : officeSupplyApplyIds) {
			try {
				OfficeSupplyApplyLocalServiceUtil.deleteOfficeSupplyApply(Long
						.parseLong(officeSupplyApplyId));
			} catch (NumberFormatException | PortalException | SystemException e) {
				e.printStackTrace();
			}
		}
	}
}