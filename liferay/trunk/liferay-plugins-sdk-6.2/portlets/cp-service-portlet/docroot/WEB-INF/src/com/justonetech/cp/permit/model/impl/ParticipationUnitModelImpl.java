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

import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.ParticipationUnitModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ParticipationUnit service. Represents a row in the &quot;cp_ParticipationUnit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.cp.permit.model.ParticipationUnitModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ParticipationUnitImpl}.
 * </p>
 *
 * @author fanqi
 * @see ParticipationUnitImpl
 * @see com.justonetech.cp.permit.model.ParticipationUnit
 * @see com.justonetech.cp.permit.model.ParticipationUnitModel
 * @generated
 */
public class ParticipationUnitModelImpl extends BaseModelImpl<ParticipationUnit>
	implements ParticipationUnitModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a participation unit model instance should use the {@link com.justonetech.cp.permit.model.ParticipationUnit} interface instead.
	 */
	public static final String TABLE_NAME = "cp_ParticipationUnit";
	public static final Object[][] TABLE_COLUMNS = {
			{ "unitId", Types.BIGINT },
			{ "permitId", Types.BIGINT },
			{ "dwlx", Types.VARCHAR },
			{ "dwmc", Types.VARCHAR },
			{ "xmfzr", Types.VARCHAR },
			{ "dhhm", Types.VARCHAR },
			{ "zjlx", Types.VARCHAR },
			{ "zjh", Types.VARCHAR },
			{ "sfyssj", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table cp_ParticipationUnit (unitId LONG not null primary key,permitId LONG,dwlx VARCHAR(75) null,dwmc VARCHAR(75) null,xmfzr VARCHAR(75) null,dhhm VARCHAR(75) null,zjlx VARCHAR(75) null,zjh VARCHAR(75) null,sfyssj BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table cp_ParticipationUnit";
	public static final String ORDER_BY_JPQL = " ORDER BY participationUnit.unitId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY cp_ParticipationUnit.unitId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.cp.permit.model.ParticipationUnit"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.cp.permit.model.ParticipationUnit"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.justonetech.cp.permit.model.ParticipationUnit"),
			true);
	public static long PERMITID_COLUMN_BITMASK = 1L;
	public static long UNITID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.cp.permit.model.ParticipationUnit"));

	public ParticipationUnitModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _unitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUnitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _unitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ParticipationUnit.class;
	}

	@Override
	public String getModelClassName() {
		return ParticipationUnit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("unitId", getUnitId());
		attributes.put("permitId", getPermitId());
		attributes.put("dwlx", getDwlx());
		attributes.put("dwmc", getDwmc());
		attributes.put("xmfzr", getXmfzr());
		attributes.put("dhhm", getDhhm());
		attributes.put("zjlx", getZjlx());
		attributes.put("zjh", getZjh());
		attributes.put("sfyssj", getSfyssj());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		Long permitId = (Long)attributes.get("permitId");

		if (permitId != null) {
			setPermitId(permitId);
		}

		String dwlx = (String)attributes.get("dwlx");

		if (dwlx != null) {
			setDwlx(dwlx);
		}

		String dwmc = (String)attributes.get("dwmc");

		if (dwmc != null) {
			setDwmc(dwmc);
		}

		String xmfzr = (String)attributes.get("xmfzr");

		if (xmfzr != null) {
			setXmfzr(xmfzr);
		}

		String dhhm = (String)attributes.get("dhhm");

		if (dhhm != null) {
			setDhhm(dhhm);
		}

		String zjlx = (String)attributes.get("zjlx");

		if (zjlx != null) {
			setZjlx(zjlx);
		}

		String zjh = (String)attributes.get("zjh");

		if (zjh != null) {
			setZjh(zjh);
		}

		Boolean sfyssj = (Boolean)attributes.get("sfyssj");

		if (sfyssj != null) {
			setSfyssj(sfyssj);
		}
	}

	@Override
	public long getUnitId() {
		return _unitId;
	}

	@Override
	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	@Override
	public long getPermitId() {
		return _permitId;
	}

	@Override
	public void setPermitId(long permitId) {
		_columnBitmask |= PERMITID_COLUMN_BITMASK;

		if (!_setOriginalPermitId) {
			_setOriginalPermitId = true;

			_originalPermitId = _permitId;
		}

		_permitId = permitId;
	}

	public long getOriginalPermitId() {
		return _originalPermitId;
	}

	@Override
	public String getDwlx() {
		if (_dwlx == null) {
			return StringPool.BLANK;
		}
		else {
			return _dwlx;
		}
	}

	@Override
	public void setDwlx(String dwlx) {
		_dwlx = dwlx;
	}

	@Override
	public String getDwmc() {
		if (_dwmc == null) {
			return StringPool.BLANK;
		}
		else {
			return _dwmc;
		}
	}

	@Override
	public void setDwmc(String dwmc) {
		_dwmc = dwmc;
	}

	@Override
	public String getXmfzr() {
		if (_xmfzr == null) {
			return StringPool.BLANK;
		}
		else {
			return _xmfzr;
		}
	}

	@Override
	public void setXmfzr(String xmfzr) {
		_xmfzr = xmfzr;
	}

	@Override
	public String getDhhm() {
		if (_dhhm == null) {
			return StringPool.BLANK;
		}
		else {
			return _dhhm;
		}
	}

	@Override
	public void setDhhm(String dhhm) {
		_dhhm = dhhm;
	}

	@Override
	public String getZjlx() {
		if (_zjlx == null) {
			return StringPool.BLANK;
		}
		else {
			return _zjlx;
		}
	}

	@Override
	public void setZjlx(String zjlx) {
		_zjlx = zjlx;
	}

	@Override
	public String getZjh() {
		if (_zjh == null) {
			return StringPool.BLANK;
		}
		else {
			return _zjh;
		}
	}

	@Override
	public void setZjh(String zjh) {
		_zjh = zjh;
	}

	@Override
	public boolean getSfyssj() {
		return _sfyssj;
	}

	@Override
	public boolean isSfyssj() {
		return _sfyssj;
	}

	@Override
	public void setSfyssj(boolean sfyssj) {
		_sfyssj = sfyssj;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ParticipationUnit.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ParticipationUnit toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ParticipationUnit)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ParticipationUnitImpl participationUnitImpl = new ParticipationUnitImpl();

		participationUnitImpl.setUnitId(getUnitId());
		participationUnitImpl.setPermitId(getPermitId());
		participationUnitImpl.setDwlx(getDwlx());
		participationUnitImpl.setDwmc(getDwmc());
		participationUnitImpl.setXmfzr(getXmfzr());
		participationUnitImpl.setDhhm(getDhhm());
		participationUnitImpl.setZjlx(getZjlx());
		participationUnitImpl.setZjh(getZjh());
		participationUnitImpl.setSfyssj(getSfyssj());

		participationUnitImpl.resetOriginalValues();

		return participationUnitImpl;
	}

	@Override
	public int compareTo(ParticipationUnit participationUnit) {
		long primaryKey = participationUnit.getPrimaryKey();

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

		if (!(obj instanceof ParticipationUnit)) {
			return false;
		}

		ParticipationUnit participationUnit = (ParticipationUnit)obj;

		long primaryKey = participationUnit.getPrimaryKey();

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
		ParticipationUnitModelImpl participationUnitModelImpl = this;

		participationUnitModelImpl._originalPermitId = participationUnitModelImpl._permitId;

		participationUnitModelImpl._setOriginalPermitId = false;

		participationUnitModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ParticipationUnit> toCacheModel() {
		ParticipationUnitCacheModel participationUnitCacheModel = new ParticipationUnitCacheModel();

		participationUnitCacheModel.unitId = getUnitId();

		participationUnitCacheModel.permitId = getPermitId();

		participationUnitCacheModel.dwlx = getDwlx();

		String dwlx = participationUnitCacheModel.dwlx;

		if ((dwlx != null) && (dwlx.length() == 0)) {
			participationUnitCacheModel.dwlx = null;
		}

		participationUnitCacheModel.dwmc = getDwmc();

		String dwmc = participationUnitCacheModel.dwmc;

		if ((dwmc != null) && (dwmc.length() == 0)) {
			participationUnitCacheModel.dwmc = null;
		}

		participationUnitCacheModel.xmfzr = getXmfzr();

		String xmfzr = participationUnitCacheModel.xmfzr;

		if ((xmfzr != null) && (xmfzr.length() == 0)) {
			participationUnitCacheModel.xmfzr = null;
		}

		participationUnitCacheModel.dhhm = getDhhm();

		String dhhm = participationUnitCacheModel.dhhm;

		if ((dhhm != null) && (dhhm.length() == 0)) {
			participationUnitCacheModel.dhhm = null;
		}

		participationUnitCacheModel.zjlx = getZjlx();

		String zjlx = participationUnitCacheModel.zjlx;

		if ((zjlx != null) && (zjlx.length() == 0)) {
			participationUnitCacheModel.zjlx = null;
		}

		participationUnitCacheModel.zjh = getZjh();

		String zjh = participationUnitCacheModel.zjh;

		if ((zjh != null) && (zjh.length() == 0)) {
			participationUnitCacheModel.zjh = null;
		}

		participationUnitCacheModel.sfyssj = getSfyssj();

		return participationUnitCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{unitId=");
		sb.append(getUnitId());
		sb.append(", permitId=");
		sb.append(getPermitId());
		sb.append(", dwlx=");
		sb.append(getDwlx());
		sb.append(", dwmc=");
		sb.append(getDwmc());
		sb.append(", xmfzr=");
		sb.append(getXmfzr());
		sb.append(", dhhm=");
		sb.append(getDhhm());
		sb.append(", zjlx=");
		sb.append(getZjlx());
		sb.append(", zjh=");
		sb.append(getZjh());
		sb.append(", sfyssj=");
		sb.append(getSfyssj());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.cp.permit.model.ParticipationUnit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>unitId</column-name><column-value><![CDATA[");
		sb.append(getUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permitId</column-name><column-value><![CDATA[");
		sb.append(getPermitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dwlx</column-name><column-value><![CDATA[");
		sb.append(getDwlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dwmc</column-name><column-value><![CDATA[");
		sb.append(getDwmc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xmfzr</column-name><column-value><![CDATA[");
		sb.append(getXmfzr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dhhm</column-name><column-value><![CDATA[");
		sb.append(getDhhm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjlx</column-name><column-value><![CDATA[");
		sb.append(getZjlx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zjh</column-name><column-value><![CDATA[");
		sb.append(getZjh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sfyssj</column-name><column-value><![CDATA[");
		sb.append(getSfyssj());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ParticipationUnit.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ParticipationUnit.class
		};
	private long _unitId;
	private long _permitId;
	private long _originalPermitId;
	private boolean _setOriginalPermitId;
	private String _dwlx;
	private String _dwmc;
	private String _xmfzr;
	private String _dhhm;
	private String _zjlx;
	private String _zjh;
	private boolean _sfyssj;
	private long _columnBitmask;
	private ParticipationUnit _escapedModel;
}