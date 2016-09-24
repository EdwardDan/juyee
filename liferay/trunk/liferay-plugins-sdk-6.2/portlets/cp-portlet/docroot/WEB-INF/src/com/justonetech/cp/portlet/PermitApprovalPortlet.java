package com.justonetech.cp.portlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
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

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.DocumentException;
import com.justonetech.cp.permit.model.ApplyMaterial;
import com.justonetech.cp.permit.model.ParticipationUnit;
import com.justonetech.cp.permit.model.Permit;
import com.justonetech.cp.permit.model.ProjectProfile;
import com.justonetech.cp.permit.service.ApplyMaterialLocalServiceUtil;
import com.justonetech.cp.permit.service.ParticipationUnitLocalServiceUtil;
import com.justonetech.cp.permit.service.PermitLocalServiceUtil;
import com.justonetech.cp.permit.service.ProjectProfileLocalServiceUtil;
import com.justonetech.sys.model.Dictionary;
import com.justonetech.sys.service.DictionaryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * Portlet implementation class PermitApprovalPortlet
 */
public class PermitApprovalPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}

	// 保存收件sj
	public void saveSj(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		String slbh = ParamUtil.getString(request, "slbh");
		String cltjr = ParamUtil.getString(request, "cltjr");
		String hjgsz = ParamUtil.getString(request, "hjgsz");
		String hjgsh = ParamUtil.getString(request, "hjgsh");
		String cltjrlxdh = ParamUtil.getString(request, "cltjrlxdh");
		String sqr = ParamUtil.getString(request, "sqr");
		String cltjrlxdz = ParamUtil.getString(request, "cltjrlxdz");
		String sqsx = ParamUtil.getString(request, "sqsx");
		String sjr = ParamUtil.getString(request, "sjr");
		String sqh = ParamUtil.getString(request, "sqh");
		String sjrlxdh = ParamUtil.getString(request, "sjrlxdh");
		permit.setSlbh(slbh);
		permit.setCltjr(cltjr);
		try {
			permit.setHjgsz(Integer.parseInt(hjgsz));
			permit.setHjgsh(Integer.parseInt(hjgsh));
		} catch (Exception e) {
			// TODO: handle exception
		}

		permit.setCltjrlxdh(cltjrlxdh);
		permit.setSqr(sqr);
		permit.setCltjrlxdz(cltjrlxdz);
		permit.setSqsx(sqsx);
		permit.setSjr(sjr);
		permit.setSqh(sqh);
		permit.setSjrlxdh(sjrlxdh);
		PermitLocalServiceUtil.updatePermit(permit);
		redirect(request, response);
	}

	// 保存初审cs和sl
	public void saveCs(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] csyjs = ParamUtil.getParameterValues(request, "csyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setCsyj(csyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
		redirect(request, response);
	}

	// 保存复核fh和sh
	public void saveFh(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] fhyjs = ParamUtil.getParameterValues(request, "fhyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setFhyj(fhyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
		redirect(request, response);
	}

	// 保存审核sh和sp
	public void saveSh(ActionRequest request, ActionResponse response) throws SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		List<ApplyMaterial> applyMaterials = ApplyMaterialLocalServiceUtil.findByPermitId(permitId, -1, -1);
		String[] shyjs = ParamUtil.getParameterValues(request, "shyj");
		int i = 0;
		for (ApplyMaterial applyMaterial : applyMaterials) {
			applyMaterial.setShyj(shyjs[i]);
			i++;
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
		redirect(request, response);
	}

	public void redirect(ActionRequest request, ActionResponse response) throws IOException {
		String redirect = ParamUtil.getString(request, "redirectURL");
		String permitId = ParamUtil.getString(request, "permitId");
		redirect += "&" + response.getNamespace() + "permitId=" + permitId;
		response.sendRedirect(redirect);
	}

	// 施工许可
	public void sgxk(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			IOException, DocumentException, com.lowagie.text.DocumentException {
		long permitId = ParamUtil.getLong(request, "permitId");
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(29087);
		String newPDFPath = "F://jtjs//" + xmlx + "施工许可证书.pdf";
		Map<String, String> map = getMap(permitId, xmlx);
		fillTemplate(request, response, fileEntry, newPDFPath, map);
	}

	// 施工许可(绿色)
	public void sgxkls(ActionRequest request, ActionResponse response) throws PortalException, SystemException,
			IOException, DocumentException, com.lowagie.text.DocumentException {
		long permitId = ParamUtil.getLong(request, "permitId");
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(29017);
		String newPDFPath = "F://jtjs//" + xmlx + "施工许可证书(绿色通道).pdf";
		Map<String, String> map = getMap(permitId, xmlx);
		fillTemplate(request, response, fileEntry, newPDFPath, map);
	}
	
	public void kgba(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException, DocumentException, com.lowagie.text.DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit =PermitLocalServiceUtil.getPermit(permitId);
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String babh = permit.getSgxkzbh();
		String xmmc = projectProfile.getGcmc();
		String jsdd = projectProfile.getJsdd();
		String tzly = "";
		String gkpzwh = "";
		String hzrq = "";
		String tzgs = projectProfile.getXmtzgs();
		String cbpzwh = "";
		String pfrq = "";
		String pfgq = "";
		String jsgm = projectProfile.getJsgcgm();
		String pzjghwh = "";
		String xmdw = "";
		String xmdwfzr = "";
		String xmdwfzrlxdh = "";
		String sjdw = "";
		String jldw = "";
		String sgdw = "";
		List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId, -1, -1);
		for (ParticipationUnit participationUnit : participationUnits) {
			if (participationUnit.getDwlx().equals("设计单位")) {
				sjdw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("监理单位")) {
				jldw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("施工单位")) {
				sgdw = participationUnit.getDwmc();
			}
		}
		String sjdwzbfs = "";
		String sjdwzbj = "";
		String sjdwzzdj = "";
		String sjdwzzdjzs = "";
		String sjdwxmfzr = "";
		String sjdwxmfzrzs = "";
		
		String jldwzbfs = "";
		String jldwzbj = "";
		String jldwzzdj = "";
		String jldwzzdjzs = "";
		String jldwzj = "";
		String jldwzjzs = "";
		
		String sgdwzbfs = "";
		String sgdwzbj = "";
		String sgdwzzdj = "";
		String sgdwzzdjzs = "";
		String sgdwxmjl = "";
		String sgdwxmjlzs = "";
		
		String jszjjh = "";
		String dcqwcqk = "";
		String sgzbqk = "";
		String xgwj = "";
		String gczljd = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String jhkgrq = sdf.format(projectProfile.getJhkg());
		String jhjgrq = sdf.format(projectProfile.getJhjg());
		String jhkg = jhkgrq.substring(0, 4) + "年" + jhkgrq.substring(4, 6) + "月" + jhkgrq.substring(6, 8) + "日";
		String jhwg = jhjgrq.substring(0, 4) + "年" + jhjgrq.substring(4, 6) + "月" + jhjgrq.substring(6, 8) + "日";
		map.put("babh", babh);
		map.put("xmmc", xmmc);
		map.put("jsdd", jsdd);
		map.put("tzly", tzly);
		map.put("gkpzwh", gkpzwh);
		map.put("hzrq", hzrq);
		map.put("tzgs", tzgs);
		map.put("cbpzwh", cbpzwh);
		map.put("pfrq", pfrq);
		map.put("pfgq", pfgq);
		map.put("jsgm", jsgm);
		map.put("pzjghwh", pzjghwh);
		map.put("xmdw", xmdw);
		map.put("xmdwfzr", xmdwfzr);
		map.put("xmdwfzrlxdh", xmdwfzrlxdh);
		map.put("sjdw", sjdw);
		map.put("sjdwzbfs", sjdwzbfs);
		map.put("sjdwzbj", sjdwzbj);
		map.put("sjdwzzdj", sjdwzzdj);
		map.put("sjdwzzdjzs", sjdwzzdjzs);
		map.put("sjdwxmfzr", sjdwxmfzr);
		map.put("sjdwxmfzrzs", sjdwxmfzrzs);
		map.put("jldw", jldw);
		map.put("jldwzbfs", jldwzbfs);
		map.put("jldwzbj", jldwzbj);
		map.put("jldwzzdj", jldwzzdj);
		map.put("jldwzzdjzs", jldwzzdjzs);
		map.put("jldwzj", jldwzj);
		map.put("jldwzjzs", jldwzjzs);
		map.put("sgdw", sgdw);
		map.put("sgdwzbfs", sgdwzbfs);
		map.put("sgdwzbj", sgdwzbj);
		map.put("sgdwzzdj", sgdwzzdj);
		map.put("sgdwzzdjzs", sgdwzzdjzs);
		map.put("sgdwxmjl", sgdwxmjl);
		map.put("sgdwxmjlzs", sgdwxmjlzs);
		map.put("jszjjh", jszjjh);
		map.put("dcqwcqk", dcqwcqk);
		map.put("sgzbqk", sgzbqk);
		map.put("xgwj", xgwj);
		map.put("gczljd", gczljd);
		map.put("jhkg", jhkg);
		map.put("jhwg", jhwg);

		
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(29302);
		String newPDFPath = "F://jtjs//航道工程开工备案表.pdf";
		fillTemplate(request, response, fileEntry, newPDFPath, map);
	}

	// 生成许可证pdf
	public void fillTemplate(ActionRequest request, ActionResponse response, DLFileEntry fileEntry, String newPDFPath,
			Map<String, String> map) throws IOException, DocumentException, PortalException, SystemException,
			com.lowagie.text.DocumentException {
		long permitId = ParamUtil.getLong(request, "permitId");
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();//
		PdfReader pdfReader = new PdfReader(fileEntry.getContentStream());
		File file = new File(newPDFPath);
		file.delete();
		FileOutputStream outputStream = new FileOutputStream(file);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfStamper pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
		AcroFields acroFields = pdfStamper.getAcroFields();
		Iterator<String> iterator = acroFields.getFields().keySet().iterator();
		while (iterator.hasNext()) {
			String data = iterator.next().toString();
			acroFields.setField(data, map.get(data));
		}
		pdfStamper.setFormFlattening(true);
		pdfStamper.close();
		Document document = new Document();
		PdfCopy pdfCopy = new PdfCopy(document, outputStream);
		document.open();
		for (int i=1;i<=pdfReader.getNumberOfPages();i++) {
			PdfImportedPage importedPage = pdfCopy.getImportedPage(new PdfReader(byteArrayOutputStream.toByteArray()), i);
			pdfCopy.addPage(importedPage);	
		}

		document.close();
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setIndexingEnabled(true);
		DLAppLocalServiceUtil.addFileEntry(20199, 20195, 28426, file.getName(), "application/pdf", permit.getSgxkzbh(),
				null, null, file, serviceContext);
	}

	//施工许可Excel
	public void sgxkExcel(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
		Map<String, String> map = getMap(permitId, xmlx);
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(29682);
		XLSTransformer transformer = new XLSTransformer();
        HSSFWorkbook hssfWorkbook = transformer.transformXLS(fileEntry.getContentStream(), map);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		hssfWorkbook.write(baos);
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		ServletResponseUtil.sendFile(req, res, "tst.xls", baos.toByteArray(),
				ContentTypes.APPLICATION_VND_MS_EXCEL);
	}
	//施工许可Excel绿色
	public void sgxklsExcel(ActionRequest request, ActionResponse response) throws PortalException, SystemException, IOException {
		long permitId = ParamUtil.getLong(request, "permitId");
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
		Map<String, String> map = getMap(permitId, xmlx);
		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(29668);
		XLSTransformer transformer = new XLSTransformer();
        HSSFWorkbook hssfWorkbook = transformer.transformXLS(fileEntry.getContentStream(), map);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		hssfWorkbook.write(baos);
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		ServletResponseUtil.sendFile(req, res, "tst.xls", baos.toByteArray(),
				ContentTypes.APPLICATION_VND_MS_EXCEL);
	}
	
	public Map<String, String> getMap(long permitId, String xmlx) throws PortalException, SystemException {
		Map<String, String> map = new HashMap<String, String>();
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		String title = "上海市(" + xmlx + ")工程施工许可证";
		String bh = permit.getSgxkzbh();
		String gj = "";
		if (xmlx.equals("港口")) {
			gj = "根据《中华人民共和国港口法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		} else if (xmlx.equals("公路")) {
			gj = "根据《中华人民共和国公路法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		} else {
			gj = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		}
		String jsdw = projectProfile.getJsdwmc();
		String gcmc = projectProfile.getGcmc();
		String gcwz = projectProfile.getJsdd();
		String gcnr = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工";
		String xmtzgs = projectProfile.getXmtzgs() + "(万元)";
		String htjg = projectProfile.getHtjg() + "(万元)";
		String sjdw = "";
		String sgdw = "";
		String jldw = "";

		List<ParticipationUnit> participationUnits = ParticipationUnitLocalServiceUtil.findByPermitId(permitId, -1, -1);
		for (ParticipationUnit participationUnit : participationUnits) {
			if (participationUnit.getDwlx().equals("设计单位")) {
				sjdw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("施工单位")) {
				sgdw = participationUnit.getDwmc();
			}
			if (participationUnit.getDwlx().equals("监理单位")) {
				jldw = participationUnit.getDwmc();
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String jhkg = sdf.format(projectProfile.getJhkg());
		String jhjg = sdf.format(projectProfile.getJhjg());
		String jhkgrq = jhkg.substring(0, 4) + "年" + jhkg.substring(4, 6) + "月" + jhkg.substring(6, 8) + "日";
		String jhjgrq = jhjg.substring(0, 4) + "年" + jhjg.substring(4, 6) + "月" + jhjg.substring(6, 8) + "日";
		String bz = "根据《中华人民共和国交通建设法》等相关法律规定，经审查，本工程符合施工条件，准予施工。";
		map.put("xmtzgs", xmtzgs);
		map.put("htjg", htjg);
		map.put("gcwz", gcwz);
		map.put("gcnr", gcnr);
		map.put("jsdw", jsdw);
		map.put("gcmc", gcmc);
		map.put("bh", bh);
		map.put("gj", gj);
		map.put("title", title);
		map.put("jhkgrq", jhkgrq);
		map.put("jhjgrq", jhjgrq);
		map.put("sgdw", sgdw);
		map.put("jldw", jldw);
		map.put("sjdw", sjdw);
		map.put("bz", bz);
		return map;
	}

	public void provideSgxkzbh(long permitId) throws PortalException, SystemException {
		String sgxkzbh = "JT";// JT
		Permit permit1 = PermitLocalServiceUtil.getPermit(permitId);
		sgxkzbh = sgxkzbh + permit1.getBjbh() + permit1.getBdh();// 报建编号+标段号
		Locale locale = LocaleUtil.getDefault();
		String currentDate = DateUtil.getCurrentDate("yyyy-MM-dd", locale);
		String currentDateStr = currentDate.substring(2, 4);
		sgxkzbh = sgxkzbh + currentDateStr;// 两位年份
		ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
		Dictionary xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx());
		sgxkzbh = sgxkzbh + xmlx.getCode();// 类别

		List<Permit> permits = PermitLocalServiceUtil.getPermits(-1, -1);
		int num = 1;
		for (Permit permit2 : permits) {
			String bjbh = permit2.getSgxkzbh().substring(2, 12);
			if (bjbh.equals(permit1.getBjbh())) {
				num++;
			}
		}
		if (num / 10 < 1) {
			sgxkzbh = sgxkzbh + "00" + num;
		} else if (num / 100 < 1) {
			sgxkzbh = sgxkzbh + "0" + num;
		} else if (num / 1000 < 1) {
			sgxkzbh = sgxkzbh + num;
		}
		permit1.setSgxkzbh(sgxkzbh);
		PermitLocalServiceUtil.updatePermit(permit1);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// TODO Auto-generated method stub

		try {
			String resourceId = resourceRequest.getResourceID();
			String fileSourceName = "";
			// 上传文件
			if ("fileBzclUpLoad".equals(resourceId)) {
				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);

				ServiceContext serviceContext;
				com.liferay.portal.kernel.json.JSONObject fileJson = JSONFactoryUtil.createJSONObject();
				serviceContext = ServiceContextFactory.getInstance(Permit.class.getName(), resourceRequest);
				FileEntry fileEntry = null;
				// 对应的是第几类材料的div
//				String divNo = ParamUtil.get(resourceRequest, "divNo", "");
				// 文件材料的名称编号
				String no = ParamUtil.get(resourceRequest, "no", "");
				String fileExtension = ParamUtil.get(resourceRequest, "fileBzclExtension", "");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				String portletId = ParamUtil.get(resourceRequest, "portletId", "");
				fileSourceName = uploadPortletRequest.getFileName("userfileBzcl");
				InputStream stream = uploadPortletRequest.getFileAsStream("userfileBzcl");

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
					ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil.getApplyMaterial(Long
							.valueOf(materialId));
					String fileTitle = applyMaterial.getClmc() + "补正材料-" + no + "." + fileExtension;

					fileEntry = uploadFile(resourceRequest, fileSourceName, fileBytes, serviceContext, portletId,
							materialId, fileTitle);

					String bzclIds = applyMaterial.getBzclIds();
					// 添加第一条数据时
					if (Validator.isNull(bzclIds)) {
						bzclIds = fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();
					}
					// 如果已有数据
					else {
						bzclIds = bzclIds + "," + fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();
						fileJson.put("fileBzclId", fileEntry.getFileEntryId());
					}
					applyMaterial.setBzclIds(bzclIds);
					ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
					fileJson.put("materialName", applyMaterial.getClmc());
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
			if ("fileBzclDelete".equals(resourceId)) {
				String fileId = ParamUtil.get(resourceRequest, "fileBzclId", "0");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				if (!fileId.equals("0")) {
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileId));
					if (!materialId.equals("0")) {
						ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil.getApplyMaterial(Long
								.valueOf(materialId));
						String bzclIds = applyMaterial.getBzclIds();
						bzclIds = bzclIds + ",";// 加上逗号为了容易替换
						// 获取文件路径
						String str = fileId + "\\|" + dlFileEntry.getExtension() + "\\,";
						bzclIds = bzclIds.replaceFirst(str, "");
						if (Validator.isNotNull(bzclIds)) {
							bzclIds = bzclIds.substring(0, bzclIds.length() - 1);// 最后一步再把逗号去掉
						}
						applyMaterial.setBzclIds(bzclIds);
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
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	public FileEntry uploadFile(ResourceRequest request, String fileSourceName, byte[] fileBytes,
			ServiceContext serviceContext, String portletId, String materialId, String fileTitle)
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
}
