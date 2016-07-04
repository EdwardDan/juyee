
package com.justonetech.sys.portlet.dictionary;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.sql.CommonDataSource;

import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DictionaryPortlet
 */
public class DictionaryPortlet extends MVCPortlet {

    private static Log log = LogFactoryUtil.getLog(DictionaryPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        long groupId = 0;
        try {
            groupId = PortalUtil.getScopeGroupId(renderRequest);
        }
        catch (PortalException | SystemException e) {
            log.info("无法获取groupId：" + e.getMessage());
        }
        long parentId = ParamUtil.getLong(renderRequest, "parentId", 0);
        Dictionary parentDictionary = null;
        if (parentId != 0) {
            try {
                parentDictionary = DictionaryLocalServiceUtil.getDictionary(parentId);
            }
            catch (PortalException | SystemException e) {
                log.info("DictionaryLocalServiceUtil.getDictionary(parentId)：" + e.getMessage());
            }
        }
        String keywords = ParamUtil.getString(renderRequest, "keywords");
        int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
        int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
        int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
        int start = pageSize * (pageNumber - 1);
        int end = pageSize * pageNumber;

        List<Dictionary> dictionaries = Collections.emptyList();
        try {
            dictionaries = DictionaryLocalServiceUtil.findByG_P_K(groupId, parentId, keywords, start, end);
        }
        catch (SystemException e) {
            log.info("DictionaryLocalServiceUtil.findByG_P_K(" + keywords + ", " + start + ", " + end + ")出错：" +
                e.getMessage());
        }
        int dictionariesCount = 0;
        try {
            dictionariesCount = DictionaryLocalServiceUtil.countByG_P_K(groupId, parentId, keywords);
        }
        catch (SystemException e) {
            log.info("DictionaryLocalServiceUtil.countByG_P_K(" + keywords + ")出错：" + e.getMessage());

        }
        renderRequest.setAttribute("dictionaries", dictionaries);
        renderRequest.setAttribute("dictionariesCount", dictionariesCount);
        renderRequest.setAttribute("parentId", parentId);
        renderRequest.setAttribute("parentDictionary", parentDictionary);
        super.doView(renderRequest, renderResponse);
    }

    public void editDictionary(ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException, PortalException, SystemException {

        long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId", 0);
        Dictionary dictionary = null;

        if (dictionaryId != 0) {
            dictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
        }
        else {
            long parentId = ParamUtil.getLong(actionRequest, "parentId", 0);
            Dictionary parentDictionary = null;
            if (parentId != 0) {
                parentDictionary = DictionaryLocalServiceUtil.getDictionary(parentId);
                actionRequest.setAttribute("parentDictionary", parentDictionary);
            }
            long groupId = PortalUtil.getScopeGroupId(actionRequest);
            List<Dictionary> dictionaries =
                DictionaryLocalServiceUtil.findByGroupIdAndParentId(
                    groupId, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

            int sortNo = (dictionaries.isEmpty() ? 0 : dictionaries.get(dictionaries.size() - 1).getSortNo()) + 1;
            actionRequest.setAttribute("sortNo", sortNo);

        }
        actionRequest.setAttribute("dictionary", dictionary);

    }

    public void saveDictionary(ActionRequest actionRequest, ActionResponse actionResponse)
        throws IOException, PortletException, SystemException, PortalException {

        long dictionaryId = ParamUtil.getLong(actionRequest, "dictionaryId");

        String name = ParamUtil.getString(actionRequest, "name");
        String code = ParamUtil.getString(actionRequest, "code");
        int sortNo = ParamUtil.getInteger(actionRequest, "sortNo");
        boolean isValid = ParamUtil.getBoolean(actionRequest, "isValid");
        String tag = ParamUtil.getString(actionRequest, "tag");
        String desc = ParamUtil.getString(actionRequest, "desc");

        Dictionary dictionary = null;
        String cmd = "add";
        Date now = new Date();
        if (dictionaryId == 0) {
            dictionaryId = CounterLocalServiceUtil.increment();
            dictionary = DictionaryLocalServiceUtil.createDictionary(dictionaryId);

            long groupId = PortalUtil.getScopeGroupId(actionRequest);

            dictionary.setGroupId(groupId);
            long parentId = ParamUtil.getLong(actionRequest, "parentId");
            dictionary.setParentId(parentId);
            dictionary.setTreePath((dictionary.getParentId() == 0
                ? StringPool.SLASH : dictionary.getParentDictionary().getTreePath()) +
                dictionary.getDictionaryId() +
                StringPool.SLASH);
            dictionary.setCreateTime(now);
            dictionary.setIsLeaf(true);
            dictionary.setNew(true);

        }
        else {
            cmd = "edit";
            dictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
            dictionary.setNew(false);
        }

        User user = PortalUtil.getUser(actionRequest);
        if (Validator.isNotNull(user)) {
            dictionary.setUserId(user.getUserId());
            dictionary.setUserName(user.getFullName());
        }

        dictionary.setName(name);
        dictionary.setCode(code);
        dictionary.setSortNo(sortNo);
        dictionary.setSortPath((dictionary.getParentId() == 0
            ? StringPool.SLASH : dictionary.getParentDictionary().getSortPath()) +
            String.format("%05d", sortNo) +
            StringPool.SLASH);
        
        dictionary.setIsValid(isValid);
        dictionary.setDesc(desc);
        dictionary.setTag(tag);
        dictionary.setModifiedTime(now);

        dictionary = DictionaryLocalServiceUtil.updateDictionary(dictionary);
        if (cmd.equals("add")) {
            if (dictionary.getParentDictionary() != null) {
                DictionaryLocalServiceUtil.updateIsLeaf(dictionary.getParentDictionary(), false, user);
            }
        }
        else if (cmd.equals("edit")) {
            DictionaryLocalServiceUtil.recursiveUpdateSortPath(dictionary);
        }

    }

    public void deleteDictionaries(ActionRequest actionRequest, ActionResponse actionResponse)
        throws PortalException, SystemException {

        long parentId = ParamUtil.getInteger(actionRequest, "parentId", 0);
        String deleteDictionaryIds = ParamUtil.getString(actionRequest, "dictionaryIds");
        String[] dictionaryIds = deleteDictionaryIds.split(",");
        DictionaryLocalServiceUtil.recursiveDeleteDictionaries(dictionaryIds);
        long groupId = PortalUtil.getScopeGroupId(actionRequest);
        if (parentId != 0) {
            int dictionariesCount = DictionaryLocalServiceUtil.countByGroupIdAndParentId(groupId, parentId);
            if (dictionariesCount == 0) {
                DictionaryLocalServiceUtil.updateIsLeaf(
                    DictionaryLocalServiceUtil.getDictionary(parentId), true, PortalUtil.getUser(actionRequest));
            }
        }
    }

}
