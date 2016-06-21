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

package com.justonetech.sys.model;

import com.justonetech.sys.service.ClpSerializer;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;

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
public class DictionaryClp extends BaseModelImpl<Dictionary>
	implements Dictionary {
	public DictionaryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Dictionary.class;
	}

	@Override
	public String getModelClassName() {
		return Dictionary.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dictionaryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictionaryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionaryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("isLeaf", getIsLeaf());
		attributes.put("sortNo", getSortNo());
		attributes.put("desc", getDesc());
		attributes.put("tag", getTag());
		attributes.put("isValid", getIsValid());
		attributes.put("treePath", getTreePath());
		attributes.put("sortPath", getSortPath());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean isLeaf = (Boolean)attributes.get("isLeaf");

		if (isLeaf != null) {
			setIsLeaf(isLeaf);
		}

		Integer sortNo = (Integer)attributes.get("sortNo");

		if (sortNo != null) {
			setSortNo(sortNo);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		Boolean isValid = (Boolean)attributes.get("isValid");

		if (isValid != null) {
			setIsValid(isValid);
		}

		String treePath = (String)attributes.get("treePath");

		if (treePath != null) {
			setTreePath(treePath);
		}

		String sortPath = (String)attributes.get("sortPath");

		if (sortPath != null) {
			setSortPath(sortPath);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public long getDictionaryId() {
		return _dictionaryId;
	}

	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionaryId", long.class);

				method.invoke(_dictionaryRemoteModel, dictionaryId);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dictionaryRemoteModel, groupId);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dictionaryRemoteModel, companyId);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dictionaryRemoteModel, userId);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_dictionaryRemoteModel, userName);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dictionaryRemoteModel, createDate);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dictionaryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_dictionaryRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_dictionaryRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsLeaf() {
		return _isLeaf;
	}

	@Override
	public boolean isIsLeaf() {
		return _isLeaf;
	}

	@Override
	public void setIsLeaf(boolean isLeaf) {
		_isLeaf = isLeaf;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setIsLeaf", boolean.class);

				method.invoke(_dictionaryRemoteModel, isLeaf);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setSortNo", int.class);

				method.invoke(_dictionaryRemoteModel, sortNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesc() {
		return _desc;
	}

	@Override
	public void setDesc(String desc) {
		_desc = desc;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDesc", String.class);

				method.invoke(_dictionaryRemoteModel, desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTag() {
		return _tag;
	}

	@Override
	public void setTag(String tag) {
		_tag = tag;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setTag", String.class);

				method.invoke(_dictionaryRemoteModel, tag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsValid() {
		return _isValid;
	}

	@Override
	public boolean isIsValid() {
		return _isValid;
	}

	@Override
	public void setIsValid(boolean isValid) {
		_isValid = isValid;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setIsValid", boolean.class);

				method.invoke(_dictionaryRemoteModel, isValid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTreePath() {
		return _treePath;
	}

	@Override
	public void setTreePath(String treePath) {
		_treePath = treePath;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setTreePath", String.class);

				method.invoke(_dictionaryRemoteModel, treePath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSortPath() {
		return _sortPath;
	}

	@Override
	public void setSortPath(String sortPath) {
		_sortPath = sortPath;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setSortPath", String.class);

				method.invoke(_dictionaryRemoteModel, sortPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_dictionaryRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String buildTreePath() {
		try {
			String methodName = "buildTreePath";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void updateTreePath(String treePath) {
		try {
			_treePath = treePath;

			invokeOnRemoteModel("updateTreePath",
				new Class<?>[] { String.class }, new Object[] { treePath });
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getDictionaryRemoteModel() {
		return _dictionaryRemoteModel;
	}

	public void setDictionaryRemoteModel(BaseModel<?> dictionaryRemoteModel) {
		_dictionaryRemoteModel = dictionaryRemoteModel;
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

		Class<?> remoteModelClass = _dictionaryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dictionaryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DictionaryLocalServiceUtil.addDictionary(this);
		}
		else {
			DictionaryLocalServiceUtil.updateDictionary(this);
		}
	}

	@Override
	public Dictionary toEscapedModel() {
		return (Dictionary)ProxyUtil.newProxyInstance(Dictionary.class.getClassLoader(),
			new Class[] { Dictionary.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictionaryClp clone = new DictionaryClp();

		clone.setDictionaryId(getDictionaryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCode(getCode());
		clone.setName(getName());
		clone.setIsLeaf(getIsLeaf());
		clone.setSortNo(getSortNo());
		clone.setDesc(getDesc());
		clone.setTag(getTag());
		clone.setIsValid(getIsValid());
		clone.setTreePath(getTreePath());
		clone.setSortPath(getSortPath());
		clone.setParentId(getParentId());

		return clone;
	}

	@Override
	public int compareTo(Dictionary dictionary) {
		int value = 0;

		value = getSortPath().compareTo(dictionary.getSortPath());

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

		if (!(obj instanceof DictionaryClp)) {
			return false;
		}

		DictionaryClp dictionary = (DictionaryClp)obj;

		long primaryKey = dictionary.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{dictionaryId=");
		sb.append(getDictionaryId());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", isLeaf=");
		sb.append(getIsLeaf());
		sb.append(", sortNo=");
		sb.append(getSortNo());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", tag=");
		sb.append(getTag());
		sb.append(", isValid=");
		sb.append(getIsValid());
		sb.append(", treePath=");
		sb.append(getTreePath());
		sb.append(", sortPath=");
		sb.append(getSortPath());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.justonetech.sys.model.Dictionary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictionaryId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLeaf</column-name><column-value><![CDATA[");
		sb.append(getIsLeaf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortNo</column-name><column-value><![CDATA[");
		sb.append(getSortNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desc</column-name><column-value><![CDATA[");
		sb.append(getDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tag</column-name><column-value><![CDATA[");
		sb.append(getTag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isValid</column-name><column-value><![CDATA[");
		sb.append(getIsValid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>treePath</column-name><column-value><![CDATA[");
		sb.append(getTreePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortPath</column-name><column-value><![CDATA[");
		sb.append(getSortPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictionaryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _name;
	private boolean _isLeaf;
	private int _sortNo;
	private String _desc;
	private String _tag;
	private boolean _isValid;
	private String _treePath;
	private String _sortPath;
	private long _parentId;
	private BaseModel<?> _dictionaryRemoteModel;
	private Class<?> _clpSerializerClass = com.justonetech.sys.service.ClpSerializer.class;
}