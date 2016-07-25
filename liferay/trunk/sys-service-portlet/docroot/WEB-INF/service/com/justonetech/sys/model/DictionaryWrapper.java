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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Dictionary}.
 * </p>
 *
 * @author justonetech
 * @see Dictionary
 * @generated
 */
public class DictionaryWrapper implements Dictionary, ModelWrapper<Dictionary> {
	public DictionaryWrapper(Dictionary dictionary) {
		_dictionary = dictionary;
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
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("isLeaf", getIsLeaf());
		attributes.put("sortNo", getSortNo());
		attributes.put("desc", getDesc());
		attributes.put("tag", getTag());
		attributes.put("isValid", getIsValid());
		attributes.put("treePath", getTreePath());
		attributes.put("sortPath", getSortPath());
		attributes.put("customContent", getCustomContent());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
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

		String customContent = (String)attributes.get("customContent");

		if (customContent != null) {
			setCustomContent(customContent);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	/**
	* Returns the primary key of this dictionary.
	*
	* @return the primary key of this dictionary
	*/
	@Override
	public long getPrimaryKey() {
		return _dictionary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dictionary.
	*
	* @param primaryKey the primary key of this dictionary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictionary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dictionary ID of this dictionary.
	*
	* @return the dictionary ID of this dictionary
	*/
	@Override
	public long getDictionaryId() {
		return _dictionary.getDictionaryId();
	}

	/**
	* Sets the dictionary ID of this dictionary.
	*
	* @param dictionaryId the dictionary ID of this dictionary
	*/
	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionary.setDictionaryId(dictionaryId);
	}

	/**
	* Returns the user ID of this dictionary.
	*
	* @return the user ID of this dictionary
	*/
	@Override
	public long getUserId() {
		return _dictionary.getUserId();
	}

	/**
	* Sets the user ID of this dictionary.
	*
	* @param userId the user ID of this dictionary
	*/
	@Override
	public void setUserId(long userId) {
		_dictionary.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dictionary.
	*
	* @return the user uuid of this dictionary
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictionary.getUserUuid();
	}

	/**
	* Sets the user uuid of this dictionary.
	*
	* @param userUuid the user uuid of this dictionary
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictionary.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this dictionary.
	*
	* @return the user name of this dictionary
	*/
	@Override
	public java.lang.String getUserName() {
		return _dictionary.getUserName();
	}

	/**
	* Sets the user name of this dictionary.
	*
	* @param userName the user name of this dictionary
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dictionary.setUserName(userName);
	}

	/**
	* Returns the create time of this dictionary.
	*
	* @return the create time of this dictionary
	*/
	@Override
	public java.util.Date getCreateTime() {
		return _dictionary.getCreateTime();
	}

	/**
	* Sets the create time of this dictionary.
	*
	* @param createTime the create time of this dictionary
	*/
	@Override
	public void setCreateTime(java.util.Date createTime) {
		_dictionary.setCreateTime(createTime);
	}

	/**
	* Returns the modified time of this dictionary.
	*
	* @return the modified time of this dictionary
	*/
	@Override
	public java.util.Date getModifiedTime() {
		return _dictionary.getModifiedTime();
	}

	/**
	* Sets the modified time of this dictionary.
	*
	* @param modifiedTime the modified time of this dictionary
	*/
	@Override
	public void setModifiedTime(java.util.Date modifiedTime) {
		_dictionary.setModifiedTime(modifiedTime);
	}

	/**
	* Returns the code of this dictionary.
	*
	* @return the code of this dictionary
	*/
	@Override
	public java.lang.String getCode() {
		return _dictionary.getCode();
	}

	/**
	* Sets the code of this dictionary.
	*
	* @param code the code of this dictionary
	*/
	@Override
	public void setCode(java.lang.String code) {
		_dictionary.setCode(code);
	}

	/**
	* Returns the name of this dictionary.
	*
	* @return the name of this dictionary
	*/
	@Override
	public java.lang.String getName() {
		return _dictionary.getName();
	}

	/**
	* Sets the name of this dictionary.
	*
	* @param name the name of this dictionary
	*/
	@Override
	public void setName(java.lang.String name) {
		_dictionary.setName(name);
	}

	/**
	* Returns the is leaf of this dictionary.
	*
	* @return the is leaf of this dictionary
	*/
	@Override
	public boolean getIsLeaf() {
		return _dictionary.getIsLeaf();
	}

	/**
	* Returns <code>true</code> if this dictionary is is leaf.
	*
	* @return <code>true</code> if this dictionary is is leaf; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsLeaf() {
		return _dictionary.isIsLeaf();
	}

	/**
	* Sets whether this dictionary is is leaf.
	*
	* @param isLeaf the is leaf of this dictionary
	*/
	@Override
	public void setIsLeaf(boolean isLeaf) {
		_dictionary.setIsLeaf(isLeaf);
	}

	/**
	* Returns the sort no of this dictionary.
	*
	* @return the sort no of this dictionary
	*/
	@Override
	public int getSortNo() {
		return _dictionary.getSortNo();
	}

	/**
	* Sets the sort no of this dictionary.
	*
	* @param sortNo the sort no of this dictionary
	*/
	@Override
	public void setSortNo(int sortNo) {
		_dictionary.setSortNo(sortNo);
	}

	/**
	* Returns the desc of this dictionary.
	*
	* @return the desc of this dictionary
	*/
	@Override
	public java.lang.String getDesc() {
		return _dictionary.getDesc();
	}

	/**
	* Sets the desc of this dictionary.
	*
	* @param desc the desc of this dictionary
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_dictionary.setDesc(desc);
	}

	/**
	* Returns the tag of this dictionary.
	*
	* @return the tag of this dictionary
	*/
	@Override
	public java.lang.String getTag() {
		return _dictionary.getTag();
	}

	/**
	* Sets the tag of this dictionary.
	*
	* @param tag the tag of this dictionary
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_dictionary.setTag(tag);
	}

	/**
	* Returns the is valid of this dictionary.
	*
	* @return the is valid of this dictionary
	*/
	@Override
	public boolean getIsValid() {
		return _dictionary.getIsValid();
	}

	/**
	* Returns <code>true</code> if this dictionary is is valid.
	*
	* @return <code>true</code> if this dictionary is is valid; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsValid() {
		return _dictionary.isIsValid();
	}

	/**
	* Sets whether this dictionary is is valid.
	*
	* @param isValid the is valid of this dictionary
	*/
	@Override
	public void setIsValid(boolean isValid) {
		_dictionary.setIsValid(isValid);
	}

	/**
	* Returns the tree path of this dictionary.
	*
	* @return the tree path of this dictionary
	*/
	@Override
	public java.lang.String getTreePath() {
		return _dictionary.getTreePath();
	}

	/**
	* Sets the tree path of this dictionary.
	*
	* @param treePath the tree path of this dictionary
	*/
	@Override
	public void setTreePath(java.lang.String treePath) {
		_dictionary.setTreePath(treePath);
	}

	/**
	* Returns the sort path of this dictionary.
	*
	* @return the sort path of this dictionary
	*/
	@Override
	public java.lang.String getSortPath() {
		return _dictionary.getSortPath();
	}

	/**
	* Sets the sort path of this dictionary.
	*
	* @param sortPath the sort path of this dictionary
	*/
	@Override
	public void setSortPath(java.lang.String sortPath) {
		_dictionary.setSortPath(sortPath);
	}

	/**
	* Returns the custom content of this dictionary.
	*
	* @return the custom content of this dictionary
	*/
	@Override
	public java.lang.String getCustomContent() {
		return _dictionary.getCustomContent();
	}

	/**
	* Sets the custom content of this dictionary.
	*
	* @param customContent the custom content of this dictionary
	*/
	@Override
	public void setCustomContent(java.lang.String customContent) {
		_dictionary.setCustomContent(customContent);
	}

	/**
	* Returns the parent ID of this dictionary.
	*
	* @return the parent ID of this dictionary
	*/
	@Override
	public long getParentId() {
		return _dictionary.getParentId();
	}

	/**
	* Sets the parent ID of this dictionary.
	*
	* @param parentId the parent ID of this dictionary
	*/
	@Override
	public void setParentId(long parentId) {
		_dictionary.setParentId(parentId);
	}

	@Override
	public boolean isNew() {
		return _dictionary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dictionary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dictionary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictionary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dictionary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dictionary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dictionary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dictionary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dictionary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dictionary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dictionary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DictionaryWrapper((Dictionary)_dictionary.clone());
	}

	@Override
	public int compareTo(com.justonetech.sys.model.Dictionary dictionary) {
		return _dictionary.compareTo(dictionary);
	}

	@Override
	public int hashCode() {
		return _dictionary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.justonetech.sys.model.Dictionary> toCacheModel() {
		return _dictionary.toCacheModel();
	}

	@Override
	public com.justonetech.sys.model.Dictionary toEscapedModel() {
		return new DictionaryWrapper(_dictionary.toEscapedModel());
	}

	@Override
	public com.justonetech.sys.model.Dictionary toUnescapedModel() {
		return new DictionaryWrapper(_dictionary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dictionary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictionary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictionary.persist();
	}

	@Override
	public void updateTreePath(java.lang.String treePath)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictionary.updateTreePath(treePath);
	}

	@Override
	public java.lang.String buildTreePath()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionary.buildTreePath();
	}

	@Override
	public com.justonetech.sys.model.Dictionary getParentDictionary()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dictionary.getParentDictionary();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryWrapper)) {
			return false;
		}

		DictionaryWrapper dictionaryWrapper = (DictionaryWrapper)obj;

		if (Validator.equals(_dictionary, dictionaryWrapper._dictionary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Dictionary getWrappedDictionary() {
		return _dictionary;
	}

	@Override
	public Dictionary getWrappedModel() {
		return _dictionary;
	}

	@Override
	public void resetOriginalValues() {
		_dictionary.resetOriginalValues();
	}

	private Dictionary _dictionary;
}