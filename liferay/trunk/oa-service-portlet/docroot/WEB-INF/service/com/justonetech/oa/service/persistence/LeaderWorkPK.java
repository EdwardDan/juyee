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

package com.justonetech.oa.service.persistence;

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Date;

/**
 * @author justonetech
 * @generated
 */
public class LeaderWorkPK implements Comparable<LeaderWorkPK>, Serializable {
	public long userId;
	public Date workDate;
	public long amOrPm;

	public LeaderWorkPK() {
	}

	public LeaderWorkPK(long userId, Date workDate, long amOrPm) {
		this.userId = userId;
		this.workDate = workDate;
		this.amOrPm = amOrPm;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public long getAmOrPm() {
		return amOrPm;
	}

	public void setAmOrPm(long amOrPm) {
		this.amOrPm = amOrPm;
	}

	@Override
	public int compareTo(LeaderWorkPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(workDate, pk.workDate);

		if (value != 0) {
			return value;
		}

		if (amOrPm < pk.amOrPm) {
			value = -1;
		}
		else if (amOrPm > pk.amOrPm) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LeaderWorkPK)) {
			return false;
		}

		LeaderWorkPK pk = (LeaderWorkPK)obj;

		if ((userId == pk.userId) && (workDate.equals(pk.workDate)) &&
				(amOrPm == pk.amOrPm)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(userId) + workDate.toString() +
		String.valueOf(amOrPm)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("workDate");
		sb.append(StringPool.EQUAL);
		sb.append(workDate);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("amOrPm");
		sb.append(StringPool.EQUAL);
		sb.append(amOrPm);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}