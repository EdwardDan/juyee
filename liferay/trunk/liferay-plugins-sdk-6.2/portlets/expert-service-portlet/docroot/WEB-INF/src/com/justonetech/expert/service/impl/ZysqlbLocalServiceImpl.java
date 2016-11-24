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

package com.justonetech.expert.service.impl;

import java.util.Collections;
import java.util.List;

import com.justonetech.expert.model.Expert;
import com.justonetech.expert.model.Zysqlb;
import com.justonetech.expert.service.base.ZysqlbLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the zysqlb local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.justonetech.expert.service.ZysqlbLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author fanqi
 * @see com.justonetech.expert.service.base.ZysqlbLocalServiceBaseImpl
 * @see com.justonetech.expert.service.ZysqlbLocalServiceUtil
 */
public class ZysqlbLocalServiceImpl extends ZysqlbLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.justonetech.expert.service.ZysqlbLocalServiceUtil} to access the
	 * zysqlb local service.
	 */
	private static Log log = LogFactoryUtil
			.getLog(ZysqlbLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<Zysqlb> getZysqlbs(String keyWord, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(keyWord), start, end);
		} catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public DynamicQuery createDynamicQuery(String keyWord) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		Junction junction = RestrictionsFactoryUtil.disjunction();

		DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil
				.forClass(Expert.class);
		projectProfileDQ.setProjection(ProjectionFactoryUtil
				.property("expertId"));
		projectProfileDQ.add(PropertyFactoryUtil.forName("xm").like(
				"%" + keyWord + "%"));
		Criterion criterion = PropertyFactoryUtil.forName("expertId").in(
				projectProfileDQ);
		junction.add(criterion);

		projectProfileDQ.setProjection(ProjectionFactoryUtil
				.property("expertId"));
		projectProfileDQ.add(PropertyFactoryUtil.forName("zc").like(
				"%" + keyWord + "%"));
		criterion = PropertyFactoryUtil.forName("expertId")
				.in(projectProfileDQ);
		junction.add(criterion);

		projectProfileDQ.setProjection(ProjectionFactoryUtil
				.property("expertId"));
		projectProfileDQ.add(PropertyFactoryUtil.forName("zyzg").like(
				"%" + keyWord + "%"));
		criterion = PropertyFactoryUtil.forName("expertId")
				.in(projectProfileDQ);
		junction.add(criterion);

		projectProfileDQ.setProjection(ProjectionFactoryUtil
				.property("expertId"));
		projectProfileDQ.add(PropertyFactoryUtil.forName("cszy").like(
				"%" + keyWord + "%"));
		criterion = PropertyFactoryUtil.forName("expertId")
				.in(projectProfileDQ);
		junction.add(criterion);

		dynamicQuery.addOrder(OrderFactoryUtil.desc("expertId"));
		return dynamicQuery;
	}

}