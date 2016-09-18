package com.justonetech.leo.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.justonetech.cyzt.leo.model.LEOCertificate;
import com.justonetech.cyzt.leo.service.LEOCertificateLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.UserGroupRole;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LEOCertificatePortlet
 */
public class LEOCertificatePortlet extends MVCPortlet {
	private static String dateFormatPattern = PropsUtil
			.get("default.date.format.pattern");

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		String xm = ParamUtil.getString(renderRequest, "xm", "");
		String zylx = ParamUtil.getString(renderRequest, "zylx", "");
		String certificateId = ParamUtil.getString(renderRequest,
				"certificateId", "");
		Date yxq = ParamUtil.getDate(renderRequest, "yxq",
				new SimpleDateFormat(dateFormatPattern), null);

		List<LEOCertificate> leoCertificates = LEOCertificateLocalServiceUtil
				.getLEOCertificates(xm, zylx, certificateId, yxq, -1, -1);

		int leoCertificatesCount = 0;
		try {
			leoCertificatesCount = LEOCertificateLocalServiceUtil
					.getLEOCertificatesCount();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		renderRequest.setAttribute("leoCertificates", leoCertificates);
		renderRequest
				.setAttribute("leoCertificatesCount", leoCertificatesCount);
		
		super.doView(renderRequest, renderResponse);
	}

	public void saveLEOCertificate(ActionRequest request,
			ActionResponse response) throws SystemException {
		String xm = ParamUtil.getString(request, "xm");
		String zylx = ParamUtil.getString(request, "zylx");
		String certificateId = ParamUtil.getString(request, "certificateId");
		Date fzrq = ParamUtil.getDate(request, "fzrq", new SimpleDateFormat(
				dateFormatPattern));
		Date yxq = ParamUtil.getDate(request, "yxq", new SimpleDateFormat(
				dateFormatPattern));
		LEOCertificate leoCertificate = null;
		try {
			leoCertificate = LEOCertificateLocalServiceUtil
					.getLEOCertificate(certificateId);
			
		} catch (Exception e) {
			leoCertificate = LEOCertificateLocalServiceUtil
					.createLEOCertificate(certificateId);
		}

		leoCertificate.setXm(xm);
		leoCertificate.setZylx(zylx);
		leoCertificate.setFzrq(fzrq);
		leoCertificate.setYxq(yxq);
		LEOCertificateLocalServiceUtil.updateLEOCertificate(leoCertificate);
	}

	public void deleteLEOCertificate(ActionRequest request,
			ActionResponse response) throws PortalException, SystemException {
		String certificateId = ParamUtil.getString(request, "certificateId");
		LEOCertificate leoCertificate = LEOCertificateLocalServiceUtil.getLEOCertificate(certificateId);
		LEOCertificateLocalServiceUtil.deleteLEOCertificate(leoCertificate);
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String certificateId = ParamUtil.getString(resourceRequest, "certificateId");
		String result = "";
		try {
			LEOCertificateLocalServiceUtil.getLEOCertificate(certificateId);
		} catch (Exception e) {
			result = e.toString();
		}
		JSONArray userArray = JSONFactoryUtil.createJSONArray();
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		userArray.put(result);
		out.println(userArray.toString());
		out.flush();
		out.close();
		resourceResponse.setContentType("text/html");
		super.serveResource(resourceRequest, resourceResponse);
	}
}
