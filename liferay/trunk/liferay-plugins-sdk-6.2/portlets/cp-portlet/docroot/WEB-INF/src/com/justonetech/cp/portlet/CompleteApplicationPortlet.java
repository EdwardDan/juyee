
package com.justonetech.cp.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.justonetech.cp.complete.model.Complete;
import com.justonetech.cp.complete.model.CompleteApplyMaterial;
import com.justonetech.cp.complete.model.CompleteProjectProfile;
import com.justonetech.cp.complete.model.CompleteUnitProject;
import com.justonetech.cp.complete.service.CompleteApplyMaterialLocalServiceUtil;
import com.justonetech.cp.complete.service.CompleteLocalServiceUtil;
import com.justonetech.cp.complete.service.CompleteProjectProfileLocalServiceUtil;
import com.justonetech.cp.complete.service.CompleteUnitProjectLocalServiceUtil;
import com.justonetech.cp.notification.CompleteApplicationNotificationHandler;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.UnitProject;
import com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil;
import com.justonetech.cp.project.model.Project;
import com.justonetech.cp.project.service.ProjectLocalServiceUtil;
import com.justonetech.cp.util.CompleteStatus;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletConfigFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.portletconfiguration.util.PortletConfigurationUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class CompleteApplicationPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(CompleteApplicationPortlet.class);
	private static String dateFormatPattern = PropsUtil.get("default.date.format.pattern");

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		 String path = ParamUtil.getString(renderRequest, "path");
			if (path.contains("uploadFile")) {
				path=path.replace("uploadFile", "");
				if(Validator.isNotNull(path)){
					String[] pathParam=path.split("\\/");
					String divNo=pathParam[0];
					String materialId=pathParam[1];
					String no=pathParam[2];
					renderRequest.setAttribute("divNo",divNo); 
					renderRequest.setAttribute("materialId", materialId);
					renderRequest.setAttribute("no", no);
				}else{
					renderRequest.setAttribute("divNo",ParamUtil.getString(renderRequest, "divNo"));
					renderRequest.setAttribute("materialId",ParamUtil.getString(renderRequest, "materialId"));
					renderRequest.setAttribute("no",ParamUtil.getString(renderRequest, "no"));
					renderRequest.setAttribute("upLoadMessage",ParamUtil.getString(renderRequest, "upLoadMessage"));
				}
				include("/portlet/complete-application/uploadFile.jsp", renderRequest, renderResponse);
			}
			else {
		User user = null;
		try {
			user = PortalUtil.getUser(renderRequest);
		}
		catch (PortalException | SystemException e) {
			log.info(e.getMessage());
		}
		String zzjgdm = "";
		try {
			long[] roles = user.getRoleIds();
			for (long role : roles) {
				if (role == Long.parseLong(PropsUtil.get("jsdw"))) {
					zzjgdm = Validator.isNull(user) ? "" : user.getScreenName();
				}
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		int status = ParamUtil.getInteger(renderRequest, "state");
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;
		List<Complete> completes = Collections.emptyList();
		int completesCount = 0;
		String gs = "";// 根据角色来判断是市属还是区属
		completes = CompleteLocalServiceUtil.getCompletes(zzjgdm, bjbh, wssqbh, gcmc, status, gs, start, end);
		completesCount = CompleteLocalServiceUtil.getCompletesCount(zzjgdm, bjbh, wssqbh, gcmc, status, gs);
		renderRequest.setAttribute("zzjgdm", zzjgdm);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("wssqbh", wssqbh);
		renderRequest.setAttribute("gcmc", gcmc);
		renderRequest.setAttribute("status", status);
		renderRequest.setAttribute("completes", completes);
		renderRequest.setAttribute("completesCount", completesCount);
		super.doView(renderRequest, renderResponse);
			}
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException, IOException {
		try{
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (Validator.equals(mvcPath, "/portlet/complete-application/select-project.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
			String xmmc = ParamUtil.getString(renderRequest, "xmmc");
			Date bjrqStart =
				ParamUtil.getDate(renderRequest, "bjrqStart", new SimpleDateFormat(dateFormatPattern), null);
			Date bjrqEnd = ParamUtil.getDate(renderRequest, "bjrqEnd", new SimpleDateFormat(dateFormatPattern), null);
			String bjwcbj = ParamUtil.getString(renderRequest, "bjwcbj");
			User user = null;
			try {
				user = PortalUtil.getUser(renderRequest);
			}
			catch (PortalException | SystemException e) {
				log.info(e.getMessage());
			}
			String zzjgdm = "";
			try {
				long[] roles = user.getRoleIds();
				for (long role : roles) {
					if (role == Long.parseLong(PropsUtil.get("jsdw"))) {
						zzjgdm = Validator.isNull(user) ? "" : user.getScreenName();
					}
				}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String bjrqStartStr = null;
			String bjrqEndStr = null;
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);
			if (bjrqStart != null) {
				bjrqStartStr = sdf.format(bjrqStart);
			}
			if (bjrqStartStr == null) {
				bjrqStartStr = ParamUtil.getString(renderRequest, "bjrqStartStr", "");
			}
			if (bjrqEnd != null) {
				bjrqEndStr = sdf.format(bjrqEnd);
			}
			if (bjrqEndStr == null) {
				bjrqEndStr = ParamUtil.getString(renderRequest, "bjrqEndStr", "");
			}
			renderRequest.setAttribute("bjrqStartStr", bjrqStartStr);
			renderRequest.setAttribute("bjrqEndStr", bjrqEndStr);

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
			List<Project> projects =
				ProjectLocalServiceUtil.getProjects(zzjgdm, bjbh, wssqbh, xmmc, bjrqStart, bjrqEnd, bjwcbj, start, end);
			projectsCount =
				ProjectLocalServiceUtil.getProjectsCount(zzjgdm, bjbh, wssqbh, xmmc, bjrqStart, bjrqEnd, bjwcbj);
			renderRequest.setAttribute("projects", projects);
			renderRequest.setAttribute("projectsCount", projectsCount);
		}
		else if (Validator.equals(mvcPath, "/portlet/complete-application/edit-complete.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			renderRequest.setAttribute("bjbh", bjbh);
		}
		else if (Validator.equals(mvcPath, "/portlet/complete-application/select-permit-unitProject.jsp")) {

			List<UnitProject> unitProjects = new ArrayList<UnitProject>();
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			String completeId = renderRequest.getParameter("completeId");
			String permitUnitProjectIds = renderRequest.getParameter("permitUnitProjectIds");
			int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
			int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			if (Validator.isNotNull(bjbh)) {

				String[] permitUnitProjectIdArr = null;
				Long[] longPermitUnitProjectIds = null;
				if (permitUnitProjectIds != null && permitUnitProjectIds.length() > 0) {
					permitUnitProjectIdArr = permitUnitProjectIds.split(",");
					longPermitUnitProjectIds = new Long[permitUnitProjectIdArr.length];
					if (null != permitUnitProjectIdArr && permitUnitProjectIdArr.length > 0) {
						for (int i = 0; i < longPermitUnitProjectIds.length; i++) {
							longPermitUnitProjectIds[i] = Long.valueOf(permitUnitProjectIdArr[i]);
						}
					}
				}

				unitProjects =
					UnitProjectLocalServiceUtil.findByBjbhAndPermitUnitProjectIds(
						bjbh, longPermitUnitProjectIds, start, end);
			}
			renderRequest.setAttribute("permitUnitProjectIds", permitUnitProjectIds);
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("completeId", Long.valueOf(completeId));
			renderRequest.setAttribute("unitProjects", unitProjects);
			renderRequest.setAttribute("unitProjectCount", unitProjects.size());
		}

		super.render(renderRequest, renderResponse);
		}catch(Exception e){
			e.printStackTrace();
			SessionErrors.add(renderRequest, e.getClass());
		}
	}

	public void saveProjectProfile(ActionRequest request, ActionResponse response)
		throws SystemException, PortalException, IOException {

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
		}
		catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		String wssqbh = project.getBj_webid();
		long xmlx = ParamUtil.getLong(request, "xmlx");
		long jsgcsx = ParamUtil.getLong(request, "jsgcsx");
		String gcmc = ParamUtil.getString(request, "gcmc");
		String jsdwmc = ParamUtil.getString(request, "jsdwmc");
		String jsdwdz = ParamUtil.getString(request, "jsdwdz");
		String jsdd = ParamUtil.getString(request, "jsdd");
		String szqx = ParamUtil.getString(request, "szqx");
		String fddbr = ParamUtil.getString(request, "fddbr");
		String lxr = ParamUtil.getString(request, "lxr");
		String lxdh = ParamUtil.getString(request, "lxdh");
		String bz = ParamUtil.getString(request, "bz");
		String lxjb = ParamUtil.getString(request, "lxjb");
		String zzjgdm = "";
		User user = null;
		try {
			user = PortalUtil.getUser(request);
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user != null) {
			zzjgdm = user.getScreenName();
		}
		Complete complete = null;
		CompleteProjectProfile completeProjectProfile = null;
		if (Validator.isNull(completeId)) {
			complete = CompleteLocalServiceUtil.createComplete(CounterLocalServiceUtil.increment());
			completeProjectProfile =
				CompleteProjectProfileLocalServiceUtil.createCompleteProjectProfile(complete.getCompleteId());
		}
		else {
			complete = CompleteLocalServiceUtil.getComplete(completeId);
			completeProjectProfile = CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId);
		}
		complete.setZzjgdm(zzjgdm);
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
		complete.setStatus(CompleteStatus.STATUS_EDIT.getCode());
		completeProjectProfile.setBjbh(bjbh);
		completeProjectProfile.setLxjb(lxjb);
		completeProjectProfile.setXmlx(xmlx);
		completeProjectProfile.setJsgcsx(jsgcsx);
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
   
	public void saveUnitProjects(ActionRequest request, ActionResponse response)
		throws SystemException, PortalException, IOException {

		long completeId = ParamUtil.getLong(request, "completeId", 0);
		// 删除原有数据
		if (completeId != 0) {
			List<CompleteUnitProject> completeUnitProjects =
				CompleteUnitProjectLocalServiceUtil.findByCompleteId(completeId, -1, -1);
			for (CompleteUnitProject completeUnitProject : completeUnitProjects) {
				CompleteUnitProjectLocalServiceUtil.deleteCompleteUnitProject(completeUnitProject);
			}
			//
			String[] permitUnitProjectIds = ParamUtil.getParameterValues(request, "permitUnitProjectId");
			String bjbh = ParamUtil.getString(request, "bjbh");
			String[] sgxkzbh = ParamUtil.getParameterValues(request, "sgxkzbh");
			String[] gcbhs = ParamUtil.getParameterValues(request, "gcbh");
			String[] gcmcs = ParamUtil.getParameterValues(request, "gcmc");
			String[] jsnrs = ParamUtil.getParameterValues(request, "jsnr");
			for (int i = 0; i < gcbhs.length - 1; i++) {
				CompleteUnitProject unitProject =
					CompleteUnitProjectLocalServiceUtil.createCompleteUnitProject(CounterLocalServiceUtil.increment());
				unitProject.setBjbh(bjbh);
				unitProject.setCompleteId(completeId);
				unitProject.setSgxkzbh(sgxkzbh[i]);
				unitProject.setGcbh(gcbhs[i]);
				unitProject.setGcmc(gcmcs[i]);
				unitProject.setJsnr(jsnrs[i]);
				unitProject.setJsnr(jsnrs[i]);
				unitProject.setPermitUnitProjectId(Long.valueOf(permitUnitProjectIds[i]));
				CompleteUnitProjectLocalServiceUtil.addCompleteUnitProject(unitProject);
			}

			Complete complete = CompleteLocalServiceUtil.getComplete(completeId);

			if (complete.getSqbz() == 1) {
				complete.setSqbz(2);
			}
			CompleteLocalServiceUtil.updateComplete(complete);

			redirect(request, response, complete, 2);
		}
	}

	public void deleteComplete(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long completeId = ParamUtil.getLong(request, "completeId");
		CompleteLocalServiceUtil.deleteComplete(completeId);
		CompleteProjectProfileLocalServiceUtil.deleteCompleteProjectProfile(CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId));
	}

	public void redirect(ActionRequest request, ActionResponse response, Complete complete, int sqbz)
		throws IOException {

		String redirect = ParamUtil.getString(request, "redirectURL");
		int tabSqbz = 1;
		if (complete.getSqbz() == sqbz && sqbz < 4) {
			tabSqbz = sqbz + 1;
		}
		else if (complete.getSqbz() == sqbz && sqbz == 4) {
			tabSqbz = sqbz;
		}
		else if (complete.getSqbz() > sqbz) {
			tabSqbz = sqbz;
		}
		redirect += "&" + response.getNamespace() + "completeId=" + complete.getCompleteId();
		redirect += "&" + response.getNamespace() + "bjbh=" + complete.getBjbh();
		redirect += "&" + response.getNamespace() + "tabSqbz=" + tabSqbz;
		response.sendRedirect(redirect);
	}

	public void saveCompleteApplyMaterials(ActionRequest request, ActionResponse response)
		throws SystemException, PortalException, ParseException, IOException {

		long completeId = ParamUtil.getLong(request, "completeId");
		Complete complete = CompleteLocalServiceUtil.getComplete(completeId);
		if (complete.getSqbz() == 1) {
			complete.setSqbz(2);
		}
		complete.setStatus(CompleteStatus.STATUS_EDIT.getCode());
		CompleteLocalServiceUtil.updateComplete(complete);
		redirect(request, response, complete, 2);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		try {
			String resourceId = resourceRequest.getResourceID();
			String fileSourceName = "";
			// 删除文件
			if ("fileDelete".equals(resourceId)) {
				String fileId = ParamUtil.get(resourceRequest, "fileId", "0");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				if (!fileId.equals("0")) {
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileId));
					if (!materialId.equals("0")) {
						CompleteApplyMaterial completeApplyMaterial =
							CompleteApplyMaterialLocalServiceUtil.getCompleteApplyMaterial(Long.valueOf(materialId));
						String fileEntryIds = completeApplyMaterial.getFileEntryIds();
						fileEntryIds = fileEntryIds + ",";// 加上逗号为了容易替换
						// 获取文件路径
						String str = fileId + "\\|" + dlFileEntry.getExtension() + "\\,";
						fileEntryIds = fileEntryIds.replaceFirst(str, "");
						if (Validator.isNotNull(fileEntryIds)) {
							fileEntryIds = fileEntryIds.substring(0, fileEntryIds.length() - 1);// 最后一步再把逗号去掉
						}
						completeApplyMaterial.setFileEntryIds(fileEntryIds);
						CompleteApplyMaterialLocalServiceUtil.updateCompleteApplyMaterial(completeApplyMaterial);
					}
					DLFileEntryLocalServiceUtil.deleteFileEntry(Long.valueOf(fileId));
				}
			}
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
	public FileEntry uploadFile(
		ActionRequest request, String fileSourceName, byte[] fileBytes, ServiceContext serviceContext,
		String portletId, String materialId, String fileTitle)
		throws PortalException, SystemException, IOException {

		serviceContext.setAddGuestPermissions(true);
		serviceContext.setIndexingEnabled(true);
		User user = PortalUtil.getUser(request);
		long userId = user.getUserId();
		Long groupId = user.getGroupId();
		Long rootFolderId = DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT;
		FileEntry fileEntry = null;
		// 为每一种材料名称创建一个文件夹,如果已有就不再创建
		DLFolder dlParentFolder = null;
		DLFolder dlChildFolder = null;
		if (Validator.isNotNull(portletId) && Validator.isNotNull(materialId)) {
			dlParentFolder = DLFolderLocalServiceUtil.fetchFolder(groupId, rootFolderId, portletId);

			if (Validator.isNotNull(dlParentFolder)) {
				dlChildFolder = DLFolderLocalServiceUtil.fetchFolder(groupId, dlParentFolder.getFolderId(), materialId);
				if (Validator.isNull(dlChildFolder)) {
					dlChildFolder =
						DLFolderLocalServiceUtil.addFolder(
							userId, groupId, groupId, false, dlParentFolder.getFolderId(), materialId, "", false,
							serviceContext);
				}
			}
			else {
				dlParentFolder =
					DLFolderLocalServiceUtil.addFolder(
						userId, groupId, groupId, true, rootFolderId, portletId, "", true, serviceContext);
				dlChildFolder =
					DLFolderLocalServiceUtil.addFolder(
						userId, groupId, groupId, false, dlParentFolder.getFolderId(), materialId, "", false,
						serviceContext);
			}
		}

		if (fileBytes != null) {
			fileEntry =
				DLAppLocalServiceUtil.addFileEntry(
					userId, groupId, dlChildFolder.getFolderId(), fileSourceName,
					MimeTypesUtil.getContentType(fileSourceName), fileTitle, null, null, fileBytes, serviceContext);
		}
		return fileEntry;
	}

	public void submitAll(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long completeId = ParamUtil.getLong(request, "completeId");
		String babh = "JT";
		Complete complete = CompleteLocalServiceUtil.getComplete(completeId);

		CompleteProjectProfile completeProjectProfile =
			CompleteProjectProfileLocalServiceUtil.getCompleteProjectProfile(completeId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(completeProjectProfile.getXmlx());
		babh = babh + xmlx.getCode();
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4) + currentDate.substring(5, 7);
		babh = babh + currentDateStr;
		List<Complete> completes = CompleteLocalServiceUtil.getCompletes(-1, -1);
		List<Long> nums = new ArrayList<Long>();
		if (null != completes && completes.size() > 0) {
			for (Complete complete_ : completes) {
				if (null != complete.getBabh() && complete.getBabh().length() > 0) {
					if (Validator.isNotNull(complete_.getBabh()) &&
						complete_.getBabh().substring(4, 8).equals(currentDateStr)) {
						nums.add(Long.parseLong(complete_.getBabh().substring(8, 12)));
					}
				}

			}
		}

		Long num = 0L;
		if (nums.size() > 0) {
			for (Long num_ : nums) {
				if (num_ > num) {
					num = num_;
				}
			}
		}

		num++;

		if (num / 10 < 1) {
			babh = babh + "000" + num;
		}
		else if (num / 100 < 1) {
			babh = babh + "00" + num;
		}
		else if (num / 1000 < 1) {
			babh = babh + "0" + num;
		}
		else if (num / 10000 < 1) {
			babh = babh + num;
		}

		complete.setBabh(babh);
		complete.setGroupId(themeDisplay.getScopeGroupId());
		complete.setCompanyId(themeDisplay.getCompanyId());
		// 保存状态
		complete.setSqbz(0);
		complete.setStatus(CompleteStatus.STATUS_SB.getCode());
		CompleteLocalServiceUtil.updateComplete(complete);

		try {
			User user = PortalUtil.getUser(request);
			Role aRole = null;
			Set<Long> userIdsList = new HashSet<Long>();
			List<User> users = new ArrayList<User>();
			long[] userIds = null;
			if (completeProjectProfile.getLxjb().equals("区县级机关或区县级单位")) {
				aRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), "区竣工备案审核");
				userIds = UserLocalServiceUtil.getRoleUserIds(aRole.getRoleId());
				for (long useId : userIds) {
					userIdsList.add(useId);
				}
				aRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), "市竣工备案审核");
				userIds = UserLocalServiceUtil.getRoleUserIds(aRole.getRoleId());
				for (long useId : userIds) {
					userIdsList.add(useId);
				}
				for (long userId : userIdsList) {
					users.add(UserLocalServiceUtil.getUser(userId));
				}
			}
			else {
				aRole = RoleLocalServiceUtil.fetchRole(user.getCompanyId(), "市竣工备案审核");
				userIds = UserLocalServiceUtil.getRoleUserIds(aRole.getRoleId());
				for (long useId : userIds) {
					users.add(UserLocalServiceUtil.getUser(useId));
				}
			}
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
			for (User a : users) {
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					a.getUserId(), CompleteApplicationNotificationHandler.PORTLET_ID, (new Date()).getTime(),
					user.getUserId(), payloadJSON.toString(), false, serviceContext);
			}
		}
		catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addDLFileEntry(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String sourceFileName = uploadPortletRequest.getFileName("file");
			File file = uploadPortletRequest.getFile("file");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			String[] groupPermissions = { "VIEW" };
			serviceContext.setGroupPermissions(groupPermissions);
			String materialId=ParamUtil.getString(actionRequest, "materialId");
			actionResponse.setRenderParameter("materialId", materialId);
			String no=ParamUtil.getString(actionRequest, "no");
			byte[] fileBytes = null;
			long fileSize=0l;
			FileEntry fileEntry=null;
			if (null != file) {
				fileBytes = FileUtil.getBytes(file);
				fileSize=fileBytes.length/1024/1024;
			}
			String fileTitle = "";
			String fileExtension=sourceFileName.substring(sourceFileName.lastIndexOf(".")+1).toUpperCase().trim();
			
			String upLoadMessage="上传成功！";
			Boolean upLoadStatus=true;
			if(!fileExtension.equals("JPG")&&!fileExtension.equals("PDF")){
				upLoadMessage="文件上传仅限于jpg或者pdf格式！";
				upLoadStatus=false;
				SessionErrors.add(actionRequest, "error-key"); 
	        }else if(fileExtension.equals("JPG")){
	        	if(fileSize>2){	
	        		upLoadMessage="上传的jpg文件超过2M,请压缩后上传！";
	        		upLoadStatus=false;
	        		SessionErrors.add(actionRequest, "error-key"); 
	        	}
	        }else if(fileExtension.equals("PDF")){
	        	if(fileSize>20){	
	        		upLoadMessage="上传的pdf文件超过20M,请压缩或拆分后上传！";
	        		upLoadStatus=false;
	        		SessionErrors.add(actionRequest, "error-key"); 
	        	}
	        }

			if (!materialId.equals("0")&upLoadStatus) {
				CompleteApplyMaterial completeApplyMaterial = CompleteApplyMaterialLocalServiceUtil.getCompleteApplyMaterial(Long
						.valueOf(materialId));
				 fileTitle = completeApplyMaterial.getClmc() + "-" + no + "." + fileExtension.toLowerCase();
				 fileEntry=uploadFile(actionRequest, sourceFileName, fileBytes, serviceContext, "completeapplication_WAR_cpportlet", materialId, fileTitle);	
				 String fileEntryIds = completeApplyMaterial.getFileEntryIds();
						// 添加第一条数据时
						if (Validator.isNull(fileEntryIds)) {
							fileEntryIds = fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();
						}
						// 如果已有数据
						else {
							fileEntryIds = fileEntryIds + "," + fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();						
						}
						completeApplyMaterial.setFileEntryIds(fileEntryIds);
						CompleteApplyMaterialLocalServiceUtil.updateCompleteApplyMaterial(completeApplyMaterial);
						 no=(Integer.valueOf(no)+1)+"";	
				 actionResponse.setRenderParameter("materialName", completeApplyMaterial.getClmc());
				 actionResponse.setRenderParameter("fieId", Long.toString(fileEntry.getFileEntryId()));
				 actionResponse.setRenderParameter("name", sourceFileName);
				actionResponse.setRenderParameter("divNo", ParamUtil.getString(actionRequest, "divNo"));
				actionResponse.setRenderParameter("fileExtension", fileExtension.toLowerCase());
					//删除掉默认的成功信息
					//SessionMessages.add(actionRequest, "completeapplication_WAR_cpportlet" + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
					//覆盖掉默认的成功信息
				SessionMessages.add(actionRequest, "request_processed",completeApplyMaterial.getClmc()+"上传成功！"); 	
			}
			actionResponse.setRenderParameter("no", no);
			//SessionErrors.add(actionRequest, "error-key","this is the error message");
			SessionMessages.add(actionRequest, "completeapplication_WAR_cpportlet" + SessionMessages. KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			actionResponse.setRenderParameter("path", "uploadFile");
			actionResponse.setRenderParameter("upLoadMessage", upLoadMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException,
	PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
		} else {
	portletRequestDispatcher.include(renderRequest, renderResponse);
		}
}
	
}