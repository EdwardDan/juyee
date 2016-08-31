package com.justonetech.oa.portlet;

import java.io.IOException;
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

import com.justonetech.oa.model.OfficeSupplyApplication;
import com.justonetech.oa.model.OfficeSupplyApplicationItem;
import com.justonetech.oa.service.OfficeSupplyApplicationItemLocalServiceUtil;
import com.justonetech.oa.service.OfficeSupplyApplicationLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Portlet implementation class OfficeSupplyApplicationPortlet
 */
public class OfficeSupplyApplicationPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(OfficeSupplyApplicationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		long userId = PortalUtil.getUserId(renderRequest);
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;
		List<OfficeSupplyApplication> officeSupplyApplications = Collections.emptyList();
		try {
			// officeSupplyApplications =
			// OfficeSupplyApplicationLocalServiceUtil.findByUserId(userId,
			// start, end);
			officeSupplyApplications = OfficeSupplyApplicationLocalServiceUtil.getOfficeSupplyApplications(-1, -1);
		} catch (SystemException e) {
			log.error("findByUserId(" + userId + "," + start + "," + end + ")出错：" + e.getMessage());
		}
		int OfficeSupplyApplicationsCount = 0;
		System.out.println(new Date());
		try {
			OfficeSupplyApplicationsCount = OfficeSupplyApplicationLocalServiceUtil.countByUserId(userId);
		} catch (SystemException e) {
			log.error("countByUserId(" + userId + ")出错：" + e.getMessage());
		}
		renderRequest.setAttribute("officeSupplyApplications", officeSupplyApplications);
		renderRequest.setAttribute("OfficeSupplyApplicationsCount", OfficeSupplyApplicationsCount);
		super.doView(renderRequest, renderResponse);
	}

	public void saveOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long officeSupplyApplicationId = ParamUtil.getLong(request, "officeSupplyApplicationId");
		long userId = PortalUtil.getUserId(request);
		String userName = ParamUtil.getString(request, "userName");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		String deptName = ParamUtil.getString(request, "deptName");
		String introductions = ParamUtil.getString(request, "introductions");
		String type = ParamUtil.getString(request, "type");
		String perposeClerk = "";
		if (type.equals("appoint")) {
			perposeClerk = ParamUtil.getString(request, "perposeClerk");
		}
		Date now = new Date();
		OfficeSupplyApplication officeSupplyApplication = null;
		if (Validator.isNotNull(officeSupplyApplicationId)) {
			officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
					.getOfficeSupplyApplication(officeSupplyApplicationId);
			officeSupplyApplication.setModifiedTime(now);
			if (type.equals("appoint")) {
				officeSupplyApplication.setStatus(7);
				officeSupplyApplication.setPerposeClerk(perposeClerk);
			}
		} else {
			officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
					.createOfficeSupplyApplication(CounterLocalServiceUtil.increment());
			officeSupplyApplication.setCreateTime(now);
			officeSupplyApplication.setModifiedTime(now);
		}
		officeSupplyApplication.setUserId(userId);
		officeSupplyApplication.setGroupId(groupId);
		officeSupplyApplication.setCompanyId(companyId);
		officeSupplyApplication.setUserName(userName);
		officeSupplyApplication.setDeptName(deptName);
		officeSupplyApplication.setIntroductions(introductions);
		OfficeSupplyApplicationLocalServiceUtil.updateOfficeSupplyApplication(officeSupplyApplication);

		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		for (OfficeSupplyApplicationItem officeSupplyApplicationItem : officeSupplyApplicationItems) {
			OfficeSupplyApplicationItemLocalServiceUtil.deleteOfficeSupplyApplicationItem(officeSupplyApplicationItem);
		}
		String[] names = request.getParameterValues("name");
		String[] models = request.getParameterValues("model");
		String[] units = request.getParameterValues("unit");
		String[] unitPrices = request.getParameterValues("unitPrice");
		String[] quantities = request.getParameterValues("quantity");
		for (int i = 0; i < names.length; i++) {
			OfficeSupplyApplicationItem officeSupplyApplicationItem = OfficeSupplyApplicationItemLocalServiceUtil
					.createOfficeSupplyApplicationItem(CounterLocalServiceUtil.increment());
			officeSupplyApplicationItem.setName(names[i]);
			officeSupplyApplicationItem.setModel(models[i]);
			officeSupplyApplicationItem.setUnit(units[i]);
			officeSupplyApplicationItem.setUnitPrice(Double.valueOf(unitPrices[i]));
			officeSupplyApplicationItem.setQuantity(Integer.valueOf(quantities[i]));
			officeSupplyApplicationItem.setOfficeSupplyApplicationId(officeSupplyApplication
					.getOfficeSupplyApplicationId());
			OfficeSupplyApplicationItemLocalServiceUtil.updateOfficeSupplyApplicationItem(officeSupplyApplicationItem);
		}
		ServiceContext serviceContext = ServiceContextFactory.getInstance(OfficeSupplyApplication.class.getName(),
				request);
		AssetEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(), officeSupplyApplication.getGroupId(),
				OfficeSupplyApplication.class.getName(), officeSupplyApplication.getOfficeSupplyApplicationId(), null,
				null);
		WorkflowHandlerRegistryUtil.startWorkflowInstance(officeSupplyApplication.getCompanyId(),
				officeSupplyApplication.getUserId(), OfficeSupplyApplication.class.getName(),
				officeSupplyApplication.getOfficeSupplyApplicationId(), officeSupplyApplication, serviceContext);
	}

	public void editOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException {
		long officeSupplyApplicationId = ParamUtil.getLong(request, "officeSupplyApplicationId");
		OfficeSupplyApplication officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
				.getOfficeSupplyApplication(officeSupplyApplicationId);
		List<OfficeSupplyApplicationItem> OfficeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		double sum = 0;
		for (OfficeSupplyApplicationItem OfficeSupplyApplicationItem : OfficeSupplyApplicationItems) {
			sum += OfficeSupplyApplicationItem.getUnitPrice() * OfficeSupplyApplicationItem.getQuantity();
		}
		request.setAttribute("officeSupplyApplication", officeSupplyApplication);
		request.setAttribute("officeSupplyApplicationId", officeSupplyApplicationId);
		request.setAttribute("officeSupplyApplicationItems", OfficeSupplyApplicationItems);
		request.setAttribute("sum", sum);
	}

	public void deleteOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException {
		long officeSupplyApplicationId = ParamUtil.getLong(request, "officeSupplyApplicationId");
		OfficeSupplyApplicationLocalServiceUtil.deleteOfficeSupplyApplication(officeSupplyApplicationId);
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		for (OfficeSupplyApplicationItem officeSupplyApplicationItem : officeSupplyApplicationItems) {
			OfficeSupplyApplicationItemLocalServiceUtil.deleteOfficeSupplyApplicationItem(officeSupplyApplicationItem);
		}
	}

	public void viewOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException {
		long officeSupplyApplicationId = ParamUtil.getLong(request, "officeSupplyApplicationId");
		OfficeSupplyApplication officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
				.getOfficeSupplyApplication(officeSupplyApplicationId);
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		List<OfficeSupplyApplicationItem> OfficeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		double sum = 0;
		for (OfficeSupplyApplicationItem OfficeSupplyApplicationItem : OfficeSupplyApplicationItems) {
			sum += OfficeSupplyApplicationItem.getUnitPrice() * OfficeSupplyApplicationItem.getQuantity();
		}
		request.setAttribute("officeSupplyApplication", officeSupplyApplication);
		request.setAttribute("officeSupplyApplicationItems", officeSupplyApplicationItems);
		request.setAttribute("sum", sum);
	}

	public void notification(ResourceRequest request, List<UserGroupRole> userGroupRoles) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			for (UserGroupRole userGroupRole : userGroupRoles) {
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userGroupRole.getUserId(),
						com.justonetech.oa.notification.OfficeSupplyApplicationNotificationHandler.PORTLET_ID,
						(new Date()).getTime(), userGroupRole.getUserId(), payloadJSON.toString(), false,
						serviceContext);
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String resourceId = resourceRequest.getResourceID();
		System.out.println("resourceId==========//=============" + resourceId);
		Long organizationId = ParamUtil.getLong(resourceRequest, "organizationId");
		System.out.println("organizationId============//=========" + organizationId);
		Long groupId = organizationId + 1;
		List<UserGroupRole> userGroupRoles = null;
		if (resourceId.equals("stateToReviewByKezhang")) {
			try {
				userGroupRoles = UserGroupRoleLocalServiceUtil.getUserGroupRolesByGroupAndRole(groupId, (long) 29656);
			} catch (SystemException e) {
				e.printStackTrace();
			}
			if (userGroupRoles != null) {
				notification(resourceRequest, userGroupRoles);
			}
		} else if (resourceId.equals("passURL")) {
			Long leaderId = ParamUtil.getLong(resourceRequest, "leaderId");
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(leaderId,
						com.justonetech.oa.notification.OfficeSupplyApplicationNotificationHandler.PORTLET_ID,
						(new Date()).getTime(), leaderId, payloadJSON.toString(), false, serviceContext);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}else if(resourceId.equals("rejectURL")){
			Long userId = ParamUtil.getLong(resourceRequest, "userId");
			System.out.println("===============userId="+userId+"123456789");
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(userId,
						com.justonetech.oa.notification.OfficeSupplyApplicationNotificationHandler.PORTLET_ID,
						(new Date()).getTime(), userId, payloadJSON.toString(), false, serviceContext);
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
}
