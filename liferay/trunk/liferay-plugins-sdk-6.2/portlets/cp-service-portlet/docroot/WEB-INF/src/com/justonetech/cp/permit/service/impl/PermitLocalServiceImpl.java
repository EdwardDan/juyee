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
import java.util.Dictionary;
import java.util.List;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.base.PermitLocalServiceBaseImpl;
import com.justonetech.cp.project.service.impl.ProjectLocalServiceImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.intraband.SystemDataType;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the permit local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.justonetech.cp.permit.service.PermitLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author fanqi
 * @see com.justonetech.cp.permit.service.base.PermitLocalServiceBaseImpl
 * @see com.justonetech.cp.permit.service.PermitLocalServiceUtil
 */
public class PermitLocalServiceImpl extends PermitLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link com.justonetech.cp.permit.service.PermitLocalServiceUtil} to
	 * access the permit local service.
	 */
	private static Log log = LogFactoryUtil.getLog(ProjectLocalServiceImpl.class);

	@SuppressWarnings("unchecked")
	public List<Permit> getPermits(String zzjgdm, String bjbh, String wssqbh, String gcmc, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(zzjgdm, bjbh, wssqbh, gcmc), start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Permit> getPermits(String ywbh, String bjbh, String gcmc, Long xmlx,String jsdwmc,String status,String gs, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(ywbh, bjbh, gcmc, xmlx,jsdwmc,status,gs), start, end);
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return Collections.emptyList();
	}

	public int getPermitsCount(String zzjgdm, String bjbh, String wssqbh, String gcmc) {

		try {
			return (int) this.dynamicQueryCount(createDynamicQuery(zzjgdm, bjbh, wssqbh, gcmc));
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}
	
	public int getPermitsCount(String ywbh, String bjbh, String gcmc, Long xmlx,String jsdwmc,String status,String gs) {

		try {
			return (int) this.dynamicQueryCount(createDynamicQuery(ywbh, bjbh, gcmc, xmlx,jsdwmc,status,gs));
		}
		catch (SystemException e) {
			log.info(e.getMessage());
		}
		return 0;
	}

	public DynamicQuery createDynamicQuery(String zzjgdm, String bjbh, String wssqbh, String gcmc) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		if (!Validator.isBlank(zzjgdm)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("zzjgdm").eq(zzjgdm));
		}
		if (!Validator.isBlank(bjbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjbh").like("%" + bjbh + "%"));
		}
		if (!Validator.isBlank(wssqbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("wssqbh").like("%" + wssqbh + "%"));
		}
		if (!Validator.isBlank(gcmc)) {
			DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
			projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
			projectProfileDQ.add(PropertyFactoryUtil.forName("gcmc").like("%" + gcmc + "%"));
			dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
		}
		return dynamicQuery;
	}
	
	public DynamicQuery createDynamicQuery(String ywbh, String bjbh, String gcmc, Long xmlx,String jsdwmc,String status,String gs) {

		DynamicQuery dynamicQuery = this.dynamicQuery();
		if (!Validator.isBlank(ywbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("ywbh").like("%" + ywbh + "%"));
		}
		if (!Validator.isBlank(bjbh)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("bjbh").like("%" + bjbh + "%"));
		}
		if (!Validator.isBlank(gcmc)) {
			DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
			projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
			projectProfileDQ.add(PropertyFactoryUtil.forName("gcmc").like("%" + gcmc + "%"));
			dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
		}
		if (null!=xmlx) {
			DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
			projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));			
			projectProfileDQ.add(PropertyFactoryUtil.forName("xmlx").eq(xmlx));
			dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
		}
		if (!Validator.isBlank(jsdwmc)) {
			DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
			projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
			projectProfileDQ.add(PropertyFactoryUtil.forName("jsdwmc").like("%" + jsdwmc + "%"));
			dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
		}
		String[] ss = {"国家部委或中央单位","市级机关或市级单位","其他"};
		String[] qs = {"区县级机关或区县级单位"};
		if(gs.equals("市属")){
			if (!Validator.isBlank(status)) {
				if("wtj".equals(status)){
					int[] values = {1,4,6};
					DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ.add(PropertyFactoryUtil.forName("lxjb").like("%" + ss[1] + "%"));
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
					dynamicQuery.add(PropertyFactoryUtil.forName("status").in(values));
				}else if("ytj".equals(status)){
					int[] values = {2,3,5,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
					DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ.add(PropertyFactoryUtil.forName("lxjb").like("%" + ss[1] + "%"));
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
					dynamicQuery.add(PropertyFactoryUtil.forName("status").in(values));
				}
			}
		}else if(gs.equals("区属")){
			if (!Validator.isBlank(status)) {
				if("wtj".equals(status)){
					int[] values = {1,4};
					DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ.add(PropertyFactoryUtil.forName("lxjb").like("%" + qs[0] + "%"));
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
					dynamicQuery.add(PropertyFactoryUtil.forName("status").in(values));
				}else if("ytj".equals(status)){
					int[] values = {2,3,5,6,7,8,9};
					DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ.add(PropertyFactoryUtil.forName("lxjb").like("%" + qs[0] + "%"));
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
					dynamicQuery.add(PropertyFactoryUtil.forName("status").in(values));
				}
			}
		}
		return dynamicQuery;
	}
}
