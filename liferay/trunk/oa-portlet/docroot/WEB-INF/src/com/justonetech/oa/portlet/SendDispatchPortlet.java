package com.justonetech.oa.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.oa.model.Dispatch;
import com.justonetech.oa.service.DispatchLocalServiceUtil;
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
 * Portlet implementation class SendDispatchPortlet
 */
public class SendDispatchPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(SendDispatchPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int delta = GetterUtil.getInteger(PropsUtil
				.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;

		List<Dispatch> dispatches = Collections.emptyList();
		try {
			dispatches = DispatchLocalServiceUtil.findByTitle(keywords,
					start, end);
		} catch (SystemException e) {
			log.error("getDispatchesByTitle(" + keywords + ", " + start
					+ ", " + end + ")出错：" + e.getMessage());
		}
		int dispatchesCount = 0;
		try {
			dispatchesCount = DispatchLocalServiceUtil
					.countByTitle(keywords);
		} catch (SystemException e) {
			log.error("getDispatchesCountByTitle(" + keywords + ")出错："
					+ e.getMessage());

		}
		renderRequest.setAttribute("dispatches", dispatches);
		renderRequest.setAttribute("dispatchesCount", dispatchesCount);

		super.doView(renderRequest, renderResponse);
	}

	public void editDispatch(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {

		long dispatchId = ParamUtil.getLong(actionRequest, "dispatchId");
		Dispatch dispatch = null;
		if (dispatchId != 0) {
			dispatch = DispatchLocalServiceUtil.getDispatch(dispatchId);
		}
		actionRequest.setAttribute("dispatch", dispatch);
	}

	public void saveDispatch(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException {

		long dispatchId = ParamUtil.getLong(actionRequest, "dispatchId");

		long recordType = ParamUtil.getLong(actionRequest, "recordType");
		long securityLevel = ParamUtil.getLong(actionRequest, "securityLevel");
		long organaAbbreviation = ParamUtil.getLong(actionRequest,
				"organaAbbreviation");
		int year = ParamUtil.getInteger(actionRequest, "year");
		int serialNo = ParamUtil.getInteger(actionRequest, "serialNo");
		String title = ParamUtil.getString(actionRequest, "title");
		String sendOrgan = ParamUtil.getString(actionRequest, "sendOrgan");
		String ccOrgan = ParamUtil.getString(actionRequest, "ccOrgan");
		String writtenOrgan = ParamUtil
				.getString(actionRequest, "writtenOrgan");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date writtenDate = ParamUtil.getDate(actionRequest, "writtenDateFormat", sdf);
		long urgencyDegree = ParamUtil.getLong(actionRequest, "urgencyDegree");
		Dispatch dispatch = null;
		Date now = new Date();
		if (dispatchId == 0) {
			dispatchId = CounterLocalServiceUtil.increment();
			dispatch = DispatchLocalServiceUtil.createDispatch(dispatchId);

			dispatch.setCreateTime(now);
		} else {
			dispatch = DispatchLocalServiceUtil.getDispatch(dispatchId);
		}

		User user = PortalUtil.getUser(actionRequest);
		if (Validator.isNotNull(user)) {
			dispatch.setUserId(user.getUserId());
			dispatch.setUserName(user.getFullName());
		}
		dispatch.setRecordType(recordType);
		dispatch.setSecurityLevel(securityLevel);
		dispatch.setOrganaAbbreviation(organaAbbreviation);
		dispatch.setYear(year);
		dispatch.setSerialNo(serialNo);
		dispatch.setTitle(title);
		dispatch.setSendOrgan(sendOrgan);
		dispatch.setCcOrgan(ccOrgan);
		dispatch.setWrittenOrgan(writtenOrgan);
		dispatch.setWrittenDate(writtenDate);
		dispatch.setUrgencyDegree(urgencyDegree);
		dispatch.setModifiedTime(now);
		DispatchLocalServiceUtil.updateDispatch(dispatch);
	}

	public void deleteDispatches(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, NumberFormatException, PortalException,
			SystemException {

		String deleteDispatchIds = ParamUtil.getString(actionRequest,
				"dispatchIds");
		String[] dispatchIds = deleteDispatchIds.split(",");
		DispatchLocalServiceUtil.deleteDispatchs(dispatchIds);
	}
}
