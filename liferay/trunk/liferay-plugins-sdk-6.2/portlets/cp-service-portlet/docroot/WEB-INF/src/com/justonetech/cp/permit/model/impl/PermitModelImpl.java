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

package com.justonetech.cp.permit.model.impl;

import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.PermitModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
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
 * The base model implementation for the Permit service. Represents a row in the &quot;cp_Permit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.cp.permit.model.PermitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PermitImpl}.
 * </p>
 *
 * @author fanqi
 * @see PermitImpl
 * @see com.justonetech.cp.permit.model.Permit
 * @see com.justonetech.cp.permit.model.PermitModel
 * @generated
 */
public class PermitModelImpl extends BaseModelImpl<Permit>
	implements PermitModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a permit model instance should use the {@link com.justonetech.cp.permit.model.Permit} interface instead.
	 */
	public static final String TABLE_NAME = "cp_Permit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "permitId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "zzjgdm", Types.VARCHAR },
			{ "bjbh", Types.VARCHAR },
			{ "htxxbsbh", Types.VARCHAR },
			{ "sqbz", Types.INTEGER },
			{ "status", Types.INTEGER },
			{ "bdh", Types.VARCHAR },
			{ "ywbh", Types.VARCHAR },
			{ "sgxkzbh", Types.VARCHAR },
			{ "slbh", Types.VARCHAR },
			{ "hjgsz", Types.INTEGER },
			{ "hjgsh", Types.INTEGER },
			{ "sqr", Types.VARCHAR },
			{ "sqsx", Types.VARCHAR },
			{ "sqh", Types.VARCHAR },
			{ "cltjr", Types.VARCHAR },
			{ "cltjrlxdh", Types.VARCHAR },
			{ "cltjrlxdz", Types.VARCHAR },
			{ "sjr", Types.VARCHAR },
			{ "sjrlxdh", Types.VARCHAR },
			{ "slyj", Types.VARCHAR },
			{ "slsj", Types.VARCHAR },
			{ "nsgnr", Types.VARCHAR },
			{ "sgxkzFileEntryId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "content", Types.VARCHAR },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table cp_Permit (permitId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,zzjgdm VARCHAR(75) null,bjbh VARCHAR(75) null,htxxbsbh VARCHAR(75) null,sqbz INTEGER,status INTEGER,bdh VARCHAR(75) null,ywbh VARCHAR(75) null,sgxkzbh VARCHAR(75) null,slbh VARCHAR(75) null,hjgsz INTEGER,hjgsh INTEGER,sqr VARCHAR(75) null,sqsx VARCHAR(75) null,sqh VARCHAR(75) null,cltjr VARCHAR(75) null,cltjrlxdh VARCHAR(75) null,cltjrlxdz VARCHAR(75) null,sjr VARCHAR(75) null,sjrlxdh VARCHAR(75) null,slyj VARCHAR(75) null,slsj VARCHAR(75) null,nsgnr VARCHAR(100) null,sgxkzFileEntryId LONG,title VARCHAR(200) null,content VARCHAR(1000) null,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table cp_Permit";
	public static final String ORDER_BY_JPQL = " ORDER BY permit.permitId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cp_Permit.permitId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.cp.permit.model.Permit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.cp.permit.model.Permit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.justonetech.cp.permit.model.Permit"),
			true);
	public static long ZZJGDM_COLUMN_BITMASK = 1L;
	public static long PERMITID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.cp.permit.model.Permit"));

	public PermitModelImpl() {
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
	public Class<?> getModelClass() {
		return Permit.class;
	}

	@Override
	public String getModelClassName() {
		return Permit.class.getName();
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
		attributes.put("status", getStatus());
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
		attributes.put("nsgnr", getNsgnr());
		attributes.put("sgxkzFileEntryId", getSgxkzFileEntryId());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

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

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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

		String nsgnr = (String)attributes.get("nsgnr");

		if (nsgnr != null) {
			setNsgnr(nsgnr);
		}

		Long sgxkzFileEntryId = (Long)attributes.get("sgxkzFileEntryId");

		if (sgxkzFileEntryId != null) {
			setSgxkzFileEntryId(sgxkzFileEntryId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public long getPermitId() {
		return _permitId;
	}

	@Override
	public void setPermitId(long permitId) {
		_permitId = permitId;
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
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getZzjgdm() {
		if (_zzjgdm == null) {
			return StringPool.BLANK;
		}
		else {
			return _zzjgdm;
		}
	}

	@Override
	public void setZzjgdm(String zzjgdm) {
		_columnBitmask |= ZZJGDM_COLUMN_BITMASK;

		if (_originalZzjgdm == null) {
			_originalZzjgdm = _zzjgdm;
		}

		_zzjgdm = zzjgdm;
	}

	public String getOriginalZzjgdm() {
		return GetterUtil.getString(_originalZzjgdm);
	}

	@Override
	public String getBjbh() {
		if (_bjbh == null) {
			return StringPool.BLANK;
		}
		else {
			return _bjbh;
		}
	}

	@Override
	public void setBjbh(String bjbh) {
		_bjbh = bjbh;
	}

	@Override
	public String getHtxxbsbh() {
		if (_htxxbsbh == null) {
			return StringPool.BLANK;
		}
		else {
			return _htxxbsbh;
		}
	}

	@Override
	public void setHtxxbsbh(String htxxbsbh) {
		_htxxbsbh = htxxbsbh;
	}

	@Override
	public int getSqbz() {
		return _sqbz;
	}

	@Override
	public void setSqbz(int sqbz) {
		_sqbz = sqbz;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public String getBdh() {
		if (_bdh == null) {
			return StringPool.BLANK;
		}
		else {
			return _bdh;
		}
	}

	@Override
	public void setBdh(String bdh) {
		_bdh = bdh;
	}

	@Override
	public String getYwbh() {
		if (_ywbh == null) {
			return StringPool.BLANK;
		}
		else {
			return _ywbh;
		}
	}

	@Override
	public void setYwbh(String ywbh) {
		_ywbh = ywbh;
	}

	@Override
	public String getSgxkzbh() {
		if (_sgxkzbh == null) {
			return StringPool.BLANK;
		}
		else {
			return _sgxkzbh;
		}
	}

	@Override
	public void setSgxkzbh(String sgxkzbh) {
		_sgxkzbh = sgxkzbh;
	}

	@Override
	public String getSlbh() {
		if (_slbh == null) {
			return StringPool.BLANK;
		}
		else {
			return _slbh;
		}
	}

	@Override
	public void setSlbh(String slbh) {
		_slbh = slbh;
	}

	@Override
	public int getHjgsz() {
		return _hjgsz;
	}

	@Override
	public void setHjgsz(int hjgsz) {
		_hjgsz = hjgsz;
	}

	@Override
	public int getHjgsh() {
		return _hjgsh;
	}

	@Override
	public void setHjgsh(int hjgsh) {
		_hjgsh = hjgsh;
	}

	@Override
	public String getSqr() {
		if (_sqr == null) {
			return StringPool.BLANK;
		}
		else {
			return _sqr;
		}
	}

	@Override
	public void setSqr(String sqr) {
		_sqr = sqr;
	}

	@Override
	public String getSqsx() {
		if (_sqsx == null) {
			return StringPool.BLANK;
		}
		else {
			return _sqsx;
		}
	}

	@Override
	public void setSqsx(String sqsx) {
		_sqsx = sqsx;
	}

	@Override
	public String getSqh() {
		if (_sqh == null) {
			return StringPool.BLANK;
		}
		else {
			return _sqh;
		}
	}

	@Override
	public void setSqh(String sqh) {
		_sqh = sqh;
	}

	@Override
	public String getCltjr() {
		if (_cltjr == null) {
			return StringPool.BLANK;
		}
		else {
			return _cltjr;
		}
	}

	@Override
	public void setCltjr(String cltjr) {
		_cltjr = cltjr;
	}

	@Override
	public String getCltjrlxdh() {
		if (_cltjrlxdh == null) {
			return StringPool.BLANK;
		}
		else {
			return _cltjrlxdh;
		}
	}

	@Override
	public void setCltjrlxdh(String cltjrlxdh) {
		_cltjrlxdh = cltjrlxdh;
	}

	@Override
	public String getCltjrlxdz() {
		if (_cltjrlxdz == null) {
			return StringPool.BLANK;
		}
		else {
			return _cltjrlxdz;
		}
	}

	@Override
	public void setCltjrlxdz(String cltjrlxdz) {
		_cltjrlxdz = cltjrlxdz;
	}

	@Override
	public String getSjr() {
		if (_sjr == null) {
			return StringPool.BLANK;
		}
		else {
			return _sjr;
		}
	}

	@Override
	public void setSjr(String sjr) {
		_sjr = sjr;
	}

	@Override
	public String getSjrlxdh() {
		if (_sjrlxdh == null) {
			return StringPool.BLANK;
		}
		else {
			return _sjrlxdh;
		}
	}

	@Override
	public void setSjrlxdh(String sjrlxdh) {
		_sjrlxdh = sjrlxdh;
	}

	@Override
	public String getSlyj() {
		if (_slyj == null) {
			return StringPool.BLANK;
		}
		else {
			return _slyj;
		}
	}

	@Override
	public void setSlyj(String slyj) {
		_slyj = slyj;
	}

	@Override
	public String getSlsj() {
		if (_slsj == null) {
			return StringPool.BLANK;
		}
		else {
			return _slsj;
		}
	}

	@Override
	public void setSlsj(String slsj) {
		_slsj = slsj;
	}

	@Override
	public String getNsgnr() {
		if (_nsgnr == null) {
			return StringPool.BLANK;
		}
		else {
			return _nsgnr;
		}
	}

	@Override
	public void setNsgnr(String nsgnr) {
		_nsgnr = nsgnr;
	}

	@Override
	public long getSgxkzFileEntryId() {
		return _sgxkzFileEntryId;
	}

	@Override
	public void setSgxkzFileEntryId(long sgxkzFileEntryId) {
		_sgxkzFileEntryId = sgxkzFileEntryId;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Permit.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Permit toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Permit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PermitImpl permitImpl = new PermitImpl();

		permitImpl.setPermitId(getPermitId());
		permitImpl.setGroupId(getGroupId());
		permitImpl.setCompanyId(getCompanyId());
		permitImpl.setUserId(getUserId());
		permitImpl.setUserName(getUserName());
		permitImpl.setCreateDate(getCreateDate());
		permitImpl.setModifiedDate(getModifiedDate());
		permitImpl.setZzjgdm(getZzjgdm());
		permitImpl.setBjbh(getBjbh());
		permitImpl.setHtxxbsbh(getHtxxbsbh());
		permitImpl.setSqbz(getSqbz());
		permitImpl.setStatus(getStatus());
		permitImpl.setBdh(getBdh());
		permitImpl.setYwbh(getYwbh());
		permitImpl.setSgxkzbh(getSgxkzbh());
		permitImpl.setSlbh(getSlbh());
		permitImpl.setHjgsz(getHjgsz());
		permitImpl.setHjgsh(getHjgsh());
		permitImpl.setSqr(getSqr());
		permitImpl.setSqsx(getSqsx());
		permitImpl.setSqh(getSqh());
		permitImpl.setCltjr(getCltjr());
		permitImpl.setCltjrlxdh(getCltjrlxdh());
		permitImpl.setCltjrlxdz(getCltjrlxdz());
		permitImpl.setSjr(getSjr());
		permitImpl.setSjrlxdh(getSjrlxdh());
		permitImpl.setSlyj(getSlyj());
		permitImpl.setSlsj(getSlsj());
		permitImpl.setNsgnr(getNsgnr());
		permitImpl.setSgxkzFileEntryId(getSgxkzFileEntryId());
		permitImpl.setTitle(getTitle());
		permitImpl.setContent(getContent());
		permitImpl.setStatusByUserId(getStatusByUserId());
		permitImpl.setStatusByUserName(getStatusByUserName());
		permitImpl.setStatusDate(getStatusDate());

		permitImpl.resetOriginalValues();

		return permitImpl;
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

		if (!(obj instanceof Permit)) {
			return false;
		}

		Permit permit = (Permit)obj;

		long primaryKey = permit.getPrimaryKey();

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
		PermitModelImpl permitModelImpl = this;

		permitModelImpl._originalZzjgdm = permitModelImpl._zzjgdm;

		permitModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Permit> toCacheModel() {
		PermitCacheModel permitCacheModel = new PermitCacheModel();

		permitCacheModel.permitId = getPermitId();

		permitCacheModel.groupId = getGroupId();

		permitCacheModel.companyId = getCompanyId();

		permitCacheModel.userId = getUserId();

		permitCacheModel.userName = getUserName();

		String userName = permitCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			permitCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			permitCacheModel.createDate = createDate.getTime();
		}
		else {
			permitCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			permitCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			permitCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		permitCacheModel.zzjgdm = getZzjgdm();

		String zzjgdm = permitCacheModel.zzjgdm;

		if ((zzjgdm != null) && (zzjgdm.length() == 0)) {
			permitCacheModel.zzjgdm = null;
		}

		permitCacheModel.bjbh = getBjbh();

		String bjbh = permitCacheModel.bjbh;

		if ((bjbh != null) && (bjbh.length() == 0)) {
			permitCacheModel.bjbh = null;
		}

		permitCacheModel.htxxbsbh = getHtxxbsbh();

		String htxxbsbh = permitCacheModel.htxxbsbh;

		if ((htxxbsbh != null) && (htxxbsbh.length() == 0)) {
			permitCacheModel.htxxbsbh = null;
		}

		permitCacheModel.sqbz = getSqbz();

		permitCacheModel.status = getStatus();

		permitCacheModel.bdh = getBdh();

		String bdh = permitCacheModel.bdh;

		if ((bdh != null) && (bdh.length() == 0)) {
			permitCacheModel.bdh = null;
		}

		permitCacheModel.ywbh = getYwbh();

		String ywbh = permitCacheModel.ywbh;

		if ((ywbh != null) && (ywbh.length() == 0)) {
			permitCacheModel.ywbh = null;
		}

		permitCacheModel.sgxkzbh = getSgxkzbh();

		String sgxkzbh = permitCacheModel.sgxkzbh;

		if ((sgxkzbh != null) && (sgxkzbh.length() == 0)) {
			permitCacheModel.sgxkzbh = null;
		}

		permitCacheModel.slbh = getSlbh();

		String slbh = permitCacheModel.slbh;

		if ((slbh != null) && (slbh.length() == 0)) {
			permitCacheModel.slbh = null;
		}

		permitCacheModel.hjgsz = getHjgsz();

		permitCacheModel.hjgsh = getHjgsh();

		permitCacheModel.sqr = getSqr();

		String sqr = permitCacheModel.sqr;

		if ((sqr != null) && (sqr.length() == 0)) {
			permitCacheModel.sqr = null;
		}

		permitCacheModel.sqsx = getSqsx();

		String sqsx = permitCacheModel.sqsx;

		if ((sqsx != null) && (sqsx.length() == 0)) {
			permitCacheModel.sqsx = null;
		}

		permitCacheModel.sqh = getSqh();

		String sqh = permitCacheModel.sqh;

		if ((sqh != null) && (sqh.length() == 0)) {
			permitCacheModel.sqh = null;
		}

		permitCacheModel.cltjr = getCltjr();

		String cltjr = permitCacheModel.cltjr;

		if ((cltjr != null) && (cltjr.length() == 0)) {
			permitCacheModel.cltjr = null;
		}

		permitCacheModel.cltjrlxdh = getCltjrlxdh();

		String cltjrlxdh = permitCacheModel.cltjrlxdh;

		if ((cltjrlxdh != null) && (cltjrlxdh.length() == 0)) {
			permitCacheModel.cltjrlxdh = null;
		}

		permitCacheModel.cltjrlxdz = getCltjrlxdz();

		String cltjrlxdz = permitCacheModel.cltjrlxdz;

		if ((cltjrlxdz != null) && (cltjrlxdz.length() == 0)) {
			permitCacheModel.cltjrlxdz = null;
		}

		permitCacheModel.sjr = getSjr();

		String sjr = permitCacheModel.sjr;

		if ((sjr != null) && (sjr.length() == 0)) {
			permitCacheModel.sjr = null;
		}

		permitCacheModel.sjrlxdh = getSjrlxdh();

		String sjrlxdh = permitCacheModel.sjrlxdh;

		if ((sjrlxdh != null) && (sjrlxdh.length() == 0)) {
			permitCacheModel.sjrlxdh = null;
		}

		permitCacheModel.slyj = getSlyj();

		String slyj = permitCacheModel.slyj;

		if ((slyj != null) && (slyj.length() == 0)) {
			permitCacheModel.slyj = null;
		}

		permitCacheModel.slsj = getSlsj();

		String slsj = permitCacheModel.slsj;

		if ((slsj != null) && (slsj.length() == 0)) {
			permitCacheModel.slsj = null;
		}

		permitCacheModel.nsgnr = getNsgnr();

		String nsgnr = permitCacheModel.nsgnr;

		if ((nsgnr != null) && (nsgnr.length() == 0)) {
			permitCacheModel.nsgnr = null;
		}

		permitCacheModel.sgxkzFileEntryId = getSgxkzFileEntryId();

		permitCacheModel.title = getTitle();

		String title = permitCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			permitCacheModel.title = null;
		}

		permitCacheModel.content = getContent();

		String content = permitCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			permitCacheModel.content = null;
		}

		permitCacheModel.statusByUserId = getStatusByUserId();

		permitCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = permitCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			permitCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			permitCacheModel.statusDate = statusDate.getTime();
		}
		else {
			permitCacheModel.statusDate = Long.MIN_VALUE;
		}

		return permitCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(71);

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
		sb.append(", status=");
		sb.append(getStatus());
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
		sb.append(", nsgnr=");
		sb.append(getNsgnr());
		sb.append(", sgxkzFileEntryId=");
		sb.append(getSgxkzFileEntryId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(109);

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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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
		sb.append(
			"<column><column-name>nsgnr</column-name><column-value><![CDATA[");
		sb.append(getNsgnr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sgxkzFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getSgxkzFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Permit.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Permit.class };
	private long _permitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _zzjgdm;
	private String _originalZzjgdm;
	private String _bjbh;
	private String _htxxbsbh;
	private int _sqbz;
	private int _status;
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
	private String _nsgnr;
	private long _sgxkzFileEntryId;
	private String _title;
	private String _content;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private Permit _escapedModel;
}