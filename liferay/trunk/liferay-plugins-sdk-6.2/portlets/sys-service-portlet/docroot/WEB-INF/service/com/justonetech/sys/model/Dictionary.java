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

package com.justonetech.sys.model;

import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.model.TreeModel;

/**
 * The extended model interface for the Dictionary service. Represents a row in the &quot;sys_Dictionary&quot; database table, with each column mapped to a property of this class.
 *
 * @author justonetech
 * @see DictionaryModel
 * @see com.justonetech.sys.model.impl.DictionaryImpl
 * @see com.justonetech.sys.model.impl.DictionaryModelImpl
 * @generated
 */
public interface Dictionary extends DictionaryModel, PersistedModel, TreeModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.justonetech.sys.model.impl.DictionaryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public java.lang.String buildTreePath()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	public void updateTreePath(java.lang.String treePath)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.justonetech.sys.model.Dictionary getParentDictionary()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}