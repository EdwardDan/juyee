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

import com.justonetech.expert.model.Gzjl;
import com.justonetech.expert.model.Zqtzjkrzqk;
import com.justonetech.expert.service.base.ZqtzjkrzqkLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the zqtzjkrzqk local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.expert.service.ZqtzjkrzqkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author fanqi
 * @see com.justonetech.expert.service.base.ZqtzjkrzqkLocalServiceBaseImpl
 * @see com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil
 */
public class ZqtzjkrzqkLocalServiceImpl extends ZqtzjkrzqkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.justonetech.expert.service.ZqtzjkrzqkLocalServiceUtil} to access the zqtzjkrzqk local service.
	 */
	
	private static Log log = LogFactoryUtil
			.getLog(ZqtzjkrzqkLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<Zqtzjkrzqk> getZqtzjkrzqks(long expertId, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(expertId), start, end);
		} catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public DynamicQuery createDynamicQuery(long expertId) {

		DynamicQuery dynamicQuery = this.dynamicQuery();

		dynamicQuery.add(PropertyFactoryUtil.forName("expertId").eq(expertId));

		dynamicQuery.addOrder(OrderFactoryUtil.desc("zqtzjkrzqkId"));
		return dynamicQuery;
	}
}