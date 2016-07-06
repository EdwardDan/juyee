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

package com.justonetech.oa.model.impl;

import com.justonetech.oa.model.OfficeSupplyRequisition;
import com.justonetech.oa.model.OfficeSupplyRequisitionModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OfficeSupplyRequisition service. Represents a row in the &quot;oa_OfficeSupplyRequisition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.oa.model.OfficeSupplyRequisitionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OfficeSupplyRequisitionImpl}.
 * </p>
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionImpl
 * @see com.justonetech.oa.model.OfficeSupplyRequisition
 * @see com.justonetech.oa.model.OfficeSupplyRequisitionModel
 * @generated
 */
public class OfficeSupplyRequisitionModelImpl extends BaseModelImpl<OfficeSupplyRequisition>
	implements OfficeSupplyRequisitionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a office supply requisition model instance should use the {@link com.justonetech.oa.model.OfficeSupplyRequisition} interface instead.
	 */
	public static final String TABLE_NAME = "oa_OfficeSupplyRequisition";
	public static final Object[][] TABLE_COLUMNS = {
			{ "officeSupplyRequisitionId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createTime", Types.TIMESTAMP },
			{ "modifiedTime", Types.TIMESTAMP },
			{ "deptId", Types.BIGINT },
			{ "deptName", Types.VARCHAR },
			{ "applicantId", Types.BIGINT },
			{ "applicantName", Types.VARCHAR },
			{ "introductions", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table oa_OfficeSupplyRequisition (officeSupplyRequisitionId LONG not null primary key,userId LONG,userName VARCHAR(75) null,createTime DATE null,modifiedTime DATE null,deptId LONG,deptName VARCHAR(75) null,applicantId LONG,applicantName VARCHAR(75) null,introductions VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table oa_OfficeSupplyRequisition";
	public static final String ORDER_BY_JPQL = " ORDER BY officeSupplyRequisition.modifiedTime DESC";
	public static final String ORDER_BY_SQL = " ORDER BY oa_OfficeSupplyRequisition.modifiedTime DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.oa.model.OfficeSupplyRequisition"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.oa.model.OfficeSupplyRequisition"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.justonetech.oa.model.OfficeSupplyRequisition"),
			true);
	public static long APPLICANTNAME_COLUMN_BITMASK = 1L;
	public static long DEPTNAME_COLUMN_BITMASK = 2L;
	public static long MODIFIEDTIME_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.oa.model.OfficeSupplyRequisition"));

	public OfficeSupplyRequisitionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _officeSupplyRequisitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOfficeSupplyRequisitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _officeSupplyRequisitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OfficeSupplyRequisition.class;
	}

	@Override
	public String getModelClassName() {
		return OfficeSupplyRequisition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("officeSupplyRequisitionId",
			getOfficeSupplyRequisitionId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("deptId", getDeptId());
		attributes.put("deptName", getDeptName());
		attributes.put("applicantId", getApplicantId());
		attributes.put("applicantName", getApplicantName());
		attributes.put("introductions", getIntroductions());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long officeSupplyRequisitionId = (Long)attributes.get(
				"officeSupplyRequisitionId");

		if (officeSupplyRequisitionId != null) {
			setOfficeSupplyRequisitionId(officeSupplyRequisitionId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createTime = (Date)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Date modifiedTime = (Date)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
		}

		Long deptId = (Long)attributes.get("deptId");

		if (deptId != null) {
			setDeptId(deptId);
		}

		String deptName = (String)attributes.get("deptName");

		if (deptName != null) {
			setDeptName(deptName);
		}

		Long applicantId = (Long)attributes.get("applicantId");

		if (applicantId != null) {
			setApplicantId(applicantId);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String introductions = (String)attributes.get("introductions");

		if (introductions != null) {
			setIntroductions(introductions);
		}
	}

	@Override
	public long getOfficeSupplyRequisitionId() {
		return _officeSupplyRequisitionId;
	}

	@Override
	public void setOfficeSupplyRequisitionId(long officeSupplyRequisitionId) {
		_officeSupplyRequisitionId = officeSupplyRequisitionId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		_createTime = createTime;
	}

	@Override
	public Date getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(Date modifiedTime) {
		_columnBitmask = -1L;

		_modifiedTime = modifiedTime;
	}

	@Override
	public long getDeptId() {
		return _deptId;
	}

	@Override
	public void setDeptId(long deptId) {
		_deptId = deptId;
	}

	@Override
	public String getDeptName() {
		if (_deptName == null) {
			return StringPool.BLANK;
		}
		else {
			return _deptName;
		}
	}

	@Override
	public void setDeptName(String deptName) {
		_columnBitmask |= DEPTNAME_COLUMN_BITMASK;

		if (_originalDeptName == null) {
			_originalDeptName = _deptName;
		}

		_deptName = deptName;
	}

	public String getOriginalDeptName() {
		return GetterUtil.getString(_originalDeptName);
	}

	@Override
	public long getApplicantId() {
		return _applicantId;
	}

	@Override
	public void setApplicantId(long applicantId) {
		_applicantId = applicantId;
	}

	@Override
	public String getApplicantName() {
		if (_applicantName == null) {
			return StringPool.BLANK;
		}
		else {
			return _applicantName;
		}
	}

	@Override
	public void setApplicantName(String applicantName) {
		_columnBitmask |= APPLICANTNAME_COLUMN_BITMASK;

		if (_originalApplicantName == null) {
			_originalApplicantName = _applicantName;
		}

		_applicantName = applicantName;
	}

	public String getOriginalApplicantName() {
		return GetterUtil.getString(_originalApplicantName);
	}

	@Override
	public String getIntroductions() {
		if (_introductions == null) {
			return StringPool.BLANK;
		}
		else {
			return _introductions;
		}
	}

	@Override
	public void setIntroductions(String introductions) {
		_introductions = introductions;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			OfficeSupplyRequisition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OfficeSupplyRequisition toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OfficeSupplyRequisition)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OfficeSupplyRequisitionImpl officeSupplyRequisitionImpl = new OfficeSupplyRequisitionImpl();

		officeSupplyRequisitionImpl.setOfficeSupplyRequisitionId(getOfficeSupplyRequisitionId());
		officeSupplyRequisitionImpl.setUserId(getUserId());
		officeSupplyRequisitionImpl.setUserName(getUserName());
		officeSupplyRequisitionImpl.setCreateTime(getCreateTime());
		officeSupplyRequisitionImpl.setModifiedTime(getModifiedTime());
		officeSupplyRequisitionImpl.setDeptId(getDeptId());
		officeSupplyRequisitionImpl.setDeptName(getDeptName());
		officeSupplyRequisitionImpl.setApplicantId(getApplicantId());
		officeSupplyRequisitionImpl.setApplicantName(getApplicantName());
		officeSupplyRequisitionImpl.setIntroductions(getIntroductions());

		officeSupplyRequisitionImpl.resetOriginalValues();

		return officeSupplyRequisitionImpl;
	}

	@Override
	public int compareTo(OfficeSupplyRequisition officeSupplyRequisition) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedTime(),
				officeSupplyRequisition.getModifiedTime());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OfficeSupplyRequisition)) {
			return false;
		}

		OfficeSupplyRequisition officeSupplyRequisition = (OfficeSupplyRequisition)obj;

		long primaryKey = officeSupplyRequisition.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		OfficeSupplyRequisitionModelImpl officeSupplyRequisitionModelImpl = this;

		officeSupplyRequisitionModelImpl._originalDeptName = officeSupplyRequisitionModelImpl._deptName;

		officeSupplyRequisitionModelImpl._originalApplicantName = officeSupplyRequisitionModelImpl._applicantName;

		officeSupplyRequisitionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OfficeSupplyRequisition> toCacheModel() {
		OfficeSupplyRequisitionCacheModel officeSupplyRequisitionCacheModel = new OfficeSupplyRequisitionCacheModel();

		officeSupplyRequisitionCacheModel.officeSupplyRequisitionId = getOfficeSupplyRequisitionId();

		officeSupplyRequisitionCacheModel.userId = getUserId();

		officeSupplyRequisitionCacheModel.userName = getUserName();

		String userName = officeSupplyRequisitionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			officeSupplyRequisitionCacheModel.userName = null;
		}

		Date createTime = getCreateTime();

		if (createTime != null) {
			officeSupplyRequisitionCacheModel.createTime = createTime.getTime();
		}
		else {
			officeSupplyRequisitionCacheModel.createTime = Long.MIN_VALUE;
		}

		Date modifiedTime = getModifiedTime();

		if (modifiedTime != null) {
			officeSupplyRequisitionCacheModel.modifiedTime = modifiedTime.getTime();
		}
		else {
			officeSupplyRequisitionCacheModel.modifiedTime = Long.MIN_VALUE;
		}

		officeSupplyRequisitionCacheModel.deptId = getDeptId();

		officeSupplyRequisitionCacheModel.deptName = getDeptName();

		String deptName = officeSupplyRequisitionCacheModel.deptName;

		if ((deptName != null) && (deptName.length() == 0)) {
			officeSupplyRequisitionCacheModel.deptName = null;
		}

		officeSupplyRequisitionCacheModel.applicantId = getApplicantId();

		officeSupplyRequisitionCacheModel.applicantName = getApplicantName();

		String applicantName = officeSupplyRequisitionCacheModel.applicantName;

		if ((applicantName != null) && (applicantName.length() == 0)) {
			officeSupplyRequisitionCacheModel.applicantName = null;
		}

		officeSupplyRequisitionCacheModel.introductions = getIntroductions();

		String introductions = officeSupplyRequisitionCacheModel.introductions;

		if ((introductions != null) && (introductions.length() == 0)) {
			officeSupplyRequisitionCacheModel.introductions = null;
		}

		return officeSupplyRequisitionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{officeSupplyRequisitionId=");
		sb.append(getOfficeSupplyRequisitionId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", deptId=");
		sb.append(getDeptId());
		sb.append(", deptName=");
		sb.append(getDeptName());
		sb.append(", applicantId=");
		sb.append(getApplicantId());
		sb.append(", applicantName=");
		sb.append(getApplicantName());
		sb.append(", introductions=");
		sb.append(getIntroductions());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.OfficeSupplyRequisition");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>officeSupplyRequisitionId</column-name><column-value><![CDATA[");
		sb.append(getOfficeSupplyRequisitionId());
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
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deptId</column-name><column-value><![CDATA[");
		sb.append(getDeptId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deptName</column-name><column-value><![CDATA[");
		sb.append(getDeptName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantId</column-name><column-value><![CDATA[");
		sb.append(getApplicantId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicantName</column-name><column-value><![CDATA[");
		sb.append(getApplicantName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>introductions</column-name><column-value><![CDATA[");
		sb.append(getIntroductions());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OfficeSupplyRequisition.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			OfficeSupplyRequisition.class
		};
	private long _officeSupplyRequisitionId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private String _originalDeptName;
	private long _applicantId;
	private String _applicantName;
	private String _originalApplicantName;
	private String _introductions;
	private long _columnBitmask;
	private OfficeSupplyRequisition _escapedModel;
}