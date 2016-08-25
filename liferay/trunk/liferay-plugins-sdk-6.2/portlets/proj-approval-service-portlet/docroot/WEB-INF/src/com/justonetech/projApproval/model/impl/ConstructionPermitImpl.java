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

package com.justonetech.projApproval.model.impl;



import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The extended model implementation for the ConstructionPermit service. Represents a row in the &quot;projApproval_ConstructionPermit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.justonetech.projApproval.model.ConstructionPermit} interface.
 * </p>
 *
 * @author justonetech
 */
public class ConstructionPermitImpl extends ConstructionPermitBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a construction permit model instance should use the {@link com.justonetech.projApproval.model.ConstructionPermit} interface instead.
	 */
	public ConstructionPermitImpl() {
	}
	
	public String getProjTypeStr() throws PortalException, SystemException{
		String projTypeName="";
		if(Validator.isNotNull(getProjType())){
			Dictionary dictionary=DictionaryLocalServiceUtil.getDictionary(getProjType());
			projTypeName=dictionary.getName();
		}
		return projTypeName;
	}
		
		
	
}