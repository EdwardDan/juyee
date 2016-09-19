package com.justonetech.leo.portlet;

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

import com.justonetech.cyzt.leo.model.LEOCertificate;
import com.justonetech.cyzt.leo.model.LEOTraining;
import com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil;
import com.justonetech.cyzt.leo.service.LEOTrainingLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LEOTrainingPortlet
 */
public class LEOTrainingPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(LEOTrainingPortlet.class);
	private static String dateFormatPattern = PropsUtil.get("default.date.format.pattern");

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		} catch (PortalException | SystemException e) {
			log.info(e.getMessage());
		}
		String zylx = ParamUtil.getString(renderRequest, "zylx", "");
		String xm = ParamUtil.getString(renderRequest, "xm", "");
		String certificateId = ParamUtil.getString(renderRequest, "certificateId", "");
		Date yxq = ParamUtil.getDate(renderRequest, "yxq", new SimpleDateFormat(dateFormatPattern), null);
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;
		List<LEOCertificate> leoCertificates = Collections.emptyList();
		int leoCertificatesCount = 0;
		leoCertificates = LEOCertificateLocalServiceUtil.getLEOCertificates(xm, zylx, certificateId, yxq, start, end);
		leoCertificatesCount = LEOCertificateLocalServiceUtil.getLEOCertificatesCount(xm, zylx, certificateId, yxq);
		renderRequest.setAttribute("certificateId", certificateId);
		renderRequest.setAttribute("leoCertificates", leoCertificates);
		renderRequest.setAttribute("leoCertificatesCount", leoCertificatesCount);
		renderRequest.setAttribute("yxq", yxq);
		super.doView(renderRequest, renderResponse);
	}

	public void saveLEOTrainings(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, IOException {
		long certificateId = ParamUtil.getLong(request, "certificateId");
		Date[] pxsjs = ParamUtil.getDateValues(request, "pxsj", new SimpleDateFormat(dateFormatPattern), null);
		Date[] xcjysjs = ParamUtil.getDateValues(request, "xcjysj", new SimpleDateFormat(dateFormatPattern), null);
		String[] pxnrs = ParamUtil.getParameterValues(request, "pxnr");

		// 保存前删除以前的数据
		List<LEOTraining> leoTrainingsByZjbh = LEOTrainingLocalServiceUtil.findByCertificateId(certificateId, -1, -1);
		if (null != leoTrainingsByZjbh && leoTrainingsByZjbh.size() > 0) {
			for (LEOTraining leoTraining : leoTrainingsByZjbh) {
				LEOTrainingLocalServiceUtil.deleteLEOTraining(leoTraining);
			}

		}
		if (null != pxsjs) {
			for (int i = 0; i < pxsjs.length; i++) {
				LEOTraining leoTraining = LEOTrainingLocalServiceUtil.createLEOTraining(CounterLocalServiceUtil
						.increment());
				if (null != pxnrs && pxnrs.length > 0) {
					leoTraining.setPxnr(pxnrs[i]);
				}
				if (null != pxsjs && pxsjs.length > 0) {
					leoTraining.setPxsj(pxsjs[i]);
				}
				leoTraining.setCertificateId(certificateId);
				if (null != xcjysjs && xcjysjs.length > 0) {
					leoTraining.setXcjysj(xcjysjs[i]);
				}
				LEOTrainingLocalServiceUtil.addLEOTraining(leoTraining);
			}

		}
	}

}
