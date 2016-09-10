package com.justonetech.sys.portlet;

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

public class CustomIframeConfigurationAction extends DefaultConfigurationAction {
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		String portletId = renderRequest.getParameter("portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletId);
		String src = preferences.getValue("src", StringPool.BLANK);
		renderRequest.setAttribute("src", src);
		String height = preferences.getValue("height", StringPool.BLANK);
		renderRequest.setAttribute("height", height);
		String isAddUserParam = preferences.getValue("isAddUserParam", "false");
		renderRequest.setAttribute("isAddUserParam", isAddUserParam);
		String isAddPwdParam = preferences.getValue("isAddPwdParam", "false");
		renderRequest.setAttribute("isAddPwdParam", isAddPwdParam);
		return "/portlet/custom-iframe/config.jsp";
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
			String src = ParamUtil.getString(actionRequest, "src");
			preferences.setValue("src", src);
			String height = ParamUtil.getString(actionRequest, "height");
			preferences.setValue("height", height);
			String isAddUserParam = ParamUtil.getString(actionRequest, "isAddUserParam");
			preferences.setValue("isAddUserParam", isAddUserParam);
			String isAddPwdParam = ParamUtil.getString(actionRequest, "isAddPwdParam");
			preferences.setValue("isAddPwdParam", isAddPwdParam);
			preferences.store();
			SessionMessages.add(actionRequest, "success");
		}
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
