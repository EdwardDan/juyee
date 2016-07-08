package com.justonetech.oa.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class DeptWeeklyWorkPortlet
 */
public class DeptWeeklyWorkPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			String keywords = ParamUtil.getString(renderRequest, "keywords", "");
			int delta = ParamUtil.getInteger(renderRequest, "delta", 5);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType", "");
			List<DeptWork> deptWorks = DeptWorkLocalServiceUtil.findByDeptName(keywords, start, end);
			int deptWorksCount = DeptWorkLocalServiceUtil.countByDeptName(keywords);

			renderRequest.setAttribute("deptWorks", deptWorks);
			renderRequest.setAttribute("deptWorksCount", deptWorksCount);
			renderRequest.setAttribute("orderByCol", orderByCol);
			renderRequest.setAttribute("orderByType", orderByType);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 */
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

		if (deptWorkId == 0) {
			deptWorkId = CounterLocalServiceUtil.increment();
			deptWork = DeptWorkLocalServiceUtil.createDeptWork(deptWorkId);
		} else {
			deptWork = DeptWorkLocalServiceUtil.getDeptWork(deptWorkId);
		}
//		deptWork.setDeptName(deptName);
//		deptWork.setUserName(userName);
		deptWork.setStatus(status);
//		try {
////			deptWork.setStartDate(sdf.parse(startDate));
////			deptWork.setEndDate(sdf.parse(endDate));
////			DeptWorkLocalServiceUtil.updateDeptWork(deptWork);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// 保存工作详情
		autoRowData(request, deptWork.getDeptWorkId());
	}

	// 保存自动添加行的数据
	private void autoRowData(ActionRequest request, Long deptWorkId) throws SystemException, PortalException {
		String rowIndexes = request.getParameter("rowIndexes");

		System.out.println("rowIndexes=============" + rowIndexes);
		String[] indexOfRows = rowIndexes.split(",");

		// 先删除所有关联item中的数据
		List<DeptWorkItem> deptWorkItems = DeptWorkItemLocalServiceUtil.findByDeptWorkId(deptWorkId);
		if (deptWorkItems != null && deptWorkItems.size() > 0) {
			for (DeptWorkItem deptWorkItem : deptWorkItems) {
				DeptWorkItemLocalServiceUtil.deleteDeptWorkItem(deptWorkItem);
			}
		}

		for (int i = 0; i < indexOfRows.length; i++) {

			int sortNo = ParamUtil.getInteger(request, "sortNo" + indexOfRows[i]);
			String dutyPerosn = ParamUtil.getString(request, "dutyPerosn" + indexOfRows[i]);
			boolean mainWork = ParamUtil.getBoolean(request, "mainWork" + indexOfRows[i]);
			String schedule = ParamUtil.getString(request, "schedule" + indexOfRows[i]);
			String content = ParamUtil.getString(request, "content" + indexOfRows[i]);
			String agentPerson = ParamUtil.getString(request, "agentPerson" + indexOfRows[i]);
			DeptWorkItem deptWorkItem = DeptWorkItemLocalServiceUtil.createDeptWorkItem(CounterLocalServiceUtil
					.increment());
			deptWorkItem.setSortNo(sortNo);
			deptWorkItem.setDutyPerosn(dutyPerosn);
			deptWorkItem.setMainWork(mainWork);
			deptWorkItem.setSchedule(schedule);
			deptWorkItem.setContent(content);
			deptWorkItem.setAgentPerson(agentPerson);
			deptWorkItem.setDeptWorkId(deptWorkId);

			DeptWorkItemLocalServiceUtil.updateDeptWorkItem(deptWorkItem);
		}
	}

	public void editDeptWork(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
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

	public void deleteDeptWorks(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, PortalException, SystemException {

		String deptWorkIds = ParamUtil.getString(actionRequest, "deptWorkIds");
		System.out.println("deptWork==============" + deptWorkIds);
		String[] splitDeptWorkIds = deptWorkIds.split(",");
		for (String deptWorkId : splitDeptWorkIds) {
			for (DeptWorkItem deptWorkItem : DeptWorkItemLocalServiceUtil.findByDeptWorkId(Long.valueOf(deptWorkId))) {
				if (deptWorkItem != null) {
					DeptWorkItemLocalServiceUtil.deleteDeptWorkItem(deptWorkItem);
				}
			}
			DeptWorkLocalServiceUtil.deleteDeptWork(Long.valueOf(deptWorkId));
		}
	}

}
