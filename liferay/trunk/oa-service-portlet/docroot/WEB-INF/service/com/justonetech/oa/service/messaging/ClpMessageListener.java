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

package com.justonetech.oa.service.messaging;

import com.justonetech.oa.service.ClpSerializer;
import com.justonetech.oa.service.DeptWorkItemLocalServiceUtil;
import com.justonetech.oa.service.DeptWorkLocalServiceUtil;
import com.justonetech.oa.service.DispatchLocalServiceUtil;
import com.justonetech.oa.service.LeaderWorkLocalServiceUtil;
import com.justonetech.oa.service.OfficeSupplyApplicationItemLocalServiceUtil;
import com.justonetech.oa.service.OfficeSupplyApplicationLocalServiceUtil;
import com.justonetech.oa.service.OfficeSupplyLocalServiceUtil;
import com.justonetech.oa.service.VehicleApplicationLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author justonetech
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			DeptWorkLocalServiceUtil.clearService();

			DeptWorkItemLocalServiceUtil.clearService();

			DispatchLocalServiceUtil.clearService();

			LeaderWorkLocalServiceUtil.clearService();

			OfficeSupplyLocalServiceUtil.clearService();

			OfficeSupplyApplicationLocalServiceUtil.clearService();

			OfficeSupplyApplicationItemLocalServiceUtil.clearService();

			VehicleApplicationLocalServiceUtil.clearService();
		}
	}
}