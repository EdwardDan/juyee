package com.justonetech.oa.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.VehicleApplication;
import com.justonetech.oa.service.VehicleApplicationLocalServiceUtil;
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
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VehicleApplicationPortlet
 */
public class VehicleApplicationPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(VehicleApplicationPortlet.class);
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String keywords = ParamUtil.getString(renderRequest, "keywords");
        int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
        int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
        int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
        int start = pageSize * (pageNumber - 1);
        int end = pageSize * pageNumber;

        List<VehicleApplication> vehicleApplications = Collections.emptyList();
        try {
        	vehicleApplications = VehicleApplicationLocalServiceUtil.findByApplicantName(keywords, start, end);
        }
        catch (SystemException e) {
            log.error("getVehicleApplicationsByName(" + keywords + ", " + start + ", " + end + ")出错：" + e.getMessage());
        }
        int vehicleApplicationsCount = 0;
        try {
        	vehicleApplicationsCount = VehicleApplicationLocalServiceUtil.countByName(keywords);
        }
        catch (SystemException e) {
            log.error("getVehicleApplicationsCountByName(" + keywords + ")出错：" + e.getMessage());

        }
        renderRequest.setAttribute("vehicleApplications", vehicleApplications);
        renderRequest.setAttribute("vehicleApplicationsCount", vehicleApplicationsCount);

        super.doView(renderRequest, renderResponse);
	}
 
	//编辑
	public void editVehicleApplication(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, SystemException {
		long vehicleApplicationId = ParamUtil.getLong(actionRequest, "vehicleApplicationId");
		VehicleApplication vehicleApplication = null;
		if (vehicleApplicationId != 0) {
			vehicleApplication = VehicleApplicationLocalServiceUtil.getVehicleApplication(vehicleApplicationId);
		}
		actionRequest.setAttribute("vehicleApplication", vehicleApplication);
	}
	//保存并添加
	public void	saveVehicleApplication(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException, SystemException, PortalException, ParseException {
			long vehicleApplicationId=ParamUtil.getLong(actionRequest, "vehicleApplicationId");
	        String applicantDeptName = ParamUtil.getString(actionRequest, "applicantDeptName");
	        String applicantName = ParamUtil.getString(actionRequest, "applicantName");
	        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date startTime = ParamUtil.getDate(actionRequest, "startTimes", df);
			Date endTime = ParamUtil.getDate(actionRequest, "endTimes", df);
	        String reason = ParamUtil.getString(actionRequest, "reason");
	        int passengerNum = ParamUtil.getInteger(actionRequest, "passengerNum");
	        String destination=ParamUtil.getString(actionRequest, "destination");
	        VehicleApplication vehicleApplication=null;
	        Date now = new Date();
	        if (vehicleApplicationId == 0) {
	        	vehicleApplicationId = CounterLocalServiceUtil.increment();
	        	vehicleApplication = VehicleApplicationLocalServiceUtil.createVehicleApplication(vehicleApplicationId);

	        	vehicleApplication.setCreateTime(now);
	        }
	        else {
	        	vehicleApplication = VehicleApplicationLocalServiceUtil.getVehicleApplication(vehicleApplicationId);
	        }

	        User user = PortalUtil.getUser(actionRequest);
	        if (Validator.isNotNull(user)) {
	        	vehicleApplication.setUserId(user.getUserId());
	        	vehicleApplication.setUserName(user.getFullName());
	        }

	        vehicleApplication.setApplicantDeptName(applicantDeptName);
	        vehicleApplication.setApplicantName(applicantName);
	        vehicleApplication.setStartTime(startTime);
	        vehicleApplication.setEndTime(endTime);
	        vehicleApplication.setReason(reason);
	        vehicleApplication.setPassengerNum(passengerNum);
	        vehicleApplication.setDestination(destination);
	        vehicleApplication.setModifiedTime(now);
	        VehicleApplicationLocalServiceUtil.updateVehicleApplication(vehicleApplication);
	        
		}
	
	
	//删除
	 public void deleteVehicleApplications(ActionRequest actionRequest, ActionResponse actionResponse)
		        throws IOException, PortletException, NumberFormatException, PortalException, SystemException {
		        String deleteVehicleApplicationIds = ParamUtil.getString(actionRequest, "vehicleApplicationIds");
		        String[] vehicleApplicationIds = deleteVehicleApplicationIds.split(",");
		        VehicleApplicationLocalServiceUtil.deleteVehicleApplications(vehicleApplicationIds);
		    }
}
