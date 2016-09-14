package com.justonetech.cp.portlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.ParseException;
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
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
		int status = ParamUtil.getInteger(renderRequest, "state");
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;
		List<Complete> completes = Collections.emptyList();
		int completesCount = 0;
		completes = CompleteLocalServiceUtil.getCompletes("", bjbh, wssqbh, gcmc, status, start, end);
		completesCount = CompleteLocalServiceUtil.getCompletesCount("", bjbh, wssqbh, gcmc, status);
		renderRequest.setAttribute("zzjgdm", zzjgdm);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("wssqbh", wssqbh);
		renderRequest.setAttribute("gcmc", gcmc);
		renderRequest.setAttribute("status", status);
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
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			renderRequest.setAttribute("bjbh", bjbh);
		} else if (Validator.equals(mvcPath, "/portlet/complete-application/select-permit-unitProject.jsp")) {

			List<UnitProject> unitProjects = new ArrayList<UnitProject>();
			String bjbh = ParamUtil.getString(renderRequest, "bjbh");
			String completeId = renderRequest.getParameter("completeId");
			int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
			int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			if (Validator.isNotNull(bjbh)) {
				unitProjects = UnitProjectLocalServiceUtil.findByBjbh(bjbh, start, end);
			}
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("completeId", Long.valueOf(completeId));
			renderRequest.setAttribute("unitProjects", unitProjects);
			renderRequest.setAttribute("unitProjectCount", unitProjects.size());
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

	public void saveUnitProjects(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, IOException {
		long completeId = ParamUtil.getLong(request, "completeId", 0);
		// 删除原有数据
		if (completeId != 0) {
			List<CompleteUnitProject> completeUnitProjects = CompleteUnitProjectLocalServiceUtil.findByCompleteId(
					completeId, -1, -1);
			for (CompleteUnitProject completeUnitProject : completeUnitProjects) {
				CompleteUnitProjectLocalServiceUtil.deleteCompleteUnitProject(completeUnitProject);
			}
			//
			String bjbh = ParamUtil.getString(request, "bjbh");
			String[] sgxkzbh = ParamUtil.getParameterValues(request, "sgxkzbh");
			String[] gcbhs = ParamUtil.getParameterValues(request, "gcbh");
			String[] gcmcs = ParamUtil.getParameterValues(request, "gcmc");
			String[] jsnrs = ParamUtil.getParameterValues(request, "jsnr");
			for (int i = 0; i < gcbhs.length - 1; i++) {
				CompleteUnitProject unitProject = CompleteUnitProjectLocalServiceUtil
						.createCompleteUnitProject(CounterLocalServiceUtil.increment());
				unitProject.setBjbh(bjbh);
				unitProject.setCompleteId(completeId);
				unitProject.setSgxkzbh(sgxkzbh[i]);
				unitProject.setGcbh(gcbhs[i]);
				unitProject.setGcmc(gcmcs[i]);
				unitProject.setJsnr(jsnrs[i]);
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

	public void deleteComplete(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		long completeId = ParamUtil.getLong(request, "completeId");
		CompleteLocalServiceUtil.deleteComplete(completeId);
		CompleteProjectProfileLocalServiceUtil.deleteCompleteProjectProfile(CompleteProjectProfileLocalServiceUtil
				.getCompleteProjectProfile(completeId));
	}

	public void redirect(ActionRequest request, ActionResponse response, Complete complete, int sqbz)
			throws IOException {

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
		redirect += "&" + response.getNamespace() + "bjbh=" + complete.getBjbh();
		redirect += "&" + response.getNamespace() + "tabSqbz=" + tabSqbz;
		response.sendRedirect(redirect);
	}

	public void saveCompleteApplyMaterials(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException, IOException {
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
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub

		try {
			String resourceId = resourceRequest.getResourceID();
			String fileSourceName = "";
			// 上传文件
			if ("fileUpLoad".equals(resourceId)) {
				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

				ServiceContext serviceContext;
				com.liferay.portal.kernel.json.JSONObject fileJson = JSONFactoryUtil.createJSONObject();
				serviceContext = ServiceContextFactory.getInstance(Permit.class.getName(), resourceRequest);
				FileEntry fileEntry = null;
				// 对应的是第几类材料的div
				String divNo = ParamUtil.get(resourceRequest, "divNo", "");
				// 文件材料的名称编号
				String no = ParamUtil.get(resourceRequest, "no", "");
				String fileExtension = ParamUtil.get(resourceRequest, "fileExtension", "");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				String portletId = ParamUtil.get(resourceRequest, "portletId", "");
				fileSourceName = uploadPortletRequest.getFileName("userfile");
				InputStream stream = uploadPortletRequest.getFileAsStream("userfile");

				/*
				 * fileSourceName =
				 * uploadPortletRequest.getFileName("fileInput"+divNo);
				 * InputStream stream =
				 * uploadPortletRequest.getFileAsStream("fileInput"+divNo);
				 */
				byte[] fileBytes = null;
				if (null != stream) {
					fileBytes = FileUtil.getBytes(stream);
				}
				if (!materialId.equals("0")) {
					CompleteApplyMaterial completeApplyMaterial = CompleteApplyMaterialLocalServiceUtil
							.getCompleteApplyMaterial(Long.valueOf(materialId));
					String fileTitle = completeApplyMaterial.getClmc() + "-" + no + "." + fileExtension;

					fileEntry = uploadFile(resourceRequest, fileSourceName, fileBytes, serviceContext, portletId,
							materialId, fileTitle);

					String fileEntryIds = completeApplyMaterial.getFileEntryIds();
					// 添加第一条数据时
					if (Validator.isNull(fileEntryIds)) {
						fileEntryIds = fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();
					}
					// 如果已有数据
					else {
						fileEntryIds = fileEntryIds + "," + fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();
						fileJson.put("fileId", fileEntry.getFileEntryId());
					}
					completeApplyMaterial.setFileEntryIds(fileEntryIds);
					CompleteApplyMaterialLocalServiceUtil.updateCompleteApplyMaterial(completeApplyMaterial);
					fileJson.put("materialName", completeApplyMaterial.getClmc());
				}

				HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = null;
				out = response.getWriter();
				out.print(fileJson.toString());
				out.flush();
				out.close();
			}

			// 删除文件
			if ("fileDelete".equals(resourceId)) {
				String fileId = ParamUtil.get(resourceRequest, "fileId", "0");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				if (!fileId.equals("0")) {
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileId));
					if (!materialId.equals("0")) {
						CompleteApplyMaterial completeApplyMaterial = CompleteApplyMaterialLocalServiceUtil
								.getCompleteApplyMaterial(Long.valueOf(materialId));
						String fileEntryIds = completeApplyMaterial.getFileEntryIds();
						fileEntryIds = fileEntryIds + ",";// 加上逗号为了容易替换
						// 获取文件路径
						String filePath = getFilePath(Long.valueOf(fileId));
						String str = fileId + "\\|" + dlFileEntry.getExtension() + "\\,";
						fileEntryIds = fileEntryIds.replaceFirst(str, "");
						if (Validator.isNotNull(fileEntryIds)) {
							fileEntryIds = fileEntryIds.substring(0, fileEntryIds.length() - 1);// 最后一步再把逗号去掉
						}
						completeApplyMaterial.setFileEntryIds(fileEntryIds);
						CompleteApplyMaterialLocalServiceUtil.updateCompleteApplyMaterial(completeApplyMaterial);
					}
					DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long.valueOf(fileId));
				}
			}

		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	public FileEntry uploadFile(ResourceRequest request, String fileSourceName, byte[] fileBytes,
			ServiceContext serviceContext, String portletId, String materialId, String fileTitle)
			throws PortalException, SystemException, IOException {
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
					dlChildFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false,
							dlParentFolder.getFolderId(), materialId, "", false, serviceContext);
				}
			} else {
				dlParentFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, true, rootFolderId,
						portletId, "", true, serviceContext);
				dlChildFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false,
						dlParentFolder.getFolderId(), materialId, "", false, serviceContext);
			}
		}

		if (fileBytes != null) {
			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId, dlChildFolder.getFolderId(),
					fileSourceName, MimeTypesUtil.getContentType(fileSourceName), fileTitle, null, null, fileBytes,
					serviceContext);
		}
		return fileEntry;
	}

	public static String getFilePath(Long fileEntryId) throws PortalException, SystemException {
		if (Validator.isNotNull(fileEntryId)) {
			DLFileEntry dLFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
			return dLFileEntry.getGroupId() + "/" + dLFileEntry.getFolderId() + "/" + dLFileEntry.getTitle();
		} else
			return "";
	}

	public void submitAll(ActionRequest request, ActionResponse response) throws PortalException, SystemException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long completeId = ParamUtil.getLong(request, "completeId");
		String babh = "JT";
		Complete complete = CompleteLocalServiceUtil.getComplete(completeId);

		CompleteProjectProfile completeProjectProfile = CompleteProjectProfileLocalServiceUtil
				.getCompleteProjectProfile(completeId);
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
					if (Validator.isNotNull(complete_.getBabh())
							&& complete_.getBabh().substring(4, 8).equals(currentDateStr)) {
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
		} else if (num / 100 < 1) {
			babh = babh + "00" + num;
		} else if (num / 1000 < 1) {
			babh = babh + "0" + num;
		} else if (num / 10000 < 1) {
			babh = babh + num;
		}

		complete.setBabh(babh);
		complete.setGroupId(themeDisplay.getScopeGroupId());
		complete.setCompanyId(themeDisplay.getCompanyId());
		// 保存状态
		complete.setSqbz(0);
		complete.setStatus(CompleteStatus.STATUS_SB.getCode());
		CompleteLocalServiceUtil.updateComplete(complete);
	}

}
