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

import com.justonetech.oa.model.VehicleRequisition;
import com.justonetech.oa.service.VehicleRequisitionLocalServiceUtil;
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
 * Portlet implementation class VehicleRequisitionPortlet
 */
public class VehicleRequisitionPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(VehicleRequisitionPortlet.class);
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String keywords = ParamUtil.getString(renderRequest, "keywords");
        int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
        int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
        int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
        int start = pageSize * (pageNumber - 1);
        int end = pageSize * pageNumber;

        List<VehicleRequisition> vehicleRequisitions = Collections.emptyList();
        try {
        	vehicleRequisitions = VehicleRequisitionLocalServiceUtil.findByApplicantName(keywords, start, end);
        }
        catch (SystemException e) {
            log.error("getVehicleRequisitionsByName(" + keywords + ", " + start + ", " + end + ")出错：" + e.getMessage());
        }
        int vehicleRequisitionsCount = 0;
        try {
        	vehicleRequisitionsCount = VehicleRequisitionLocalServiceUtil.countByName(keywords);
        }
        catch (SystemException e) {
            log.error("getVehicleRequisitionsCountByName(" + keywords + ")出错：" + e.getMessage());

        }
        renderRequest.setAttribute("vehicleRequisitions", vehicleRequisitions);
        renderRequest.setAttribute("vehicleRequisitionsCount", vehicleRequisitionsCount);

        super.doView(renderRequest, renderResponse);
	}
 
	//编辑
	public void editVehicleRequisition(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, SystemException {
		long vehicleRequisitionId = ParamUtil.getLong(actionRequest, "vehicleRequisitionId");
		VehicleRequisition vehicleRequisition = null;
		if (vehicleRequisitionId != 0) {
			vehicleRequisition = VehicleRequisitionLocalServiceUtil.getVehicleRequisition(vehicleRequisitionId);
		}
		actionRequest.setAttribute("vehicleRequisition", vehicleRequisition);
	}
	//保存并添加
	public void	saveVehicleRequisition(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException, SystemException, PortalException, ParseException {
			long vehicleRequisitionId=ParamUtil.getLong(actionRequest, "vehicleRequisitionId");
	        String applicantDeptName = ParamUtil.getString(actionRequest, "applicantDeptName");
	        String applicantName = ParamUtil.getString(actionRequest, "applicantName");
	        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date startTime = ParamUtil.getDate(actionRequest, "startTimes", df);
			Date endTime = ParamUtil.getDate(actionRequest, "endTimes", df);
	        String reason = ParamUtil.getString(actionRequest, "reason");
	        int passengerNum = ParamUtil.getInteger(actionRequest, "passengerNum");
	        String destination=ParamUtil.getString(actionRequest, "destination");
	        VehicleRequisition vehicleRequisition=null;
	        Date now = new Date();
	        if (vehicleRequisitionId == 0) {
	        	vehicleRequisitionId = CounterLocalServiceUtil.increment();
	        	vehicleRequisition = VehicleRequisitionLocalServiceUtil.createVehicleRequisition(vehicleRequisitionId);

	        	vehicleRequisition.setCreateTime(now);
	        }
	        else {
	        	vehicleRequisition = VehicleRequisitionLocalServiceUtil.getVehicleRequisition(vehicleRequisitionId);
	        }

	        User user = PortalUtil.getUser(actionRequest);
	        if (Validator.isNotNull(user)) {
	        	vehicleRequisition.setUserId(user.getUserId());
	        	vehicleRequisition.setUserName(user.getFullName());
	        }

	        vehicleRequisition.setApplicantDeptName(applicantDeptName);
	        vehicleRequisition.setApplicantName(applicantName);
	        vehicleRequisition.setStartTime(startTime);
	        vehicleRequisition.setEndTime(endTime);
	        vehicleRequisition.setReason(reason);
	        vehicleRequisition.setPassengerNum(passengerNum);
	        vehicleRequisition.setDestination(destination);
	        vehicleRequisition.setModifiedTime(now);
	        VehicleRequisitionLocalServiceUtil.updateVehicleRequisition(vehicleRequisition);
	        
		}
	
	
	//删除
	 public void deleteVehicleRequisitions(ActionRequest actionRequest, ActionResponse actionResponse)
		        throws IOException, PortletException, NumberFormatException, PortalException, SystemException {
		        String deleteVehicleRequisitionIds = ParamUtil.getString(actionRequest, "vehicleRequisitionIds");
		        String[] vehicleRequisitionIds = deleteVehicleRequisitionIds.split(",");
		        VehicleRequisitionLocalServiceUtil.deleteVehicleRequisitions(vehicleRequisitionIds);
		    }
}
