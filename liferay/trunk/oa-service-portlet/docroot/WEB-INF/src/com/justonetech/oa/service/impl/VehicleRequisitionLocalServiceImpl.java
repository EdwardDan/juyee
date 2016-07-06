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

import com.justonetech.oa.model.VehicleRequisition;
import com.justonetech.oa.service.VehicleRequisitionLocalServiceUtil;
import com.justonetech.oa.service.base.VehicleRequisitionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the vehicle requisition local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.oa.service.VehicleRequisitionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author justonetech
 * @see com.justonetech.oa.service.base.VehicleRequisitionLocalServiceBaseImpl
 * @see com.justonetech.oa.service.VehicleRequisitionLocalServiceUtil
 */
public class VehicleRequisitionLocalServiceImpl
	extends VehicleRequisitionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.oa.service.VehicleRequisitionLocalServiceUtil} to access the vehicle requisition local service.
	 */
	
	public List<VehicleRequisition> findByApplicantName(String applicantName, int start, int end)
	        throws SystemException {

	        return vehicleRequisitionPersistence.findByApplicantName("%" + applicantName + "%", start, end);
	    }

	    public int countByName(String applicantName)
	        throws SystemException {

	        return officeSupplyPersistence.countByName("%" + applicantName + "%");
	    }

	    public void deleteVehicleRequisitions(String[] vehicleRequisitionIds) {

	        for (String vehicleRequisitionId : vehicleRequisitionIds) {
	            try {
	                VehicleRequisitionLocalServiceUtil.deleteVehicleRequisition(Long.parseLong(vehicleRequisitionId));
	            }
	            catch (NumberFormatException | PortalException | SystemException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}