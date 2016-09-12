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

package com.justonetech.cp.permit.model;

import com.justonetech.cp.permit.service.ClpSerializer;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fanqi
 */
public class PermitClp extends BaseModelImpl<Permit> implements Permit {
	public PermitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Permit.class;
	}

	@Override
	public String getModelClassName() {
		return Permit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _permitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPermitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _permitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("permitId", getPermitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("zzjgdm", getZzjgdm());
		attributes.put("bjbh", getBjbh());
		attributes.put("htxxbsbh", getHtxxbsbh());
		attributes.put("sqbz", getSqbz());
		attributes.put("sqzt", getSqzt());
		attributes.put("bdh", getBdh());
		attributes.put("ywbh", getYwbh());
		attributes.put("sgxkzbh", getSgxkzbh());
		attributes.put("slbh", getSlbh());
		attributes.put("hjgsz", getHjgsz());
		attributes.put("hjgsh", getHjgsh());
		attributes.put("sqr", getSqr());
		attributes.put("sqsx", getSqsx());
		attributes.put("sqh", getSqh());
		attributes.put("cltjr", getCltjr());
		attributes.put("cltjrlxdh", getCltjrlxdh());
		attributes.put("cltjrlxdz", getCltjrlxdz());
		attributes.put("sjr", getSjr());
		attributes.put("sjrlxdh", getSjrlxdh());
		attributes.put("slyj", getSlyj());
		attributes.put("slsj", getSlsj());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String zzjgdm = (String)attributes.get("zzjgdm");

		if (zzjgdm != null) {
			setZzjgdm(zzjgdm);
		}

		String bjbh = (String)attributes.get("bjbh");

		if (bjbh != null) {
			setBjbh(bjbh);
		}

		String htxxbsbh = (String)attributes.get("htxxbsbh");

		if (htxxbsbh != null) {
			setHtxxbsbh(htxxbsbh);
		}

		Integer sqbz = (Integer)attributes.get("sqbz");

		if (sqbz != null) {
			setSqbz(sqbz);
		}

		Integer sqzt = (Integer)attributes.get("sqzt");

		if (sqzt != null) {
			setSqzt(sqzt);
		}

		String bdh = (String)attributes.get("bdh");

		if (bdh != null) {
			setBdh(bdh);
		}

		String ywbh = (String)attributes.get("ywbh");

		if (ywbh != null) {
			setYwbh(ywbh);
		}

		String sgxkzbh = (String)attributes.get("sgxkzbh");

		if (sgxkzbh != null) {
			setSgxkzbh(sgxkzbh);
		}

		String slbh = (String)attributes.get("slbh");

		if (slbh != null) {
			setSlbh(slbh);
		}

		Integer hjgsz = (Integer)attributes.get("hjgsz");

		if (hjgsz != null) {
			setHjgsz(hjgsz);
		}

		Integer hjgsh = (Integer)attributes.get("hjgsh");

		if (hjgsh != null) {
			setHjgsh(hjgsh);
		}

		String sqr = (String)attributes.get("sqr");

		if (sqr != null) {
			setSqr(sqr);
		}

		String sqsx = (String)attributes.get("sqsx");

		if (sqsx != null) {
			setSqsx(sqsx);
		}

		String sqh = (String)attributes.get("sqh");

		if (sqh != null) {
			setSqh(sqh);
		}

		String cltjr = (String)attributes.get("cltjr");

		if (cltjr != null) {
			setCltjr(cltjr);
		}

		String cltjrlxdh = (String)attributes.get("cltjrlxdh");

		if (cltjrlxdh != null) {
			setCltjrlxdh(cltjrlxdh);
		}

		String cltjrlxdz = (String)attributes.get("cltjrlxdz");

		if (cltjrlxdz != null) {
			setCltjrlxdz(cltjrlxdz);
		}

		String sjr = (String)attributes.get("sjr");

		if (sjr != null) {
			setSjr(sjr);
		}

		String sjrlxdh = (String)attributes.get("sjrlxdh");

		if (sjrlxdh != null) {
			setSjrlxdh(sjrlxdh);
		}

		String slyj = (String)attributes.get("slyj");

		if (slyj != null) {
			setSlyj(slyj);
		}

		String slsj = (String)attributes.get("slsj");

		if (slsj != null) {
			setSlsj(slsj);
		}
	}

	@Override
	public long getPermitId() {
		return _permitId;
	}

	@Override
	public void setPermitId(long permitId) {
		_permitId = permitId;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setPermitId", long.class);

				method.invoke(_permitRemoteModel, permitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_permitRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_permitRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_permitRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_permitRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_permitRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_permitRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZzjgdm() {
		return _zzjgdm;
	}

	@Override
	public void setZzjgdm(String zzjgdm) {
		_zzjgdm = zzjgdm;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setZzjgdm", String.class);

				method.invoke(_permitRemoteModel, zzjgdm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBjbh() {
		return _bjbh;
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setBjbh", String.class);

				method.invoke(_permitRemoteModel, bjbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtxxbsbh() {
		return _htxxbsbh;
	}

	@Override
	public void setHtxxbsbh(String htxxbsbh) {
		_htxxbsbh = htxxbsbh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setHtxxbsbh", String.class);

				method.invoke(_permitRemoteModel, htxxbsbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSqbz() {
		return _sqbz;
	}

	@Override
	public void setSqbz(int sqbz) {
		_sqbz = sqbz;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSqbz", int.class);

				method.invoke(_permitRemoteModel, sqbz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSqzt() {
		return _sqzt;
	}

	@Override
	public void setSqzt(int sqzt) {
		_sqzt = sqzt;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSqzt", int.class);

				method.invoke(_permitRemoteModel, sqzt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBdh() {
		return _bdh;
	}

	@Override
	public void setBdh(String bdh) {
		_bdh = bdh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setBdh", String.class);

				method.invoke(_permitRemoteModel, bdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYwbh() {
		return _ywbh;
	}

	@Override
	public void setYwbh(String ywbh) {
		_ywbh = ywbh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setYwbh", String.class);

				method.invoke(_permitRemoteModel, ywbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSgxkzbh() {
		return _sgxkzbh;
	}

	@Override
	public void setSgxkzbh(String sgxkzbh) {
		_sgxkzbh = sgxkzbh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSgxkzbh", String.class);

				method.invoke(_permitRemoteModel, sgxkzbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSlbh() {
		return _slbh;
	}

	@Override
	public void setSlbh(String slbh) {
		_slbh = slbh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSlbh", String.class);

				method.invoke(_permitRemoteModel, slbh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHjgsz() {
		return _hjgsz;
	}

	@Override
	public void setHjgsz(int hjgsz) {
		_hjgsz = hjgsz;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setHjgsz", int.class);

				method.invoke(_permitRemoteModel, hjgsz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHjgsh() {
		return _hjgsh;
	}

	@Override
	public void setHjgsh(int hjgsh) {
		_hjgsh = hjgsh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setHjgsh", int.class);

				method.invoke(_permitRemoteModel, hjgsh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSqr() {
		return _sqr;
	}

	@Override
	public void setSqr(String sqr) {
		_sqr = sqr;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSqr", String.class);

				method.invoke(_permitRemoteModel, sqr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSqsx() {
		return _sqsx;
	}

	@Override
	public void setSqsx(String sqsx) {
		_sqsx = sqsx;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSqsx", String.class);

				method.invoke(_permitRemoteModel, sqsx);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSqh() {
		return _sqh;
	}

	@Override
	public void setSqh(String sqh) {
		_sqh = sqh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSqh", String.class);

				method.invoke(_permitRemoteModel, sqh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCltjr() {
		return _cltjr;
	}

	@Override
	public void setCltjr(String cltjr) {
		_cltjr = cltjr;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setCltjr", String.class);

				method.invoke(_permitRemoteModel, cltjr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCltjrlxdh() {
		return _cltjrlxdh;
	}

	@Override
	public void setCltjrlxdh(String cltjrlxdh) {
		_cltjrlxdh = cltjrlxdh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setCltjrlxdh", String.class);

				method.invoke(_permitRemoteModel, cltjrlxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCltjrlxdz() {
		return _cltjrlxdz;
	}

	@Override
	public void setCltjrlxdz(String cltjrlxdz) {
		_cltjrlxdz = cltjrlxdz;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setCltjrlxdz", String.class);

				method.invoke(_permitRemoteModel, cltjrlxdz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjr() {
		return _sjr;
	}

	@Override
	public void setSjr(String sjr) {
		_sjr = sjr;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSjr", String.class);

				method.invoke(_permitRemoteModel, sjr);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSjrlxdh() {
		return _sjrlxdh;
	}

	@Override
	public void setSjrlxdh(String sjrlxdh) {
		_sjrlxdh = sjrlxdh;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSjrlxdh", String.class);

				method.invoke(_permitRemoteModel, sjrlxdh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSlyj() {
		return _slyj;
	}

	@Override
	public void setSlyj(String slyj) {
		_slyj = slyj;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSlyj", String.class);

				method.invoke(_permitRemoteModel, slyj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSlsj() {
		return _slsj;
	}

	@Override
	public void setSlsj(String slsj) {
		_slsj = slsj;

		if (_permitRemoteModel != null) {
			try {
				Class<?> clazz = _permitRemoteModel.getClass();

				Method method = clazz.getMethod("setSlsj", String.class);

				method.invoke(_permitRemoteModel, slsj);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPermitRemoteModel() {
		return _permitRemoteModel;
	}

	public void setPermitRemoteModel(BaseModel<?> permitRemoteModel) {
		_permitRemoteModel = permitRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _permitRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_permitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PermitLocalServiceUtil.addPermit(this);
		}
		else {
			PermitLocalServiceUtil.updatePermit(this);
		}
	}

	@Override
	public Permit toEscapedModel() {
		return (Permit)ProxyUtil.newProxyInstance(Permit.class.getClassLoader(),
			new Class[] { Permit.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PermitClp clone = new PermitClp();

		clone.setPermitId(getPermitId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setZzjgdm(getZzjgdm());
		clone.setBjbh(getBjbh());
		clone.setHtxxbsbh(getHtxxbsbh());
		clone.setSqbz(getSqbz());
		clone.setSqzt(getSqzt());
		clone.setBdh(getBdh());
		clone.setYwbh(getYwbh());
		clone.setSgxkzbh(getSgxkzbh());
		clone.setSlbh(getSlbh());
		clone.setHjgsz(getHjgsz());
		clone.setHjgsh(getHjgsh());
		clone.setSqr(getSqr());
		clone.setSqsx(getSqsx());
		clone.setSqh(getSqh());
		clone.setCltjr(getCltjr());
		clone.setCltjrlxdh(getCltjrlxdh());
		clone.setCltjrlxdz(getCltjrlxdz());
		clone.setSjr(getSjr());
		clone.setSjrlxdh(getSjrlxdh());
		clone.setSlyj(getSlyj());
		clone.setSlsj(getSlsj());

		return clone;
	}

	@Override
	public int compareTo(Permit permit) {
		long primaryKey = permit.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PermitClp)) {
			return false;
		}

		PermitClp permit = (PermitClp)obj;

		long primaryKey = permit.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{permitId=");
		sb.append(getPermitId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", zzjgdm=");
		sb.append(getZzjgdm());
		sb.append(", bjbh=");
		sb.append(getBjbh());
		sb.append(", htxxbsbh=");
		sb.append(getHtxxbsbh());
		sb.append(", sqbz=");
		sb.append(getSqbz());
		sb.append(", sqzt=");
		sb.append(getSqzt());
		sb.append(", bdh=");
		sb.append(getBdh());
		sb.append(", ywbh=");
		sb.append(getYwbh());
		sb.append(", sgxkzbh=");
		sb.append(getSgxkzbh());
		sb.append(", slbh=");
		sb.append(getSlbh());
		sb.append(", hjgsz=");
		sb.append(getHjgsz());
		sb.append(", hjgsh=");
		sb.append(getHjgsh());
		sb.append(", sqr=");
		sb.append(getSqr());
		sb.append(", sqsx=");
		sb.append(getSqsx());
		sb.append(", sqh=");
		sb.append(getSqh());
		sb.append(", cltjr=");
		sb.append(getCltjr());
		sb.append(", cltjrlxdh=");
		sb.append(getCltjrlxdh());
		sb.append(", cltjrlxdz=");
		sb.append(getCltjrlxdz());
		sb.append(", sjr=");
		sb.append(getSjr());
		sb.append(", sjrlxdh=");
		sb.append(getSjrlxdh());
		sb.append(", slyj=");
		sb.append(getSlyj());
		sb.append(", slsj=");
		sb.append(getSlsj());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(88);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.permit.model.Permit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>permitId</column-name><column-value><![CDATA[");
		sb.append(getPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zzjgdm</column-name><column-value><![CDATA[");
		sb.append(getZzjgdm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bjbh</column-name><column-value><![CDATA[");
		sb.append(getBjbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htxxbsbh</column-name><column-value><![CDATA[");
		sb.append(getHtxxbsbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqbz</column-name><column-value><![CDATA[");
		sb.append(getSqbz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqzt</column-name><column-value><![CDATA[");
		sb.append(getSqzt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bdh</column-name><column-value><![CDATA[");
		sb.append(getBdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ywbh</column-name><column-value><![CDATA[");
		sb.append(getYwbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgxkzbh</column-name><column-value><![CDATA[");
		sb.append(getSgxkzbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slbh</column-name><column-value><![CDATA[");
		sb.append(getSlbh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hjgsz</column-name><column-value><![CDATA[");
		sb.append(getHjgsz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hjgsh</column-name><column-value><![CDATA[");
		sb.append(getHjgsh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqr</column-name><column-value><![CDATA[");
		sb.append(getSqr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqsx</column-name><column-value><![CDATA[");
		sb.append(getSqsx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sqh</column-name><column-value><![CDATA[");
		sb.append(getSqh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cltjr</column-name><column-value><![CDATA[");
		sb.append(getCltjr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cltjrlxdh</column-name><column-value><![CDATA[");
		sb.append(getCltjrlxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cltjrlxdz</column-name><column-value><![CDATA[");
		sb.append(getCltjrlxdz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjr</column-name><column-value><![CDATA[");
		sb.append(getSjr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sjrlxdh</column-name><column-value><![CDATA[");
		sb.append(getSjrlxdh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slyj</column-name><column-value><![CDATA[");
		sb.append(getSlyj());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slsj</column-name><column-value><![CDATA[");
		sb.append(getSlsj());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _permitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _zzjgdm;
	private String _bjbh;
	private String _htxxbsbh;
	private int _sqbz;
	private int _sqzt;
	private String _bdh;
	private String _ywbh;
	private String _sgxkzbh;
	private String _slbh;
	private int _hjgsz;
	private int _hjgsh;
	private String _sqr;
	private String _sqsx;
	private String _sqh;
	private String _cltjr;
	private String _cltjrlxdh;
	private String _cltjrlxdz;
	private String _sjr;
	private String _sjrlxdh;
	private String _slyj;
	private String _slsj;
	private BaseModel<?> _permitRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.cp.permit.service.ClpSerializer.class;
}