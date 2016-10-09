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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.base.PermitLocalServiceBaseImpl;
import com.justonetech.cp.project.service.impl.ProjectLocalServiceImpl;
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
	public List<Permit> getPermits(String ywbh, String bjbh, String gcmc, long[] xmlxs,String jsdwmc,String status,String gs, int start, int end) {

		try {
			return this.dynamicQuery(createDynamicQuery(ywbh, bjbh, gcmc, xmlxs,jsdwmc,status,gs), start, end);
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
	
	public int getPermitsCount(String ywbh, String bjbh, String gcmc, long[] xmlxs,String jsdwmc,String status,String gs) {

		try {
			return (int) this.dynamicQueryCount(createDynamicQuery(ywbh, bjbh, gcmc, xmlxs,jsdwmc,status,gs));
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
	
	public DynamicQuery createDynamicQuery(String ywbh, String bjbh, String gcmc, long[] xmlxs,String jsdwmc,String status,String gs) {

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
		if (xmlxs.length>0) {
			Junction junction = RestrictionsFactoryUtil.disjunction();
			for(long xmlx:xmlxs){
				DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
				projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
				projectProfileDQ.add(PropertyFactoryUtil.forName("xmlx").eq(xmlx));
				Criterion criterion = PropertyFactoryUtil.forName("permitId").in(projectProfileDQ);
				junction.add(criterion);
			}
			dynamicQuery.add(junction);
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
			Junction junction = RestrictionsFactoryUtil.disjunction();
			if (!Validator.isBlank(status)) {
				if("wtj".equals(status)){
					int ssValues = 6;
					List<Integer> qsValues = new ArrayList<Integer>();
					qsValues.add(1);
					qsValues.add(4);
					DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ.add(PropertyFactoryUtil.forName("lxjb").in(ss));
					
					Criterion criterion = PropertyFactoryUtil.forName("permitId").in(projectProfileDQ);
					criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("status", ssValues));
					junction.add(criterion);
					
					Criterion criterion_ = RestrictionsFactoryUtil.in("status", qsValues);
					junction.add(criterion_);
					dynamicQuery.add(junction);
				}else if("shz".equals(status)){
					List<Integer> ssValues = new ArrayList<Integer>();
					ssValues.add(2);
					ssValues.add(3);
					ssValues.add(5);
					ssValues.add(6);
					ssValues.add(7);
					ssValues.add(8);
					ssValues.add(9);
					ssValues.add(10);
					ssValues.add(11);
					ssValues.add(12);
					ssValues.add(13);
					ssValues.add(14);
					ssValues.add(15);
					ssValues.add(16);
					ssValues.add(17);
					List<Integer> qsValues = new ArrayList<Integer>();
					qsValues.add(2);
					qsValues.add(3);
					qsValues.add(5);
					qsValues.add(6);
					qsValues.add(8);
					qsValues.add(9);
					DynamicQuery projectProfileDQ1 = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ1.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ1.add(PropertyFactoryUtil.forName("lxjb").in(ss));
					Criterion criterion = PropertyFactoryUtil.forName("permitId").in(projectProfileDQ1);
					criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.in("status", ssValues));
					junction.add(criterion);
					DynamicQuery projectProfileDQ2 = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ2.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ2.add(PropertyFactoryUtil.forName("lxjb").in(qs));
					Criterion criterion2 = PropertyFactoryUtil.forName("permitId").in(projectProfileDQ2);
					criterion2 = RestrictionsFactoryUtil.and(criterion2, RestrictionsFactoryUtil.in("status", qsValues));
					junction.add(criterion2);
					dynamicQuery.add(junction);
				}else if("shwc".equals(status)){
					List<Integer> ssValues = new ArrayList<Integer>();
					ssValues.add(18);
					ssValues.add(19);
					List<Integer> qsValues = new ArrayList<Integer>();
					qsValues.add(7);
					DynamicQuery projectProfileDQ1 = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ1.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ1.add(PropertyFactoryUtil.forName("lxjb").in(ss));
					Criterion criterion = PropertyFactoryUtil.forName("permitId").in(projectProfileDQ1);
					criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.in("status", ssValues));
					junction.add(criterion);
					DynamicQuery projectProfileDQ2 = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
					projectProfileDQ2.setProjection(ProjectionFactoryUtil.property("permitId"));
					projectProfileDQ2.add(PropertyFactoryUtil.forName("lxjb").in(qs));
					Criterion criterion2 = PropertyFactoryUtil.forName("permitId").in(projectProfileDQ2);
					criterion2 = RestrictionsFactoryUtil.and(criterion2, RestrictionsFactoryUtil.in("status", qsValues));
					junction.add(criterion2);
					dynamicQuery.add(junction);
				}
			}
		}else if(gs.equals("区属")){
			if (!Validator.isBlank(status)) {
				DynamicQuery projectProfileDQ = DynamicQueryFactoryUtil.forClass(ProjectProfile.class);
				projectProfileDQ.setProjection(ProjectionFactoryUtil.property("permitId"));
				projectProfileDQ.add(PropertyFactoryUtil.forName("lxjb").in(qs));
				if("wtj".equals(status)){
					int[] values = {1,4};
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
					dynamicQuery.add(PropertyFactoryUtil.forName("status").in(values));
				}else if("shz".equals(status)){
					int[] values = {2,3,5,6,8,9};
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
					dynamicQuery.add(PropertyFactoryUtil.forName("status").in(values));
				}else if("shwc".equals(status)){
					int[] values = {7};
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
					dynamicQuery.add(PropertyFactoryUtil.forName("status").in(values));
				}else{
					dynamicQuery.add(PropertyFactoryUtil.forName("permitId").in(projectProfileDQ));
				}
			}
		}else{
				dynamicQuery.add(PropertyFactoryUtil.forName("status").eq("-1"));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.desc("permitId"));
		return dynamicQuery;
	}
}
