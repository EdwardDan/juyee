package com.justonetech.portal.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.justonetech.portal.feedback.model.Feedback;
import com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FeedbackPortlet
 */
public class FeedbackPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(FeedbackPortlet.class);

	public void saveFeedBack(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {
		String zt = ParamUtil.getString(request, "zt");
		String fknr = ParamUtil.getString(request, "fknr");
		PortletPreferences preferences = request.getPreferences();
		String lxId = preferences.getValue("lxId", StringPool.BLANK);
		Feedback feedback = FeedbackLocalServiceUtil.createFeedback(CounterLocalServiceUtil.increment());
		feedback.setZt(zt);
		feedback.setFknr(fknr);
		feedback.setLxId(Validator.isBlank(lxId)?0:GetterUtil.getLong(lxId));
		feedback.setFkrq(new Date());
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		feedback.setFkrId(themeDisplay.getRealUser().getUserId());
		feedback.setFkrq(new Date());
		feedback.setGroupId(themeDisplay.getCompanyGroupId());
		feedback.setCompanyId(themeDisplay.getCompanyId());
		FeedbackLocalServiceUtil.addFeedback(feedback);
	}

	public void saveReplyFeedback(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long feedbackId = ParamUtil.getLong(request, "feedbackId");
		String hfjg = ParamUtil.getString(request, "hfjg");
		long userId = PortalUtil.getUserId(request);
		Date now = new Date();
		Feedback feedback = FeedbackLocalServiceUtil.getFeedback(feedbackId);
		feedback.setHfjg(hfjg);
		feedback.setHfrq(now);
		feedback.setHfrId(userId);
		FeedbackLocalServiceUtil.updateFeedback(feedback);
	}
	
	public static final String CAPTCHA_TEXT = "CAPTCHA_TEXT";

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String resourceId = resourceRequest.getResourceID();

		if (resourceId.equals("ajaxCaptcha")) {
			String value = resourceRequest.getParameter("captchaText");
			log.debug("captchaText:" + value);
			if (value == null) {
				try {
					CaptchaUtil.serveImage(resourceRequest, resourceResponse);
				} catch (Exception e) {
					// _log.error(e);
				}
			} else // do verify
			{
				if (!Validator.isBlank(value)) {
					resourceResponse.setContentType(ContentTypes.TEXT);
					String answer = (String) resourceRequest.getPortletSession().getAttribute(CAPTCHA_TEXT);
					log.debug("answer:" + answer);
					String ret = String.valueOf(value.equalsIgnoreCase(answer));

					// CaptchaUtil.check(resourceRequest);
					resourceResponse.getPortletOutputStream().write(ret.getBytes());
					log.debug("captcha verify:" + ret);
				}
			}
		}

		if (resourceId.equals("captchaID")) {
			try {
				com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			} catch (Exception e) {
				log.error(e);
			}
		}
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
		}
		if ("createUser".equals(resourceId)) {
			String yhm = ParamUtil.getString(resourceRequest, "yhm");
			String mm = ParamUtil.getString(resourceRequest, "mm");
			String qrmm = ParamUtil.getString(resourceRequest, "qrmm");
			String xm = ParamUtil.getString(resourceRequest, "xm");
			String sfzh = ParamUtil.getString(resourceRequest, "sfzh");
			String lxdh = ParamUtil.getString(resourceRequest, "lxdh");
			String yxdz = ParamUtil.getString(resourceRequest, "yxdz");
			String lxdz = ParamUtil.getString(resourceRequest, "lxdz");
			String exception = "";
			try {
				createUser(yhm, mm, qrmm, xm, yxdz, sfzh, lxdh, lxdz, resourceRequest);
			} catch (Exception e) {
				exception = e.toString();
			}
			JSONArray userArray = JSONFactoryUtil.createJSONArray();
			HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			userArray.put(exception);
			out.println(userArray.toString());
			out.flush();
			out.close();
			resourceResponse.setContentType("text/html");

		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	public void createUser(String yhm, String mm, String qrmm, String xm, String yxdz, String sfzh, String lxdh, String lxdz,
			ResourceRequest resourceRequest) throws PortalException, SystemException {

		// 获取参数
		long companyId = PortalUtil.getCompanyId(resourceRequest);
		boolean autoPassword = false;
		String password1 = mm;
		String password2 = qrmm;
		boolean autoScreenName = false;
		String screenName = yhm;
		String emailAddress = yxdz;// 必填
		long facebookId = 0;
		String openId = "";
		Locale locale = PortalUtil.getLocale(resourceRequest);
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

		User defaultUser = UserLocalServiceUtil.getDefaultUser(companyId);
		long creatorUserId = defaultUser.getUserId();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
		User user = UserLocalServiceUtil.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName,
				screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		ExpandoTable eTable = ExpandoTableLocalServiceUtil.getDefaultTable(PortalUtil.getDefaultCompanyId(), User.class.getName());
		ExpandoColumn eColumnSfzh = ExpandoColumnLocalServiceUtil.getColumn(eTable.getTableId(), "sfzh");
		ExpandoValueLocalServiceUtil.addValue(eTable.getClassNameId(), eTable.getTableId(), eColumnSfzh.getColumnId(), user.getUserId(), sfzh);
		ExpandoColumn eColumnLxdh = ExpandoColumnLocalServiceUtil.getColumn(eTable.getTableId(), "lxdh");
		ExpandoValueLocalServiceUtil.addValue(eTable.getClassNameId(), eTable.getTableId(), eColumnLxdh.getColumnId(), user.getUserId(), lxdh);
		ExpandoColumn eColumnLxdz = ExpandoColumnLocalServiceUtil.getColumn(eTable.getTableId(), "lxdz");
		ExpandoValueLocalServiceUtil.addValue(eTable.getClassNameId(), eTable.getTableId(), eColumnLxdz.getColumnId(), user.getUserId(), lxdz);

	}
}
