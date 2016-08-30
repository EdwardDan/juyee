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

package com.justonetech.cp.contract.model.impl;

import com.justonetech.cp.contract.model.Contract;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contract in entity cache.
 *
 * @author fanqi
 * @see Contract
 * @generated
 */
public class ContractCacheModel implements CacheModel<Contract>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{contractId=");
		sb.append(contractId);
		sb.append(", htlb=");
		sb.append(htlb);
		sb.append(", bjbh=");
		sb.append(bjbh);
		sb.append(", bdh=");
		sb.append(bdh);
		sb.append(", cbfs=");
		sb.append(cbfs);
		sb.append(", htmc=");
		sb.append(htmc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contract toEntityModel() {
		ContractImpl contractImpl = new ContractImpl();

		if (contractId == null) {
			contractImpl.setContractId(StringPool.BLANK);
		}
		else {
			contractImpl.setContractId(contractId);
		}

		if (htlb == null) {
			contractImpl.setHtlb(StringPool.BLANK);
		}
		else {
			contractImpl.setHtlb(htlb);
		}

		if (bjbh == null) {
			contractImpl.setBjbh(StringPool.BLANK);
		}
		else {
			contractImpl.setBjbh(bjbh);
		}

		if (bdh == null) {
			contractImpl.setBdh(StringPool.BLANK);
		}
		else {
			contractImpl.setBdh(bdh);
		}

		if (cbfs == null) {
			contractImpl.setCbfs(StringPool.BLANK);
		}
		else {
			contractImpl.setCbfs(cbfs);
		}

		if (htmc == null) {
			contractImpl.setHtmc(StringPool.BLANK);
		}
		else {
			contractImpl.setHtmc(htmc);
		}

		contractImpl.resetOriginalValues();

		return contractImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contractId = objectInput.readUTF();
		htlb = objectInput.readUTF();
		bjbh = objectInput.readUTF();
		bdh = objectInput.readUTF();
		cbfs = objectInput.readUTF();
		htmc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (contractId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contractId);
		}

		if (htlb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htlb);
		}

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		if (bdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bdh);
		}

		if (cbfs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cbfs);
		}

		if (htmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htmc);
		}
	}

	public String contractId;
	public String htlb;
	public String bjbh;
	public String bdh;
	public String cbfs;
	public String htmc;
}