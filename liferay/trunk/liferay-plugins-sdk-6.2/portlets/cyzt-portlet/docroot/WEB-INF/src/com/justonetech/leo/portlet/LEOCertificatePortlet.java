package com.justonetech.leo.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LEOCertificatePortlet
 */
public class LEOCertificatePortlet extends MVCPortlet {
	private static String dateFormatPattern = PropsUtil.get("default.date.format.pattern");

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String xm = ParamUtil.getString(renderRequest, "xm", "");
		String zylx = ParamUtil.getString(renderRequest, "zylx", "");
		String zjbh = ParamUtil.getString(renderRequest, "zjbh", "");
		Date yxq = null;
		try {
			yxq = ParamUtil.getDate(renderRequest, "yxq", new SimpleDateFormat(dateFormatPattern), null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String yxqStr = null;
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat(dateFormatPattern);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (yxq != null) {
			yxqStr = sdf.format(yxq);
		}
		if (yxqStr == null) {
			yxqStr = ParamUtil.getString(renderRequest, "yxqStr", "");
		}
		
		renderRequest.setAttribute("xm", xm);
		renderRequest.setAttribute("zylx", zylx);
		renderRequest.setAttribute("zjbh", zjbh);
		renderRequest.setAttribute("yxq", yxq);
		renderRequest.setAttribute("yxqStr", yxqStr);

		List<LEOCertificate> leoCertificates = new ArrayList<LEOCertificate>();
		int leoCertificatesCount = 0;
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;
		leoCertificates = LEOCertificateLocalServiceUtil.getLEOCertificates(xm, zylx, zjbh, yxq, start, end);
		leoCertificatesCount = LEOCertificateLocalServiceUtil.getLEOCertificatesCount(xm, zylx, zjbh, yxq);
		renderRequest.setAttribute("leoCertificates", leoCertificates);
		renderRequest.setAttribute("leoCertificatesCount", leoCertificatesCount);
		super.render(renderRequest, renderResponse);
	}

	public void saveLEOCertificate(ActionRequest request, ActionResponse response) throws SystemException {
		long certificateId = ParamUtil.getLong(request, "certificateId", 0L);
		String xm = ParamUtil.getString(request, "xm");
		String zylx = ParamUtil.getString(request, "zylx");
		String zjbh = ParamUtil.getString(request, "zjbh");
		Date fzrq = ParamUtil.getDate(request, "fzrq", new SimpleDateFormat(dateFormatPattern));
		Date yxq = ParamUtil.getDate(request, "yxq", new SimpleDateFormat(dateFormatPattern));
		LEOCertificate leoCertificate = null;
		try {
			if (certificateId == 0L) {
				leoCertificate = LEOCertificateLocalServiceUtil.createLEOCertificate(CounterLocalServiceUtil.increment());
			} else {
				leoCertificate = LEOCertificateLocalServiceUtil.getLEOCertificate(certificateId);
			}
		} catch (Exception e) {

		}
		leoCertificate.setZjbh(zjbh);
		leoCertificate.setXm(xm);
		leoCertificate.setZylx(zylx);
		leoCertificate.setFzrq(fzrq);
		leoCertificate.setYxq(yxq);
		LEOCertificateLocalServiceUtil.updateLEOCertificate(leoCertificate);
	}

	public void deleteLEOCertificate(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long certificateId = ParamUtil.getLong(request, "certificateId", 0L);
		LEOCertificate leoCertificate = LEOCertificateLocalServiceUtil.getLEOCertificate(certificateId);
		LEOCertificateLocalServiceUtil.deleteLEOCertificate(leoCertificate);
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String zjbh = ParamUtil.getString(resourceRequest, "zjbh", "");
		long certificateId = ParamUtil.getLong(resourceRequest, "certificateId", 0L);
		String result = "";

		List<LEOCertificate> leoCertificates = LEOCertificateLocalServiceUtil.getLEOCertificates("", "", zjbh, null, -1, -1);

		if (leoCertificates.size() == 0) {
			result = "Is not exist";// 不存在
		} else if (certificateId != 0L) {
			LEOCertificate leoCertificate = null;// 存在但等于当前的证件编号
			try {
				leoCertificate = LEOCertificateLocalServiceUtil.getLEOCertificate(certificateId);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (zjbh.equals(leoCertificate.getZjbh())) {
				result = "Is current zjbh";
			}
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
