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

package com.justonetech.cp.complete.model.impl;

import com.justonetech.cp.complete.model.CompleteUnitProject;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CompleteUnitProject in entity cache.
 *
 * @author fanqi
 * @see CompleteUnitProject
 * @generated
 */
public class CompleteUnitProjectCacheModel implements CacheModel<CompleteUnitProject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{projectId=");
		sb.append(projectId);
		sb.append(", completeId=");
		sb.append(completeId);
		sb.append(", permitUnitProjectId=");
		sb.append(permitUnitProjectId);
		sb.append(", bjbh=");
		sb.append(bjbh);
		sb.append(", sgxkzbh=");
		sb.append(sgxkzbh);
		sb.append(", gcbh=");
		sb.append(gcbh);
		sb.append(", gcmc=");
		sb.append(gcmc);
		sb.append(", jsnr=");
		sb.append(jsnr);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompleteUnitProject toEntityModel() {
		CompleteUnitProjectImpl completeUnitProjectImpl = new CompleteUnitProjectImpl();

		completeUnitProjectImpl.setProjectId(projectId);
		completeUnitProjectImpl.setCompleteId(completeId);
		completeUnitProjectImpl.setPermitUnitProjectId(permitUnitProjectId);

		if (bjbh == null) {
			completeUnitProjectImpl.setBjbh(StringPool.BLANK);
		}
		else {
			completeUnitProjectImpl.setBjbh(bjbh);
		}

		if (sgxkzbh == null) {
			completeUnitProjectImpl.setSgxkzbh(StringPool.BLANK);
		}
		else {
			completeUnitProjectImpl.setSgxkzbh(sgxkzbh);
		}

		if (gcbh == null) {
			completeUnitProjectImpl.setGcbh(StringPool.BLANK);
		}
		else {
			completeUnitProjectImpl.setGcbh(gcbh);
		}

		if (gcmc == null) {
			completeUnitProjectImpl.setGcmc(StringPool.BLANK);
		}
		else {
			completeUnitProjectImpl.setGcmc(gcmc);
		}

		if (jsnr == null) {
			completeUnitProjectImpl.setJsnr(StringPool.BLANK);
		}
		else {
			completeUnitProjectImpl.setJsnr(jsnr);
		}

		completeUnitProjectImpl.resetOriginalValues();

		return completeUnitProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectId = objectInput.readLong();
		completeId = objectInput.readLong();
		permitUnitProjectId = objectInput.readLong();
		bjbh = objectInput.readUTF();
		sgxkzbh = objectInput.readUTF();
		gcbh = objectInput.readUTF();
		gcmc = objectInput.readUTF();
		jsnr = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectId);
		objectOutput.writeLong(completeId);
		objectOutput.writeLong(permitUnitProjectId);

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		if (sgxkzbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sgxkzbh);
		}

		if (gcbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gcbh);
		}

		if (gcmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gcmc);
		}

		if (jsnr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsnr);
		}
	}

	public long projectId;
	public long completeId;
	public long permitUnitProjectId;
	public String bjbh;
	public String sgxkzbh;
	public String gcbh;
	public String gcmc;
	public String jsnr;
}