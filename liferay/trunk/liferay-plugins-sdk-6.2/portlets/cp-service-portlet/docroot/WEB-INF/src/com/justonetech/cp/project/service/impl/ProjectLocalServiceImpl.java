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

package com.justonetech.cp.project.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.service.base.ProjectLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the project local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.justonetech.cp.project.service.ProjectLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author fanqi
 * @see com.justonetech.cp.project.service.base.ProjectLocalServiceBaseImpl
 * @see com.justonetech.cp.project.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.justonetech.cp.project.service.ProjectLocalServiceUtil} to
	 * access the project local service.
	 */
	private static Log log = LogFactoryUtil.getLog(ProjectLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<Project> getProjects(String zzjgdm,String bjbh, String bjWebid, String xmmc, Date bjrqStart, Date bjrqEnd, String bjwcbj, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(zzjgdm,bjbh, bjWebid, xmmc, bjrqStart, bjrqEnd, bjwcbj), start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int getProjectsCount(String zzjgdm,String bjbh, String bjWebid, String xmmc, Date bjrqStart, Date bjrqEnd, String bjwcbj) {

		try {
			return (int) this.dynamicQueryCount(createDynamicQuery(zzjgdm,bjbh, bjWebid, xmmc, bjrqStart, bjrqEnd, bjwcbj));
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}

	public DynamicQuery createDynamicQuery(String zzjgdm,String bjbh, String bjWebid, String xmmc, Date bjrqStart, Date bjrqEnd, String bjwcbj) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		if (!Validator.isBlank(zzjgdm)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("zzjgdm").eq(zzjgdm));
		}
		if (!Validator.isBlank(bjbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjbh").like("%" + bjbh + "%"));
		}
		if (!Validator.isBlank(bjWebid)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjWebid").like("%" + bjWebid + "%"));
		}
		if (!Validator.isBlank(xmmc)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("xmmc").like("%" + xmmc + "%"));
		}
		if (Validator.isNotNull(bjrqStart) && Validator.isNotNull(bjrqEnd)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjrq").between(bjrqStart, bjrqEnd));
		}
		if (!Validator.isBlank(bjwcbj)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjwcbj").eq(bjwcbj));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.desc("bjrq"));
		return dynamicQuery;
	}
}
