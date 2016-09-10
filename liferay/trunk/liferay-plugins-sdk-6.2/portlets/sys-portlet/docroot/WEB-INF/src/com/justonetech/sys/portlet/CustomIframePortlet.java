
package com.justonetech.sys.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CustomIframePortlet
 */
public class CustomIframePortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletPreferences preferences = renderRequest.getPreferences();
		String src = preferences.getValue("src", StringPool.BLANK);
		String height = preferences.getValue("height", "600");
		boolean isAddUserParam = GetterUtil.getBoolean(preferences.getValue("isAddUserParam", "false"));
		boolean isAddPwdParam = GetterUtil.getBoolean(preferences.getValue("isAddPwdParam", "false"));
		if (isAddUserParam) {
			try {
				User user = PortalUtil.getUser(renderRequest);
				src += src.indexOf("?") > -1 ? "" : "?1=1";
				src += isAddUserParam ? "&loginName=" + user.getScreenName() : "";
				src += isAddPwdParam ? "&password=" + user.getPassword() : "";
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		renderRequest.setAttribute("src", src);
		renderRequest.setAttribute("height", height);
		super.doView(renderRequest, renderResponse);
	}
}
