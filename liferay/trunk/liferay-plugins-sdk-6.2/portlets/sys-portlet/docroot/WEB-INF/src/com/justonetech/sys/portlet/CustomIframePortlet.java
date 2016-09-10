package com.justonetech.sys.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CustomIframePortlet
 */
public class CustomIframePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
	
		PortletPreferences preferences = renderRequest.getPreferences();
		String loginPage = preferences.getValue("src", StringPool.BLANK);
		renderRequest.setAttribute("src", loginPage);
		super.doView(renderRequest, renderResponse);
	}
}
