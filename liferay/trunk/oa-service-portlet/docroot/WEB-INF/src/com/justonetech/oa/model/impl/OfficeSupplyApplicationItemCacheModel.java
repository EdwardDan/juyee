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

import com.justonetech.oa.model.OfficeSupplyApplicationItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OfficeSupplyApplicationItem in entity cache.
 *
 * @author justonetech
 * @see OfficeSupplyApplicationItem
 * @generated
 */
public class OfficeSupplyApplicationItemCacheModel implements CacheModel<OfficeSupplyApplicationItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{officeSupplyApplicationItemId=");
		sb.append(officeSupplyApplicationItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
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
		sb.append(", officeSupplyApplicationId=");
		sb.append(officeSupplyApplicationId);
		sb.append(", officeSupplyId=");
		sb.append(officeSupplyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OfficeSupplyApplicationItem toEntityModel() {
		OfficeSupplyApplicationItemImpl officeSupplyApplicationItemImpl = new OfficeSupplyApplicationItemImpl();

		officeSupplyApplicationItemImpl.setOfficeSupplyApplicationItemId(officeSupplyApplicationItemId);
		officeSupplyApplicationItemImpl.setGroupId(groupId);
		officeSupplyApplicationItemImpl.setCompanyId(companyId);

		if (name == null) {
			officeSupplyApplicationItemImpl.setName(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationItemImpl.setName(name);
		}

		if (model == null) {
			officeSupplyApplicationItemImpl.setModel(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationItemImpl.setModel(model);
		}

		if (unit == null) {
			officeSupplyApplicationItemImpl.setUnit(StringPool.BLANK);
		}
		else {
			officeSupplyApplicationItemImpl.setUnit(unit);
		}

		officeSupplyApplicationItemImpl.setUnitPrice(unitPrice);
		officeSupplyApplicationItemImpl.setQuantity(quantity);
		officeSupplyApplicationItemImpl.setOfficeSupplyApplicationId(officeSupplyApplicationId);
		officeSupplyApplicationItemImpl.setOfficeSupplyId(officeSupplyId);

		officeSupplyApplicationItemImpl.resetOriginalValues();

		return officeSupplyApplicationItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeSupplyApplicationItemId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		name = objectInput.readUTF();
		model = objectInput.readUTF();
		unit = objectInput.readUTF();
		unitPrice = objectInput.readDouble();
		quantity = objectInput.readInt();
		officeSupplyApplicationId = objectInput.readLong();
		officeSupplyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(officeSupplyApplicationItemId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

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
		objectOutput.writeLong(officeSupplyApplicationId);
		objectOutput.writeLong(officeSupplyId);
	}

	public long officeSupplyApplicationItemId;
	public long groupId;
	public long companyId;
	public String name;
	public String model;
	public String unit;
	public double unitPrice;
	public int quantity;
	public long officeSupplyApplicationId;
	public long officeSupplyId;
}