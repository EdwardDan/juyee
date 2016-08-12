package com.justonetech.portal.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CustomLoginPortlet
 */
public class CustomLoginPortlet extends MVCPortlet {
 
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String loginPage = preferences.getValue("loginPage", StringPool.BLANK);
		renderRequest.setAttribute("loginPage", loginPage);
		String loggedInPage = preferences.getValue("loggedInPage", StringPool.BLANK);
		renderRequest.setAttribute("loggedInPage", loggedInPage);
		String redirectPage = preferences.getValue("redirectPage", StringPool.BLANK);
		renderRequest.setAttribute("redirectPage", redirectPage);
		super.render(renderRequest, renderResponse);
	}


}
