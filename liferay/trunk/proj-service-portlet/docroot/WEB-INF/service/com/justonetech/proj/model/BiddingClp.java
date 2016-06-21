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

package com.justonetech.proj.model;

import com.justonetech.proj.service.BiddingLocalServiceUtil;
import com.justonetech.proj.service.ClpSerializer;

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
public class BiddingClp extends BaseModelImpl<Bidding> implements Bidding {
	public BiddingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Bidding.class;
	}

	@Override
	public String getModelClassName() {
		return Bidding.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _biddingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBiddingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _biddingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("biddingId", getBiddingId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("bidCode", getBidCode());
		attributes.put("sortNo", getSortNo());
		attributes.put("bidName", getBidName());
		attributes.put("bidCategoryCode", getBidCategoryCode());
		attributes.put("buildMileage", getBuildMileage());
		attributes.put("involveCounty", getInvolveCounty());
		attributes.put("projLinkman", getProjLinkman());
		attributes.put("linkTel", getLinkTel());
		attributes.put("startDate", getStartDate());
		attributes.put("projectId", getProjectId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long biddingId = (Long)attributes.get("biddingId");

		if (biddingId != null) {
			setBiddingId(biddingId);
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

		String bidCode = (String)attributes.get("bidCode");

		if (bidCode != null) {
			setBidCode(bidCode);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String bidName = (String)attributes.get("bidName");

		if (bidName != null) {
			setBidName(bidName);
		}

		String bidCategoryCode = (String)attributes.get("bidCategoryCode");

		if (bidCategoryCode != null) {
			setBidCategoryCode(bidCategoryCode);
		}

		String buildMileage = (String)attributes.get("buildMileage");

		if (buildMileage != null) {
			setBuildMileage(buildMileage);
		}

		String involveCounty = (String)attributes.get("involveCounty");

		if (involveCounty != null) {
			setInvolveCounty(involveCounty);
		}

		String projLinkman = (String)attributes.get("projLinkman");

		if (projLinkman != null) {
			setProjLinkman(projLinkman);
		}

		String linkTel = (String)attributes.get("linkTel");

		if (linkTel != null) {
			setLinkTel(linkTel);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}
	}

	@Override
	public long getBiddingId() {
		return _biddingId;
	}

	@Override
	public void setBiddingId(long biddingId) {
		_biddingId = biddingId;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setBiddingId", long.class);

				method.invoke(_biddingRemoteModel, biddingId);
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

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_biddingRemoteModel, userId);
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

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_biddingRemoteModel, userName);
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

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_biddingRemoteModel, createDate);
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

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_biddingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBidCode() {
		return _bidCode;
	}

	@Override
	public void setBidCode(String bidCode) {
		_bidCode = bidCode;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setBidCode", String.class);

				method.invoke(_biddingRemoteModel, bidCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSortNo() {
		return _sortNo;
	}

	@Override
	public void setSortNo(int sortNo) {
		_sortNo = sortNo;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setSortNo", int.class);

				method.invoke(_biddingRemoteModel, sortNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBidName() {
		return _bidName;
	}

	@Override
	public void setBidName(String bidName) {
		_bidName = bidName;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setBidName", String.class);

				method.invoke(_biddingRemoteModel, bidName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBidCategoryCode() {
		return _bidCategoryCode;
	}

	@Override
	public void setBidCategoryCode(String bidCategoryCode) {
		_bidCategoryCode = bidCategoryCode;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setBidCategoryCode",
						String.class);

				method.invoke(_biddingRemoteModel, bidCategoryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBuildMileage() {
		return _buildMileage;
	}

	@Override
	public void setBuildMileage(String buildMileage) {
		_buildMileage = buildMileage;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setBuildMileage", String.class);

				method.invoke(_biddingRemoteModel, buildMileage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInvolveCounty() {
		return _involveCounty;
	}

	@Override
	public void setInvolveCounty(String involveCounty) {
		_involveCounty = involveCounty;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setInvolveCounty", String.class);

				method.invoke(_biddingRemoteModel, involveCounty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjLinkman() {
		return _projLinkman;
	}

	@Override
	public void setProjLinkman(String projLinkman) {
		_projLinkman = projLinkman;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setProjLinkman", String.class);

				method.invoke(_biddingRemoteModel, projLinkman);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkTel() {
		return _linkTel;
	}

	@Override
	public void setLinkTel(String linkTel) {
		_linkTel = linkTel;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkTel", String.class);

				method.invoke(_biddingRemoteModel, linkTel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_biddingRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;

		if (_biddingRemoteModel != null) {
			try {
				Class<?> clazz = _biddingRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", long.class);

				method.invoke(_biddingRemoteModel, projectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBiddingRemoteModel() {
		return _biddingRemoteModel;
	}

	public void setBiddingRemoteModel(BaseModel<?> biddingRemoteModel) {
		_biddingRemoteModel = biddingRemoteModel;
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

		Class<?> remoteModelClass = _biddingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_biddingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BiddingLocalServiceUtil.addBidding(this);
		}
		else {
			BiddingLocalServiceUtil.updateBidding(this);
		}
	}

	@Override
	public Bidding toEscapedModel() {
		return (Bidding)ProxyUtil.newProxyInstance(Bidding.class.getClassLoader(),
			new Class[] { Bidding.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BiddingClp clone = new BiddingClp();

		clone.setBiddingId(getBiddingId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBidCode(getBidCode());
		clone.setSortNo(getSortNo());
		clone.setBidName(getBidName());
		clone.setBidCategoryCode(getBidCategoryCode());
		clone.setBuildMileage(getBuildMileage());
		clone.setInvolveCounty(getInvolveCounty());
		clone.setProjLinkman(getProjLinkman());
		clone.setLinkTel(getLinkTel());
		clone.setStartDate(getStartDate());
		clone.setProjectId(getProjectId());

		return clone;
	}

	@Override
	public int compareTo(Bidding bidding) {
		int value = 0;

		if (getBiddingId() < bidding.getBiddingId()) {
			value = -1;
		}
		else if (getBiddingId() > bidding.getBiddingId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof BiddingClp)) {
			return false;
		}

		BiddingClp bidding = (BiddingClp)obj;

		long primaryKey = bidding.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{biddingId=");
		sb.append(getBiddingId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", bidCode=");
		sb.append(getBidCode());
		sb.append(", sortNo=");
		sb.append(getSortNo());
		sb.append(", bidName=");
		sb.append(getBidName());
		sb.append(", bidCategoryCode=");
		sb.append(getBidCategoryCode());
		sb.append(", buildMileage=");
		sb.append(getBuildMileage());
		sb.append(", involveCounty=");
		sb.append(getInvolveCounty());
		sb.append(", projLinkman=");
		sb.append(getProjLinkman());
		sb.append(", linkTel=");
		sb.append(getLinkTel());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.proj.model.Bidding");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>biddingId</column-name><column-value><![CDATA[");
		sb.append(getBiddingId());
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
			"<column><column-name>bidCode</column-name><column-value><![CDATA[");
		sb.append(getBidCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortNo</column-name><column-value><![CDATA[");
		sb.append(getSortNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bidName</column-name><column-value><![CDATA[");
		sb.append(getBidName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bidCategoryCode</column-name><column-value><![CDATA[");
		sb.append(getBidCategoryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>buildMileage</column-name><column-value><![CDATA[");
		sb.append(getBuildMileage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>involveCounty</column-name><column-value><![CDATA[");
		sb.append(getInvolveCounty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projLinkman</column-name><column-value><![CDATA[");
		sb.append(getProjLinkman());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkTel</column-name><column-value><![CDATA[");
		sb.append(getLinkTel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _biddingId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _bidCode;
	private int _sortNo;
	private String _bidName;
	private String _bidCategoryCode;
	private String _buildMileage;
	private String _involveCounty;
	private String _projLinkman;
	private String _linkTel;
	private Date _startDate;
	private long _projectId;
	private BaseModel<?> _biddingRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.proj.service.ClpSerializer.class;
}