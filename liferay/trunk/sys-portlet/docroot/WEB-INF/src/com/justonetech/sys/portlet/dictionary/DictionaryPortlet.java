package com.justonetech.sys.portlet.dictionary;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DictionaryPortlet
 */
public class DictionaryPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// String keywords = ParamUtil.getString(renderRequest, "keywords");
		long dictionaryId = ParamUtil.getLong(renderRequest, "dictionaryId");
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", 15);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = (pageNumber - 1) * pageSize;
		int end = pageNumber * pageSize;
		int totalSize = 0;
		List<Dictionary> dictionaries = null;
		try {
			long groupId = 0;
			try {
				groupId = PortalUtil.getScopeGroupId(renderRequest);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			if (Validator.isNull(dictionaryId)) {
				dictionaries = DictionaryLocalServiceUtil
						.findByGroupIdAndParentId(groupId, 0, start, end);
				totalSize = DictionaryLocalServiceUtil
						.countByGroupIdAndParentId(groupId, 0);
			} else {
				dictionaries = DictionaryLocalServiceUtil
						.findByGroupIdAndParentId(groupId, dictionaryId, start,
								end);
				totalSize = DictionaryLocalServiceUtil
						.countByGroupIdAndParentId(groupId, dictionaryId);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		renderRequest.setAttribute("dictionaries", dictionaries);
		renderRequest.setAttribute("totalSize", totalSize);
		renderRequest.setAttribute("dictionaryId", dictionaryId);
		super.doView(renderRequest, renderResponse);
	}

	public void addCode(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException, ParseException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		long parentId = ParamUtil.getLong(request, "parentId");
		long edit = ParamUtil.getInteger(request, "edit");
		System.out.println("dictionaId=" + dictionaryId + "," + "parentId="
				+ parentId);
		String name = ParamUtil.getString(request, "name");
		String code = ParamUtil.getString(request, "code");
		long groupId = PortalUtil.getScopeGroupId(request);
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "default");
		Date day = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date createDate = sdf.parse(sdf.format(day));
		Dictionary dictionary = null;
		int sortNo = 0;
		String sortPath = null;
		List<Integer> sortNos = new ArrayList<Integer>();
		if (dictionaryId == 0) {// 添加集
			dictionary = DictionaryLocalServiceUtil
					.createDictionary(CounterLocalServiceUtil.increment());
			dictionary.setName(name);
			dictionary.setCode(code);
			dictionary.setCreateDate(createDate);
			dictionary.setGroupId(groupId);
			DictionaryLocalServiceUtil.updateDictionary(dictionary);
			String treePath = "/" + dictionary.getDictionaryId() + "/";
			dictionary.setTreePath(treePath);
			List<Dictionary> dics = DictionaryLocalServiceUtil
					.findByGroupIdAndParentId(groupId, 0, -1, -1);
			if (Validator.isNotNull(dics)) {
				for (Dictionary dic : dics) {
					sortNos.add(dic.getSortNo());
				}
				sortNo = java.util.Collections.max(sortNos) + 1;
				sortPath = "/"
						+ ("00000" + sortNo).substring(
								("00000" + sortNo).length() - 5,
								("00000" + sortNo).length()) + "/";
			} else {
				sortNo = 1;
				sortPath = "/0000" + sortNo;
			}
			dictionary.setSortPath(sortPath);
			dictionary.setSortNo(sortNo);
		} else if (Validator.isNotNull(dictionaryId)
				&& Validator.isNotNull(parentId)) {// 编辑项
			dictionary = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
			dictionary.setName(name);
			dictionary.setCode(code);
			dictionary.setModifiedDate(createDate);
		} else if (Validator.isNotNull(dictionaryId) && parentId == 0) {
			if (edit != 1) {// 添加项
				dictionary = DictionaryLocalServiceUtil
						.createDictionary(CounterLocalServiceUtil.increment());
				dictionary.setName(name);
				dictionary.setCode(code);
				dictionary.setParentId(dictionaryId);
				dictionary.setCreateDate(createDate);
				dictionary.setGroupId(groupId);
				DictionaryLocalServiceUtil.updateDictionary(dictionary);
				String treePath = "/" + dictionaryId + "/"
						+ dictionary.getDictionaryId() + "/";
				dictionary.setTreePath(treePath);
				List<Dictionary> dics = DictionaryLocalServiceUtil
						.findByGroupIdAndParentId(groupId, dictionaryId, -1, -1);
				if (Validator.isNotNull(dics)) {
					for (Dictionary dic : dics) {
						sortNos.add(dic.getSortNo());
					}
					sortNo = Collections.max(sortNos) + 1;
					sortPath = DictionaryLocalServiceUtil.getDictionary(
							dictionaryId).getSortPath()
							+ ("00000" + sortNo).substring(
									("00000" + sortNo).length() - 5,
									("00000" + sortNo).length()) + "/";
				} else {
					sortNo = 1;
					sortPath = DictionaryLocalServiceUtil.getDictionary(
							dictionaryId).getSortPath()
							+ "00001/";
				}
				dictionary.setSortNo(sortNo);
				dictionary.setSortPath(sortPath);
			} else {// 编辑集
				dictionary = DictionaryLocalServiceUtil
						.getDictionary(dictionaryId);
				dictionary.setName(name);
				dictionary.setCode(code);
				dictionary.setModifiedDate(createDate);
			}
		}
		dictionary.setGroupId(groupId);
		dictionary.setUserId(userId);
		dictionary.setUserName(userName);
		DictionaryLocalServiceUtil.updateDictionary(dictionary);
	}

	public void deleteCode(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		long groupId = PortalUtil.getScopeGroupId(request);
		DictionaryLocalServiceUtil.deleteDictionary(dictionaryId);
		List<Dictionary> dictionaries = DictionaryLocalServiceUtil
				.findByGroupIdAndParentId(groupId, dictionaryId, -1, -1);
		for (Dictionary dictionary : dictionaries) {
			DictionaryLocalServiceUtil.deleteDictionary(dictionary);
		}
	}

	public void editCode(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		Dictionary dictionary = DictionaryLocalServiceUtil
				.getDictionary(dictionaryId);
		String name = dictionary.getName();
		String code = dictionary.getCode();
		String desc = dictionary.getDesc();
		String tag = dictionary.getTag();
		long parentId = dictionary.getParentId();
		boolean isValid = dictionary.getIsValid();
		request.setAttribute("name", name);
		request.setAttribute("code", code);
		request.setAttribute("desc", desc);
		request.setAttribute("tag", tag);
		request.setAttribute("isValid", isValid);
		request.setAttribute("parentId", parentId);
		System.out.println("==================" + dictionaryId);
	}
}
