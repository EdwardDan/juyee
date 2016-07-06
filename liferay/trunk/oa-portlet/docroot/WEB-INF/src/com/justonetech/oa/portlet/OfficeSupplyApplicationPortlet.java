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

import com.justonetech.oa.model.OfficeSupplyApplication;
import com.justonetech.oa.model.OfficeSupplyApplicationItem;
import com.justonetech.oa.service.OfficeSupplyApplicationItemLocalServiceUtil;
import com.justonetech.oa.service.OfficeSupplyApplicationLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OfficeSupplyApplicationPortlet
 */
public class OfficeSupplyApplicationPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(OfficeSupplyApplicationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		long userId = PortalUtil.getUserId(renderRequest);
		// String userName = PortalUtil.getUserName(userId, "default");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;

		List<OfficeSupplyApplication> officeSupplyApplications = Collections.emptyList();
		try {
			officeSupplyApplications = OfficeSupplyApplicationLocalServiceUtil.findByUserId(userId, start, end);
		} catch (SystemException e) {
			log.error("findByUserId(" + userId + "," + start + "," + end + ")出错：" + e.getMessage());
		}
		int OfficeSupplyApplicationsCount = 0;
		try {
			OfficeSupplyApplicationsCount = OfficeSupplyApplicationLocalServiceUtil.countByUserId(userId);
		} catch (SystemException e) {
			log.error("countByUserId(" + userId + ")出错：" + e.getMessage());
		}
		renderRequest.setAttribute("officeSupplyApplications", officeSupplyApplications);
		renderRequest.setAttribute("OfficeSupplyApplicationsCount", OfficeSupplyApplicationsCount);
		super.doView(renderRequest, renderResponse);
	}

	public void saveOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws SystemException {
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "default");
		String deptName = ParamUtil.getString(request, "deptName");
		String introductions = ParamUtil.getString(request, "introductions");
		Date now = new Date();
		OfficeSupplyApplication officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
				.createOfficeSupplyApplication(CounterLocalServiceUtil.increment());
		officeSupplyApplication.setUserId(userId);
		officeSupplyApplication.setUserName(userName);
		officeSupplyApplication.setCreateTime(now);
		officeSupplyApplication.setModifiedTime(now);
		officeSupplyApplication.setDeptName(deptName);
		officeSupplyApplication.setDeptName(introductions);
		OfficeSupplyApplicationLocalServiceUtil.updateOfficeSupplyApplication(officeSupplyApplication);
		long officeSupplyApplicationId = officeSupplyApplication.getOfficeSupplyApplicationId();
		String rowIndexes = request.getParameter("rowIndexes");
		String[] indexOfRows = rowIndexes.split(",");
		for (int i = 0; i < indexOfRows.length; i++) {
			OfficeSupplyApplicationItem officeSupplyApplicationItem = OfficeSupplyApplicationItemLocalServiceUtil
					.createOfficeSupplyApplicationItem(CounterLocalServiceUtil.increment());
			String name = (request.getParameter("name" + indexOfRows[i])).trim();
			String model = (request.getParameter("model" + indexOfRows[i])).trim();
			String unit = (request.getParameter("unit" + indexOfRows[i])).trim();
			String str1 = (request.getParameter("unitPrice" + indexOfRows[i])).trim();
			double unitPrice = Double.parseDouble(str1);
			String str2 = (request.getParameter("quantity" + indexOfRows[i])).trim();
			int quantity = Integer.valueOf(str2);
			officeSupplyApplicationItem.setName(name);
			officeSupplyApplicationItem.setModel(model);
			officeSupplyApplicationItem.setUnit(unit);
			officeSupplyApplicationItem.setUnitPrice(unitPrice);
			officeSupplyApplicationItem.setQuantity(quantity);
			officeSupplyApplicationItem.setOfficeSupplyApplicationId(officeSupplyApplicationId);
			OfficeSupplyApplicationItemLocalServiceUtil.updateOfficeSupplyApplicationItem(officeSupplyApplicationItem);
		}
	}
	
	public void editOfficeSupplyApplication(ActionRequest request, ActionResponse response) {
		
	}
	
	public void deleteOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long officeSupplyApplicationId = ParamUtil.getLong(request, "officeSupplyApplicationId");
		OfficeSupplyApplicationLocalServiceUtil.deleteOfficeSupplyApplication(officeSupplyApplicationId);
//		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil.d
	}
	
	public void viewOfficeSupplyApplication(ActionRequest request, ActionResponse response) {
		
	}
}
