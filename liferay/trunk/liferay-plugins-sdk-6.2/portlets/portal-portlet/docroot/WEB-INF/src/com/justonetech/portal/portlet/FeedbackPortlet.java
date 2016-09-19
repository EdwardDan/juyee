package com.justonetech.portal.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.justonetech.portal.feedback.model.Feedback;
import com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.Authenticator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FeedbackPortlet
 */
public class FeedbackPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(FeedbackPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		} catch (PortalException | SystemException e) {
			log.info(e.getMessage());
		}
		String zt = ParamUtil.getString(renderRequest, "zt", "");
		String lx = ParamUtil.getString(renderRequest, "lx", "");
		renderRequest.setAttribute("zt", zt);
		renderRequest.setAttribute("lx", lx);
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;
		List<Feedback> feedbacks = Collections.emptyList();
		int feedbacksCount = 0;
		try {
			feedbacks = FeedbackLocalServiceUtil.getFeedbacks(start, end);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		feedbacksCount = FeedbackLocalServiceUtil.getFeedbacksCount(zt, lx, 0);
		renderRequest.setAttribute("feedbacks", feedbacks);
		renderRequest.setAttribute("feedbacksCount", feedbacksCount);
		super.doView(renderRequest, renderResponse);
	}

	public void saveFeedBack(ActionRequest request, ActionResponse response) throws SystemException, PortalException,
			ParseException, IOException {
		String zt = ParamUtil.getString(request, "zt");
		String fknr = ParamUtil.getString(request, "fknr");
		PortletPreferences preferences = request.getPreferences();
		String lx = preferences.getValue("lx", StringPool.BLANK);
		System.out.println(lx);
		Feedback feedback = null;
		feedback = FeedbackLocalServiceUtil.createFeedback(CounterLocalServiceUtil.increment());
		feedback.setZt(zt);
		feedback.setFknr(fknr);
		feedback.setLx(lx);
		feedback.setFkrq(new Date());
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		feedback.setFkrId(themeDisplay.getRealUser().getUserId());
		feedback.setFkrq(new Date());
		FeedbackLocalServiceUtil.addFeedback(feedback);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
		} catch (Exception e) {
			log.error(e);
		}
		
		String resourceId = resourceRequest.getResourceID();
		if ("feedback".equals(resourceId)) {
			String loginUser = ParamUtil.get(resourceRequest, "_58_login", "");
			String loginPassword = ParamUtil.get(resourceRequest, "_58_password", "");
			Boolean loginState = false;
			String responseContent = "";
			try {
				List<User> userList = UserLocalServiceUtil.getUsers(-1, -1);
				
				if (Validator.isNotNull(loginUser) && !loginUser.equals("请输入用户名")) {
					User defaultUser = null;
					for (User user : userList) {
						if (loginUser.equals(user.getScreenName())) {
							defaultUser = user;
						}
					}
					if (Validator.isNotNull(defaultUser)) {
						long companyId = PortalUtil.getCompanyId(resourceRequest);
						int authResult = Authenticator.FAILURE;
						try {
							authResult = UserLocalServiceUtil.authenticateByScreenName(companyId, loginUser, loginPassword, null, null, null);
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
						responseContent = "用户名错误!";
					}

				} else {

					responseContent = "请输入用户名和密码!";
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

	private void checkCaptcha(PortletRequest request) throws Exception {
		String enteredCaptchaText = ParamUtil.getString(request, "captchaText");

		PortletSession session = request.getPortletSession();
		String captchaText = getCaptchaValueFromSession(session);
		if (Validator.isNull(captchaText)) {
			throw new Exception("Internal Error! Captcha text not found in session");
		}
		if (!captchaText.equals(enteredCaptchaText)) {
			throw new Exception("Invalid captcha text. Please reenter.");
		}
	}

	private String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
			String name = atNames.nextElement();
			if (name.contains("CAPTCHA_TEXT")) {
				return (String) session.getAttribute(name);
			}
		}
		return null;
	}
	

	
	public void register(ActionRequest request,ActionResponse response) throws PortalException, SystemException{
		String yhm = ParamUtil.getString(request, "yhm");
		String mm = ParamUtil.getString(request, "mm");
		String qrmm = ParamUtil.getString(request, "qrmm");
		String xm = ParamUtil.getString(request, "xm");
		String sfzh = ParamUtil.getString(request, "sfzh");
		String lxdh = ParamUtil.getString(request, "lxdh");
		String yxdz = ParamUtil.getString(request, "yxdz");
		String lxdz = ParamUtil.getString(request, "lxdz");
		createUser(yhm, mm, qrmm,xm,yxdz,request);
	}
	
	public void createUser(String yhm, String mm, String qrmm, String xm, String yxdz,ActionRequest request) throws PortalException, SystemException {
 
		// 获取参数
		long companyId = PortalUtil.getCompanyId(request);
		boolean autoPassword = false;
		String password1 = mm;
		String password2 = qrmm;
		boolean autoScreenName = false;
		String screenName = yhm;
		String emailAddress = yxdz;// 必填
		long facebookId = 0;
		String openId = "";
		Locale locale = PortalUtil.getLocale(request);
		String firstName = xm;
		String middleName = "";
		String lastName = "";
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true;
		int birthdayMonth = 0;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = "";
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;

		// 新增用户
		try {
			User defaultUser = UserLocalServiceUtil.getDefaultUser(companyId);
			long creatorUserId = defaultUser.getUserId();
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			User user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
