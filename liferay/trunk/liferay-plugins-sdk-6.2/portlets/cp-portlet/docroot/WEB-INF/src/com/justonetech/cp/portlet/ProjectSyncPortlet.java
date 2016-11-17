package com.justonetech.cp.portlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.justonetech.cp.util.ProjectSync;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class XmpCrawlerPortlet
 */
public class ProjectSyncPortlet extends MVCPortlet {
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		String bjbh = ParamUtil.getString(resourceRequest, "bjbh");
		boolean result = ProjectSync.projectSync(bjbh);
		PrintWriter out = resourceResponse.getWriter();
		out.println("{result:" + result + "}");
		out.flush();
		super.serveResource(resourceRequest, resourceResponse);
	}
}
