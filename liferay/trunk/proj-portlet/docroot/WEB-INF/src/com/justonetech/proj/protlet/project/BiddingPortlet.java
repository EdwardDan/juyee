package com.justonetech.proj.protlet.project;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.proj.model.Bidding;
import com.justonetech.proj.model.Company;
import com.justonetech.proj.model.Project;
import com.justonetech.proj.service.BiddingLocalServiceUtil;
import com.justonetech.proj.service.CompanyLocalServiceUtil;
import com.justonetech.proj.service.ProjectLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.org.apache.bcel.internal.generic.I2F;

/**
 * Portlet implementation class BiddingPortlet
 */
public class BiddingPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(BiddingPortlet.class);
	private static String timeFormatPattern = PropsUtil.get("default.date.format.pattern");

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		List<Project> projects = null;
		int projectsCount = 0;
		try {
			projects = ProjectLocalServiceUtil.getProjects(-1, -1);
			projectsCount = projects.size();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		Map<Long, Integer> biddingCount = new HashMap<Long, Integer>();
		for (Project project : projects) {
			try {
				List<Bidding> biddings = BiddingLocalServiceUtil.findByProjectId(project.getProjectId());
				biddingCount.put(project.getProjectId(), biddings.size());
			} catch (SystemException e) {
				log.info("findByProjectId 出错" + e.getMessage());
			}
		}
		long manageAttrId = 0;
		Dictionary manageAttributeDic = null;
		;
		try {
			manageAttributeDic = DictionaryLocalServiceUtil.findByCode("manageAttribute");
		} catch (SystemException e) {
			e.printStackTrace();
		}
		if (Validator.isNotNull(manageAttributeDic)) {
			List<Dictionary> manageAttributes = DictionaryLocalServiceUtil.findByParentId(
					manageAttributeDic.getDictionaryId(), -1, -1);
			for (Dictionary manageAttribute : manageAttributes) {
				if (manageAttribute.getName().equals("市属")) {
					manageAttrId = manageAttribute.getDictionaryId();
				}
			}
		}
		Dictionary projectStatusDic = null;
		Dictionary industryCategoryDic = null;
		List<Dictionary> projectStatuses = null;
		List<Dictionary> industryCategories = null;
		try {
			projectStatusDic = DictionaryLocalServiceUtil.findByCode("projectStatus");
			projectStatuses = projectStatusDic != null ? DictionaryLocalServiceUtil.findByParentId(
					projectStatusDic.getDictionaryId(), -1, -1) : null;
			industryCategoryDic = DictionaryLocalServiceUtil.findByCode("industryCategory");
			industryCategories = industryCategoryDic != null ? DictionaryLocalServiceUtil.findByParentId(
					industryCategoryDic.getDictionaryId(), -1, -1) : null;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		renderRequest.setAttribute("projectStatuses", projectStatuses);
		renderRequest.setAttribute("industryCategories", industryCategories);
		renderRequest.setAttribute("manageAttrId", manageAttrId);
		renderRequest.setAttribute("biddingCount", biddingCount);
		renderRequest.setAttribute("projects", projects);
		renderRequest.setAttribute("projectCount", projectsCount);
		super.doView(renderRequest, renderResponse);
	}

	public void doViewBiddings(ActionRequest request, ActionResponse response) throws IOException, PortletException,
			SystemException, PortalException {
		String keywords = ParamUtil.getString(request, "keywords");
		long projectId = ParamUtil.getLong(request, "projectId");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(request, "delta", delta);
		int pageNumber = ParamUtil.getInteger(request, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		List<Bidding> biddings = null;
		int biddingsCount = 0;
		try {
			biddings = BiddingLocalServiceUtil.findByProjectId(projectId);
			biddingsCount = BiddingLocalServiceUtil.getBiddingsCount();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		Dictionary involveCountyDic = DictionaryLocalServiceUtil.findByCode("areaName");
		List<Dictionary> involveCountys = involveCountyDic != null ? DictionaryLocalServiceUtil.findByParentId(
				involveCountyDic.getDictionaryId(), -1, -1) : null;
		request.setAttribute("involveCountys", involveCountys);
		request.setAttribute("biddings", biddings);
		request.setAttribute("projectId", projectId);
		request.setAttribute("biddingsCount", biddingsCount);
	}

	public void saveBidding(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			ParseException {
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "");
		long projectId = ParamUtil.getLong(request, "projectId");
		long biddingId = ParamUtil.getLong(request, "biddingId");
		String bidCategoryCode = ParamUtil.getString(request, "bidCategoryCode");
		int sortNo = ParamUtil.getInteger(request, "sortNo");
		String bidName = ParamUtil.getString(request, "bidName");
		Date startDate = ParamUtil.getDate(request, "startDate", new SimpleDateFormat(timeFormatPattern));
		String[] involveCountys = ParamUtil.getParameterValues(request, "involveCountyCheckbox");
		String buildMileage = ParamUtil.getString(request, "buildMileage");
		String projLinkman = ParamUtil.getString(request, "projLinkman");
		String linkTel = ParamUtil.getString(request, "linkTel");
		Date now = new Date();
		Bidding bidding = null;
		if (Validator.isNotNull(biddingId)) {
			bidding = BiddingLocalServiceUtil.getBidding(biddingId);
			bidding.setModifiedDate(now);
		} else {
			bidding = BiddingLocalServiceUtil.createBidding(CounterLocalServiceUtil.increment());
			bidding.setCreateDate(now);
			bidding.setModifiedDate(now);
		}
		String involveCountyIds = "";
		if (null != involveCountys && involveCountys.length > 0) {
			for (String involveString : involveCountys) {
				involveCountyIds += "," + involveString;
			}
		}
		bidding.setUserId(userId);
		bidding.setUserName(userName);
		bidding.setBidCategoryCode(bidCategoryCode);
		bidding.setProjectId(projectId);
		bidding.setSortNo(sortNo);
		bidding.setBidName(bidName);
		bidding.setStartDate(startDate);
		bidding.setInvolveCounty(involveCountyIds);
		bidding.setBuildMileage(buildMileage);
		bidding.setProjLinkman(projLinkman);
		bidding.setLinkTel(linkTel);

		BiddingLocalServiceUtil.updateBidding(bidding);
		long[] companyIds = ParamUtil.getLongValues(request, "companyId");
		long[] typeIds = ParamUtil.getLongValues(request, "typeId");
		String[] unitNames = ParamUtil.getParameterValues(request, "unitName");
		String[] linkmans = ParamUtil.getParameterValues(request, "linkman");
		String[] linkmanTels = ParamUtil.getParameterValues(request, "linkmanTel");
		for (int i = 0; i < unitNames.length; i++) {
			Company company;
			if (Validator.isNotNull(companyIds[i])) {
				company = CompanyLocalServiceUtil.getCompany(companyIds[i]);
			} else {
				company = CompanyLocalServiceUtil.createCompany(CounterLocalServiceUtil.increment());
			}

			company.setUnitName(unitNames[i]);
			company.setType(typeIds[i]);
			company.setLinkman(linkmans[i]);
			company.setLinkmanTel(linkmanTels[i]);
			company.setBiddingId(bidding.getBiddingId());
			CompanyLocalServiceUtil.updateCompany(company);
		}
	}

	public void deleteBiddings(ActionRequest request, ActionResponse response) throws IOException, PortletException,
			NumberFormatException, PortalException, SystemException {
		String biddingIds = ParamUtil.getString(request, "biddingIds");
		long projectId = ParamUtil.getLong(request, "projectId");
		String[] biddingsId = biddingIds.split(",");
		for (String biddingId : biddingsId) {
			List<Company> companies = CompanyLocalServiceUtil.findByBiddingId(Long.parseLong(biddingId));
			if (null != companies && companies.size() > 0) {
				for (Company company : companies) {
					CompanyLocalServiceUtil.deleteCompany(company);
				}
			}
			BiddingLocalServiceUtil.deleteBidding(Long.parseLong(biddingId));
		}
		request.setAttribute("projectId", projectId);

		List<Bidding> biddings = BiddingLocalServiceUtil.findByProjectId(projectId);
		int i = 1;
		for (Bidding bidding : biddings) {
			bidding.setSortNo(i);
			i += 1;
			BiddingLocalServiceUtil.updateBidding(bidding);
		}
	}

	public void editBidding(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long biddingId = ParamUtil.getLong(request, "biddingId");
		long projectId = 0;
		List<Company> companies = null;
		int sortNo = 0;
		if (Validator.isNotNull(biddingId)) {
			Bidding bidding = BiddingLocalServiceUtil.getBidding(biddingId);
			projectId = bidding.getProjectId();
			sortNo = bidding.getSortNo();
			companies = CompanyLocalServiceUtil.findByBiddingId(biddingId);
			request.setAttribute("bidding", bidding);
			request.setAttribute("biddingId", biddingId);
		} else {
			projectId = ParamUtil.getLong(request, "projectId");
			List<Bidding> biddings = BiddingLocalServiceUtil.findByProjectId(projectId);
			sortNo = (biddings.isEmpty() ? 0 : biddings.get(biddings.size() - 1).getSortNo()) + 1;
		}
		if (Validator.isNotNull(biddingId)) {
			companies = CompanyLocalServiceUtil.findByBiddingId(biddingId);
		}
		Dictionary companyTypeDic = DictionaryLocalServiceUtil.findByCode("CompanyType");
		List<Dictionary> companyTypes = companyTypeDic != null ? DictionaryLocalServiceUtil.findByParentId(
				companyTypeDic.getDictionaryId(), -1, -1) : null;
		Map<Dictionary, Company> companyMap = new TreeMap<Dictionary, Company>();
		if (Validator.isNotNull(companyTypes)) {
			for (Dictionary dictionary : companyTypes) {
				companyMap.put(dictionary, null);
				if (companies != null) {
					for (Company com : companies) {
						if (Validator.isNotNull(com.getType())) {
							Dictionary dic = DictionaryLocalServiceUtil.getDictionary(com.getType());
							if (dictionary.equals(dic)) {
								companyMap.put(dictionary, com);
							}
						}
					}
				}
			}
		}
		Dictionary involveCountyDic = DictionaryLocalServiceUtil.findByCode("areaName");
		List<Dictionary> involveCountys = involveCountyDic != null ? DictionaryLocalServiceUtil.findByParentId(
				involveCountyDic.getDictionaryId(), -1, -1) : null;
		request.setAttribute("involveCountys", involveCountys);
		request.setAttribute("companyMap", companyMap);
		request.setAttribute("companies", companies);
		request.setAttribute("projectId", projectId);
		request.setAttribute("sortNo", sortNo);
	}

	public void viewBiddingDetail(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException {
		long biddingId = ParamUtil.getLong(request, "biddingId");
		Bidding bidding = BiddingLocalServiceUtil.getBidding(biddingId);
		long projectId = bidding.getProjectId();
		List<Company> companies = CompanyLocalServiceUtil.findByBiddingId(biddingId);
		Dictionary companyTypeDic = DictionaryLocalServiceUtil.findByCode("CompanyType");
		List<Dictionary> companyTypes = companyTypeDic != null ? DictionaryLocalServiceUtil.findByParentId(
				companyTypeDic.getDictionaryId(), -1, -1) : null;
		Map<Dictionary, Company> companyMap = new TreeMap<Dictionary, Company>();
		if (Validator.isNotNull(companyTypes)) {
			for (Dictionary dictionary : companyTypes) {
				companyMap.put(dictionary, null);
				if (companies != null) {
					for (Company com : companies) {
						if (Validator.isNotNull(com.getType())) {
							Dictionary dic = DictionaryLocalServiceUtil.getDictionary(com.getType());
							if (dictionary.equals(dic)) {
								companyMap.put(dictionary, com);
							}
						}
					}
				}
			}
		}
		Dictionary involveCountyDic = DictionaryLocalServiceUtil.findByCode("areaName");
		List<Dictionary> involveCountys = involveCountyDic != null ? DictionaryLocalServiceUtil.findByParentId(
				involveCountyDic.getDictionaryId(), -1, -1) : null;
		request.setAttribute("involveCountys", involveCountys);
		request.setAttribute("companyMap", companyMap);
		request.setAttribute("biddingId", biddingId);
		request.setAttribute("bidding", bidding);
		request.setAttribute("projectId", projectId);
		request.setAttribute("companies", companies);
	}
}
