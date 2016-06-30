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

package com.justonetech.sys.service.http;

import com.justonetech.sys.service.DictionaryServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.justonetech.sys.service.DictionaryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.justonetech.sys.model.DictionarySoap}.
 * If the method in the service utility returns a
 * {@link com.justonetech.sys.model.Dictionary}, that is translated to a
 * {@link com.justonetech.sys.model.DictionarySoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author justonetech
 * @see DictionaryServiceHttp
 * @see com.justonetech.sys.model.DictionarySoap
 * @see com.justonetech.sys.service.DictionaryServiceUtil
 * @generated
 */
public class DictionaryServiceSoap {
	public static com.justonetech.sys.model.DictionarySoap findByGroupIdAndCode(
		long groupId, java.lang.String code) throws RemoteException {
		try {
			com.justonetech.sys.model.Dictionary returnValue = DictionaryServiceUtil.findByGroupIdAndCode(groupId,
					code);

			return com.justonetech.sys.model.DictionarySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.justonetech.sys.model.DictionarySoap[] findByGroupIdAndParentId(
		long groupId, long parentId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.justonetech.sys.model.Dictionary> returnValue = DictionaryServiceUtil.findByGroupIdAndParentId(groupId,
					parentId, start, end);

			return com.justonetech.sys.model.DictionarySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByGroupIdAndParentId(long groupId, long parentId)
		throws RemoteException {
		try {
			int returnValue = DictionaryServiceUtil.countByGroupIdAndParentId(groupId,
					parentId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.justonetech.sys.model.DictionarySoap[] findByParentIdAndIsValid(
		long parentId, boolean isValid, int start, int end)
		throws RemoteException {
		try {
			java.util.List<com.justonetech.sys.model.Dictionary> returnValue = DictionaryServiceUtil.findByParentIdAndIsValid(parentId,
					isValid, start, end);

			return com.justonetech.sys.model.DictionarySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int countByParentIdAndIsValid(long parentId, boolean isValid)
		throws RemoteException {
		try {
			int returnValue = DictionaryServiceUtil.countByParentIdAndIsValid(parentId,
					isValid);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DictionaryServiceSoap.class);
}