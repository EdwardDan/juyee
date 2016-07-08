package com.justonetech.oa.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.DeptWork;
import com.justonetech.oa.model.DeptWorkItem;
import com.justonetech.oa.service.DeptWorkItemLocalServiceUtil;
import com.justonetech.oa.service.DeptWorkLocalServiceUtil;
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
 * Portlet implementation class DeptWeeklyWorkPortlet
 */
public class DeptWeeklyWorkPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(OfficeSupplyApplicationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		long userId = PortalUtil.getUserId(renderRequest);
		String userName = PortalUtil.getUserName(userId, "");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		List<DeptWork> deptWorks = Collections.emptyList();
		try {
			deptWorks = DeptWorkLocalServiceUtil.findByUserName(userName, start, end);
		} catch (SystemException e) {
			log.error("findByUserNam(" + userName + "," + start + "," + end + ")错误：" + e.getMessage());
		}
		int deptWorkCount = 0;
		try {
			deptWorkCount = DeptWorkLocalServiceUtil.countByUserName(userName);
		} catch (SystemException e) {
			log.error("countByUserNam(" + userName + ")错误：" + e.getMessage());
		}
		renderRequest.setAttribute("deptWorks", deptWorks);
		renderRequest.setAttribute("deptWorkCount", deptWorkCount);
		super.doView(renderRequest, renderResponse);
	}

	public void saveDeptWork(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		long deptWorkId = ParamUtil.getLong(request, "deptWorkId");
		String status = ParamUtil.getString(request, "status");
		System.out.println("sutats==============" + status);
		String deptName = ParamUtil.getString(request, "deptName");
		String userName = ParamUtil.getString(request, "userName");
		String startDate = ParamUtil.getString(request, "startDate");
		String endDate = ParamUtil.getString(request, "endDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DeptWork deptWork;

	}

	public void editDeptWeeklyWork(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		Long deptWorkId = ParamUtil.getLong(actionRequest, "deptWorkId");
		DeptWork deptWork = null;
		if (Validator.isNotNull(deptWorkId)) {
			deptWork = DeptWorkLocalServiceUtil.getDeptWork(deptWorkId);
		}

		List<DeptWorkItem> deptWorkItems = DeptWorkItemLocalServiceUtil.findByDeptWorkId(deptWorkId);

		actionRequest.setAttribute("deptWork", deptWork);
		actionRequest.setAttribute("deptWorkItems", deptWorkItems);
		actionResponse.setRenderParameter("mvcPath", "/portlet/dept-weekly-work/edit-dept-weekly-work.jsp");
	}

	public void deleteDeptWeeklyWork(ActionRequest actionRequest, ActionResponse actionResponse) {

	}

	public void viewDeptWeeklyWork(ActionRequest actionRequest, ActionResponse actionResponse) {

	}

}
