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

package com.justonetech.cyzt.leo.service.impl;

import java.util.Collections;
import java.util.List;

import com.justonetech.cyzt.leo.model.LEOTraining;
import com.justonetech.cyzt.leo.service.base.LEOTrainingLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the l e o training local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link com.justonetech.cyzt.leo.service.LEOTrainingLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author fanqi
 * @see com.justonetech.cyzt.leo.service.base.LEOTrainingLocalServiceBaseImpl
 * @see com.justonetech.cyzt.leo.service.LEOTrainingLocalServiceUtil
 */
public class LEOTrainingLocalServiceImpl extends LEOTrainingLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.justonetech.cyzt.leo.service.LEOTrainingLocalServiceUtil} to
	 * access the l e o training local service.
	 */
	private static Log log = LogFactoryUtil.getLog(LEOTrainingLocalServiceImpl.class);

	public List<LEOTraining> findByCertificateId(long certificateId, int start, int end) {

		try {
			return leoTrainingPersistence.findByCertificateId(certificateId, start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int countByCertificateId(long certificateId) {

		try {
			return leoTrainingPersistence.countByCertificateId(certificateId);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}
}
