package com.justonetech.portal.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class CustomLoginConfigurationAction extends DefaultConfigurationAction {
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		String portletId = renderRequest.getParameter("portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletId);
		String loginPage = preferences.getValue("loginPage", StringPool.BLANK);
		renderRequest.setAttribute("loginPage", loginPage);
		String loggedInPage = preferences.getValue("loggedInPage", StringPool.BLANK);
		renderRequest.setAttribute("loggedInPage", loggedInPage);
		String redirectPage = preferences.getValue("redirectPage", StringPool.BLANK);
		renderRequest.setAttribute("redirectPage", redirectPage);
		return "/portlet/custom-login/config.jsp";
	}
	
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String portletResource = ParamUtil.getString(actionRequest,
				"portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletResource);
		if (Validator.isNotNull(preferences)) {
			String loginPage = ParamUtil.getString(actionRequest, "loginPage");
			preferences.setValue("loginPage", loginPage);
			String loggedInPage = ParamUtil.getString(actionRequest, "loggedInPage");
			preferences.setValue("loggedInPage", loggedInPage);
			String redirectPage = ParamUtil.getString(actionRequest, "redirectPage");
			preferences.setValue("redirectPage", redirectPage);
			preferences.store();
			SessionMessages.add(actionRequest, "success");
		}
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
