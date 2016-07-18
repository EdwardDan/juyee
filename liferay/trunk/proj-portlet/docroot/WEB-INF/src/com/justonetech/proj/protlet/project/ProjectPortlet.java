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

import com.justonetech.proj.model.Project;
import com.justonetech.proj.service.ProjectLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * 项目基本信息
 */
public class ProjectPortlet extends MVCPortlet {

	/**
	 * 项目列表
	 */
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
//		String keyword = ParamUtil.getString(renderRequest, "keyword");
//		renderRequest.setAttribute("keyword", keyword);
//		int pageSize = ParamUtil.getInteger(renderRequest, "delta", 10);
//		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
//		int start = (pageNumber - 1) * pageSize;
//		int end = pageNumber * pageSize;
//		List<Project> projects = null;
//		int totalSize = 0;
//
//		renderRequest.setAttribute("projects", projects);
//		renderRequest.setAttribute("totalSize", totalSize);
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
	public void doEdit(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, ParseException {
		long projectId = ParamUtil.getInteger(request, "projectId");
		String projNum = ParamUtil.getString(request, "projNum");
		int sortNo = ParamUtil.getInteger(request, "sortNo");
		long projStatus = ParamUtil.getLong(request, "projStatus");
		long industryCategory = ParamUtil.getLong(request, "industryCategory");
		long manageAttr = ParamUtil.getLong(request, "manageAttr");
		boolean isMajor = ParamUtil.getBoolean(request, "isMajor");
		long projSource = ParamUtil.getLong(request, "projSource");
		long belongCounty = ParamUtil.getLong(request, "belongCounty");
		long projAttr = ParamUtil.getLong(request, "projAttr");
		String location = ParamUtil.getString(request, "location");
		String projName = ParamUtil.getString(request, "projName");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strStartDate = ParamUtil.getString(request, "bornDate");
		Date startDate = sdf.parse(strStartDate);
		String strEndDate = ParamUtil.getString(request, "bornDate");
		Date endDate = sdf.parse(strEndDate);
		String countys = ParamUtil.getString(request, "countyCheckbox");
		double ghhx = ParamUtil.getDouble(request, "ghhx");
		long roadTechLevel = ParamUtil.getLong(request, "roadTechLevel");
		long roadLevel = ParamUtil.getLong(request, "roadLevel");
		
		
		Project project = ProjectLocalServiceUtil.createProject(CounterLocalServiceUtil.increment());
		if (Validator.isNotNull(projectId)) {
			project = ProjectLocalServiceUtil.getProject(projectId);
		}
		ProjectLocalServiceUtil.updateProject(project);

	}

	/**
	 * 项目删除
	 * 
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void doDelete(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		long projectId = ParamUtil.getInteger(request, "projectId");
		if (Validator.isNotNull(projectId)) {
			ProjectLocalServiceUtil.deleteProject(projectId);
		}
	}


}
