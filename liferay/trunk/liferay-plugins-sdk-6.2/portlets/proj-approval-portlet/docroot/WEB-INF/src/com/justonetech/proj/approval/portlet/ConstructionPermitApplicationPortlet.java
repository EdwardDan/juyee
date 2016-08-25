package com.justonetech.proj.approval.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.entity.FileEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.justonetech.proj.approval.vo.ConstructionPermitApplication;
import com.justonetech.proj.approval.vo.ConstructionPermitMaterial;
import com.justonetech.projApproval.NoSuchConstructionParticipantUnitsException;
import com.justonetech.projApproval.NoSuchConstructionUnitProjectException;
import com.justonetech.projApproval.model.ConstructionParticipantUnits;
import com.justonetech.projApproval.model.ConstructionPermit;
import com.justonetech.projApproval.model.ConstructionPermitClp;
import com.justonetech.projApproval.model.ConstructionUnitProject;
import com.justonetech.projApproval.service.ConstructionParticipantUnitsLocalServiceUtil;
import com.justonetech.projApproval.service.ConstructionPermitLocalServiceUtil;
import com.justonetech.projApproval.service.ConstructionUnitProjectLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.model.DictionaryClp;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Portlet implementation class ConstructionPermitApplicationPortlet
 */
public class ConstructionPermitApplicationPortlet extends MVCPortlet {
	private static Log log = LogFactoryUtil.getLog(ConstructionPermitApplicationPortlet.class);
	private static String dateFormatPattern = PropsUtil.get("default.date.format.pattern");
	private static String timeFormatPattern = PropsUtil.get("default.time.format.pattern");

