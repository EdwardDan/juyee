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

package com.justonetech.sys.service.impl;

import java.util.List;

import com.justonetech.sys.NoSuchDictionaryException;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.base.DictionaryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the dictionary local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.justonetech.sys.service.DictionaryLocalService} interface. <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author fanqi
 * @see com.justonetech.sys.service.base.DictionaryLocalServiceBaseImpl
 * @see com.justonetech.sys.service.DictionaryLocalServiceUtil
 */
public class DictionaryLocalServiceImpl extends DictionaryLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
     * {@link com.justonetech.sys.service.DictionaryLocalServiceUtil} to access
     * the dictionary local service.
     */
    public Dictionary findByGroupIdAndCode(long groupId, String code)
        throws SystemException, NoSuchDictionaryException {

        return dictionaryPersistence.findByGroupIdAndCode(groupId, code);
    }

    public List<Dictionary> findByGroupIdAndParentId(long groupId, long parentId, int start, int end)
        throws SystemException {

        return dictionaryPersistence.findByGroupIdAndParentId(groupId, parentId, start, end);
    }

    public int countByGroupIdAndParentId(long groupId, long parentId)
        throws SystemException {

        return dictionaryPersistence.countByGroupIdAndParentId(groupId, parentId);
    }

    public List<Dictionary> findByParentIdAndIsValid(long parentId, boolean isValid, int start, int end)
        throws SystemException {

        return dictionaryPersistence.findByParentIdAndIsValid(parentId, isValid, start, end);
    }

    public int countByParentIdAndIsValid(long parentId, boolean isValid)
        throws SystemException {

        return dictionaryPersistence.countByParentIdAndIsValid(parentId, isValid);
    }

    public List<Dictionary> findByG_P_N_C(long groupId, long parentId, String name, String code, int start, int end)
        throws SystemException {

        return dictionaryPersistence.findByG_P_N_C(groupId, parentId, name, code, start, end);
    }

    public int countByG_P_N_C(long groupId, long parentId, String name, String code)
        throws SystemException {

        return dictionaryPersistence.countByG_P_N_C(groupId, parentId, name, code);
    }
}
