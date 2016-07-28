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

import com.justonetech.oa.model.OfficeSupply;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OfficeSupply in entity cache.
 *
 * @author justonetech
 * @see OfficeSupply
 * @generated
 */
public class OfficeSupplyCacheModel implements CacheModel<OfficeSupply>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{officeSupplyId=");
		sb.append(officeSupplyId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", model=");
		sb.append(model);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", unitPrice=");
		sb.append(unitPrice);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OfficeSupply toEntityModel() {
		OfficeSupplyImpl officeSupplyImpl = new OfficeSupplyImpl();

		officeSupplyImpl.setOfficeSupplyId(officeSupplyId);
		officeSupplyImpl.setGroupId(groupId);
		officeSupplyImpl.setCompanyId(companyId);
		officeSupplyImpl.setUserId(userId);

		if (userName == null) {
			officeSupplyImpl.setUserName(StringPool.BLANK);
		}
		else {
			officeSupplyImpl.setUserName(userName);
		}

		if (createTime == Long.MIN_VALUE) {
			officeSupplyImpl.setCreateTime(null);
		}
		else {
			officeSupplyImpl.setCreateTime(new Date(createTime));
		}

		if (modifiedTime == Long.MIN_VALUE) {
			officeSupplyImpl.setModifiedTime(null);
		}
		else {
			officeSupplyImpl.setModifiedTime(new Date(modifiedTime));
		}

		if (name == null) {
			officeSupplyImpl.setName(StringPool.BLANK);
		}
		else {
			officeSupplyImpl.setName(name);
		}

		if (model == null) {
			officeSupplyImpl.setModel(StringPool.BLANK);
		}
		else {
			officeSupplyImpl.setModel(model);
		}

		if (unit == null) {
			officeSupplyImpl.setUnit(StringPool.BLANK);
		}
		else {
			officeSupplyImpl.setUnit(unit);
		}

		officeSupplyImpl.setUnitPrice(unitPrice);
		officeSupplyImpl.setQuantity(quantity);

		officeSupplyImpl.resetOriginalValues();

		return officeSupplyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeSupplyId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createTime = objectInput.readLong();
		modifiedTime = objectInput.readLong();
		name = objectInput.readUTF();
		model = objectInput.readUTF();
		unit = objectInput.readUTF();
		unitPrice = objectInput.readDouble();
		quantity = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(officeSupplyId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (model == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(model);
		}

		if (unit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unit);
		}

		objectOutput.writeDouble(unitPrice);
		objectOutput.writeInt(quantity);
	}

	public long officeSupplyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createTime;
	public long modifiedTime;
	public String name;
	public String model;
	public String unit;
	public double unitPrice;
	public int quantity;
}