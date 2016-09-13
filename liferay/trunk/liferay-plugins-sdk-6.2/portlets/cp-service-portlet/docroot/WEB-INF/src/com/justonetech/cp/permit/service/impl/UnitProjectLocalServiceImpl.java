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

package com.justonetech.cp.permit.service.impl;

import java.util.Collections;
import java.util.List;
import com.justonetech.cp.permit.model.UnitProject;
import com.justonetech.cp.permit.service.base.UnitProjectLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the unit project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.cp.permit.service.UnitProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author fanqi
 * @see com.justonetech.cp.permit.service.base.UnitProjectLocalServiceBaseImpl
 * @see com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil
 */
public class UnitProjectLocalServiceImpl extends UnitProjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil} to access the unit project local service.
	 */
	private static Log log = LogFactoryUtil
			.getLog(UnitProjectLocalServiceImpl.class);

	public List<UnitProject> findByPermitId(long permitId, int start, int end) {
		try {
			return unitProjectPersistence.findByPermitId(permitId, start, end);
		} catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int countByPermitId(long permitId) {

		try {
			return (int) unitProjectPersistence.countByPermitId(permitId);
		} catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}

	public List<UnitProject> findByBjbh(String bjbh, int start, int end) {
		try {
			return unitProjectPersistence.findByBjbh(bjbh, start, end);
		} catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int countByBjbh(String bjbh) {

		try {
			return (int) unitProjectPersistence.countByBjbh(bjbh);
		} catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}
}