package com.justonetech.portal.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ManagementCenterLoginPortlet extends MVCPortlet{
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
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		String loginUser = ParamUtil.get(resourceRequest, "_58_login", "");
		String loginPassword = ParamUtil.get(resourceRequest, "_58_password","");
		Boolean loginState = false;
		String responseContent = "";

		try {
			List<User> userList = UserLocalServiceUtil.getUsers(-1, -1);

			if (Validator.isNotNull(loginUser) && !loginUser.equals("请输入用户名")) {
				User defaultUser = null;
				for (User user : userList) {
					if (loginUser.equals(user.getEmailAddress())) {
						defaultUser = user;
					}
				}
				if (Validator.isNotNull(defaultUser)) {
					long compangyId = PortalUtil.getCompanyId(resourceRequest);
					int authResult = Authenticator.FAILURE;
					try {
						authResult = UserLocalServiceUtil
								.authenticateByEmailAddress(compangyId,
										loginUser, loginPassword, null, null,
										null);
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (authResult == Authenticator.SUCCESS) {
						loginState = true;
					} else {
						responseContent = "密码错误！";
					}
				} else {
					responseContent = "用户名错误！";
				}

			} else {

				responseContent = "请输入用户名和密码！";
			}

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject userJson = JSONFactoryUtil.createJSONObject();
		userJson.put("loginState", loginState);
		userJson.put("responseContent", responseContent);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(userJson.toString());
		out.flush();
		out.close();
		resourceResponse.setContentType("text/html");
		super.serveResource(resourceRequest, resourceResponse);
	}
}
