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

package com.justonetech.cp.project.model.impl;

import com.justonetech.cp.project.model.Project;

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
		StringBundler sb = new StringBundler(15);

		sb.append("{projectId=");
		sb.append(projectId);
		sb.append(", zzjgdm=");
		sb.append(zzjgdm);
		sb.append(", bjrq=");
		sb.append(bjrq);
		sb.append(", bjWebid=");
		sb.append(bjWebid);
		sb.append(", xmmc=");
		sb.append(xmmc);
		sb.append(", bjwcbj=");
		sb.append(bjwcbj);
		sb.append(", jsdwmc=");
		sb.append(jsdwmc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Project toEntityModel() {
		ProjectImpl projectImpl = new ProjectImpl();

		if (projectId == null) {
			projectImpl.setProjectId(StringPool.BLANK);
		}
		else {
			projectImpl.setProjectId(projectId);
		}

		if (zzjgdm == null) {
			projectImpl.setZzjgdm(StringPool.BLANK);
		}
		else {
			projectImpl.setZzjgdm(zzjgdm);
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

		if (jsdwmc == null) {
			projectImpl.setJsdwmc(StringPool.BLANK);
		}
		else {
			projectImpl.setJsdwmc(jsdwmc);
		}

		projectImpl.resetOriginalValues();

		return projectImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectId = objectInput.readUTF();
		zzjgdm = objectInput.readUTF();
		bjrq = objectInput.readLong();
		bjWebid = objectInput.readUTF();
		xmmc = objectInput.readUTF();
		bjwcbj = objectInput.readUTF();
		jsdwmc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (projectId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectId);
		}

		if (zzjgdm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zzjgdm);
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

		if (jsdwmc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jsdwmc);
		}
	}

	public String projectId;
	public String zzjgdm;
	public long bjrq;
	public String bjWebid;
	public String xmmc;
	public String bjwcbj;
	public String jsdwmc;
}