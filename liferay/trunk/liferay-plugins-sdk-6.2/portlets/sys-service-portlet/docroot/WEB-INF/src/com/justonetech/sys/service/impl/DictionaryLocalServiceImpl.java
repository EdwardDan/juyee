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

import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.justonetech.sys.NoSuchDictionaryException;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.justonetech.sys.service.base.DictionaryLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

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

    private static Log log = LogFactoryUtil.getLog(DictionaryLocalServiceImpl.class);

    /*
     * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
     * {@link com.justonetech.sys.service.DictionaryLocalServiceUtil} to access
     * the dictionary local service.
     */
    public Dictionary findByCode(String code)
        throws SystemException {

        Dictionary dictionary = null;
        try {
            dictionary = dictionaryPersistence.findByCode(code);
        }
        catch (NoSuchDictionaryException e) {
            log.info("获取code="+code+"的Dictionary出错！");
        }
        return dictionary;
    }

    public List<Dictionary> findByParentId(long parentId, int start, int end){

        try {
            return dictionaryPersistence.findByParentId(parentId, start, end);
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public int countByParentId(long parentId)
        throws SystemException {

        return dictionaryPersistence.countByParentId(parentId);
    }

    public List<Dictionary> findByParentIdIsValid(long parentId, boolean isValid, int start, int end)
        throws SystemException {

        return dictionaryPersistence.findByParentIdIsValid(parentId, isValid, start, end);
    }

    public int countByParentIdIsValid(long parentId, boolean isValid)
        throws SystemException {

        return dictionaryPersistence.countByParentIdIsValid(parentId, isValid);
    }

    public List<Dictionary> findByParentIdKeywords(long parentId, String keywords, int start, int end) {

        try {
            return this.dynamicQuery(createByParentIdKeywords(parentId, keywords), start, end);
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
        return Collections.emptyList(); 
    }

    public int countByParentIdKeywords(long parentId, String keywords)
        throws SystemException {

        return (int) this.dynamicQueryCount(createByParentIdKeywords(parentId, keywords));
    }

    public DynamicQuery createByParentIdKeywords(long parentId, String keywords) {

        DynamicQuery dynamicQuery = this.dynamicQuery();
        dynamicQuery.add(PropertyFactoryUtil.forName("parentId").eq(parentId));
        Junction junction = RestrictionsFactoryUtil.disjunction();
        junction.add(PropertyFactoryUtil.forName("name").like("%" + keywords + "%"));
        junction.add(PropertyFactoryUtil.forName("code").like("%" + keywords + "%"));
        dynamicQuery.add(junction);
        dynamicQuery.addOrder(OrderFactoryUtil.asc("sortPath"));
        return dynamicQuery;
    }

    public void deleteDictionaries(String[] dictionaryIds) {

        for (String dictionaryId : dictionaryIds) {
            try {
                dictionaryPersistence.remove(Long.parseLong(dictionaryId));
            }
            catch (NumberFormatException | PortalException | SystemException e) {
                e.printStackTrace();
            }
        }
    }

    public void recursiveDeleteDictionaries(String[] dictionaryIds) {

        for (String dictionaryId : dictionaryIds) {
            try {
                recursiveDeleteDictionary(dictionaryPersistence.fetchByPrimaryKey(Long.parseLong(dictionaryId)));

            }
            catch (NumberFormatException | SystemException e) {
                e.printStackTrace();
            }
        }
    }

    public void recursiveDeleteDictionary(Dictionary parentDictionary)
        throws SystemException {

        dictionaryPersistence.remove(parentDictionary);
        List<Dictionary> dictionaries =
            dictionaryPersistence.findByParentId(parentDictionary.getDictionaryId());
        for (Dictionary dictionary : dictionaries) {
            recursiveDeleteDictionary(dictionary);
        }
    }

    public Dictionary updateIsLeaf(Dictionary dictionary, boolean isLeaf, User user)
        throws SystemException, PortalException {

        dictionary.setIsLeaf(false);
        dictionary.setModifiedTime(new Date());
        if (Validator.isNotNull(user)) {
            dictionary.setUserId(user.getUserId());
            dictionary.setUserName(user.getFullName());
        }
        return DictionaryLocalServiceUtil.updateDictionary(dictionary);
    }

    public void recursiveUpdateSortPath(Dictionary parentDictionary)
        throws SystemException {

        List<Dictionary> dictionaries = Collections.emptyList();
        dictionaries =
            dictionaryPersistence.findByParentId(parentDictionary.getDictionaryId());

        for (Dictionary dictionary : dictionaries) {
            dictionary.setModifiedTime(new Date());
            dictionary.setUserId(parentDictionary.getUserId());
            dictionary.setUserName(parentDictionary.getUserName());
            dictionary.setSortPath((dictionary.getParentId() == 0 ? StringPool.SLASH : parentDictionary.getSortPath()) +
                String.format("%05d", dictionary.getSortNo()) + StringPool.SLASH);
            DictionaryLocalServiceUtil.updateDictionary(dictionary);
            recursiveUpdateSortPath(dictionary);
        }
    }
}
