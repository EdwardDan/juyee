package com.justonetech.portal.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.justonetech.portal.feedback.model.Feedback;
import com.justonetech.portal.feedback.service.FeedbackLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
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
		String lx = ParamUtil.getString(request, "lx");

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
}
