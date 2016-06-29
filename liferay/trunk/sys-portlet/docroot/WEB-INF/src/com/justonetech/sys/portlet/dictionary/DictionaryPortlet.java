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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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

	// 代码集列表显示
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", 5);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = (pageNumber - 1) * pageSize;
		int end = pageNumber * pageSize;
		List<Dictionary> dictionaries = null;
		int totalSize = 0;
		try {
			totalSize = DictionaryPortlet.getCodesCount(keywords);
			if (Validator.isNotNull(keywords)) {
				dictionaries = DictionaryPortlet.getCodesByKeywords(keywords,
						start, end);
				// dictionaries =
				// DictionaryLocalServiceUtil.getCodesByKeyword(keyword, start,
				// end);
			} else {
				dictionaries = DictionaryPortlet.getCodesByKeywords("", start,
						end);
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}

		renderRequest.setAttribute("dictionaries", dictionaries);
		renderRequest.setAttribute("totalSize", totalSize);
		super.doView(renderRequest, renderResponse);
	}

	// 添加代码集
	public void inputCodeSet(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException, ParseException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		String code = ParamUtil.getString(request, "code");
		request.setAttribute("code", code);
		String name = ParamUtil.getString(request, "name");
		String desc = ParamUtil.getString(request, "desc");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "default");
		// 获取当前日期
		Date day = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date createDate = sdf.parse(sdf.format(day));

		List<Integer> list = new ArrayList<Integer>();
		Date modifiedDate = null;
		Dictionary dic = null;
		int sortNo = 0;
		if (Validator.isNotNull(dictionaryId)) {
			int sort = ParamUtil.getInteger(request, "sortNo");
			dic = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
			modifiedDate = sdf.parse(sdf.format(day));
			dic.setCode(code);
			dic.setName(name);
			dic.setDesc(desc);
			dic.setModifiedDate(modifiedDate);
			dic.setSortNo(sort);
			String str = "00000" + sort;
			String sortPath = "/"
					+ str.substring(str.length() - 5, str.length()) + "/";
			dic.setSortPath(sortPath);
			dic.setTreePath("/" + dic.getDictionaryId() + "/");
			List<Dictionary> dics = DictionaryPortlet
					.getCodesByParentId(dictionaryId);
			for (Dictionary di : dics) {
				String sortStr = di.getSortPath();
				String sortPath1 = sortPath
						+ sortStr.substring(sortStr.length() - 6,
								sortStr.length());
				di.setSortPath(sortPath1);
				DictionaryLocalServiceUtil.updateDictionary(di);
			}
			DictionaryLocalServiceUtil.updateDictionary(dic);
		} else {
			dic = DictionaryLocalServiceUtil
					.createDictionary(CounterLocalServiceUtil.increment());
			dic.setCode(code);
			dic.setName(name);
			dic.setDesc(desc);
			dic.setParentId(0);
			dic.setGroupId(groupId);
			dic.setUserId(userId);
			dic.setCompanyId(companyId);
			dic.setUserName(userName);
			dic.setCreateDate(createDate);
			dic.setModifiedDate(modifiedDate);
			dic.setTreePath("/" + dic.getDictionaryId() + "/");
			DictionaryLocalServiceUtil.updateDictionary(dic);

			List<Dictionary> ds = DictionaryPortlet.getPath();
			for (Dictionary d : ds) {
				list.add(d.getSortNo());
			}
			boolean isLeaf = true;
			if (dic.getParentId() == 0L) {
				isLeaf = false;
			}
			sortNo = java.util.Collections.max(list) + 1;
			String sortStr = "00000" + sortNo;
			String sortPath = "/"
					+ sortStr.substring(sortStr.length() - 5, sortStr.length())
					+ "/";
			dic.setSortNo(sortNo);
			dic.setSortPath(sortPath);
			dic.setIsLeaf(isLeaf);
			DictionaryLocalServiceUtil.updateDictionary(dic);
		}
	}

	// 删除代码集
	public void deleteCodeSet(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		long dictionaryId = ParamUtil.getInteger(request, "dictionaryId");
		if (Validator.isNotNull(dictionaryId)) {
			List<Dictionary> dics = DictionaryPortlet
					.getCodesByParentId(dictionaryId);
			for (Dictionary dic : dics) {
				DictionaryLocalServiceUtil.deleteDictionary(dic);
			}
			DictionaryLocalServiceUtil
					.deleteDictionary(DictionaryLocalServiceUtil
							.getDictionary(dictionaryId));
		}
	}

	// 修改代码集
	public void editCodeSet(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		request.setAttribute("dictionaryId", dictionaryId);
		Dictionary dic = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		String code = dic.getCode();
		String name = dic.getName();
		String desc = dic.getDesc();
		int sortNo = dic.getSortNo();
		request.setAttribute("name", name);
		request.setAttribute("code", code);
		request.setAttribute("desc", desc);
		request.setAttribute("sortNo", sortNo);

	}

	// 查看代码集
	public void viewCodeSet(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		request.setAttribute("dictionaryId", dictionaryId);
		Dictionary dic = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		String code = dic.getCode();
		String name = dic.getName();
		String desc = dic.getDesc();
		request.setAttribute("name", name);
		request.setAttribute("code", code);
		request.setAttribute("desc", desc);

		List<Dictionary> dictionaries = DictionaryPortlet
				.getCode(dictionaryId);
		request.setAttribute("dictionaries", dictionaries);
	}

	// 添加代码项
	public void inputCode(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException, ParseException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		String parentSortPath = DictionaryLocalServiceUtil.getDictionary(
				dictionaryId).getSortPath();
		long parentID = ParamUtil.getLong(request, "parentID");
		Dictionary dic = null;
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name");
		String tag = ParamUtil.getString(request, "tag");
		String desc = ParamUtil.getString(request, "desc");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "default");
		boolean isValid = true;
		if (ParamUtil.getInteger(request, "isValid") == 2) {
			isValid = false;
		}
		int sortNo = 0;

		if (Validator.isNotNull(parentID)) {
			dic = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
			int sort = ParamUtil.getInteger(request, "sortNo");
			String sortStr = "00000" + sort;
			String sortPath = dic.getSortPath().substring(0, 6) + "/"
					+ sortStr.substring(sortStr.length() - 5, sortStr.length())
					+ "/";
			Date day = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date modifiedDate = sdf.parse(sdf.format(day));
			dic.setParentId(parentID);
			dic.setTreePath("/" + dic.getParentId() + "/"
					+ dic.getDictionaryId() + "/");
			dic.setSortNo(dic.getSortNo());
			dic.setCode(code);
			dic.setName(name);
			dic.setTag(tag);
			dic.setIsValid(isValid);
			dic.setDesc(desc);
			dic.setModifiedDate(modifiedDate);
			dic.setSortNo(sort);
			dic.setSortPath(sortPath);
			DictionaryLocalServiceUtil.updateDictionary(dic);
		} else {
			dic = DictionaryLocalServiceUtil
					.createDictionary(CounterLocalServiceUtil.increment());
			long parentId = dictionaryId;
			Date day = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date createDate = sdf.parse(sdf.format(day));
			dic.setParentId(parentId);
			dic.setTreePath("/" + dic.getParentId() + "/"
					+ dic.getDictionaryId() + "/");
			dic.setSortNo(sortNo);

			dic.setCode(code);
			dic.setName(name);
			dic.setTag(tag);
			dic.setIsValid(isValid);
			dic.setDesc(desc);
			dic.setGroupId(groupId);
			dic.setUserId(userId);
			dic.setCompanyId(companyId);
			dic.setUserName(userName);
			dic.setCreateDate(createDate);
			DictionaryLocalServiceUtil.updateDictionary(dic);
			List<Dictionary> ds = DictionaryPortlet.getPath(dic.getParentId());
			List<Integer> list = new ArrayList<Integer>();
			for (Dictionary d : ds) {
				list.add(d.getSortNo());
			}
			if (dic.getParentId() != 0L) {
				dic.setIsLeaf(true);
			} else {
				dic.setIsLeaf(false);
			}

			sortNo = java.util.Collections.max(list) + 1;
			String sortStr = "00000" + sortNo;
			String sortPath = parentSortPath
					+ sortStr.substring(sortStr.length() - 5, sortStr.length())
					+ "/";
			dic.setSortNo(sortNo);
			dic.setSortPath(sortPath);
			DictionaryLocalServiceUtil.updateDictionary(dic);
		}
	}

	// 删除代码项
	public void deleteCode(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		if (Validator.isNotNull(dictionaryId)) {
			DictionaryLocalServiceUtil
					.deleteDictionary(DictionaryLocalServiceUtil
							.getDictionary(dictionaryId));
		}
	}

	// 编辑代码项
	public void editCode(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		request.setAttribute("dictionaryId", dictionaryId);
		long parentId = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getParentId();
		request.setAttribute("parentId", parentId);
		String code = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getCode();
		String name = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getName();
		int sortNo = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getSortNo();
		String tag = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getTag();
		boolean isValid = DictionaryLocalServiceUtil
				.getDictionary(dictionaryId).getIsValid();
		String desc = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getDesc();
		request.setAttribute("code", code);
		request.setAttribute("isValid", isValid);
		request.setAttribute("name", name);
		request.setAttribute("tag", tag);
		request.setAttribute("desc", desc);
		request.setAttribute("sortNo", sortNo);
	}

	public static List<Dictionary> getCodesByKeywords(String keyword,
			int start, int end) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(0L));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("name").like(
				"%" + keyword + "%"));
		junction.add(PropertyFactoryUtil.forName("code").like(
				"%" + keyword + "%"));
		query.add(junction);
		return (List<Dictionary>) DictionaryLocalServiceUtil.dynamicQuery(
				query, start, end);
	}

	public static int getCodesCount(String keyword) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(0L));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("name").like(
				"%" + keyword + "%"));
		junction.add(PropertyFactoryUtil.forName("code").like(
				"%" + keyword + "%"));
		query.add(junction);
		return DictionaryLocalServiceUtil.dynamicQuery(query).size();
	}

	public static List<Dictionary> getCode(long id) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(id));
		return (List<Dictionary>) DictionaryLocalServiceUtil
				.dynamicQuery(query);
	}

	public static List<Dictionary> getPath() throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(0L));
		return (List<Dictionary>) DictionaryLocalServiceUtil
				.dynamicQuery(query);
	}

	public static List<Dictionary> getPath(long id) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").ne(0L));
		query.add(PropertyFactoryUtil.forName("parentId").eq(id));
		return (List<Dictionary>) DictionaryLocalServiceUtil
				.dynamicQuery(query);
	}

	public static List<Dictionary> getCodesByParentId(long parentId)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(parentId));
		return (List<Dictionary>) DictionaryLocalServiceUtil
				.dynamicQuery(query);
	}
}
