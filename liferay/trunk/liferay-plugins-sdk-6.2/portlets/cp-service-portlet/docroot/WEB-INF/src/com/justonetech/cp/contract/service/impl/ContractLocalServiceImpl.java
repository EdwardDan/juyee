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

package com.justonetech.cp.contract.service.impl;

import java.util.Collections;
import java.util.List;

import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.service.base.ContractLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the contract local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.justonetech.cp.contract.service.ContractLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author fanqi
 * @see com.justonetech.cp.contract.service.base.ContractLocalServiceBaseImpl
 * @see com.justonetech.cp.contract.service.ContractLocalServiceUtil
 */
public class ContractLocalServiceImpl extends ContractLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.justonetech.cp.contract.service.ContractLocalServiceUtil} to
	 * access the contract local service.
	 */
	private static Log log = LogFactoryUtil.getLog(ContractLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<Contract> getContracts(String zzjgdm, String bjbh, String bdh, String xmmc, String htlx, String htxxbsbh, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(zzjgdm, bjbh, bdh, xmmc, htlx, htxxbsbh), start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int getContractsCount(String zzjgdm, String bjbh, String bdh, String xmmc, String htlx, String htxxbsbh) {

		try {
			return (int) this.dynamicQueryCount(createDynamicQuery(zzjgdm, bjbh, bdh, xmmc, htlx, htxxbsbh));
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}

	public DynamicQuery createDynamicQuery(String zzjgdm, String bjbh, String bdh, String xmmc, String htlx, String htxxbsbh) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		if (!Validator.isBlank(zzjgdm)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("zzjgdm").eq(zzjgdm));
		}
		if (!Validator.isBlank(bjbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjbh").like("%" + bjbh + "%"));
		}
		if (!Validator.isBlank(bdh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bdh").like("%" + bdh + "%"));
		}
		if (!Validator.isBlank(xmmc)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("xmmc").like("%" + xmmc + "%"));
		}
		if (!Validator.isBlank(htlx)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("htlx").like("%" + htlx + "%"));
		}
		if (!Validator.isBlank(htxxbsbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("contractId").like("%" + htxxbsbh + "%"));
		}
		return dynamicQuery;
	}

	@SuppressWarnings("unchecked")
	public List<Contract> getYbssgzbContracts(String zzjgdm, String bjbh, String bdh, String htmc, int start, int end) {

		try {
			return this.dynamicQuery(createYbssgzbDQ(zzjgdm, bjbh, bdh, htmc), start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int getYbssgzbContractsCount(String zzjgdm, String bjbh, String bdh, String htmc) {

		try {
			return (int) this.dynamicQueryCount(createYbssgzbDQ(zzjgdm, bjbh, bdh, htmc));
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}

	public DynamicQuery createYbssgzbDQ(String zzjgdm, String bjbh, String bdh, String htmc) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		if (!Validator.isBlank(zzjgdm)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("zzjgdm").eq(zzjgdm));
		}
		if (!Validator.isBlank(bjbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjbh").like("%" + bjbh + "%"));
		}
		if (!Validator.isBlank(bdh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bdh").like("%" + bdh + "%"));
		}
		if (!Validator.isBlank(htmc)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("htmc").like("%" + htmc + "%"));
		}
		dynamicQuery.add(PropertyFactoryUtil.forName("htzt").eq("已报送"));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("zbfgx").like("CZ%"));
		junction.add(PropertyFactoryUtil.forName("zbfgx").like("VZ%"));
		junction.add(PropertyFactoryUtil.forName("zbfgx").like("WZ%"));
		dynamicQuery.add(junction);
		return dynamicQuery;
	}
}
