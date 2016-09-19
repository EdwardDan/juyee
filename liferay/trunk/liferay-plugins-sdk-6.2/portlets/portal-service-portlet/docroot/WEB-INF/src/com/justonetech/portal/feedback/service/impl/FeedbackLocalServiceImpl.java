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

package com.justonetech.portal.feedback.service.impl;

import java.util.Collections;
import java.util.List;

import com.justonetech.portal.feedback.model.Feedback;
import com.justonetech.portal.feedback.service.base.FeedbackLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the feedback local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.portal.feedback.service.FeedbackLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author fanqi
 * @see com.justonetech.portal.feedback.service.base.FeedbackLocalServiceBaseImpl
 * @see com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil
 */
public class FeedbackLocalServiceImpl extends FeedbackLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil} to access the feedback local service.
	 */
	private static Log log = LogFactoryUtil.getLog(FeedbackLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<Feedback> getFeedbacks(String zt,String lx, long fkrId, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(zt,lx,fkrId), start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int getFeedbacksCount(String zt,String lx, long fkrId) {

		try {
			return (int) this.dynamicQueryCount(createDynamicQuery(zt,lx,fkrId));
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}

	public DynamicQuery createDynamicQuery(String zt,String lx, long fkrId) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		if (!Validator.isBlank(zt)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("zt").like("%" + zt + "%"));
		}
		if (!Validator.isBlank(lx)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("lx").like("%" + lx + "%"));
		}
		if (!Validator.equals(fkrId, -1)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("fkrId").eq(fkrId));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.desc("fkrq"));
		return dynamicQuery;
	}
}