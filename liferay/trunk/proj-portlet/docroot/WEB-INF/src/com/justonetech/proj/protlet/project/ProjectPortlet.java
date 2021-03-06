package com.justonetech.proj.protlet.project;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

/**
 * 项目基本信息
 */
public class ProjectPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(ProjectPortlet.class);
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
			projects = ProjectLocalServiceUtil.getProjects(start, end);
			projectsCount = ProjectLocalServiceUtil.getProjectsCount();
		} catch (SystemException e) {
			log.error(e.getMessage());
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
		renderRequest.setAttribute("projects", projects);
		renderRequest.setAttribute("projectCount", projectsCount);
		renderRequest.setAttribute("projectStatuses", projectStatuses);
		renderRequest.setAttribute("industryCategories", industryCategories);
		super.doView(renderRequest, renderResponse);
	}

	public void editProject(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			ParseException {
		long projectId = ParamUtil.getInteger(request, "projectId");
		List<Project> projects = ProjectLocalServiceUtil.getProjects(-1, -1);
		int sortNo = 0;
		if (Validator.isNull(projectId)) {
			sortNo = (projects.isEmpty() ? 0 : projects.get(projects.size() - 1).getSortNo()) + 1;
		} else {
			sortNo = ProjectLocalServiceUtil.getProject(projectId).getSortNo();
			Project project = ProjectLocalServiceUtil.getProject(projectId);
			request.setAttribute("project", project);
			request.setAttribute("projectId", projectId);
			List<Company> companies = CompanyLocalServiceUtil.findByProjectId(projectId);
			request.setAttribute("companies", companies);
		}
		Dictionary projAttrDic = DictionaryLocalServiceUtil.findByCode("projAttr");
		Dictionary involveCountyDic = DictionaryLocalServiceUtil.findByCode("areaName");
		Dictionary industryCategoryDic = DictionaryLocalServiceUtil.findByCode("industryCategory");
		Dictionary projectStatusDic = DictionaryLocalServiceUtil.findByCode("projectStatus");
		Dictionary manageAttributeDic = DictionaryLocalServiceUtil.findByCode("manageAttribute");
		Dictionary projectSourceDic = DictionaryLocalServiceUtil.findByCode("projectSource");
		Dictionary roadLevelDic = DictionaryLocalServiceUtil.findByCode("roadLevel");
		Dictionary roadTechLevelDic = DictionaryLocalServiceUtil.findByCode("roadTechLevel");
		Dictionary companyTypeDic = DictionaryLocalServiceUtil.findByCode("companyType");
		List<Dictionary> projAttrs = projAttrDic != null ? DictionaryLocalServiceUtil.findByParentId(
				projAttrDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> involveCounties = involveCountyDic != null ? DictionaryLocalServiceUtil.findByParentId(
				involveCountyDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> industryCategories = industryCategoryDic != null ? DictionaryLocalServiceUtil.findByParentId(
				industryCategoryDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> projectStatuses = projectStatusDic != null ? DictionaryLocalServiceUtil.findByParentId(
				projectStatusDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> manageAttributes = manageAttributeDic != null ? DictionaryLocalServiceUtil.findByParentId(
				manageAttributeDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> projectSources = projectSourceDic != null ? DictionaryLocalServiceUtil.findByParentId(
				projectSourceDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> roadLevels = roadLevelDic != null ? DictionaryLocalServiceUtil.findByParentId(
				roadLevelDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> roadTechLevels = roadTechLevelDic != null ? DictionaryLocalServiceUtil.findByParentId(
				roadTechLevelDic.getDictionaryId(), -1, -1) : null;
		List<Dictionary> companyTypes = companyTypeDic != null ? DictionaryLocalServiceUtil.findByParentId(
				companyTypeDic.getDictionaryId(), -1, -1) : null;

		request.setAttribute("projAttrs", projAttrs);
		request.setAttribute("involveCounties", involveCounties);
		request.setAttribute("industryCategories", industryCategories);
		request.setAttribute("projectStatuses", projectStatuses);
		request.setAttribute("manageAttributes", manageAttributes);
		request.setAttribute("projectSources", projectSources);
		request.setAttribute("projAttrs", projAttrs);
		request.setAttribute("roadLevels", roadLevels);
		request.setAttribute("roadTechLevels", roadTechLevels);
		request.setAttribute("companyTypes", companyTypes);
		Map<Dictionary, Company> companyMap = new TreeMap<Dictionary, Company>();
		List<Company> companies = (List<Company>) request.getAttribute("companies");
		String companyName = "";
		if (Validator.isNotNull(companyTypes)) {
			for (Dictionary dictionary : companyTypes) {
				companyMap.put(dictionary, null);
				if (companies != null) {
					for (Company com : companies) {
						Dictionary dic = DictionaryLocalServiceUtil.getDictionary(com.getType());
						if (dictionary.equals(dic)) {
							companyMap.put(dictionary, com);
						}
					}
				}
				companyName += dictionary.getName() + ",";
			}
		}
		request.setAttribute("companyMap", companyMap);
		request.setAttribute("companyName", companyName);
		request.setAttribute("sortNo", sortNo);
	}

	public void saveProject(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			ParseException {
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		long projectId = ParamUtil.getLong(request, "projectId");
		// 项目基本信息
		String projNum = ParamUtil.getString(request, "projNum");
		String projName = ParamUtil.getString(request, "projName");
		int sortNo = ParamUtil.getInteger(request, "sortNo");
		Date startDate = ParamUtil.getDate(request, "startDate", new SimpleDateFormat(timeFormatPattern));
		Date endDate = ParamUtil.getDate(request, "endDate", new SimpleDateFormat(timeFormatPattern));
		long projStatus = ParamUtil.getLong(request, "projStatus");
		long industryCategory = ParamUtil.getLong(request, "industryCategory");
		String[] involveCountyArrs = ParamUtil.getParameterValues(request, "involveCountyCheckbox");
		String involveCounties = "";
		if (null != involveCountyArrs && involveCountyArrs.length > 0) {
			for (String involveString : involveCountyArrs) {
				involveCounties += "," + involveString;
			}
		}
		long manageAttrId = ParamUtil.getLong(request, "manageAttribute");
		boolean isMajor = ParamUtil.getBoolean(request, "isMajor");
		Double planRedLine = ParamUtil.getDouble(request, "planRedLine");
		long projSourceId = ParamUtil.getLong(request, "projSource");
		long roadTechLevel = ParamUtil.getLong(request, "roadTechLevel");
		long belongCounty = ParamUtil.getLong(request, "belongCounty");
		long roadLevel = ParamUtil.getLong(request, "roadLevel");
		long projAttr = ParamUtil.getLong(request, "projAttr");
		String location = ParamUtil.getString(request, "location");
		Date startNode = ParamUtil.getDate(request, "startNode", new SimpleDateFormat(timeFormatPattern));
		Date endNode = ParamUtil.getDate(request, "endNode", new SimpleDateFormat(timeFormatPattern));
		Double planTotalInvestment = ParamUtil.getDouble(request, "planTotalInvestment");
		Double feasibilityTotalInvestment = ParamUtil.getDouble(request, "feasibilityTotalInvestment");
		Date planStartDate = ParamUtil.getDate(request, "planStartDate", new SimpleDateFormat(timeFormatPattern));
		Date planEndDate = ParamUtil.getDate(request, "planEndDate", new SimpleDateFormat(timeFormatPattern));

		Double feasibilityPreCost = ParamUtil.getDouble(request, "feasibilityPreCost");
		Double feasibilityJiananCost = ParamUtil.getDouble(request, "feasibilityJiananCost");
		String introduction = ParamUtil.getString(request, "introduction");
		Double firstFoundedTotalInvestment = ParamUtil.getDouble(request, "firstFoundedTotalInvestment");
		Double firstFoundedPreCost = ParamUtil.getDouble(request, "firstFoundedPreCost");
		Double firstFoundedJiananCost = ParamUtil.getDouble(request, "firstFoundedJiananCost");

		Project project = null;
		if (Validator.isNotNull(projectId)) {
			project = ProjectLocalServiceUtil.getProject(projectId);
		} else {
			project = ProjectLocalServiceUtil.createProject(CounterLocalServiceUtil.increment());
		}
		project.setUserId(userId);
		project.setUserName(userName);
		project.setGroupId(groupId);
		project.setCompanyId(companyId);
		project.setProjNum(projNum);
		project.setProjName(projName);
		project.setSortNo(sortNo);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		project.setProjStatus(projStatus);
		project.setIndustryCategory(industryCategory);
		project.setInvolveCounty(involveCounties);
		project.setManageAttribute(manageAttrId);
		project.setIsMajor(isMajor);
		project.setPlanRedLine(planRedLine);
		project.setProjSource(projSourceId);
		project.setRoadTechLevel(roadTechLevel);
		project.setBelongCounty(belongCounty);
		project.setRoadLevel(roadLevel);
		project.setProjAttr(projAttr);
		project.setLocation(location);
		project.setStartNode(startNode);
		project.setEndNode(endNode);
		project.setPlanTotalInvestment(planTotalInvestment);
		project.setFeasibilityTotalInvestment(feasibilityTotalInvestment);
		project.setPlanStartDate(planStartDate);
		project.setPlanEndDate(planEndDate);
		project.setFeasibilityPreCost(feasibilityPreCost);
		project.setFeasibilityJiananCost(feasibilityJiananCost);
		project.setIntroduction(introduction);
		project.setFirstFoundedTotalInvestment(firstFoundedTotalInvestment);
		project.setFirstFoundedPreCost(firstFoundedPreCost);
		project.setFirstFoundedJiananCost(firstFoundedJiananCost);
		ProjectLocalServiceUtil.updateProject(project);

		long[] companyIds = ParamUtil.getLongValues(request, "companyId");
		long[] types = ParamUtil.getLongValues(request, "type");
		String[] unitNames = ParamUtil.getParameterValues(request, "unitName");
		String[] indepLegals = ParamUtil.getParameterValues(request, "indepLegal");
		String[] indepLegalTels = ParamUtil.getParameterValues(request, "indepLegalTel");
		String[] indepLegalFaxs = ParamUtil.getParameterValues(request, "indepLegalFax");
		String[] indepLegalPhones = ParamUtil.getParameterValues(request, "indepLegalPhone");
		String[] projLegals = ParamUtil.getParameterValues(request, "projLegal");
		String[] projLegalTels = ParamUtil.getParameterValues(request, "projLegalTel");
		String[] projLegalFaxs = ParamUtil.getParameterValues(request, "projLegalFax");
		String[] projLegalPhone = ParamUtil.getParameterValues(request, "projLegalPhone");
		String[] linkmans = ParamUtil.getParameterValues(request, "linkman");
		String[] linkmanTels = ParamUtil.getParameterValues(request, "linkmanTel");
		String[] linkmanFaxs = ParamUtil.getParameterValues(request, "linkmanFax");
		String[] linkmanPhones = ParamUtil.getParameterValues(request, "linkmanPhone");
		for (int i = 0; i < types.length; i++) {
			Company company;
			if (Validator.isNotNull(companyIds[i])) {
				company = CompanyLocalServiceUtil.getCompany(companyIds[i]);
			} else {
				company = CompanyLocalServiceUtil.createCompany(CounterLocalServiceUtil.increment());
			}
			company.setType(types[i]);
			company.setUnitName(unitNames[i]);
			company.setIndepLegal(indepLegals[i]);
			company.setIndepLegalTel(indepLegalTels[i]);
			company.setIndepLegalFax(indepLegalFaxs[i]);
			company.setIndepLegalPhone(indepLegalPhones[i]);
			company.setProjLegal(projLegals[i]);
			company.setProjLegalTel(projLegalTels[i]);
			company.setProjLegalFax(projLegalFaxs[i]);
			company.setProjLegalPhone(projLegalPhone[i]);
			company.setLinkman(linkmans[i]);
			company.setLinkmanTel(linkmanTels[i]);
			company.setLinkmanFax(linkmanFaxs[i]);
			company.setLinkmanPhone(linkmanPhones[i]);
			company.setProjectId(project.getProjectId());
			CompanyLocalServiceUtil.updateCompany(company);
		}
	}

	public void viewProject(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long projectId = ParamUtil.getInteger(request, "projectId");
		Project project = ProjectLocalServiceUtil.getProject(projectId);
		List<Company> companies = CompanyLocalServiceUtil.findByProjectId(projectId);
		request.setAttribute("project", project);
		request.setAttribute("projectId", projectId);
		request.setAttribute("companies", companies);
	}

	public void deleteProjects(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {
		String projectIds = ParamUtil.getString(actionRequest, "projectIds");
		String[] projectsId = projectIds.split(",");
		for (String projectId : projectsId) {
			List<Company> companiesPro = CompanyLocalServiceUtil.findByProjectId(Long.parseLong(projectId));
			List<Bidding> biddings = BiddingLocalServiceUtil.findByProjectId(Long.parseLong(projectId));
			if (null != companiesPro && companiesPro.size() > 0) {
				for (Company company : companiesPro) {
					CompanyLocalServiceUtil.deleteCompany(company);
				}
			}
			if (null != biddings && biddings.size() > 0) {
				for (Bidding bidding : biddings) {
					BiddingLocalServiceUtil.deleteBidding(bidding);
					List<Company> companiesBid = CompanyLocalServiceUtil.findByBiddingId(bidding.getBiddingId());
					for (Company company : companiesBid) {
						CompanyLocalServiceUtil.deleteCompany(company);
					}
				}
			}
			ProjectLocalServiceUtil.deleteProject(Long.parseLong(projectId));
		}
	}
}
