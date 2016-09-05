/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.justonetech.cp.permit;

import com.liferay.portal.NoSuchModelException;

/**
 * @author fanqi
 */
public class NoSuchParticipationUnitException extends NoSuchModelException {

	public NoSuchParticipationUnitException() {
		super();
	}

	public NoSuchParticipationUnitException(String msg) {
		super(msg);
	}

	public NoSuchParticipationUnitException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchParticipationUnitException(Throwable cause) {
		super(cause);
	}

}