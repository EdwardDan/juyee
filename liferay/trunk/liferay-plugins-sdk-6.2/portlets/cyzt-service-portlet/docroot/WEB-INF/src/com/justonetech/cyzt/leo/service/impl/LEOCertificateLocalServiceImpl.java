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
import java.util.Date;
import java.util.List;

import com.justonetech.cyzt.leo.model.LEOCertificate;
import com.justonetech.cyzt.leo.service.base.LEOCertificateLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the l e o certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.cyzt.leo.service.LEOCertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author fanqi
 * @see com.justonetech.cyzt.leo.service.base.LEOCertificateLocalServiceBaseImpl
 * @see com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil
 */
public class LEOCertificateLocalServiceImpl
	extends LEOCertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil} to access the l e o certificate local service.
	 */
	private static Log log = LogFactoryUtil.getLog(LEOCertificateLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<LEOCertificate> getLEOCertificates(String xm,String zylx, String zjbh, Date yxq, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(xm,zylx,zjbh,yxq), start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int getProjectsCount(String xm,String zylx, String zjbh, Date yxq) {

		try {
			return (int) this.dynamicQueryCount(createDynamicQuery(xm,zylx,zjbh,yxq));
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}

	public DynamicQuery createDynamicQuery(String xm,String zylx, String zjbh, Date yxq) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		if (!Validator.isBlank(xm)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("xm").like("%" + xm + "%"));
		}
		if (!Validator.isBlank(zylx)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("zylx").like("%" + zylx + "%"));
		}
		if (!Validator.isBlank(zjbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("zjbh").like("%" + zjbh + "%"));
		}
		if (Validator.isNotNull(yxq)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("yxq").eq(yxq));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("certificateId"));
		return dynamicQuery;
	}
}