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

import com.justonetech.expert.model.Expert;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Expert in entity cache.
 *
 * @author fanqi
 * @see Expert
 * @generated
 */
public class ExpertCacheModel implements CacheModel<Expert>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{expertId=");
		sb.append(expertId);
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
	public Expert toEntityModel() {
		ExpertImpl expertImpl = new ExpertImpl();

		expertImpl.setExpertId(expertId);

		if (xm == null) {
			expertImpl.setXm(StringPool.BLANK);
		}
		else {
			expertImpl.setXm(xm);
		}

		if (xb == null) {
			expertImpl.setXb(StringPool.BLANK);
		}
		else {
			expertImpl.setXb(xb);
		}

		if (sfzh == null) {
			expertImpl.setSfzh(StringPool.BLANK);
		}
		else {
			expertImpl.setSfzh(sfzh);
		}

		if (csny == Long.MIN_VALUE) {
			expertImpl.setCsny(null);
		}
		else {
			expertImpl.setCsny(new Date(csny));
		}

		if (gzdw == null) {
			expertImpl.setGzdw(StringPool.BLANK);
		}
		else {
			expertImpl.setGzdw(gzdw);
		}

		if (dzyx == null) {
			expertImpl.setDzyx(StringPool.BLANK);
		}
		else {
			expertImpl.setDzyx(dzyx);
		}

		if (txdz == null) {
			expertImpl.setTxdz(StringPool.BLANK);
		}
		else {
			expertImpl.setTxdz(txdz);
		}

		if (yzbm == null) {
			expertImpl.setYzbm(StringPool.BLANK);
		}
		else {
			expertImpl.setYzbm(yzbm);
		}

		if (xrzw == null) {
			expertImpl.setXrzw(StringPool.BLANK);
		}
		else {
			expertImpl.setXrzw(xrzw);
		}

		if (zc == null) {
			expertImpl.setZc(StringPool.BLANK);
		}
		else {
			expertImpl.setZc(zc);
		}

		if (zyzg == null) {
			expertImpl.setZyzg(StringPool.BLANK);
		}
		else {
			expertImpl.setZyzg(zyzg);
		}

		if (cszy == null) {
			expertImpl.setCszy(StringPool.BLANK);
		}
		else {
			expertImpl.setCszy(cszy);
		}

		if (zygznx == null) {
			expertImpl.setZygznx(StringPool.BLANK);
		}
		else {
			expertImpl.setZygznx(zygznx);
		}

		if (sjhm == null) {
			expertImpl.setSjhm(StringPool.BLANK);
		}
		else {
			expertImpl.setSjhm(sjhm);
		}

		if (lxdh == null) {
			expertImpl.setLxdh(StringPool.BLANK);
		}
		else {
			expertImpl.setLxdh(lxdh);
		}

		if (cz == null) {
			expertImpl.setCz(StringPool.BLANK);
		}
		else {
			expertImpl.setCz(cz);
		}

		expertImpl.resetOriginalValues();

		return expertImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expertId = objectInput.readLong();
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
		objectOutput.writeLong(expertId);

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

	public long expertId;
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