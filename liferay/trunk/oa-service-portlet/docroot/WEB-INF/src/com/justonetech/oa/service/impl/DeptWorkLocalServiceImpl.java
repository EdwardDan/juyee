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

import com.justonetech.oa.model.DeptWork;
import com.justonetech.oa.service.DeptWorkLocalServiceUtil;
import com.justonetech.oa.service.base.DeptWorkLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the dept work local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.justonetech.oa.service.DeptWorkLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author justonetech
 * @see com.justonetech.oa.service.base.DeptWorkLocalServiceBaseImpl
 * @see com.justonetech.oa.service.DeptWorkLocalServiceUtil
 */
public class DeptWorkLocalServiceImpl extends DeptWorkLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
     * {@link com.justonetech.oa.service.DeptWorkLocalServiceUtil} to access the
     * dept work local service.
     */

    public List<DeptWork> findByUserName(String userName, int start, int end)
        throws SystemException {

        return deptWorkPersistence.findByUserName("%" + userName + "%", start, end);
    }

    public int countByUserName(String userName)
        throws SystemException {

        return deptWorkPersistence.countByUserName("%" + userName + "%");
    }

    public List<DeptWork> findByDeptName(String deptName, int start, int end)
        throws SystemException {

        return deptWorkPersistence.findByDeptName("%" + deptName + "%", start, end);
    }

    public int countByDeptName(String deptName)
        throws SystemException {

        return deptWorkPersistence.countByDeptName("%" + deptName + "%");
    }

    public void deleteDeptWorks(String[] deptWorkIds) {

        for (String deptWorkId : deptWorkIds) {
            try {
                DeptWorkLocalServiceUtil.deleteDeptWork(Long.parseLong(deptWorkId));
            }
            catch (NumberFormatException | PortalException | SystemException e) {
                e.printStackTrace();
            }
        }
    }
}
