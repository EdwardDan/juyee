package com.justonetech.oa.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.justonetech.oa.model.VehicleApplication;
import com.justonetech.oa.service.VehicleApplicationLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchWorkflowDefinitionLinkException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowTask;
import com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowDefinitionLink;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VehicleApplicationPortlet
 */
public class VehicleApplicationPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(VehicleApplicationPortlet.class);
	private static String timeFormatPattern = PropsUtil.get("default.date.format.pattern") + " "
			+ PropsUtil.get("default.time.format.pattern").substring(0, 5);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		List<VehicleApplication> vehicleApplications = Collections.emptyList();
		try {
			vehicleApplications = VehicleApplicationLocalServiceUtil.findByApplicantName(keywords, start, end);

		} catch (SystemException e) {
			log.error("getVehicleApplicationsByName(" + keywords + ", " + start + ", " + end + ")出错：" + e.getMessage());
		}
		int vehicleApplicationsCount = 0;
		try {
			vehicleApplicationsCount = VehicleApplicationLocalServiceUtil.countByName(keywords);
		} catch (SystemException e) {
			log.error("getVehicleApplicationsCountByName(" + keywords + ")出错：" + e.getMessage());

		}
		renderRequest.setAttribute("vehicleApplications", vehicleApplications);
		renderRequest.setAttribute("vehicleApplicationsCount", vehicleApplicationsCount);

		super.doView(renderRequest, renderResponse);
	}

	// 编辑
	public void editVehicleApplication(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		long vehicleApplicationId = ParamUtil.getLong(actionRequest, "vehicleApplicationId");
		String[] assetTypes = new String[1];
		assetTypes[0] = "com.justonetech.oa.model.VehicleApplication";
		OrderByComparator orderByComparator = null;
		List<WorkflowTask> results = null;
		try {
			results = WorkflowTaskManagerUtil
					.search(20154L, 0, null, assetTypes, null, null, -1, -1, orderByComparator);
		} catch (WorkflowException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		System.out.println("results.size=" + results.size());
		for (WorkflowTask aa : results) {
			try {
				if (KaleoTaskInstanceTokenLocalServiceUtil.getKaleoTaskInstanceToken(aa.getWorkflowTaskId())
						.getClassPK() == vehicleApplicationId) {
					System.out.println("kaleoTaskInstanceTokenId=" + aa.getWorkflowTaskId());
				}
			} catch (PortalException | SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		VehicleApplication vehicleApplication = null;
		if (vehicleApplicationId != 0) {
			vehicleApplication = VehicleApplicationLocalServiceUtil.getVehicleApplication(vehicleApplicationId);
		}
		actionRequest.setAttribute("vehicleApplication", vehicleApplication);

	}

	// 保存并添加
	public void saveVehicleApplication(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException, ParseException {
		String type = ParamUtil.getString(actionRequest, "type");
		System.out.println("type后台=" + type);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long vehicleApplicationId = ParamUtil.getLong(actionRequest, "vehicleApplicationId");
		String applicantDeptName = ParamUtil.getString(actionRequest, "applicantDeptName");
		String applicantName = ParamUtil.getString(actionRequest, "applicantName");
		Date startTime = ParamUtil.getDate(actionRequest, "startTimeFmt", new SimpleDateFormat(timeFormatPattern));
		Date endTime = ParamUtil.getDate(actionRequest, "endTimeFmt", new SimpleDateFormat(timeFormatPattern));
		String reason = ParamUtil.getString(actionRequest, "reason");
		int passengerNum = ParamUtil.getInteger(actionRequest, "passengerNum");
		String destination = ParamUtil.getString(actionRequest, "destination");
		long proposeVehicle = ParamUtil.getLong(actionRequest, "proposeVehicle");
		Boolean isProposeDriver = ParamUtil.getBoolean(actionRequest, "isProposeDriver");
		String driver = ParamUtil.getString(actionRequest, "driver");
		String phone = ParamUtil.getString(actionRequest, "phone");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(VehicleApplication.class.getName(),
				actionRequest);
		VehicleApplication vehicleApplication = null;
		Date now = new Date();
		if (vehicleApplicationId == 0) {
			vehicleApplicationId = CounterLocalServiceUtil.increment();
			vehicleApplication = VehicleApplicationLocalServiceUtil.createVehicleApplication(vehicleApplicationId);

			vehicleApplication.setCreateTime(now);
		} else {
			vehicleApplication = VehicleApplicationLocalServiceUtil.getVehicleApplication(vehicleApplicationId);
		}

		User user = PortalUtil.getUser(actionRequest);
		if (Validator.isNotNull(user)) {
			vehicleApplication.setUserId(user.getUserId());
			vehicleApplication.setUserName(user.getFullName());
			vehicleApplication.setStatusByUserName(user.getFullName());
		}

		vehicleApplication.setApplicantDeptName(applicantDeptName);
		vehicleApplication.setApplicantName(applicantName);
		vehicleApplication.setStartTime(startTime);
		vehicleApplication.setEndTime(endTime);
		vehicleApplication.setReason(reason);
		vehicleApplication.setProposeVehicle(proposeVehicle);
		vehicleApplication.setIsProposeDriver(isProposeDriver ? 1 : 0);
		vehicleApplication.setDriver(driver);
		vehicleApplication.setPhone(phone);
		vehicleApplication.setPassengerNum(passengerNum);
		vehicleApplication.setDestination(destination);
		vehicleApplication.setModifiedTime(now);
		vehicleApplication.setGroupId(themeDisplay.getScopeGroupId());
		// 没有类似companyId这样的字段，状态不进行更新。
		vehicleApplication.setCompanyId(themeDisplay.getCompanyId());
		vehicleApplication.setTitle("车辆申请内容");
		vehicleApplication.setContent("申请部门：" + applicantDeptName + " 申请人:" + applicantName + " 用车人数：" + passengerNum
				+ " 目的地：" + destination);
		VehicleApplicationLocalServiceUtil.updateVehicleApplication(vehicleApplication);
		WorkflowDefinitionLink workflowDefinitionLink = null;
		try {
			workflowDefinitionLink = WorkflowDefinitionLinkLocalServiceUtil.getDefaultWorkflowDefinitionLink(
					themeDisplay.getCompanyId(), VehicleApplication.class.getName(), 0, 0);
		} catch (Exception e) {
			if (e instanceof NoSuchWorkflowDefinitionLinkException) {
				SessionMessages.add(actionRequest.getPortletSession(), "workflow-not-enabled");
			}
			e.printStackTrace();
		}
		if (vehicleApplication != null && workflowDefinitionLink != null) {
			AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(), vehicleApplication.getGroupId(),
					VehicleApplication.class.getName(), vehicleApplication.getVehicleApplicationId(), null, null);
			// if(null==WorkflowHandlerRegistryUtil.getWorkflowHandler(VehicleApplication.class.getName())){
			System.out.println("id=" + vehicleApplication.getVehicleApplicationId());
			WorkflowHandlerRegistryUtil.startWorkflowInstance(vehicleApplication.getCompanyId(),
					vehicleApplication.getUserId(), VehicleApplication.class.getName(),
					vehicleApplication.getVehicleApplicationId(), vehicleApplication, serviceContext);
			// }
		}
	}

	// 删除
	public void deleteVehicleApplications(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, NumberFormatException, PortalException, SystemException {

		String deleteVehicleApplicationIds = ParamUtil.getString(actionRequest, "vehicleApplicationIds");
		String[] vehicleApplicationIds = deleteVehicleApplicationIds.split(",");
		for (String a : vehicleApplicationIds) {
			System.out.println("删除的ID为=" + a);
			VehicleApplication oneToDel = VehicleApplicationLocalServiceUtil.getVehicleApplication(Long.parseLong(a));
			WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(oneToDel.getCompanyId(),
					oneToDel.getGroupId(), VehicleApplication.class.getName(), oneToDel.getApplicantId());
		}
		VehicleApplicationLocalServiceUtil.deleteVehicleApplications(vehicleApplicationIds);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String resourceID = resourceRequest.getResourceID();
		System.out.println("===============" + resourceID);
		String dictionaryId = ParamUtil.getString(resourceRequest, "proposeVehicle");
		Dictionary dictionary = null;
		try {
			dictionary = DictionaryLocalServiceUtil.getDictionary(Long.valueOf(dictionaryId));
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray userArray = JSONFactoryUtil.createJSONArray();
		JSONObject dic = null;
		dic = JSONFactoryUtil.createJSONObject();
		dic.put("driver", dictionary.getTag());
		dic.put("phone", dictionary.getDesc());
		userArray.put(dic);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(userArray.toString());
		System.out.println("userArray=" + userArray.toString());
		out.flush();
		out.close();

		resourceResponse.getWriter().write("Resource served successfully!");
		super.serveResource(resourceRequest, resourceResponse);
	}

}
