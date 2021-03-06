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

package com.justonetech.sys.model.impl;

import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model implementation for the Dictionary service. Represents a
 * row in the &quot;sys_Dictionary&quot; database table, with each column mapped
 * to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the {@link com.justonetech.sys.model.Dictionary} interface.
 * </p>
 *
 * @author fanqi
 */
public class DictionaryImpl extends DictionaryBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this class directly. All methods that expect a dictionary
	 * model instance should use the {@link
	 * com.justonetech.sys.model.Dictionary} interface instead.
	 */
	public DictionaryImpl() {
	}

	@Override
	public String buildTreePath() throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTreePath(String treePath) throws SystemException {
		// TODO Auto-generated method stub
		super.updateTreePath(treePath);
	}

	public Dictionary getParentDictionary() throws PortalException,
			SystemException {
		if (getParentId() != 0) {
			return DictionaryLocalServiceUtil.getDictionary(getParentId());
		}
		return null;
	}

}