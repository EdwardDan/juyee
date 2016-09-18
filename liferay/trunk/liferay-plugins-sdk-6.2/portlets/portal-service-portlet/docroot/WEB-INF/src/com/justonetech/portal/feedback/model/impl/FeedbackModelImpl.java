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

package com.justonetech.portal.feedback.model.impl;

import com.justonetech.portal.feedback.model.Feedback;
import com.justonetech.portal.feedback.model.FeedbackModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Feedback service. Represents a row in the &quot;portal_Feedback&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.justonetech.portal.feedback.model.FeedbackModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeedbackImpl}.
 * </p>
 *
 * @author fanqi
 * @see FeedbackImpl
 * @see com.justonetech.portal.feedback.model.Feedback
 * @see com.justonetech.portal.feedback.model.FeedbackModel
 * @generated
 */
public class FeedbackModelImpl extends BaseModelImpl<Feedback>
	implements FeedbackModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a feedback model instance should use the {@link com.justonetech.portal.feedback.model.Feedback} interface instead.
	 */
	public static final String TABLE_NAME = "portal_Feedback";
	public static final Object[][] TABLE_COLUMNS = {
			{ "feedbackId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "zt", Types.VARCHAR },
			{ "lx", Types.VARCHAR },
			{ "fkrId", Types.BIGINT },
			{ "fkrq", Types.TIMESTAMP },
			{ "fknr", Types.VARCHAR },
			{ "hfrId", Types.BIGINT },
			{ "hfrq", Types.TIMESTAMP },
			{ "hfjg", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table portal_Feedback (feedbackId LONG not null primary key,groupId LONG,companyId LONG,zt VARCHAR(75) null,lx VARCHAR(75) null,fkrId LONG,fkrq DATE null,fknr VARCHAR(75) null,hfrId LONG,hfrq DATE null,hfjg VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table portal_Feedback";
	public static final String ORDER_BY_JPQL = " ORDER BY feedback.fkrq DESC";
	public static final String ORDER_BY_SQL = " ORDER BY portal_Feedback.fkrq DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.justonetech.portal.feedback.model.Feedback"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.justonetech.portal.feedback.model.Feedback"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.justonetech.portal.feedback.model.Feedback"));

	public FeedbackModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("zt", getZt());
		attributes.put("lx", getLx());
		attributes.put("fkrId", getFkrId());
		attributes.put("fkrq", getFkrq());
		attributes.put("fknr", getFknr());
		attributes.put("hfrId", getHfrId());
		attributes.put("hfrq", getHfrq());
		attributes.put("hfjg", getHfjg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String zt = (String)attributes.get("zt");

		if (zt != null) {
			setZt(zt);
		}

		String lx = (String)attributes.get("lx");

		if (lx != null) {
			setLx(lx);
		}

		Long fkrId = (Long)attributes.get("fkrId");

		if (fkrId != null) {
			setFkrId(fkrId);
		}

		Date fkrq = (Date)attributes.get("fkrq");

		if (fkrq != null) {
			setFkrq(fkrq);
		}

		String fknr = (String)attributes.get("fknr");

		if (fknr != null) {
			setFknr(fknr);
		}

		Long hfrId = (Long)attributes.get("hfrId");

		if (hfrId != null) {
			setHfrId(hfrId);
		}

		Date hfrq = (Date)attributes.get("hfrq");

		if (hfrq != null) {
			setHfrq(hfrq);
		}

		String hfjg = (String)attributes.get("hfjg");

		if (hfjg != null) {
			setHfjg(hfjg);
		}
	}

	@Override
	public long getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
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
	public String getZt() {
		if (_zt == null) {
			return StringPool.BLANK;
		}
		else {
			return _zt;
		}
	}

	@Override
	public void setZt(String zt) {
		_zt = zt;
	}

	@Override
	public String getLx() {
		if (_lx == null) {
			return StringPool.BLANK;
		}
		else {
			return _lx;
		}
	}

	@Override
	public void setLx(String lx) {
		_lx = lx;
	}

	@Override
	public long getFkrId() {
		return _fkrId;
	}

	@Override
	public void setFkrId(long fkrId) {
		_fkrId = fkrId;
	}

	@Override
	public Date getFkrq() {
		return _fkrq;
	}

	@Override
	public void setFkrq(Date fkrq) {
		_fkrq = fkrq;
	}

	@Override
	public String getFknr() {
		if (_fknr == null) {
			return StringPool.BLANK;
		}
		else {
			return _fknr;
		}
	}

	@Override
	public void setFknr(String fknr) {
		_fknr = fknr;
	}

	@Override
	public long getHfrId() {
		return _hfrId;
	}

	@Override
	public void setHfrId(long hfrId) {
		_hfrId = hfrId;
	}

	@Override
	public Date getHfrq() {
		return _hfrq;
	}

	@Override
	public void setHfrq(Date hfrq) {
		_hfrq = hfrq;
	}

	@Override
	public String getHfjg() {
		if (_hfjg == null) {
			return StringPool.BLANK;
		}
		else {
			return _hfjg;
		}
	}

	@Override
	public void setHfjg(String hfjg) {
		_hfjg = hfjg;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Feedback.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Feedback toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Feedback)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setFeedbackId(getFeedbackId());
		feedbackImpl.setGroupId(getGroupId());
		feedbackImpl.setCompanyId(getCompanyId());
		feedbackImpl.setZt(getZt());
		feedbackImpl.setLx(getLx());
		feedbackImpl.setFkrId(getFkrId());
		feedbackImpl.setFkrq(getFkrq());
		feedbackImpl.setFknr(getFknr());
		feedbackImpl.setHfrId(getHfrId());
		feedbackImpl.setHfrq(getHfrq());
		feedbackImpl.setHfjg(getHfjg());

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int value = 0;

		value = DateUtil.compareTo(getFkrq(), feedback.getFkrq());

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

		if (!(obj instanceof Feedback)) {
			return false;
		}

		Feedback feedback = (Feedback)obj;

		long primaryKey = feedback.getPrimaryKey();

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
	}

	@Override
	public CacheModel<Feedback> toCacheModel() {
		FeedbackCacheModel feedbackCacheModel = new FeedbackCacheModel();

		feedbackCacheModel.feedbackId = getFeedbackId();

		feedbackCacheModel.groupId = getGroupId();

		feedbackCacheModel.companyId = getCompanyId();

		feedbackCacheModel.zt = getZt();

		String zt = feedbackCacheModel.zt;

		if ((zt != null) && (zt.length() == 0)) {
			feedbackCacheModel.zt = null;
		}

		feedbackCacheModel.lx = getLx();

		String lx = feedbackCacheModel.lx;

		if ((lx != null) && (lx.length() == 0)) {
			feedbackCacheModel.lx = null;
		}

		feedbackCacheModel.fkrId = getFkrId();

		Date fkrq = getFkrq();

		if (fkrq != null) {
			feedbackCacheModel.fkrq = fkrq.getTime();
		}
		else {
			feedbackCacheModel.fkrq = Long.MIN_VALUE;
		}

		feedbackCacheModel.fknr = getFknr();

		String fknr = feedbackCacheModel.fknr;

		if ((fknr != null) && (fknr.length() == 0)) {
			feedbackCacheModel.fknr = null;
		}

		feedbackCacheModel.hfrId = getHfrId();

		Date hfrq = getHfrq();

		if (hfrq != null) {
			feedbackCacheModel.hfrq = hfrq.getTime();
		}
		else {
			feedbackCacheModel.hfrq = Long.MIN_VALUE;
		}

		feedbackCacheModel.hfjg = getHfjg();

		String hfjg = feedbackCacheModel.hfjg;

		if ((hfjg != null) && (hfjg.length() == 0)) {
			feedbackCacheModel.hfjg = null;
		}

		return feedbackCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{feedbackId=");
		sb.append(getFeedbackId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", zt=");
		sb.append(getZt());
		sb.append(", lx=");
		sb.append(getLx());
		sb.append(", fkrId=");
		sb.append(getFkrId());
		sb.append(", fkrq=");
		sb.append(getFkrq());
		sb.append(", fknr=");
		sb.append(getFknr());
		sb.append(", hfrId=");
		sb.append(getHfrId());
		sb.append(", hfrq=");
		sb.append(getHfrq());
		sb.append(", hfjg=");
		sb.append(getHfjg());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.portal.feedback.model.Feedback");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
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
			"<column><column-name>zt</column-name><column-value><![CDATA[");
		sb.append(getZt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lx</column-name><column-value><![CDATA[");
		sb.append(getLx());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fkrId</column-name><column-value><![CDATA[");
		sb.append(getFkrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fkrq</column-name><column-value><![CDATA[");
		sb.append(getFkrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fknr</column-name><column-value><![CDATA[");
		sb.append(getFknr());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hfrId</column-name><column-value><![CDATA[");
		sb.append(getHfrId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hfrq</column-name><column-value><![CDATA[");
		sb.append(getHfrq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hfjg</column-name><column-value><![CDATA[");
		sb.append(getHfjg());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Feedback.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Feedback.class
		};
	private long _feedbackId;
	private long _groupId;
	private long _companyId;
	private String _zt;
	private String _lx;
	private long _fkrId;
	private Date _fkrq;
	private String _fknr;
	private long _hfrId;
	private Date _hfrq;
	private String _hfjg;
	private Feedback _escapedModel;
}