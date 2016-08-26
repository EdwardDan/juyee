package com.justonetech.portlet.constructionproject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * Portlet implementation class ConstructionProjectPortlet
 */
public class ConstructionProjectPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil
			.getLog(ConstructionProjectPortlet.class);

	// private static String dateFormatPattern = PropsUtil
	// .get("default.date.format.pattern");

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String bjbh = ParamUtil.getString(resourceRequest, "bjbh");
		String wssqbh = ParamUtil.getString(resourceRequest, "wssqbh");
		String xmmc = ParamUtil.getString(resourceRequest, "xmmc");
		String ksbjrq = ParamUtil.getString(resourceRequest, "ksbjrq");
		String jsbjrq = ParamUtil.getString(resourceRequest, "jsbjrq");
		String bjwcbj = ParamUtil.getString(resourceRequest, "bjwcbj");
		System.out.println("bjbh=" + bjbh + ":wssqbh=" + wssqbh + ":xmmc="
				+ xmmc + ":bjwcbj=" + bjwcbj + ":ksbjrq1=" + ksbjrq
				+ ":jsbjrq1=" + jsbjrq);

	}

}
