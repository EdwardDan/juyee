package com.justonetech.cp.portlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import com.justonetech.cp.contract.model.Contract;
import com.justonetech.cp.contract.service.ContractLocalServiceUtil;
import com.justonetech.cp.permit.model.ApplyMaterial;
import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.model.UnitProject;
import com.justonetech.cp.permit.service.ApplyMaterialLocalServiceUtil;
import com.justonetech.cp.permit.service.ParticipationUnitLocalServiceUtil;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.cp.permit.service.UnitProjectLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PermitApplicationPortlet
 */
public class PermitApplicationPortlet extends MVCPortlet {

	private static String dateFormatPattern = PropsUtil.get("default.date.format.pattern");

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (Validator.equals(mvcPath, "/portlet/permit-application/select-contract.jsp")) {
			String bjbh = ParamUtil.getString(renderRequest, "bjbh", "");
			String bdh = ParamUtil.getString(renderRequest, "bdh", "");
			String htmc = ParamUtil.getString(renderRequest, "htmc", "");
			String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm", "");
			renderRequest.setAttribute("bjbh", bjbh);
			renderRequest.setAttribute("bdh", bdh);
			renderRequest.setAttribute("htmc", htmc);
			renderRequest.setAttribute("zzjgdm", zzjgdm);
			List<Contract> ybssgzbContracts = new ArrayList<Contract>();
			int ybssgzbContractsCount = 0;
			int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
			int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			ybssgzbContracts = ContractLocalServiceUtil.getYbssgzbContracts(zzjgdm, bjbh, bdh, htmc, start, end);
			ybssgzbContractsCount = ContractLocalServiceUtil.getYbssgzbContractsCount(zzjgdm, bjbh, bdh, htmc);
			renderRequest.setAttribute("ybssgzbContracts", ybssgzbContracts);
			renderRequest.setAttribute("ybssgzbContractsCount", ybssgzbContractsCount);
		} else if (Validator.equals(mvcPath, "/portlet/permit-application/edit-permit.jsp")) {
		}
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String bjbh = ParamUtil.getString(renderRequest, "bjbh");
		String wssqbh = ParamUtil.getString(renderRequest, "wssqbh");
		String gcmc = ParamUtil.getString(renderRequest, "gcmc");
		String zzjgdm = ParamUtil.getString(renderRequest, "zzjgdm");
		int defaultDelta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int delta = ParamUtil.getInteger(renderRequest, "delta", defaultDelta);
		int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = delta * (cur - 1);
		int end = delta * cur;

