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

package com.justonetech.cp.permit.model.impl;

import com.justonetech.cp.permit.model.UnitProject;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UnitProject in entity cache.
 *
 * @author fanqi
 * @see UnitProject
 * @generated
 */
public class UnitProjectCacheModel implements CacheModel<UnitProject>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{projectId=");
		sb.append(projectId);
		sb.append(", permitId=");
		sb.append(permitId);
		sb.append(", bjbh=");
		sb.append(bjbh);
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
	public UnitProject toEntityModel() {
		UnitProjectImpl unitProjectImpl = new UnitProjectImpl();

		unitProjectImpl.setProjectId(projectId);
		unitProjectImpl.setPermitId(permitId);

		if (bjbh == null) {
			unitProjectImpl.setBjbh(StringPool.BLANK);
		}
		else {
			unitProjectImpl.setBjbh(bjbh);
		}

		if (gcbh == null) {
			unitProjectImpl.setGcbh(StringPool.BLANK);
		}
		else {
			unitProjectImpl.setGcbh(gcbh);
		}

		if (gcmc == null) {
			unitProjectImpl.setGcmc(StringPool.BLANK);
		}
		else {
			unitProjectImpl.setGcmc(gcmc);
		}

		if (jsnr == null) {
			unitProjectImpl.setJsnr(StringPool.BLANK);
		}
		else {
			unitProjectImpl.setJsnr(jsnr);
		}

		unitProjectImpl.resetOriginalValues();

		return unitProjectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectId = objectInput.readLong();
		permitId = objectInput.readLong();
		bjbh = objectInput.readUTF();
		gcbh = objectInput.readUTF();
		gcmc = objectInput.readUTF();
		jsnr = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(projectId);
		objectOutput.writeLong(permitId);

		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
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
	public long permitId;
	public String bjbh;
	public String gcbh;
	public String gcmc;
	public String jsnr;
}