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

import com.justonetech.oa.model.DeptWorkItem;
import com.justonetech.oa.service.base.DeptWorkItemLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the dept work item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.oa.service.DeptWorkItemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.oa.service.base.DeptWorkItemLocalServiceBaseImpl
 * @see com.justonetech.oa.service.DeptWorkItemLocalServiceUtil
 */
public class DeptWorkItemLocalServiceImpl
	extends DeptWorkItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.oa.service.DeptWorkItemLocalServiceUtil} to access the dept work item local service.
	 */
	
	public List<DeptWorkItem> findByDeptWorkId(long deptWorkId) throws SystemException {
		return deptWorkItemPersistence.findByDeptWorkId(deptWorkId);
	}

	public int countByDeptWorkId(long deptWorkId) throws SystemException {

		return deptWorkItemPersistence.countByDeptWorkId(deptWorkId);
	}
}