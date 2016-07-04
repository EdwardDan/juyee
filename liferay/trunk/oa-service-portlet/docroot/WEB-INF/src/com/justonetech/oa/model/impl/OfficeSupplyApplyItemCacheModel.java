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

import com.justonetech.oa.model.OfficeSupplyApplyItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OfficeSupplyApplyItem in entity cache.
 *
 * @author justonetech
 * @see OfficeSupplyApplyItem
 * @generated
 */
public class OfficeSupplyApplyItemCacheModel implements CacheModel<OfficeSupplyApplyItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{officeSupplyApplyItemId=");
		sb.append(officeSupplyApplyItemId);
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
	public OfficeSupplyApplyItem toEntityModel() {
		OfficeSupplyApplyItemImpl officeSupplyApplyItemImpl = new OfficeSupplyApplyItemImpl();

		officeSupplyApplyItemImpl.setOfficeSupplyApplyItemId(officeSupplyApplyItemId);

		if (name == null) {
			officeSupplyApplyItemImpl.setName(StringPool.BLANK);
		}
		else {
			officeSupplyApplyItemImpl.setName(name);
		}

		if (model == null) {
			officeSupplyApplyItemImpl.setModel(StringPool.BLANK);
		}
		else {
			officeSupplyApplyItemImpl.setModel(model);
		}

		if (unit == null) {
			officeSupplyApplyItemImpl.setUnit(StringPool.BLANK);
		}
		else {
			officeSupplyApplyItemImpl.setUnit(unit);
		}

		officeSupplyApplyItemImpl.setUnitPrice(unitPrice);
		officeSupplyApplyItemImpl.setQuantity(quantity);

		officeSupplyApplyItemImpl.resetOriginalValues();

		return officeSupplyApplyItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeSupplyApplyItemId = objectInput.readLong();
		name = objectInput.readUTF();
		model = objectInput.readUTF();
		unit = objectInput.readUTF();
		unitPrice = objectInput.readDouble();
		quantity = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(officeSupplyApplyItemId);

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

	public long officeSupplyApplyItemId;
	public String name;
	public String model;
	public String unit;
	public double unitPrice;
	public int quantity;
}