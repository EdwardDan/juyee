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

package com.justonetech.xmq.project.model.impl;

import com.justonetech.xmq.project.model.Project;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author fanqi
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{bjbh=");
		sb.append(bjbh);
		sb.append(", bjrq=");
		sb.append(bjrq);
		sb.append(", bjWebid=");
		sb.append(bjWebid);
		sb.append(", xmmc=");
		sb.append(xmmc);
		sb.append(", bjwcbj=");
		sb.append(bjwcbj);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		if (bjbh == null) {
			projectImpl.setBjbh(StringPool.BLANK);
		}
		else {
			projectImpl.setBjbh(bjbh);
		}

		if (bjrq == Long.MIN_VALUE) {
			projectImpl.setBjrq(null);
		}
		else {
			projectImpl.setBjrq(new Date(bjrq));
		}

		if (bjWebid == null) {
			projectImpl.setBjWebid(StringPool.BLANK);
		}
		else {
			projectImpl.setBjWebid(bjWebid);
		}

		if (xmmc == null) {
			projectImpl.setXmmc(StringPool.BLANK);
		}
		else {
			projectImpl.setXmmc(xmmc);
		}

		if (bjwcbj == null) {
			projectImpl.setBjwcbj(StringPool.BLANK);
		}
		else {
			projectImpl.setBjwcbj(bjwcbj);
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bjbh = objectInput.readUTF();
		bjrq = objectInput.readLong();
		bjWebid = objectInput.readUTF();
		xmmc = objectInput.readUTF();
		bjwcbj = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (bjbh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjbh);
		}

		objectOutput.writeLong(bjrq);

		if (bjWebid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjWebid);
		}

		if (xmmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xmmc);
		}

		if (bjwcbj == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bjwcbj);
		}
	}

	public String bjbh;
	public long bjrq;
	public String bjWebid;
	public String xmmc;
	public String bjwcbj;
}