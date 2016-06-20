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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.justonetech.sys.service.http.DictionaryServiceSoap}.
 *
 * @author fanqi
 * @see com.justonetech.sys.service.http.DictionaryServiceSoap
 * @generated
 */
public class DictionarySoap implements Serializable {
	public static DictionarySoap toSoapModel(Dictionary model) {
		DictionarySoap soapModel = new DictionarySoap();

		soapModel.setDictionaryId(model.getDictionaryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setName(model.getName());
		soapModel.setIsLeaf(model.getIsLeaf());
		soapModel.setSortNo(model.getSortNo());
		soapModel.setDesc(model.getDesc());
		soapModel.setTag(model.getTag());
		soapModel.setIsValid(model.getIsValid());
		soapModel.setTreePath(model.getTreePath());
		soapModel.setSortPath(model.getSortPath());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static DictionarySoap[] toSoapModels(Dictionary[] models) {
		DictionarySoap[] soapModels = new DictionarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[][] toSoapModels(Dictionary[][] models) {
		DictionarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictionarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictionarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[] toSoapModels(List<Dictionary> models) {
		List<DictionarySoap> soapModels = new ArrayList<DictionarySoap>(models.size());

		for (Dictionary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictionarySoap[soapModels.size()]);
	}

	public DictionarySoap() {
	}

	public long getPrimaryKey() {
		return _dictionaryId;
	}

	public void setPrimaryKey(long pk) {
		setDictionaryId(pk);
	}

	public long getDictionaryId() {
		return _dictionaryId;
	}

	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getIsLeaf() {
		return _isLeaf;
	}

	public boolean isIsLeaf() {
		return _isLeaf;
	}

	public void setIsLeaf(boolean isLeaf) {
		_isLeaf = isLeaf;
	}

	public int getSortNo() {
		return _sortNo;
	}

	public void setSortNo(int sortNo) {
		_sortNo = sortNo;
	}

	public String getDesc() {
		return _desc;
	}

	public void setDesc(String desc) {
		_desc = desc;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	public boolean getIsValid() {
		return _isValid;
	}

	public boolean isIsValid() {
		return _isValid;
	}

	public void setIsValid(boolean isValid) {
		_isValid = isValid;
	}

	public String getTreePath() {
		return _treePath;
	}

	public void setTreePath(String treePath) {
		_treePath = treePath;
	}

	public int getSortPath() {
		return _sortPath;
	}

	public void setSortPath(int sortPath) {
		_sortPath = sortPath;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	private long _dictionaryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
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
	private int _sortPath;
	private long _parentId;
}