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

package com.justonetech.sys.model.impl;

import com.justonetech.sys.model.Dictionary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dictionary in entity cache.
 *
 * @author justonetech
 * @see Dictionary
 * @generated
 */
public class DictionaryCacheModel implements CacheModel<Dictionary>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{dictionaryId=");
		sb.append(dictionaryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", modifiedTime=");
		sb.append(modifiedTime);
		sb.append(", code=");
		sb.append(code);
		sb.append(", name=");
		sb.append(name);
		sb.append(", isLeaf=");
		sb.append(isLeaf);
		sb.append(", sortNo=");
		sb.append(sortNo);
		sb.append(", desc=");
		sb.append(desc);
		sb.append(", tag=");
		sb.append(tag);
		sb.append(", isValid=");
		sb.append(isValid);
		sb.append(", treePath=");
		sb.append(treePath);
		sb.append(", sortPath=");
		sb.append(sortPath);
		sb.append(", customContent=");
		sb.append(customContent);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", customField1=");
		sb.append(customField1);
		sb.append(", customField2=");
		sb.append(customField2);
		sb.append(", customField3=");
		sb.append(customField3);
		sb.append(", customField4=");
		sb.append(customField4);
		sb.append(", customField5=");
		sb.append(customField5);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dictionary toEntityModel() {
		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		dictionaryImpl.setDictionaryId(dictionaryId);
		dictionaryImpl.setGroupId(groupId);
		dictionaryImpl.setCompanyId(companyId);
		dictionaryImpl.setUserId(userId);

		if (userName == null) {
			dictionaryImpl.setUserName(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			dictionaryImpl.setCreateTime(null);
		}
		else {
			dictionaryImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			dictionaryImpl.setModifiedTime(null);
		}
		else {
			dictionaryImpl.setModifiedTime(new Date(modifiedTime));
		}

		if (code == null) {
			dictionaryImpl.setCode(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCode(code);
		}

		if (name == null) {
			dictionaryImpl.setName(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setName(name);
		}

		dictionaryImpl.setIsLeaf(isLeaf);
		dictionaryImpl.setSortNo(sortNo);

		if (desc == null) {
			dictionaryImpl.setDesc(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setDesc(desc);
		}

		if (tag == null) {
			dictionaryImpl.setTag(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setTag(tag);
		}

		dictionaryImpl.setIsValid(isValid);

		if (treePath == null) {
			dictionaryImpl.setTreePath(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setTreePath(treePath);
		}

		if (sortPath == null) {
			dictionaryImpl.setSortPath(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setSortPath(sortPath);
		}

		if (customContent == null) {
			dictionaryImpl.setCustomContent(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCustomContent(customContent);
		}

		dictionaryImpl.setParentId(parentId);

		if (customField1 == null) {
			dictionaryImpl.setCustomField1(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCustomField1(customField1);
		}

		if (customField2 == null) {
			dictionaryImpl.setCustomField2(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCustomField2(customField2);
		}

		if (customField3 == null) {
			dictionaryImpl.setCustomField3(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCustomField3(customField3);
		}

		if (customField4 == null) {
			dictionaryImpl.setCustomField4(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCustomField4(customField4);
		}

		if (customField5 == null) {
			dictionaryImpl.setCustomField5(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCustomField5(customField5);
		}

		dictionaryImpl.resetOriginalValues();

		return dictionaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dictionaryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		code = objectInput.readUTF();
		name = objectInput.readUTF();
		isLeaf = objectInput.readBoolean();
		sortNo = objectInput.readInt();
		desc = objectInput.readUTF();
		tag = objectInput.readUTF();
		isValid = objectInput.readBoolean();
		treePath = objectInput.readUTF();
		sortPath = objectInput.readUTF();
		customContent = objectInput.readUTF();
		parentId = objectInput.readLong();
		customField1 = objectInput.readUTF();
		customField2 = objectInput.readUTF();
		customField3 = objectInput.readUTF();
		customField4 = objectInput.readUTF();
		customField5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dictionaryId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createTime);
		objectOutput.writeLong(modifiedTime);

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(isLeaf);
		objectOutput.writeInt(sortNo);

		if (desc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc);
		}

		if (tag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag);
		}

		objectOutput.writeBoolean(isValid);

		if (treePath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(treePath);
		}

		if (sortPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sortPath);
		}

		if (customContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customContent);
		}

		objectOutput.writeLong(parentId);

		if (customField1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField1);
		}

		if (customField2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField2);
		}

		if (customField3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField3);
		}

		if (customField4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField4);
		}

		if (customField5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField5);
		}
	}

	public long dictionaryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public String code;
	public String name;
	public boolean isLeaf;
	public int sortNo;
	public String desc;
	public String tag;
	public boolean isValid;
	public String treePath;
	public String sortPath;
	public String customContent;
	public long parentId;
	public String customField1;
	public String customField2;
	public String customField3;
	public String customField4;
	public String customField5;
}