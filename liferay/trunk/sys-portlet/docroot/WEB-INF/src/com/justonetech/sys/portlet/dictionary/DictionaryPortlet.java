package com.justonetech.sys.portlet.dictionary;

import java.io.IOException;
import java.util.List;

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
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DictionaryPortlet
 */
public class DictionaryPortlet extends MVCPortlet {

	// 代码集列表显示
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String keyword = ParamUtil.getString(renderRequest, "keyword");
		renderRequest.setAttribute("keyword", keyword);
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", 10);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = (pageNumber - 1) * pageSize;
		int end = pageNumber * pageSize;
		List<Dictionary> dics = null;
		int totalSize = 0;
		try {
			totalSize = DictionaryPortlet.findCodes("").size();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (Validator.isNotNull(keyword)) {
			try {
				dics = DictionaryPortlet.findCodes(keyword, start, end);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				dics = DictionaryPortlet.findCodes("", start, end);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		renderRequest.setAttribute("dics", dics);
		renderRequest.setAttribute("totalSize", totalSize);
		super.doView(renderRequest, renderResponse);
	}

	// 添加代码集
	public void input(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		String code = ParamUtil.getString(request, "code");
		request.setAttribute("code", code);
		String name = ParamUtil.getString(request, "name");
		String desc = ParamUtil.getString(request, "desc");
		Dictionary dic = null;
		if (Validator.isNotNull(dictionaryId)) {
			dic = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		} else {
			dic = DictionaryLocalServiceUtil
					.createDictionary(CounterLocalServiceUtil.increment());
		}
		dic.setCode(code);
		dic.setName(name);
		dic.setDesc(desc);
		dic.setParentId(0);
		DictionaryLocalServiceUtil.updateDictionary(dic);
	}

	// 删除代码集
	public void delete(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		long dictionaryId = ParamUtil.getInteger(request, "dictionaryId");
		if (Validator.isNotNull(dictionaryId)) {
			DictionaryLocalServiceUtil
					.deleteDictionary(DictionaryLocalServiceUtil
							.getDictionary(dictionaryId));
		}
	}

	// 修改代码集
	public void edit(ActionRequest request, ActionResponse response)
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

	}

	// 查看代码集
	public void grid(ActionRequest request, ActionResponse response)
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
	}

	// 添加代码项
	public void add(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		System.out.println("============================dicId" + dictionaryId);
		long parentID = ParamUtil.getLong(request, "parentID");
		System.out.println("===========parentID" + parentID);
		Dictionary dic = null;
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name");
		String tag = ParamUtil.getString(request, "tag");
		String desc = ParamUtil.getString(request, "desc");
		boolean isValid = true;
		if (ParamUtil.getInteger(request, "isValid") == 2) {
			isValid = false;
		}
		if (Validator.isNotNull(parentID)) {
			dic = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
			dic.setCode(code);
			dic.setName(name);
			dic.setTag(tag);
			dic.setIsValid(isValid);
			dic.setDesc(desc);
			dic.setParentId(parentID);
		} else {
			dic = DictionaryLocalServiceUtil
					.createDictionary(CounterLocalServiceUtil.increment());
			long parentId = dictionaryId;
			dic.setCode(code);
			dic.setName(name);
			dic.setTag(tag);
			dic.setIsValid(isValid);
			dic.setDesc(desc);
			dic.setParentId(parentId);
		}
		DictionaryLocalServiceUtil.updateDictionary(dic);
	}

	// 传值用
	public void pass(ActionRequest request, ActionResponse response) {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		request.setAttribute("dictionaryId", dictionaryId);
	}

	// 查看代码项
	public void check(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		request.setAttribute("dictionaryId", dictionaryId);
		Dictionary dic = DictionaryLocalServiceUtil.getDictionary(dictionaryId);
		String code = dic.getCode();
		String name = dic.getName();
		String desc = dic.getDesc();
		request.setAttribute("code", code);
		request.setAttribute("name", name);
		request.setAttribute("desc", desc);

		String keywords = ParamUtil.getString(request, "keywords");
		request.setAttribute("keywords", keywords);
		int pageSize = ParamUtil.getInteger(request, "delta", 15);
		int pageNumber = ParamUtil.getInteger(request, "cur", 1);
		int start = (pageNumber - 1) * pageSize;
		int end = pageNumber * pageSize;
		int totalSize = DictionaryPortlet.findCode("", dictionaryId).size();
		System.out.println("==========totalSize============" + totalSize);
		request.setAttribute("totalSize", totalSize);
		List<Dictionary> dics = null;
		if (Validator.isNotNull(keywords)) {
			dics = DictionaryPortlet.findCode(keywords, start, end,
					dictionaryId);
		} else {
			dics = DictionaryPortlet.findCode("", start, end, dictionaryId);
		}
		request.setAttribute("dics", dics);
	}

	// 删除代码项
	public void del(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {
		long dictionaryId = ParamUtil.getLong(request, "dictionaryId");
		if (Validator.isNotNull(dictionaryId)) {
			DictionaryLocalServiceUtil
					.deleteDictionary(DictionaryLocalServiceUtil
							.getDictionary(dictionaryId));
		}
	}

	// 修改代码项
	public void modify(ActionRequest request, ActionResponse response)
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
		String tag = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getTag();
		boolean isValid = DictionaryLocalServiceUtil
				.getDictionary(dictionaryId).getIsValid();
		String desc = DictionaryLocalServiceUtil.getDictionary(dictionaryId)
				.getDesc();
		request.setAttribute("code", code);
		request.setAttribute("name", name);
		request.setAttribute("tag", tag);
		request.setAttribute("isValid", isValid);
		request.setAttribute("desc", desc);
	}

	public static List<Dictionary> findCodes(String keyword, int start, int end)
			throws SystemException {
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

	public static List<Dictionary> findCodes(String keyword)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(0L));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("name").like(
				"%" + keyword + "%"));
		junction.add(PropertyFactoryUtil.forName("code").like(
				"%" + keyword + "%"));
		query.add(junction);
		return (List<Dictionary>) DictionaryLocalServiceUtil
				.dynamicQuery(query);
	}

	public static List<Dictionary> findCode(String keyword, int start, int end,
			long id) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(id));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("name").like(
				"%" + keyword + "%"));
		junction.add(PropertyFactoryUtil.forName("code").like(
				"%" + keyword + "%"));
		// junction.add(PropertyFactoryUtil.forName("tag").like(
		// Integer.parseInt("%" + keyword + "%")));
		query.add(junction);
		return (List<Dictionary>) DictionaryLocalServiceUtil.dynamicQuery(
				query, start, end);
	}

	public static List<Dictionary> findCode(String keyword, long id)
			throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(com.justonetech.sys.model.Dictionary.class);
		query.add(PropertyFactoryUtil.forName("parentId").eq(id));
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("name").like(
				"%" + keyword + "%"));
		junction.add(PropertyFactoryUtil.forName("code").like(
				"%" + keyword + "%"));
		query.add(junction);
		return (List<Dictionary>) DictionaryLocalServiceUtil
				.dynamicQuery(query);
	}
}
