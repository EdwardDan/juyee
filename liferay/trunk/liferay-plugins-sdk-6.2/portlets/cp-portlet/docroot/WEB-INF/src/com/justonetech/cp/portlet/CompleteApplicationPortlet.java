package com.justonetech.cp.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.justonetech.cp.complete.model.Complete;
import com.justonetech.cp.complete.model.CompleteProjectProfile;
import com.justonetech.cp.complete.service.CompleteLocalServiceUtil;
import com.justonetech.cp.complete.service.CompleteProjectProfileLocalServiceUtil;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;
import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CompleteApplicationPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(CompleteApplicationPortlet.class);
	private static String dateFormatPattern = PropsUtil.get("default.date.format.pattern");

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		} catch (PortalException | SystemException e) {
			log.info(e.getMessage());
		}
		String zzjgdm = Validator.isNull(user) ? "" : user.getScreenName();
		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		String zt = ParamUtil.getString(renderRequest, "zt");
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;
		List<Complete> completes = new ArrayList<Complete>();
		int completesCount = 0;
		completes = CompleteLocalServiceUtil.getCompletes("", bjbh, wssqbh, gcmc, start, end);
		completesCount = CompleteLocalServiceUtil.getCompletesCount("", bjbh, wssqbh, gcmc);
		renderRequest.setAttribute("zzjgdm", zzjgdm);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("wssqbh", wssqbh);
		renderRequest.setAttribute("gcmc", gcmc);
		renderRequest.setAttribute("zt", zt);
		renderRequest.setAttribute("delta", delta);
		renderRequest.setAttribute("cur", cur);
		renderRequest.setAttribute("completes", completes);
		renderRequest.setAttribute("completesCount", completesCount);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {

		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (Validator.equals(mvcPath, "/portlet/complete-application/select-project.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
			String xmmc = ParamUtil.getString(renderRequest, "xmmc");
			Date bjrqStart = ParamUtil.getDate(renderRequest, "bjrqStart", new SimpleDateFormat(dateFormatPattern),
					null);
			Date bjrqEnd = ParamUtil.getDate(renderRequest, "bjrqEnd", new SimpleDateFormat(dateFormatPattern), null);
			String bjwcbj = ParamUtil.getString(renderRequest, "bjwcbj");
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("wssqbh", wssqbh);
			renderRequest.setAttribute("xmmc", xmmc);
			renderRequest.setAttribute("bjrqStart", bjrqStart);
			renderRequest.setAttribute("bjrqEnd", bjrqEnd);
			renderRequest.setAttribute("bjwcbj", bjwcbj);
			int projectsCount = 0;
			int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
			int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			List<Project> projects = ProjectLocalServiceUtil.getProjects("", bjbh, wssqbh, xmmc, bjrqStart, bjrqEnd,
					bjwcbj, start, end);
			projectsCount = ProjectLocalServiceUtil
					.getProjectsCount("", bjbh, wssqbh, xmmc, bjrqStart, bjrqEnd, bjwcbj);
			renderRequest.setAttribute("projects", projects);
			renderRequest.setAttribute("projectsCount", projectsCount);
		} else if (Validator.equals(mvcPath, "/portlet/complete-application/edit-complete.jsp")) {
		}
		super.render(renderRequest, renderResponse);
	}

	public void saveProjectProfile(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, IOException {
		long completeId = ParamUtil.getLong(request, "completeId");
		long groupId = PortalUtil.getScopeGroupId(request);
		long companyId = PortalUtil.getCompanyId(request);
		long userId = PortalUtil.getUserId(request);
		String userName = PortalUtil.getUserName(userId, "");
		Date now = new Date();
		String bjbh = ParamUtil.getString(request, "bjbh");
		Project project = null;
		try {
			project = ProjectLocalServiceUtil.getProject(bjbh);
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		String wssqbh = project.getBj_webid();
		String gcmc = ParamUtil.getString(request, "gcmc");
		String jsdwmc = ParamUtil.getString(request, "jsdwmc");
		String jsdwdz = ParamUtil.getString(request, "jsdwdz");
		String jsdd = ParamUtil.getString(request, "jsdd");
		String szqx = ParamUtil.getString(request, "szqx");
		String fddbr = ParamUtil.getString(request, "fddbr");
		String lxr = ParamUtil.getString(request, "lxr");
		String lxdh = ParamUtil.getString(request, "lxdh");
		String bz = ParamUtil.getString(request, "bz");
		Complete complete = null;
		CompleteProjectProfile completeProjectProfile = null;
		if (Validator.isNull(completeId)) {
			complete = CompleteLocalServiceUtil.createComplete(CounterLocalServiceUtil.increment());
			completeProjectProfile = CompleteProjectProfileLocalServiceUtil.createCompleteProjectProfile(complete
					.getCompleteId());
		} else {
			complete = CompleteLocalServiceUtil.getComplete(completeId);
			completeProjectProfile = CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId);
		}
		complete.setGroupId(groupId);
		complete.setCompanyId(companyId);
		complete.setUserId(userId);
		complete.setUserName(userName);
		complete.setCreateDate(now);
		complete.setModifiedDate(now);
		complete.setBjbh(bjbh);
		// complete.setBabh(babh);
		complete.setSqbz(1);
		complete.setWssqbh(wssqbh);
		complete.setSbrq(now);
		completeProjectProfile.setBjbh(bjbh);
		completeProjectProfile.setGcmc(gcmc);
		completeProjectProfile.setJsdwmc(jsdwmc);
		completeProjectProfile.setJsdwdz(jsdwdz);
		completeProjectProfile.setJsdd(jsdd);
		completeProjectProfile.setSzqx(szqx);
		completeProjectProfile.setFddbr(fddbr);
		completeProjectProfile.setLxr(lxr);
		completeProjectProfile.setLxdh(lxdh);
		completeProjectProfile.setBz(bz);
		CompleteLocalServiceUtil.updateComplete(complete);
		CompleteProjectProfileLocalServiceUtil.updateCompleteProjectProfile(completeProjectProfile);
		redirect(request, response, complete, 1);
	}

	public void deleteComplete(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long completeId = ParamUtil.getLong(request, "completeId");
		CompleteLocalServiceUtil.deleteComplete(completeId);
		CompleteProjectProfileLocalServiceUtil.deleteCompleteProjectProfile(CompleteProjectProfileLocalServiceUtil
				.getCompleteProjectProfile(completeId));
	}
	
	public void redirect(ActionRequest request, ActionResponse response, Complete complete, int sqbz) throws IOException {

		String redirect = ParamUtil.getString(request, "redirectURL");
		int tabSqbz = 1;
		if (complete.getSqbz() == sqbz && sqbz < 4) {
			tabSqbz = sqbz + 1;
		} else if (complete.getSqbz() == sqbz && sqbz == 4) {
			tabSqbz = sqbz;
		} else if (complete.getSqbz() > sqbz) {
			tabSqbz = sqbz;
		}
		redirect += "&" + response.getNamespace() + "completeId=" + complete.getCompleteId();
		redirect += "&" + response.getNamespace() + "tabSqbz=" + tabSqbz;
		response.sendRedirect(redirect);
	}
}
