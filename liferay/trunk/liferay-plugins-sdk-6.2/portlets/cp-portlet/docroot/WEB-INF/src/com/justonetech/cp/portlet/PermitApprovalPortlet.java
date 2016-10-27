package com.justonetech.cp.portlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jxls.transformer.XLSTransformer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.itextpdf.text.DocumentException;
import com.justonetech.core.utils.JspHelper;
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
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
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
		String path = ParamUtil.getString(renderRequest, "path");
		if (path.contains("uploadFile")) {
			String[] pathParam=path.split("\\/");
			String divNo=pathParam[0].substring(pathParam[0].length()-1);
			String materialId=pathParam[1];
			String no=pathParam[2];
			String uploadfileType=pathParam[3];
			renderRequest.setAttribute("divNo",divNo); 
			renderRequest.setAttribute("materialId", materialId);
			renderRequest.setAttribute("no", no);
			renderRequest.setAttribute("uploadfileType",uploadfileType);
			include("/portlet/permit-approval/view-permit/uploadFile.jsp", renderRequest, renderResponse);
		}
		else if (path.contains("uploadResult")) {
			renderRequest.setAttribute("name",ParamUtil.getString(renderRequest, "name"));
			renderRequest.setAttribute("upLoadMessage",ParamUtil.getString(renderRequest, "upLoadMessage"));
			renderRequest.setAttribute("fieId",ParamUtil.getString(renderRequest, "fieId"));
			renderRequest.setAttribute("divNo",ParamUtil.getString(renderRequest, "divNo"));
			renderRequest.setAttribute("no",ParamUtil.getString(renderRequest, "no"));
			renderRequest.setAttribute("materialId",ParamUtil.getString(renderRequest, "materialId"));
			renderRequest.setAttribute("materialName",ParamUtil.getString(renderRequest, "materialName"));
			renderRequest.setAttribute("fileExtension",ParamUtil.getString(renderRequest, "fileExtension"));
			renderRequest.setAttribute("uploadfileType",ParamUtil.getString(renderRequest, "uploadfileType"));
			include("/portlet/permit-approval/view-permit/uploadResult.jsp", renderRequest, renderResponse);
		}
		else {
		super.doView(renderRequest, renderResponse);}
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

		// 保存附件信息
		long[] materialIds = ParamUtil.getLongValues(request, "materialId");
		String[] shfses = ParamUtil.getParameterValues(request, "sjfs");
		for (int j = 0; j < materialIds.length; j++) {
			ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil.getApplyMaterial(materialIds[j]);
			applyMaterial.setSjfs(JspHelper.getInteger(shfses[j]));
			ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial);
		}
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

	// 生成许可证pdf
		public FileEntry fillTemplate( DLFileEntry fileEntry, String newPDFPath,
				Map<String, String> map,ResourceRequest request, ResourceResponse response,Permit permit) throws IOException, DocumentException, PortalException, SystemException,
				com.lowagie.text.DocumentException {
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
			long userId = PortalUtil.getUserId(request);
			long repositoryId = Long.valueOf(PropsUtil.get("global.group.id"));
			long folderId = Long.valueOf(PropsUtil.get("sgxkz.pdf.folder.id"));
			return DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, file.getName(), "application/pdf",permit.getSgxkzbh(),
					null, null, file, serviceContext);
		}

		public Map<String, String> getMap(long permitId, String xmlx) throws PortalException, SystemException {
			Map<String, String> map = new HashMap<String, String>();
			Permit permit = PermitLocalServiceUtil.getPermit(permitId);
			ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			String title = "上海市(" + xmlx + ")工程施工许可证";
			String bh = "";
			if(Validator.isNotNull(permit.getSgxkzbh())){
				bh = permit.getSgxkzbh();
			}
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
			String gcnr = projectProfile.getGcnr();
			String xmtzgs = projectProfile.getXmtzgs() + "万元";
			String htjg = projectProfile.getHtjg() + "万元";
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
			String bz = "";
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

		public Map<String, String> getKgbaMap(long permitId) throws PortalException, SystemException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Map<String, String> map = new HashMap<String, String>();
			Permit permit =PermitLocalServiceUtil.getPermit(permitId);
			ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
			String babh = "";
			if(Validator.isNotNull(permit.getSgxkzbh())){
				babh = permit.getSgxkzbh();
			}
			String xmmc = projectProfile.getGcmc();
			String jsdd = projectProfile.getJsdd();
			String tzly = projectProfile.getTzly();
			String gkpzwh = projectProfile.getGkpzhhzjghwh();
			Date pfhhzrqDate = projectProfile.getPfhhzrq();
			String pfhhzrq = sdf.format(pfhhzrqDate);
			String hzrq = pfhhzrq.substring(0, 4) + "年" + pfhhzrq.substring(4, 6) + "月" + pfhhzrq.substring(6, 8) + "日";
			String tzgs = projectProfile.getXmtzgs();
			String cbpzwh = projectProfile.getCbsjpzjghwh();
			Date pfrqDate = projectProfile.getPfrq();
			String pfrqStr = sdf.format(pfrqDate);
			String pfrq = pfrqStr.substring(0, 4) + "年" + pfrqStr.substring(4, 6) + "月" + pfrqStr.substring(6, 8) + "日";
			String pfgq = projectProfile.getPfgq()+"天";
			String jsgm = projectProfile.getJsgcgm()+"。"+projectProfile.getGcnr();
			String pzjghwh = projectProfile.getPzjghwh();
			String xmdw = projectProfile.getXmdw();
			String xmdwfzr = projectProfile.getXmfzr();
			String xmdwfzrlxdh = projectProfile.getXmfzrlxdh();
			String sjdw = projectProfile.getZyjldw();
			String sjdwzbfs = projectProfile.getSj_zbfs();
			String sjdwzbj = projectProfile.getSj_zbj();
			String sjdwzzdj = projectProfile.getSj_zzdj();
			String sjdwzzdjzs = projectProfile.getSj_zzdjzsbh();
			String sjdwxmfzr = projectProfile.getSj_xmfzr();
			String sjdwxmfzrzs = projectProfile.getSj_xmfzrzsbh();
			
			String jldw = projectProfile.getZyjldw();
			String jldwzbfs = projectProfile.getJl_zbfs();
			String jldwzbj = projectProfile.getJl_zbj();
			String jldwzzdj = projectProfile.getJl_zzdj();
			String jldwzzdjzs = projectProfile.getJl_zzdjzsbh();
			String jldwzj = projectProfile .getJl_zj();
			String jldwzjzs = projectProfile.getJl_zjzsbh();
			
			String sgdw = projectProfile.getZysgdw();
			String sgdwzbfs = projectProfile.getSg_zbfs();
			String sgdwzbj = projectProfile.getSg_zbj();
			String sgdwzzdj = projectProfile.getSg_zzdj();
			String sgdwzzdjzs = projectProfile.getSg_zzdjzsbh();
			String sgdwxmjl = projectProfile.getSg_xmjl();
			String sgdwxmjlzs = projectProfile.getSg_xmjlzsbh();  	
			
			String jszjjh = projectProfile.getJszjjhlsqk();
			String dcqwcqk = projectProfile.getDcqwcqk();
			String sgzbqk = projectProfile.getSgzbqk();
			String xgwj = projectProfile.getSytdxgwj();
			String gczljd = projectProfile.getGczljddjqk();
			
			
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

	public String getDownLoadURL(ResourceRequest request,ResourceResponse response, long permitId,long fileEntryId,String newPDFPath,Map<String,String> map) throws PortalException, SystemException, IOException, DocumentException, com.lowagie.text.DocumentException {
		String downloadURL = "";
		Permit permit = PermitLocalServiceUtil.getPermit(permitId);
		if(permit.getSgxkzFileEntryId()==0){
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
			FileEntry file = fillTemplate(fileEntry, newPDFPath, map,request,response,permit);
			permit.setSgxkzFileEntryId(file.getFileEntryId());
			PermitLocalServiceUtil.updatePermit(permit);
			downloadURL = "/documents/" + file.getGroupId()+"/"+file.getFolderId()+"/"+file.getTitle()+"?&download=true";
		}else{
			DLFileEntry dlFileEntry =DLFileEntryLocalServiceUtil.getDLFileEntry(permit.getSgxkzFileEntryId());
			downloadURL = "/documents/" + dlFileEntry.getGroupId()+"/"+dlFileEntry.getFolderId()+"/"+dlFileEntry.getTitle()+"?&download=true";
		}
		return downloadURL;
	}
	
	public void generatePDF(DLFileEntry fileEntry, String newPDFPath, Map<String, String> map,
			ResourceRequest request, ResourceResponse response, Permit permit) throws IOException, DocumentException,
			PortalException, SystemException, com.lowagie.text.DocumentException {
		PdfReader pdfReader = new PdfReader(fileEntry.getContentStream());
		File file = new File(newPDFPath);
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
		for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
			PdfImportedPage importedPage = pdfCopy.getImportedPage(new PdfReader(byteArrayOutputStream.toByteArray()),
					i);
			pdfCopy.addPage(importedPage);
		}
		document.close();
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
			String uploadfileType=ParamUtil.getString(actionRequest, "uploadfileType");
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
	        }else if(fileExtension.equals("JPG")){
	        	if(fileSize>2){	
	        		upLoadMessage="上传的jpg文件超过2M,请压缩后上传！";
	        		upLoadStatus=false;
	        	}
	        }else if(fileExtension.equals("PDF")){
	        	if(fileSize>20){	
	        		upLoadMessage="上传的pdf文件超过20M,请压缩或拆分后上传！";
	        		upLoadStatus=false;
	        	}
	        }
			if (!materialId.equals("0")&upLoadStatus) {
				ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil.getApplyMaterial(Long
					.valueOf(materialId));
				String fileEntryIds="";
				
				System.out.println(uploadfileType);
				
				if(uploadfileType.equals("jgzxFile")){
					 fileTitle = applyMaterial.getClmc() +"补正材料(建管中心)"+ "-" + ParamUtil.getString(actionRequest, "no") + "." + fileExtension.toLowerCase();
					 fileEntryIds = applyMaterial.getBzclIds();
				}else if(uploadfileType.equals("wjscFile")){
					 fileTitle = applyMaterial.getClmc() +"补正材料(委建设处)"+ "-" + ParamUtil.getString(actionRequest, "no") + "." + fileExtension.toLowerCase();
					 fileEntryIds = applyMaterial.getWjscbzclIds();
				}
	
				 fileEntry=uploadFile(actionRequest, sourceFileName, fileBytes, serviceContext, "permitapplication_WAR_cpportlet", materialId, fileTitle);	
				// 添加第一条数据时
				 if (Validator.isNull(fileEntryIds)) {
						fileEntryIds = fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();
					}
					// 如果已有数据
					else {
						fileEntryIds = fileEntryIds + "," + fileEntry.getFileEntryId() + "|" + fileEntry.getExtension();						
					}
				 if(uploadfileType.equals("jgzxFile")){
					 applyMaterial.setBzclIds(fileEntryIds);
					 actionResponse.setRenderParameter("materialName", applyMaterial.getClmc()+"补正材料(建管中心)");
				}else if(uploadfileType.equals("wjscFile")){
					applyMaterial.setWjscbzclIds(fileEntryIds);
					actionResponse.setRenderParameter("materialName", applyMaterial.getClmc()+"补正材料(委建设处)");
				}
				ApplyMaterialLocalServiceUtil.updateApplyMaterial(applyMaterial); 
				actionResponse.setRenderParameter("materialId", materialId);
				actionResponse.setRenderParameter("fieId", Long.toString(fileEntry.getFileEntryId()));
				actionResponse.setRenderParameter("name", sourceFileName);
				actionResponse.setRenderParameter("divNo", ParamUtil.getString(actionRequest, "divNo"));
				actionResponse.setRenderParameter("no", ParamUtil.getString(actionRequest, "no"));
				actionResponse.setRenderParameter("fileExtension", fileExtension.toLowerCase());
			}
			actionResponse.setRenderParameter("uploadfileType", uploadfileType);
			actionResponse.setRenderParameter("path", "uploadResult");
			actionResponse.setRenderParameter("upLoadMessage", upLoadMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
			PortletException {

		try {
			String resourceId = resourceRequest.getResourceID();
			String fileSourceName = "";
			//预览证书
			if(resourceId.equals("view")){
				long permitId = ParamUtil.getLong(resourceRequest, "permitId");
				Permit permit = PermitLocalServiceUtil.getPermit(permitId);
				ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
				String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
				Map<String, String> map = null;
				String newPDFPath = "";
				if (xmlx.equals("航道")) {
					newPDFPath = PropsUtil.get("sgxkz.temp.folder.id") + "航道开工备案.pdf";
				} else {
					newPDFPath = PropsUtil.get("sgxkz.temp.folder.id") + "施工许可证书.pdf";
				}
				if (xmlx.equals("航道")) {
					map = getKgbaMap(permitId);
					generatePDF(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil
							.get("sgxkz.hd.pdf.template.id"))), newPDFPath, map, resourceRequest, resourceResponse, permit);
				} else {
					map = getMap(permitId, xmlx);
					if (projectProfile.getXmxz() == 29769) {
						generatePDF(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil
								.get("sgxkz.pdf.template.id"))), newPDFPath, map, resourceRequest, resourceResponse,
								permit);
					} else {
						generatePDF(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil
								.get("sgxkz.ls.pdf.template.id"))), newPDFPath, map, resourceRequest, resourceResponse,
								permit);
					}
				}

				HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
				HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
				File file = null;
				if (xmlx.equals("航道")) {
					file = new File("D:\\temp\\航道开工备案.pdf");
				} else {
					file = new File("D:\\temp\\施工许可证书.pdf");
				}
				byte[] bytes = FileUtil.getBytes(file);
				if (xmlx.equals("航道")) {
					ServletResponseUtil.sendFile(request, response, "航道开工备案.pdf", bytes, ContentTypes.APPLICATION_PDF);
				}else{
					ServletResponseUtil.sendFile(request, response, "施工许可证书.pdf", bytes, ContentTypes.APPLICATION_PDF);
				}
			}
			//生成开工备案pdf
			if(resourceId.equals("printkgbaPdf")){
				long permitId = ParamUtil.getLong(resourceRequest, "permitId");
				Permit permit = PermitLocalServiceUtil.getPermit(permitId);
				String newPDFPath = PropsUtil.get("sgxkz.temp.folder.id")+permit.getSgxkzbh()+".pdf";
				Map<String, String> map = getKgbaMap(permitId);
				String downloadURL = getDownLoadURL(resourceRequest,resourceResponse,permitId,Long.valueOf(PropsUtil.get("sgxkz.hd.pdf.template.id")),newPDFPath,map);
				 PrintWriter out = resourceResponse.getWriter();
				 out.println(downloadURL);
				 out.flush();
				 out.close();
			}
			//生成施工许可pdf
			if(resourceId.equals("printsgxkPdf")){
				long permitId = ParamUtil.getLong(resourceRequest, "permitId");
				ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
				String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
				Permit permit = PermitLocalServiceUtil.getPermit(permitId);
				String newPDFPath = PropsUtil.get("sgxkz.temp.folder.id")+permit.getSgxkzbh()+".pdf";
				Map<String, String> map = getMap(permitId, xmlx);
				String downloadURL =getDownLoadURL(resourceRequest,resourceResponse,permitId, Long.valueOf(PropsUtil.get("sgxkz.pdf.template.id")),newPDFPath,map);
				 PrintWriter out = resourceResponse.getWriter();
				 out.println(downloadURL);
				 out.flush();
				 out.close();
			}
			//生成施工许可绿色pdf
			if(resourceId.equals("printsgxklsPdf")){
				long permitId = ParamUtil.getLong(resourceRequest, "permitId");
				ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
				String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
				Permit permit = PermitLocalServiceUtil.getPermit(permitId);
				String newPDFPath = PropsUtil.get("sgxkz.temp.folder.id")+permit.getSgxkzbh()+".pdf";
				Map<String, String> map = getMap(permitId, xmlx);
				String downloadURL =getDownLoadURL(resourceRequest,resourceResponse,permitId, Long.valueOf(PropsUtil.get("sgxkz.ls.pdf.template.id")),newPDFPath,map);
				PrintWriter out = resourceResponse.getWriter();
				 out.println(downloadURL);
				 out.flush();
				 out.close();
			}
			//生成开工备案excel
			if(resourceId.equals("printkgbaExcel")){
				long permitId = ParamUtil.getLong(resourceRequest, "permitId");
				Permit permit = PermitLocalServiceUtil.getPermit(permitId);
				String fileName = permit.getSgxkzbh()+".xls";
				Map<String, String> map = getKgbaMap(permitId);
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil.get("sgxkz.hd.xls.template.id")));
				XLSTransformer transformer = new XLSTransformer();
		        HSSFWorkbook hssfWorkbook = transformer.transformXLS(fileEntry.getContentStream(), map);
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
				hssfWorkbook.write(baos);
				HttpServletRequest req = PortalUtil.getHttpServletRequest(resourceRequest);
				HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
				ServletResponseUtil.sendFile(req, res, fileName, baos.toByteArray(),
						ContentTypes.APPLICATION_VND_MS_EXCEL);
			}
			//生成施工许可excel
			if(resourceId.equals("ptintsgxkExcel")){
				long permitId = ParamUtil.getLong(resourceRequest, "permitId");
				Permit permit = PermitLocalServiceUtil.getPermit(permitId);
				String fileName = permit.getSgxkzbh()+".xls";
				ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
				String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
				Map<String, String> map = getMap(permitId, xmlx);
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil.get("sgxkz.xls.template.id")) );
				XLSTransformer transformer = new XLSTransformer();
		        HSSFWorkbook hssfWorkbook = transformer.transformXLS(fileEntry.getContentStream(), map);
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
				hssfWorkbook.write(baos);
				HttpServletRequest req = PortalUtil.getHttpServletRequest(resourceRequest);
				HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
				ServletResponseUtil.sendFile(req, res, fileName, baos.toByteArray(),
						ContentTypes.APPLICATION_VND_MS_EXCEL);
			}
			//生成施工许可绿色excel
			if(resourceId.equals("printsgxklsExcel")){
				long permitId = ParamUtil.getLong(resourceRequest, "permitId");
				Permit permit = PermitLocalServiceUtil.getPermit(permitId);
				String fileName = permit.getSgxkzbh()+".xls";
				ProjectProfile projectProfile = ProjectProfileLocalServiceUtil.getProjectProfile(permitId);
				String xmlx = DictionaryLocalServiceUtil.getDictionary(projectProfile.getXmlx()).getName();
				Map<String, String> map = getMap(permitId, xmlx);
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(PropsUtil.get("sgxkz.ls.xls.template.id")));
				XLSTransformer transformer = new XLSTransformer();
		        HSSFWorkbook hssfWorkbook = transformer.transformXLS(fileEntry.getContentStream(), map);
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
				hssfWorkbook.write(baos);
				HttpServletRequest req = PortalUtil.getHttpServletRequest(resourceRequest);
				HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
				ServletResponseUtil.sendFile(req, res, fileName, baos.toByteArray(),
						ContentTypes.APPLICATION_VND_MS_EXCEL);
			}
			

			// 删除建管中心补正材料文件
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
			
			//删除委建设处材料文件
			if ("fileWjscbzclDelete".equals(resourceId)) {
				String fileId = ParamUtil.get(resourceRequest, "fileWjscbzclId", "0");
				String materialId = ParamUtil.get(resourceRequest, "materialId", "0");
				if (!fileId.equals("0")) {
					DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(fileId));
					if (!materialId.equals("0")) {
						ApplyMaterial applyMaterial = ApplyMaterialLocalServiceUtil.getApplyMaterial(Long
								.valueOf(materialId));
						String wjscbzclIds = applyMaterial.getWjscbzclIds();
						wjscbzclIds = wjscbzclIds + ",";// 加上逗号为了容易替换
						// 获取文件路径
						String str = fileId + "\\|" + dlFileEntry.getExtension() + "\\,";
						wjscbzclIds = wjscbzclIds.replaceFirst(str, "");
						if (Validator.isNotNull(wjscbzclIds)) {
							wjscbzclIds = wjscbzclIds.substring(0, wjscbzclIds.length() - 1);// 最后一步再把逗号去掉
						}
						applyMaterial.setWjscbzclIds(wjscbzclIds);
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
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.lowagie.text.DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.serveResource(resourceRequest, resourceResponse);
	}

	public FileEntry uploadFile(ActionRequest request, String fileSourceName, byte[] fileBytes,
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
	public void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException,
	PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
		} else {
	portletRequestDispatcher.include(renderRequest, renderResponse);
		}
}
	
	
	
	
}