		List<Permit> permits = new ArrayList<Permit>();
		int permitsCount = 0;
		permits = PermitLocalServiceUtil.getPermits(zzjgdm, bjbh, wssqbh, gcmc, start, end);
		permitsCount = PermitLocalServiceUtil.getPermitsCount(zzjgdm, bjbh, wssqbh, gcmc);
		renderRequest.setAttribute("permits", permits);
		renderRequest.setAttribute("permitsCount", permitsCount);
		renderRequest.setAttribute("bjbh", bjbh);
		renderRequest.setAttribute("zzjgdm", zzjgdm);
		renderRequest.setAttribute("wssqbh", wssqbh);
		renderRequest.setAttribute("gcmc", gcmc);
		super.doView(renderRequest, renderResponse);
	}

	public void saveProjectProfile(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {

		Long xmlx = ParamUtil.getLong(request, "xmlx");
		String lxjb = ParamUtil.getString(request, "lxjb");
		Long xmxz = ParamUtil.getLong(request, "xmxz");
		String ssqx = ParamUtil.getString(request, "ssqx");
		String jsdwmc = ParamUtil.getString(request, "jsdwmc");
		String jsdwxz = ParamUtil.getString(request, "jsdwxz");
		String jsdwdz = ParamUtil.getString(request, "jsdwdz");
		String gcmc = ParamUtil.getString(request, "gcmc");
		String jsdd = ParamUtil.getString(request, "jsdd");
		Long jsddssqx = ParamUtil.getLong(request, "jsddssqx");
		String[] jsgclbArrs = ParamUtil.getParameterValues(request, "jsgclbCheckbox");
		String jsgclbs = "";
		if (null != jsgclbArrs && jsgclbArrs.length > 0) {
			for (String jsgclb : jsgclbArrs) {
				jsgclbs += "," + jsgclb;
			}
		}
		Long jsgcsx = ParamUtil.getLong(request, "jsgcsx");
		String jsgcgm = ParamUtil.getString(request, "jsgcgm");
		String gyzjbz = ParamUtil.getString(request, "gyzjbz");
		String fwjzmj = ParamUtil.getString(request, "fwjzmj");
		String htjg = ParamUtil.getString(request, "htjg");
		int htgq = ParamUtil.getInteger(request, "htgq");
		String zbjg = ParamUtil.getString(request, "zbjg");
		String xmtzgs = ParamUtil.getString(request, "xmtzgs");
		String fddbr = ParamUtil.getString(request, "fddbr");
		String jsdwlxdh = ParamUtil.getString(request, "jsdwlxdh");
		String jsdwlxr = ParamUtil.getString(request, "jsdwlxr");
		String jsdwsjh = ParamUtil.getString(request, "jsdwsjh");
		String jsydpzwjhfdccqzbh = ParamUtil.getString(request, "jsydpzwjhfdccqzbh");
		String jsgcghxkzbh = ParamUtil.getString(request, "jsgcghxkzbh");
		String xckgqk = ParamUtil.getString(request, "xckgqk");
		Date jhkg = ParamUtil.getDate(request, "jhkg", new SimpleDateFormat(dateFormatPattern));
		Date jhjg = ParamUtil.getDate(request, "jhjg", new SimpleDateFormat(dateFormatPattern));
		Boolean sfzftzl = ParamUtil.getBoolean(request, "sfzftzl");
		String yzzpl1 = ParamUtil.getString(request, "yzzpl1");
		String yzzpl2 = ParamUtil.getString(request, "yzzpl2");
		String yzzpl3 = ParamUtil.getString(request, "yzzpl3");
		String yzzpl4 = ParamUtil.getString(request, "yzzpl4");
		Long permitId = ParamUtil.getLong(request, "permitId");
		String bjbh = ParamUtil.getString(request, "bjbh");
		String bdh = ParamUtil.getString(request, "bdh");

		ProjectProfile projectProfile = null;
		Permit permit = null;
		if (permitId != 0) {
			projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			permit = PermitLocalServiceUtil.getPermit(permitId);
		} else {
			projectProfile = ProjectProfileLocalServiceUtil.createProjectProfile(CounterLocalServiceUtil.increment());
			permit = PermitLocalServiceUtil.createPermit(projectProfile.getPermitId());
			permit.setSqbz(1);
			permit.setSqzt(1);
		}
		projectProfile.setXmlx(xmlx);
		projectProfile.setLxjb(lxjb);
		projectProfile.setXmxz(xmxz);
		projectProfile.setSsqx(ssqx);
		projectProfile.setJsdwmc(jsdwmc);
		projectProfile.setJsdwxz(jsdwxz);
		projectProfile.setJsdwdz(jsdwdz);
		projectProfile.setGcmc(gcmc);
		projectProfile.setJsdd(jsdd);
		projectProfile.setJsddssqx(jsddssqx);
		projectProfile.setJsgclb(jsgclbs);
		projectProfile.setJsgcsx(jsgcsx);
		projectProfile.setJsgcgm(jsgcgm);
		projectProfile.setGyzjbz(gyzjbz);
		projectProfile.setFwjzmj(fwjzmj);
		projectProfile.setHtjg(htjg);
		projectProfile.setHtgq(htgq);
		projectProfile.setZbjg(zbjg);
		projectProfile.setXmtzgs(xmtzgs);
		projectProfile.setFddbr(fddbr);
		projectProfile.setJsdwlxdh(jsdwlxdh);
		projectProfile.setJsdwlxr(jsdwlxr);
		projectProfile.setJsdwsjh(jsdwsjh);
		projectProfile.setJsydpzwjhfdccqzbh(jsydpzwjhfdccqzbh);
		projectProfile.setJsgcghxkzbh(jsgcghxkzbh);
		projectProfile.setXckgqk(xckgqk);
		projectProfile.setJhkg(jhkg);
		projectProfile.setJhjg(jhjg);
		projectProfile.setSfzftzl(sfzftzl);
		projectProfile.setYzzpl1(yzzpl1);
		projectProfile.setYzzpl2(yzzpl2);
		projectProfile.setYzzpl3(yzzpl3);
		projectProfile.setYzzpl4(yzzpl4);
		String ywbm = "JT";
		Dictionary xmlxDic = DictionaryLocalServiceUtil.getDictionary(xmlx);
		ywbm = ywbm + xmlxDic.getCode();
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4) + currentDate.substring(5, 7);
		ywbm = ywbm + currentDateStr+"0000";
		projectProfile.setYwbm(ywbm);
		ProjectProfileLocalServiceUtil.updateProjectProfile(projectProfile);
		permit.setBjbh(bjbh);
		permit.setBdh(bdh);
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 1);
	}

	public void saveParticipationUnits(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {

		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		if (permit.getSqbz() == 1) {
			permit.setSqbz(2);
		}

		PermitLocalServiceUtil.updatePermit(permit);

		List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId, -1, -1);
		if (null != participationUnits) {
			for (ParticipationUnit participationUnit : participationUnits) {
				ParticipationUnitLocalServiceUtil.deleteParticipationUnit(participationUnit);
			}
		}
		String[] dwmcs = ParamUtil.getParameterValues(request, "dwmc");
		String[] sfssjs = ParamUtil.getParameterValues(request, "sfyssj");
		String[] dwlxs = ParamUtil.getParameterValues(request, "dwlx");
		String[] xmfzrs = ParamUtil.getParameterValues(request, "xmfzr");
		String[] zjlxs = ParamUtil.getParameterValues(request, "zjlx");
		String[] zjhs = ParamUtil.getParameterValues(request, "zjh");
		String[] dhhms = ParamUtil.getParameterValues(request, "dhhm");
		for (int i = 0; i < dwmcs.length; i++) {
			ParticipationUnit participationUnit = ParticipationUnitLocalServiceUtil.createParticipationUnit(CounterLocalServiceUtil.increment());
			participationUnit.setDwmc(dwmcs[i]);
			participationUnit.setSfyssj(Boolean.valueOf(sfssjs[i]));
			participationUnit.setDwlx(dwlxs[i]);
			if (xmfzrs.length > 0) {
				participationUnit.setXmfzr(xmfzrs[i]);
			}
			if (zjhs.length > 0) {
				participationUnit.setZjh(zjhs[i]);
			}
			participationUnit.setZjlx(zjlxs[i]);
			if (dhhms.length > 0) {
				participationUnit.setDhhm(dhhms[i]);
			}
			participationUnit.setPermitId(permitId);
			ParticipationUnitLocalServiceUtil.addParticipationUnit(participationUnit);

		}
		redirect(request, response, permit, 2);
	}

	public void saveUnitProjects(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {

		long permitId = ParamUtil.getLong(request, "permitId");

		List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(permitId, -1, -1);
		for (UnitProject unitProject : unitProjects) {
			UnitProjectLocalServiceUtil.deleteUnitProject(unitProject);
		}
		String bjbh = ParamUtil.getString(request, "bjbh");
		String[] gcbhs = ParamUtil.getParameterValues(request, "gcbh");
		String[] gcmcs = ParamUtil.getParameterValues(request, "gcmc");
		String[] jsnrs = ParamUtil.getParameterValues(request, "jsnr");
		for (int i = 0; i < gcbhs.length - 1; i++) {
			UnitProject unitProject = UnitProjectLocalServiceUtil.createUnitProject(CounterLocalServiceUtil.increment());
			unitProject.setBjbh(bjbh);
			unitProject.setPermitId(permitId);
			unitProject.setGcbh(gcbhs[i]);
			unitProject.setGcmc(gcmcs[i]);
			unitProject.setJsnr(jsnrs[i]);
			UnitProjectLocalServiceUtil.addUnitProject(unitProject);
		}
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);

		if (permit.getSqbz() == 2) {
			permit.setSqbz(3);
		}
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 3);
	}

	public void saveApplyMaterials(ActionRequest request, ActionResponse response) throws SystemException, PortalException, ParseException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		if (permit.getSqbz() == 3) {
			permit.setSqbz(4);
		}
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response, permit, 4);
	}

	public void redirect(ActionRequest request, ActionResponse response, Permit permit, int sqbz) throws IOException {

		String redirect = ParamUtil.getString(request, "redirectURL");
		int tabSqbz = 1;
		if (permit.getSqbz() == sqbz && sqbz < 4) {
			tabSqbz = sqbz + 1;
		} else if (permit.getSqbz() == sqbz && sqbz == 4) {
			tabSqbz = sqbz;
		} else if (permit.getSqbz() > sqbz) {
			tabSqbz = sqbz;
		}
		redirect += "&" + response.getNamespace() + "permitId=" + permit.getPermitId();
		redirect += "&" + response.getNamespace() + "tabSqbz=" + tabSqbz;
		response.sendRedirect(redirect);
	}
	
	public void deletePermits(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException, PortalException, SystemException  {
		String deletePermitIds = ParamUtil.getString(actionRequest,
				"permitIds");
		String[] permitIds = deletePermitIds.split(",");
		for (String permitId : permitIds) {
			ProjectProfileLocalServiceUtil.deleteProjectProfile(Long
					.parseLong(permitId));
			List<UnitProject> unitProjects = UnitProjectLocalServiceUtil.findByPermitId(Long
					.parseLong(permitId), -1, -1);
			for (UnitProject unitProject : unitProjects) {
				UnitProjectLocalServiceUtil.deleteUnitProject(unitProject);
			}
			List<ParticipationUnit> participationUnits=ParticipationUnitLocalServiceUtil.findByPermitId(Long
					.parseLong(permitId), -1, -1);
			for(ParticipationUnit participationUnit:participationUnits){
				ParticipationUnitLocalServiceUtil.deleteParticipationUnit(participationUnit);
			}
			List<ApplyMaterial> applyMaterials=ApplyMaterialLocalServiceUtil.findByPermitId(Long
					.parseLong(permitId), -1, -1);
			for(ApplyMaterial applyMaterial:applyMaterials){
				ApplyMaterialLocalServiceUtil.deleteApplyMaterial(applyMaterial);
			}
			PermitLocalServiceUtil.deletePermit(Long
					.parseLong(permitId));
		}
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub

		try {
			String resourceId = resourceRequest.getResourceID();
			String fileSourceName = "";
			//上传文件
			if ("fileUpLoad".equals(resourceId)) {
				UploadPortletRequest uploadPortletRequest = PortalUtil
						.getUploadPortletRequest(resourceRequest);

				ServiceContext serviceContext;
				JSONObject fileJson = JSONFactoryUtil.createJSONObject();
				serviceContext = ServiceContextFactory.getInstance(
						Permit.class.getName(), resourceRequest);
				FileEntry fileEntry=null;
				//对应的是第几类材料的div
				String divNo=ParamUtil.get(resourceRequest, "divNo","");
				//文件材料的名称编号
				String no=ParamUtil.get(resourceRequest, "no","");
				String fileExtension=ParamUtil.get(resourceRequest, "fileExtension","");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				String portletId = ParamUtil.get(resourceRequest, "portletId", "");
				fileSourceName = uploadPortletRequest.getFileName("userfile");
				InputStream stream = uploadPortletRequest.getFileAsStream("userfile");
				
				/*
				fileSourceName = uploadPortletRequest.getFileName("fileInput"+divNo);
				InputStream stream = uploadPortletRequest.getFileAsStream("fileInput"+divNo);*/
				byte[] fileBytes=null;
				if(null!=stream){
					fileBytes=FileUtil.getBytes(stream);
				}
				if(!materialId.equals("0")){
					ApplyMaterial applyMaterial=ApplyMaterialLocalServiceUtil.getApplyMaterial(Long.valueOf(materialId));
					String fileTitle=applyMaterial.getClmc()+"-"+no+"."+fileExtension;
					
					fileEntry = uploadFile(resourceRequest,
							fileSourceName, fileBytes, serviceContext,portletId,materialId,fileTitle);
					
					String fileEntryIds =applyMaterial.getFileEntryIds();
					//添加第一条数据时
					if(Validator.isNull(fileEntryIds)){
						fileEntryIds=fileEntry.getFileEntryId()+"|"+fileEntry.getExtension();
					}
					//如果已有数据
					else{
						fileEntryIds=fileEntryIds+","+fileEntry.getFileEntryId()+"|"+fileEntry.getExtension();
					}
					applyMaterial.setFileEntryIds(fileEntryIds);
					ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
					fileJson.put("materialName", applyMaterial.getClmc());
				}
				fileJson.put("fileId", fileEntry.getFileEntryId());
				HttpServletResponse response = PortalUtil
							.getHttpServletResponse(resourceResponse);
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = null;
				out = response.getWriter();
				out.print(fileJson.toString());
				out.flush();
				out.close();
			}
			
			//删除文件
			if ("fileDelete".equals(resourceId)) {
				String fileId = ParamUtil.get(resourceRequest, "fileId", "0");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				System.out.println(111);
				if (!fileId.equals("0")) {
					DLFileEntry dlFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileId));
					if(!materialId.equals("0")){
						System.out.println(fileId);
						ApplyMaterial applyMaterial=ApplyMaterialLocalServiceUtil.getApplyMaterial(Long.valueOf(materialId));
						String fileEntryIds =applyMaterial.getFileEntryIds();
						fileEntryIds=fileEntryIds+",";//加上逗号为了容易替换
						//获取文件路径
						String filePath=getFilePath(Long.valueOf(fileId));
						String str=fileId+"\\|"+dlFileEntry.getExtension()+"\\,";
						fileEntryIds=fileEntryIds.replaceFirst(str, "");
						System.out.println(fileEntryIds);
						if(Validator.isNotNull(fileEntryIds)){
							fileEntryIds=fileEntryIds.substring(0,fileEntryIds.length()-1);//最后一步再把逗号去掉
						}
						applyMaterial.setFileEntryIds(fileEntryIds);
						ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
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
		}/* catch (IOException e) {
			e.printStackTrace();
		}*/
		super.serveResource(resourceRequest, resourceResponse);
	}
	

	public FileEntry uploadFile(ResourceRequest request, String fileSourceName,
			byte[] fileBytes, ServiceContext serviceContext,String portletId,String materialId,String fileTitle)
			throws PortalException, SystemException, IOException {
		User user = PortalUtil.getUser(request);
		long userId = user.getUserId();
		Long groupId = user.getGroupId();
		Long rootFolderId = DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT;
		FileEntry fileEntry = null;
		//为每一种材料名称创建一个文件夹,如果已有就不再创建
		DLFolder dlParentFolder=null;
		DLFolder dlChildFolder=null;
		if(Validator.isNotNull(portletId)&&Validator.isNotNull(materialId)){
			dlParentFolder=DLFolderLocalServiceUtil.fetchFolder(groupId, rootFolderId, portletId);
			
			if(Validator.isNotNull(dlParentFolder)){
				dlChildFolder=DLFolderLocalServiceUtil.fetchFolder(groupId, dlParentFolder.getFolderId(), materialId);
				if(Validator.isNull(dlChildFolder)){
					dlChildFolder=DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, dlParentFolder.getFolderId(), materialId, "", false, serviceContext);
				}
			}else{
				dlParentFolder=DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, true, rootFolderId, portletId, "", true, serviceContext);
				dlChildFolder=DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, dlParentFolder.getFolderId(), materialId, "", false, serviceContext);			
			}
		}

		
		if (fileBytes != null) {
			fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId,
					dlChildFolder.getFolderId(), fileSourceName,
					MimeTypesUtil.getContentType(fileSourceName), fileTitle, null,
					null, fileBytes, serviceContext);
		}
		return fileEntry;
	}

	
	public static String getFilePath(Long fileEntryId) throws PortalException, SystemException {
		if(Validator.isNotNull(fileEntryId)){
			DLFileEntry dLFileEntry=DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
			return dLFileEntry.getGroupId() + "/" + dLFileEntry.getFolderId() + "/" + dLFileEntry.getTitle();
		}else
			return "";
	}
}