	public void testFile(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			IOException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		String[] fileSourceNames = uploadPortletRequest.getFileNames("photo");
		File[] files = uploadPortletRequest.getFiles("photo");
		/*InputStream[] streams = uploadPortletRequest.getFilesAsStream("photo");*/
		

		System.out.println(Arrays.asList(files)); 
		User user = PortalUtil.getUser(request);
		long userId = user.getUserId();
		Long groupId = user.getGroupId();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(ConstructionPermit.class.getName(), request);
		Long folderId = DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT;
		for (int i = 0; i < fileSourceNames.length; i++) {
			byte[] bytes=FileUtil.getBytes(files[i]);
			System.out.println(bytes.length);
			Date date = new Date();
			String title = DateUtil.getDate(date, "yyyy-MM-dd hh-mm-ss", Locale.CHINA) + fileSourceNames[i];
			System.out.println(title);
//			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId, folderId, fileSourceNames[i],
//					MimeTypesUtil.getContentType(fileSourceNames[i]), title, null, null, bytes, serviceContext);

		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub
		String resourceId = resourceRequest.getResourceID();
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
		try {
			DLAppLocalServiceUtil.deleteFileEntry(26548);
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String filePath = ""; try { FileEntry fileEntry =
		 * DLAppLocalServiceUtil.getFileEntry(25809l); filePath =
		 * getFilePath(fileEntry); System.out.println(filePath); } catch
		 * (PortalException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (SystemException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * // File file = new File("d:\\系统字典要点.txt"); File file = new File(
		 * "/documents/20201/0/11+-+%E5%89%AF%E6%9C%AC.txt/5cf4de78-1d26-49b7-9502-a79327f57c02?version=1.0&download=true"
		 * ); byte[] bytes = FileUtil.getBytes(file);
		 * ServletResponseUtil.sendFile(request, response, "test.txt", bytes,
		 * ContentTypes.APPLICATION_OCTET_STREAM);
		 */

		super.serveResource(resourceRequest, resourceResponse);
	}

	// 文件上传测试

	public List<FileEntry> uploadFileToDest(ActionRequest request, String[] fileSourceNames, InputStream[] streams)
			throws PortalException, SystemException, IOException {
		User user = PortalUtil.getUser(request);
		long userId = user.getUserId();
		Long groupId = user.getGroupId();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(ConstructionPermit.class.getName(), request);
		Long folderId = DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT;
		List<FileEntry> fileEntryList = new ArrayList<FileEntry>();

		if (fileSourceNames != null && fileSourceNames.length > 0 && streams.length > 0 && streams != null) {
			for (int i = 0; i < fileSourceNames.length; i++) {
				byte[] bytes = FileUtil.getBytes(streams[i]);

				String title = DateUtil.getDate(new Date(), "yyyy-MM-dd hh-mm-ss", Locale.CHINA) + fileSourceNames[i];
				FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId, folderId, fileSourceNames[i],
						MimeTypesUtil.getContentType(fileSourceNames[i]), title, null, null, bytes, serviceContext);
				fileEntryList.add(fileEntry);
			}
		}
		return fileEntryList;
	}

	public static String getFilePath(FileEntry fileEntry) {
		if (null != fileEntry) {
			return "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getTitle()
					+ "/" + fileEntry.getUuid();
		} else {
			// 如有需要，此处可以定义一个默认图片
			return StringPool.BLANK;
		}
	}

	// list
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String statusName = ParamUtil.getString(renderRequest, "statusName");
		System.out.println(statusName);
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		int delta = GetterUtil.getInteger(PropsUtil.get(PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA));
		int pageSize = ParamUtil.getInteger(renderRequest, "delta", delta);
		int pageNumber = ParamUtil.getInteger(renderRequest, "cur", 1);
		int start = pageSize * (pageNumber - 1);
		int end = pageSize * pageNumber;

		List<ConstructionPermit> constructionPermits = Collections.emptyList();
		try {
			constructionPermits = ConstructionPermitLocalServiceUtil.getConstructionPermits(start, end);
		} catch (SystemException e) {
			log.error("getConstructionPermits( " + start + ", " + end + ")出错：" + e.getMessage());
		}
		int constructionPermitsCount = 0;
		try {
			constructionPermitsCount = ConstructionPermitLocalServiceUtil.getConstructionPermitsCount();
		} catch (SystemException e) {
			log.error("getConstructionPermitsCount()出错：" + e.getMessage());

		}
		renderRequest.setAttribute("constructionPermits", constructionPermits);
		renderRequest.setAttribute("constructionPermitsCount", constructionPermitsCount);

		super.doView(renderRequest, renderResponse);
	}

	// 查看的方法（目前和编辑的内容是一样的，但是后面会不一样）
	public void viewConstructionPermit(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException, ParseException {
		long constructionPermitId = ParamUtil.getLong(request, "constructionPermitId", 0);
		ConstructionPermit constructionPermit = new ConstructionPermitClp();
		Dictionary dictionary = new DictionaryClp();
		ConstructionPermitApplication permitApplication = new ConstructionPermitApplication();
		List<ConstructionParticipantUnits> constructionParticipantUnitsList = new ArrayList<ConstructionParticipantUnits>();
		List<ConstructionUnitProject> constructionUnitProjects = new ArrayList<ConstructionUnitProject>();
		if (constructionPermitId != 0) {
			constructionPermit = ConstructionPermitLocalServiceUtil.getConstructionPermit(constructionPermitId);
			String otherInfo = constructionPermit.getOtherInfo();
			// 把扩展信息解析成对象
			if (Validator.isNotNull(otherInfo)) {
				permitApplication = JSONArray.parseObject(otherInfo, ConstructionPermitApplication.class);
			}
			// 取出参建单位信息
			constructionParticipantUnitsList = ConstructionParticipantUnitsLocalServiceUtil
					.findByConstructionPermitId(constructionPermitId);
			// 取出单位工程信息
			constructionUnitProjects = ConstructionUnitProjectLocalServiceUtil
					.findByConstructionPermitId(constructionPermitId);
		}
		// 找到该申请的项目类型
		long projType = constructionPermit.getProjType();
		if (Validator.isNotNull(projType)) {
			dictionary = DictionaryLocalServiceUtil.getDictionary(projType);
		}

		// 附件的信息
		String json = constructionPermit.getApplyMaterial();
		List<ConstructionPermitMaterial> materials = JSON.parseArray(json, ConstructionPermitMaterial.class);

		request.setAttribute("materials", materials);
		request.setAttribute("constructionParticipantUnitsS", constructionParticipantUnitsList);
		request.setAttribute("constructionUnitProjects", constructionUnitProjects);
		request.setAttribute("permitApplication", permitApplication);
		request.setAttribute("constructionPermit", constructionPermit);
		request.setAttribute("dictionary", dictionary);
	}

	// 编辑的方法
	public void editConstructionPermit(ActionRequest request, ActionResponse response) throws PortalException,
			SystemException, ParseException {
		long constructionPermitId = ParamUtil.getLong(request, "constructionPermitId", 0);
		ConstructionPermit constructionPermit = new ConstructionPermitClp();
		Dictionary dictionary = new DictionaryClp();
		ConstructionPermitApplication permitApplication = new ConstructionPermitApplication();
		List<ConstructionParticipantUnits> constructionParticipantUnitsList = new ArrayList<ConstructionParticipantUnits>();
		List<ConstructionUnitProject> constructionUnitProjects = new ArrayList<ConstructionUnitProject>();
		if (constructionPermitId != 0) {
			constructionPermit = ConstructionPermitLocalServiceUtil.getConstructionPermit(constructionPermitId);
			String otherInfo = constructionPermit.getOtherInfo();
			// 把扩展信息解析成对象
			if (Validator.isNotNull(otherInfo)) {
				permitApplication = JSONArray.parseObject(otherInfo, ConstructionPermitApplication.class);
			}
			// 取出参建单位信息
			constructionParticipantUnitsList = ConstructionParticipantUnitsLocalServiceUtil
					.findByConstructionPermitId(constructionPermitId);
			// 取出单位工程信息
			constructionUnitProjects = ConstructionUnitProjectLocalServiceUtil
					.findByConstructionPermitId(constructionPermitId);
		}
		// 找到该申请的项目类型
		String customContent = "";
		long projType = constructionPermit.getProjType();
		if (Validator.isNotNull(projType)) {
			dictionary = DictionaryLocalServiceUtil.getDictionary(projType);
			customContent = dictionary.getCustomContent();
		}

		String json = constructionPermit.getApplyMaterial();
		if (Validator.isNull(json)) {
			json = customContent;
		}
		List<ConstructionPermitMaterial> materials = JSON.parseArray(json, ConstructionPermitMaterial.class);

		request.setAttribute("materials", materials);
		request.setAttribute("permitApplication", permitApplication);
		request.setAttribute("constructionPermit", constructionPermit);
		request.setAttribute("constructionParticipantUnitsS", constructionParticipantUnitsList);
		request.setAttribute("constructionUnitProjects", constructionUnitProjects);
		request.setAttribute("dictionary", dictionary);
	}

	// 保存
	public void saveConstructionPermit(ActionRequest request, ActionResponse response) throws SystemException,
			PortalException, ParseException, IOException {

		// 获取基本信息
		long constructionPermitId = ParamUtil.getLong(request, "constructionPermitId", 0);
		long projType = ParamUtil.getLong(request, "projType");
		long projProperty = ParamUtil.getLong(request, "projProperty");
		long county = ParamUtil.getLong(request, "county");
		String constructionCode = ParamUtil.getString(request, "constructionCode");
		String bidingCode = ParamUtil.getString(request, "bidingCode");
		String projName = ParamUtil.getString(request, "projName");
		String company = ParamUtil.getString(request, "company");
		String companyProperty = ParamUtil.getString(request, "companyProperty");
		String companyAddress = ParamUtil.getString(request, "companyAddress");
		String legalPerson = ParamUtil.getString(request, "legalPerson");
		String companyTel = ParamUtil.getString(request, "companyTel");
		String companyContacts = ParamUtil.getString(request, "companyContacts");
		String companyContactPhone = ParamUtil.getString(request, "companyContactPhone");
		String companySite = ParamUtil.getString(request, "companySite");
		// 建设地点所属区县
		String companySiteCounty = ParamUtil.getString(request, "companySiteCounty");
		// 建设工程类别
		String engineerCategory = "";
		long[] engineerCates = ParamUtil.getLongValues(request, "engineerCategoryCheckbox");
		for (long engineerCate : engineerCates) {
			engineerCategory += engineerCate + ",";
		}
		if (Validator.isNotNull(engineerCategory)) {
			engineerCategory = engineerCategory.substring(0, engineerCategory.lastIndexOf(","));
		}

		// 建设工程属性
		long engineerAttribute = ParamUtil.getLong(request, "engineerAttribute");

		String engineerScale = ParamUtil.getString(request, "engineerScale");
		String nationalFundsProportion = ParamUtil.getString(request, "nationalFundsProportion");
		Double contractPrice = ParamUtil.getDouble(request, "contractPrice");
		Double contractSchedule = ParamUtil.getDouble(request, "contractSchedule");
		Double bidPrice = ParamUtil.getDouble(request, "bidPrice");
		Double investBudget = ParamUtil.getDouble(request, "investBudget");
		// 计划开工和计划竣工
		Date planStartDate = ParamUtil.getDate(request, "planStartDate", new SimpleDateFormat(dateFormatPattern));
		Date planEndDate = ParamUtil.getDate(request, "planEndDate", new SimpleDateFormat(dateFormatPattern));
		String workSituation = ParamUtil.getString(request, "workSituation");

		// 收件号和发证日期
		/*
		 * String receiptNum = ParamUtil.getString(request, "receiptNum");
		 * String certificationDate = ParamUtil.getString(request,
		 * "certificationDate");
		 */

		// 申请材料
		/* String applyMaterial = ParamUtil.getString(request, "applyMaterial"); */

		// 还有的是施工许可编码的保存
		/*
		 * String constructionPermitCode = ParamUtil.getString(request,
		 * "constructionPermitCode");
		 */

		// 获取扩展信息
		String designCompany = ParamUtil.getString(request, "designCompany");
		String designTenderMethod = ParamUtil.getString(request, "designTenderMethod");
		Double designBidPrice = ParamUtil.getDouble(request, "designBidPrice");
		String designQualificationLevel = ParamUtil.getString(request, "designQualificationLevel");
		String designLevelCertificateCode = ParamUtil.getString(request, "designLevelCertificateCode");
		String designProjectLeader = ParamUtil.getString(request, "designProjectLeader");
		String designLeaderCertificateCode = ParamUtil.getString(request, "designLeaderCertificateCode");
		String supervisionCompany = ParamUtil.getString(request, "supervisionCompany");
		String supervisionTenderMethod = ParamUtil.getString(request, "supervisionTenderMethod");
		Double supervisionBidPrice = ParamUtil.getDouble(request, "supervisionBidPrice");
		String supervisionQualificationLevel = ParamUtil.getString(request, "supervisionQualificationLevel");
		String supervisionLevelCertificateCode = ParamUtil.getString(request, "supervisionLevelCertificateCode");
		String supervisionProjectLeader = ParamUtil.getString(request, "supervisionProjectLeader");
		String supervisionLeaderCertificateCode = ParamUtil.getString(request, "supervisionLeaderCertificateCode");
		String constructionCompany = ParamUtil.getString(request, "constructionCompany");
		String constructionTenderMethod = ParamUtil.getString(request, "constructionTenderMethod");
		Double constructionBidPrice = ParamUtil.getDouble(request, "constructionBidPrice");
		String constructionQualificationLevel = ParamUtil.getString(request, "constructionQualificationLevel");
		String constructionLevelCertificateCode = ParamUtil.getString(request, "constructionLevelCertificateCode");
		String constructionProjectLeader = ParamUtil.getString(request, "constructionProjectLeader");
		String constructionLeaderCertificateCode = ParamUtil.getString(request, "constructionLeaderCertificateCode");
		String feasibilityApprovalOrganAndNumber = ParamUtil.getString(request, "feasibilityApprovalOrganAndNumber");
		Date feasibilityReplyDate = ParamUtil.getDate(request, "feasibilityReplyDate", new SimpleDateFormat(
				dateFormatPattern));
		String initialDesignApprovalOrganAndNumber = ParamUtil
				.getString(request, "initialDesignApprovalOrganAndNumber");
		Double investmentEstimation = ParamUtil.getDouble(request, "investmentEstimation");
		Date initialDesignReplyDate = ParamUtil.getDate(request, "initialDesignReplyDate", new SimpleDateFormat(
				dateFormatPattern));
		String replyProject = ParamUtil.getString(request, "replyProject");
		Double totalBudget = ParamUtil.getDouble(request, "totalBudget");
		String constructionDrawingApprovalOrganAndNumber = ParamUtil.getString(request,
				"constructionDrawingApprovalOrganAndNumber");
		String investmentSource = ParamUtil.getString(request, "investmentSource");
		String projManager = ParamUtil.getString(request, "projManager");
		String projDirector = ParamUtil.getString(request, "projDirector");

		// 把扩展信息保存到对象中
		ConstructionPermitApplication consPerApp = new ConstructionPermitApplication();
		consPerApp.setDesignCompany(designCompany);
		consPerApp.setDesignTenderMethod(designTenderMethod);
		consPerApp.setDesignBidPrice(designBidPrice);
		consPerApp.setDesignQualificationLevel(designQualificationLevel);
		consPerApp.setDesignLevelCertificateCode(designLevelCertificateCode);
		consPerApp.setDesignProjectLeader(designProjectLeader);
		consPerApp.setDesignLeaderCertificateCode(designLeaderCertificateCode);

		consPerApp.setSupervisionCompany(supervisionCompany);
		consPerApp.setSupervisionTenderMethod(supervisionTenderMethod);
		consPerApp.setSupervisionBidPrice(supervisionBidPrice);
		consPerApp.setSupervisionQualificationLevel(supervisionQualificationLevel);
		consPerApp.setSupervisionLevelCertificateCode(supervisionLevelCertificateCode);
		consPerApp.setSupervisionProjectLeader(supervisionProjectLeader);
		consPerApp.setSupervisionLeaderCertificateCode(supervisionLeaderCertificateCode);

		consPerApp.setConstructionCompany(constructionCompany);
		consPerApp.setConstructionTenderMethod(constructionTenderMethod);
		consPerApp.setConstructionBidPrice(constructionBidPrice);
		consPerApp.setConstructionQualificationLevel(constructionQualificationLevel);
		consPerApp.setConstructionLevelCertificateCode(constructionLevelCertificateCode);
		consPerApp.setConstructionProjectLeader(constructionProjectLeader);
		consPerApp.setConstructionLeaderCertificateCode(constructionLeaderCertificateCode);

		consPerApp.setFeasibilityApprovalOrganAndNumber(feasibilityApprovalOrganAndNumber);
		consPerApp.setFeasibilityReplyDate(feasibilityReplyDate);
		consPerApp.setInitialDesignReplyDate(initialDesignReplyDate);
		consPerApp.setInitialDesignApprovalOrganAndNumber(initialDesignApprovalOrganAndNumber);
		consPerApp.setInvestmentEstimation(investmentEstimation);
		consPerApp.setReplyProject(replyProject);
		consPerApp.setTotalBudget(totalBudget);
		consPerApp.setConstructionDrawingApprovalOrganAndNumber(constructionDrawingApprovalOrganAndNumber);
		consPerApp.setInvestmentSource(investmentSource);
		consPerApp.setProjManager(projManager);
		consPerApp.setProjDirector(projDirector);
		// 把对象转化为json字符串
		String otherInfoJson = JSON.toJSONString(consPerApp);
		List<ConstructionParticipantUnits> constructionParticipantUnitsList = new ArrayList<ConstructionParticipantUnits>();
		List<ConstructionUnitProject> constructionUnitProjectList = new ArrayList<ConstructionUnitProject>();

		// 获取参建单位信息
		String[] sortNo1s = request.getParameterValues("sortNo1");
		String[] contractInfoSubmitNums = request.getParameterValues("contractInfoSubmitNum");
		String[] unitTypes = request.getParameterValues("unitType");
		String[] unitNames = request.getParameterValues("unitName");
		String[] projectLeaders = request.getParameterValues("projectLeader");
		String[] telephoneNums = request.getParameterValues("telephoneNum");

		// 获取单位工程信息
		String[] sortNo2s = request.getParameterValues("sortNo2");
		String[] unitProjectNums = request.getParameterValues("unitProjectNum");
		String[] unitProjectNames = request.getParameterValues("unitProjectName");
		String[] constructionContents = request.getParameterValues("constructionContent");

		Integer statusProxy = -1;
		// 保存基本信息
		ConstructionPermit constructionPermit = null;
		if (constructionPermitId == 0) {

			constructionPermitId = CounterLocalServiceUtil.increment();
			constructionPermit = ConstructionPermitLocalServiceUtil.createConstructionPermit(constructionPermitId);
			constructionPermit.setCreateTime(new Date());
		} else {
			constructionPermit = ConstructionPermitLocalServiceUtil.getConstructionPermit(constructionPermitId);
			constructionParticipantUnitsList = ConstructionParticipantUnitsLocalServiceUtil
					.findByConstructionPermitId(constructionPermitId);
			constructionUnitProjectList = ConstructionUnitProjectLocalServiceUtil
					.findByConstructionPermitId(constructionPermitId);
			statusProxy = constructionPermit.getStatus();
		}

		User user = PortalUtil.getUser(request);
		if (Validator.isNotNull(user)) {
			constructionPermit.setUserId(user.getUserId());
			constructionPermit.setUserName(user.getFullName());
		}

		constructionPermit.setProjType(projType);
		constructionPermit.setProjProperty(projProperty);
		constructionPermit.setCounty(county);
		constructionPermit.setConstructionCode(constructionCode);
		constructionPermit.setBidingCode(bidingCode);

		// 业务编码暂时搁置（JT+项目类型名称简写+年月+本年编号）
		String businessCode = "";
		// 项目类型名称简写
		DictionaryLocalServiceUtil.getDictionary(projType).getName();
		// 年月
		businessCode = DateUtil.getDate(new Date(), "yy-MM", Locale.CHINA);
		// 根据状态搜索提交后的本年的申请数量（需要后面做）

		constructionPermit.setProjName(projName);
		constructionPermit.setCompany(company);
		constructionPermit.setCompanyProperty(companyProperty);
		constructionPermit.setCompanyAddress(companyAddress);
		constructionPermit.setLegalPerson(legalPerson);
		constructionPermit.setCompanyTel(companyTel);
		constructionPermit.setCompanyContacts(companyContacts);
		constructionPermit.setCompanyContactPhone(companyContactPhone);
		constructionPermit.setCompanySite(companySite);
		constructionPermit.setCompanySiteCounty(companySiteCounty);
		constructionPermit.setEngineerCategory(engineerCategory);
		constructionPermit.setEngineerAttribute(engineerAttribute);
		constructionPermit.setEngineerScale(engineerScale);
		constructionPermit.setNationalFundsProportion(nationalFundsProportion);
		constructionPermit.setContractPrice(contractPrice);
		constructionPermit.setContractSchedule(contractSchedule);
		constructionPermit.setBidPrice(bidPrice);
		constructionPermit.setInvestBudget(investBudget);
		constructionPermit.setPlanStartDate(planStartDate);
		constructionPermit.setPlanEndDate(planEndDate);
		constructionPermit.setWorkSituation(workSituation);
		constructionPermit.setModifiedTime(new Date());
		// 保存扩展信息
		constructionPermit.setOtherInfo(otherInfoJson);

		if (statusProxy >= 0) {
			System.out.println("0");
			// 申请材料的信息
			Dictionary channelDictionary = DictionaryLocalServiceUtil.findByCode("ProjectType1");
			String jsonString = channelDictionary.getCustomContent();
			List<ConstructionPermitMaterial> materials = JSON.parseArray(jsonString, ConstructionPermitMaterial.class);
			List<ConstructionPermitMaterial> applyMaterials = new ArrayList<ConstructionPermitMaterial>();
			for (ConstructionPermitMaterial material : materials) {
				long type = material.getType();

				Dictionary materialType = DictionaryLocalServiceUtil.getDictionary(type);

				if (materialType.getCode().equals("apply")) {
					applyMaterials.add(material);
				}
			}

			// 保存附件信息
			// 1.保存附件到数据库表和本地文档及保存实交份数信息
			// 得到liferay的api
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
			// 得到实交份数
			String[] realPostNums = ParamUtil.getParameterValues(request, "realPostNum");
			for (ConstructionPermitMaterial applyMaterial : applyMaterials) {
				System.out.println("2");
				List<FileEntry> fileEntryList = null;
				InputStream[] streams = null;
				String[] fileSourceNames = null;
				String fileEntryIds = "";
				streams = uploadPortletRequest.getFilesAsStream("applyMaterial" + applyMaterial.getSortNo());
				fileSourceNames = uploadPortletRequest.getFileNames("applyMaterial" + applyMaterial.getSortNo());
				// 从上面两个方法获取的files和fileSourceNames如果没有上传附件，长度是1，而不是0
				if (fileSourceNames != null && streams != null) {

					if (!((streams.length <= 1 && streams[0] != null) || (fileSourceNames.length <= 1 && fileSourceNames[0] == ""))) {
						fileEntryList = uploadFileToDest(request, fileSourceNames, streams);
					}
				}
				// 生成文件的ids和文件的路径
				List<String> filePaths = new ArrayList<String>();
				if (Validator.isNotNull(fileEntryList)) {
					for (FileEntry fileEntry : fileEntryList) {
						fileEntryIds += fileEntry.getFileEntryId() + ",";
						filePaths.add(getFilePath(fileEntry));
					}
					fileEntryIds = fileEntryIds.substring(0, fileEntryIds.length() - 1);
				}
				// 保存附件的路径
				applyMaterial.setFilePaths(filePaths);

				// 保存附件的ids
				applyMaterial.setDlFileEntryIds(fileEntryIds);
				// 保存实交份数
				applyMaterial.setRealPostNum(Integer.valueOf(realPostNums[applyMaterial.getSortNo() - 1]));
			}

			// 2.保存附件的fileEntryId到施工许可申请的applyMaterial字段中
			String applyMaterialJson = "";
			applyMaterialJson = JSON.toJSONString(applyMaterials);
			constructionPermit.setApplyMaterial(applyMaterialJson);
		}
		ConstructionPermitLocalServiceUtil.updateConstructionPermit(constructionPermit);
		// 保存参建单位信息和单位工程信息
		// 判断对应的constructionPermitId是否有参建单位信息和单位工程信息，如果有信息，在保存新信息之前删除掉旧的信息

		// 删除参建单位信息s
		if (null != constructionParticipantUnitsList && constructionParticipantUnitsList.size() > 0) {
			for (ConstructionParticipantUnits constructionParticipantUnits : constructionParticipantUnitsList) {
				ConstructionParticipantUnitsLocalServiceUtil
						.deleteConstructionParticipantUnits(constructionParticipantUnits);
			}
		}
		// 删除单位工程信息
		if (null != constructionUnitProjectList && constructionUnitProjectList.size() > 0) {
			for (ConstructionUnitProject constructionUnitProject : constructionUnitProjectList) {
				ConstructionUnitProjectLocalServiceUtil.deleteConstructionUnitProject(constructionUnitProject);
			}
		}
		// 保存参建单位信息
		if (null != sortNo1s && sortNo1s.length > 0) {
			for (String sortNoStr : sortNo1s) {
				int sortNo = Integer.parseInt(sortNoStr) - 1;
				Long constructionParticipantUnitsId = CounterLocalServiceUtil.increment();
				ConstructionParticipantUnits constructionParticipantUnits = ConstructionParticipantUnitsLocalServiceUtil
						.createConstructionParticipantUnits(constructionParticipantUnitsId);
				constructionParticipantUnits.setConstructionPermitId(constructionPermitId);
				constructionParticipantUnits.setSortNo(sortNo + 1);
				if (Validator.isNotNull(unitTypes[sortNo])) {
					constructionParticipantUnits.setUnitType(Long.valueOf(unitTypes[sortNo]));
				}
				if (Validator.isNotNull(contractInfoSubmitNums[sortNo])) {
					constructionParticipantUnits.setContractInfoSubmitNum(contractInfoSubmitNums[sortNo]);
				}
				if (Validator.isNotNull(unitNames[sortNo])) {
					constructionParticipantUnits.setUnitName(unitNames[sortNo]);
				}
				if (Validator.isNotNull(projectLeaders[sortNo])) {
					constructionParticipantUnits.setProjectLeader(projectLeaders[sortNo]);
				}
				if (Validator.isNotNull(telephoneNums[sortNo])) {
					constructionParticipantUnits.setTelephoneNum(telephoneNums[sortNo]);
				}
				ConstructionParticipantUnitsLocalServiceUtil
						.addConstructionParticipantUnits(constructionParticipantUnits);
			}
		}

		// 保存单位工程信息
		if (null != sortNo2s && sortNo2s.length > 0) {
			for (String sortNoStr : sortNo2s) {
				int sortNo = Integer.parseInt(sortNoStr) - 1;
				Long constructionUnitProbjectId = CounterLocalServiceUtil.increment();
				ConstructionUnitProject constructionUnitProject = ConstructionUnitProjectLocalServiceUtil
						.createConstructionUnitProject(constructionUnitProbjectId);
				constructionUnitProject.setConstructionPermitId(constructionPermitId);
				constructionUnitProject.setSortNo(sortNo + 1);

				if (Validator.isNotNull(unitProjectNums[sortNo])) {
					constructionUnitProject.setUnitProjectNum(unitProjectNums[sortNo]);
				}

				if (Validator.isNotNull(unitProjectNames[sortNo])) {
					constructionUnitProject.setUnitProjectName(unitProjectNames[sortNo]);
				}
				if (Validator.isNotNull(constructionContents[sortNo])) {
					constructionUnitProject.setConstructionContent(constructionContents[sortNo]);
				}
				ConstructionUnitProjectLocalServiceUtil.addConstructionUnitProject(constructionUnitProject);
			}
		}
	}

	// 删除
	public void deleteConstructionPermits(ActionRequest request, ActionResponse response)
			throws NoSuchConstructionParticipantUnitsException, NoSuchConstructionUnitProjectException,
			NumberFormatException, SystemException {

		String deleteConstructionPermitIds = ParamUtil.getString(request, "constructionPermitIds");
		String[] constructionPermitIds = deleteConstructionPermitIds.split(",");
		for (String constructionPermitId : constructionPermitIds) {
			if (Validator.isNotNull(constructionPermitId)) {
				// 删除参建单位及负责人信息
				List<ConstructionParticipantUnits> constructionParticipantUnitsList = ConstructionParticipantUnitsLocalServiceUtil
						.findByConstructionPermitId(Long.valueOf(constructionPermitId));
				if (Validator.isNotNull(constructionParticipantUnitsList)) {
					for (ConstructionParticipantUnits constructionParticipantUnits : constructionParticipantUnitsList) {
						ConstructionParticipantUnitsLocalServiceUtil
								.deleteConstructionParticipantUnits(constructionParticipantUnits);
					}
				}
				// 删除单位工程信息
				List<ConstructionUnitProject> constructionUnitProjectList = ConstructionUnitProjectLocalServiceUtil
						.findByConstructionPermitId(Long.valueOf(constructionPermitId));
				if (Validator.isNotNull(constructionUnitProjectList)) {
					for (ConstructionUnitProject constructionUnitProject : constructionUnitProjectList) {
						ConstructionUnitProjectLocalServiceUtil.deleteConstructionUnitProject(constructionUnitProject);
					}
				}
			}
		}
		ConstructionPermitLocalServiceUtil.deleteConstructionPermits(constructionPermitIds);
	}

}
