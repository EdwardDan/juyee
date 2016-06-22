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

package com.justonetech.proj.model.impl;

import com.justonetech.proj.model.Company;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Company in entity cache.
 *
 * @author fanqi
 * @see Company
 * @generated
 */
public class CompanyCacheModel implements CacheModel<Company>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", unitName=");
		sb.append(unitName);
		sb.append(", indepLegal=");
		sb.append(indepLegal);
		sb.append(", indepLegalTel=");
		sb.append(indepLegalTel);
		sb.append(", indepLegalFax=");
		sb.append(indepLegalFax);
		sb.append(", indepLegalPhone=");
		sb.append(indepLegalPhone);
		sb.append(", projLegal=");
		sb.append(projLegal);
		sb.append(", projLegalTel=");
		sb.append(projLegalTel);
		sb.append(", projLegalFax=");
		sb.append(projLegalFax);
		sb.append(", projLegalPhone=");
		sb.append(projLegalPhone);
		sb.append(", linkman=");
		sb.append(linkman);
		sb.append(", linkmanTel=");
		sb.append(linkmanTel);
		sb.append(", linkmanFax=");
		sb.append(linkmanFax);
		sb.append(", linkmanPhone=");
		sb.append(linkmanPhone);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", biddingId=");
		sb.append(biddingId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Company toEntityModel() {
		CompanyImpl companyImpl = new CompanyImpl();

		companyImpl.setCompanyId(companyId);
		companyImpl.setType(type);

		if (unitName == null) {
			companyImpl.setUnitName(StringPool.BLANK);
		}
		else {
			companyImpl.setUnitName(unitName);
		}

		if (indepLegal == null) {
			companyImpl.setIndepLegal(StringPool.BLANK);
		}
		else {
			companyImpl.setIndepLegal(indepLegal);
		}

		if (indepLegalTel == null) {
			companyImpl.setIndepLegalTel(StringPool.BLANK);
		}
		else {
			companyImpl.setIndepLegalTel(indepLegalTel);
		}

		if (indepLegalFax == null) {
			companyImpl.setIndepLegalFax(StringPool.BLANK);
		}
		else {
			companyImpl.setIndepLegalFax(indepLegalFax);
		}

		if (indepLegalPhone == null) {
			companyImpl.setIndepLegalPhone(StringPool.BLANK);
		}
		else {
			companyImpl.setIndepLegalPhone(indepLegalPhone);
		}

		if (projLegal == null) {
			companyImpl.setProjLegal(StringPool.BLANK);
		}
		else {
			companyImpl.setProjLegal(projLegal);
		}

		if (projLegalTel == null) {
			companyImpl.setProjLegalTel(StringPool.BLANK);
		}
		else {
			companyImpl.setProjLegalTel(projLegalTel);
		}

		if (projLegalFax == null) {
			companyImpl.setProjLegalFax(StringPool.BLANK);
		}
		else {
			companyImpl.setProjLegalFax(projLegalFax);
		}

		if (projLegalPhone == null) {
			companyImpl.setProjLegalPhone(StringPool.BLANK);
		}
		else {
			companyImpl.setProjLegalPhone(projLegalPhone);
		}

		if (linkman == null) {
			companyImpl.setLinkman(StringPool.BLANK);
		}
		else {
			companyImpl.setLinkman(linkman);
		}

		if (linkmanTel == null) {
			companyImpl.setLinkmanTel(StringPool.BLANK);
		}
		else {
			companyImpl.setLinkmanTel(linkmanTel);
		}

		if (linkmanFax == null) {
			companyImpl.setLinkmanFax(StringPool.BLANK);
		}
		else {
			companyImpl.setLinkmanFax(linkmanFax);
		}

		if (linkmanPhone == null) {
			companyImpl.setLinkmanPhone(StringPool.BLANK);
		}
		else {
			companyImpl.setLinkmanPhone(linkmanPhone);
		}

		companyImpl.setProjectId(projectId);
		companyImpl.setBiddingId(biddingId);

		companyImpl.resetOriginalValues();

		return companyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();
		type = objectInput.readLong();
		unitName = objectInput.readUTF();
		indepLegal = objectInput.readUTF();
		indepLegalTel = objectInput.readUTF();
		indepLegalFax = objectInput.readUTF();
		indepLegalPhone = objectInput.readUTF();
		projLegal = objectInput.readUTF();
		projLegalTel = objectInput.readUTF();
		projLegalFax = objectInput.readUTF();
		projLegalPhone = objectInput.readUTF();
		linkman = objectInput.readUTF();
		linkmanTel = objectInput.readUTF();
		linkmanFax = objectInput.readUTF();
		linkmanPhone = objectInput.readUTF();
		projectId = objectInput.readLong();
		biddingId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(type);

		if (unitName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unitName);
		}

		if (indepLegal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indepLegal);
		}

		if (indepLegalTel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indepLegalTel);
		}

		if (indepLegalFax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indepLegalFax);
		}

		if (indepLegalPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indepLegalPhone);
		}

		if (projLegal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projLegal);
		}

		if (projLegalTel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projLegalTel);
		}

		if (projLegalFax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projLegalFax);
		}

		if (projLegalPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projLegalPhone);
		}

		if (linkman == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkman);
		}

		if (linkmanTel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkmanTel);
		}

		if (linkmanFax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkmanFax);
		}

		if (linkmanPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkmanPhone);
		}

		objectOutput.writeLong(projectId);
		objectOutput.writeLong(biddingId);
	}

	public long companyId;
	public long type;
	public String unitName;
	public String indepLegal;
	public String indepLegalTel;
	public String indepLegalFax;
	public String indepLegalPhone;
	public String projLegal;
	public String projLegalTel;
	public String projLegalFax;
	public String projLegalPhone;
	public String linkman;
	public String linkmanTel;
	public String linkmanFax;
	public String linkmanPhone;
	public long projectId;
	public long biddingId;
}