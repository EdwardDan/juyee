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

import com.justonetech.oa.model.OfficeSupplyRequisitionItem;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing OfficeSupplyRequisitionItem in entity cache.
 *
 * @author justonetech
 * @see OfficeSupplyRequisitionItem
 * @generated
 */
public class OfficeSupplyRequisitionItemCacheModel implements CacheModel<OfficeSupplyRequisitionItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{officeSupplyRequisitionItemId=");
		sb.append(officeSupplyRequisitionItemId);
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
		sb.append(", officeSupplyRequisitionId=");
		sb.append(officeSupplyRequisitionId);
		sb.append(", officeSupplyId=");
		sb.append(officeSupplyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OfficeSupplyRequisitionItem toEntityModel() {
		OfficeSupplyRequisitionItemImpl officeSupplyRequisitionItemImpl = new OfficeSupplyRequisitionItemImpl();

		officeSupplyRequisitionItemImpl.setOfficeSupplyRequisitionItemId(officeSupplyRequisitionItemId);

		if (name == null) {
			officeSupplyRequisitionItemImpl.setName(StringPool.BLANK);
		}
		else {
			officeSupplyRequisitionItemImpl.setName(name);
		}

		if (model == null) {
			officeSupplyRequisitionItemImpl.setModel(StringPool.BLANK);
		}
		else {
			officeSupplyRequisitionItemImpl.setModel(model);
		}

		if (unit == null) {
			officeSupplyRequisitionItemImpl.setUnit(StringPool.BLANK);
		}
		else {
			officeSupplyRequisitionItemImpl.setUnit(unit);
		}

		officeSupplyRequisitionItemImpl.setUnitPrice(unitPrice);
		officeSupplyRequisitionItemImpl.setQuantity(quantity);
		officeSupplyRequisitionItemImpl.setOfficeSupplyRequisitionId(officeSupplyRequisitionId);
		officeSupplyRequisitionItemImpl.setOfficeSupplyId(officeSupplyId);

		officeSupplyRequisitionItemImpl.resetOriginalValues();

		return officeSupplyRequisitionItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		officeSupplyRequisitionItemId = objectInput.readLong();
		name = objectInput.readUTF();
		model = objectInput.readUTF();
		unit = objectInput.readUTF();
		unitPrice = objectInput.readDouble();
		quantity = objectInput.readInt();
		officeSupplyRequisitionId = objectInput.readLong();
		officeSupplyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(officeSupplyRequisitionItemId);

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
		objectOutput.writeLong(officeSupplyRequisitionId);
		objectOutput.writeLong(officeSupplyId);
	}

	public long officeSupplyRequisitionItemId;
	public String name;
	public String model;
	public String unit;
	public double unitPrice;
	public int quantity;
	public long officeSupplyRequisitionId;
	public long officeSupplyId;
}