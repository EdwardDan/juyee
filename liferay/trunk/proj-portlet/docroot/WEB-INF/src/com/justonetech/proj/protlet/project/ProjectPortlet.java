package com.justonetech.proj.protlet.project;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.proj.model.Company;
import com.justonetech.proj.model.Project;
import com.justonetech.proj.service.CompanyLocalServiceUtil;
import com.justonetech.proj.service.ProjectLocalServiceUtil;
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
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * 项目基本信息
 */
public class ProjectPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(ProjectPortlet.class);
	private static String timeFormatPattern = PropsUtil.get("default.date.format.pattern");

	/**
	 * 项目列表
	 */
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
			projectsCount = ProjectLocalServiceUtil.getProjectsCount();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// try {
		// projects = ProjectLocalServiceUtil.
		// } catch (SystemException e) {
		// log.error("findByUserNam(" + userName + "," + start + "," + end +
		// ")错误：" + e.getMessage());
		// }
		// int projectCount = 0;
		// try {
		// projectCount = ProjectLocalServiceUtil.getProjectsCount()(userName);
		// } catch (SystemException e) {
		// log.error("countByUserNam(" + userName + ")错误：" + e.getMessage());
		// }
		renderRequest.setAttribute("projects", projects);
		renderRequest.setAttribute("projectCount", projectsCount);
		// renderRequest.setAttribute("projectCount", projectCount);
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * 项目编辑
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void editProject(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			ParseException {
		long projectId = ParamUtil.getInteger(request, "projectId");

		Project project = ProjectLocalServiceUtil.getProject(projectId);
		request.setAttribute("project", project);

	}

	/**
	 * 项目保存
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void saveProject(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			ParseException {
		long projectId = ParamUtil.getLong(request, "projectId");
		String projNum = ParamUtil.getString(request, "projNum");
		String projName = ParamUtil.getString(request, "projName");
		// String projNum = ParamUtil.getString(request, "projNum");
		int sortNo = ParamUtil.getInteger(request, "sortNo");
		Date startDate = ParamUtil.getDate(request, "startDate", new SimpleDateFormat(timeFormatPattern));
		Date endDate = ParamUtil.getDate(request, "endDate", new SimpleDateFormat(timeFormatPattern));
		long projStatus = ParamUtil.getLong(request, "projStatus");
		long industryCategory = ParamUtil.getLong(request, "industryCategory");
		String[] involveCountyArrs = ParamUtil.getParameterValues(request, "involveCountyCheckbox");
		String involveCountys = "";
		if (null != involveCountyArrs && involveCountyArrs.length > 0) {
			for (String involveString : involveCountyArrs) {
				involveCountys += "," + involveString;
			}

		}
		long manageAttrId = ParamUtil.getLong(request, "manageAttr");
		boolean isMajor = ParamUtil.getBoolean(request, "isMajor");
		Double ghhx = ParamUtil.getDouble(request, "ghhx");
		long projSourceId = ParamUtil.getLong(request, "projSource");
		long roadTechLevelId = ParamUtil.getLong(request, "roadTechLevel");
		long belongCountyId = ParamUtil.getLong(request, "belongCounty");
		long roadLevelId = ParamUtil.getLong(request, "roadLevel");
		long projAttrId = ParamUtil.getLong(request, "projAttr");
		String location = ParamUtil.getString(request, "location");
		Date startNode = ParamUtil.getDate(request, "startNode", new SimpleDateFormat(timeFormatPattern));
		Date endNode = ParamUtil.getDate(request, "endNode", new SimpleDateFormat(timeFormatPattern));
		Double planTotle = ParamUtil.getDouble(request, "planTotle");
		Double gkpfTotle = ParamUtil.getDouble(request, "gkpfTotle");
		Date planStartDate = ParamUtil.getDate(request, "planStartDate", new SimpleDateFormat(timeFormatPattern));
		Date planEndDate = ParamUtil.getDate(request, "planEndDate", new SimpleDateFormat(timeFormatPattern));

		Double gkpfPre = ParamUtil.getDouble(request, "gkpfPre");
		Double gkpfJafy = ParamUtil.getDouble(request, "gkpfJafy");
		String introduction = ParamUtil.getString(request, "introduction");
		Double csTotle = ParamUtil.getDouble(request, "csTotle");
		Double csPre = ParamUtil.getDouble(request, "csPre");
		Double csJafy = ParamUtil.getDouble(request, "csJafy");

		Project project = null;
		if (Validator.isNotNull(projectId)) {
			project = ProjectLocalServiceUtil.getProject(projectId);
		} else {
			project = ProjectLocalServiceUtil.createProject(CounterLocalServiceUtil.increment());
		}
		project.setProjNum(projNum);
		project.setProjName(projName);
		project.setSortNo(sortNo);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		project.setProjStatus(projStatus);
		project.setIndustryCategory(industryCategory);
		project.setInvolveCounty(involveCountys);
		project.setManageAttr(manageAttrId);
		project.setIsMajor(isMajor);
		project.setGhhx(ghhx);
		project.setProjSource(projSourceId);
		project.setRoadTechLevel(roadTechLevelId);
		project.setBelongCounty(belongCountyId);
		project.setRoadLevel(roadLevelId);
		project.setProjAttr(projAttrId);
		project.setLocation(location);
		project.setStartNode(startNode);
		project.setEndNode(endNode);
		project.setPlanTotle(planTotle);
		project.setGkpfTotle(gkpfTotle);
		project.setPlanStartDate(planStartDate);
		project.setPlanEndDate(planEndDate);
		project.setGkpfPre(gkpfPre);
		project.setGkpfJafy(gkpfJafy);
		project.setIntroduction(introduction);
		project.setCsTotle(csTotle);
		project.setCsJafy(csJafy);
		project.setCsPre(csPre);

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
			company.setProjectId(projectId);
			CompanyLocalServiceUtil.updateCompany(company);
		}

	}

	/**
	 * 项目删除
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteProjects(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException, SystemException {
		String projectIds = ParamUtil.getString(actionRequest, "projectIds");
		String[] projectsId = projectIds.split(",");
		for (String projectId : projectsId) {
			List<Company> companies = CompanyLocalServiceUtil.findByProjectId(Long.parseLong(projectId));
			if (null != companies && companies.size() > 0) {
				for (Company company : companies) {
					CompanyLocalServiceUtil.deleteCompany(company);
				}
			}

			ProjectLocalServiceUtil.deleteProject(Long.parseLong(projectId));
		}
	}

}
