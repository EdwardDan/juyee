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

package com.justonetech.portal.feedback.model.impl;

import com.justonetech.portal.feedback.model.Feedback;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Feedback in entity cache.
 *
 * @author fanqi
 * @see Feedback
 * @generated
 */
public class FeedbackCacheModel implements CacheModel<Feedback>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{feedbackId=");
		sb.append(feedbackId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", zt=");
		sb.append(zt);
		sb.append(", lx=");
		sb.append(lx);
		sb.append(", fkrId=");
		sb.append(fkrId);
		sb.append(", fkrq=");
		sb.append(fkrq);
		sb.append(", fknr=");
		sb.append(fknr);
		sb.append(", hfrId=");
		sb.append(hfrId);
		sb.append(", hfrq=");
		sb.append(hfrq);
		sb.append(", hfjg=");
		sb.append(hfjg);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feedback toEntityModel() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setFeedbackId(feedbackId);
		feedbackImpl.setGroupId(groupId);
		feedbackImpl.setCompanyId(companyId);

		if (zt == null) {
			feedbackImpl.setZt(StringPool.BLANK);
		}
		else {
			feedbackImpl.setZt(zt);
		}

		if (lx == null) {
			feedbackImpl.setLx(StringPool.BLANK);
		}
		else {
			feedbackImpl.setLx(lx);
		}

		feedbackImpl.setFkrId(fkrId);

		if (fkrq == Long.MIN_VALUE) {
			feedbackImpl.setFkrq(null);
		}
		else {
			feedbackImpl.setFkrq(new Date(fkrq));
		}

		if (fknr == null) {
			feedbackImpl.setFknr(StringPool.BLANK);
		}
		else {
			feedbackImpl.setFknr(fknr);
		}

		feedbackImpl.setHfrId(hfrId);

		if (hfrq == Long.MIN_VALUE) {
			feedbackImpl.setHfrq(null);
		}
		else {
			feedbackImpl.setHfrq(new Date(hfrq));
		}

		if (hfjg == null) {
			feedbackImpl.setHfjg(StringPool.BLANK);
		}
		else {
			feedbackImpl.setHfjg(hfjg);
		}

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		feedbackId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		zt = objectInput.readUTF();
		lx = objectInput.readUTF();
		fkrId = objectInput.readLong();
		fkrq = objectInput.readLong();
		fknr = objectInput.readUTF();
		hfrId = objectInput.readLong();
		hfrq = objectInput.readLong();
		hfjg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(feedbackId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (zt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zt);
		}

		if (lx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lx);
		}

		objectOutput.writeLong(fkrId);
		objectOutput.writeLong(fkrq);

		if (fknr == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fknr);
		}

		objectOutput.writeLong(hfrId);
		objectOutput.writeLong(hfrq);

		if (hfjg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hfjg);
		}
	}

	public long feedbackId;
	public long groupId;
	public long companyId;
	public String zt;
	public String lx;
	public long fkrId;
	public long fkrq;
	public String fknr;
	public long hfrId;
	public long hfrq;
	public String hfjg;
}