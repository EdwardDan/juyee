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

import com.justonetech.oa.model.DeptWork;
import com.justonetech.oa.model.DeptWorkModel;

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
 * The base model implementation for the DeptWork service. Represents a row in the &quot;oa_DeptWork&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.oa.model.DeptWorkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DeptWorkImpl}.
 * </p>
 *
 * @author justonetech
 * @see DeptWorkImpl
 * @see com.justonetech.oa.model.DeptWork
 * @see com.justonetech.oa.model.DeptWorkModel
 * @generated
 */
public class DeptWorkModelImpl extends BaseModelImpl<DeptWork>
	implements DeptWorkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dept work model instance should use the {@link com.justonetech.oa.model.DeptWork} interface instead.
	 */
	public static final String TABLE_NAME = "oa_DeptWork";
	public static final Object[][] TABLE_COLUMNS = {
			{ "deptWorkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createTime", Types.TIMESTAMP },
			{ "modifiedTime", Types.TIMESTAMP },
			{ "deptId", Types.BIGINT },
			{ "deptName", Types.VARCHAR },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "status", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table oa_DeptWork (deptWorkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createTime DATE null,modifiedTime DATE null,deptId LONG,deptName VARCHAR(75) null,startDate DATE null,endDate DATE null,status VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table oa_DeptWork";
	public static final String ORDER_BY_JPQL = " ORDER BY deptWork.modifiedTime DESC";
	public static final String ORDER_BY_SQL = " ORDER BY oa_DeptWork.modifiedTime DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.oa.model.DeptWork"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.oa.model.DeptWork"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.justonetech.oa.model.DeptWork"),
			true);
	public static long DEPTNAME_COLUMN_BITMASK = 1L;
	public static long USERNAME_COLUMN_BITMASK = 2L;
	public static long MODIFIEDTIME_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.oa.model.DeptWork"));

	public DeptWorkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _deptWorkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDeptWorkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deptWorkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DeptWork.class;
	}

	@Override
	public String getModelClassName() {
		return DeptWork.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deptWorkId", getDeptWorkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("deptId", getDeptId());
		attributes.put("deptName", getDeptName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long deptWorkId = (Long)attributes.get("deptWorkId");

		if (deptWorkId != null) {
			setDeptWorkId(deptWorkId);
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

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getDeptWorkId() {
		return _deptWorkId;
	}

	@Override
	public void setDeptWorkId(long deptWorkId) {
		_deptWorkId = deptWorkId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
		_columnBitmask |= USERNAME_COLUMN_BITMASK;

		if (_originalUserName == null) {
			_originalUserName = _userName;
		}

		_userName = userName;
	}

	public String getOriginalUserName() {
		return GetterUtil.getString(_originalUserName);
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
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			DeptWork.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DeptWork toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (DeptWork)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DeptWorkImpl deptWorkImpl = new DeptWorkImpl();

		deptWorkImpl.setDeptWorkId(getDeptWorkId());
		deptWorkImpl.setGroupId(getGroupId());
		deptWorkImpl.setCompanyId(getCompanyId());
		deptWorkImpl.setUserId(getUserId());
		deptWorkImpl.setUserName(getUserName());
		deptWorkImpl.setCreateTime(getCreateTime());
		deptWorkImpl.setModifiedTime(getModifiedTime());
		deptWorkImpl.setDeptId(getDeptId());
		deptWorkImpl.setDeptName(getDeptName());
		deptWorkImpl.setStartDate(getStartDate());
		deptWorkImpl.setEndDate(getEndDate());
		deptWorkImpl.setStatus(getStatus());

		deptWorkImpl.resetOriginalValues();

		return deptWorkImpl;
	}

	@Override
	public int compareTo(DeptWork deptWork) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedTime(), deptWork.getModifiedTime());

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

		if (!(obj instanceof DeptWork)) {
			return false;
		}

		DeptWork deptWork = (DeptWork)obj;

		long primaryKey = deptWork.getPrimaryKey();

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
		DeptWorkModelImpl deptWorkModelImpl = this;

		deptWorkModelImpl._originalUserName = deptWorkModelImpl._userName;

		deptWorkModelImpl._originalDeptName = deptWorkModelImpl._deptName;

		deptWorkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DeptWork> toCacheModel() {
		DeptWorkCacheModel deptWorkCacheModel = new DeptWorkCacheModel();

		deptWorkCacheModel.deptWorkId = getDeptWorkId();

		deptWorkCacheModel.groupId = getGroupId();

		deptWorkCacheModel.companyId = getCompanyId();

		deptWorkCacheModel.userId = getUserId();

		deptWorkCacheModel.userName = getUserName();

		String userName = deptWorkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			deptWorkCacheModel.userName = null;
		}

		Date createTime = getCreateTime();

		if (createTime != null) {
			deptWorkCacheModel.createTime = createTime.getTime();
		}
		else {
			deptWorkCacheModel.createTime = Long.MIN_VALUE;
		}

		Date modifiedTime = getModifiedTime();

		if (modifiedTime != null) {
			deptWorkCacheModel.modifiedTime = modifiedTime.getTime();
		}
		else {
			deptWorkCacheModel.modifiedTime = Long.MIN_VALUE;
		}

		deptWorkCacheModel.deptId = getDeptId();

		deptWorkCacheModel.deptName = getDeptName();

		String deptName = deptWorkCacheModel.deptName;

		if ((deptName != null) && (deptName.length() == 0)) {
			deptWorkCacheModel.deptName = null;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			deptWorkCacheModel.startDate = startDate.getTime();
		}
		else {
			deptWorkCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			deptWorkCacheModel.endDate = endDate.getTime();
		}
		else {
			deptWorkCacheModel.endDate = Long.MIN_VALUE;
		}

		deptWorkCacheModel.status = getStatus();

		String status = deptWorkCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			deptWorkCacheModel.status = null;
		}

		return deptWorkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{deptWorkId=");
		sb.append(getDeptWorkId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
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
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.oa.model.DeptWork");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>deptWorkId</column-name><column-value><![CDATA[");
		sb.append(getDeptWorkId());
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
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = DeptWork.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			DeptWork.class
		};
	private long _deptWorkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private String _originalUserName;
	private Date _createTime;
	private Date _modifiedTime;
	private long _deptId;
	private String _deptName;
	private String _originalDeptName;
	private Date _startDate;
	private Date _endDate;
	private String _status;
	private long _columnBitmask;
	private DeptWork _escapedModel;
}