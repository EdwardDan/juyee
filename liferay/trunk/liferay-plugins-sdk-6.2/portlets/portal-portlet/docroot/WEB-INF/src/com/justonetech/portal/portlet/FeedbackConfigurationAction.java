package com.justonetech.portal.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

public class FeedbackConfigurationAction extends DefaultConfigurationAction {
	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		String portletId = ParamUtil.getString(renderRequest,
						"portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(renderRequest, portletId);
		String displayPage = preferences.getValue("displayPage", StringPool.BLANK);
		renderRequest.setAttribute("displayPage", displayPage);
		String lxId = preferences.getValue("lxId", StringPool.BLANK);
		renderRequest.setAttribute("lxId", GetterUtil.getLong(lxId));
		return "/portlet/feedback/config.jsp";
	}
	
	
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String portletId = ParamUtil.getString(actionRequest,
				"portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil
				.getPortletSetup(actionRequest, portletId);
		if (Validator.isNotNull(preferences)) {
			String displayPage = ParamUtil.getString(actionRequest, "displayPage");
			preferences.setValue("displayPage", displayPage);
			String lxId = ParamUtil.getString(actionRequest, "lxId");
			preferences.setValue("lxId", lxId);
			preferences.store();
			SessionMessages.add(actionRequest, "success");
		}
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
