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

package com.justonetech.expert.model.impl;

import com.justonetech.expert.model.Jbxx;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Jbxx in entity cache.
 *
 * @author fanqi
 * @see Jbxx
 * @generated
 */
public class JbxxCacheModel implements CacheModel<Jbxx>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{jbxxId=");
		sb.append(jbxxId);
		sb.append(", xm=");
		sb.append(xm);
		sb.append(", xb=");
		sb.append(xb);
		sb.append(", sfzh=");
		sb.append(sfzh);
		sb.append(", csny=");
		sb.append(csny);
		sb.append(", gzdw=");
		sb.append(gzdw);
		sb.append(", dzyx=");
		sb.append(dzyx);
		sb.append(", txdz=");
		sb.append(txdz);
		sb.append(", yzbm=");
		sb.append(yzbm);
		sb.append(", xrzw=");
		sb.append(xrzw);
		sb.append(", zc=");
		sb.append(zc);
		sb.append(", zyzg=");
		sb.append(zyzg);
		sb.append(", cszy=");
		sb.append(cszy);
		sb.append(", zygznx=");
		sb.append(zygznx);
		sb.append(", sjhm=");
		sb.append(sjhm);
		sb.append(", lxdh=");
		sb.append(lxdh);
		sb.append(", cz=");
		sb.append(cz);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Jbxx toEntityModel() {
		JbxxImpl jbxxImpl = new JbxxImpl();

		jbxxImpl.setJbxxId(jbxxId);

		if (xm == null) {
			jbxxImpl.setXm(StringPool.BLANK);
		}
		else {
			jbxxImpl.setXm(xm);
		}

		if (xb == null) {
			jbxxImpl.setXb(StringPool.BLANK);
		}
		else {
			jbxxImpl.setXb(xb);
		}

		if (sfzh == null) {
			jbxxImpl.setSfzh(StringPool.BLANK);
		}
		else {
			jbxxImpl.setSfzh(sfzh);
		}

		if (csny == Long.MIN_VALUE) {
			jbxxImpl.setCsny(null);
		}
		else {
			jbxxImpl.setCsny(new Date(csny));
		}

		if (gzdw == null) {
			jbxxImpl.setGzdw(StringPool.BLANK);
		}
		else {
			jbxxImpl.setGzdw(gzdw);
		}

		if (dzyx == null) {
			jbxxImpl.setDzyx(StringPool.BLANK);
		}
		else {
			jbxxImpl.setDzyx(dzyx);
		}

		if (txdz == null) {
			jbxxImpl.setTxdz(StringPool.BLANK);
		}
		else {
			jbxxImpl.setTxdz(txdz);
		}

		if (yzbm == null) {
			jbxxImpl.setYzbm(StringPool.BLANK);
		}
		else {
			jbxxImpl.setYzbm(yzbm);
		}

		if (xrzw == null) {
			jbxxImpl.setXrzw(StringPool.BLANK);
		}
		else {
			jbxxImpl.setXrzw(xrzw);
		}

		if (zc == null) {
			jbxxImpl.setZc(StringPool.BLANK);
		}
		else {
			jbxxImpl.setZc(zc);
		}

		if (zyzg == null) {
			jbxxImpl.setZyzg(StringPool.BLANK);
		}
		else {
			jbxxImpl.setZyzg(zyzg);
		}

		if (cszy == null) {
			jbxxImpl.setCszy(StringPool.BLANK);
		}
		else {
			jbxxImpl.setCszy(cszy);
		}

		if (zygznx == null) {
			jbxxImpl.setZygznx(StringPool.BLANK);
		}
		else {
			jbxxImpl.setZygznx(zygznx);
		}

		if (sjhm == null) {
			jbxxImpl.setSjhm(StringPool.BLANK);
		}
		else {
			jbxxImpl.setSjhm(sjhm);
		}

		if (lxdh == null) {
			jbxxImpl.setLxdh(StringPool.BLANK);
		}
		else {
			jbxxImpl.setLxdh(lxdh);
		}

		if (cz == null) {
			jbxxImpl.setCz(StringPool.BLANK);
		}
		else {
			jbxxImpl.setCz(cz);
		}

		jbxxImpl.resetOriginalValues();

		return jbxxImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jbxxId = objectInput.readLong();
		xm = objectInput.readUTF();
		xb = objectInput.readUTF();
		sfzh = objectInput.readUTF();
		csny = objectInput.readLong();
		gzdw = objectInput.readUTF();
		dzyx = objectInput.readUTF();
		txdz = objectInput.readUTF();
		yzbm = objectInput.readUTF();
		xrzw = objectInput.readUTF();
		zc = objectInput.readUTF();
		zyzg = objectInput.readUTF();
		cszy = objectInput.readUTF();
		zygznx = objectInput.readUTF();
		sjhm = objectInput.readUTF();
		lxdh = objectInput.readUTF();
		cz = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jbxxId);

		if (xm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xm);
		}

		if (xb == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xb);
		}

		if (sfzh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sfzh);
		}

		objectOutput.writeLong(csny);

		if (gzdw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gzdw);
		}

		if (dzyx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dzyx);
		}

		if (txdz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(txdz);
		}

		if (yzbm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yzbm);
		}

		if (xrzw == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xrzw);
		}

		if (zc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zc);
		}

		if (zyzg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zyzg);
		}

		if (cszy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cszy);
		}

		if (zygznx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zygznx);
		}

		if (sjhm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sjhm);
		}

		if (lxdh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lxdh);
		}

		if (cz == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cz);
		}
	}

	public long jbxxId;
	public String xm;
	public String xb;
	public String sfzh;
	public long csny;
	public String gzdw;
	public String dzyx;
	public String txdz;
	public String yzbm;
	public String xrzw;
	public String zc;
	public String zyzg;
	public String cszy;
	public String zygznx;
	public String sjhm;
	public String lxdh;
	public String cz;
}