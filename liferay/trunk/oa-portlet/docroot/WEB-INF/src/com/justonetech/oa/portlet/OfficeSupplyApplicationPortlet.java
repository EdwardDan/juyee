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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
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
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1) ;
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

	public void saveOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException {
		long officeSupplyApplicationId = ParamUtil.getLong(request, "officeSupplyApplicationId");
		System.out.println("==================="+officeSupplyApplicationId);
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "");
		String deptName = ParamUtil.getString(request, "deptName");
		String introductions = ParamUtil.getString(request, "introductions");
		Date now = new Date();
		OfficeSupplyApplication officeSupplyApplication = null;
		if (Validator.isNotNull(officeSupplyApplicationId)) {
			officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
					.getOfficeSupplyApplication(officeSupplyApplicationId);
			officeSupplyApplication.setModifiedTime(now);
		} else {
			officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
					.createOfficeSupplyApplication(CounterLocalServiceUtil.increment());
			officeSupplyApplication.setCreateTime(now);
			officeSupplyApplication.setModifiedTime(now);
		}
		officeSupplyApplication.setUserId(userId);
		officeSupplyApplication.setUserName(userName);
		officeSupplyApplication.setDeptName(deptName);
		officeSupplyApplication.setIntroductions(introductions);
		OfficeSupplyApplicationLocalServiceUtil.updateOfficeSupplyApplication(officeSupplyApplication);
		
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		for (OfficeSupplyApplicationItem officeSupplyApplicationItem : officeSupplyApplicationItems) {
			OfficeSupplyApplicationItemLocalServiceUtil.deleteOfficeSupplyApplicationItem(officeSupplyApplicationItem);
		}
		String rowIndexes = request.getParameter("rowIndexes");
		String[] indexOfRows = rowIndexes.split(",");
		for (int i = 0; i < indexOfRows.length; i++) {
			OfficeSupplyApplicationItem officeSupplyApplicationItem = OfficeSupplyApplicationItemLocalServiceUtil
						.createOfficeSupplyApplicationItem(CounterLocalServiceUtil.increment());			
			String name = ParamUtil.getString(request, "name" + indexOfRows[i]);
			String model = ParamUtil.getString(request, "model" + indexOfRows[i]);
			String unit = ParamUtil.getString(request, "unit" + indexOfRows[i]);
			int quantity = ParamUtil.getInteger(request, "quantity" + indexOfRows[i]);
			double unitPrice = ParamUtil.getDouble(request,"unitPrice" + indexOfRows[i]);
			officeSupplyApplicationItem.setName(name);
			officeSupplyApplicationItem.setModel(model);
			officeSupplyApplicationItem.setUnit(unit);
			officeSupplyApplicationItem.setUnitPrice(unitPrice);
			officeSupplyApplicationItem.setQuantity(quantity);
			officeSupplyApplicationItem.setOfficeSupplyApplicationId(officeSupplyApplication
					.getOfficeSupplyApplicationId());
			OfficeSupplyApplicationItemLocalServiceUtil.updateOfficeSupplyApplicationItem(officeSupplyApplicationItem);
		}
	}

	public void editOfficeSupplyApplication(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException {
		long officeSupplyApplicationId = ParamUtil.getLong(request, "officeSupplyApplicationId");
		OfficeSupplyApplication officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
				.getOfficeSupplyApplication(officeSupplyApplicationId);
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		request.setAttribute("officeSupplyApplication", officeSupplyApplication);
		request.setAttribute("officeSupplyApplicationId", officeSupplyApplicationId);
		request.setAttribute("officeSupplyApplicationItems", officeSupplyApplicationItems);
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
		System.out.println("====================="+officeSupplyApplicationId);
		OfficeSupplyApplication officeSupplyApplication = OfficeSupplyApplicationLocalServiceUtil
				.getOfficeSupplyApplication(officeSupplyApplicationId);
		List<OfficeSupplyApplicationItem> officeSupplyApplicationItems = OfficeSupplyApplicationItemLocalServiceUtil
				.findByOfficeSupplyApplicationId(officeSupplyApplicationId);
		request.setAttribute("officeSupplyApplication", officeSupplyApplication);
		request.setAttribute("officeSupplyApplicationItems", officeSupplyApplicationItems);
	}
}
